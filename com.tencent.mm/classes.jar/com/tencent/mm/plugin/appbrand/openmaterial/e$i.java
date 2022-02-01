package com.tencent.mm.plugin.appbrand.openmaterial;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MenuItem;", "onAttach"})
final class e$i
  implements o.a
{
  public static final i nkY;
  
  static
  {
    AppMethodBeat.i(229114);
    nkY = new i();
    AppMethodBeat.o(229114);
  }
  
  public final void f(ImageView paramImageView)
  {
    AppMethodBeat.i(229113);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconBadgeCreator");
    paramImageView.setBackgroundResource(2131231021);
    paramImageView.setImageResource(2131689637);
    AppMethodBeat.o(229113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.i
 * JD-Core Version:    0.7.0.1
 */