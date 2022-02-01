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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI
  extends MMActivity
  implements g
{
  private ListView gFr;
  private com.tencent.mm.plugin.j.a.b iZQ;
  private a iZR;
  private com.tencent.mm.plugin.address.b.b.a iZS;
  private TextView iZT;
  private LinkedList<com.tencent.mm.plugin.j.a.b> iZU;
  private boolean iZV;
  private boolean iZW;
  private TextView iZe;
  private boolean iZp;
  private Object lockObj;
  
  public InvoiceListUI()
  {
    AppMethodBeat.i(20912);
    this.iZS = null;
    this.lockObj = new Object();
    this.iZT = null;
    this.iZe = null;
    this.iZU = new LinkedList();
    this.iZp = false;
    this.iZV = false;
    this.iZW = false;
    AppMethodBeat.o(20912);
  }
  
  private void aRQ()
  {
    AppMethodBeat.i(20916);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.aRF();
      this.iZU = com.tencent.mm.plugin.address.a.a.aRG().iYw.tGN;
      this.iZR.hqR = this.iZU;
      this.iZU.size();
      this.iZR.notifyDataSetChanged();
      AppMethodBeat.o(20916);
      return;
    }
  }
  
  private void qX(int paramInt)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20919);
      return;
      ((Intent)localObject).setClass(this, AddInvoiceUI.class);
      ((Intent)localObject).putExtra("launch_from_invoicelist_webview", this.iZp);
      ((Intent)localObject).putExtra("invoice_id", paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131494494;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20917);
    this.iZT = ((TextView)findViewById(2131300995));
    if (this.iZT != null) {
      this.iZT.setVisibility(8);
    }
    if (this.iZp)
    {
      this.iZe = ((TextView)findViewById(2131301231));
      if (this.iZe != null) {
        this.iZe.setVisibility(0);
      }
    }
    for (;;)
    {
      this.iZT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(20900);
          InvoiceListUI.a(InvoiceListUI.this);
          AppMethodBeat.o(20900);
        }
      });
      this.gFr = ((ListView)findViewById(2131304655));
      this.iZR = new a(this);
      this.gFr.setAdapter(this.iZR);
      this.gFr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20901);
          ac.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
          synchronized (InvoiceListUI.b(InvoiceListUI.this))
          {
            if (paramAnonymousInt < InvoiceListUI.c(InvoiceListUI.this).size())
            {
              InvoiceListUI.a(InvoiceListUI.this, (com.tencent.mm.plugin.j.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt));
              if ((InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null)) {
                break label122;
              }
              InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.e(InvoiceListUI.this).tGO);
            }
            label122:
            while ((InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).tGO == 0))
            {
              InvoiceListUI.f(InvoiceListUI.this).notifyDataSetChanged();
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
      this.gFr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20903);
          paramAnonymousAdapterView = InvoiceListUI.this.getResources().getStringArray(2130903053);
          h.a(InvoiceListUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
          {
            public final void kG(int paramAnonymous2Int)
            {
              AppMethodBeat.i(20902);
              for (;;)
              {
                synchronized (InvoiceListUI.b(InvoiceListUI.this))
                {
                  if (paramAnonymousInt >= InvoiceListUI.c(InvoiceListUI.this).size()) {
                    break label194;
                  }
                  com.tencent.mm.plugin.j.a.b localb = (com.tencent.mm.plugin.j.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt);
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
                  InvoiceListUI.a(InvoiceListUI.this, localObject1.tGO);
                  AppMethodBeat.o(20902);
                  return;
                  locala = new com.tencent.mm.plugin.address.model.a(localObject1.tGO);
                  InvoiceListUI.a(InvoiceListUI.this, null);
                  az.agi().a(locala, 0);
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
      this.iZR.notifyDataSetChanged();
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
      addIconOptionMenu(0, 2131763167, 2131689489, new MenuItem.OnMenuItemClickListener()
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
      this.iZe = ((TextView)findViewById(2131301231));
      if (this.iZe != null) {
        this.iZe.setVisibility(8);
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
      ac.e("MicroMsg.InvoiceUtil", "intent is null");
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
      localObject = new com.tencent.mm.plugin.j.a.b();
      ((com.tencent.mm.plugin.j.a.b)localObject).type = paramIntent.getStringExtra("type");
      if ((((com.tencent.mm.plugin.j.a.b)localObject).type != null) && (((com.tencent.mm.plugin.j.a.b)localObject).type.equals("1")))
      {
        ((com.tencent.mm.plugin.j.a.b)localObject).tGP = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.j.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.j.a.b)localObject).tGQ = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.j.a.b)localObject).tGW = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.j.a.b)localObject).tGU = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.j.a.b)localObject).tGS = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.j.a.b)localObject).tGR = paramIntent.getStringExtra("bank_account");
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
    this.iZp = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.iZV = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.iZp) || (this.iZV)) {
      this.iZp = true;
    }
    if (this.iZp)
    {
      az.ayM();
      boolean bool = ((Boolean)c.agA().get(ah.a.GJL, Boolean.TRUE)).booleanValue();
      ac.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(bool)));
      if (bool)
      {
        ac.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        h.a(this, getString(2131760412), getString(2131760413), getString(2131755012), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20906);
            ac.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(20906);
          }
        });
        az.ayM();
        c.agA().set(ah.a.GJL, Boolean.FALSE);
      }
    }
    setMMTitle(2131763310);
    az.agi().a(1194, this);
    az.agi().a(1191, this);
    initView();
    aRQ();
    AppMethodBeat.o(20913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20914);
    az.agi().b(1194, this);
    az.agi().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(20914);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20915);
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    az.agi().a(localb, 0);
    super.onResume();
    AppMethodBeat.o(20915);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20918);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramn.getType() == 1191)
      {
        aRQ();
        if (this.iZp)
        {
          com.tencent.mm.plugin.address.a.a.aRF();
          if ((com.tencent.mm.plugin.address.a.a.aRG().iYw.tGN.size() == 0) && (!this.iZW))
          {
            paramString = new Intent();
            paramString.setClass(this, AddInvoiceUI.class);
            paramString.putExtra("launch_from_webview", true);
            startActivityForResult(paramString, 1);
            AppMethodBeat.o(20918);
          }
        }
      }
      else if (paramn.getType() == 1194)
      {
        paramString = new com.tencent.mm.plugin.address.model.b();
        az.agi().a(paramString, 0);
        this.iZW = true;
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
    List<com.tencent.mm.plugin.j.a.b> hqR;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(20907);
      this.hqR = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(20907);
    }
    
    private com.tencent.mm.plugin.j.a.b qY(int paramInt)
    {
      AppMethodBeat.i(20910);
      com.tencent.mm.plugin.j.a.b localb = (com.tencent.mm.plugin.j.a.b)this.hqR.get(paramInt);
      AppMethodBeat.o(20910);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(20909);
      int i = this.hqR.size();
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
      com.tencent.mm.plugin.j.a.b localb;
      if (paramView == null)
      {
        paramView = View.inflate(this.context, 2131495893, null);
        paramViewGroup.iZZ = ((ImageView)paramView.findViewById(2131298246));
        paramViewGroup.gIq = ((TextView)paramView.findViewById(2131296472));
        paramViewGroup.fwQ = ((TextView)paramView.findViewById(2131296487));
        paramView.setTag(paramViewGroup);
        localb = qY(paramInt);
        if ((localb.type == null) || (!localb.type.equals("0"))) {
          break label189;
        }
        paramViewGroup.gIq.setText(2131760395);
        paramViewGroup.fwQ.setText(localb.title);
        label123:
        if ((!InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).tGO != localb.tGO)) {
          break label234;
        }
        paramViewGroup.iZZ.setImageResource(2131691078);
      }
      for (;;)
      {
        AppMethodBeat.o(20908);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label189:
        if ((localb.type == null) || (!localb.type.equals("1"))) {
          break label123;
        }
        paramViewGroup.gIq.setText(2131760401);
        paramViewGroup.fwQ.setText(localb.tGP);
        break label123;
        label234:
        paramViewGroup.iZZ.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView fwQ;
      TextView gIq;
      ImageView iZZ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */