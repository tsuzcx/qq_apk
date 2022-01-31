package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
public final class BizVideoDetailUI$k
  extends b
{
  public final void aDk()
  {
    AppMethodBeat.i(15152);
    BizVideoDetailUI.a(this.kgi, false);
    if (BizVideoDetailUI.e(this.kgi).getParent() == null) {
      BizVideoDetailUI.d(this.kgi).addView((View)BizVideoDetailUI.e(this.kgi), 0);
    }
    AppMethodBeat.o(15152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.k
 * JD-Core Version:    0.7.0.1
 */