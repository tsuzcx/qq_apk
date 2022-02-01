package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/view/MenuItem;", "onAttach"})
final class e$g
  implements q.c
{
  public static final g qmy;
  
  static
  {
    AppMethodBeat.i(277370);
    qmy = new g();
    AppMethodBeat.o(277370);
  }
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277369);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach, menuItem: ".concat(String.valueOf(paramMenuItem)));
    p.j(paramMenuItem, "menuItem");
    ContextMenu.ContextMenuInfo localContextMenuInfo = paramMenuItem.getMenuInfo();
    paramMenuItem = localContextMenuInfo;
    if (!(localContextMenuInfo instanceof n)) {
      paramMenuItem = null;
    }
    paramMenuItem = (n)paramMenuItem;
    if (paramMenuItem == null)
    {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach, menuInfo is not RawFunctionName2Show");
      AppMethodBeat.o(277369);
      return;
    }
    p.j(paramTextView, "textView");
    if (!paramMenuItem.qmW)
    {
      paramTextView.setText((CharSequence)paramMenuItem.qmT);
      AppMethodBeat.o(277369);
      return;
    }
    paramTextView.post((Runnable)new g.a(paramTextView, paramMenuItem));
    AppMethodBeat.o(277369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.g
 * JD-Core Version:    0.7.0.1
 */