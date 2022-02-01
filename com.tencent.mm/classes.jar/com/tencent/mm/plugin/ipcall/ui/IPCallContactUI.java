package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.HashMap;

public class IPCallContactUI
  extends MMActivity
{
  private r fvI;
  private ap gAC;
  private String iiW;
  private ListView sFG;
  private Runnable sFN;
  private ProgressDialog sFV;
  private c sFW;
  private RelativeLayout sFX;
  private LinearLayout sFY;
  private IPCallAddressCountView sFZ;
  private VerticalScrollBar sGa;
  private LinearLayout sGb;
  private int sGc;
  private int sGd;
  private a.a sGe;
  private Runnable sGf;
  private boolean sGg;
  
  public IPCallContactUI()
  {
    AppMethodBeat.i(25704);
    this.fvI = new r((byte)0);
    this.sFV = null;
    this.sFZ = null;
    this.sGc = -1;
    this.sGd = -1;
    this.sGe = new a.a()
    {
      public final void cGU()
      {
        AppMethodBeat.i(25697);
        IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(1);
        AppMethodBeat.o(25697);
      }
    };
    this.sFN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25698);
        com.tencent.mm.plugin.ipcall.model.a.cGT().a(IPCallContactUI.g(IPCallContactUI.this), false);
        AppMethodBeat.o(25698);
      }
    };
    this.sGf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25700);
        if ((IPCallContactUI.d(IPCallContactUI.this) != null) && (IPCallContactUI.b(IPCallContactUI.this) != null) && (!IPCallContactUI.d(IPCallContactUI.this).mUj))
        {
          IPCallContactUI.d(IPCallContactUI.this).BW(IPCallContactUI.h(IPCallContactUI.this));
          IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(2);
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
        }
        AppMethodBeat.o(25700);
      }
    };
    this.sGg = true;
    this.gAC = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(25688);
        if (paramAnonymousMessage.what == 1)
        {
          if (IPCallContactUI.k(IPCallContactUI.this) != null) {
            IPCallContactUI.k(IPCallContactUI.this).dismiss();
          }
          IPCallContactUI.l(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.d(IPCallContactUI.this);
          c.sDW = com.tencent.mm.plugin.ipcall.model.h.b.cHO();
          IPCallContactUI.d(IPCallContactUI.this).Wd();
          IPCallContactUI.d(IPCallContactUI.this).notifyDataSetChanged();
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
          IPCallContactUI.c(IPCallContactUI.this).setAddressCount(IPCallContactUI.d(IPCallContactUI.this).getCount());
          com.tencent.mm.plugin.ipcall.a.cGy().cGz();
          AppMethodBeat.o(25688);
          return;
        }
        if (paramAnonymousMessage.what == 2)
        {
          if (IPCallContactUI.d(IPCallContactUI.this).getCount() != 0) {
            break label194;
          }
          IPCallContactUI.m(IPCallContactUI.this).setVisibility(0);
        }
        for (;;)
        {
          if ((IPCallContactUI.d(IPCallContactUI.this).getCount() != 0) && (IPCallContactUI.e(IPCallContactUI.this))) {
            IPCallContactUI.d(IPCallContactUI.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(25688);
          return;
          label194:
          IPCallContactUI.m(IPCallContactUI.this).setVisibility(8);
        }
      }
    };
    AppMethodBeat.o(25704);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(25706);
    this.iiW = paramString;
    this.gAC.removeCallbacks(this.sGf);
    this.gAC.postDelayed(this.sGf, 200L);
    AppMethodBeat.o(25706);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494501;
  }
  
  public final void mz(boolean paramBoolean)
  {
    AppMethodBeat.i(25707);
    this.sGg = paramBoolean;
    if (this.sGg) {
      this.sFW.notifyDataSetChanged();
    }
    AppMethodBeat.o(25707);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(25711);
    super.onBackPressed();
    AppMethodBeat.o(25711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25705);
    super.onCreate(paramBundle);
    setMMTitle(2131760426);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25687);
        IPCallContactUI.this.finish();
        AppMethodBeat.o(25687);
        return true;
      }
    });
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    ad.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN() });
    if (bool)
    {
      this.sFX = ((RelativeLayout)findViewById(2131301339));
      this.sFY = ((LinearLayout)findViewById(2131296497));
      this.sFG = ((ListView)findViewById(2131296469));
      this.sGa = ((VerticalScrollBar)findViewById(2131296489));
      this.sGb = ((LinearLayout)findViewById(2131296496));
      this.fvI.Htp = new r.b()
      {
        public final boolean BX(String paramAnonymousString)
        {
          AppMethodBeat.i(25694);
          ad.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
          AppMethodBeat.o(25694);
          return false;
        }
        
        public final void BY(String paramAnonymousString)
        {
          AppMethodBeat.i(25693);
          ad.d("MicroMsg.IPCallContactUI", "onSearchChange");
          IPCallContactUI.this.BW(paramAnonymousString);
          if (!bt.isNullOrNil(paramAnonymousString))
          {
            IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
            IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
            IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          }
          AppMethodBeat.o(25693);
        }
        
        public final void aIj()
        {
          AppMethodBeat.i(25692);
          ad.d("MicroMsg.IPCallContactUI", "onQuitSearch");
          IPCallContactUI.this.BW("");
          IPCallContactUI.this.mz(true);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(0);
          AppMethodBeat.o(25692);
        }
        
        public final void aIk()
        {
          AppMethodBeat.i(25691);
          ad.d("MicroMsg.IPCallContactUI", "onEnterSearch");
          com.tencent.mm.plugin.report.service.h.vKh.f(12767, new Object[] { Integer.valueOf(1) });
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.this.mz(false);
          AppMethodBeat.o(25691);
        }
        
        public final void aIl()
        {
          AppMethodBeat.i(25695);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          AppMethodBeat.o(25695);
        }
        
        public final void aIm() {}
      };
      this.fvI.Htu = 2131755882;
      addSearchMenu(true, this.fvI);
      this.sFW = new c(getContext());
      c.sDW = com.tencent.mm.plugin.ipcall.model.h.b.cHO();
      this.sFZ = new IPCallAddressCountView(getContext(), this.sFW.cHW());
      this.sFG.addFooterView(this.sFZ, null, false);
      this.sFG.setAdapter(this.sFW);
      this.sFG.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(25696);
          if (IPCallContactUI.d(IPCallContactUI.this).EJ(paramAnonymousInt))
          {
            AppMethodBeat.o(25696);
            return;
          }
          paramAnonymousView = IPCallContactUI.d(IPCallContactUI.this).Fo(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (!IPCallContactUI.e(IPCallContactUI.this)) {
              com.tencent.mm.plugin.report.service.h.vKh.f(12767, new Object[] { Integer.valueOf(2) });
            }
            paramAnonymousAdapterView = new Intent(IPCallContactUI.this.getContext(), IPCallUserProfileUI.class);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_contactid", paramAnonymousView.field_contactId);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_systemUsername", paramAnonymousView.field_systemAddressBookUsername);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_wechatUsername", paramAnonymousView.field_wechatUsername);
            paramAnonymousView = IPCallContactUI.this.getContext();
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(25696);
        }
      });
      this.sGa.setVisibility(0);
      this.sFG.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private int sq = 0;
        
        @TargetApi(11)
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(25702);
          if (IPCallContactUI.i(IPCallContactUI.this) == -1)
          {
            IPCallContactUI.a(IPCallContactUI.this, paramAnonymousInt1);
            AppMethodBeat.o(25702);
            return;
          }
          if (IPCallContactUI.j(IPCallContactUI.this) == -1) {
            IPCallContactUI.b(IPCallContactUI.this, paramAnonymousInt1);
          }
          AppMethodBeat.o(25702);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(25701);
          this.sq = paramAnonymousInt;
          IPCallContactUI.this.hideVKB();
          AppMethodBeat.o(25701);
        }
      });
      this.sGa.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void pb(String paramAnonymousString)
        {
          AppMethodBeat.i(25703);
          if ("↑".equals(paramAnonymousString))
          {
            IPCallContactUI.b(IPCallContactUI.this).setSelection(0);
            AppMethodBeat.o(25703);
            return;
          }
          c localc = IPCallContactUI.d(IPCallContactUI.this);
          if (localc.fwy.containsKey(paramAnonymousString)) {}
          for (int i = ((Integer)localc.fwy.get(paramAnonymousString)).intValue();; i = -1)
          {
            if (i != -1) {
              IPCallContactUI.b(IPCallContactUI.this).setSelection(i);
            }
            AppMethodBeat.o(25703);
            return;
          }
        }
      });
      if (this.sFW.cHW() <= 0)
      {
        this.sFX.setVisibility(8);
        paramBundle = getContext();
        getContext().getString(2131755906);
        this.sFV = com.tencent.mm.ui.base.h.b(paramBundle, getContext().getString(2131760447), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(25699);
            IPCallContactUI.this.finish();
            AppMethodBeat.o(25699);
          }
        });
        com.tencent.mm.sdk.g.b.c(this.sFN, "IPCall_LoadSystemAddressBook");
        AppMethodBeat.o(25705);
        return;
      }
      com.tencent.mm.plugin.ipcall.a.cGy().cGz();
    }
    AppMethodBeat.o(25705);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25710);
    ad.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25710);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25708);
    super.onDestroy();
    com.tencent.mm.plugin.ipcall.model.a locala = com.tencent.mm.plugin.ipcall.model.a.cGT();
    a.a locala1 = this.sGe;
    if (locala.szH.contains(locala1)) {
      locala.szH.remove(locala1);
    }
    this.gAC.removeMessages(1);
    AppMethodBeat.o(25708);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25712);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25712);
      return;
    }
    ad.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25712);
      return;
      if (paramArrayOfInt[0] != 0) {
        com.tencent.mm.ui.base.h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25689);
            paramAnonymousDialogInterface.dismiss();
            IPCallContactUI.this.finish();
            paramAnonymousDialogInterface = IPCallContactUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(25689);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25690);
            paramAnonymousDialogInterface.dismiss();
            IPCallContactUI.this.finish();
            AppMethodBeat.o(25690);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25709);
    super.onResume();
    supportInvalidateOptionsMenu();
    AppMethodBeat.o(25709);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI
 * JD-Core Version:    0.7.0.1
 */