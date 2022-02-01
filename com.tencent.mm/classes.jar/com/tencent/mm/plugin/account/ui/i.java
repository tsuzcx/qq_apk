package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ce.j;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class i
  implements com.tencent.mm.am.h, MobileInputUI.b
{
  private MobileInputUI qcl;
  private String qcm;
  private String qcn;
  private int qco = 0;
  
  private void bYk()
  {
    AppMethodBeat.i(128272);
    Object localObject = this.qcl;
    MobileInputUI localMobileInputUI = this.qcl;
    this.qcl.getString(r.j.app_tip);
    ((MobileInputUI)localObject).pRu = k.a(localMobileInputUI, this.qcl.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new i.4(this));
    localObject = new com.tencent.mm.modelfriend.a(this.qcl.qcP + this.qcl.qcQ, 8, "", 0, "");
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(128272);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128270);
    switch (5.qcq[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128270);
      return;
    }
    this.qcl.qcP = PhoneFormater.countryCodeWithPlus(this.qcl.countryCode);
    this.qcl.qcQ = this.qcl.qcB.getText().toString();
    parama = this.qcl.qcP + this.qcl.qcQ;
    if (this.qcl.pRu != null)
    {
      Log.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(128270);
      return;
    }
    Object localObject = this.qcl;
    MobileInputUI localMobileInputUI = this.qcl;
    this.qcl.getString(r.j.app_tip);
    ((MobileInputUI)localObject).pRu = k.a(localMobileInputUI, this.qcl.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new i.1(this));
    localObject = this.qcl.qcB.getText().toString();
    int i;
    if ((this.qcm != null) && (this.qcn != null) && (!((String)localObject).equals(this.qcm)) && (((String)localObject).equals(this.qcn))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.wd(this.qco);
      parama.we(i);
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      this.qcm = this.qcl.qcB.getText().toString();
      this.qco += 1;
      break;
      if ((this.qcm != null) && (this.qcn != null) && (!this.qcn.equals(this.qcm)) && (!((String)localObject).equals(this.qcn))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128267);
    this.qcl = paramMobileInputUI;
    paramMobileInputUI.qcC.requestFocus();
    paramMobileInputUI.showVKB();
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
    paramMobileInputUI.qcH.setText(r.j.app_nextstep);
    paramMobileInputUI.qcH.setVisibility(0);
    AppMethodBeat.o(128267);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128271);
    Log.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qcl.pRu != null)
    {
      this.qcl.pRu.dismiss();
      this.qcl.pRu = null;
    }
    if (paramInt2 == -75)
    {
      k.s(this.qcl, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128271);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if (paramString != null)
      {
        paramString.a(this.qcl, null, null);
        AppMethodBeat.o(128271);
        return;
      }
      k.s(this.qcl, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
      AppMethodBeat.o(128271);
      return;
    }
    if (paramp.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramp = ((com.tencent.mm.modelfriend.a)paramp).bIS();
          if (!Util.isNullOrNil(paramp)) {
            this.qcl.qcQ = paramp.trim();
          }
          this.qcl.qcQ = PhoneFormater.pureNumber(this.qcl.qcQ);
          this.qcn = (this.qcl.qcP + this.qcl.qcQ);
          paramp = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramp = paramp.append(b.aZR()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.z(true, b.Fw("F200_200") + ",1");
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramString != null)
          {
            paramString.a(this.qcl, new i.2(this), new i.3(this));
            AppMethodBeat.o(128271);
            return;
          }
          bYk();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramString = paramString.append(b.aZR()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.z(true, b.Fw("F200_200") + ",2");
          AppMethodBeat.o(128271);
          return;
        }
        if (paramInt2 == -34)
        {
          k.c(this.qcl, this.qcl.getString(r.j.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(128271);
          return;
        }
        Toast.makeText(this.qcl, this.qcl.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.qcl.qcP + " " + this.qcl.qcB.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.qcl.qcQ);
        paramString.putExtra("country_name", this.qcl.oLl);
        paramString.putExtra("couttry_code", this.qcl.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramp).bIY());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramp).bIZ());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramp).bJa());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramp).bJb());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.qcl, MobileVerifyUI.class);
        paramp = this.qcl;
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramp, paramString.aYi(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramp.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramp, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(128271);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128268);
    com.tencent.mm.kernel.h.aZW().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, b.Fw("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.Tz("F200_100");
    this.qco = 0;
    AppMethodBeat.o(128268);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128269);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, b.Fw("F200_100") + ",2");
    AppMethodBeat.o(128269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */