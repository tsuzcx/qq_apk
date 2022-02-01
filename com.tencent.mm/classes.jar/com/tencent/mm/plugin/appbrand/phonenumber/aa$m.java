package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class aa$m
  implements DialogInterface.OnClickListener
{
  aa$m(aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditVerifyCodeView localEditVerifyCodeView = null;
    Object localObject2 = null;
    AppMethodBeat.i(148190);
    Object localObject1 = aa.f(this.mlJ);
    if (localObject1 != null) {}
    for (localObject1 = ((EditVerifyCodeView)localObject1).getText();; localObject1 = null)
    {
      ad.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
      localObject1 = aa.f(this.mlJ);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      if ((localObject1 == null) || (((String)localObject1).length() != 6)) {
        break;
      }
      paramDialogInterface.dismiss();
      aa.d(this.mlJ);
      aa.e(this.mlJ);
      localObject1 = this.mlJ;
      localEditVerifyCodeView = aa.f(this.mlJ);
      paramDialogInterface = localObject2;
      if (localEditVerifyCodeView != null) {
        paramDialogInterface = localEditVerifyCodeView.getText();
      }
      aa.a((aa)localObject1, String.valueOf(paramDialogInterface));
      AppMethodBeat.o(148190);
      return;
    }
    paramDialogInterface = aa.f(this.mlJ);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getText();
      if (paramDialogInterface == null) {}
    }
    for (paramDialogInterface = Integer.valueOf(paramDialogInterface.length());; paramDialogInterface = null)
    {
      if (paramDialogInterface == null) {
        p.gfZ();
      }
      if (paramDialogInterface.intValue() >= 6) {
        break;
      }
      ad.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
      k.a(this.mlJ.context, this.mlJ.context.getString(2131755450), this.mlJ.context.getString(2131755442), (DialogInterface.OnClickListener)1.mlS);
      AppMethodBeat.o(148190);
      return;
    }
    localObject1 = aa.f(this.mlJ);
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
      p.gfZ();
    }
    if (paramDialogInterface.intValue() == 0)
    {
      ad.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
      k.a(this.mlJ.context, this.mlJ.context.getString(2131755449), this.mlJ.context.getString(2131755442), (DialogInterface.OnClickListener)2.mlT);
    }
    AppMethodBeat.o(148190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.m
 * JD-Core Version:    0.7.0.1
 */