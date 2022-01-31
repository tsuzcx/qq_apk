package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;

public class LoginUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private TextWatcher ami;
  private String cJr;
  private String crs;
  private ProgressDialog eeN;
  private String gBP;
  private com.tencent.mm.sdk.b.c gCZ;
  protected Button gDQ;
  protected Button gDR;
  private View gDS;
  protected Button gDT;
  private f gDU;
  private String gDW;
  private String gDX;
  private MMClearEditText gES;
  private MMClearEditText gET;
  private MMFormInputView gEU;
  private MMFormInputView gEV;
  private Button gEW;
  private Button gEX;
  protected View gEY;
  private String gEZ;
  private ResizeLayout gEb;
  private com.tencent.mm.platformtools.c gEe;
  private Button gEk;
  private boolean gFa;
  private MMKeyboardUperView gFb;
  private boolean gFc;
  final boolean[] gFd;
  private final int gFe;
  private String guI;
  private SecurityImage gwg;
  private int sceneType;
  
  public LoginUI()
  {
    AppMethodBeat.i(125052);
    this.eeN = null;
    this.crs = null;
    this.gwg = null;
    this.gDU = new f();
    this.cJr = "";
    this.sceneType = 0;
    this.ami = new LoginUI.1(this);
    this.gFc = false;
    this.gCZ = new LoginUI.12(this);
    this.gFd = new boolean[] { true };
    this.gFe = 128;
    AppMethodBeat.o(125052);
  }
  
  private static void R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125058);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    com.tencent.mm.bq.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(125058);
  }
  
  private void arq()
  {
    AppMethodBeat.i(125063);
    this.gDU.account = this.gES.getText().toString().trim();
    this.gDU.gwh = this.gET.getText().toString();
    if (this.gDU.account.equals(""))
    {
      com.tencent.mm.ui.base.h.h(this, 2131304504, 2131301135);
      AppMethodBeat.o(125063);
      return;
    }
    if (this.gDU.gwh.equals(""))
    {
      com.tencent.mm.ui.base.h.h(this, 2131304500, 2131301135);
      AppMethodBeat.o(125063);
      return;
    }
    hideVKB();
    com.tencent.mm.kernel.g.Rc().a(252, this);
    com.tencent.mm.kernel.g.Rc().a(701, this);
    s locals = new s(this.gDU.account, this.gDU.gwh, this.gBP, 2);
    com.tencent.mm.kernel.g.Rc().a(locals, 0);
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131301149), true, new LoginUI.20(this, locals));
    AppMethodBeat.o(125063);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(125060);
    hideVKB();
    com.tencent.mm.plugin.b.a.xD(this.guI);
    com.tencent.mm.pluginsdk.model.app.p.dlF();
    finish();
    AppMethodBeat.o(125060);
  }
  
  private boolean l(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(125061);
    if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(125061);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new ag(paramInt1, paramInt2, paramString);
      boolean bool = this.gEe.a(this, paramString);
      AppMethodBeat.o(125061);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.g.Rc().adt() == 5)
      {
        com.tencent.mm.ui.base.h.h(this, 2131301790, 2131301789);
        AppMethodBeat.o(125061);
        return true;
      }
      AppMethodBeat.o(125061);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.h(this, 2131299331, 2131301135);
      AppMethodBeat.o(125061);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.h(this, 2131301134, 2131301135);
      AppMethodBeat.o(125061);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.h(getContext(), 2131302471, 2131297087);
      AppMethodBeat.o(125061);
      return true;
    case -75: 
      z.cA(getContext());
      AppMethodBeat.o(125061);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.Rc().a(701, this);
      com.tencent.mm.kernel.g.Rc().a(252, this);
      if (this.gwg == null) {
        this.gwg = SecurityImage.a.a(this, this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk, new LoginUI.14(this), null, new LoginUI.15(this), this.gDU);
      }
      for (;;)
      {
        AppMethodBeat.o(125061);
        return true;
        ab.d("MicroMsg.LoginUI", "imgSid:" + this.gDU.gwj + " img len" + this.gDU.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
        this.gwg.b(this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.RJ();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
      for (paramString = com.tencent.mm.cb.a.aq(getContext(), 2131301416);; paramString = com.tencent.mm.kernel.a.QD())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramString, getContext().getString(2131297087), new LoginUI.16(this), new LoginUI.17(this));
        AppMethodBeat.o(125061);
        return true;
        com.tencent.mm.kernel.g.RJ();
      }
    case -205: 
      ab.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bo.aqg(this.gBP), this.gDX });
      f.a(this.gDU);
      com.tencent.mm.plugin.b.a.xD("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.gBP);
      paramString.putExtra("binded_mobile", this.gDW);
      paramString.putExtra("close_safe_device_style", this.gDX);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.a.a.gmO.g(this, paramString);
      AppMethodBeat.o(125061);
      return true;
    }
    if (!bo.isNullOrNil(this.cJr)) {
      z.o(this, paramString, this.cJr);
    }
    AppMethodBeat.o(125061);
    return true;
  }
  
  public void finish()
  {
    AppMethodBeat.i(125064);
    super.finish();
    overridePendingTransition(2131034130, 2131034130);
    AppMethodBeat.o(125064);
  }
  
  public int getLayoutId()
  {
    return 2130969997;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125057);
    this.gEU = ((MMFormInputView)findViewById(2131825452));
    this.gEV = ((MMFormInputView)findViewById(2131825453));
    this.gES = ((MMClearEditText)this.gEU.getContentEditText());
    this.gET = ((MMClearEditText)this.gEV.getContentEditText());
    com.tencent.mm.ui.tools.b.c.d(this.gET).QS(16).a(null);
    this.gES.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(152567);
        if (LoginUI.this.gFd[0] != 0)
        {
          LoginUI.this.gFd[0] = false;
          b.pgQ.VV("ie_login_id");
        }
        b.pgQ.VW("ie_login_id");
        AppMethodBeat.o(152567);
      }
    });
    this.gEW = ((Button)findViewById(2131825455));
    this.gEW.setEnabled(false);
    this.gEX = ((Button)findViewById(2131825454));
    this.gEk = ((Button)findViewById(2131825456));
    this.gEY = findViewById(2131825457);
    this.gEY.setVisibility(0);
    this.gDQ = ((Button)findViewById(2131825458));
    this.gDS = findViewById(2131825459);
    this.gDR = ((Button)findViewById(2131825460));
    this.gDT = ((Button)findViewById(2131825461));
    this.gEb = ((ResizeLayout)findViewById(2131825451));
    this.gFb = ((MMKeyboardUperView)findViewById(2131820935));
    this.gEb.setOnSizeChanged(new LoginUI.22(this));
    this.gDQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(125048);
        paramAnonymousView = LoginUI.this.getString(2131306187) + aa.dsG();
        LoginUI.S(LoginUI.this, paramAnonymousView);
        AppMethodBeat.o(125048);
      }
    });
    this.gDR.setOnClickListener(new LoginUI.24(this));
    Object localObject = new com.tencent.mm.ui.widget.b.d(this, 1, false);
    ((com.tencent.mm.ui.widget.b.d)localObject).sao = new LoginUI.25(this);
    ((com.tencent.mm.ui.widget.b.d)localObject).AGQ = new LoginUI.26(this);
    ((com.tencent.mm.ui.widget.b.d)localObject).sap = new LoginUI.27(this);
    if (aa.dsD()) {
      this.gDT.setOnClickListener(new LoginUI.2(this));
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new LoginUI.4(this), 2131230735);
      localObject = new boolean[1];
      localObject[0] = 0;
      this.gEW.setOnClickListener(new LoginUI.5(this, (boolean[])localObject));
      this.gEW.setOnTouchListener(new LoginUI.6(this, (boolean[])localObject));
      this.gEX.setOnClickListener(new LoginUI.7(this));
      this.gBP = getIntent().getStringExtra("auth_ticket");
      if (!bo.isNullOrNil(this.gBP))
      {
        this.gES.setText(bo.nullAsNil(f.arv()));
        this.gET.setText(bo.nullAsNil(f.arw()));
        new ak().postDelayed(new LoginUI.8(this), 500L);
      }
      this.gES.addTextChangedListener(this.ami);
      this.gET.addTextChangedListener(this.ami);
      this.gET.setOnEditorActionListener(new LoginUI.9(this));
      this.gET.setOnKeyListener(new LoginUI.10(this));
      if (com.tencent.mm.sdk.platformtools.g.ymN) {
        com.tencent.mm.plugin.account.a.a.gmP.o(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.gFc = getIntent().getBooleanExtra("from_deep_link", false);
      if (!bo.isNullOrNil((String)localObject)) {
        this.gES.setText((CharSequence)localObject);
      }
      if (com.tencent.mm.sdk.platformtools.f.EX_DEVICE_LOGIN)
      {
        this.gEk.setVisibility(0);
        this.gEk.setOnClickListener(new LoginUI.11(this));
      }
      AppMethodBeat.o(125057);
      return;
      this.gDS.setVisibility(8);
      this.gDT.setText(2131301124);
      this.gDT.setOnClickListener(new LoginUI.3(this, (com.tencent.mm.ui.widget.b.d)localObject));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(125065);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      ab.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label239;
      }
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label194;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bo.isNullOrNil(str);
      if (!bo.isNullOrNil(str)) {
        break label178;
      }
    }
    label178:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ab.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label187;
      }
      this.gDU.gwh = str;
      arq();
      AppMethodBeat.o(125065);
      return;
      bool = false;
      break;
    }
    label187:
    AppMethodBeat.o(125065);
    return;
    label194:
    if ((paramInt1 == 32644) && (paramIntent != null))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        arq();
      }
    }
    label239:
    AppMethodBeat.o(125065);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125053);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(2131690317));
    paramBundle = "";
    if (com.tencent.mm.protocal.d.whK) {
      paramBundle = getString(2131297005) + getString(2131296529);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(2131690316));
    hideActionbarLine();
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    this.gEe = new com.tencent.mm.platformtools.c();
    this.gFa = getIntent().getBooleanExtra("from_switch_account", false);
    this.gEZ = av.flM.Y("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.h.qsU.e(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    AppMethodBeat.o(125053);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125056);
    if (this.gEe != null) {
      this.gEe.close();
    }
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    b.pgQ.VX("ie_login_id");
    super.onDestroy();
    AppMethodBeat.o(125056);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125059);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(125059);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125059);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125055);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L100_100_logout") + ",2");
      AppMethodBeat.o(125055);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L400_100_login") + ",2");
    }
    AppMethodBeat.o(125055);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125054);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.xC("L100_100_logout");
      AppMethodBeat.o(125054);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.xC("L400_100_login");
    }
    AppMethodBeat.o(125054);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125062);
    ab.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramm.getType() != 252) && (paramm.getType() != 701))
    {
      AppMethodBeat.o(125062);
      return;
    }
    com.tencent.mm.kernel.g.Rc().b(252, this);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    this.cJr = ((s)paramm).ajF();
    this.gDU.gwj = ((s)paramm).ajG();
    this.gDU.gwi = ((s)paramm).ajH();
    this.gDU.gwk = ((s)paramm).ajI();
    this.gDU.gEL = ((s)paramm).getSecCodeType();
    this.gDU.account = ((s)paramm).account;
    if (paramInt2 == -205)
    {
      this.gBP = ((s)paramm).agy();
      this.gDW = ((s)paramm).ajK();
      this.gDX = ((s)paramm).ajN();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.Rc().a(new bk(new LoginUI.18(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        l.aqv();
        z.wz(this.gDU.account);
        paramString = av.flM.Y("login_weixin_username", "");
        w.cs(this);
        if (this.gFa)
        {
          bx.fnO.ar(this.gEZ, paramString);
          bx.fnO.g(r.Zn(), r.ZV());
          com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), bx.fnO.abg() });
        }
        z.showAddrBookUploadConfirm(this, new LoginUI.19(this, paramm), false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.RJ();
        paramString = paramString.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_900_phone") + ",4");
        if (this.gFc)
        {
          paramString = ah.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.h.Mp()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.qsU.e(11930, new Object[] { paramString, Integer.valueOf(4) });
        }
        AppMethodBeat.o(125062);
        return;
      }
      if (paramInt2 == -106)
      {
        z.f(this, paramString, 32644);
        AppMethodBeat.o(125062);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(this, e.a((s)paramm), paramInt2);
        AppMethodBeat.o(125062);
        return;
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125062);
        return;
      }
      if (paramInt2 == -5)
      {
        Toast.makeText(this, getString(2131301158), 0).show();
        AppMethodBeat.o(125062);
        return;
      }
      paramString = com.tencent.mm.h.a.kO(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(125062);
        return;
      }
      Toast.makeText(this, getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(125062);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */