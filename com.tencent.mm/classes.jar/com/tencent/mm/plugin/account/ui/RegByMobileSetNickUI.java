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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMEditText.c;

@Deprecated
public class RegByMobileSetNickUI
  extends MMActivity
  implements f
{
  private String dzn;
  private ProgressDialog fMu = null;
  private EditText jps;
  private q jpt = null;
  private boolean jpu;
  
  public int getLayoutId()
  {
    return 2131495241;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128597);
    setMMTitle(2131762343);
    this.jps = ((EditText)findViewById(2131303954));
    this.jps.addTextChangedListener(new MMEditText.c(this.jps, null, 16));
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128593);
        paramAnonymousMenuItem = RegByMobileSetNickUI.a(RegByMobileSetNickUI.this).getText().toString().trim();
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.length() <= 0))
        {
          h.l(RegByMobileSetNickUI.this, 2131764648, 2131762346);
          AppMethodBeat.o(128593);
          return true;
        }
        RegByMobileSetNickUI.this.hideVKB();
        Object localObject1 = RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd");
        Object localObject2 = RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket");
        paramAnonymousMenuItem = new com.tencent.mm.modelsimple.u("", (String)localObject1, paramAnonymousMenuItem, 0, "", RegByMobileSetNickUI.b(RegByMobileSetNickUI.this), (String)localObject2, 4);
        g.aiU().a(paramAnonymousMenuItem, 0);
        localObject1 = RegByMobileSetNickUI.this;
        localObject2 = RegByMobileSetNickUI.this;
        RegByMobileSetNickUI.this.getString(2131755906);
        RegByMobileSetNickUI.a((RegByMobileSetNickUI)localObject1, h.b((Context)localObject2, RegByMobileSetNickUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(128592);
            g.aiU().a(paramAnonymousMenuItem);
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
    this.jpu = getIntent().getBooleanExtra("is_sync_addr", false);
    this.dzn = getIntent().getExtras().getString("bindmcontact_mobile");
    initView();
    g.aiU().a(126, this);
    AppMethodBeat.o(128595);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128596);
    if (this.jpt != null)
    {
      q localq = this.jpt;
      t localt = localq.joo;
      localt.cancel();
      localt.cXg.stopTimer();
      localt.reset();
      localq.text = null;
    }
    g.aiU().b(126, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128599);
    ad.i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (!bt.jh(this))
    {
      AppMethodBeat.o(128599);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = com.tencent.mm.model.u.aAq();
      ad.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + paramInt1 + " isSync = " + this.jpu);
      if (this.jpu)
      {
        paramInt1 &= 0xFFFDFFFF;
        com.tencent.mm.plugin.account.friend.a.l.fr(true);
        getApplicationContext();
        com.tencent.mm.platformtools.a.aQj();
        ad.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = ".concat(String.valueOf(paramInt1)));
        g.ajC().ajl().set(7, Integer.valueOf(paramInt1));
        if (this.jpu) {
          break label329;
        }
      }
      label329:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramString = new aty();
        paramString.GrZ = 17;
        paramString.xcI = paramInt1;
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(23, paramString));
        com.tencent.mm.plugin.account.a.a.iRH.MR();
        az.hFS.aM("login_user_name", this.dzn);
        paramString = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString.addFlags(67108864);
        if (!((com.tencent.mm.modelsimple.u)paramn).imq) {
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
    if (paramn.getType() == 126)
    {
      paramn = com.tencent.mm.h.a.uz(paramString);
      if (paramn != null)
      {
        paramn.a(this, null, null);
        AppMethodBeat.o(128599);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.iRH.a(getContext(), paramInt1, paramInt2, paramString)) {
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
          h.l(this, 2131762274, 2131762275);
          i = 1;
          break;
        }
      } while (paramInt2 != -75);
      h.l(this, 2131755266, 2131762275);
      i = 1;
    }
    Toast.makeText(this, getString(2131759555, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128599);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI
 * JD-Core Version:    0.7.0.1
 */