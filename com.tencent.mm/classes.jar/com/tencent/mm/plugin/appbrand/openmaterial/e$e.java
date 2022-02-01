package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.c;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/view/MenuItem;", "onAttach"})
final class e$e
  implements o.c
{
  public static final e nkW;
  
  static
  {
    AppMethodBeat.i(229108);
    nkW = new e();
    AppMethodBeat.o(229108);
  }
  
  public final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(229107);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach, menuItem: ".concat(String.valueOf(paramMenuItem)));
    p.g(paramMenuItem, "menuItem");
    ContextMenu.ContextMenuInfo localContextMenuInfo = paramMenuItem.getMenuInfo();
    paramMenuItem = localContextMenuInfo;
    if (!(localContextMenuInfo instanceof l)) {
      paramMenuItem = null;
    }
    paramMenuItem = (l)paramMenuItem;
    if (paramMenuItem == null)
    {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach, menuInfo is not RawFunctionName2Show");
      AppMethodBeat.o(229107);
      return;
    }
    p.g(paramTextView, "textView");
    if (!paramMenuItem.nlm)
    {
      paramTextView.setText((CharSequence)paramMenuItem.nll);
      AppMethodBeat.o(229107);
      return;
    }
    paramTextView.post((Runnable)new f.a(paramTextView, paramMenuItem));
    AppMethodBeat.o(229107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.e
 * JD-Core Version:    0.7.0.1
 */