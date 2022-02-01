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
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class LoginByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private TextView contentView;
  private int countDown;
  private String dKk;
  private SecurityImage jct;
  protected String jiy;
  private String jjx;
  private Button jkA;
  private Button jkB;
  private TextView jkC;
  private av jkD;
  private String jkp;
  private String jkq;
  private f jkr;
  private boolean jks;
  private boolean jkt;
  private String jku;
  private String jkv;
  protected String jkw;
  private g jkx;
  private ProgressDialog jky;
  private int jkz;
  
  public LoginByMobileSendSmsUI()
  {
    AppMethodBeat.i(128070);
    this.jkp = "";
    this.jjx = "";
    this.jkq = "";
    this.jkr = new f();
    this.jct = null;
    this.dKk = "";
    this.jkw = "";
    this.countDown = 15;
    AppMethodBeat.o(128070);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.l JU(String paramString)
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
    h.a(this, getString(2131762332), "", new DialogInterface.OnClickListener()
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
    if (this.jkD != null) {
      this.jkD.stopTimer();
    }
    this.jkB.setText(2131762330);
    this.jkB.setEnabled(true);
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
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.jkp }));
    this.contentView = ((TextView)findViewById(2131304581));
    this.contentView.setText(JU(getString(2131762335, new Object[] { this.jjx })));
    this.jkC = ((TextView)findViewById(2131304585));
    this.jkC.setText(JU(getString(2131762338, new Object[] { this.jkq })));
    this.jkA = ((Button)findViewById(2131304580));
    this.jkB = ((Button)findViewById(2131302852));
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
    this.jkr.account = this.jkp;
    AppMethodBeat.o(128072);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128071);
    super.onCreate(paramBundle);
    this.jkp = bt.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.jkt = getIntent().getBooleanExtra("from_switch_account", false);
    this.jku = az.hFS.ax("login_weixin_username", "");
    initView();
    paramBundle = new com.tencent.mm.modelfriend.a(this.jkp, 16, "", 0, "", 1);
    com.tencent.mm.kernel.g.aiU().a(paramBundle, 0);
    getString(2131755906);
    this.jky = h.b(this, getString(2131755936), true, new LoginByMobileSendSmsUI.9(this, paramBundle));
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
    com.tencent.mm.kernel.g.aiU().a(145, this);
    AppMethodBeat.o(128074);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128076);
    ad.i("MicroMsg.LoginByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn.getType() == 145)
    {
      if (this.jky != null) {
        this.jky.dismiss();
      }
      paramInt1 = ((com.tencent.mm.modelfriend.a)paramn).KR();
      if (paramInt1 == 16)
      {
        if (paramInt2 == -41)
        {
          h.l(this, 2131762328, 2131762329);
          AppMethodBeat.o(128076);
          return;
        }
        if (paramInt2 == -75)
        {
          h.c(this, getString(2131755265), "", true);
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
          this.jjx = ((com.tencent.mm.modelfriend.a)paramn).aHA();
          this.jkq = ((com.tencent.mm.modelfriend.a)paramn).aHB();
          ad.i("MicroMsg.LoginByMobileSendSmsUI", "verifyCode %s, smsUpMobile %s", new Object[] { this.jjx, this.jkq });
          this.contentView.setText(JU(getString(2131762335, new Object[] { this.jjx })));
          this.jkC.setText(JU(getString(2131762338, new Object[] { this.jkq })));
          if (bt.V(new String[] { this.jkp, this.jkq, this.jjx }))
          {
            this.jkA.setEnabled(false);
            this.jkB.setEnabled(false);
          }
          while (bt.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))
          {
            this.jkA.setVisibility(8);
            AppMethodBeat.o(128076);
            return;
            this.jkB.setOnClickListener(new LoginByMobileSendSmsUI.7(this));
          }
          this.jkA.setOnClickListener(new LoginByMobileSendSmsUI.8(this));
          AppMethodBeat.o(128076);
        }
      }
      else if (paramInt1 == 17)
      {
        if (paramInt2 == 0)
        {
          paramString = this.jkp;
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aHv();
          ad.i("MicroMsg.LoginByMobileSendSmsUI", "start auto login");
          com.tencent.mm.kernel.g.aiU().a(701, this);
          com.tencent.mm.kernel.g.aiU().a(252, this);
          this.jkx = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(128060);
              LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this, paramAnonymousProgressDialog);
              AppMethodBeat.o(128060);
            }
          }, paramString, paramn, this.jkp);
          this.jkx.b(this);
          AppMethodBeat.o(128076);
          return;
        }
        if ((!bt.isNullOrNil(paramString)) && (this.jkz >= 4))
        {
          paramString = com.tencent.mm.h.a.uz(paramString);
          if ((paramString != null) && (paramString.a(this, null, null)))
          {
            AppMethodBeat.o(128076);
            return;
          }
        }
        AppMethodBeat.o(128076);
        return;
      }
      paramString = com.tencent.mm.h.a.uz(paramString);
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
      com.tencent.mm.kernel.g.aiU().b(701, this);
      com.tencent.mm.kernel.g.aiU().b(252, this);
      this.jkr.jlF = ((s)paramn).getSecCodeType();
      this.jkr.jcw = ((s)paramn).aKL();
      this.jkr.jcv = ((s)paramn).aKM();
      this.jkr.jcx = ((s)paramn).aKN();
      if (paramInt2 == -205)
      {
        this.jiy = ((s)paramn).aHx();
        this.jkv = ((s)paramn).aKS();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label2036;
      }
      i = 1;
      com.tencent.mm.kernel.g.aiU().a(new bo(new bo.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128066);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128066);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFc();
          com.tencent.mm.kernel.g.ajA();
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
        com.tencent.mm.plugin.account.friend.a.l.aST();
        t.cU(this);
        y.IW(this.jkr.account);
        paramString = az.hFS.ax("login_weixin_username", "");
        if (this.jkt)
        {
          cb.hIi.aP(this.jku, paramString);
          cb.hIi.g(u.aAm(), u.aBf());
          com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cb.hIi.aCB() });
        }
        if ((this.jky != null) && (this.jky.isShowing())) {
          this.jky.setMessage(getString(2131755804));
        }
        paramString = (s)paramn;
        ad.i("MicroMsg.LoginByMobileSendSmsUI", "checktask LoginByMobileSendSmsUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
        Intent localIntent = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
        localIntent.addFlags(67108864);
        if (paramString != null)
        {
          localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramString.aKQ());
          localIntent.putExtra("kstyle_bind_recommend_show", paramString.aKT());
          localIntent.putExtra("kstyle_bind_wording", paramString.aKR());
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        this.jks = ((s)paramn).aKU();
        if (((s)paramn).aKO())
        {
          boolean bool = this.jks;
          paramString = new Intent(this, RegByMobileSetPwdUI.class);
          paramString.putExtra("kintent_hint", getString(2131763302));
          paramString.putExtra("kintent_cancelable", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128076);
        return;
      }
      if ((this.jky != null) && (this.jky.isShowing()))
      {
        this.jky.dismiss();
        this.jky = null;
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
        if (com.tencent.mm.plugin.account.a.a.iRH.a(this, paramInt1, paramInt2, paramString))
        {
          if (this.jct != null) {
            this.jct.dismiss();
          }
          i = 1;
        }
        break;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128076);
        return;
        h.l(this, 2131758459, 2131760766);
        i = 1;
        continue;
        if (com.tencent.mm.kernel.g.aiU().aEN() == 5)
        {
          h.l(this, 2131761537, 2131761536);
          i = 1;
        }
        else
        {
          h.l(this, 2131760765, 2131760766);
          i = 1;
          continue;
          h.l(this, 2131762374, 2131755906);
          i = 1;
          continue;
          y.dc(this);
          i = 1;
          continue;
          h.d(this, getString(2131756510), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          h.a(this, 2131756508, 2131756514, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          i = 1;
          continue;
          com.tencent.mm.kernel.g.aiU().a(701, this);
          com.tencent.mm.kernel.g.aiU().a(252, this);
          if (this.jct == null) {
            this.jct = SecurityImage.a.a(this, this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                int i = -1;
                AppMethodBeat.i(128068);
                ad.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jcw + " img len" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
                int j = paramInt1;
                if (LoginByMobileSendSmsUI.this.jkw == null)
                {
                  paramAnonymousInt = -1;
                  paramAnonymousDialogInterface = bt.aRp(LoginByMobileSendSmsUI.this.jkw);
                  if (LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jcu != null) {
                    break label380;
                  }
                }
                for (;;)
                {
                  ad.d("MicroMsg.LoginByMobileSendSmsUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bt.aRp(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jcu) });
                  paramAnonymousDialogInterface = new s(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).account, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jcu, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jlF, LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgCode(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgSid(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgEncryptKey(), 0, "", false, false);
                  if ((bt.isNullOrNil(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jcu)) && (!bt.isNullOrNil(LoginByMobileSendSmsUI.this.jkw)))
                  {
                    ad.i("MicroMsg.LoginByMobileSendSmsUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bt.aRp(LoginByMobileSendSmsUI.this.jkw) });
                    paramAnonymousDialogInterface.Gm(LoginByMobileSendSmsUI.this.jkw);
                  }
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI1 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI2 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI.this.getString(2131755906);
                  LoginByMobileSendSmsUI.a(localLoginByMobileSendSmsUI1, h.b(localLoginByMobileSendSmsUI2, LoginByMobileSendSmsUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(128067);
                      com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                      com.tencent.mm.kernel.g.aiU().b(701, LoginByMobileSendSmsUI.this);
                      com.tencent.mm.kernel.g.aiU().b(252, LoginByMobileSendSmsUI.this);
                      AppMethodBeat.o(128067);
                    }
                  }));
                  AppMethodBeat.o(128068);
                  return;
                  paramAnonymousInt = LoginByMobileSendSmsUI.this.jkw.length();
                  break;
                  label380:
                  i = LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jcu.length();
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
            }, this.jkr);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + this.jkr.jcw + " img len" + this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
            this.jct.b(this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx);
          }
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.ajA();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
          for (paramn = com.tencent.mm.cc.a.az(this, 2131761063);; paramn = com.tencent.mm.kernel.a.ais())
          {
            h.a(this, paramn, getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.g.ajA();
          }
          ad.i("MicroMsg.LoginByMobileSendSmsUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aRp(this.jiy), this.jkv });
          f.a(this.jkr);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.jiy);
          paramn.putExtra("binded_mobile", this.jkp);
          paramn.putExtra("close_safe_device_style", this.jkv);
          paramn.putExtra("from_source", 2);
          com.tencent.mm.plugin.account.a.a.iRG.g(this, paramn);
          i = 1;
          continue;
          if (!bt.isNullOrNil(this.dKk)) {
            y.n(this, paramString, this.dKk);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      paramString = com.tencent.mm.h.a.uz(paramString);
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
    com.tencent.mm.kernel.g.aiU().b(145, this);
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