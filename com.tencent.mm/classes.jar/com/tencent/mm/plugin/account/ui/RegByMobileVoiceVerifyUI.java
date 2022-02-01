package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RegByMobileVoiceVerifyUI
  extends MMActivity
  implements f
{
  private String dzn;
  private String jaZ;
  private String jkm;
  private com.tencent.mm.modelfriend.a jpM;
  private z jpN;
  private int jpO = 0;
  private String languageCode;
  private TextView vk;
  
  public int getLayoutId()
  {
    return 2131493184;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128633);
    setMMTitle(2131756524);
    setBackBtn(new RegByMobileVoiceVerifyUI.1(this));
    this.vk = ((TextView)findViewById(2131301307));
    Button localButton = (Button)findViewById(2131297255);
    this.jkm = RegByMobileVoiceVerifySelectUI.Ka(this.dzn);
    this.vk.setText(this.jkm);
    this.languageCode = com.tencent.mm.ax.b.FT(this.dzn);
    findViewById(2131301460).setOnClickListener(new RegByMobileVoiceVerifyUI.2(this));
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128628);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 0) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 2) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 3))
        {
          RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this, new com.tencent.mm.modelfriend.a(RegByMobileVoiceVerifyUI.c(RegByMobileVoiceVerifyUI.this), RegByMobileVoiceVerifyUI.d(RegByMobileVoiceVerifyUI.this), "", 1, RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this)));
          g.aiU().a(RegByMobileVoiceVerifyUI.e(RegByMobileVoiceVerifyUI.this), 0);
          h.a(RegByMobileVoiceVerifyUI.this, 2131756521, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(128626);
              RegByMobileVoiceVerifyUI.this.finish();
              AppMethodBeat.o(128626);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128628);
          return;
          if ((RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 4) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 1))
          {
            RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this, new z(RegByMobileVoiceVerifyUI.c(RegByMobileVoiceVerifyUI.this), 1, "", 1, RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this)));
            g.aiU().a(RegByMobileVoiceVerifyUI.f(RegByMobileVoiceVerifyUI.this), 0);
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
        }
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
      this.jkm = paramIntent.getStringExtra("voice_verify_language");
      this.languageCode = paramIntent.getStringExtra("voice_verify_code");
      this.vk.setText(this.jkm);
    }
    AppMethodBeat.o(128634);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128629);
    super.onCreate(paramBundle);
    this.dzn = getIntent().getExtras().getString("bindmcontact_mobile");
    this.jpO = getIntent().getExtras().getInt("voice_verify_type");
    if ((this.jpO == 0) || (this.jpO == 2) || (this.jpO == 3)) {
      g.aiU().a(145, this);
    }
    for (;;)
    {
      this.jaZ = com.tencent.mm.plugin.b.a.Mp();
      initView();
      AppMethodBeat.o(128629);
      return;
      if ((this.jpO == 4) || (this.jpO == 1)) {
        g.aiU().a(132, this);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128631);
    super.onDestroy();
    g.aiU().b(132, this);
    g.aiU().b(145, this);
    if ((this.jpO == 0) || (this.jpO == 2) || (this.jpO == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_500,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_500") + ",2");
    }
    AppMethodBeat.o(128631);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128632);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.b.a.Ma(this.jaZ);
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
    if ((this.jpO == 0) || (this.jpO == 2) || (this.jpO == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajA();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_500,");
      g.ajA();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R200_500") + ",1");
      com.tencent.mm.plugin.b.a.Kc("R200_500");
    }
    AppMethodBeat.o(128630);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128635);
    ad.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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