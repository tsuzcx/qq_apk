package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.friend.a.r.a;
import com.tencent.mm.plugin.account.friend.a.r.b;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b;
import com.tencent.mm.ui.base.h;

public class EmailVerifyUI
  extends MMActivity
  implements f
{
  private ProgressDialog eeN = null;
  private TextView gCG;
  private TextView gCH;
  private MMAutoSwitchEditTextView gCI;
  private Button gCJ;
  private Button gCK;
  private String gCL;
  private String gCM;
  private String gCN;
  private String gCO;
  private boolean gCP = false;
  private String guI;
  
  private void goBack()
  {
    AppMethodBeat.i(124771);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    finish();
    AppMethodBeat.o(124771);
  }
  
  public int getLayoutId()
  {
    return 2130971058;
  }
  
  public void initView()
  {
    AppMethodBeat.i(124769);
    setMMTitle(2131302404);
    this.gCG = ((TextView)findViewById(2131828675));
    String str = getString(2131302387);
    this.gCG.setText(Html.fromHtml(str));
    this.gCH = ((TextView)findViewById(2131828676));
    this.gCL = getIntent().getStringExtra("email_address");
    if (!bo.isNullOrNil(this.gCL))
    {
      this.gCH.setText(this.gCL);
      this.gCN = getIntent().getStringExtra("password");
      this.gCM = getIntent().getStringExtra("email_login_page");
      ab.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[] { this.gCL, this.gCM });
      this.gCI = ((MMAutoSwitchEditTextView)findViewById(2131828677));
      this.gCI.setOnInputFinished(new EmailVerifyUI.1(this));
      this.gCI.setOnTextChanged(new MMAutoSwitchEditTextView.b()
      {
        public final void arh()
        {
          AppMethodBeat.i(124758);
          EmailVerifyUI.this.enableOptionMenu(false);
          AppMethodBeat.o(124758);
        }
      });
      this.gCK = ((Button)findViewById(2131828679));
      this.gCK.setOnClickListener(new EmailVerifyUI.3(this));
      this.gCJ = ((Button)findViewById(2131828678));
      if ((!bo.isNullOrNil(this.gCM)) && (!bo.isNullOrNil(this.gCL))) {
        break label305;
      }
      this.gCJ.setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new EmailVerifyUI.5(this));
      addTextOptionMenu(0, getString(2131297013), new EmailVerifyUI.6(this));
      enableOptionMenu(false);
      AppMethodBeat.o(124769);
      return;
      ab.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
      break;
      label305:
      this.gCJ.setVisibility(0);
      this.gCJ.setOnClickListener(new EmailVerifyUI.4(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124766);
    super.onCreate(paramBundle);
    initView();
    this.guI = com.tencent.mm.plugin.b.a.awy();
    AppMethodBeat.o(124766);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(124770);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(124770);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(124770);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(124768);
    super.onPause();
    g.Rc().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R500_200,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R500_200") + ",2");
    AppMethodBeat.o(124768);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(124767);
    super.onResume();
    g.Rc().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R500_200,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R500_200") + ",1");
    com.tencent.mm.plugin.b.a.xC("R500_200");
    AppMethodBeat.o(124767);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(124772);
    ab.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    this.gCP = false;
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (paramm.getType() != 481)
    {
      ab.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramm.getType()) });
      AppMethodBeat.o(124772);
      return;
    }
    int j = ((r.a)((z)paramm).ftU.getReqObj()).gxH.wsW;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (j == 2)
      {
        com.tencent.mm.plugin.b.a.xD("R200_900_email");
        paramString = new Intent(this, RegSetInfoUI.class);
        paramString.putExtra("regsetinfo_ticket", ((r.b)((z)paramm).ftU.getRespObj()).gxI.wQf);
        paramString.putExtra("regsetinfo_user", this.gCL);
        paramString.putExtra("regsetinfo_ismobile", 3);
        paramString.putExtra("regsetinfo_NextStyle", ((z)paramm).ajR());
        paramString.putExtra("regsetinfo_pwd", this.gCN);
        paramString.putExtra("regsetinfo_bind_email", this.gCL);
        startActivity(paramString);
        AppMethodBeat.o(124772);
        return;
      }
      if (j == 1)
      {
        paramString = new StringBuilder();
        g.RJ();
        paramString = paramString.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
        g.RJ();
        com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R22_resend_email_code_alert") + ",3");
        h.bO(this, getString(2131302397));
        AppMethodBeat.o(124772);
        return;
      }
      ab.e("MicroMsg.EmailVerifyUI", "err opcode");
      AppMethodBeat.o(124772);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(124772);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -32: 
        h.a(this, 2131302386, 2131302385, null);
        paramString = new StringBuilder();
        g.RJ();
        paramString = paramString.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R500_260,");
        g.RJ();
        com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R500_260") + ",3");
        i = 1;
        break;
      case -33: 
        h.a(this, 2131302384, 2131302385, null);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131302383, 0).show();
        i = 1;
      }
    }
    if (j == 2)
    {
      Toast.makeText(this, getString(2131302405, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(124772);
      return;
    }
    if (j == 1) {
      Toast.makeText(this, getString(2131302396, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(124772);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI
 * JD-Core Version:    0.7.0.1
 */