package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.g.a.c;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WelcomeActivity
  extends MMFragmentActivity
{
  private static final String[] gCv = { "public_profile" };
  private com.tencent.mm.ui.g.a.d gCU;
  private c gDk;
  private bj gDn;
  private WelcomeSelectView gKx;
  
  public WelcomeActivity()
  {
    AppMethodBeat.i(125650);
    this.gDn = new bj();
    AppMethodBeat.o(125650);
  }
  
  private void ash()
  {
    AppMethodBeat.i(125653);
    if (q.u(this, "com.facebook.katana"))
    {
      this.gCU.a("name,picture.type(large)", new WelcomeActivity.10(this));
      AppMethodBeat.o(125653);
      return;
    }
    g.RO().a(new WelcomeActivity.11(this));
    AppMethodBeat.o(125653);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(125656);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      ab.i("MicroMsg.WelcomeActivity", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.gCU != null) {
        this.gCU.h(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(125656);
      return;
      bool = false;
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(125651);
    super.onCreate(paramBundle);
    getSupportActionBar().hide();
    getWindow().getDecorView().setSystemUiVisibility(1024);
    this.gKx = new WelcomeSelectView(this);
    setContentView(this.gKx);
    this.gKx.asi();
    this.gKx.gKB.setOnClickListener(new WelcomeActivity.1(this));
    this.gKx.gKz.setOnClickListener(new WelcomeActivity.4(this));
    paramBundle = new ArrayList();
    final m localm = new m(this, 1001, 0);
    localm.setTitle(2131302408);
    paramBundle.add(localm);
    localm = new m(this, 1002, 0);
    if (com.tencent.mm.au.b.aid())
    {
      localm.setTitle(2131302406);
      paramBundle.add(localm);
    }
    if (paramBundle.size() > 1)
    {
      final com.tencent.mm.ui.widget.b.d locald = new com.tencent.mm.ui.widget.b.d(this, 1, false);
      locald.sao = new WelcomeActivity.5(this, paramBundle);
      locald.sap = new WelcomeActivity.6(this);
      locald.AGQ = new WelcomeActivity.7(this);
      this.gKx.gKA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125644);
          if (com.tencent.mm.protocal.d.whK)
          {
            WelcomeActivity.c(WelcomeActivity.this);
            AppMethodBeat.o(125644);
            return;
          }
          locald.crd();
          if (paramBundle.contains(localm))
          {
            WelcomeActivity.a(WelcomeActivity.this).cXw = 1L;
            WelcomeActivity.a(WelcomeActivity.this).cRH = 1L;
            WelcomeActivity.a(WelcomeActivity.this).ake();
          }
          AppMethodBeat.o(125644);
        }
      });
      AppMethodBeat.o(125651);
      return;
    }
    this.gKx.gKA.setOnClickListener(new WelcomeActivity.9(this));
    AppMethodBeat.o(125651);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125654);
    super.onDestroy();
    this.gDn.ake();
    if (this.gCU != null) {
      this.gCU.logout();
    }
    AppMethodBeat.o(125654);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125655);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.ig(this);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125655);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125652);
    super.onResume();
    this.gKx.init();
    AppMethodBeat.o(125652);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */