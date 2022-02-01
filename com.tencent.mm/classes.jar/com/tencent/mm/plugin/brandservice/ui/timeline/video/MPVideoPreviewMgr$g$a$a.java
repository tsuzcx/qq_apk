package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$startPreview$setUI$1$createVideo$1$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
public final class MPVideoPreviewMgr$g$a$a
  implements e.c
{
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dH(String paramString1, String paramString2) {}
  
  public final void dI(String paramString1, String paramString2) {}
  
  public final void dJ(String paramString1, String paramString2) {}
  
  public final void dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195927);
    Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview onVideoPlay");
    paramString1 = MPVideoPreviewMgr.pJz;
    int i;
    if (MPVideoPreviewMgr.cqN())
    {
      paramString1 = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.cqP().pJJ = System.currentTimeMillis();
      paramString1 = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.cqO();
      paramString1 = MPVideoPreviewMgr.pJz;
      paramString1 = MPVideoPreviewMgr.cqQ();
      if (paramString1 == null) {
        break label348;
      }
      paramString1 = (View)paramString1.get();
      paramString1 = ObjectAnimator.ofFloat(paramString1, "alpha", new float[] { 0.0F, 1.0F });
      p.g(paramString1, "it");
      paramString1.setDuration(200L);
      paramString1.start();
      paramString1 = MPVideoPreviewMgr.pJz;
      paramString1 = MPVideoPreviewMgr.cqQ();
      if (paramString1 != null)
      {
        paramString1 = (View)paramString1.get();
        if (paramString1 != null)
        {
          paramString2 = (TextView)paramString1.findViewById(2131306121);
          if (paramString2 != null)
          {
            paramString1 = MPVideoPreviewMgr.pJz;
            MPVideoPreviewMgr.d(new WeakReference(paramString2));
            paramString1 = MPVideoPreviewMgr.pJz;
            paramString1 = MPVideoPreviewMgr.cqS();
            if (paramString1 == null) {
              break label353;
            }
            paramString1 = (AppBrandVideoView)paramString1.get();
            if (paramString1 == null) {
              break label353;
            }
            i = paramString1.getDuration();
            label180:
            paramString1 = m.rJ(i);
            if (paramString1 == null) {
              break label358;
            }
            paramString1 = (CharSequence)paramString1;
            label194:
            paramString2.setText(paramString1);
            paramString1 = MPVideoPreviewMgr.pJz;
            MPVideoPreviewMgr.cqP().setVideoDuration(i);
          }
        }
      }
      paramString1 = MPVideoPreviewMgr.pJz;
      paramString1 = MPVideoPreviewMgr.cqQ();
      if (paramString1 != null)
      {
        paramString1 = (View)paramString1.get();
        if (paramString1 != null)
        {
          paramString2 = (TextView)paramString1.findViewById(2131306122);
          if (paramString2 != null)
          {
            paramString1 = MPVideoPreviewMgr.pJz;
            if (MPVideoPreviewMgr.cqP().akb <= 1) {
              break label367;
            }
            paramString1 = MPVideoPreviewMgr.pJz;
            paramString1 = MPVideoPreviewMgr.cqP().pJA;
            if (paramString1 == null) {
              break label367;
            }
            MPVideoPreviewMgr localMPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
            paramString1 = MPVideoPreviewMgr.v(paramString1);
            if (paramString1 == null) {
              break label367;
            }
          }
        }
      }
    }
    label348:
    label353:
    label358:
    label367:
    for (paramString1 = (CharSequence)paramString1;; paramString1 = (CharSequence)"")
    {
      paramString2.setText(paramString1);
      paramString1 = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.cqP().aiO("PLAY");
      paramString1 = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.cqP().pl(1);
      paramString1 = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.cqP().pl(2);
      paramString1 = MPVideoPreviewMgr.pJz;
      MPVideoPreviewMgr.startTimer();
      AppMethodBeat.o(195927);
      return;
      paramString1 = null;
      break;
      i = 0;
      break label180;
      paramString1 = (CharSequence)"";
      break label194;
    }
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195928);
    paramString1 = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.cqP().pJK = System.currentTimeMillis();
    AppMethodBeat.o(195928);
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195929);
    paramString1 = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.cqP().pJL = System.currentTimeMillis();
    paramString1 = MPVideoPreviewMgr.pJz;
    MPVideoPreviewMgr.cqP().pl(5);
    AppMethodBeat.o(195929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.g.a.a
 * JD-Core Version:    0.7.0.1
 */