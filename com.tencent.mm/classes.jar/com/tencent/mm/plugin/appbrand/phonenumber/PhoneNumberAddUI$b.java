package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class PhoneNumberAddUI$b
  implements View.OnClickListener
{
  PhoneNumberAddUI$b(PhoneNumberAddUI paramPhoneNumberAddUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(134817);
    PhoneNumberAddUI localPhoneNumberAddUI = this.iDB;
    paramView = this.iDB.iDw;
    if (paramView != null) {}
    for (paramView = paramView.getText();; paramView = null)
    {
      localPhoneNumberAddUI.jC(String.valueOf(paramView));
      if (bo.isNullOrNil(this.iDB.czF)) {
        break;
      }
      h.d((Context)this.iDB, this.iDB.getString(2131296691) + this.iDB.czF, this.iDB.getString(2131296686), this.iDB.getString(2131297018), this.iDB.getString(2131296888), (DialogInterface.OnClickListener)new PhoneNumberAddUI.b.1(this), (DialogInterface.OnClickListener)2.iDD);
      AppMethodBeat.o(134817);
      return;
    }
    h.h((Context)this.iDB, 2131297169, 2131297170);
    ab.e("MicroMsg.PhoneNumberAddUI", "mobile:%s isn't phone", new Object[] { this.iDB.czF });
    AppMethodBeat.o(134817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.b
 * JD-Core Version:    0.7.0.1
 */