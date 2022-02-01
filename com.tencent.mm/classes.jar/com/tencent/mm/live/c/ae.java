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
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "forceSetVisible", "", "visible", "", "hideProgress", "setVisible", "showBlurBg", "username", "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ae
  extends a
{
  private static final long FADE_OUT_DURATION = 300L;
  public static final a hRk;
  private final b hOp;
  private final RelativeLayout hRi;
  private final TextView hRj;
  private final ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(208090);
    hRk = new a((byte)0);
    FADE_OUT_DURATION = 300L;
    AppMethodBeat.o(208090);
  }
  
  public ae(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208089);
    this.hOp = paramb;
    this.hRi = ((RelativeLayout)paramViewGroup.findViewById(2131303429));
    this.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131303428));
    this.hRj = ((TextView)paramViewGroup.findViewById(2131305271));
    AppMethodBeat.o(208089);
  }
  
  public final void Hc(String paramString)
  {
    AppMethodBeat.i(208085);
    Object localObject = this.hRi;
    p.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.progressBar;
      p.g(paramString, "progressBar");
      paramString.setVisibility(0);
      paramString = this.hRj;
      p.g(paramString, "networkErrTip");
      paramString.setVisibility(8);
      AppMethodBeat.o(208085);
      return;
    }
    paramString = com.tencent.mm.live.b.d.a.hLg;
    paramString = com.tencent.mm.live.b.x.hJf;
    paramString = com.tencent.mm.live.b.x.aGt();
    localObject = this.hwr.getContext();
    p.g(localObject, "root.context");
    a.a.a(paramString, ((Context)localObject).getResources().getColor(2131100702), (kotlin.g.a.b)new c(this));
    this.hwr.setVisibility(0);
    AppMethodBeat.o(208085);
  }
  
  public final void rg(final int paramInt)
  {
    AppMethodBeat.i(208087);
    if (this.hwr.getVisibility() == paramInt)
    {
      AppMethodBeat.o(208087);
      return;
    }
    if (paramInt == 0)
    {
      this.hwr.setVisibility(paramInt);
      AppMethodBeat.o(208087);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.hwr.getContext(), 2130772060);
    p.g(localAnimation, "animation");
    localAnimation.setDuration(FADE_OUT_DURATION);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
    this.hwr.startAnimation(localAnimation);
    this.hwr.invalidate();
    AppMethodBeat.o(208087);
  }
  
  public final void showTipWithBlurBg(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(208086);
    p.h(paramString2, "tip");
    Object localObject = this.hRi;
    p.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = this.progressBar;
      p.g(paramString1, "progressBar");
      paramString1.setVisibility(8);
      paramString1 = this.hRj;
      p.g(paramString1, "networkErrTip");
      paramString1.setVisibility(0);
      paramString1 = this.hRj;
      p.g(paramString1, "networkErrTip");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(208086);
      return;
    }
    paramString1 = com.tencent.mm.live.b.d.a.hLg;
    paramString1 = com.tencent.mm.live.b.x.hJf;
    paramString1 = com.tencent.mm.live.b.x.aGt();
    localObject = this.hwr.getContext();
    p.g(localObject, "root.context");
    a.a.a(paramString1, ((Context)localObject).getResources().getColor(2131100702), (kotlin.g.a.b)new d(this, paramString2));
    this.hwr.setVisibility(0);
    AppMethodBeat.o(208086);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208088);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (af.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208088);
      return;
      rg(8);
      AppMethodBeat.o(208088);
      return;
      paramc = this.progressBar;
      p.g(paramc, "progressBar");
      paramc.setVisibility(8);
      AppMethodBeat.o(208088);
      return;
      paramc = this.progressBar;
      p.g(paramc, "progressBar");
      paramc.setVisibility(0);
      paramc = this.hRi;
      p.g(paramc, "blurView");
      paramc.setVisibility(8);
      paramc = this.hRj;
      p.g(paramc, "networkErrTip");
      paramc.setVisibility(8);
      this.hwr.setVisibility(0);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin$Companion;", "", "()V", "FADE_OUT_DURATION", "", "getFADE_OUT_DURATION", "()J", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(208082);
      this.hRl.hwr.setVisibility(paramInt);
      AppMethodBeat.o(208082);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Bitmap, kotlin.x>
  {
    c(ae paramae)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Bitmap, kotlin.x>
  {
    d(ae paramae, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.ae
 * JD-Core Version:    0.7.0.1
 */