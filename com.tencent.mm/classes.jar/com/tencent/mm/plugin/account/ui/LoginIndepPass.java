package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.s;

public class LoginIndepPass
  extends MMActivity
  implements i
{
  private String account;
  private String fXu;
  private ProgressDialog iXX;
  private String mTu;
  private s mUN;
  private SecurityImage mUP;
  private String nbl;
  private IListener ncA;
  private String ndO;
  private g ndj;
  private String ndn;
  private EditText nep;
  private String neq;
  private Button ner;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(128163);
    this.iXX = null;
    this.mUP = null;
    this.ndj = new g();
    this.ncA = new LoginIndepPass.1(this);
    AppMethodBeat.o(128163);
  }
  
  private void bzr()
  {
    AppMethodBeat.i(128169);
    Object localObject = this.nep.getText().toString();
    if (Util.isNullOrNil(this.account))
    {
      com.tencent.mm.ui.base.h.p(this, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128169);
      return;
    }
    if (((String)localObject).equals(""))
    {
      com.tencent.mm.ui.base.h.p(this, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128169);
      return;
    }
    hideVKB();
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    localObject = new com.tencent.mm.modelsimple.t(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    getString(r.j.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(this, getString(r.j.login_logining), true, new LoginIndepPass.16(this, (com.tencent.mm.modelsimple.t)localObject));
    AppMethodBeat.o(128169);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128171);
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128171);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(128171);
      return false;
    case -1: 
      if (com.tencent.mm.kernel.h.aGY().bih() == 5)
      {
        com.tencent.mm.ui.base.h.p(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128171);
        return true;
      }
      AppMethodBeat.o(128171);
      return false;
    case -4: 
    case -3: 
      com.tencent.mm.ui.base.h.p(this, r.j.errcode_password, r.j.login_err_title);
      AppMethodBeat.o(128171);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.p(this, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128171);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aGF();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.h.aHE();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aGs())) {}
      for (paramString = com.tencent.mm.ci.a.ba(getContext(), r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aGs())
      {
        com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramString, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128171);
        return true;
        com.tencent.mm.kernel.h.aHE();
      }
    }
    if (!Util.isNullOrNil(this.fXu)) {
      y.p(getContext(), paramString, this.fXu);
    }
    AppMethodBeat.o(128171);
    return true;
  }
  
  public int getLayoutId()
  {
    return r.g.login_indep_pass;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128168);
    this.nep = ((EditText)findViewById(r.f.indep_password));
    this.ner = ((Button)findViewById(r.f.login_tip));
    enableOptionMenu(false);
    addTextOptionMenu(0, getString(r.j.login_login), new LoginIndepPass.9(this));
    this.nep.addTextChangedListener(new LoginIndepPass.10(this));
    this.nep.setOnEditorActionListener(new LoginIndepPass.11(this));
    this.nep.setOnKeyListener(new LoginIndepPass.12(this));
    this.ner.setText(getString(r.j.login_login_by_sms));
    this.ner.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128159);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.ui.base.h.a(LoginIndepPass.this, LoginIndepPass.this.getString(r.j.regbymobile_reg_verify_mobile_msg) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(r.j.regbymobile_reg_verify_mobile_title), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128158);
            com.tencent.mm.kernel.h.aGY().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.modelfriend.a(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            com.tencent.mm.kernel.h.aGY().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(r.j.app_tip);
            LoginIndepPass.a(localLoginIndepPass1, com.tencent.mm.ui.base.h.a(localLoginIndepPass2, LoginIndepPass.this.getString(r.j.app_loading), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                AppMethodBeat.i(128157);
                com.tencent.mm.kernel.h.aGY().a(paramAnonymous2DialogInterface);
                com.tencent.mm.kernel.h.aGY().b(701, LoginIndepPass.this);
                com.tencent.mm.kernel.h.aGY().b(252, LoginIndepPass.this);
                AppMethodBeat.o(128157);
              }
            }));
            AppMethodBeat.o(128158);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128159);
      }
    });
    setBackBtn(new LoginIndepPass.14(this));
    this.nbl = getIntent().getStringExtra("auth_ticket");
    if (!Util.isNullOrNil(this.nbl)) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128161);
          LoginIndepPass.a(LoginIndepPass.this, g.bzw(), g.bzx());
          AppMethodBeat.o(128161);
        }
      }, 500L);
    }
    AppMethodBeat.o(128168);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(128172);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      Log.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = Util.isNullOrNil(str);
      if (!Util.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      Log.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      bzr();
      AppMethodBeat.o(128172);
      return;
      bool = false;
      break;
    }
    label178:
    AppMethodBeat.o(128172);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128164);
    super.onCreate(paramBundle);
    paramBundle = getString(r.j.login_indep_title);
    if ((d.RAG) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(r.j.app_name) + com.tencent.mm.cj.h.kv(this);
    }
    setMMTitle(paramBundle);
    this.neq = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.neq != null) {
      this.account = PhoneFormater.pureNumber(this.neq);
    }
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.mTu = com.tencent.mm.plugin.b.a.bAt();
    initView();
    AppMethodBeat.o(128164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128167);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128167);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128166);
    super.onPause();
    EventCenter.instance.removeListener(this.ncA);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("L200_200") + ",2");
    AppMethodBeat.o(128166);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128165);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.bgi("L200_200");
    AppMethodBeat.o(128165);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128170);
    Log.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (this.mUN != null)
    {
      this.mUN.dismiss();
      this.mUN = null;
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      this.fXu = ((com.tencent.mm.modelsimple.t)paramq).boA();
      com.tencent.mm.kernel.h.aGY().b(701, this);
      com.tencent.mm.kernel.h.aGY().b(252, this);
      this.ndj.mUS = ((com.tencent.mm.modelsimple.t)paramq).boB();
      this.ndj.mUR = ((com.tencent.mm.modelsimple.t)paramq).boC();
      this.ndj.mUT = ((com.tencent.mm.modelsimple.t)paramq).boD();
      this.ndj.neB = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
      this.ndj.account = this.account;
      this.ndj.mUQ = this.nep.getText().toString();
      if (paramInt2 == -75)
      {
        y.dw(getContext());
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -106)
      {
        y.f(this, paramString, 0);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -205)
      {
        this.nbl = ((com.tencent.mm.modelsimple.t)paramq).bkX();
        this.ndO = ((com.tencent.mm.modelsimple.t)paramq).boF();
        this.ndn = ((com.tencent.mm.modelsimple.t)paramq).boI();
        Log.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.nbl), this.ndn });
        g.a(this.ndj);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.nbl);
        paramString.putExtra("binded_mobile", this.ndO);
        paramString.putExtra("close_safe_device_style", this.ndn);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.sdk.a.mIG.g(this, paramString);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!Util.isNullOrNil(this.fXu)) {
          y.p(this, paramString, this.fXu);
        }
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1232;
      }
      com.tencent.mm.kernel.h.aGY().a(new bv(new bv.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128148);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128148);
            return;
          }
          paramAnonymousg = paramAnonymousg.biw();
          com.tencent.mm.kernel.h.aHE();
          int i = com.tencent.mm.kernel.b.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128148);
        }
      }), 0);
    }
    label1232:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.h.aGY().a(701, this);
        com.tencent.mm.kernel.h.aGY().a(252, this);
        if (this.mUP == null)
        {
          this.mUP = SecurityImage.a.a(getContext(), r.j.regbyqq_secimg_title, this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128150);
              Log.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).mUS + " img len" + LoginIndepPass.e(LoginIndepPass.this).mUR.length + " " + f.avD());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginIndepPass.e(LoginIndepPass.this).account, LoginIndepPass.e(LoginIndepPass.this).mUQ, LoginIndepPass.e(LoginIndepPass.this).neB, LoginIndepPass.f(LoginIndepPass.this).getSecImgCode(), LoginIndepPass.f(LoginIndepPass.this).getSecImgSid(), LoginIndepPass.f(LoginIndepPass.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(r.j.app_tip);
              LoginIndepPass.a(localLoginIndepPass1, com.tencent.mm.ui.base.h.a(localLoginIndepPass2, LoginIndepPass.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128149);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aGY().b(701, LoginIndepPass.this);
                  com.tencent.mm.kernel.h.aGY().b(252, LoginIndepPass.this);
                  AppMethodBeat.o(128149);
                }
              }));
              AppMethodBeat.o(128150);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128151);
              LoginIndepPass.g(LoginIndepPass.this);
              AppMethodBeat.o(128151);
            }
          }, this.ndj);
          AppMethodBeat.o(128170);
          return;
        }
        Log.d("MicroMsg.LoginIndepPass", "imgSid:" + this.ndj.mUS + " img len" + this.ndj.mUR.length + " " + f.avD());
        this.mUP.b(this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT);
        AppMethodBeat.o(128170);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.b.aGG();
        com.tencent.mm.plugin.account.friend.a.l.byn();
        y.ZV(this.ndj.account);
        com.tencent.mm.platformtools.t.jdMethod_do(this);
        y.showAddrBookUploadConfirm(this, new LoginIndepPass.6(this), false, 2);
        AppMethodBeat.o(128170);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramq.getType() == 252) || (paramq.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128170);
          return;
        }
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128170);
      return;
      if (paramq.getType() == 145)
      {
        com.tencent.mm.kernel.h.aGY().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramq).bkY();
        if (paramInt2 == -41)
        {
          com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(128170);
          return;
        }
        if (paramInt2 == -75)
        {
          com.tencent.mm.ui.base.h.c(this, getString(r.j.alpha_version_tip_login), "", true);
          AppMethodBeat.o(128170);
          return;
        }
        com.tencent.mm.plugin.b.a.bkD("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.neq);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramq).ble());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramq).blf());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramq).blg());
        startActivity(MobileVerifyUI.class, (Intent)localObject);
        AppMethodBeat.o(128170);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128170);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass
 * JD-Core Version:    0.7.0.1
 */