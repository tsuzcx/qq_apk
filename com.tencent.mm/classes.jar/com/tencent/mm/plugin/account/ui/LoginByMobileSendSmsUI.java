package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
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
import com.tencent.mm.al.n;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;

public class LoginByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private TextView contentView;
  private int countDown;
  private String dAl;
  private SecurityImage ijd;
  protected String ipj;
  private String iqi;
  private String irb;
  private String irc;
  private f ird;
  private boolean ire;
  private boolean irf;
  private String irg;
  private String irh;
  protected String iri;
  private g irj;
  private ProgressDialog irk;
  private int irl;
  private Button irm;
  private Button irn;
  private TextView iro;
  private av irp;
  
  public LoginByMobileSendSmsUI()
  {
    AppMethodBeat.i(128070);
    this.irb = "";
    this.iqi = "";
    this.irc = "";
    this.ird = new f();
    this.ijd = null;
    this.dAl = "";
    this.iri = "";
    this.countDown = 15;
    AppMethodBeat.o(128070);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.l CC(String paramString)
  {
    AppMethodBeat.i(128073);
    com.tencent.mm.pluginsdk.ui.span.l locall = new com.tencent.mm.pluginsdk.ui.span.l(paramString);
    ad.d("MicroMsg.LoginByMobileSendSmsUI", "content: %s", new Object[] { paramString });
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
    if (this.irp != null) {
      this.irp.stopTimer();
    }
    this.irn.setText(2131762330);
    this.irn.setEnabled(true);
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
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.irb }));
    this.contentView = ((TextView)findViewById(2131304581));
    this.contentView.setText(CC(getString(2131762335, new Object[] { this.iqi })));
    this.iro = ((TextView)findViewById(2131304585));
    this.iro.setText(CC(getString(2131762338, new Object[] { this.irc })));
    this.irm = ((Button)findViewById(2131304580));
    this.irn = ((Button)findViewById(2131302852));
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
    this.ird.account = this.irb;
    AppMethodBeat.o(128072);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(128071);
    super.onCreate(paramBundle);
    this.irb = bt.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.irf = getIntent().getBooleanExtra("from_switch_account", false);
    this.irg = ay.gNa.ao("login_weixin_username", "");
    initView();
    paramBundle = new com.tencent.mm.modelfriend.a(this.irb, 16, "", 0, "", 1);
    com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    getString(2131755906);
    this.irk = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128065);
        com.tencent.mm.kernel.g.aeS().a(paramBundle);
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
    com.tencent.mm.kernel.g.aeS().a(145, this);
    AppMethodBeat.o(128074);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128076);
    ad.i("MicroMsg.LoginByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn.getType() == 145)
    {
      if (this.irk != null) {
        this.irk.dismiss();
      }
      paramInt1 = ((com.tencent.mm.modelfriend.a)paramn).JJ();
      if (paramInt1 == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.j(this, 2131762328, 2131762329);
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
          this.iqi = ((com.tencent.mm.modelfriend.a)paramn).axD();
          this.irc = ((com.tencent.mm.modelfriend.a)paramn).axE();
          ad.i("MicroMsg.LoginByMobileSendSmsUI", "verifyCode %s, smsUpMobile %s", new Object[] { this.iqi, this.irc });
          this.contentView.setText(CC(getString(2131762335, new Object[] { this.iqi })));
          this.iro.setText(CC(getString(2131762338, new Object[] { this.irc })));
          if (bt.T(new String[] { this.irb, this.irc, this.iqi }))
          {
            this.irm.setEnabled(false);
            this.irn.setEnabled(false);
          }
          while (bt.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))
          {
            this.irm.setVisibility(8);
            AppMethodBeat.o(128076);
            return;
            this.irn.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(128063);
                LoginByMobileSendSmsUI.b(LoginByMobileSendSmsUI.this);
                AppMethodBeat.o(128063);
              }
            });
          }
          this.irm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(128064);
              Object localObject = new Intent();
              ((Intent)localObject).setAction("android.intent.action.SENDTO");
              ((Intent)localObject).setData(Uri.parse("smsto:" + LoginByMobileSendSmsUI.c(LoginByMobileSendSmsUI.this)));
              ((Intent)localObject).putExtra("sms_body", LoginByMobileSendSmsUI.d(LoginByMobileSendSmsUI.this));
              try
              {
                paramAnonymousView = LoginByMobileSendSmsUI.this;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                LoginByMobileSendSmsUI.this.overridePendingTransition(2130772144, 2130772141);
                AppMethodBeat.o(128064);
                return;
              }
              catch (Exception paramAnonymousView)
              {
                ad.e("MicroMsg.LoginByMobileSendSmsUI", paramAnonymousView.getMessage());
                AppMethodBeat.o(128064);
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
          paramString = this.irb;
          paramn = ((com.tencent.mm.modelfriend.a)paramn).axy();
          ad.i("MicroMsg.LoginByMobileSendSmsUI", "start auto login");
          com.tencent.mm.kernel.g.aeS().a(701, this);
          com.tencent.mm.kernel.g.aeS().a(252, this);
          this.irj = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(128060);
              LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this, paramAnonymousProgressDialog);
              AppMethodBeat.o(128060);
            }
          }, paramString, paramn, this.irb);
          this.irj.a(this);
          AppMethodBeat.o(128076);
          return;
        }
        if ((!bt.isNullOrNil(paramString)) && (this.irl >= 4))
        {
          paramString = com.tencent.mm.h.a.oG(paramString);
          if ((paramString != null) && (paramString.a(this, null, null)))
          {
            AppMethodBeat.o(128076);
            return;
          }
        }
        AppMethodBeat.o(128076);
        return;
      }
      paramString = com.tencent.mm.h.a.oG(paramString);
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
      com.tencent.mm.kernel.g.aeS().b(701, this);
      com.tencent.mm.kernel.g.aeS().b(252, this);
      this.ird.iss = ((s)paramn).getSecCodeType();
      this.ird.ijg = ((s)paramn).aAK();
      this.ird.ijf = ((s)paramn).aAL();
      this.ird.ijh = ((s)paramn).aAM();
      if (paramInt2 == -205)
      {
        this.ipj = ((s)paramn).axA();
        this.irh = ((s)paramn).aAR();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label2036;
      }
      i = 1;
      com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128066);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128066);
            return;
          }
          paramAnonymouse = paramAnonymouse.avg();
          com.tencent.mm.kernel.g.afz();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
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
        com.tencent.mm.plugin.account.friend.a.l.aIQ();
        t.cN(this);
        y.BD(this.ird.account);
        paramString = ay.gNa.ao("login_weixin_username", "");
        if (this.irf)
        {
          ca.gPq.aG(this.irg, paramString);
          ca.gPq.f(u.aqG(), u.arp());
          com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ca.gPq.asH() });
        }
        if ((this.irk != null) && (this.irk.isShowing())) {
          this.irk.setMessage(getString(2131755804));
        }
        paramString = (s)paramn;
        ad.i("MicroMsg.LoginByMobileSendSmsUI", "checktask LoginByMobileSendSmsUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
        Intent localIntent = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
        localIntent.addFlags(67108864);
        if (paramString != null)
        {
          localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramString.aAP());
          localIntent.putExtra("kstyle_bind_recommend_show", paramString.aAS());
          localIntent.putExtra("kstyle_bind_wording", paramString.aAQ());
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        this.ire = ((s)paramn).aAT();
        if (((s)paramn).aAN())
        {
          boolean bool = this.ire;
          paramString = new Intent(this, RegByMobileSetPwdUI.class);
          paramString.putExtra("kintent_hint", getString(2131763302));
          paramString.putExtra("kintent_cancelable", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128076);
        return;
      }
      if ((this.irk != null) && (this.irk.isShowing()))
      {
        this.irk.dismiss();
        this.irk = null;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 31685);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        if (com.tencent.mm.plugin.account.a.a.hYu.a(this, paramInt1, paramInt2, paramString))
        {
          if (this.ijd != null) {
            this.ijd.dismiss();
          }
          i = 1;
        }
        break;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128076);
        return;
        com.tencent.mm.ui.base.h.j(this, 2131758459, 2131760766);
        i = 1;
        continue;
        if (com.tencent.mm.kernel.g.aeS().auR() == 5)
        {
          com.tencent.mm.ui.base.h.j(this, 2131761537, 2131761536);
          i = 1;
        }
        else
        {
          com.tencent.mm.ui.base.h.j(this, 2131760765, 2131760766);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.j(this, 2131762374, 2131755906);
          i = 1;
          continue;
          y.cV(this);
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
          com.tencent.mm.kernel.g.aeS().a(701, this);
          com.tencent.mm.kernel.g.aeS().a(252, this);
          if (this.ijd == null) {
            this.ijd = SecurityImage.a.a(this, this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                int i = -1;
                AppMethodBeat.i(128068);
                ad.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).ijg + " img len" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
                int j = paramInt1;
                if (LoginByMobileSendSmsUI.this.iri == null)
                {
                  paramAnonymousInt = -1;
                  paramAnonymousDialogInterface = bt.aGs(LoginByMobileSendSmsUI.this.iri);
                  if (LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).ije != null) {
                    break label380;
                  }
                }
                for (;;)
                {
                  ad.d("MicroMsg.LoginByMobileSendSmsUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bt.aGs(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).ije) });
                  paramAnonymousDialogInterface = new s(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).account, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).ije, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).iss, LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgCode(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgSid(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgEncryptKey(), 0, "", false, false);
                  if ((bt.isNullOrNil(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).ije)) && (!bt.isNullOrNil(LoginByMobileSendSmsUI.this.iri)))
                  {
                    ad.i("MicroMsg.LoginByMobileSendSmsUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bt.aGs(LoginByMobileSendSmsUI.this.iri) });
                    paramAnonymousDialogInterface.zc(LoginByMobileSendSmsUI.this.iri);
                  }
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI1 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI2 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI.this.getString(2131755906);
                  LoginByMobileSendSmsUI.a(localLoginByMobileSendSmsUI1, com.tencent.mm.ui.base.h.b(localLoginByMobileSendSmsUI2, LoginByMobileSendSmsUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(128067);
                      com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                      com.tencent.mm.kernel.g.aeS().b(701, LoginByMobileSendSmsUI.this);
                      com.tencent.mm.kernel.g.aeS().b(252, LoginByMobileSendSmsUI.this);
                      AppMethodBeat.o(128067);
                    }
                  }));
                  AppMethodBeat.o(128068);
                  return;
                  paramAnonymousInt = LoginByMobileSendSmsUI.this.iri.length();
                  break;
                  label380:
                  i = LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).ije.length();
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
            }, this.ird);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + this.ird.ijg + " img len" + this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
            this.ijd.b(this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh);
          }
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.afz();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
          for (paramn = com.tencent.mm.cd.a.aq(this, 2131761063);; paramn = com.tencent.mm.kernel.a.aeq())
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
            com.tencent.mm.kernel.g.afz();
          }
          ad.i("MicroMsg.LoginByMobileSendSmsUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aGs(this.ipj), this.irh });
          f.a(this.ird);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.ipj);
          paramn.putExtra("binded_mobile", this.irb);
          paramn.putExtra("close_safe_device_style", this.irh);
          paramn.putExtra("from_source", 2);
          com.tencent.mm.plugin.account.a.a.hYt.g(this, paramn);
          i = 1;
          continue;
          if (!bt.isNullOrNil(this.dAl)) {
            y.m(this, paramString, this.dAl);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      paramString = com.tencent.mm.h.a.oG(paramString);
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
    com.tencent.mm.kernel.g.aeS().b(145, this);
    AppMethodBeat.o(128075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */