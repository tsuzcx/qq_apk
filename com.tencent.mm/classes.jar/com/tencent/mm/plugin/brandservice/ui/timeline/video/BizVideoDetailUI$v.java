package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.af.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onStart$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-brandservice_release"})
public final class BizVideoDetailUI$v
  implements e.b
{
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(15168);
    Object localObject = BizVideoDetailUI.r(this.kgi);
    if (localObject != null)
    {
      localObject = ((MMWebView)localObject).getSettings();
      if (localObject != null) {
        ((t)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
      }
    }
    if (this.kgi.kge)
    {
      this.kgi.kge = false;
      this.kgi.aZv();
    }
    if (this.kgi.kfZ)
    {
      this.kgi.kfZ = false;
      BizVideoDetailUI.b(this.kgi, false);
    }
    if (!BizVideoDetailUI.e(this.kgi).isPlaying()) {
      BizVideoDetailUI.e(this.kgi).a(BizVideoDetailUI.s(this.kgi).fjD.fjJ, this.kgi.iiW, this.kgi.videoHeight, BizVideoDetailUI.s(this.kgi));
    }
    AppMethodBeat.o(15168);
  }
  
  public final void onAnimationStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.v
 * JD-Core Version:    0.7.0.1
 */