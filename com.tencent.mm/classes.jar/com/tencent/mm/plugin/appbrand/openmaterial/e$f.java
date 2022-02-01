package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
final class e$f
  implements q.g
{
  public static final f qmx;
  
  static
  {
    AppMethodBeat.i(272116);
    qmx = new f();
    AppMethodBeat.o(272116);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(272115);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem: " + paramMenuItem + ", i: " + paramInt);
    if ((paramMenuItem instanceof p))
    {
      ((p)paramMenuItem).performClick();
      AppMethodBeat.o(272115);
      return;
    }
    Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem is not MMMenuItem");
    AppMethodBeat.o(272115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.f
 * JD-Core Version:    0.7.0.1
 */