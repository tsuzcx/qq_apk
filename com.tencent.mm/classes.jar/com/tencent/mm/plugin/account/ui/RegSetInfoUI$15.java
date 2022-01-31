package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class RegSetInfoUI$15
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$15(RegSetInfoUI paramRegSetInfoUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125522);
    paramDialogInterface = RegSetInfoUI.b(this.gJQ).getText().toString().trim();
    Object localObject1 = RegSetInfoUI.a(this.gJQ).getText().toString().trim();
    if ((paramDialogInterface == null) || (paramDialogInterface.length() <= 0))
    {
      h.h(this.gJQ, 2131304491, 2131302443);
      AppMethodBeat.o(125522);
      return;
    }
    this.gJQ.hideVKB();
    paramInt = RegSetInfoUI.e(this.gJQ);
    Object localObject2 = RegSetInfoUI.f(this.gJQ);
    g.Rc().a(429, this.gJQ);
    paramDialogInterface = new ad((String)localObject2, RegSetInfoUI.g(this.gJQ), paramInt, paramDialogInterface, (String)localObject1, ((ad)this.ckS).ajG(), RegSetInfoUI.C(this.gJQ).getSecImgCode());
    g.Rc().a(paramDialogInterface, 0);
    localObject1 = this.gJQ;
    localObject2 = this.gJQ;
    this.gJQ.getString(2131297087);
    RegSetInfoUI.a((RegSetInfoUI)localObject1, h.b((Context)localObject2, this.gJQ.getString(2131302482), true, new RegSetInfoUI.15.1(this, paramDialogInterface)));
    AppMethodBeat.o(125522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.15
 * JD-Core Version:    0.7.0.1
 */