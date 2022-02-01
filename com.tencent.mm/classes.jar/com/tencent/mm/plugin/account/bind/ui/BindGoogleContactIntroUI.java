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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements i
{
  private ImageView jZA;
  private TextView jZB;
  private Button jZC;
  private Button jZD;
  private boolean jZE;
  private boolean jZF;
  private String jZG;
  private ProgressDialog jZH;
  private x jZI;
  private int jZJ;
  private View.OnClickListener jZK;
  private View.OnClickListener jZL;
  
  public BindGoogleContactIntroUI()
  {
    AppMethodBeat.i(109763);
    this.jZE = false;
    this.jZF = false;
    this.jZK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109758);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
        ((Intent)localObject).putExtra("enter_scene", BindGoogleContactIntroUI.a(BindGoogleContactIntroUI.this));
        paramAnonymousView = BindGoogleContactIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109758);
      }
    };
    this.jZL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109760);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.a(BindGoogleContactIntroUI.this.getContext(), true, BindGoogleContactIntroUI.this.getString(2131766893), "", BindGoogleContactIntroUI.this.getString(2131766892), BindGoogleContactIntroUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void bnc()
  {
    AppMethodBeat.i(109769);
    this.jZD.setVisibility(8);
    this.jZC.setVisibility(0);
    this.jZA.setVisibility(0);
    this.jZB.setVisibility(0);
    this.jZB.setText(2131756577);
    this.jZC.setText(2131756575);
    this.jZC.setOnClickListener(this.jZK);
    AppMethodBeat.o(109769);
  }
  
  public int getLayoutId()
  {
    return 2131493223;
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
    this.jZA = ((ImageView)findViewById(2131307669));
    this.jZB = ((TextView)findViewById(2131307670));
    this.jZC = ((Button)findViewById(2131307668));
    this.jZD = ((Button)findViewById(2131307685));
    AppMethodBeat.o(109768);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109770);
    Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      if (paramInt1 == 2005)
      {
        this.jZE = paramIntent.getBooleanExtra("gpservices", false);
        AppMethodBeat.o(109770);
      }
    }
    else if (paramInt1 == 2005) {
      this.jZE = paramIntent.getBooleanExtra("gpservices", false);
    }
    AppMethodBeat.o(109770);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109764);
    super.onCreate(paramBundle);
    setMMTitle(2131756578);
    this.jZJ = getIntent().getIntExtra("enter_scene", 0);
    this.jZE = m.dB(this);
    if (this.jZE) {
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
    this.jZG = ((String)g.aAh().azQ().get(208903, null));
    if (TextUtils.isEmpty(this.jZG))
    {
      this.jZF = false;
      initView();
      if (!this.jZF) {
        break label139;
      }
      this.jZD.setVisibility(0);
      this.jZC.setVisibility(8);
      this.jZB.setVisibility(0);
      this.jZB.setText(getString(2131756576, new Object[] { this.jZG }));
      this.jZD.setOnClickListener(this.jZL);
    }
    for (;;)
    {
      g.azz().a(487, this);
      AppMethodBeat.o(109765);
      return;
      this.jZF = true;
      break;
      label139:
      bnc();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(109771);
    paramq = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramq = "";
    }
    Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramq });
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.aAh().azQ().set(208903, "");
      g.aAh().azQ().set(208901, "");
      g.aAh().azQ().set(208902, "");
      g.aAh().azQ().set(208905, Boolean.TRUE);
      g.aAh().azQ().gBI();
      bnc();
      h.cD(this, getString(2131766894));
      AppMethodBeat.o(109771);
      return;
    }
    Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
    Toast.makeText(this, 2131761408, 0).show();
    AppMethodBeat.o(109771);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109766);
    super.onStop();
    g.azz().b(487, this);
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