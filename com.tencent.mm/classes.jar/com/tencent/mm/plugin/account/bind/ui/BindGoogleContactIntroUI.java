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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements f
{
  private Button jbA;
  private boolean jbB;
  private boolean jbC;
  private String jbD;
  private ProgressDialog jbE;
  private x jbF;
  private int jbG;
  private View.OnClickListener jbH;
  private View.OnClickListener jbI;
  private ImageView jbx;
  private TextView jby;
  private Button jbz;
  
  public BindGoogleContactIntroUI()
  {
    AppMethodBeat.i(109763);
    this.jbB = false;
    this.jbC = false;
    this.jbH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109758);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
        ((Intent)localObject).putExtra("enter_scene", BindGoogleContactIntroUI.a(BindGoogleContactIntroUI.this));
        paramAnonymousView = BindGoogleContactIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109758);
      }
    };
    this.jbI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109760);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109760);
      }
    };
    AppMethodBeat.o(109763);
  }
  
  private void aSp()
  {
    AppMethodBeat.i(109769);
    this.jbA.setVisibility(8);
    this.jbz.setVisibility(0);
    this.jbx.setVisibility(0);
    this.jby.setVisibility(0);
    this.jby.setText(2131756441);
    this.jbz.setText(2131756439);
    this.jbz.setOnClickListener(this.jbH);
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
    this.jbx = ((ImageView)findViewById(2131304617));
    this.jby = ((TextView)findViewById(2131304618));
    this.jbz = ((Button)findViewById(2131304616));
    this.jbA = ((Button)findViewById(2131304633));
    AppMethodBeat.o(109768);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109770);
    ae.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramInt1 == 2005)
      {
        this.jbB = paramIntent.getBooleanExtra("gpservices", false);
        AppMethodBeat.o(109770);
      }
    }
    else if (paramInt1 == 2005) {
      this.jbB = paramIntent.getBooleanExtra("gpservices", false);
    }
    AppMethodBeat.o(109770);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109764);
    super.onCreate(paramBundle);
    setMMTitle(2131756442);
    this.jbG = getIntent().getIntExtra("enter_scene", 0);
    this.jbB = m.dg(this);
    if (this.jbB) {
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
    this.jbD = ((String)g.ajR().ajA().get(208903, null));
    if (TextUtils.isEmpty(this.jbD))
    {
      this.jbC = false;
      initView();
      if (!this.jbC) {
        break label139;
      }
      this.jbA.setVisibility(0);
      this.jbz.setVisibility(8);
      this.jby.setVisibility(0);
      this.jby.setText(getString(2131756440, new Object[] { this.jbD }));
      this.jbA.setOnClickListener(this.jbI);
    }
    for (;;)
    {
      g.ajj().a(487, this);
      AppMethodBeat.o(109765);
      return;
      this.jbC = true;
      break;
      label139:
      aSp();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109771);
    paramn = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramn = "";
    }
    ae.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramn });
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.ajR().ajA().set(208903, "");
      g.ajR().ajA().set(208901, "");
      g.ajR().ajA().set(208902, "");
      g.ajR().ajA().set(208905, Boolean.TRUE);
      g.ajR().ajA().fuc();
      aSp();
      h.cm(this, getString(2131764549));
      AppMethodBeat.o(109771);
      return;
    }
    ae.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
    Toast.makeText(this, 2131760030, 0).show();
    AppMethodBeat.o(109771);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109766);
    super.onStop();
    g.ajj().b(487, this);
    AppMethodBeat.o(109766);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI
 * JD-Core Version:    0.7.0.1
 */