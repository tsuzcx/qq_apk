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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements f
{
  private ImageView iYE;
  private TextView iYF;
  private Button iYG;
  private Button iYH;
  private boolean iYI;
  private boolean iYJ;
  private String iYK;
  private ProgressDialog iYL;
  private x iYM;
  private int iYN;
  private View.OnClickListener iYO;
  private View.OnClickListener iYP;
  
  public BindGoogleContactIntroUI()
  {
    AppMethodBeat.i(109763);
    this.iYI = false;
    this.iYJ = false;
    this.iYO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109758);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = new Intent(BindGoogleContactIntroUI.this, BindGoogleContactUI.class);
        ((Intent)localObject).putExtra("enter_scene", BindGoogleContactIntroUI.a(BindGoogleContactIntroUI.this));
        paramAnonymousView = BindGoogleContactIntroUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109758);
      }
    };
    this.iYP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109760);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindGoogleContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
  
  private void aRQ()
  {
    AppMethodBeat.i(109769);
    this.iYH.setVisibility(8);
    this.iYG.setVisibility(0);
    this.iYE.setVisibility(0);
    this.iYF.setVisibility(0);
    this.iYF.setText(2131756441);
    this.iYG.setText(2131756439);
    this.iYG.setOnClickListener(this.iYO);
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
    this.iYE = ((ImageView)findViewById(2131304617));
    this.iYF = ((TextView)findViewById(2131304618));
    this.iYG = ((Button)findViewById(2131304616));
    this.iYH = ((Button)findViewById(2131304633));
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
        this.iYI = paramIntent.getBooleanExtra("gpservices", false);
        AppMethodBeat.o(109770);
      }
    }
    else if (paramInt1 == 2005) {
      this.iYI = paramIntent.getBooleanExtra("gpservices", false);
    }
    AppMethodBeat.o(109770);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109764);
    super.onCreate(paramBundle);
    setMMTitle(2131756442);
    this.iYN = getIntent().getIntExtra("enter_scene", 0);
    this.iYI = m.de(this);
    if (this.iYI) {
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
    this.iYK = ((String)g.ajC().ajl().get(208903, null));
    if (TextUtils.isEmpty(this.iYK))
    {
      this.iYJ = false;
      initView();
      if (!this.iYJ) {
        break label139;
      }
      this.iYH.setVisibility(0);
      this.iYG.setVisibility(8);
      this.iYF.setVisibility(0);
      this.iYF.setText(getString(2131756440, new Object[] { this.iYK }));
      this.iYH.setOnClickListener(this.iYP);
    }
    for (;;)
    {
      g.aiU().a(487, this);
      AppMethodBeat.o(109765);
      return;
      this.iYJ = true;
      break;
      label139:
      aRQ();
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
    if ((this.iYL != null) && (this.iYL.isShowing())) {
      this.iYL.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.ajC().ajl().set(208903, "");
      g.ajC().ajl().set(208901, "");
      g.ajC().ajl().set(208902, "");
      g.ajC().ajl().set(208905, Boolean.TRUE);
      g.ajC().ajl().fqc();
      aRQ();
      h.cl(this, getString(2131764549));
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
    g.aiU().b(487, this);
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