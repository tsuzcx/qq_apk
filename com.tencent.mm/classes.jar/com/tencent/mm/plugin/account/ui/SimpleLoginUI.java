package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.xlog.app.XLogSetup;

public class SimpleLoginUI
  extends MMWizardActivity
  implements com.tencent.mm.ah.f
{
  private TextWatcher ajS = new SimpleLoginUI.1(this);
  private String caS = "";
  private ProgressDialog dnm = null;
  private SecurityImage fex = null;
  private String fky;
  private com.tencent.mm.sdk.b.c flH = new SimpleLoginUI.12(this);
  private f fmA = new f();
  private String fmC;
  private String fmD;
  private ResizeLayout fmH;
  private MMClearEditText fnA;
  private MMFormInputView fnB;
  private MMFormInputView fnC;
  private Button fnD;
  private MMKeyboardUperView fnJ;
  private MMClearEditText fnz;
  
  private void Wc()
  {
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    FW(1);
    if (bool) {
      exit(1);
    }
  }
  
  private void XJ()
  {
    this.fmA.account = this.fnz.getText().toString().trim();
    this.fmA.fey = this.fnA.getText().toString();
    if (this.fmA.account.equals(""))
    {
      h.h(this, q.j.verify_username_null_tip, q.j.login_err_title);
      return;
    }
    if (this.fmA.fey.equals(""))
    {
      h.h(this, q.j.verify_password_null_tip, q.j.login_err_title);
      return;
    }
    XM();
    q localq = new q(this.fmA.account, this.fmA.fey, this.fky, 0);
    com.tencent.mm.kernel.g.Dk().a(localq, 0);
    getString(q.j.app_tip);
    this.dnm = h.b(this, getString(q.j.login_logining), true, new SimpleLoginUI.5(this, localq));
  }
  
  protected final int getLayoutId()
  {
    return q.g.login;
  }
  
  protected final void initView()
  {
    this.fnB = ((MMFormInputView)findViewById(q.f.login_account_auto));
    this.fnC = ((MMFormInputView)findViewById(q.f.login_password_et));
    this.fnz = ((MMClearEditText)this.fnB.getContentEditText());
    this.fnz.setFocusableInTouchMode(false);
    this.fnz.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(true);
        return SimpleLoginUI.c(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
      }
    });
    this.fnA = ((MMClearEditText)this.fnC.getContentEditText());
    this.fnA.setFocusableInTouchMode(false);
    this.fnA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        SimpleLoginUI.d(SimpleLoginUI.this).setFocusableInTouchMode(true);
        SimpleLoginUI.c(SimpleLoginUI.this).setFocusableInTouchMode(false);
        return SimpleLoginUI.d(SimpleLoginUI.this).getDefaultOnTouchListener().onTouch(paramAnonymousView, paramAnonymousMotionEvent);
      }
    });
    com.tencent.mm.ui.tools.a.c.d(this.fnA).Ig(16).a(null);
    this.fnD = ((Button)findViewById(q.f.login_btn));
    this.fnD.setEnabled(false);
    this.fnz.addTextChangedListener(this.ajS);
    this.fnA.addTextChangedListener(this.ajS);
    this.fnA.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          SimpleLoginUI.b(SimpleLoginUI.this);
          return true;
        }
        return false;
      }
    });
    this.fnA.setOnKeyListener(new SimpleLoginUI.17(this));
    this.fmH = ((ResizeLayout)findViewById(q.f.resize_lv));
    this.fnJ = ((MMKeyboardUperView)findViewById(q.f.scrollView));
    this.fmH.setOnSizeChanged(new SimpleLoginUI.18(this));
    this.fnJ.setOnTouchListener(new SimpleLoginUI.19(this));
    findViewById(q.f.login_by_other).setVisibility(8);
    View localView = findViewById(q.f.fblogin_tip);
    if (localView != null) {
      localView.setVisibility(8);
    }
    setMMTitle(q.j.login_title);
    setBackBtn(new SimpleLoginUI.2(this));
    this.fky = getIntent().getStringExtra("auth_ticket");
    if (!bk.bl(this.fky))
    {
      this.fnz.setText(bk.pm(f.XP()));
      this.fnA.setText(bk.pm(f.XQ()));
      new ah().postDelayed(new SimpleLoginUI.3(this), 500L);
    }
    if (com.tencent.mm.sdk.platformtools.e.uem) {
      com.tencent.mm.plugin.account.a.a.eUS.n(this);
    }
    this.fnD.setOnClickListener(new SimpleLoginUI.4(this));
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
      y.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      y.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    int i = 0;
    super.onCreate(paramBundle);
    paramBundle = getSharedPreferences("system_config_prefs", 4);
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(q.j.app_name);
    if (com.tencent.mm.plugin.account.a.a.eUS != null) {
      com.tencent.mm.plugin.account.a.a.eUS.tn();
    }
    initView();
    com.tencent.mm.kernel.g.Dk().a(701, this);
    boolean bool = com.tencent.mm.pluginsdk.permission.a.g(this, "android.permission.WRITE_EXTERNAL_STORAGE");
    y.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {}
    for (;;)
    {
      if (i == 0)
      {
        new Intent().addFlags(67108864);
        com.tencent.mm.plugin.account.a.a.eUR.q(new Intent(), this);
      }
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.g(this, "android.permission.READ_PHONE_STATE");
      y.i("MicroMsg.MPermissionUtil", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        i = 1;
      }
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(701, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Wc();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.fky = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.fky = paramIntent.getString("auth_ticket");
    }
    if (!bk.bl(this.fky))
    {
      this.fnz.setText(bk.pm(f.XP()));
      this.fnA.setText(bk.pm(f.XQ()));
      new ah().postDelayed(new SimpleLoginUI.13(this), 500L);
    }
  }
  
  protected void onPause()
  {
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.flH);
  }
  
  public void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    y.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramm.getType());
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    this.caS = ((q)paramm).Qy();
    int i;
    if (paramm.getType() == 701)
    {
      this.fmA.fns = ((q)paramm).getSecCodeType();
      this.fmA.feA = ((q)paramm).Qz();
      this.fmA.fez = ((q)paramm).QA();
      this.fmA.feB = ((q)paramm).QB();
      if (paramInt2 == -205)
      {
        this.fky = ((q)paramm).NK();
        this.fmC = ((q)paramm).QC();
        this.fmD = ((q)paramm).QF();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.g.Dk().a(new bi(new SimpleLoginUI.10(this)), 0);
      }
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        w.bL(this);
        z.pi(this.fmA.account);
        paramString = new com.tencent.mm.plugin.account.model.c(this.mController.uMN, new SimpleLoginUI.11(this));
        paramString.bJk = com.tencent.mm.plugin.account.a.a.eUS.a(paramString);
        if (paramString.bJk == null) {
          if (paramString.fjr != null) {
            paramString.fjr.Xw();
          }
        }
      }
      label1160:
      for (;;)
      {
        return;
        if (paramString.bJk.getType() == 139) {
          com.tencent.mm.kernel.g.Dk().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.Dk().a(paramString.bJk, 0);
          paramm = paramString.context;
          paramString.context.getString(q.j.app_tip);
          paramString.tipDialog = h.b(paramm, paramString.context.getString(q.j.app_loading_data), true, new c.1(paramString));
          return;
          if (paramString.bJk.getType() == 138) {
            com.tencent.mm.kernel.g.Dk().a(138, paramString);
          }
        }
        if (paramInt2 == -217)
        {
          z.a(this, com.tencent.mm.platformtools.e.a((q)paramm), paramInt2);
          return;
        }
        if (com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            break label1160;
          }
          paramString = com.tencent.mm.i.a.eI(paramString);
          if ((paramString != null) && (paramString.a(this, null, null))) {
            break;
          }
          Toast.makeText(this, getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
          return;
          if (paramInt1 == 4) {}
          switch (paramInt2)
          {
          default: 
            i = 0;
            break;
          case -1: 
            if (com.tencent.mm.kernel.g.Dk().KG() == 5)
            {
              h.h(this, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
              i = 1;
            }
            break;
          case -30: 
          case -4: 
          case -3: 
            h.h(this, q.j.errcode_password, q.j.login_err_title);
            i = 1;
            break;
          case -9: 
            h.h(this, q.j.login_err_mailnotverify, q.j.login_err_title);
            i = 1;
            break;
          case -72: 
            h.h(this.mController.uMN, q.j.regbyqq_auth_err_failed_niceqq, q.j.app_tip);
            i = 1;
            break;
          case -75: 
            z.bT(this.mController.uMN);
            i = 1;
            break;
          case -311: 
          case -310: 
          case -6: 
            if (this.fex == null) {
              this.fex = SecurityImage.a.a(this.mController.uMN, q.j.regbyqq_secimg_title, this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB, new SimpleLoginUI.6(this), null, new SimpleLoginUI.7(this), this.fmA);
            }
            for (;;)
            {
              i = 1;
              break;
              y.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.fmA.feA + " img len" + this.fmA.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
              this.fex.a(this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB);
            }
          case -100: 
            com.tencent.mm.kernel.a.hold();
            com.tencent.mm.kernel.g.DN();
            h.a(this, com.tencent.mm.kernel.a.CM(), getString(q.j.app_tip), new SimpleLoginUI.8(this), new SimpleLoginUI.9(this));
            i = 1;
            break;
          case -205: 
            y.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bk.aac(this.fky), this.fmD });
            f.a(this.fmA);
            paramm = new Intent();
            paramm.putExtra("auth_ticket", this.fky);
            paramm.putExtra("binded_mobile", this.fmC);
            paramm.putExtra("close_safe_device_style", this.fmD);
            paramm.putExtra("from_source", 3);
            com.tencent.mm.plugin.account.a.a.eUR.e(this, paramm);
            i = 1;
            break;
          case -140: 
            if (!bk.bl(this.caS)) {
              z.l(this, paramString, this.caS);
            }
            i = 1;
            break;
          case -106: 
            z.e(this, paramString, 0);
            i = 1;
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI
 * JD-Core Version:    0.7.0.1
 */