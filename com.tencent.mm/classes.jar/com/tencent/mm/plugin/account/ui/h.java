package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.p;

public final class h
  implements com.tencent.mm.ak.g, MobileInputUI.b
{
  private MobileInputUI iSZ;
  private String iTa;
  private String iTb;
  private int iTc = 0;
  
  private void aQO()
  {
    AppMethodBeat.i(128272);
    Object localObject = this.iSZ;
    MobileInputUI localMobileInputUI = this.iSZ;
    this.iSZ.getString(2131755906);
    ((MobileInputUI)localObject).iJi = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.iSZ.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.iSZ.iTC + this.iSZ.iTD, 8, "", 0, "");
    com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    AppMethodBeat.o(128272);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128270);
    switch (5.iTe[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128270);
      return;
    }
    this.iSZ.iTC = az.aLe(this.iSZ.countryCode);
    this.iSZ.iTD = this.iSZ.iTp.getText().toString();
    parama = this.iSZ.iTC + this.iSZ.iTD;
    if (this.iSZ.iJi != null)
    {
      ac.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(128270);
      return;
    }
    Object localObject = this.iSZ;
    MobileInputUI localMobileInputUI = this.iSZ;
    this.iSZ.getString(2131755906);
    ((MobileInputUI)localObject).iJi = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.iSZ.getString(2131762310), true, new h.1(this));
    localObject = this.iSZ.iTp.getText().toString();
    int i;
    if ((this.iTa != null) && (this.iTb != null) && (!((String)localObject).equals(this.iTa)) && (((String)localObject).equals(this.iTb))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.oG(this.iTc);
      parama.oH(i);
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      this.iTa = this.iSZ.iTp.getText().toString();
      this.iTc += 1;
      break;
      if ((this.iTa != null) && (this.iTb != null) && (!this.iTb.equals(this.iTa)) && (!((String)localObject).equals(this.iTb))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128267);
    this.iSZ = paramMobileInputUI;
    paramMobileInputUI.iTq.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1 = str2;
    if (d.DIf) {
      str1 = str2 + paramMobileInputUI.getString(2131755263);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.iGS.setVisibility(0);
    paramMobileInputUI.iTp.setVisibility(0);
    paramMobileInputUI.iTq.requestFocus();
    paramMobileInputUI.iTv.setText(2131755830);
    paramMobileInputUI.iTv.setVisibility(0);
    AppMethodBeat.o(128267);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128271);
    ac.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iSZ.iJi != null)
    {
      this.iSZ.iJi.dismiss();
      this.iSZ.iJi = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.l(this.iSZ, 2131755266, 2131762275);
      AppMethodBeat.o(128271);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.h.a.rM(paramString);
      if (paramString != null)
      {
        paramString.a(this.iSZ, null, null);
        AppMethodBeat.o(128271);
        return;
      }
      com.tencent.mm.ui.base.h.l(this.iSZ, 2131762328, 2131762329);
      AppMethodBeat.o(128271);
      return;
    }
    if (paramn.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramn).Js();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aEt();
          if (!bs.isNullOrNil(paramn)) {
            this.iSZ.iTD = paramn.trim();
          }
          this.iSZ.iTD = az.aLc(this.iSZ.iTD);
          this.iTb = (this.iSZ.iTC + this.iSZ.iTD);
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramn = paramn.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("F200_200") + ",1");
          paramString = com.tencent.mm.h.a.rM(paramString);
          if (paramString != null)
          {
            paramString.a(this.iSZ, new h.2(this), new h.3(this));
            AppMethodBeat.o(128271);
            return;
          }
          aQO();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramString = paramString.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("F200_200") + ",2");
          AppMethodBeat.o(128271);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.iSZ, this.iSZ.getString(2131756462), "", true);
          AppMethodBeat.o(128271);
          return;
        }
        Toast.makeText(this.iSZ, this.iSZ.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.iSZ.iTC + " " + this.iSZ.iTp.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.iSZ.iTD);
        paramString.putExtra("country_name", this.iSZ.hLr);
        paramString.putExtra("couttry_code", this.iSZ.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aEz());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aEA());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aEB());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).aEC());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.iSZ, MobileVerifyUI.class);
        paramn = this.iSZ;
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.aeD(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(128271);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128268);
    com.tencent.mm.kernel.g.agi().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.IK("F200_100");
    this.iTc = 0;
    AppMethodBeat.o(128268);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128269);
    com.tencent.mm.kernel.g.agi().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("F200_100") + ",2");
    AppMethodBeat.o(128269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */