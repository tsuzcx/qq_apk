package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class n$m
  implements DialogInterface.OnClickListener
{
  n$m(n paramn) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditVerifyCodeView localEditVerifyCodeView = null;
    Object localObject2 = null;
    AppMethodBeat.i(134915);
    Object localObject1 = n.f(this.iEE);
    if (localObject1 != null) {}
    for (localObject1 = ((EditVerifyCodeView)localObject1).getText();; localObject1 = null)
    {
      ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", new Object[] { localObject1 });
      localObject1 = n.f(this.iEE);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((EditVerifyCodeView)localObject1).getText();
      if ((localObject1 == null) || (((String)localObject1).length() != 6)) {
        break;
      }
      paramDialogInterface.dismiss();
      n.d(this.iEE);
      n.e(this.iEE);
      localObject1 = this.iEE;
      localEditVerifyCodeView = n.f(this.iEE);
      paramDialogInterface = localObject2;
      if (localEditVerifyCodeView != null) {
        paramDialogInterface = localEditVerifyCodeView.getText();
      }
      n.a((n)localObject1, String.valueOf(paramDialogInterface));
      AppMethodBeat.o(134915);
      return;
    }
    paramDialogInterface = n.f(this.iEE);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getText();
      if (paramDialogInterface == null) {}
    }
    for (paramDialogInterface = Integer.valueOf(paramDialogInterface.length());; paramDialogInterface = null)
    {
      if (paramDialogInterface == null) {
        j.ebi();
      }
      if (paramDialogInterface.intValue() >= 6) {
        break;
      }
      ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
      n.d(this.iEE);
      h.bL(this.iEE.context, this.iEE.context.getString(2131296671));
      AppMethodBeat.o(134915);
      return;
    }
    localObject1 = n.f(this.iEE);
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
      j.ebi();
    }
    if (paramDialogInterface.intValue() == 0)
    {
      ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
      n.d(this.iEE);
      h.bL(this.iEE.context, this.iEE.context.getString(2131296670));
    }
    AppMethodBeat.o(134915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n.m
 * JD-Core Version:    0.7.0.1
 */