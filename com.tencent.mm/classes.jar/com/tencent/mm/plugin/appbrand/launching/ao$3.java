package com.tencent.mm.plugin.appbrand.launching;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.sdk.platformtools.ab;

final class ao$3
  implements DialogInterface.OnCancelListener
{
  ao$3(ao paramao, String paramString1, String paramString2) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(132003);
    ab.w("MicroMsg.WeAppLauncher", "openBusinessViewByOpenSdk, user canceled");
    ao.a(this.imZ);
    OpenBusinessViewUtil.s(this.inb, this.imY, -2);
    AppMethodBeat.o(132003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ao.3
 * JD-Core Version:    0.7.0.1
 */