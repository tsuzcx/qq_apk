package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bx;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private String cJr;
  protected ProgressDialog eeN;
  protected String gBP;
  private com.tencent.mm.sdk.b.c gCZ;
  protected TextView gDJ;
  protected EditText gDK;
  protected Button gDL;
  protected Button gDM;
  protected View gDN;
  protected View gDO;
  protected View gDP;
  protected Button gDQ;
  protected Button gDR;
  private View gDS;
  protected Button gDT;
  protected f gDU;
  protected String gDV;
  protected String gDW;
  private String gDX;
  private String gDY;
  private ImageView gDZ;
  private MMKeyboardUperView gEa;
  private ResizeLayout gEb;
  protected String gEc;
  private String gEd;
  private com.tencent.mm.platformtools.c gEe;
  protected LinearLayout gEf;
  protected LinearLayout gEg;
  protected LinearLayout gEh;
  protected MMFormInputView gEi;
  protected MMFormVerifyCodeInputView gEj;
  private Button gEk;
  protected String gEl;
  protected boolean gEm;
  protected boolean gEn;
  private int gEo;
  private int gEp;
  private boolean gEq;
  private String gEr;
  protected int[] gEs;
  private int gEt;
  private String gEu;
  private int gEv;
  private SecurityImage gwg;
  protected int gyZ;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(124940);
    this.eeN = null;
    this.gwg = null;
    this.gDU = new f();
    this.cJr = "";
    this.gEl = "";
    this.gEm = false;
    this.gEq = false;
    this.gEs = new int[5];
    this.gCZ = new LoginHistoryUI.1(this);
    this.gEv = 0;
    AppMethodBeat.o(124940);
  }
  
  public static void R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124959);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    com.tencent.mm.bq.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(124959);
  }
  
  private void b(s params)
  {
    AppMethodBeat.i(124957);
    ab.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
    localIntent.addFlags(67108864);
    if (params != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", params.ajL());
      localIntent.putExtra("kstyle_bind_recommend_show", params.ajO());
      localIntent.putExtra("kstyle_bind_wording", params.ajM());
    }
    startActivity(localIntent);
    finish();
    AppMethodBeat.o(124957);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(124945);
    Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
    localIntent.addFlags(67108864);
    if (bo.isNullOrNil(this.gDY)) {
      localIntent.putExtra("can_finish", true);
    }
    startActivity(localIntent);
    finish();
    b.ig(this);
    AppMethodBeat.o(124945);
  }
  
  private boolean l(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(124958);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
        break label785;
      }
      if (this.gwg != null) {
        this.gwg.dismiss();
      }
      AppMethodBeat.o(124958);
      return true;
    case -3: 
      if (this.gEv <= 0)
      {
        com.tencent.mm.ui.base.h.h(this, 2131299331, 2131301135);
        this.gEv += 1;
      }
      for (;;)
      {
        AppMethodBeat.o(124958);
        return true;
        com.tencent.mm.ui.base.h.d(this, getString(2131299332), getString(2131301135), getString(2131299333), getString(2131296888), new LoginHistoryUI.10(this), new LoginHistoryUI.11(this));
      }
    case -1: 
      if (com.tencent.mm.kernel.g.Rc().adt() == 5)
      {
        com.tencent.mm.ui.base.h.h(this, 2131301790, 2131301789);
        AppMethodBeat.o(124958);
        return true;
      }
    case -9: 
      com.tencent.mm.ui.base.h.h(this, 2131301134, 2131301135);
      AppMethodBeat.o(124958);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.h(this, 2131302471, 2131297087);
      AppMethodBeat.o(124958);
      return true;
    case -75: 
      z.cA(this);
      AppMethodBeat.o(124958);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.a(this, getString(2131297617), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(124923);
          AppMethodBeat.o(124923);
        }
      });
      AppMethodBeat.o(124958);
      return true;
    case -33: 
      com.tencent.mm.ui.base.h.a(this, 2131297615, 2131297621, new LoginHistoryUI.13(this));
      AppMethodBeat.o(124958);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.Rc().a(701, this);
      com.tencent.mm.kernel.g.Rc().a(252, this);
      if (this.gwg == null) {
        this.gwg = SecurityImage.a.a(this, this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk, new LoginHistoryUI.14(this, paramInt1), null, new LoginHistoryUI.15(this), this.gDU);
      }
      for (;;)
      {
        AppMethodBeat.o(124958);
        return true;
        ab.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.gDU.gwj + " img len" + this.gDU.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
        this.gwg.b(this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      com.tencent.mm.kernel.g.RJ();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
      for (paramString = com.tencent.mm.cb.a.aq(this, 2131301416);; paramString = com.tencent.mm.kernel.a.QD())
      {
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131297087), new LoginHistoryUI.16(this), new LoginHistoryUI.17(this));
        AppMethodBeat.o(124958);
        return true;
        com.tencent.mm.kernel.g.RJ();
      }
    case -205: 
      ab.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bo.aqg(this.gBP), this.gDX });
      f.a(this.gDU);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.gBP);
      paramString.putExtra("binded_mobile", this.gDW);
      paramString.putExtra("close_safe_device_style", this.gDX);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.a.a.gmO.g(this, paramString);
      AppMethodBeat.o(124958);
      return true;
    }
    if (!bo.isNullOrNil(this.cJr)) {
      z.o(this, paramString, this.cJr);
    }
    AppMethodBeat.o(124958);
    return true;
    label785:
    paramString = new ag(paramInt1, paramInt2, paramString);
    boolean bool = this.gEe.a(this, paramString);
    AppMethodBeat.o(124958);
    return bool;
  }
  
  private void xx(String paramString)
  {
    AppMethodBeat.i(124955);
    this.gEl = paramString;
    arq();
    AppMethodBeat.o(124955);
  }
  
  protected void arq()
  {
    AppMethodBeat.i(124952);
    this.gDU.account = this.gEc.trim();
    AppMethodBeat.o(124952);
  }
  
  protected final void arr()
  {
    AppMethodBeat.i(124950);
    com.tencent.mm.kernel.g.Rc().a(701, this);
    com.tencent.mm.kernel.g.Rc().a(252, this);
    AppMethodBeat.o(124950);
  }
  
  protected final void ars()
  {
    AppMethodBeat.i(124951);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    AppMethodBeat.o(124951);
  }
  
  public boolean art()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130969998;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(124953);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(124953);
      return;
    }
    Object localObject = getCurrentFocus();
    if (localObject == null)
    {
      AppMethodBeat.o(124953);
      return;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      AppMethodBeat.o(124953);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
    AppMethodBeat.o(124953);
  }
  
  public void initView()
  {
    AppMethodBeat.i(124948);
    this.gEf = ((LinearLayout)findViewById(2131825465));
    this.gEh = ((LinearLayout)findViewById(2131825470));
    this.gEg = ((LinearLayout)findViewById(2131825474));
    this.gEi = ((MMFormInputView)findViewById(2131825463));
    this.gEj = ((MMFormVerifyCodeInputView)findViewById(2131825464));
    this.gDY = getIntent().getStringExtra("switch_login_wx_id");
    if (!bo.isNullOrNil(this.gDY))
    {
      this.gEc = bx.fnO.getString(this.gDY, "login_user_name");
      this.gEd = bx.fnO.getString(this.gDY, "last_avatar_path");
      this.gEp = bo.apV(bx.fnO.getString(this.gDY, "last_bind_info"));
      if ((this.gEp & 0x1) != 0) {
        this.gDV = bx.fnO.getString(this.gDY, "last_login_bind_qq");
      }
      if ((this.gEp & 0x4) != 0) {
        this.gDW = bx.fnO.getString(this.gDY, "last_login_bind_mobile");
      }
      this.gEo = bo.apV(bx.fnO.getString(this.gDY, "last_login_use_voice"));
      setBackBtn(new LoginHistoryUI.25(this), 2131230735);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.gEc))) {
        this.gEc = ((String)localObject);
      }
      this.gDZ = ((ImageView)findViewById(2131825462));
      if (!bo.isNullOrNil(this.gEd)) {}
      try
      {
        localObject = com.tencent.mm.ah.d.rd(this.gEd);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.gDZ.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
        }
        this.gEa = ((MMKeyboardUperView)findViewById(2131820935));
        this.gDJ = ((TextView)findViewById(2131825452));
        this.gDK = this.gEi.getContentEditText();
        this.gDL = ((Button)findViewById(2131825455));
        this.gDN = findViewById(2131825466);
        this.gDO = findViewById(2131825471);
        this.gDP = ((Button)findViewById(2131825476));
        this.gDM = ((Button)findViewById(2131825469));
        this.gEk = ((Button)findViewById(2131825456));
        this.gDQ = ((Button)findViewById(2131825458));
        this.gDR = ((Button)findViewById(2131825460));
        this.gDS = findViewById(2131825459);
        this.gDT = ((Button)findViewById(2131825461));
        this.gDQ.setOnClickListener(new LoginHistoryUI.26(this));
        this.gDR.setOnClickListener(new LoginHistoryUI.27(this));
        if (aa.dsD()) {
          break label733;
        }
        this.gDS.setVisibility(8);
        this.gEi.setVisibility(8);
        this.gEf.setVisibility(8);
        this.gEh.setVisibility(8);
        this.gEg.setVisibility(8);
        this.gDL.setVisibility(8);
        this.gDN.setVisibility(8);
        this.gDO.setVisibility(8);
        this.gDP.setVisibility(8);
        this.gDM.setVisibility(8);
        com.tencent.mm.ui.tools.b.c.d(this.gDK).hR(4, 16).a(null);
        this.gEb = ((ResizeLayout)findViewById(2131825451));
        if (!bo.aqe(this.gEc).booleanValue()) {
          break label1077;
        }
      }
      com.tencent.mm.kernel.g.RJ();
      if ((!com.tencent.mm.kernel.a.QT()) || (this.gEc.equals(""))) {
        break;
      }
      this.gEm = true;
      b(null);
      AppMethodBeat.o(124948);
      return;
      this.gEc = com.tencent.mm.model.av.flM.Y("login_user_name", "");
      this.gEd = com.tencent.mm.model.av.flM.aar();
      this.gEp = bo.apV(com.tencent.mm.model.av.flM.Y("last_bind_info", ""));
      if ((this.gEp & 0x1) != 0) {
        this.gDV = com.tencent.mm.model.av.flM.Y("last_login_bind_qq", "");
      }
      if ((this.gEp & 0x4) != 0) {
        this.gDW = com.tencent.mm.model.av.flM.Y("last_login_bind_mobile", "");
      }
      this.gEo = bo.apV(com.tencent.mm.model.av.flM.Y("last_login_use_voice", ""));
    }
    label733:
    if (!this.gEc.equals(this.gDV))
    {
      this.gEs[2] = 1;
      this.gDJ.setText(xw(this.gEc));
      this.gEb.setOnSizeChanged(new LoginHistoryUI.28(this));
      this.gEa.setOnTouchListener(new LoginHistoryUI.29(this));
      com.tencent.mm.ui.widget.b.d locald = new com.tencent.mm.ui.widget.b.d(this, 1, false);
      locald.sao = new LoginHistoryUI.30(this);
      locald.sap = new LoginHistoryUI.2(this);
      locald.AGQ = new LoginHistoryUI.3(this);
      if (!bo.isNullOrNil(this.gDY)) {
        break label1098;
      }
      this.gDT.setOnClickListener(new LoginHistoryUI.4(this, locald));
    }
    for (;;)
    {
      setMMTitle("");
      setActionbarColor(getResources().getColor(2131690316));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (com.tencent.mm.sdk.platformtools.g.ymN) {
        com.tencent.mm.plugin.account.a.a.gmP.o(this);
      }
      if (com.tencent.mm.sdk.platformtools.f.EX_DEVICE_LOGIN)
      {
        this.gEk.setVisibility(0);
        this.gEk.setOnClickListener(new LoginHistoryUI.7(this));
      }
      AppMethodBeat.o(124948);
      return;
      label1077:
      this.gEs[2] = 2;
      this.gDJ.setText(this.gEc);
      break;
      label1098:
      if (!aa.dsD())
      {
        this.gDT.setText(2131305943);
        this.gDT.setOnClickListener(new LoginHistoryUI.5(this));
      }
      else
      {
        this.gDT.setText(2131305945);
        this.gDT.setOnClickListener(new LoginHistoryUI.6(this));
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(124954);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      ab.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label176;
      }
      if (paramInt2 != -1) {
        break label314;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bo.isNullOrNil(str);
      if (!bo.isNullOrNil(str)) {
        break label167;
      }
    }
    label167:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ab.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      xx(str);
      AppMethodBeat.o(124954);
      return;
      bool = false;
      break;
    }
    label176:
    if ((paramInt1 == 1025) && (paramIntent != null))
    {
      if (paramInt2 == 2)
      {
        paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
        bool = bo.isNullOrNil(paramIntent);
        if (bo.isNullOrNil(paramIntent)) {}
        for (paramInt1 = j;; paramInt1 = paramIntent.length())
        {
          ab.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          xx(paramIntent);
          AppMethodBeat.o(124954);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        arq();
      }
    }
    label314:
    AppMethodBeat.o(124954);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124941);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.a.a.gmP });
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.sp = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.gEq = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.gEq = this.gEq;
      if (this.gEq) {
        this.gEr = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.gEe = new com.tencent.mm.platformtools.c();
    AppMethodBeat.o(124941);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(124942);
    ab.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    if (this.gEe != null) {
      this.gEe.close();
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(14262, new Object[] { Integer.valueOf(this.gEs[0]), Integer.valueOf(this.gEs[1]), Integer.valueOf(this.gEs[2]), Integer.valueOf(this.gEs[3]), Integer.valueOf(this.gEs[4]) });
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    super.onDestroy();
    AppMethodBeat.o(124942);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(124946);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      goBack();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(124946);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(124944);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    AppMethodBeat.o(124944);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(124943);
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((art()) && (this.gyZ != 1) && ((this.gEo & 0x20000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7001, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(2131301147);
      ((List)localObject1).add(localObject2);
    }
    if ((this.gyZ != 5) && ((this.gEo & 0x40000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7005, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(2131301144);
      ((List)localObject1).add(localObject2);
    }
    if (!bo.isNullOrNil(this.gEc))
    {
      if (this.gyZ != 2)
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7007, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(2131301145));
        ((List)localObject1).add(localObject2);
      }
      if ((!bo.isNullOrNil(this.gDW)) && (this.gyZ != 3))
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7008, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(2131301146));
        ((List)localObject1).add(localObject2);
      }
      if (this.gEc.equalsIgnoreCase(this.gDV)) {
        this.gDK.setHint(getString(2131302477));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.b.d(this, 1, false);
      ((com.tencent.mm.ui.widget.b.d)localObject2).sao = new LoginHistoryUI.18(this, (List)localObject1);
      ((com.tencent.mm.ui.widget.b.d)localObject2).sap = new LoginHistoryUI.19(this);
      ((com.tencent.mm.ui.widget.b.d)localObject2).AGQ = new LoginHistoryUI.20(this);
      this.gDM.setVisibility(0);
      this.gDM.setText(2131301128);
      this.gDM.setOnClickListener(new LoginHistoryUI.21(this, (com.tencent.mm.ui.widget.b.d)localObject2));
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.kernel.a.QY();
      if ((!com.tencent.mm.kernel.g.RG()) || (!com.tencent.mm.kernel.g.RJ().eHg) || (this.gEc.equals(""))) {
        break label492;
      }
      if ((this.eeN == null) || (!this.eeN.isShowing())) {
        break;
      }
      AppMethodBeat.o(124943);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.gDM.setVisibility(0);
        this.gDM.setText(((com.tencent.mm.ui.base.m)((List)localObject1).get(0)).getTitle());
        this.gDM.setOnClickListener(new LoginHistoryUI.23(this, (List)localObject1));
      }
      else
      {
        this.gDM.setVisibility(8);
      }
    }
    b(null);
    AppMethodBeat.o(124943);
    return;
    label492:
    if (com.tencent.mm.q.a.Oj() == 2)
    {
      localObject1 = new c.a(this);
      ((c.a)localObject1).Rb(2131298349);
      ((c.a)localObject1).avn(getString(2131298348));
      ((c.a)localObject1).rG(false);
      ((c.a)localObject1).Ri(2131298346).a(new LoginHistoryUI.22(this));
      ((c.a)localObject1).aLZ().show();
      com.tencent.mm.q.a.b(this, System.currentTimeMillis());
    }
    AppMethodBeat.o(124943);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(124956);
    ab.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ab.d("MicroMsg.LoginHistoryUI", "Scene Type " + paramm.getType());
    if (paramm.getType() == 145)
    {
      if ((this.eeN != null) && (this.eeN.isShowing()))
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramm).Ac();
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.h(this, 2131302425, 2131302426);
          this.gEj.reset();
          AppMethodBeat.o(124956);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.b(this, getString(2131296531), "", true);
          this.gEj.reset();
          AppMethodBeat.o(124956);
          return;
        }
        if (paramInt2 == -106)
        {
          z.f(this, paramString, 32045);
          this.gEj.reset();
          AppMethodBeat.o(124956);
        }
      }
      else if (i == 17)
      {
        this.gEt = paramInt2;
        this.gEu = paramString;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          new g(new LoginHistoryUI.8(this), ((com.tencent.mm.modelfriend.a)paramm).getUsername(), ((com.tencent.mm.modelfriend.a)paramm).agw(), this.gDW).a(this);
          AppMethodBeat.o(124956);
          return;
        }
        if (l(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(124956);
          return;
        }
        paramm = com.tencent.mm.h.a.kO(paramString);
        if (paramm != null) {
          paramm.a(this, null, null);
        }
      }
    }
    while (l(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(124956);
      return;
      if ((paramm.getType() == 252) || (paramm.getType() == 701))
      {
        this.cJr = ((s)paramm).ajF();
        ab.e("MicroMsg.LoginHistoryUI", "url " + this.cJr);
        com.tencent.mm.kernel.g.Rc().b(701, this);
        com.tencent.mm.kernel.g.Rc().b(252, this);
        this.gDU.gEL = ((s)paramm).getSecCodeType();
        this.gDU.gwj = ((s)paramm).ajG();
        this.gDU.gwi = ((s)paramm).ajH();
        this.gDU.gwk = ((s)paramm).ajI();
        if (paramInt2 == -205)
        {
          this.gBP = ((s)paramm).agy();
          this.gDW = ((s)paramm).ajK();
          this.gDX = ((s)paramm).ajN();
        }
        if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
          break label903;
        }
        com.tencent.mm.kernel.g.Rc().a(new bk(new LoginHistoryUI.9(this)), 0);
      }
    }
    label903:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        l.aqv();
        w.cs(this);
        z.wz(this.gDU.account);
        if ((this.eeN != null) && (this.eeN.isShowing())) {
          this.eeN.setMessage(getString(2131296987));
        }
        b((s)paramm);
        if (this.gyZ == 3)
        {
          this.gEn = ((s)paramm).ajP();
          if (((s)paramm).ajJ())
          {
            boolean bool = this.gEn;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131303322));
            paramString.putExtra("kintent_cancelable", bool);
            startActivity(paramString);
          }
        }
        AppMethodBeat.o(124956);
        return;
      }
      if ((this.eeN != null) && (this.eeN.isShowing()))
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if (paramInt2 == -106)
      {
        z.f(this, paramString, 31685);
        AppMethodBeat.o(124956);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(this, e.a((s)paramm), paramInt2);
        AppMethodBeat.o(124956);
        return;
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(124956);
        return;
      }
      paramm = com.tencent.mm.h.a.kO(paramString);
      if ((paramm != null) && (paramm.a(this, null, null)))
      {
        AppMethodBeat.o(124956);
        return;
      }
      Toast.makeText(this, getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(124956);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
  
  protected final String xw(String paramString)
  {
    AppMethodBeat.i(124949);
    new com.tencent.mm.sdk.platformtools.av();
    String str1 = "86";
    Object localObject = paramString;
    if (this.gEc.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = com.tencent.mm.sdk.platformtools.av.RC(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = com.tencent.mm.sdk.platformtools.av.formatNumber(str1, (String)localObject);
    AppMethodBeat.o(124949);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */