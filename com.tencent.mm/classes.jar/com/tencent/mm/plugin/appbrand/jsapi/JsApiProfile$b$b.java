package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiProfile$b$b
  implements DialogInterface.OnCancelListener
{
  JsApiProfile$b$b(JsApiProfile.b paramb, String paramString, JsApiProfile.ProfileResult paramProfileResult) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    am.a.Hh().iC(this.ghe);
    this.ghb.aYY = 2;
    JsApiProfile.b.a(this.gha, (AppBrandProxyUIProcessTask.ProcessResult)this.ghb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiProfile.b.b
 * JD-Core Version:    0.7.0.1
 */