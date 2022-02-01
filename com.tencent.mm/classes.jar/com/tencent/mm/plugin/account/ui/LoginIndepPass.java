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
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String account;
  private String dAl;
  private ProgressDialog fpP;
  private String ihI;
  private p ijb;
  private SecurityImage ijd;
  private String ipj;
  private com.tencent.mm.sdk.b.c iqt;
  private String irI;
  private f ird;
  private String irh;
  private EditText isi;
  private String isj;
  private Button isk;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(128163);
    this.fpP = null;
    this.ijd = null;
    this.ird = new f();
    this.iqt = new LoginIndepPass.1(this);
    AppMethodBeat.o(128163);
  }
  
  private void aJQ()
  {
    AppMethodBeat.i(128169);
    Object localObject = this.isi.getText().toString();
    if (bt.isNullOrNil(this.account))
    {
      h.j(this, 2131764665, 2131760766);
      AppMethodBeat.o(128169);
      return;
    }
    if (((String)localObject).equals(""))
    {
      h.j(this, 2131764658, 2131760766);
      AppMethodBeat.o(128169);
      return;
    }
    hideVKB();
    com.tencent.mm.kernel.g.aeS().a(701, this);
    com.tencent.mm.kernel.g.aeS().a(252, this);
    localObject = new s(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    getString(2131755906);
    this.fpP = h.b(this, getString(2131760781), true, new LoginIndepPass.16(this, (s)localObject));
    AppMethodBeat.o(128169);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128171);
    if (com.tencent.mm.plugin.account.a.a.hYu.a(getContext(), paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.aeS().auR() == 5)
      {
        h.j(this, 2131761537, 2131761536);
        AppMethodBeat.o(128171);
        return true;
      }
      AppMethodBeat.o(128171);
      return false;
    case -4: 
    case -3: 
      h.j(this, 2131758459, 2131760766);
      AppMethodBeat.o(128171);
      return true;
    case -9: 
      h.j(this, 2131760765, 2131760766);
      AppMethodBeat.o(128171);
      return true;
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.afz();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
      for (paramString = com.tencent.mm.cd.a.aq(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.aeq())
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
        com.tencent.mm.kernel.g.afz();
      }
    }
    if (!bt.isNullOrNil(this.dAl)) {
      y.m(getContext(), paramString, this.dAl);
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
    this.isi = ((EditText)findViewById(2131300998));
    this.isk = ((Button)findViewById(2131301581));
    enableOptionMenu(false);
    addTextOptionMenu(0, getString(2131760774), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128153);
        LoginIndepPass.a(LoginIndepPass.this);
        AppMethodBeat.o(128153);
        return true;
      }
    });
    this.isi.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128154);
        LoginIndepPass.b(LoginIndepPass.this);
        AppMethodBeat.o(128154);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.isi.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128155);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          AppMethodBeat.o(128155);
          return true;
        }
        AppMethodBeat.o(128155);
        return false;
      }
    });
    this.isi.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128156);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          AppMethodBeat.o(128156);
          return true;
        }
        AppMethodBeat.o(128156);
        return false;
      }
    });
    this.isk.setText(getString(2131760778));
    this.isk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128159);
        h.a(LoginIndepPass.this, LoginIndepPass.this.getString(2131762365) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(2131762366), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128158);
            com.tencent.mm.kernel.g.aeS().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.modelfriend.a(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            com.tencent.mm.kernel.g.aeS().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(2131755906);
            LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131755804), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                AppMethodBeat.i(128157);
                com.tencent.mm.kernel.g.aeS().a(paramAnonymous2DialogInterface);
                com.tencent.mm.kernel.g.aeS().b(701, LoginIndepPass.this);
                com.tencent.mm.kernel.g.aeS().b(252, LoginIndepPass.this);
                AppMethodBeat.o(128157);
              }
            }));
            AppMethodBeat.o(128158);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(128159);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128160);
        com.tencent.mm.plugin.b.a.aUz("L200_100");
        Object localObject = new Intent(LoginIndepPass.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).addFlags(67108864);
        paramAnonymousMenuItem = LoginIndepPass.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/account/ui/LoginIndepPass$7", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        LoginIndepPass.this.finish();
        AppMethodBeat.o(128160);
        return true;
      }
    });
    this.ipj = getIntent().getStringExtra("auth_ticket");
    if (!bt.isNullOrNil(this.ipj)) {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128161);
          LoginIndepPass.a(LoginIndepPass.this, f.aJV(), f.aJW());
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
      aJQ();
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
    if (d.CpN) {
      paramBundle = getString(2131755822) + getString(2131755263);
    }
    setMMTitle(paramBundle);
    this.isj = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.isj != null) {
      this.account = ba.aFL(this.isj);
    }
    com.tencent.mm.plugin.account.a.a.hYu.Lo();
    this.ihI = com.tencent.mm.plugin.b.a.fQQ();
    initView();
    AppMethodBeat.o(128164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128167);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128167);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128166);
    super.onPause();
    com.tencent.mm.sdk.b.a.ESL.d(this.iqt);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("L200_200") + ",2");
    AppMethodBeat.o(128166);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128165);
    com.tencent.mm.sdk.b.a.ESL.c(this.iqt);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.aUy("L200_200");
    AppMethodBeat.o(128165);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128170);
    ad.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (this.ijb != null)
    {
      this.ijb.dismiss();
      this.ijb = null;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.dAl = ((s)paramn).aAJ();
      com.tencent.mm.kernel.g.aeS().b(701, this);
      com.tencent.mm.kernel.g.aeS().b(252, this);
      this.ird.ijg = ((s)paramn).aAK();
      this.ird.ijf = ((s)paramn).aAL();
      this.ird.ijh = ((s)paramn).aAM();
      this.ird.iss = ((s)paramn).getSecCodeType();
      this.ird.account = this.account;
      this.ird.ije = this.isi.getText().toString();
      if (paramInt2 == -75)
      {
        y.cV(getContext());
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
        y.a(this, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -205)
      {
        this.ipj = ((s)paramn).axA();
        this.irI = ((s)paramn).aAO();
        this.irh = ((s)paramn).aAR();
        ad.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aGs(this.ipj), this.irh });
        f.a(this.ird);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.ipj);
        paramString.putExtra("binded_mobile", this.irI);
        paramString.putExtra("close_safe_device_style", this.irh);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.a.a.hYt.g(this, paramString);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!bt.isNullOrNil(this.dAl)) {
          y.m(this, paramString, this.dAl);
        }
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1229;
      }
      com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128148);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128148);
            return;
          }
          paramAnonymouse = paramAnonymouse.avg();
          com.tencent.mm.kernel.g.afz();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128148);
        }
      }), 0);
    }
    label1229:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.aeS().a(701, this);
        com.tencent.mm.kernel.g.aeS().a(252, this);
        if (this.ijd == null)
        {
          this.ijd = SecurityImage.a.a(getContext(), this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128150);
              ad.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).ijg + " img len" + LoginIndepPass.e(LoginIndepPass.this).ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
              paramAnonymousDialogInterface = new s(LoginIndepPass.e(LoginIndepPass.this).account, LoginIndepPass.e(LoginIndepPass.this).ije, LoginIndepPass.e(LoginIndepPass.this).iss, LoginIndepPass.f(LoginIndepPass.this).getSecImgCode(), LoginIndepPass.f(LoginIndepPass.this).getSecImgSid(), LoginIndepPass.f(LoginIndepPass.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(2131755906);
              LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128149);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aeS().b(701, LoginIndepPass.this);
                  com.tencent.mm.kernel.g.aeS().b(252, LoginIndepPass.this);
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
          }, this.ird);
          AppMethodBeat.o(128170);
          return;
        }
        ad.d("MicroMsg.LoginIndepPass", "imgSid:" + this.ird.ijg + " img len" + this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
        this.ijd.b(this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh);
        AppMethodBeat.o(128170);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aIQ();
        y.BD(this.ird.account);
        t.cN(this);
        y.showAddrBookUploadConfirm(this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128152);
            ad.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(LoginIndepPass.this);
            ((Intent)localObject).addFlags(67108864);
            LoginIndepPass localLoginIndepPass = LoginIndepPass.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localLoginIndepPass, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localLoginIndepPass.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localLoginIndepPass, "com/tencent/mm/plugin/account/ui/LoginIndepPass$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            LoginIndepPass.this.finish();
            AppMethodBeat.o(128152);
          }
        }, false, 2);
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
        paramString = com.tencent.mm.h.a.oG(paramString);
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
        com.tencent.mm.kernel.g.aeS().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramn).axB();
        if (paramInt2 == -41)
        {
          h.j(this, 2131762328, 2131762329);
          AppMethodBeat.o(128170);
          return;
        }
        if (paramInt2 == -75)
        {
          h.c(this, getString(2131755265), "", true);
          AppMethodBeat.o(128170);
          return;
        }
        com.tencent.mm.plugin.b.a.aUz("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.isj);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).axH());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).axI());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).axJ());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass
 * JD-Core Version:    0.7.0.1
 */