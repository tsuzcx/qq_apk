package com.tencent.mm.plugin.brandservice.ui.widget;

import a.f.b.j;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.sdk.platformtools.ab;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initVideoViewCallback$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
public final class MPVideoView$n
  implements d.b
{
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153033);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    j.q(paramString3, "errorMsg");
    ab.i(MPVideoView.access$getTAG$cp(), "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    MPVideoView.s(this.kjR);
    paramString1 = MPVideoView.m(this.kjR);
    if (paramString1 != null) {
      paramString1.Hs(paramString3);
    }
    this.kjR.setPlayStatus(4);
    AppMethodBeat.o(153033);
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153034);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    ab.i(MPVideoView.access$getTAG$cp(), "onPrepared");
    paramString1 = MPVideoView.t(this.kjR);
    if (paramString1 == null) {
      j.ebi();
    }
    paramString1.aFG();
    AppMethodBeat.o(153034);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153035);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    ab.i(MPVideoView.access$getTAG$cp(), "onVideoEnded");
    MPVideoView.s(this.kjR);
    paramString1 = MPVideoView.k(this.kjR);
    if (paramString1 == null) {
      j.ebi();
    }
    paramString1.setVisibility(8);
    if (MPVideoView.c(this.kjR))
    {
      paramString1 = MPVideoView.e(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      paramString1.setVisibility(0);
      paramString1 = MPVideoView.d(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      if (paramString1.Pk())
      {
        paramString1 = MPVideoView.d(this.kjR);
        if (paramString1 == null) {
          j.ebi();
        }
        paramString1.hide();
      }
      paramString1 = MPVideoView.u(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      if (paramString1.getVisibility() == 0)
      {
        paramString1 = MPVideoView.u(this.kjR);
        if (paramString1 == null) {
          j.ebi();
        }
        paramString1.setVisibility(8);
      }
      if ((!MPVideoView.v(this.kjR)) && (MPVideoView.c(this.kjR))) {
        break label300;
      }
      paramString1 = MPVideoView.w(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      paramString1.setVisibility(8);
      label208:
      if (!MPVideoView.z(this.kjR)) {
        break label377;
      }
      this.kjR.e(0.0D, true);
    }
    for (;;)
    {
      this.kjR.setPlayStatus(4);
      paramString1 = MPVideoView.m(this.kjR);
      if (paramString1 == null) {
        break label389;
      }
      paramString1.xT();
      AppMethodBeat.o(153035);
      return;
      paramString1 = MPVideoView.d(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      paramString1.baj();
      paramString1 = MPVideoView.d(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      paramString1.show();
      break;
      label300:
      if (MPVideoView.x(this.kjR) <= 0)
      {
        paramString1 = MPVideoView.y(this.kjR);
        if (paramString1 == null) {
          j.ebi();
        }
        paramString2 = MPVideoView.i(this.kjR);
        if (paramString2 == null) {
          j.ebi();
        }
        paramString1.setText((CharSequence)MPVideoView.sQ(paramString2.getVideoDurationSec()));
      }
      paramString1 = MPVideoView.w(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      paramString1.setVisibility(0);
      break label208;
      label377:
      this.kjR.e(0.0D, false);
    }
    label389:
    AppMethodBeat.o(153035);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153037);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    ab.i(MPVideoView.access$getTAG$cp(), "onVideoPause");
    paramString1 = MPVideoView.m(this.kjR);
    if (paramString1 != null) {
      paramString1.onVideoPause();
    }
    this.kjR.setPlayStatus(3);
    MPVideoView.s(this.kjR);
    AppMethodBeat.o(153037);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153038);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    ab.i(MPVideoView.access$getTAG$cp(), "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(MPVideoView.v(this.kjR)) });
    MPVideoView.B(this.kjR);
    this.kjR.bah();
    paramString1 = MPVideoView.m(this.kjR);
    if (paramString1 != null) {
      paramString1.onVideoPlay();
    }
    if ((MPVideoView.x(this.kjR) <= 0) && (!MPVideoView.v(this.kjR)))
    {
      paramString1 = MPVideoView.y(this.kjR);
      if (paramString1 == null) {
        j.ebi();
      }
      paramString2 = MPVideoView.i(this.kjR);
      if (paramString2 == null) {
        j.ebi();
      }
      paramString1.setText((CharSequence)MPVideoView.sQ(paramString2.getVideoDurationSec()));
    }
    MPVideoView.b(this.kjR, MPVideoView.v(this.kjR));
    if (MPVideoView.b(this.kjR)) {
      MPVideoView.C(this.kjR);
    }
    MPVideoView.D(this.kjR);
    this.kjR.setPlayStatus(2);
    AppMethodBeat.o(153038);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153039);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    ab.i(MPVideoView.access$getTAG$cp(), "onVideoWaiting");
    MPVideoView.a(this.kjR, true);
    MPVideoView.g(this.kjR);
    paramString1 = MPVideoView.m(this.kjR);
    if (paramString1 != null)
    {
      paramString1.onVideoWaiting();
      AppMethodBeat.o(153039);
      return;
    }
    AppMethodBeat.o(153039);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(153040);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    MPVideoView.a(this.kjR, false);
    MPVideoView.l(this.kjR);
    paramString1 = MPVideoView.m(this.kjR);
    if (paramString1 != null)
    {
      paramString1.aZF();
      AppMethodBeat.o(153040);
      return;
    }
    AppMethodBeat.o(153040);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153036);
    j.q(paramString1, "sessionId");
    j.q(paramString2, "mediaId");
    ab.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i = MPVideoView.A(this.kjR);
    paramString1 = MPVideoView.kjQ;
    if (i == MPVideoView.bai())
    {
      paramString1 = this.kjR;
      if (paramInt1 >= paramInt2) {
        break label118;
      }
    }
    label118:
    for (paramInt1 = 0;; paramInt1 = 90)
    {
      MPVideoView.a(paramString1, paramInt1);
      ab.i(MPVideoView.access$getTAG$cp(), "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(MPVideoView.A(this.kjR)) });
      AppMethodBeat.o(153036);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.n
 * JD-Core Version:    0.7.0.1
 */