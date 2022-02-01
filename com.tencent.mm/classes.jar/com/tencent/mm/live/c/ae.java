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
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.d.a.a;
import com.tencent.mm.live.b.u;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "forceSetVisible", "", "visible", "", "hideProgress", "setVisible", "showBlurBg", "username", "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ae
  extends a
{
  private static final long FADE_OUT_DURATION = 300L;
  public static final a kFH;
  private final b kCL;
  private final RelativeLayout kFF;
  private final TextView kFG;
  private final ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(197079);
    kFH = new a((byte)0);
    FADE_OUT_DURATION = 300L;
    AppMethodBeat.o(197079);
  }
  
  public ae(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(197077);
    this.kCL = paramb;
    this.kFF = ((RelativeLayout)paramViewGroup.findViewById(b.e.live_loading_blur));
    this.progressBar = ((ProgressBar)paramViewGroup.findViewById(b.e.live_loading_bar));
    this.kFG = ((TextView)paramViewGroup.findViewById(b.e.network_error_tip));
    AppMethodBeat.o(197077);
  }
  
  public final void On(String paramString)
  {
    AppMethodBeat.i(197059);
    Object localObject = this.kFF;
    p.j(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.progressBar;
      p.j(paramString, "progressBar");
      paramString.setVisibility(0);
      paramString = this.kFG;
      p.j(paramString, "networkErrTip");
      paramString.setVisibility(8);
      AppMethodBeat.o(197059);
      return;
    }
    paramString = com.tencent.mm.live.b.d.a.kyA;
    paramString = u.kwz;
    paramString = u.aOt();
    localObject = this.kiF.getContext();
    p.j(localObject, "root.context");
    a.a.b(paramString, ((Context)localObject).getResources().getColor(b.b.live_half_black_bg), (kotlin.g.a.b)new c(this));
    this.kiF.setVisibility(0);
    AppMethodBeat.o(197059);
  }
  
  public final void showTipWithBlurBg(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(197064);
    p.k(paramString2, "tip");
    Object localObject = this.kFF;
    p.j(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = this.progressBar;
      p.j(paramString1, "progressBar");
      paramString1.setVisibility(8);
      paramString1 = this.kFG;
      p.j(paramString1, "networkErrTip");
      paramString1.setVisibility(0);
      paramString1 = this.kFG;
      p.j(paramString1, "networkErrTip");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(197064);
      return;
    }
    paramString1 = com.tencent.mm.live.b.d.a.kyA;
    paramString1 = u.kwz;
    paramString1 = u.aOt();
    localObject = this.kiF.getContext();
    p.j(localObject, "root.context");
    a.a.b(paramString1, ((Context)localObject).getResources().getColor(b.b.live_half_black_bg), (kotlin.g.a.b)new d(this, paramString2));
    this.kiF.setVisibility(0);
    AppMethodBeat.o(197064);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(197074);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (af.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(197074);
      return;
      tU(8);
      AppMethodBeat.o(197074);
      return;
      paramc = this.progressBar;
      p.j(paramc, "progressBar");
      paramc.setVisibility(8);
      AppMethodBeat.o(197074);
      return;
      paramc = this.progressBar;
      p.j(paramc, "progressBar");
      paramc.setVisibility(0);
      paramc = this.kFF;
      p.j(paramc, "blurView");
      paramc.setVisibility(8);
      paramc = this.kFG;
      p.j(paramc, "networkErrTip");
      paramc.setVisibility(8);
      this.kiF.setVisibility(0);
    }
  }
  
  public final void tU(final int paramInt)
  {
    AppMethodBeat.i(197069);
    if (this.kiF.getVisibility() == paramInt)
    {
      AppMethodBeat.o(197069);
      return;
    }
    if (paramInt == 0)
    {
      this.kiF.setVisibility(paramInt);
      AppMethodBeat.o(197069);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.kiF.getContext(), b.a.fast_faded_out);
    p.j(localAnimation, "animation");
    localAnimation.setDuration(FADE_OUT_DURATION);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
    this.kiF.startAnimation(localAnimation);
    this.kiF.invalidate();
    AppMethodBeat.o(197069);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin$Companion;", "", "()V", "FADE_OUT_DURATION", "", "getFADE_OUT_DURATION", "()J", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(190604);
      this.kFI.kiF.setVisibility(paramInt);
      AppMethodBeat.o(190604);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Bitmap, x>
  {
    c(ae paramae)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Bitmap, x>
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