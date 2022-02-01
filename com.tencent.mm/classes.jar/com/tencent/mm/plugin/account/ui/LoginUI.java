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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;

public class LoginUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private TextWatcher awu;
  private String dLz;
  private String dqk;
  private ProgressDialog fOC;
  private String jdS;
  private SecurityImage jfm;
  private String jlr;
  private com.tencent.mm.sdk.b.c jmB;
  protected Button jnK;
  protected Button jnL;
  private View jnM;
  protected Button jnN;
  private String jnP;
  private ResizeLayout jnT;
  private com.tencent.mm.platformtools.b jnW;
  private f jnl;
  private boolean jnn;
  private String jno;
  private String jnp;
  private MMClearEditText joF;
  private MMClearEditText joG;
  private MMFormInputView joH;
  private MMFormInputView joI;
  private Button joJ;
  private Button joK;
  protected View joL;
  private MMKeyboardUperView joM;
  private boolean joN;
  final boolean[] joO;
  private final int joP;
  private Button joc;
  private x jow;
  private int sceneType;
  
  public LoginUI()
  {
    AppMethodBeat.i(128229);
    this.fOC = null;
    this.dqk = null;
    this.jfm = null;
    this.jnl = new f();
    this.dLz = "";
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
    this.joN = false;
    this.jmB = new LoginUI.12(this);
    this.joO = new boolean[] { true };
    this.joP = 128;
    this.jow = new x();
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128235);
  }
  
  private void aUs()
  {
    AppMethodBeat.i(128240);
    this.jnl.account = this.joF.getText().toString().trim();
    this.jnl.jfn = this.joG.getText().toString();
    if (this.jnl.account.equals(""))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    if (this.jnl.jfn.equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    hideVKB();
    this.jow.b(this, new Runnable()
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
    com.tencent.mm.plugin.b.a.KB(this.jdS);
    com.tencent.mm.pluginsdk.model.app.q.fdO();
    finish();
    AppMethodBeat.o(128237);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128238);
    if (com.tencent.mm.plugin.account.a.a.iUA.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128238);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
      boolean bool = this.jnW.a(this, paramString);
      AppMethodBeat.o(128238);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
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
      y.de(getContext());
      AppMethodBeat.o(128238);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.ajj().a(701, this);
      com.tencent.mm.kernel.g.ajj().a(252, this);
      if (this.jfm == null) {
        this.jfm = SecurityImage.a.a(this, this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128216);
            if (LoginUI.h(LoginUI.this) == null)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LoginUI", "secimg is null!");
              AppMethodBeat.o(128216);
              return;
            }
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.i(LoginUI.this).jfp + " img len" + LoginUI.i(LoginUI.this).jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
            paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginUI.i(LoginUI.this).account, LoginUI.i(LoginUI.this).jfn, LoginUI.i(LoginUI.this).joz, LoginUI.h(LoginUI.this).getSecImgCode(), LoginUI.h(LoginUI.this).getSecImgSid(), LoginUI.h(LoginUI.this).getSecImgEncryptKey(), 2, "", false, false);
            com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(2131755906);
            LoginUI.a(localLoginUI1, h.b(localLoginUI2, LoginUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(128215);
                com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.g.ajj().b(701, LoginUI.this);
                com.tencent.mm.kernel.g.ajj().b(252, LoginUI.this);
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
        }, this.jnl);
      }
      for (;;)
      {
        AppMethodBeat.o(128238);
        return true;
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginUI", "imgSid:" + this.jnl.jfp + " img len" + this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
        this.jfm.b(this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.ajP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
      for (paramString = com.tencent.mm.cb.a.az(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.aiH())
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
        com.tencent.mm.kernel.g.ajP();
      }
    case -205: 
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bu.aSM(this.jlr), this.jnp });
      f.a(this.jnl);
      com.tencent.mm.plugin.b.a.KB("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.jlr);
      paramString.putExtra("binded_mobile", this.jnP);
      paramString.putExtra("close_safe_device_style", this.jnp);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.a.a.iUz.g(this, paramString);
      AppMethodBeat.o(128238);
      return true;
    }
    if (!bu.isNullOrNil(this.dLz)) {
      y.n(this, paramString, this.dLz);
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
    this.joH = ((MMFormInputView)findViewById(2131301558));
    this.joI = ((MMFormInputView)findViewById(2131301577));
    this.joF = ((MMClearEditText)this.joH.getContentEditText());
    this.joG = ((MMClearEditText)this.joI.getContentEditText());
    com.tencent.mm.ui.tools.b.c.d(this.joG).afD(16).a(null);
    this.joF.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(128223);
        if (LoginUI.this.joO[0] != 0)
        {
          LoginUI.this.joO[0] = false;
          com.tencent.mm.plugin.normsg.a.b.wJt.auC("ie_login_id");
        }
        com.tencent.mm.plugin.normsg.a.b.wJt.auD("ie_login_id");
        AppMethodBeat.o(128223);
      }
    });
    this.joJ = ((Button)findViewById(2131301562));
    this.joJ.setEnabled(false);
    this.joK = ((Button)findViewById(2131301569));
    this.joc = ((Button)findViewById(2131301559));
    this.joL = findViewById(2131301561);
    this.joL.setVisibility(0);
    this.jnK = ((Button)findViewById(2131301572));
    this.jnM = findViewById(2131300241);
    this.jnL = ((Button)findViewById(2131301574));
    this.jnN = ((Button)findViewById(2131301575));
    this.jnT = ((ResizeLayout)findViewById(2131304133));
    this.joM = ((MMKeyboardUperView)findViewById(2131304370));
    this.jnT.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aUw()
      {
        AppMethodBeat.i(128224);
        LoginUI.b(LoginUI.this);
        AppMethodBeat.o(128224);
      }
    });
    this.jnK.setOnClickListener(new LoginUI.24(this));
    this.jnL.setOnClickListener(new LoginUI.25(this));
    Object localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    ((com.tencent.mm.ui.widget.a.e)localObject).LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(128227);
        if (paramAnonymousl.fCR())
        {
          paramAnonymousl.jM(5001, 2131766192);
          paramAnonymousl.jM(5002, 2131766189);
        }
        AppMethodBeat.o(128227);
      }
    };
    ((com.tencent.mm.ui.widget.a.e)localObject).KtV = new e.b()
    {
      public final void onDismiss() {}
    };
    ((com.tencent.mm.ui.widget.a.e)localObject).LfT = new LoginUI.28(this);
    if (ad.foj()) {
      this.jnN.setOnClickListener(new LoginUI.2(this));
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128205);
          LoginUI.d(LoginUI.this);
          AppMethodBeat.o(128205);
          return true;
        }
      }, 2131689488);
      localObject = new boolean[1];
      localObject[0] = 0;
      this.joJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128206);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (this.joR[0] != 0) {
            this.joR[0] = false;
          }
          for (;;)
          {
            LoginUI.e(LoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128206);
            return;
            com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_login_id", "<LoginByID>");
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_login_id", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_login_id");
          }
        }
      });
      this.joJ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(128207);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$14", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginUI$14", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(128207);
            return false;
            this.joR[0] = true;
            com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_login_id", "<LoginByID>");
            continue;
            com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_login_id", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_login_id");
          }
        }
      });
      this.joK.setOnClickListener(new LoginUI.7(this));
      this.jlr = getIntent().getStringExtra("auth_ticket");
      if (!bu.isNullOrNil(this.jlr))
      {
        this.joF.setText(bu.nullAsNil(f.aUx()));
        this.joG.setText(bu.nullAsNil(f.aUy()));
        new aq().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128209);
            LoginUI.e(LoginUI.this);
            AppMethodBeat.o(128209);
          }
        }, 500L);
      }
      this.joF.addTextChangedListener(this.awu);
      this.joG.addTextChangedListener(this.awu);
      this.joG.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128210);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            LoginUI.e(LoginUI.this);
            AppMethodBeat.o(128210);
            return true;
          }
          AppMethodBeat.o(128210);
          return false;
        }
      });
      this.joG.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128211);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.bd(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            LoginUI.e(LoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(128211);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128211);
          return false;
        }
      });
      if (k.IwK) {
        com.tencent.mm.plugin.account.a.a.iUA.t(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.joN = getIntent().getBooleanExtra("from_deep_link", false);
      if (!bu.isNullOrNil((String)localObject)) {
        this.joF.setText((CharSequence)localObject);
      }
      if (j.EX_DEVICE_LOGIN)
      {
        this.joc.setVisibility(0);
        this.joc.setOnClickListener(new LoginUI.11(this));
      }
      AppMethodBeat.o(128234);
      return;
      this.jnM.setVisibility(8);
      this.jnN.setText(2131760754);
      this.jnN.setOnClickListener(new LoginUI.3(this, (com.tencent.mm.ui.widget.a.e)localObject));
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (paramInt2 != -1) {
        break label239;
      }
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label194;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bu.isNullOrNil(str);
      if (!bu.isNullOrNil(str)) {
        break label178;
      }
    }
    label178:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label187;
      }
      this.jnl.jfn = str;
      aUs();
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
        aUs();
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
    if ((com.tencent.mm.protocal.d.FFK) || (j.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755822) + com.tencent.mm.cc.g.ix(this);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    this.jdS = com.tencent.mm.plugin.b.a.aVo();
    initView();
    this.jnW = new com.tencent.mm.platformtools.b();
    this.jnn = getIntent().getBooleanExtra("from_switch_account", false);
    this.jno = bb.hIK.ay("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.g.yxI.f(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    com.tencent.mm.cp.d.fWU();
    AppMethodBeat.o(128230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128233);
    if (this.jnW != null) {
      this.jnW.close();
    }
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_login_id");
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
    com.tencent.mm.sdk.b.a.IvT.d(this.jmB);
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("L100_100_logout") + ",2");
      AppMethodBeat.o(128232);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("L400_100_login") + ",2");
    }
    AppMethodBeat.o(128232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169139);
    this.jow.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128231);
    com.tencent.mm.sdk.b.a.IvT.c(this.jmB);
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.KA("L100_100_logout");
      AppMethodBeat.o(128231);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.KA("L400_100_login");
    }
    AppMethodBeat.o(128231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(128239);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if ((paramn.getType() != 252) && (paramn.getType() != 701))
    {
      AppMethodBeat.o(128239);
      return;
    }
    com.tencent.mm.kernel.g.ajj().b(252, this);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    this.dLz = ((com.tencent.mm.modelsimple.t)paramn).aLh();
    this.jnl.jfp = ((com.tencent.mm.modelsimple.t)paramn).aLi();
    this.jnl.jfo = ((com.tencent.mm.modelsimple.t)paramn).aLj();
    this.jnl.jfq = ((com.tencent.mm.modelsimple.t)paramn).aLk();
    this.jnl.joz = ((com.tencent.mm.modelsimple.t)paramn).getSecCodeType();
    this.jnl.account = ((com.tencent.mm.modelsimple.t)paramn).account;
    if (paramInt2 == -205)
    {
      this.jlr = ((com.tencent.mm.modelsimple.t)paramn).aHO();
      this.jnP = ((com.tencent.mm.modelsimple.t)paramn).aLm();
      this.jnp = ((com.tencent.mm.modelsimple.t)paramn).aLp();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128220);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128220);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFs();
          com.tencent.mm.kernel.g.ajP();
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
        com.tencent.mm.plugin.account.friend.a.l.aTs();
        y.Jv(this.jnl.account);
        paramString = bb.hIK.ay("login_weixin_username", "");
        com.tencent.mm.platformtools.t.cW(this);
        if (this.jnn)
        {
          cd.hLa.aP(this.jno, paramString);
          cd.hLa.h(v.aAC(), v.aBv());
          com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cd.hLa.aCR() });
        }
        y.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128221);
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(LoginUI.this);
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("kstyle_show_bind_mobile_afterauth", ((com.tencent.mm.modelsimple.t)paramn).aLn());
            ((Intent)localObject).putExtra("kstyle_bind_wording", ((com.tencent.mm.modelsimple.t)paramn).aLo());
            ((Intent)localObject).putExtra("kstyle_bind_recommend_show", ((com.tencent.mm.modelsimple.t)paramn).aLq());
            LoginUI localLoginUI = LoginUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginUI.this.finish();
            AppMethodBeat.o(128221);
          }
        }, false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        paramString = paramString.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_900_phone") + ",4");
        if (this.joN)
        {
          paramString = ak.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.abv()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.g.yxI.f(11930, new Object[] { paramString, Integer.valueOf(4) });
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
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramn), paramInt2);
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
      paramString = com.tencent.mm.h.a.uU(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */