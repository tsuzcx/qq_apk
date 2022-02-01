package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "videoOrientationBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getVideoOrientationBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "canClearScreen", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "setLayoutOrientation", "isFitRenderMode", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class cu
  extends d
{
  public static final a yyA;
  private static final String yyy = "PORTRAIT_ACTION_CHANGE_VIDEO";
  private static final String yyz = "LANDSCAPE_ACTION_CHANGE_VIDEO";
  private final String TAG;
  private final com.tencent.mm.live.c.b kCU;
  private final WeImageView yyx;
  
  static
  {
    AppMethodBeat.i(275600);
    yyA = new a((byte)0);
    yyy = "PORTRAIT_ACTION_CHANGE_VIDEO";
    yyz = "LANDSCAPE_ACTION_CHANGE_VIDEO";
    AppMethodBeat.o(275600);
  }
  
  public cu(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(275599);
    this.kCU = paramb;
    this.TAG = "Finder.LiveVideoOrientationPlugin";
    this.yyx = ((WeImageView)paramViewGroup.findViewById(b.f.video_orientation_btn));
    paramViewGroup.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(282674);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = paramViewGroup.getContext();
        p.j(paramAnonymousView, "root.context");
        paramAnonymousView = paramAnonymousView.getResources();
        p.j(paramAnonymousView, "root.context.resources");
        if (paramAnonymousView.getConfiguration().orientation == 1)
        {
          paramAnonymousView = this.yyB;
          localObject = cu.yyA;
          d.b(paramAnonymousView, cu.dCP());
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(282674);
          return;
          paramAnonymousView = this.yyB;
          localObject = cu.yyA;
          d.a(paramAnonymousView, cu.dCO());
        }
      }
    });
    paramViewGroup.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288206);
        Object localObject1 = new Rect();
        this.kCW.getHitRect((Rect)localObject1);
        Object localObject2 = MMApplicationContext.getContext();
        p.j(localObject2, "MMApplicationContext.getContext()");
        int i = ((Context)localObject2).getResources().getDimensionPixelOffset(b.d.Edge_A);
        ((Rect)localObject1).inset(-i, -i);
        localObject2 = this.kCW.getParent();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(288206);
          throw ((Throwable)localObject1);
        }
        ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.kCW));
        AppMethodBeat.o(288206);
      }
    });
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.a((d)this);
    AppMethodBeat.o(275599);
  }
  
  public final void cN()
  {
    AppMethodBeat.i(275598);
    if (ar.hIH()) {
      tU(8);
    }
    AppMethodBeat.o(275598);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void po(boolean paramBoolean)
  {
    AppMethodBeat.i(275595);
    Object localObject = this.kiF.getContext();
    p.j(localObject, "root.context");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "root.context.resources");
    int i = ((Resources)localObject).getConfiguration().orientation;
    Log.i(this.TAG, "setLayoutOrientation isFitRenderMode:" + paramBoolean + ",orientaion:" + i);
    if (!paramBoolean)
    {
      tU(8);
      AppMethodBeat.o(275595);
      return;
    }
    if (ar.hIH())
    {
      tU(8);
      AppMethodBeat.o(275595);
      return;
    }
    switch (i)
    {
    default: 
      tU(8);
      AppMethodBeat.o(275595);
      return;
    case 2: 
      this.yyx.setImageResource(b.i.icons_outlined_htov);
      localObject = this.yyx;
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(com.tencent.mm.plugin.finder.b.c.White));
      tU(0);
      m.yCt.a(Integer.valueOf(0), 2, s.ay.yKA);
      AppMethodBeat.o(275595);
      return;
    }
    this.yyx.setImageResource(b.i.icons_outlined_vtoh);
    localObject = this.yyx;
    Context localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(com.tencent.mm.plugin.finder.b.c.White));
    tU(0);
    m.yCt.a(Integer.valueOf(0), 1, s.ay.yKA);
    AppMethodBeat.o(275595);
  }
  
  public final void statusChange(com.tencent.mm.live.c.b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(275597);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (cv.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(275597);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$Companion;", "", "()V", "LANDSCAPE_ACTION_CHANGE_VIDEO", "", "getLANDSCAPE_ACTION_CHANGE_VIDEO", "()Ljava/lang/String;", "PORTRAIT_ACTION_CHANGE_VIDEO", "getPORTRAIT_ACTION_CHANGE_VIDEO", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cu
 * JD-Core Version:    0.7.0.1
 */