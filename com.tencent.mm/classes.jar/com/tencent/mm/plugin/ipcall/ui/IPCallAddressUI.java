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
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;

public class IPCallAddressUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ListView sFG;
  private e sFH;
  private int sFI;
  private boolean sFJ;
  private boolean sFK;
  private boolean sFL;
  private com.tencent.mm.sdk.b.c sFM;
  private Runnable sFN;
  private View sFu;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(25671);
    this.sFH = null;
    this.sFI = 0;
    this.sFJ = false;
    this.sFK = true;
    this.sFL = false;
    this.sFM = new com.tencent.mm.sdk.b.c() {};
    this.sFN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25668);
        com.tencent.mm.plugin.ipcall.model.a.cGT().a(null, true);
        AppMethodBeat.o(25668);
      }
    };
    AppMethodBeat.o(25671);
  }
  
  private void cIb()
  {
    AppMethodBeat.i(25673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ad.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN() });
    if (bool) {
      com.tencent.mm.sdk.g.b.c(this.sFN, "IPCallAddressUI_LoadSystemAddressBook");
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
    if (this.sFI == 1)
    {
      com.tencent.mm.plugin.ipcall.b.hYt.p(new Intent(), this);
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
    az.arV();
    if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fjb, Boolean.FALSE)).booleanValue())
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fjb, Boolean.FALSE);
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), IPCallAcitivityUI.class);
      paramBundle = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772144, 2130772141);
      this.sFK = false;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25667);
        if (IPCallAddressUI.b(IPCallAddressUI.this) == 1) {
          com.tencent.mm.plugin.ipcall.b.hYt.p(new Intent(), IPCallAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(25667);
          return true;
          IPCallAddressUI.this.finish();
        }
      }
    });
    if (this.sFK)
    {
      this.sFL = true;
      cIb();
    }
    az.arV();
    this.sFJ = ((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fix, Boolean.TRUE)).booleanValue();
    setMMTitle(2131760448);
    this.sFG = ((ListView)findViewById(2131296469));
    this.sFu = findViewById(2131296496);
    this.sFH = new e(this, this.sFG, this.sFu);
    paramBundle = this.sFH;
    paramBundle.sFt = new h(paramBundle.sFv);
    Object localObject = (ViewGroup)View.inflate(paramBundle.sFv, 2131494511, null);
    paramBundle.sFs.addHeaderView((View)localObject, null, false);
    paramBundle.sFs.setAdapter(paramBundle.sFt);
    paramBundle.sFx = ((TextView)((ViewGroup)localObject).findViewById(2131296330));
    paramBundle.sFy = ((TextView)((ViewGroup)localObject).findViewById(2131296336));
    paramBundle.sFz = ((LinearLayout)((ViewGroup)localObject).findViewById(2131296326));
    paramBundle.sFA = ((TextView)((ViewGroup)localObject).findViewById(2131296327));
    paramBundle.sFB = ((ImageView)((ViewGroup)localObject).findViewById(2131306195));
    ((ViewGroup)localObject).findViewById(2131296337).setOnClickListener(new e.1(paramBundle));
    ((ViewGroup)localObject).findViewById(2131298711).setOnClickListener(new e.2(paramBundle));
    ((ViewGroup)localObject).findViewById(2131299113).setOnClickListener(new e.3(paramBundle));
    paramBundle.sFs.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.sFs.setOnItemLongClickListener(new e.5(paramBundle));
    az.arV();
    if (((Boolean)com.tencent.mm.model.c.afk().get(ae.a.Fix, Boolean.TRUE)).booleanValue())
    {
      d.cGZ().mo(true);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fix, Boolean.FALSE);
      if (paramBundle.sFt.getCount() <= 0) {
        break label607;
      }
      paramBundle.sFu.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.cIa();
      paramBundle.cHZ();
      paramBundle.sFw = true;
      az.aeS().a(257, this);
      com.tencent.mm.sdk.b.a.ESL.c(this.sFM);
      this.sFI = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(25672);
      return;
      d.cGZ().mo(false);
      break;
      label607:
      paramBundle.sFu.setVisibility(0);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25677);
    ad.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25677);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25674);
    super.onDestroy();
    if (this.sFH != null)
    {
      Object localObject = this.sFH;
      ((e)localObject).sFs.setOnItemClickListener(null);
      ((e)localObject).sFs.setOnItemLongClickListener(null);
      localObject = ((e)localObject).sFt;
      p.auq().b((e.a)localObject);
    }
    az.aeS().b(257, this);
    com.tencent.mm.sdk.b.a.ESL.d(this.sFM);
    AppMethodBeat.o(25674);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25679);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25679);
      return;
    }
    ad.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25679);
      return;
      if ((paramArrayOfInt[0] != 0) && (this.sFJ))
      {
        this.sFJ = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25669);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = IPCallAddressUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
    if (this.sFH != null)
    {
      locale = this.sFH;
      if ((locale.sFt != null) && (!locale.sFw))
      {
        locale.sFt.notifyDataSetChanged();
        if (locale.sFt.getCount() <= 0) {
          break label101;
        }
        locale.sFu.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.sFw = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.model.g.b.cHM().my(true);
      if (!this.sFL)
      {
        this.sFL = true;
        cIb();
      }
      AppMethodBeat.o(25675);
      return;
      label101:
      locale.sFu.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25676);
    if (((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.sFH != null)) {
      this.sFH.cIa();
    }
    AppMethodBeat.o(25676);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI
 * JD-Core Version:    0.7.0.1
 */