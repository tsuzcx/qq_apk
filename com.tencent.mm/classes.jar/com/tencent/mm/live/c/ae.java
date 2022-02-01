package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.g;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "forceSetVisible", "", "visible", "", "hideProgress", "setVisible", "showBlurBg", "username", "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ae
  extends a
{
  private static final long gVF = 300L;
  public static final ae.a gVG;
  private final b gSM;
  private final RelativeLayout gVD;
  private final TextView gVE;
  private final ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(212508);
    gVG = new ae.a((byte)0);
    gVF = 300L;
    AppMethodBeat.o(212508);
  }
  
  public ae(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212507);
    this.gSM = paramb;
    this.gVD = ((RelativeLayout)paramViewGroup.findViewById(2131307651));
    this.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131307650));
    this.gVE = ((TextView)paramViewGroup.findViewById(2131307884));
    AppMethodBeat.o(212507);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(212506);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (af.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212506);
      return;
      nI(8);
      AppMethodBeat.o(212506);
      return;
      paramc = this.progressBar;
      p.g(paramc, "progressBar");
      paramc.setVisibility(8);
      AppMethodBeat.o(212506);
      return;
      paramc = this.progressBar;
      p.g(paramc, "progressBar");
      paramc.setVisibility(0);
      paramc = this.gVD;
      p.g(paramc, "blurView");
      paramc.setVisibility(8);
      paramc = this.gVE;
      p.g(paramc, "networkErrTip");
      paramc.setVisibility(8);
      this.gGK.setVisibility(0);
    }
  }
  
  public final void at(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(212504);
    p.h(paramString2, "tip");
    Object localObject = this.gVD;
    p.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = this.progressBar;
      p.g(paramString1, "progressBar");
      paramString1.setVisibility(8);
      paramString1 = this.gVE;
      p.g(paramString1, "networkErrTip");
      paramString1.setVisibility(0);
      paramString1 = this.gVE;
      p.g(paramString1, "networkErrTip");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(212504);
      return;
    }
    paramString1 = com.tencent.mm.live.b.d.a.gRe;
    paramString1 = g.gOr;
    paramString1 = g.anu();
    localObject = this.gGK.getContext();
    p.g(localObject, "root.context");
    a.a.a(paramString1, ((Context)localObject).getResources().getColor(2131101201), (d.g.a.b)new d(this, paramString2));
    this.gGK.setVisibility(0);
    AppMethodBeat.o(212504);
  }
  
  public final void nI(final int paramInt)
  {
    AppMethodBeat.i(212505);
    if (this.gGK.getVisibility() == paramInt)
    {
      AppMethodBeat.o(212505);
      return;
    }
    if (paramInt == 0)
    {
      this.gGK.setVisibility(paramInt);
      AppMethodBeat.o(212505);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.gGK.getContext(), 2130772048);
    p.g(localAnimation, "animation");
    localAnimation.setDuration(gVF);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
    this.gGK.startAnimation(localAnimation);
    this.gGK.invalidate();
    AppMethodBeat.o(212505);
  }
  
  public final void xT(String paramString)
  {
    AppMethodBeat.i(212503);
    Object localObject = this.gVD;
    p.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bt.isNullOrNil(paramString))
    {
      paramString = this.progressBar;
      p.g(paramString, "progressBar");
      paramString.setVisibility(0);
      paramString = this.gVE;
      p.g(paramString, "networkErrTip");
      paramString.setVisibility(8);
      AppMethodBeat.o(212503);
      return;
    }
    paramString = com.tencent.mm.live.b.d.a.gRe;
    paramString = g.gOr;
    paramString = g.anu();
    localObject = this.gGK.getContext();
    p.g(localObject, "root.context");
    a.a.a(paramString, ((Context)localObject).getResources().getColor(2131101201), (d.g.a.b)new c(this));
    this.gGK.setVisibility(0);
    AppMethodBeat.o(212503);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(212500);
      this.gVH.gGK.setVisibility(paramInt);
      AppMethodBeat.o(212500);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<Bitmap, z>
  {
    c(ae paramae)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Bitmap, z>
  {
    d(ae paramae, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ae
 * JD-Core Version:    0.7.0.1
 */