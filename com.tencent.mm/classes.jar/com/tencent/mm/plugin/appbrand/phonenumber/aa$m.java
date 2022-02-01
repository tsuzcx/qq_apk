package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class aa$m
  implements DialogInterface.OnClickListener
{
  aa$m(aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditVerifyCodeView localEditVerifyCodeView = null;
    Object localObject2 = null;
    AppMethodBeat.i(148190);
    Object localObject1 = aa.f(this.qDD);
    if (localObject1 != null) {}
    for (localObject1 = ((EditVerifyCodeView)localObject1).getText();; localObject1 = null)
    {
      Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
      localObject1 = aa.f(this.qDD);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      if ((localObject1 == null) || (((String)localObject1).length() != 6)) {
        break;
      }
      paramDialogInterface.dismiss();
      aa.d(this.qDD);
      aa.e(this.qDD);
      localObject1 = this.qDD;
      localEditVerifyCodeView = aa.f(this.qDD);
      paramDialogInterface = localObject2;
      if (localEditVerifyCodeView != null) {
        paramDialogInterface = localEditVerifyCodeView.getText();
      }
      aa.a((aa)localObject1, String.valueOf(paramDialogInterface));
      AppMethodBeat.o(148190);
      return;
    }
    paramDialogInterface = aa.f(this.qDD);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getText();
      if (paramDialogInterface == null) {}
    }
    for (paramDialogInterface = Integer.valueOf(paramDialogInterface.length());; paramDialogInterface = null)
    {
      if (paramDialogInterface == null) {
        p.iCn();
      }
      if (paramDialogInterface.intValue() >= 6) {
        break;
      }
      Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
      n.b(this.qDD.context, this.qDD.context.getString(a.g.app_brand_get_phone_number_verify_code_error_format), this.qDD.context.getString(a.g.app_brand_get_phone_number_ok), (DialogInterface.OnClickListener)1.qDM);
      AppMethodBeat.o(148190);
      return;
    }
    localObject1 = aa.f(this.qDD);
    paramDialogInterface = localEditVerifyCodeView;
    if (localObject1 != null)
    {
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      paramDialogInterface = localEditVerifyCodeView;
      if (localObject1 != null) {
        paramDialogInterface = Integer.valueOf(((String)localObject1).length());
      }
    }
    if (paramDialogInterface == null) {
      p.iCn();
    }
    if (paramDialogInterface.intValue() == 0)
    {
      Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
      n.b(this.qDD.context, this.qDD.context.getString(a.g.app_brand_get_phone_number_verify_code_error_empty), this.qDD.context.getString(a.g.app_brand_get_phone_number_ok), (DialogInterface.OnClickListener)2.qDN);
    }
    AppMethodBeat.o(148190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.m
 * JD-Core Version:    0.7.0.1
 */