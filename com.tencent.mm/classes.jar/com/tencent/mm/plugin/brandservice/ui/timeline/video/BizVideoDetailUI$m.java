package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class BizVideoDetailUI$m
  implements MenuItem.OnMenuItemClickListener
{
  BizVideoDetailUI$m(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(15155);
    this.kgi.hideVKB();
    this.kgi.finish();
    AppMethodBeat.o(15155);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.m
 * JD-Core Version:    0.7.0.1
 */