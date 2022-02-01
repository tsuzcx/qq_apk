package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class BizTestCanvasUI$d
  implements MenuItem.OnMenuItemClickListener
{
  BizTestCanvasUI$d(BizTestCanvasUI paramBizTestCanvasUI, BizTestCanvasUI.a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(208641);
    this.ofO.destroy();
    this.ofN.finish();
    AppMethodBeat.o(208641);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTestCanvasUI.d
 * JD-Core Version:    0.7.0.1
 */