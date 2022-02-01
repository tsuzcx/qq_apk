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
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.report.live.s.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "videoOrientationBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getVideoOrientationBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "canClearScreen", "", "setLayoutOrientation", "", "isFitRenderMode", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class bm
  extends d
{
  private static final String uuK = "PORTRAIT_ACTION_CHANGE_VIDEO";
  private static final String uuL = "LANDSCAPE_ACTION_CHANGE_VIDEO";
  public static final a uuM;
  private final String TAG;
  private final com.tencent.mm.live.c.b hOy;
  private final WeImageView uuJ;
  
  static
  {
    AppMethodBeat.i(247112);
    uuM = new a((byte)0);
    uuK = "PORTRAIT_ACTION_CHANGE_VIDEO";
    uuL = "LANDSCAPE_ACTION_CHANGE_VIDEO";
    AppMethodBeat.o(247112);
  }
  
  public bm(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247111);
    this.hOy = paramb;
    this.TAG = "Finder.LiveVideoOrientationPlugin";
    this.uuJ = ((WeImageView)paramViewGroup.findViewById(2131309790));
    paramViewGroup.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247106);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = paramViewGroup.getContext();
        p.g(paramAnonymousView, "root.context");
        paramAnonymousView = paramAnonymousView.getResources();
        p.g(paramAnonymousView, "root.context.resources");
        if (paramAnonymousView.getConfiguration().orientation == 1)
        {
          localObject = this.uuN;
          paramAnonymousView = bm.uuM;
          paramAnonymousView = bm.dhV();
          p.h(paramAnonymousView, "action");
          localObject = ((d)localObject).umc;
          if (localObject != null)
          {
            b.c localc = b.c.hNu;
            Bundle localBundle = new Bundle();
            localBundle.putString("POST_LANDSCAPE_ACTION", paramAnonymousView);
            ((com.tencent.mm.live.c.b)localObject).statusChange(localc, localBundle);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247106);
          return;
          paramAnonymousView = this.uuN;
          localObject = bm.uuM;
          d.a(paramAnonymousView, bm.dhU());
        }
      }
    });
    paramViewGroup.post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(247107);
        Object localObject1 = new Rect();
        this.hOA.getHitRect((Rect)localObject1);
        Object localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        int i = ((Context)localObject2).getResources().getDimensionPixelOffset(2131165314);
        ((Rect)localObject1).inset(-i, -i);
        localObject2 = this.hOA.getParent();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(247107);
          throw ((Throwable)localObject1);
        }
        ((View)localObject2).setTouchDelegate(new TouchDelegate((Rect)localObject1, (View)this.hOA));
        AppMethodBeat.o(247107);
      }
    });
    paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
    com.tencent.mm.plugin.finder.utils.m.a((d)this);
    AppMethodBeat.o(247111);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void nx(boolean paramBoolean)
  {
    AppMethodBeat.i(247109);
    Object localObject = this.hwr.getContext();
    p.g(localObject, "root.context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "root.context.resources");
    int i = ((Resources)localObject).getConfiguration().orientation;
    Log.i(this.TAG, "setLayoutOrientation isFitRenderMode:" + paramBoolean + ",orientaion:" + i);
    if (!paramBoolean)
    {
      rg(8);
      AppMethodBeat.o(247109);
      return;
    }
    switch (i)
    {
    default: 
      rg(8);
      AppMethodBeat.o(247109);
      return;
    case 2: 
      this.uuJ.setImageResource(2131690816);
      localObject = this.uuJ;
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099844));
      rg(0);
      localObject = com.tencent.mm.plugin.finder.report.live.m.vli;
      com.tencent.mm.plugin.finder.report.live.m.a(Integer.valueOf(0), 2, s.al.vqO);
      AppMethodBeat.o(247109);
      return;
    }
    this.uuJ.setImageResource(2131690934);
    localObject = this.uuJ;
    Context localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099844));
    rg(0);
    localObject = com.tencent.mm.plugin.finder.report.live.m.vli;
    com.tencent.mm.plugin.finder.report.live.m.a(Integer.valueOf(0), 1, s.al.vqO);
    AppMethodBeat.o(247109);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247110);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bn.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247110);
      return;
      paramc = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVideoOrientationPlugin$Companion;", "", "()V", "LANDSCAPE_ACTION_CHANGE_VIDEO", "", "getLANDSCAPE_ACTION_CHANGE_VIDEO", "()Ljava/lang/String;", "PORTRAIT_ACTION_CHANGE_VIDEO", "getPORTRAIT_ACTION_CHANGE_VIDEO", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bm
 * JD-Core Version:    0.7.0.1
 */