package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ce.j;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String account;
  private String idu;
  private ProgressDialog lzP;
  private String pQb;
  private w pRu;
  private SecurityImage pRw;
  private String pYt;
  private f pZh;
  private String pZj;
  private String pZk;
  private IListener pZz;
  private EditText qbd;
  private String qbe;
  private Button qbf;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(128163);
    this.lzP = null;
    this.pRw = null;
    this.pZh = new f();
    this.pZz = new LoginIndepPass.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(128163);
  }
  
  private void bXX()
  {
    AppMethodBeat.i(128169);
    Object localObject = this.qbd.getText().toString();
    if (Util.isNullOrNil(this.account))
    {
      k.s(this, r.j.verify_username_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128169);
      return;
    }
    if (((String)localObject).equals(""))
    {
      k.s(this, r.j.verify_password_null_tip, r.j.login_err_title);
      AppMethodBeat.o(128169);
      return;
    }
    hideVKB();
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    localObject = new u(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    getString(r.j.app_tip);
    this.lzP = k.a(this, getString(r.j.login_logining), true, new LoginIndepPass.16(this, (u)localObject));
    AppMethodBeat.o(128169);
  }
  
  private boolean p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128171);
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(getContext(), paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
      {
        k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        AppMethodBeat.o(128171);
        return true;
      }
      AppMethodBeat.o(128171);
      return false;
    case -4: 
    case -3: 
      k.s(this, r.j.errcode_password, r.j.login_err_title);
      AppMethodBeat.o(128171);
      return true;
    case -9: 
      k.s(this, r.j.login_err_mailnotverify, r.j.login_err_title);
      AppMethodBeat.o(128171);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.b.aZH();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.h.baC();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.b.aZu())) {}
      for (paramString = com.tencent.mm.cd.a.bt(getContext(), r.j.main_err_another_place);; paramString = com.tencent.mm.kernel.b.aZu())
      {
        k.a(localAppCompatActivity, paramString, getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128171);
        return true;
        com.tencent.mm.kernel.h.baC();
      }
    }
    if (!Util.isNullOrNil(this.idu)) {
      v.r(getContext(), paramString, this.idu);
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
    this.qbd = ((EditText)findViewById(r.f.indep_password));
    this.qbf = ((Button)findViewById(r.f.login_tip));
    enableOptionMenu(false);
    addTextOptionMenu(0, getString(r.j.login_login), new LoginIndepPass.9(this));
    this.qbd.addTextChangedListener(new LoginIndepPass.10(this));
    this.qbd.setOnEditorActionListener(new LoginIndepPass.11(this));
    this.qbd.setOnKeyListener(new LoginIndepPass.12(this));
    this.qbf.setText(getString(r.j.login_login_by_sms));
    this.qbf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128159);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        k.a(LoginIndepPass.this, LoginIndepPass.this.getString(r.j.regbymobile_reg_verify_mobile_msg) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(r.j.regbymobile_reg_verify_mobile_title), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128158);
            com.tencent.mm.kernel.h.aZW().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.modelfriend.a(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            com.tencent.mm.kernel.h.aZW().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(r.j.app_tip);
            LoginIndepPass.a(localLoginIndepPass1, k.a(localLoginIndepPass2, LoginIndepPass.this.getString(r.j.app_loading), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                AppMethodBeat.i(128157);
                com.tencent.mm.kernel.h.aZW().a(paramAnonymous2DialogInterface);
                com.tencent.mm.kernel.h.aZW().b(701, LoginIndepPass.this);
                com.tencent.mm.kernel.h.aZW().b(252, LoginIndepPass.this);
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
    this.pYt = getIntent().getStringExtra("auth_ticket");
    if (!Util.isNullOrNil(this.pYt)) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128161);
          LoginIndepPass.a(LoginIndepPass.this, f.bYd(), f.bYe());
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
      bXX();
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
    if ((d.Yxk) || (BuildInfo.IS_FLAVOR_BLUE)) {
      paramBundle = getString(r.j.app_name) + j.mx(this);
    }
    setMMTitle(paramBundle);
    this.qbe = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.qbe != null) {
      this.account = PhoneFormater.pureNumber(this.qbe);
    }
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.pQb = com.tencent.mm.plugin.b.a.chY();
    initView();
    AppMethodBeat.o(128164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128167);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128167);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128166);
    super.onPause();
    this.pZz.dead();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("L200_200") + ",2");
    AppMethodBeat.o(128166);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128165);
    this.pZz.alive();
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.Tz("L200_200");
    AppMethodBeat.o(128165);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128170);
    Log.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (this.pRu != null)
    {
      this.pRu.dismiss();
      this.pRu = null;
    }
    if ((paramp.getType() == 252) || (paramp.getType() == 701))
    {
      this.idu = ((u)paramp).bMh();
      com.tencent.mm.kernel.h.aZW().b(701, this);
      com.tencent.mm.kernel.h.aZW().b(252, this);
      this.pZh.pRz = ((u)paramp).bMi();
      this.pZh.pRy = ((u)paramp).bMj();
      this.pZh.pRA = ((u)paramp).bMk();
      this.pZh.qbo = ((u)paramp).getSecCodeType();
      this.pZh.account = this.account;
      this.pZh.pRx = this.qbd.getText().toString();
      if (paramInt2 == -75)
      {
        v.ei(getContext());
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -106)
      {
        v.f(this, paramString, 0);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -217)
      {
        v.a(this, com.tencent.mm.platformtools.e.d((u)paramp), paramInt2);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -205)
      {
        this.pYt = ((u)paramp).bIR();
        this.pZj = ((u)paramp).bMm();
        this.pZk = ((u)paramp).bMp();
        Log.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.pYt), this.pZk });
        f.a(this.pZh);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.pYt);
        paramString.putExtra("binded_mobile", this.pZj);
        paramString.putExtra("close_safe_device_style", this.pZk);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.sdk.a.pFn.g(this, paramString);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!Util.isNullOrNil(this.idu)) {
          v.r(this, paramString, this.idu);
        }
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1228;
      }
      com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
      {
        public final void b(g paramAnonymousg)
        {
          AppMethodBeat.i(128148);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128148);
            return;
          }
          paramAnonymousg = paramAnonymousg.bGg();
          com.tencent.mm.kernel.h.baC();
          int i = com.tencent.mm.kernel.b.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128148);
        }
      }), 0);
    }
    label1228:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.h.aZW().a(701, this);
        com.tencent.mm.kernel.h.aZW().a(252, this);
        if (this.pRw == null)
        {
          this.pRw = SecurityImage.a.a(getContext(), r.j.regbyqq_secimg_title, this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128150);
              Log.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).pRz + " img len" + LoginIndepPass.e(LoginIndepPass.this).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
              paramAnonymousDialogInterface = new u(LoginIndepPass.e(LoginIndepPass.this).account, LoginIndepPass.e(LoginIndepPass.this).pRx, LoginIndepPass.e(LoginIndepPass.this).qbo, LoginIndepPass.f(LoginIndepPass.this).getSecImgCode(), LoginIndepPass.f(LoginIndepPass.this).getSecImgSid(), LoginIndepPass.f(LoginIndepPass.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(r.j.app_tip);
              LoginIndepPass.a(localLoginIndepPass1, k.a(localLoginIndepPass2, LoginIndepPass.this.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128149);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aZW().b(701, LoginIndepPass.this);
                  com.tencent.mm.kernel.h.aZW().b(252, LoginIndepPass.this);
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
          }, this.pZh);
          AppMethodBeat.o(128170);
          return;
        }
        Log.d("MicroMsg.LoginIndepPass", "imgSid:" + this.pZh.pRz + " img len" + this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
        this.pRw.b(this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA);
        AppMethodBeat.o(128170);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.b.aZI();
        i.bXa();
        v.Sj(this.pZh.account);
        v.showAddrBookUploadConfirm(this, new LoginIndepPass.6(this), false, 2);
        AppMethodBeat.o(128170);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramp.getType() == 252) || (paramp.getType() == 701))
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128170);
          return;
        }
      }
      Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128170);
      return;
      if (paramp.getType() == 145)
      {
        com.tencent.mm.kernel.h.aZW().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramp).bIS();
        if (paramInt2 == -41)
        {
          k.s(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(128170);
          return;
        }
        if (paramInt2 == -75)
        {
          k.c(this, getString(r.j.alpha_version_tip_login), "", true);
          AppMethodBeat.o(128170);
          return;
        }
        com.tencent.mm.plugin.b.a.TA("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.qbe);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramp).bIY());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramp).bIZ());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramp).bJa());
        startActivity(MobileVerifyUI.class, (Intent)localObject);
        AppMethodBeat.o(128170);
        return;
      }
      if (p(paramInt1, paramInt2, paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass
 * JD-Core Version:    0.7.0.1
 */