package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$startPreview$setUI$1$createVideo$1$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr$g$a$a
  implements d.c
{
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dS(String paramString1, String paramString2) {}
  
  public final void dT(String paramString1, String paramString2) {}
  
  public final void dU(String paramString1, String paramString2) {}
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265670);
    Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview onVideoPlay");
    paramString1 = MPVideoPreviewMgr.sSn;
    int i;
    if (MPVideoPreviewMgr.cEd())
    {
      paramString1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.cEf().sSx = System.currentTimeMillis();
      paramString1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.cEe();
      paramString1 = MPVideoPreviewMgr.sSn;
      paramString1 = MPVideoPreviewMgr.cEg();
      if (paramString1 == null) {
        break label350;
      }
      paramString1 = (View)paramString1.get();
      paramString1 = ObjectAnimator.ofFloat(paramString1, "alpha", new float[] { 0.0F, 1.0F });
      p.j(paramString1, "it");
      paramString1.setDuration(200L);
      paramString1.start();
      paramString1 = MPVideoPreviewMgr.sSn;
      paramString1 = MPVideoPreviewMgr.cEg();
      if (paramString1 != null)
      {
        paramString1 = (View)paramString1.get();
        if (paramString1 != null)
        {
          paramString2 = (TextView)paramString1.findViewById(d.e.ssx);
          if (paramString2 != null)
          {
            paramString1 = MPVideoPreviewMgr.sSn;
            MPVideoPreviewMgr.d(new WeakReference(paramString2));
            paramString1 = MPVideoPreviewMgr.sSn;
            paramString1 = MPVideoPreviewMgr.cEi();
            if (paramString1 == null) {
              break label355;
            }
            paramString1 = (AppBrandVideoView)paramString1.get();
            if (paramString1 == null) {
              break label355;
            }
            i = paramString1.getDuration();
            label181:
            paramString1 = m.uD(i);
            if (paramString1 == null) {
              break label360;
            }
            paramString1 = (CharSequence)paramString1;
            label195:
            paramString2.setText(paramString1);
            paramString1 = MPVideoPreviewMgr.sSn;
            MPVideoPreviewMgr.cEf().setVideoDuration(i);
          }
        }
      }
      paramString1 = MPVideoPreviewMgr.sSn;
      paramString1 = MPVideoPreviewMgr.cEg();
      if (paramString1 != null)
      {
        paramString1 = (View)paramString1.get();
        if (paramString1 != null)
        {
          paramString2 = (TextView)paramString1.findViewById(d.e.ssy);
          if (paramString2 != null)
          {
            paramString1 = MPVideoPreviewMgr.sSn;
            if (MPVideoPreviewMgr.cEf().afI <= 1) {
              break label369;
            }
            paramString1 = MPVideoPreviewMgr.sSn;
            paramString1 = MPVideoPreviewMgr.cEf().sSo;
            if (paramString1 == null) {
              break label369;
            }
            MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.sSn;
            paramString1 = MPVideoPreviewMgr.v(paramString1);
            if (paramString1 == null) {
              break label369;
            }
          }
        }
      }
    }
    label350:
    label355:
    label360:
    label369:
    for (paramString1 = (CharSequence)paramString1;; paramString1 = (CharSequence)"")
    {
      paramString2.setText(paramString1);
      paramString1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.cEf().aqA("PLAY");
      paramString1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.cEf().rE(1);
      paramString1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.cEf().rE(2);
      paramString1 = MPVideoPreviewMgr.sSn;
      MPVideoPreviewMgr.startTimer();
      AppMethodBeat.o(265670);
      return;
      paramString1 = null;
      break;
      i = 0;
      break label181;
      paramString1 = (CharSequence)"";
      break label195;
    }
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265671);
    paramString1 = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.cEf().sSy = System.currentTimeMillis();
    AppMethodBeat.o(265671);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(265673);
    paramString1 = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.cEf().sSz = System.currentTimeMillis();
    paramString1 = MPVideoPreviewMgr.sSn;
    MPVideoPreviewMgr.cEf().rE(5);
    AppMethodBeat.o(265673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.g.a.a
 * JD-Core Version:    0.7.0.1
 */