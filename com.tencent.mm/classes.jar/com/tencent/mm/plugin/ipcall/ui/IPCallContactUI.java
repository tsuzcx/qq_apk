package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.model.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import java.util.ArrayList;
import java.util.HashMap;

public class IPCallContactUI
  extends MMActivity
{
  private ListView JLA;
  private Runnable JLH;
  private c JLP;
  private RelativeLayout JLQ;
  private LinearLayout JLR;
  private IPCallAddressCountView JLS;
  private VerticalScrollBar JLT;
  private LinearLayout JLU;
  private int JLV;
  private int JLW;
  private a.a JLX;
  private Runnable JLY;
  private boolean JLZ;
  private s lMw;
  private MMHandler mRi;
  private String pRp;
  private ProgressDialog xZJ;
  
  public IPCallContactUI()
  {
    AppMethodBeat.i(25704);
    this.lMw = new s(true);
    this.xZJ = null;
    this.JLS = null;
    this.JLV = -1;
    this.JLW = -1;
    this.JLX = new a.a()
    {
      public final void dVo()
      {
        AppMethodBeat.i(25697);
        IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(1);
        AppMethodBeat.o(25697);
      }
    };
    this.JLH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25698);
        com.tencent.mm.plugin.ipcall.model.a.fRa().a(IPCallContactUI.g(IPCallContactUI.this), false);
        AppMethodBeat.o(25698);
      }
    };
    this.JLY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25700);
        if ((IPCallContactUI.d(IPCallContactUI.this) != null) && (IPCallContactUI.b(IPCallContactUI.this) != null) && (!IPCallContactUI.d(IPCallContactUI.this).vDm))
        {
          IPCallContactUI.d(IPCallContactUI.this).SM(IPCallContactUI.h(IPCallContactUI.this));
          IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(2);
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
        }
        AppMethodBeat.o(25700);
      }
    };
    this.JLZ = true;
    this.mRi = new MMHandler(Looper.getMainLooper())
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
          c.JJR = com.tencent.mm.plugin.ipcall.model.h.b.fRU();
          IPCallContactUI.d(IPCallContactUI.this).aNy();
          IPCallContactUI.d(IPCallContactUI.this).notifyDataSetChanged();
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
          IPCallContactUI.c(IPCallContactUI.this).setAddressCount(IPCallContactUI.d(IPCallContactUI.this).getCount());
          com.tencent.mm.plugin.ipcall.a.fQE().ddr();
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
    this.pRp = paramString;
    this.mRi.removeCallbacks(this.JLY);
    this.mRi.postDelayed(this.JLY, 200L);
    AppMethodBeat.o(25706);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gkH;
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
    setMMTitle(R.l.gKd);
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
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null);
    Log.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
    if (bool)
    {
      this.JLQ = ((RelativeLayout)findViewById(R.h.layout));
      this.JLR = ((LinearLayout)findViewById(R.h.fqQ));
      this.JLA = ((ListView)findViewById(R.h.fqB));
      this.JLT = ((VerticalScrollBar)findViewById(R.h.fqN));
      this.JLU = ((LinearLayout)findViewById(R.h.fqP));
      this.lMw.afKz = new s.c()
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
        
        public final void bWw()
        {
          AppMethodBeat.i(25692);
          Log.d("MicroMsg.IPCallContactUI", "onQuitSearch");
          IPCallContactUI.this.SM("");
          IPCallContactUI.this.xM(true);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(0);
          AppMethodBeat.o(25692);
        }
        
        public final void bWx()
        {
          AppMethodBeat.i(25691);
          Log.d("MicroMsg.IPCallContactUI", "onEnterSearch");
          h.OAn.b(12767, new Object[] { Integer.valueOf(1) });
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.this.xM(false);
          AppMethodBeat.o(25691);
        }
        
        public final void bWy()
        {
          AppMethodBeat.i(25695);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          AppMethodBeat.o(25695);
        }
        
        public final void bWz() {}
      };
      this.lMw.afKE = R.l.app_search;
      addSearchMenu(true, this.lMw);
      this.JLP = new c(getContext());
      c.JJR = com.tencent.mm.plugin.ipcall.model.h.b.fRU();
      this.JLS = new IPCallAddressCountView(getContext(), this.JLP.fSc());
      this.JLA.addFooterView(this.JLS, null, false);
      this.JLA.setAdapter(this.JLP);
      this.JLA.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(25696);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          if (IPCallContactUI.d(IPCallContactUI.this).XL(paramAnonymousInt))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(25696);
            return;
          }
          paramAnonymousView = IPCallContactUI.d(IPCallContactUI.this).Zk(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (!IPCallContactUI.e(IPCallContactUI.this)) {
              h.OAn.b(12767, new Object[] { Integer.valueOf(2) });
            }
            paramAnonymousAdapterView = new Intent(IPCallContactUI.this.getContext(), IPCallUserProfileUI.class);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_contactid", paramAnonymousView.field_contactId);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_systemUsername", paramAnonymousView.field_systemAddressBookUsername);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_wechatUsername", paramAnonymousView.field_wechatUsername);
            paramAnonymousView = IPCallContactUI.this.getContext();
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(25696);
        }
      });
      this.JLT.setVisibility(0);
      this.JLA.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private int dyP = 0;
        
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
          this.dyP = paramAnonymousInt;
          IPCallContactUI.this.hideVKB();
          AppMethodBeat.o(25701);
        }
      });
      this.JLT.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void onScollBarTouch(String paramAnonymousString)
        {
          AppMethodBeat.i(25703);
          if ("↑".equals(paramAnonymousString))
          {
            IPCallContactUI.b(IPCallContactUI.this).setSelection(0);
            AppMethodBeat.o(25703);
            return;
          }
          c localc = IPCallContactUI.d(IPCallContactUI.this);
          if (localc.lNs.containsKey(paramAnonymousString)) {}
          for (int i = ((Integer)localc.lNs.get(paramAnonymousString)).intValue();; i = -1)
          {
            if (i != -1) {
              IPCallContactUI.b(IPCallContactUI.this).setSelection(i);
            }
            AppMethodBeat.o(25703);
            return;
          }
        }
      });
      if (this.JLP.fSc() <= 0)
      {
        this.JLQ.setVisibility(8);
        paramBundle = getContext();
        getContext().getString(R.l.app_tip);
        this.xZJ = k.a(paramBundle, getContext().getString(R.l.gKr), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(25699);
            IPCallContactUI.this.finish();
            AppMethodBeat.o(25699);
          }
        });
        ThreadPool.post(this.JLH, "IPCall_LoadSystemAddressBook");
        AppMethodBeat.o(25705);
        return;
      }
      com.tencent.mm.plugin.ipcall.a.fQE().ddr();
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
    com.tencent.mm.plugin.ipcall.model.a locala = com.tencent.mm.plugin.ipcall.model.a.fRa();
    a.a locala1 = this.JLX;
    if (locala.JFJ.contains(locala1)) {
      locala.JFJ.remove(locala1);
    }
    this.mRi.removeMessages(1);
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
        k.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25689);
            paramAnonymousDialogInterface.dismiss();
            IPCallContactUI.this.finish();
            com.tencent.mm.pluginsdk.permission.b.lx(IPCallContactUI.this.getContext());
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
  
  public final void xM(boolean paramBoolean)
  {
    AppMethodBeat.i(25707);
    this.JLZ = paramBoolean;
    if (this.JLZ) {
      this.JLP.notifyDataSetChanged();
    }
    AppMethodBeat.o(25707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI
 * JD-Core Version:    0.7.0.1
 */