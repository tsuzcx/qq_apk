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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
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
public abstract class BaseLoginVoiceUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String idu = "";
  protected int loginType;
  protected ProgressDialog lzP = null;
  private SecurityImage pRw = null;
  protected String pYt;
  private int pZA = 0;
  protected TextView pZa;
  protected Button pZb;
  protected View pZc;
  protected Button pZd;
  protected Button pZe;
  private View pZf;
  protected Button pZg;
  protected f pZh = new f();
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
  protected String pZt = "";
  protected boolean pZu = false;
  protected boolean pZv;
  private int pZw;
  private int pZx;
  protected int[] pZy = new int[5];
  private IListener pZz = new BaseLoginVoiceUI.1(this, com.tencent.mm.app.f.hfK);
  private SharedPreferences sp;
  
  private void Tp(String paramString)
  {
    this.pZt = paramString;
    bXX();
  }
  
  private void Tq(final String paramString)
  {
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
          AppMethodBeat.i(305052);
          com.tencent.mm.kernel.h.aZW().a(paramString);
          AppMethodBeat.o(305052);
        }
      });
    }
  }
  
  public static void U(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
  }
  
  private void e(u paramu)
  {
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
    com.tencent.mm.hellhoundlib.a.a.b(this, paramu.aYi(), "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramu.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI", "startLauncher", "(Lcom/tencent/mm/modelsimple/NetSceneManualAuth;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
  }
  
  private void goBack()
  {
    Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
    ((Intent)localObject).addFlags(67108864);
    if (Util.isNullOrNil(this.pZl)) {
      ((Intent)localObject).putExtra("can_finish", true);
    }
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.ui.base.b.nf(this);
  }
  
  private boolean p(final int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (!com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
        break label714;
      }
      if (this.pRw != null) {
        this.pRw.dismiss();
      }
      return true;
    case -3: 
      if (this.pZA <= 0)
      {
        k.s(this, r.j.errcode_password, r.j.login_err_title);
        this.pZA += 1;
      }
      for (;;)
      {
        return true;
        k.b(this, getString(r.j.errcode_password_ask_if_forgot_pwd), getString(r.j.login_err_title), getString(r.j.errcode_password_go_forgot_pwd), getString(r.j.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305018);
            BaseLoginVoiceUI.g(BaseLoginVoiceUI.this);
            AppMethodBeat.o(305018);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305016);
            BaseLoginVoiceUI.h(BaseLoginVoiceUI.this);
            AppMethodBeat.o(305016);
          }
        });
      }
    case -1: 
      if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
      {
        k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        return true;
      }
    case -9: 
      k.s(this, r.j.login_err_mailnotverify, r.j.login_err_title);
      return true;
    case -72: 
      k.s(this, r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
      return true;
    case -75: 
      v.ei(this);
      return true;
    case -32: 
      k.d(this, getString(r.j.bind_mcontact_verify_error), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return true;
    case -33: 
      k.a(this, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
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
            AppMethodBeat.i(305034);
            Log.d("MicroMsg.LoginHistoryUI", "imgSid:" + BaseLoginVoiceUI.this.pZh.pRz + " img len" + BaseLoginVoiceUI.this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
            int j = paramInt1;
            if (BaseLoginVoiceUI.this.pZt == null)
            {
              paramAnonymousInt = -1;
              paramAnonymousDialogInterface = Util.secPrint(BaseLoginVoiceUI.this.pZt);
              if (BaseLoginVoiceUI.this.pZh.pRx != null) {
                break label381;
              }
            }
            for (;;)
            {
              Log.d("MicroMsg.LoginHistoryUI", "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(paramAnonymousInt), paramAnonymousDialogInterface, Integer.valueOf(i), Util.secPrint(BaseLoginVoiceUI.this.pZh.pRx) });
              paramAnonymousDialogInterface = new u(BaseLoginVoiceUI.this.pZh.account, BaseLoginVoiceUI.this.pZh.pRx, BaseLoginVoiceUI.this.pZh.qbo, BaseLoginVoiceUI.i(BaseLoginVoiceUI.this).getSecImgCode(), BaseLoginVoiceUI.i(BaseLoginVoiceUI.this).getSecImgSid(), BaseLoginVoiceUI.i(BaseLoginVoiceUI.this).getSecImgEncryptKey(), 0, "", false, false);
              if ((Util.isNullOrNil(BaseLoginVoiceUI.this.pZh.pRx)) && (!Util.isNullOrNil(BaseLoginVoiceUI.this.pZt)))
              {
                Log.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", new Object[] { Util.secPrint(BaseLoginVoiceUI.this.pZt) });
                paramAnonymousDialogInterface.OY(BaseLoginVoiceUI.this.pZt);
              }
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              BaseLoginVoiceUI localBaseLoginVoiceUI1 = BaseLoginVoiceUI.this;
              BaseLoginVoiceUI localBaseLoginVoiceUI2 = BaseLoginVoiceUI.this;
              BaseLoginVoiceUI.this.getString(r.j.app_tip);
              localBaseLoginVoiceUI1.lzP = k.a(localBaseLoginVoiceUI2, BaseLoginVoiceUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(305163);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aZW().b(701, BaseLoginVoiceUI.this);
                  com.tencent.mm.kernel.h.aZW().b(252, BaseLoginVoiceUI.this);
                  AppMethodBeat.o(305163);
                }
              });
              AppMethodBeat.o(305034);
              return;
              paramAnonymousInt = BaseLoginVoiceUI.this.pZt.length();
              break;
              label381:
              i = BaseLoginVoiceUI.this.pZh.pRx.length();
            }
          }
        }, null, new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(305032);
            BaseLoginVoiceUI.j(BaseLoginVoiceUI.this);
            AppMethodBeat.o(305032);
          }
        }, this.pZh);
      }
      for (;;)
      {
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
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
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
      return true;
    }
    if (!Util.isNullOrNil(this.idu)) {
      v.r(this, paramString, this.idu);
    }
    return true;
    label714:
    paramString = new aa(paramInt1, paramInt2, paramString);
    return this.pZq.a(this, paramString);
  }
  
  protected final void bXW()
  {
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
  }
  
  protected void bXX()
  {
    this.pZh.account = this.pZn.trim();
  }
  
  public boolean bXY()
  {
    return !WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned();
  }
  
  public void hideVKB()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getCurrentFocus();
      } while (localObject == null);
      localObject = ((View)localObject).getWindowToken();
    } while (localObject == null);
    localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
  }
  
  public void initView()
  {
    this.pZr = ((LinearLayout)findViewById(r.f.voice_print_ll));
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
      setBackBtn(new BaseLoginVoiceUI.27(this), r.i.actionbar_icon_close_black);
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
          TextView localTextView;
          String str2;
          PhoneFormater localPhoneFormater;
          String str1;
          String str3;
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
              this.pZg.setOnClickListener(new BaseLoginVoiceUI.3(this));
            }
            else
            {
              this.pZg.setText(r.j.wechat_safe_center);
              this.pZg.setOnClickListener(new BaseLoginVoiceUI.4(this));
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
      this.pZc = findViewById(r.f.login_voice_btn);
      this.pZb = ((Button)findViewById(r.f.login_change_btn));
      this.pZs = ((Button)findViewById(r.f.login_as_other_device_btn));
      this.pZd = ((Button)findViewById(r.f.login_find_password_btn));
      this.pZe = ((Button)findViewById(r.f.login_freeze_account_btn));
      this.pZf = findViewById(r.f.free_btn_container);
      this.pZg = ((Button)findViewById(r.f.login_more_btn));
      this.pZd.setOnClickListener(new BaseLoginVoiceUI.28(this));
      this.pZe.setOnClickListener(new BaseLoginVoiceUI.29(this));
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        this.pZf.setVisibility(8);
      }
      this.pZc.setVisibility(8);
      this.pZb.setVisibility(8);
      if ((!Util.isPhoneNumber(this.pZn).booleanValue()) || (this.pZn.equals(this.pZi))) {
        break;
      }
      this.pZy[2] = 1;
      localTextView = this.pZa;
      str2 = this.pZn;
      localPhoneFormater = new PhoneFormater();
      str1 = "86";
      localObject = str2;
      if (this.pZn.startsWith("+"))
      {
        str3 = str2.replace("+", "");
        str2 = PhoneFormater.extractCountryCode(str3);
        str1 = str2;
        localObject = str3;
        if (str2 != null)
        {
          localObject = str3.substring(str2.length());
          str1 = str2;
        }
      }
      localTextView.setText(localPhoneFormater.formatNumber(str1, (String)localObject));
      localObject = new com.tencent.mm.ui.widget.a.f(this, 1, false);
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(304947);
          if (paramAnonymouss.size() == 0)
          {
            paramAnonymouss.oh(7002, r.j.login_by_others);
            paramAnonymouss.oh(7003, r.j.intro_create_account_qq);
            paramAnonymouss.oh(7004, r.j.wechat_safe_center);
            if (!LocaleUtil.isSimplifiedChineseAppLang()) {
              paramAnonymouss.oh(7009, r.j.wechat_help_center);
            }
          }
          AppMethodBeat.o(304947);
        }
      };
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new BaseLoginVoiceUI.31(this);
      ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new BaseLoginVoiceUI.32(this);
      if (!Util.isNullOrNil(this.pZl)) {
        break label985;
      }
      this.pZg.setOnClickListener(new BaseLoginVoiceUI.2(this, (com.tencent.mm.ui.widget.a.f)localObject));
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
          break label1047;
        }
        this.pZs.setText(getResources().getString(r.j.login_in_pad_and_phone));
        this.pZs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(305055);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            c.ai(BaseLoginVoiceUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            BaseLoginVoiceUI.this.overridePendingTransition(r.a.push_down_in, r.a.anim_not_change);
            com.tencent.mm.plugin.report.service.h.OAn.tJ(4L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305055);
          }
        });
      }
      if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
        this.pZd.setVisibility(8);
      }
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
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      Log.d("MicroMsg.LoginHistoryUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt1 != 1024) || (paramIntent == null)) {
        break label162;
      }
      if (paramInt2 == -1)
      {
        str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
        paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
        bool = Util.isNullOrNil(str);
        if (!Util.isNullOrNil(str)) {
          break label153;
        }
        paramInt1 = i;
        label106:
        Log.d("MicroMsg.LoginHistoryUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Tp(str);
      }
    }
    label153:
    label162:
    label243:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
          paramInt1 = str.length();
          break label106;
          if ((paramInt1 != 1025) || (paramIntent == null)) {
            break label243;
          }
        } while (paramInt2 != 2);
        paramIntent = paramIntent.getStringExtra("KFaceLoginAuthPwd");
        bool = Util.isNullOrNil(paramIntent);
        if (Util.isNullOrNil(paramIntent)) {}
        for (paramInt1 = j;; paramInt1 = paramIntent.length())
        {
          Log.i("MicroMsg.LoginHistoryUI", "hy: onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1) });
          Tp(paramIntent);
          return;
        }
      } while ((paramInt1 != 31685) || (paramIntent == null) || (paramInt2 != -1));
      paramIntent = paramIntent.getBundleExtra("result_data");
    } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("auth_again")));
    bXX();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("MicroMsg.LoginHistoryUI", "AccountSyncApplication.modelCallback %s", new Object[] { com.tencent.mm.plugin.account.sdk.a.pFo });
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.sp = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    initView();
    this.pZq = new com.tencent.mm.platformtools.b();
  }
  
  public void onDestroy()
  {
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
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      goBack();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.pZz.dead();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((bXY()) && (this.loginType != 1) && ((this.pZw & 0x20000) != 0))
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
    }
    if (((List)localObject1).size() > 1)
    {
      localObject2 = new com.tencent.mm.ui.widget.a.f(this, 1, false);
      ((com.tencent.mm.ui.widget.a.f)localObject2).Vtg = new BaseLoginVoiceUI.20(this, (List)localObject1);
      ((com.tencent.mm.ui.widget.a.f)localObject2).GAC = new BaseLoginVoiceUI.21(this);
      ((com.tencent.mm.ui.widget.a.f)localObject2).aeLi = new f.b()
      {
        public final void onDismiss() {}
      };
      this.pZb.setVisibility(0);
      this.pZb.setText(r.j.login_by_other_method);
      this.pZb.setOnClickListener(new BaseLoginVoiceUI.24(this, (com.tencent.mm.ui.widget.a.f)localObject2));
      this.pZz.alive();
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.kernel.b.aZS();
      if ((!com.tencent.mm.kernel.h.baz()) || (!com.tencent.mm.kernel.h.baC().mBZ) || (this.pZn.equals(""))) {
        break label442;
      }
      if ((this.lzP == null) || (!this.lzP.isShowing())) {
        break label436;
      }
    }
    label436:
    label442:
    while (com.tencent.mm.m.a.aTd() != 2)
    {
      return;
      if (((List)localObject1).size() > 0)
      {
        this.pZb.setVisibility(0);
        this.pZb.setText(((t)((List)localObject1).get(0)).getTitle());
        this.pZb.setOnClickListener(new BaseLoginVoiceUI.25(this, (List)localObject1));
        break;
      }
      this.pZb.setVisibility(8);
      break;
      e(null);
      return;
    }
    localObject1 = new e.a(this);
    ((e.a)localObject1).aEK(r.j.check_db_size_tip_dangerous_title);
    ((e.a)localObject1).bDw(getString(r.j.check_db_size_tip_dangerous_message));
    ((e.a)localObject1).NC(false);
    ((e.a)localObject1).aER(r.j.check_db_size_btn_dangerous_message).c(new BaseLoginVoiceUI.22(this));
    ((e.a)localObject1).jHH().show();
    com.tencent.mm.m.a.b(this, System.currentTimeMillis());
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
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
            break label213;
          }
          Log.i("MicroMsg.LoginHistoryUI", "login check state, sms up");
          if (locala != null)
          {
            locala.a(this, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(305066);
                BaseLoginVoiceUI.f(BaseLoginVoiceUI.this);
                AppMethodBeat.o(305066);
              }
            }, null);
            return;
          }
          k.a(this, getString(r.j.login_by_sms_up_tip), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(305075);
              BaseLoginVoiceUI.f(BaseLoginVoiceUI.this);
              AppMethodBeat.o(305075);
            }
          }, null);
        }
      }
    }
    for (;;)
    {
      label202:
      if (p(paramInt1, paramInt2, paramString))
      {
        return;
        label213:
        if (locala != null)
        {
          locala.a(this, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(305065);
              BaseLoginVoiceUI.a(BaseLoginVoiceUI.this, BaseLoginVoiceUI.this.pZj);
              AppMethodBeat.o(305065);
            }
          }, null);
          return;
        }
        Tq(this.pZj);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            k.s(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
            return;
          }
          if (paramInt2 == -75)
          {
            k.c(this, getString(r.j.alpha_version_tip_login), "", true);
            return;
          }
          if (paramInt2 == -106) {
            v.f(this, paramString, 32045);
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
                BaseLoginVoiceUI.this.lzP = paramAnonymousProgressDialog;
              }
            }, ((com.tencent.mm.modelfriend.a)paramp).getUsername(), ((com.tencent.mm.modelfriend.a)paramp).bIP(), this.pZj).d(this);
            return;
          }
          if (p(paramInt1, paramInt2, paramString)) {
            break;
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
                break label970;
              }
              com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
              {
                public final void b(g paramAnonymousg)
                {
                  AppMethodBeat.i(305022);
                  if (paramAnonymousg == null)
                  {
                    AppMethodBeat.o(305022);
                    return;
                  }
                  paramAnonymousg = paramAnonymousg.bGg();
                  com.tencent.mm.kernel.h.baC();
                  int i = com.tencent.mm.kernel.b.getUin();
                  paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
                  AppMethodBeat.o(305022);
                }
              }), 0);
            }
          }
        }
      }
    }
    label970:
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
        if (this.loginType != 3) {
          break;
        }
        this.pZv = ((u)paramp).bMr();
        if (!((u)paramp).bMl()) {
          break;
        }
        boolean bool = this.pZv;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(r.j.settings_modify_password_tip));
        paramString.putExtra("kintent_cancelable", bool);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/BaseLoginVoiceUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        return;
      }
      if (paramInt2 == -217)
      {
        v.a(this, com.tencent.mm.platformtools.e.d((u)paramp), paramInt2);
        return;
      }
      if (p(paramInt1, paramInt2, paramString)) {
        break;
      }
      paramp = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramp != null) && (paramp.a(this, null, null))) {
        break;
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break label202;
      break;
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
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.account.ui.a.a.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI
 * JD-Core Version:    0.7.0.1
 */