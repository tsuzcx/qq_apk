package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class LoginIndepPass
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private String account;
  private String cJr;
  private ProgressDialog eeN;
  private String gBP;
  private c gCZ;
  private f gDU;
  private String gDW;
  private String gDX;
  private EditText gEB;
  private String gEC;
  private Button gED;
  private String guI;
  private com.tencent.mm.ui.base.p gwe;
  private SecurityImage gwg;
  
  public LoginIndepPass()
  {
    AppMethodBeat.i(124985);
    this.eeN = null;
    this.gwg = null;
    this.gDU = new f();
    this.gCZ = new c() {};
    AppMethodBeat.o(124985);
  }
  
  private void arq()
  {
    AppMethodBeat.i(124991);
    Object localObject = this.gEB.getText().toString();
    if (bo.isNullOrNil(this.account))
    {
      h.h(this, 2131304504, 2131301135);
      AppMethodBeat.o(124991);
      return;
    }
    if (((String)localObject).equals(""))
    {
      h.h(this, 2131304500, 2131301135);
      AppMethodBeat.o(124991);
      return;
    }
    hideVKB();
    com.tencent.mm.kernel.g.Rc().a(701, this);
    com.tencent.mm.kernel.g.Rc().a(252, this);
    localObject = new s(this.account, (String)localObject, null, 1);
    com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    getString(2131297087);
    this.eeN = h.b(this, getString(2131301149), true, new LoginIndepPass.16(this, (s)localObject));
    AppMethodBeat.o(124991);
  }
  
  private boolean l(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(124993);
    if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(124993);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(124993);
      return false;
    case -1: 
      if (com.tencent.mm.kernel.g.Rc().adt() == 5)
      {
        h.h(this, 2131301790, 2131301789);
        AppMethodBeat.o(124993);
        return true;
      }
      AppMethodBeat.o(124993);
      return false;
    case -4: 
    case -3: 
      h.h(this, 2131299331, 2131301135);
      AppMethodBeat.o(124993);
      return true;
    case -9: 
      h.h(this, 2131301134, 2131301135);
      AppMethodBeat.o(124993);
      return true;
    case -100: 
      com.tencent.mm.kernel.a.hold();
      AppCompatActivity localAppCompatActivity = getContext();
      com.tencent.mm.kernel.g.RJ();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
      for (paramString = com.tencent.mm.cb.a.aq(getContext(), 2131301416);; paramString = com.tencent.mm.kernel.a.QD())
      {
        h.a(localAppCompatActivity, paramString, getContext().getString(2131297087), new LoginIndepPass.7(this), new LoginIndepPass.8(this));
        AppMethodBeat.o(124993);
        return true;
        com.tencent.mm.kernel.g.RJ();
      }
    }
    if (!bo.isNullOrNil(this.cJr)) {
      z.o(getContext(), paramString, this.cJr);
    }
    AppMethodBeat.o(124993);
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130969999;
  }
  
  public void initView()
  {
    AppMethodBeat.i(124990);
    this.gEB = ((EditText)findViewById(2131825477));
    this.gED = ((Button)findViewById(2131825478));
    enableOptionMenu(false);
    addTextOptionMenu(0, getString(2131301142), new LoginIndepPass.9(this));
    this.gEB.addTextChangedListener(new LoginIndepPass.10(this));
    this.gEB.setOnEditorActionListener(new LoginIndepPass.11(this));
    this.gEB.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(124978);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          LoginIndepPass.a(LoginIndepPass.this);
          AppMethodBeat.o(124978);
          return true;
        }
        AppMethodBeat.o(124978);
        return false;
      }
    });
    this.gED.setText(getString(2131301146));
    this.gED.setOnClickListener(new LoginIndepPass.13(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(124982);
        com.tencent.mm.plugin.b.a.xD("L200_100");
        paramAnonymousMenuItem = new Intent(LoginIndepPass.this, MobileInputUI.class);
        paramAnonymousMenuItem.putExtra("mobile_input_purpose", 1);
        paramAnonymousMenuItem.addFlags(67108864);
        LoginIndepPass.this.startActivity(paramAnonymousMenuItem);
        LoginIndepPass.this.finish();
        AppMethodBeat.o(124982);
        return true;
      }
    });
    this.gBP = getIntent().getStringExtra("auth_ticket");
    if (!bo.isNullOrNil(this.gBP)) {
      new ak().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(124983);
          LoginIndepPass.a(LoginIndepPass.this, f.arv(), f.arw());
          AppMethodBeat.o(124983);
        }
      }, 500L);
    }
    AppMethodBeat.o(124990);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(124994);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      ab.d("MicroMsg.LoginIndepPass", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label178;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bo.isNullOrNil(str);
      if (!bo.isNullOrNil(str)) {
        break label169;
      }
    }
    label169:
    for (paramInt1 = i;; paramInt1 = str.length())
    {
      ab.d("MicroMsg.LoginIndepPass", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      arq();
      AppMethodBeat.o(124994);
      return;
      bool = false;
      break;
    }
    label178:
    AppMethodBeat.o(124994);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124986);
    super.onCreate(paramBundle);
    paramBundle = getString(2131301140);
    if (d.whK) {
      paramBundle = getString(2131297005) + getString(2131296529);
    }
    setMMTitle(paramBundle);
    this.gEC = getIntent().getStringExtra("bindmcontact_mobile");
    if (this.gEC != null) {
      this.account = av.apy(this.gEC);
    }
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    AppMethodBeat.o(124986);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(124989);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(124989);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(124988);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L200_200") + ",2");
    AppMethodBeat.o(124988);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(124987);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L200_200,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L200_200") + ",1");
    com.tencent.mm.plugin.b.a.xC("L200_200");
    AppMethodBeat.o(124987);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(124992);
    ab.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (this.gwe != null)
    {
      this.gwe.dismiss();
      this.gwe = null;
    }
    if ((paramm.getType() == 252) || (paramm.getType() == 701))
    {
      this.cJr = ((s)paramm).ajF();
      com.tencent.mm.kernel.g.Rc().b(701, this);
      com.tencent.mm.kernel.g.Rc().b(252, this);
      this.gDU.gwj = ((s)paramm).ajG();
      this.gDU.gwi = ((s)paramm).ajH();
      this.gDU.gwk = ((s)paramm).ajI();
      this.gDU.gEL = ((s)paramm).getSecCodeType();
      this.gDU.account = this.account;
      this.gDU.gwh = this.gEB.getText().toString();
      if (paramInt2 == -75)
      {
        z.cA(getContext());
        AppMethodBeat.o(124992);
        return;
      }
      if (paramInt2 == -106)
      {
        z.f(this, paramString, 0);
        AppMethodBeat.o(124992);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(this, e.a((s)paramm), paramInt2);
        AppMethodBeat.o(124992);
        return;
      }
      if (paramInt2 == -205)
      {
        this.gBP = ((s)paramm).agy();
        this.gDW = ((s)paramm).ajK();
        this.gDX = ((s)paramm).ajN();
        ab.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bo.aqg(this.gBP), this.gDX });
        f.a(this.gDU);
        paramString = new Intent();
        paramString.putExtra("auth_ticket", this.gBP);
        paramString.putExtra("binded_mobile", this.gDW);
        paramString.putExtra("close_safe_device_style", this.gDX);
        paramString.putExtra("from_source", 5);
        com.tencent.mm.plugin.account.a.a.gmO.g(this, paramString);
        AppMethodBeat.o(124992);
        return;
      }
      if (paramInt2 == -140)
      {
        if (!bo.isNullOrNil(this.cJr)) {
          z.o(this, paramString, this.cJr);
        }
        AppMethodBeat.o(124992);
        return;
      }
      if ((paramInt1 != 4) || ((paramInt2 != -16) && (paramInt2 != -17))) {
        break label1229;
      }
      com.tencent.mm.kernel.g.Rc().a(new bk(new LoginIndepPass.3(this)), 0);
    }
    label1229:
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.Rc().a(701, this);
        com.tencent.mm.kernel.g.Rc().a(252, this);
        if (this.gwg == null)
        {
          this.gwg = SecurityImage.a.a(getContext(), this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk, new LoginIndepPass.4(this), null, new LoginIndepPass.5(this), this.gDU);
          AppMethodBeat.o(124992);
          return;
        }
        ab.d("MicroMsg.LoginIndepPass", "imgSid:" + this.gDU.gwj + " img len" + this.gDU.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
        this.gwg.b(this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk);
        AppMethodBeat.o(124992);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        l.aqv();
        z.wz(this.gDU.account);
        w.cs(this);
        z.showAddrBookUploadConfirm(this, new LoginIndepPass.6(this), false, 2);
        AppMethodBeat.o(124992);
        return;
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(124992);
        return;
      }
      if ((paramm.getType() == 252) || (paramm.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(124992);
          return;
        }
      }
      Toast.makeText(this, getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(124992);
      return;
      if (paramm.getType() == 145)
      {
        com.tencent.mm.kernel.g.Rc().b(145, this);
        paramString = ((com.tencent.mm.modelfriend.a)paramm).agz();
        if (paramInt2 == -41)
        {
          h.h(this, 2131302425, 2131302426);
          AppMethodBeat.o(124992);
          return;
        }
        if (paramInt2 == -75)
        {
          h.b(this, getString(2131296531), "", true);
          AppMethodBeat.o(124992);
          return;
        }
        com.tencent.mm.plugin.b.a.xD("L3");
        Object localObject = new StringBuilder();
        com.tencent.mm.kernel.g.RJ();
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L3,");
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L3") + ",1");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.gEC);
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", paramString);
        ((Intent)localObject).putExtra("mobile_verify_purpose", 1);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramm).agE());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramm).agF());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramm).agG());
        startActivity(MobileVerifyUI.class, (Intent)localObject);
        AppMethodBeat.o(124992);
        return;
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(124992);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(124992);
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