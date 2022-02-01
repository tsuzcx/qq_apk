package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.p;

public final class h
  implements f, MobileInputUI.b
{
  private MobileInputUI jmh;
  private String jmi;
  private String jmj;
  private int jmk = 0;
  
  private void aUa()
  {
    AppMethodBeat.i(128272);
    Object localObject = this.jmh;
    MobileInputUI localMobileInputUI = this.jmh;
    this.jmh.getString(2131755906);
    ((MobileInputUI)localObject).jcr = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.jmh.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.jmh.jmK + this.jmh.jmL, 8, "", 0, "");
    com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
    AppMethodBeat.o(128272);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128270);
    switch (5.jmm[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128270);
      return;
    }
    this.jmh.jmK = ba.aQK(this.jmh.countryCode);
    this.jmh.jmL = this.jmh.jmx.getText().toString();
    parama = this.jmh.jmK + this.jmh.jmL;
    if (this.jmh.jcr != null)
    {
      ad.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(128270);
      return;
    }
    Object localObject = this.jmh;
    MobileInputUI localMobileInputUI = this.jmh;
    this.jmh.getString(2131755906);
    ((MobileInputUI)localObject).jcr = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.jmh.getString(2131762310), true, new h.1(this));
    localObject = this.jmh.jmx.getText().toString();
    int i;
    if ((this.jmi != null) && (this.jmj != null) && (!((String)localObject).equals(this.jmi)) && (((String)localObject).equals(this.jmj))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.ph(this.jmk);
      parama.pi(i);
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
      this.jmi = this.jmh.jmx.getText().toString();
      this.jmk += 1;
      break;
      if ((this.jmi != null) && (this.jmj != null) && (!this.jmj.equals(this.jmi)) && (!((String)localObject).equals(this.jmj))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128267);
    this.jmh = paramMobileInputUI;
    paramMobileInputUI.jmy.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1;
    if (!d.Fnm)
    {
      str1 = str2;
      if (!i.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + com.tencent.mm.cd.g.is(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.jab.setVisibility(0);
    paramMobileInputUI.jmx.setVisibility(0);
    paramMobileInputUI.jmy.requestFocus();
    paramMobileInputUI.jmD.setText(2131755830);
    paramMobileInputUI.jmD.setVisibility(0);
    AppMethodBeat.o(128267);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128271);
    ad.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jmh.jcr != null)
    {
      this.jmh.jcr.dismiss();
      this.jmh.jcr = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.l(this.jmh, 2131755266, 2131762275);
      AppMethodBeat.o(128271);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.h.a.uz(paramString);
      if (paramString != null)
      {
        paramString.a(this.jmh, null, null);
        AppMethodBeat.o(128271);
        return;
      }
      com.tencent.mm.ui.base.h.l(this.jmh, 2131762328, 2131762329);
      AppMethodBeat.o(128271);
      return;
    }
    if (paramn.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramn).KR();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aHy();
          if (!bt.isNullOrNil(paramn)) {
            this.jmh.jmL = paramn.trim();
          }
          this.jmh.jmL = ba.aQI(this.jmh.jmL);
          this.jmj = (this.jmh.jmK + this.jmh.jmL);
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          paramn = paramn.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("F200_200") + ",1");
          paramString = com.tencent.mm.h.a.uz(paramString);
          if (paramString != null)
          {
            paramString.a(this.jmh, new h.2(this), new h.3(this));
            AppMethodBeat.o(128271);
            return;
          }
          aUa();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          paramString = paramString.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("F200_200") + ",2");
          AppMethodBeat.o(128271);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.jmh, this.jmh.getString(2131756462), "", true);
          AppMethodBeat.o(128271);
          return;
        }
        Toast.makeText(this.jmh, this.jmh.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.jmh.jmK + " " + this.jmh.jmx.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.jmh.jmL);
        paramString.putExtra("country_name", this.jmh.iem);
        paramString.putExtra("couttry_code", this.jmh.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aHE());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aHF());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aHG());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).aHH());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.jmh, MobileVerifyUI.class);
        paramn = this.jmh;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahp(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(128271);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128268);
    com.tencent.mm.kernel.g.aiU().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.Kc("F200_100");
    this.jmk = 0;
    AppMethodBeat.o(128268);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128269);
    com.tencent.mm.kernel.g.aiU().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("F200_100") + ",2");
    AppMethodBeat.o(128269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */