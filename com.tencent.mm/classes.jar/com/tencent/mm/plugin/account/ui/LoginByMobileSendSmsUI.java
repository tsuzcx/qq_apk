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
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
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
  private int countDown;
  private String edo;
  private SecurityImage kdp;
  protected String kjv;
  private String kkz;
  private ProgressDialog klA;
  private int klB;
  private Button klC;
  private Button klD;
  private TextView klE;
  private MTimerHandler klF;
  private String klr;
  private String kls;
  private g klt;
  private boolean klu;
  private boolean klv;
  private String klw;
  private String klx;
  protected String kly;
  private h klz;
  
  public LoginByMobileSendSmsUI()
  {
    AppMethodBeat.i(128070);
    this.klr = "";
    this.kkz = "";
    this.kls = "";
    this.klt = new g();
    this.kdp = null;
    this.edo = "";
    this.kly = "";
    this.countDown = 15;
    AppMethodBeat.o(128070);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.m Tr(String paramString)
  {
    AppMethodBeat.i(128073);
    com.tencent.mm.pluginsdk.ui.span.m localm = new com.tencent.mm.pluginsdk.ui.span.m(paramString);
    Log.d("MicroMsg.LoginByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localm.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(2131165485)), i, paramString.length(), 33);
    localm.setSpan(new ForegroundColorSpan(getResources().getColor(2131100566)), i, paramString.length(), 33);
    AppMethodBeat.o(128073);
    return localm;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128078);
    com.tencent.mm.ui.base.h.a(this, getString(2131764398), "", new DialogInterface.OnClickListener()
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
    if (this.klF != null) {
      this.klF.stopTimer();
    }
    this.klD.setText(2131764396);
    this.klD.setEnabled(true);
    AppMethodBeat.o(128077);
  }
  
  public int getLayoutId()
  {
    return 2131495677;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128072);
    super.initView();
    ((TextView)findViewById(2131307629)).setText(getString(2131764402, new Object[] { this.klr }));
    this.contentView = ((TextView)findViewById(2131307626));
    this.contentView.setText(Tr(getString(2131764401, new Object[] { this.kkz })));
    this.klE = ((TextView)findViewById(2131307630));
    this.klE.setText(Tr(getString(2131764404, new Object[] { this.kls })));
    this.klC = ((Button)findViewById(2131307625));
    this.klD = ((Button)findViewById(2131305423));
    setMMTitle(2131764403);
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
    this.klt.account = this.klr;
    AppMethodBeat.o(128072);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128071);
    super.onCreate(paramBundle);
    this.klr = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.klv = getIntent().getBooleanExtra("from_switch_account", false);
    this.klw = bf.iDu.aA("login_weixin_username", "");
    initView();
    paramBundle = new com.tencent.mm.modelfriend.a(this.klr, 16, "", 0, "", 1);
    com.tencent.mm.kernel.g.azz().a(paramBundle, 0);
    getString(2131755998);
    this.klA = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128065);
        com.tencent.mm.kernel.g.azz().a(paramBundle);
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
    com.tencent.mm.kernel.g.azz().a(145, this);
    AppMethodBeat.o(128074);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128076);
    Log.i("MicroMsg.LoginByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq.getType() == 145)
    {
      if (this.klA != null) {
        this.klA.dismiss();
      }
      paramInt1 = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      if (paramInt1 == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.n(this, 2131764394, 2131764395);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131755300), "", true);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -106)
        {
          y.g(this, paramString, 32045);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == 0)
        {
          this.kkz = ((com.tencent.mm.modelfriend.a)paramq).bbK();
          this.kls = ((com.tencent.mm.modelfriend.a)paramq).bbL();
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "verifyCode %s, smsUpMobile %s", new Object[] { this.kkz, this.kls });
          this.contentView.setText(Tr(getString(2131764401, new Object[] { this.kkz })));
          this.klE.setText(Tr(getString(2131764404, new Object[] { this.kls })));
          if (Util.isNullOrNil(new String[] { this.klr, this.kls, this.kkz }))
          {
            this.klC.setEnabled(false);
            this.klD.setEnabled(false);
          }
          while (Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))
          {
            this.klC.setVisibility(8);
            AppMethodBeat.o(128076);
            return;
            this.klD.setOnClickListener(new LoginByMobileSendSmsUI.7(this));
          }
          this.klC.setOnClickListener(new LoginByMobileSendSmsUI.8(this));
          AppMethodBeat.o(128076);
        }
      }
      else if (paramInt1 == 17)
      {
        if (paramInt2 == 0)
        {
          paramString = this.klr;
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bbF();
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "start auto login");
          com.tencent.mm.kernel.g.azz().a(701, this);
          com.tencent.mm.kernel.g.azz().a(252, this);
          this.klz = new h(new h.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(128060);
              LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this, paramAnonymousProgressDialog);
              AppMethodBeat.o(128060);
            }
          }, paramString, paramq, this.klr);
          this.klz.b(this);
          AppMethodBeat.o(128076);
          return;
        }
        if ((!Util.isNullOrNil(paramString)) && (this.klB >= 4))
        {
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if ((paramString != null) && (paramString.a(this, null, null)))
          {
            AppMethodBeat.o(128076);
            return;
          }
        }
        AppMethodBeat.o(128076);
        return;
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
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
      com.tencent.mm.kernel.g.azz().b(701, this);
      com.tencent.mm.kernel.g.azz().b(252, this);
      this.klt.kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
      this.klt.kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
      this.klt.kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
      this.klt.kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
      if (paramInt2 == -205)
      {
        this.kjv = ((com.tencent.mm.modelsimple.t)paramq).bbH();
        this.klx = ((com.tencent.mm.modelsimple.t)paramq).bfs();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label2044;
      }
      i = 1;
      com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128066);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128066);
            return;
          }
          paramAnonymousg = paramAnonymousg.aZh();
          com.tencent.mm.kernel.g.aAf();
          int i = com.tencent.mm.kernel.a.getUin();
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
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.boe();
        com.tencent.mm.platformtools.t.dr(this);
        y.St(this.klt.account);
        paramString = bf.iDu.aA("login_weixin_username", "");
        if (this.klv)
        {
          ch.iFO.aR(this.klw, paramString);
          ch.iFO.h(z.aTY(), z.aUS());
          com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ch.iFO.aWp() });
        }
        if ((this.klA != null) && (this.klA.isShowing())) {
          this.klA.setMessage(getString(2131755886));
        }
        paramString = (com.tencent.mm.modelsimple.t)paramq;
        Log.i("MicroMsg.LoginByMobileSendSmsUI", "checktask LoginByMobileSendSmsUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
        Intent localIntent = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        localIntent.addFlags(67108864);
        if (paramString != null)
        {
          localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramString.bfq());
          localIntent.putExtra("kstyle_bind_recommend_show", paramString.bft());
          localIntent.putExtra("kstyle_bind_wording", paramString.bfr());
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        this.klu = ((com.tencent.mm.modelsimple.t)paramq).bfu();
        if (((com.tencent.mm.modelsimple.t)paramq).bfo())
        {
          boolean bool = this.klu;
          paramString = new Intent(this, RegByMobileSetPwdUI.class);
          paramString.putExtra("kintent_hint", getString(2131765477));
          paramString.putExtra("kintent_cancelable", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128076);
        return;
      }
      if ((this.klA != null) && (this.klA.isShowing()))
      {
        this.klA.dismiss();
        this.klA = null;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 31685);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString))
        {
          if (this.kdp != null) {
            this.kdp.dismiss();
          }
          i = 1;
        }
        break;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128076);
        return;
        com.tencent.mm.ui.base.h.n(this, 2131758757, 2131762516);
        i = 1;
        continue;
        if (com.tencent.mm.kernel.g.azz().aYS() == 5)
        {
          com.tencent.mm.ui.base.h.n(this, 2131763503, 2131763502);
          i = 1;
        }
        else
        {
          com.tencent.mm.ui.base.h.n(this, 2131762515, 2131762516);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.n(this, 2131764440, 2131755998);
          i = 1;
          continue;
          y.dz(this);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.d(this, getString(2131756646), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.a(this, 2131756644, 2131756650, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          com.tencent.mm.kernel.g.azz().a(701, this);
          com.tencent.mm.kernel.g.azz().a(252, this);
          if (this.kdp == null) {
            this.kdp = SecurityImage.a.a(this, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                int i = -1;
                AppMethodBeat.i(128068);
                Log.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kds + " img len" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kdr.length + " " + f.apq());
                int j = paramInt1;
                if (LoginByMobileSendSmsUI.this.kly == null)
                {
                  paramAnonymousInt = -1;
                  paramAnonymousDialogInterface = Util.secPrint(LoginByMobileSendSmsUI.this.kly);
                  if (LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kdq != null) {
                    break label380;
                  }
                }
                for (;;)
                {
                  Log.d("MicroMsg.LoginByMobileSendSmsUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), Util.secPrint(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kdq) });
                  paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).account, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kdq, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kmJ, LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgCode(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgSid(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgEncryptKey(), 0, "", false, false);
                  if ((Util.isNullOrNil(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kdq)) && (!Util.isNullOrNil(LoginByMobileSendSmsUI.this.kly)))
                  {
                    Log.i("MicroMsg.LoginByMobileSendSmsUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { Util.secPrint(LoginByMobileSendSmsUI.this.kly) });
                    paramAnonymousDialogInterface.PA(LoginByMobileSendSmsUI.this.kly);
                  }
                  com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI1 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI2 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI.this.getString(2131755998);
                  LoginByMobileSendSmsUI.a(localLoginByMobileSendSmsUI1, com.tencent.mm.ui.base.h.a(localLoginByMobileSendSmsUI2, LoginByMobileSendSmsUI.this.getString(2131762532), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(128067);
                      com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
                      com.tencent.mm.kernel.g.azz().b(701, LoginByMobileSendSmsUI.this);
                      com.tencent.mm.kernel.g.azz().b(252, LoginByMobileSendSmsUI.this);
                      AppMethodBeat.o(128067);
                    }
                  }));
                  AppMethodBeat.o(128068);
                  return;
                  paramAnonymousInt = LoginByMobileSendSmsUI.this.kly.length();
                  break;
                  label380:
                  i = LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).kdq.length();
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
            }, this.klt);
          }
          for (;;)
          {
            i = 1;
            break;
            Log.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
            this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
          }
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.aAf();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
          for (paramq = com.tencent.mm.cb.a.aI(this, 2131762849);; paramq = com.tencent.mm.kernel.a.ayX())
          {
            com.tencent.mm.ui.base.h.a(this, paramq, getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.g.aAf();
          }
          Log.i("MicroMsg.LoginByMobileSendSmsUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.kjv), this.klx });
          g.a(this.klt);
          paramq = new Intent();
          paramq.putExtra("auth_ticket", this.kjv);
          paramq.putExtra("binded_mobile", this.klr);
          paramq.putExtra("close_safe_device_style", this.klx);
          paramq.putExtra("from_source", 2);
          com.tencent.mm.plugin.account.a.a.jRt.g(this, paramq);
          i = 1;
          continue;
          if (!Util.isNullOrNil(this.edo)) {
            y.m(this, paramString, this.edo);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128076);
        return;
      }
      Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128076);
      return;
      label2044:
      i = 0;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128075);
    super.onStop();
    stopTimer();
    com.tencent.mm.kernel.g.azz().b(145, this);
    AppMethodBeat.o(128075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */