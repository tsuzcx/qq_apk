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
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "forceSetVisible", "", "visible", "", "hideProgress", "setVisible", "showBlurBg", "username", "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ae
  extends a
{
  private static final long gYo = 300L;
  public static final ae.a gYp;
  private final b gVv;
  private final RelativeLayout gYm;
  private final TextView gYn;
  private final ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(216128);
    gYp = new ae.a((byte)0);
    gYo = 300L;
    AppMethodBeat.o(216128);
  }
  
  public ae(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(216127);
    this.gVv = paramb;
    this.gYm = ((RelativeLayout)paramViewGroup.findViewById(2131307651));
    this.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131307650));
    this.gYn = ((TextView)paramViewGroup.findViewById(2131307884));
    AppMethodBeat.o(216127);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(216126);
    p.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (af.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216126);
      return;
      nL(8);
      AppMethodBeat.o(216126);
      return;
      paramc = this.progressBar;
      p.g(paramc, "progressBar");
      paramc.setVisibility(8);
      AppMethodBeat.o(216126);
      return;
      paramc = this.progressBar;
      p.g(paramc, "progressBar");
      paramc.setVisibility(0);
      paramc = this.gYm;
      p.g(paramc, "blurView");
      paramc.setVisibility(8);
      paramc = this.gYn;
      p.g(paramc, "networkErrTip");
      paramc.setVisibility(8);
      this.gJt.setVisibility(0);
    }
  }
  
  public final void au(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(216124);
    p.h(paramString2, "tip");
    Object localObject = this.gYm;
    p.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bu.isNullOrNil(paramString1))
    {
      paramString1 = this.progressBar;
      p.g(paramString1, "progressBar");
      paramString1.setVisibility(8);
      paramString1 = this.gYn;
      p.g(paramString1, "networkErrTip");
      paramString1.setVisibility(0);
      paramString1 = this.gYn;
      p.g(paramString1, "networkErrTip");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(216124);
      return;
    }
    paramString1 = com.tencent.mm.live.b.d.a.gTM;
    paramString1 = g.gQZ;
    paramString1 = g.anJ();
    localObject = this.gJt.getContext();
    p.g(localObject, "root.context");
    a.a.a(paramString1, ((Context)localObject).getResources().getColor(2131101201), (d.g.a.b)new d(this, paramString2));
    this.gJt.setVisibility(0);
    AppMethodBeat.o(216124);
  }
  
  public final void nL(final int paramInt)
  {
    AppMethodBeat.i(216125);
    if (this.gJt.getVisibility() == paramInt)
    {
      AppMethodBeat.o(216125);
      return;
    }
    if (paramInt == 0)
    {
      this.gJt.setVisibility(paramInt);
      AppMethodBeat.o(216125);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.gJt.getContext(), 2130772048);
    p.g(localAnimation, "animation");
    localAnimation.setDuration(gYo);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
    this.gJt.startAnimation(localAnimation);
    this.gJt.invalidate();
    AppMethodBeat.o(216125);
  }
  
  public final void yD(String paramString)
  {
    AppMethodBeat.i(216123);
    Object localObject = this.gYm;
    p.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bu.isNullOrNil(paramString))
    {
      paramString = this.progressBar;
      p.g(paramString, "progressBar");
      paramString.setVisibility(0);
      paramString = this.gYn;
      p.g(paramString, "networkErrTip");
      paramString.setVisibility(8);
      AppMethodBeat.o(216123);
      return;
    }
    paramString = com.tencent.mm.live.b.d.a.gTM;
    paramString = g.gQZ;
    paramString = g.anJ();
    localObject = this.gJt.getContext();
    p.g(localObject, "root.context");
    a.a.a(paramString, ((Context)localObject).getResources().getColor(2131101201), (d.g.a.b)new c(this));
    this.gJt.setVisibility(0);
    AppMethodBeat.o(216123);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(216120);
      this.gYq.gJt.setVisibility(paramInt);
      AppMethodBeat.o(216120);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<Bitmap, z>
  {
    c(ae paramae)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.ae
 * JD-Core Version:    0.7.0.1
 */