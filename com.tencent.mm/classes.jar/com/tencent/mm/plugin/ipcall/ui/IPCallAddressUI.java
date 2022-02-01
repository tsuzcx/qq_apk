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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ipcall.model.d;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;

public class IPCallAddressUI
  extends MMActivity
  implements i
{
  private View yua;
  private ListView yum;
  private e yun;
  private int yuo;
  private boolean yup;
  private boolean yuq;
  private boolean yur;
  private IListener yus;
  private Runnable yut;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(25671);
    this.yun = null;
    this.yuo = 0;
    this.yup = false;
    this.yuq = true;
    this.yur = false;
    this.yus = new IListener() {};
    this.yut = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25668);
        com.tencent.mm.plugin.ipcall.model.a.eab().a(null, true);
        AppMethodBeat.o(25668);
      }
    };
    AppMethodBeat.o(25671);
  }
  
  private void ebj()
  {
    AppMethodBeat.i(25673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (bool) {
      ThreadPool.post(this.yut, "IPCallAddressUI_LoadSystemAddressBook");
    }
    AppMethodBeat.o(25673);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495091;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(25678);
    if (this.yuo == 1)
    {
      com.tencent.mm.plugin.ipcall.b.jRt.o(new Intent(), this);
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
    bg.aVF();
    if (((Boolean)c.azQ().get(ar.a.NVH, Boolean.FALSE)).booleanValue())
    {
      bg.aVF();
      c.azQ().set(ar.a.NVH, Boolean.FALSE);
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), IPCallAcitivityUI.class);
      paramBundle = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(2130772169, 2130772166);
      this.yuq = false;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25667);
        if (IPCallAddressUI.b(IPCallAddressUI.this) == 1) {
          com.tencent.mm.plugin.ipcall.b.jRt.o(new Intent(), IPCallAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(25667);
          return true;
          IPCallAddressUI.this.finish();
        }
      }
    });
    if (this.yuq)
    {
      this.yur = true;
      ebj();
    }
    bg.aVF();
    this.yup = ((Boolean)c.azQ().get(ar.a.NVd, Boolean.TRUE)).booleanValue();
    setMMTitle(2131761893);
    this.yum = ((ListView)findViewById(2131296542));
    this.yua = findViewById(2131296570);
    this.yun = new e(this, this.yum, this.yua);
    paramBundle = this.yun;
    paramBundle.ytZ = new h(paramBundle.yub);
    Object localObject = (ViewGroup)View.inflate(paramBundle.yub, 2131495103, null);
    paramBundle.ytY.addHeaderView((View)localObject, null, false);
    paramBundle.ytY.setAdapter(paramBundle.ytZ);
    paramBundle.yud = ((TextView)((ViewGroup)localObject).findViewById(2131296344));
    paramBundle.yue = ((TextView)((ViewGroup)localObject).findViewById(2131296352));
    paramBundle.yuf = ((LinearLayout)((ViewGroup)localObject).findViewById(2131296340));
    paramBundle.yug = ((TextView)((ViewGroup)localObject).findViewById(2131296341));
    paramBundle.yuh = ((ImageView)((ViewGroup)localObject).findViewById(2131309593));
    ((ViewGroup)localObject).findViewById(2131296353).setOnClickListener(new e.1(paramBundle));
    ((ViewGroup)localObject).findViewById(2131299149).setOnClickListener(new e.2(paramBundle));
    ((ViewGroup)localObject).findViewById(2131299636).setOnClickListener(new e.3(paramBundle));
    paramBundle.ytY.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.ytY.setOnItemLongClickListener(new e.5(paramBundle));
    bg.aVF();
    if (((Boolean)c.azQ().get(ar.a.NVd, Boolean.TRUE)).booleanValue())
    {
      d.eah().qo(true);
      bg.aVF();
      c.azQ().set(ar.a.NVd, Boolean.FALSE);
      if (paramBundle.ytZ.getCount() <= 0) {
        break label607;
      }
      paramBundle.yua.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.ebi();
      paramBundle.ebh();
      paramBundle.yuc = true;
      bg.azz().a(257, this);
      EventCenter.instance.addListener(this.yus);
      this.yuo = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(25672);
      return;
      d.eah().qo(false);
      break;
      label607:
      paramBundle.yua.setVisibility(0);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25677);
    Log.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25677);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25674);
    super.onDestroy();
    if (this.yun != null)
    {
      Object localObject = this.yun;
      ((e)localObject).ytY.setOnItemClickListener(null);
      ((e)localObject).ytY.setOnItemLongClickListener(null);
      localObject = ((e)localObject).ytZ;
      p.aYn().b((e.a)localObject);
    }
    bg.azz().b(257, this);
    EventCenter.instance.removeListener(this.yus);
    AppMethodBeat.o(25674);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25679);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25679);
      return;
    }
    Log.i("MicroMsg.IPCallAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25679);
      return;
      if ((paramArrayOfInt[0] != 0) && (this.yup))
      {
        this.yup = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25669);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = IPCallAddressUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
    if (this.yun != null)
    {
      locale = this.yun;
      if ((locale.ytZ != null) && (!locale.yuc))
      {
        locale.ytZ.notifyDataSetChanged();
        if (locale.ytZ.getCount() <= 0) {
          break label101;
        }
        locale.yua.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.yuc = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.model.g.b.eaU().qy(true);
      if (!this.yur)
      {
        this.yur = true;
        ebj();
      }
      AppMethodBeat.o(25675);
      return;
      label101:
      locale.yua.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(25676);
    if (((paramq instanceof g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.yun != null)) {
      this.yun.ebi();
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