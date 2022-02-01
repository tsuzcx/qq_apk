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
import com.tencent.mm.al.n;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;

public class LoginUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private TextWatcher atH;
  private String dAl;
  private String dgo;
  private ProgressDialog fpP;
  private String ihI;
  private SecurityImage ijd;
  private String ipj;
  private com.tencent.mm.sdk.b.c iqt;
  protected Button irD;
  protected Button irE;
  private View irF;
  protected Button irG;
  private String irI;
  private ResizeLayout irM;
  private com.tencent.mm.platformtools.b irP;
  private Button irV;
  private f ird;
  private boolean irf;
  private String irg;
  private String irh;
  private MMFormInputView isA;
  private MMFormInputView isB;
  private Button isC;
  private Button isD;
  protected View isE;
  private MMKeyboardUperView isF;
  private boolean isG;
  final boolean[] isH;
  private final int isI;
  private x isp;
  private MMClearEditText isy;
  private MMClearEditText isz;
  private int sceneType;
  
  public LoginUI()
  {
    AppMethodBeat.i(128229);
    this.fpP = null;
    this.dgo = null;
    this.ijd = null;
    this.ird = new f();
    this.dAl = "";
    this.sceneType = 0;
    this.atH = new TextWatcher()
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
    this.isG = false;
    this.iqt = new LoginUI.12(this);
    this.isH = new boolean[] { true };
    this.isI = 128;
    this.isp = new x();
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128235);
  }
  
  private void aJQ()
  {
    AppMethodBeat.i(128240);
    this.ird.account = this.isy.getText().toString().trim();
    this.ird.ije = this.isz.getText().toString();
    if (this.ird.account.equals(""))
    {
      com.tencent.mm.ui.base.h.j(this, 2131764665, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    if (this.ird.ije.equals(""))
    {
      com.tencent.mm.ui.base.h.j(this, 2131764658, 2131760766);
      AppMethodBeat.o(128240);
      return;
    }
    hideVKB();
    this.isp.b(this, new Runnable()
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
    com.tencent.mm.plugin.b.a.aUz(this.ihI);
    com.tencent.mm.pluginsdk.model.app.q.evM();
    finish();
    AppMethodBeat.o(128237);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128238);
    if (com.tencent.mm.plugin.account.a.a.hYu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128238);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new com.tencent.mm.platformtools.ad(paramInt1, paramInt2, paramString);
      boolean bool = this.irP.a(this, paramString);
      AppMethodBeat.o(128238);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.g.aeS().auR() == 5)
      {
        com.tencent.mm.ui.base.h.j(this, 2131761537, 2131761536);
        AppMethodBeat.o(128238);
        return true;
      }
      AppMethodBeat.o(128238);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.j(this, 2131758459, 2131760766);
      AppMethodBeat.o(128238);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.j(this, 2131760765, 2131760766);
      AppMethodBeat.o(128238);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.j(getContext(), 2131762374, 2131755906);
      AppMethodBeat.o(128238);
      return true;
    case -75: 
      y.cV(getContext());
      AppMethodBeat.o(128238);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.aeS().a(701, this);
      com.tencent.mm.kernel.g.aeS().a(252, this);
      if (this.ijd == null) {
        this.ijd = SecurityImage.a.a(this, this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128216);
            if (LoginUI.h(LoginUI.this) == null)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LoginUI", "secimg is null!");
              AppMethodBeat.o(128216);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.i(LoginUI.this).ijg + " img len" + LoginUI.i(LoginUI.this).ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
            paramAnonymousDialogInterface = new s(LoginUI.i(LoginUI.this).account, LoginUI.i(LoginUI.this).ije, LoginUI.i(LoginUI.this).iss, LoginUI.h(LoginUI.this).getSecImgCode(), LoginUI.h(LoginUI.this).getSecImgSid(), LoginUI.h(LoginUI.this).getSecImgEncryptKey(), 2, "", false, false);
            com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(2131755906);
            LoginUI.a(localLoginUI1, com.tencent.mm.ui.base.h.b(localLoginUI2, LoginUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(128215);
                com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.g.aeS().b(701, LoginUI.this);
                com.tencent.mm.kernel.g.aeS().b(252, LoginUI.this);
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
        }, this.ird);
      }
      for (;;)
      {
        AppMethodBeat.o(128238);
        return true;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginUI", "imgSid:" + this.ird.ijg + " img len" + this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
        this.ijd.b(this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.afz();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
      for (paramString = com.tencent.mm.cd.a.aq(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.aeq())
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
        com.tencent.mm.kernel.g.afz();
      }
    case -205: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aGs(this.ipj), this.irh });
      f.a(this.ird);
      com.tencent.mm.plugin.b.a.aUz("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.ipj);
      paramString.putExtra("binded_mobile", this.irI);
      paramString.putExtra("close_safe_device_style", this.irh);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.a.a.hYt.g(this, paramString);
      AppMethodBeat.o(128238);
      return true;
    }
    if (!bt.isNullOrNil(this.dAl)) {
      y.m(this, paramString, this.dAl);
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
    this.isA = ((MMFormInputView)findViewById(2131301558));
    this.isB = ((MMFormInputView)findViewById(2131301577));
    this.isy = ((MMClearEditText)this.isA.getContentEditText());
    this.isz = ((MMClearEditText)this.isB.getContentEditText());
    com.tencent.mm.ui.tools.b.c.d(this.isz).aaj(16).a(null);
    this.isy.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(128223);
        if (LoginUI.this.isH[0] != 0)
        {
          LoginUI.this.isH[0] = false;
          com.tencent.mm.plugin.normsg.a.b.ufs.ajr("ie_login_id");
        }
        com.tencent.mm.plugin.normsg.a.b.ufs.ajs("ie_login_id");
        AppMethodBeat.o(128223);
      }
    });
    this.isC = ((Button)findViewById(2131301562));
    this.isC.setEnabled(false);
    this.isD = ((Button)findViewById(2131301569));
    this.irV = ((Button)findViewById(2131301559));
    this.isE = findViewById(2131301561);
    this.isE.setVisibility(0);
    this.irD = ((Button)findViewById(2131301572));
    this.irF = findViewById(2131300241);
    this.irE = ((Button)findViewById(2131301574));
    this.irG = ((Button)findViewById(2131301575));
    this.irM = ((ResizeLayout)findViewById(2131304133));
    this.isF = ((MMKeyboardUperView)findViewById(2131304370));
    this.irM.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aJU()
      {
        AppMethodBeat.i(128224);
        LoginUI.b(LoginUI.this);
        AppMethodBeat.o(128224);
      }
    });
    this.irD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128225);
        paramAnonymousView = LoginUI.this.getString(2131760769) + ac.eFu();
        LoginUI.R(LoginUI.this, paramAnonymousView);
        AppMethodBeat.o(128225);
      }
    });
    this.irE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128226);
        paramAnonymousView = LoginUI.this.getString(2131759660, new Object[] { ac.eFu() });
        LoginUI.R(LoginUI.this, paramAnonymousView);
        AppMethodBeat.o(128226);
      }
    });
    Object localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
    ((com.tencent.mm.ui.widget.a.e)localObject).HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(128227);
        if (paramAnonymousl.eSQ())
        {
          paramAnonymousl.jj(5001, 2131766192);
          paramAnonymousl.jj(5002, 2131766189);
        }
        AppMethodBeat.o(128227);
      }
    };
    ((com.tencent.mm.ui.widget.a.e)localObject).GHn = new e.b()
    {
      public final void onDismiss() {}
    };
    ((com.tencent.mm.ui.widget.a.e)localObject).HrY = new n.d()
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
          LoginUI.R(LoginUI.this, LoginUI.this.getString(2131766190) + ac.eFu());
        }
      }
    };
    if (ac.eFr()) {
      this.irG.setOnClickListener(new View.OnClickListener()
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
      this.isC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128206);
          if (this.isK[0] != 0) {
            this.isK[0] = false;
          }
          for (;;)
          {
            LoginUI.e(LoginUI.this);
            AppMethodBeat.o(128206);
            return;
            com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_login_id", "<LoginByID>");
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_login_id", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_login_id");
          }
        }
      });
      this.isC.setOnTouchListener(new View.OnTouchListener()
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
            this.isK[0] = true;
            com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_login_id", "<LoginByID>");
            continue;
            com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_login_id", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_login_id");
          }
        }
      });
      this.isD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128208);
          paramAnonymousView = new Intent(LoginUI.this, MobileInputUI.class);
          Object localObject = new int[5];
          localObject[0] = 2;
          paramAnonymousView.putExtra("mobile_input_purpose", 1);
          paramAnonymousView.putExtra("kv_report_login_method_data", (int[])localObject);
          paramAnonymousView.putExtra("from_switch_account", LoginUI.f(LoginUI.this));
          localObject = LoginUI.this;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((LoginUI)localObject).startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LoginUI.this.finish();
          AppMethodBeat.o(128208);
        }
      });
      this.ipj = getIntent().getStringExtra("auth_ticket");
      if (!bt.isNullOrNil(this.ipj))
      {
        this.isy.setText(bt.nullAsNil(f.aJV()));
        this.isz.setText(bt.nullAsNil(f.aJW()));
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128209);
            LoginUI.e(LoginUI.this);
            AppMethodBeat.o(128209);
          }
        }, 500L);
      }
      this.isy.addTextChangedListener(this.atH);
      this.isz.addTextChangedListener(this.atH);
      this.isz.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
      this.isz.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128211);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            LoginUI.e(LoginUI.this);
            AppMethodBeat.o(128211);
            return true;
          }
          AppMethodBeat.o(128211);
          return false;
        }
      });
      if (i.ETy) {
        com.tencent.mm.plugin.account.a.a.hYu.t(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.isG = getIntent().getBooleanExtra("from_deep_link", false);
      if (!bt.isNullOrNil((String)localObject)) {
        this.isy.setText((CharSequence)localObject);
      }
      if (com.tencent.mm.sdk.platformtools.h.EX_DEVICE_LOGIN)
      {
        this.irV.setVisibility(0);
        this.irV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(128212);
            com.tencent.mm.bs.d.O(LoginUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginUI.this.overridePendingTransition(2130772105, 2130771986);
            AppMethodBeat.o(128212);
          }
        });
      }
      AppMethodBeat.o(128234);
      return;
      this.irF.setVisibility(8);
      this.irG.setText(2131760754);
      this.irG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128204);
          this.ise.csG();
          AppMethodBeat.o(128204);
        }
      });
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label187;
      }
      this.ird.ije = str;
      aJQ();
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
        aJQ();
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
    if (com.tencent.mm.protocal.d.CpN) {
      paramBundle = getString(2131755822) + getString(2131755263);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(2131100705));
    hideActionbarLine();
    com.tencent.mm.plugin.account.a.a.hYu.Lo();
    this.ihI = com.tencent.mm.plugin.b.a.fQQ();
    initView();
    this.irP = new com.tencent.mm.platformtools.b();
    this.irf = getIntent().getBooleanExtra("from_switch_account", false);
    this.irg = ay.gNa.ao("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.h.vKh.f(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    AppMethodBeat.o(128230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128233);
    if (this.irP != null) {
      this.irP.close();
    }
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_login_id");
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
    com.tencent.mm.sdk.b.a.ESL.d(this.iqt);
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("L100_100_logout") + ",2");
      AppMethodBeat.o(128232);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("L400_100_login") + ",2");
    }
    AppMethodBeat.o(128232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169139);
    this.isp.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128231);
    com.tencent.mm.sdk.b.a.ESL.c(this.iqt);
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.aUy("L100_100_logout");
      AppMethodBeat.o(128231);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.aUy("L400_100_login");
    }
    AppMethodBeat.o(128231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(128239);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramn.getType() != 252) && (paramn.getType() != 701))
    {
      AppMethodBeat.o(128239);
      return;
    }
    com.tencent.mm.kernel.g.aeS().b(252, this);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    this.dAl = ((s)paramn).aAJ();
    this.ird.ijg = ((s)paramn).aAK();
    this.ird.ijf = ((s)paramn).aAL();
    this.ird.ijh = ((s)paramn).aAM();
    this.ird.iss = ((s)paramn).getSecCodeType();
    this.ird.account = ((s)paramn).account;
    if (paramInt2 == -205)
    {
      this.ipj = ((s)paramn).axA();
      this.irI = ((s)paramn).aAO();
      this.irh = ((s)paramn).aAR();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128220);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128220);
            return;
          }
          paramAnonymouse = paramAnonymouse.avg();
          com.tencent.mm.kernel.g.afz();
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
        com.tencent.mm.plugin.account.friend.a.l.aIQ();
        y.BD(this.ird.account);
        paramString = ay.gNa.ao("login_weixin_username", "");
        t.cN(this);
        if (this.irf)
        {
          ca.gPq.aG(this.irg, paramString);
          ca.gPq.f(u.aqG(), u.arp());
          com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ca.gPq.asH() });
        }
        y.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128221);
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(LoginUI.this);
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("kstyle_show_bind_mobile_afterauth", ((s)paramn).aAP());
            ((Intent)localObject).putExtra("kstyle_bind_wording", ((s)paramn).aAQ());
            ((Intent)localObject).putExtra("kstyle_bind_recommend_show", ((s)paramn).aAS());
            LoginUI localLoginUI = LoginUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginUI.this.finish();
            AppMethodBeat.o(128221);
          }
        }, false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        paramString = paramString.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_900_phone") + ",4");
        if (this.isG)
        {
          paramString = aj.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.XN()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.vKh.f(11930, new Object[] { paramString, Integer.valueOf(4) });
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
      paramString = com.tencent.mm.h.a.oG(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */