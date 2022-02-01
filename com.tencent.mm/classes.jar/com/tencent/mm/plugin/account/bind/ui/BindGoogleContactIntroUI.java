package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ImageView ifm;
  private TextView ifn;
  private Button ifo;
  private Button ifp;
  private boolean ifq;
  private boolean ifr;
  private String ifs;
  private ProgressDialog ift;
  private x ifu;
  private int ifv;
  private View.OnClickListener ifw;
  private View.OnClickListener ifx;
  
  public BindGoogleContactIntroUI()
  {
    AppMethodBeat.i(109763);
    this.ifq = false;
    this.ifr = false;
    this.ifw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109758);
        Object localObject = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
        ((Intent)localObject).putExtra("enter_scene", BindGoogleContactIntroUI.a(BindGoogleContactIntroUI.this));
        paramAnonymousView = BindGoogleContactIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109758);
      }
    };
    this.ifx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109760);
        h.a(BindGoogleContactIntroUI.this.getContext(), true, BindGoogleContactIntroUI.this.getString(2131764548), "", BindGoogleContactIntroUI.this.getString(2131764547), BindGoogleContactIntroUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(109759);
            BindGoogleContactIntroUI.b(BindGoogleContactIntroUI.this);
            AppMethodBeat.o(109759);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(109760);
      }
    };
    AppMethodBeat.o(109763);
  }
  
  private void aHN()
  {
    AppMethodBeat.i(109769);
    this.ifp.setVisibility(8);
    this.ifo.setVisibility(0);
    this.ifm.setVisibility(0);
    this.ifn.setVisibility(0);
    this.ifn.setText(2131756441);
    this.ifo.setText(2131756439);
    this.ifo.setOnClickListener(this.ifw);
    AppMethodBeat.o(109769);
  }
  
  public int getLayoutId()
  {
    return 2131493177;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109768);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109761);
        BindGoogleContactIntroUI.this.finish();
        AppMethodBeat.o(109761);
        return true;
      }
    });
    this.ifm = ((ImageView)findViewById(2131304617));
    this.ifn = ((TextView)findViewById(2131304618));
    this.ifo = ((Button)findViewById(2131304616));
    this.ifp = ((Button)findViewById(2131304633));
    AppMethodBeat.o(109768);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109770);
    ad.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramInt1 == 2005)
      {
        this.ifq = paramIntent.getBooleanExtra("gpservices", false);
        AppMethodBeat.o(109770);
      }
    }
    else if (paramInt1 == 2005) {
      this.ifq = paramIntent.getBooleanExtra("gpservices", false);
    }
    AppMethodBeat.o(109770);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109764);
    super.onCreate(paramBundle);
    setMMTitle(2131756442);
    this.ifv = getIntent().getIntExtra("enter_scene", 0);
    this.ifq = m.cX(this);
    if (this.ifq) {
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
    AppMethodBeat.o(109764);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109767);
    super.onDestroy();
    AppMethodBeat.o(109767);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109765);
    super.onResume();
    this.ifs = ((String)com.tencent.mm.kernel.g.afB().afk().get(208903, null));
    if (TextUtils.isEmpty(this.ifs))
    {
      this.ifr = false;
      initView();
      if (!this.ifr) {
        break label139;
      }
      this.ifp.setVisibility(0);
      this.ifo.setVisibility(8);
      this.ifn.setVisibility(0);
      this.ifn.setText(getString(2131756440, new Object[] { this.ifs }));
      this.ifp.setOnClickListener(this.ifx);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aeS().a(487, this);
      AppMethodBeat.o(109765);
      return;
      this.ifr = true;
      break;
      label139:
      aHN();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109771);
    paramn = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramn = "";
    }
    ad.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    if ((this.ift != null) && (this.ift.isShowing())) {
      this.ift.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.kernel.g.afB().afk().set(208903, "");
      com.tencent.mm.kernel.g.afB().afk().set(208901, "");
      com.tencent.mm.kernel.g.afB().afk().set(208902, "");
      com.tencent.mm.kernel.g.afB().afk().set(208905, Boolean.TRUE);
      com.tencent.mm.kernel.g.afB().afk().eKy();
      aHN();
      h.cf(this, getString(2131764549));
      AppMethodBeat.o(109771);
      return;
    }
    ad.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
    Toast.makeText(this, 2131760030, 0).show();
    AppMethodBeat.o(109771);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109766);
    super.onStop();
    com.tencent.mm.kernel.g.aeS().b(487, this);
    AppMethodBeat.o(109766);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI
 * JD-Core Version:    0.7.0.1
 */