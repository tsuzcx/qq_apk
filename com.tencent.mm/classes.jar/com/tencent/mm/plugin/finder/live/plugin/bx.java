package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.sidebar.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "canClearScreen", "", "canClearScreenWhenSideBarShow", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "onClearForSideBar", "", "clear", "playEnterAnim", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bx
  extends b
{
  public static final bx.a DiW;
  private static final double DiX;
  private static final double DiY;
  private final String TAG;
  private final com.tencent.mm.live.b.b ngl;
  private final View njL;
  private final View njM;
  
  static
  {
    AppMethodBeat.i(354137);
    DiW = new bx.a((byte)0);
    DiX = 0.463D;
    DiY = 0.232D;
    AppMethodBeat.o(354137);
  }
  
  public bx(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354124);
    this.ngl = paramb;
    this.TAG = "FinderLiveShadowPlugin";
    this.njL = paramViewGroup.findViewById(b.e.live_shadow_down);
    this.njM = paramViewGroup.findViewById(b.e.live_shadow_up);
    if (!isLandscape())
    {
      paramb = this.njL.getLayoutParams();
      paramb.height += bf.bk(paramViewGroup.getContext());
      AppMethodBeat.o(354124);
      return;
    }
    int i = bf.bf(paramViewGroup.getContext()).y;
    this.njL.getLayoutParams().height = ((int)(i * DiX));
    this.njM.getLayoutParams().height = ((int)(i * DiY));
    Log.i(this.TAG, "screenHeight:" + i + ",shadowDown.height:" + this.njL.getLayoutParams().height + ",shadowUp.height:" + this.njM.getLayoutParams().height);
    AppMethodBeat.o(354124);
  }
  
  private static final void a(bx parambx)
  {
    AppMethodBeat.i(354132);
    s.u(parambx, "this$0");
    parambx.njL.animate().alpha(1.0F).setDuration(500L).start();
    parambx.njM.animate().alpha(1.0F).setDuration(500L).start();
    AppMethodBeat.o(354132);
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void erT()
  {
    AppMethodBeat.i(354153);
    this.njL.setAlpha(0.0F);
    this.njM.setAlpha(0.0F);
    tO(0);
    this.mJe.post(new bx..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(354153);
  }
  
  public final void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(354170);
    super.qU(paramBoolean);
    tO(this.CTl);
    AppMethodBeat.o(354170);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354190);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354190);
      return;
      tO(4);
      AppMethodBeat.o(354190);
      return;
      if (this.ngl.getLiveRole() != 1)
      {
        tO(4);
        AppMethodBeat.o(354190);
        return;
        tO(0);
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354180);
    this.CTl = paramInt;
    Object localObject = k.aeZF;
    localObject = this.mJe.getContext();
    s.s(localObject, "root.context");
    if (((d)k.nq((Context)localObject).q(d.class)).DGD) {
      paramInt = 0;
    }
    for (;;)
    {
      this.mJe.setVisibility(paramInt);
      if (paramInt == 0) {
        this.mJe.setAlpha(1.0F);
      }
      AppMethodBeat.o(354180);
      return;
      if (this.CTm == 8) {
        paramInt = 8;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bx
 * JD-Core Version:    0.7.0.1
 */