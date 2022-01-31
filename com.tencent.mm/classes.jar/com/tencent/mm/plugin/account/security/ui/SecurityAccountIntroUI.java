package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI
  extends MMWizardActivity
  implements f
{
  private String czF;
  private ProgressDialog eeN = null;
  private String gBP;
  private String gBQ;
  private boolean gBR = false;
  private Button gBS;
  private String guI;
  private String jumpUrl;
  
  private void apB()
  {
    AppMethodBeat.i(69912);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    cancel();
    Oi(1);
    AppMethodBeat.o(69912);
  }
  
  public int getLayoutId()
  {
    return 2130970635;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69911);
    setMMTitle(2131302864);
    findViewById(2131827510).setOnClickListener(new SecurityAccountIntroUI.1(this));
    if (!this.gBR)
    {
      this.gBS = ((Button)findViewById(2131827511));
      if (!bo.isNullOrNil(this.gBQ)) {
        this.gBS.setText(this.gBQ);
      }
      this.gBS.setVisibility(0);
      this.gBS.setOnClickListener(new SecurityAccountIntroUI.2(this));
    }
    setBackBtn(new SecurityAccountIntroUI.3(this));
    AppMethodBeat.o(69911);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69907);
    super.onCreate(paramBundle);
    this.gBP = getIntent().getStringExtra("auth_ticket");
    this.czF = getIntent().getStringExtra("binded_mobile");
    this.gBR = getIntent().getBooleanExtra("re_open_verify", false);
    paramBundle = getIntent().getStringExtra("close_safe_device_style");
    ab.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[] { bo.aqg(this.gBP), paramBundle });
    if (!bo.isNullOrNil(paramBundle))
    {
      paramBundle = br.F(paramBundle, "wording");
      if (paramBundle != null)
      {
        this.gBQ = ((String)paramBundle.get(".wording.title"));
        this.jumpUrl = ((String)paramBundle.get(".wording.url"));
        ab.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[] { this.gBQ, this.jumpUrl });
      }
    }
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    AppMethodBeat.o(69907);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69910);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      apB();
      AppMethodBeat.o(69910);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(69910);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69909);
    super.onPause();
    g.Rc().b(145, this);
    g.Rc().b(132, this);
    if (!this.gBR)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L600_100,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L600_100") + ",2");
    }
    AppMethodBeat.o(69909);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69908);
    super.onResume();
    g.Rc().a(145, this);
    g.Rc().a(132, this);
    if (!this.gBR)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L600_100,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L600_100") + ",1");
      com.tencent.mm.plugin.b.a.xC("L600_100");
    }
    AppMethodBeat.o(69908);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(69913);
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!this.gBR) {}
      for (paramString = ((com.tencent.mm.modelfriend.a)paramm).agy();; paramString = ((jt)((x)paramm).rr.fsW.fta).wrW)
      {
        ab.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.gBP + "duanyi test authTicket_check = " + paramString);
        paramm = new Intent(this, SecurityAccountVerifyUI.class);
        paramm.putExtra("auth_ticket", paramString);
        paramm.putExtra("binded_mobile", this.czF);
        paramm.putExtra("re_open_verify", this.gBR);
        paramm.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
        J(this, paramm);
        if (getIntent().getIntExtra("from_source", 1) == 3) {
          finish();
        }
        AppMethodBeat.o(69913);
        return;
      }
    }
    int i;
    switch (paramInt2)
    {
    default: 
      i = 0;
    }
    while ((i != 0) || (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString)))
    {
      AppMethodBeat.o(69913);
      return;
      Toast.makeText(this, 2131296926, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131297570, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131297569, 0).show();
      i = 1;
      continue;
      h.a(this, 2131297566, 2131297087, null);
      i = 1;
    }
    Toast.makeText(this, getString(2131302858, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(69913);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI
 * JD-Core Version:    0.7.0.1
 */