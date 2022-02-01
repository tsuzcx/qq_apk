package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
public final class BizVideoDetailUI$k
  extends b
{
  public final void Na()
  {
    AppMethodBeat.i(7099);
    BizVideoDetailUI.a(this.pIu, false);
    if (BizVideoDetailUI.f(this.pIu).getParent() == null) {
      BizVideoDetailUI.e(this.pIu).addView((View)BizVideoDetailUI.f(this.pIu), 0);
    }
    AppMethodBeat.o(7099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.k
 * JD-Core Version:    0.7.0.1
 */