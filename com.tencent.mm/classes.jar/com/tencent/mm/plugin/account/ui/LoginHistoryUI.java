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
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.cj;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class LoginHistoryUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String idu;
  protected int loginType;
  protected ProgressDialog lzP;
  private SecurityImage pRw;
  protected String pYt;
  private int pZA;
  protected TextView pZa;
  protected Button pZb;
  protected View pZc;
  protected Button pZd;
  protected Button pZe;
  private View pZf;
  protected Button pZg;
  protected f pZh;
  protected String pZi;
  protected String pZj;
  private String pZk;
  private String pZl;
  private ImageView pZm;
  protected String pZn;
  protected String pZo;
  private String pZp;
  private com.tencent.mm.platformtools.b pZq;
  protected LinearLayout pZr;
  private Button pZs;
  protected String pZt;
  protected boolean pZu;
  protected boolean pZv;
  private int pZw;
  private int pZx;
  protected int[] pZy;
  private IListener pZz;
  protected EditText qaR;
  protected Button qaS;
  protected View qaT;
  protected View qaU;
  protected LinearLayout qaV;
  protected LinearLayout qaW;
  protected MMFormInputView qaX;
  protected MMFormVerifyCodeInputView qaY;
  private boolean qaZ;
  private String qba;
  private SharedPreferences sp;
  
  public LoginHistoryUI()
  {
    AppMethodBeat.i(128117);
    this.lzP = null;
    this.pRw = null;
    this.pZh = new f();
    this.idu = "";
    this.pZt = "";
    this.pZu = false;
    this.qaZ = false;
    this.pZy = new int[5];
    this.pZz = new LoginHistoryUI.1(this, com.tencent.mm.app.f.hfK);
    this.pZA = 0;
    AppMethodBeat.o(128117);
  }
  
  private void Tp(String paramString)
  {
    AppMethodBeat.i(128131);
    this.pZt = paramString;
    bXX();
    AppMethodBeat.o(128131);
  }
  
  private void Tq(final String paramString)
  {
    AppMethodBeat.i(128132);
    Log.i("MicroMsg.LoginHistoryUI", "requestSms %s", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      getString(r.j.app_tip);
      this.lzP = k.a(this, getString(r.j.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(304931);
          com.tencent.mm.kernel.h.aZW().a(paramString);
          AppMethodBeat.o(304931);
        }
      });
    }
    AppMethodBeat.o(128132);
  }
  
  public static void U(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128136);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128136);
  }
  
  private void e(u paramu)
  {
    AppMethodBeat.i(128134);
    Log.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", new Object[] { Integer.valueOf(hashCode()), Util.getStack() });
    Intent localIntent = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
    localIntent.addFlags(67108864);
    if (paramu != null)
    {
      localIntent.putExtra("kstyle_show_bind_mobile_afterauth", paramu.bMn());
      localIntent.putExtra("kstyle_bind_recommend_show", paramu.bMq());
      localIntent.putExtra("kstyle_bind_wording", paramu.bMo());
    }
    paramu = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramu.aYi(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramu.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(128134);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128122);
    Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
    ((Intent)localObject).addFlags(67108864);
    if (Util.isNullOrNil(this.pZl)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.nf(this);
    AppMethodBeat.o(128122);
  }
  
  private boolean p(final int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128135);
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
        break label794;
      }
      if (this.pRw != null) {
        this.pRw.dismiss();
      }
      AppMethodBeat.o(128135);
      return true;
    case -3: 
      if (this.pZA <= 0)
      {
        k.s(this, r.j.errcode_password, r.j.login_err_title);
        this.pZA += 1;
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        k.b(this, getString(r.j.errcode_password_ask_if_forgot_pwd), getString(r.j.login_err_title), getString(r.j.errcode_password_go_forgot_pwd), getString(r.j.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305217);
            LoginHistoryUI.g(LoginHistoryUI.this);
            AppMethodBeat.o(305217);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305222);
            LoginHistoryUI.h(LoginHistoryUI.this);
            AppMethodBeat.o(305222);
          }
        });
      }
    case -1: 
      if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
      {
        k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128135);
        return true;
      }
    case -9: 
      k.s(this, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128135);
      return true;
    case -72: 
      k.s(this, r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
      AppMethodBeat.o(128135);
      return true;
    case -75: 
      v.ei(this);
      AppMethodBeat.o(128135);
      return true;
    case -32: 
      k.d(this, getString(r.j.bind_mcontact_verify_error), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128099);
          AppMethodBeat.o(128099);
        }
      });
      AppMethodBeat.o(128135);
      return true;
    case -33: 
      k.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128100);
          AppMethodBeat.o(128100);
        }
      });
      AppMethodBeat.o(128135);
      return true;
    case -311: 
    case -310: 
    case -6: 
      com.tencent.mm.kernel.h.aZW().a(701, this);
      com.tencent.mm.kernel.h.aZW().a(252, this);
      if (this.pRw == null) {
        this.pRw = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA, new DialogInterface.OnClickListener()
        {
          public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            int i = -1;
            AppMethodBeat.i(305265);
            Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + LoginHistoryUI.this.pZh.pRz + " img len" + LoginHistoryUI.this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
            int j = paramInt1;
            if (LoginHistoryUI.this.pZt == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = Util.secPrint(LoginHistoryUI.this.pZt);
              if (LoginHistoryUI.this.pZh.pRx != null) {
                break label381;
              }
            }
            for (;;)
            {
              Log.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), Util.secPrint(LoginHistoryUI.this.pZh.pRx) });
              paramAnonymousDialogInterface = new u(LoginHistoryUI.this.pZh.account, LoginHistoryUI.this.pZh.pRx, LoginHistoryUI.this.pZh.qbo, LoginHistoryUI.i(LoginHistoryUI.this).getSecImgCode(), LoginHistoryUI.i(LoginHistoryUI.this).getSecImgSid(), LoginHistoryUI.i(LoginHistoryUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((Util.isNullOrNil(LoginHistoryUI.this.pZh.pRx)) && (!Util.isNullOrNil(LoginHistoryUI.this.pZt)))
              {
                Log.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { Util.secPrint(LoginHistoryUI.this.pZt) });
                paramAnonymousDialogInterface.OY(LoginHistoryUI.this.pZt);
              }
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              LoginHistoryUI localLoginHistoryUI1 = LoginHistoryUI.this;
              LoginHistoryUI localLoginHistoryUI2 = LoginHistoryUI.this;
              LoginHistoryUI.this.getString(r.j.app_tip);
              localLoginHistoryUI1.lzP = k.a(localLoginHistoryUI2, LoginHistoryUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(304897);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aZW().b(701, LoginHistoryUI.this);
                  com.tencent.mm.kernel.h.aZW().b(252, LoginHistoryUI.this);
                  AppMethodBeat.o(304897);
                }
              });
              AppMethodBeat.o(305265);
              return;
              paramAnonymousInt = LoginHistoryUI.this.pZt.length();
              break;
              label381:
              i = LoginHistoryUI.this.pZh.pRx.length();
            }
          }
        }, null, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(305260);
            LoginHistoryUI.j(LoginHistoryUI.this);
            AppMethodBeat.o(305260);
          }
        }, this.pZh);
      }
      for (;;)
      {
        AppMethodBeat.o(128135);
        return true;
        Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.pZh.pRz + " img len" + this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
        this.pRw.b(this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA);
      }
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aZH();
      com.tencent.mm.kernel.h.baC();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
      for (paramString = com.tencent.mm.cd.a.bt(this, r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aZu())
      {
        k.a(this, paramString, getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128102);
            AppMethodBeat.o(128102);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128135);
        return true;
        com.tencent.mm.kernel.h.baC();
      }
    case -205: 
      Log.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.pYt), this.pZk });
      f.a(this.pZh);
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.pYt);
      paramString.putExtra("binded_mobile", this.pZj);
      paramString.putExtra("close_safe_device_style", this.pZk);
      paramString.putExtra("from_source", 2);
      com.tencent.mm.plugin.account.sdk.a.pFn.g(this, paramString);
      AppMethodBeat.o(128135);
      return true;
    }
    if (!Util.isNullOrNil(this.idu)) {
      v.r(this, paramString, this.idu);
    }
    AppMethodBeat.o(128135);
    return true;
    label794:
    paramString = new aa(paramInt1, paramInt2, paramString);
    boolean bool = this.pZq.a(this, paramString);
    AppMethodBeat.o(128135);
    return bool;
  }
  
  protected final String Tu(String paramString)
  {
    AppMethodBeat.i(128125);
    PhoneFormater localPhoneFormater = new PhoneFormater();
    String str1 = "86";
    Object localObject = paramString;
    if (this.pZn.startsWith("+"))
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
  
  protected final void bXW()
  {
    AppMethodBeat.i(128126);
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    AppMethodBeat.o(128126);
  }
  
  protected void bXX()
  {
    AppMethodBeat.i(128128);
    this.pZh.account = this.pZn.trim();
    AppMethodBeat.o(128128);
  }
  
  public boolean bYb()
  {
    return false;
  }
  
  protected final void bYc()
  {
    AppMethodBeat.i(128127);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    AppMethodBeat.o(128127);
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
    this.pZr = ((LinearLayout)findViewById(r.f.voice_print_ll));
    this.qaW = ((LinearLayout)findViewById(r.f.face_print_ll));
    this.qaV = ((LinearLayout)findViewById(r.f.finger_print_ll));
    this.qaX = ((MMFormInputView)findViewById(r.f.login_password_input));
    this.qaY = ((MMFormVerifyCodeInputView)findViewById(r.f.sms_verify_container));
    this.pZl = getIntent().getStringExtra("switch_login_wx_id");
    if (!Util.isNullOrNil(this.pZl))
    {
      this.pZn = cj.ono.getString(this.pZl, "login_user_name");
      this.pZp = cj.ono.getString(this.pZl, "last_avatar_path");
      this.pZx = Util.safeParseInt(cj.ono.getString(this.pZl, "last_bind_info"));
      if ((this.pZx & 0x1) != 0) {
        this.pZi = cj.ono.getString(this.pZl, "last_login_bind_qq");
      }
      if ((this.pZx & 0x4) != 0) {
        this.pZj = cj.ono.getString(this.pZl, "last_login_bind_mobile");
      }
      this.pZw = Util.safeParseInt(cj.ono.getString(this.pZl, "last_login_use_voice"));
      setBackBtn(new LoginHistoryUI.27(this), r.i.actionbar_icon_close_black);
    }
    for (;;)
    {
      Object localObject = getIntent().getStringExtra("email_address");
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equalsIgnoreCase(this.pZn))) {
        this.pZn = ((String)localObject);
      }
      this.pZm = ((ImageView)findViewById(r.f.last_avatar));
      if (!Util.isNullOrNil(this.pZp)) {}
      try
      {
        localObject = AvatarStorage.LL(this.pZp);
        if ((localObject != null) && (((Bitmap)localObject).getWidth() > 10)) {
          this.pZm.setImageBitmap(Bitmap.createBitmap((Bitmap)localObject, 5, 5, ((Bitmap)localObject).getWidth() - 10, ((Bitmap)localObject).getHeight() - 10, null, false));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LoginHistoryUI", localException, "get avatar error", new Object[0]);
          continue;
          this.pZy[2] = 2;
          if (!Util.isNullOrNil(this.pZo))
          {
            this.pZa.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.pZo));
          }
          else
          {
            this.pZa.setText(this.pZn);
            continue;
            if (!LocaleUtil.isSimplifiedChineseAppLang())
            {
              this.pZg.setText(r.j.wechat_help_center);
              this.pZg.setOnClickListener(new LoginHistoryUI.3(this));
            }
            else
            {
              this.pZg.setText(r.j.wechat_safe_center);
              this.pZg.setOnClickListener(new LoginHistoryUI.4(this));
              continue;
              if (aw.ato()) {
                this.pZs.setText(getResources().getString(r.j.fold_login_in_pad));
              } else {
                this.pZs.setText(getResources().getString(r.j.login_as_other_device));
              }
            }
          }
        }
      }
      this.pZa = ((TextView)findViewById(r.f.login_account_auto));
      this.qaR = this.qaX.getContentEditText();
      this.qaS = ((Button)findViewById(r.f.login_btn));
      this.pZc = findViewById(r.f.login_voice_btn);
      this.qaT = findViewById(r.f.login_face_btn);
      this.qaU = ((Button)findViewById(r.f.shua_fingerprint_btn));
      this.pZb = ((Button)findViewById(r.f.login_change_btn));
      this.pZs = ((Button)findViewById(r.f.login_as_other_device_btn));
      this.pZd = ((Button)findViewById(r.f.login_find_password_btn));
      this.pZe = ((Button)findViewById(r.f.login_freeze_account_btn));
      this.pZf = findViewById(r.f.free_btn_container);
      this.pZg = ((Button)findViewById(r.f.login_more_btn));
      this.pZd.setOnClickListener(new LoginHistoryUI.28(this));
      this.pZe.setOnClickListener(new LoginHistoryUI.29(this));
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        this.pZf.setVisibility(8);
      }
      this.qaX.setVisibility(8);
      this.pZr.setVisibility(8);
      this.qaW.setVisibility(8);
      this.qaV.setVisibility(8);
      this.qaS.setVisibility(8);
      this.pZc.setVisibility(8);
      this.qaT.setVisibility(8);
      this.qaU.setVisibility(8);
      this.pZb.setVisibility(8);
      com.tencent.mm.ui.tools.b.c.i(this.qaR).oF(4, 16).a(null);
      if ((!Util.isPhoneNumber(this.pZn).booleanValue()) || (this.pZn.equals(this.pZi))) {
        break;
      }
      this.pZy[2] = 1;
      this.pZa.setText(Tu(this.pZn));
      localObject = new com.tencent.mm.ui.widget.a.f(this, 1, false);
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(305120);
          if (paramAnonymouss.size() == 0)
          {
            paramAnonymouss.oh(7002, r.j.login_by_others);
            paramAnonymouss.oh(7003, r.j.intro_create_account_qq);
            paramAnonymouss.oh(7004, r.j.wechat_safe_center);
            if (!LocaleUtil.isSimplifiedChineseAppLang()) {
              paramAnonymouss.oh(7009, r.j.wechat_help_center);
            }
          }
          AppMethodBeat.o(305120);
        }
      };
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new LoginHistoryUI.31(this);
      ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new LoginHistoryUI.32(this);
      if (!Util.isNullOrNil(this.pZl)) {
        break label1109;
      }
      this.pZg.setOnClickListener(new LoginHistoryUI.2(this, (com.tencent.mm.ui.widget.a.f)localObject));
      setMMTitle("");
      setActionbarColor(getResources().getColor(r.c.normal_actionbar_color));
      hideActionbarLine();
      setBackBtnVisible(false);
      if (ChannelUtil.shouldShowGprsAlert) {
        com.tencent.mm.plugin.account.sdk.a.pFo.u(this);
      }
      if (!BuildInfo.EX_DEVICE_LOGIN)
      {
        if ((aw.jkP()) || (aw.ato())) {
          localObject = d.pWz;
        }
      }
      else
      {
        this.pZs.setVisibility(0);
        if ((!aw.jkP()) || (aw.ato())) {
          break label1171;
        }
        this.pZs.setText(getResources().getString(r.j.login_in_pad_and_phone));
        this.pZs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(128091);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginHistoryUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.br.c.ai(LoginHistoryUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            LoginHistoryUI.this.overridePendingTransition(r.a.push_down_in, r.a.anim_not_change);
            com.tencent.mm.plugin.report.service.h.OAn.tJ(4L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128091);
          }
        });
      }
      if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
        this.pZd.setVisibility(8);
      }
      AppMethodBeat.o(128124);
      return;
      this.pZn = bg.okT.aM("login_user_name", "");
      this.pZo = bg.okT.aM("last_login_nick_name", "");
      this.pZp = bg.okT.bCr();
      this.pZx = Util.safeParseInt(bg.okT.aM("last_bind_info", ""));
      if ((this.pZx & 0x1) != 0) {
        this.pZi = bg.okT.aM("last_login_bind_qq", "");
      }
      if ((this.pZx & 0x4) != 0) {
        this.pZj = bg.okT.aM("last_login_bind_mobile", "");
      }
      this.pZw = Util.safeParseInt(bg.okT.aM("last_login_use_voice", ""));
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
      Tp(str);
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
          Tp(paramIntent);
          AppMethodBeat.o(128130);
          return;
        }
      }
    }
    else if ((paramInt1 == 31685) && (paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getBundleExtra("result_data");
      if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("auth_again"))) {
        bXX();
      }
    }
    label311:
    AppMethodBeat.o(128130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128118);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.sdk.a.pFo });
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.qaZ = paramBundle.getBooleanExtra("login_success_need_bind_fingerprint", false);
      this.qaZ = this.qaZ;
      if (this.qaZ) {
        this.qba = paramBundle.getStringExtra("bind_login_fingerprint_info");
      }
    }
    initView();
    this.pZq = new com.tencent.mm.platformtools.b();
    AppMethodBeat.o(128118);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128119);
    Log.i("MicroMsg.LoginHistoryUI", "onDestroy");
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    if (this.pZq != null) {
      this.pZq.close();
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(14262, new Object[] { Integer.valueOf(this.pZy[0]), Integer.valueOf(this.pZy[1]), Integer.valueOf(this.pZy[2]), Integer.valueOf(this.pZy[3]), Integer.valueOf(this.pZy[4]) });
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
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
    this.pZz.dead();
    AppMethodBeat.o(128121);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128120);
    super.onResume();
    Object localObject1 = new ArrayList();
    int i;
    if (!WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned())
    {
      i = 1;
      if ((i != 0) && (this.loginType != 1) && ((this.pZw & 0x20000) != 0))
      {
        localObject2 = new t(this, 7001, 0);
        ((t)localObject2).setTitle(r.j.login_login_by_voice_print);
        ((List)localObject1).add(localObject2);
      }
      if ((this.loginType != 5) && ((this.pZw & 0x40000) != 0))
      {
        localObject2 = new t(this, 7005, 0);
        ((t)localObject2).setTitle(r.j.login_login_by_finger_print);
        ((List)localObject1).add(localObject2);
      }
      if ((bYb()) && (this.loginType != 4) && ((this.pZw & 0x400000) != 0))
      {
        localObject2 = new t(this, 7006, 0);
        ((t)localObject2).setTitle(r.j.login_login_by_face_print);
        ((List)localObject1).add(localObject2);
      }
      if (!Util.isNullOrNil(this.pZn))
      {
        if (this.loginType != 2)
        {
          localObject2 = new t(this, 7007, 0);
          ((t)localObject2).setTitle(getString(r.j.login_login_by_password));
          ((List)localObject1).add(localObject2);
        }
        if ((!Util.isNullOrNil(this.pZj)) && (this.loginType != 3))
        {
          localObject2 = new t(this, 7008, 0);
          ((t)localObject2).setTitle(getString(r.j.login_login_by_sms));
          ((List)localObject1).add(localObject2);
        }
        if (this.pZn.equalsIgnoreCase(this.pZi)) {
          this.qaR.setHint(getString(r.j.regbyqq_password_hint));
        }
      }
      if (((List)localObject1).size() <= 1) {
        break label476;
      }
      Object localObject2 = new com.tencent.mm.ui.widget.a.f(this, 1, false);
      ((com.tencent.mm.ui.widget.a.f)localObject2).Vtg = new LoginHistoryUI.20(this, (List)localObject1);
      ((com.tencent.mm.ui.widget.a.f)localObject2).GAC = new LoginHistoryUI.21(this);
      ((com.tencent.mm.ui.widget.a.f)localObject2).aeLi = new f.b()
      {
        public final void onDismiss() {}
      };
      this.pZb.setVisibility(0);
      this.pZb.setText(r.j.login_by_other_method);
      this.pZb.setOnClickListener(new LoginHistoryUI.24(this, (com.tencent.mm.ui.widget.a.f)localObject2));
    }
    for (;;)
    {
      this.pZz.alive();
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.kernel.b.aZS();
      if ((!com.tencent.mm.kernel.h.baz()) || (!com.tencent.mm.kernel.h.baC().mBZ) || (this.pZn.equals(""))) {
        break label556;
      }
      if ((this.lzP == null) || (!this.lzP.isShowing())) {
        break label544;
      }
      AppMethodBeat.o(128120);
      return;
      i = 0;
      break;
      label476:
      if (((List)localObject1).size() > 0)
      {
        this.pZb.setVisibility(0);
        this.pZb.setText(((t)((List)localObject1).get(0)).getTitle());
        this.pZb.setOnClickListener(new LoginHistoryUI.25(this, (List)localObject1));
      }
      else
      {
        this.pZb.setVisibility(8);
      }
    }
    label544:
    e(null);
    AppMethodBeat.o(128120);
    return;
    label556:
    if (com.tencent.mm.m.a.aTd() == 2)
    {
      localObject1 = new e.a(this);
      ((e.a)localObject1).aEK(r.j.check_db_size_tip_dangerous_title);
      ((e.a)localObject1).bDw(getString(r.j.check_db_size_tip_dangerous_message));
      ((e.a)localObject1).NC(false);
      ((e.a)localObject1).aER(r.j.check_db_size_btn_dangerous_message).c(new LoginHistoryUI.22(this));
      ((e.a)localObject1).jHH().show();
      com.tencent.mm.m.a.b(this, System.currentTimeMillis());
    }
    AppMethodBeat.o(128120);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(128133);
    Log.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Log.i("MicroMsg.LoginHistoryUI", "Scene Type " + paramp.getType());
    com.tencent.mm.broadcast.a locala;
    if (paramp.getType() == 145)
    {
      if ((this.lzP != null) && (this.lzP.isShowing()))
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          locala = com.tencent.mm.broadcast.a.CH(paramString);
          if (((com.tencent.mm.modelfriend.a)paramp).bIT() != 1) {
            break label231;
          }
          Log.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
          if (locala != null)
          {
            locala.a(this, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(304926);
                LoginHistoryUI.f(LoginHistoryUI.this);
                AppMethodBeat.o(304926);
              }
            }, null);
            AppMethodBeat.o(128133);
            return;
          }
          k.a(this, getString(r.j.login_by_sms_up_tip), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(304932);
              LoginHistoryUI.f(LoginHistoryUI.this);
              AppMethodBeat.o(304932);
            }
          }, null);
        }
      }
    }
    while (p(paramInt1, paramInt2, paramString))
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
            AppMethodBeat.i(128095);
            LoginHistoryUI.this.qaY.cHv();
            LoginHistoryUI.a(LoginHistoryUI.this, LoginHistoryUI.this.pZj);
            AppMethodBeat.o(128095);
          }
        }, null);
        AppMethodBeat.o(128133);
        return;
      }
      this.qaY.cHv();
      Tq(this.pZj);
      continue;
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          k.s(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          this.qaY.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -75)
        {
          k.c(this, getString(r.j.alpha_version_tip_login), "", true);
          this.qaY.reset();
          AppMethodBeat.o(128133);
          return;
        }
        if (paramInt2 == -106)
        {
          v.f(this, paramString, 32045);
          this.qaY.reset();
          AppMethodBeat.o(128133);
        }
      }
      else if (i == 17)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          new h(new h.a()
          {
            public final void b(ProgressDialog paramAnonymousProgressDialog)
            {
              LoginHistoryUI.this.lzP = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramp).getUsername(), ((com.tencent.mm.modelfriend.a)paramp).bIP(), this.pZj).d(this);
          AppMethodBeat.o(128133);
          return;
        }
        if (p(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128133);
          return;
        }
        paramp = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramp != null)
        {
          paramp.a(this, null, null);
          continue;
          if ((paramp.getType() == 252) || (paramp.getType() == 701))
          {
            this.idu = ((u)paramp).bMh();
            Log.e("MicroMsg.LoginHistoryUI", "url " + this.idu);
            com.tencent.mm.kernel.h.aZW().b(701, this);
            com.tencent.mm.kernel.h.aZW().b(252, this);
            this.pZh.qbo = ((u)paramp).getSecCodeType();
            this.pZh.pRz = ((u)paramp).bMi();
            this.pZh.pRy = ((u)paramp).bMj();
            this.pZh.pRA = ((u)paramp).bMk();
            if (paramInt2 == -205)
            {
              this.pYt = ((u)paramp).bIR();
              this.pZj = ((u)paramp).bMm();
              this.pZk = ((u)paramp).bMp();
            }
            if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
              break label1092;
            }
            com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
            {
              public final void b(g paramAnonymousg)
              {
                AppMethodBeat.i(305229);
                if (paramAnonymousg == null)
                {
                  AppMethodBeat.o(305229);
                  return;
                }
                paramAnonymousg = paramAnonymousg.bGg();
                com.tencent.mm.kernel.h.baC();
                int i = com.tencent.mm.kernel.b.getUin();
                paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
                AppMethodBeat.o(305229);
              }
            }), 0);
          }
        }
      }
    }
    label1092:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.b.aZI();
        i.bXa();
        v.Sj(this.pZh.account);
        if ((this.lzP != null) && (this.lzP.isShowing())) {
          this.lzP.setMessage(getString(r.j.app_loading));
        }
        e((u)paramp);
        if (this.loginType == 3)
        {
          this.pZv = ((u)paramp).bMr();
          if (((u)paramp).bMl())
          {
            boolean bool = this.pZv;
            paramString = new Intent(this, RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
            paramString.putExtra("kintent_cancelable", bool);
            paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramString.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128133);
        return;
      }
      if ((this.lzP != null) && (this.lzP.isShowing()))
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      if (paramInt2 == -106)
      {
        v.f(this, paramString, 31685);
        AppMethodBeat.o(128133);
        return;
      }
      if (paramInt2 == -217)
      {
        v.a(this, com.tencent.mm.platformtools.e.d((u)paramp), paramInt2);
        AppMethodBeat.o(128133);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128133);
        return;
      }
      paramp = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramp != null) && (paramp.a(this, null, null)))
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(305064);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mvvmbase.b.a.class);
    paramHashSet.add(com.tencent.mm.plugin.account.ui.a.a.class);
    AppMethodBeat.o(305064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI
 * JD-Core Version:    0.7.0.1
 */