package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class LoginHistoryUI$14
  implements DialogInterface.OnClickListener
{
  LoginHistoryUI$14(LoginHistoryUI paramLoginHistoryUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(152545);
    ab.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.gEw.gDU.gwj + " img len" + this.gEw.gDU.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
    int j = this.val$errType;
    if (this.gEw.gEl == null)
    {
      paramInt = -1;
      paramDialogInterface = bo.aqg(this.gEw.gEl);
      if (this.gEw.gDU.gwh != null) {
        break label379;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), paramDialogInterface, Integer.valueOf(i), bo.aqg(this.gEw.gDU.gwh) });
      paramDialogInterface = new s(this.gEw.gDU.account, this.gEw.gDU.gwh, this.gEw.gDU.gEL, LoginHistoryUI.i(this.gEw).getSecImgCode(), LoginHistoryUI.i(this.gEw).getSecImgSid(), LoginHistoryUI.i(this.gEw).getSecImgEncryptKey(), 0, "", false, false);
      if ((bo.isNullOrNil(this.gEw.gDU.gwh)) && (!bo.isNullOrNil(this.gEw.gEl)))
      {
        ab.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bo.aqg(this.gEw.gEl) });
        paramDialogInterface.up(this.gEw.gEl);
      }
      com.tencent.mm.kernel.g.Rc().a(paramDialogInterface, 0);
      LoginHistoryUI localLoginHistoryUI1 = this.gEw;
      LoginHistoryUI localLoginHistoryUI2 = this.gEw;
      this.gEw.getString(2131297087);
      localLoginHistoryUI1.eeN = h.b(localLoginHistoryUI2, this.gEw.getString(2131301149), true, new LoginHistoryUI.14.1(this, paramDialogInterface));
      AppMethodBeat.o(152545);
      return;
      paramInt = this.gEw.gEl.length();
      break;
      label379:
      i = this.gEw.gDU.gwh.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.14
 * JD-Core Version:    0.7.0.1
 */