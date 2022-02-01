package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<no name provided>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class MPVideoPreviewMgr$e$a
  extends u
  implements a<ah>
{
  MPVideoPreviewMgr$e$a(Context paramContext, ah.f<AppBrandVideoView> paramf)
  {
    super(0);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$startPreview$setUI$1$createVideo$1$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d.c
  {
    public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
    
    public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
    
    public final void el(String paramString1, String paramString2) {}
    
    public final void em(String paramString1, String paramString2) {}
    
    public final void en(String paramString1, String paramString2) {}
    
    public final void eo(String paramString1, String paramString2)
    {
      paramString2 = null;
      int i = 0;
      AppMethodBeat.i(302092);
      Log.i("MicroMsg.MPVideoPreviewMgr", "startPreview onVideoPlay");
      Object localObject;
      if (MPVideoPreviewMgr.dhH())
      {
        MPVideoPreviewMgr.dhI().vXS = System.currentTimeMillis();
        paramString1 = MPVideoPreviewMgr.vXs;
        MPVideoPreviewMgr.dhJ();
        paramString1 = MPVideoPreviewMgr.dhK();
        if (paramString1 != null) {
          break label250;
        }
        paramString1 = null;
        paramString1 = ObjectAnimator.ofFloat(paramString1, "alpha", new float[] { 0.0F, 1.0F });
        paramString1.setDuration(200L);
        paramString1.start();
        paramString1 = MPVideoPreviewMgr.dhK();
        if (paramString1 != null)
        {
          paramString1 = (View)paramString1.get();
          if (paramString1 != null)
          {
            localObject = (TextView)paramString1.findViewById(d.e.preview_time);
            if (localObject != null)
            {
              paramString1 = MPVideoPreviewMgr.vXs;
              MPVideoPreviewMgr.d(new WeakReference(localObject));
              paramString1 = MPVideoPreviewMgr.dhL();
              if (paramString1 != null) {
                break label261;
              }
              label139:
              paramString1 = m.uD(i);
              if (paramString1 != null) {
                break label281;
              }
              paramString1 = (CharSequence)"";
              label154:
              ((TextView)localObject).setText(paramString1);
              MPVideoPreviewMgr.dhI().setVideoDuration(i);
            }
          }
        }
        paramString1 = MPVideoPreviewMgr.dhK();
        if (paramString1 != null) {
          break label289;
        }
        paramString1 = paramString2;
        label177:
        if (paramString1 != null)
        {
          if (MPVideoPreviewMgr.dhI().bUo <= 1) {
            break label333;
          }
          paramString2 = MPVideoPreviewMgr.dhI().vXJ;
          if (paramString2 != null) {
            break label320;
          }
          paramString2 = "";
        }
      }
      label205:
      for (paramString2 = (CharSequence)paramString2;; paramString2 = (CharSequence)"")
      {
        paramString1.setText(paramString2);
        MPVideoPreviewMgr.dhI().ajZ("PLAY");
        MPVideoPreviewMgr.dhI().rG(1);
        MPVideoPreviewMgr.dhI().rG(2);
        paramString1 = MPVideoPreviewMgr.vXs;
        MPVideoPreviewMgr.startTimer();
        AppMethodBeat.o(302092);
        return;
        label250:
        paramString1 = (View)paramString1.get();
        break;
        paramString1 = (AppBrandVideoView)paramString1.get();
        if (paramString1 == null) {
          break label139;
        }
        i = paramString1.getDuration();
        break label139;
        paramString1 = (CharSequence)paramString1;
        break label154;
        localObject = (View)paramString1.get();
        paramString1 = paramString2;
        if (localObject == null) {
          break label177;
        }
        paramString1 = (TextView)((View)localObject).findViewById(d.e.preview_title);
        break label177;
        localObject = MPVideoPreviewMgr.vXs;
        paramString2 = MPVideoPreviewMgr.s(paramString2);
        break label205;
      }
    }
    
    public final void ep(String paramString1, String paramString2)
    {
      AppMethodBeat.i(302099);
      MPVideoPreviewMgr.dhI().vXT = System.currentTimeMillis();
      AppMethodBeat.o(302099);
    }
    
    public final void eq(String paramString1, String paramString2)
    {
      AppMethodBeat.i(302105);
      MPVideoPreviewMgr.dhI().vXU = System.currentTimeMillis();
      MPVideoPreviewMgr.dhI().rG(5);
      AppMethodBeat.o(302105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.e.a
 * JD-Core Version:    0.7.0.1
 */