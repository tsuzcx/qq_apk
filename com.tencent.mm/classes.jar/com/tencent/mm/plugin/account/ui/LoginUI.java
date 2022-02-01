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
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.b;

public class LoginUI
  extends MMActivity
  implements i
{
  private TextWatcher aws;
  private String dHx;
  private String dYB;
  private String edo;
  private ProgressDialog gtM;
  private String kbV;
  private SecurityImage kdp;
  private String kjv;
  private IListener kkK;
  protected Button klS;
  protected Button klT;
  private View klU;
  protected Button klV;
  private String klX;
  private g klt;
  private boolean klv;
  private String klw;
  private String klx;
  private x kmF;
  private MMClearEditText kmP;
  private MMClearEditText kmQ;
  private MMFormInputView kmR;
  private MMFormInputView kmS;
  private Button kmT;
  private Button kmU;
  protected View kmV;
  private MMKeyboardUperView kmW;
  private boolean kmX;
  final boolean[] kmY;
  private final int kmZ;
  private ResizeLayout kmb;
  private com.tencent.mm.platformtools.b kmf;
  private Button kml;
  private int sceneType;
  
  public LoginUI()
  {
    AppMethodBeat.i(128229);
    this.gtM = null;
    this.dHx = null;
    this.kdp = null;
    this.klt = new g();
    this.edo = "";
    this.sceneType = 0;
    this.aws = new TextWatcher()
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
    this.kmX = false;
    this.kkK = new LoginUI.12(this);
    this.kmY = new boolean[] { true };
    this.dYB = "";
    this.kmZ = 128;
    this.kmF = new x();
    AppMethodBeat.o(128229);
  }
  
  private static void Y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128235);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128235);
  }
  
  private void bpf()
  {
    AppMethodBeat.i(128240);
    this.klt.account = this.kmP.getText().toString().trim();
    this.klt.kdq = this.kmQ.getText().toString();
    if (this.klt.account.equals(""))
    {
      com.tencent.mm.ui.base.h.n(this, 2131767037, 2131762516);
      AppMethodBeat.o(128240);
      return;
    }
    if (this.klt.kdq.equals(""))
    {
      com.tencent.mm.ui.base.h.n(this, 2131767029, 2131762516);
      AppMethodBeat.o(128240);
      return;
    }
    hideVKB();
    this.kmF.b(this, new Runnable()
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
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    com.tencent.mm.pluginsdk.model.app.q.gmZ();
    finish();
    AppMethodBeat.o(128237);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128238);
    if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128238);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new ae(paramInt1, paramInt2, paramString);
      boolean bool = this.kmf.a(this, paramString);
      AppMethodBeat.o(128238);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.g.azz().aYS() == 5)
      {
        com.tencent.mm.ui.base.h.n(this, 2131763503, 2131763502);
        AppMethodBeat.o(128238);
        return true;
      }
      AppMethodBeat.o(128238);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.n(this, 2131758757, 2131762516);
      AppMethodBeat.o(128238);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.n(this, 2131762515, 2131762516);
      AppMethodBeat.o(128238);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.n(getContext(), 2131764440, 2131755998);
      AppMethodBeat.o(128238);
      return true;
    case -75: 
      y.dz(getContext());
      AppMethodBeat.o(128238);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.g.azz().a(701, this);
      com.tencent.mm.kernel.g.azz().a(252, this);
      if (this.kdp == null) {
        this.kdp = SecurityImage.a.a(this, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener()
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
            Log.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.j(LoginUI.this).kds + " img len" + LoginUI.j(LoginUI.this).kdr.length + " " + f.apq());
            paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginUI.j(LoginUI.this).account, LoginUI.j(LoginUI.this).kdq, LoginUI.j(LoginUI.this).kmJ, LoginUI.i(LoginUI.this).getSecImgCode(), LoginUI.i(LoginUI.this).getSecImgSid(), LoginUI.i(LoginUI.this).getSecImgEncryptKey(), 2, "", false, false);
            com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(2131755998);
            LoginUI.a(localLoginUI1, com.tencent.mm.ui.base.h.a(localLoginUI2, LoginUI.this.getString(2131762532), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(128215);
                com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.g.azz().b(701, LoginUI.this);
                com.tencent.mm.kernel.g.azz().b(252, LoginUI.this);
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
        }, this.klt);
      }
      for (;;)
      {
        AppMethodBeat.o(128238);
        return true;
        Log.d("MicroMsg.LoginUI", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
        this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
      }
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.aAf();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
      for (paramString = com.tencent.mm.cb.a.aI(getContext(), 2131762849);; paramString = com.tencent.mm.kernel.a.ayX())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramString, getContext().getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
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
        com.tencent.mm.kernel.g.aAf();
      }
    case -205: 
      Log.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.kjv), this.klx });
      g.a(this.klt);
      com.tencent.mm.plugin.b.a.bwV("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.kjv);
      paramString.putExtra("binded_mobile", this.klX);
      paramString.putExtra("close_safe_device_style", this.klx);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.a.a.jRt.g(this, paramString);
      AppMethodBeat.o(128238);
      return true;
    }
    if (!Util.isNullOrNil(this.edo)) {
      y.m(this, paramString, this.edo);
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
    return 2131495313;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128234);
    this.kmR = ((MMFormInputView)findViewById(2131303776));
    Object localObject = (TextView)findViewById(2131303812);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      this.kmR.setHint(2131762484);
      ((TextView)localObject).setText(2131762504);
      this.kmS = ((MMFormInputView)findViewById(2131303805));
      this.kmP = ((MMClearEditText)this.kmR.getContentEditText());
      this.kmQ = ((MMClearEditText)this.kmS.getContentEditText());
      com.tencent.mm.ui.tools.b.c.f(this.kmQ).aoq(16).a(null);
      this.kmP.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128223);
          if (LoginUI.this.kmY[0] != 0)
          {
            LoginUI.this.kmY[0] = false;
            com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_login_id");
          }
          com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_login_id");
          AppMethodBeat.o(128223);
        }
      });
      this.kmT = ((Button)findViewById(2131303784));
      this.kmT.setEnabled(false);
      this.kmU = ((Button)findViewById(2131303791));
      this.kml = ((Button)findViewById(2131303779));
      this.kmV = findViewById(2131303783);
      this.kmV.setVisibility(0);
      this.klS = ((Button)findViewById(2131303796));
      this.klU = findViewById(2131301720);
      this.klT = ((Button)findViewById(2131303798));
      this.klV = ((Button)findViewById(2131303803));
      this.kmb = ((ResizeLayout)findViewById(2131307029));
      this.kmW = ((MMKeyboardUperView)findViewById(2131307332));
      this.kmb.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void bpj()
        {
          AppMethodBeat.i(128224);
          LoginUI.b(LoginUI.this);
          AppMethodBeat.o(128224);
        }
      });
      this.klS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128225);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = LoginUI.this.getString(2131762519) + LocaleUtil.getApplicationLanguage();
          LoginUI.Z(LoginUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128225);
        }
      });
      this.klT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128226);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = LoginUI.this.getString(2131760981, new Object[] { LocaleUtil.getApplicationLanguage() });
          LoginUI.Z(LoginUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128226);
        }
      });
      localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(128227);
          if (paramAnonymousm.gKQ())
          {
            paramAnonymousm.kV(5001, 2131768668);
            paramAnonymousm.kV(5002, 2131768665);
          }
          AppMethodBeat.o(128227);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).PGl = new e.b()
      {
        public final void onDismiss() {}
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).HLY = new o.g()
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
            LoginUI.Z(LoginUI.this, LoginUI.this.getString(2131768666) + LocaleUtil.getApplicationLanguage());
          }
        }
      };
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        break label721;
      }
      this.klV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128203);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          LoginUI.c(LoginUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      }, 2131689490);
      localObject = new boolean[1];
      localObject[0] = 0;
      this.kmT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128206);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (this.kmH[0] != 0) {
            this.kmH[0] = false;
          }
          for (;;)
          {
            LoginUI.f(LoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128206);
            return;
            LoginUI.a(LoginUI.this, com.tencent.mm.plugin.normsg.a.c.TN(2));
            com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_login_id", "<LoginByID>", LoginUI.e(LoginUI.this));
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_login_id", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_login_id");
          }
        }
      });
      this.kmT.setOnTouchListener(new View.OnTouchListener()
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
            this.kmH[0] = true;
            LoginUI.a(LoginUI.this, com.tencent.mm.plugin.normsg.a.c.TN(2));
            com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_login_id", "<LoginByID>", LoginUI.e(LoginUI.this));
            continue;
            com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_login_id", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_login_id");
          }
        }
      });
      this.kmU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128208);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new Intent(LoginUI.this, MobileInputUI.class);
          localObject = new int[5];
          localObject[0] = 2;
          paramAnonymousView.putExtra("mobile_input_purpose", 1);
          paramAnonymousView.putExtra("kv_report_login_method_data", (int[])localObject);
          paramAnonymousView.putExtra("from_switch_account", LoginUI.g(LoginUI.this));
          localObject = LoginUI.this;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((LoginUI)localObject).startActivity((Intent)paramAnonymousView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LoginUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128208);
        }
      });
      this.kjv = getIntent().getStringExtra("auth_ticket");
      if (!Util.isNullOrNil(this.kjv))
      {
        this.kmP.setText(Util.nullAsNil(g.bpk()));
        this.kmQ.setText(Util.nullAsNil(g.bpl()));
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128209);
            LoginUI.f(LoginUI.this);
            AppMethodBeat.o(128209);
          }
        }, 500L);
      }
      this.kmP.addTextChangedListener(this.aws);
      this.kmQ.addTextChangedListener(this.aws);
      this.kmQ.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128210);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            LoginUI.f(LoginUI.this);
            AppMethodBeat.o(128210);
            return true;
          }
          AppMethodBeat.o(128210);
          return false;
        }
      });
      this.kmQ.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128211);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.bm(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            LoginUI.f(LoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(128211);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginUI$18", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128211);
          return false;
        }
      });
      if (ChannelUtil.shouldShowGprsAlert) {
        com.tencent.mm.plugin.account.a.a.jRu.t(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.kmX = getIntent().getBooleanExtra("from_deep_link", false);
      if (!Util.isNullOrNil((String)localObject)) {
        this.kmP.setText((CharSequence)localObject);
      }
      if (!BuildInfo.EX_DEVICE_LOGIN)
      {
        if ((ao.gJH()) && (!ao.gJL())) {
          localObject = com.tencent.mm.plugin.account.model.d.kiq;
        }
      }
      else
      {
        this.kml.setVisibility(0);
        this.kml.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(128212);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.br.c.V(LoginUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginUI.this.overridePendingTransition(2130772129, 2130771986);
            com.tencent.mm.plugin.report.service.h.CyF.Ip(2L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128212);
          }
        });
      }
      AppMethodBeat.o(128234);
      return;
      this.kmR.setHint(2131762485);
      ((TextView)localObject).setText(2131762505);
      break;
      label721:
      this.klU.setVisibility(8);
      this.klV.setText(2131762500);
      this.klV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128204);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.kmu.dGm();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      this.klt.kdq = str;
      bpf();
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
        bpf();
      }
    }
    label239:
    AppMethodBeat.o(128242);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128230);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(2131100899));
    paramBundle = "";
    if ((com.tencent.mm.protocal.d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755908) + com.tencent.mm.cc.h.jr(this);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(2131100898));
    hideActionbarLine();
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
    initView();
    this.kmf = new com.tencent.mm.platformtools.b();
    this.klv = getIntent().getBooleanExtra("from_switch_account", false);
    this.klw = bf.iDu.aA("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.h.CyF.a(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    com.tencent.mm.cr.d.hiy();
    AppMethodBeat.o(128230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128233);
    if (this.kmf != null) {
      this.kmf.close();
    }
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_login_id");
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
    EventCenter.instance.removeListener(this.kkK);
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L100_100_logout") + ",2");
      AppMethodBeat.o(128232);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L400_100_login") + ",2");
    }
    AppMethodBeat.o(128232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169139);
    this.kmF.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128231);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.bwU("L100_100_logout");
      AppMethodBeat.o(128231);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.bwU("L400_100_login");
    }
    AppMethodBeat.o(128231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128239);
    Log.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramq.getType() != 252) && (paramq.getType() != 701))
    {
      AppMethodBeat.o(128239);
      return;
    }
    com.tencent.mm.kernel.g.azz().b(252, this);
    com.tencent.mm.kernel.g.azz().b(701, this);
    this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
    this.klt.kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
    this.klt.kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
    this.klt.kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
    this.klt.kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
    this.klt.account = ((com.tencent.mm.modelsimple.t)paramq).account;
    if (paramInt2 == -205)
    {
      this.kjv = ((com.tencent.mm.modelsimple.t)paramq).bbH();
      this.klX = ((com.tencent.mm.modelsimple.t)paramq).bfp();
      this.klx = ((com.tencent.mm.modelsimple.t)paramq).bfs();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128220);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128220);
            return;
          }
          paramAnonymousg = paramAnonymousg.aZh();
          com.tencent.mm.kernel.g.aAf();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128220);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.boe();
        y.St(this.klt.account);
        paramString = bf.iDu.aA("login_weixin_username", "");
        com.tencent.mm.platformtools.t.dr(this);
        if (this.klv)
        {
          ch.iFO.aR(this.klw, paramString);
          ch.iFO.h(z.aTY(), z.aUS());
          com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ch.iFO.aWp() });
        }
        y.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128221);
            Log.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(LoginUI.this);
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("kstyle_show_bind_mobile_afterauth", ((com.tencent.mm.modelsimple.t)paramq).bfq());
            ((Intent)localObject).putExtra("kstyle_bind_wording", ((com.tencent.mm.modelsimple.t)paramq).bfr());
            ((Intent)localObject).putExtra("kstyle_bind_recommend_show", ((com.tencent.mm.modelsimple.t)paramq).bft());
            LoginUI localLoginUI = LoginUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localLoginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginUI.this.finish();
            AppMethodBeat.o(128221);
          }
        }, false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.aAf();
        paramString = paramString.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_900_phone") + ",4");
        if (this.kmX)
        {
          paramString = MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.aps()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.CyF.a(11930, new Object[] { paramString, Integer.valueOf(4) });
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
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
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
          Toast.makeText(this, getString(2131762543), 0).show();
          AppMethodBeat.o(128239);
          return;
        }
        Toast.makeText(this, getString(2131762516), 0).show();
        AppMethodBeat.o(128239);
        return;
      }
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128239);
        return;
      }
      Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */