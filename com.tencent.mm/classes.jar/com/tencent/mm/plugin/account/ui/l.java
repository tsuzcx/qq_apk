package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.s;

public final class l
  implements i, MobileInputUI.b
{
  private MobileInputUI nfd;
  private String nfe;
  private String nff;
  private int nfg = 0;
  private String nfm;
  int nfn = 1;
  
  private void bzy()
  {
    AppMethodBeat.i(128301);
    Object localObject = this.nfd;
    MobileInputUI localMobileInputUI = this.nfd;
    this.nfd.getString(r.j.app_tip);
    ((MobileInputUI)localObject).mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.nfd.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.nfd.nfG + this.nfd.nfH, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).VH(this.nfm);
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    AppMethodBeat.o(128301);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128299);
    switch (6.nfi[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128299);
      return;
    }
    this.nfd.hideVKB();
    if (!this.nfd.nfx.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.nfd, r.a.anim_shake_horizontal);
      this.nfd.nfw.startAnimation(parama);
      AppMethodBeat.o(128299);
      return;
    }
    switch (this.nfn)
    {
    default: 
      this.nfd.nfG = PhoneFormater.countryCodeWithPlus(this.nfd.countryCode);
      this.nfd.nfH = this.nfd.nft.getText().toString();
      parama = this.nfd.nfG + this.nfd.nfH;
      if (com.tencent.mm.plugin.account.sdk.b.a.T(this.nfd, this.nfd.ndD.getText().toString()))
      {
        if ((this.nfd.mUN == null) || (!this.nfd.mUN.isShowing())) {
          break label326;
        }
        Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.nfn = 0;
      break;
      bzy();
      continue;
      parama = this.nfd.getString(r.j.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), com.tencent.mm.az.b.by(this.nfd.countryCode, this.nfd.getString(r.j.country_code)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.sdk.b.a.b(this.nfd, parama, 32047, false);
    }
    label326:
    Object localObject1 = this.nfd;
    Object localObject2 = this.nfd;
    this.nfd.getString(r.j.app_tip);
    ((MobileInputUI)localObject1).mUN = com.tencent.mm.ui.base.h.a((Context)localObject2, this.nfd.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new l.2(this));
    localObject1 = this.nfd.nft.getText().toString();
    int i;
    if ((this.nfe != null) && (this.nff != null) && (!((String)localObject1).equals(this.nfe)) && (((String)localObject1).equals(this.nff))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.vY(this.nfg);
      parama.vZ(i);
      if (com.tencent.mm.plugin.normsg.a.d.GxJ.aTk("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_reg_eu");
      }
      localObject1 = new fgr();
      ((fgr)localObject1).UGM = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTl("ie_reg_eu"));
      ((fgr)localObject1).UGN = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTo("ce_reg"));
      ((fgr)localObject1).UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
      ((fgr)localObject1).UGS = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjq());
      localObject2 = com.tencent.mm.plugin.normsg.a.d.GxJ.aTp("ce_reg");
      if (localObject2 != null) {
        ((fgr)localObject1).UGT = new eae().dc(((String)localObject2).getBytes());
      }
      parama.a((fgr)localObject1);
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      this.nfe = this.nfd.nft.getText().toString();
      this.nfg += 1;
      break;
      if ((this.nfe != null) && (this.nff != null) && (!this.nff.equals(this.nfe)) && (!((String)localObject1).equals(this.nff))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128296);
    this.nfd = paramMobileInputUI;
    String str = "";
    if ((com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_BLUE)) {
      str = "" + com.tencent.mm.cj.h.kv(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.nfA.setVisibility(0);
    paramMobileInputUI.nfA.setVisibility(0);
    paramMobileInputUI.mSs.setVisibility(0);
    paramMobileInputUI.nft.setVisibility(0);
    paramMobileInputUI.nfu.requestFocus();
    paramMobileInputUI.nfw.setVisibility(0);
    paramMobileInputUI.neK.setVisibility(0);
    paramMobileInputUI.nfE.setVisibility(8);
    paramMobileInputUI.nfz.setVisibility(0);
    paramMobileInputUI.nfz.setText(r.j.loginby_new_mobile_reg_ok);
    paramMobileInputUI.nfy.setOnClickListener(new l.1(this, paramMobileInputUI));
    AppMethodBeat.o(128296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128300);
    Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.nfd.mUN != null)
    {
      this.nfd.mUN.dismiss();
      this.nfd.mUN = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.p(this.nfd, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128300);
      return;
    }
    if (paramq.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this.nfd, null, null);
          AppMethodBeat.o(128300);
          return;
        }
        com.tencent.mm.ui.base.h.p(this.nfd, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
        AppMethodBeat.o(128300);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      if (i == 12)
      {
        this.nfd.nfH = PhoneFormater.pureNumber(this.nfd.nfH);
        this.nff = (this.nfd.nfG + this.nfd.nfH);
        this.nfm = ((com.tencent.mm.modelfriend.a)paramq).blk();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bkY();
          if (!Util.isNullOrNil(paramq)) {
            this.nfd.nfH = paramq.trim();
          }
          paramq = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramq = paramq.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R200_200") + ",1");
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if (paramString != null)
          {
            paramString.a(this.nfd, new l.3(this), new l.4(this));
            AppMethodBeat.o(128300);
            return;
          }
          bzy();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramString = paramString.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R200_200") + ",2");
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -355)
        {
          y.f(this.nfd, paramString, 32046);
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.nfd, this.nfd.getString(r.j.bind_mcontact_err_freq_limit), "", true);
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
        if (((com.tencent.mm.modelfriend.a)paramq).bkZ() != 1) {
          break label849;
        }
        localObject = this.nfd.nfG + this.nfd.nfH;
        String str1 = ((com.tencent.mm.modelfriend.a)paramq).blb();
        String str2 = ((com.tencent.mm.modelfriend.a)paramq).bla();
        paramq = new Intent(this.nfd, RegByMobileSendSmsUI.class);
        paramq.putExtra("from_mobile", (String)localObject);
        paramq.putExtra("to_mobile", str1);
        paramq.putExtra("verify_code", str2);
        paramq.putExtra("key_reg_style", 2);
        paramq.putExtra("kintent_password", this.nfd.ndD.getText().toString());
        paramq.putExtra("regsession_id", this.nfm);
        localObject = this.nfd;
        paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramq.aFh(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileInputUI)localObject).startActivity((Intent)paramq.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label849:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if ((paramString == null) || (this.nfd == null) || (!paramString.a(this.nfd, null, null))) {
            break;
          }
          AppMethodBeat.o(128300);
          return;
          com.tencent.mm.plugin.b.a.bkD("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.nfd.nfG + " " + this.nfd.nft.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.nfd.nfH);
          ((Intent)localObject).putExtra("country_name", this.nfd.lSz);
          ((Intent)localObject).putExtra("couttry_code", this.nfd.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramq).ble());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramq).blf());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramq).blg());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramq).blh());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.nfd.ndD.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.nfm);
          ((Intent)localObject).setClass(this.nfd, MobileVerifyUI.class);
          paramq = this.nfd;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramq, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramq, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.l.a(l.a.nad);
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.nfd, this.nfd.getString(r.j.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      } while (!com.tencent.mm.plugin.account.sdk.a.mIH.a(this.nfd, paramInt1, paramInt2, paramString));
      label1193:
      AppMethodBeat.o(128300);
      return;
    }
    AppMethodBeat.o(128300);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128297);
    com.tencent.mm.kernel.h.aGY().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.bgi("R200_100");
    this.nfg = 0;
    AppMethodBeat.o(128297);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128298);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R200_100") + ",2");
    AppMethodBeat.o(128298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */