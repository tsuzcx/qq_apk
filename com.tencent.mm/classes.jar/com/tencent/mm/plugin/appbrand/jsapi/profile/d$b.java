package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class d$b
  implements DialogInterface.OnCancelListener
{
  d$b(d paramd, String paramString, ProfileResult paramProfileResult) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(134707);
    ao.a.aaj().pl(this.hDt);
    this.hXp.bpE = 2;
    d.a(this.hXo, (AppBrandProxyUIProcessTask.ProcessResult)this.hXp);
    AppMethodBeat.o(134707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d.b
 * JD-Core Version:    0.7.0.1
 */