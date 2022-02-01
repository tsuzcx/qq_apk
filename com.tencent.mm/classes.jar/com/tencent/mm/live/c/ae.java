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
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "forceSetVisible", "", "visible", "", "hideProgress", "setVisible", "showBlurBg", "username", "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ae
  extends a
{
  private static final long gBV = 300L;
  public static final ae.a gBW;
  private final RelativeLayout gBT;
  private final TextView gBU;
  private final b gzb;
  private final ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(190218);
    gBW = new ae.a((byte)0);
    gBV = 300L;
    AppMethodBeat.o(190218);
  }
  
  public ae(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190217);
    this.gzb = paramb;
    this.gBT = ((RelativeLayout)paramViewGroup.findViewById(2131307651));
    this.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131307650));
    this.gBU = ((TextView)paramViewGroup.findViewById(2131307884));
    AppMethodBeat.o(190217);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190216);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (af.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190216);
      return;
      nj(8);
      AppMethodBeat.o(190216);
      return;
      paramc = this.progressBar;
      k.g(paramc, "progressBar");
      paramc.setVisibility(8);
      AppMethodBeat.o(190216);
      return;
      paramc = this.progressBar;
      k.g(paramc, "progressBar");
      paramc.setVisibility(0);
      paramc = this.gBT;
      k.g(paramc, "blurView");
      paramc.setVisibility(8);
      paramc = this.gBU;
      k.g(paramc, "networkErrTip");
      paramc.setVisibility(8);
      this.gnb.setVisibility(0);
    }
  }
  
  public final void as(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(190214);
    k.h(paramString2, "tip");
    Object localObject = this.gBT;
    k.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bs.isNullOrNil(paramString1))
    {
      paramString1 = this.progressBar;
      k.g(paramString1, "progressBar");
      paramString1.setVisibility(8);
      paramString1 = this.gBU;
      k.g(paramString1, "networkErrTip");
      paramString1.setVisibility(0);
      paramString1 = this.gBU;
      k.g(paramString1, "networkErrTip");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(190214);
      return;
    }
    paramString1 = com.tencent.mm.live.b.d.a.gxt;
    paramString1 = g.guG;
    paramString1 = g.akH();
    localObject = this.gnb.getContext();
    k.g(localObject, "root.context");
    a.a.a(paramString1, ((Context)localObject).getResources().getColor(2131101201), (d.g.a.b)new d(this, paramString2));
    this.gnb.setVisibility(0);
    AppMethodBeat.o(190214);
  }
  
  public final void nj(final int paramInt)
  {
    AppMethodBeat.i(190215);
    if (this.gnb.getVisibility() == paramInt)
    {
      AppMethodBeat.o(190215);
      return;
    }
    if (paramInt == 0)
    {
      this.gnb.setVisibility(paramInt);
      AppMethodBeat.o(190215);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.gnb.getContext(), 2130772048);
    k.g(localAnimation, "animation");
    localAnimation.setDuration(gBV);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
    this.gnb.startAnimation(localAnimation);
    this.gnb.invalidate();
    AppMethodBeat.o(190215);
  }
  
  public final void vd(String paramString)
  {
    AppMethodBeat.i(190213);
    Object localObject = this.gBT;
    k.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bs.isNullOrNil(paramString))
    {
      paramString = this.progressBar;
      k.g(paramString, "progressBar");
      paramString.setVisibility(0);
      paramString = this.gBU;
      k.g(paramString, "networkErrTip");
      paramString.setVisibility(8);
      AppMethodBeat.o(190213);
      return;
    }
    paramString = com.tencent.mm.live.b.d.a.gxt;
    paramString = g.guG;
    paramString = g.akH();
    localObject = this.gnb.getContext();
    k.g(localObject, "root.context");
    a.a.a(paramString, ((Context)localObject).getResources().getColor(2131101201), (d.g.a.b)new c(this));
    this.gnb.setVisibility(0);
    AppMethodBeat.o(190213);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(190210);
      this.gBX.gnb.setVisibility(paramInt);
      AppMethodBeat.o(190210);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Bitmap, y>
  {
    c(ae paramae)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Bitmap, y>
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