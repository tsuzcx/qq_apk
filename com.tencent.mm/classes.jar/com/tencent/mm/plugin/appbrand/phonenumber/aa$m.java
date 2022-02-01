package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class aa$m
  implements DialogInterface.OnClickListener
{
  aa$m(aa paramaa) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditVerifyCodeView localEditVerifyCodeView = null;
    Object localObject2 = null;
    AppMethodBeat.i(148190);
    Object localObject1 = aa.f(this.nBs);
    if (localObject1 != null) {}
    for (localObject1 = ((EditVerifyCodeView)localObject1).getText();; localObject1 = null)
    {
      Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
      localObject1 = aa.f(this.nBs);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      if ((localObject1 == null) || (((String)localObject1).length() != 6)) {
        break;
      }
      paramDialogInterface.dismiss();
      aa.d(this.nBs);
      aa.e(this.nBs);
      localObject1 = this.nBs;
      localEditVerifyCodeView = aa.f(this.nBs);
      paramDialogInterface = localObject2;
      if (localEditVerifyCodeView != null) {
        paramDialogInterface = localEditVerifyCodeView.getText();
      }
      aa.a((aa)localObject1, String.valueOf(paramDialogInterface));
      AppMethodBeat.o(148190);
      return;
    }
    paramDialogInterface = aa.f(this.nBs);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getText();
      if (paramDialogInterface == null) {}
    }
    for (paramDialogInterface = Integer.valueOf(paramDialogInterface.length());; paramDialogInterface = null)
    {
      if (paramDialogInterface == null) {
        p.hyc();
      }
      if (paramDialogInterface.intValue() >= 6) {
        break;
      }
      Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
      com.tencent.mm.plugin.appbrand.utils.l.b(this.nBs.context, this.nBs.context.getString(2131755488), this.nBs.context.getString(2131755480), (DialogInterface.OnClickListener)1.nBB);
      AppMethodBeat.o(148190);
      return;
    }
    localObject1 = aa.f(this.nBs);
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
      p.hyc();
    }
    if (paramDialogInterface.intValue() == 0)
    {
      Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
      com.tencent.mm.plugin.appbrand.utils.l.b(this.nBs.context, this.nBs.context.getString(2131755487), this.nBs.context.getString(2131755480), (DialogInterface.OnClickListener)2.nBC);
    }
    AppMethodBeat.o(148190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.aa.m
 * JD-Core Version:    0.7.0.1
 */