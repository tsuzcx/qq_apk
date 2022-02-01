package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.g.b.v.d;
import d.k.h;
import d.l;
import d.v;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "", "()V", "currentMaxVideoHeight", "", "getCurrentMaxVideoHeight", "()I", "setCurrentMaxVideoHeight", "(I)V", "currentVideoHeight", "getCurrentVideoHeight", "setCurrentVideoHeight", "currentVideoWidth", "getCurrentVideoWidth", "setCurrentVideoWidth", "currentX", "getCurrentX", "setCurrentX", "currentY", "getCurrentY", "setCurrentY", "height", "getHeight", "setHeight", "lastVideoBackGround", "getLastVideoBackGround", "setLastVideoBackGround", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "minEdgeGap", "getMinEdgeGap", "setMinEdgeGap", "minVideoHeightWhenPause", "getMinVideoHeightWhenPause", "setMinVideoHeightWhenPause", "minVideoHeightWhenPlay", "getMinVideoHeightWhenPlay", "setMinVideoHeightWhenPlay", "newY", "getNewY", "setNewY", "positionState", "getPositionState", "setPositionState", "reportParams", "", "getReportParams", "()Ljava/lang/String;", "setReportParams", "(Ljava/lang/String;)V", "screenWidth", "getScreenWidth", "setScreenWidth", "va", "Landroid/animation/ValueAnimator;", "getVa", "()Landroid/animation/ValueAnimator;", "setVa", "(Landroid/animation/ValueAnimator;)V", "videoVideo", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoVideo", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "setVideoVideo", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "doVideoZoomAnimation", "", "zoomIn", "", "onUpdateView", "Lkotlin/Function0;", "heightZoomScroll", "absY", "init", "context", "Landroid/content/Context;", "params", "", "density", "", "isZooming", "normalScroll", "onGetVideoSize", "onWebViewScrollChanged", "scrollY", "resetPositionState", "setVideoBackGroundColor", "color", "switchPlayStatus", "updatePositionByWidth", "currentWidth", "updateVideoPosition", "view", "Landroid/view/View;", "Companion", "plugin-brandservice_release"})
public final class i
{
  public static final i.a nOx;
  public int btU;
  public int height;
  public int kWB;
  public int nOj;
  public int nOk;
  public int nOl;
  public int nOm;
  public int nOn;
  public int nOo;
  public int nOp;
  public int nOq;
  public MPVideoView nOr;
  private int nOs;
  public String nOt;
  public int nOu;
  public ValueAnimator nOv;
  private int nOw;
  public int width;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(175542);
    nOx = new i.a((byte)0);
    AppMethodBeat.o(175542);
  }
  
  public i()
  {
    AppMethodBeat.i(175541);
    this.nOs = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 4);
    this.nOw = -16777216;
    AppMethodBeat.o(175541);
  }
  
  public final void a(int paramInt, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(175540);
    k.h(paramMPVideoView, "videoVideo");
    paramMPVideoView.setBackgroundColor(paramInt);
    this.nOw = paramInt;
    AppMethodBeat.o(175540);
  }
  
  public final void b(boolean paramBoolean, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(175535);
    ac.v("MicroMsg.BizVideoPosHelper", "doVideoZoomAnimation zoomIn=".concat(String.valueOf(paramBoolean)));
    ValueAnimator localValueAnimator = this.nOv;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    if (paramBoolean) {}
    for (localValueAnimator = ValueAnimator.ofInt(new int[] { this.width, this.kWB });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.kWB, this.width }))
    {
      this.nOv = localValueAnimator;
      this.nOn = this.btU;
      localValueAnimator = this.nOv;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new i.b(this, paramBoolean, parama));
      }
      parama = this.nOv;
      if (parama != null) {
        parama.setDuration(200L);
      }
      parama = this.nOv;
      if (parama == null) {
        break;
      }
      parama.start();
      AppMethodBeat.o(175535);
      return;
    }
    AppMethodBeat.o(175535);
  }
  
  public final boolean bNB()
  {
    return (this.nOq == 1) || (this.nOq == 2);
  }
  
  public final void bNC()
  {
    AppMethodBeat.i(175539);
    if (this.nOr != null)
    {
      localObject = this.nOr;
      if ((localObject == null) || (((MPVideoView)localObject).getVideoWidth() != 0))
      {
        localObject = this.nOr;
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
    Object localObject = new v.d();
    ((v.d)localObject).KUO = -16777216;
    double d = this.nOl;
    MPVideoView localMPVideoView = this.nOr;
    if (localMPVideoView == null) {
      k.fOy();
    }
    d = d * 1.0D / localMPVideoView.getVideoHeight();
    localMPVideoView = this.nOr;
    if (localMPVideoView == null) {
      k.fOy();
    }
    if (Math.abs(d * localMPVideoView.getVideoWidth() - this.nOm) < this.nOs)
    {
      localMPVideoView = this.nOr;
      if (localMPVideoView == null) {
        k.fOy();
      }
      ((v.d)localObject).KUO = com.tencent.mm.cc.a.n(localMPVideoView.getContext(), 2131101179);
    }
    if (this.nOw != ((v.d)localObject).KUO)
    {
      ac.d("MicroMsg.BizVideoPosHelper", "setVideoBackGroundColor lastVideoBackGround=" + this.nOw + ", newBackGroundColor=" + ((v.d)localObject).KUO);
      ap.f((Runnable)new e(this, (v.d)localObject));
    }
    AppMethodBeat.o(175539);
  }
  
  public final void dD(View paramView)
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
    ((ViewGroup.MarginLayoutParams)localObject).height = this.nOl;
    ((ViewGroup.MarginLayoutParams)localObject).width = this.nOm;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = h.la(this.nOj, 0);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = h.la(this.nOk, 0);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(175538);
  }
  
  public final void zp(int paramInt)
  {
    AppMethodBeat.i(175536);
    if (bNB())
    {
      AppMethodBeat.o(175536);
      return;
    }
    this.nOj = this.x;
    if (paramInt >= 0) {}
    for (;;)
    {
      this.nOk = paramInt;
      this.nOl = this.height;
      this.nOm = this.width;
      this.nOq = 0;
      AppMethodBeat.o(175536);
      return;
      paramInt = 0;
    }
  }
  
  public final boolean zq(int paramInt)
  {
    AppMethodBeat.i(175537);
    int j = this.btU;
    if (this.nOr != null)
    {
      MPVideoView localMPVideoView = this.nOr;
      if ((localMPVideoView == null) || (localMPVideoView.isPlaying() != true)) {}
    }
    for (int i = this.nOo;; i = this.nOp)
    {
      paramInt = h.la(j - paramInt, i);
      if (paramInt == this.nOl) {
        break label109;
      }
      this.nOk = 0;
      this.nOl = paramInt;
      this.nOn = paramInt;
      bNC();
      if (bNB()) {
        break;
      }
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
    label109:
    if (this.nOk != 0)
    {
      this.nOk = 0;
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i parami, v.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(175534);
      i locali = this.nOy;
      int i = this.nOB.KUO;
      MPVideoView localMPVideoView = this.nOy.nOr;
      if (localMPVideoView == null) {
        k.fOy();
      }
      locali.a(i, localMPVideoView);
      AppMethodBeat.o(175534);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i
 * JD-Core Version:    0.7.0.1
 */