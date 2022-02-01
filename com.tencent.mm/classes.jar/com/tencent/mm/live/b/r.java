package com.tencent.mm.live.b;

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
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.model.d.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "forceSetVisible", "", "visible", "", "hideProgress", "setVisible", "showBlurBg", "username", "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends a
{
  public static final r.a niG;
  private static final long niJ;
  private final b nfT;
  private final RelativeLayout niH;
  private final TextView niI;
  private final ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(247169);
    niG = new r.a((byte)0);
    niJ = 300L;
    AppMethodBeat.o(247169);
  }
  
  public r(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247129);
    this.nfT = paramb;
    this.niH = ((RelativeLayout)paramViewGroup.findViewById(b.e.live_loading_blur));
    this.progressBar = ((ProgressBar)paramViewGroup.findViewById(b.e.live_loading_bar));
    this.niI = ((TextView)paramViewGroup.findViewById(b.e.network_error_tip));
    AppMethodBeat.o(247129);
  }
  
  public final void GA(String paramString)
  {
    AppMethodBeat.i(247183);
    this.niH.setVisibility(0);
    if (Util.isNullOrNil(paramString))
    {
      this.progressBar.setVisibility(0);
      this.niI.setVisibility(8);
      AppMethodBeat.o(247183);
      return;
    }
    paramString = com.tencent.mm.live.model.d.a.nbX;
    paramString = com.tencent.mm.live.model.u.mZl;
    a.a.b(com.tencent.mm.live.model.u.big(), this.mJe.getContext().getResources().getColor(b.b.live_half_black_bg), (kotlin.g.a.b)new d(this));
    this.mJe.setVisibility(0);
    AppMethodBeat.o(247183);
  }
  
  public final void showTipWithBlurBg(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(247196);
    s.u(paramString2, "tip");
    this.niH.setVisibility(0);
    if (Util.isNullOrNil(paramString1))
    {
      this.progressBar.setVisibility(8);
      this.niI.setVisibility(0);
      this.niI.setText((CharSequence)paramString2);
      AppMethodBeat.o(247196);
      return;
    }
    paramString1 = com.tencent.mm.live.model.d.a.nbX;
    paramString1 = com.tencent.mm.live.model.u.mZl;
    a.a.b(com.tencent.mm.live.model.u.big(), this.mJe.getContext().getResources().getColor(b.b.live_half_black_bg), (kotlin.g.a.b)new e(this, paramString2));
    this.mJe.setVisibility(0);
    AppMethodBeat.o(247196);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247218);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (r.b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247218);
      return;
      tO(8);
      AppMethodBeat.o(247218);
      return;
      this.progressBar.setVisibility(8);
      AppMethodBeat.o(247218);
      return;
      this.progressBar.setVisibility(0);
      this.niH.setVisibility(8);
      this.niI.setVisibility(8);
      this.mJe.setVisibility(0);
    }
  }
  
  public final void tO(final int paramInt)
  {
    AppMethodBeat.i(247204);
    if (this.mJe.getVisibility() == paramInt)
    {
      AppMethodBeat.o(247204);
      return;
    }
    if (paramInt == 0)
    {
      this.mJe.setVisibility(paramInt);
      AppMethodBeat.o(247204);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.mJe.getContext(), b.a.fast_faded_out);
    localAnimation.setDuration(niJ);
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this, paramInt));
    this.mJe.startAnimation(localAnimation);
    this.mJe.invalidate();
    AppMethodBeat.o(247204);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animation.AnimationListener
  {
    c(r paramr, int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(247465);
      this.niK.mJe.setVisibility(paramInt);
      AppMethodBeat.o(247465);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    d(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    e(r paramr, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.b.r
 * JD-Core Version:    0.7.0.1
 */