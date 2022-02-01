package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText.c;

@Deprecated
public class RegByMobileSetNickUI
  extends MMActivity
  implements i
{
  private String dSf;
  private ProgressDialog gtM = null;
  private EditText kqA;
  private r kqB = null;
  private boolean kqC;
  
  public int getLayoutId()
  {
    return 2131496087;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128597);
    setMMTitle(2131764409);
    this.kqA = ((EditText)findViewById(2131306808));
    this.kqA.addTextChangedListener(new MMEditText.c(this.kqA, null, 16));
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128593);
        paramAnonymousMenuItem = RegByMobileSetNickUI.a(RegByMobileSetNickUI.this).getText().toString().trim();
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.length() <= 0))
        {
          h.n(RegByMobileSetNickUI.this, 2131767019, 2131764412);
          AppMethodBeat.o(128593);
          return true;
        }
        RegByMobileSetNickUI.this.hideVKB();
        Object localObject1 = RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd");
        Object localObject2 = RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket");
        paramAnonymousMenuItem = new v("", (String)localObject1, paramAnonymousMenuItem, 0, "", RegByMobileSetNickUI.b(RegByMobileSetNickUI.this), (String)localObject2, 4);
        g.azz().a(paramAnonymousMenuItem, 0);
        localObject1 = RegByMobileSetNickUI.this;
        localObject2 = RegByMobileSetNickUI.this;
        RegByMobileSetNickUI.this.getString(2131755998);
        RegByMobileSetNickUI.a((RegByMobileSetNickUI)localObject1, h.a((Context)localObject2, RegByMobileSetNickUI.this.getString(2131764451), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(128592);
            g.azz().a(paramAnonymousMenuItem);
            AppMethodBeat.o(128592);
          }
        }));
        AppMethodBeat.o(128593);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128594);
        RegByMobileSetNickUI.this.hideVKB();
        RegByMobileSetNickUI.this.finish();
        AppMethodBeat.o(128594);
        return true;
      }
    });
    AppMethodBeat.o(128597);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128595);
    super.onCreate(paramBundle);
    this.kqC = getIntent().getBooleanExtra("is_sync_addr", false);
    this.dSf = getIntent().getExtras().getString("bindmcontact_mobile");
    initView();
    g.azz().a(126, this);
    AppMethodBeat.o(128595);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128596);
    if (this.kqB != null)
    {
      r localr = this.kqB;
      u localu = localr.kpv;
      localu.cancel();
      localu.timer.stopTimer();
      localu.reset();
      localr.text = null;
    }
    g.azz().b(126, this);
    super.onDestroy();
    AppMethodBeat.o(128596);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128598);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(128598);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128598);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128599);
    Log.i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(128599);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = z.aUc();
      Log.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + paramInt1 + " isSync = " + this.kqC);
      if (this.kqC)
      {
        paramInt1 &= 0xFFFDFFFF;
        com.tencent.mm.plugin.account.friend.a.l.gl(true);
        getApplicationContext();
        com.tencent.mm.platformtools.a.blm();
        Log.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = ".concat(String.valueOf(paramInt1)));
        g.aAh().azQ().set(7, Integer.valueOf(paramInt1));
        if (this.kqC) {
          break label329;
        }
      }
      label329:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramString = new bfx();
        paramString.LPB = 17;
        paramString.BsD = paramInt1;
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, paramString));
        com.tencent.mm.plugin.account.a.a.jRu.WZ();
        bf.iDu.aO("login_user_name", this.dSf);
        paramString = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString.addFlags(67108864);
        if (!((v)paramq).jkr) {
          break label334;
        }
        MMWizardActivity.b(this, new Intent(this, BindQQUI.class).putExtra("bindqq_regbymobile", 1), paramString);
        AppMethodBeat.o(128599);
        return;
        paramInt1 |= 0x20000;
        break;
      }
      label334:
      MMWizardActivity.b(this, new Intent(this, BindFacebookUI.class), paramString);
      AppMethodBeat.o(128599);
      return;
    }
    if (paramq.getType() == 126)
    {
      paramq = com.tencent.mm.h.a.Dk(paramString);
      if (paramq != null)
      {
        paramq.a(this, null, null);
        AppMethodBeat.o(128599);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128599);
      return;
      switch (paramInt1)
      {
      }
      do
      {
        i = 0;
        break;
        if ((paramInt2 == -7) || (paramInt2 == -10))
        {
          h.n(this, 2131764340, 2131764341);
          i = 1;
          break;
        }
      } while (paramInt2 != -75);
      h.n(this, 2131755301, 2131764341);
      i = 1;
    }
    Toast.makeText(this, getString(2131760872, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128599);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI
 * JD-Core Version:    0.7.0.1
 */