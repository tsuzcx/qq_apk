package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class InvoiceListUI
  extends MMActivity
  implements f
{
  private TextView ftP = null;
  private com.tencent.mm.plugin.o.a.b fuD;
  private InvoiceListUI.a fuE;
  private ListView fuF;
  private com.tencent.mm.plugin.address.b.b.a fuG = null;
  private TextView fuH = null;
  private LinkedList<com.tencent.mm.plugin.o.a.b> fuI = new LinkedList();
  private boolean fuJ = false;
  private boolean fuK = false;
  private boolean fua = false;
  private Object lockObj = new Object();
  
  private void YN()
  {
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.YB();
      this.fuI = com.tencent.mm.plugin.address.a.a.YC().fth.lnO;
      this.fuE.items = this.fuI;
      this.fuI.size();
      this.fuE.notifyDataSetChanged();
      return;
    }
  }
  
  private void kj(int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramInt != 0)
    {
      localIntent.setClass(this, QrcodeInvoiceUI.class);
      localIntent.putExtra("invoice_id", paramInt);
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      localIntent.setClass(this, AddInvoiceUI.class);
      localIntent.putExtra("launch_from_invoicelist_webview", this.fua);
      localIntent.putExtra("invoice_id", paramInt);
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.invoice_list_ui;
  }
  
  public final void initView()
  {
    this.fuH = ((TextView)findViewById(R.h.import_invoice_tv));
    if (this.fuH != null) {
      this.fuH.setVisibility(8);
    }
    if (this.fua)
    {
      this.ftP = ((TextView)findViewById(R.h.jsapi_tips_tv));
      if (this.ftP != null) {
        this.ftP.setVisibility(0);
      }
    }
    for (;;)
    {
      this.fuH.setOnClickListener(new InvoiceListUI.1(this));
      this.fuF = ((ListView)findViewById(R.h.settings_lv_invoice));
      this.fuE = new InvoiceListUI.a(this, this);
      this.fuF.setAdapter(this.fuE);
      this.fuF.setOnItemClickListener(new InvoiceListUI.2(this));
      this.fuF.setOnItemLongClickListener(new InvoiceListUI.3(this));
      this.fuE.notifyDataSetChanged();
      setBackBtn(new InvoiceListUI.4(this));
      addIconOptionMenu(0, R.l.settings_add_invoice, R.k.actionbar_icon_dark_add, new InvoiceListUI.5(this));
      return;
      this.ftP = ((TextView)findViewById(R.h.jsapi_tips_tv));
      if (this.ftP != null) {
        this.ftP.setVisibility(8);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 1)
    {
      if (-1 != paramInt2) {
        break label197;
      }
      if (paramIntent != null) {
        break label59;
      }
      y.e("MicroMsg.InvoiceUtil", "intent is null");
      paramIntent = null;
      localObject = new Intent();
      ((Intent)localObject).putExtra("choose_invoice_title_info", e.a(paramIntent));
      setResult(-1, (Intent)localObject);
    }
    for (;;)
    {
      finish();
      return;
      label59:
      localObject = new com.tencent.mm.plugin.o.a.b();
      ((com.tencent.mm.plugin.o.a.b)localObject).type = paramIntent.getStringExtra("type");
      if ((((com.tencent.mm.plugin.o.a.b)localObject).type != null) && (((com.tencent.mm.plugin.o.a.b)localObject).type.equals("1")))
      {
        ((com.tencent.mm.plugin.o.a.b)localObject).lnQ = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.o.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.o.a.b)localObject).lnR = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.o.a.b)localObject).lnX = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.o.a.b)localObject).lnV = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.o.a.b)localObject).lnT = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.o.a.b)localObject).lnS = paramIntent.getStringExtra("bank_account");
      paramIntent = (Intent)localObject;
      break;
      label197:
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.fua = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.fuJ = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.fua) || (this.fuJ)) {
      this.fua = true;
    }
    if (this.fua)
    {
      au.Hx();
      boolean bool = ((Boolean)c.Dz().get(ac.a.utv, Boolean.valueOf(true))).booleanValue();
      y.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog " + bool);
      if (bool)
      {
        y.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        h.a(this, getString(R.l.invoice_third_party_disclaimer_content), getString(R.l.invoice_third_party_disclaimer_title), getString(R.l.I_known), false, new InvoiceListUI.6(this));
        au.Hx();
        c.Dz().c(ac.a.utv, Boolean.valueOf(false));
      }
    }
    setMMTitle(R.l.settings_my_invoice_information);
    au.Dk().a(1194, this);
    au.Dk().a(1191, this);
    initView();
    YN();
  }
  
  public void onDestroy()
  {
    au.Dk().b(1194, this);
    au.Dk().b(1191, this);
    super.onDestroy();
  }
  
  public void onResume()
  {
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    au.Dk().a(localb, 0);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() != 1191) {
        break label89;
      }
      YN();
      if (this.fua)
      {
        com.tencent.mm.plugin.address.a.a.YB();
        if ((com.tencent.mm.plugin.address.a.a.YC().fth.lnO.size() == 0) && (!this.fuK))
        {
          paramString = new Intent();
          paramString.setClass(this, AddInvoiceUI.class);
          paramString.putExtra("launch_from_webview", true);
          startActivityForResult(paramString, 1);
        }
      }
    }
    label89:
    while (paramm.getType() != 1194) {
      return;
    }
    paramString = new com.tencent.mm.plugin.address.model.b();
    au.Dk().a(paramString, 0);
    this.fuK = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */