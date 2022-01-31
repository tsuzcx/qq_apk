package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.h.a.je;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private String account;
  private String caS;
  private ProgressDialog dnm = null;
  private String fcX;
  private com.tencent.mm.ui.base.p fev;
  private SecurityImage fex = null;
  private String fky;
  private c flH = new c() {};
  private f fmA = new f();
  private String fmC;
  private String fmD;
  private EditText fni;
  private String fnj;
  private Button fnk;
  
  private void XJ()
  {
    Object localObject = this.fni.getText().toString();
    if (bk.bl(this.account))
    {
      h.h(this, q.j.verify_username_null_tip, q.j.login_err_title);
      return;
    }
    if (((String)localObject).equals(""))
    {
      h.h(this, q.j.verify_password_null_tip, q.j.login_err_title);
      return;
    }
    XM();
    com.tencent.mm.kernel.g.Dk().a(701, this);
    localObject = new q(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
    getString(q.j.app_tip);
    this.dnm = h.b(this, getString(q.j.login_logining), true, new LoginIndepPass.16(this, (q)localObject));
  }
  
  private boolean h(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInt1 != 4);
      switch (paramInt2)
      {
      default: 
        return false;
      case -140: 
        if (!bk.bl(this.caS)) {
          z.l(this.mController.uMN, paramString, this.caS);
        }
        return true;
      case -1: 
        bool1 = bool2;
      }
    } while (com.tencent.mm.kernel.g.Dk().KG() != 5);
    h.h(this, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
    return true;
    h.h(this, q.j.errcode_password, q.j.login_err_title);
    return true;
    h.h(this, q.j.login_err_mailnotverify, q.j.login_err_title);
    return true;
    com.tencent.mm.kernel.a.hold();
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    com.tencent.mm.kernel.g.DN();
    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {}
    for (paramString = com.tencent.mm.cb.a.ac(this.mController.uMN, q.j.main_err_another_place);; paramString = com.tencent.mm.kernel.a.CM())
    {
      h.a(localAppCompatActivity, paramString, this.mController.uMN.getString(q.j.app_tip), new LoginIndepPass.7(this), new LoginIndepPass.8(this));
      return true;
      com.tencent.mm.kernel.g.DN();
    }
  }
  
  protected final int getLayoutId()
  {
    return q.g.login_indep_pass;
  }
  
  protected final void initView()
  {
    this.fni = ((EditText)findViewById(q.f.indep_password));
    this.fnk = ((Button)findViewById(q.f.login_tip));
    enableOptionMenu(false);
    addTextOptionMenu(0, getString(q.j.login_login), new LoginIndepPass.9(this));
    this.fni.addTextChangedListener(new LoginIndepPass.10(this));
    this.fni.setOnEditorActionListener(new LoginIndepPass.11(this));
    this.fni.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          return true;
        }
        return false;
      }
    });
    this.fnk.setText(getString(q.j.login_login_by_sms));
    this.fnk.setOnClickListener(new LoginIndepPass.13(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        com.tencent.mm.plugin.b.a.qj("L200_100");
        paramAnonymousMenuItem = new Intent(LoginIndepPass.this, MobileInputUI.class);
        paramAnonymousMenuItem.putExtra("mobile_input_purpose", 1);
        paramAnonymousMenuItem.addFlags(67108864);
        LoginIndepPass.this.startActivity(paramAnonymousMenuItem);
        LoginIndepPass.this.finish();
        return true;
      }
    });
    this.fky = getIntent().getStringExtra("auth_ticket");
    if (!bk.bl(this.fky)) {
      new ah().postDelayed(new Runnable()
      {
        public final void run()
        {
          LoginIndepPass.a(LoginIndepPass.this, f.XP(), f.XQ());
        }
      }, 500L);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      y.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 == -1) && (paramInt1 == 1024) && (paramIntent != null))
      {
        str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
        paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
        bool = bk.bl(str);
        if (!bk.bl(str)) {
          break label157;
        }
      }
    }
    label157:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      y.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 == -217) {
        XJ();
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getString(q.j.login_indep_title);
    if (d.spd) {
      paramBundle = getString(q.j.app_name) + getString(q.j.alpha_version_alpha);
    }
    setMMTitle(paramBundle);
    this.fnj = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.fnj != null) {
      this.account = ar.Zt(this.fnj);
    }
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(701, this);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.flH);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L200_200") + ",2");
  }
  
  public void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.qi("L200_200");
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (this.fev != null)
    {
      this.fev.dismiss();
      this.fev = null;
    }
    if (paramm.getType() == 701)
    {
      this.caS = ((q)paramm).Qy();
      com.tencent.mm.kernel.g.Dk().b(701, this);
      this.fmA.feA = ((q)paramm).Qz();
      this.fmA.fez = ((q)paramm).QA();
      this.fmA.feB = ((q)paramm).QB();
      this.fmA.fns = ((q)paramm).getSecCodeType();
      this.fmA.account = this.account;
      this.fmA.fey = this.fni.getText().toString();
      if (paramInt2 == -75) {
        z.bT(this.mController.uMN);
      }
      do
      {
        return;
        if (paramInt2 == -106)
        {
          z.e(this, paramString, 0);
          return;
        }
        if (paramInt2 == -217)
        {
          z.a(this, e.a((q)paramm), paramInt2);
          return;
        }
        if (paramInt2 == -205)
        {
          this.fky = ((q)paramm).NK();
          this.fmC = ((q)paramm).QC();
          this.fmD = ((q)paramm).QF();
          y.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bk.aac(this.fky), this.fmD });
          f.a(this.fmA);
          paramString = new Intent();
          paramString.putExtra("auth_ticket", this.fky);
          paramString.putExtra("binded_mobile", this.fmC);
          paramString.putExtra("close_safe_device_style", this.fmD);
          paramString.putExtra("from_source", 5);
          com.tencent.mm.plugin.account.a.a.eUR.e(this, paramString);
          return;
        }
        if (paramInt2 != -140) {
          break;
        }
      } while (bk.bl(this.caS));
      z.l(this, paramString, this.caS);
      return;
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1098;
      }
      com.tencent.mm.kernel.g.Dk().a(new bi(new LoginIndepPass.3(this)), 0);
    }
    label1098:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.Dk().a(701, this);
        if (this.fex == null)
        {
          this.fex = SecurityImage.a.a(this.mController.uMN, q.j.regbyqq_secimg_title, this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB, new LoginIndepPass.4(this), null, new LoginIndepPass.5(this), this.fmA);
          return;
        }
        y.d("MicroMsg.LoginIndepPass", "imgSid:" + this.fmA.feA + " img len" + this.fmA.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
        this.fex.a(this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        z.pi(this.fmA.account);
        w.bL(this);
        z.showAddrBookUploadConfirm(this, new LoginIndepPass.6(this), false, 2);
        return;
      }
      if (h(paramInt1, paramInt2, paramString)) {
        break;
      }
      if (paramm.getType() == 701)
      {
        paramString = com.tencent.mm.i.a.eI(paramString);
        if ((paramString != null) && (paramString.a(this, null, null))) {
          break;
        }
      }
      Toast.makeText(this, getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
      if (paramm.getType() == 145)
      {
        com.tencent.mm.kernel.g.Dk().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramm).NL();
        if (paramInt2 == -41)
        {
          h.h(this, q.j.regbymobile_reg_mobile_format_err_msg, q.j.regbymobile_reg_mobile_format_err_title);
          return;
        }
        if (paramInt2 == -75)
        {
          h.b(this, getString(q.j.alpha_version_tip_login), "", true);
          return;
        }
        com.tencent.mm.plugin.b.a.qj("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.g.DN();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.fnj);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("login_type", 3);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramm).NQ());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramm).NR());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramm).NS());
        a(MobileVerifyUI.class, (Intent)localObject);
        return;
      }
      if ((h(paramInt1, paramInt2, paramString)) || ((paramInt1 == 0) && (paramInt2 == 0))) {
        break;
      }
      Toast.makeText(this, getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass
 * JD-Core Version:    0.7.0.1
 */