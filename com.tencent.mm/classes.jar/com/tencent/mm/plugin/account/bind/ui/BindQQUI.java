package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public class BindQQUI
  extends MMWizardActivity
  implements f
{
  private String iZM = null;
  private String iZN = null;
  com.tencent.mm.ui.base.p tipDialog;
  private int type = 0;
  
  public int getLayoutId()
  {
    return 2131493185;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109983);
    long l = new com.tencent.mm.b.p(bt.n((Integer)g.ajC().ajl().get(9, null))).longValue();
    Object localObject;
    if (l == 0L)
    {
      setMMTitle(2131756534);
      localObject = (TextView)findViewById(2131304629);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(2131756532);
      ((TextView)findViewById(2131304630)).setVisibility(8);
      localObject = (Button)findViewById(2131297260);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131756531);
      ((Button)localObject).setOnClickListener(new BindQQUI.5(this));
      removeOptionMenu(1);
    }
    while (this.type == 1)
    {
      addTextOptionMenu(0, getString(2131755796), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109971);
          BindQQUI.a(BindQQUI.this);
          AppMethodBeat.o(109971);
          return true;
        }
      });
      AppMethodBeat.o(109983);
      return;
      setMMTitle(2131756530);
      localObject = (TextView)findViewById(2131304629);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(2131756528);
      localObject = (TextView)findViewById(2131304630);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(getString(2131756529) + l);
      localObject = (Button)findViewById(2131297260);
      ((Button)localObject).setVisibility(8);
      ((Button)localObject).setText(2131760197);
      ((Button)localObject).setOnClickListener(new BindQQUI.6(this));
      addIconOptionMenu(1, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109977);
          paramAnonymousMenuItem = new com.tencent.mm.ui.tools.l(BindQQUI.this.getContext());
          paramAnonymousMenuItem.KJy = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(109975);
              paramAnonymous2l.setHeaderTitle(2131756477);
              paramAnonymous2l.jI(0, 2131764550);
              AppMethodBeat.o(109975);
            }
          };
          paramAnonymousMenuItem.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(109976);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(109976);
                return;
                paramAnonymous2MenuItem = BindQQUI.this;
                aa localaa = new aa(aa.jek);
                g.aiU().a(localaa, 0);
                paramAnonymous2MenuItem.getString(2131755906);
                paramAnonymous2MenuItem.tipDialog = h.b(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(2131755804), true, new BindQQUI.2(paramAnonymous2MenuItem));
              }
            }
          };
          paramAnonymousMenuItem.fKy();
          AppMethodBeat.o(109977);
          return false;
        }
      });
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109972);
        BindQQUI.this.hideVKB();
        BindQQUI.this.finish();
        AppMethodBeat.o(109972);
        return true;
      }
    });
    AppMethodBeat.o(109983);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109985);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109985);
      return;
      if (paramInt2 == -1)
      {
        ad.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
        paramIntent = new aa(aa.jek);
        g.aiU().a(paramIntent, 0);
        getString(2131755906);
        this.tipDialog = h.b(this, getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109980);
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
    g.aiU().a(254, this);
    g.aiU().a(255, this);
    AppMethodBeat.o(109980);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109981);
    g.aiU().b(254, this);
    g.aiU().b(255, this);
    super.onDestroy();
    AppMethodBeat.o(109981);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109982);
    super.onResume();
    initView();
    AppMethodBeat.o(109982);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(109984);
    ad.d("MicroMsg.BindQQUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramn.getType());
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramn.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.iZM = ((aa)paramn).aSZ();
        if ((this.iZM != null) && (this.iZM.length() > 0)) {
          g.ajC().ajl().set(102407, this.iZM);
        }
        if (!bt.isNullOrNil(this.iZN))
        {
          paramString = new Intent(this, StartUnbindQQ.class);
          paramString.putExtra("notice", this.iZN);
          al(this, paramString);
          AppMethodBeat.o(109984);
          return;
        }
        paramString = new t(2);
        g.aiU().a(paramString, 0);
        AppMethodBeat.o(109984);
        return;
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramInt2 == -3)
      {
        ad.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        h.a(getContext(), getString(2131763480), null, getString(2131763481), getString(2131763479), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109978);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(2131763478));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            d.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            AppMethodBeat.o(109978);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -81)
      {
        h.a(this, 2131763137, 2131755906, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -82)
      {
        h.a(this, 2131763138, 2131755906, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -83)
      {
        h.a(this, 2131763135, 2131755906, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -84)
      {
        h.a(this, 2131763136, 2131755906, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -85)
      {
        h.a(this, 2131763134, 2131755906, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -86)
      {
        h.a(this, 2131763140, 2131755906, null);
        AppMethodBeat.o(109984);
      }
    }
    else if (paramn.getType() == 255)
    {
      if (paramInt2 == 0)
      {
        al(this, new Intent(this, StartUnbindQQ.class));
        AppMethodBeat.o(109984);
        return;
      }
      h.a(getContext(), getString(2131763480), null, getString(2131763481), getString(2131763479), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109979);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(2131763478));
          paramAnonymousDialogInterface.putExtra("from_unbind", true);
          d.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
          AppMethodBeat.o(109979);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(109984);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI
 * JD-Core Version:    0.7.0.1
 */