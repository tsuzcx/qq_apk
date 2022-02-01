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
import d.g.b.p;
import d.g.b.y.d;
import d.k.h;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoPosHelper;", "", "()V", "currentMaxVideoHeight", "", "getCurrentMaxVideoHeight", "()I", "setCurrentMaxVideoHeight", "(I)V", "currentVideoHeight", "getCurrentVideoHeight", "setCurrentVideoHeight", "currentVideoWidth", "getCurrentVideoWidth", "setCurrentVideoWidth", "currentX", "getCurrentX", "setCurrentX", "currentY", "getCurrentY", "setCurrentY", "height", "getHeight", "setHeight", "lastVideoBackGround", "getLastVideoBackGround", "setLastVideoBackGround", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "minEdgeGap", "getMinEdgeGap", "setMinEdgeGap", "minVideoHeightWhenPause", "getMinVideoHeightWhenPause", "setMinVideoHeightWhenPause", "minVideoHeightWhenPlay", "getMinVideoHeightWhenPlay", "setMinVideoHeightWhenPlay", "newY", "getNewY", "setNewY", "positionState", "getPositionState", "setPositionState", "reportParams", "", "getReportParams", "()Ljava/lang/String;", "setReportParams", "(Ljava/lang/String;)V", "screenWidth", "getScreenWidth", "setScreenWidth", "va", "Landroid/animation/ValueAnimator;", "getVa", "()Landroid/animation/ValueAnimator;", "setVa", "(Landroid/animation/ValueAnimator;)V", "videoVideo", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoVideo", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "setVideoVideo", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "doVideoZoomAnimation", "", "zoomIn", "", "onUpdateView", "Lkotlin/Function0;", "heightZoomScroll", "absY", "init", "context", "Landroid/content/Context;", "params", "", "density", "", "isZooming", "normalScroll", "onGetVideoSize", "onWebViewScrollChanged", "scrollY", "resetPositionState", "setVideoBackGroundColor", "color", "switchPlayStatus", "updatePositionByWidth", "currentWidth", "updateVideoPosition", "view", "Landroid/view/View;", "Companion", "plugin-brandservice_release"})
public final class i
{
  public static final i.a ord;
  public int bEk;
  public int height;
  public int ltA;
  public int oqP;
  public int oqQ;
  public int oqR;
  public int oqS;
  public int oqT;
  public int oqU;
  public int oqV;
  public int oqW;
  public MPVideoView oqX;
  private int oqY;
  public String oqZ;
  public int ora;
  public ValueAnimator orb;
  private int orc;
  public int width;
  public int x;
  public int y;
  
  static
  {
    AppMethodBeat.i(175542);
    ord = new i.a((byte)0);
    AppMethodBeat.o(175542);
  }
  
  public i()
  {
    AppMethodBeat.i(175541);
    this.oqY = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 4);
    this.orc = -16777216;
    AppMethodBeat.o(175541);
  }
  
  public final void a(int paramInt, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(175540);
    p.h(paramMPVideoView, "videoVideo");
    paramMPVideoView.setBackgroundColor(paramInt);
    this.orc = paramInt;
    AppMethodBeat.o(175540);
  }
  
  public final void b(final boolean paramBoolean, final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(175535);
    ad.v("MicroMsg.BizVideoPosHelper", "doVideoZoomAnimation zoomIn=".concat(String.valueOf(paramBoolean)));
    ValueAnimator localValueAnimator = this.orb;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    if (paramBoolean) {}
    for (localValueAnimator = ValueAnimator.ofInt(new int[] { this.width, this.ltA });; localValueAnimator = ValueAnimator.ofInt(new int[] { this.ltA, this.width }))
    {
      this.orb = localValueAnimator;
      this.oqT = this.bEk;
      localValueAnimator = this.orb;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this, paramBoolean, parama));
      }
      parama = this.orb;
      if (parama != null) {
        parama.setDuration(200L);
      }
      parama = this.orb;
      if (parama == null) {
        break;
      }
      parama.start();
      AppMethodBeat.o(175535);
      return;
    }
    AppMethodBeat.o(175535);
  }
  
  public final boolean bSb()
  {
    return (this.oqW == 1) || (this.oqW == 2);
  }
  
  public final void bSc()
  {
    AppMethodBeat.i(175539);
    if (this.oqX != null)
    {
      localObject = this.oqX;
      if ((localObject == null) || (((MPVideoView)localObject).getVideoWidth() != 0))
      {
        localObject = this.oqX;
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
    ((y.d)localObject).MLT = -16777216;
    double d = this.oqR;
    MPVideoView localMPVideoView = this.oqX;
    if (localMPVideoView == null) {
      p.gfZ();
    }
    d = d * 1.0D / localMPVideoView.getVideoHeight();
    localMPVideoView = this.oqX;
    if (localMPVideoView == null) {
      p.gfZ();
    }
    if (Math.abs(d * localMPVideoView.getVideoWidth() - this.oqS) < this.oqY)
    {
      localMPVideoView = this.oqX;
      if (localMPVideoView == null) {
        p.gfZ();
      }
      ((y.d)localObject).MLT = com.tencent.mm.cc.a.n(localMPVideoView.getContext(), 2131101179);
    }
    if (this.orc != ((y.d)localObject).MLT)
    {
      ad.d("MicroMsg.BizVideoPosHelper", "setVideoBackGroundColor lastVideoBackGround=" + this.orc + ", newBackGroundColor=" + ((y.d)localObject).MLT);
      aq.f((Runnable)new e(this, (y.d)localObject));
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
    ((ViewGroup.MarginLayoutParams)localObject).height = this.oqR;
    ((ViewGroup.MarginLayoutParams)localObject).width = this.oqS;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = h.lp(this.oqP, 0);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = h.lp(this.oqQ, 0);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(175538);
  }
  
  public final void zY(int paramInt)
  {
    AppMethodBeat.i(175536);
    if (bSb())
    {
      AppMethodBeat.o(175536);
      return;
    }
    this.oqP = this.x;
    if (paramInt >= 0) {}
    for (;;)
    {
      this.oqQ = paramInt;
      this.oqR = this.height;
      this.oqS = this.width;
      this.oqW = 0;
      AppMethodBeat.o(175536);
      return;
      paramInt = 0;
    }
  }
  
  public final boolean zZ(int paramInt)
  {
    AppMethodBeat.i(175537);
    int j = this.bEk;
    if (this.oqX != null)
    {
      MPVideoView localMPVideoView = this.oqX;
      if ((localMPVideoView == null) || (localMPVideoView.isPlaying() != true)) {}
    }
    for (int i = this.oqU;; i = this.oqV)
    {
      paramInt = h.lp(j - paramInt, i);
      if (paramInt == this.oqR) {
        break label109;
      }
      this.oqQ = 0;
      this.oqR = paramInt;
      this.oqT = paramInt;
      bSc();
      if (bSb()) {
        break;
      }
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
    label109:
    if (this.oqQ != 0)
    {
      this.oqQ = 0;
      AppMethodBeat.o(175537);
      return true;
    }
    AppMethodBeat.o(175537);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(i parami, boolean paramBoolean, d.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(175531);
      i locali = this.ore;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(i parami, y.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(175534);
      i locali = this.ore;
      int i = this.orh.MLT;
      MPVideoView localMPVideoView = this.ore.oqX;
      if (localMPVideoView == null) {
        p.gfZ();
      }
      locali.a(i, localMPVideoView);
      AppMethodBeat.o(175534);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  public static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    public f(i parami, d.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(210115);
      i locali = this.ore;
      p.g(paramValueAnimator, "valueAnimator");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(210115);
        throw paramValueAnimator;
      }
      locali.oqR = ((Integer)paramValueAnimator).intValue();
      if (this.ore.oqR == this.ore.oqU) {
        i.a(this.ore);
      }
      this.org.invoke();
      AppMethodBeat.o(210115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i
 * JD-Core Version:    0.7.0.1
 */