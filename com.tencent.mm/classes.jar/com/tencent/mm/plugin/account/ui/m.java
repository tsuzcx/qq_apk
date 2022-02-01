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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class m
  implements com.tencent.mm.am.h, MobileInputUI.b
{
  private String account;
  private String hPy;
  private String idu;
  private SecurityImage pRw = null;
  private String pYt;
  private boolean pZv = true;
  private String qaF;
  private MobileInputUI qcl;
  
  private void Tq(final String paramString)
  {
    AppMethodBeat.i(128324);
    paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
    com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.qcl;
    MobileInputUI localMobileInputUI2 = this.qcl;
    this.qcl.getString(r.j.app_tip);
    localMobileInputUI1.pRu = k.a(localMobileInputUI2, this.qcl.getString(r.j.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128316);
        com.tencent.mm.kernel.h.aZW().a(paramString);
        AppMethodBeat.o(128316);
      }
    });
    AppMethodBeat.o(128324);
  }
  
  private void bYl()
  {
    AppMethodBeat.i(128320);
    if (this.qcl.olm == 6)
    {
      this.qcl.qcD.reset();
      this.qcl.qcM.setText(r.j.login_login_by_password);
      this.qcl.qby.setVisibility(8);
      this.qcl.qcD.setVisibility(0);
      this.qcl.qcD.getContentEditText().requestFocus();
      this.qcl.qcD.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128311);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          m.a(m.this, m.a(m.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128311);
        }
      });
      this.qcl.qcM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128312);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          m.b(m.this).pZy[1] = 2;
          m.b(m.this).olm = 7;
          m.b(m.this).qcD.reset();
          com.tencent.mm.kernel.h.aZW().b(145, m.this);
          m.c(m.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128312);
        }
      });
      AppMethodBeat.o(128320);
      return;
    }
    if (this.qcl.olm == 7)
    {
      this.qcl.qcM.setText(r.j.login_login_by_sms);
      this.qcl.qby.setVisibility(0);
      this.qcl.qaR.requestFocus();
      this.qcl.qcD.setVisibility(8);
      this.qcl.qcM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128313);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          m.b(m.this).pZy[1] = 1;
          m.b(m.this).olm = 6;
          com.tencent.mm.kernel.h.aZW().a(145, m.this);
          m.c(m.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128313);
        }
      });
    }
    AppMethodBeat.o(128320);
  }
  
  private void cw(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(128325);
    if (Util.isNullOrNil(paramString1))
    {
      k.s(this.qcl, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128325);
      return;
    }
    if (Util.isNullOrNil(paramString2))
    {
      k.s(this.qcl, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128325);
      return;
    }
    this.qcl.qaR.setText(paramString2);
    this.qcl.hideVKB();
    paramString1 = new u(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    paramString2 = this.qcl;
    MobileInputUI localMobileInputUI = this.qcl;
    this.qcl.getString(r.j.app_tip);
    paramString2.pRu = k.a(localMobileInputUI, this.qcl.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128317);
        com.tencent.mm.kernel.h.aZW().a(paramString1);
        AppMethodBeat.o(128317);
      }
    });
    AppMethodBeat.o(128325);
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128327);
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this.qcl, paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
      {
        k.s(this.qcl, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128327);
        return true;
      }
      AppMethodBeat.o(128327);
      return false;
    case -3: 
      k.s(this.qcl, r.j.errcode_password, r.j.login_err_title);
      AppMethodBeat.o(128327);
      return true;
    case -9: 
      k.s(this.qcl, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128327);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.kernel.b.aZH();
      MobileInputUI localMobileInputUI = this.qcl;
      com.tencent.mm.kernel.h.baC();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
      for (paramString = com.tencent.mm.cd.a.bt(this.qcl, r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aZu())
      {
        k.a(localMobileInputUI, paramString, this.qcl.getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128327);
        return true;
        com.tencent.mm.kernel.h.baC();
      }
    case -140: 
      if (!Util.isNullOrNil(this.idu)) {
        v.r(this.qcl, paramString, this.idu);
      }
      AppMethodBeat.o(128327);
      return true;
    case -34: 
      Toast.makeText(this.qcl, r.j.bind_mcontact_err_freq_limit, 0).show();
      AppMethodBeat.o(128327);
      return true;
    case -32: 
      k.a(this.qcl, r.j.bind_mcontact_verify_error, r.j.bind_mcontact_verify_tip, null);
      AppMethodBeat.o(128327);
      return true;
    }
    k.a(this.qcl, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, null);
    AppMethodBeat.o(128327);
    return true;
  }
  
  public final void a(final MobileInputUI.a parama)
  {
    AppMethodBeat.i(128323);
    switch (11.qcq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128323);
      return;
      Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "goNext");
      this.qcl.hideVKB();
      this.qcl.qcP = PhoneFormater.countryCodeWithPlus(this.qcl.countryCode);
      this.qcl.qcQ = this.qcl.qcC.getText().toString();
      if ((Util.isNullOrNil(this.qcl.qcP)) || (Util.isNullOrNil(this.qcl.qcQ)))
      {
        AppMethodBeat.o(128323);
        return;
      }
      if (this.qcl.olm == 7)
      {
        if (!Util.isNullOrNil(this.hPy))
        {
          cw(this.account, this.hPy);
          AppMethodBeat.o(128323);
          return;
        }
        cw(this.account, this.qcl.qaR.getText().toString());
        AppMethodBeat.o(128323);
        return;
      }
      if (this.qcl.olm == 6)
      {
        parama = this.qcl.qcD.getText().toString().trim();
        if (Util.isNullOrNil(parama))
        {
          k.s(this.qcl, r.j.verify_seccode_tip, r.j.login_err_title);
          AppMethodBeat.o(128323);
          return;
        }
        this.qcl.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.h.aZW().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.qcl;
        MobileInputUI localMobileInputUI2 = this.qcl;
        this.qcl.getString(r.j.app_tip);
        localMobileInputUI1.pRu = k.a(localMobileInputUI2, this.qcl.getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128315);
            com.tencent.mm.kernel.h.aZW().a(parama);
            AppMethodBeat.o(128315);
          }
        });
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128319);
    this.qcl = paramMobileInputUI;
    paramMobileInputUI.qcK.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (Util.isNullOrNil(this.account)) {
      this.account = PhoneFormater.pureNumber(paramMobileInputUI.qcP + paramMobileInputUI.qcQ);
    }
    paramMobileInputUI.qcC.setTextColor(paramMobileInputUI.getResources().getColor(r.c.hint_text_color));
    paramMobileInputUI.qcC.setEnabled(false);
    paramMobileInputUI.qcC.setFocusable(false);
    paramMobileInputUI.qcB.setFocusable(false);
    paramMobileInputUI.qcB.setText(PhoneFormater.pureNumber(this.account));
    paramMobileInputUI.qcB.setVisibility(0);
    bYl();
    paramMobileInputUI.qcM.setVisibility(0);
    paramMobileInputUI.qcH.setText(r.j.login_login);
    paramMobileInputUI.qcH.setVisibility(0);
    paramMobileInputUI.qcH.setEnabled(true);
    this.qaF = bg.okT.aM("login_weixin_username", "");
    this.pYt = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!Util.isNullOrNil(this.pYt)) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128303);
          m.a(m.this, f.bYd(), f.bYe());
          AppMethodBeat.o(128303);
        }
      }, 500L);
    }
    AppMethodBeat.o(128319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128326);
    Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qcl.pRu != null)
    {
      this.qcl.pRu.dismiss();
      this.qcl.pRu = null;
    }
    if (paramp.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          localObject = com.tencent.mm.broadcast.a.CH(paramString);
          if (((com.tencent.mm.modelfriend.a)paramp).bIT() != 1) {
            break label234;
          }
          Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
          if (localObject != null)
          {
            ((com.tencent.mm.broadcast.a)localObject).a(this.qcl, new DialogInterface.OnClickListener()
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
          k.a(this.qcl, this.qcl.getString(r.j.login_by_sms_up_tip), "", new DialogInterface.OnClickListener()
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
    while ((paramp.getType() != 252) && (paramp.getType() != 701)) {
      for (;;)
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if ((paramString == null) || (this.qcl == null) || (!paramString.a(this.qcl, null, null))) {
          break;
        }
        AppMethodBeat.o(128326);
        return;
        if (localObject != null)
        {
          ((com.tencent.mm.broadcast.a)localObject).a(this.qcl, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128305);
              m.b(m.this).qcD.cHv();
              m.b(m.this, m.a(m.this));
              AppMethodBeat.o(128305);
            }
          }, null);
          AppMethodBeat.o(128326);
          return;
        }
        this.qcl.qcD.cHv();
        Tq(this.account);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            this.qcl.qcD.reset();
            k.s(this.qcl, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -75)
          {
            this.qcl.qcD.reset();
            k.c(this.qcl, this.qcl.getString(r.j.alpha_version_tip_login), "", true);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -106)
          {
            this.qcl.qcD.reset();
            v.f(this.qcl, paramString, 0);
            AppMethodBeat.o(128326);
          }
        }
        else if (i == 17)
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            new h(new h.a()
            {
              public final void b(ProgressDialog paramAnonymousProgressDialog)
              {
                AppMethodBeat.i(305148);
                m.b(m.this).pRu = ((w)paramAnonymousProgressDialog);
                AppMethodBeat.o(305148);
              }
            }, ((com.tencent.mm.modelfriend.a)paramp).getUsername(), ((com.tencent.mm.modelfriend.a)paramp).bIP(), this.account).d(this.qcl);
            AppMethodBeat.o(128326);
            return;
          }
          if (p(paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(128326);
            return;
          }
          paramp = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramp != null) {
            paramp.a(this.qcl, null, null);
          }
        }
      }
    }
    this.idu = ((u)paramp).bMh();
    Object localObject = new f();
    ((f)localObject).pRz = ((u)paramp).bMi();
    ((f)localObject).pRy = ((u)paramp).bMj();
    ((f)localObject).pRA = ((u)paramp).bMk();
    ((f)localObject).qbo = ((u)paramp).getSecCodeType();
    ((f)localObject).account = ((u)paramp).account;
    ((f)localObject).pRx = this.qcl.qaR.getText().toString();
    if (paramInt2 == -75)
    {
      v.ei(this.qcl);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -106)
    {
      v.f(this.qcl, paramString, 32045);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -217)
    {
      v.a(this.qcl, com.tencent.mm.platformtools.e.d((u)paramp), paramInt2);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -205)
    {
      this.pYt = ((u)paramp).bIR();
      paramString = ((u)paramp).bMm();
      paramp = ((u)paramp).bMp();
      Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.pYt), paramp });
      f.a((f)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.pYt);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramp);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.sdk.a.pFn.g(this.qcl, (Intent)localObject);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!Util.isNullOrNil(this.idu)) {
        v.r(this.qcl, paramString, this.idu);
      }
      AppMethodBeat.o(128326);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
      {
        public final void b(g paramAnonymousg)
        {
          AppMethodBeat.i(128306);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128306);
            return;
          }
          paramAnonymousg = paramAnonymousg.bGg();
          com.tencent.mm.kernel.h.baC();
          int i = com.tencent.mm.kernel.b.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128306);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.pRw == null)
        {
          this.pRw = SecurityImage.a.a(this.qcl, r.j.regbyqq_secimg_title, ((f)localObject).qbo, ((f)localObject).pRy, ((f)localObject).pRz, ((f)localObject).pRA, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128308);
              Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.qcz.pRz + " img len" + this.qcz.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
              paramAnonymousDialogInterface = new u(this.qcz.account, this.qcz.pRx, this.qcz.qbo, m.e(m.this).getSecImgCode(), m.e(m.this).getSecImgSid(), m.e(m.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = m.b(m.this);
              MobileInputUI localMobileInputUI2 = m.b(m.this);
              m.b(m.this).getString(r.j.app_tip);
              localMobileInputUI1.pRu = k.a(localMobileInputUI2, m.b(m.this).getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128307);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128307);
                }
              });
              AppMethodBeat.o(128308);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(305136);
              m.f(m.this);
              AppMethodBeat.o(305136);
            }
          }, (SecurityImage.b)localObject);
          AppMethodBeat.o(128326);
          return;
        }
        Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).pRz + " img len" + ((f)localObject).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
        this.pRw.b(((f)localObject).qbo, ((f)localObject).pRy, ((f)localObject).pRz, ((f)localObject).pRA);
        AppMethodBeat.o(128326);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.kernel.b.aZI();
        i.bXa();
        Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((f)localObject).account });
        v.Sj(((f)localObject).account);
        paramString = bg.okT.aM("login_weixin_username", "");
        if (this.qcl.qaE)
        {
          cj.ono.bf(this.qaF, paramString);
          cj.ono.g(z.bAM(), z.bBM());
          com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
        }
        v.showAddrBookUploadConfirm(this.qcl, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128309);
            Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(m.b(m.this));
            ((Intent)localObject).addFlags(67108864);
            MobileInputUI localMobileInputUI = m.b(m.this);
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localMobileInputUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMobileInputUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localMobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            m.b(m.this).finish();
            AppMethodBeat.o(128309);
          }
        }, false, 2);
        if (this.qcl.olm == 6)
        {
          this.pZv = ((u)paramp).bMr();
          if (((u)paramp).bMl())
          {
            paramString = this.qcl;
            boolean bool = this.pZv;
            paramp = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramp.putExtra("kintent_hint", paramString.getString(r.j.settings_modify_password_tip));
            paramp.putExtra("kintent_cancelable", bool);
            paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
            com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramp.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128326);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128326);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      Toast.makeText(this.qcl, this.qcl.getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128326);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128321);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.Tz("L200_100");
    AppMethodBeat.o(128321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128322);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("L200_100") + ",2");
    AppMethodBeat.o(128322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */