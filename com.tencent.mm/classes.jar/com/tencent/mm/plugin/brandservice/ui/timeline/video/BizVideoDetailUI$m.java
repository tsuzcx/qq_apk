package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class BizVideoDetailUI$m
  implements MenuItem.OnMenuItemClickListener
{
  BizVideoDetailUI$m(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7101);
    this.pIu.hideVKB();
    BizVideoDetailUI.a(this.pIu);
    AppMethodBeat.o(7101);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.m
 * JD-Core Version:    0.7.0.1
 */