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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private String account;
  private String dLz;
  private ProgressDialog fOC;
  private String jdS;
  private p jfk;
  private SecurityImage jfm;
  private String jlr;
  private com.tencent.mm.sdk.b.c jmB;
  private String jnP;
  private f jnl;
  private String jnp;
  private EditText jop;
  private String joq;
  private Button jor;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(128163);
    this.fOC = null;
    this.jfm = null;
    this.jnl = new f();
    this.jmB = new LoginIndepPass.1(this);
    AppMethodBeat.o(128163);
  }
  
  private void aUs()
  {
    AppMethodBeat.i(128169);
    Object localObject = this.jop.getText().toString();
    if (bu.isNullOrNil(this.account))
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
    com.tencent.mm.kernel.g.ajj().a(701, this);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    localObject = new com.tencent.mm.modelsimple.t(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
    getString(2131755906);
    this.fOC = h.b(this, getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128162);
        com.tencent.mm.kernel.g.ajj().a(this.jnA);
        AppMethodBeat.o(128162);
      }
    });
    AppMethodBeat.o(128169);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128171);
    if (com.tencent.mm.plugin.account.a.a.iUA.a(getContext(), paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
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
      com.tencent.mm.kernel.g.ajP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
      for (paramString = com.tencent.mm.cb.a.az(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.aiH())
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
        com.tencent.mm.kernel.g.ajP();
      }
    }
    if (!bu.isNullOrNil(this.dLz)) {
      y.n(getContext(), paramString, this.dLz);
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
    this.jop = ((EditText)findViewById(2131300998));
    this.jor = ((Button)findViewById(2131301581));
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
    this.jop.addTextChangedListener(new TextWatcher()
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
    this.jop.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.jop.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(128156);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128156);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(128156);
        return false;
      }
    });
    this.jor.setText(getString(2131760778));
    this.jor.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128159);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        h.a(LoginIndepPass.this, LoginIndepPass.this.getString(2131762365) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(2131762366), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128158);
            com.tencent.mm.kernel.g.ajj().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.modelfriend.a(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            com.tencent.mm.kernel.g.ajj().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(2131755906);
            LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131755804), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                AppMethodBeat.i(128157);
                com.tencent.mm.kernel.g.ajj().a(paramAnonymous2DialogInterface);
                com.tencent.mm.kernel.g.ajj().b(701, LoginIndepPass.this);
                com.tencent.mm.kernel.g.ajj().b(252, LoginIndepPass.this);
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
    this.jlr = getIntent().getStringExtra("auth_ticket");
    if (!bu.isNullOrNil(this.jlr)) {
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128161);
          LoginIndepPass.a(LoginIndepPass.this, f.aUx(), f.aUy());
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
      ae.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bu.isNullOrNil(str);
      if (!bu.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ae.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      aUs();
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
    if ((d.FFK) || (j.IS_FLAVOR_BLUE)) {
      paramBundle = getString(2131755822) + com.tencent.mm.cc.g.ix(this);
    }
    setMMTitle(paramBundle);
    this.joq = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.joq != null) {
      this.account = bb.aSf(this.joq);
    }
    com.tencent.mm.plugin.account.a.a.iUA.MP();
    this.jdS = com.tencent.mm.plugin.b.a.aVo();
    initView();
    AppMethodBeat.o(128164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128167);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128167);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128166);
    super.onPause();
    com.tencent.mm.sdk.b.a.IvT.d(this.jmB);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("L200_200") + ",2");
    AppMethodBeat.o(128166);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128165);
    com.tencent.mm.sdk.b.a.IvT.c(this.jmB);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.KA("L200_200");
    AppMethodBeat.o(128165);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128170);
    ae.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (this.jfk != null)
    {
      this.jfk.dismiss();
      this.jfk = null;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.dLz = ((com.tencent.mm.modelsimple.t)paramn).aLh();
      com.tencent.mm.kernel.g.ajj().b(701, this);
      com.tencent.mm.kernel.g.ajj().b(252, this);
      this.jnl.jfp = ((com.tencent.mm.modelsimple.t)paramn).aLi();
      this.jnl.jfo = ((com.tencent.mm.modelsimple.t)paramn).aLj();
      this.jnl.jfq = ((com.tencent.mm.modelsimple.t)paramn).aLk();
      this.jnl.joz = ((com.tencent.mm.modelsimple.t)paramn).getSecCodeType();
      this.jnl.account = this.account;
      this.jnl.jfn = this.jop.getText().toString();
      if (paramInt2 == -75)
      {
        y.de(getContext());
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
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramn), paramInt2);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -205)
      {
        this.jlr = ((com.tencent.mm.modelsimple.t)paramn).aHO();
        this.jnP = ((com.tencent.mm.modelsimple.t)paramn).aLm();
        this.jnp = ((com.tencent.mm.modelsimple.t)paramn).aLp();
        ae.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bu.aSM(this.jlr), this.jnp });
        f.a(this.jnl);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.jlr);
        paramString.putExtra("binded_mobile", this.jnP);
        paramString.putExtra("close_safe_device_style", this.jnp);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.a.a.iUz.g(this, paramString);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!bu.isNullOrNil(this.dLz)) {
          y.n(this, paramString, this.dLz);
        }
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1229;
      }
      com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128148);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128148);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFs();
          com.tencent.mm.kernel.g.ajP();
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
        com.tencent.mm.kernel.g.ajj().a(701, this);
        com.tencent.mm.kernel.g.ajj().a(252, this);
        if (this.jfm == null)
        {
          this.jfm = SecurityImage.a.a(getContext(), this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128150);
              ae.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).jfp + " img len" + LoginIndepPass.e(LoginIndepPass.this).jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(LoginIndepPass.e(LoginIndepPass.this).account, LoginIndepPass.e(LoginIndepPass.this).jfn, LoginIndepPass.e(LoginIndepPass.this).joz, LoginIndepPass.f(LoginIndepPass.this).getSecImgCode(), LoginIndepPass.f(LoginIndepPass.this).getSecImgSid(), LoginIndepPass.f(LoginIndepPass.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(2131755906);
              LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128149);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.ajj().b(701, LoginIndepPass.this);
                  com.tencent.mm.kernel.g.ajj().b(252, LoginIndepPass.this);
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
          }, this.jnl);
          AppMethodBeat.o(128170);
          return;
        }
        ae.d("MicroMsg.LoginIndepPass", "imgSid:" + this.jnl.jfp + " img len" + this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
        this.jfm.b(this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq);
        AppMethodBeat.o(128170);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aTs();
        y.Jv(this.jnl.account);
        com.tencent.mm.platformtools.t.cW(this);
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
        paramString = com.tencent.mm.h.a.uU(paramString);
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
        com.tencent.mm.kernel.g.ajj().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramn).aHP();
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
        com.tencent.mm.plugin.b.a.KB("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.joq);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aHV());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aHW());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aHX());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass
 * JD-Core Version:    0.7.0.1
 */