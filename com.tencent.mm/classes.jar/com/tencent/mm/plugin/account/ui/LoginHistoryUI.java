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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.platformtools.ae;
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
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements i
{
  private String edo;
  protected ProgressDialog gtM;
  private SecurityImage kdp;
  protected String kjv;
  private IListener kkK;
  protected TextView klL;
  protected EditText klM;
  protected Button klN;
  protected Button klO;
  protected View klP;
  protected View klQ;
  protected View klR;
  protected Button klS;
  protected Button klT;
  private View klU;
  protected Button klV;
  protected String klW;
  protected String klX;
  private String klY;
  private ImageView klZ;
  protected g klt;
  protected boolean klu;
  private String klx;
  protected String kly;
  private MMKeyboardUperView kma;
  private ResizeLayout kmb;
  protected String kmc;
  protected String kmd;
  private String kme;
  private com.tencent.mm.platformtools.b kmf;
  protected LinearLayout kmg;
  protected LinearLayout kmh;
  protected LinearLayout kmi;
  protected MMFormInputView kmj;
  protected MMFormVerifyCodeInputView kmk;
  private Button kml;
  protected boolean kmm;
  private int kmn;
  private int kmo;
  private boolean kmp;
  private String kmq;
  protected int[] kmr;
  private int kms;
  protected int loginType;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(128117);
    this.gtM = null;
    this.kdp = null;
    this.klt = new g();
    this.edo = "";
    this.kly = "";
    this.kmm = false;
    this.kmp = false;
    this.kmr = new int[5];
    this.kkK = new LoginHistoryUI.1(this);
    this.kms = 0;
    AppMethodBeat.o(128117);
  }
  
  private void Tt(String paramString)
  {
    AppMethodBeat.i(128131);
    this.kly = paramString;
    bpf();
    AppMethodBeat.o(128131);
  }
  
  private void Tu(final String paramString)
  {
    AppMethodBeat.i(128132);
    Log.i("MicroMsg.LoginHistoryUI", "requestSms %s", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
      com.tencent.mm.kernel.g.azz().a(paramString, 0);
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128094);
          com.tencent.mm.kernel.g.azz().a(paramString);
          AppMethodBeat.o(128094);
        }
      });
    }
    AppMethodBeat.o(128132);
  }
  
  public static void Y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128136);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128136);
  }
  
  private void b(com.tencent.mm.modelsimple.t paramt)
  {
    AppMethodBeat.i(128134);
    Log.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    Intent localIntent = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
    localIntent.addFlags(67108864);
    if (paramt != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramt.bfq());
      localIntent.putExtra("kstyle_bind_recommend_show", paramt.bft());
      localIntent.putExtra("kstyle_bind_wording", paramt.bfr());
    }
    paramt = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramt.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramt.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(128134);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128122);
    Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
    ((Intent)localObject).addFlags(67108864);
    if (Util.isNullOrNil(this.klY)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.kd(this);
    AppMethodBeat.o(128122);
  }
  
  private boolean n(final int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128135);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
        break label789;
      }
      if (this.kdp != null) {
        this.kdp.dismiss();
      }
      AppMethodBeat.o(128135);
      return true;
    case -3: 
      if (this.kms <= 0)
      {
        com.tencent.mm.ui.base.h.n(this, 2131758757, 2131762516);
        this.kms += 1;
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.ui.base.h.c(this, getString(2131758758), getString(2131762516), getString(2131758759), getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      if (com.tencent.mm.kernel.g.azz().aYS() == 5)
      {
        com.tencent.mm.ui.base.h.n(this, 2131763503, 2131763502);
        AppMethodBeat.o(128135);
        return true;
      }
    case -9: 
      com.tencent.mm.ui.base.h.n(this, 2131762515, 2131762516);
      AppMethodBeat.o(128135);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.n(this, 2131764440, 2131755998);
      AppMethodBeat.o(128135);
      return true;
    case -75: 
      y.dz(this);
      AppMethodBeat.o(128135);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.d(this, getString(2131756646), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
      return true;
    case -33: 
      com.tencent.mm.ui.base.h.a(this, 2131756644, 2131756650, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
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
            int i = -1;
            AppMethodBeat.i(128102);
            Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.klt.kds + " img len" + LoginHistoryUI.this.klt.kdr.length + " " + f.apq());
            int j = paramInt1;
            if (LoginHistoryUI.this.kly == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = Util.secPrint(LoginHistoryUI.this.kly);
              if (LoginHistoryUI.this.klt.kdq != null) {
                break label379;
              }
            }
            for (;;)
            {
              Log.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), Util.secPrint(LoginHistoryUI.this.klt.kdq) });
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginHistoryUI.this.klt.account, LoginHistoryUI.this.klt.kdq, LoginHistoryUI.this.klt.kmJ, LoginHistoryUI.j(LoginHistoryUI.this).getSecImgCode(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgSid(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((Util.isNullOrNil(LoginHistoryUI.this.klt.kdq)) && (!Util.isNullOrNil(LoginHistoryUI.this.kly)))
              {
                Log.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { Util.secPrint(LoginHistoryUI.this.kly) });
                paramAnonymousDialogInterface.PA(LoginHistoryUI.this.kly);
              }
              com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(2131755998);
              localLoginHistoryUI1.gtM = com.tencent.mm.ui.base.h.a(localLoginHistoryUI2, LoginHistoryUI.this.getString(2131762532), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128101);
                  com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.azz().b(701, LoginHistoryUI.this);
                  com.tencent.mm.kernel.g.azz().b(252, LoginHistoryUI.this);
                  AppMethodBeat.o(128101);
                }
              });
              AppMethodBeat.o(128102);
              return;
              paramAnonymousInt = LoginHistoryUI.this.kly.length();
              break;
              label379:
              i = LoginHistoryUI.this.klt.kdq.length();
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
        }, this.klt);
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
        this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
      }
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.a.hold();
      com.tencent.mm.kernel.g.aAf();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
      for (paramString = com.tencent.mm.cb.a.aI(this, 2131762849);; paramString = com.tencent.mm.kernel.a.ayX())
      {
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.kernel.g.aAf();
      }
    case -205: 
      Log.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.kjv), this.klx });
      g.a(this.klt);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.kjv);
      paramString.putExtra("binded_mobile", this.klX);
      paramString.putExtra("close_safe_device_style", this.klx);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.a.a.jRt.g(this, paramString);
      AppMethodBeat.o(128135);
      return true;
    }
    if (!Util.isNullOrNil(this.edo)) {
      y.m(this, paramString, this.edo);
    }
    AppMethodBeat.o(128135);
    return true;
    label789:
    paramString = new ae(paramInt1, paramInt2, paramString);
    boolean bool = this.kmf.a(this, paramString);
    AppMethodBeat.o(128135);
    return bool;
  }
  
  protected final String Ts(String paramString)
  {
    AppMethodBeat.i(128125);
    PhoneFormater localPhoneFormater = new PhoneFormater();
    String str1 = "86";
    Object localObject = paramString;
    if (this.kmc.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = PhoneFormater.extractCountryCode(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = localPhoneFormater.formatNumber(str1, (String)localObject);
    AppMethodBeat.o(128125);
    return paramString;
  }
  
  protected void bpf()
  {
    AppMethodBeat.i(128128);
    this.klt.account = this.kmc.trim();
    AppMethodBeat.o(128128);
  }
  
  protected final void bpg()
  {
    AppMethodBeat.i(128126);
    com.tencent.mm.kernel.g.azz().a(701, this);
    com.tencent.mm.kernel.g.azz().a(252, this);
    AppMethodBeat.o(128126);
  }
  
  protected final void bph()
  {
    AppMethodBeat.i(128127);
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    AppMethodBeat.o(128127);
  }
  
  public boolean bpi()
  {
    AppMethodBeat.i(196864);
    if (!WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned())
    {
      AppMethodBeat.o(196864);
      return true;
    }
    AppMethodBeat.o(196864);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131495317;
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
    this.kmg = ((LinearLayout)findViewById(2131309970));
    this.kmi = ((LinearLayout)findViewById(2131300364));
    this.kmh = ((LinearLayout)findViewById(2131301524));
    this.kmj = ((MMFormInputView)findViewById(2131303806));
    this.kmk = ((MMFormVerifyCodeInputView)findViewById(2131307965));
    this.klY = getIntent().getStringExtra("switch_login_wx_id");
    if (!Util.isNullOrNil(this.klY))
    {
      this.kmc = ch.iFO.getString(this.klY, "login_user_name");
      this.kme = ch.iFO.getString(this.klY, "last_avatar_path");
      this.kmo = Util.safeParseInt(ch.iFO.getString(this.klY, "last_bind_info"));
      if ((this.kmo & 0x1) != 0) {
        this.klW = ch.iFO.getString(this.klY, "last_login_bind_qq");
      }
      if ((this.kmo & 0x4) != 0) {
        this.klX = ch.iFO.getString(this.klY, "last_login_bind_mobile");
      }
      this.kmn = Util.safeParseInt(ch.iFO.getString(this.klY, "last_login_use_voice"));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128110);
          LoginHistoryUI.b(LoginHistoryUI.this);
          AppMethodBeat.o(128110);
          return true;
        }
      }, 2131689490);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.kmc))) {
        this.kmc = ((String)localObject);
      }
      this.klZ = ((ImageView)findViewById(2131303010));
      if (!Util.isNullOrNil(this.kme)) {}
      try
      {
        localObject = com.tencent.mm.aj.e.Mq(this.kme);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.klZ.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
          continue;
          this.kmr[2] = 2;
          if (!Util.isNullOrNil(this.kmd))
          {
            this.klL.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), this.kmd));
          }
          else
          {
            this.klL.setText(this.kmc);
            continue;
            if (!LocaleUtil.isSimplifiedChineseAppLang())
            {
              this.klV.setText(2131768665);
              this.klV.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(128091);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  LoginHistoryUI.Y(LoginHistoryUI.this, LoginHistoryUI.this.getString(2131768666) + LocaleUtil.getApplicationLanguage());
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(128091);
                }
              });
            }
            else
            {
              this.klV.setText(2131768668);
              this.klV.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(128092);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  LoginHistoryUI.f(LoginHistoryUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(128092);
                }
              });
            }
          }
        }
      }
      this.kma = ((MMKeyboardUperView)findViewById(2131307332));
      this.klL = ((TextView)findViewById(2131303776));
      this.klM = this.kmj.getContentEditText();
      this.klN = ((Button)findViewById(2131303784));
      this.klP = findViewById(2131303813);
      this.klQ = findViewById(2131303795);
      this.klR = ((Button)findViewById(2131307880));
      this.klO = ((Button)findViewById(2131303792));
      this.kml = ((Button)findViewById(2131303779));
      this.klS = ((Button)findViewById(2131303796));
      this.klT = ((Button)findViewById(2131303798));
      this.klU = findViewById(2131301720);
      this.klV = ((Button)findViewById(2131303803));
      this.klS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128111);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = LoginHistoryUI.this.getString(2131762519) + LocaleUtil.getApplicationLanguage();
          LoginHistoryUI.Y(LoginHistoryUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128111);
        }
      });
      this.klT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = LoginHistoryUI.this.getString(2131760981, new Object[] { LocaleUtil.getApplicationLanguage() });
          LoginHistoryUI.Y(LoginHistoryUI.this, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128112);
        }
      });
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        this.klU.setVisibility(8);
      }
      this.kmj.setVisibility(8);
      this.kmg.setVisibility(8);
      this.kmi.setVisibility(8);
      this.kmh.setVisibility(8);
      this.klN.setVisibility(8);
      this.klP.setVisibility(8);
      this.klQ.setVisibility(8);
      this.klR.setVisibility(8);
      this.klO.setVisibility(8);
      com.tencent.mm.ui.tools.b.c.f(this.klM).lv(4, 16).a(null);
      this.kmb = ((ResizeLayout)findViewById(2131307029));
      if ((!Util.isPhoneNumber(this.kmc).booleanValue()) || (this.kmc.equals(this.klW))) {
        break;
      }
      this.kmr[2] = 1;
      this.klL.setText(Ts(this.kmc));
      this.kmb.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void bpj()
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
      this.kma.setOnTouchListener(new View.OnTouchListener()
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
      ((com.tencent.mm.ui.widget.a.e)localObject).HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(128116);
          if (paramAnonymousm.size() == 0)
          {
            paramAnonymousm.kV(7002, 2131762507);
            paramAnonymousm.kV(7003, 2131761790);
            paramAnonymousm.kV(7004, 2131768668);
            if (!LocaleUtil.isSimplifiedChineseAppLang()) {
              paramAnonymousm.kV(7009, 2131768665);
            }
          }
          AppMethodBeat.o(128116);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).HLY = new o.g()
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
            LoginHistoryUI.Y(LoginHistoryUI.this, LoginHistoryUI.this.getString(2131768666) + LocaleUtil.getApplicationLanguage());
          }
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).PGl = new e.b()
      {
        public final void onDismiss() {}
      };
      if (!Util.isNullOrNil(this.klY)) {
        break label1167;
      }
      this.klV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128090);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          LoginHistoryUI.this.hideVKB();
          this.kmu.dGm();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128090);
        }
      });
      setMMTitle("");
      setActionbarColor(getResources().getColor(2131100898));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (ChannelUtil.shouldShowGprsAlert) {
        com.tencent.mm.plugin.account.a.a.jRu.t(this);
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
        if ((ao.gJH()) && (!ao.gJL())) {
          this.kml.setText(getResources().getString(2131762522));
        }
        this.kml.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(128093);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.br.c.V(LoginHistoryUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginHistoryUI.this.overridePendingTransition(2130772129, 2130771986);
            com.tencent.mm.plugin.report.service.h.CyF.Ip(4L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128093);
          }
        });
      }
      if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
        this.klS.setVisibility(8);
      }
      AppMethodBeat.o(128124);
      return;
      this.kmc = bf.iDu.aA("login_user_name", "");
      this.kmd = bf.iDu.aA("last_login_nick_name", "");
      this.kme = bf.iDu.aVx();
      this.kmo = Util.safeParseInt(bf.iDu.aA("last_bind_info", ""));
      if ((this.kmo & 0x1) != 0) {
        this.klW = bf.iDu.aA("last_login_bind_qq", "");
      }
      if ((this.kmo & 0x4) != 0) {
        this.klX = bf.iDu.aA("last_login_bind_mobile", "");
      }
      this.kmn = Util.safeParseInt(bf.iDu.aA("last_login_use_voice", ""));
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
      Log.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label174;
      }
      if (paramInt2 != -1) {
        break label311;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = Util.isNullOrNil(str);
      if (!Util.isNullOrNil(str)) {
        break label165;
      }
    }
    label165:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      Log.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      Tt(str);
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
        bool = Util.isNullOrNil(paramIntent);
        if (Util.isNullOrNil(paramIntent)) {}
        for (paramInt1 = j;; paramInt1 = paramIntent.length())
        {
          Log.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          Tt(paramIntent);
          AppMethodBeat.o(128130);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        bpf();
      }
    }
    label311:
    AppMethodBeat.o(128130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.a.a.jRu });
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.kmp = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.kmp = this.kmp;
      if (this.kmp) {
        this.kmq = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.kmf = new com.tencent.mm.platformtools.b();
    AppMethodBeat.o(128118);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128119);
    Log.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    if (this.kmf != null) {
      this.kmf.close();
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(14262, new Object[] { Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]) });
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
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
    EventCenter.instance.removeListener(this.kkK);
    AppMethodBeat.o(128121);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128120);
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((bpi()) && (this.loginType != 1) && ((this.kmn & 0x20000) != 0))
    {
      localObject2 = new n(this, 7001, 0);
      ((n)localObject2).setTitle(2131762530);
      ((List)localObject1).add(localObject2);
    }
    if ((this.loginType != 5) && ((this.kmn & 0x40000) != 0))
    {
      localObject2 = new n(this, 7005, 0);
      ((n)localObject2).setTitle(2131762527);
      ((List)localObject1).add(localObject2);
    }
    if (!Util.isNullOrNil(this.kmc))
    {
      if (this.loginType != 2)
      {
        localObject2 = new n(this, 7007, 0);
        ((n)localObject2).setTitle(getString(2131762528));
        ((List)localObject1).add(localObject2);
      }
      if ((!Util.isNullOrNil(this.klX)) && (this.loginType != 3))
      {
        localObject2 = new n(this, 7008, 0);
        ((n)localObject2).setTitle(getString(2131762529));
        ((List)localObject1).add(localObject2);
      }
      if (this.kmc.equalsIgnoreCase(this.klW)) {
        this.klM.setHint(getString(2131764446));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject2).HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(128105);
          if (paramAnonymousm.size() == 0)
          {
            Iterator localIterator = this.kmw.iterator();
            while (localIterator.hasNext()) {
              paramAnonymousm.g((n)localIterator.next());
            }
          }
          AppMethodBeat.o(128105);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject2).HLY = new LoginHistoryUI.24(this);
      ((com.tencent.mm.ui.widget.a.e)localObject2).PGl = new e.b()
      {
        public final void onDismiss() {}
      };
      this.klO.setVisibility(0);
      this.klO.setText(2131762506);
      this.klO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128107);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          LoginHistoryUI.this.hideVKB();
          this.kmu.dGm();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128107);
        }
      });
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.kkK);
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.kernel.a.azu();
      if ((!com.tencent.mm.kernel.g.aAc()) || (!com.tencent.mm.kernel.g.aAf().hpY) || (this.kmc.equals(""))) {
        break label492;
      }
      if ((this.gtM == null) || (!this.gtM.isShowing())) {
        break;
      }
      AppMethodBeat.o(128120);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.klO.setVisibility(0);
        this.klO.setText(((n)((List)localObject1).get(0)).getTitle());
        this.klO.setOnClickListener(new LoginHistoryUI.27(this, (List)localObject1));
      }
      else
      {
        this.klO.setVisibility(8);
      }
    }
    b(null);
    AppMethodBeat.o(128120);
    return;
    label492:
    if (com.tencent.mm.p.a.ats() == 2)
    {
      localObject1 = new d.a(this);
      ((d.a)localObject1).aoO(2131757557);
      ((d.a)localObject1).boo(getString(2131757556));
      ((d.a)localObject1).Dk(false);
      ((d.a)localObject1).aoV(2131757554).c(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128104);
          Log.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
          LoginHistoryUI.a(LoginHistoryUI.this);
          AppMethodBeat.o(128104);
        }
      });
      ((d.a)localObject1).hbn().show();
      com.tencent.mm.p.a.b(this, System.currentTimeMillis());
    }
    AppMethodBeat.o(128120);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128133);
    Log.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Log.i("MicroMsg.LoginHistoryUI", "Scene Type " + paramq.getType());
    com.tencent.mm.h.a locala;
    if (paramq.getType() == 145)
    {
      if ((this.gtM != null) && (this.gtM.isShowing()))
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          locala = com.tencent.mm.h.a.Dk(paramString);
          if (((com.tencent.mm.modelfriend.a)paramq).bbJ() != 1) {
            break label231;
          }
          Log.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
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
          com.tencent.mm.ui.base.h.a(this, getString(2131762511), "", new DialogInterface.OnClickListener()
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
            LoginHistoryUI.this.kmk.bTu();
            LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.klX);
            AppMethodBeat.o(128097);
          }
        }, null);
        AppMethodBeat.o(128133);
        return;
      }
      this.kmk.bTu();
      Tu(this.klX);
      continue;
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.n(this, 2131764394, 2131764395);
          this.kmk.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131755300), "", true);
          this.kmk.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -106)
        {
          y.g(this, paramString, 32045);
          this.kmk.reset();
          AppMethodBeat.o(128133);
        }
      }
      else if (i == 17)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          new h(new h.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              LoginHistoryUI.this.gtM = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bbF(), this.klX).b(this);
          AppMethodBeat.o(128133);
          return;
        }
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128133);
          return;
        }
        paramq = com.tencent.mm.h.a.Dk(paramString);
        if (paramq != null)
        {
          paramq.a(this, null, null);
          continue;
          if ((paramq.getType() == 252) || (paramq.getType() == 701))
          {
            this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
            Log.e("MicroMsg.LoginHistoryUI", "url " + this.edo);
            com.tencent.mm.kernel.g.azz().b(701, this);
            com.tencent.mm.kernel.g.azz().b(252, this);
            this.klt.kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
            this.klt.kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
            this.klt.kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
            this.klt.kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
            if (paramInt2 == -205)
            {
              this.kjv = ((com.tencent.mm.modelsimple.t)paramq).bbH();
              this.klX = ((com.tencent.mm.modelsimple.t)paramq).bfp();
              this.klx = ((com.tencent.mm.modelsimple.t)paramq).bfs();
            }
            if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
              break label1096;
            }
            com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
            {
              public final void a(com.tencent.mm.network.g paramAnonymousg)
              {
                AppMethodBeat.i(128098);
                if (paramAnonymousg == null)
                {
                  AppMethodBeat.o(128098);
                  return;
                }
                paramAnonymousg = paramAnonymousg.aZh();
                com.tencent.mm.kernel.g.aAf();
                int i = com.tencent.mm.kernel.a.getUin();
                paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
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
        com.tencent.mm.plugin.account.friend.a.l.boe();
        com.tencent.mm.platformtools.t.dr(this);
        y.St(this.klt.account);
        if ((this.gtM != null) && (this.gtM.isShowing())) {
          this.gtM.setMessage(getString(2131755886));
        }
        b((com.tencent.mm.modelsimple.t)paramq);
        if (this.loginType == 3)
        {
          this.klu = ((com.tencent.mm.modelsimple.t)paramq).bfu();
          if (((com.tencent.mm.modelsimple.t)paramq).bfo())
          {
            boolean bool = this.klu;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131765477));
            paramString.putExtra("kintent_cancelable", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128133);
        return;
      }
      if ((this.gtM != null) && (this.gtM.isShowing()))
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 31685);
        AppMethodBeat.o(128133);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128133);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128133);
        return;
      }
      paramq = com.tencent.mm.h.a.Dk(paramString);
      if ((paramq != null) && (paramq.a(this, null, null)))
      {
        AppMethodBeat.o(128133);
        return;
      }
      Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */