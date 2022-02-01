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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
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
  private ListView hUI;
  private boolean ktF;
  private TextView ktu;
  private com.tencent.mm.plugin.j.a.b kug;
  private a kuh;
  private com.tencent.mm.plugin.address.b.b.a kui;
  private TextView kuj;
  private LinkedList<com.tencent.mm.plugin.j.a.b> kuk;
  private boolean kul;
  private boolean kum;
  private Object lockObj;
  
  public InvoiceListUI()
  {
    AppMethodBeat.i(20912);
    this.kui = null;
    this.lockObj = new Object();
    this.kuj = null;
    this.ktu = null;
    this.kuk = new LinkedList();
    this.ktF = false;
    this.kul = false;
    this.kum = false;
    AppMethodBeat.o(20912);
  }
  
  private void bqn()
  {
    AppMethodBeat.i(20916);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.bqb();
      this.kuk = com.tencent.mm.plugin.address.a.a.bqc().ksN.ynO;
      this.kuh.iHf = this.kuk;
      this.kuk.size();
      this.kuh.notifyDataSetChanged();
      AppMethodBeat.o(20916);
      return;
    }
  }
  
  private void vq(int paramInt)
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI", "editInvoiceUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(20919);
      return;
      ((Intent)localObject).setClass(this, AddInvoiceUI.class);
      ((Intent)localObject).putExtra("launch_from_invoicelist_webview", this.ktF);
      ((Intent)localObject).putExtra("invoice_id", paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495086;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20917);
    this.kuj = ((TextView)findViewById(2131302636));
    if (this.kuj != null) {
      this.kuj.setVisibility(8);
    }
    if (this.ktF)
    {
      this.ktu = ((TextView)findViewById(2131302919));
      if (this.ktu != null) {
        this.ktu.setVisibility(0);
      }
    }
    for (;;)
    {
      this.kuj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(20900);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          InvoiceListUI.a(InvoiceListUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/InvoiceListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(20900);
        }
      });
      this.hUI = ((ListView)findViewById(2131307708));
      this.kuh = new a(this);
      this.hUI.setAdapter(this.kuh);
      this.hUI.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> arg1, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20901);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(???);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/InvoiceListUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          Log.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(paramAnonymousInt)));
          synchronized (InvoiceListUI.b(InvoiceListUI.this))
          {
            if (paramAnonymousInt < InvoiceListUI.c(InvoiceListUI.this).size())
            {
              InvoiceListUI.a(InvoiceListUI.this, (com.tencent.mm.plugin.j.a.b)InvoiceListUI.c(InvoiceListUI.this).get(paramAnonymousInt));
              if ((InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null)) {
                break label185;
              }
              InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.e(InvoiceListUI.this).ynP);
            }
            label185:
            while ((InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).ynP == 0))
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
      this.hUI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(20903);
          paramAnonymousAdapterView = InvoiceListUI.this.getResources().getStringArray(2130903053);
          h.a(InvoiceListUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.d()
          {
            public final void oj(int paramAnonymous2Int)
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
                  InvoiceListUI.a(InvoiceListUI.this, localObject1.ynP);
                  AppMethodBeat.o(20902);
                  return;
                  locala = new com.tencent.mm.plugin.address.model.a(localObject1.ynP);
                  InvoiceListUI.a(InvoiceListUI.this, null);
                  bg.azz().a(locala, 0);
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
      this.kuh.notifyDataSetChanged();
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
      addIconOptionMenu(0, 2131765335, 2131689491, new MenuItem.OnMenuItemClickListener()
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
      this.ktu = ((TextView)findViewById(2131302919));
      if (this.ktu != null) {
        this.ktu.setVisibility(8);
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
      localObject = new com.tencent.mm.plugin.j.a.b();
      ((com.tencent.mm.plugin.j.a.b)localObject).type = paramIntent.getStringExtra("type");
      if ((((com.tencent.mm.plugin.j.a.b)localObject).type != null) && (((com.tencent.mm.plugin.j.a.b)localObject).type.equals("1")))
      {
        ((com.tencent.mm.plugin.j.a.b)localObject).ynQ = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.j.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.j.a.b)localObject).ynR = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.j.a.b)localObject).ynX = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.j.a.b)localObject).ynV = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.j.a.b)localObject).ynT = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.j.a.b)localObject).ynS = paramIntent.getStringExtra("bank_account");
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
    this.ktF = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.kul = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.ktF) || (this.kul)) {
      this.ktF = true;
    }
    if (this.ktF)
    {
      bg.aVF();
      boolean bool = ((Boolean)c.azQ().get(ar.a.NYC, Boolean.TRUE)).booleanValue();
      Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(bool)));
      if (bool)
      {
        Log.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        h.a(this, getString(2131761857), getString(2131761858), getString(2131755013), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(20906);
            Log.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(20906);
          }
        });
        bg.aVF();
        c.azQ().set(ar.a.NYC, Boolean.FALSE);
      }
    }
    setMMTitle(2131765489);
    bg.azz().a(1194, this);
    bg.azz().a(1191, this);
    initView();
    bqn();
    AppMethodBeat.o(20913);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20914);
    bg.azz().b(1194, this);
    bg.azz().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(20914);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20915);
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    bg.azz().a(localb, 0);
    super.onResume();
    AppMethodBeat.o(20915);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(20918);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramq.getType() == 1191)
      {
        bqn();
        if (this.ktF)
        {
          com.tencent.mm.plugin.address.a.a.bqb();
          if ((com.tencent.mm.plugin.address.a.a.bqc().ksN.ynO.size() == 0) && (!this.kum))
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
        bg.azz().a(paramString, 0);
        this.kum = true;
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
    List<com.tencent.mm.plugin.j.a.b> iHf;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(20907);
      this.iHf = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(20907);
    }
    
    private com.tencent.mm.plugin.j.a.b vr(int paramInt)
    {
      AppMethodBeat.i(20910);
      com.tencent.mm.plugin.j.a.b localb = (com.tencent.mm.plugin.j.a.b)this.iHf.get(paramInt);
      AppMethodBeat.o(20910);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(20909);
      int i = this.iHf.size();
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
        paramView = View.inflate(this.context, 2131496873, null);
        paramViewGroup.kup = ((ImageView)paramView.findViewById(2131298630));
        paramViewGroup.hXC = ((TextView)paramView.findViewById(2131296546));
        paramViewGroup.gxs = ((TextView)paramView.findViewById(2131296561));
        paramView.setTag(paramViewGroup);
        localb = vr(paramInt);
        if ((localb.type == null) || (!localb.type.equals("0"))) {
          break label189;
        }
        paramViewGroup.hXC.setText(2131761840);
        paramViewGroup.gxs.setText(localb.title);
        label123:
        if ((!InvoiceListUI.d(InvoiceListUI.this)) || (InvoiceListUI.e(InvoiceListUI.this) == null) || (InvoiceListUI.e(InvoiceListUI.this).ynP != localb.ynP)) {
          break label234;
        }
        paramViewGroup.kup.setImageResource(2131691380);
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
        paramViewGroup.hXC.setText(2131761846);
        paramViewGroup.gxs.setText(localb.ynQ);
        break label123;
        label234:
        paramViewGroup.kup.setImageBitmap(null);
      }
    }
    
    final class a
    {
      TextView gxs;
      TextView hXC;
      ImageView kup;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */