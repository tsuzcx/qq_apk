package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
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
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.k;

public class LoginByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private TextView contentView;
  private String idu;
  private SecurityImage pRw;
  protected String pYt;
  private f pZh;
  private String pZk;
  protected String pZt;
  private boolean pZv;
  private String qaC;
  private String qaD;
  private boolean qaE;
  private String qaF;
  private h qaG;
  private ProgressDialog qaH;
  private int qaI;
  private Button qaJ;
  private Button qaK;
  private TextView qaL;
  private MTimerHandler qaM;
  private int qaN;
  private String qaf;
  
  public LoginByMobileSendSmsUI()
  {
    AppMethodBeat.i(128070);
    this.qaC = "";
    this.qaf = "";
    this.qaD = "";
    this.pZh = new f();
    this.pRw = null;
    this.idu = "";
    this.pZt = "";
    this.qaN = 15;
    AppMethodBeat.o(128070);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.q Tt(String paramString)
  {
    AppMethodBeat.i(128073);
    com.tencent.mm.pluginsdk.ui.span.q localq = new com.tencent.mm.pluginsdk.ui.span.q(paramString);
    Log.d("MicroMsg.LoginByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localq.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(r.d.HugersTextSize)), i, paramString.length(), 33);
    localq.setSpan(new ForegroundColorSpan(getResources().getColor(r.c.green_text_color)), i, paramString.length(), 33);
    AppMethodBeat.o(128073);
    return localq;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128078);
    k.a(this, getString(r.j.regbymobile_reg_quit_send_sms), "", new DialogInterface.OnClickListener()
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
    if (this.qaM != null) {
      this.qaM.stopTimer();
    }
    this.qaK.setText(r.j.regbymobile_reg_no_sim_send_sms_btn_title);
    this.qaK.setEnabled(true);
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
    ((TextView)findViewById(r.f.send_sms_tip)).setText(getString(r.j.regbymobile_reg_send_sms_tip, new Object[] { this.qaC }));
    this.contentView = ((TextView)findViewById(r.f.send_sms_content));
    this.contentView.setText(Tt(getString(r.j.regbymobile_reg_send_sms_content, new Object[] { this.qaf })));
    this.qaL = ((TextView)findViewById(r.f.send_sms_to));
    this.qaL.setText(Tt(getString(r.j.regbymobile_reg_send_sms_to, new Object[] { this.qaD })));
    this.qaJ = ((Button)findViewById(r.f.send_sms_btn));
    this.qaK = ((Button)findViewById(r.f.next_btn));
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
    this.pZh.account = this.qaC;
    AppMethodBeat.o(128072);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128071);
    super.onCreate(paramBundle);
    this.qaC = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.qaE = getIntent().getBooleanExtra("from_switch_account", false);
    this.qaF = bg.okT.aM("login_weixin_username", "");
    initView();
    paramBundle = new com.tencent.mm.modelfriend.a(this.qaC, 16, "", 0, "", 1);
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    getString(r.j.app_tip);
    this.qaH = k.a(this, getString(r.j.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128065);
        com.tencent.mm.kernel.h.aZW().a(paramBundle);
        AppMethodBeat.o(128065);
      }
    });
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
    com.tencent.mm.kernel.h.aZW().a(145, this);
    AppMethodBeat.o(128074);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128076);
    Log.i("MicroMsg.LoginByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp.getType() == 145)
    {
      if (this.qaH != null) {
        this.qaH.dismiss();
      }
      paramInt1 = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      if (paramInt1 == 16)
      {
        if (paramInt2 == -41)
        {
          k.s(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -75)
        {
          k.c(this, getString(r.j.alpha_version_tip_login), "", true);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -106)
        {
          v.f(this, paramString, 32045);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == 0)
        {
          this.qaf = ((com.tencent.mm.modelfriend.a)paramp).bIU();
          this.qaD = ((com.tencent.mm.modelfriend.a)paramp).bIV();
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "verifyCode %s, smsUpMobile %s", new Object[] { this.qaf, this.qaD });
          this.contentView.setText(Tt(getString(r.j.regbymobile_reg_send_sms_content, new Object[] { this.qaf })));
          this.qaL.setText(Tt(getString(r.j.regbymobile_reg_send_sms_to, new Object[] { this.qaD })));
          if (Util.isNullOrNil(new String[] { this.qaC, this.qaD, this.qaf }))
          {
            this.qaJ.setEnabled(false);
            this.qaK.setEnabled(false);
          }
          while (Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.aPc()))
          {
            this.qaJ.setVisibility(8);
            AppMethodBeat.o(128076);
            return;
            this.qaK.setOnClickListener(new LoginByMobileSendSmsUI.7(this));
          }
          this.qaJ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(128064);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.SENDTO");
              ((Intent)localObject).setData(Uri.parse("smsto:" + LoginByMobileSendSmsUI.c(LoginByMobileSendSmsUI.this)));
              ((Intent)localObject).putExtra("sms_body", LoginByMobileSendSmsUI.d(LoginByMobileSendSmsUI.this));
              try
              {
                paramAnonymousView = LoginByMobileSendSmsUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LoginByMobileSendSmsUI.this.overridePendingTransition(r.a.slide_right_in, r.a.slide_left_out);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128064);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                for (;;)
                {
                  Log.e("MicroMsg.LoginByMobileSendSmsUI", paramAnonymousView.getMessage());
                }
              }
            }
          });
          AppMethodBeat.o(128076);
        }
      }
      else if (paramInt1 == 17)
      {
        if (paramInt2 == 0)
        {
          paramString = this.qaC;
          paramp = ((com.tencent.mm.modelfriend.a)paramp).bIP();
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "start auto login");
          com.tencent.mm.kernel.h.aZW().a(701, this);
          com.tencent.mm.kernel.h.aZW().a(252, this);
          this.qaG = new h(new h.a()
          {
            public final void b(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(128060);
              LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this, paramAnonymousProgressDialog);
              AppMethodBeat.o(128060);
            }
          }, paramString, paramp, this.qaC);
          this.qaG.d(this);
          AppMethodBeat.o(128076);
          return;
        }
        if ((!Util.isNullOrNil(paramString)) && (this.qaI >= 4))
        {
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if ((paramString != null) && (paramString.a(this, null, null)))
          {
            AppMethodBeat.o(128076);
            return;
          }
        }
        AppMethodBeat.o(128076);
        return;
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
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
    if ((paramp.getType() == 701) || (paramp.getType() == 252))
    {
      com.tencent.mm.kernel.h.aZW().b(701, this);
      com.tencent.mm.kernel.h.aZW().b(252, this);
      this.pZh.qbo = ((u)paramp).getSecCodeType();
      this.pZh.pRz = ((u)paramp).bMi();
      this.pZh.pRy = ((u)paramp).bMj();
      this.pZh.pRA = ((u)paramp).bMk();
      if (paramInt2 == -205)
      {
        this.pYt = ((u)paramp).bIR();
        this.pZk = ((u)paramp).bMp();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label2059;
      }
      i = 1;
      com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
      {
        public final void b(g paramAnonymousg)
        {
          AppMethodBeat.i(128066);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128066);
            return;
          }
          paramAnonymousg = paramAnonymousg.bGg();
          com.tencent.mm.kernel.h.baC();
          int i = com.tencent.mm.kernel.b.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128066);
        }
      }), 0);
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        stopTimer();
        com.tencent.mm.kernel.b.aZI();
        i.bXa();
        v.Sj(this.pZh.account);
        paramString = bg.okT.aM("login_weixin_username", "");
        if (this.qaE)
        {
          cj.ono.bf(this.qaF, paramString);
          cj.ono.g(z.bAM(), z.bBM());
          com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cj.ono.bDk(), cj.ono.bDl(), com.tencent.mm.compatible.deviceinfo.q.aPg() });
        }
        if ((this.qaH != null) && (this.qaH.isShowing())) {
          this.qaH.setMessage(getString(r.j.app_loading));
        }
        paramString = (u)paramp;
        Log.i("MicroMsg.LoginByMobileSendSmsUI", "checktask LoginByMobileSendSmsUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
        Intent localIntent = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
        localIntent.addFlags(67108864);
        if (paramString != null)
        {
          localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramString.bMn());
          localIntent.putExtra("kstyle_bind_recommend_show", paramString.bMq());
          localIntent.putExtra("kstyle_bind_wording", paramString.bMo());
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        this.pZv = ((u)paramp).bMr();
        if (((u)paramp).bMl())
        {
          boolean bool = this.pZv;
          paramString = new Intent(this, RegByMobileSetPwdUI.class);
          paramString.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
          paramString.putExtra("kintent_cancelable", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128076);
        return;
      }
      if ((this.qaH != null) && (this.qaH.isShowing()))
      {
        this.qaH.dismiss();
        this.qaH = null;
      }
      if (paramInt2 == -106)
      {
        v.f(this, paramString, 31685);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt2 == -217)
      {
        v.a(this, com.tencent.mm.platformtools.e.d((u)paramp), paramInt2);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString))
        {
          if (this.pRw != null) {
            this.pRw.dismiss();
          }
          i = 1;
        }
        break;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128076);
        return;
        k.s(this, r.j.errcode_password, r.j.login_err_title);
        i = 1;
        continue;
        if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
        {
          k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
          i = 1;
        }
        else
        {
          k.s(this, r.j.login_err_mailnotverify, r.j.login_err_title);
          i = 1;
          continue;
          k.s(this, r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
          i = 1;
          continue;
          v.ei(this);
          i = 1;
          continue;
          k.d(this, getString(r.j.bind_mcontact_verify_error), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          k.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          com.tencent.mm.kernel.h.aZW().a(701, this);
          com.tencent.mm.kernel.h.aZW().a(252, this);
          if (this.pRw == null) {
            this.pRw = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                int i = -1;
                AppMethodBeat.i(128068);
                Log.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).pRz + " img len" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
                int j = paramInt1;
                if (LoginByMobileSendSmsUI.this.pZt == null)
                {
                  paramAnonymousInt = -1;
                  paramAnonymousDialogInterface = Util.secPrint(LoginByMobileSendSmsUI.this.pZt);
                  if (LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).pRx != null) {
                    break label382;
                  }
                }
                for (;;)
                {
                  Log.d("MicroMsg.LoginByMobileSendSmsUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), Util.secPrint(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).pRx) });
                  paramAnonymousDialogInterface = new u(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).account, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).pRx, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).qbo, LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgCode(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgSid(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgEncryptKey(), 0, "", false, false);
                  if ((Util.isNullOrNil(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).pRx)) && (!Util.isNullOrNil(LoginByMobileSendSmsUI.this.pZt)))
                  {
                    Log.i("MicroMsg.LoginByMobileSendSmsUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { Util.secPrint(LoginByMobileSendSmsUI.this.pZt) });
                    paramAnonymousDialogInterface.OY(LoginByMobileSendSmsUI.this.pZt);
                  }
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI1 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI2 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI.this.getString(r.j.app_tip);
                  LoginByMobileSendSmsUI.a(localLoginByMobileSendSmsUI1, k.a(localLoginByMobileSendSmsUI2, LoginByMobileSendSmsUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(128067);
                      com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                      com.tencent.mm.kernel.h.aZW().b(701, LoginByMobileSendSmsUI.this);
                      com.tencent.mm.kernel.h.aZW().b(252, LoginByMobileSendSmsUI.this);
                      AppMethodBeat.o(128067);
                    }
                  }));
                  AppMethodBeat.o(128068);
                  return;
                  paramAnonymousInt = LoginByMobileSendSmsUI.this.pZt.length();
                  break;
                  label382:
                  i = LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).pRx.length();
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
            }, this.pZh);
          }
          for (;;)
          {
            i = 1;
            break;
            Log.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + this.pZh.pRz + " img len" + this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
            this.pRw.b(this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA);
          }
          com.tencent.mm.kernel.b.aZH();
          com.tencent.mm.kernel.h.baC();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
          for (paramp = com.tencent.mm.cd.a.bt(this, r.j.main_err_another_place);; paramp = com.tencent.mm.kernel.b.aZu())
          {
            k.a(this, paramp, getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.h.baC();
          }
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.pYt), this.pZk });
          f.a(this.pZh);
          paramp = new Intent();
          paramp.putExtra("auth_ticket", this.pYt);
          paramp.putExtra("binded_mobile", this.qaC);
          paramp.putExtra("close_safe_device_style", this.pZk);
          paramp.putExtra("from_source", 2);
          com.tencent.mm.plugin.account.sdk.a.pFn.g(this, paramp);
          i = 1;
          continue;
          if (!Util.isNullOrNil(this.idu)) {
            v.r(this, paramString, this.idu);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128076);
        return;
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128076);
      return;
      label2059:
      i = 0;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128075);
    super.onStop();
    stopTimer();
    com.tencent.mm.kernel.h.aZW().b(145, this);
    AppMethodBeat.o(128075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */