package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.model.c.1;
import com.tencent.mm.plugin.account.model.c.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.xlog.app.XLogSetup;

public class SimpleLoginUI
  extends MMWizardActivity
  implements com.tencent.mm.ai.f
{
  private TextWatcher ami;
  private String cJr;
  private ProgressDialog eeN;
  private String gBP;
  private com.tencent.mm.sdk.b.c gCZ;
  private f gDU;
  private String gDW;
  private String gDX;
  private MMClearEditText gES;
  private MMClearEditText gET;
  private MMFormInputView gEU;
  private MMFormInputView gEV;
  private Button gEW;
  private ResizeLayout gEb;
  private MMKeyboardUperView gFb;
  private SecurityImage gwg;
  
  public SimpleLoginUI()
  {
    AppMethodBeat.i(125617);
    this.eeN = null;
    this.gwg = null;
    this.gDU = new f();
    this.cJr = "";
    this.ami = new SimpleLoginUI.1(this);
    this.gCZ = new SimpleLoginUI.12(this);
    AppMethodBeat.o(125617);
  }
  
  private void apB()
  {
    AppMethodBeat.i(125623);
    boolean bool = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
    if (!bool) {
      cancel();
    }
    Oi(1);
    if (bool) {
      exit(1);
    }
    AppMethodBeat.o(125623);
  }
  
  private void arq()
  {
    AppMethodBeat.i(125624);
    this.gDU.account = this.gES.getText().toString().trim();
    this.gDU.gwh = this.gET.getText().toString();
    if (this.gDU.account.equals(""))
    {
      com.tencent.mm.ui.base.h.h(this, 2131304504, 2131301135);
      AppMethodBeat.o(125624);
      return;
    }
    if (this.gDU.gwh.equals(""))
    {
      com.tencent.mm.ui.base.h.h(this, 2131304500, 2131301135);
      AppMethodBeat.o(125624);
      return;
    }
    hideVKB();
    s locals = new s(this.gDU.account, this.gDU.gwh, this.gBP, 0);
    com.tencent.mm.kernel.g.Rc().a(locals, 0);
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131301149), true, new SimpleLoginUI.5(this, locals));
    AppMethodBeat.o(125624);
  }
  
  public int getLayoutId()
  {
    return 2130969997;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125622);
    this.gEU = ((MMFormInputView)findViewById(2131825452));
    this.gEV = ((MMFormInputView)findViewById(2131825453));
    this.gES = ((MMClearEditText)this.gEU.getContentEditText());
    this.gES.setFocusableInTouchMode(false);
    this.gES.setOnTouchListener(new SimpleLoginUI.14(this));
    this.gET = ((MMClearEditText)this.gEV.getContentEditText());
    this.gET.setFocusableInTouchMode(false);
    this.gET.setOnTouchListener(new SimpleLoginUI.15(this));
    com.tencent.mm.ui.tools.b.c.d(this.gET).QS(16).a(null);
    this.gEW = ((Button)findViewById(2131825455));
    this.gEW.setEnabled(false);
    this.gES.addTextChangedListener(this.ami);
    this.gET.addTextChangedListener(this.ami);
    this.gET.setOnEditorActionListener(new SimpleLoginUI.16(this));
    this.gET.setOnKeyListener(new SimpleLoginUI.17(this));
    this.gEb = ((ResizeLayout)findViewById(2131825451));
    this.gFb = ((MMKeyboardUperView)findViewById(2131820935));
    this.gEb.setOnSizeChanged(new SimpleLoginUI.18(this));
    this.gFb.setOnTouchListener(new SimpleLoginUI.19(this));
    findViewById(2131825454).setVisibility(8);
    setMMTitle(2131301155);
    setBackBtn(new SimpleLoginUI.2(this));
    this.gBP = getIntent().getStringExtra("auth_ticket");
    if (!bo.isNullOrNil(this.gBP))
    {
      this.gES.setText(bo.nullAsNil(f.arv()));
      this.gET.setText(bo.nullAsNil(f.arw()));
      new ak().postDelayed(new SimpleLoginUI.3(this), 500L);
    }
    if (com.tencent.mm.sdk.platformtools.g.ymN) {
      com.tencent.mm.plugin.account.a.a.gmP.o(this);
    }
    this.gEW.setOnClickListener(new SimpleLoginUI.4(this));
    AppMethodBeat.o(125622);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(125628);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool;
    String str;
    if (paramIntent == null)
    {
      bool = true;
      ab.d("MicroMsg.SimpleLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
      ab.d("MicroMsg.SimpleLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break label178;
      }
      arq();
      AppMethodBeat.o(125628);
      return;
      bool = false;
      break;
    }
    label178:
    AppMethodBeat.o(125628);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125618);
    super.onCreate(paramBundle);
    paramBundle = getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp());
    if (paramBundle.getBoolean("first_launch_weixin", true))
    {
      paramBundle.edit().putBoolean("first_launch_weixin", false).commit();
      XLogSetup.realSetupXlog();
    }
    setMMTitle(2131297005);
    if (com.tencent.mm.plugin.account.a.a.gmP != null) {
      com.tencent.mm.plugin.account.a.a.gmP.BR();
    }
    initView();
    com.tencent.mm.kernel.g.Rc().a(701, this);
    com.tencent.mm.kernel.g.Rc().a(252, this);
    if (!b.aq(this))
    {
      new Intent().addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.gmO.p(new Intent(), this);
    }
    AppMethodBeat.o(125618);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125620);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    super.onDestroy();
    AppMethodBeat.o(125620);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125625);
    if (paramInt == 4)
    {
      apB();
      AppMethodBeat.o(125625);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125625);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(125621);
    super.onNewIntent(paramIntent);
    this.gBP = paramIntent.getStringExtra("auth_ticket");
    paramIntent = getIntent().getExtras();
    if (paramIntent != null) {
      this.gBP = paramIntent.getString("auth_ticket");
    }
    if (!bo.isNullOrNil(this.gBP))
    {
      this.gES.setText(bo.nullAsNil(f.arv()));
      this.gET.setText(bo.nullAsNil(f.arw()));
      new ak().postDelayed(new SimpleLoginUI.13(this), 500L);
    }
    AppMethodBeat.o(125621);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125626);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    AppMethodBeat.o(125626);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125619);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    AppMethodBeat.o(125619);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125627);
    ab.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ab.d("MicroMsg.SimpleLoginUI", "Scene Type " + paramm.getType());
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    this.cJr = ((s)paramm).ajF();
    int i;
    if ((paramm.getType() == 252) || (paramm.getType() == 701))
    {
      this.gDU.gEL = ((s)paramm).getSecCodeType();
      this.gDU.gwj = ((s)paramm).ajG();
      this.gDU.gwi = ((s)paramm).ajH();
      this.gDU.gwk = ((s)paramm).ajI();
      if (paramInt2 == -205)
      {
        this.gBP = ((s)paramm).agy();
        this.gDW = ((s)paramm).ajK();
        this.gDX = ((s)paramm).ajN();
      }
      if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17)))
      {
        i = 1;
        com.tencent.mm.kernel.g.Rc().a(new bk(new SimpleLoginUI.10(this)), 0);
      }
    }
    for (;;)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        w.cs(this);
        z.wz(this.gDU.account);
        paramString = new com.tencent.mm.plugin.account.model.c(getContext(), new SimpleLoginUI.11(this));
        paramString.cqE = com.tencent.mm.plugin.account.a.a.gmP.a(paramString);
        if (paramString.cqE == null)
        {
          if (paramString.gAJ != null) {
            paramString.gAJ.aqZ();
          }
          AppMethodBeat.o(125627);
          return;
        }
        if (paramString.cqE.getType() == 139) {
          com.tencent.mm.kernel.g.Rc().a(139, paramString);
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.Rc().a(paramString.cqE, 0);
          paramm = paramString.context;
          paramString.context.getString(2131297087);
          paramString.tipDialog = com.tencent.mm.ui.base.h.b(paramm, paramString.context.getString(2131296988), true, new c.1(paramString));
          AppMethodBeat.o(125627);
          return;
          if (paramString.cqE.getType() == 138) {
            com.tencent.mm.kernel.g.Rc().a(138, paramString);
          }
        }
      }
      if (paramInt2 == -217)
      {
        z.a(this, e.a((s)paramm), paramInt2);
        AppMethodBeat.o(125627);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(125627);
        return;
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (com.tencent.mm.kernel.g.Rc().adt() == 5)
          {
            com.tencent.mm.ui.base.h.h(this, 2131301790, 2131301789);
            i = 1;
          }
          break;
        case -30: 
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.h(this, 2131299331, 2131301135);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.h(this, 2131301134, 2131301135);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.h(getContext(), 2131302471, 2131297087);
          i = 1;
          break;
        case -75: 
          z.cA(getContext());
          i = 1;
          break;
        case -311: 
        case -310: 
        case -6: 
          if (this.gwg == null) {
            this.gwg = SecurityImage.a.a(getContext(), this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk, new SimpleLoginUI.6(this), null, new SimpleLoginUI.7(this), this.gDU);
          }
          for (;;)
          {
            i = 1;
            break;
            ab.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.gDU.gwj + " img len" + this.gDU.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
            this.gwg.b(this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk);
          }
        case -100: 
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.RJ();
          com.tencent.mm.ui.base.h.a(this, com.tencent.mm.kernel.a.QD(), getString(2131297087), new SimpleLoginUI.8(this), new SimpleLoginUI.9(this));
          i = 1;
          break;
        case -205: 
          ab.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bo.aqg(this.gBP), this.gDX });
          f.a(this.gDU);
          paramm = new Intent();
          paramm.putExtra("auth_ticket", this.gBP);
          paramm.putExtra("binded_mobile", this.gDW);
          paramm.putExtra("close_safe_device_style", this.gDX);
          paramm.putExtra("from_source", 3);
          com.tencent.mm.plugin.account.a.a.gmO.g(this, paramm);
          i = 1;
          break;
        case -140: 
          if (!bo.isNullOrNil(this.cJr)) {
            z.o(this, paramString, this.cJr);
          }
          i = 1;
          break;
        case -106: 
          z.f(this, paramString, 0);
          i = 1;
        }
      }
      paramString = com.tencent.mm.h.a.kO(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(125627);
        return;
      }
      Toast.makeText(this, getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(125627);
      return;
      i = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI
 * JD-Core Version:    0.7.0.1
 */