package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.p;

public final class h
  implements f, MobileInputUI.b
{
  private MobileInputUI jpb;
  private String jpc;
  private String jpd;
  private int jpe = 0;
  
  private void aUz()
  {
    AppMethodBeat.i(128272);
    Object localObject = this.jpb;
    MobileInputUI localMobileInputUI = this.jpb;
    this.jpb.getString(2131755906);
    ((MobileInputUI)localObject).jfk = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.jpb.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.jpb.jpE + this.jpb.jpF, 8, "", 0, "");
    com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
    AppMethodBeat.o(128272);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128270);
    switch (5.jpg[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128270);
      return;
    }
    this.jpb.jpE = bb.aSh(this.jpb.countryCode);
    this.jpb.jpF = this.jpb.jpr.getText().toString();
    parama = this.jpb.jpE + this.jpb.jpF;
    if (this.jpb.jfk != null)
    {
      ae.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(128270);
      return;
    }
    Object localObject = this.jpb;
    MobileInputUI localMobileInputUI = this.jpb;
    this.jpb.getString(2131755906);
    ((MobileInputUI)localObject).jfk = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.jpb.getString(2131762310), true, new h.1(this));
    localObject = this.jpb.jpr.getText().toString();
    int i;
    if ((this.jpc != null) && (this.jpd != null) && (!((String)localObject).equals(this.jpc)) && (((String)localObject).equals(this.jpd))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.pk(this.jpe);
      parama.pl(i);
      com.tencent.mm.kernel.g.ajj().a(parama, 0);
      this.jpc = this.jpb.jpr.getText().toString();
      this.jpe += 1;
      break;
      if ((this.jpc != null) && (this.jpd != null) && (!this.jpd.equals(this.jpc)) && (!((String)localObject).equals(this.jpd))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128267);
    this.jpb = paramMobileInputUI;
    paramMobileInputUI.jps.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1;
    if (!d.FFK)
    {
      str1 = str2;
      if (!j.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + com.tencent.mm.cc.g.ix(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.jcU.setVisibility(0);
    paramMobileInputUI.jpr.setVisibility(0);
    paramMobileInputUI.jps.requestFocus();
    paramMobileInputUI.jpx.setText(2131755830);
    paramMobileInputUI.jpx.setVisibility(0);
    AppMethodBeat.o(128267);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128271);
    ae.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jpb.jfk != null)
    {
      this.jpb.jfk.dismiss();
      this.jpb.jfk = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.l(this.jpb, 2131755266, 2131762275);
      AppMethodBeat.o(128271);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.h.a.uU(paramString);
      if (paramString != null)
      {
        paramString.a(this.jpb, null, null);
        AppMethodBeat.o(128271);
        return;
      }
      com.tencent.mm.ui.base.h.l(this.jpb, 2131762328, 2131762329);
      AppMethodBeat.o(128271);
      return;
    }
    if (paramn.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramn).KZ();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aHP();
          if (!bu.isNullOrNil(paramn)) {
            this.jpb.jpF = paramn.trim();
          }
          this.jpb.jpF = bb.aSf(this.jpb.jpF);
          this.jpd = (this.jpb.jpE + this.jpb.jpF);
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          paramn = paramn.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("F200_200") + ",1");
          paramString = com.tencent.mm.h.a.uU(paramString);
          if (paramString != null)
          {
            paramString.a(this.jpb, new h.2(this), new h.3(this));
            AppMethodBeat.o(128271);
            return;
          }
          aUz();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          paramString = paramString.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("F200_200") + ",2");
          AppMethodBeat.o(128271);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.jpb, this.jpb.getString(2131756462), "", true);
          AppMethodBeat.o(128271);
          return;
        }
        Toast.makeText(this.jpb, this.jpb.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.jpb.jpE + " " + this.jpb.jpr.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.jpb.jpF);
        paramString.putExtra("country_name", this.jpb.ihe);
        paramString.putExtra("couttry_code", this.jpb.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aHV());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aHW());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aHX());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).aHY());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.jpb, MobileVerifyUI.class);
        paramn = this.jpb;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahE(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(128271);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128268);
    com.tencent.mm.kernel.g.ajj().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.KA("F200_100");
    this.jpe = 0;
    AppMethodBeat.o(128268);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128269);
    com.tencent.mm.kernel.g.ajj().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("F200_100") + ",2");
    AppMethodBeat.o(128269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */