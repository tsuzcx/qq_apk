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
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.cd;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String dLz;
  protected ProgressDialog fOC;
  private SecurityImage jfm;
  protected int jir;
  protected String jlr;
  private com.tencent.mm.sdk.b.c jmB;
  protected TextView jnD;
  protected EditText jnE;
  protected Button jnF;
  protected Button jnG;
  protected View jnH;
  protected View jnI;
  protected View jnJ;
  protected Button jnK;
  protected Button jnL;
  private View jnM;
  protected Button jnN;
  protected String jnO;
  protected String jnP;
  private String jnQ;
  private ImageView jnR;
  private MMKeyboardUperView jnS;
  private ResizeLayout jnT;
  protected String jnU;
  private String jnV;
  private com.tencent.mm.platformtools.b jnW;
  protected LinearLayout jnX;
  protected LinearLayout jnY;
  protected LinearLayout jnZ;
  protected f jnl;
  protected boolean jnm;
  private String jnp;
  protected String jnq;
  protected MMFormInputView joa;
  protected MMFormVerifyCodeInputView job;
  private Button joc;
  protected boolean jod;
  private int joe;
  private int jof;
  private boolean jog;
  private String joh;
  protected int[] joi;
  private int joj;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(128117);
    this.fOC = null;
    this.jfm = null;
    this.jnl = new f();
    this.dLz = "";
    this.jnq = "";
    this.jod = false;
    this.jog = false;
    this.joi = new int[5];
    this.jmB = new LoginHistoryUI.1(this);
    this.joj = 0;
    AppMethodBeat.o(128117);
  }
  
  private void Kv(String paramString)
  {
    AppMethodBeat.i(128131);
    this.jnq = paramString;
    aUs();
    AppMethodBeat.o(128131);
  }
  
  private void Kw(String paramString)
  {
    AppMethodBeat.i(128132);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "requestSms %s", new Object[] { paramString });
    if (!bu.isNullOrNil(paramString))
    {
      paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
      com.tencent.mm.kernel.g.ajj().a(paramString, 0);
      getString(2131755906);
      this.fOC = h.b(this, getString(2131755936), true, new LoginHistoryUI.8(this, paramString));
    }
    AppMethodBeat.o(128132);
  }
  
  public static void R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128136);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128136);
  }
  
  private void b(com.tencent.mm.modelsimple.t paramt)
  {
    AppMethodBeat.i(128134);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    Intent localIntent = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
    localIntent.addFlags(67108864);
    if (paramt != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramt.aLn());
      localIntent.putExtra("kstyle_bind_recommend_show", paramt.aLq());
      localIntent.putExtra("kstyle_bind_wording", paramt.aLo());
    }
    paramt = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramt.ahE(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramt.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(128134);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128122);
    Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
    ((Intent)localObject).addFlags(67108864);
    if (bu.isNullOrNil(this.jnQ)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.kl(this);
    AppMethodBeat.o(128122);
  }
  
  private boolean n(final int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128135);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.a.a.iUA.a(this, paramInt1, paramInt2, paramString)) {
        break label781;
      }
      if (this.jfm != null) {
        this.jfm.dismiss();
      }
      AppMethodBeat.o(128135);
      return true;
    case -3: 
      if (this.joj <= 0)
      {
        h.l(this, 2131758459, 2131760766);
        this.joj += 1;
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        h.e(this, getString(2131758460), getString(2131760766), getString(2131758461), getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
      {
        h.l(this, 2131761537, 2131761536);
        AppMethodBeat.o(128135);
        return true;
      }
    case -9: 
      h.l(this, 2131760765, 2131760766);
      AppMethodBeat.o(128135);
      return true;
    case -72: 
      h.l(this, 2131762374, 2131755906);
      AppMethodBeat.o(128135);
      return true;
    case -75: 
      y.de(this);
      AppMethodBeat.o(128135);
      return true;
    case -32: 
      h.d(this, getString(2131756510), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
      return true;
    case -33: 
      h.a(this, 2131756508, 2131756514, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
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
            int i = -1;
            AppMethodBeat.i(128102);
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.jnl.jfp + " img len" + LoginHistoryUI.this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
            int j = paramInt1;
            if (LoginHistoryUI.this.jnq == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = bu.aSM(LoginHistoryUI.this.jnq);
              if (LoginHistoryUI.this.jnl.jfn != null) {
                break label379;
              }
            }
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bu.aSM(LoginHistoryUI.this.jnl.jfn) });
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginHistoryUI.this.jnl.account, LoginHistoryUI.this.jnl.jfn, LoginHistoryUI.this.jnl.joz, LoginHistoryUI.j(LoginHistoryUI.this).getSecImgCode(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgSid(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((bu.isNullOrNil(LoginHistoryUI.this.jnl.jfn)) && (!bu.isNullOrNil(LoginHistoryUI.this.jnq)))
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bu.aSM(LoginHistoryUI.this.jnq) });
                paramAnonymousDialogInterface.GO(LoginHistoryUI.this.jnq);
              }
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(2131755906);
              localLoginHistoryUI1.fOC = h.b(localLoginHistoryUI2, LoginHistoryUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128101);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.ajj().b(701, LoginHistoryUI.this);
                  com.tencent.mm.kernel.g.ajj().b(252, LoginHistoryUI.this);
                  AppMethodBeat.o(128101);
                }
              });
              AppMethodBeat.o(128102);
              return;
              paramAnonymousInt = LoginHistoryUI.this.jnq.length();
              break;
              label379:
              i = LoginHistoryUI.this.jnl.jfn.length();
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
        }, this.jnl);
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.jnl.jfp + " img len" + this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
        this.jfm.b(this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      com.tencent.mm.kernel.g.ajP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
      for (paramString = com.tencent.mm.cb.a.az(this, 2131761063);; paramString = com.tencent.mm.kernel.a.aiH())
      {
        h.a(this, paramString, getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.kernel.g.ajP();
      }
    case -205: 
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bu.aSM(this.jlr), this.jnp });
      f.a(this.jnl);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.jlr);
      paramString.putExtra("binded_mobile", this.jnP);
      paramString.putExtra("close_safe_device_style", this.jnp);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.a.a.iUz.g(this, paramString);
      AppMethodBeat.o(128135);
      return true;
    }
    if (!bu.isNullOrNil(this.dLz)) {
      y.n(this, paramString, this.dLz);
    }
    AppMethodBeat.o(128135);
    return true;
    label781:
    paramString = new com.tencent.mm.platformtools.ae(paramInt1, paramInt2, paramString);
    boolean bool = this.jnW.a(this, paramString);
    AppMethodBeat.o(128135);
    return bool;
  }
  
  protected final String Ku(String paramString)
  {
    AppMethodBeat.i(128125);
    new com.tencent.mm.sdk.platformtools.bb();
    String str1 = "86";
    Object localObject = paramString;
    if (this.jnU.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = com.tencent.mm.sdk.platformtools.bb.apd(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = com.tencent.mm.sdk.platformtools.bb.formatNumber(str1, (String)localObject);
    AppMethodBeat.o(128125);
    return paramString;
  }
  
  protected void aUs()
  {
    AppMethodBeat.i(128128);
    this.jnl.account = this.jnU.trim();
    AppMethodBeat.o(128128);
  }
  
  protected final void aUt()
  {
    AppMethodBeat.i(128126);
    com.tencent.mm.kernel.g.ajj().a(701, this);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    AppMethodBeat.o(128126);
  }
  
  protected final void aUu()
  {
    AppMethodBeat.i(128127);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    AppMethodBeat.o(128127);
  }
  
  public boolean aUv()
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
    this.jnX = ((LinearLayout)findViewById(2131306510));
    this.jnZ = ((LinearLayout)findViewById(2131299699));
    this.jnY = ((LinearLayout)findViewById(2131300089));
    this.joa = ((MMFormInputView)findViewById(2131301578));
    this.job = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.jnQ = getIntent().getStringExtra("switch_login_wx_id");
    if (!bu.isNullOrNil(this.jnQ))
    {
      this.jnU = cd.hLa.getString(this.jnQ, "login_user_name");
      this.jnV = cd.hLa.getString(this.jnQ, "last_avatar_path");
      this.jof = bu.aSB(cd.hLa.getString(this.jnQ, "last_bind_info"));
      if ((this.jof & 0x1) != 0) {
        this.jnO = cd.hLa.getString(this.jnQ, "last_login_bind_qq");
      }
      if ((this.jof & 0x4) != 0) {
        this.jnP = cd.hLa.getString(this.jnQ, "last_login_bind_mobile");
      }
      this.joe = bu.aSB(cd.hLa.getString(this.jnQ, "last_login_use_voice"));
      setBackBtn(new LoginHistoryUI.29(this), 2131689488);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.jnU))) {
        this.jnU = ((String)localObject);
      }
      this.jnR = ((ImageView)findViewById(2131301310));
      if (!bu.isNullOrNil(this.jnV)) {}
      try
      {
        localObject = com.tencent.mm.aj.e.DF(this.jnV);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.jnR.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
          continue;
          this.joi[2] = 2;
          this.jnD.setText(this.jnU);
          continue;
          if (!ad.foj())
          {
            this.jnN.setText(2131766189);
            this.jnN.setOnClickListener(new LoginHistoryUI.5(this));
          }
          else
          {
            this.jnN.setText(2131766192);
            this.jnN.setOnClickListener(new LoginHistoryUI.6(this));
          }
        }
      }
      this.jnS = ((MMKeyboardUperView)findViewById(2131304370));
      this.jnD = ((TextView)findViewById(2131301558));
      this.jnE = this.joa.getContentEditText();
      this.jnF = ((Button)findViewById(2131301562));
      this.jnH = findViewById(2131301583);
      this.jnI = findViewById(2131301571);
      this.jnJ = ((Button)findViewById(2131304798));
      this.jnG = ((Button)findViewById(2131301570));
      this.joc = ((Button)findViewById(2131301559));
      this.jnK = ((Button)findViewById(2131301572));
      this.jnL = ((Button)findViewById(2131301574));
      this.jnM = findViewById(2131300241);
      this.jnN = ((Button)findViewById(2131301575));
      this.jnK.setOnClickListener(new LoginHistoryUI.30(this));
      this.jnL.setOnClickListener(new LoginHistoryUI.31(this));
      if (!ad.foj()) {
        this.jnM.setVisibility(8);
      }
      this.joa.setVisibility(8);
      this.jnX.setVisibility(8);
      this.jnZ.setVisibility(8);
      this.jnY.setVisibility(8);
      this.jnF.setVisibility(8);
      this.jnH.setVisibility(8);
      this.jnI.setVisibility(8);
      this.jnJ.setVisibility(8);
      this.jnG.setVisibility(8);
      com.tencent.mm.ui.tools.b.c.d(this.jnE).kj(4, 16).a(null);
      this.jnT = ((ResizeLayout)findViewById(2131304133));
      if ((!bu.aSK(this.jnU).booleanValue()) || (this.jnU.equals(this.jnO))) {
        break;
      }
      this.joi[2] = 1;
      this.jnD.setText(Ku(this.jnU));
      this.jnT.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void aUw()
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
      this.jnS.setOnTouchListener(new LoginHistoryUI.33(this));
      localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(128116);
          if (paramAnonymousl.size() == 0)
          {
            paramAnonymousl.jM(7002, 2131760759);
            paramAnonymousl.jM(7003, 2131760345);
            paramAnonymousl.jM(7004, 2131766192);
            if (!ad.foj()) {
              paramAnonymousl.jM(7009, 2131766189);
            }
          }
          AppMethodBeat.o(128116);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).LfT = new LoginHistoryUI.2(this);
      ((com.tencent.mm.ui.widget.a.e)localObject).KtV = new LoginHistoryUI.3(this);
      if (!bu.isNullOrNil(this.jnQ)) {
        break label1058;
      }
      this.jnN.setOnClickListener(new LoginHistoryUI.4(this, (com.tencent.mm.ui.widget.a.e)localObject));
      setMMTitle("");
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (k.IwK) {
        com.tencent.mm.plugin.account.a.a.iUA.t(this);
      }
      if (j.EX_DEVICE_LOGIN)
      {
        this.joc.setVisibility(0);
        this.joc.setOnClickListener(new LoginHistoryUI.7(this));
      }
      AppMethodBeat.o(128124);
      return;
      this.jnU = com.tencent.mm.model.bb.hIK.ay("login_user_name", "");
      this.jnV = com.tencent.mm.model.bb.hIK.aBY();
      this.jof = bu.aSB(com.tencent.mm.model.bb.hIK.ay("last_bind_info", ""));
      if ((this.jof & 0x1) != 0) {
        this.jnO = com.tencent.mm.model.bb.hIK.ay("last_login_bind_qq", "");
      }
      if ((this.jof & 0x4) != 0) {
        this.jnP = com.tencent.mm.model.bb.hIK.ay("last_login_bind_mobile", "");
      }
      this.joe = bu.aSB(com.tencent.mm.model.bb.hIK.ay("last_login_use_voice", ""));
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label174;
      }
      if (paramInt2 != -1) {
        break label311;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bu.isNullOrNil(str);
      if (!bu.isNullOrNil(str)) {
        break label165;
      }
    }
    label165:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Kv(str);
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
        bool = bu.isNullOrNil(paramIntent);
        if (bu.isNullOrNil(paramIntent)) {}
        for (paramInt1 = j;; paramInt1 = paramIntent.length())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          Kv(paramIntent);
          AppMethodBeat.o(128130);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        aUs();
      }
    }
    label311:
    AppMethodBeat.o(128130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.a.a.iUA });
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    this.sp = ak.getContext().getSharedPreferences(ak.fow(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jog = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.jog = this.jog;
      if (this.jog) {
        this.joh = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.jnW = new com.tencent.mm.platformtools.b();
    AppMethodBeat.o(128118);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128119);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    if (this.jnW != null) {
      this.jnW.close();
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(14262, new Object[] { Integer.valueOf(this.joi[0]), Integer.valueOf(this.joi[1]), Integer.valueOf(this.joi[2]), Integer.valueOf(this.joi[3]), Integer.valueOf(this.joi[4]) });
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
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
    com.tencent.mm.sdk.b.a.IvT.d(this.jmB);
    AppMethodBeat.o(128121);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128120);
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((aUv()) && (this.jir != 1) && ((this.joe & 0x20000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7001, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(2131760779);
      ((List)localObject1).add(localObject2);
    }
    if ((this.jir != 5) && ((this.joe & 0x40000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7005, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(2131760776);
      ((List)localObject1).add(localObject2);
    }
    if (!bu.isNullOrNil(this.jnU))
    {
      if (this.jir != 2)
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7007, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(2131760777));
        ((List)localObject1).add(localObject2);
      }
      if ((!bu.isNullOrNil(this.jnP)) && (this.jir != 3))
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7008, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(2131760778));
        ((List)localObject1).add(localObject2);
      }
      if (this.jnU.equalsIgnoreCase(this.jnO)) {
        this.jnE.setHint(getString(2131762380));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject2).LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(128105);
          if (paramAnonymousl.size() == 0)
          {
            Iterator localIterator = this.jon.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousl.g((com.tencent.mm.ui.base.m)localIterator.next());
            }
          }
          AppMethodBeat.o(128105);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject2).LfT = new LoginHistoryUI.24(this);
      ((com.tencent.mm.ui.widget.a.e)localObject2).KtV = new e.b()
      {
        public final void onDismiss() {}
      };
      this.jnG.setVisibility(0);
      this.jnG.setText(2131760758);
      this.jnG.setOnClickListener(new LoginHistoryUI.26(this, (com.tencent.mm.ui.widget.a.e)localObject2));
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.c(this.jmB);
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.kernel.a.aje();
      if ((!com.tencent.mm.kernel.g.ajM()) || (!com.tencent.mm.kernel.g.ajP().gDk) || (this.jnU.equals(""))) {
        break label492;
      }
      if ((this.fOC == null) || (!this.fOC.isShowing())) {
        break;
      }
      AppMethodBeat.o(128120);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.jnG.setVisibility(0);
        this.jnG.setText(((com.tencent.mm.ui.base.m)((List)localObject1).get(0)).getTitle());
        this.jnG.setOnClickListener(new LoginHistoryUI.27(this, (List)localObject1));
      }
      else
      {
        this.jnG.setVisibility(8);
      }
    }
    b(null);
    AppMethodBeat.o(128120);
    return;
    label492:
    if (com.tencent.mm.q.a.adN() == 2)
    {
      localObject1 = new d.a(this);
      ((d.a)localObject1).afN(2131757340);
      ((d.a)localObject1).aZi(getString(2131757339));
      ((d.a)localObject1).zf(false);
      ((d.a)localObject1).afU(2131757337).c(new LoginHistoryUI.22(this));
      ((d.a)localObject1).fQv().show();
      com.tencent.mm.q.a.b(this, System.currentTimeMillis());
    }
    AppMethodBeat.o(128120);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128133);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "Scene Type " + paramn.getType());
    com.tencent.mm.h.a locala;
    if (paramn.getType() == 145)
    {
      if ((this.fOC != null) && (this.fOC.isShowing()))
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramn).KZ();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          locala = com.tencent.mm.h.a.uU(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).aHQ() != 1) {
            break label231;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
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
          h.a(this, getString(2131760761), "", new DialogInterface.OnClickListener()
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
            LoginHistoryUI.this.job.bxk();
            LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.jnP);
            AppMethodBeat.o(128097);
          }
        }, null);
        AppMethodBeat.o(128133);
        return;
      }
      this.job.bxk();
      Kw(this.jnP);
      continue;
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          h.l(this, 2131762328, 2131762329);
          this.job.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -75)
        {
          h.c(this, getString(2131755265), "", true);
          this.job.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -106)
        {
          y.g(this, paramString, 32045);
          this.job.reset();
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
              LoginHistoryUI.this.fOC = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHM(), this.jnP).b(this);
          AppMethodBeat.o(128133);
          return;
        }
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128133);
          return;
        }
        paramn = com.tencent.mm.h.a.uU(paramString);
        if (paramn != null)
        {
          paramn.a(this, null, null);
          continue;
          if ((paramn.getType() == 252) || (paramn.getType() == 701))
          {
            this.dLz = ((com.tencent.mm.modelsimple.t)paramn).aLh();
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LoginHistoryUI", "url " + this.dLz);
            com.tencent.mm.kernel.g.ajj().b(701, this);
            com.tencent.mm.kernel.g.ajj().b(252, this);
            this.jnl.joz = ((com.tencent.mm.modelsimple.t)paramn).getSecCodeType();
            this.jnl.jfp = ((com.tencent.mm.modelsimple.t)paramn).aLi();
            this.jnl.jfo = ((com.tencent.mm.modelsimple.t)paramn).aLj();
            this.jnl.jfq = ((com.tencent.mm.modelsimple.t)paramn).aLk();
            if (paramInt2 == -205)
            {
              this.jlr = ((com.tencent.mm.modelsimple.t)paramn).aHO();
              this.jnP = ((com.tencent.mm.modelsimple.t)paramn).aLm();
              this.jnp = ((com.tencent.mm.modelsimple.t)paramn).aLp();
            }
            if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
              break label1096;
            }
            com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
            {
              public final void a(com.tencent.mm.network.e paramAnonymouse)
              {
                AppMethodBeat.i(128098);
                if (paramAnonymouse == null)
                {
                  AppMethodBeat.o(128098);
                  return;
                }
                paramAnonymouse = paramAnonymouse.aFs();
                com.tencent.mm.kernel.g.ajP();
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
        com.tencent.mm.plugin.account.friend.a.l.aTs();
        com.tencent.mm.platformtools.t.cW(this);
        y.Jv(this.jnl.account);
        if ((this.fOC != null) && (this.fOC.isShowing())) {
          this.fOC.setMessage(getString(2131755804));
        }
        b((com.tencent.mm.modelsimple.t)paramn);
        if (this.jir == 3)
        {
          this.jnm = ((com.tencent.mm.modelsimple.t)paramn).aLr();
          if (((com.tencent.mm.modelsimple.t)paramn).aLl())
          {
            boolean bool = this.jnm;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131763302));
            paramString.putExtra("kintent_cancelable", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128133);
        return;
      }
      if ((this.fOC != null) && (this.fOC.isShowing()))
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 31685);
        AppMethodBeat.o(128133);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramn), paramInt2);
        AppMethodBeat.o(128133);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128133);
        return;
      }
      paramn = com.tencent.mm.h.a.uU(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */