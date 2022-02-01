package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "", "()V", "currentMaxVideoHeight", "", "getCurrentMaxVideoHeight", "()I", "setCurrentMaxVideoHeight", "(I)V", "currentVideoHeight", "getCurrentVideoHeight", "setCurrentVideoHeight", "currentVideoWidth", "getCurrentVideoWidth", "setCurrentVideoWidth", "currentX", "getCurrentX", "setCurrentX", "currentY", "getCurrentY", "setCurrentY", "height", "getHeight", "setHeight", "lastVideoBackGround", "getLastVideoBackGround", "setLastVideoBackGround", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "minEdgeGap", "getMinEdgeGap", "setMinEdgeGap", "minVideoHeightWhenPause", "getMinVideoHeightWhenPause", "setMinVideoHeightWhenPause", "minVideoHeightWhenPlay", "getMinVideoHeightWhenPlay", "setMinVideoHeightWhenPlay", "newY", "getNewY", "setNewY", "positionState", "getPositionState", "setPositionState", "reportParams", "", "getReportParams", "()Ljava/lang/String;", "setReportParams", "(Ljava/lang/String;)V", "screenWidth", "getScreenWidth", "setScreenWidth", "va", "Landroid/animation/ValueAnimator;", "getVa", "()Landroid/animation/ValueAnimator;", "setVa", "(Landroid/animation/ValueAnimator;)V", "videoVideo", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoVideo", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "setVideoVideo", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "doVideoZoomAnimation", "", "zoomIn", "", "onUpdateView", "Lkotlin/Function0;", "heightZoomScroll", "absY", "init", "context", "Landroid/content/Context;", "params", "", "density", "", "isZooming", "normalScroll", "onGetVideoSize", "onWebViewScrollChanged", "scrollY", "resetPositionState", "setVideoBackGroundColor", "color", "switchPlayStatus", "updatePositionByWidth", "currentWidth", "updateVideoPosition", "view", "Landroid/view/View;", "Companion", "plugin-brandservice_release"})
public final class i
{
  public static final i.a pLd;
  public int bEm;
  public int height;
  public int mEX;
  public int pKP;
  public int pKQ;
  public int pKR;
  public int pKS;
  public int pKT;
  public int pKU;
  public int pKV;
  public int pKW;
  public MPVideoView pKX;
  private int pKY;
  public String pKZ;
  public int pLa;
  public ValueAnimator pLb;
  private int pLc;
  public int width;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(175542);
    pLd = new i.a((byte)0);
    AppMethodBeat.o(175542);
  }
  
  public i()
  {
    AppMethodBeat.i(175541);
    this.pKY = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    this.pLc = -16777216;
    AppMethodBeat.o(175541);
  }
  
  public final void DN(int paramInt)
  {
    AppMethodBeat.i(175536);
    if (cqY())
    {
      AppMethodBeat.o(175536);
      return;
    }
    this.pKP = this.x;
    if (paramInt >= 0) {}
    for (;;)
    {
      this.pKQ = paramInt;
      this.pKR = this.height;
      this.pKS = this.width;
      this.pKW = 0;
      AppMethodBeat.o(175536);
      return;
      paramInt = 0;
    }
  }
  
  public final boolean DO(int paramInt)
  {
    AppMethodBeat.i(175537);
    int j = this.bEm;
    if (this.pKX != null)
    {
      MPVideoView localMPVideoView = this.pKX;
      if ((localMPVideoView == null) || (localMPVideoView.isPlaying() != true)) {}
    }
    for (int i = this.pKU;; i = this.pKV)
    {
      paramInt = j.mZ(j - paramInt, i);
      if (paramInt == this.pKR) {
        break label106;
      }
      this.pKQ = 0;
      this.pKR = paramInt;
      this.pKT = paramInt;
      cqZ();
      if (cqY()) {
        break;
      }
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
    label106:
    if (this.pKQ != 0)
    {
      this.pKQ = 0;
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
  }
  
  public final void a(int paramInt, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(175540);
    p.h(paramMPVideoView, "videoVideo");
    paramMPVideoView.setBackgroundColor(paramInt);
    this.pLc = paramInt;
    AppMethodBeat.o(175540);
  }
  
  public final void b(final boolean paramBoolean, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(175535);
    Log.v("MicroMsg.BizVideoPosHelper", "doVideoZoomAnimation zoomIn=".concat(String.valueOf(paramBoolean)));
    ValueAnimator localValueAnimator = this.pLb;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    if (paramBoolean) {}
    for (localValueAnimator = ValueAnimator.ofInt(new int[] { this.width, this.mEX });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.mEX, this.width }))
    {
      this.pLb = localValueAnimator;
      this.pKT = this.bEm;
      localValueAnimator = this.pLb;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this, paramBoolean, parama));
      }
      parama = this.pLb;
      if (parama != null) {
        parama.setDuration(200L);
      }
      parama = this.pLb;
      if (parama == null) {
        break;
      }
      parama.start();
      AppMethodBeat.o(175535);
      return;
    }
    AppMethodBeat.o(175535);
  }
  
  public final boolean cqY()
  {
    return (this.pKW == 1) || (this.pKW == 2);
  }
  
  public final void cqZ()
  {
    AppMethodBeat.i(175539);
    if (this.pKX != null)
    {
      localObject = this.pKX;
      if ((localObject == null) || (((MPVideoView)localObject).getVideoWidth() != 0))
      {
        localObject = this.pKX;
        if ((localObject == null) || (((MPVideoView)localObject).getVideoHeight() != 0)) {
          break label59;
        }
        AppMethodBeat.o(175539);
        return;
      }
    }
    AppMethodBeat.o(175539);
    return;
    label59:
    Object localObject = new z.d();
    ((z.d)localObject).SYE = -16777216;
    double d = this.pKR;
    MPVideoView localMPVideoView = this.pKX;
    if (localMPVideoView == null) {
      p.hyc();
    }
    d = d * 1.0D / localMPVideoView.getVideoHeight();
    localMPVideoView = this.pKX;
    if (localMPVideoView == null) {
      p.hyc();
    }
    if (Math.abs(d * localMPVideoView.getVideoWidth() - this.pKS) < this.pKY)
    {
      localMPVideoView = this.pKX;
      if (localMPVideoView == null) {
        p.hyc();
      }
      ((z.d)localObject).SYE = com.tencent.mm.cb.a.n(localMPVideoView.getContext(), 2131101424);
    }
    if (this.pLc != ((z.d)localObject).SYE)
    {
      Log.d("MicroMsg.BizVideoPosHelper", "setVideoBackGroundColor lastVideoBackGround=" + this.pLc + ", newBackGroundColor=" + ((z.d)localObject).SYE);
      MMHandlerThread.postToMainThread((Runnable)new e(this, (z.d)localObject));
    }
    AppMethodBeat.o(175539);
  }
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(175538);
    p.h(paramView, "view");
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(175538);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).height = this.pKR;
    ((ViewGroup.MarginLayoutParams)localObject).width = this.pKS;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j.mZ(this.pKP, 0);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = j.mZ(this.pKQ, 0);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(175538);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(i parami, boolean paramBoolean, kotlin.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(175531);
      i locali = this.pLe;
      boolean bool = paramBoolean;
      p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(175531);
        throw paramValueAnimator;
      }
      i.a(locali, bool, ((Integer)paramValueAnimator).intValue());
      parama.invoke();
      AppMethodBeat.o(175531);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i parami, z.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(175534);
      i locali = this.pLe;
      int i = this.pLh.SYE;
      MPVideoView localMPVideoView = this.pLe.pKX;
      if (localMPVideoView == null) {
        p.hyc();
      }
      locali.a(i, localMPVideoView);
      AppMethodBeat.o(175534);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    public f(i parami, kotlin.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(195972);
      i locali = this.pLe;
      p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(195972);
        throw paramValueAnimator;
      }
      locali.pKR = ((Integer)paramValueAnimator).intValue();
      if (this.pLe.pKR == this.pLe.pKU) {
        i.a(this.pLe);
      }
      this.pLg.invoke();
      AppMethodBeat.o(195972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i
 * JD-Core Version:    0.7.0.1
 */