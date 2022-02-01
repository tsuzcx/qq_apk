package com.tencent.mm.plugin.account.ui;

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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.ce.j;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.ad.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
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
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(1)
public class LoginUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h
{
  private String hFb;
  private String hYq;
  private String idu;
  private ProgressDialog lzP;
  private String pQb;
  private SecurityImage pRw;
  private String pYt;
  protected Button pZd;
  protected Button pZe;
  private View pZf;
  protected Button pZg;
  private f pZh;
  private String pZj;
  private String pZk;
  private com.tencent.mm.platformtools.b pZq;
  private Button pZs;
  private IListener pZz;
  private boolean qaE;
  private String qaF;
  private Button qbA;
  private boolean qbB;
  final boolean[] qbC;
  private com.tencent.mm.platformtools.u qbk;
  private MMClearEditText qbv;
  private MMClearEditText qbw;
  private MMFormInputView qbx;
  private MMFormInputView qby;
  private Button qbz;
  private int sceneType;
  private TextWatcher vU;
  
  public LoginUI()
  {
    AppMethodBeat.i(128229);
    this.lzP = null;
    this.hFb = null;
    this.pRw = null;
    this.pZh = new f();
    this.idu = "";
    this.sceneType = 0;
    this.vU = new TextWatcher()
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
    this.qbB = false;
    this.pZz = new LoginUI.2(this, com.tencent.mm.app.f.hfK);
    this.qbC = new boolean[] { true };
    this.hYq = "";
    this.qbk = new com.tencent.mm.platformtools.u();
    AppMethodBeat.o(128229);
  }
  
