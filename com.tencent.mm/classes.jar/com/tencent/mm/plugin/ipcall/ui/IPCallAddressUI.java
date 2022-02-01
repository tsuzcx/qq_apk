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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.ipcall.model.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;

public class IPCallAddressUI
  extends MMActivity
  implements f
{
  private View uPO;
  private ListView uQa;
  private e uQb;
  private int uQc;
  private boolean uQd;
  private boolean uQe;
  private boolean uQf;
  private com.tencent.mm.sdk.b.c uQg;
  private Runnable uQh;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(25671);
    this.uQb = null;
    this.uQc = 0;
    this.uQd = false;
    this.uQe = true;
    this.uQf = false;
    this.uQg = new com.tencent.mm.sdk.b.c() {};
    this.uQh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25668);
        com.tencent.mm.plugin.ipcall.model.a.ddp().a(null, true);
        AppMethodBeat.o(25668);
      }
    };
    AppMethodBeat.o(25671);
  }
  
  private void dex()
  {
    AppMethodBeat.i(25673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ad.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
    if (bool) {
      com.tencent.mm.sdk.g.b.c(this.uQh, "IPCallAddressUI_LoadSystemAddressBook");
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
    if (this.uQc == 1)
    {
      com.tencent.mm.plugin.ipcall.b.iRG.p(new Intent(), this);
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
    ba.aBQ();
    if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.Iti, Boolean.FALSE)).booleanValue())
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Iti, Boolean.FALSE);
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), IPCallAcitivityUI.class);
      paramBundle = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772144, 2130772141);
      this.uQe = false;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25667);
        if (IPCallAddressUI.b(IPCallAddressUI.this) == 1) {
          com.tencent.mm.plugin.ipcall.b.iRG.p(new Intent(), IPCallAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(25667);
          return true;
          IPCallAddressUI.this.finish();
        }
      }
    });
    if (this.uQe)
    {
      this.uQf = true;
      dex();
    }
    ba.aBQ();
    this.uQd = ((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsE, Boolean.TRUE)).booleanValue();
    setMMTitle(2131760448);
    this.uQa = ((ListView)findViewById(2131296469));
    this.uPO = findViewById(2131296496);
    this.uQb = new e(this, this.uQa, this.uPO);
    paramBundle = this.uQb;
    paramBundle.uPN = new h(paramBundle.uPP);
    Object localObject = (ViewGroup)View.inflate(paramBundle.uPP, 2131494511, null);
    paramBundle.uPM.addHeaderView((View)localObject, null, false);
    paramBundle.uPM.setAdapter(paramBundle.uPN);
    paramBundle.uPR = ((TextView)((ViewGroup)localObject).findViewById(2131296330));
    paramBundle.uPS = ((TextView)((ViewGroup)localObject).findViewById(2131296336));
    paramBundle.uPT = ((LinearLayout)((ViewGroup)localObject).findViewById(2131296326));
    paramBundle.uPU = ((TextView)((ViewGroup)localObject).findViewById(2131296327));
    paramBundle.uPV = ((ImageView)((ViewGroup)localObject).findViewById(2131306195));
    ((ViewGroup)localObject).findViewById(2131296337).setOnClickListener(new e.1(paramBundle));
    ((ViewGroup)localObject).findViewById(2131298711).setOnClickListener(new e.2(paramBundle));
    ((ViewGroup)localObject).findViewById(2131299113).setOnClickListener(new e.3(paramBundle));
    paramBundle.uPM.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.uPM.setOnItemLongClickListener(new e.5(paramBundle));
    ba.aBQ();
    if (((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsE, Boolean.TRUE)).booleanValue())
    {
      d.ddv().nB(true);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.IsE, Boolean.FALSE);
      if (paramBundle.uPN.getCount() <= 0) {
        break label607;
      }
      paramBundle.uPO.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.dew();
      paramBundle.dev();
      paramBundle.uPQ = true;
      ba.aiU().a(257, this);
      com.tencent.mm.sdk.b.a.IbL.c(this.uQg);
      this.uQc = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(25672);
      return;
      d.ddv().nB(false);
      break;
      label607:
      paramBundle.uPO.setVisibility(0);
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
    if (this.uQb != null)
    {
      Object localObject = this.uQb;
      ((e)localObject).uPM.setOnItemClickListener(null);
      ((e)localObject).uPM.setOnItemLongClickListener(null);
      localObject = ((e)localObject).uPN;
      p.aEk().b((e.a)localObject);
    }
    ba.aiU().b(257, this);
    com.tencent.mm.sdk.b.a.IbL.d(this.uQg);
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
      if ((paramArrayOfInt[0] != 0) && (this.uQd))
      {
        this.uQd = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25669);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = IPCallAddressUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    if (this.uQb != null)
    {
      locale = this.uQb;
      if ((locale.uPN != null) && (!locale.uPQ))
      {
        locale.uPN.notifyDataSetChanged();
        if (locale.uPN.getCount() <= 0) {
          break label101;
        }
        locale.uPO.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.uPQ = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.model.g.b.dei().nL(true);
      if (!this.uQf)
      {
        this.uQf = true;
        dex();
      }
      AppMethodBeat.o(25675);
      return;
      label101:
      locale.uPO.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25676);
    if (((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.uQb != null)) {
      this.uQb.dew();
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