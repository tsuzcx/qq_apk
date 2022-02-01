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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import java.util.ArrayList;
import java.util.HashMap;

public class IPCallContactUI
  extends MMActivity
{
  private s gzP;
  private MMHandler hAk;
  private String kdi;
  private ProgressDialog yuB;
  private c yuC;
  private RelativeLayout yuD;
  private LinearLayout yuE;
  private IPCallAddressCountView yuF;
  private VerticalScrollBar yuG;
  private LinearLayout yuH;
  private int yuI;
  private int yuJ;
  private a.a yuK;
  private Runnable yuL;
  private boolean yuM;
  private ListView yum;
  private Runnable yut;
  
  public IPCallContactUI()
  {
    AppMethodBeat.i(25704);
    this.gzP = new s((byte)0);
    this.yuB = null;
    this.yuF = null;
    this.yuI = -1;
    this.yuJ = -1;
    this.yuK = new a.a()
    {
      public final void eac()
      {
        AppMethodBeat.i(25697);
        IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(1);
        AppMethodBeat.o(25697);
      }
    };
    this.yut = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25698);
        com.tencent.mm.plugin.ipcall.model.a.eab().a(IPCallContactUI.g(IPCallContactUI.this), false);
        AppMethodBeat.o(25698);
      }
    };
    this.yuL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25700);
        if ((IPCallContactUI.d(IPCallContactUI.this) != null) && (IPCallContactUI.b(IPCallContactUI.this) != null) && (!IPCallContactUI.d(IPCallContactUI.this).poG))
        {
          IPCallContactUI.d(IPCallContactUI.this).SM(IPCallContactUI.h(IPCallContactUI.this));
          IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(2);
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
        }
        AppMethodBeat.o(25700);
      }
    };
    this.yuM = true;
    this.hAk = new MMHandler(Looper.getMainLooper())
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
          c.ysD = com.tencent.mm.plugin.ipcall.model.h.b.eaW();
          IPCallContactUI.d(IPCallContactUI.this).anp();
          IPCallContactUI.d(IPCallContactUI.this).notifyDataSetChanged();
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
          IPCallContactUI.c(IPCallContactUI.this).setAddressCount(IPCallContactUI.d(IPCallContactUI.this).getCount());
          com.tencent.mm.plugin.ipcall.a.dZG().cmK();
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
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(25706);
    this.kdi = paramString;
    this.hAk.removeCallbacks(this.yuL);
    this.hAk.postDelayed(this.yuL, 200L);
    AppMethodBeat.o(25706);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495093;
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
    setMMTitle(2131761871);
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
    Log.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (bool)
    {
      this.yuD = ((RelativeLayout)findViewById(2131303060));
      this.yuE = ((LinearLayout)findViewById(2131296571));
      this.yum = ((ListView)findViewById(2131296542));
      this.yuG = ((VerticalScrollBar)findViewById(2131296563));
      this.yuH = ((LinearLayout)findViewById(2131296570));
      this.gzP.Qwi = new s.b()
      {
        public final boolean SN(String paramAnonymousString)
        {
          AppMethodBeat.i(25694);
          Log.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
          AppMethodBeat.o(25694);
          return false;
        }
        
        public final void SO(String paramAnonymousString)
        {
          AppMethodBeat.i(25693);
          Log.d("MicroMsg.IPCallContactUI", "onSearchChange");
          IPCallContactUI.this.SM(paramAnonymousString);
          if (!Util.isNullOrNil(paramAnonymousString))
          {
            IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
            IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
            IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          }
          AppMethodBeat.o(25693);
        }
        
        public final void bnA()
        {
          AppMethodBeat.i(25695);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          AppMethodBeat.o(25695);
        }
        
        public final void bnB() {}
        
        public final void bny()
        {
          AppMethodBeat.i(25692);
          Log.d("MicroMsg.IPCallContactUI", "onQuitSearch");
          IPCallContactUI.this.SM("");
          IPCallContactUI.this.qz(true);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(0);
          AppMethodBeat.o(25692);
        }
        
        public final void bnz()
        {
          AppMethodBeat.i(25691);
          Log.d("MicroMsg.IPCallContactUI", "onEnterSearch");
          com.tencent.mm.plugin.report.service.h.CyF.a(12767, new Object[] { Integer.valueOf(1) });
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.this.qz(false);
          AppMethodBeat.o(25691);
        }
      };
      this.gzP.Qwn = 2131755972;
      addSearchMenu(true, this.gzP);
      this.yuC = new c(getContext());
      c.ysD = com.tencent.mm.plugin.ipcall.model.h.b.eaW();
      this.yuF = new IPCallAddressCountView(getContext(), this.yuC.ebe());
      this.yum.addFooterView(this.yuF, null, false);
      this.yum.setAdapter(this.yuC);
      this.yum.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(25696);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (IPCallContactUI.d(IPCallContactUI.this).Ox(paramAnonymousInt))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(25696);
            return;
          }
          paramAnonymousView = IPCallContactUI.d(IPCallContactUI.this).Pg(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (!IPCallContactUI.e(IPCallContactUI.this)) {
              com.tencent.mm.plugin.report.service.h.CyF.a(12767, new Object[] { Integer.valueOf(2) });
            }
            paramAnonymousAdapterView = new Intent(IPCallContactUI.this.getContext(), IPCallUserProfileUI.class);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_contactid", paramAnonymousView.field_contactId);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_systemUsername", paramAnonymousView.field_systemAddressBookUsername);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_wechatUsername", paramAnonymousView.field_wechatUsername);
            paramAnonymousView = IPCallContactUI.this.getContext();
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(25696);
        }
      });
      this.yuG.setVisibility(0);
      this.yum.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private int vp = 0;
        
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
          this.vp = paramAnonymousInt;
          IPCallContactUI.this.hideVKB();
          AppMethodBeat.o(25701);
        }
      });
      this.yuG.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void DP(String paramAnonymousString)
        {
          AppMethodBeat.i(25703);
          if ("↑".equals(paramAnonymousString))
          {
            IPCallContactUI.b(IPCallContactUI.this).setSelection(0);
            AppMethodBeat.o(25703);
            return;
          }
          c localc = IPCallContactUI.d(IPCallContactUI.this);
          if (localc.gAI.containsKey(paramAnonymousString)) {}
          for (int i = ((Integer)localc.gAI.get(paramAnonymousString)).intValue();; i = -1)
          {
            if (i != -1) {
              IPCallContactUI.b(IPCallContactUI.this).setSelection(i);
            }
            AppMethodBeat.o(25703);
            return;
          }
        }
      });
      if (this.yuC.ebe() <= 0)
      {
        this.yuD.setVisibility(8);
        paramBundle = getContext();
        getContext().getString(2131755998);
        this.yuB = com.tencent.mm.ui.base.h.a(paramBundle, getContext().getString(2131761892), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(25699);
            IPCallContactUI.this.finish();
            AppMethodBeat.o(25699);
          }
        });
        ThreadPool.post(this.yut, "IPCall_LoadSystemAddressBook");
        AppMethodBeat.o(25705);
        return;
      }
      com.tencent.mm.plugin.ipcall.a.dZG().cmK();
    }
    AppMethodBeat.o(25705);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25710);
    Log.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25710);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25708);
    super.onDestroy();
    com.tencent.mm.plugin.ipcall.model.a locala = com.tencent.mm.plugin.ipcall.model.a.eab();
    a.a locala1 = this.yuK;
    if (locala.yos.contains(locala1)) {
      locala.yos.remove(locala1);
    }
    this.hAk.removeMessages(1);
    AppMethodBeat.o(25708);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25712);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25712);
      return;
    }
    Log.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25712);
      return;
      if (paramArrayOfInt[0] != 0) {
        com.tencent.mm.ui.base.h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25689);
            paramAnonymousDialogInterface.dismiss();
            IPCallContactUI.this.finish();
            paramAnonymousDialogInterface = IPCallContactUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
  
  public final void qz(boolean paramBoolean)
  {
    AppMethodBeat.i(25707);
    this.yuM = paramBoolean;
    if (this.yuM) {
      this.yuC.notifyDataSetChanged();
    }
    AppMethodBeat.o(25707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI
 * JD-Core Version:    0.7.0.1
 */