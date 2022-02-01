package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.s;

public final class i
  implements com.tencent.mm.an.i, MobileInputUI.b
{
  private MobileInputUI nfd;
  private String nfe;
  private String nff;
  private int nfg = 0;
  
  private void bzy()
  {
    AppMethodBeat.i(128272);
    Object localObject = this.nfd;
    MobileInputUI localMobileInputUI = this.nfd;
    this.nfd.getString(r.j.app_tip);
    ((MobileInputUI)localObject).mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.nfd.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.nfd.nfG + this.nfd.nfH, 8, "", 0, "");
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    AppMethodBeat.o(128272);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128270);
    switch (5.nfi[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128270);
      return;
    }
    this.nfd.nfG = PhoneFormater.countryCodeWithPlus(this.nfd.countryCode);
    this.nfd.nfH = this.nfd.nft.getText().toString();
    parama = this.nfd.nfG + this.nfd.nfH;
    if (this.nfd.mUN != null)
    {
      Log.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(128270);
      return;
    }
    Object localObject = this.nfd;
    MobileInputUI localMobileInputUI = this.nfd;
    this.nfd.getString(r.j.app_tip);
    ((MobileInputUI)localObject).mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.nfd.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new i.1(this));
    localObject = this.nfd.nft.getText().toString();
    int i;
    if ((this.nfe != null) && (this.nff != null) && (!((String)localObject).equals(this.nfe)) && (((String)localObject).equals(this.nff))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.vY(this.nfg);
      parama.vZ(i);
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      this.nfe = this.nfd.nft.getText().toString();
      this.nfg += 1;
      break;
      if ((this.nfe != null) && (this.nff != null) && (!this.nff.equals(this.nfe)) && (!((String)localObject).equals(this.nff))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128267);
    this.nfd = paramMobileInputUI;
    paramMobileInputUI.nfu.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(r.j.regbymoile_reg_title);
    String str1;
    if (!d.RAG)
    {
      str1 = str2;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + com.tencent.mm.cj.h.kv(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.mSs.setVisibility(0);
    paramMobileInputUI.nft.setVisibility(0);
    paramMobileInputUI.nfu.requestFocus();
    paramMobileInputUI.nfz.setText(r.j.app_nextstep);
    paramMobileInputUI.nfz.setVisibility(0);
    AppMethodBeat.o(128267);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128271);
    Log.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.nfd.mUN != null)
    {
      this.nfd.mUN.dismiss();
      this.nfd.mUN = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.p(this.nfd, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128271);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if (paramString != null)
      {
        paramString.a(this.nfd, null, null);
        AppMethodBeat.o(128271);
        return;
      }
      com.tencent.mm.ui.base.h.p(this.nfd, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
      AppMethodBeat.o(128271);
      return;
    }
    if (paramq.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bkY();
          if (!Util.isNullOrNil(paramq)) {
            this.nfd.nfH = paramq.trim();
          }
          this.nfd.nfH = PhoneFormater.pureNumber(this.nfd.nfH);
          this.nff = (this.nfd.nfG + this.nfd.nfH);
          paramq = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramq = paramq.append(b.aGR()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.m(true, b.MN("F200_200") + ",1");
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if (paramString != null)
          {
            paramString.a(this.nfd, new i.2(this), new i.3(this));
            AppMethodBeat.o(128271);
            return;
          }
          bzy();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramString = paramString.append(b.aGR()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.m(true, b.MN("F200_200") + ",2");
          AppMethodBeat.o(128271);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.nfd, this.nfd.getString(r.j.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(128271);
          return;
        }
        Toast.makeText(this.nfd, this.nfd.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.nfd.nfG + " " + this.nfd.nft.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.nfd.nfH);
        paramString.putExtra("country_name", this.nfd.lSz);
        paramString.putExtra("couttry_code", this.nfd.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramq).ble());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramq).blf());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramq).blg());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramq).blh());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.nfd, MobileVerifyUI.class);
        paramq = this.nfd;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramq, paramString.aFh(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramq.startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramq, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(128271);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128268);
    com.tencent.mm.kernel.h.aGY().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(b.aGR()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, b.MN("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.bgi("F200_100");
    this.nfg = 0;
    AppMethodBeat.o(128268);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128269);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(b.aGR()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, b.MN("F200_100") + ",2");
    AppMethodBeat.o(128269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */