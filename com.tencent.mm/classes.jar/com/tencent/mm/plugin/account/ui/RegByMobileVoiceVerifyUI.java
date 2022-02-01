package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RegByMobileVoiceVerifyUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String dnz;
  private String iHQ;
  private String iRe;
  private com.tencent.mm.modelfriend.a iWD;
  private z iWE;
  private int iWF = 0;
  private String languageCode;
  private TextView tr;
  
  public int getLayoutId()
  {
    return 2131493184;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128633);
    setMMTitle(2131756524);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128624);
        RegByMobileVoiceVerifyUI.this.hideVKB();
        RegByMobileVoiceVerifyUI.this.finish();
        AppMethodBeat.o(128624);
        return true;
      }
    });
    this.tr = ((TextView)findViewById(2131301307));
    Button localButton = (Button)findViewById(2131297255);
    this.iRe = RegByMobileVoiceVerifySelectUI.GL(this.dnz);
    this.tr.setText(this.iRe);
    this.languageCode = b.CP(this.dnz);
    findViewById(2131301460).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128625);
        RegByMobileVoiceVerifyUI.this.startActivityForResult(new Intent(RegByMobileVoiceVerifyUI.this, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this)), 10000);
        AppMethodBeat.o(128625);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128628);
        if ((RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 0) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 2) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 3))
        {
          RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this, new com.tencent.mm.modelfriend.a(RegByMobileVoiceVerifyUI.c(RegByMobileVoiceVerifyUI.this), RegByMobileVoiceVerifyUI.d(RegByMobileVoiceVerifyUI.this), "", 1, RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this)));
          com.tencent.mm.kernel.g.agi().a(RegByMobileVoiceVerifyUI.e(RegByMobileVoiceVerifyUI.this), 0);
          h.a(RegByMobileVoiceVerifyUI.this, 2131756521, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128626);
              RegByMobileVoiceVerifyUI.this.finish();
              AppMethodBeat.o(128626);
            }
          });
          AppMethodBeat.o(128628);
          return;
        }
        if ((RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 4) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 1))
        {
          RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this, new z(RegByMobileVoiceVerifyUI.c(RegByMobileVoiceVerifyUI.this), 1, "", 1, RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this)));
          com.tencent.mm.kernel.g.agi().a(RegByMobileVoiceVerifyUI.f(RegByMobileVoiceVerifyUI.this), 0);
          h.a(RegByMobileVoiceVerifyUI.this, 2131756521, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128627);
              RegByMobileVoiceVerifyUI.this.finish();
              AppMethodBeat.o(128627);
            }
          });
        }
        AppMethodBeat.o(128628);
      }
    });
    AppMethodBeat.o(128633);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128634);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10000)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(128634);
        return;
      }
      this.iRe = paramIntent.getStringExtra("voice_verify_language");
      this.languageCode = paramIntent.getStringExtra("voice_verify_code");
      this.tr.setText(this.iRe);
    }
    AppMethodBeat.o(128634);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128629);
    super.onCreate(paramBundle);
    this.dnz = getIntent().getExtras().getString("bindmcontact_mobile");
    this.iWF = getIntent().getExtras().getInt("voice_verify_type");
    if ((this.iWF == 0) || (this.iWF == 2) || (this.iWF == 3)) {
      com.tencent.mm.kernel.g.agi().a(145, this);
    }
    for (;;)
    {
      this.iHQ = com.tencent.mm.plugin.b.a.EL();
      initView();
      AppMethodBeat.o(128629);
      return;
      if ((this.iWF == 4) || (this.iWF == 1)) {
        com.tencent.mm.kernel.g.agi().a(132, this);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128631);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(132, this);
    com.tencent.mm.kernel.g.agi().b(145, this);
    if ((this.iWF == 0) || (this.iWF == 2) || (this.iWF == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_500,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_500") + ",2");
    }
    AppMethodBeat.o(128631);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128632);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.b.a.IL(this.iHQ);
      hideVKB();
      finish();
      AppMethodBeat.o(128632);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128632);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128630);
    super.onResume();
    if ((this.iWF == 0) || (this.iWF == 2) || (this.iWF == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_500,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R200_500") + ",1");
      com.tencent.mm.plugin.b.a.IK("R200_500");
    }
    AppMethodBeat.o(128630);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128635);
    ac.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(128635);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI
 * JD-Core Version:    0.7.0.1
 */