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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String dKk;
  protected ProgressDialog fMu;
  private SecurityImage jct;
  protected int jfy;
  protected String jiy;
  private com.tencent.mm.sdk.b.c jjI;
  protected TextView jkJ;
  protected EditText jkK;
  protected Button jkL;
  protected Button jkM;
  protected View jkN;
  protected View jkO;
  protected View jkP;
  protected Button jkQ;
  protected Button jkR;
  private View jkS;
  protected Button jkT;
  protected String jkU;
  protected String jkV;
  private String jkW;
  private ImageView jkX;
  private MMKeyboardUperView jkY;
  private ResizeLayout jkZ;
  protected f jkr;
  protected boolean jks;
  private String jkv;
  protected String jkw;
  protected String jla;
  private String jlb;
  private com.tencent.mm.platformtools.b jlc;
  protected LinearLayout jld;
  protected LinearLayout jle;
  protected LinearLayout jlf;
  protected MMFormInputView jlg;
  protected MMFormVerifyCodeInputView jlh;
  private Button jli;
  protected boolean jlj;
  private int jlk;
  private int jll;
  private boolean jlm;
  private String jln;
  protected int[] jlo;
  private int jlp;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(128117);
    this.fMu = null;
    this.jct = null;
    this.jkr = new f();
    this.dKk = "";
    this.jkw = "";
    this.jlj = false;
    this.jlm = false;
    this.jlo = new int[5];
    this.jjI = new LoginHistoryUI.1(this);
    this.jlp = 0;
    AppMethodBeat.o(128117);
  }
  
  private void JW(String paramString)
  {
    AppMethodBeat.i(128131);
    this.jkw = paramString;
    aTT();
    AppMethodBeat.o(128131);
  }
  
  private void JX(String paramString)
  {
    AppMethodBeat.i(128132);
    ad.i("MicroMsg.LoginHistoryUI", "requestSms %s", new Object[] { paramString });
    if (!bt.isNullOrNil(paramString))
    {
      paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
      com.tencent.mm.kernel.g.aiU().a(paramString, 0);
      getString(2131755906);
      this.fMu = h.b(this, getString(2131755936), true, new LoginHistoryUI.8(this, paramString));
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128136);
  }
  
  private void b(s params)
  {
    AppMethodBeat.i(128134);
    ad.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    Intent localIntent = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
    localIntent.addFlags(67108864);
    if (params != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", params.aKQ());
      localIntent.putExtra("kstyle_bind_recommend_show", params.aKT());
      localIntent.putExtra("kstyle_bind_wording", params.aKR());
    }
    params = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, params.ahp(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)params.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(128134);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128122);
    Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
    ((Intent)localObject).addFlags(67108864);
    if (bt.isNullOrNil(this.jkW)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.ke(this);
    AppMethodBeat.o(128122);
  }
  
  private boolean n(final int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128135);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.a.a.iRH.a(this, paramInt1, paramInt2, paramString)) {
        break label781;
      }
      if (this.jct != null) {
        this.jct.dismiss();
      }
      AppMethodBeat.o(128135);
      return true;
    case -3: 
      if (this.jlp <= 0)
      {
        h.l(this, 2131758459, 2131760766);
        this.jlp += 1;
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
      if (com.tencent.mm.kernel.g.aiU().aEN() == 5)
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
      y.dc(this);
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
      com.tencent.mm.kernel.g.aiU().a(701, this);
      com.tencent.mm.kernel.g.aiU().a(252, this);
      if (this.jct == null) {
        this.jct = SecurityImage.a.a(this, this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            int i = -1;
            AppMethodBeat.i(128102);
            ad.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.jkr.jcw + " img len" + LoginHistoryUI.this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
            int j = paramInt1;
            if (LoginHistoryUI.this.jkw == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = bt.aRp(LoginHistoryUI.this.jkw);
              if (LoginHistoryUI.this.jkr.jcu != null) {
                break label379;
              }
            }
            for (;;)
            {
              ad.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bt.aRp(LoginHistoryUI.this.jkr.jcu) });
              paramAnonymousDialogInterface = new s(LoginHistoryUI.this.jkr.account, LoginHistoryUI.this.jkr.jcu, LoginHistoryUI.this.jkr.jlF, LoginHistoryUI.j(LoginHistoryUI.this).getSecImgCode(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgSid(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((bt.isNullOrNil(LoginHistoryUI.this.jkr.jcu)) && (!bt.isNullOrNil(LoginHistoryUI.this.jkw)))
              {
                ad.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bt.aRp(LoginHistoryUI.this.jkw) });
                paramAnonymousDialogInterface.Gm(LoginHistoryUI.this.jkw);
              }
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(2131755906);
              localLoginHistoryUI1.fMu = h.b(localLoginHistoryUI2, LoginHistoryUI.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128101);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aiU().b(701, LoginHistoryUI.this);
                  com.tencent.mm.kernel.g.aiU().b(252, LoginHistoryUI.this);
                  AppMethodBeat.o(128101);
                }
              });
              AppMethodBeat.o(128102);
              return;
              paramAnonymousInt = LoginHistoryUI.this.jkw.length();
              break;
              label379:
              i = LoginHistoryUI.this.jkr.jcu.length();
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
        }, this.jkr);
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        ad.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.jkr.jcw + " img len" + this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
        this.jct.b(this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      com.tencent.mm.kernel.g.ajA();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
      for (paramString = com.tencent.mm.cc.a.az(this, 2131761063);; paramString = com.tencent.mm.kernel.a.ais())
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
        com.tencent.mm.kernel.g.ajA();
      }
    case -205: 
      ad.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aRp(this.jiy), this.jkv });
      f.a(this.jkr);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.jiy);
      paramString.putExtra("binded_mobile", this.jkV);
      paramString.putExtra("close_safe_device_style", this.jkv);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.a.a.iRG.g(this, paramString);
      AppMethodBeat.o(128135);
      return true;
    }
    if (!bt.isNullOrNil(this.dKk)) {
      y.n(this, paramString, this.dKk);
    }
    AppMethodBeat.o(128135);
    return true;
    label781:
    paramString = new ae(paramInt1, paramInt2, paramString);
    boolean bool = this.jlc.a(this, paramString);
    AppMethodBeat.o(128135);
    return bool;
  }
  
  protected final String JV(String paramString)
  {
    AppMethodBeat.i(128125);
    new ba();
    String str1 = "86";
    Object localObject = paramString;
    if (this.jla.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = ba.aob(str2);
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
  
  protected void aTT()
  {
    AppMethodBeat.i(128128);
    this.jkr.account = this.jla.trim();
    AppMethodBeat.o(128128);
  }
  
  protected final void aTU()
  {
    AppMethodBeat.i(128126);
    com.tencent.mm.kernel.g.aiU().a(701, this);
    com.tencent.mm.kernel.g.aiU().a(252, this);
    AppMethodBeat.o(128126);
  }
  
  protected final void aTV()
  {
    AppMethodBeat.i(128127);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    AppMethodBeat.o(128127);
  }
  
  public boolean aTW()
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
    this.jld = ((LinearLayout)findViewById(2131306510));
    this.jlf = ((LinearLayout)findViewById(2131299699));
    this.jle = ((LinearLayout)findViewById(2131300089));
    this.jlg = ((MMFormInputView)findViewById(2131301578));
    this.jlh = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.jkW = getIntent().getStringExtra("switch_login_wx_id");
    if (!bt.isNullOrNil(this.jkW))
    {
      this.jla = cb.hIi.getString(this.jkW, "login_user_name");
      this.jlb = cb.hIi.getString(this.jkW, "last_avatar_path");
      this.jll = bt.aRe(cb.hIi.getString(this.jkW, "last_bind_info"));
      if ((this.jll & 0x1) != 0) {
        this.jkU = cb.hIi.getString(this.jkW, "last_login_bind_qq");
      }
      if ((this.jll & 0x4) != 0) {
        this.jkV = cb.hIi.getString(this.jkW, "last_login_bind_mobile");
      }
      this.jlk = bt.aRe(cb.hIi.getString(this.jkW, "last_login_use_voice"));
      setBackBtn(new LoginHistoryUI.29(this), 2131689488);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.jla))) {
        this.jla = ((String)localObject);
      }
      this.jkX = ((ImageView)findViewById(2131301310));
      if (!bt.isNullOrNil(this.jlb)) {}
      try
      {
        localObject = com.tencent.mm.ak.e.Dd(this.jlb);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.jkX.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
          continue;
          this.jlo[2] = 2;
          this.jkJ.setText(this.jla);
          continue;
          if (!ac.fkp())
          {
            this.jkT.setText(2131766189);
            this.jkT.setOnClickListener(new LoginHistoryUI.5(this));
          }
          else
          {
            this.jkT.setText(2131766192);
            this.jkT.setOnClickListener(new LoginHistoryUI.6(this));
          }
        }
      }
      this.jkY = ((MMKeyboardUperView)findViewById(2131304370));
      this.jkJ = ((TextView)findViewById(2131301558));
      this.jkK = this.jlg.getContentEditText();
      this.jkL = ((Button)findViewById(2131301562));
      this.jkN = findViewById(2131301583);
      this.jkO = findViewById(2131301571);
      this.jkP = ((Button)findViewById(2131304798));
      this.jkM = ((Button)findViewById(2131301570));
      this.jli = ((Button)findViewById(2131301559));
      this.jkQ = ((Button)findViewById(2131301572));
      this.jkR = ((Button)findViewById(2131301574));
      this.jkS = findViewById(2131300241);
      this.jkT = ((Button)findViewById(2131301575));
      this.jkQ.setOnClickListener(new LoginHistoryUI.30(this));
      this.jkR.setOnClickListener(new LoginHistoryUI.31(this));
      if (!ac.fkp()) {
        this.jkS.setVisibility(8);
      }
      this.jlg.setVisibility(8);
      this.jld.setVisibility(8);
      this.jlf.setVisibility(8);
      this.jle.setVisibility(8);
      this.jkL.setVisibility(8);
      this.jkN.setVisibility(8);
      this.jkO.setVisibility(8);
      this.jkP.setVisibility(8);
      this.jkM.setVisibility(8);
      com.tencent.mm.ui.tools.b.c.d(this.jkK).kc(4, 16).a(null);
      this.jkZ = ((ResizeLayout)findViewById(2131304133));
      if ((!bt.aRn(this.jla).booleanValue()) || (this.jla.equals(this.jkU))) {
        break;
      }
      this.jlo[2] = 1;
      this.jkJ.setText(JV(this.jla));
      this.jkZ.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void aTX()
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
      this.jkY.setOnTouchListener(new LoginHistoryUI.33(this));
      localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).KJy = new LoginHistoryUI.34(this);
      ((com.tencent.mm.ui.widget.a.e)localObject).KJz = new LoginHistoryUI.2(this);
      ((com.tencent.mm.ui.widget.a.e)localObject).JXC = new LoginHistoryUI.3(this);
      if (!bt.isNullOrNil(this.jkW)) {
        break label1058;
      }
      this.jkT.setOnClickListener(new LoginHistoryUI.4(this, (com.tencent.mm.ui.widget.a.e)localObject));
      setMMTitle("");
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (j.Icz) {
        com.tencent.mm.plugin.account.a.a.iRH.t(this);
      }
      if (i.EX_DEVICE_LOGIN)
      {
        this.jli.setVisibility(0);
        this.jli.setOnClickListener(new LoginHistoryUI.7(this));
      }
      AppMethodBeat.o(128124);
      return;
      this.jla = az.hFS.ax("login_user_name", "");
      this.jlb = az.hFS.aBI();
      this.jll = bt.aRe(az.hFS.ax("last_bind_info", ""));
      if ((this.jll & 0x1) != 0) {
        this.jkU = az.hFS.ax("last_login_bind_qq", "");
      }
      if ((this.jll & 0x4) != 0) {
        this.jkV = az.hFS.ax("last_login_bind_mobile", "");
      }
      this.jlk = bt.aRe(az.hFS.ax("last_login_use_voice", ""));
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
      ad.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      ad.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      JW(str);
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
          ad.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          JW(paramIntent);
          AppMethodBeat.o(128130);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        aTT();
      }
    }
    label311:
    AppMethodBeat.o(128130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.a.a.iRH });
    com.tencent.mm.plugin.account.a.a.iRH.MU();
    this.sp = aj.getContext().getSharedPreferences(aj.fkC(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jlm = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.jlm = this.jlm;
      if (this.jlm) {
        this.jln = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.jlc = new com.tencent.mm.platformtools.b();
    AppMethodBeat.o(128118);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128119);
    ad.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    if (this.jlc != null) {
      this.jlc.close();
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(14262, new Object[] { Integer.valueOf(this.jlo[0]), Integer.valueOf(this.jlo[1]), Integer.valueOf(this.jlo[2]), Integer.valueOf(this.jlo[3]), Integer.valueOf(this.jlo[4]) });
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
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
    com.tencent.mm.sdk.b.a.IbL.d(this.jjI);
    AppMethodBeat.o(128121);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128120);
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((aTW()) && (this.jfy != 1) && ((this.jlk & 0x20000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7001, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(2131760779);
      ((List)localObject1).add(localObject2);
    }
    if ((this.jfy != 5) && ((this.jlk & 0x40000) != 0))
    {
      localObject2 = new com.tencent.mm.ui.base.m(this, 7005, 0);
      ((com.tencent.mm.ui.base.m)localObject2).setTitle(2131760776);
      ((List)localObject1).add(localObject2);
    }
    if (!bt.isNullOrNil(this.jla))
    {
      if (this.jfy != 2)
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7007, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(2131760777));
        ((List)localObject1).add(localObject2);
      }
      if ((!bt.isNullOrNil(this.jkV)) && (this.jfy != 3))
      {
        localObject2 = new com.tencent.mm.ui.base.m(this, 7008, 0);
        ((com.tencent.mm.ui.base.m)localObject2).setTitle(getString(2131760778));
        ((List)localObject1).add(localObject2);
      }
      if (this.jla.equalsIgnoreCase(this.jkU)) {
        this.jkK.setHint(getString(2131762380));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject2).KJy = new LoginHistoryUI.23(this, (List)localObject1);
      ((com.tencent.mm.ui.widget.a.e)localObject2).KJz = new LoginHistoryUI.24(this);
      ((com.tencent.mm.ui.widget.a.e)localObject2).JXC = new e.b()
      {
        public final void onDismiss() {}
      };
      this.jkM.setVisibility(0);
      this.jkM.setText(2131760758);
      this.jkM.setOnClickListener(new LoginHistoryUI.26(this, (com.tencent.mm.ui.widget.a.e)localObject2));
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IbL.c(this.jjI);
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.kernel.a.aiP();
      if ((!com.tencent.mm.kernel.g.ajx()) || (!com.tencent.mm.kernel.g.ajA().gAD) || (this.jla.equals(""))) {
        break label492;
      }
      if ((this.fMu == null) || (!this.fMu.isShowing())) {
        break;
      }
      AppMethodBeat.o(128120);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.jkM.setVisibility(0);
        this.jkM.setText(((com.tencent.mm.ui.base.m)((List)localObject1).get(0)).getTitle());
        this.jkM.setOnClickListener(new LoginHistoryUI.27(this, (List)localObject1));
      }
      else
      {
        this.jkM.setVisibility(8);
      }
    }
    b(null);
    AppMethodBeat.o(128120);
    return;
    label492:
    if (com.tencent.mm.r.a.adB() == 2)
    {
      localObject1 = new d.a(this);
      ((d.a)localObject1).afe(2131757340);
      ((d.a)localObject1).aXG(getString(2131757339));
      ((d.a)localObject1).yR(false);
      ((d.a)localObject1).afl(2131757337).c(new LoginHistoryUI.22(this));
      ((d.a)localObject1).fMb().show();
      com.tencent.mm.r.a.b(this, System.currentTimeMillis());
    }
    AppMethodBeat.o(128120);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128133);
    ad.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ad.i("MicroMsg.LoginHistoryUI", "Scene Type " + paramn.getType());
    com.tencent.mm.h.a locala;
    if (paramn.getType() == 145)
    {
      if ((this.fMu != null) && (this.fMu.isShowing()))
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramn).KR();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          locala = com.tencent.mm.h.a.uz(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).aHz() != 1) {
            break label231;
          }
          ad.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
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
            LoginHistoryUI.this.jlh.bwt();
            LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.jkV);
            AppMethodBeat.o(128097);
          }
        }, null);
        AppMethodBeat.o(128133);
        return;
      }
      this.jlh.bwt();
      JX(this.jkV);
      continue;
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          h.l(this, 2131762328, 2131762329);
          this.jlh.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -75)
        {
          h.c(this, getString(2131755265), "", true);
          this.jlh.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -106)
        {
          y.g(this, paramString, 32045);
          this.jlh.reset();
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
              LoginHistoryUI.this.fMu = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHv(), this.jkV).b(this);
          AppMethodBeat.o(128133);
          return;
        }
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128133);
          return;
        }
        paramn = com.tencent.mm.h.a.uz(paramString);
        if (paramn != null)
        {
          paramn.a(this, null, null);
          continue;
          if ((paramn.getType() == 252) || (paramn.getType() == 701))
          {
            this.dKk = ((s)paramn).aKK();
            ad.e("MicroMsg.LoginHistoryUI", "url " + this.dKk);
            com.tencent.mm.kernel.g.aiU().b(701, this);
            com.tencent.mm.kernel.g.aiU().b(252, this);
            this.jkr.jlF = ((s)paramn).getSecCodeType();
            this.jkr.jcw = ((s)paramn).aKL();
            this.jkr.jcv = ((s)paramn).aKM();
            this.jkr.jcx = ((s)paramn).aKN();
            if (paramInt2 == -205)
            {
              this.jiy = ((s)paramn).aHx();
              this.jkV = ((s)paramn).aKP();
              this.jkv = ((s)paramn).aKS();
            }
            if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
              break label1096;
            }
            com.tencent.mm.kernel.g.aiU().a(new bo(new bo.a()
            {
              public final void a(com.tencent.mm.network.e paramAnonymouse)
              {
                AppMethodBeat.i(128098);
                if (paramAnonymouse == null)
                {
                  AppMethodBeat.o(128098);
                  return;
                }
                paramAnonymouse = paramAnonymouse.aFc();
                com.tencent.mm.kernel.g.ajA();
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
        com.tencent.mm.plugin.account.friend.a.l.aST();
        t.cU(this);
        y.IW(this.jkr.account);
        if ((this.fMu != null) && (this.fMu.isShowing())) {
          this.fMu.setMessage(getString(2131755804));
        }
        b((s)paramn);
        if (this.jfy == 3)
        {
          this.jks = ((s)paramn).aKU();
          if (((s)paramn).aKO())
          {
            boolean bool = this.jks;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131763302));
            paramString.putExtra("kintent_cancelable", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128133);
        return;
      }
      if ((this.fMu != null) && (this.fMu.isShowing()))
      {
        this.fMu.dismiss();
        this.fMu = null;
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
      paramn = com.tencent.mm.h.a.uz(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */