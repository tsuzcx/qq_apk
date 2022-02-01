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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ca;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String dxX;
  protected ProgressDialog fts;
  private SecurityImage iJk;
  protected int iMo;
  protected String iPp;
  private com.tencent.mm.sdk.b.c iQA;
  protected TextView iRB;
  protected EditText iRC;
  protected Button iRD;
  protected Button iRE;
  protected View iRF;
  protected View iRG;
  protected View iRH;
  protected Button iRI;
  protected Button iRJ;
  private View iRK;
  protected Button iRL;
  protected String iRM;
  protected String iRN;
  private String iRO;
  private ImageView iRP;
  private MMKeyboardUperView iRQ;
  private ResizeLayout iRR;
  protected String iRS;
  private String iRT;
  private com.tencent.mm.platformtools.b iRU;
  protected LinearLayout iRV;
  protected LinearLayout iRW;
  protected LinearLayout iRX;
  protected MMFormInputView iRY;
  protected MMFormVerifyCodeInputView iRZ;
  protected f iRj;
  protected boolean iRk;
  private String iRn;
  protected String iRo;
  private Button iSa;
  protected boolean iSb;
  private int iSc;
  private int iSd;
  private boolean iSe;
  private String iSf;
  protected int[] iSg;
  private int iSh;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(128117);
    this.fts = null;
    this.iJk = null;
    this.iRj = new f();
    this.dxX = "";
    this.iRo = "";
    this.iSb = false;
    this.iSe = false;
    this.iSg = new int[5];
    this.iQA = new LoginHistoryUI.1(this);
    this.iSh = 0;
    AppMethodBeat.o(128117);
  }
  
  private void GH(String paramString)
  {
    AppMethodBeat.i(128131);
    this.iRo = paramString;
    aQH();
    AppMethodBeat.o(128131);
  }
  
  private void GI(String paramString)
  {
    AppMethodBeat.i(128132);
    ac.i("MicroMsg.LoginHistoryUI", "requestSms %s", new Object[] { paramString });
    if (!bs.isNullOrNil(paramString))
    {
      paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, new LoginHistoryUI.8(this, paramString));
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128136);
  }
  
  private void b(s params)
  {
    AppMethodBeat.i(128134);
    ac.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    Intent localIntent = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
    localIntent.addFlags(67108864);
    if (params != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", params.aHF());
      localIntent.putExtra("kstyle_bind_recommend_show", params.aHI());
      localIntent.putExtra("kstyle_bind_wording", params.aHG());
    }
    params = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, params.aeD(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)params.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(128134);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128122);
    Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
    ((Intent)localObject).addFlags(67108864);
    if (bs.isNullOrNil(this.iRO)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.jT(this);
    AppMethodBeat.o(128122);
  }
  
  private boolean n(final int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128135);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString)) {
        break label781;
      }
      if (this.iJk != null) {
        this.iJk.dismiss();
      }
      AppMethodBeat.o(128135);
      return true;
    case -3: 
      if (this.iSh <= 0)
      {
        com.tencent.mm.ui.base.h.l(this, 2131758459, 2131760766);
        this.iSh += 1;
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
      if (com.tencent.mm.kernel.g.agi().aBK() == 5)
      {
        com.tencent.mm.ui.base.h.l(this, 2131761537, 2131761536);
        AppMethodBeat.o(128135);
        return true;
      }
    case -9: 
      com.tencent.mm.ui.base.h.l(this, 2131760765, 2131760766);
      AppMethodBeat.o(128135);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.l(this, 2131762374, 2131755906);
      AppMethodBeat.o(128135);
      return true;
    case -75: 
      y.de(this);
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
      com.tencent.mm.kernel.g.agi().a(701, this);
      com.tencent.mm.kernel.g.agi().a(252, this);
      if (this.iJk == null) {
        this.iJk = SecurityImage.a.a(this, this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            int i = -1;
            AppMethodBeat.i(128102);
            ac.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.iRj.iJn + " img len" + LoginHistoryUI.this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
            int j = paramInt1;
            if (LoginHistoryUI.this.iRo == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = bs.aLJ(LoginHistoryUI.this.iRo);
              if (LoginHistoryUI.this.iRj.iJl != null) {
                break label379;
              }
            }
            for (;;)
            {
              ac.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), bs.aLJ(LoginHistoryUI.this.iRj.iJl) });
              paramAnonymousDialogInterface = new s(LoginHistoryUI.this.iRj.account, LoginHistoryUI.this.iRj.iJl, LoginHistoryUI.this.iRj.iSx, LoginHistoryUI.j(LoginHistoryUI.this).getSecImgCode(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgSid(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((bs.isNullOrNil(LoginHistoryUI.this.iRj.iJl)) && (!bs.isNullOrNil(LoginHistoryUI.this.iRo)))
              {
                ac.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { bs.aLJ(LoginHistoryUI.this.iRo) });
                paramAnonymousDialogInterface.Dh(LoginHistoryUI.this.iRo);
              }
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(2131755906);
              localLoginHistoryUI1.fts = com.tencent.mm.ui.base.h.b(localLoginHistoryUI2, LoginHistoryUI.this.getString(2131760781), true, new LoginHistoryUI.18.1(this, paramAnonymousDialogInterface));
              AppMethodBeat.o(128102);
              return;
              paramAnonymousInt = LoginHistoryUI.this.iRo.length();
              break;
              label379:
              i = LoginHistoryUI.this.iRj.iJl.length();
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
        }, this.iRj);
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        ac.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.iRj.iJn + " img len" + this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
        this.iJk.b(this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo);
      }
    case -100: 
      com.tencent.mm.kernel.a.hold();
      com.tencent.mm.kernel.g.agP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
      for (paramString = com.tencent.mm.cc.a.aw(this, 2131761063);; paramString = com.tencent.mm.kernel.a.afG())
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
        com.tencent.mm.kernel.g.agP();
      }
    case -205: 
      ac.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bs.aLJ(this.iPp), this.iRn });
      f.a(this.iRj);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.iPp);
      paramString.putExtra("binded_mobile", this.iRN);
      paramString.putExtra("close_safe_device_style", this.iRn);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.a.a.iyx.g(this, paramString);
      AppMethodBeat.o(128135);
      return true;
    }
    if (!bs.isNullOrNil(this.dxX)) {
      y.m(this, paramString, this.dxX);
    }
    AppMethodBeat.o(128135);
    return true;
    label781:
    paramString = new ad(paramInt1, paramInt2, paramString);
    boolean bool = this.iRU.a(this, paramString);
    AppMethodBeat.o(128135);
    return bool;
  }
  
  protected final String GG(String paramString)
  {
    AppMethodBeat.i(128125);
    new az();
    String str1 = "86";
    Object localObject = paramString;
    if (this.iRS.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = az.ajo(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = az.formatNumber(str1, (String)localObject);
    AppMethodBeat.o(128125);
    return paramString;
  }
  
  protected void aQH()
  {
    AppMethodBeat.i(128128);
    this.iRj.account = this.iRS.trim();
    AppMethodBeat.o(128128);
  }
  
  protected final void aQI()
  {
    AppMethodBeat.i(128126);
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    AppMethodBeat.o(128126);
  }
  
  protected final void aQJ()
  {
    AppMethodBeat.i(128127);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    AppMethodBeat.o(128127);
  }
  
  public boolean aQK()
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
    this.iRV = ((LinearLayout)findViewById(2131306510));
    this.iRX = ((LinearLayout)findViewById(2131299699));
    this.iRW = ((LinearLayout)findViewById(2131300089));
    this.iRY = ((MMFormInputView)findViewById(2131301578));
    this.iRZ = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.iRO = getIntent().getStringExtra("switch_login_wx_id");
    if (!bs.isNullOrNil(this.iRO))
    {
      this.iRS = ca.hpQ.getString(this.iRO, "login_user_name");
      this.iRT = ca.hpQ.getString(this.iRO, "last_avatar_path");
      this.iSd = bs.aLy(ca.hpQ.getString(this.iRO, "last_bind_info"));
      if ((this.iSd & 0x1) != 0) {
        this.iRM = ca.hpQ.getString(this.iRO, "last_login_bind_qq");
      }
      if ((this.iSd & 0x4) != 0) {
        this.iRN = ca.hpQ.getString(this.iRO, "last_login_bind_mobile");
      }
      this.iSc = bs.aLy(ca.hpQ.getString(this.iRO, "last_login_use_voice"));
      setBackBtn(new LoginHistoryUI.29(this), 2131689488);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.iRS))) {
        this.iRS = ((String)localObject);
      }
      this.iRP = ((ImageView)findViewById(2131301310));
      if (!bs.isNullOrNil(this.iRT)) {}
      try
      {
        localObject = com.tencent.mm.aj.e.Ae(this.iRT);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.iRP.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
          continue;
          this.iSg[2] = 2;
          this.iRB.setText(this.iRS);
          continue;
          if (!ab.eUL())
          {
            this.iRL.setText(2131766189);
            this.iRL.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(128091);
                LoginHistoryUI.R(LoginHistoryUI.this, LoginHistoryUI.this.getString(2131766190) + ab.eUO());
                AppMethodBeat.o(128091);
              }
            });
          }
          else
          {
            this.iRL.setText(2131766192);
            this.iRL.setOnClickListener(new View.OnClickListener()
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
      this.iRQ = ((MMKeyboardUperView)findViewById(2131304370));
      this.iRB = ((TextView)findViewById(2131301558));
      this.iRC = this.iRY.getContentEditText();
      this.iRD = ((Button)findViewById(2131301562));
      this.iRF = findViewById(2131301583);
      this.iRG = findViewById(2131301571);
      this.iRH = ((Button)findViewById(2131304798));
      this.iRE = ((Button)findViewById(2131301570));
      this.iSa = ((Button)findViewById(2131301559));
      this.iRI = ((Button)findViewById(2131301572));
      this.iRJ = ((Button)findViewById(2131301574));
      this.iRK = findViewById(2131300241);
      this.iRL = ((Button)findViewById(2131301575));
      this.iRI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128111);
          paramAnonymousView = LoginHistoryUI.this.getString(2131760769) + ab.eUO();
          LoginHistoryUI.R(LoginHistoryUI.this, paramAnonymousView);
          AppMethodBeat.o(128111);
        }
      });
      this.iRJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128112);
          paramAnonymousView = LoginHistoryUI.this.getString(2131759660, new Object[] { ab.eUO() });
          LoginHistoryUI.R(LoginHistoryUI.this, paramAnonymousView);
          AppMethodBeat.o(128112);
        }
      });
      if (!ab.eUL()) {
        this.iRK.setVisibility(8);
      }
      this.iRY.setVisibility(8);
      this.iRV.setVisibility(8);
      this.iRX.setVisibility(8);
      this.iRW.setVisibility(8);
      this.iRD.setVisibility(8);
      this.iRF.setVisibility(8);
      this.iRG.setVisibility(8);
      this.iRH.setVisibility(8);
      this.iRE.setVisibility(8);
      com.tencent.mm.ui.tools.b.c.d(this.iRC).jQ(4, 16).a(null);
      this.iRR = ((ResizeLayout)findViewById(2131304133));
      if ((!bs.aLH(this.iRS).booleanValue()) || (this.iRS.equals(this.iRM))) {
        break;
      }
      this.iSg[2] = 1;
      this.iRB.setText(GG(this.iRS));
      this.iRR.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void aQL()
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
      this.iRQ.setOnTouchListener(new View.OnTouchListener()
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
      ((com.tencent.mm.ui.widget.a.e)localObject).ISu = new LoginHistoryUI.34(this);
      ((com.tencent.mm.ui.widget.a.e)localObject).ISv = new n.d()
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
            LoginHistoryUI.R(LoginHistoryUI.this, LoginHistoryUI.this.getString(2131766190) + ab.eUO());
          }
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).Ihj = new e.b()
      {
        public final void onDismiss() {}
      };
      if (!bs.isNullOrNil(this.iRO)) {
        break label1058;
      }
      this.iRL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128090);
          LoginHistoryUI.this.hideVKB();
          this.iSj.cED();
          AppMethodBeat.o(128090);
        }
      });
      setMMTitle("");
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (i.GqL) {
        com.tencent.mm.plugin.account.a.a.iyy.t(this);
      }
      if (com.tencent.mm.sdk.platformtools.h.EX_DEVICE_LOGIN)
      {
        this.iSa.setVisibility(0);
        this.iSa.setOnClickListener(new LoginHistoryUI.7(this));
      }
      AppMethodBeat.o(128124);
      return;
      this.iRS = ay.hnA.aw("login_user_name", "");
      this.iRT = ay.hnA.ayE();
      this.iSd = bs.aLy(ay.hnA.aw("last_bind_info", ""));
      if ((this.iSd & 0x1) != 0) {
        this.iRM = ay.hnA.aw("last_login_bind_qq", "");
      }
      if ((this.iSd & 0x4) != 0) {
        this.iRN = ay.hnA.aw("last_login_bind_mobile", "");
      }
      this.iSc = bs.aLy(ay.hnA.aw("last_login_use_voice", ""));
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
      ac.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label174;
      }
      if (paramInt2 != -1) {
        break label311;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bs.isNullOrNil(str);
      if (!bs.isNullOrNil(str)) {
        break label165;
      }
    }
    label165:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ac.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      GH(str);
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
        bool = bs.isNullOrNil(paramIntent);
        if (bs.isNullOrNil(paramIntent)) {}
        for (paramInt1 = j;; paramInt1 = paramIntent.length())
        {
          ac.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          GH(paramIntent);
          AppMethodBeat.o(128130);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        aQH();
      }
    }
    label311:
    AppMethodBeat.o(128130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.a.a.iyy });
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.sp = ai.getContext().getSharedPreferences(ai.eUX(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.iSe = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.iSe = this.iSe;
      if (this.iSe) {
        this.iSf = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.iRU = new com.tencent.mm.platformtools.b();
    AppMethodBeat.o(128118);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128119);
    ac.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    if (this.iRU != null) {
      this.iRU.close();
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(14262, new Object[] { Integer.valueOf(this.iSg[0]), Integer.valueOf(this.iSg[1]), Integer.valueOf(this.iSg[2]), Integer.valueOf(this.iSg[3]), Integer.valueOf(this.iSg[4]) });
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
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
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    AppMethodBeat.o(128121);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128120);
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((aQK()) && (this.iMo != 1) && ((this.iSc & 0x20000) != 0))
    {
      localObject2 = new m(this, 7001, 0);
      ((m)localObject2).setTitle(2131760779);
      ((List)localObject1).add(localObject2);
    }
    if ((this.iMo != 5) && ((this.iSc & 0x40000) != 0))
    {
      localObject2 = new m(this, 7005, 0);
      ((m)localObject2).setTitle(2131760776);
      ((List)localObject1).add(localObject2);
    }
    if (!bs.isNullOrNil(this.iRS))
    {
      if (this.iMo != 2)
      {
        localObject2 = new m(this, 7007, 0);
        ((m)localObject2).setTitle(getString(2131760777));
        ((List)localObject1).add(localObject2);
      }
      if ((!bs.isNullOrNil(this.iRN)) && (this.iMo != 3))
      {
        localObject2 = new m(this, 7008, 0);
        ((m)localObject2).setTitle(getString(2131760778));
        ((List)localObject1).add(localObject2);
      }
      if (this.iRS.equalsIgnoreCase(this.iRM)) {
        this.iRC.setHint(getString(2131762380));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject2).ISu = new LoginHistoryUI.23(this, (List)localObject1);
      ((com.tencent.mm.ui.widget.a.e)localObject2).ISv = new LoginHistoryUI.24(this);
      ((com.tencent.mm.ui.widget.a.e)localObject2).Ihj = new e.b()
      {
        public final void onDismiss() {}
      };
      this.iRE.setVisibility(0);
      this.iRE.setText(2131760758);
      this.iRE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128107);
          LoginHistoryUI.this.hideVKB();
          this.iSj.cED();
          AppMethodBeat.o(128107);
        }
      });
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.kernel.a.agd();
      if ((!com.tencent.mm.kernel.g.agM()) || (!com.tencent.mm.kernel.g.agP().ggT) || (this.iRS.equals(""))) {
        break label492;
      }
      if ((this.fts == null) || (!this.fts.isShowing())) {
        break;
      }
      AppMethodBeat.o(128120);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.iRE.setVisibility(0);
        this.iRE.setText(((m)((List)localObject1).get(0)).getTitle());
        this.iRE.setOnClickListener(new LoginHistoryUI.27(this, (List)localObject1));
      }
      else
      {
        this.iRE.setVisibility(8);
      }
    }
    b(null);
    AppMethodBeat.o(128120);
    return;
    label492:
    if (com.tencent.mm.q.a.aaY() == 2)
    {
      localObject1 = new d.a(this);
      ((d.a)localObject1).acF(2131757340);
      ((d.a)localObject1).aRI(getString(2131757339));
      ((d.a)localObject1).yf(false);
      ((d.a)localObject1).acM(2131757337).b(new LoginHistoryUI.22(this));
      ((d.a)localObject1).fvp().show();
      com.tencent.mm.q.a.b(this, System.currentTimeMillis());
    }
    AppMethodBeat.o(128120);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128133);
    ac.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ac.i("MicroMsg.LoginHistoryUI", "Scene Type " + paramn.getType());
    com.tencent.mm.h.a locala;
    if (paramn.getType() == 145)
    {
      if ((this.fts != null) && (this.fts.isShowing()))
      {
        this.fts.dismiss();
        this.fts = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramn).Js();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          locala = com.tencent.mm.h.a.rM(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).aEu() != 1) {
            break label231;
          }
          ac.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
          if (locala != null)
          {
            locala.a(this, new LoginHistoryUI.9(this), null);
            AppMethodBeat.o(128133);
            return;
          }
          com.tencent.mm.ui.base.h.a(this, getString(2131760761), "", new LoginHistoryUI.10(this), null);
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
            LoginHistoryUI.this.iRZ.bso();
            LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.iRN);
            AppMethodBeat.o(128097);
          }
        }, null);
        AppMethodBeat.o(128133);
        return;
      }
      this.iRZ.bso();
      GI(this.iRN);
      continue;
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.l(this, 2131762328, 2131762329);
          this.iRZ.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131755265), "", true);
          this.iRZ.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -106)
        {
          y.g(this, paramString, 32045);
          this.iRZ.reset();
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
              LoginHistoryUI.this.fts = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aEq(), this.iRN).a(this);
          AppMethodBeat.o(128133);
          return;
        }
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128133);
          return;
        }
        paramn = com.tencent.mm.h.a.rM(paramString);
        if (paramn != null)
        {
          paramn.a(this, null, null);
          continue;
          if ((paramn.getType() == 252) || (paramn.getType() == 701))
          {
            this.dxX = ((s)paramn).aHz();
            ac.e("MicroMsg.LoginHistoryUI", "url " + this.dxX);
            com.tencent.mm.kernel.g.agi().b(701, this);
            com.tencent.mm.kernel.g.agi().b(252, this);
            this.iRj.iSx = ((s)paramn).getSecCodeType();
            this.iRj.iJn = ((s)paramn).aHA();
            this.iRj.iJm = ((s)paramn).aHB();
            this.iRj.iJo = ((s)paramn).aHC();
            if (paramInt2 == -205)
            {
              this.iPp = ((s)paramn).aEs();
              this.iRN = ((s)paramn).aHE();
              this.iRn = ((s)paramn).aHH();
            }
            if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
              break label1096;
            }
            com.tencent.mm.kernel.g.agi().a(new bn(new LoginHistoryUI.13(this)), 0);
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
        com.tencent.mm.plugin.account.friend.a.l.aPH();
        t.cW(this);
        y.FH(this.iRj.account);
        if ((this.fts != null) && (this.fts.isShowing())) {
          this.fts.setMessage(getString(2131755804));
        }
        b((s)paramn);
        if (this.iMo == 3)
        {
          this.iRk = ((s)paramn).aHJ();
          if (((s)paramn).aHD())
          {
            boolean bool = this.iRk;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131763302));
            paramString.putExtra("kintent_cancelable", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128133);
        return;
      }
      if ((this.fts != null) && (this.fts.isShowing()))
      {
        this.fts.dismiss();
        this.fts = null;
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
      paramn = com.tencent.mm.h.a.rM(paramString);
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