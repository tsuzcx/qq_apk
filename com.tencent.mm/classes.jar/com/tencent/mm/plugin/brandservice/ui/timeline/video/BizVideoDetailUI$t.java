package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class BizVideoDetailUI$t
  implements View.OnClickListener
{
  BizVideoDetailUI$t(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152835);
    if (BizVideoDetailUI.e(this.kgi).isPlaying())
    {
      BizVideoDetailUI.e(this.kgi).pause();
      AppMethodBeat.o(152835);
      return;
    }
    BizVideoDetailUI.e(this.kgi).start();
    AppMethodBeat.o(152835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.t
 * JD-Core Version:    0.7.0.1
 */