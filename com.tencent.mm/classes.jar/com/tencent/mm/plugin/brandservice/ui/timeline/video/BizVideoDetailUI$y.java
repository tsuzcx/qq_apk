package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.f;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class BizVideoDetailUI$y
  implements View.OnClickListener
{
  BizVideoDetailUI$y(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152839);
    BizVideoDetailUI.t(this.kgi);
    BizVideoDetailUI.e(this.kgi).start();
    paramView = BizVideoDetailUI.j(this.kgi);
    as localas = as.eu("brandService", 2);
    if (localas != null)
    {
      localas.encode("BizVideoLastPlayTimestamp", System.currentTimeMillis() / 1000L);
      localas.encode("BizVideoLastPlayFileSize", paramView.kfu);
    }
    com.tencent.mm.plugin.webview.ui.tools.b.Ko(17);
    BizVideoDetailUI.j(this.kgi).kfB.dN(15, 0);
    BizVideoDetailUI.j(this.kgi).kfz = 0;
    AppMethodBeat.o(152839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.y
 * JD-Core Version:    0.7.0.1
 */