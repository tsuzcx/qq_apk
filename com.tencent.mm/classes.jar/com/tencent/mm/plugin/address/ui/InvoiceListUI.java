package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
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
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI
  extends MMActivity
  implements h
{
  private Object lockObj;
  private ListView nlI;
  private boolean qiC;
  private TextView qir;
  private com.tencent.mm.plugin.o.a.b qjd;
  private a qje;
  private com.tencent.mm.plugin.address.b.b.a qjf;
  private TextView qjg;
  private LinkedList<com.tencent.mm.plugin.o.a.b> qjh;
  private boolean qji;
  private boolean qjj;
  
  public InvoiceListUI()
  {
    AppMethodBeat.i(20912);
    this.qjf = null;
    this.lockObj = new Object();
    this.qjg = null;
    this.qir = null;
    this.qjh = new LinkedList();
    this.qiC = false;
    this.qji = false;
    this.qjj = false;
    AppMethodBeat.o(20912);
  }
  
  private void bZr()
  {
    AppMethodBeat.i(20916);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.bZe();
      this.qjh = com.tencent.mm.plugin.address.a.a.bZf().qhF.JFf;
      this.qje.bMQ = this.qjh;
      this.qjh.size();
      this.qje.notifyDataSetChanged();
      AppMethodBeat.o(20916);
      return;
    }
  }
  
  private void yC(int paramInt)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20919);
      return;
      ((Intent)localObject).setClass(this, AddInvoiceUI.class);
      ((Intent)localObject).putExtra("launch_from_invoicelist_webview", this.qiC);
      ((Intent)localObject).putExtra("invoice_id", paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return R.i.gkB;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20917);
    this.qjg = ((TextView)findViewById(R.h.fKz));
    if (this.qjg != null) {
      this.qjg.setVisibility(8);
    }
    if (this.qiC)
    {
      this.qir = ((TextView)findViewById(R.h.fLR));
      if (this.qir != null) {
        this.qir.setVisibility(0);
      }
    }
    for (;;)
    {
      this.qjg.setOnClickListener(new InvoiceListUI.1(this));
      this.nlI = ((ListView)findViewById(R.h.fVZ));
      this.qje = new a(this);
      this.nlI.setAdapter(this.qje);
      this.nlI.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20901);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(???);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/InvoiceListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          Log.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
          synchronized (InvoiceListUI.b(InvoiceListUI.this))
          {
            if (paramAnonymousInt < InvoiceListUI.c(InvoiceListUI.this).size())
            {
              InvoiceListUI.a(InvoiceListUI.this, (com.tencent.mm.plugin.o.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt));
              if ((InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null)) {
                break label185;
              }
              InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.e(InvoiceListUI.this).JFg);
            }
            label185:
            while ((InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).JFg == 0))
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
      this.nlI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20903);
          paramAnonymousAdapterView = InvoiceListUI.this.getResources().getStringArray(R.c.fjR);
          k.a(InvoiceListUI.this.getContext(), null, paramAnonymousAdapterView, null, new k.d()
          {
            public final void qz(int paramAnonymous2Int)
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
                  InvoiceListUI.a(InvoiceListUI.this, localObject1.JFg);
                  AppMethodBeat.o(20902);
                  return;
                  locala = new com.tencent.mm.plugin.address.model.a(localObject1.JFg);
                  InvoiceListUI.a(InvoiceListUI.this, null);
                  bh.aZW().a(locala, 0);
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
      this.qje.notifyDataSetChanged();
      setBackBtn(new InvoiceListUI.4(this));
      addIconOptionMenu(0, R.l.settings_add_invoice, R.k.actionbar_icon_dark_add, new InvoiceListUI.5(this));
      AppMethodBeat.o(20917);
      return;
      this.qir = ((TextView)findViewById(R.h.fLR));
      if (this.qir != null) {
        this.qir.setVisibility(8);
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
        ((com.tencent.mm.plugin.o.a.b)localObject).JFh = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.o.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.o.a.b)localObject).JFi = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.o.a.b)localObject).JFo = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.o.a.b)localObject).JFm = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.o.a.b)localObject).JFk = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.o.a.b)localObject).JFj = paramIntent.getStringExtra("bank_account");
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
    this.qiC = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.qji = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.qiC) || (this.qji)) {
      this.qiC = true;
    }
    if (this.qiC)
    {
      bh.bCz();
      boolean bool = ((Boolean)c.ban().get(at.a.acNX, Boolean.TRUE)).booleanValue();
      Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(bool)));
      if (bool)
      {
        Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        k.a(this, getString(R.l.gJX), getString(R.l.gJY), getString(R.l.gps), false, new InvoiceListUI.6(this));
        bh.bCz();
        c.ban().set(at.a.acNX, Boolean.FALSE);
      }
    }
    setMMTitle(R.l.settings_my_invoice_information);
    bh.aZW().a(1194, this);
    bh.aZW().a(1191, this);
    initView();
    bZr();
    AppMethodBeat.o(20913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20914);
    bh.aZW().b(1194, this);
    bh.aZW().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(20914);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20915);
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    bh.aZW().a(localb, 0);
    super.onResume();
    AppMethodBeat.o(20915);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(20918);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramp.getType() == 1191)
      {
        bZr();
        if (this.qiC)
        {
          com.tencent.mm.plugin.address.a.a.bZe();
          if ((com.tencent.mm.plugin.address.a.a.bZf().qhF.JFf.size() == 0) && (!this.qjj))
          {
            paramString = new Intent();
            paramString.setClass(this, AddInvoiceUI.class);
            paramString.putExtra("launch_from_webview", true);
            startActivityForResult(paramString, 1);
            AppMethodBeat.o(20918);
          }
        }
      }
      else if (paramp.getType() == 1194)
      {
        paramString = new com.tencent.mm.plugin.address.model.b();
        bh.aZW().a(paramString, 0);
        this.qjj = true;
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
    List<com.tencent.mm.plugin.o.a.b> bMQ;
    private final Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(20907);
      this.bMQ = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(20907);
    }
    
    private com.tencent.mm.plugin.o.a.b yD(int paramInt)
    {
      AppMethodBeat.i(20910);
      com.tencent.mm.plugin.o.a.b localb = (com.tencent.mm.plugin.o.a.b)this.bMQ.get(paramInt);
      AppMethodBeat.o(20910);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(20909);
      int i = this.bMQ.size();
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
        paramView = View.inflate(this.context, R.i.gpd, null);
        paramViewGroup.qjm = ((ImageView)paramView.findViewById(R.h.fBk));
        paramViewGroup.noc = ((TextView)paramView.findViewById(R.h.fqE));
        paramViewGroup.lDF = ((TextView)paramView.findViewById(R.h.fqL));
        paramView.setTag(paramViewGroup);
        localb = yD(paramInt);
        if ((localb.type == null) || (!localb.type.equals("0"))) {
          break label195;
        }
        paramViewGroup.noc.setText(R.l.gJQ);
        paramViewGroup.lDF.setText(localb.title);
        label128:
        if ((!InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).JFg != localb.JFg)) {
          break label241;
        }
        paramViewGroup.qjm.setImageResource(R.k.radio_on);
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
        paramViewGroup.noc.setText(R.l.gJS);
        paramViewGroup.lDF.setText(localb.JFh);
        break label128;
        label241:
        paramViewGroup.qjm.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView lDF;
      TextView noc;
      ImageView qjm;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */