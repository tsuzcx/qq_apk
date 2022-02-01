package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bo;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private String account;
  private String dKk;
  private ProgressDialog fMu;
  private String jaZ;
  private p jcr;
  private SecurityImage jct;
  private String jiy;
  private c jjI;
  private String jkV;
  private f jkr;
  private String jkv;
  private EditText jlv;
  private String jlw;
  private Button jlx;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(128163);
    this.fMu = null;
    this.jct = null;
    this.jkr = new f();
    this.jjI = new LoginIndepPass.1(this);
    AppMethodBeat.o(128163);
  }
  
  private void aTT()
  {
    AppMethodBeat.i(128169);
    Object localObject = this.jlv.getText().toString();
    if (bt.isNullOrNil(this.account))
    {
      h.l(this, 2131764665, 2131760766);
      AppMethodBeat.o(128169);
      return;
    }
    if (((String)localObject).equals(""))
    {
      h.l(this, 2131764658, 2131760766);
      AppMethodBeat.o(128169);
      return;
    }
    hideVKB();
    com.tencent.mm.kernel.g.aiU().a(701, this);
    com.tencent.mm.kernel.g.aiU().a(252, this);
    localObject = new s(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
    getString(2131755906);
    this.fMu = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128162);
        com.tencent.mm.kernel.g.aiU().a(this.jkG);
        AppMethodBeat.o(128162);
      }
    });
    AppMethodBeat.o(128169);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128171);
    if (com.tencent.mm.plugin.account.a.a.iRH.a(getContext(), paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.aiU().aEN() == 5)
      {
        h.l(this, 2131761537, 2131761536);
        AppMethodBeat.o(128171);
        return true;
      }
      AppMethodBeat.o(128171);
      return false;
    case -4: 
    case -3: 
      h.l(this, 2131758459, 2131760766);
      AppMethodBeat.o(128171);
      return true;
    case -9: 
      h.l(this, 2131760765, 2131760766);
      AppMethodBeat.o(128171);
      return true;
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.ajA();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
      for (paramString = com.tencent.mm.cc.a.az(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.ais())
      {
        h.a(localAppCompatActivity, paramString, getContext().getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128171);
        return true;
        com.tencent.mm.kernel.g.ajA();
      }
    }
    if (!bt.isNullOrNil(this.dKk)) {
      y.n(getContext(), paramString, this.dKk);
    }
    AppMethodBeat.o(128171);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131494604;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128168);
    this.jlv = ((EditText)findViewById(2131300998));
    this.jlx = ((Button)findViewById(2131301581));
    enableOptionMenu(false);
    addTextOptionMenu(0, getString(2131760774), new LoginIndepPass.9(this));
    this.jlv.addTextChangedListener(new LoginIndepPass.10(this));
    this.jlv.setOnEditorActionListener(new LoginIndepPass.11(this));
    this.jlv.setOnKeyListener(new LoginIndepPass.12(this));
    this.jlx.setText(getString(2131760778));
    this.jlx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128159);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        h.a(LoginIndepPass.this, LoginIndepPass.this.getString(2131762365) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(2131762366), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128158);
            com.tencent.mm.kernel.g.aiU().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.modelfriend.a(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            com.tencent.mm.kernel.g.aiU().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(2131755906);
            LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131755804), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                AppMethodBeat.i(128157);
                com.tencent.mm.kernel.g.aiU().a(paramAnonymous2DialogInterface);
                com.tencent.mm.kernel.g.aiU().b(701, LoginIndepPass.this);
                com.tencent.mm.kernel.g.aiU().b(252, LoginIndepPass.this);
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
    this.jiy = getIntent().getStringExtra("auth_ticket");
    if (!bt.isNullOrNil(this.jiy)) {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128161);
          LoginIndepPass.a(LoginIndepPass.this, f.aTY(), f.aTZ());
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
      ad.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bt.isNullOrNil(str);
      if (!bt.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ad.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      aTT();
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
    paramBundle = getString(2131760772);
    if ((d.Fnm) || (i.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755822) + com.tencent.mm.cd.g.is(this);
    }
    setMMTitle(paramBundle);
    this.jlw = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.jlw != null) {
      this.account = ba.aQI(this.jlw);
    }
    com.tencent.mm.plugin.account.a.a.iRH.MU();
    this.jaZ = com.tencent.mm.plugin.b.a.Mp();
    initView();
    AppMethodBeat.o(128164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128167);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128167);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128166);
    super.onPause();
    com.tencent.mm.sdk.b.a.IbL.d(this.jjI);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("L200_200") + ",2");
    AppMethodBeat.o(128166);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128165);
    com.tencent.mm.sdk.b.a.IbL.c(this.jjI);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.Kc("L200_200");
    AppMethodBeat.o(128165);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128170);
    ad.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (this.jcr != null)
    {
      this.jcr.dismiss();
      this.jcr = null;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.dKk = ((s)paramn).aKK();
      com.tencent.mm.kernel.g.aiU().b(701, this);
      com.tencent.mm.kernel.g.aiU().b(252, this);
      this.jkr.jcw = ((s)paramn).aKL();
      this.jkr.jcv = ((s)paramn).aKM();
      this.jkr.jcx = ((s)paramn).aKN();
      this.jkr.jlF = ((s)paramn).getSecCodeType();
      this.jkr.account = this.account;
      this.jkr.jcu = this.jlv.getText().toString();
      if (paramInt2 == -75)
      {
        y.dc(getContext());
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 0);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -205)
      {
        this.jiy = ((s)paramn).aHx();
        this.jkV = ((s)paramn).aKP();
        this.jkv = ((s)paramn).aKS();
        ad.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aRp(this.jiy), this.jkv });
        f.a(this.jkr);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.jiy);
        paramString.putExtra("binded_mobile", this.jkV);
        paramString.putExtra("close_safe_device_style", this.jkv);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.a.a.iRG.g(this, paramString);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!bt.isNullOrNil(this.dKk)) {
          y.n(this, paramString, this.dKk);
        }
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1229;
      }
      com.tencent.mm.kernel.g.aiU().a(new bo(new LoginIndepPass.3(this)), 0);
    }
    label1229:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.aiU().a(701, this);
        com.tencent.mm.kernel.g.aiU().a(252, this);
        if (this.jct == null)
        {
          this.jct = SecurityImage.a.a(getContext(), this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128150);
              ad.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).jcw + " img len" + LoginIndepPass.e(LoginIndepPass.this).jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
              paramAnonymousDialogInterface = new s(LoginIndepPass.e(LoginIndepPass.this).account, LoginIndepPass.e(LoginIndepPass.this).jcu, LoginIndepPass.e(LoginIndepPass.this).jlF, LoginIndepPass.f(LoginIndepPass.this).getSecImgCode(), LoginIndepPass.f(LoginIndepPass.this).getSecImgSid(), LoginIndepPass.f(LoginIndepPass.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(2131755906);
              LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128149);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aiU().b(701, LoginIndepPass.this);
                  com.tencent.mm.kernel.g.aiU().b(252, LoginIndepPass.this);
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
          }, this.jkr);
          AppMethodBeat.o(128170);
          return;
        }
        ad.d("MicroMsg.LoginIndepPass", "imgSid:" + this.jkr.jcw + " img len" + this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
        this.jct.b(this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx);
        AppMethodBeat.o(128170);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aST();
        y.IW(this.jkr.account);
        t.cU(this);
        y.showAddrBookUploadConfirm(this, new LoginIndepPass.6(this), false, 2);
        AppMethodBeat.o(128170);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramn.getType() == 252) || (paramn.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128170);
          return;
        }
      }
      Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128170);
      return;
      if (paramn.getType() == 145)
      {
        com.tencent.mm.kernel.g.aiU().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramn).aHy();
        if (paramInt2 == -41)
        {
          h.l(this, 2131762328, 2131762329);
          AppMethodBeat.o(128170);
          return;
        }
        if (paramInt2 == -75)
        {
          h.c(this, getString(2131755265), "", true);
          AppMethodBeat.o(128170);
          return;
        }
        com.tencent.mm.plugin.b.a.Ma("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.jlw);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aHE());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aHF());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aHG());
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
        Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass
 * JD-Core Version:    0.7.0.1
 */