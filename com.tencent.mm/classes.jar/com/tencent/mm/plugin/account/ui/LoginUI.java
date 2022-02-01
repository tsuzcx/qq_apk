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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public class LoginUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private TextWatcher awu;
  private String dKk;
  private String dpf;
  private ProgressDialog fMu;
  private String jaZ;
  private SecurityImage jct;
  private String jiy;
  private com.tencent.mm.sdk.b.c jjI;
  protected Button jkQ;
  protected Button jkR;
  private View jkS;
  protected Button jkT;
  private String jkV;
  private ResizeLayout jkZ;
  private f jkr;
  private boolean jkt;
  private String jku;
  private String jkv;
  private x jlC;
  private MMClearEditText jlL;
  private MMClearEditText jlM;
  private MMFormInputView jlN;
  private MMFormInputView jlO;
  private Button jlP;
  private Button jlQ;
  protected View jlR;
  private MMKeyboardUperView jlS;
  private boolean jlT;
  final boolean[] jlU;
  private final int jlV;
  private com.tencent.mm.platformtools.b jlc;
  private Button jli;
  private int sceneType;
  
  public LoginUI()
  {
    AppMethodBeat.i(128229);
    this.fMu = null;
    this.dpf = null;
    this.jct = null;
    this.jkr = new f();
    this.dKk = "";
    this.sceneType = 0;
    this.awu = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128202);
        LoginUI.a(LoginUI.this);
        AppMethodBeat.o(128202);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.jlT = false;
    this.jjI = new LoginUI.12(this);
    this.jlU = new boolean[] { true };
    this.jlV = 128;
    this.jlC = new x();
    AppMethodBeat.o(128229);
  }
  
  private static void Q(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128235);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128235);
  }
  
  private void aTT()
  {
    AppMethodBeat.i(128240);
    this.jkr.account = this.jlL.getText().toString().trim();
    this.jkr.jcu = this.jlM.getText().toString();
    if (this.jkr.account.equals(""))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    if (this.jkr.jcu.equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    hideVKB();
    this.jlC.b(this, new Runnable()
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
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    com.tencent.mm.pluginsdk.model.app.q.faa();
    finish();
    AppMethodBeat.o(128237);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128238);
    if (com.tencent.mm.plugin.account.a.a.iRH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128238);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new ae(paramInt1, paramInt2, paramString);
      boolean bool = this.jlc.a(this, paramString);
      AppMethodBeat.o(128238);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.g.aiU().aEN() == 5)
      {
        h.l(this, 2131761537, 2131761536);
        AppMethodBeat.o(128238);
        return true;
      }
      AppMethodBeat.o(128238);
      return false;
    case -3: 
      h.l(this, 2131758459, 2131760766);
      AppMethodBeat.o(128238);
      return true;
    case -9: 
      h.l(this, 2131760765, 2131760766);
      AppMethodBeat.o(128238);
      return true;
    case -72: 
      h.l(getContext(), 2131762374, 2131755906);
      AppMethodBeat.o(128238);
      return true;
    case -75: 
      y.dc(getContext());
      AppMethodBeat.o(128238);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.aiU().a(701, this);
      com.tencent.mm.kernel.g.aiU().a(252, this);
      if (this.jct == null) {
        this.jct = SecurityImage.a.a(this, this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128216);
            if (LoginUI.h(LoginUI.this) == null)
            {
              ad.e("MicroMsg.LoginUI", "secimg is null!");
              AppMethodBeat.o(128216);
              return;
            }
            ad.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.i(LoginUI.this).jcw + " img len" + LoginUI.i(LoginUI.this).jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
            paramAnonymousDialogInterface = new s(LoginUI.i(LoginUI.this).account, LoginUI.i(LoginUI.this).jcu, LoginUI.i(LoginUI.this).jlF, LoginUI.h(LoginUI.this).getSecImgCode(), LoginUI.h(LoginUI.this).getSecImgSid(), LoginUI.h(LoginUI.this).getSecImgEncryptKey(), 2, "", false, false);
            com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(2131755906);
            LoginUI.a(localLoginUI1, h.b(localLoginUI2, LoginUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(128215);
                com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.g.aiU().b(701, LoginUI.this);
                com.tencent.mm.kernel.g.aiU().b(252, LoginUI.this);
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
            LoginUI.j(LoginUI.this);
            AppMethodBeat.o(128217);
          }
        }, this.jkr);
      }
      for (;;)
      {
        AppMethodBeat.o(128238);
        return true;
        ad.d("MicroMsg.LoginUI", "imgSid:" + this.jkr.jcw + " img len" + this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
        this.jct.b(this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.ajA();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
      for (paramString = com.tencent.mm.cc.a.az(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.ais())
      {
        h.a(localAppCompatActivity, paramString, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
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
        com.tencent.mm.kernel.g.ajA();
      }
    case -205: 
      ad.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aRp(this.jiy), this.jkv });
      f.a(this.jkr);
      com.tencent.mm.plugin.b.a.Ma("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.jiy);
      paramString.putExtra("binded_mobile", this.jkV);
      paramString.putExtra("close_safe_device_style", this.jkv);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.a.a.iRG.g(this, paramString);
      AppMethodBeat.o(128238);
      return true;
    }
    if (!bt.isNullOrNil(this.dKk)) {
      y.n(this, paramString, this.dKk);
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
    this.jlN = ((MMFormInputView)findViewById(2131301558));
    this.jlO = ((MMFormInputView)findViewById(2131301577));
    this.jlL = ((MMClearEditText)this.jlN.getContentEditText());
    this.jlM = ((MMClearEditText)this.jlO.getContentEditText());
    com.tencent.mm.ui.tools.b.c.d(this.jlM).aeU(16).a(null);
    this.jlL.addTextChangedListener(new LoginUI.22(this));
    this.jlP = ((Button)findViewById(2131301562));
    this.jlP.setEnabled(false);
    this.jlQ = ((Button)findViewById(2131301569));
    this.jli = ((Button)findViewById(2131301559));
    this.jlR = findViewById(2131301561);
    this.jlR.setVisibility(0);
    this.jkQ = ((Button)findViewById(2131301572));
    this.jkS = findViewById(2131300241);
    this.jkR = ((Button)findViewById(2131301574));
    this.jkT = ((Button)findViewById(2131301575));
    this.jkZ = ((ResizeLayout)findViewById(2131304133));
    this.jlS = ((MMKeyboardUperView)findViewById(2131304370));
    this.jkZ.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aTX()
      {
        AppMethodBeat.i(128224);
        LoginUI.b(LoginUI.this);
        AppMethodBeat.o(128224);
      }
    });
    this.jkQ.setOnClickListener(new LoginUI.24(this));
    this.jkR.setOnClickListener(new LoginUI.25(this));
    Object localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    ((com.tencent.mm.ui.widget.a.e)localObject).KJy = new LoginUI.26(this);
    ((com.tencent.mm.ui.widget.a.e)localObject).JXC = new LoginUI.27(this);
    ((com.tencent.mm.ui.widget.a.e)localObject).KJz = new LoginUI.28(this);
    if (ac.fkp()) {
      this.jkT.setOnClickListener(new LoginUI.2(this));
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new LoginUI.4(this), 2131689488);
      localObject = new boolean[1];
      localObject[0] = 0;
      this.jlP.setOnClickListener(new LoginUI.5(this, (boolean[])localObject));
      this.jlP.setOnTouchListener(new LoginUI.6(this, (boolean[])localObject));
      this.jlQ.setOnClickListener(new LoginUI.7(this));
      this.jiy = getIntent().getStringExtra("auth_ticket");
      if (!bt.isNullOrNil(this.jiy))
      {
        this.jlL.setText(bt.nullAsNil(f.aTY()));
        this.jlM.setText(bt.nullAsNil(f.aTZ()));
        new ap().postDelayed(new LoginUI.8(this), 500L);
      }
      this.jlL.addTextChangedListener(this.awu);
      this.jlM.addTextChangedListener(this.awu);
      this.jlM.setOnEditorActionListener(new LoginUI.9(this));
      this.jlM.setOnKeyListener(new LoginUI.10(this));
      if (j.Icz) {
        com.tencent.mm.plugin.account.a.a.iRH.t(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.jlT = getIntent().getBooleanExtra("from_deep_link", false);
      if (!bt.isNullOrNil((String)localObject)) {
        this.jlL.setText((CharSequence)localObject);
      }
      if (i.EX_DEVICE_LOGIN)
      {
        this.jli.setVisibility(0);
        this.jli.setOnClickListener(new LoginUI.11(this));
      }
      AppMethodBeat.o(128234);
      return;
      this.jkS.setVisibility(8);
      this.jkT.setText(2131760754);
      this.jkT.setOnClickListener(new LoginUI.3(this, (com.tencent.mm.ui.widget.a.e)localObject));
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
      ad.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label239;
      }
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label194;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bt.isNullOrNil(str);
      if (!bt.isNullOrNil(str)) {
        break label178;
      }
    }
    label178:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ad.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label187;
      }
      this.jkr.jcu = str;
      aTT();
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
        aTT();
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
    if ((com.tencent.mm.protocal.d.Fnm) || (i.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755822) + com.tencent.mm.cd.g.is(this);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.account.a.a.iRH.MU();
    this.jaZ = com.tencent.mm.plugin.b.a.Mp();
    initView();
    this.jlc = new com.tencent.mm.platformtools.b();
    this.jkt = getIntent().getBooleanExtra("from_switch_account", false);
    this.jku = az.hFS.ax("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.g.yhR.f(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    com.tencent.mm.cq.d.fSu();
    AppMethodBeat.o(128230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128233);
    if (this.jlc != null) {
      this.jlc.close();
    }
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_login_id");
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
    com.tencent.mm.sdk.b.a.IbL.d(this.jjI);
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("L100_100_logout") + ",2");
      AppMethodBeat.o(128232);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("L400_100_login") + ",2");
    }
    AppMethodBeat.o(128232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169139);
    this.jlC.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128231);
    com.tencent.mm.sdk.b.a.IbL.c(this.jjI);
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.Kc("L100_100_logout");
      AppMethodBeat.o(128231);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.Kc("L400_100_login");
    }
    AppMethodBeat.o(128231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(128239);
    ad.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if ((paramn.getType() != 252) && (paramn.getType() != 701))
    {
      AppMethodBeat.o(128239);
      return;
    }
    com.tencent.mm.kernel.g.aiU().b(252, this);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    this.dKk = ((s)paramn).aKK();
    this.jkr.jcw = ((s)paramn).aKL();
    this.jkr.jcv = ((s)paramn).aKM();
    this.jkr.jcx = ((s)paramn).aKN();
    this.jkr.jlF = ((s)paramn).getSecCodeType();
    this.jkr.account = ((s)paramn).account;
    if (paramInt2 == -205)
    {
      this.jiy = ((s)paramn).aHx();
      this.jkV = ((s)paramn).aKP();
      this.jkv = ((s)paramn).aKS();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.aiU().a(new bo(new bo.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128220);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128220);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFc();
          com.tencent.mm.kernel.g.ajA();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128220);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aST();
        y.IW(this.jkr.account);
        paramString = az.hFS.ax("login_weixin_username", "");
        t.cU(this);
        if (this.jkt)
        {
          cb.hIi.aP(this.jku, paramString);
          cb.hIi.g(u.aAm(), u.aBf());
          com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cb.hIi.aCB() });
        }
        y.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128221);
            ad.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(LoginUI.this);
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("kstyle_show_bind_mobile_afterauth", ((s)paramn).aKQ());
            ((Intent)localObject).putExtra("kstyle_bind_wording", ((s)paramn).aKR());
            ((Intent)localObject).putExtra("kstyle_bind_recommend_show", ((s)paramn).aKT());
            LoginUI localLoginUI = LoginUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginUI.this.finish();
            AppMethodBeat.o(128221);
          }
        }, false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        paramString = paramString.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_900_phone") + ",4");
        if (this.jlT)
        {
          paramString = aj.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.abm()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.g.yhR.f(11930, new Object[] { paramString, Integer.valueOf(4) });
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
      paramString = com.tencent.mm.h.a.uz(paramString);
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