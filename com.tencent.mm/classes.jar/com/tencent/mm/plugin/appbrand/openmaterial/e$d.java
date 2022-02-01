package com.tencent.mm.plugin.appbrand.openmaterial;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.t;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$convertOpenMaterialModel2MenuItem$2", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "kotlin.jvm.PlatformType", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$d
  implements b.k
{
  e$d(t paramt, e parame) {}
  
  public final void bFg()
  {
    AppMethodBeat.i(323657);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "beforeLoadBitmap");
    AppMethodBeat.o(323657);
  }
  
  public final void bFh()
  {
    AppMethodBeat.i(323646);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onLoadFailed");
    AppMethodBeat.o(323646);
  }
  
  public final String key()
  {
    AppMethodBeat.i(323640);
    String str = p.el(this);
    AppMethodBeat.o(323640);
    return str;
  }
  
  public final void onBitmapLoaded(Bitmap paramBitmap)
  {
    AppMethodBeat.i(323651);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded");
    if (paramBitmap == null)
    {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded, bitmap is null");
      AppMethodBeat.o(323651);
      return;
    }
    this.tro.f((Drawable)new BitmapDrawable(e.ac(paramBitmap)), 0);
    AppMethodBeat.o(323651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e.d
 * JD-Core Version:    0.7.0.1
 */