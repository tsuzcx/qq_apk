package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private String caS = "";
  private SharedPreferences dnD;
  protected ProgressDialog dnm = null;
  private SecurityImage fex = null;
  protected int fhr;
  protected String fky;
  private com.tencent.mm.sdk.b.c flH = new LoginHistoryUI.1(this);
  protected f fmA = new f();
  protected String fmB;
  protected String fmC;
  private String fmD;
  private String fmE;
  private ImageView fmF;
  private MMKeyboardUperView fmG;
  private ResizeLayout fmH;
  protected String fmI;
  private String fmJ;
  private com.tencent.mm.platformtools.c fmK;
  protected LinearLayout fmL;
  protected LinearLayout fmM;
  protected LinearLayout fmN;
  protected MMFormInputView fmO;
  protected MMFormVerifyCodeInputView fmP;
  private Button fmQ;
  protected String fmR = "";
  protected boolean fmS = false;
  protected boolean fmT;
  private int fmU;
  private int fmV;
  private boolean fmW = false;
  private String fmX;
  protected int[] fmY = new int[5];
  private int fmZ;
  protected TextView fmp;
  protected EditText fmq;
  protected Button fmr;
  protected Button fms;
  protected View fmt;
  protected View fmu;
  protected View fmv;
  protected Button fmw;
  protected Button fmx;
  private View fmy;
  protected Button fmz;
  private String fna;
  private int fnb = 0;
  
  public static void N(Context paramContext, String paramString)
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
  
  private void b(q paramq)
  {
    y.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
    Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
    localIntent.addFlags(67108864);
    if (paramq != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramq.QD());
      localIntent.putExtra("kstyle_bind_recommend_show", paramq.QG());
      localIntent.putExtra("kstyle_bind_wording", paramq.QE());
    }
    startActivity(localIntent);
    finish();
  }
  
  private void goBack()
  {
    Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
    localIntent.addFlags(67108864);
    if (bk.bl(this.fmE)) {
      localIntent.putExtra("can_finish", true);
    }
    startActivity(localIntent);
    finish();
    b.gK(this);
  }
  
  private boolean h(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        break label698;
      }
      if (this.fex != null) {
        this.fex.dismiss();
      }
      return true;
    case -3: 
      if (this.fnb <= 0)
      {
        com.tencent.mm.ui.base.h.h(this, q.j.errcode_password, q.j.login_err_title);
        this.fnb += 1;
      }
      for (;;)
      {
        return true;
        com.tencent.mm.ui.base.h.a(this, getString(q.j.errcode_password_ask_if_forgot_pwd), getString(q.j.login_err_title), getString(q.j.errcode_password_go_forgot_pwd), getString(q.j.app_cancel), new LoginHistoryUI.11(this), new LoginHistoryUI.12(this));
      }
    case -1: 
      if (com.tencent.mm.kernel.g.Dk().KG() == 5)
      {
        com.tencent.mm.ui.base.h.h(this, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
        return true;
      }
    case -9: 
      com.tencent.mm.ui.base.h.h(this, q.j.login_err_mailnotverify, q.j.login_err_title);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.h(this, q.j.regbyqq_auth_err_failed_niceqq, q.j.app_tip);
      return true;
    case -75: 
      z.bT(this);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.a(this, getString(q.j.bind_mcontact_verify_error), "", new LoginHistoryUI.13(this));
      return true;
    case -33: 
      com.tencent.mm.ui.base.h.a(this, q.j.bind_mcontact_verify_err_time_out_content, q.j.bind_mcontact_verify_tip, new LoginHistoryUI.14(this));
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.Dk().a(701, this);
      if (this.fex == null) {
        this.fex = SecurityImage.a.a(this, q.j.regbyqq_secimg_title, this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB, new LoginHistoryUI.15(this, paramInt1), null, new LoginHistoryUI.16(this), this.fmA);
      }
      for (;;)
      {
        return true;
        y.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.fmA.feA + " img len" + this.fmA.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
        this.fex.a(this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      com.tencent.mm.kernel.g.DN();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {}
      for (paramString = com.tencent.mm.cb.a.ac(this, q.j.main_err_another_place);; paramString = com.tencent.mm.kernel.a.CM())
      {
        com.tencent.mm.ui.base.h.a(this, paramString, getString(q.j.app_tip), new LoginHistoryUI.17(this), new LoginHistoryUI.18(this));
        return true;
        com.tencent.mm.kernel.g.DN();
      }
    case -205: 
      y.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bk.aac(this.fky), this.fmD });
      f.a(this.fmA);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.fky);
      paramString.putExtra("binded_mobile", this.fmC);
      paramString.putExtra("close_safe_device_style", this.fmD);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.a.a.eUR.e(this, paramString);
      return true;
    }
    if (!bk.bl(this.caS)) {
      z.l(this, paramString, this.caS);
    }
    return true;
    label698:
    paramString = new ag(paramInt1, paramInt2, paramString);
    return this.fmK.a(this, paramString);
  }
  
  private void qb(String paramString)
  {
    this.fmR = paramString;
    XJ();
  }
  
  protected void XJ()
  {
    this.fmA.account = this.fmI.trim();
  }
  
  protected final void XK()
  {
    com.tencent.mm.kernel.g.Dk().a(701, this);
  }
  
  protected final void XL()
  {
    com.tencent.mm.kernel.g.Dk().b(701, this);
  }
  
  public final void XM()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getCurrentFocus();
      } while (localObject == null);
      localObject = ((View)localObject).getWindowToken();
    } while (localObject == null);
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
  }
  
  public boolean XN()
  {
    return true;
  }
  
  protected final int getLayoutId()
  {
    return q.g.login_history;
  }
  
  protected final void initView()
  {
    this.fmL = ((LinearLayout)findViewById(q.f.voice_print_ll));
    this.fmN = ((LinearLayout)findViewById(q.f.face_print_ll));
    this.fmM = ((LinearLayout)findViewById(q.f.finger_print_ll));
    this.fmO = ((MMFormInputView)findViewById(q.f.login_password_input));
    this.fmP = ((MMFormVerifyCodeInputView)findViewById(q.f.sms_verify_container));
    this.fmE = getIntent().getStringExtra("switch_login_wx_id");
    if (!bk.bl(this.fmE))
    {
      this.fmI = bv.dXJ.getString(this.fmE, "login_user_name");
      this.fmJ = bv.dXJ.getString(this.fmE, "last_avatar_path");
      this.fmV = bk.ZR(bv.dXJ.getString(this.fmE, "last_bind_info"));
      if ((this.fmV & 0x1) != 0) {
        this.fmB = bv.dXJ.getString(this.fmE, "last_login_bind_qq");
      }
      if ((this.fmV & 0x4) != 0) {
        this.fmC = bv.dXJ.getString(this.fmE, "last_login_bind_mobile");
      }
      this.fmU = bk.ZR(bv.dXJ.getString(this.fmE, "last_login_use_voice"));
      setBackBtn(new LoginHistoryUI.25(this), q.i.actionbar_icon_close_black);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!bk.bl((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.fmI))) {
        this.fmI = ((String)localObject);
      }
      this.fmF = ((ImageView)findViewById(q.f.last_avatar));
      if (!bk.bl(this.fmJ)) {}
      try
      {
        localObject = com.tencent.mm.ag.d.kj(this.fmJ);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.fmF.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
        }
        this.fmG = ((MMKeyboardUperView)findViewById(q.f.scrollView));
        this.fmp = ((TextView)findViewById(q.f.login_account_auto));
        this.fmq = this.fmO.getContentEditText();
        this.fmr = ((Button)findViewById(q.f.login_btn));
        this.fmt = findViewById(q.f.login_voice_btn);
        this.fmu = findViewById(q.f.login_face_btn);
        this.fmv = ((Button)findViewById(q.f.shua_fingerprint_btn));
        this.fms = ((Button)findViewById(q.f.login_change_btn));
        this.fmQ = ((Button)findViewById(q.f.login_as_other_device_btn));
        this.fmw = ((Button)findViewById(q.f.login_find_password_btn));
        this.fmx = ((Button)findViewById(q.f.login_freeze_account_btn));
        this.fmy = findViewById(q.f.free_btn_container);
        this.fmz = ((Button)findViewById(q.f.login_more_btn));
        this.fmw.setOnClickListener(new LoginHistoryUI.26(this));
        this.fmx.setOnClickListener(new LoginHistoryUI.27(this));
        if (x.cqG()) {
          break label721;
        }
        this.fmy.setVisibility(8);
        this.fmO.setVisibility(8);
        this.fmL.setVisibility(8);
        this.fmN.setVisibility(8);
        this.fmM.setVisibility(8);
        this.fmr.setVisibility(8);
        this.fmt.setVisibility(8);
        this.fmu.setVisibility(8);
        this.fmv.setVisibility(8);
        this.fms.setVisibility(8);
        com.tencent.mm.ui.tools.a.c.d(this.fmq).fJ(4, 16).a(null);
        this.fmH = ((ResizeLayout)findViewById(q.f.resize_lv));
        if (!bk.aaa(this.fmI).booleanValue()) {
          break label1060;
        }
      }
      com.tencent.mm.kernel.g.DN();
      if ((!com.tencent.mm.kernel.a.Db()) || (this.fmI.equals(""))) {
        break;
      }
      this.fmS = true;
      b(null);
      return;
      this.fmI = at.dVC.L("login_user_name", "");
      this.fmJ = at.dVC.Ho();
      this.fmV = bk.ZR(at.dVC.L("last_bind_info", ""));
      if ((this.fmV & 0x1) != 0) {
        this.fmB = at.dVC.L("last_login_bind_qq", "");
      }
      if ((this.fmV & 0x4) != 0) {
        this.fmC = at.dVC.L("last_login_bind_mobile", "");
      }
      this.fmU = bk.ZR(at.dVC.L("last_login_use_voice", ""));
    }
    label721:
    if (!this.fmI.equals(this.fmB))
    {
      this.fmY[2] = 1;
      this.fmp.setText(qa(this.fmI));
      label882:
      this.fmH.setOnSizeChanged(new LoginHistoryUI.28(this));
      this.fmG.setOnTouchListener(new LoginHistoryUI.29(this));
      com.tencent.mm.ui.widget.a.d locald = new com.tencent.mm.ui.widget.a.d(this, 1, false);
      locald.phH = new LoginHistoryUI.30(this);
      locald.phI = new LoginHistoryUI.2(this);
      locald.wmU = new LoginHistoryUI.3(this, locald);
      if (!bk.bl(this.fmE)) {
        break label1081;
      }
      this.fmz.setOnClickListener(new LoginHistoryUI.4(this, locald));
    }
    for (;;)
    {
      setMMTitle("");
      ta(getResources().getColor(q.c.normal_actionbar_color));
      czo();
      mT(false);
      if (com.tencent.mm.sdk.platformtools.e.uem) {
        com.tencent.mm.plugin.account.a.a.eUS.n(this);
      }
      if (!com.tencent.mm.sdk.platformtools.d.EX_DEVICE_LOGIN) {
        break;
      }
      this.fmQ.setVisibility(0);
      this.fmQ.setOnClickListener(new LoginHistoryUI.7(this));
      return;
      label1060:
      this.fmY[2] = 2;
      this.fmp.setText(this.fmI);
      break label882;
      label1081:
      if (!x.cqG())
      {
        this.fmz.setText(q.j.wechat_help_center);
        this.fmz.setOnClickListener(new LoginHistoryUI.5(this));
      }
      else
      {
        this.fmz.setText(q.j.wechat_safe_center);
        this.fmz.setOnClickListener(new LoginHistoryUI.6(this));
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      y.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label164;
      }
      if (paramInt2 == -1)
      {
        str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
        paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
        bool = bk.bl(str);
        if (!bk.bl(str)) {
          break label155;
        }
        paramInt1 = i;
        label107:
        y.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        qb(str);
      }
    }
    label155:
    label164:
    label246:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
          paramInt1 = str.length();
          break label107;
          if ((paramInt1 != 1025) || (paramIntent == null)) {
            break label246;
          }
        } while (paramInt2 != 2);
        paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
        bool = bk.bl(paramIntent);
        if (bk.bl(paramIntent)) {}
        for (paramInt1 = j;; paramInt1 = paramIntent.length())
        {
          y.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          qb(paramIntent);
          return;
        }
      } while ((paramInt1 != 31685) || (paramIntent == null) || (paramInt2 != -1));
      paramIntent = paramIntent.getBundleExtra("result_data");
    } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("auth_again")));
    XJ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.a.a.eUS });
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.dnD = ae.getContext().getSharedPreferences(ae.cqR(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.fmW = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      if (this.fmW) {
        this.fmX = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.fmK = new com.tencent.mm.platformtools.c();
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.g.Dk().b(701, this);
    if (this.fmK != null) {
      this.fmK.close();
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(14262, new Object[] { Integer.valueOf(this.fmY[0]), Integer.valueOf(this.fmY[1]), Integer.valueOf(this.fmY[2]), Integer.valueOf(this.fmY[3]), Integer.valueOf(this.fmY[4]) });
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      goBack();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.flH);
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((XN()) && (this.fhr != 1) && ((this.fmU & 0x20000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7001, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(q.j.login_login_by_voice_print);
      ((List)localObject1).add(localObject2);
    }
    if ((this.fhr != 5) && ((this.fmU & 0x40000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7005, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(q.j.login_login_by_finger_print);
      ((List)localObject1).add(localObject2);
    }
    if (!bk.bl(this.fmI))
    {
      if (this.fhr != 2)
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7007, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(q.j.login_login_by_password));
        ((List)localObject1).add(localObject2);
      }
      if ((!bk.bl(this.fmC)) && (this.fhr != 3))
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7008, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(q.j.login_login_by_sms));
        ((List)localObject1).add(localObject2);
      }
      if (this.fmI.equalsIgnoreCase(this.fmB)) {
        this.fmq.setHint(getString(q.j.regbyqq_password_hint));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.d(this, 1, false);
      ((com.tencent.mm.ui.widget.a.d)localObject2).phH = new LoginHistoryUI.19(this, (List)localObject1);
      ((com.tencent.mm.ui.widget.a.d)localObject2).phI = new LoginHistoryUI.20(this);
      ((com.tencent.mm.ui.widget.a.d)localObject2).wmU = new LoginHistoryUI.21(this, (com.tencent.mm.ui.widget.a.d)localObject2);
      this.fms.setVisibility(0);
      this.fms.setText(q.j.login_by_other_method);
      this.fms.setOnClickListener(new LoginHistoryUI.23(this, (com.tencent.mm.ui.widget.a.d)localObject2));
      com.tencent.mm.sdk.b.a.udP.c(this.flH);
      com.tencent.mm.kernel.g.DN();
      com.tencent.mm.kernel.a.Dg();
      if ((!com.tencent.mm.kernel.g.DK()) || (this.fmI.equals(""))) {
        break label466;
      }
      if ((this.dnm == null) || (!this.dnm.isShowing())) {
        break label460;
      }
    }
    label460:
    label466:
    while (com.tencent.mm.q.a.Bu() != 2)
    {
      return;
      if (((List)localObject1).size() > 0)
      {
        this.fms.setVisibility(0);
        this.fms.setText(((com.tencent.mm.ui.base.m)((List)localObject1).get(0)).getTitle());
        this.fms.setOnClickListener(new LoginHistoryUI.24(this, (List)localObject1));
        break;
      }
      this.fms.setVisibility(8);
      break;
      b(null);
      return;
    }
    localObject1 = new c.a(this);
    ((c.a)localObject1).Ip(q.j.check_db_size_tip_dangerous_title);
    ((c.a)localObject1).aeA(getString(q.j.check_db_size_tip_dangerous_message));
    ((c.a)localObject1).nW(false);
    ((c.a)localObject1).Is(q.j.check_db_size_btn_dangerous_message).a(new LoginHistoryUI.22(this));
    ((c.a)localObject1).aoP().show();
    com.tencent.mm.q.a.b(this, System.currentTimeMillis());
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    y.d("MicroMsg.LoginHistoryUI", "Scene Type " + paramm.getType());
    if (paramm.getType() == 145)
    {
      if ((this.dnm != null) && (this.dnm.isShowing()))
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramm).rN();
      if (i == 16) {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.h(this, q.j.regbymobile_reg_mobile_format_err_msg, q.j.regbymobile_reg_mobile_format_err_title);
          this.fmP.reset();
          return;
          break label276;
        }
      }
      label151:
      while (paramInt2 == -75)
      {
        com.tencent.mm.ui.base.h.b(this, getString(q.j.alpha_version_tip_login), "", true);
        this.fmP.reset();
        return;
        if (i == 17)
        {
          this.fmZ = paramInt2;
          this.fna = paramString;
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            new g(new LoginHistoryUI.8(this), ((com.tencent.mm.modelfriend.a)paramm).getUsername(), ((com.tencent.mm.modelfriend.a)paramm).NI(), this.fmC).a(this);
            return;
          }
          if (!h(paramInt1, paramInt2, paramString))
          {
            paramm = com.tencent.mm.i.a.eI(paramString);
            if (paramm != null) {
              paramm.a(this, null, null);
            }
          }
        }
      }
      label276:
      if (!h(paramInt1, paramInt2, paramString)) {}
    }
    else
    {
      if (paramm.getType() != 701) {
        break label777;
      }
      this.caS = ((q)paramm).Qy();
      y.e("MicroMsg.LoginHistoryUI", "url " + this.caS);
      com.tencent.mm.kernel.g.Dk().b(701, this);
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
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label884;
      }
      com.tencent.mm.kernel.g.Dk().a(new bi(new LoginHistoryUI.9(this)), 0);
    }
    label777:
    label884:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        w.bL(this);
        z.pi(this.fmA.account);
        if ((this.dnm != null) && (this.dnm.isShowing())) {
          this.dnm.setMessage(getString(q.j.app_loading));
        }
        b((q)paramm);
        if (this.fhr != 3) {
          break label151;
        }
        this.fmT = ((q)paramm).QH();
        com.tencent.mm.kernel.g.Dk().a(255, this);
        paramString = new r(1);
        com.tencent.mm.kernel.g.Dk().a(paramString, 0);
        getString(q.j.app_tip);
        this.dnm = com.tencent.mm.ui.base.h.b(this, getString(q.j.app_loading), true, new LoginHistoryUI.10(this, paramString));
        return;
      }
      if ((this.dnm != null) && (this.dnm.isShowing()))
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
      if (paramInt2 == -106)
      {
        z.e(this, paramString, 31685);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(this, com.tencent.mm.platformtools.e.a((q)paramm), paramInt2);
        return;
      }
      if (h(paramInt1, paramInt2, paramString)) {
        break label151;
      }
      paramm = com.tencent.mm.i.a.eI(paramString);
      if ((paramm != null) && (paramm.a(this, null, null))) {
        break label151;
      }
      Toast.makeText(this, getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break label276;
      break label151;
      if (paramm.getType() != 255) {
        break;
      }
      if ((this.dnm != null) && (this.dnm.isShowing()))
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
      com.tencent.mm.kernel.g.Dk().b(255, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label151;
      }
      boolean bool = this.fmT;
      paramString = new Intent(this, RegByMobileSetPwdUI.class);
      paramString.putExtra("kintent_hint", getString(q.j.settings_modify_password_tip));
      paramString.putExtra("kintent_cancelable", bool);
      startActivity(paramString);
      return;
    }
  }
  
  protected final String qa(String paramString)
  {
    new ar();
    String str1 = "86";
    Object localObject = paramString;
    if (this.fmI.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = ar.Ga(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    return ar.formatNumber(str1, (String)localObject);
  }
  
  public void setRequestedOrientation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */