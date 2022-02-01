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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class RegByQQAuthUI
  extends MMActivity
  implements i
{
  private String account;
  private String dHx;
  private String dWp;
  private ProgressDialog gtM = null;
  private String kdq;
  private EditText krm = null;
  private int krn;
  
  public int getLayoutId()
  {
    return 2131496089;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128666);
    this.krn = getIntent().getIntExtra("RegByQQ_BindUin", 0);
    this.kdq = getIntent().getStringExtra("RegByQQ_RawPsw");
    this.account = getIntent().getStringExtra("RegByQQ_Account");
    this.dHx = getIntent().getStringExtra("RegByQQ_Ticket");
    this.dWp = getIntent().getStringExtra("RegByQQ_Nick");
    Log.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.krn + "  pass:" + this.kdq + "  ticket:" + this.dHx);
    this.krm = ((EditText)findViewById(2131305430));
    if ((this.dWp != null) && (!this.dWp.equals(""))) {
      this.krm.setText(this.dWp);
    }
    setMMTitle(2131764444);
    addTextOptionMenu(0, getString(2131755916), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128660);
        RegByQQAuthUI.a(RegByQQAuthUI.this, RegByQQAuthUI.a(RegByQQAuthUI.this).getText().toString().trim());
        if (RegByQQAuthUI.b(RegByQQAuthUI.this).equals(""))
        {
          h.n(RegByQQAuthUI.this, 2131767019, 2131755802);
          AppMethodBeat.o(128660);
          return true;
        }
        paramAnonymousMenuItem = new v("", RegByQQAuthUI.c(RegByQQAuthUI.this), RegByQQAuthUI.b(RegByQQAuthUI.this), RegByQQAuthUI.d(RegByQQAuthUI.this), "", "", RegByQQAuthUI.e(RegByQQAuthUI.this), 2);
        g.azz().a(paramAnonymousMenuItem, 0);
        RegByQQAuthUI localRegByQQAuthUI1 = RegByQQAuthUI.this;
        RegByQQAuthUI localRegByQQAuthUI2 = RegByQQAuthUI.this;
        RegByQQAuthUI.this.getString(2131755998);
        RegByQQAuthUI.a(localRegByQQAuthUI1, h.a(localRegByQQAuthUI2, RegByQQAuthUI.this.getString(2131764451), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(128659);
            g.azz().a(paramAnonymousMenuItem);
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
    g.azz().b(126, this);
    AppMethodBeat.o(128665);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128664);
    super.onResume();
    g.azz().a(126, this);
    AppMethodBeat.o(128664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128667);
    Log.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(128667);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramq.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(128667);
        return;
        com.tencent.mm.kernel.a.unhold();
        bf.iDu.aO("login_user_name", this.account);
        paramString = new Intent(this, BindMContactIntroUI.class);
        paramString.putExtra("key_upload_scene", 1);
        paramString.putExtra("skip", true);
        paramq = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
        paramq.addFlags(67108864);
        paramq.putExtra("LauncherUI.enter_from_reg", true);
        MMWizardActivity.b(this, paramString, paramq);
      }
    }
    if (paramq.getType() == 126)
    {
      paramq = com.tencent.mm.h.a.Dk(paramString);
      if (paramq != null)
      {
        paramq.a(this, null, null);
        AppMethodBeat.o(128667);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString)) {
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
        if (g.azz().aYS() == 5)
        {
          h.n(this, 2131763503, 2131763502);
          i = 1;
        }
        break;
      case -3: 
        h.n(this, 2131755801, 2131764442);
        i = 1;
        break;
      case -4: 
        h.n(this, 2131755800, 2131764442);
        i = 1;
        break;
      case -12: 
        h.n(this, 2131764443, 2131764442);
        i = 1;
        break;
      case -11: 
        h.n(this, 2131764441, 2131764442);
        i = 1;
        break;
      case -72: 
        h.n(getContext(), 2131764440, 2131755998);
        i = 1;
        break;
      case -75: 
        h.n(getContext(), 2131755301, 2131755998);
        i = 1;
      }
    }
    Toast.makeText(this, getString(2131760872, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128667);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI
 * JD-Core Version:    0.7.0.1
 */