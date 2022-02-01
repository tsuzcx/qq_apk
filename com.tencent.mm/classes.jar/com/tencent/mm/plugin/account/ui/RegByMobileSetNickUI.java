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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.MMEditText.c;

@Deprecated
public class RegByMobileSetNickUI
  extends MMActivity
  implements i
{
  private String fLC;
  private ProgressDialog iXX = null;
  private EditText nin;
  private s nio = null;
  private boolean nip;
  
  public int getLayoutId()
  {
    return r.g.regbymobilesetnick_reg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128597);
    setMMTitle(r.j.regbymobile_reg_setnick_title);
    this.nin = ((EditText)findViewById(r.f.regbymobilereg_nick_et));
    this.nin.addTextChangedListener(new MMEditText.c(this.nin, null, 16));
    addTextOptionMenu(0, getString(r.j.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128593);
        paramAnonymousMenuItem = RegByMobileSetNickUI.a(RegByMobileSetNickUI.this).getText().toString().trim();
        if ((paramAnonymousMenuItem == null) || (paramAnonymousMenuItem.length() <= 0))
        {
          com.tencent.mm.ui.base.h.p(RegByMobileSetNickUI.this, r.j.verify_account_null_tip, r.j.regbymobile_reg_setpwd_alert_title);
          AppMethodBeat.o(128593);
          return true;
        }
        RegByMobileSetNickUI.this.hideVKB();
        Object localObject1 = RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd");
        Object localObject2 = RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket");
        paramAnonymousMenuItem = new v("", (String)localObject1, paramAnonymousMenuItem, 0, "", RegByMobileSetNickUI.b(RegByMobileSetNickUI.this), (String)localObject2, 4);
        com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem, 0);
        localObject1 = RegByMobileSetNickUI.this;
        localObject2 = RegByMobileSetNickUI.this;
        RegByMobileSetNickUI.this.getString(r.j.app_tip);
        RegByMobileSetNickUI.a((RegByMobileSetNickUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, RegByMobileSetNickUI.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(128592);
            com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem);
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
    this.nip = getIntent().getBooleanExtra("is_sync_addr", false);
    this.fLC = getIntent().getExtras().getString("bindmcontact_mobile");
    initView();
    com.tencent.mm.kernel.h.aGY().a(126, this);
    AppMethodBeat.o(128595);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128596);
    if (this.nio != null)
    {
      AppMethodBeat.o(128596);
      throw null;
    }
    com.tencent.mm.kernel.h.aGY().b(126, this);
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
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(128599);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = z.bdd();
      Log.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + paramInt1 + " isSync = " + this.nip);
      if (this.nip)
      {
        paramInt1 &= 0xFFFDFFFF;
        com.tencent.mm.plugin.account.friend.a.l.gX(true);
        getApplicationContext();
        com.tencent.mm.platformtools.a.bvc();
        Log.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = ".concat(String.valueOf(paramInt1)));
        com.tencent.mm.kernel.h.aHG().aHp().i(7, Integer.valueOf(paramInt1));
        if (this.nip) {
          break label329;
        }
      }
      label329:
      for (paramInt1 = 1;; paramInt1 = 2)
      {
        paramString = new bmy();
        paramString.SXP = 17;
        paramString.HmX = paramInt1;
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, paramString));
        com.tencent.mm.plugin.account.sdk.a.mIH.abC();
        bg.ltv.aS("login_user_name", this.fLC);
        paramString = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString.addFlags(67108864);
        if (!((v)paramq).mao) {
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
      paramq = com.tencent.mm.h.a.Kb(paramString);
      if (paramq != null)
      {
        paramq.a(this, null, null);
        AppMethodBeat.o(128599);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(getContext(), paramInt1, paramInt2, paramString)) {
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
          com.tencent.mm.ui.base.h.p(this, r.j.reg_username_exist_tip, r.j.reg_username_exist_title);
          i = 1;
          break;
        }
      } while (paramInt2 != -75);
      com.tencent.mm.ui.base.h.p(this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      i = 1;
    }
    Toast.makeText(this, getString(r.j.fmt_reg_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128599);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI
 * JD-Core Version:    0.7.0.1
 */