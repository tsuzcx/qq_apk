package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.j;
import com.tencent.mm.plugin.account.friend.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private ImageView pNA;
  private TextView pNB;
  private Button pNC;
  private Button pND;
  private boolean pNE;
  private boolean pNF;
  private String pNG;
  private ProgressDialog pNH;
  private u pNI;
  private int pNJ;
  private View.OnClickListener pNK;
  private View.OnClickListener pNL;
  
  public BindGoogleContactIntroUI()
  {
    AppMethodBeat.i(109763);
    this.pNE = false;
    this.pNF = false;
    this.pNK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109758);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
        ((Intent)localObject).putExtra("enter_scene", BindGoogleContactIntroUI.a(BindGoogleContactIntroUI.this));
        paramAnonymousView = BindGoogleContactIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109758);
      }
    };
    this.pNL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109760);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        k.a(BindGoogleContactIntroUI.this.getContext(), true, BindGoogleContactIntroUI.this.getString(a.i.unbind_gcontact_confirm), "", BindGoogleContactIntroUI.this.getString(a.i.unbind_gcontact_btn_setting), BindGoogleContactIntroUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void bWa()
  {
    AppMethodBeat.i(109769);
    this.pND.setVisibility(8);
    this.pNC.setVisibility(0);
    this.pNA.setVisibility(0);
    this.pNB.setVisibility(0);
    this.pNB.setText(a.i.bind_gcontact_contenct_setting);
    this.pNC.setText(a.i.bind_gcontact_btn_setting);
    this.pNC.setOnClickListener(this.pNK);
    AppMethodBeat.o(109769);
  }
  
  public int getLayoutId()
  {
    return a.f.bindgooglecontactintro;
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
    this.pNA = ((ImageView)findViewById(a.e.setting_bind_google_account_icon));
    this.pNB = ((TextView)findViewById(a.e.setting_bind_google_account_text));
    this.pNC = ((Button)findViewById(a.e.setting_bind_google_account_btn));
    this.pND = ((Button)findViewById(a.e.setting_unbind_google_account_btn));
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
        this.pNE = paramIntent.getBooleanExtra("gpservices", false);
        AppMethodBeat.o(109770);
      }
    }
    else if (paramInt1 == 2005) {
      this.pNE = paramIntent.getBooleanExtra("gpservices", false);
    }
    AppMethodBeat.o(109770);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109764);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_gcontact_title_setting);
    this.pNJ = getIntent().getIntExtra("enter_scene", 0);
    this.pNE = j.eq(this);
    if (this.pNE) {
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
    this.pNG = ((String)com.tencent.mm.kernel.h.baE().ban().d(208903, null));
    if (TextUtils.isEmpty(this.pNG))
    {
      this.pNF = false;
      initView();
      if (!this.pNF) {
        break label142;
      }
      this.pND.setVisibility(0);
      this.pNC.setVisibility(8);
      this.pNB.setVisibility(0);
      this.pNB.setText(getString(a.i.bind_gcontact_contenct_binded, new Object[] { this.pNG }));
      this.pND.setOnClickListener(this.pNL);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aZW().a(487, this);
      AppMethodBeat.o(109765);
      return;
      this.pNF = true;
      break;
      label142:
      bWa();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(109771);
    paramp = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramp = "";
    }
    Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramp });
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.kernel.h.baE().ban().B(208903, "");
      com.tencent.mm.kernel.h.baE().ban().B(208901, "");
      com.tencent.mm.kernel.h.baE().ban().B(208902, "");
      com.tencent.mm.kernel.h.baE().ban().B(208905, Boolean.TRUE);
      com.tencent.mm.kernel.h.baE().ban().iZy();
      bWa();
      k.cZ(this, getString(a.i.unbind_gcontact_success_tip));
      AppMethodBeat.o(109771);
      return;
    }
    Log.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
    Toast.makeText(this, a.i.gcontact_unbind_failed_msg, 0).show();
    AppMethodBeat.o(109771);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109766);
    super.onStop();
    com.tencent.mm.kernel.h.aZW().b(487, this);
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