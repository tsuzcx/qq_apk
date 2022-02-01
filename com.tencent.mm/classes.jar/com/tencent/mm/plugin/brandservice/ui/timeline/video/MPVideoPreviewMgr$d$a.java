package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "invoke"})
final class MPVideoPreviewMgr$d$a
  extends q
  implements a<z>
{
  MPVideoPreviewMgr$d$a(Context paramContext, y.f paramf)
  {
    super(0);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoPreviewMgr$addPreview$setUI$1$createVideo$1$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IMMVideoView$IMMVideoViewCallback;", "onError", "", "sessionId", "", "mediaId", "errorMsg", "what", "", "extra", "onGetVideoSize", "width", "height", "onPrepared", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "plugin-brandservice_release"})
  public static final class a
    implements e.c
  {
    public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {}
    
    public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209116);
      AppMethodBeat.o(209116);
    }
    
    public final void ds(String paramString1, String paramString2) {}
    
    public final void dt(String paramString1, String paramString2) {}
    
    public final void du(String paramString1, String paramString2) {}
    
    public final void dv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(209117);
      ae.i("MicroMsg.MPVideoPreviewMgr", "addPreview onVideoPlay");
      paramString1 = MPVideoPreviewMgr.ovZ;
      int i;
      if (MPVideoPreviewMgr.bTe())
      {
        paramString1 = MPVideoPreviewMgr.ovZ;
        MPVideoPreviewMgr.bTg().owg = System.currentTimeMillis();
        paramString1 = MPVideoPreviewMgr.ovZ;
        MPVideoPreviewMgr.bTf();
        paramString1 = MPVideoPreviewMgr.ovZ;
        paramString1 = MPVideoPreviewMgr.bTh();
        if (paramString1 == null) {
          break label343;
        }
        paramString1 = (View)paramString1.get();
        paramString1 = ObjectAnimator.ofFloat(paramString1, "alpha", new float[] { 0.0F, 1.0F });
        p.g(paramString1, "it");
        paramString1.setDuration(200L);
        paramString1.start();
        paramString1 = MPVideoPreviewMgr.ovZ;
        paramString1 = MPVideoPreviewMgr.bTh();
        if (paramString1 != null)
        {
          paramString1 = (View)paramString1.get();
          if (paramString1 != null)
          {
            paramString2 = (TextView)paramString1.findViewById(2131308510);
            if (paramString2 != null)
            {
              paramString1 = MPVideoPreviewMgr.ovZ;
              MPVideoPreviewMgr.k(new WeakReference(paramString2));
              paramString1 = MPVideoPreviewMgr.ovZ;
              paramString1 = MPVideoPreviewMgr.bTd();
              if (paramString1 == null) {
                break label348;
              }
              paramString1 = (AppBrandVideoView)paramString1.get();
              if (paramString1 == null) {
                break label348;
              }
              i = paramString1.getDuration();
              label180:
              paramString1 = m.ol(i);
              if (paramString1 == null) {
                break label353;
              }
              paramString1 = (CharSequence)paramString1;
              label194:
              paramString2.setText(paramString1);
              paramString1 = MPVideoPreviewMgr.ovZ;
              MPVideoPreviewMgr.bTg().Ae(i);
            }
          }
        }
        paramString1 = MPVideoPreviewMgr.ovZ;
        paramString1 = MPVideoPreviewMgr.bTh();
        if (paramString1 != null)
        {
          paramString1 = (View)paramString1.get();
          if (paramString1 != null)
          {
            paramString2 = (TextView)paramString1.findViewById(2131308511);
            if (paramString2 != null)
            {
              paramString1 = MPVideoPreviewMgr.ovZ;
              if (MPVideoPreviewMgr.bTg().ajO <= 1) {
                break label362;
              }
              paramString1 = MPVideoPreviewMgr.ovZ;
              paramString1 = MPVideoPreviewMgr.bTg().hFY;
              if (paramString1 == null) {
                break label362;
              }
              paramString1 = paramString1.title;
              if (paramString1 == null) {
                break label362;
              }
            }
          }
        }
      }
      label343:
      label348:
      label353:
      label362:
      for (paramString1 = (CharSequence)paramString1;; paramString1 = (CharSequence)"")
      {
        paramString2.setText(paramString1);
        paramString1 = MPVideoPreviewMgr.ovZ;
        MPVideoPreviewMgr.bTg().aJg("PLAY");
        paramString1 = MPVideoPreviewMgr.ovZ;
        MPVideoPreviewMgr.bTg().md(1);
        paramString1 = MPVideoPreviewMgr.ovZ;
        MPVideoPreviewMgr.bTg().md(2);
        paramString1 = MPVideoPreviewMgr.ovZ;
        MPVideoPreviewMgr.startTimer();
        AppMethodBeat.o(209117);
        return;
        paramString1 = null;
        break;
        i = 0;
        break label180;
        paramString1 = (CharSequence)"";
        break label194;
      }
    }
    
    public final void dw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(209118);
      paramString1 = MPVideoPreviewMgr.ovZ;
      MPVideoPreviewMgr.bTg().owh = System.currentTimeMillis();
      AppMethodBeat.o(209118);
    }
    
    public final void dx(String paramString1, String paramString2)
    {
      AppMethodBeat.i(209119);
      paramString1 = MPVideoPreviewMgr.ovZ;
      MPVideoPreviewMgr.bTg().owi = System.currentTimeMillis();
      paramString1 = MPVideoPreviewMgr.ovZ;
      MPVideoPreviewMgr.bTg().md(5);
      AppMethodBeat.o(209119);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.d.a
 * JD-Core Version:    0.7.0.1
 */