package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.at.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;

public class MobileInputUI
  extends MMActivity
{
  protected String countryCode = null;
  protected int dVU;
  protected String esg = null;
  protected LinearLayout fbR;
  protected TextView fbT;
  protected String fbX = null;
  protected String fcX;
  protected p fev;
  private com.tencent.mm.sdk.b.c flH = new MobileInputUI.1(this);
  private ResizeLayout fmH;
  private Button fmQ;
  protected int[] fmY = new int[5];
  protected String fml = null;
  protected EditText fmq;
  protected Button fmw;
  protected Button fmx;
  private View fmy;
  protected Button fmz;
  protected MMFormInputView fnC;
  protected boolean fnH;
  private com.tencent.mm.ui.widget.a.d fnI;
  private MMKeyboardUperView fnJ;
  protected boolean fnK = false;
  private final int fnL = 128;
  protected View foA;
  protected boolean foB = true;
  protected String foC = null;
  protected String foD = null;
  private int foE = 0;
  private MobileInputUI.b foF;
  protected boolean foG;
  protected MMFormInputView foo;
  protected EditText fop;
  protected MMFormVerifyCodeInputView foq;
  protected View jdField_for;
  protected TextView fos;
  protected Button fot;
  protected Button fou;
  protected TextView fow;
  protected TextView fox;
  protected TextView foy;
  protected Button foz;
  
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
  
  private void XT()
  {
    XM();
    this.foF.a(MobileInputUI.a.foK);
  }
  
  private void XU()
  {
    if ((!bk.bl(this.esg)) && (!bk.bl(this.countryCode)))
    {
      this.fbT.setText(ar.gf(this.esg, this.countryCode));
      return;
    }
    this.fbT.setText(getString(q.j.mobile_code_error));
  }
  
  private void goBack()
  {
    if (this.foG)
    {
      XM();
      Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.gK(this);
      return;
    }
    this.foF.a(MobileInputUI.a.foJ);
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    XM();
    finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(q.a.anim_not_change, q.a.anim_not_change);
    com.tencent.mm.plugin.report.service.h.nFQ.f(14262, new Object[] { Integer.valueOf(this.fmY[0]), Integer.valueOf(this.fmY[1]), Integer.valueOf(this.fmY[2]), Integer.valueOf(this.fmY[3]), Integer.valueOf(this.fmY[4]) });
  }
  
  protected final int getLayoutId()
  {
    return q.g.mobile_input_ui;
  }
  
  protected final void initView()
  {
    this.fnC = ((MMFormInputView)findViewById(q.f.setpassword_container));
    this.fmq = this.fnC.getContentEditText();
    com.tencent.mm.ui.tools.a.c.d(this.fmq).Ig(16).a(null);
    this.foo = ((MMFormInputView)findViewById(q.f.mobile_number_display));
    this.foo.setInputType(3);
    this.fop = this.foo.getContentEditText();
    this.foq = ((MMFormVerifyCodeInputView)findViewById(q.f.sms_verify_container));
    this.foq.setInputType(3);
    this.fbR = ((LinearLayout)findViewById(q.f.country_code_ll));
    this.fbT = ((TextView)findViewById(q.f.country_name));
    this.jdField_for = findViewById(q.f.reg_license);
    this.fos = ((TextView)findViewById(q.f.agree_text));
    this.fot = ((Button)findViewById(q.f.agree_btn));
    this.fou = ((Button)findViewById(q.f.next_btn));
    this.fow = ((TextView)findViewById(q.f.register_title));
    this.fox = ((TextView)findViewById(q.f.login_title));
    this.foy = ((TextView)findViewById(q.f.mobile_input_hint));
    this.foz = ((Button)findViewById(q.f.login_by_other));
    this.fmQ = ((Button)findViewById(q.f.login_as_other_device_btn));
    this.fmw = ((Button)findViewById(q.f.login_find_password_btn));
    this.fmx = ((Button)findViewById(q.f.login_freeze_account_btn));
    this.fmy = findViewById(q.f.free_btn_container);
    this.fmz = ((Button)findViewById(q.f.login_more_btn));
    this.foA = findViewById(q.f.bottom_btn_container);
    this.fmH = ((ResizeLayout)findViewById(q.f.resize_lv));
    this.fnJ = ((MMKeyboardUperView)findViewById(q.f.scrollView));
    this.fbR.setVisibility(8);
    this.fnC.setVisibility(8);
    this.foq.setVisibility(8);
    this.foo.setVisibility(8);
    this.fow.setVisibility(8);
    this.fox.setVisibility(8);
    this.fou.setVisibility(8);
    this.jdField_for.setVisibility(8);
    this.foz.setVisibility(8);
    this.fmH.setOnSizeChanged(new MobileInputUI.16(this));
    this.fmw.setOnClickListener(new MobileInputUI.17(this));
    this.fmx.setOnClickListener(new MobileInputUI.18(this));
    this.fnI = new com.tencent.mm.ui.widget.a.d(this, 1, false);
    this.fnI.phH = new MobileInputUI.19(this);
    this.fnI.phI = new MobileInputUI.20(this);
    this.fnI.wmU = new MobileInputUI.2(this);
    Object localObject;
    if (x.cqG())
    {
      this.fmz.setOnClickListener(new MobileInputUI.3(this));
      localObject = new boolean[1];
      localObject[0] = 1;
      this.fop.setOnFocusChangeListener(new MobileInputUI.5(this, (boolean[])localObject));
      this.fop.addTextChangedListener(new MobileInputUI.6(this, (boolean[])localObject));
      this.fmq.addTextChangedListener(new MobileInputUI.7(this));
      this.fop.setOnEditorActionListener(new MobileInputUI.8(this));
      this.fop.setOnKeyListener(new MobileInputUI.9(this));
      this.fou.setEnabled(false);
      this.fou.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            return false;
            com.tencent.mm.plugin.normsg.a.b.mGK.ei("ce_reg_eu", "<Reg>");
            continue;
            com.tencent.mm.plugin.normsg.a.b.mGK.a("ce_reg_eu", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.b.mGK.Ka("ce_reg_eu");
          }
        }
      });
      this.fou.setOnClickListener(new MobileInputUI.11(this));
      if (!bk.bl(this.countryCode)) {
        break label927;
      }
      this.esg = getString(q.j.country_normal_name);
      this.countryCode = ar.Zu(getString(q.j.country_normal_code));
      label703:
      if ((bk.bl(this.esg)) || (bk.bl(this.countryCode)))
      {
        this.fml = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        y.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.fml);
        if (!bk.bl(this.fml)) {
          break label949;
        }
        y.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      XU();
      if (bk.bl(this.fbX)) {
        this.fop.setText(this.fbX);
      }
      this.fbR.setOnClickListener(new MobileInputUI.13(this));
      localObject = "";
      if (com.tencent.mm.protocal.d.spd) {
        localObject = getString(q.j.app_name) + getString(q.j.alpha_version_alpha);
      }
      setMMTitle((String)localObject);
      ta(getResources().getColor(q.c.normal_actionbar_color));
      czo();
      return;
      this.fmy.setVisibility(8);
      this.fmz.setText(q.j.login_by_more);
      this.fmz.setOnClickListener(new MobileInputUI.4(this));
      break;
      label927:
      this.esg = com.tencent.mm.at.b.j(this, this.countryCode, getString(q.j.country_code));
      break label703;
      label949:
      localObject = com.tencent.mm.at.b.i(this, this.fml, getString(q.j.country_code));
      if (localObject == null)
      {
        y.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = ar.Zu(((b.a)localObject).esf);
        this.esg = ((b.a)localObject).esg;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 32047)
    {
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(712L, 2L, 1L, false);
        if ((this.foF instanceof k)) {
          ((k)this.foF).foh = 0;
        }
        this.foF.a(MobileInputUI.a.foK);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            com.tencent.mm.plugin.report.service.h.nFQ.a(712L, 1L, 1L, false);
          } while (!(this.foF instanceof k));
          ((k)this.foF).foh = 1;
          return;
          if (paramInt1 != 32046) {
            break;
          }
          localObject1 = localObject2;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
        } while ((paramInt2 != -1) || (localObject1 == null) || (!((Bundle)localObject1).getString("go_next", "").equals("get_reg_verify_code")));
        if ((this.foF instanceof k)) {
          ((k)this.foF).foh = 2;
        }
        this.foF.a(MobileInputUI.a.foK);
        return;
        if (paramInt1 != 32045) {
          break;
        }
        localObject1 = localObject3;
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
      } while ((paramInt2 != -1) || (localObject1 == null) || (!((Bundle)localObject1).getString("go_next", "").equals("auth_again")) || (!(this.foF instanceof l)));
      this.foF.a(MobileInputUI.a.foK);
      return;
      switch (paramInt2)
      {
      default: 
        return;
      }
    } while ((paramInt1 != 1024) || (paramIntent == null));
    localObject1 = paramIntent.getStringExtra("VoiceLoginAuthPwd");
    paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
    boolean bool = bk.bl((String)localObject1);
    if (bk.bl((String)localObject1)) {}
    for (paramInt1 = i;; paramInt1 = ((String)localObject1).length())
    {
      y.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break;
      }
      XT();
      return;
      this.esg = bk.aM(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bk.aM(paramIntent.getStringExtra("couttry_code"), "");
      this.fml = bk.aM(paramIntent.getStringExtra("iso_code"), "");
      if ((this.foE == 2) && (!com.tencent.mm.at.b.mD(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.esg);
        paramIntent.putExtra("iso_code", this.fml);
        startActivity(paramIntent);
        finish();
        return;
      }
      XU();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(this.mController.uMN.getResources().getColor(q.c.normal_bg_color));
    this.foE = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.dVU = getIntent().getIntExtra("mobile_auth_type", 0);
    this.foG = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MobileInputUI.12(this), q.i.actionbar_icon_close_black);
    ta(this.mController.uMN.getResources().getColor(q.c.normal_actionbar_color));
    czo();
    switch (this.foE)
    {
    case 0: 
    default: 
      y.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.foE) });
      finish();
      return;
    case 1: 
      if (!bk.bl(getIntent().getStringExtra("auth_ticket"))) {
        this.foF = new l();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = ar.Zu(bk.aM(getIntent().getStringExtra("couttry_code"), ""));
      this.esg = bk.aM(getIntent().getStringExtra("country_name"), "");
      this.fml = bk.pm(getIntent().getStringExtra("iso_code"));
      this.fbX = bk.aM(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.foC = ar.Zv(this.countryCode);
      this.foD = bk.aM(getIntent().getStringExtra("input_mobile_number"), "");
      this.fcX = com.tencent.mm.plugin.b.a.YA();
      initView();
      this.fnK = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.fnK) && (!bk.bl(this.foC)) && (!bk.bl(this.foD))) {
        this.foo.setText(this.foD);
      }
      this.foF.a(this);
      if (com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN)
      {
        this.fmQ.setVisibility(0);
        this.fmQ.setOnClickListener(new MobileInputUI.15(this));
      }
      this.fnH = getIntent().getBooleanExtra("from_switch_account", false);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.fmY = paramBundle;
      }
      this.foF = new i();
      continue;
      this.foF = new k();
      continue;
      this.foF = new h();
      continue;
      this.foF = new j();
      continue;
      this.foF = new l();
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.plugin.normsg.a.b.mGK.JX("ie_reg_eu");
    this.foq.reset();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
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
    this.foF.stop();
  }
  
  public void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
    this.foF.start();
  }
  
  public void setRequestedOrientation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */