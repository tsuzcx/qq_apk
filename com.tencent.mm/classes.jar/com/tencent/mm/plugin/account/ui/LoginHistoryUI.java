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
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String dAl;
  protected ProgressDialog fpP;
  private SecurityImage ijd;
  protected int imi;
  protected String ipj;
  private com.tencent.mm.sdk.b.c iqt;
  protected View irA;
  protected View irB;
  protected View irC;
  protected Button irD;
  protected Button irE;
  private View irF;
  protected Button irG;
  protected String irH;
  protected String irI;
  private String irJ;
  private ImageView irK;
  private MMKeyboardUperView irL;
  private ResizeLayout irM;
  protected String irN;
  private String irO;
  private com.tencent.mm.platformtools.b irP;
  protected LinearLayout irQ;
  protected LinearLayout irR;
  protected LinearLayout irS;
  protected MMFormInputView irT;
  protected MMFormVerifyCodeInputView irU;
  private Button irV;
  protected boolean irW;
  private int irX;
  private int irY;
  private boolean irZ;
  protected f ird;
  protected boolean ire;
  private String irh;
  protected String iri;
  protected TextView irw;
  protected EditText irx;
  protected Button iry;
  protected Button irz;
  private String isa;
  protected int[] isb;
  private int isc;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(128117);
    this.fpP = null;
    this.ijd = null;
    this.ird = new f();
    this.dAl = "";
    this.iri = "";
    this.irW = false;
    this.irZ = false;
    this.isb = new int[5];
    this.iqt = new LoginHistoryUI.1(this);
    this.isc = 0;
    AppMethodBeat.o(128117);
  }
  
  private void CE(String paramString)
  {
    AppMethodBeat.i(128131);
    this.iri = paramString;
    aJQ();
    AppMethodBeat.o(128131);
  }
  
  private void CF(final String paramString)
  {
    AppMethodBeat.i(128132);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "requestSms %s", new Object[] { paramString });
    if (!bt.isNullOrNil(paramString))
    {
      paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      getString(2131755906);
      this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128094);
          com.tencent.mm.kernel.g.aeS().a(paramString);
          AppMethodBeat.o(128094);
        }
      });
    }
    AppMethodBeat.o(128132);
  }
  
  public static void Q(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128136);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128136);
  }
  
  private void b(s params)
  {
    AppMethodBeat.i(128134);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    Intent localIntent = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
    localIntent.addFlags(67108864);
    if (params != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", params.aAP());
      localIntent.putExtra("kstyle_bind_recommend_show", params.aAS());
      localIntent.putExtra("kstyle_bind_wording", params.aAQ());
    }
    params = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, params.adn(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)params.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(128134);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128122);
    Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
    ((Intent)localObject).addFlags(67108864);
    if (bt.isNullOrNil(this.irJ)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.jI(this);
    AppMethodBeat.o(128122);
  }
  
  private boolean n(final int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128135);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
        break label781;
      }
      if (this.ijd != null) {
        this.ijd.dismiss();
      }
      AppMethodBeat.o(128135);
      return true;
    case -3: 
      if (this.isc <= 0)
      {
        com.tencent.mm.ui.base.h.j(this, 2131758459, 2131760766);
        this.isc += 1;
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.ui.base.h.d(this, getString(2131758460), getString(2131760766), getString(2131758461), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128099);
            LoginHistoryUI.h(LoginHistoryUI.this);
            AppMethodBeat.o(128099);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128100);
            LoginHistoryUI.i(LoginHistoryUI.this);
            AppMethodBeat.o(128100);
          }
        });
      }
    case -1: 
      if (com.tencent.mm.kernel.g.aeS().auR() == 5)
      {
        com.tencent.mm.ui.base.h.j(this, 2131761537, 2131761536);
        AppMethodBeat.o(128135);
        return true;
      }
    case -9: 
      com.tencent.mm.ui.base.h.j(this, 2131760765, 2131760766);
      AppMethodBeat.o(128135);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.j(this, 2131762374, 2131755906);
      AppMethodBeat.o(128135);
      return true;
    case -75: 
      y.cV(this);
      AppMethodBeat.o(128135);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.d(this, getString(2131756510), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
      return true;
    case -33: 
      com.tencent.mm.ui.base.h.a(this, 2131756508, 2131756514, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
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
            int i = -1;
            AppMethodBeat.i(128102);
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.ird.ijg + " img len" + LoginHistoryUI.this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
            int j = paramInt1;
            if (LoginHistoryUI.this.iri == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = bt.aGs(LoginHistoryUI.this.iri);
              if (LoginHistoryUI.this.ird.ije != null) {
                break label379;
              }
            }
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bt.aGs(LoginHistoryUI.this.ird.ije) });
              paramAnonymousDialogInterface = new s(LoginHistoryUI.this.ird.account, LoginHistoryUI.this.ird.ije, LoginHistoryUI.this.ird.iss, LoginHistoryUI.j(LoginHistoryUI.this).getSecImgCode(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgSid(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((bt.isNullOrNil(LoginHistoryUI.this.ird.ije)) && (!bt.isNullOrNil(LoginHistoryUI.this.iri)))
              {
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bt.aGs(LoginHistoryUI.this.iri) });
                paramAnonymousDialogInterface.zc(LoginHistoryUI.this.iri);
              }
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(2131755906);
              localLoginHistoryUI1.fpP = com.tencent.mm.ui.base.h.b(localLoginHistoryUI2, LoginHistoryUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128101);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aeS().b(701, LoginHistoryUI.this);
                  com.tencent.mm.kernel.g.aeS().b(252, LoginHistoryUI.this);
                  AppMethodBeat.o(128101);
                }
              });
              AppMethodBeat.o(128102);
              return;
              paramAnonymousInt = LoginHistoryUI.this.iri.length();
              break;
              label379:
              i = LoginHistoryUI.this.ird.ije.length();
            }
          }
        }, null, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128103);
            LoginHistoryUI.k(LoginHistoryUI.this);
            AppMethodBeat.o(128103);
          }
        }, this.ird);
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.ird.ijg + " img len" + this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
        this.ijd.b(this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      com.tencent.mm.kernel.g.afz();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
      for (paramString = com.tencent.mm.cd.a.aq(this, 2131761063);; paramString = com.tencent.mm.kernel.a.aeq())
      {
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.kernel.g.afz();
      }
    case -205: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aGs(this.ipj), this.irh });
      f.a(this.ird);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.ipj);
      paramString.putExtra("binded_mobile", this.irI);
      paramString.putExtra("close_safe_device_style", this.irh);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.a.a.hYt.g(this, paramString);
      AppMethodBeat.o(128135);
      return true;
    }
    if (!bt.isNullOrNil(this.dAl)) {
      y.m(this, paramString, this.dAl);
    }
    AppMethodBeat.o(128135);
    return true;
    label781:
    paramString = new com.tencent.mm.platformtools.ad(paramInt1, paramInt2, paramString);
    boolean bool = this.irP.a(this, paramString);
    AppMethodBeat.o(128135);
    return bool;
  }
  
  protected final String CD(String paramString)
  {
    AppMethodBeat.i(128125);
    new ba();
    String str1 = "86";
    Object localObject = paramString;
    if (this.irN.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = ba.aew(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = ba.formatNumber(str1, (String)localObject);
    AppMethodBeat.o(128125);
    return paramString;
  }
  
  protected void aJQ()
  {
    AppMethodBeat.i(128128);
    this.ird.account = this.irN.trim();
    AppMethodBeat.o(128128);
  }
  
  protected final void aJR()
  {
    AppMethodBeat.i(128126);
    com.tencent.mm.kernel.g.aeS().a(701, this);
    com.tencent.mm.kernel.g.aeS().a(252, this);
    AppMethodBeat.o(128126);
  }
  
  protected final void aJS()
  {
    AppMethodBeat.i(128127);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    AppMethodBeat.o(128127);
  }
  
  public boolean aJT()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131494603;
  }
  
  public void hideVKB()
  {
    AppMethodBeat.i(128129);
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(128129);
      return;
    }
    Object localObject = getCurrentFocus();
    if (localObject == null)
    {
      AppMethodBeat.o(128129);
      return;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      AppMethodBeat.o(128129);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
    AppMethodBeat.o(128129);
  }
  
  public void initView()
  {
    AppMethodBeat.i(128124);
    this.irQ = ((LinearLayout)findViewById(2131306510));
    this.irS = ((LinearLayout)findViewById(2131299699));
    this.irR = ((LinearLayout)findViewById(2131300089));
    this.irT = ((MMFormInputView)findViewById(2131301578));
    this.irU = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.irJ = getIntent().getStringExtra("switch_login_wx_id");
    if (!bt.isNullOrNil(this.irJ))
    {
      this.irN = ca.gPq.getString(this.irJ, "login_user_name");
      this.irO = ca.gPq.getString(this.irJ, "last_avatar_path");
      this.irY = bt.aGh(ca.gPq.getString(this.irJ, "last_bind_info"));
      if ((this.irY & 0x1) != 0) {
        this.irH = ca.gPq.getString(this.irJ, "last_login_bind_qq");
      }
      if ((this.irY & 0x4) != 0) {
        this.irI = ca.gPq.getString(this.irJ, "last_login_bind_mobile");
      }
      this.irX = bt.aGh(ca.gPq.getString(this.irJ, "last_login_use_voice"));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128110);
          LoginHistoryUI.b(LoginHistoryUI.this);
          AppMethodBeat.o(128110);
          return true;
        }
      }, 2131689488);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.irN))) {
        this.irN = ((String)localObject);
      }
      this.irK = ((ImageView)findViewById(2131301310));
      if (!bt.isNullOrNil(this.irO)) {}
      try
      {
        localObject = com.tencent.mm.ak.e.vY(this.irO);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.irK.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
          continue;
          this.isb[2] = 2;
          this.irw.setText(this.irN);
          continue;
          if (!ac.eFr())
          {
            this.irG.setText(2131766189);
            this.irG.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(128091);
                LoginHistoryUI.Q(LoginHistoryUI.this, LoginHistoryUI.this.getString(2131766190) + ac.eFu());
                AppMethodBeat.o(128091);
              }
            });
          }
          else
          {
            this.irG.setText(2131766192);
            this.irG.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(128092);
                LoginHistoryUI.f(LoginHistoryUI.this);
                AppMethodBeat.o(128092);
              }
            });
          }
        }
      }
      this.irL = ((MMKeyboardUperView)findViewById(2131304370));
      this.irw = ((TextView)findViewById(2131301558));
      this.irx = this.irT.getContentEditText();
      this.iry = ((Button)findViewById(2131301562));
      this.irA = findViewById(2131301583);
      this.irB = findViewById(2131301571);
      this.irC = ((Button)findViewById(2131304798));
      this.irz = ((Button)findViewById(2131301570));
      this.irV = ((Button)findViewById(2131301559));
      this.irD = ((Button)findViewById(2131301572));
      this.irE = ((Button)findViewById(2131301574));
      this.irF = findViewById(2131300241);
      this.irG = ((Button)findViewById(2131301575));
      this.irD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128111);
          paramAnonymousView = LoginHistoryUI.this.getString(2131760769) + ac.eFu();
          LoginHistoryUI.Q(LoginHistoryUI.this, paramAnonymousView);
          AppMethodBeat.o(128111);
        }
      });
      this.irE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128112);
          paramAnonymousView = LoginHistoryUI.this.getString(2131759660, new Object[] { ac.eFu() });
          LoginHistoryUI.Q(LoginHistoryUI.this, paramAnonymousView);
          AppMethodBeat.o(128112);
        }
      });
      if (!ac.eFr()) {
        this.irF.setVisibility(8);
      }
      this.irT.setVisibility(8);
      this.irQ.setVisibility(8);
      this.irS.setVisibility(8);
      this.irR.setVisibility(8);
      this.iry.setVisibility(8);
      this.irA.setVisibility(8);
      this.irB.setVisibility(8);
      this.irC.setVisibility(8);
      this.irz.setVisibility(8);
      com.tencent.mm.ui.tools.b.c.d(this.irx).jE(4, 16).a(null);
      this.irM = ((ResizeLayout)findViewById(2131304133));
      if ((!bt.aGq(this.irN).booleanValue()) || (this.irN.equals(this.irH))) {
        break;
      }
      this.isb[2] = 1;
      this.irw.setText(CD(this.irN));
      this.irM.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void aJU()
        {
          AppMethodBeat.i(128114);
          LoginHistoryUI.c(LoginHistoryUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128113);
              LoginHistoryUI.c(LoginHistoryUI.this).fullScroll(130);
              AppMethodBeat.o(128113);
            }
          });
          AppMethodBeat.o(128114);
        }
      });
      this.irL.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(128115);
          LoginHistoryUI.this.hideVKB();
          AppMethodBeat.o(128115);
          return false;
        }
      });
      localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(128116);
          if (paramAnonymousl.size() == 0)
          {
            paramAnonymousl.jj(7002, 2131760759);
            paramAnonymousl.jj(7003, 2131760345);
            paramAnonymousl.jj(7004, 2131766192);
            if (!ac.eFr()) {
              paramAnonymousl.jj(7009, 2131766189);
            }
          }
          AppMethodBeat.o(128116);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(128089);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(128089);
            return;
            LoginHistoryUI.d(LoginHistoryUI.this);
            AppMethodBeat.o(128089);
            return;
            LoginHistoryUI.e(LoginHistoryUI.this);
            AppMethodBeat.o(128089);
            return;
            LoginHistoryUI.f(LoginHistoryUI.this);
            AppMethodBeat.o(128089);
            return;
            LoginHistoryUI.Q(LoginHistoryUI.this, LoginHistoryUI.this.getString(2131766190) + ac.eFu());
          }
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).GHn = new e.b()
      {
        public final void onDismiss() {}
      };
      if (!bt.isNullOrNil(this.irJ)) {
        break label1058;
      }
      this.irG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128090);
          LoginHistoryUI.this.hideVKB();
          this.ise.csG();
          AppMethodBeat.o(128090);
        }
      });
      setMMTitle("");
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (i.ETy) {
        com.tencent.mm.plugin.account.a.a.hYu.t(this);
      }
      if (com.tencent.mm.sdk.platformtools.h.EX_DEVICE_LOGIN)
      {
        this.irV.setVisibility(0);
        this.irV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(128093);
            com.tencent.mm.bs.d.O(LoginHistoryUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginHistoryUI.this.overridePendingTransition(2130772105, 2130771986);
            AppMethodBeat.o(128093);
          }
        });
      }
      AppMethodBeat.o(128124);
      return;
      this.irN = ay.gNa.ao("login_user_name", "");
      this.irO = ay.gNa.arN();
      this.irY = bt.aGh(ay.gNa.ao("last_bind_info", ""));
      if ((this.irY & 0x1) != 0) {
        this.irH = ay.gNa.ao("last_login_bind_qq", "");
      }
      if ((this.irY & 0x4) != 0) {
        this.irI = ay.gNa.ao("last_login_bind_mobile", "");
      }
      this.irX = bt.aGh(ay.gNa.ao("last_login_use_voice", ""));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(128130);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label174;
      }
      if (paramInt2 != -1) {
        break label311;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bt.isNullOrNil(str);
      if (!bt.isNullOrNil(str)) {
        break label165;
      }
    }
    label165:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      CE(str);
      AppMethodBeat.o(128130);
      return;
      bool = false;
      break;
    }
    label174:
    if ((paramInt1 == 1025) && (paramIntent != null))
    {
      if (paramInt2 == 2)
      {
        paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
        bool = bt.isNullOrNil(paramIntent);
        if (bt.isNullOrNil(paramIntent)) {}
        for (paramInt1 = j;; paramInt1 = paramIntent.length())
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          CE(paramIntent);
          AppMethodBeat.o(128130);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        aJQ();
      }
    }
    label311:
    AppMethodBeat.o(128130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.a.a.hYu });
    com.tencent.mm.plugin.account.a.a.hYu.Lo();
    this.sp = aj.getContext().getSharedPreferences(aj.eFD(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.irZ = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.irZ = this.irZ;
      if (this.irZ) {
        this.isa = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.irP = new com.tencent.mm.platformtools.b();
    AppMethodBeat.o(128118);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128119);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    if (this.irP != null) {
      this.irP.close();
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(14262, new Object[] { Integer.valueOf(this.isb[0]), Integer.valueOf(this.isb[1]), Integer.valueOf(this.isb[2]), Integer.valueOf(this.isb[3]), Integer.valueOf(this.isb[4]) });
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    super.onDestroy();
    AppMethodBeat.o(128119);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128123);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      goBack();
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128123);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128121);
    super.onPause();
    com.tencent.mm.sdk.b.a.ESL.d(this.iqt);
    AppMethodBeat.o(128121);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128120);
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((aJT()) && (this.imi != 1) && ((this.irX & 0x20000) != 0))
    {
      localObject2 = new m(this, 7001, 0);
      ((m)localObject2).setTitle(2131760779);
      ((List)localObject1).add(localObject2);
    }
    if ((this.imi != 5) && ((this.irX & 0x40000) != 0))
    {
      localObject2 = new m(this, 7005, 0);
      ((m)localObject2).setTitle(2131760776);
      ((List)localObject1).add(localObject2);
    }
    if (!bt.isNullOrNil(this.irN))
    {
      if (this.imi != 2)
      {
        localObject2 = new m(this, 7007, 0);
        ((m)localObject2).setTitle(getString(2131760777));
        ((List)localObject1).add(localObject2);
      }
      if ((!bt.isNullOrNil(this.irI)) && (this.imi != 3))
      {
        localObject2 = new m(this, 7008, 0);
        ((m)localObject2).setTitle(getString(2131760778));
        ((List)localObject1).add(localObject2);
      }
      if (this.irN.equalsIgnoreCase(this.irH)) {
        this.irx.setHint(getString(2131762380));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject2).HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(128105);
          if (paramAnonymousl.size() == 0)
          {
            Iterator localIterator = this.isg.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousl.g((m)localIterator.next());
            }
          }
          AppMethodBeat.o(128105);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject2).HrY = new LoginHistoryUI.24(this);
      ((com.tencent.mm.ui.widget.a.e)localObject2).GHn = new e.b()
      {
        public final void onDismiss() {}
      };
      this.irz.setVisibility(0);
      this.irz.setText(2131760758);
      this.irz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128107);
          LoginHistoryUI.this.hideVKB();
          this.ise.csG();
          AppMethodBeat.o(128107);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ESL.c(this.iqt);
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.kernel.a.aeN();
      if ((!com.tencent.mm.kernel.g.afw()) || (!com.tencent.mm.kernel.g.afz().gcn) || (this.irN.equals(""))) {
        break label492;
      }
      if ((this.fpP == null) || (!this.fpP.isShowing())) {
        break;
      }
      AppMethodBeat.o(128120);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.irz.setVisibility(0);
        this.irz.setText(((m)((List)localObject1).get(0)).getTitle());
        this.irz.setOnClickListener(new LoginHistoryUI.27(this, (List)localObject1));
      }
      else
      {
        this.irz.setVisibility(8);
      }
    }
    b(null);
    AppMethodBeat.o(128120);
    return;
    label492:
    if (com.tencent.mm.q.a.aac() == 2)
    {
      localObject1 = new d.a(this);
      ((d.a)localObject1).aau(2131757340);
      ((d.a)localObject1).aMg(getString(2131757339));
      ((d.a)localObject1).wX(false);
      ((d.a)localObject1).aaB(2131757337).b(new LoginHistoryUI.22(this));
      ((d.a)localObject1).fft().show();
      com.tencent.mm.q.a.b(this, System.currentTimeMillis());
    }
    AppMethodBeat.o(128120);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128133);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "Scene Type " + paramn.getType());
    com.tencent.mm.h.a locala;
    if (paramn.getType() == 145)
    {
      if ((this.fpP != null) && (this.fpP.isShowing()))
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramn).JJ();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          locala = com.tencent.mm.h.a.oG(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).axC() != 1) {
            break label231;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
          if (locala != null)
          {
            locala.a(this, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128095);
                LoginHistoryUI.g(LoginHistoryUI.this);
                AppMethodBeat.o(128095);
              }
            }, null);
            AppMethodBeat.o(128133);
            return;
          }
          com.tencent.mm.ui.base.h.a(this, getString(2131760761), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128096);
              LoginHistoryUI.g(LoginHistoryUI.this);
              AppMethodBeat.o(128096);
            }
          }, null);
        }
      }
    }
    while (n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128133);
      return;
      label231:
      if (locala != null)
      {
        locala.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128097);
            LoginHistoryUI.this.irU.blz();
            LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.irI);
            AppMethodBeat.o(128097);
          }
        }, null);
        AppMethodBeat.o(128133);
        return;
      }
      this.irU.blz();
      CF(this.irI);
      continue;
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.j(this, 2131762328, 2131762329);
          this.irU.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131755265), "", true);
          this.irU.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -106)
        {
          y.g(this, paramString, 32045);
          this.irU.reset();
          AppMethodBeat.o(128133);
        }
      }
      else if (i == 17)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              LoginHistoryUI.this.fpP = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).axy(), this.irI).a(this);
          AppMethodBeat.o(128133);
          return;
        }
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128133);
          return;
        }
        paramn = com.tencent.mm.h.a.oG(paramString);
        if (paramn != null)
        {
          paramn.a(this, null, null);
          continue;
          if ((paramn.getType() == 252) || (paramn.getType() == 701))
          {
            this.dAl = ((s)paramn).aAJ();
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LoginHistoryUI", "url " + this.dAl);
            com.tencent.mm.kernel.g.aeS().b(701, this);
            com.tencent.mm.kernel.g.aeS().b(252, this);
            this.ird.iss = ((s)paramn).getSecCodeType();
            this.ird.ijg = ((s)paramn).aAK();
            this.ird.ijf = ((s)paramn).aAL();
            this.ird.ijh = ((s)paramn).aAM();
            if (paramInt2 == -205)
            {
              this.ipj = ((s)paramn).axA();
              this.irI = ((s)paramn).aAO();
              this.irh = ((s)paramn).aAR();
            }
            if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
              break label1096;
            }
            com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
            {
              public final void a(com.tencent.mm.network.e paramAnonymouse)
              {
                AppMethodBeat.i(128098);
                if (paramAnonymouse == null)
                {
                  AppMethodBeat.o(128098);
                  return;
                }
                paramAnonymouse = paramAnonymouse.avg();
                com.tencent.mm.kernel.g.afz();
                int i = com.tencent.mm.kernel.a.getUin();
                paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
                AppMethodBeat.o(128098);
              }
            }), 0);
          }
        }
      }
    }
    label1096:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aIQ();
        t.cN(this);
        y.BD(this.ird.account);
        if ((this.fpP != null) && (this.fpP.isShowing())) {
          this.fpP.setMessage(getString(2131755804));
        }
        b((s)paramn);
        if (this.imi == 3)
        {
          this.ire = ((s)paramn).aAT();
          if (((s)paramn).aAN())
          {
            boolean bool = this.ire;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131763302));
            paramString.putExtra("kintent_cancelable", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128133);
        return;
      }
      if ((this.fpP != null) && (this.fpP.isShowing()))
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 31685);
        AppMethodBeat.o(128133);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128133);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128133);
        return;
      }
      paramn = com.tencent.mm.h.a.oG(paramString);
      if ((paramn != null) && (paramn.a(this, null, null)))
      {
        AppMethodBeat.o(128133);
        return;
      }
      Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128133);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */