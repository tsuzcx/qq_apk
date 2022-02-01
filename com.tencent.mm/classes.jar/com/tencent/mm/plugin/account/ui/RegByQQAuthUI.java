package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class RegByQQAuthUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String account;
  private String ddJ;
  private String drF;
  private ProgressDialog fts = null;
  private String iJl;
  private EditText iWV = null;
  private int iWW;
  
  public int getLayoutId()
  {
    return 2131495243;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128666);
    this.iWW = getIntent().getIntExtra("RegByQQ_BindUin", 0);
    this.iJl = getIntent().getStringExtra("RegByQQ_RawPsw");
    this.account = getIntent().getStringExtra("RegByQQ_Account");
    this.ddJ = getIntent().getStringExtra("RegByQQ_Ticket");
    this.drF = getIntent().getStringExtra("RegByQQ_Nick");
    ac.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.iWW + "  pass:" + this.iJl + "  ticket:" + this.ddJ);
    this.iWV = ((EditText)findViewById(2131302857));
    if ((this.drF != null) && (!this.drF.equals(""))) {
      this.iWV.setText(this.drF);
    }
    setMMTitle(2131762378);
    addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128660);
        RegByQQAuthUI.a(RegByQQAuthUI.this, RegByQQAuthUI.a(RegByQQAuthUI.this).getText().toString().trim());
        if (RegByQQAuthUI.b(RegByQQAuthUI.this).equals(""))
        {
          h.l(RegByQQAuthUI.this, 2131764648, 2131755731);
          AppMethodBeat.o(128660);
          return true;
        }
        paramAnonymousMenuItem = new u("", RegByQQAuthUI.c(RegByQQAuthUI.this), RegByQQAuthUI.b(RegByQQAuthUI.this), RegByQQAuthUI.d(RegByQQAuthUI.this), "", "", RegByQQAuthUI.e(RegByQQAuthUI.this), 2);
        com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem, 0);
        RegByQQAuthUI localRegByQQAuthUI1 = RegByQQAuthUI.this;
        RegByQQAuthUI localRegByQQAuthUI2 = RegByQQAuthUI.this;
        RegByQQAuthUI.this.getString(2131755906);
        RegByQQAuthUI.a(localRegByQQAuthUI1, h.b(localRegByQQAuthUI2, RegByQQAuthUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(128659);
            com.tencent.mm.kernel.g.agi().a(paramAnonymousMenuItem);
            AppMethodBeat.o(128659);
          }
        }));
        AppMethodBeat.o(128660);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128661);
        RegByQQAuthUI.this.hideVKB();
        RegByQQAuthUI.this.finish();
        AppMethodBeat.o(128661);
        return true;
      }
    });
    AppMethodBeat.o(128666);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128662);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(128662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128663);
    super.onDestroy();
    AppMethodBeat.o(128663);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128665);
    super.onPause();
    com.tencent.mm.kernel.g.agi().b(126, this);
    AppMethodBeat.o(128665);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128664);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(126, this);
    AppMethodBeat.o(128664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128667);
    ac.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (!bs.iX(this))
    {
      AppMethodBeat.o(128667);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(128667);
        return;
        com.tencent.mm.kernel.a.unhold();
        ay.hnA.aL("login_user_name", this.account);
        paramString = new Intent(this, BindMContactIntroUI.class);
        paramString.putExtra("key_upload_scene", 1);
        paramString.putExtra("skip", true);
        paramn = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
        paramn.addFlags(67108864);
        paramn.putExtra("LauncherUI.enter_from_reg", true);
        MMWizardActivity.b(this, paramString, paramn);
      }
    }
    if (paramn.getType() == 126)
    {
      paramn = com.tencent.mm.h.a.rM(paramString);
      if (paramn != null)
      {
        paramn.a(this, null, null);
        AppMethodBeat.o(128667);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.iyy.a(getContext(), paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128667);
      return;
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -1: 
        if (com.tencent.mm.kernel.g.agi().aBK() == 5)
        {
          h.l(this, 2131761537, 2131761536);
          i = 1;
        }
        break;
      case -3: 
        h.l(this, 2131755730, 2131762376);
        i = 1;
        break;
      case -4: 
        h.l(this, 2131755729, 2131762376);
        i = 1;
        break;
      case -12: 
        h.l(this, 2131762377, 2131762376);
        i = 1;
        break;
      case -11: 
        h.l(this, 2131762375, 2131762376);
        i = 1;
        break;
      case -72: 
        h.l(getContext(), 2131762374, 2131755906);
        i = 1;
        break;
      case -75: 
        h.l(getContext(), 2131755266, 2131755906);
        i = 1;
      }
    }
    Toast.makeText(this, getString(2131759555, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128667);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI
 * JD-Core Version:    0.7.0.1
 */