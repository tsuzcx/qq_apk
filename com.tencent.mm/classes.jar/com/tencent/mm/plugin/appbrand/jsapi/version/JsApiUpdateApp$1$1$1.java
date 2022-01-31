package com.tencent.mm.plugin.appbrand.jsapi.version;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;

final class JsApiUpdateApp$1$1$1
  implements DialogInterface.OnClickListener
{
  JsApiUpdateApp$1$1$1(JsApiUpdateApp.1.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(131486);
    paramDialogInterface = this.ibx.ibw.hxC.getRuntime();
    AppBrandInitConfigWC localAppBrandInitConfigWC = this.ibx.gSh;
    if ((paramDialogInterface == null) || (localAppBrandInitConfigWC == null))
    {
      ab.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
      AppMethodBeat.o(131486);
      return;
    }
    if (!paramDialogInterface.mInitialized)
    {
      ab.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[] { paramDialogInterface.mAppId });
      AppMethodBeat.o(131486);
      return;
    }
    paramDialogInterface.k(new af.1(paramDialogInterface, localAppBrandInitConfigWC), 0L);
    AppMethodBeat.o(131486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.1.1.1
 * JD-Core Version:    0.7.0.1
 */