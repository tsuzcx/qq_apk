package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class n$o
  extends ClickableSpan
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134917);
    j.q(paramView, "arg0");
    ab.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
    if (this.iEE.iEB.iDr)
    {
      n.a(this.iEE);
      AppMethodBeat.o(134917);
      return;
    }
    ab.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
    paramView = this.iEE;
    String str = this.iEE.context.getString(2131296667);
    j.p(str, "context.getString(R.stri…end_verify_code_frequent)");
    n.c(paramView, str);
    AppMethodBeat.o(134917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n.o
 * JD-Core Version:    0.7.0.1
 */