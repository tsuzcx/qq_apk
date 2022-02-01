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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI
  extends MMActivity
  implements f
{
  private ListView hbO;
  private com.tencent.mm.plugin.j.a.b jvS;
  private a jvT;
  private com.tencent.mm.plugin.address.b.b.a jvU;
  private TextView jvV;
  private LinkedList<com.tencent.mm.plugin.j.a.b> jvW;
  private boolean jvX;
  private boolean jvY;
  private TextView jvg;
  private boolean jvr;
  private Object lockObj;
  
  public InvoiceListUI()
  {
    AppMethodBeat.i(20912);
    this.jvU = null;
    this.lockObj = new Object();
    this.jvV = null;
    this.jvg = null;
    this.jvW = new LinkedList();
    this.jvr = false;
    this.jvX = false;
    this.jvY = false;
    AppMethodBeat.o(20912);
  }
  
  private void aVB()
  {
    AppMethodBeat.i(20916);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.aVq();
      this.jvW = com.tencent.mm.plugin.address.a.a.aVr().juy.uVn;
      this.jvT.hMc = this.jvW;
      this.jvW.size();
      this.jvT.notifyDataSetChanged();
      AppMethodBeat.o(20916);
      return;
    }
  }
  
  private void rA(int paramInt)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20919);
      return;
      ((Intent)localObject).setClass(this, AddInvoiceUI.class);
      ((Intent)localObject).putExtra("launch_from_invoicelist_webview", this.jvr);
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
    this.jvV = ((TextView)findViewById(2131300995));
    if (this.jvV != null) {
      this.jvV.setVisibility(8);
    }
    if (this.jvr)
    {
      this.jvg = ((TextView)findViewById(2131301231));
      if (this.jvg != null) {
        this.jvg.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jvV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(20900);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          InvoiceListUI.a(InvoiceListUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(20900);
        }
      });
      this.hbO = ((ListView)findViewById(2131304655));
      this.jvT = new a(this);
      this.hbO.setAdapter(this.jvT);
      this.hbO.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20901);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(???);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          ae.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
          synchronized (InvoiceListUI.b(InvoiceListUI.this))
          {
            if (paramAnonymousInt < InvoiceListUI.c(InvoiceListUI.this).size())
            {
              InvoiceListUI.a(InvoiceListUI.this, (com.tencent.mm.plugin.j.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt));
              if ((InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null)) {
                break label185;
              }
              InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.e(InvoiceListUI.this).uVo);
            }
            label185:
            while ((InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).uVo == 0))
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
      this.hbO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20903);
          paramAnonymousAdapterView = InvoiceListUI.this.getResources().getStringArray(2130903053);
          h.a(InvoiceListUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
          {
            public final void lh(int paramAnonymous2Int)
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
                  InvoiceListUI.a(InvoiceListUI.this, localObject1.uVo);
                  AppMethodBeat.o(20902);
                  return;
                  locala = new com.tencent.mm.plugin.address.model.a(localObject1.uVo);
                  InvoiceListUI.a(InvoiceListUI.this, null);
                  bc.ajj().a(locala, 0);
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
      this.jvT.notifyDataSetChanged();
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
      this.jvg = ((TextView)findViewById(2131301231));
      if (this.jvg != null) {
        this.jvg.setVisibility(8);
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
      ae.e("MicroMsg.InvoiceUtil", "intent is null");
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
        ((com.tencent.mm.plugin.j.a.b)localObject).uVp = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.j.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.j.a.b)localObject).uVq = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.j.a.b)localObject).uVw = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.j.a.b)localObject).uVu = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.j.a.b)localObject).uVs = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.j.a.b)localObject).uVr = paramIntent.getStringExtra("bank_account");
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
    this.jvr = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.jvX = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.jvr) || (this.jvX)) {
      this.jvr = true;
    }
    if (this.jvr)
    {
      bc.aCg();
      boolean bool = ((Boolean)c.ajA().get(am.a.IQB, Boolean.TRUE)).booleanValue();
      ae.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(bool)));
      if (bool)
      {
        ae.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        h.a(this, getString(2131760412), getString(2131760413), getString(2131755012), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20906);
            ae.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(20906);
          }
        });
        bc.aCg();
        c.ajA().set(am.a.IQB, Boolean.FALSE);
      }
    }
    setMMTitle(2131763310);
    bc.ajj().a(1194, this);
    bc.ajj().a(1191, this);
    initView();
    aVB();
    AppMethodBeat.o(20913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20914);
    bc.ajj().b(1194, this);
    bc.ajj().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(20914);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20915);
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    bc.ajj().a(localb, 0);
    super.onResume();
    AppMethodBeat.o(20915);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20918);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramn.getType() == 1191)
      {
        aVB();
        if (this.jvr)
        {
          com.tencent.mm.plugin.address.a.a.aVq();
          if ((com.tencent.mm.plugin.address.a.a.aVr().juy.uVn.size() == 0) && (!this.jvY))
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
        bc.ajj().a(paramString, 0);
        this.jvY = true;
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
    List<com.tencent.mm.plugin.j.a.b> hMc;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(20907);
      this.hMc = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(20907);
    }
    
    private com.tencent.mm.plugin.j.a.b rB(int paramInt)
    {
      AppMethodBeat.i(20910);
      com.tencent.mm.plugin.j.a.b localb = (com.tencent.mm.plugin.j.a.b)this.hMc.get(paramInt);
      AppMethodBeat.o(20910);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(20909);
      int i = this.hMc.size();
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
        paramViewGroup.jwb = ((ImageView)paramView.findViewById(2131298246));
        paramViewGroup.heO = ((TextView)paramView.findViewById(2131296472));
        paramViewGroup.fSj = ((TextView)paramView.findViewById(2131296487));
        paramView.setTag(paramViewGroup);
        localb = rB(paramInt);
        if ((localb.type == null) || (!localb.type.equals("0"))) {
          break label189;
        }
        paramViewGroup.heO.setText(2131760395);
        paramViewGroup.fSj.setText(localb.title);
        label123:
        if ((!InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).uVo != localb.uVo)) {
          break label234;
        }
        paramViewGroup.jwb.setImageResource(2131691078);
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
        paramViewGroup.heO.setText(2131760401);
        paramViewGroup.fSj.setText(localb.uVp);
        break label123;
        label234:
        paramViewGroup.jwb.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView fSj;
      TextView heO;
      ImageView jwb;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */