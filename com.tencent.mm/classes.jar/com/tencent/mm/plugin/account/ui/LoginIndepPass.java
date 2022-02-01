package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.model.bn;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String account;
  private String dxX;
  private ProgressDialog fts;
  private String iHQ;
  private p iJi;
  private SecurityImage iJk;
  private String iPp;
  private c iQA;
  private String iRN;
  private f iRj;
  private String iRn;
  private EditText iSn;
  private String iSo;
  private Button iSp;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(128163);
    this.fts = null;
    this.iJk = null;
    this.iRj = new f();
    this.iQA = new LoginIndepPass.1(this);
    AppMethodBeat.o(128163);
  }
  
  private void aQH()
  {
    AppMethodBeat.i(128169);
    Object localObject = this.iSn.getText().toString();
    if (bs.isNullOrNil(this.account))
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
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    localObject = new s(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    getString(2131755906);
    this.fts = h.b(this, getString(2131760781), true, new LoginIndepPass.16(this, (s)localObject));
    AppMethodBeat.o(128169);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128171);
    if (com.tencent.mm.plugin.account.a.a.iyy.a(getContext(), paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.agi().aBK() == 5)
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
      com.tencent.mm.kernel.g.agP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
      for (paramString = com.tencent.mm.cc.a.aw(getContext(), 2131761063);; paramString = com.tencent.mm.kernel.a.afG())
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
        com.tencent.mm.kernel.g.agP();
      }
    }
    if (!bs.isNullOrNil(this.dxX)) {
      y.m(getContext(), paramString, this.dxX);
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
    this.iSn = ((EditText)findViewById(2131300998));
    this.iSp = ((Button)findViewById(2131301581));
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
    this.iSn.addTextChangedListener(new TextWatcher()
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
    this.iSn.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.iSn.setOnKeyListener(new View.OnKeyListener()
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
    this.iSp.setText(getString(2131760778));
    this.iSp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128159);
        h.a(LoginIndepPass.this, LoginIndepPass.this.getString(2131762365) + LoginIndepPass.c(LoginIndepPass.this), LoginIndepPass.this.getString(2131762366), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(128158);
            com.tencent.mm.kernel.g.agi().a(145, LoginIndepPass.this);
            paramAnonymous2DialogInterface = new com.tencent.mm.modelfriend.a(LoginIndepPass.d(LoginIndepPass.this), 16, "", 0, "");
            com.tencent.mm.kernel.g.agi().a(paramAnonymous2DialogInterface, 0);
            LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
            LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
            LoginIndepPass.this.getString(2131755906);
            LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131755804), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
              {
                AppMethodBeat.i(128157);
                com.tencent.mm.kernel.g.agi().a(paramAnonymous2DialogInterface);
                com.tencent.mm.kernel.g.agi().b(701, LoginIndepPass.this);
                com.tencent.mm.kernel.g.agi().b(252, LoginIndepPass.this);
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
    setBackBtn(new LoginIndepPass.14(this));
    this.iPp = getIntent().getStringExtra("auth_ticket");
    if (!bs.isNullOrNil(this.iPp)) {
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128161);
          LoginIndepPass.a(LoginIndepPass.this, f.aQM(), f.aQN());
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
      ac.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bs.isNullOrNil(str);
      if (!bs.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ac.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      aQH();
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
    if (d.DIf) {
      paramBundle = getString(2131755822) + getString(2131755263);
    }
    setMMTitle(paramBundle);
    this.iSo = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.iSo != null) {
      this.account = az.aLc(this.iSo);
    }
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.iHQ = com.tencent.mm.plugin.b.a.EL();
    initView();
    AppMethodBeat.o(128164);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128167);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(128167);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128166);
    super.onPause();
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("L200_200") + ",2");
    AppMethodBeat.o(128166);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128165);
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.IK("L200_200");
    AppMethodBeat.o(128165);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128170);
    ac.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (this.iJi != null)
    {
      this.iJi.dismiss();
      this.iJi = null;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      this.dxX = ((s)paramn).aHz();
      com.tencent.mm.kernel.g.agi().b(701, this);
      com.tencent.mm.kernel.g.agi().b(252, this);
      this.iRj.iJn = ((s)paramn).aHA();
      this.iRj.iJm = ((s)paramn).aHB();
      this.iRj.iJo = ((s)paramn).aHC();
      this.iRj.iSx = ((s)paramn).getSecCodeType();
      this.iRj.account = this.account;
      this.iRj.iJl = this.iSn.getText().toString();
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
        y.a(this, e.a((s)paramn), paramInt2);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -205)
      {
        this.iPp = ((s)paramn).aEs();
        this.iRN = ((s)paramn).aHE();
        this.iRn = ((s)paramn).aHH();
        ac.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bs.aLJ(this.iPp), this.iRn });
        f.a(this.iRj);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.iPp);
        paramString.putExtra("binded_mobile", this.iRN);
        paramString.putExtra("close_safe_device_style", this.iRn);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.a.a.iyx.g(this, paramString);
        AppMethodBeat.o(128170);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!bs.isNullOrNil(this.dxX)) {
          y.m(this, paramString, this.dxX);
        }
        AppMethodBeat.o(128170);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1229;
      }
      com.tencent.mm.kernel.g.agi().a(new bn(new LoginIndepPass.3(this)), 0);
    }
    label1229:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.agi().a(701, this);
        com.tencent.mm.kernel.g.agi().a(252, this);
        if (this.iJk == null)
        {
          this.iJk = SecurityImage.a.a(getContext(), this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128150);
              ac.d("MicroMsg.LoginIndepPass", "imgSid:" + LoginIndepPass.e(LoginIndepPass.this).iJn + " img len" + LoginIndepPass.e(LoginIndepPass.this).iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
              paramAnonymousDialogInterface = new s(LoginIndepPass.e(LoginIndepPass.this).account, LoginIndepPass.e(LoginIndepPass.this).iJl, LoginIndepPass.e(LoginIndepPass.this).iSx, LoginIndepPass.f(LoginIndepPass.this).getSecImgCode(), LoginIndepPass.f(LoginIndepPass.this).getSecImgSid(), LoginIndepPass.f(LoginIndepPass.this).getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              LoginIndepPass localLoginIndepPass1 = LoginIndepPass.this;
              LoginIndepPass localLoginIndepPass2 = LoginIndepPass.this;
              LoginIndepPass.this.getString(2131755906);
              LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.this.getString(2131760781), true, new LoginIndepPass.4.1(this, paramAnonymousDialogInterface)));
              AppMethodBeat.o(128150);
            }
          }, null, new LoginIndepPass.5(this), this.iRj);
          AppMethodBeat.o(128170);
          return;
        }
        ac.d("MicroMsg.LoginIndepPass", "imgSid:" + this.iRj.iJn + " img len" + this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
        this.iJk.b(this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo);
        AppMethodBeat.o(128170);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aPH();
        y.FH(this.iRj.account);
        t.cW(this);
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
        paramString = com.tencent.mm.h.a.rM(paramString);
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
        com.tencent.mm.kernel.g.agi().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramn).aEt();
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
        com.tencent.mm.plugin.b.a.IL("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.iSo);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aEz());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aEA());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aEB());
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