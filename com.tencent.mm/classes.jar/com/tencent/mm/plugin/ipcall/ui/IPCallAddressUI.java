package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ln;
import com.tencent.mm.model.bh;
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
  private View DUe;
  private ListView DUq;
  private e DUr;
  private int DUs;
  private boolean DUt;
  private boolean DUu;
  private boolean DUv;
  private IListener DUw;
  private Runnable DUx;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(25671);
    this.DUr = null;
    this.DUs = 0;
    this.DUt = false;
    this.DUu = true;
    this.DUv = false;
    this.DUw = new IListener() {};
    this.DUx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25668);
        com.tencent.mm.plugin.ipcall.model.a.eIZ().a(null, true);
        AppMethodBeat.o(25668);
      }
    };
    AppMethodBeat.o(25671);
  }
  
  private void eKh()
  {
    AppMethodBeat.i(25673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    Log.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (bool) {
      ThreadPool.post(this.DUx, "IPCallAddressUI_LoadSystemAddressBook");
    }
    AppMethodBeat.o(25673);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.ehK;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(25678);
    if (this.DUs == 1)
    {
      com.tencent.mm.plugin.ipcall.b.mIG.n(new Intent(), this);
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
    bh.beI();
    if (((Boolean)c.aHp().get(ar.a.VjH, Boolean.FALSE)).booleanValue())
    {
      bh.beI();
      c.aHp().set(ar.a.VjH, Boolean.FALSE);
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), IPCallAcitivityUI.class);
      paramBundle = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      this.DUu = false;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25667);
        if (IPCallAddressUI.b(IPCallAddressUI.this) == 1) {
          com.tencent.mm.plugin.ipcall.b.mIG.n(new Intent(), IPCallAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(25667);
          return true;
          IPCallAddressUI.this.finish();
        }
      }
    });
    if (this.DUu)
    {
      this.DUv = true;
      eKh();
    }
    bh.beI();
    this.DUt = ((Boolean)c.aHp().get(ar.a.Vjd, Boolean.TRUE)).booleanValue();
    setMMTitle(R.l.ip_call_func_name);
    this.DUq = ((ListView)findViewById(R.h.dqn));
    this.DUe = findViewById(R.h.dqB);
    this.DUr = new e(this, this.DUq, this.DUe);
    paramBundle = this.DUr;
    paramBundle.DUd = new h(paramBundle.DUf);
    Object localObject = (ViewGroup)View.inflate(paramBundle.DUf, R.i.ehW, null);
    paramBundle.DUc.addHeaderView((View)localObject, null, false);
    paramBundle.DUc.setAdapter(paramBundle.DUd);
    paramBundle.DUh = ((TextView)((ViewGroup)localObject).findViewById(R.h.dpF));
    paramBundle.DUi = ((TextView)((ViewGroup)localObject).findViewById(R.h.dpG));
    paramBundle.DUj = ((LinearLayout)((ViewGroup)localObject).findViewById(R.h.dpD));
    paramBundle.DUk = ((TextView)((ViewGroup)localObject).findViewById(R.h.dpE));
    paramBundle.DUl = ((ImageView)((ViewGroup)localObject).findViewById(R.h.dYu));
    ((ViewGroup)localObject).findViewById(R.h.dpH).setOnClickListener(new e.1(paramBundle));
    ((ViewGroup)localObject).findViewById(R.h.dCr).setOnClickListener(new e.2(paramBundle));
    ((ViewGroup)localObject).findViewById(R.h.dEJ).setOnClickListener(new e.3(paramBundle));
    paramBundle.DUc.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.DUc.setOnItemLongClickListener(new e.5(paramBundle));
    bh.beI();
    if (((Boolean)c.aHp().get(ar.a.Vjd, Boolean.TRUE)).booleanValue())
    {
      d.eJf().tq(true);
      bh.beI();
      c.aHp().set(ar.a.Vjd, Boolean.FALSE);
      if (paramBundle.DUd.getCount() <= 0) {
        break label612;
      }
      paramBundle.DUe.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.eKg();
      paramBundle.eKf();
      paramBundle.DUg = true;
      bh.aGY().a(257, this);
      EventCenter.instance.addListener(this.DUw);
      this.DUs = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(25672);
      return;
      d.eJf().tq(false);
      break;
      label612:
      paramBundle.DUe.setVisibility(0);
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
    if (this.DUr != null)
    {
      Object localObject = this.DUr;
      ((e)localObject).DUc.setOnItemClickListener(null);
      ((e)localObject).DUc.setOnItemLongClickListener(null);
      localObject = ((e)localObject).DUd;
      com.tencent.mm.am.q.bhz().b((f.a)localObject);
    }
    bh.aGY().b(257, this);
    EventCenter.instance.removeListener(this.DUw);
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
      if ((paramArrayOfInt[0] != 0) && (this.DUt))
      {
        this.DUt = false;
        com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25669);
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = IPCallAddressUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    if (this.DUr != null)
    {
      locale = this.DUr;
      if ((locale.DUd != null) && (!locale.DUg))
      {
        locale.DUd.notifyDataSetChanged();
        if (locale.DUd.getCount() <= 0) {
          break label101;
        }
        locale.DUe.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.DUg = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.model.g.b.eJS().tA(true);
      if (!this.DUv)
      {
        this.DUv = true;
        eKh();
      }
      AppMethodBeat.o(25675);
      return;
      label101:
      locale.DUe.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(25676);
    if (((paramq instanceof g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.DUr != null)) {
      this.DUr.eKg();
    }
    AppMethodBeat.o(25676);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI
 * JD-Core Version:    0.7.0.1
 */