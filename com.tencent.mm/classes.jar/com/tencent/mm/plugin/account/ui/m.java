package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.s;

public final class m
  implements i, MobileInputUI.b
{
  private String account;
  private String fJS;
  private String fXu;
  private SecurityImage mUP = null;
  private String nbl;
  private boolean ndk = true;
  private String ndm;
  private MobileInputUI nfd;
  
  private void aba(String paramString)
  {
    AppMethodBeat.i(128324);
    paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.nfd;
    MobileInputUI localMobileInputUI2 = this.nfd;
    this.nfd.getString(r.j.app_tip);
    localMobileInputUI1.mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.nfd.getString(r.j.app_waiting), true, new m.17(this, paramString));
    AppMethodBeat.o(128324);
  }
  
  private void bzz()
  {
    AppMethodBeat.i(128320);
    if (this.nfd.ltN == 6)
    {
      this.nfd.nfv.reset();
      this.nfd.nfD.setText(r.j.login_login_by_password);
      this.nfd.neK.setVisibility(8);
      this.nfd.nfv.setVisibility(0);
      this.nfd.nfv.getContentEditText().requestFocus();
      this.nfd.nfv.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128311);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          m.a(m.this, m.a(m.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128311);
        }
      });
      this.nfd.nfD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128312);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          m.b(m.this).nei[1] = 2;
          m.b(m.this).ltN = 7;
          m.b(m.this).nfv.reset();
          com.tencent.mm.kernel.h.aGY().b(145, m.this);
          m.c(m.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128312);
        }
      });
      AppMethodBeat.o(128320);
      return;
    }
    if (this.nfd.ltN == 7)
    {
      this.nfd.nfD.setText(r.j.login_login_by_sms);
      this.nfd.neK.setVisibility(0);
      this.nfd.ndD.requestFocus();
      this.nfd.nfv.setVisibility(8);
      this.nfd.nfD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128313);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          m.b(m.this).nei[1] = 1;
          m.b(m.this).ltN = 6;
          com.tencent.mm.kernel.h.aGY().a(145, m.this);
          m.c(m.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128313);
        }
      });
    }
    AppMethodBeat.o(128320);
  }
  
  private void ci(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128325);
    if (Util.isNullOrNil(paramString1))
    {
      com.tencent.mm.ui.base.h.p(this.nfd, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128325);
      return;
    }
    if (Util.isNullOrNil(paramString2))
    {
      com.tencent.mm.ui.base.h.p(this.nfd, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128325);
      return;
    }
    this.nfd.ndD.setText(paramString2);
    this.nfd.hideVKB();
    paramString1 = new com.tencent.mm.modelsimple.t(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    paramString2 = this.nfd;
    MobileInputUI localMobileInputUI = this.nfd;
    this.nfd.getString(r.j.app_tip);
    paramString2.mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.nfd.getString(r.j.login_logining), true, new m.18(this, paramString1));
    AppMethodBeat.o(128325);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128327);
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(this.nfd, paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128327);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(128327);
      return false;
    case -1: 
      if (com.tencent.mm.kernel.h.aGY().bih() == 5)
      {
        com.tencent.mm.ui.base.h.p(this.nfd, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128327);
        return true;
      }
      AppMethodBeat.o(128327);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.p(this.nfd, r.j.errcode_password, r.j.login_err_title);
      AppMethodBeat.o(128327);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.p(this.nfd, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128327);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.kernel.b.aGF();
      MobileInputUI localMobileInputUI = this.nfd;
      com.tencent.mm.kernel.h.aHE();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aGs())) {}
      for (paramString = com.tencent.mm.ci.a.ba(this.nfd, r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aGs())
      {
        com.tencent.mm.ui.base.h.a(localMobileInputUI, paramString, this.nfd.getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128327);
        return true;
        com.tencent.mm.kernel.h.aHE();
      }
    case -140: 
      if (!Util.isNullOrNil(this.fXu)) {
        y.p(this.nfd, paramString, this.fXu);
      }
      AppMethodBeat.o(128327);
      return true;
    case -34: 
      Toast.makeText(this.nfd, r.j.bind_mcontact_err_freq_limit, 0).show();
      AppMethodBeat.o(128327);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.a(this.nfd, r.j.bind_mcontact_verify_error, r.j.bind_mcontact_verify_tip, null);
      AppMethodBeat.o(128327);
      return true;
    }
    com.tencent.mm.ui.base.h.a(this.nfd, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, null);
    AppMethodBeat.o(128327);
    return true;
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128323);
    switch (11.nfi[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128323);
      return;
      this.nfd.hideVKB();
      this.nfd.nfG = PhoneFormater.countryCodeWithPlus(this.nfd.countryCode);
      this.nfd.nfH = this.nfd.nfu.getText().toString();
      if ((Util.isNullOrNil(this.nfd.nfG)) || (Util.isNullOrNil(this.nfd.nfH)))
      {
        AppMethodBeat.o(128323);
        return;
      }
      if (this.nfd.ltN == 7)
      {
        if (!Util.isNullOrNil(this.fJS))
        {
          ci(this.account, this.fJS);
          AppMethodBeat.o(128323);
          return;
        }
        ci(this.account, this.nfd.ndD.getText().toString());
        AppMethodBeat.o(128323);
        return;
      }
      if (this.nfd.ltN == 6)
      {
        parama = this.nfd.nfv.getText().toString().trim();
        if (Util.isNullOrNil(parama))
        {
          com.tencent.mm.ui.base.h.p(this.nfd, r.j.verify_seccode_tip, r.j.login_err_title);
          AppMethodBeat.o(128323);
          return;
        }
        this.nfd.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.h.aGY().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.nfd;
        MobileInputUI localMobileInputUI2 = this.nfd;
        this.nfd.getString(r.j.app_tip);
        localMobileInputUI1.mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.nfd.getString(r.j.bind_mcontact_verifing), true, new m.16(this, parama));
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128319);
    this.nfd = paramMobileInputUI;
    paramMobileInputUI.nfB.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (Util.isNullOrNil(this.account)) {
      this.account = PhoneFormater.pureNumber(paramMobileInputUI.nfG + paramMobileInputUI.nfH);
    }
    paramMobileInputUI.nfu.setTextColor(paramMobileInputUI.getResources().getColor(r.c.hint_text_color));
    paramMobileInputUI.nfu.setEnabled(false);
    paramMobileInputUI.nfu.setFocusable(false);
    paramMobileInputUI.nft.setFocusable(false);
    paramMobileInputUI.nft.setText(PhoneFormater.pureNumber(this.account));
    paramMobileInputUI.nft.setVisibility(0);
    bzz();
    paramMobileInputUI.nfD.setVisibility(0);
    paramMobileInputUI.nfz.setText(r.j.login_login);
    paramMobileInputUI.nfz.setVisibility(0);
    paramMobileInputUI.nfz.setEnabled(true);
    this.ndm = bg.ltv.aD("login_weixin_username", "");
    this.nbl = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!Util.isNullOrNil(this.nbl)) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128303);
          m.a(m.this, g.bzw(), g.bzx());
          AppMethodBeat.o(128303);
        }
      }, 500L);
    }
    AppMethodBeat.o(128319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128326);
    Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.nfd.mUN != null)
    {
      this.nfd.mUN.dismiss();
      this.nfd.mUN = null;
    }
    if (paramq.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          localObject = com.tencent.mm.h.a.Kb(paramString);
          if (((com.tencent.mm.modelfriend.a)paramq).bkZ() != 1) {
            break label234;
          }
          Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
          if (localObject != null)
          {
            ((com.tencent.mm.h.a)localObject).a(this.nfd, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128318);
                m.d(m.this);
                AppMethodBeat.o(128318);
              }
            }, null);
            AppMethodBeat.o(128326);
            return;
          }
          com.tencent.mm.ui.base.h.a(this.nfd, this.nfd.getString(r.j.login_by_sms_up_tip), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128304);
              m.d(m.this);
              AppMethodBeat.o(128304);
            }
          }, null);
        }
      }
    }
    label234:
    while ((paramq.getType() != 252) && (paramq.getType() != 701)) {
      for (;;)
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if ((paramString == null) || (this.nfd == null) || (!paramString.a(this.nfd, null, null))) {
          break;
        }
        AppMethodBeat.o(128326);
        return;
        if (localObject != null)
        {
          ((com.tencent.mm.h.a)localObject).a(this.nfd, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128305);
              m.b(m.this).nfv.cgz();
              m.b(m.this, m.a(m.this));
              AppMethodBeat.o(128305);
            }
          }, null);
          AppMethodBeat.o(128326);
          return;
        }
        this.nfd.nfv.cgz();
        aba(this.account);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            this.nfd.nfv.reset();
            com.tencent.mm.ui.base.h.p(this.nfd, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -75)
          {
            this.nfd.nfv.reset();
            com.tencent.mm.ui.base.h.c(this.nfd, this.nfd.getString(r.j.alpha_version_tip_login), "", true);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -106)
          {
            this.nfd.nfv.reset();
            y.f(this.nfd, paramString, 32045);
            AppMethodBeat.o(128326);
          }
        }
        else if (i == 17)
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            new h(new h.a()
            {
              public final void a(ProgressDialog paramAnonymousProgressDialog)
              {
                AppMethodBeat.i(218617);
                m.b(m.this).mUN = ((s)paramAnonymousProgressDialog);
                AppMethodBeat.o(218617);
              }
            }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bkV(), this.account).c(this.nfd);
            AppMethodBeat.o(128326);
            return;
          }
          if (n(paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(128326);
            return;
          }
          paramq = com.tencent.mm.h.a.Kb(paramString);
          if (paramq != null) {
            paramq.a(this.nfd, null, null);
          }
        }
      }
    }
    this.fXu = ((com.tencent.mm.modelsimple.t)paramq).boA();
    Object localObject = new g();
    ((g)localObject).mUS = ((com.tencent.mm.modelsimple.t)paramq).boB();
    ((g)localObject).mUR = ((com.tencent.mm.modelsimple.t)paramq).boC();
    ((g)localObject).mUT = ((com.tencent.mm.modelsimple.t)paramq).boD();
    ((g)localObject).neB = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
    ((g)localObject).account = ((com.tencent.mm.modelsimple.t)paramq).account;
    ((g)localObject).mUQ = this.nfd.ndD.getText().toString();
    if (paramInt2 == -75)
    {
      y.dw(this.nfd);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -106)
    {
      y.f(this.nfd, paramString, 32045);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this.nfd, e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -205)
    {
      this.nbl = ((com.tencent.mm.modelsimple.t)paramq).bkX();
      paramString = ((com.tencent.mm.modelsimple.t)paramq).boF();
      paramq = ((com.tencent.mm.modelsimple.t)paramq).boI();
      Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.nbl), paramq });
      g.a((g)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.nbl);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramq);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.sdk.a.mIG.g(this.nfd, (Intent)localObject);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!Util.isNullOrNil(this.fXu)) {
        y.p(this.nfd, paramString, this.fXu);
      }
      AppMethodBeat.o(128326);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.h.aGY().a(new bv(new m.5(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.mUP == null)
        {
          this.mUP = SecurityImage.a.a(this.nfd, r.j.regbyqq_secimg_title, ((g)localObject).neB, ((g)localObject).mUR, ((g)localObject).mUS, ((g)localObject).mUT, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128308);
              Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.nfr.mUS + " img len" + this.nfr.mUR.length + " " + f.avD());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(this.nfr.account, this.nfr.mUQ, this.nfr.neB, m.e(m.this).getSecImgCode(), m.e(m.this).getSecImgSid(), m.e(m.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = m.b(m.this);
              MobileInputUI localMobileInputUI2 = m.b(m.this);
              m.b(m.this).getString(r.j.app_tip);
              localMobileInputUI1.mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI2, m.b(m.this).getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128307);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128307);
                }
              });
              AppMethodBeat.o(128308);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(220347);
              m.f(m.this);
              AppMethodBeat.o(220347);
            }
          }, (SecurityImage.b)localObject);
          AppMethodBeat.o(128326);
          return;
        }
        Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((g)localObject).mUS + " img len" + ((g)localObject).mUR.length + " " + f.avD());
        this.mUP.b(((g)localObject).neB, ((g)localObject).mUR, ((g)localObject).mUS, ((g)localObject).mUT);
        AppMethodBeat.o(128326);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.kernel.b.aGG();
        com.tencent.mm.plugin.account.friend.a.l.byn();
        Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((g)localObject).account });
        y.ZV(((g)localObject).account);
        paramString = bg.ltv.aD("login_weixin_username", "");
        com.tencent.mm.platformtools.t.jdMethod_do(this.nfd);
        if (this.nfd.ndl)
        {
          ci.lvQ.aV(this.ndm, paramString);
          ci.lvQ.g(z.bcZ(), z.bdU());
          com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ci.lvQ.bft() });
        }
        y.showAddrBookUploadConfirm(this.nfd, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128309);
            Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(m.b(m.this));
            ((Intent)localObject).addFlags(67108864);
            MobileInputUI localMobileInputUI = m.b(m.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localMobileInputUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMobileInputUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localMobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            m.b(m.this).finish();
            AppMethodBeat.o(128309);
          }
        }, false, 2);
        if (this.nfd.ltN == 6)
        {
          this.ndk = ((com.tencent.mm.modelsimple.t)paramq).boK();
          if (((com.tencent.mm.modelsimple.t)paramq).boE())
          {
            paramString = this.nfd;
            boolean bool = this.ndk;
            paramq = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramq.putExtra("kintent_hint", paramString.getString(r.j.settings_modify_password_tip));
            paramq.putExtra("kintent_cancelable", bool);
            paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
            com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramq.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128326);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128326);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      Toast.makeText(this.nfd, this.nfd.getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128326);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128321);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.bgi("L200_100");
    AppMethodBeat.o(128321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128322);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("L200_100") + ",2");
    AppMethodBeat.o(128322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */