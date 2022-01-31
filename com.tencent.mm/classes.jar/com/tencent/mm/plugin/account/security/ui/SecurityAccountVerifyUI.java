package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountVerifyUI
  extends MMWizardActivity
  implements com.tencent.mm.ai.f
{
  private ap caS;
  private String cxl;
  private String cxn;
  private String czF;
  private ProgressDialog eeN = null;
  private String gBP;
  private Button gBS;
  private EditText gBW;
  private TextView gBX;
  private TextView gBY;
  private Button gBZ;
  private boolean gCa = false;
  private String guI;
  
  private void apB()
  {
    AppMethodBeat.i(69929);
    cancel();
    Oi(1);
    AppMethodBeat.o(69929);
  }
  
  private boolean l(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(69931);
    if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(69931);
      return true;
    }
    switch (paramInt2)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(69931);
      return bool;
      h.a(getContext(), 2131297616, 2131297621, null);
      continue;
      h.a(getContext(), 2131297615, 2131297621, null);
      continue;
      Toast.makeText(this, 2131297570, 0).show();
      continue;
      Toast.makeText(getContext(), 2131296926, 0).show();
      continue;
      Toast.makeText(getContext(), 2131297569, 0).show();
      continue;
      h.a(getContext(), 2131297566, 2131297087, null);
    }
  }
  
  public int getLayoutId()
  {
    return 2130970637;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69927);
    this.czF = getIntent().getStringExtra("binded_mobile");
    this.gBP = getIntent().getStringExtra("auth_ticket");
    this.gCa = getIntent().getBooleanExtra("re_open_verify", false);
    this.gBW = ((EditText)findViewById(2131821810));
    this.gBX = ((TextView)findViewById(2131827514));
    this.gBY = ((TextView)findViewById(2131827515));
    this.gBZ = ((Button)findViewById(2131827516));
    this.gBW.addTextChangedListener(new SecurityAccountVerifyUI.1(this));
    this.gBX.setText(bo.aqd(this.czF));
    this.gBY.setTag(Integer.valueOf(60));
    this.caS = new ap(new SecurityAccountVerifyUI.2(this), true);
    this.gBZ.setOnClickListener(new SecurityAccountVerifyUI.3(this));
    if (!this.gCa)
    {
      this.gBS = ((Button)findViewById(2131827511));
      this.gBS.setVisibility(0);
      this.gBS.setOnClickListener(new SecurityAccountVerifyUI.4(this));
    }
    setBackBtn(new SecurityAccountVerifyUI.5(this));
    addTextOptionMenu(0, getString(2131297013), new SecurityAccountVerifyUI.6(this));
    enableOptionMenu(false);
    setMMTitle(2131302849);
    this.caS.ag(1000L, 1000L);
    AppMethodBeat.o(69927);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69923);
    super.onCreate(paramBundle);
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    AppMethodBeat.o(69923);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(69926);
    super.onDestroy();
    this.caS.stopTimer();
    AppMethodBeat.o(69926);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(69928);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      apB();
      AppMethodBeat.o(69928);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(69928);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(69925);
    g.Rc().b(145, this);
    g.Rc().b(132, this);
    super.onPause();
    if (!this.gCa)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L600_200,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L600_200") + ",2");
    }
    AppMethodBeat.o(69925);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69924);
    g.Rc().a(145, this);
    g.Rc().a(132, this);
    super.onResume();
    if (!this.gCa)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.RJ();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L600_200,");
      g.RJ();
      com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L600_200") + ",1");
      com.tencent.mm.plugin.b.a.xC("L600_200");
    }
    AppMethodBeat.o(69924);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(69930);
    if ((this.eeN != null) && (this.eeN.isShowing()))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(69930);
      return;
      paramm = (com.tencent.mm.modelfriend.a)paramm;
      if (paramm.Ac() == 10)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ab.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
          AppMethodBeat.o(69930);
          return;
        }
        ab.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (l(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(69930);
          return;
        }
        Toast.makeText(getContext(), getString(2131302858, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(69930);
        return;
      }
      if (paramm.Ac() == 11)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.gBP = paramm.agy();
          ab.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.gBP);
          paramInt1 = getIntent().getIntExtra("from_source", 1);
          Intent localIntent = new Intent();
          localIntent.putExtra("from_source", paramInt1);
          localIntent.putExtra("binded_mobile", this.czF);
          switch (paramInt1)
          {
          case 4: 
          default: 
            Oi(1);
            AppMethodBeat.o(69930);
            return;
          case 3: 
            localIntent.addFlags(67108864);
            localIntent.putExtra("auth_ticket", this.gBP);
            paramm = getIntent().getStringExtra("WizardTransactionId");
            paramString = paramm;
            if (paramm == null) {
              paramString = "";
            }
            paramString = (Intent)zcw.get(paramString);
            zcw.clear();
            if (paramString != null) {
              com.tencent.mm.plugin.account.a.a.gmO.a(this, localIntent, paramString);
            }
            for (;;)
            {
              finish();
              AppMethodBeat.o(69930);
              return;
              com.tencent.mm.plugin.account.a.a.gmO.a(this, localIntent, null);
            }
          }
          localIntent.addFlags(67108864);
          localIntent.putExtra("auth_ticket", this.gBP);
          com.tencent.mm.plugin.account.a.a.gmO.a(this, localIntent, null);
          finish();
          AppMethodBeat.o(69930);
          return;
        }
        ab.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (l(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(69930);
          return;
        }
        Toast.makeText(getContext(), getString(2131302862, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(69930);
        return;
      }
      ab.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[] { Integer.valueOf(paramm.Ac()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(69930);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.security.a.f.n(true, true);
        paramString = new Intent(this, MySafeDeviceListUI.class);
        paramString.addFlags(67108864);
        startActivity(paramString);
        finish();
        AppMethodBeat.o(69930);
        return;
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(69930);
        return;
      }
      Toast.makeText(this, getString(2131302862, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI
 * JD-Core Version:    0.7.0.1
 */