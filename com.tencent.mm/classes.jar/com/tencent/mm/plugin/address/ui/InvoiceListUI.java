package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private com.tencent.mm.plugin.j.a.b izN;
  private a izO;
  private ListView izP;
  private com.tencent.mm.plugin.address.b.b.a izQ;
  private TextView izR;
  private LinkedList<com.tencent.mm.plugin.j.a.b> izS;
  private boolean izT;
  private boolean izU;
  private TextView izb;
  private boolean izm;
  private Object lockObj;
  
  public InvoiceListUI()
  {
    AppMethodBeat.i(20912);
    this.izQ = null;
    this.lockObj = new Object();
    this.izR = null;
    this.izb = null;
    this.izS = new LinkedList();
    this.izm = false;
    this.izT = false;
    this.izU = false;
    AppMethodBeat.o(20912);
  }
  
  private void aKZ()
  {
    AppMethodBeat.i(20916);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.aKO();
      this.izS = com.tencent.mm.plugin.address.a.a.aKP().iyt.szd;
      this.izO.gQr = this.izS;
      this.izS.size();
      this.izO.notifyDataSetChanged();
      AppMethodBeat.o(20916);
      return;
    }
  }
  
  private void qk(int paramInt)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20919);
      return;
      ((Intent)localObject).setClass(this, AddInvoiceUI.class);
      ((Intent)localObject).putExtra("launch_from_invoicelist_webview", this.izm);
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
    this.izR = ((TextView)findViewById(2131300995));
    if (this.izR != null) {
      this.izR.setVisibility(8);
    }
    if (this.izm)
    {
      this.izb = ((TextView)findViewById(2131301231));
      if (this.izb != null) {
        this.izb.setVisibility(0);
      }
    }
    for (;;)
    {
      this.izR.setOnClickListener(new InvoiceListUI.1(this));
      this.izP = ((ListView)findViewById(2131304655));
      this.izO = new a(this);
      this.izP.setAdapter(this.izO);
      this.izP.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20901);
          ad.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
          synchronized (InvoiceListUI.b(InvoiceListUI.this))
          {
            if (paramAnonymousInt < InvoiceListUI.c(InvoiceListUI.this).size())
            {
              InvoiceListUI.a(InvoiceListUI.this, (com.tencent.mm.plugin.j.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt));
              if ((InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null)) {
                break label122;
              }
              InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.e(InvoiceListUI.this).sze);
            }
            label122:
            while ((InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).sze == 0))
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
      this.izP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20903);
          paramAnonymousAdapterView = InvoiceListUI.this.getResources().getStringArray(2130903053);
          h.a(InvoiceListUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
          {
            public final void kM(int paramAnonymous2Int)
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
                  InvoiceListUI.a(InvoiceListUI.this, localObject1.sze);
                  AppMethodBeat.o(20902);
                  return;
                  locala = new com.tencent.mm.plugin.address.model.a(localObject1.sze);
                  InvoiceListUI.a(InvoiceListUI.this, null);
                  az.aeS().a(locala, 0);
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
      this.izO.notifyDataSetChanged();
      setBackBtn(new InvoiceListUI.4(this));
      addIconOptionMenu(0, 2131763167, 2131689489, new InvoiceListUI.5(this));
      AppMethodBeat.o(20917);
      return;
      this.izb = ((TextView)findViewById(2131301231));
      if (this.izb != null) {
        this.izb.setVisibility(8);
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
      ad.e("MicroMsg.InvoiceUtil", "intent is null");
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
        ((com.tencent.mm.plugin.j.a.b)localObject).szf = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.j.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.j.a.b)localObject).szg = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.j.a.b)localObject).szm = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.j.a.b)localObject).szk = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.j.a.b)localObject).szi = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.j.a.b)localObject).szh = paramIntent.getStringExtra("bank_account");
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
    this.izm = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.izT = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.izm) || (this.izT)) {
      this.izm = true;
    }
    if (this.izm)
    {
      az.arV();
      boolean bool = ((Boolean)c.afk().get(ae.a.FlW, Boolean.TRUE)).booleanValue();
      ad.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(bool)));
      if (bool)
      {
        ad.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        h.a(this, getString(2131760412), getString(2131760413), getString(2131755012), false, new InvoiceListUI.6(this));
        az.arV();
        c.afk().set(ae.a.FlW, Boolean.FALSE);
      }
    }
    setMMTitle(2131763310);
    az.aeS().a(1194, this);
    az.aeS().a(1191, this);
    initView();
    aKZ();
    AppMethodBeat.o(20913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20914);
    az.aeS().b(1194, this);
    az.aeS().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(20914);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20915);
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    az.aeS().a(localb, 0);
    super.onResume();
    AppMethodBeat.o(20915);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20918);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramn.getType() == 1191)
      {
        aKZ();
        if (this.izm)
        {
          com.tencent.mm.plugin.address.a.a.aKO();
          if ((com.tencent.mm.plugin.address.a.a.aKP().iyt.szd.size() == 0) && (!this.izU))
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
        az.aeS().a(paramString, 0);
        this.izU = true;
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
    List<com.tencent.mm.plugin.j.a.b> gQr;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(20907);
      this.gQr = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(20907);
    }
    
    private com.tencent.mm.plugin.j.a.b ql(int paramInt)
    {
      AppMethodBeat.i(20910);
      com.tencent.mm.plugin.j.a.b localb = (com.tencent.mm.plugin.j.a.b)this.gQr.get(paramInt);
      AppMethodBeat.o(20910);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(20909);
      int i = this.gQr.size();
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
        paramViewGroup.izY = ((ImageView)paramView.findViewById(2131298246));
        paramViewGroup.izX = ((TextView)paramView.findViewById(2131296472));
        paramViewGroup.ftj = ((TextView)paramView.findViewById(2131296487));
        paramView.setTag(paramViewGroup);
        localb = ql(paramInt);
        if ((localb.type == null) || (!localb.type.equals("0"))) {
          break label189;
        }
        paramViewGroup.izX.setText(2131760395);
        paramViewGroup.ftj.setText(localb.title);
        label123:
        if ((!InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).sze != localb.sze)) {
          break label234;
        }
        paramViewGroup.izY.setImageResource(2131691078);
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
        paramViewGroup.izX.setText(2131760401);
        paramViewGroup.ftj.setText(localb.szf);
        break label123;
        label234:
        paramViewGroup.izY.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView ftj;
      TextView izX;
      ImageView izY;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */