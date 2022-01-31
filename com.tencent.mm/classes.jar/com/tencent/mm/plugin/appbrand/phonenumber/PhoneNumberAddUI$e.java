package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class PhoneNumberAddUI$e
  implements View.OnClickListener
{
  PhoneNumberAddUI$e(PhoneNumberAddUI paramPhoneNumberAddUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134822);
    PhoneNumberAddUI localPhoneNumberAddUI = this.iDB;
    paramView = this.iDB.iDw;
    if (paramView != null) {}
    for (paramView = paramView.getText();; paramView = null)
    {
      localPhoneNumberAddUI.jC(String.valueOf(paramView));
      if (!bo.isNullOrNil(this.iDB.czF)) {
        PhoneNumberAddUI.b(this.iDB);
      }
      AppMethodBeat.o(134822);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.e
 * JD-Core Version:    0.7.0.1
 */