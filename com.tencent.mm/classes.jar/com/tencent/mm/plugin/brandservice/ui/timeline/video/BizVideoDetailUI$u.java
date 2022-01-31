package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onShowAd$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
public final class BizVideoDetailUI$u
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(154591);
    Object localObject = BizVideoDetailUI.g(this.kgi);
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      }
    }
    localObject = this.kgi.uQS;
    if (localObject != null) {
      ((d)localObject).aiV("appear");
    }
    localObject = this.kgi.kfX;
    if (localObject != null)
    {
      localObject = ((MMWebViewWithJsApi)localObject).getJsapi();
      if (localObject != null)
      {
        ((d)localObject).aiV("appear");
        AppMethodBeat.o(154591);
        return;
      }
    }
    AppMethodBeat.o(154591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.u
 * JD-Core Version:    0.7.0.1
 */