  private static void U(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128235);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128235);
  }
  
  private void bXX()
  {
    AppMethodBeat.i(128240);
    this.pZh.account = this.qbv.getText().toString().trim();
    this.pZh.pRx = this.qbw.getText().toString();
    if (this.pZh.account.equals(""))
    {
      com.tencent.mm.ui.base.k.s(this, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128240);
      return;
    }
    if (this.pZh.pRx.equals(""))
    {
      com.tencent.mm.ui.base.k.s(this, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128240);
      return;
    }
    hideVKB();
    this.qbk.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169137);
        LoginUI.k(LoginUI.this);
        AppMethodBeat.o(169137);
      }
    });
    AppMethodBeat.o(128240);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128237);
    hideVKB();
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    com.tencent.mm.pluginsdk.model.app.u.iIC();
    finish();
    AppMethodBeat.o(128237);
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128238);
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128238);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      paramString = new aa(paramInt1, paramInt2, paramString);
      boolean bool = this.pZq.a(this, paramString);
      AppMethodBeat.o(128238);
      return bool;
    case -1: 
      if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
      {
        com.tencent.mm.ui.base.k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128238);
        return true;
      }
      AppMethodBeat.o(128238);
      return false;
    case -3: 
      com.tencent.mm.ui.base.k.s(this, r.j.errcode_password, r.j.login_err_title);
      AppMethodBeat.o(128238);
      return true;
    case -9: 
      com.tencent.mm.ui.base.k.s(this, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128238);
      return true;
    case -72: 
      com.tencent.mm.ui.base.k.s(getContext(), r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
      AppMethodBeat.o(128238);
      return true;
    case -75: 
      v.ei(getContext());
      AppMethodBeat.o(128238);
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
            AppMethodBeat.i(128216);
            if (LoginUI.g(LoginUI.this) == null)
            {
              Log.e("MicroMsg.LoginUI", "secimg is null!");
              AppMethodBeat.o(128216);
              return;
            }
            Log.d("MicroMsg.LoginUI", "imgSid:" + LoginUI.h(LoginUI.this).pRz + " img len" + LoginUI.h(LoginUI.this).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
            paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.u(LoginUI.h(LoginUI.this).account, LoginUI.h(LoginUI.this).pRx, LoginUI.h(LoginUI.this).qbo, LoginUI.g(LoginUI.this).getSecImgCode(), LoginUI.g(LoginUI.this).getSecImgSid(), LoginUI.g(LoginUI.this).getSecImgEncryptKey(), 2, "", false, false);
            com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
            LoginUI localLoginUI1 = LoginUI.this;
            LoginUI localLoginUI2 = LoginUI.this;
            LoginUI.this.getString(r.j.app_tip);
            LoginUI.a(localLoginUI1, com.tencent.mm.ui.base.k.a(localLoginUI2, LoginUI.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(128215);
                com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                com.tencent.mm.kernel.h.aZW().b(701, LoginUI.this);
                com.tencent.mm.kernel.h.aZW().b(252, LoginUI.this);
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
            LoginUI.i(LoginUI.this);
            AppMethodBeat.o(128217);
          }
        }, this.pZh);
      }
      for (;;)
      {
        AppMethodBeat.o(128238);
        return true;
        Log.d("MicroMsg.LoginUI", "imgSid:" + this.pZh.pRz + " img len" + this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
        this.pRw.b(this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA);
      }
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aZH();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.h.baC();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
      for (paramString = com.tencent.mm.cd.a.bt(getContext(), r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aZu())
      {
        com.tencent.mm.ui.base.k.a(localAppCompatActivity, paramString, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128218);
            LoginUI.j(LoginUI.this);
            AppMethodBeat.o(128218);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128219);
            LoginUI.j(LoginUI.this);
            AppMethodBeat.o(128219);
          }
        });
        AppMethodBeat.o(128238);
        return true;
        com.tencent.mm.kernel.h.baC();
      }
    case -205: 
      Log.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.pYt), this.pZk });
      f.a(this.pZh);
      com.tencent.mm.plugin.b.a.TA("L600_100");
      paramString = new Intent();
      paramString.putExtra("auth_ticket", this.pYt);
      paramString.putExtra("binded_mobile", this.pZj);
      paramString.putExtra("close_safe_device_style", this.pZk);
      paramString.putExtra("from_source", 1);
      com.tencent.mm.plugin.account.sdk.a.pFn.g(this, paramString);
      AppMethodBeat.o(128238);
      return true;
    }
    if (!Util.isNullOrNil(this.idu)) {
      v.r(this, paramString, this.idu);
    }
    AppMethodBeat.o(128238);
    return true;
  }
  
  public void finish()
  {
    AppMethodBeat.i(128241);
    super.finish();
    int i = r.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(128241);
  }
  
  public int getLayoutId()
  {
    return r.g.login;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128234);
    this.qbx = ((MMFormInputView)findViewById(r.f.login_account_auto));
    Object localObject = (TextView)findViewById(r.f.login_title);
    if (WeChatBrands.AppInfo.current().isMainland())
    {
      this.qbx.setHint(r.j.login_account_hint);
      ((TextView)localObject).setText(r.j.login_by_other_account_title);
      this.qby = ((MMFormInputView)findViewById(r.f.login_password_et));
      this.qbv = ((MMClearEditText)this.qbx.getContentEditText());
      this.qbw = ((MMClearEditText)this.qby.getContentEditText());
      com.tencent.mm.ui.tools.b.c.i(this.qbw).aEg(16).a(null);
      this.qbv.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128223);
          if (LoginUI.this.qbC[0] != 0)
          {
            LoginUI.this.qbC[0] = false;
            com.tencent.mm.plugin.normsg.a.d.MtP.aQh("ie_login_id");
          }
          com.tencent.mm.plugin.normsg.a.d.MtP.aQi("ie_login_id");
          AppMethodBeat.o(128223);
        }
      });
      this.qbv.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305129);
          paramAnonymousView = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.mvvmbase.b.a)com.tencent.mm.ui.component.k.d(LoginUI.this).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramAnonymousBoolean);
          AppMethodBeat.o(305129);
        }
      });
      this.qbw.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305122);
          paramAnonymousView = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.mvvmbase.b.a)com.tencent.mm.ui.component.k.d(LoginUI.this).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramAnonymousBoolean);
          AppMethodBeat.o(305122);
        }
      });
      this.qbz = ((Button)findViewById(r.f.login_btn));
      this.qbz.setEnabled(false);
      this.qbA = ((Button)findViewById(r.f.login_by_other));
      this.pZs = ((Button)findViewById(r.f.login_as_other_device_btn));
      this.pZd = ((Button)findViewById(r.f.login_find_password_btn));
      this.pZf = findViewById(r.f.free_btn_container);
      this.pZe = ((Button)findViewById(r.f.login_freeze_account_btn));
      this.pZg = ((Button)findViewById(r.f.login_more_btn));
      this.pZd.setOnClickListener(new LoginUI.25(this));
      this.pZe.setOnClickListener(new LoginUI.26(this));
      localObject = new com.tencent.mm.ui.widget.a.f(this, 1, false);
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(305110);
          if (paramAnonymouss.jmw())
          {
            paramAnonymouss.oh(5001, r.j.wechat_safe_center);
            paramAnonymouss.oh(5002, r.j.wechat_help_center);
          }
          AppMethodBeat.o(305110);
        }
      };
      ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new f.b()
      {
        public final void onDismiss() {}
      };
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new LoginUI.3(this);
      if (!LocaleUtil.isSimplifiedChineseAppLang()) {
        break label718;
      }
      this.pZg.setOnClickListener(new LoginUI.4(this));
      label361:
      setMMTitle("");
      setBackBtn(new LoginUI.6(this), r.i.actionbar_icon_close_black);
      localObject = new boolean[1];
      localObject[0] = 0;
      this.qbz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305250);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (this.qbm[0] != 0) {
            this.qbm[0] = false;
          }
          for (;;)
          {
            LoginUI.e(LoginUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305250);
            return;
            LoginUI.a(LoginUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(2));
            com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_login_id", "<LoginByID>", LoginUI.d(LoginUI.this));
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_login_id", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_login_id");
          }
        }
      });
      this.qbz.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(305246);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(305246);
            return false;
            this.qbm[0] = true;
            LoginUI.a(LoginUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(2));
            com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_login_id", "<LoginByID>", LoginUI.d(LoginUI.this));
            continue;
            com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_login_id", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_login_id");
          }
        }
      });
      this.qbA.setOnClickListener(new LoginUI.9(this));
      this.pYt = getIntent().getStringExtra("auth_ticket");
      if (!Util.isNullOrNil(this.pYt))
      {
        this.qbv.setText(Util.nullAsNil(f.bYd()));
        this.qbw.setText(Util.nullAsNil(f.bYe()));
        new MMHandler().postDelayed(new LoginUI.10(this), 500L);
      }
      this.qbv.addTextChangedListener(this.vU);
      this.qbw.addTextChangedListener(this.vU);
      this.qbw.setOnEditorActionListener(new LoginUI.11(this));
      this.qbw.setOnKeyListener(new LoginUI.12(this));
      if (ChannelUtil.shouldShowGprsAlert) {
        com.tencent.mm.plugin.account.sdk.a.pFo.u(this);
      }
      localObject = getIntent().getStringExtra("login_username");
      this.qbB = getIntent().getBooleanExtra("from_deep_link", false);
      if (!Util.isNullOrNil((String)localObject)) {
        this.qbv.setText((CharSequence)localObject);
      }
      if (!BuildInfo.EX_DEVICE_LOGIN)
      {
        if ((aw.jkP()) || (aw.ato())) {
          localObject = com.tencent.mm.plugin.account.model.d.pWz;
        }
      }
      else
      {
        this.pZs.setVisibility(0);
        if ((!aw.jkP()) || (aw.ato())) {
          break label756;
        }
        this.pZs.setText(getResources().getString(r.j.login_in_pad_and_phone));
      }
    }
    for (;;)
    {
      this.pZs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305084);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.br.c.ai(LoginUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
          LoginUI.this.overridePendingTransition(r.a.push_down_in, r.a.anim_not_change);
          com.tencent.mm.plugin.report.service.h.OAn.tJ(2L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305084);
        }
      });
      AppMethodBeat.o(128234);
      return;
      this.qbx.setHint(r.j.login_account_hint_oversea);
      ((TextView)localObject).setText(r.j.login_by_other_account_title_oversea);
      break;
      label718:
      this.pZf.setVisibility(8);
      this.pZg.setText(r.j.login_by_more);
      this.pZg.setOnClickListener(new LoginUI.5(this, (com.tencent.mm.ui.widget.a.f)localObject));
      break label361;
      label756:
      if (aw.ato()) {
        this.pZs.setText(getResources().getString(r.j.fold_login_in_pad));
      } else {
        this.pZs.setText(getResources().getString(r.j.login_as_other_device));
      }
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
      this.pZh.pRx = str;
      bXX();
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
        bXX();
      }
    }
    label239:
    AppMethodBeat.o(128242);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128230);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(r.c.normal_bg_color));
    paramBundle = "";
    if ((com.tencent.mm.protocal.d.Yxk) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(r.j.app_name) + j.mx(this);
    }
    this.sceneType = getIntent().getIntExtra("login_type", 0);
    setMMTitle(paramBundle);
    setActionbarColor(getResources().getColor(r.c.normal_actionbar_color));
    hideActionbarLine();
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.pQb = com.tencent.mm.plugin.b.a.chY();
    initView();
    this.pZq = new com.tencent.mm.platformtools.b();
    this.qaE = getIntent().getBooleanExtra("from_switch_account", false);
    this.qaF = bg.okT.aM("login_weixin_username", "");
    paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
    if (paramBundle != null) {
      com.tencent.mm.plugin.report.service.h.OAn.b(14262, new Object[] { Integer.valueOf(paramBundle[0]), Integer.valueOf(paramBundle[1]), Integer.valueOf(paramBundle[2]), Integer.valueOf(paramBundle[3]), Integer.valueOf(paramBundle[4]) });
    }
    com.tencent.mm.xwebutil.c.jQG();
    ad.a.avN(6);
    AppMethodBeat.o(128230);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128233);
    if (this.pZq != null) {
      this.pZq.close();
    }
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_login_id");
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
    this.pZz.dead();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("L100_100_logout") + ",2");
      AppMethodBeat.o(128232);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("L400_100_login") + ",2");
    }
    AppMethodBeat.o(128232);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169139);
    this.qbk.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169139);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128231);
    this.pZz.alive();
    super.onResume();
    StringBuilder localStringBuilder;
    if (this.sceneType == 0)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L100_100_logout,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("L100_100_logout") + ",1");
      com.tencent.mm.plugin.b.a.Tz("L100_100_logout");
      AppMethodBeat.o(128231);
      return;
    }
    if (this.sceneType == 1)
    {
      localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L400_100_login,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("L400_100_login") + ",1");
      com.tencent.mm.plugin.b.a.Tz("L400_100_login");
    }
    AppMethodBeat.o(128231);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(128239);
    Log.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramp.getType() != 252) && (paramp.getType() != 701))
    {
      AppMethodBeat.o(128239);
      return;
    }
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    this.idu = ((com.tencent.mm.modelsimple.u)paramp).bMh();
    this.pZh.pRz = ((com.tencent.mm.modelsimple.u)paramp).bMi();
    this.pZh.pRy = ((com.tencent.mm.modelsimple.u)paramp).bMj();
    this.pZh.pRA = ((com.tencent.mm.modelsimple.u)paramp).bMk();
    this.pZh.qbo = ((com.tencent.mm.modelsimple.u)paramp).getSecCodeType();
    this.pZh.account = ((com.tencent.mm.modelsimple.u)paramp).account;
    if (paramInt2 == -205)
    {
      this.pYt = ((com.tencent.mm.modelsimple.u)paramp).bIR();
      this.pZj = ((com.tencent.mm.modelsimple.u)paramp).bMm();
      this.pZk = ((com.tencent.mm.modelsimple.u)paramp).bMp();
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
      {
        public final void b(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128220);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128220);
            return;
          }
          paramAnonymousg = paramAnonymousg.bGg();
          com.tencent.mm.kernel.h.baC();
          int i = com.tencent.mm.kernel.b.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128220);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.b.aZI();
        i.bXa();
        v.Sj(this.pZh.account);
        paramString = bg.okT.aM("login_weixin_username", "");
        if (this.qaE)
        {
          cj.ono.bf(this.qaF, paramString);
          cj.ono.g(z.bAM(), z.bBM());
          com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
        }
        v.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128221);
            Log.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(LoginUI.this);
            ((Intent)localObject).addFlags(67108864);
            ((Intent)localObject).putExtra("kstyle_show_bind_mobile_afterauth", ((com.tencent.mm.modelsimple.u)paramp).bMn());
            ((Intent)localObject).putExtra("kstyle_bind_wording", ((com.tencent.mm.modelsimple.u)paramp).bMo());
            ((Intent)localObject).putExtra("kstyle_bind_recommend_show", ((com.tencent.mm.modelsimple.u)paramp).bMq());
            LoginUI localLoginUI = LoginUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localLoginUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localLoginUI, "com/tencent/mm/plugin/account/ui/LoginUI$26", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginUI.this.finish();
            AppMethodBeat.o(128221);
          }
        }, false, 2);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        paramString = paramString.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",4");
        if (this.qbB)
        {
          paramString = MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.aQe()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.OAn.b(11930, new Object[] { paramString, Integer.valueOf(4) });
        }
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -106)
      {
        v.f(this, paramString, 32644);
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -217)
      {
        v.a(this, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.u)paramp), paramInt2);
        AppMethodBeat.o(128239);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128239);
        return;
      }
      if (paramInt2 == -5)
      {
        if (WeChatBrands.AppInfo.current().isMainland())
        {
          Toast.makeText(this, getString(r.j.loginby_access_denied), 0).show();
          AppMethodBeat.o(128239);
          return;
        }
        Toast.makeText(this, getString(r.j.login_err_title), 0).show();
        AppMethodBeat.o(128239);
        return;
      }
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128239);
        return;
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128239);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(305098);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mvvmbase.b.a.class);
    AppMethodBeat.o(305098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI
 * JD-Core Version:    0.7.0.1
 */