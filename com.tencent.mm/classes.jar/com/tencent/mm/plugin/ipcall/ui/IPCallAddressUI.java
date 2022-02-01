package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ipcall.model.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;

public class IPCallAddressUI
  extends MMActivity
  implements f
{
  private View vbA;
  private ListView vbM;
  private e vbN;
  private int vbO;
  private boolean vbP;
  private boolean vbQ;
  private boolean vbR;
  private com.tencent.mm.sdk.b.c vbS;
  private Runnable vbT;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(25671);
    this.vbN = null;
    this.vbO = 0;
    this.vbP = false;
    this.vbQ = true;
    this.vbR = false;
    this.vbS = new com.tencent.mm.sdk.b.c() {};
    this.vbT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25668);
        com.tencent.mm.plugin.ipcall.model.a.dgh().a(null, true);
        AppMethodBeat.o(25668);
      }
    };
    AppMethodBeat.o(25671);
  }
  
  private void dhp()
  {
    AppMethodBeat.i(25673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ae.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
    if (bool) {
      com.tencent.mm.sdk.g.b.c(this.vbT, "IPCallAddressUI_LoadSystemAddressBook");
    }
    AppMethodBeat.o(25673);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494499;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(25678);
    if (this.vbO == 1)
    {
      com.tencent.mm.plugin.ipcall.b.iUz.p(new Intent(), this);
      AppMethodBeat.o(25678);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(25678);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25672);
    super.onCreate(paramBundle);
    bc.aCg();
    if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INE, Boolean.FALSE)).booleanValue())
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.INE, Boolean.FALSE);
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), IPCallAcitivityUI.class);
      paramBundle = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772144, 2130772141);
      this.vbQ = false;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25667);
        if (IPCallAddressUI.b(IPCallAddressUI.this) == 1) {
          com.tencent.mm.plugin.ipcall.b.iUz.p(new Intent(), IPCallAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(25667);
          return true;
          IPCallAddressUI.this.finish();
        }
      }
    });
    if (this.vbQ)
    {
      this.vbR = true;
      dhp();
    }
    bc.aCg();
    this.vbP = ((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INa, Boolean.TRUE)).booleanValue();
    setMMTitle(2131760448);
    this.vbM = ((ListView)findViewById(2131296469));
    this.vbA = findViewById(2131296496);
    this.vbN = new e(this, this.vbM, this.vbA);
    paramBundle = this.vbN;
    paramBundle.vbz = new h(paramBundle.vbB);
    Object localObject = (ViewGroup)View.inflate(paramBundle.vbB, 2131494511, null);
    paramBundle.vby.addHeaderView((View)localObject, null, false);
    paramBundle.vby.setAdapter(paramBundle.vbz);
    paramBundle.vbD = ((TextView)((ViewGroup)localObject).findViewById(2131296330));
    paramBundle.vbE = ((TextView)((ViewGroup)localObject).findViewById(2131296336));
    paramBundle.vbF = ((LinearLayout)((ViewGroup)localObject).findViewById(2131296326));
    paramBundle.vbG = ((TextView)((ViewGroup)localObject).findViewById(2131296327));
    paramBundle.vbH = ((ImageView)((ViewGroup)localObject).findViewById(2131306195));
    ((ViewGroup)localObject).findViewById(2131296337).setOnClickListener(new e.1(paramBundle));
    ((ViewGroup)localObject).findViewById(2131298711).setOnClickListener(new e.2(paramBundle));
    ((ViewGroup)localObject).findViewById(2131299113).setOnClickListener(new e.3(paramBundle));
    paramBundle.vby.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.vby.setOnItemLongClickListener(new e.5(paramBundle));
    bc.aCg();
    if (((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INa, Boolean.TRUE)).booleanValue())
    {
      d.dgn().nF(true);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.INa, Boolean.FALSE);
      if (paramBundle.vbz.getCount() <= 0) {
        break label607;
      }
      paramBundle.vbA.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.dho();
      paramBundle.dhn();
      paramBundle.vbC = true;
      bc.ajj().a(257, this);
      com.tencent.mm.sdk.b.a.IvT.c(this.vbS);
      this.vbO = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(25672);
      return;
      d.dgn().nF(false);
      break;
      label607:
      paramBundle.vbA.setVisibility(0);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25677);
    ae.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25677);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25674);
    super.onDestroy();
    if (this.vbN != null)
    {
      Object localObject = this.vbN;
      ((e)localObject).vby.setOnItemClickListener(null);
      ((e)localObject).vby.setOnItemLongClickListener(null);
      localObject = ((e)localObject).vbz;
      p.aEA().b((e.a)localObject);
    }
    bc.ajj().b(257, this);
    com.tencent.mm.sdk.b.a.IvT.d(this.vbS);
    AppMethodBeat.o(25674);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25679);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25679);
      return;
    }
    ae.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25679);
      return;
      if ((paramArrayOfInt[0] != 0) && (this.vbP))
      {
        this.vbP = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25669);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = IPCallAddressUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(25669);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25670);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(25670);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25675);
    super.onResume();
    e locale;
    if (this.vbN != null)
    {
      locale = this.vbN;
      if ((locale.vbz != null) && (!locale.vbC))
      {
        locale.vbz.notifyDataSetChanged();
        if (locale.vbz.getCount() <= 0) {
          break label101;
        }
        locale.vbA.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.vbC = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.model.g.b.dha().nP(true);
      if (!this.vbR)
      {
        this.vbR = true;
        dhp();
      }
      AppMethodBeat.o(25675);
      return;
      label101:
      locale.vbA.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25676);
    if (((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.vbN != null)) {
      this.vbN.dho();
    }
    AppMethodBeat.o(25676);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI
 * JD-Core Version:    0.7.0.1
 */