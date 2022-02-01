package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Intent;
import com.tencent.luggage.h.f.b;
import com.tencent.luggage.h.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
final class AppBrandJsApiPayUtils$a
  implements f.c
{
  AppBrandJsApiPayUtils$a(int paramInt, f.b paramb) {}
  
  public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(228436);
    if (this.mmc == paramInt1)
    {
      this.mmd.a(paramInt2, paramIntent);
      AppMethodBeat.o(228436);
      return true;
    }
    AppMethodBeat.o(228436);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils.a
 * JD-Core Version:    0.7.0.1
 */