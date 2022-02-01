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
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class LoginByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private TextView contentView;
  private int countDown;
  private String dLz;
  private SecurityImage jfm;
  protected String jlr;
  private String jmq;
  private String jnj;
  private String jnk;
  private f jnl;
  private boolean jnm;
  private boolean jnn;
  private String jno;
  private String jnp;
  protected String jnq;
  private g jnr;
  private ProgressDialog jns;
  private int jnt;
  private Button jnu;
  private Button jnv;
  private TextView jnw;
  private aw jnx;
  
  public LoginByMobileSendSmsUI()
  {
    AppMethodBeat.i(128070);
    this.jnj = "";
    this.jmq = "";
    this.jnk = "";
    this.jnl = new f();
    this.jfm = null;
    this.dLz = "";
    this.jnq = "";
    this.countDown = 15;
    AppMethodBeat.o(128070);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.l Kt(String paramString)
  {
    AppMethodBeat.i(128073);
    com.tencent.mm.pluginsdk.ui.span.l locall = new com.tencent.mm.pluginsdk.ui.span.l(paramString);
    ae.d("MicroMsg.LoginByMobileSendSmsUI", "content: %s", new Object[] { paramString });
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
    if (this.jnx != null) {
      this.jnx.stopTimer();
    }
    this.jnv.setText(2131762330);
    this.jnv.setEnabled(true);
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
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.jnj }));
    this.contentView = ((TextView)findViewById(2131304581));
    this.contentView.setText(Kt(getString(2131762335, new Object[] { this.jmq })));
    this.jnw = ((TextView)findViewById(2131304585));
    this.jnw.setText(Kt(getString(2131762338, new Object[] { this.jnk })));
    this.jnu = ((Button)findViewById(2131304580));
    this.jnv = ((Button)findViewById(2131302852));
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
    this.jnl.account = this.jnj;
    AppMethodBeat.o(128072);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128071);
    super.onCreate(paramBundle);
    this.jnj = bu.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.jnn = getIntent().getBooleanExtra("from_switch_account", false);
    this.jno = bb.hIK.ay("login_weixin_username", "");
    initView();
    paramBundle = new com.tencent.mm.modelfriend.a(this.jnj, 16, "", 0, "", 1);
    com.tencent.mm.kernel.g.ajj().a(paramBundle, 0);
    getString(2131755906);
    this.jns = h.b(this, getString(2131755936), true, new LoginByMobileSendSmsUI.9(this, paramBundle));
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
    com.tencent.mm.kernel.g.ajj().a(145, this);
    AppMethodBeat.o(128074);
  }
  
  public void onSceneEnd(final int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128076);
    ae.i("MicroMsg.LoginByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn.getType() == 145)
    {
      if (this.jns != null) {
        this.jns.dismiss();
      }
      paramInt1 = ((com.tencent.mm.modelfriend.a)paramn).KZ();
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
          this.jmq = ((com.tencent.mm.modelfriend.a)paramn).aHR();
          this.jnk = ((com.tencent.mm.modelfriend.a)paramn).aHS();
          ae.i("MicroMsg.LoginByMobileSendSmsUI", "verifyCode %s, smsUpMobile %s", new Object[] { this.jmq, this.jnk });
          this.contentView.setText(Kt(getString(2131762335, new Object[] { this.jmq })));
          this.jnw.setText(Kt(getString(2131762338, new Object[] { this.jnk })));
          if (bu.V(new String[] { this.jnj, this.jnk, this.jmq }))
          {
            this.jnu.setEnabled(false);
            this.jnv.setEnabled(false);
          }
          while (bu.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))
          {
            this.jnu.setVisibility(8);
            AppMethodBeat.o(128076);
            return;
            this.jnv.setOnClickListener(new LoginByMobileSendSmsUI.7(this));
          }
          this.jnu.setOnClickListener(new LoginByMobileSendSmsUI.8(this));
          AppMethodBeat.o(128076);
        }
      }
      else if (paramInt1 == 17)
      {
        if (paramInt2 == 0)
        {
          paramString = this.jnj;
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aHM();
          ae.i("MicroMsg.LoginByMobileSendSmsUI", "start auto login");
          com.tencent.mm.kernel.g.ajj().a(701, this);
          com.tencent.mm.kernel.g.ajj().a(252, this);
          this.jnr = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(128060);
              LoginByMobileSendSmsUI.a(LoginByMobileSendSmsUI.this, paramAnonymousProgressDialog);
              AppMethodBeat.o(128060);
            }
          }, paramString, paramn, this.jnj);
          this.jnr.b(this);
          AppMethodBeat.o(128076);
          return;
        }
        if ((!bu.isNullOrNil(paramString)) && (this.jnt >= 4))
        {
          paramString = com.tencent.mm.h.a.uU(paramString);
          if ((paramString != null) && (paramString.a(this, null, null)))
          {
            AppMethodBeat.o(128076);
            return;
          }
        }
        AppMethodBeat.o(128076);
        return;
      }
      paramString = com.tencent.mm.h.a.uU(paramString);
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
      com.tencent.mm.kernel.g.ajj().b(701, this);
      com.tencent.mm.kernel.g.ajj().b(252, this);
      this.jnl.joz = ((com.tencent.mm.modelsimple.t)paramn).getSecCodeType();
      this.jnl.jfp = ((com.tencent.mm.modelsimple.t)paramn).aLi();
      this.jnl.jfo = ((com.tencent.mm.modelsimple.t)paramn).aLj();
      this.jnl.jfq = ((com.tencent.mm.modelsimple.t)paramn).aLk();
      if (paramInt2 == -205)
      {
        this.jlr = ((com.tencent.mm.modelsimple.t)paramn).aHO();
        this.jnp = ((com.tencent.mm.modelsimple.t)paramn).aLp();
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label2036;
      }
      i = 1;
      com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128066);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128066);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFs();
          com.tencent.mm.kernel.g.ajP();
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
        com.tencent.mm.plugin.account.friend.a.l.aTs();
        com.tencent.mm.platformtools.t.cW(this);
        y.Jv(this.jnl.account);
        paramString = bb.hIK.ay("login_weixin_username", "");
        if (this.jnn)
        {
          cd.hLa.aP(this.jno, paramString);
          cd.hLa.h(v.aAC(), v.aBv());
          com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cd.hLa.aCR() });
        }
        if ((this.jns != null) && (this.jns.isShowing())) {
          this.jns.setMessage(getString(2131755804));
        }
        paramString = (com.tencent.mm.modelsimple.t)paramn;
        ae.i("MicroMsg.LoginByMobileSendSmsUI", "checktask LoginByMobileSendSmsUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
        Intent localIntent = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
        localIntent.addFlags(67108864);
        if (paramString != null)
        {
          localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramString.aLn());
          localIntent.putExtra("kstyle_bind_recommend_show", paramString.aLq());
          localIntent.putExtra("kstyle_bind_wording", paramString.aLo());
        }
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        this.jnm = ((com.tencent.mm.modelsimple.t)paramn).aLr();
        if (((com.tencent.mm.modelsimple.t)paramn).aLl())
        {
          boolean bool = this.jnm;
          paramString = new Intent(this, RegByMobileSetPwdUI.class);
          paramString.putExtra("kintent_hint", getString(2131763302));
          paramString.putExtra("kintent_cancelable", bool);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128076);
        return;
      }
      if ((this.jns != null) && (this.jns.isShowing()))
      {
        this.jns.dismiss();
        this.jns = null;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 31685);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramn), paramInt2);
        AppMethodBeat.o(128076);
        return;
      }
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        if (com.tencent.mm.plugin.account.a.a.iUA.a(this, paramInt1, paramInt2, paramString))
        {
          if (this.jfm != null) {
            this.jfm.dismiss();
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
        if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
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
          y.de(this);
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
          com.tencent.mm.kernel.g.ajj().a(701, this);
          com.tencent.mm.kernel.g.ajj().a(252, this);
          if (this.jfm == null) {
            this.jfm = SecurityImage.a.a(this, this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                int i = -1;
                AppMethodBeat.i(128068);
                ae.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jfp + " img len" + LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
                int j = paramInt1;
                if (LoginByMobileSendSmsUI.this.jnq == null)
                {
                  paramAnonymousInt = -1;
                  paramAnonymousDialogInterface = bu.aSM(LoginByMobileSendSmsUI.this.jnq);
                  if (LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jfn != null) {
                    break label380;
                  }
                }
                for (;;)
                {
                  ae.d("MicroMsg.LoginByMobileSendSmsUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bu.aSM(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jfn) });
                  paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).account, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jfn, LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).joz, LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgCode(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgSid(), LoginByMobileSendSmsUI.f(LoginByMobileSendSmsUI.this).getSecImgEncryptKey(), 0, "", false, false);
                  if ((bu.isNullOrNil(LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jfn)) && (!bu.isNullOrNil(LoginByMobileSendSmsUI.this.jnq)))
                  {
                    ae.i("MicroMsg.LoginByMobileSendSmsUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bu.aSM(LoginByMobileSendSmsUI.this.jnq) });
                    paramAnonymousDialogInterface.GO(LoginByMobileSendSmsUI.this.jnq);
                  }
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI1 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI localLoginByMobileSendSmsUI2 = LoginByMobileSendSmsUI.this;
                  LoginByMobileSendSmsUI.this.getString(2131755906);
                  LoginByMobileSendSmsUI.a(localLoginByMobileSendSmsUI1, h.b(localLoginByMobileSendSmsUI2, LoginByMobileSendSmsUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(128067);
                      com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                      com.tencent.mm.kernel.g.ajj().b(701, LoginByMobileSendSmsUI.this);
                      com.tencent.mm.kernel.g.ajj().b(252, LoginByMobileSendSmsUI.this);
                      AppMethodBeat.o(128067);
                    }
                  }));
                  AppMethodBeat.o(128068);
                  return;
                  paramAnonymousInt = LoginByMobileSendSmsUI.this.jnq.length();
                  break;
                  label380:
                  i = LoginByMobileSendSmsUI.e(LoginByMobileSendSmsUI.this).jfn.length();
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
            }, this.jnl);
          }
          for (;;)
          {
            i = 1;
            break;
            ae.d("MicroMsg.LoginByMobileSendSmsUI", "imgSid:" + this.jnl.jfp + " img len" + this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
            this.jfm.b(this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq);
          }
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.ajP();
          if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
          for (paramn = com.tencent.mm.cb.a.az(this, 2131761063);; paramn = com.tencent.mm.kernel.a.aiH())
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
            com.tencent.mm.kernel.g.ajP();
          }
          ae.i("MicroMsg.LoginByMobileSendSmsUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bu.aSM(this.jlr), this.jnp });
          f.a(this.jnl);
          paramn = new Intent();
          paramn.putExtra("auth_ticket", this.jlr);
          paramn.putExtra("binded_mobile", this.jnj);
          paramn.putExtra("close_safe_device_style", this.jnp);
          paramn.putExtra("from_source", 2);
          com.tencent.mm.plugin.account.a.a.iUz.g(this, paramn);
          i = 1;
          continue;
          if (!bu.isNullOrNil(this.dLz)) {
            y.n(this, paramString, this.dLz);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
      paramString = com.tencent.mm.h.a.uU(paramString);
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
    com.tencent.mm.kernel.g.ajj().b(145, this);
    AppMethodBeat.o(128075);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */