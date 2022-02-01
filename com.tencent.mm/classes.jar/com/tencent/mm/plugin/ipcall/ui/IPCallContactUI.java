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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  private r fzp;
  private ao gox;
  private String iJd;
  private ProgressDialog tNC;
  private c tND;
  private RelativeLayout tNE;
  private LinearLayout tNF;
  private IPCallAddressCountView tNG;
  private VerticalScrollBar tNH;
  private LinearLayout tNI;
  private int tNJ;
  private int tNK;
  private a.a tNL;
  private Runnable tNM;
  private boolean tNN;
  private ListView tNn;
  private Runnable tNu;
  
  public IPCallContactUI()
  {
    AppMethodBeat.i(25704);
    this.fzp = new r((byte)0);
    this.tNC = null;
    this.tNG = null;
    this.tNJ = -1;
    this.tNK = -1;
    this.tNL = new a.a()
    {
      public final void cUf()
      {
        AppMethodBeat.i(25697);
        IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(1);
        AppMethodBeat.o(25697);
      }
    };
    this.tNu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25698);
        com.tencent.mm.plugin.ipcall.model.a.cUe().a(IPCallContactUI.g(IPCallContactUI.this), false);
        AppMethodBeat.o(25698);
      }
    };
    this.tNM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25700);
        if ((IPCallContactUI.d(IPCallContactUI.this) != null) && (IPCallContactUI.b(IPCallContactUI.this) != null) && (!IPCallContactUI.d(IPCallContactUI.this).nwB))
        {
          IPCallContactUI.d(IPCallContactUI.this).FZ(IPCallContactUI.h(IPCallContactUI.this));
          IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(2);
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
        }
        AppMethodBeat.o(25700);
      }
    };
    this.tNN = true;
    this.gox = new ao(Looper.getMainLooper())
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
          c.tLD = com.tencent.mm.plugin.ipcall.model.h.b.cUZ();
          IPCallContactUI.d(IPCallContactUI.this).Xb();
          IPCallContactUI.d(IPCallContactUI.this).notifyDataSetChanged();
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
          IPCallContactUI.c(IPCallContactUI.this).setAddressCount(IPCallContactUI.d(IPCallContactUI.this).getCount());
          com.tencent.mm.plugin.ipcall.a.cTI().cTJ();
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
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(25706);
    this.iJd = paramString;
    this.gox.removeCallbacks(this.tNM);
    this.gox.postDelayed(this.tNM, 200L);
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
  
  public final void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(25707);
    this.tNN = paramBoolean;
    if (this.tNN) {
      this.tND.notifyDataSetChanged();
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
    ac.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi() });
    if (bool)
    {
      this.tNE = ((RelativeLayout)findViewById(2131301339));
      this.tNF = ((LinearLayout)findViewById(2131296497));
      this.tNn = ((ListView)findViewById(2131296469));
      this.tNH = ((VerticalScrollBar)findViewById(2131296489));
      this.tNI = ((LinearLayout)findViewById(2131296496));
      this.fzp.ITM = new r.b()
      {
        public final boolean Ga(String paramAnonymousString)
        {
          AppMethodBeat.i(25694);
          ac.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
          AppMethodBeat.o(25694);
          return false;
        }
        
        public final void Gb(String paramAnonymousString)
        {
          AppMethodBeat.i(25693);
          ac.d("MicroMsg.IPCallContactUI", "onSearchChange");
          IPCallContactUI.this.FZ(paramAnonymousString);
          if (!bs.isNullOrNil(paramAnonymousString))
          {
            IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
            IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
            IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          }
          AppMethodBeat.o(25693);
        }
        
        public final void aPa()
        {
          AppMethodBeat.i(25692);
          ac.d("MicroMsg.IPCallContactUI", "onQuitSearch");
          IPCallContactUI.this.FZ("");
          IPCallContactUI.this.ns(true);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(0);
          AppMethodBeat.o(25692);
        }
        
        public final void aPb()
        {
          AppMethodBeat.i(25691);
          ac.d("MicroMsg.IPCallContactUI", "onEnterSearch");
          com.tencent.mm.plugin.report.service.h.wUl.f(12767, new Object[] { Integer.valueOf(1) });
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.this.ns(false);
          AppMethodBeat.o(25691);
        }
        
        public final void aPc()
        {
          AppMethodBeat.i(25695);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          AppMethodBeat.o(25695);
        }
        
        public final void aPd() {}
      };
      this.fzp.ITR = 2131755882;
      addSearchMenu(true, this.fzp);
      this.tND = new c(getContext());
      c.tLD = com.tencent.mm.plugin.ipcall.model.h.b.cUZ();
      this.tNG = new IPCallAddressCountView(getContext(), this.tND.cVh());
      this.tNn.addFooterView(this.tNG, null, false);
      this.tNn.setAdapter(this.tND);
      this.tNn.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(25696);
          if (IPCallContactUI.d(IPCallContactUI.this).GF(paramAnonymousInt))
          {
            AppMethodBeat.o(25696);
            return;
          }
          paramAnonymousView = IPCallContactUI.d(IPCallContactUI.this).Hj(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (!IPCallContactUI.e(IPCallContactUI.this)) {
              com.tencent.mm.plugin.report.service.h.wUl.f(12767, new Object[] { Integer.valueOf(2) });
            }
            paramAnonymousAdapterView = new Intent(IPCallContactUI.this.getContext(), IPCallUserProfileUI.class);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_contactid", paramAnonymousView.field_contactId);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_systemUsername", paramAnonymousView.field_systemAddressBookUsername);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_wechatUsername", paramAnonymousView.field_wechatUsername);
            paramAnonymousView = IPCallContactUI.this.getContext();
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          AppMethodBeat.o(25696);
        }
      });
      this.tNH.setVisibility(0);
      this.tNn.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private int tp = 0;
        
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
          this.tp = paramAnonymousInt;
          IPCallContactUI.this.hideVKB();
          AppMethodBeat.o(25701);
        }
      });
      this.tNH.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void sn(String paramAnonymousString)
        {
          AppMethodBeat.i(25703);
          if ("↑".equals(paramAnonymousString))
          {
            IPCallContactUI.b(IPCallContactUI.this).setSelection(0);
            AppMethodBeat.o(25703);
            return;
          }
          c localc = IPCallContactUI.d(IPCallContactUI.this);
          if (localc.fAf.containsKey(paramAnonymousString)) {}
          for (int i = ((Integer)localc.fAf.get(paramAnonymousString)).intValue();; i = -1)
          {
            if (i != -1) {
              IPCallContactUI.b(IPCallContactUI.this).setSelection(i);
            }
            AppMethodBeat.o(25703);
            return;
          }
        }
      });
      if (this.tND.cVh() <= 0)
      {
        this.tNE.setVisibility(8);
        paramBundle = getContext();
        getContext().getString(2131755906);
        this.tNC = com.tencent.mm.ui.base.h.b(paramBundle, getContext().getString(2131760447), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(25699);
            IPCallContactUI.this.finish();
            AppMethodBeat.o(25699);
          }
        });
        com.tencent.mm.sdk.g.b.c(this.tNu, "IPCall_LoadSystemAddressBook");
        AppMethodBeat.o(25705);
        return;
      }
      com.tencent.mm.plugin.ipcall.a.cTI().cTJ();
    }
    AppMethodBeat.o(25705);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25710);
    ac.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25710);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25708);
    super.onDestroy();
    com.tencent.mm.plugin.ipcall.model.a locala = com.tencent.mm.plugin.ipcall.model.a.cUe();
    a.a locala1 = this.tNL;
    if (locala.tHr.contains(locala1)) {
      locala.tHr.remove(locala1);
    }
    this.gox.removeMessages(1);
    AppMethodBeat.o(25708);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25712);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25712);
      return;
    }
    ac.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI
 * JD-Core Version:    0.7.0.1
 */