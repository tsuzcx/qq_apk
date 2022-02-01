package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ms;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.plugin.ipcall.model.d;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class IPCallAddressUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private ListView JLA;
  private e JLB;
  private int JLC;
  private boolean JLD;
  private boolean JLE;
  private boolean JLF;
  private IListener JLG;
  private Runnable JLH;
  private View JLo;
  
  public IPCallAddressUI()
  {
    AppMethodBeat.i(25671);
    this.JLB = null;
    this.JLC = 0;
    this.JLD = false;
    this.JLE = true;
    this.JLF = false;
    this.JLG = new IListener(f.hfK) {};
    this.JLH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25668);
        com.tencent.mm.plugin.ipcall.model.a.fRa().a(null, true);
        AppMethodBeat.o(25668);
      }
    };
    AppMethodBeat.o(25671);
  }
  
  private void fSh()
  {
    AppMethodBeat.i(25673);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null);
    Log.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (bool) {
      ThreadPool.post(this.JLH, "IPCallAddressUI_LoadSystemAddressBook");
    }
    AppMethodBeat.o(25673);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gkF;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(25678);
    if (this.JLC == 1)
    {
      com.tencent.mm.plugin.ipcall.b.pFn.n(new Intent(), this);
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
    bh.bCz();
    if (((Boolean)c.ban().get(at.a.acLb, Boolean.FALSE)).booleanValue())
    {
      bh.bCz();
      c.ban().set(at.a.acLb, Boolean.FALSE);
      localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), IPCallAcitivityUI.class);
      paramBundle = getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/ipcall/ui/IPCallAddressUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
      this.JLE = false;
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25667);
        if (IPCallAddressUI.b(IPCallAddressUI.this) == 1) {
          com.tencent.mm.plugin.ipcall.b.pFn.n(new Intent(), IPCallAddressUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(25667);
          return true;
          IPCallAddressUI.this.finish();
        }
      }
    });
    if (this.JLE)
    {
      this.JLF = true;
      fSh();
    }
    bh.bCz();
    this.JLD = ((Boolean)c.ban().get(at.a.acKx, Boolean.TRUE)).booleanValue();
    setMMTitle(R.l.ip_call_func_name);
    this.JLA = ((ListView)findViewById(R.h.fqB));
    this.JLo = findViewById(R.h.fqP);
    this.JLB = new e(this, this.JLA, this.JLo);
    paramBundle = this.JLB;
    paramBundle.JLn = new h(paramBundle.JLp);
    Object localObject = (ViewGroup)View.inflate(paramBundle.JLp, R.i.gkR, null);
    paramBundle.JLm.addHeaderView((View)localObject, null, false);
    paramBundle.JLm.setAdapter(paramBundle.JLn);
    paramBundle.JLr = ((TextView)((ViewGroup)localObject).findViewById(R.h.fpT));
    paramBundle.JLs = ((TextView)((ViewGroup)localObject).findViewById(R.h.fpU));
    paramBundle.JLt = ((LinearLayout)((ViewGroup)localObject).findViewById(R.h.fpR));
    paramBundle.JLu = ((TextView)((ViewGroup)localObject).findViewById(R.h.fpS));
    paramBundle.JLv = ((ImageView)((ViewGroup)localObject).findViewById(R.h.gbi));
    ((ViewGroup)localObject).findViewById(R.h.fpV).setOnClickListener(new e.1(paramBundle));
    ((ViewGroup)localObject).findViewById(R.h.fDh).setOnClickListener(new e.2(paramBundle));
    ((ViewGroup)localObject).findViewById(R.h.fFO).setOnClickListener(new e.3(paramBundle));
    paramBundle.JLm.setOnItemClickListener(new e.4(paramBundle));
    paramBundle.JLm.setOnItemLongClickListener(new e.5(paramBundle));
    bh.bCz();
    if (((Boolean)c.ban().get(at.a.acKx, Boolean.TRUE)).booleanValue())
    {
      d.fRf().xB(true);
      bh.bCz();
      c.ban().set(at.a.acKx, Boolean.FALSE);
      if (paramBundle.JLn.getCount() <= 0) {
        break label608;
      }
      paramBundle.JLo.setVisibility(8);
    }
    for (;;)
    {
      paramBundle.fSg();
      paramBundle.fSf();
      paramBundle.JLq = true;
      bh.aZW().a(257, this);
      this.JLG.alive();
      this.JLC = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(257L, 0L, 1L, true);
      AppMethodBeat.o(25672);
      return;
      d.fRf().xB(false);
      break;
      label608:
      paramBundle.JLo.setVisibility(0);
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
    if (this.JLB != null)
    {
      Object localObject = this.JLB;
      ((e)localObject).JLm.setOnItemClickListener(null);
      ((e)localObject).JLm.setOnItemLongClickListener(null);
      localObject = ((e)localObject).JLn;
      com.tencent.mm.modelavatar.q.bFp().b((AvatarStorage.a)localObject);
    }
    bh.aZW().b(257, this);
    this.JLG.dead();
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
      if ((paramArrayOfInt[0] != 0) && (this.JLD))
      {
        this.JLD = false;
        k.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25669);
            paramAnonymousDialogInterface.dismiss();
            com.tencent.mm.pluginsdk.permission.b.lx(IPCallAddressUI.this.getContext());
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
    if (this.JLB != null)
    {
      locale = this.JLB;
      if ((locale.JLn != null) && (!locale.JLq))
      {
        locale.JLn.notifyDataSetChanged();
        if (locale.JLn.getCount() <= 0) {
          break label101;
        }
        locale.JLo.setVisibility(8);
      }
    }
    for (;;)
    {
      locale.JLq = false;
      supportInvalidateOptionsMenu();
      com.tencent.mm.plugin.ipcall.model.g.b.fRS().xL(true);
      if (!this.JLF)
      {
        this.JLF = true;
        fSh();
      }
      AppMethodBeat.o(25675);
      return;
      label101:
      locale.JLo.setVisibility(0);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(25676);
    if (((paramp instanceof g)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.JLB != null)) {
      this.JLB.fSg();
    }
    AppMethodBeat.o(25676);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressUI
 * JD-Core Version:    0.7.0.1
 */