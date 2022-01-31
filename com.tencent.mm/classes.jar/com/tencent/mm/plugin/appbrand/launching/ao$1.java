package com.tencent.mm.plugin.appbrand.launching;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.sdk.platformtools.ab;

final class ao$1
  implements DialogInterface.OnCancelListener
{
  ao$1(ao paramao, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(132000);
    ab.w("MicroMsg.WeAppLauncher", "openBusinessViewByWebView, user canceled");
    ao.a(this.imZ);
    OpenBusinessViewUtil.t(this.imY, null, -3);
    AppMethodBeat.o(132000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao.1
 * JD-Core Version:    0.7.0.1
 */