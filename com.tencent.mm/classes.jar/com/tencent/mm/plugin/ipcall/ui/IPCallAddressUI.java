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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;

public class IPCallAddressUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private View tNb;
  private ListView tNn;
  private e tNo;
  private int tNp;
  private boolean tNq;
  private boolean tNr;
  private boolean tNs;
  private com.tencent.mm.sdk.b.c tNt;
  private Runnable tNu;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(25671);
    this.tNo = null;
    this.tNp = 0;
    this.tNq = false;
    this.tNr = true;
    this.tNs = false;
    this.tNt = new com.tencent.mm.sdk.b.c() {};
    this.tNu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25668);
        com.tencent.mm.plugin.ipcall.model.a.cUe().a(null, true);
        AppMethodBeat.o(25668);
      }
    };
    AppMethodBeat.o(25671);
  }
  
  private void cVm()
  {
    AppMethodBeat.i(25673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ac.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
    if (bool) {
      com.tencent.mm.sdk.g.b.c(this.tNu, "IPCallAddressUI_LoadSystemAddressBook");
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
    if (this.tNp == 1)
    {
      com.tencent.mm.plugin.ipcall.b.iyx.p(new Intent(), this);
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
    az.ayM();
    if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGQ, Boolean.FALSE)).booleanValue())
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GGQ, Boolean.FALSE);
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), IPCallAcitivityUI.class);
      paramBundle = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772144, 2130772141);
      this.tNr = false;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25667);
        if (IPCallAddressUI.b(IPCallAddressUI.this) == 1) {
          com.tencent.mm.plugin.ipcall.b.iyx.p(new Intent(), IPCallAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(25667);
          return true;
          IPCallAddressUI.this.finish();
        }
      }
    });
    if (this.tNr)
    {
      this.tNs = true;
      cVm();
    }
    az.ayM();
    this.tNq = ((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGm, Boolean.TRUE)).booleanValue();
    setMMTitle(2131760448);
    this.tNn = ((ListView)findViewById(2131296469));
    this.tNb = findViewById(2131296496);
    this.tNo = new e(this, this.tNn, this.tNb);
    paramBundle = this.tNo;
    paramBundle.tNa = new h(paramBundle.tNc);
    Object localObject = (ViewGroup)View.inflate(paramBundle.tNc, 2131494511, null);
    paramBundle.tMZ.addHeaderView((View)localObject, null, false);
    paramBundle.tMZ.setAdapter(paramBundle.tNa);
    paramBundle.tNe = ((TextView)((ViewGroup)localObject).findViewById(2131296330));
    paramBundle.tNf = ((TextView)((ViewGroup)localObject).findViewById(2131296336));
    paramBundle.tNg = ((LinearLayout)((ViewGroup)localObject).findViewById(2131296326));
    paramBundle.tNh = ((TextView)((ViewGroup)localObject).findViewById(2131296327));
    paramBundle.tNi = ((ImageView)((ViewGroup)localObject).findViewById(2131306195));
    ((ViewGroup)localObject).findViewById(2131296337).setOnClickListener(new e.1(paramBundle));
    ((ViewGroup)localObject).findViewById(2131298711).setOnClickListener(new e.2(paramBundle));
    ((ViewGroup)localObject).findViewById(2131299113).setOnClickListener(new e.3(paramBundle));
    paramBundle.tMZ.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.tMZ.setOnItemLongClickListener(new e.5(paramBundle));
    az.ayM();
    if (((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGm, Boolean.TRUE)).booleanValue())
    {
      d.cUk().nh(true);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GGm, Boolean.FALSE);
      if (paramBundle.tNa.getCount() <= 0) {
        break label607;
      }
      paramBundle.tNb.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.cVl();
      paramBundle.cVk();
      paramBundle.tNd = true;
      az.agi().a(257, this);
      com.tencent.mm.sdk.b.a.GpY.c(this.tNt);
      this.tNp = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(25672);
      return;
      d.cUk().nh(false);
      break;
      label607:
      paramBundle.tNb.setVisibility(0);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25677);
    ac.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25677);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25674);
    super.onDestroy();
    if (this.tNo != null)
    {
      Object localObject = this.tNo;
      ((e)localObject).tMZ.setOnItemClickListener(null);
      ((e)localObject).tMZ.setOnItemLongClickListener(null);
      localObject = ((e)localObject).tNa;
      p.aBh().b((e.a)localObject);
    }
    az.agi().b(257, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.tNt);
    AppMethodBeat.o(25674);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25679);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25679);
      return;
    }
    ac.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25679);
      return;
      if ((paramArrayOfInt[0] != 0) && (this.tNq))
      {
        this.tNq = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25669);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = IPCallAddressUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    if (this.tNo != null)
    {
      locale = this.tNo;
      if ((locale.tNa != null) && (!locale.tNd))
      {
        locale.tNa.notifyDataSetChanged();
        if (locale.tNa.getCount() <= 0) {
          break label101;
        }
        locale.tNb.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.tNd = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.model.g.b.cUX().nr(true);
      if (!this.tNs)
      {
        this.tNs = true;
        cVm();
      }
      AppMethodBeat.o(25675);
      return;
      label101:
      locale.tNb.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25676);
    if (((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.tNo != null)) {
      this.tNo.cVl();
    }
    AppMethodBeat.o(25676);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI
 * JD-Core Version:    0.7.0.1
 */