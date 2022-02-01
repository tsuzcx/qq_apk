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
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;

public class LoginUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private TextWatcher auC;
  private String ddJ;
  private String dxX;
  private ProgressDialog fts;
  private String iHQ;
  private SecurityImage iJk;
  private String iPp;
  private com.tencent.mm.sdk.b.c iQA;
  protected Button iRI;
  protected Button iRJ;
  private View iRK;
  protected Button iRL;
  private String iRN;
  private ResizeLayout iRR;
  private com.tencent.mm.platformtools.b iRU;
  private f iRj;
  private boolean iRl;
  private String iRm;
  private String iRn;
  private MMClearEditText iSD;
  private MMClearEditText iSE;
  private MMFormInputView iSF;
  private MMFormInputView iSG;
  private Button iSH;
  private Button iSI;
  protected View iSJ;
  private MMKeyboardUperView iSK;
  private boolean iSL;
  final boolean[] iSM;
  private final int iSN;
  private Button iSa;
  private x iSu;
  private int sceneType;
  
  public LoginUI()
  {
    AppMethodBeat.i(128229);
    this.fts = null;
    this.ddJ = null;
    this.iJk = null;
    this.iRj = new f();
    this.dxX = "";
    this.sceneType = 0;
    this.auC = new LoginUI.1(this);
    this.iSL = false;
    this.iQA = new LoginUI.12(this);
    this.iSM = new boolean[] { true };
    this.iSN = 128;
    this.iSu = new x();
    AppMethodBeat.o(128229);
  }
  
  private static void R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128235);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128235);
  }
  
  private void aQH()
  {
    AppMethodBeat.i(128240);
    this.iRj.account = this.iSD.getText().toString().trim();
    this.iRj.iJl = this.iSE.getText().toString();
    if (this.iRj.account.equals(""))
    {
      com.tencent.mm.ui.base.h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    if (this.iRj.iJl.equals(""))
    {
      com.tencent.mm.ui.base.h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    hideVKB();
    this.iSu.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169137);
        LoginUI.l(LoginUI.this);
        AppMethodBeat.o(169137);
      }
    });
    AppMethodBeat.o(128240);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128237);
    hideVKB();
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    com.tencent.mm.pluginsdk.model.app.q.eLg();
    finish();
    AppMethodBeat.o(128237);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128238);
    if (com.tencent.mm.plugin.account.a.a.iyy.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128238);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new ad(paramInt1, paramInt2, paramString);
      boolean bool = this.iRU.a(this, paramString);
      AppMethodBeat.o(128238);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.g.agi().aBK() == 5)
      {
        com.tencent.mm.ui.base.h.l(this, 2131761537, 2131761536);
        AppMethodBeat.o(128238);
        return true;
      }
      AppMethodBeat.o(128238);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.l(this, 2131758459, 2131760766);
      AppMethodBeat.o(128238);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.l(this, 2131760765, 2131760766);
      AppMethodBeat.o(128238);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.l(getContext(), 2131762374, 2131755906);
      AppMethodBeat.o(128238);
      return true;
    case -75: 
      y.de(getContext());
      AppMethodBeat.o(128238);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.agi().a(701, this);
      com.tencent.mm.kernel.g.agi().a(252, this);
      if (this.iJk == null) {
        this.iJk = SecurityImage.a.a(this, this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128216);
            if (LoginUI.h(LoginUI.this) == null)
            {
              ac.e("MicroMsg.LoginUI", "secimg is null!");
              AppMethodBeat.o(128216);
              return;
            }
            ac.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.i(LoginUI.this).iJn + " img len" + LoginUI.i(LoginUI.this).iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
            paramAnonymousDialogInterface = new s(LoginUI.i(LoginUI.this).account, LoginUI.i(LoginUI.this).iJl, LoginUI.i(LoginUI.this).iSx, LoginUI.h(LoginUI.this).getSecImgCode(), LoginUI.h(LoginUI.this).getSecImgSid(), LoginUI.h(LoginUI.this).getSecImgEncryptKey(), 2, "", false, false);
            com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(2131755906);
            LoginUI.a(localLoginUI1, com.tencent.mm.ui.base.h.b(localLoginUI2, LoginUI.this.getString(2131760781), true, new LoginUI.14.1(this, paramAnonymousDialogInterface)));
            AppMethodBeat.o(128216);
          }
        }, null, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128217);
            LoginUI.j(LoginUI.this);
            AppMethodBeat.o(128217);
          }
        }, this.iRj);
      }
      for (;;)
      {
        AppMethodBeat.o(128238);
        return true;
        ac.d("MicroMsg.LoginUI", "imgSid:" + this.iRj.iJn + " img len" + this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
        this.iJk.b(this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.agP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
      for (paramString = com.tencent.mm.cc.a.aw(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.afG())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramString, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128218);
            LoginUI.k(LoginUI.this);
            AppMethodBeat.o(128218);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128219);
            LoginUI.k(LoginUI.this);
            AppMethodBeat.o(128219);
          }
        });
        AppMethodBeat.o(128238);
        return true;
        com.tencent.mm.kernel.g.agP();
      }
    case -205: 
      ac.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bs.aLJ(this.iPp), this.iRn });
      f.a(this.iRj);
      com.tencent.mm.plugin.b.a.IL("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.iPp);
      paramString.putExtra("binded_mobile", this.iRN);
      paramString.putExtra("close_safe_device_style", this.iRn);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.a.a.iyx.g(this, paramString);
      AppMethodBeat.o(128238);
      return true;
    }
    if (!bs.isNullOrNil(this.dxX)) {
      y.m(this, paramString, this.dxX);
    }
    AppMethodBeat.o(128238);
    return true;
  }
  
  public void finish()
  {
    AppMethodBeat.i(128241);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(128241);
  }
  
  public int getLayoutId()
  {
    return 2131494602;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128234);
    this.iSF = ((MMFormInputView)findViewById(2131301558));
    this.iSG = ((MMFormInputView)findViewById(2131301577));
    this.iSD = ((MMClearEditText)this.iSF.getContentEditText());
    this.iSE = ((MMClearEditText)this.iSG.getContentEditText());
    com.tencent.mm.ui.tools.b.c.d(this.iSE).acw(16).a(null);
    this.iSD.addTextChangedListener(new LoginUI.22(this));
    this.iSH = ((Button)findViewById(2131301562));
    this.iSH.setEnabled(false);
    this.iSI = ((Button)findViewById(2131301569));
    this.iSa = ((Button)findViewById(2131301559));
    this.iSJ = findViewById(2131301561);
    this.iSJ.setVisibility(0);
    this.iRI = ((Button)findViewById(2131301572));
    this.iRK = findViewById(2131300241);
    this.iRJ = ((Button)findViewById(2131301574));
    this.iRL = ((Button)findViewById(2131301575));
    this.iRR = ((ResizeLayout)findViewById(2131304133));
    this.iSK = ((MMKeyboardUperView)findViewById(2131304370));
    this.iRR.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aQL()
      {
        AppMethodBeat.i(128224);
        LoginUI.b(LoginUI.this);
        AppMethodBeat.o(128224);
      }
    });
    this.iRI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128225);
        paramAnonymousView = LoginUI.this.getString(2131760769) + ab.eUO();
        LoginUI.S(LoginUI.this, paramAnonymousView);
        AppMethodBeat.o(128225);
      }
    });
    this.iRJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128226);
        paramAnonymousView = LoginUI.this.getString(2131759660, new Object[] { ab.eUO() });
        LoginUI.S(LoginUI.this, paramAnonymousView);
        AppMethodBeat.o(128226);
      }
    });
    Object localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    ((com.tencent.mm.ui.widget.a.e)localObject).ISu = new LoginUI.26(this);
    ((com.tencent.mm.ui.widget.a.e)localObject).Ihj = new e.b()
    {
      public final void onDismiss() {}
    };
    ((com.tencent.mm.ui.widget.a.e)localObject).ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(128228);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(128228);
          return;
          LoginUI.c(LoginUI.this);
          AppMethodBeat.o(128228);
          return;
          LoginUI.S(LoginUI.this, LoginUI.this.getString(2131766190) + ab.eUO());
        }
      }
    };
    if (ab.eUL()) {
      this.iRL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128203);
          LoginUI.c(LoginUI.this);
          AppMethodBeat.o(128203);
        }
      });
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new LoginUI.4(this), 2131689488);
      localObject = new boolean[1];
      localObject[0] = 0;
      this.iSH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128206);
          if (this.iSP[0] != 0) {
            this.iSP[0] = false;
          }
          for (;;)
          {
            LoginUI.e(LoginUI.this);
            AppMethodBeat.o(128206);
            return;
            com.tencent.mm.plugin.normsg.a.b.vor.id("ce_login_id", "<LoginByID>");
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.b.vor.a("ce_login_id", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_login_id");
          }
        }
      });
      this.iSH.setOnTouchListener(new View.OnTouchListener()
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
            this.iSP[0] = true;
            com.tencent.mm.plugin.normsg.a.b.vor.id("ce_login_id", "<LoginByID>");
            continue;
            com.tencent.mm.plugin.normsg.a.b.vor.a("ce_login_id", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_login_id");
          }
        }
      });
      this.iSI.setOnClickListener(new LoginUI.7(this));
      this.iPp = getIntent().getStringExtra("auth_ticket");
      if (!bs.isNullOrNil(this.iPp))
      {
        this.iSD.setText(bs.nullAsNil(f.aQM()));
        this.iSE.setText(bs.nullAsNil(f.aQN()));
        new ao().postDelayed(new LoginUI.8(this), 500L);
      }
      this.iSD.addTextChangedListener(this.auC);
      this.iSE.addTextChangedListener(this.auC);
      this.iSE.setOnEditorActionListener(new LoginUI.9(this));
      this.iSE.setOnKeyListener(new LoginUI.10(this));
      if (i.GqL) {
        com.tencent.mm.plugin.account.a.a.iyy.t(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.iSL = getIntent().getBooleanExtra("from_deep_link", false);
      if (!bs.isNullOrNil((String)localObject)) {
        this.iSD.setText((CharSequence)localObject);
      }
      if (com.tencent.mm.sdk.platformtools.h.EX_DEVICE_LOGIN)
      {
        this.iSa.setVisibility(0);
        this.iSa.setOnClickListener(new LoginUI.11(this));
      }
      AppMethodBeat.o(128234);
      return;
      this.iRK.setVisibility(8);
      this.iRL.setText(2131760754);
      this.iRL.setOnClickListener(new LoginUI.3(this, (com.tencent.mm.ui.widget.a.e)localObject));
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
      ac.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label239;
      }
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label194;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bs.isNullOrNil(str);
      if (!bs.isNullOrNil(str)) {
        break label178;
      }
    }
    label178:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ac.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label187;
      }
      this.iRj.iJl = str;
      aQH();
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
        aQH();
      }
    }
    label239:
    AppMethodBeat.o(128242);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128230);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(2131100706));
    paramBundle = "";
    if (com.tencent.mm.protocal.d.DIf) {
      paramBundle = getString(2131755822) + getString(2131755263);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.iHQ = com.tencent.mm.plugin.b.a.EL();
    initView();
    this.iRU = new com.tencent.mm.platformtools.b();
    this.iRl = getIntent().getBooleanExtra("from_switch_account", false);
    this.iRm = ay.hnA.aw("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.h.wUl.f(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    AppMethodBeat.o(128230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128233);
    if (this.iRU != null) {
      this.iRU.close();
    }
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_login_id");
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
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("L100_100_logout") + ",2");
      AppMethodBeat.o(128232);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("L400_100_login") + ",2");
    }
    AppMethodBeat.o(128232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169139);
    this.iSu.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128231);
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.IK("L100_100_logout");
      AppMethodBeat.o(128231);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.IK("L400_100_login");
    }
    AppMethodBeat.o(128231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128239);
    ac.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramn.getType() != 252) && (paramn.getType() != 701))
    {
      AppMethodBeat.o(128239);
      return;
    }
    com.tencent.mm.kernel.g.agi().b(252, this);
    com.tencent.mm.kernel.g.agi().b(701, this);
    this.dxX = ((s)paramn).aHz();
    this.iRj.iJn = ((s)paramn).aHA();
    this.iRj.iJm = ((s)paramn).aHB();
    this.iRj.iJo = ((s)paramn).aHC();
    this.iRj.iSx = ((s)paramn).getSecCodeType();
    this.iRj.account = ((s)paramn).account;
    if (paramInt2 == -205)
    {
      this.iPp = ((s)paramn).aEs();
      this.iRN = ((s)paramn).aHE();
      this.iRn = ((s)paramn).aHH();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.agi().a(new bn(new LoginUI.18(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aPH();
        y.FH(this.iRj.account);
        paramString = ay.hnA.aw("login_weixin_username", "");
        t.cW(this);
        if (this.iRl)
        {
          ca.hpQ.aO(this.iRm, paramString);
          ca.hpQ.f(u.axw(), u.ayf());
          com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ca.hpQ.azy() });
        }
        y.showAddrBookUploadConfirm(this, new LoginUI.19(this, paramn), false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        paramString = paramString.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_900_phone") + ",4");
        if (this.iSL)
        {
          paramString = ai.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.YK()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.wUl.f(11930, new Object[] { paramString, Integer.valueOf(4) });
        }
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 32644);
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
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
        Toast.makeText(this, getString(2131760790), 0).show();
        AppMethodBeat.o(128239);
        return;
      }
      paramString = com.tencent.mm.h.a.rM(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128239);
        return;
      }
      Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */