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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.l;

public class BindQQUI
  extends MMWizardActivity
  implements i
{
  private String kaI = null;
  private String kaJ = null;
  com.tencent.mm.ui.base.q tipDialog;
  private int type = 0;
  
  public int getLayoutId()
  {
    return 2131493231;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109983);
    long l = new p(Util.nullAsNil((Integer)g.aAh().azQ().get(9, null))).longValue();
    Object localObject;
    if (l == 0L)
    {
      setMMTitle(2131756670);
      localObject = (TextView)findViewById(2131307681);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(2131756668);
      ((TextView)findViewById(2131307682)).setVisibility(8);
      localObject = (Button)findViewById(2131297416);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(2131756667);
      ((Button)localObject).setOnClickListener(new BindQQUI.5(this));
      removeOptionMenu(1);
    }
    while (this.type == 1)
    {
      addTextOptionMenu(0, getString(2131755877), new MenuItem.OnMenuItemClickListener()
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
      setMMTitle(2131756666);
      localObject = (TextView)findViewById(2131307681);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(2131756664);
      localObject = (TextView)findViewById(2131307682);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(getString(2131756665) + l);
      localObject = (Button)findViewById(2131297416);
      ((Button)localObject).setVisibility(8);
      ((Button)localObject).setText(2131761583);
      ((Button)localObject).setOnClickListener(new BindQQUI.6(this));
      addIconOptionMenu(1, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109977);
          paramAnonymousMenuItem = new l(BindQQUI.this.getContext());
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(109975);
              paramAnonymous2m.setHeaderTitle(2131756613);
              paramAnonymous2m.kV(0, 2131766895);
              AppMethodBeat.o(109975);
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
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
                aa localaa = new aa(aa.kfh);
                g.azz().a(localaa, 0);
                paramAnonymous2MenuItem.getString(2131755998);
                paramAnonymous2MenuItem.tipDialog = h.a(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(2131755886), true, new BindQQUI.2(paramAnonymous2MenuItem));
              }
            }
          };
          paramAnonymousMenuItem.gXI();
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
    Log.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109985);
      return;
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
        paramIntent = new aa(aa.kfh);
        g.azz().a(paramIntent, 0);
        getString(2131755998);
        this.tipDialog = h.a(this, getString(2131755886), true, new DialogInterface.OnCancelListener()
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
    g.azz().a(254, this);
    g.azz().a(255, this);
    AppMethodBeat.o(109980);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109981);
    g.azz().b(254, this);
    g.azz().b(255, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(109984);
    Log.d("MicroMsg.BindQQUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramq.getType());
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramq.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.kaI = ((aa)paramq).bok();
        if ((this.kaI != null) && (this.kaI.length() > 0)) {
          g.aAh().azQ().set(102407, this.kaI);
        }
        if (!Util.isNullOrNil(this.kaJ))
        {
          paramString = new Intent(this, StartUnbindQQ.class);
          paramString.putExtra("notice", this.kaJ);
          ay(this, paramString);
          AppMethodBeat.o(109984);
          return;
        }
        paramString = new u(2);
        g.azz().a(paramString, 0);
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
        Log.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        h.a(getContext(), getString(2131765664), null, getString(2131765665), getString(2131765663), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109978);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(2131765661));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            c.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
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
        h.a(this, 2131765303, 2131755998, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -82)
      {
        h.a(this, 2131765304, 2131755998, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -83)
      {
        h.a(this, 2131765301, 2131755998, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -84)
      {
        h.a(this, 2131765302, 2131755998, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -85)
      {
        h.a(this, 2131765300, 2131755998, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -86)
      {
        h.a(this, 2131765306, 2131755998, null);
        AppMethodBeat.o(109984);
      }
    }
    else if (paramq.getType() == 255)
    {
      if (paramInt2 == 0)
      {
        ay(this, new Intent(this, StartUnbindQQ.class));
        AppMethodBeat.o(109984);
        return;
      }
      h.a(getContext(), getString(2131765664), null, getString(2131765665), getString(2131765663), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109979);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(2131765661));
          paramAnonymousDialogInterface.putExtra("from_unbind", true);
          c.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI
 * JD-Core Version:    0.7.0.1
 */