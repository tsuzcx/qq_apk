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
import com.tencent.mm.live.b.f;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blurView", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "networkErrTip", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "hideProgress", "", "setVisible", "visible", "", "showBlurBg", "username", "", "showLoadingWithBlurBg", "showProgress", "showTipWithBlurBg", "tip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class ae
  extends a
{
  public static final a KvO;
  private final b IIs;
  private final RelativeLayout KvM;
  private final TextView KvN;
  private final ProgressBar progressBar;
  
  static
  {
    AppMethodBeat.i(202990);
    KvO = new a((byte)0);
    AppMethodBeat.o(202990);
  }
  
  public ae(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202989);
    this.IIs = paramb;
    this.KvM = ((RelativeLayout)paramViewGroup.findViewById(2131307568));
    this.progressBar = ((ProgressBar)paramViewGroup.findViewById(2131307567));
    this.KvN = ((TextView)paramViewGroup.findViewById(2131307792));
    AppMethodBeat.o(202989);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(202988);
    k.h(paramc, "status");
    super.a(paramc, paramBundle);
    switch (af.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202988);
      return;
      agK(8);
      AppMethodBeat.o(202988);
      return;
      paramc = this.progressBar;
      k.g(paramc, "progressBar");
      paramc.setVisibility(8);
      AppMethodBeat.o(202988);
      return;
      paramc = this.progressBar;
      k.g(paramc, "progressBar");
      paramc.setVisibility(0);
      paramc = this.KvM;
      k.g(paramc, "blurView");
      paramc.setVisibility(8);
      paramc = this.KvN;
      k.g(paramc, "networkErrTip");
      paramc.setVisibility(8);
      this.pTc.setVisibility(0);
    }
  }
  
  public final void aUv(String paramString)
  {
    AppMethodBeat.i(202985);
    Object localObject = this.KvM;
    k.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bt.isNullOrNil(paramString))
    {
      paramString = this.progressBar;
      k.g(paramString, "progressBar");
      paramString.setVisibility(0);
      paramString = this.KvN;
      k.g(paramString, "networkErrTip");
      paramString.setVisibility(8);
      AppMethodBeat.o(202985);
      return;
    }
    paramString = com.tencent.mm.live.b.d.a.Fwy;
    paramString = f.rGw;
    paramString = f.eNI();
    localObject = this.pTc.getContext();
    k.g(localObject, "root.context");
    a.a.a(paramString, ((Context)localObject).getResources().getColor(2131101200), (d.g.a.b)new c(this));
    this.pTc.setVisibility(0);
    AppMethodBeat.o(202985);
  }
  
  public final void agK(final int paramInt)
  {
    AppMethodBeat.i(202987);
    if (this.pTc.getVisibility() == paramInt)
    {
      AppMethodBeat.o(202987);
      return;
    }
    if (paramInt == 0)
    {
      this.pTc.setVisibility(paramInt);
      AppMethodBeat.o(202987);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.pTc.getContext(), 2130772048);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
    this.KvM.startAnimation(localAnimation);
    AppMethodBeat.o(202987);
  }
  
  public final void ca(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(202986);
    k.h(paramString2, "tip");
    Object localObject = this.KvM;
    k.g(localObject, "blurView");
    ((RelativeLayout)localObject).setVisibility(0);
    if (bt.isNullOrNil(paramString1))
    {
      paramString1 = this.progressBar;
      k.g(paramString1, "progressBar");
      paramString1.setVisibility(8);
      paramString1 = this.KvN;
      k.g(paramString1, "networkErrTip");
      paramString1.setVisibility(0);
      paramString1 = this.KvN;
      k.g(paramString1, "networkErrTip");
      paramString1.setText((CharSequence)paramString2);
      AppMethodBeat.o(202986);
      return;
    }
    paramString1 = com.tencent.mm.live.b.d.a.Fwy;
    paramString1 = f.rGw;
    paramString1 = f.eNI();
    localObject = this.pTc.getContext();
    k.g(localObject, "root.context");
    a.a.a(paramString1, ((Context)localObject).getResources().getColor(2131101200), (d.g.a.b)new d(this, paramString2));
    this.pTc.setVisibility(0);
    AppMethodBeat.o(202986);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveLoadingPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/plugin/LiveLoadingPlugin$setVisible$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-logic_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(202982);
      this.KvP.pTc.setVisibility(paramInt);
      AppMethodBeat.o(202982);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Bitmap, y>
  {
    c(ae paramae)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.ae
 * JD-Core Version:    0.7.0.1
 */