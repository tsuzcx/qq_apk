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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.HashMap;

public class IPCallContactUI
  extends MMActivity
{
  private r fUI;
  private aq gKO;
  private String jff;
  private ListView vbM;
  private Runnable vbT;
  private ProgressDialog vcb;
  private c vcc;
  private RelativeLayout vcd;
  private LinearLayout vce;
  private IPCallAddressCountView vcf;
  private VerticalScrollBar vcg;
  private LinearLayout vch;
  private int vci;
  private int vcj;
  private a.a vck;
  private Runnable vcl;
  private boolean vcm;
  
  public IPCallContactUI()
  {
    AppMethodBeat.i(25704);
    this.fUI = new r((byte)0);
    this.vcb = null;
    this.vcf = null;
    this.vci = -1;
    this.vcj = -1;
    this.vck = new a.a()
    {
      public final void dgi()
      {
        AppMethodBeat.i(25697);
        IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(1);
        AppMethodBeat.o(25697);
      }
    };
    this.vbT = new IPCallContactUI.8(this);
    this.vcl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25700);
        if ((IPCallContactUI.d(IPCallContactUI.this) != null) && (IPCallContactUI.b(IPCallContactUI.this) != null) && (!IPCallContactUI.d(IPCallContactUI.this).odI))
        {
          IPCallContactUI.d(IPCallContactUI.this).JN(IPCallContactUI.h(IPCallContactUI.this));
          IPCallContactUI.f(IPCallContactUI.this).sendEmptyMessage(2);
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
        }
        AppMethodBeat.o(25700);
      }
    };
    this.vcm = true;
    this.gKO = new aq(Looper.getMainLooper())
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
          c.vad = com.tencent.mm.plugin.ipcall.model.h.b.dhc();
          IPCallContactUI.d(IPCallContactUI.this).ZD();
          IPCallContactUI.d(IPCallContactUI.this).notifyDataSetChanged();
          IPCallContactUI.b(IPCallContactUI.this).invalidateViews();
          IPCallContactUI.c(IPCallContactUI.this).setAddressCount(IPCallContactUI.d(IPCallContactUI.this).getCount());
          com.tencent.mm.plugin.ipcall.a.dfM().bPy();
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
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(25706);
    this.jff = paramString;
    this.gKO.removeCallbacks(this.vcl);
    this.gKO.postDelayed(this.vcl, 200L);
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
  
  public final void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(25707);
    this.vcm = paramBoolean;
    if (this.vcm) {
      this.vcc.notifyDataSetChanged();
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
    ae.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
    if (bool)
    {
      this.vcd = ((RelativeLayout)findViewById(2131301339));
      this.vce = ((LinearLayout)findViewById(2131296497));
      this.vbM = ((ListView)findViewById(2131296469));
      this.vcg = ((VerticalScrollBar)findViewById(2131296489));
      this.vch = ((LinearLayout)findViewById(2131296496));
      this.fUI.Lhk = new r.b()
      {
        public final boolean JO(String paramAnonymousString)
        {
          AppMethodBeat.i(25694);
          ae.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
          AppMethodBeat.o(25694);
          return false;
        }
        
        public final void JP(String paramAnonymousString)
        {
          AppMethodBeat.i(25693);
          ae.d("MicroMsg.IPCallContactUI", "onSearchChange");
          IPCallContactUI.this.JN(paramAnonymousString);
          if (!bu.isNullOrNil(paramAnonymousString))
          {
            IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
            IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
            IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          }
          AppMethodBeat.o(25693);
        }
        
        public final void aSL()
        {
          AppMethodBeat.i(25692);
          ae.d("MicroMsg.IPCallContactUI", "onQuitSearch");
          IPCallContactUI.this.JN("");
          IPCallContactUI.this.nQ(true);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(0);
          AppMethodBeat.o(25692);
        }
        
        public final void aSM()
        {
          AppMethodBeat.i(25691);
          ae.d("MicroMsg.IPCallContactUI", "onEnterSearch");
          g.yxI.f(12767, new Object[] { Integer.valueOf(1) });
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.this.nQ(false);
          AppMethodBeat.o(25691);
        }
        
        public final void aSN()
        {
          AppMethodBeat.i(25695);
          IPCallContactUI.a(IPCallContactUI.this).setVisibility(0);
          IPCallContactUI.b(IPCallContactUI.this).setVisibility(8);
          IPCallContactUI.c(IPCallContactUI.this).setVisibility(8);
          AppMethodBeat.o(25695);
        }
        
        public final void aSO() {}
      };
      this.fUI.Lhp = 2131755882;
      addSearchMenu(true, this.fUI);
      this.vcc = new c(getContext());
      c.vad = com.tencent.mm.plugin.ipcall.model.h.b.dhc();
      this.vcf = new IPCallAddressCountView(getContext(), this.vcc.dhk());
      this.vbM.addFooterView(this.vcf, null, false);
      this.vbM.setAdapter(this.vcc);
      this.vbM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(25696);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          if (IPCallContactUI.d(IPCallContactUI.this).Iw(paramAnonymousInt))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(25696);
            return;
          }
          paramAnonymousView = IPCallContactUI.d(IPCallContactUI.this).Jd(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            if (!IPCallContactUI.e(IPCallContactUI.this)) {
              g.yxI.f(12767, new Object[] { Integer.valueOf(2) });
            }
            paramAnonymousAdapterView = new Intent(IPCallContactUI.this.getContext(), IPCallUserProfileUI.class);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_contactid", paramAnonymousView.field_contactId);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_systemUsername", paramAnonymousView.field_systemAddressBookUsername);
            paramAnonymousAdapterView.putExtra("IPCallProfileUI_wechatUsername", paramAnonymousView.field_wechatUsername);
            paramAnonymousView = IPCallContactUI.this.getContext();
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(25696);
        }
      });
      this.vcg.setVisibility(0);
      this.vbM.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private int vi = 0;
        
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
          this.vi = paramAnonymousInt;
          IPCallContactUI.this.hideVKB();
          AppMethodBeat.o(25701);
        }
      });
      this.vcg.setOnScrollBarTouchListener(new VerticalScrollBar.a()
      {
        public final void vy(String paramAnonymousString)
        {
          AppMethodBeat.i(25703);
          if ("↑".equals(paramAnonymousString))
          {
            IPCallContactUI.b(IPCallContactUI.this).setSelection(0);
            AppMethodBeat.o(25703);
            return;
          }
          c localc = IPCallContactUI.d(IPCallContactUI.this);
          if (localc.fVB.containsKey(paramAnonymousString)) {}
          for (int i = ((Integer)localc.fVB.get(paramAnonymousString)).intValue();; i = -1)
          {
            if (i != -1) {
              IPCallContactUI.b(IPCallContactUI.this).setSelection(i);
            }
            AppMethodBeat.o(25703);
            return;
          }
        }
      });
      if (this.vcc.dhk() <= 0)
      {
        this.vcd.setVisibility(8);
        paramBundle = getContext();
        getContext().getString(2131755906);
        this.vcb = h.b(paramBundle, getContext().getString(2131760447), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(25699);
            IPCallContactUI.this.finish();
            AppMethodBeat.o(25699);
          }
        });
        com.tencent.mm.sdk.g.b.c(this.vbT, "IPCall_LoadSystemAddressBook");
        AppMethodBeat.o(25705);
        return;
      }
      com.tencent.mm.plugin.ipcall.a.dfM().bPy();
    }
    AppMethodBeat.o(25705);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(25710);
    ae.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(25710);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25708);
    super.onDestroy();
    com.tencent.mm.plugin.ipcall.model.a locala = com.tencent.mm.plugin.ipcall.model.a.dgh();
    a.a locala1 = this.vck;
    if (locala.uVR.contains(locala1)) {
      locala.uVR.remove(locala1);
    }
    this.gKO.removeMessages(1);
    AppMethodBeat.o(25708);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(25712);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(25712);
      return;
    }
    ae.i("MicroMsg.IPCallContactUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25712);
      return;
      if (paramArrayOfInt[0] != 0) {
        h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(25689);
            paramAnonymousDialogInterface.dismiss();
            IPCallContactUI.this.finish();
            paramAnonymousDialogInterface = IPCallContactUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallContactUI$11", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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