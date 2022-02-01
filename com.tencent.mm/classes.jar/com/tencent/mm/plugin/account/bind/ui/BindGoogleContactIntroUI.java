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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private boolean iFA;
  private String iFB;
  private ProgressDialog iFC;
  private x iFD;
  private int iFE;
  private View.OnClickListener iFF;
  private View.OnClickListener iFG;
  private ImageView iFv;
  private TextView iFw;
  private Button iFx;
  private Button iFy;
  private boolean iFz;
  
  public BindGoogleContactIntroUI()
  {
    AppMethodBeat.i(109763);
    this.iFz = false;
    this.iFA = false;
    this.iFF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109758);
        Object localObject = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
        ((Intent)localObject).putExtra("enter_scene", BindGoogleContactIntroUI.a(BindGoogleContactIntroUI.this));
        paramAnonymousView = BindGoogleContactIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109758);
      }
    };
    this.iFG = new View.OnClickListener()
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
  
  private void aOE()
  {
    AppMethodBeat.i(109769);
    this.iFy.setVisibility(8);
    this.iFx.setVisibility(0);
    this.iFv.setVisibility(0);
    this.iFw.setVisibility(0);
    this.iFw.setText(2131756441);
    this.iFx.setText(2131756439);
    this.iFx.setOnClickListener(this.iFF);
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
    this.iFv = ((ImageView)findViewById(2131304617));
    this.iFw = ((TextView)findViewById(2131304618));
    this.iFx = ((Button)findViewById(2131304616));
    this.iFy = ((Button)findViewById(2131304633));
    AppMethodBeat.o(109768);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109770);
    ac.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramInt1 == 2005)
      {
        this.iFz = paramIntent.getBooleanExtra("gpservices", false);
        AppMethodBeat.o(109770);
      }
    }
    else if (paramInt1 == 2005) {
      this.iFz = paramIntent.getBooleanExtra("gpservices", false);
    }
    AppMethodBeat.o(109770);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109764);
    super.onCreate(paramBundle);
    setMMTitle(2131756442);
    this.iFE = getIntent().getIntExtra("enter_scene", 0);
    this.iFz = m.dg(this);
    if (this.iFz) {
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
    this.iFB = ((String)com.tencent.mm.kernel.g.agR().agA().get(208903, null));
    if (TextUtils.isEmpty(this.iFB))
    {
      this.iFA = false;
      initView();
      if (!this.iFA) {
        break label139;
      }
      this.iFy.setVisibility(0);
      this.iFx.setVisibility(8);
      this.iFw.setVisibility(0);
      this.iFw.setText(getString(2131756440, new Object[] { this.iFB }));
      this.iFy.setOnClickListener(this.iFG);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agi().a(487, this);
      AppMethodBeat.o(109765);
      return;
      this.iFA = true;
      break;
      label139:
      aOE();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109771);
    paramn = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramn = "";
    }
    ac.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.kernel.g.agR().agA().set(208903, "");
      com.tencent.mm.kernel.g.agR().agA().set(208901, "");
      com.tencent.mm.kernel.g.agR().agA().set(208902, "");
      com.tencent.mm.kernel.g.agR().agA().set(208905, Boolean.TRUE);
      com.tencent.mm.kernel.g.agR().agA().faa();
      aOE();
      h.cg(this, getString(2131764549));
      AppMethodBeat.o(109771);
      return;
    }
    ac.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
    Toast.makeText(this, 2131760030, 0).show();
    AppMethodBeat.o(109771);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109766);
    super.onStop();
    com.tencent.mm.kernel.g.agi().b(487, this);
    AppMethodBeat.o(109766);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI
 * JD-Core Version:    0.7.0.1
 */