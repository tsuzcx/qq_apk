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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;

public class LoginByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private TextView contentView;
  private int countDown;
  private String dxX;
  private SecurityImage iJk;
  protected String iPp;
  private String iQp;
  private String iRh;
  private String iRi;
  private f iRj;
  private boolean iRk;
  private boolean iRl;
  private String iRm;
  private String iRn;
  protected String iRo;
  private g iRp;
  private ProgressDialog iRq;
  private int iRr;
  private Button iRs;
  private Button iRt;
  private TextView iRu;
  private au iRv;
  
  public LoginByMobileSendSmsUI()
  {
    AppMethodBeat.i(128070);
    this.iRh = "";
    this.iQp = "";
    this.iRi = "";
    this.iRj = new f();
    this.iJk = null;
    this.dxX = "";
    this.iRo = "";
    this.countDown = 15;
    AppMethodBeat.o(128070);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.l GF(String paramString)
  {
    AppMethodBeat.i(128073);
    com.tencent.mm.pluginsdk.ui.span.l locall = new com.tencent.mm.pluginsdk.ui.span.l(paramString);
    ac.d("MicroMsg.LoginByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    locall.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(2131165469)), i, paramString.length(), 33);
    locall.setSpan(new ForegroundColorSpan(getResources().getColor(2131100464)), i, paramString.length(), 33);
    AppMethodBeat.o(128073);
    return locall;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128078);
    com.tencent.mm.ui.base.h.a(this, getString(2131762332), "", new DialogInterface.OnClickListener()
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
    if (this.iRv != null) {
      this.iRv.stopTimer();
    }
    this.iRt.setText(2131762330);
    this.iRt.setEnabled(true);
    AppMethodBeat.o(128077);
  }
  
  public int getLayoutId()
  {
    return 2131494935;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128072);
    super.initView();
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.iRh }));
    this.contentView = ((TextView)findViewById(2131304581));
    this.contentView.setText(GF(getString(2131762335, new Object[] { this.iQp })));
    this.iRu = ((TextView)findViewById(2131304585));
    this.iRu.setText(GF(getString(2131762338, new Object[] { this.iRi })));
    this.iRs = ((Button)findViewById(2131304580));
    this.iRt = ((Button)findViewById(2131302852));
    setMMTitle(2131762337);
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
    this.iRj.account = this.iRh;
    AppMethodBeat.o(128072);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128071);
    super.onCreate(paramBundle);
    this.iRh = bs.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.iRl = getIntent().getBooleanExtra("from_switch_account", false);
    this.iRm = ay.hnA.aw("login_weixin_username", "");
    initView();
    paramBundle = new com.tencent.mm.modelfriend.a(this.iRh, 16, "", 0, "", 1);
    com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
    getString(2131755906);
    this.iRq = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new LoginByMobileSendSmsUI.9(this, paramBundle));
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
    com.tencent.mm.kernel.g.agi().a(145, this);
    AppMethodBeat.o(128074);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128076);
    ac.i("MicroMsg.LoginByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn.getType() == 145)
    {
      if (this.iRq != null) {
        this.iRq.dismiss();
      }
      paramInt1 = ((com.tencent.mm.modelfriend.a)paramn).Js();
      if (paramInt1 == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.l(this, 2131762328, 2131762329);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131755265), "", true);
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
          this.iQp = ((com.tencent.mm.modelfriend.a)paramn).aEv();
          this.iRi = ((com.tencent.mm.modelfriend.a)paramn).aEw();
          ac.i("MicroMsg.LoginByMobileSendSmsUI", "verifyCode %s, smsUpMobile %s", new Object[] { this.iQp, this.iRi });
          this.contentView.setText(GF(getString(2131762335, new Object[] { this.iQp })));
          this.iRu.setText(GF(getString(2131762338, new Object[] { this.iRi })));
          if (bs.T(new String[] { this.iRh, this.iRi, this.iQp }))
          {
            this.iRs.setEnabled(false);
            this.iRt.setEnabled(false);
          }
          while (bs.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))
          {
            this.iRs.setVisibility(8);
            AppMethodBeat.o(128076);
            return;
            this.iRt.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(128063);
                LoginByMobileSendSmsUI.b(LoginByMobileSendSmsUI.this);
                AppMethodBeat.o(128063);
              }
            });
          }
          this.iRs.setOnClickListener(new LoginByMobileSendSmsUI.8(this));
          AppMethodBeat.o(128076);
        }
      }
      else if (paramInt1 == 17)
      {
        if (paramInt2 == 0)
        {
          paramString = this.iRh;
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aEq();
          ac.i("MicroMsg.LoginByMobileSendSmsUI", "start auto login");
          com.tencent.mm.kernel.g.agi().a(701, this);
          com.tencent.mm.kernel.g.agi().a(252, this);
          this.iRp = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(128060);
              LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this, paramAnonymousProgressDialog);
              AppMethodBeat.o(128060);
            }
          }, paramString, paramn, this.iRh);
          this.iRp.a(this);
          AppMethodBeat.o(128076);
          return;
        }
        if ((!bs.isNullOrNil(paramString)) && (this.iRr >= 4))
        {
          paramString = com.tencent.mm.h.a.rM(paramString);
          if ((paramString != null) && (paramString.a(this, null, null)))
          {
            AppMethodBeat.o(128076);
            return;
          }
        }
        AppMethodBeat.o(128076);
        return;
      }
      paramString = com.tencent.mm.h.a.rM(paramString);
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
    if ((paramn.getType() == 701) || (paramn.getType() == 252))
    {
      com.tencent.mm.kernel.g.agi().b(701, this);
      com.tencent.mm.kernel.g.agi().b(252, this);
      this.iRj.iSx = ((s)paramn).getSecCodeType();
      this.iRj.iJn = ((s)paramn).aHA();
      this.iRj.iJm = ((s)paramn).aHB();
      this.iRj.iJo = ((s)paramn).aHC();
      if (paramInt2 == -205)
      {
        this.iPp = ((s)paramn).aEs();
        this.iRn = ((s)paramn).aHH();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label2036;
      }
      i = 1;
      com.tencent.mm.kernel.g.agi().a(new bn(new LoginByMobileSendSmsUI.10(this)), 0);
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        stopTimer();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aPH();
        t.cW(this);
        y.FH(this.iRj.account);
        paramString = ay.hnA.aw("login_weixin_username", "");
        if (this.iRl)
        {
          ca.hpQ.aO(this.iRm, paramString);
          ca.hpQ.f(u.axw(), u.ayf());
          com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ca.hpQ.azy() });
        }
        if ((this.iRq != null) && (this.iRq.isShowing())) {
          this.iRq.setMessage(getString(2131755804));
        }
        paramString = (s)paramn;
        ac.i("MicroMsg.LoginByMobileSendSmsUI", "checktask LoginByMobileSendSmsUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
        Intent localIntent = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
        localIntent.addFlags(67108864);
        if (paramString != null)
        {
          localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramString.aHF());
          localIntent.putExtra("kstyle_bind_recommend_show", paramString.aHI());
          localIntent.putExtra("kstyle_bind_wording", paramString.aHG());
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        this.iRk = ((s)paramn).aHJ();
        if (((s)paramn).aHD())
        {
          boolean bool = this.iRk;
          paramString = new Intent(this, RegByMobileSetPwdUI.class);
          paramString.putExtra("kintent_hint", getString(2131763302));
          paramString.putExtra("kintent_cancelable", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128076);
        return;
      }
      if ((this.iRq != null) && (this.iRq.isShowing()))
      {
        this.iRq.dismiss();
        this.iRq = null;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 31685);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        if (com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString))
        {
          if (this.iJk != null) {
            this.iJk.dismiss();
          }
          i = 1;
        }
        break;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128076);
        return;
        com.tencent.mm.ui.base.h.l(this, 2131758459, 2131760766);
        i = 1;
        continue;
        if (com.tencent.mm.kernel.g.agi().aBK() == 5)
        {
          com.tencent.mm.ui.base.h.l(this, 2131761537, 2131761536);
          i = 1;
        }
        else
        {
          com.tencent.mm.ui.base.h.l(this, 2131760765, 2131760766);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.l(this, 2131762374, 2131755906);
          i = 1;
          continue;
          y.de(this);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.d(this, getString(2131756510), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.a(this, 2131756508, 2131756514, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          com.tencent.mm.kernel.g.agi().a(701, this);
          com.tencent.mm.kernel.g.agi().a(252, this);
          if (this.iJk == null) {
            this.iJk = SecurityImage.a.a(this, this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                int i = -1;
                AppMethodBeat.i(128068);
                ac.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iJn + " img len" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
                int j = paramInt1;
                if (LoginByMobileSendSmsUI.this.iRo == null)
                {
                  paramAnonymousInt = -1;
                  paramAnonymousDialogInterface = bs.aLJ(LoginByMobileSendSmsUI.this.iRo);
                  if (LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iJl != null) {
                    break label380;
                  }
                }
                for (;;)
                {
                  ac.d("MicroMsg.LoginByMobileSendSmsUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bs.aLJ(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iJl) });
                  paramAnonymousDialogInterface = new s(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).account, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iJl, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iSx, LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgCode(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgSid(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgEncryptKey(), 0, "", false, false);
                  if ((bs.isNullOrNil(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iJl)) && (!bs.isNullOrNil(LoginByMobileSendSmsUI.this.iRo)))
                  {
                    ac.i("MicroMsg.LoginByMobileSendSmsUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bs.aLJ(LoginByMobileSendSmsUI.this.iRo) });
                    paramAnonymousDialogInterface.Dh(LoginByMobileSendSmsUI.this.iRo);
                  }
                  com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI1 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI2 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI.this.getString(2131755906);
                  LoginByMobileSendSmsUI.a(localLoginByMobileSendSmsUI1, com.tencent.mm.ui.base.h.b(localLoginByMobileSendSmsUI2, LoginByMobileSendSmsUI.this.getString(2131760781), true, new LoginByMobileSendSmsUI.13.1(this, paramAnonymousDialogInterface)));
                  AppMethodBeat.o(128068);
                  return;
                  paramAnonymousInt = LoginByMobileSendSmsUI.this.iRo.length();
                  break;
                  label380:
                  i = LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iJl.length();
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
            }, this.iRj);
          }
          for (;;)
          {
            i = 1;
            break;
            ac.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + this.iRj.iJn + " img len" + this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
            this.iJk.b(this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo);
          }
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.agP();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
          for (paramn = com.tencent.mm.cc.a.aw(this, 2131761063);; paramn = com.tencent.mm.kernel.a.afG())
          {
            com.tencent.mm.ui.base.h.a(this, paramn, getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.g.agP();
          }
          ac.i("MicroMsg.LoginByMobileSendSmsUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bs.aLJ(this.iPp), this.iRn });
          f.a(this.iRj);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.iPp);
          paramn.putExtra("binded_mobile", this.iRh);
          paramn.putExtra("close_safe_device_style", this.iRn);
          paramn.putExtra("from_source", 2);
          com.tencent.mm.plugin.account.a.a.iyx.g(this, paramn);
          i = 1;
          continue;
          if (!bs.isNullOrNil(this.dxX)) {
            y.m(this, paramString, this.dxX);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      paramString = com.tencent.mm.h.a.rM(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128076);
        return;
      }
      Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128076);
      return;
      label2036:
      i = 0;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128075);
    super.onStop();
    stopTimer();
    com.tencent.mm.kernel.g.agi().b(145, this);
    AppMethodBeat.o(128075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */