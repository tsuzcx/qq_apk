package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MenuItem;", "onAttach"})
final class e$g
  implements o.b
{
  public static final g nkX;
  
  static
  {
    AppMethodBeat.i(229111);
    nkX = new g();
    AppMethodBeat.o(229111);
  }
  
  public final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(229110);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconCreator");
    if (ao.isDarkMode()) {}
    for (int i = 2131689638;; i = 2131689639)
    {
      paramImageView.setImageResource(i);
      AppMethodBeat.o(229110);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.g
 * JD-Core Version:    0.7.0.1
 */