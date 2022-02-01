package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;

public class LoginByMobileSendSmsUI
  extends MMActivity
  implements i
{
  private TextView contentView;
  private String fXu;
  private SecurityImage mUP;
  protected String nbl;
  private String ncp;
  private String ndh;
  private String ndi;
  private g ndj;
  private boolean ndk;
  private boolean ndl;
  private String ndm;
  private String ndn;
  protected String ndo;
  private h ndp;
  private ProgressDialog ndq;
  private int ndr;
  private Button nds;
  private Button ndt;
  private TextView ndu;
  private MTimerHandler ndv;
  private int ndw;
  
  public LoginByMobileSendSmsUI()
  {
    AppMethodBeat.i(128070);
    this.ndh = "";
    this.ncp = "";
    this.ndi = "";
    this.ndj = new g();
    this.mUP = null;
    this.fXu = "";
    this.ndo = "";
    this.ndw = 15;
    AppMethodBeat.o(128070);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.m aaX(String paramString)
  {
    AppMethodBeat.i(128073);
    com.tencent.mm.pluginsdk.ui.span.m localm = new com.tencent.mm.pluginsdk.ui.span.m(paramString);
    Log.d("MicroMsg.LoginByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localm.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(r.d.HugersTextSize)), i, paramString.length(), 33);
    localm.setSpan(new ForegroundColorSpan(getResources().getColor(r.c.green_text_color)), i, paramString.length(), 33);
    AppMethodBeat.o(128073);
    return localm;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128078);
    com.tencent.mm.ui.base.h.a(this, getString(r.j.regbymobile_reg_quit_send_sms), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128062);
        LoginByMobileSendSmsUI.l(LoginByMobileSendSmsUI.this);
        LoginByMobileSendSmsUI.this.finish();
        AppMethodBeat.o(128062);
      }
    }, null);
    AppMethodBeat.o(128078);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(128077);
    if (this.ndv != null) {
      this.ndv.stopTimer();
    }
    this.ndt.setText(r.j.regbymobile_reg_no_sim_send_sms_btn_title);
    this.ndt.setEnabled(true);
    AppMethodBeat.o(128077);
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_send_sms_up;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128072);
    super.initView();
    ((TextView)findViewById(r.f.send_sms_tip)).setText(getString(r.j.regbymobile_reg_send_sms_tip, new Object[] { this.ndh }));
    this.contentView = ((TextView)findViewById(r.f.send_sms_content));
    this.contentView.setText(aaX(getString(r.j.regbymobile_reg_send_sms_content, new Object[] { this.ncp })));
    this.ndu = ((TextView)findViewById(r.f.send_sms_to));
    this.ndu.setText(aaX(getString(r.j.regbymobile_reg_send_sms_to, new Object[] { this.ndi })));
    this.nds = ((Button)findViewById(r.f.send_sms_btn));
    this.ndt = ((Button)findViewById(r.f.next_btn));
    setMMTitle(r.j.regbymobile_reg_send_sms_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128059);
        LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this);
        AppMethodBeat.o(128059);
        return true;
      }
    });
    this.ndj.account = this.ndh;
    AppMethodBeat.o(128072);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128071);
    super.onCreate(paramBundle);
    this.ndh = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.ndl = getIntent().getBooleanExtra("from_switch_account", false);
    this.ndm = bg.ltv.aD("login_weixin_username", "");
    initView();
    paramBundle = new com.tencent.mm.modelfriend.a(this.ndh, 16, "", 0, "", 1);
    com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
    getString(r.j.app_tip);
    this.ndq = com.tencent.mm.ui.base.h.a(this, getString(r.j.app_waiting), true, new LoginByMobileSendSmsUI.9(this, paramBundle));
    AppMethodBeat.o(128071);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128079);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(128079);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128079);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128074);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(145, this);
    AppMethodBeat.o(128074);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(128076);
    Log.i("MicroMsg.LoginByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq.getType() == 145)
    {
      if (this.ndq != null) {
        this.ndq.dismiss();
      }
      paramInt1 = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      if (paramInt1 == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(r.j.alpha_version_tip_login), "", true);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -106)
        {
          y.f(this, paramString, 32045);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == 0)
        {
          this.ncp = ((com.tencent.mm.modelfriend.a)paramq).bla();
          this.ndi = ((com.tencent.mm.modelfriend.a)paramq).blb();
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "verifyCode %s, smsUpMobile %s", new Object[] { this.ncp, this.ndi });
          this.contentView.setText(aaX(getString(r.j.regbymobile_reg_send_sms_content, new Object[] { this.ncp })));
          this.ndu.setText(aaX(getString(r.j.regbymobile_reg_send_sms_to, new Object[] { this.ndi })));
          if (Util.isNullOrNil(new String[] { this.ndh, this.ndi, this.ncp }))
          {
            this.nds.setEnabled(false);
            this.ndt.setEnabled(false);
          }
          while (Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.auI()))
          {
            this.nds.setVisibility(8);
            AppMethodBeat.o(128076);
            return;
            this.ndt.setOnClickListener(new LoginByMobileSendSmsUI.7(this));
          }
          this.nds.setOnClickListener(new LoginByMobileSendSmsUI.8(this));
          AppMethodBeat.o(128076);
        }
      }
      else if (paramInt1 == 17)
      {
        if (paramInt2 == 0)
        {
          paramString = this.ndh;
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bkV();
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "start auto login");
          com.tencent.mm.kernel.h.aGY().a(701, this);
          com.tencent.mm.kernel.h.aGY().a(252, this);
          this.ndp = new h(new h.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(128060);
              LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this, paramAnonymousProgressDialog);
              AppMethodBeat.o(128060);
            }
          }, paramString, paramq, this.ndh);
          this.ndp.c(this);
          AppMethodBeat.o(128076);
          return;
        }
        if ((!Util.isNullOrNil(paramString)) && (this.ndr >= 4))
        {
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if ((paramString != null) && (paramString.a(this, null, null)))
          {
            AppMethodBeat.o(128076);
            return;
          }
        }
        AppMethodBeat.o(128076);
        return;
      }
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(128076);
        return;
      }
      AppMethodBeat.o(128076);
      return;
    }
    int i;
    if ((paramq.getType() == 701) || (paramq.getType() == 252))
    {
      com.tencent.mm.kernel.h.aGY().b(701, this);
      com.tencent.mm.kernel.h.aGY().b(252, this);
      this.ndj.neB = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
      this.ndj.mUS = ((com.tencent.mm.modelsimple.t)paramq).boB();
      this.ndj.mUR = ((com.tencent.mm.modelsimple.t)paramq).boC();
      this.ndj.mUT = ((com.tencent.mm.modelsimple.t)paramq).boD();
      if (paramInt2 == -205)
      {
        this.nbl = ((com.tencent.mm.modelsimple.t)paramq).bkX();
        this.ndn = ((com.tencent.mm.modelsimple.t)paramq).boI();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label2047;
      }
      i = 1;
      com.tencent.mm.kernel.h.aGY().a(new bv(new LoginByMobileSendSmsUI.10(this)), 0);
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        stopTimer();
        b.aGG();
        com.tencent.mm.plugin.account.friend.a.l.byn();
        com.tencent.mm.platformtools.t.jdMethod_do(this);
        y.ZV(this.ndj.account);
        paramString = bg.ltv.aD("login_weixin_username", "");
        if (this.ndl)
        {
          ci.lvQ.aV(this.ndm, paramString);
          ci.lvQ.g(z.bcZ(), z.bdU());
          com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ci.lvQ.bft() });
        }
        if ((this.ndq != null) && (this.ndq.isShowing())) {
          this.ndq.setMessage(getString(r.j.app_loading));
        }
        paramString = (com.tencent.mm.modelsimple.t)paramq;
        Log.i("MicroMsg.LoginByMobileSendSmsUI", "checktask LoginByMobileSendSmsUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
        Intent localIntent = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
        localIntent.addFlags(67108864);
        if (paramString != null)
        {
          localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramString.boG());
          localIntent.putExtra("kstyle_bind_recommend_show", paramString.boJ());
          localIntent.putExtra("kstyle_bind_wording", paramString.boH());
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        this.ndk = ((com.tencent.mm.modelsimple.t)paramq).boK();
        if (((com.tencent.mm.modelsimple.t)paramq).boE())
        {
          boolean bool = this.ndk;
          paramString = new Intent(this, RegByMobileSetPwdUI.class);
          paramString.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
          paramString.putExtra("kintent_cancelable", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128076);
        return;
      }
      if ((this.ndq != null) && (this.ndq.isShowing()))
      {
        this.ndq.dismiss();
        this.ndq = null;
      }
      if (paramInt2 == -106)
      {
        y.f(this, paramString, 31685);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        if (com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString))
        {
          if (this.mUP != null) {
            this.mUP.dismiss();
          }
          i = 1;
        }
        break;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128076);
        return;
        com.tencent.mm.ui.base.h.p(this, r.j.errcode_password, r.j.login_err_title);
        i = 1;
        continue;
        if (com.tencent.mm.kernel.h.aGY().bih() == 5)
        {
          com.tencent.mm.ui.base.h.p(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
          i = 1;
        }
        else
        {
          com.tencent.mm.ui.base.h.p(this, r.j.login_err_mailnotverify, r.j.login_err_title);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.p(this, r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
          i = 1;
          continue;
          y.dw(this);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.d(this, getString(r.j.bind_mcontact_verify_error), "", new LoginByMobileSendSmsUI.11(this));
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new LoginByMobileSendSmsUI.12(this));
          i = 1;
          continue;
          com.tencent.mm.kernel.h.aGY().a(701, this);
          com.tencent.mm.kernel.h.aGY().a(252, this);
          if (this.mUP == null) {
            this.mUP = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                int i = -1;
                AppMethodBeat.i(128068);
                Log.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).mUS + " img len" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).mUR.length + " " + f.avD());
                int j = paramInt1;
                if (LoginByMobileSendSmsUI.this.ndo == null)
                {
                  paramAnonymousInt = -1;
                  paramAnonymousDialogInterface = Util.secPrint(LoginByMobileSendSmsUI.this.ndo);
                  if (LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).mUQ != null) {
                    break label382;
                  }
                }
                for (;;)
                {
                  Log.d("MicroMsg.LoginByMobileSendSmsUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), Util.secPrint(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).mUQ) });
                  paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).account, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).mUQ, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).neB, LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgCode(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgSid(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgEncryptKey(), 0, "", false, false);
                  if ((Util.isNullOrNil(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).mUQ)) && (!Util.isNullOrNil(LoginByMobileSendSmsUI.this.ndo)))
                  {
                    Log.i("MicroMsg.LoginByMobileSendSmsUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { Util.secPrint(LoginByMobileSendSmsUI.this.ndo) });
                    paramAnonymousDialogInterface.WY(LoginByMobileSendSmsUI.this.ndo);
                  }
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI1 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI2 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI.this.getString(r.j.app_tip);
                  LoginByMobileSendSmsUI.a(localLoginByMobileSendSmsUI1, com.tencent.mm.ui.base.h.a(localLoginByMobileSendSmsUI2, LoginByMobileSendSmsUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(128067);
                      com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                      com.tencent.mm.kernel.h.aGY().b(701, LoginByMobileSendSmsUI.this);
                      com.tencent.mm.kernel.h.aGY().b(252, LoginByMobileSendSmsUI.this);
                      AppMethodBeat.o(128067);
                    }
                  }));
                  AppMethodBeat.o(128068);
                  return;
                  paramAnonymousInt = LoginByMobileSendSmsUI.this.ndo.length();
                  break;
                  label382:
                  i = LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).mUQ.length();
                }
              }
            }, null, new DialogInterface.OnDismissListener()
            {
              public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128069);
                LoginByMobileSendSmsUI.g(LoginByMobileSendSmsUI.this);
                AppMethodBeat.o(128069);
              }
            }, this.ndj);
          }
          for (;;)
          {
            i = 1;
            break;
            Log.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + this.ndj.mUS + " img len" + this.ndj.mUR.length + " " + f.avD());
            this.mUP.b(this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT);
          }
          b.aGF();
          com.tencent.mm.kernel.h.aHE();
          if (TextUtils.isEmpty(b.aGs())) {}
          for (paramq = com.tencent.mm.ci.a.ba(this, r.j.main_err_another_place);; paramq = b.aGs())
          {
            com.tencent.mm.ui.base.h.a(this, paramq, getString(r.j.app_tip), new LoginByMobileSendSmsUI.2(this), new LoginByMobileSendSmsUI.3(this));
            i = 1;
            break;
            com.tencent.mm.kernel.h.aHE();
          }
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.nbl), this.ndn });
          g.a(this.ndj);
          paramq = new Intent();
          paramq.putExtra("auth_ticket", this.nbl);
          paramq.putExtra("binded_mobile", this.ndh);
          paramq.putExtra("close_safe_device_style", this.ndn);
          paramq.putExtra("from_source", 2);
          com.tencent.mm.plugin.account.sdk.a.mIG.g(this, paramq);
          i = 1;
          continue;
          if (!Util.isNullOrNil(this.fXu)) {
            y.p(this, paramString, this.fXu);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128076);
        return;
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128076);
      return;
      label2047:
      i = 0;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128075);
    super.onStop();
    stopTimer();
    com.tencent.mm.kernel.h.aGY().b(145, this);
    AppMethodBeat.o(128075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */