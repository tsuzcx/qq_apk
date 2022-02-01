package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI
  extends MMActivity
  implements i
{
  private ListView kJh;
  private Object lockObj;
  private com.tencent.mm.plugin.o.a.b nlU;
  private a nlV;
  private com.tencent.mm.plugin.address.b.b.a nlW;
  private TextView nlX;
  private LinkedList<com.tencent.mm.plugin.o.a.b> nlY;
  private boolean nlZ;
  private TextView nli;
  private boolean nlt;
  private boolean nma;
  
  public InvoiceListUI()
  {
    AppMethodBeat.i(20912);
    this.nlW = null;
    this.lockObj = new Object();
    this.nlX = null;
    this.nli = null;
    this.nlY = new LinkedList();
    this.nlt = false;
    this.nlZ = false;
    this.nma = false;
    AppMethodBeat.o(20912);
  }
  
  private void bAB()
  {
    AppMethodBeat.i(20916);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.bAn();
      this.nlY = com.tencent.mm.plugin.address.a.a.bAo().nkw.DNQ;
      this.nlV.lxh = this.nlY;
      this.nlY.size();
      this.nlV.notifyDataSetChanged();
      AppMethodBeat.o(20916);
      return;
    }
  }
  
  private void yu(int paramInt)
  {
    AppMethodBeat.i(20919);
    Object localObject = new Intent();
    if (paramInt != 0)
    {
      ((Intent)localObject).setClass(this, QrcodeInvoiceUI.class);
      ((Intent)localObject).putExtra("invoice_id", paramInt);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20919);
      return;
      ((Intent)localObject).setClass(this, AddInvoiceUI.class);
      ((Intent)localObject).putExtra("launch_from_invoicelist_webview", this.nlt);
      ((Intent)localObject).putExtra("invoice_id", paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return R.i.ehG;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20917);
    this.nlX = ((TextView)findViewById(R.h.dJe));
    if (this.nlX != null) {
      this.nlX.setVisibility(8);
    }
    if (this.nlt)
    {
      this.nli = ((TextView)findViewById(R.h.dKt));
      if (this.nli != null) {
        this.nli.setVisibility(0);
      }
    }
    for (;;)
    {
      this.nlX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(20900);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          InvoiceListUI.a(InvoiceListUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(20900);
        }
      });
      this.kJh = ((ListView)findViewById(R.h.dTR));
      this.nlV = new a(this);
      this.kJh.setAdapter(this.nlV);
      this.kJh.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20901);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(???);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          Log.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
          synchronized (InvoiceListUI.b(InvoiceListUI.this))
          {
            if (paramAnonymousInt < InvoiceListUI.c(InvoiceListUI.this).size())
            {
              InvoiceListUI.a(InvoiceListUI.this, (com.tencent.mm.plugin.o.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt));
              if ((InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null)) {
                break label185;
              }
              InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.e(InvoiceListUI.this).DNR);
            }
            label185:
            while ((InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).DNR == 0))
            {
              InvoiceListUI.f(InvoiceListUI.this).notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(20901);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("choose_invoice_title_info", e.a(InvoiceListUI.e(InvoiceListUI.this)));
            InvoiceListUI.this.setResult(-1, paramAnonymousView);
            InvoiceListUI.this.finish();
          }
        }
      });
      this.kJh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20903);
          paramAnonymousAdapterView = InvoiceListUI.this.getResources().getStringArray(R.c.djQ);
          h.a(InvoiceListUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.d()
          {
            public final void qy(int paramAnonymous2Int)
            {
              AppMethodBeat.i(20902);
              for (;;)
              {
                synchronized (InvoiceListUI.b(InvoiceListUI.this))
                {
                  if (paramAnonymousInt >= InvoiceListUI.c(InvoiceListUI.this).size()) {
                    break label194;
                  }
                  com.tencent.mm.plugin.o.a.b localb = (com.tencent.mm.plugin.o.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt);
                  if (localb == null)
                  {
                    AppMethodBeat.o(20902);
                    return;
                  }
                }
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(20902);
                  return;
                  InvoiceListUI.a(InvoiceListUI.this, localObject1.DNR);
                  AppMethodBeat.o(20902);
                  return;
                  locala = new com.tencent.mm.plugin.address.model.a(localObject1.DNR);
                  InvoiceListUI.a(InvoiceListUI.this, null);
                  bh.aGY().a(locala, 0);
                  AppMethodBeat.o(20902);
                  return;
                  InvoiceListUI.b(InvoiceListUI.this, locala);
                }
                label194:
                com.tencent.mm.plugin.address.model.a locala = null;
              }
            }
          });
          AppMethodBeat.o(20903);
          return true;
        }
      });
      this.nlV.notifyDataSetChanged();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20904);
          InvoiceListUI.this.setResult(0);
          InvoiceListUI.this.finish();
          AppMethodBeat.o(20904);
          return true;
        }
      });
      addIconOptionMenu(0, R.l.settings_add_invoice, R.k.actionbar_icon_dark_add, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20905);
          InvoiceListUI.a(InvoiceListUI.this);
          AppMethodBeat.o(20905);
          return true;
        }
      });
      AppMethodBeat.o(20917);
      return;
      this.nli = ((TextView)findViewById(R.h.dKt));
      if (this.nli != null) {
        this.nli.setVisibility(8);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20920);
    Object localObject;
    if (paramInt1 == 1)
    {
      if (-1 != paramInt2) {
        break label209;
      }
      if (paramIntent != null) {
        break label71;
      }
      Log.e("MicroMsg.InvoiceUtil", "intent is null");
      paramIntent = null;
      localObject = new Intent();
      ((Intent)localObject).putExtra("choose_invoice_title_info", e.a(paramIntent));
      setResult(-1, (Intent)localObject);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(20920);
      return;
      label71:
      localObject = new com.tencent.mm.plugin.o.a.b();
      ((com.tencent.mm.plugin.o.a.b)localObject).type = paramIntent.getStringExtra("type");
      if ((((com.tencent.mm.plugin.o.a.b)localObject).type != null) && (((com.tencent.mm.plugin.o.a.b)localObject).type.equals("1")))
      {
        ((com.tencent.mm.plugin.o.a.b)localObject).DNS = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.o.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.o.a.b)localObject).DNT = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.o.a.b)localObject).DNZ = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.o.a.b)localObject).DNX = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.o.a.b)localObject).DNV = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.o.a.b)localObject).DNU = paramIntent.getStringExtra("bank_account");
      paramIntent = (Intent)localObject;
      break;
      label209:
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20913);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.nlt = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.nlZ = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.nlt) || (this.nlZ)) {
      this.nlt = true;
    }
    if (this.nlt)
    {
      bh.beI();
      boolean bool = ((Boolean)c.aHp().get(ar.a.VmC, Boolean.TRUE)).booleanValue();
      Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(bool)));
      if (bool)
      {
        Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        h.a(this, getString(R.l.eIq), getString(R.l.eIr), getString(R.l.emp), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20906);
            Log.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(20906);
          }
        });
        bh.beI();
        c.aHp().set(ar.a.VmC, Boolean.FALSE);
      }
    }
    setMMTitle(R.l.settings_my_invoice_information);
    bh.aGY().a(1194, this);
    bh.aGY().a(1191, this);
    initView();
    bAB();
    AppMethodBeat.o(20913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20914);
    bh.aGY().b(1194, this);
    bh.aGY().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(20914);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20915);
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    bh.aGY().a(localb, 0);
    super.onResume();
    AppMethodBeat.o(20915);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(20918);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.getType() == 1191)
      {
        bAB();
        if (this.nlt)
        {
          com.tencent.mm.plugin.address.a.a.bAn();
          if ((com.tencent.mm.plugin.address.a.a.bAo().nkw.DNQ.size() == 0) && (!this.nma))
          {
            paramString = new Intent();
            paramString.setClass(this, AddInvoiceUI.class);
            paramString.putExtra("launch_from_webview", true);
            startActivityForResult(paramString, 1);
            AppMethodBeat.o(20918);
          }
        }
      }
      else if (paramq.getType() == 1194)
      {
        paramString = new com.tencent.mm.plugin.address.model.b();
        bh.aGY().a(paramString, 0);
        this.nma = true;
      }
    }
    AppMethodBeat.o(20918);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends BaseAdapter
  {
    private final Context context;
    List<com.tencent.mm.plugin.o.a.b> lxh;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(20907);
      this.lxh = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(20907);
    }
    
    private com.tencent.mm.plugin.o.a.b yv(int paramInt)
    {
      AppMethodBeat.i(20910);
      com.tencent.mm.plugin.o.a.b localb = (com.tencent.mm.plugin.o.a.b)this.lxh.get(paramInt);
      AppMethodBeat.o(20910);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(20909);
      int i = this.lxh.size();
      AppMethodBeat.o(20909);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(20908);
      paramViewGroup = new a();
      com.tencent.mm.plugin.o.a.b localb;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.elZ, null);
        paramViewGroup.nmd = ((ImageView)paramView.findViewById(R.h.dAp));
        paramViewGroup.kMh = ((TextView)paramView.findViewById(R.h.dqq));
        paramViewGroup.jbF = ((TextView)paramView.findViewById(R.h.dqx));
        paramView.setTag(paramViewGroup);
        localb = yv(paramInt);
        if ((localb.type == null) || (!localb.type.equals("0"))) {
          break label195;
        }
        paramViewGroup.kMh.setText(R.l.eIj);
        paramViewGroup.jbF.setText(localb.title);
        label128:
        if ((!InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).DNR != localb.DNR)) {
          break label241;
        }
        paramViewGroup.nmd.setImageResource(R.k.radio_on);
      }
      for (;;)
      {
        AppMethodBeat.o(20908);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label195:
        if ((localb.type == null) || (!localb.type.equals("1"))) {
          break label128;
        }
        paramViewGroup.kMh.setText(R.l.eIl);
        paramViewGroup.jbF.setText(localb.DNS);
        break label128;
        label241:
        paramViewGroup.nmd.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView jbF;
      TextView kMh;
      ImageView nmd;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */