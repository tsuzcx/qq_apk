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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.ci;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
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
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.f;
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
  private String fXu;
  protected ProgressDialog iXX;
  protected int loginType;
  private SecurityImage mUP;
  protected String nbl;
  private IListener ncA;
  protected TextView ndC;
  protected EditText ndD;
  protected Button ndE;
  protected Button ndF;
  protected View ndG;
  protected View ndH;
  protected View ndI;
  protected Button ndJ;
  protected Button ndK;
  private View ndL;
  protected Button ndM;
  protected String ndN;
  protected String ndO;
  private String ndP;
  private ImageView ndQ;
  private MMKeyboardUperView ndR;
  private ResizeLayout ndS;
  protected String ndT;
  protected String ndU;
  private String ndV;
  private com.tencent.mm.platformtools.b ndW;
  protected LinearLayout ndX;
  protected LinearLayout ndY;
  protected LinearLayout ndZ;
  protected g ndj;
  protected boolean ndk;
  private String ndn;
  protected String ndo;
  protected MMFormInputView nea;
  protected MMFormVerifyCodeInputView neb;
  private Button nec;
  protected boolean ned;
  private int nee;
  private int nef;
  private boolean neg;
  private String neh;
  protected int[] nei;
  private int nej;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(128117);
    this.iXX = null;
    this.mUP = null;
    this.ndj = new g();
    this.fXu = "";
    this.ndo = "";
    this.ned = false;
    this.neg = false;
    this.nei = new int[5];
    this.ncA = new LoginHistoryUI.1(this);
    this.nej = 0;
    AppMethodBeat.o(128117);
  }
  
  public static void W(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128136);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    com.tencent.mm.by.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128136);
  }
  
  private void aaZ(String paramString)
  {
    AppMethodBeat.i(128131);
    this.ndo = paramString;
    bzr();
    AppMethodBeat.o(128131);
  }
  
  private void aba(String paramString)
  {
    AppMethodBeat.i(128132);
    Log.i("MicroMsg.LoginHistoryUI", "requestSms %s", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
      getString(r.j.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.app_waiting), true, new LoginHistoryUI.8(this, paramString));
    }
    AppMethodBeat.o(128132);
  }
  
  private void e(com.tencent.mm.modelsimple.t paramt)
  {
    AppMethodBeat.i(128134);
    Log.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    Intent localIntent = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
    localIntent.addFlags(67108864);
    if (paramt != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramt.boG());
      localIntent.putExtra("kstyle_bind_recommend_show", paramt.boJ());
      localIntent.putExtra("kstyle_bind_wording", paramt.boH());
    }
    paramt = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramt.aFh(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramt.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(128134);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128122);
    Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
    ((Intent)localObject).addFlags(67108864);
    if (Util.isNullOrNil(this.ndP)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.lb(this);
    AppMethodBeat.o(128122);
  }
  
  private boolean n(final int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128135);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString)) {
        break label796;
      }
      if (this.mUP != null) {
        this.mUP.dismiss();
      }
      AppMethodBeat.o(128135);
      return true;
    case -3: 
      if (this.nej <= 0)
      {
        com.tencent.mm.ui.base.h.p(this, r.j.errcode_password, r.j.login_err_title);
        this.nej += 1;
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.ui.base.h.c(this, getString(r.j.errcode_password_ask_if_forgot_pwd), getString(r.j.login_err_title), getString(r.j.errcode_password_go_forgot_pwd), getString(r.j.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      if (com.tencent.mm.kernel.h.aGY().bih() == 5)
      {
        com.tencent.mm.ui.base.h.p(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128135);
        return true;
      }
    case -9: 
      com.tencent.mm.ui.base.h.p(this, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128135);
      return true;
    case -72: 
      com.tencent.mm.ui.base.h.p(this, r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
      AppMethodBeat.o(128135);
      return true;
    case -75: 
      y.dw(this);
      AppMethodBeat.o(128135);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.d(this, getString(r.j.bind_mcontact_verify_error), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
      return true;
    case -33: 
      com.tencent.mm.ui.base.h.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128135);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.h.aGY().a(701, this);
      com.tencent.mm.kernel.h.aGY().a(252, this);
      if (this.mUP == null) {
        this.mUP = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            int i = -1;
            AppMethodBeat.i(128102);
            Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.ndj.mUS + " img len" + LoginHistoryUI.this.ndj.mUR.length + " " + com.tencent.mm.compatible.util.f.avD());
            int j = paramInt1;
            if (LoginHistoryUI.this.ndo == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = Util.secPrint(LoginHistoryUI.this.ndo);
              if (LoginHistoryUI.this.ndj.mUQ != null) {
                break label381;
              }
            }
            for (;;)
            {
              Log.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), Util.secPrint(LoginHistoryUI.this.ndj.mUQ) });
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginHistoryUI.this.ndj.account, LoginHistoryUI.this.ndj.mUQ, LoginHistoryUI.this.ndj.neB, LoginHistoryUI.j(LoginHistoryUI.this).getSecImgCode(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgSid(), LoginHistoryUI.j(LoginHistoryUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((Util.isNullOrNil(LoginHistoryUI.this.ndj.mUQ)) && (!Util.isNullOrNil(LoginHistoryUI.this.ndo)))
              {
                Log.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { Util.secPrint(LoginHistoryUI.this.ndo) });
                paramAnonymousDialogInterface.WY(LoginHistoryUI.this.ndo);
              }
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(r.j.app_tip);
              localLoginHistoryUI1.iXX = com.tencent.mm.ui.base.h.a(localLoginHistoryUI2, LoginHistoryUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128101);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aGY().b(701, LoginHistoryUI.this);
                  com.tencent.mm.kernel.h.aGY().b(252, LoginHistoryUI.this);
                  AppMethodBeat.o(128101);
                }
              });
              AppMethodBeat.o(128102);
              return;
              paramAnonymousInt = LoginHistoryUI.this.ndo.length();
              break;
              label381:
              i = LoginHistoryUI.this.ndj.mUQ.length();
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
        }, this.ndj);
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.ndj.mUS + " img len" + this.ndj.mUR.length + " " + com.tencent.mm.compatible.util.f.avD());
        this.mUP.b(this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT);
      }
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aGF();
      com.tencent.mm.kernel.h.aHE();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aGs())) {}
      for (paramString = com.tencent.mm.ci.a.ba(this, r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aGs())
      {
        com.tencent.mm.ui.base.h.a(this, paramString, getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.kernel.h.aHE();
      }
    case -205: 
      Log.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.nbl), this.ndn });
      g.a(this.ndj);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.nbl);
      paramString.putExtra("binded_mobile", this.ndO);
      paramString.putExtra("close_safe_device_style", this.ndn);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.sdk.a.mIG.g(this, paramString);
      AppMethodBeat.o(128135);
      return true;
    }
    if (!Util.isNullOrNil(this.fXu)) {
      y.p(this, paramString, this.fXu);
    }
    AppMethodBeat.o(128135);
    return true;
    label796:
    paramString = new ad(paramInt1, paramInt2, paramString);
    boolean bool = this.ndW.a(this, paramString);
    AppMethodBeat.o(128135);
    return bool;
  }
  
  protected final String aaY(String paramString)
  {
    AppMethodBeat.i(128125);
    PhoneFormater localPhoneFormater = new PhoneFormater();
    String str1 = "86";
    Object localObject = paramString;
    if (this.ndT.startsWith("+"))
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
  
  protected void bzr()
  {
    AppMethodBeat.i(128128);
    this.ndj.account = this.ndT.trim();
    AppMethodBeat.o(128128);
  }
  
  protected final void bzs()
  {
    AppMethodBeat.i(128126);
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    AppMethodBeat.o(128126);
  }
  
  protected final void bzt()
  {
    AppMethodBeat.i(128127);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    AppMethodBeat.o(128127);
  }
  
  public boolean bzu()
  {
    AppMethodBeat.i(217857);
    if (!WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned())
    {
      AppMethodBeat.o(217857);
      return true;
    }
    AppMethodBeat.o(217857);
    return false;
  }
  
  public int getLayoutId()
  {
    return r.g.login_history;
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
    this.ndX = ((LinearLayout)findViewById(r.f.voice_print_ll));
    this.ndZ = ((LinearLayout)findViewById(r.f.face_print_ll));
    this.ndY = ((LinearLayout)findViewById(r.f.finger_print_ll));
    this.nea = ((MMFormInputView)findViewById(r.f.login_password_input));
    this.neb = ((MMFormVerifyCodeInputView)findViewById(r.f.sms_verify_container));
    this.ndP = getIntent().getStringExtra("switch_login_wx_id");
    if (!Util.isNullOrNil(this.ndP))
    {
      this.ndT = ci.lvQ.getString(this.ndP, "login_user_name");
      this.ndV = ci.lvQ.getString(this.ndP, "last_avatar_path");
      this.nef = Util.safeParseInt(ci.lvQ.getString(this.ndP, "last_bind_info"));
      if ((this.nef & 0x1) != 0) {
        this.ndN = ci.lvQ.getString(this.ndP, "last_login_bind_qq");
      }
      if ((this.nef & 0x4) != 0) {
        this.ndO = ci.lvQ.getString(this.ndP, "last_login_bind_mobile");
      }
      this.nee = Util.safeParseInt(ci.lvQ.getString(this.ndP, "last_login_use_voice"));
      setBackBtn(new LoginHistoryUI.29(this), r.i.actionbar_icon_close_black);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.ndT))) {
        this.ndT = ((String)localObject);
      }
      this.ndQ = ((ImageView)findViewById(r.f.last_avatar));
      if (!Util.isNullOrNil(this.ndV)) {}
      try
      {
        localObject = com.tencent.mm.am.f.TL(this.ndV);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.ndQ.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
          continue;
          this.nei[2] = 2;
          if (!Util.isNullOrNil(this.ndU))
          {
            this.ndC.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), this.ndU));
          }
          else
          {
            this.ndC.setText(this.ndT);
            continue;
            if (!LocaleUtil.isSimplifiedChineseAppLang())
            {
              this.ndM.setText(r.j.wechat_help_center);
              this.ndM.setOnClickListener(new LoginHistoryUI.5(this));
            }
            else
            {
              this.ndM.setText(r.j.wechat_safe_center);
              this.ndM.setOnClickListener(new LoginHistoryUI.6(this));
              continue;
              this.nec.setText(getResources().getString(r.j.login_as_other_device));
            }
          }
        }
      }
      this.ndR = ((MMKeyboardUperView)findViewById(r.f.scrollView));
      this.ndC = ((TextView)findViewById(r.f.login_account_auto));
      this.ndD = this.nea.getContentEditText();
      this.ndE = ((Button)findViewById(r.f.login_btn));
      this.ndG = findViewById(r.f.login_voice_btn);
      this.ndH = findViewById(r.f.login_face_btn);
      this.ndI = ((Button)findViewById(r.f.shua_fingerprint_btn));
      this.ndF = ((Button)findViewById(r.f.login_change_btn));
      this.nec = ((Button)findViewById(r.f.login_as_other_device_btn));
      this.ndJ = ((Button)findViewById(r.f.login_find_password_btn));
      this.ndK = ((Button)findViewById(r.f.login_freeze_account_btn));
      this.ndL = findViewById(r.f.free_btn_container);
      this.ndM = ((Button)findViewById(r.f.login_more_btn));
      this.ndJ.setOnClickListener(new LoginHistoryUI.30(this));
      this.ndK.setOnClickListener(new LoginHistoryUI.31(this));
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        this.ndL.setVisibility(8);
      }
      this.nea.setVisibility(8);
      this.ndX.setVisibility(8);
      this.ndZ.setVisibility(8);
      this.ndY.setVisibility(8);
      this.ndE.setVisibility(8);
      this.ndG.setVisibility(8);
      this.ndH.setVisibility(8);
      this.ndI.setVisibility(8);
      this.ndF.setVisibility(8);
      com.tencent.mm.ui.tools.b.c.i(this.ndD).mM(4, 16).a(null);
      this.ndS = ((ResizeLayout)findViewById(r.f.resize_lv));
      if ((!Util.isPhoneNumber(this.ndT).booleanValue()) || (this.ndT.equals(this.ndN))) {
        break;
      }
      this.nei[2] = 1;
      this.ndC.setText(aaY(this.ndT));
      this.ndS.setOnSizeChanged(new ResizeLayout.a()
      {
        public final void bzv()
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
      this.ndR.setOnTouchListener(new LoginHistoryUI.33(this));
      localObject = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(128116);
          if (paramAnonymouso.size() == 0)
          {
            paramAnonymouso.mn(7002, r.j.login_by_others);
            paramAnonymouso.mn(7003, r.j.intro_create_account_qq);
            paramAnonymouso.mn(7004, r.j.wechat_safe_center);
            if (!LocaleUtil.isSimplifiedChineseAppLang()) {
              paramAnonymouso.mn(7009, r.j.wechat_help_center);
            }
          }
          AppMethodBeat.o(128116);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject).ODU = new LoginHistoryUI.2(this);
      ((com.tencent.mm.ui.widget.a.e)localObject).XbB = new LoginHistoryUI.3(this);
      if (!Util.isNullOrNil(this.ndP)) {
        break label1168;
      }
      this.ndM.setOnClickListener(new LoginHistoryUI.4(this, (com.tencent.mm.ui.widget.a.e)localObject));
      setMMTitle("");
      setActionbarColor(getResources().getColor(r.c.normal_actionbar_color));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (ChannelUtil.shouldShowGprsAlert) {
        com.tencent.mm.plugin.account.sdk.a.mIH.s(this);
      }
      if (!BuildInfo.EX_DEVICE_LOGIN)
      {
        if ((ar.hIE()) && (!ar.hIM())) {
          localObject = com.tencent.mm.plugin.account.model.d.mZQ;
        }
      }
      else
      {
        this.nec.setVisibility(0);
        if ((!ar.hIE()) || (ar.hIM())) {
          break label1230;
        }
        this.nec.setText(getResources().getString(r.j.login_in_pad_and_phone));
        this.nec.setOnClickListener(new LoginHistoryUI.7(this));
      }
      if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
        this.ndJ.setVisibility(8);
      }
      AppMethodBeat.o(128124);
      return;
      this.ndT = bg.ltv.aD("login_user_name", "");
      this.ndU = bg.ltv.aD("last_login_nick_name", "");
      this.ndV = bg.ltv.beA();
      this.nef = Util.safeParseInt(bg.ltv.aD("last_bind_info", ""));
      if ((this.nef & 0x1) != 0) {
        this.ndN = bg.ltv.aD("last_login_bind_qq", "");
      }
      if ((this.nef & 0x4) != 0) {
        this.ndO = bg.ltv.aD("last_login_bind_mobile", "");
      }
      this.nee = Util.safeParseInt(bg.ltv.aD("last_login_use_voice", ""));
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
        break label176;
      }
      if (paramInt2 != -1) {
        break label314;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = Util.isNullOrNil(str);
      if (!Util.isNullOrNil(str)) {
        break label167;
      }
    }
    label167:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      Log.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      aaZ(str);
      AppMethodBeat.o(128130);
      return;
      bool = false;
      break;
    }
    label176:
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
          aaZ(paramIntent);
          AppMethodBeat.o(128130);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        bzr();
      }
    }
    label314:
    AppMethodBeat.o(128130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.sdk.a.mIH });
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.neg = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.neg = this.neg;
      if (this.neg) {
        this.neh = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.ndW = new com.tencent.mm.platformtools.b();
    AppMethodBeat.o(128118);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128119);
    Log.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    if (this.ndW != null) {
      this.ndW.close();
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(14262, new Object[] { Integer.valueOf(this.nei[0]), Integer.valueOf(this.nei[1]), Integer.valueOf(this.nei[2]), Integer.valueOf(this.nei[3]), Integer.valueOf(this.nei[4]) });
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
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
    EventCenter.instance.removeListener(this.ncA);
    AppMethodBeat.o(128121);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128120);
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((bzu()) && (this.loginType != 1) && ((this.nee & 0x20000) != 0))
    {
      localObject2 = new p(this, 7001, 0);
      ((p)localObject2).setTitle(r.j.login_login_by_voice_print);
      ((List)localObject1).add(localObject2);
    }
    if ((this.loginType != 5) && ((this.nee & 0x40000) != 0))
    {
      localObject2 = new p(this, 7005, 0);
      ((p)localObject2).setTitle(r.j.login_login_by_finger_print);
      ((List)localObject1).add(localObject2);
    }
    if (!Util.isNullOrNil(this.ndT))
    {
      if (this.loginType != 2)
      {
        localObject2 = new p(this, 7007, 0);
        ((p)localObject2).setTitle(getString(r.j.login_login_by_password));
        ((List)localObject1).add(localObject2);
      }
      if ((!Util.isNullOrNil(this.ndO)) && (this.loginType != 3))
      {
        localObject2 = new p(this, 7008, 0);
        ((p)localObject2).setTitle(getString(r.j.login_login_by_sms));
        ((List)localObject1).add(localObject2);
      }
      if (this.ndT.equalsIgnoreCase(this.ndN)) {
        this.ndD.setHint(getString(r.j.regbyqq_password_hint));
      }
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.e(this, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject2).ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(128105);
          if (paramAnonymouso.size() == 0)
          {
            Iterator localIterator = this.nen.iterator();
            while (localIterator.hasNext()) {
              paramAnonymouso.h((p)localIterator.next());
            }
          }
          AppMethodBeat.o(128105);
        }
      };
      ((com.tencent.mm.ui.widget.a.e)localObject2).ODU = new LoginHistoryUI.24(this);
      ((com.tencent.mm.ui.widget.a.e)localObject2).XbB = new e.b()
      {
        public final void onDismiss() {}
      };
      this.ndF.setVisibility(0);
      this.ndF.setText(r.j.login_by_other_method);
      this.ndF.setOnClickListener(new LoginHistoryUI.26(this, (com.tencent.mm.ui.widget.a.e)localObject2));
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.ncA);
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.kernel.b.aGS();
      if ((!com.tencent.mm.kernel.h.aHB()) || (!com.tencent.mm.kernel.h.aHE().kbT) || (this.ndT.equals(""))) {
        break label492;
      }
      if ((this.iXX == null) || (!this.iXX.isShowing())) {
        break;
      }
      AppMethodBeat.o(128120);
      return;
      if (((List)localObject1).size() > 0)
      {
        this.ndF.setVisibility(0);
        this.ndF.setText(((p)((List)localObject1).get(0)).getTitle());
        this.ndF.setOnClickListener(new LoginHistoryUI.27(this, (List)localObject1));
      }
      else
      {
        this.ndF.setVisibility(8);
      }
    }
    e(null);
    AppMethodBeat.o(128120);
    return;
    label492:
    if (com.tencent.mm.p.a.aAi() == 2)
    {
      localObject1 = new d.a(this);
      ((d.a)localObject1).ayc(r.j.check_db_size_tip_dangerous_title);
      ((d.a)localObject1).bBd(getString(r.j.check_db_size_tip_dangerous_message));
      ((d.a)localObject1).HG(false);
      ((d.a)localObject1).ayj(r.j.check_db_size_btn_dangerous_message).c(new LoginHistoryUI.22(this));
      ((d.a)localObject1).icu().show();
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
      if ((this.iXX != null) && (this.iXX.isShowing()))
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          locala = com.tencent.mm.h.a.Kb(paramString);
          if (((com.tencent.mm.modelfriend.a)paramq).bkZ() != 1) {
            break label234;
          }
          Log.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
          if (locala != null)
          {
            locala.a(this, new LoginHistoryUI.9(this), null);
            AppMethodBeat.o(128133);
            return;
          }
          com.tencent.mm.ui.base.h.a(this, getString(r.j.login_by_sms_up_tip), "", new LoginHistoryUI.10(this), null);
        }
      }
    }
    while (n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128133);
      return;
      label234:
      if (locala != null)
      {
        locala.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128097);
            LoginHistoryUI.this.neb.cgz();
            LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.ndO);
            AppMethodBeat.o(128097);
          }
        }, null);
        AppMethodBeat.o(128133);
        return;
      }
      this.neb.cgz();
      aba(this.ndO);
      continue;
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          this.neb.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(r.j.alpha_version_tip_login), "", true);
          this.neb.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -106)
        {
          y.f(this, paramString, 32045);
          this.neb.reset();
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
              LoginHistoryUI.this.iXX = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bkV(), this.ndO).c(this);
          AppMethodBeat.o(128133);
          return;
        }
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128133);
          return;
        }
        paramq = com.tencent.mm.h.a.Kb(paramString);
        if (paramq != null)
        {
          paramq.a(this, null, null);
          continue;
          if ((paramq.getType() == 252) || (paramq.getType() == 701))
          {
            this.fXu = ((com.tencent.mm.modelsimple.t)paramq).boA();
            Log.e("MicroMsg.LoginHistoryUI", "url " + this.fXu);
            com.tencent.mm.kernel.h.aGY().b(701, this);
            com.tencent.mm.kernel.h.aGY().b(252, this);
            this.ndj.neB = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
            this.ndj.mUS = ((com.tencent.mm.modelsimple.t)paramq).boB();
            this.ndj.mUR = ((com.tencent.mm.modelsimple.t)paramq).boC();
            this.ndj.mUT = ((com.tencent.mm.modelsimple.t)paramq).boD();
            if (paramInt2 == -205)
            {
              this.nbl = ((com.tencent.mm.modelsimple.t)paramq).bkX();
              this.ndO = ((com.tencent.mm.modelsimple.t)paramq).boF();
              this.ndn = ((com.tencent.mm.modelsimple.t)paramq).boI();
            }
            if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
              break label1100;
            }
            com.tencent.mm.kernel.h.aGY().a(new bv(new LoginHistoryUI.13(this)), 0);
          }
        }
      }
    }
    label1100:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.b.aGG();
        com.tencent.mm.plugin.account.friend.a.l.byn();
        com.tencent.mm.platformtools.t.jdMethod_do(this);
        y.ZV(this.ndj.account);
        if ((this.iXX != null) && (this.iXX.isShowing())) {
          this.iXX.setMessage(getString(r.j.app_loading));
        }
        e((com.tencent.mm.modelsimple.t)paramq);
        if (this.loginType == 3)
        {
          this.ndk = ((com.tencent.mm.modelsimple.t)paramq).boK();
          if (((com.tencent.mm.modelsimple.t)paramq).boE())
          {
            boolean bool = this.ndk;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
            paramString.putExtra("kintent_cancelable", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128133);
        return;
      }
      if ((this.iXX != null) && (this.iXX.isShowing()))
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      if (paramInt2 == -106)
      {
        y.f(this, paramString, 31685);
        AppMethodBeat.o(128133);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128133);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128133);
        return;
      }
      paramq = com.tencent.mm.h.a.Kb(paramString);
      if ((paramq != null) && (paramq.a(this, null, null)))
      {
        AppMethodBeat.o(128133);
        return;
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */