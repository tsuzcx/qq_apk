package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.g.b.v.c;
import d.k.h;
import d.l;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "", "()V", "currentMaxVideoHeight", "", "getCurrentMaxVideoHeight", "()I", "setCurrentMaxVideoHeight", "(I)V", "currentVideoHeight", "getCurrentVideoHeight", "setCurrentVideoHeight", "currentVideoWidth", "getCurrentVideoWidth", "setCurrentVideoWidth", "currentX", "getCurrentX", "setCurrentX", "currentY", "getCurrentY", "setCurrentY", "height", "getHeight", "setHeight", "lastVideoBackGround", "getLastVideoBackGround", "setLastVideoBackGround", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "minEdgeGap", "getMinEdgeGap", "setMinEdgeGap", "minVideoHeightWhenPause", "getMinVideoHeightWhenPause", "setMinVideoHeightWhenPause", "minVideoHeightWhenPlay", "getMinVideoHeightWhenPlay", "setMinVideoHeightWhenPlay", "newY", "getNewY", "setNewY", "positionState", "getPositionState", "setPositionState", "reportParams", "", "getReportParams", "()Ljava/lang/String;", "setReportParams", "(Ljava/lang/String;)V", "screenWidth", "getScreenWidth", "setScreenWidth", "va", "Landroid/animation/ValueAnimator;", "getVa", "()Landroid/animation/ValueAnimator;", "setVa", "(Landroid/animation/ValueAnimator;)V", "videoVideo", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoVideo", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "setVideoVideo", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "doVideoZoomAnimation", "", "zoomIn", "", "onUpdateView", "Lkotlin/Function0;", "heightZoomScroll", "absY", "init", "context", "Landroid/content/Context;", "params", "", "density", "", "isZooming", "normalScroll", "onGetVideoSize", "onWebViewScrollChanged", "scrollY", "resetPositionState", "setVideoBackGroundColor", "color", "switchPlayStatus", "updatePositionByWidth", "currentWidth", "updateVideoPosition", "view", "Landroid/view/View;", "Companion", "plugin-brandservice_release"})
public final class i
{
  public static final i.a nlx;
  public int bvW;
  public int height;
  public int kvn;
  public int nlj;
  public int nlk;
  public int nll;
  public int nlm;
  public int nln;
  public int nlo;
  public int nlp;
  public int nlq;
  public MPVideoView nlr;
  private int nls;
  public String nlt;
  public int nlu;
  public ValueAnimator nlv;
  private int nlw;
  public int width;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(175542);
    nlx = new i.a((byte)0);
    AppMethodBeat.o(175542);
  }
  
  public i()
  {
    AppMethodBeat.i(175541);
    this.nls = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 4);
    this.nlw = -16777216;
    AppMethodBeat.o(175541);
  }
  
  public final void a(int paramInt, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(175540);
    k.h(paramMPVideoView, "videoVideo");
    paramMPVideoView.setBackgroundColor(paramInt);
    this.nlw = paramInt;
    AppMethodBeat.o(175540);
  }
  
  public final void b(boolean paramBoolean, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(175535);
    ad.v("MicroMsg.BizVideoPosHelper", "doVideoZoomAnimation zoomIn=".concat(String.valueOf(paramBoolean)));
    ValueAnimator localValueAnimator = this.nlv;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    if (paramBoolean) {}
    for (localValueAnimator = ValueAnimator.ofInt(new int[] { this.width, this.kvn });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.kvn, this.width }))
    {
      this.nlv = localValueAnimator;
      this.nln = this.bvW;
      localValueAnimator = this.nlv;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i.b(this, paramBoolean, parama));
      }
      parama = this.nlv;
      if (parama != null) {
        parama.setDuration(200L);
      }
      parama = this.nlv;
      if (parama == null) {
        break;
      }
      parama.start();
      AppMethodBeat.o(175535);
      return;
    }
    AppMethodBeat.o(175535);
  }
  
  public final boolean bGo()
  {
    return (this.nlq == 1) || (this.nlq == 2);
  }
  
  public final void bGp()
  {
    AppMethodBeat.i(175539);
    if (this.nlr != null)
    {
      localObject = this.nlr;
      if ((localObject == null) || (((MPVideoView)localObject).getVideoWidth() != 0))
      {
        localObject = this.nlr;
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
    Object localObject = new v.c();
    ((v.c)localObject).Jhu = -16777216;
    double d = this.nll;
    MPVideoView localMPVideoView = this.nlr;
    if (localMPVideoView == null) {
      k.fvU();
    }
    d = d * 1.0D / localMPVideoView.getVideoHeight();
    localMPVideoView = this.nlr;
    if (localMPVideoView == null) {
      k.fvU();
    }
    if (Math.abs(d * localMPVideoView.getVideoWidth() - this.nlm) < this.nls)
    {
      localMPVideoView = this.nlr;
      if (localMPVideoView == null) {
        k.fvU();
      }
      ((v.c)localObject).Jhu = com.tencent.mm.cd.a.n(localMPVideoView.getContext(), 2131101179);
    }
    if (this.nlw != ((v.c)localObject).Jhu)
    {
      ad.d("MicroMsg.BizVideoPosHelper", "setVideoBackGroundColor lastVideoBackGround=" + this.nlw + ", newBackGroundColor=" + ((v.c)localObject).Jhu);
      aq.f((Runnable)new e(this, (v.c)localObject));
    }
    AppMethodBeat.o(175539);
  }
  
  public final void dB(View paramView)
  {
    AppMethodBeat.i(175538);
    k.h(paramView, "view");
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(175538);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).height = this.nll;
    ((ViewGroup.MarginLayoutParams)localObject).width = this.nlm;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = h.kK(this.nlj, 0);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = h.kK(this.nlk, 0);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(175538);
  }
  
  public final void yy(int paramInt)
  {
    AppMethodBeat.i(175536);
    if (bGo())
    {
      AppMethodBeat.o(175536);
      return;
    }
    this.nlj = this.x;
    if (paramInt >= 0) {}
    for (;;)
    {
      this.nlk = paramInt;
      this.nll = this.height;
      this.nlm = this.width;
      this.nlq = 0;
      AppMethodBeat.o(175536);
      return;
      paramInt = 0;
    }
  }
  
  public final boolean yz(int paramInt)
  {
    AppMethodBeat.i(175537);
    int j = this.bvW;
    if (this.nlr != null)
    {
      MPVideoView localMPVideoView = this.nlr;
      if ((localMPVideoView == null) || (localMPVideoView.isPlaying() != true)) {}
    }
    for (int i = this.nlo;; i = this.nlp)
    {
      paramInt = h.kK(j - paramInt, i);
      if (paramInt == this.nll) {
        break label104;
      }
      this.nll = paramInt;
      this.nln = paramInt;
      bGp();
      if (bGo()) {
        break;
      }
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
    label104:
    AppMethodBeat.o(175537);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i parami, v.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(175534);
      i locali = this.nly;
      int i = this.nlB.Jhu;
      MPVideoView localMPVideoView = this.nly.nlr;
      if (localMPVideoView == null) {
        k.fvU();
      }
      locali.a(i, localMPVideoView);
      AppMethodBeat.o(175534);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i
 * JD-Core Version:    0.7.0.1
 */