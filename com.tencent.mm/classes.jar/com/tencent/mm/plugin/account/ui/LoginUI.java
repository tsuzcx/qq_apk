package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

public class LoginUI
  extends MMActivity
  implements i
{
  private String fAo;
  private String fSt;
  private String fXu;
  private ProgressDialog iXX;
  private String mTu;
  private SecurityImage mUP;
  private String nbl;
  private IListener ncA;
  protected Button ndJ;
  protected Button ndK;
  private View ndL;
  protected Button ndM;
  private String ndO;
  private ResizeLayout ndS;
  private com.tencent.mm.platformtools.b ndW;
  private g ndj;
  private boolean ndl;
  private String ndm;
  private String ndn;
  private MMClearEditText neH;
  private MMClearEditText neI;
  private MMFormInputView neJ;
  private MMFormInputView neK;
  private Button neL;
  private Button neM;
  protected View neN;
  private MMKeyboardUperView neO;
  private boolean neP;
  final boolean[] neQ;
  private final int neR;
  private Button nec;
  private x nex;
  private int sceneType;
  private TextWatcher uY;
  
  public LoginUI()
  {
    AppMethodBeat.i(128229);
    this.iXX = null;
    this.fAo = null;
    this.mUP = null;
    this.ndj = new g();
    this.fXu = "";
    this.sceneType = 0;
    this.uY = new LoginUI.1(this);
    this.neP = false;
    this.ncA = new LoginUI.12(this);
    this.neQ = new boolean[] { true };
    this.fSt = "";
    this.neR = 128;
    this.nex = new x();
    AppMethodBeat.o(128229);
  }
  
  private static void W(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128235);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    com.tencent.mm.by.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128235);
  }
  
  private void bzr()
  {
    AppMethodBeat.i(128240);
    this.ndj.account = this.neH.getText().toString().trim();
    this.ndj.mUQ = this.neI.getText().toString();
    if (this.ndj.account.equals(""))
    {
      com.tencent.mm.ui.base.h.p(this, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128240);
      return;
    }
    if (this.ndj.mUQ.equals(""))
    {
      com.tencent.mm.ui.base.h.p(this, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128240);
      return;
    }
    hideVKB();
    this.nex.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169137);
        LoginUI.m(LoginUI.this);
        AppMethodBeat.o(169137);
      }
    });
    AppMethodBeat.o(128240);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128237);
    hideVKB();
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    com.tencent.mm.pluginsdk.model.app.q.hhA();
    finish();
    AppMethodBeat.o(128237);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128238);
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128238);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new ad(paramInt1, paramInt2, paramString);
      boolean bool = this.ndW.a(this, paramString);
      AppMethodBeat.o(128238);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.h.aGY().bih() == 5)
      {
        com.tencent.mm.ui.base.h.p(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128238);
        return true;
      }
      AppMethodBeat.o(128238);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.p(this, r.j.errcode_password, r.j.login_err_title);
      AppMethodBeat.o(128238);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.p(this, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128238);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.p(getContext(), r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
      AppMethodBeat.o(128238);
      return true;
    case -75: 
      y.dw(getContext());
      AppMethodBeat.o(128238);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.h.aGY().a(701, this);
      com.tencent.mm.kernel.h.aGY().a(252, this);
      if (this.mUP == null) {
        this.mUP = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128216);
            if (LoginUI.i(LoginUI.this) == null)
            {
              Log.e("MicroMsg.LoginUI", "secimg is null!");
              AppMethodBeat.o(128216);
              return;
            }
            Log.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.j(LoginUI.this).mUS + " img len" + LoginUI.j(LoginUI.this).mUR.length + " " + f.avD());
            paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginUI.j(LoginUI.this).account, LoginUI.j(LoginUI.this).mUQ, LoginUI.j(LoginUI.this).neB, LoginUI.i(LoginUI.this).getSecImgCode(), LoginUI.i(LoginUI.this).getSecImgSid(), LoginUI.i(LoginUI.this).getSecImgEncryptKey(), 2, "", false, false);
            com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(r.j.app_tip);
            LoginUI.a(localLoginUI1, com.tencent.mm.ui.base.h.a(localLoginUI2, LoginUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(128215);
                com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.h.aGY().b(701, LoginUI.this);
                com.tencent.mm.kernel.h.aGY().b(252, LoginUI.this);
                AppMethodBeat.o(128215);
              }
            }));
            AppMethodBeat.o(128216);
          }
        }, null, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128217);
            LoginUI.k(LoginUI.this);
            AppMethodBeat.o(128217);
          }
        }, this.ndj);
      }
      for (;;)
      {
        AppMethodBeat.o(128238);
        return true;
        Log.d("MicroMsg.LoginUI", "imgSid:" + this.ndj.mUS + " img len" + this.ndj.mUR.length + " " + f.avD());
        this.mUP.b(this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT);
      }
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aGF();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.h.aHE();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aGs())) {}
      for (paramString = com.tencent.mm.ci.a.ba(getContext(), r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aGs())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramString, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128218);
            LoginUI.l(LoginUI.this);
            AppMethodBeat.o(128218);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128219);
            LoginUI.l(LoginUI.this);
            AppMethodBeat.o(128219);
          }
        });
        AppMethodBeat.o(128238);
        return true;
        com.tencent.mm.kernel.h.aHE();
      }
    case -205: 
      Log.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.nbl), this.ndn });
      g.a(this.ndj);
      com.tencent.mm.plugin.b.a.bkD("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.nbl);
      paramString.putExtra("binded_mobile", this.ndO);
      paramString.putExtra("close_safe_device_style", this.ndn);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.sdk.a.mIG.g(this, paramString);
      AppMethodBeat.o(128238);
      return true;
    }
    if (!Util.isNullOrNil(this.fXu)) {
      y.p(this, paramString, this.fXu);
    }
    AppMethodBeat.o(128238);
    return true;
  }
  
  public void finish()
  {
    AppMethodBeat.i(128241);
    super.finish();
    int i = r.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(128241);
  }
  
  public int getLayoutId()
  {
    return r.g.login;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128234);
    this.neJ = ((MMFormInputView)findViewById(r.f.login_account_auto));
    Object localObject = (TextView)findViewById(r.f.login_title);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      this.neJ.setHint(r.j.login_account_hint);
      ((TextView)localObject).setText(r.j.login_by_other_account_title);
      this.neK = ((MMFormInputView)findViewById(r.f.login_password_et));
      this.neH = ((MMClearEditText)this.neJ.getContentEditText());
      this.neI = ((MMClearEditText)this.neK.getContentEditText());
      com.tencent.mm.ui.tools.b.c.i(this.neI).axx(16).a(null);
      this.neH.addTextChangedListener(new LoginUI.22(this));
      this.neL = ((Button)findViewById(r.f.login_btn));
      this.neL.setEnabled(false);
      this.neM = ((Button)findViewById(r.f.login_by_other));
      this.nec = ((Button)findViewById(r.f.login_as_other_device_btn));
      this.neN = findViewById(r.f.login_bottom_container);
      this.neN.setVisibility(0);
      this.ndJ = ((Button)findViewById(r.f.login_find_password_btn));
      this.ndL = findViewById(r.f.free_btn_container);
      this.ndK = ((Button)findViewById(r.f.login_freeze_account_btn));
      this.ndM = ((Button)findViewById(r.f.login_more_btn));
      this.ndS = ((ResizeLayout)findViewById(r.f.resize_lv));
      this.neO = ((MMKeyboardUperView)findViewById(r.f.scrollView));
      this.ndS.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void bzv()
        {
          AppMethodBeat.i(128224);
          LoginUI.b(LoginUI.this);
          AppMethodBeat.o(128224);
        }
      });
      this.ndJ.setOnClickListener(new LoginUI.24(this));
      this.ndK.setOnClickListener(new LoginUI.25(this));
      localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(128227);
          if (paramAnonymouso.hJO())
          {
            paramAnonymouso.mn(5001, r.j.wechat_safe_center);
            paramAnonymouso.mn(5002, r.j.wechat_help_center);
          }
          AppMethodBeat.o(128227);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).XbB = new LoginUI.27(this);
      ((com.tencent.mm.ui.widget.a.e)localObject).ODU = new LoginUI.28(this);
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        break label750;
      }
      this.ndM.setOnClickListener(new LoginUI.2(this));
      label393:
      setMMTitle("");
      setBackBtn(new LoginUI.4(this), r.i.actionbar_icon_close_black);
      localObject = new boolean[1];
      localObject[0] = 0;
      this.neL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128206);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (this.nez[0] != 0) {
            this.nez[0] = false;
          }
          for (;;)
          {
            LoginUI.f(LoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128206);
            return;
            LoginUI.a(LoginUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(2));
            com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_login_id", "<LoginByID>", LoginUI.e(LoginUI.this));
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_login_id", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_login_id");
          }
        }
      });
      this.neL.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(128207);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(128207);
            return false;
            this.nez[0] = true;
            LoginUI.a(LoginUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(2));
            com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_login_id", "<LoginByID>", LoginUI.e(LoginUI.this));
            continue;
            com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_login_id", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_login_id");
          }
        }
      });
      this.neM.setOnClickListener(new LoginUI.7(this));
      this.nbl = getIntent().getStringExtra("auth_ticket");
      if (!Util.isNullOrNil(this.nbl))
      {
        this.neH.setText(Util.nullAsNil(g.bzw()));
        this.neI.setText(Util.nullAsNil(g.bzx()));
        new MMHandler().postDelayed(new LoginUI.8(this), 500L);
      }
      this.neH.addTextChangedListener(this.uY);
      this.neI.addTextChangedListener(this.uY);
      this.neI.setOnEditorActionListener(new LoginUI.9(this));
      this.neI.setOnKeyListener(new LoginUI.10(this));
      if (ChannelUtil.shouldShowGprsAlert) {
        com.tencent.mm.plugin.account.sdk.a.mIH.s(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.neP = getIntent().getBooleanExtra("from_deep_link", false);
      if (!Util.isNullOrNil((String)localObject)) {
        this.neH.setText((CharSequence)localObject);
      }
      if (!BuildInfo.EX_DEVICE_LOGIN)
      {
        if ((ar.hIE()) && (!ar.hIM())) {
          localObject = com.tencent.mm.plugin.account.model.d.mZQ;
        }
      }
      else
      {
        this.nec.setVisibility(0);
        if ((!ar.hIE()) || (ar.hIM())) {
          break label788;
        }
        this.nec.setText(getResources().getString(r.j.login_in_pad_and_phone));
      }
    }
    for (;;)
    {
      this.nec.setOnClickListener(new LoginUI.11(this));
      AppMethodBeat.o(128234);
      return;
      this.neJ.setHint(r.j.login_account_hint_oversea);
      ((TextView)localObject).setText(r.j.login_by_other_account_title_oversea);
      break;
      label750:
      this.ndL.setVisibility(8);
      this.ndM.setText(r.j.login_by_more);
      this.ndM.setOnClickListener(new LoginUI.3(this, (com.tencent.mm.ui.widget.a.e)localObject));
      break label393;
      label788:
      this.nec.setText(getResources().getString(r.j.login_as_other_device));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(128242);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      Log.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label239;
      }
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label194;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = Util.isNullOrNil(str);
      if (!Util.isNullOrNil(str)) {
        break label178;
      }
    }
    label178:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      Log.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label187;
      }
      this.ndj.mUQ = str;
      bzr();
      AppMethodBeat.o(128242);
      return;
      bool = false;
      break;
    }
    label187:
    AppMethodBeat.o(128242);
    return;
    label194:
    if ((paramInt1 == 32644) && (paramIntent != null))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        bzr();
      }
    }
    label239:
    AppMethodBeat.o(128242);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128230);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(r.c.normal_bg_color));
    paramBundle = "";
    if ((com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(r.j.app_name) + com.tencent.mm.cj.h.kv(this);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(r.c.normal_actionbar_color));
    hideActionbarLine();
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.mTu = com.tencent.mm.plugin.b.a.bAt();
    initView();
    this.ndW = new com.tencent.mm.platformtools.b();
    this.ndl = getIntent().getBooleanExtra("from_switch_account", false);
    this.ndm = bg.ltv.aD("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.h.IzE.a(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    com.tencent.mm.xwebutil.c.ikh();
    AppMethodBeat.o(128230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128233);
    if (this.ndW != null) {
      this.ndW.close();
    }
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_login_id");
    super.onDestroy();
    AppMethodBeat.o(128233);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128236);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(128236);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128236);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128232);
    super.onPause();
    EventCenter.instance.removeListener(this.ncA);
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("L100_100_logout") + ",2");
      AppMethodBeat.o(128232);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("L400_100_login") + ",2");
    }
    AppMethodBeat.o(128232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169139);
    this.nex.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128231);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.bgi("L100_100_logout");
      AppMethodBeat.o(128231);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.bgi("L400_100_login");
    }
    AppMethodBeat.o(128231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(128239);
    Log.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramq.getType() != 252) && (paramq.getType() != 701))
    {
      AppMethodBeat.o(128239);
      return;
    }
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    this.fXu = ((com.tencent.mm.modelsimple.t)paramq).boA();
    this.ndj.mUS = ((com.tencent.mm.modelsimple.t)paramq).boB();
    this.ndj.mUR = ((com.tencent.mm.modelsimple.t)paramq).boC();
    this.ndj.mUT = ((com.tencent.mm.modelsimple.t)paramq).boD();
    this.ndj.neB = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
    this.ndj.account = ((com.tencent.mm.modelsimple.t)paramq).account;
    if (paramInt2 == -205)
    {
      this.nbl = ((com.tencent.mm.modelsimple.t)paramq).bkX();
      this.ndO = ((com.tencent.mm.modelsimple.t)paramq).boF();
      this.ndn = ((com.tencent.mm.modelsimple.t)paramq).boI();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.h.aGY().a(new bv(new LoginUI.18(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.b.aGG();
        com.tencent.mm.plugin.account.friend.a.l.byn();
        y.ZV(this.ndj.account);
        paramString = bg.ltv.aD("login_weixin_username", "");
        com.tencent.mm.platformtools.t.jdMethod_do(this);
        if (this.ndl)
        {
          ci.lvQ.aV(this.ndm, paramString);
          ci.lvQ.g(z.bcZ(), z.bdU());
          com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ci.lvQ.bft() });
        }
        y.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128221);
            Log.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(LoginUI.this);
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("kstyle_show_bind_mobile_afterauth", ((com.tencent.mm.modelsimple.t)paramq).boG());
            ((Intent)localObject).putExtra("kstyle_bind_wording", ((com.tencent.mm.modelsimple.t)paramq).boH());
            ((Intent)localObject).putExtra("kstyle_bind_recommend_show", ((com.tencent.mm.modelsimple.t)paramq).boJ());
            LoginUI localLoginUI = LoginUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localLoginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginUI.this.finish();
            AppMethodBeat.o(128221);
          }
        }, false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        paramString = paramString.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_900_phone") + ",4");
        if (this.neP)
        {
          paramString = MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.avK()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.IzE.a(11930, new Object[] { paramString, Integer.valueOf(4) });
        }
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -106)
      {
        y.f(this, paramString, 32644);
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128239);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -5)
      {
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          Toast.makeText(this, getString(r.j.loginby_access_denied), 0).show();
          AppMethodBeat.o(128239);
          return;
        }
        Toast.makeText(this, getString(r.j.login_err_title), 0).show();
        AppMethodBeat.o(128239);
        return;
      }
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128239);
        return;
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128239);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */