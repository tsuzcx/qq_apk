package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
public final class MPVideoView$p
  implements i.b
{
  public final void c(String paramString1, String paramString2, final String paramString3, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7521);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    p.k(paramString3, "errorMsg");
    Log.i(MPVideoView.access$getTAG$cp(), "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    MMHandlerThread.postToMainThread((Runnable)new a(this, paramString3, paramInt1));
    AppMethodBeat.o(7521);
  }
  
  public final void d(String paramString1, String paramString2, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(7524);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    this.sVn.setVideoWidth(paramInt1);
    this.sVn.setVideoHeight(paramInt2);
    MPVideoView.k(this.sVn);
    MMHandlerThread.postToMainThread((Runnable)new b(this, paramInt1, paramInt2));
    AppMethodBeat.o(7524);
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7522);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    Log.i(MPVideoView.access$getTAG$cp(), "onPrepared");
    MMHandlerThread.postToMainThread((Runnable)new c(this));
    AppMethodBeat.o(7522);
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7523);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    Log.i(MPVideoView.access$getTAG$cp(), "onVideoEnded");
    MMHandlerThread.postToMainThread((Runnable)new d(this));
    AppMethodBeat.o(7523);
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7525);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    Log.i(MPVideoView.access$getTAG$cp(), "onVideoPause");
    this.sVn.cEH();
    MPVideoView.k(this.sVn);
    if (this.sVn.getPlayStatus() != 4) {
      this.sVn.setPlayStatus(3);
    }
    paramString1 = MPVideoView.h(this.sVn);
    if (paramString1 == null) {
      p.iCn();
    }
    paramString1 = paramString1.sUc;
    if (paramString1 == null) {
      p.iCn();
    }
    if (paramString1.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      MMHandlerThread.postToMainThreadDelayed((Runnable)new e(this), 1000L);
      AppMethodBeat.o(7525);
      return;
    }
    this.sVn.cEI();
    AppMethodBeat.o(7525);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7526);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    MMHandlerThread.postToMainThread((Runnable)new f(this));
    AppMethodBeat.o(7526);
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7527);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    Log.i(MPVideoView.access$getTAG$cp(), "onVideoWaiting");
    MMHandlerThread.postToMainThread((Runnable)new g(this));
    AppMethodBeat.o(7527);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(7528);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    MMHandlerThread.postToMainThread((Runnable)new h(this));
    AppMethodBeat.o(7528);
  }
  
  public final void fC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(258305);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "mediaId");
    AppMethodBeat.o(258305);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(MPVideoView.p paramp, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(7513);
      this.sVo.sVn.cEH();
      MPVideoView.k(this.sVo.sVn);
      this.sVo.sVn.setPlayStatus(4);
      AppMethodBeat.o(7513);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MPVideoView.p paramp, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(7514);
      int i = MPVideoView.y(this.sVo.sVn);
      Object localObject = MPVideoView.sVm;
      if (i == MPVideoView.cEJ())
      {
        localObject = this.sVo.sVn;
        if (paramInt1 >= paramInt2) {
          break label89;
        }
      }
      label89:
      for (i = 0;; i = 90)
      {
        MPVideoView.b((MPVideoView)localObject, i);
        Log.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(MPVideoView.y(this.sVo.sVn)) });
        AppMethodBeat.o(7514);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MPVideoView.p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(7515);
      if (MPVideoView.k(this.sVo.sVn) != null)
      {
        localObject = MPVideoView.h(this.sVo.sVn);
        if (localObject != null) {
          ((MPExoVideoWrapper)localObject).getFirstRenderTime();
        }
      }
      Object localObject = MPVideoView.s(this.sVo.sVn);
      if (localObject == null) {
        p.iCn();
      }
      ((a)localObject).bWZ();
      AppMethodBeat.o(7515);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MPVideoView.p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(7516);
      this.sVo.sVn.cEH();
      Object localObject = MPVideoView.j(this.sVo.sVn);
      if (localObject == null) {
        p.iCn();
      }
      ((TextView)localObject).setVisibility(8);
      if (MPVideoView.b(this.sVo.sVn))
      {
        localObject = MPVideoView.d(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        ((View)localObject).setVisibility(0);
        localObject = MPVideoView.c(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        if (((MPVideoViewControlBar)localObject).bVd())
        {
          localObject = MPVideoView.c(this.sVo.sVn);
          if (localObject == null) {
            p.iCn();
          }
          ((MPVideoViewControlBar)localObject).hide();
        }
        localObject = MPVideoView.t(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        if (((FrameLayout)localObject).getVisibility() == 0)
        {
          localObject = MPVideoView.t(this.sVo.sVn);
          if (localObject == null) {
            p.iCn();
          }
          ((FrameLayout)localObject).setVisibility(8);
        }
        if ((!MPVideoView.u(this.sVo.sVn)) && (MPVideoView.b(this.sVo.sVn))) {
          break label308;
        }
        localObject = MPVideoView.v(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        ((View)localObject).setVisibility(8);
      }
      for (;;)
      {
        this.sVo.sVn.cEA();
        this.sVo.sVn.setPlayStatus(4);
        MPVideoView.k(this.sVo.sVn);
        AppMethodBeat.o(7516);
        return;
        localObject = MPVideoView.c(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        ((MPVideoViewControlBar)localObject).cEO();
        localObject = MPVideoView.c(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        ((MPVideoViewControlBar)localObject).show();
        break;
        label308:
        if (MPVideoView.w(this.sVo.sVn) <= 0)
        {
          localObject = MPVideoView.x(this.sVo.sVn);
          if (localObject == null) {
            p.iCn();
          }
          MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVo.sVn);
          if (localMPExoVideoWrapper == null) {
            p.iCn();
          }
          ((TextView)localObject).setText((CharSequence)MPVideoView.Hz(localMPExoVideoWrapper.getVideoDurationSec()));
        }
        localObject = MPVideoView.v(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(MPVideoView.p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(7517);
      this.sVo.sVn.cEI();
      AppMethodBeat.o(7517);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(MPVideoView.p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(7518);
      Log.i(MPVideoView.access$getTAG$cp(), "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(MPVideoView.u(this.sVo.sVn)) });
      MPVideoView.z(this.sVo.sVn);
      this.sVo.sVn.cEB();
      MPVideoView.k(this.sVo.sVn);
      if ((MPVideoView.w(this.sVo.sVn) <= 0) && (!MPVideoView.u(this.sVo.sVn)))
      {
        localObject = MPVideoView.x(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        MPExoVideoWrapper localMPExoVideoWrapper = MPVideoView.h(this.sVo.sVn);
        if (localMPExoVideoWrapper == null) {
          p.iCn();
        }
        ((TextView)localObject).setText((CharSequence)MPVideoView.Hz(localMPExoVideoWrapper.getVideoDurationSec()));
      }
      MPVideoView.b(this.sVo.sVn, MPVideoView.u(this.sVo.sVn));
      if (MPVideoView.a(this.sVo.sVn)) {
        MPVideoView.A(this.sVo.sVn);
      }
      MPVideoView.m(this.sVo.sVn);
      this.sVo.sVn.setPlayStatus(2);
      Object localObject = MPVideoView.c(this.sVo.sVn);
      if (localObject == null) {
        p.iCn();
      }
      if (((MPVideoViewControlBar)localObject).bVd())
      {
        localObject = MPVideoView.c(this.sVo.sVn);
        if (localObject == null) {
          p.iCn();
        }
        ((MPVideoViewControlBar)localObject).bVi();
      }
      AppMethodBeat.o(7518);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(MPVideoView.p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(7519);
      MPVideoView.a(this.sVo.sVn, true);
      MPVideoView.f(this.sVo.sVn);
      MPVideoView.k(this.sVo.sVn);
      AppMethodBeat.o(7519);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(MPVideoView.p paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(7520);
      MPVideoView.a(this.sVo.sVn, false);
      MPVideoView.l(this.sVo.sVn);
      MPVideoView.k(this.sVo.sVn);
      AppMethodBeat.o(7520);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.p
 * JD-Core Version:    0.7.0.1
 */