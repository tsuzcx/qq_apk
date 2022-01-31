package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.at.b;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bv;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.s;

public class LoginUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private TextWatcher ajS = new LoginUI.1(this);
  private String bJY = null;
  private String caS = "";
  private ProgressDialog dnm = null;
  private String fcX;
  private SecurityImage fex = null;
  private String fky;
  private com.tencent.mm.sdk.b.c flH = new LoginUI.12(this);
  private f fmA = new f();
  private String fmC;
  private String fmD;
  private ResizeLayout fmH;
  private com.tencent.mm.platformtools.c fmK;
  private Button fmQ;
  protected Button fmw;
  protected Button fmx;
  private View fmy;
  protected Button fmz;
  private MMClearEditText fnA;
  private MMFormInputView fnB;
  private MMFormInputView fnC;
  private Button fnD;
  private Button fnE;
  protected View fnF;
  private String fnG;
  private boolean fnH;
  private com.tencent.mm.ui.widget.a.d fnI;
  private MMKeyboardUperView fnJ;
  private boolean fnK = false;
  private final int fnL = 128;
  private MMClearEditText fnz;
  private int sceneType = 0;
  
  private static void N(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
  }
  
  private void XJ()
  {
    this.fmA.account = this.fnz.getText().toString().trim();
    this.fmA.fey = this.fnA.getText().toString();
    if (this.fmA.account.equals(""))
    {
      com.tencent.mm.ui.base.h.h(this, q.j.verify_username_null_tip, q.j.login_err_title);
      return;
    }
    if (this.fmA.fey.equals(""))
    {
      com.tencent.mm.ui.base.h.h(this, q.j.verify_password_null_tip, q.j.login_err_title);
      return;
    }
    XM();
    com.tencent.mm.kernel.g.Dk().a(701, this);
    com.tencent.mm.modelsimple.q localq = new com.tencent.mm.modelsimple.q(this.fmA.account, this.fmA.fey, this.fky, 2);
    com.tencent.mm.kernel.g.Dk().a(localq, 0);
    getString(q.j.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(q.j.login_logining), true, new LoginUI.19(this, localq));
  }
  
  private void goBack()
  {
    XM();
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    com.tencent.mm.pluginsdk.model.app.p.ckW();
    finish();
  }
  
  private boolean h(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = false;
    if (com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
      bool = true;
    }
    do
    {
      return bool;
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        paramString = new ag(paramInt1, paramInt2, paramString);
        return this.fmK.a(this, paramString);
      }
    } while (com.tencent.mm.kernel.g.Dk().KG() != 5);
    com.tencent.mm.ui.base.h.h(this, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
    return true;
    com.tencent.mm.ui.base.h.h(this, q.j.errcode_password, q.j.login_err_title);
    return true;
    com.tencent.mm.ui.base.h.h(this, q.j.login_err_mailnotverify, q.j.login_err_title);
    return true;
    com.tencent.mm.ui.base.h.h(this.mController.uMN, q.j.regbyqq_auth_err_failed_niceqq, q.j.app_tip);
    return true;
    z.bT(this.mController.uMN);
    return true;
    com.tencent.mm.kernel.g.Dk().a(701, this);
    if (this.fex == null) {
      this.fex = SecurityImage.a.a(this, q.j.regbyqq_secimg_title, this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB, new LoginUI.13(this), null, new LoginUI.14(this), this.fmA);
    }
    for (;;)
    {
      return true;
      y.d("MicroMsg.LoginUI", "imgSid:" + this.fmA.feA + " img len" + this.fmA.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
      this.fex.a(this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB);
    }
    com.tencent.mm.kernel.a.hold();
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    com.tencent.mm.kernel.g.DN();
    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {}
    for (paramString = com.tencent.mm.cb.a.ac(this.mController.uMN, q.j.main_err_another_place);; paramString = com.tencent.mm.kernel.a.CM())
    {
      com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramString, this.mController.uMN.getString(q.j.app_tip), new LoginUI.15(this), new LoginUI.16(this));
      return true;
      com.tencent.mm.kernel.g.DN();
    }
    y.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bk.aac(this.fky), this.fmD });
    f.a(this.fmA);
    com.tencent.mm.plugin.b.a.qj("L600_100");
    paramString = new Intent();
    paramString.putExtra("auth_ticket", this.fky);
    paramString.putExtra("binded_mobile", this.fmC);
    paramString.putExtra("close_safe_device_style", this.fmD);
    paramString.putExtra("from_source", 1);
    com.tencent.mm.plugin.account.a.a.eUR.e(this, paramString);
    return true;
    if (!bk.bl(this.caS)) {
      z.l(this, paramString, this.caS);
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(q.a.anim_not_change, q.a.anim_not_change);
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
    this.fnA = ((MMClearEditText)this.fnC.getContentEditText());
    com.tencent.mm.ui.tools.a.c.d(this.fnA).Ig(16).a(null);
    this.fnD = ((Button)findViewById(q.f.login_btn));
    this.fnD.setEnabled(false);
    this.fnE = ((Button)findViewById(q.f.login_by_other));
    this.fmQ = ((Button)findViewById(q.f.login_as_other_device_btn));
    this.fnF = findViewById(q.f.login_bottom_container);
    this.fnF.setVisibility(0);
    this.fmw = ((Button)findViewById(q.f.login_find_password_btn));
    this.fmy = findViewById(q.f.free_btn_container);
    this.fmx = ((Button)findViewById(q.f.login_freeze_account_btn));
    this.fmz = ((Button)findViewById(q.f.login_more_btn));
    this.fmH = ((ResizeLayout)findViewById(q.f.resize_lv));
    this.fnJ = ((MMKeyboardUperView)findViewById(q.f.scrollView));
    this.fmH.setOnSizeChanged(new LoginUI.20(this));
    boolean bool = b.Pc();
    Object localObject = findViewById(q.f.fblogin_tip);
    int i;
    if (!bool)
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      ((View)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          LoginUI.this.startActivity(new Intent(LoginUI.this, FacebookLoginUI.class));
        }
      });
      this.fmw.setOnClickListener(new LoginUI.22(this));
      this.fmx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = LoginUI.this.getString(q.j.freeze_account_url, new Object[] { x.cqJ() });
          LoginUI.O(LoginUI.this, paramAnonymousView);
        }
      });
      this.fnI = new com.tencent.mm.ui.widget.a.d(this, 1, false);
      this.fnI.phH = new LoginUI.24(this);
      this.fnI.wmU = new LoginUI.25(this);
      this.fnI.phI = new LoginUI.26(this);
      if (!x.cqG()) {
        break label649;
      }
      this.fmz.setOnClickListener(new LoginUI.2(this));
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new LoginUI.4(this), q.i.actionbar_icon_close_black);
      this.fnD.setOnClickListener(new LoginUI.5(this));
      this.fnE.setOnClickListener(new LoginUI.6(this));
      this.fky = getIntent().getStringExtra("auth_ticket");
      if (!bk.bl(this.fky))
      {
        this.fnz.setText(bk.pm(f.XP()));
        this.fnA.setText(bk.pm(f.XQ()));
        new ah().postDelayed(new LoginUI.7(this), 500L);
      }
      this.fnz.addTextChangedListener(this.ajS);
      this.fnA.addTextChangedListener(this.ajS);
      this.fnA.setOnEditorActionListener(new LoginUI.8(this));
      this.fnA.setOnKeyListener(new LoginUI.9(this));
      if (com.tencent.mm.sdk.platformtools.e.uem) {
        com.tencent.mm.plugin.account.a.a.eUS.n(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.fnK = getIntent().getBooleanExtra("from_deep_link", false);
      if (!bk.bl((String)localObject)) {
        this.fnz.setText((CharSequence)localObject);
      }
      if (com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN)
      {
        this.fmQ.setVisibility(0);
        this.fmQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            com.tencent.mm.br.d.x(LoginUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginUI.this.overridePendingTransition(q.a.push_down_in, q.a.anim_not_change);
          }
        });
      }
      return;
      i = 0;
      break;
      label649:
      this.fmy.setVisibility(8);
      this.fmz.setText(q.j.login_by_more);
      this.fmz.setOnClickListener(new LoginUI.3(this));
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
      y.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 == -1)
      {
        if ((paramInt1 != 1024) || (paramIntent == null)) {
          break label175;
        }
        str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
        paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
        bool = bk.bl(str);
        if (!bk.bl(str)) {
          break label166;
        }
        paramInt1 = i;
        label104:
        y.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (paramInt2 == -217)
        {
          this.fmA.fey = str;
          XJ();
        }
      }
    }
    label166:
    label175:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        paramInt1 = str.length();
        break label104;
      } while ((paramInt1 != 32644) || (paramIntent == null));
      paramIntent = paramIntent.getBundleExtra("result_data");
    } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("auth_again")));
    XJ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(this.mController.uMN.getResources().getColor(q.c.normal_bg_color));
    paramBundle = "";
    if (com.tencent.mm.protocal.d.spd) {
      paramBundle = getString(q.j.app_name) + getString(q.j.alpha_version_alpha);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    ta(getResources().getColor(q.c.normal_actionbar_color));
    czo();
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
    this.fmK = new com.tencent.mm.platformtools.c();
    this.fnH = getIntent().getBooleanExtra("from_switch_account", false);
    this.fnG = at.dVC.L("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
  }
  
  public void onDestroy()
  {
    if (this.fmK != null) {
      this.fmK.close();
    }
    com.tencent.mm.kernel.g.Dk().b(701, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.flH);
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L100_100_logout") + ",2");
    }
    while (this.sceneType != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L400_100_login,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L400_100_login") + ",2");
  }
  
  public void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.qi("L100_100_logout");
    }
    while (this.sceneType != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L400_100_login,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L400_100_login") + ",1");
    com.tencent.mm.plugin.b.a.qi("L400_100_login");
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (paramm.getType() != 701) {
      return;
    }
    com.tencent.mm.kernel.g.Dk().b(701, this);
    this.caS = ((com.tencent.mm.modelsimple.q)paramm).Qy();
    this.fmA.feA = ((com.tencent.mm.modelsimple.q)paramm).Qz();
    this.fmA.fez = ((com.tencent.mm.modelsimple.q)paramm).QA();
    this.fmA.feB = ((com.tencent.mm.modelsimple.q)paramm).QB();
    this.fmA.fns = ((com.tencent.mm.modelsimple.q)paramm).getSecCodeType();
    this.fmA.account = ((com.tencent.mm.modelsimple.q)paramm).account;
    if (paramInt2 == -205)
    {
      this.fky = ((com.tencent.mm.modelsimple.q)paramm).NK();
      this.fmC = ((com.tencent.mm.modelsimple.q)paramm).QC();
      this.fmD = ((com.tencent.mm.modelsimple.q)paramm).QF();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.Dk().a(new bi(new LoginUI.17(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        z.pi(this.fmA.account);
        paramString = at.dVC.L("login_weixin_username", "");
        w.bL(this);
        if (this.fnH)
        {
          bv.dXJ.ab(this.fnG, paramString);
          bv.dXJ.f(com.tencent.mm.model.q.Gj(), com.tencent.mm.model.q.GT());
          com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), bv.dXJ.Ij() });
        }
        z.showAddrBookUploadConfirm(this, new LoginUI.18(this, paramm), false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.DN();
        paramString = paramString.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_900_phone") + ",4");
        if (!this.fnK) {
          break;
        }
        paramString = ae.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
        com.tencent.mm.plugin.report.service.h.nFQ.f(11930, new Object[] { paramString, Integer.valueOf(4) });
        return;
      }
      if (paramInt2 == -106)
      {
        z.e(this, paramString, 32644);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.q)paramm), paramInt2);
        return;
      }
      if (h(paramInt1, paramInt2, paramString)) {
        break;
      }
      if (paramInt2 == -5)
      {
        Toast.makeText(this, getString(q.j.loginby_access_denied), 0).show();
        return;
      }
      paramString = com.tencent.mm.i.a.eI(paramString);
      if ((paramString != null) && (paramString.a(this, null, null))) {
        break;
      }
      Toast.makeText(this, getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */