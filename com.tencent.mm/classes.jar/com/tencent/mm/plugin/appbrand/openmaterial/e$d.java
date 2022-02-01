package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.g;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
final class e$d
  implements o.g
{
  public static final d nkV;
  
  static
  {
    AppMethodBeat.i(229106);
    nkV = new d();
    AppMethodBeat.o(229106);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(229105);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem: " + paramMenuItem + ", i: " + paramInt);
    if ((paramMenuItem instanceof n))
    {
      ((n)paramMenuItem).performClick();
      AppMethodBeat.o(229105);
      return;
    }
    Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem is not MMMenuItem");
    AppMethodBeat.o(229105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.d
 * JD-Core Version:    0.7.0.1
 */