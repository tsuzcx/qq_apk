package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.g.b.y.d;
import d.k.j;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "", "()V", "currentMaxVideoHeight", "", "getCurrentMaxVideoHeight", "()I", "setCurrentMaxVideoHeight", "(I)V", "currentVideoHeight", "getCurrentVideoHeight", "setCurrentVideoHeight", "currentVideoWidth", "getCurrentVideoWidth", "setCurrentVideoWidth", "currentX", "getCurrentX", "setCurrentX", "currentY", "getCurrentY", "setCurrentY", "height", "getHeight", "setHeight", "lastVideoBackGround", "getLastVideoBackGround", "setLastVideoBackGround", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "minEdgeGap", "getMinEdgeGap", "setMinEdgeGap", "minVideoHeightWhenPause", "getMinVideoHeightWhenPause", "setMinVideoHeightWhenPause", "minVideoHeightWhenPlay", "getMinVideoHeightWhenPlay", "setMinVideoHeightWhenPlay", "newY", "getNewY", "setNewY", "positionState", "getPositionState", "setPositionState", "reportParams", "", "getReportParams", "()Ljava/lang/String;", "setReportParams", "(Ljava/lang/String;)V", "screenWidth", "getScreenWidth", "setScreenWidth", "va", "Landroid/animation/ValueAnimator;", "getVa", "()Landroid/animation/ValueAnimator;", "setVa", "(Landroid/animation/ValueAnimator;)V", "videoVideo", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoVideo", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "setVideoVideo", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "doVideoZoomAnimation", "", "zoomIn", "", "onUpdateView", "Lkotlin/Function0;", "heightZoomScroll", "absY", "init", "context", "Landroid/content/Context;", "params", "", "density", "", "isZooming", "normalScroll", "onGetVideoSize", "onWebViewScrollChanged", "scrollY", "resetPositionState", "setVideoBackGroundColor", "color", "switchPlayStatus", "updatePositionByWidth", "currentWidth", "updateVideoPosition", "view", "Landroid/view/View;", "Companion", "plugin-brandservice_release"})
public final class i
{
  public static final i.a oxz;
  public int bEk;
  public int height;
  public int lxZ;
  public int oxl;
  public int oxm;
  public int oxn;
  public int oxo;
  public int oxp;
  public int oxq;
  public int oxr;
  public int oxs;
  public MPVideoView oxt;
  private int oxu;
  public String oxv;
  public int oxw;
  public ValueAnimator oxx;
  private int oxy;
  public int width;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(175542);
    oxz = new i.a((byte)0);
    AppMethodBeat.o(175542);
  }
  
  public i()
  {
    AppMethodBeat.i(175541);
    this.oxu = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 4);
    this.oxy = -16777216;
    AppMethodBeat.o(175541);
  }
  
  public final void Ai(int paramInt)
  {
    AppMethodBeat.i(175536);
    if (bTn())
    {
      AppMethodBeat.o(175536);
      return;
    }
    this.oxl = this.x;
    if (paramInt >= 0) {}
    for (;;)
    {
      this.oxm = paramInt;
      this.oxn = this.height;
      this.oxo = this.width;
      this.oxs = 0;
      AppMethodBeat.o(175536);
      return;
      paramInt = 0;
    }
  }
  
  public final boolean Aj(int paramInt)
  {
    AppMethodBeat.i(175537);
    int j = this.bEk;
    if (this.oxt != null)
    {
      MPVideoView localMPVideoView = this.oxt;
      if ((localMPVideoView == null) || (localMPVideoView.isPlaying() != true)) {}
    }
    for (int i = this.oxq;; i = this.oxr)
    {
      paramInt = j.lw(j - paramInt, i);
      if (paramInt == this.oxn) {
        break label106;
      }
      this.oxm = 0;
      this.oxn = paramInt;
      this.oxp = paramInt;
      bTo();
      if (bTn()) {
        break;
      }
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
    label106:
    if (this.oxm != 0)
    {
      this.oxm = 0;
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
    this.oxy = paramInt;
    AppMethodBeat.o(175540);
  }
  
  public final void b(final boolean paramBoolean, final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(175535);
    ae.v("MicroMsg.BizVideoPosHelper", "doVideoZoomAnimation zoomIn=".concat(String.valueOf(paramBoolean)));
    ValueAnimator localValueAnimator = this.oxx;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    if (paramBoolean) {}
    for (localValueAnimator = ValueAnimator.ofInt(new int[] { this.width, this.lxZ });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.lxZ, this.width }))
    {
      this.oxx = localValueAnimator;
      this.oxp = this.bEk;
      localValueAnimator = this.oxx;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this, paramBoolean, parama));
      }
      parama = this.oxx;
      if (parama != null) {
        parama.setDuration(200L);
      }
      parama = this.oxx;
      if (parama == null) {
        break;
      }
      parama.start();
      AppMethodBeat.o(175535);
      return;
    }
    AppMethodBeat.o(175535);
  }
  
  public final boolean bTn()
  {
    return (this.oxs == 1) || (this.oxs == 2);
  }
  
  public final void bTo()
  {
    AppMethodBeat.i(175539);
    if (this.oxt != null)
    {
      localObject = this.oxt;
      if ((localObject == null) || (((MPVideoView)localObject).getVideoWidth() != 0))
      {
        localObject = this.oxt;
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
    Object localObject = new y.d();
    ((y.d)localObject).NiW = -16777216;
    double d = this.oxn;
    MPVideoView localMPVideoView = this.oxt;
    if (localMPVideoView == null) {
      p.gkB();
    }
    d = d * 1.0D / localMPVideoView.getVideoHeight();
    localMPVideoView = this.oxt;
    if (localMPVideoView == null) {
      p.gkB();
    }
    if (Math.abs(d * localMPVideoView.getVideoWidth() - this.oxo) < this.oxu)
    {
      localMPVideoView = this.oxt;
      if (localMPVideoView == null) {
        p.gkB();
      }
      ((y.d)localObject).NiW = com.tencent.mm.cb.a.n(localMPVideoView.getContext(), 2131101179);
    }
    if (this.oxy != ((y.d)localObject).NiW)
    {
      ae.d("MicroMsg.BizVideoPosHelper", "setVideoBackGroundColor lastVideoBackGround=" + this.oxy + ", newBackGroundColor=" + ((y.d)localObject).NiW);
      ar.f((Runnable)new e(this, (y.d)localObject));
    }
    AppMethodBeat.o(175539);
  }
  
  public final void dG(View paramView)
  {
    AppMethodBeat.i(175538);
    p.h(paramView, "view");
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(175538);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).height = this.oxn;
    ((ViewGroup.MarginLayoutParams)localObject).width = this.oxo;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j.lw(this.oxl, 0);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = j.lw(this.oxm, 0);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(175538);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(i parami, boolean paramBoolean, d.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(175531);
      i locali = this.oxA;
      boolean bool = paramBoolean;
      p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(175531);
        throw paramValueAnimator;
      }
      i.a(locali, bool, ((Integer)paramValueAnimator).intValue());
      parama.invoke();
      AppMethodBeat.o(175531);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i parami, y.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(175534);
      i locali = this.oxA;
      int i = this.oxD.NiW;
      MPVideoView localMPVideoView = this.oxA.oxt;
      if (localMPVideoView == null) {
        p.gkB();
      }
      locali.a(i, localMPVideoView);
      AppMethodBeat.o(175534);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    public f(i parami, d.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(209149);
      i locali = this.oxA;
      p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(209149);
        throw paramValueAnimator;
      }
      locali.oxn = ((Integer)paramValueAnimator).intValue();
      if (this.oxA.oxn == this.oxA.oxq) {
        i.a(this.oxA);
      }
      this.oxC.invoke();
      AppMethodBeat.o(209149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i
 * JD-Core Version:    0.7.0.1
 */