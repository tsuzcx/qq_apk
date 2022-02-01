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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RegByMobileVoiceVerifyUI
  extends MMActivity
  implements i
{
  private String dSf;
  private String kbV;
  private String klo;
  private com.tencent.mm.modelfriend.a kqU;
  private z kqV;
  private int kqW = 0;
  private String languageCode;
  private TextView vr;
  
  public int getLayoutId()
  {
    return 2131493230;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128633);
    setMMTitle(2131756660);
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
    this.vr = ((TextView)findViewById(2131303005));
    Button localButton = (Button)findViewById(2131297410);
    this.klo = RegByMobileVoiceVerifySelectUI.Ty(this.dSf);
    this.vr.setText(this.klo);
    this.languageCode = com.tencent.mm.aw.b.Ph(this.dSf);
    findViewById(2131303643).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128625);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        RegByMobileVoiceVerifyUI.this.startActivityForResult(new Intent(RegByMobileVoiceVerifyUI.this, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this)), 10000);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128625);
      }
    });
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128628);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileVoiceVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 0) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 2) || (RegByMobileVoiceVerifyUI.b(RegByMobileVoiceVerifyUI.this) == 3))
        {
          RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this, new com.tencent.mm.modelfriend.a(RegByMobileVoiceVerifyUI.c(RegByMobileVoiceVerifyUI.this), RegByMobileVoiceVerifyUI.d(RegByMobileVoiceVerifyUI.this), "", 1, RegByMobileVoiceVerifyUI.a(RegByMobileVoiceVerifyUI.this)));
          g.azz().a(RegByMobileVoiceVerifyUI.e(RegByMobileVoiceVerifyUI.this), 0);
          h.a(RegByMobileVoiceVerifyUI.this, 2131756657, 2131755998, new DialogInterface.OnClickListener()
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
            g.azz().a(RegByMobileVoiceVerifyUI.f(RegByMobileVoiceVerifyUI.this), 0);
            h.a(RegByMobileVoiceVerifyUI.this, 2131756657, 2131755998, new DialogInterface.OnClickListener()
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
      this.klo = paramIntent.getStringExtra("voice_verify_language");
      this.languageCode = paramIntent.getStringExtra("voice_verify_code");
      this.vr.setText(this.klo);
    }
    AppMethodBeat.o(128634);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128629);
    super.onCreate(paramBundle);
    this.dSf = getIntent().getExtras().getString("bindmcontact_mobile");
    this.kqW = getIntent().getExtras().getInt("voice_verify_type");
    if ((this.kqW == 0) || (this.kqW == 2) || (this.kqW == 3)) {
      g.azz().a(145, this);
    }
    for (;;)
    {
      this.kbV = com.tencent.mm.plugin.b.a.bpZ();
      initView();
      AppMethodBeat.o(128629);
      return;
      if ((this.kqW == 4) || (this.kqW == 1)) {
        g.azz().a(132, this);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128631);
    super.onDestroy();
    g.azz().b(132, this);
    g.azz().b(145, this);
    if ((this.kqW == 0) || (this.kqW == 2) || (this.kqW == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_500,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_500") + ",2");
    }
    AppMethodBeat.o(128631);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128632);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.b.a.bwV(this.kbV);
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
    if ((this.kqW == 0) || (this.kqW == 2) || (this.kqW == 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_500,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R200_500") + ",1");
      com.tencent.mm.plugin.b.a.bwU("R200_500");
    }
    AppMethodBeat.o(128630);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128635);
    Log.i("MicroMsg.RegByMobileVoiceVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(128635);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI
 * JD-Core Version:    0.7.0.1
 */