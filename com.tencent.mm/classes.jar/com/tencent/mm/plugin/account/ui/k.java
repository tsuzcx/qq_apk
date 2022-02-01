package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ce.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.ui.base.MMFormInputView;

public final class k
  implements com.tencent.mm.am.h, MobileInputUI.b
{
  protected String lCS = null;
  protected String pPU = "";
  protected int pPV = 2;
  private MobileInputUI qcl;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128290);
    switch (2.qcq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128290);
      return;
      this.qcl.qcP = PhoneFormater.countryCodeWithPlus(this.qcl.countryCode);
      this.qcl.qcQ = this.qcl.qcB.getText().toString();
      parama = this.qcl.qcP + this.qcl.qcQ;
      if (this.qcl.pRu != null)
      {
        Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(128290);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.qcl;
      MobileInputUI localMobileInputUI2 = this.qcl;
      this.qcl.getString(r.j.app_tip);
      localMobileInputUI1.pRu = com.tencent.mm.ui.base.k.a(localMobileInputUI2, this.qcl.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new com.tencent.mm.plugin.account.friend.model.w(parama, 1, "", 0, "", "");
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128287);
    this.qcl = paramMobileInputUI;
    paramMobileInputUI.qcC.requestFocus();
    paramMobileInputUI.showVKB();
    this.lCS = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.pPU = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.pPV = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(r.j.regbymoile_reg_title);
    String str1;
    if (!d.Yxk)
    {
      str1 = str2;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + j.mx(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.pOX.setVisibility(0);
    paramMobileInputUI.qcB.setVisibility(0);
    paramMobileInputUI.qcC.requestFocus();
    paramMobileInputUI.qcE.setVisibility(0);
    paramMobileInputUI.qcH.setVisibility(0);
    paramMobileInputUI.qcH.setText(r.j.loginby_new_mobile_reg_ok);
    AppMethodBeat.o(128287);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128291);
    Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qcl.pRu != null)
    {
      this.qcl.pRu.dismiss();
      this.qcl.pRu = null;
    }
    if (paramp.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 1)
        {
          paramp = new Intent();
          paramp.putExtra("bindmcontact_mobile", this.qcl.qcP + " " + this.qcl.qcB.getText().toString());
          paramp.putExtra("bindmcontact_shortmobile", this.qcl.qcB.getText().toString());
          paramp.putExtra("country_name", this.qcl.oLl);
          paramp.putExtra("couttry_code", this.qcl.countryCode);
          paramp.putExtra("mobile_verify_purpose", 4);
          paramp.putExtra("regsetinfo_ticket", this.lCS);
          paramp.putExtra("regsetinfo_NextStep", this.pPU);
          paramp.putExtra("regsetinfo_NextStyle", this.pPV);
          paramp.setClass(this.qcl, MobileVerifyUI.class);
          paramString = this.qcl;
          paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramp.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.qcl.finish();
        }
        AppMethodBeat.o(128291);
        return;
      }
      if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this.qcl, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128291);
        return;
      }
      Toast.makeText(this.qcl, this.qcl.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128291);
      return;
    }
    AppMethodBeat.o(128291);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128288);
    com.tencent.mm.kernel.h.aZW().a(132, this);
    AppMethodBeat.o(128288);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128289);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    AppMethodBeat.o(128289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */