package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ce.j;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class l
  implements com.tencent.mm.am.h, MobileInputUI.b
{
  private MobileInputUI qcl;
  private String qcm;
  private String qcn;
  private int qco = 0;
  private String qcu;
  int qcv = 1;
  
  private void bYk()
  {
    AppMethodBeat.i(128301);
    Object localObject = this.qcl;
    MobileInputUI localMobileInputUI = this.qcl;
    this.qcl.getString(r.j.app_tip);
    ((MobileInputUI)localObject).pRu = k.a(localMobileInputUI, this.qcl.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.qcl.qcP + this.qcl.qcQ, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).NH(this.qcu);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    AppMethodBeat.o(128301);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128299);
    switch (6.qcq[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128299);
      return;
    }
    this.qcl.hideVKB();
    if (!this.qcl.qcF.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.qcl, r.a.anim_shake_horizontal);
      this.qcl.qcE.startAnimation(parama);
      AppMethodBeat.o(128299);
      return;
    }
    switch (this.qcv)
    {
    default: 
      this.qcl.qcP = PhoneFormater.countryCodeWithPlus(this.qcl.countryCode);
      this.qcl.qcQ = this.qcl.qcB.getText().toString();
      parama = this.qcl.qcP + this.qcl.qcQ;
      if (com.tencent.mm.plugin.account.sdk.c.a.T(this.qcl, this.qcl.qaR.getText().toString()))
      {
        if ((this.qcl.pRu == null) || (!this.qcl.pRu.isShowing())) {
          break label326;
        }
        Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.qcv = 0;
      break;
      bYk();
      continue;
      parama = this.qcl.getString(r.j.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), com.tencent.mm.au.b.bJ(this.qcl.countryCode, this.qcl.getString(r.j.country_code)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.sdk.c.a.b(this.qcl, parama, 32047, false);
    }
    label326:
    Object localObject1 = this.qcl;
    Object localObject2 = this.qcl;
    this.qcl.getString(r.j.app_tip);
    ((MobileInputUI)localObject1).pRu = k.a((Context)localObject2, this.qcl.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new l.2(this));
    localObject1 = this.qcl.qcB.getText().toString();
    int i;
    if ((this.qcm != null) && (this.qcn != null) && (!((String)localObject1).equals(this.qcm)) && (((String)localObject1).equals(this.qcn))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.wd(this.qco);
      parama.we(i);
      if (com.tencent.mm.plugin.normsg.a.d.MtP.aQk("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_reg_eu");
      }
      localObject1 = new gdd();
      ((gdd)localObject1).acaV = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQl("ie_reg_eu"));
      ((gdd)localObject1).acaW = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQo("ce_reg"));
      ((gdd)localObject1).acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
      ((gdd)localObject1).acbb = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtH());
      localObject2 = com.tencent.mm.plugin.normsg.a.d.MtP.aQp("ce_reg");
      if (localObject2 != null) {
        ((gdd)localObject1).acbc = new gol().df(((String)localObject2).getBytes());
      }
      parama.a((gdd)localObject1);
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      this.qcm = this.qcl.qcB.getText().toString();
      this.qco += 1;
      break;
      if ((this.qcm != null) && (this.qcn != null) && (!this.qcn.equals(this.qcm)) && (!((String)localObject1).equals(this.qcn))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128296);
    this.qcl = paramMobileInputUI;
    String str = "";
    if ((com.tencent.mm.protocal.d.Yxk) || (BuildInfo.IS_FLAVOR_BLUE)) {
      str = "" + j.mx(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.qcJ.setVisibility(0);
    paramMobileInputUI.qcJ.setVisibility(0);
    paramMobileInputUI.pOX.setVisibility(0);
    paramMobileInputUI.qcB.setVisibility(0);
    paramMobileInputUI.qcC.requestFocus();
    paramMobileInputUI.qcE.setVisibility(0);
    paramMobileInputUI.qby.setVisibility(0);
    paramMobileInputUI.qcN.setVisibility(8);
    paramMobileInputUI.qcH.setVisibility(0);
    paramMobileInputUI.qcH.setText(r.j.loginby_new_mobile_reg_ok);
    paramMobileInputUI.qcG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128292);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputRegLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = com.tencent.mm.au.b.bJ(paramMobileInputUI.countryCode, paramMobileInputUI.getString(r.j.country_code));
        com.tencent.mm.plugin.account.sdk.c.a.b(paramMobileInputUI, paramMobileInputUI.getString(r.j.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), paramAnonymousView }), 0, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128292);
      }
    });
    AppMethodBeat.o(128296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128300);
    Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qcl.pRu != null)
    {
      this.qcl.pRu.dismiss();
      this.qcl.pRu = null;
    }
    if (paramInt2 == -75)
    {
      k.s(this.qcl, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128300);
      return;
    }
    if (paramp.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null)
        {
          paramString.a(this.qcl, null, null);
          AppMethodBeat.o(128300);
          return;
        }
        k.s(this.qcl, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
        AppMethodBeat.o(128300);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      if (i == 12)
      {
        this.qcl.qcQ = PhoneFormater.pureNumber(this.qcl.qcQ);
        this.qcn = (this.qcl.qcP + this.qcl.qcQ);
        this.qcu = ((com.tencent.mm.modelfriend.a)paramp).bJe();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramp = ((com.tencent.mm.modelfriend.a)paramp).bIS();
          if (!Util.isNullOrNil(paramp)) {
            this.qcl.qcQ = paramp.trim();
          }
          paramp = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramp = paramp.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R200_200") + ",1");
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramString != null)
          {
            paramString.a(this.qcl, new l.3(this), new l.4(this));
            AppMethodBeat.o(128300);
            return;
          }
          bYk();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramString = paramString.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R200_200") + ",2");
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -355)
        {
          v.f(this.qcl, paramString, 32046);
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -34)
        {
          k.c(this.qcl, this.qcl.getString(r.j.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      }
      Object localObject;
      if (i == 14)
      {
        if ((paramInt2 != 0) && (paramString != null)) {
          break label1193;
        }
        if (((com.tencent.mm.modelfriend.a)paramp).bIT() != 1) {
          break label849;
        }
        localObject = this.qcl.qcP + this.qcl.qcQ;
        String str1 = ((com.tencent.mm.modelfriend.a)paramp).bIV();
        String str2 = ((com.tencent.mm.modelfriend.a)paramp).bIU();
        paramp = new Intent(this.qcl, RegByMobileSendSmsUI.class);
        paramp.putExtra("from_mobile", (String)localObject);
        paramp.putExtra("to_mobile", str1);
        paramp.putExtra("verify_code", str2);
        paramp.putExtra("key_reg_style", 2);
        paramp.putExtra("kintent_password", this.qcl.qaR.getText().toString());
        paramp.putExtra("regsession_id", this.qcu);
        localObject = this.qcl;
        paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramp.aYi(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileInputUI)localObject).startActivity((Intent)paramp.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label849:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if ((paramString == null) || (this.qcl == null) || (!paramString.a(this.qcl, null, null))) {
            break;
          }
          AppMethodBeat.o(128300);
          return;
          com.tencent.mm.plugin.b.a.TA("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.qcl.qcP + " " + this.qcl.qcB.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.qcl.qcQ);
          ((Intent)localObject).putExtra("country_name", this.qcl.oLl);
          ((Intent)localObject).putExtra("couttry_code", this.qcl.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramp).bIY());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramp).bIZ());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramp).bJa());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramp).bJb());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.qcl.qaR.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.qcu);
          ((Intent)localObject).setClass(this.qcl, MobileVerifyUI.class);
          paramp = this.qcl;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramp, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramp.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramp, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.l.a(l.a.pWM);
        }
        if (paramInt2 == -34)
        {
          k.c(this.qcl, this.qcl.getString(r.j.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      } while (!com.tencent.mm.plugin.account.sdk.a.pFo.a(this.qcl, paramInt1, paramInt2, paramString));
      label1193:
      AppMethodBeat.o(128300);
      return;
    }
    AppMethodBeat.o(128300);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128297);
    com.tencent.mm.kernel.h.aZW().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.Tz("R200_100");
    this.qco = 0;
    AppMethodBeat.o(128297);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128298);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R200_100") + ",2");
    AppMethodBeat.o(128298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */