package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class InvoiceListUI
  extends MMActivity
  implements f
{
  private boolean gLC;
  private TextView gLr;
  private com.tencent.mm.plugin.j.a.b gMf;
  private InvoiceListUI.a gMg;
  private ListView gMh;
  private com.tencent.mm.plugin.address.b.b.a gMi;
  private TextView gMj;
  private LinkedList<com.tencent.mm.plugin.j.a.b> gMk;
  private boolean gMl;
  private boolean gMm;
  private Object lockObj;
  
  public InvoiceListUI()
  {
    AppMethodBeat.i(16869);
    this.gMi = null;
    this.lockObj = new Object();
    this.gMj = null;
    this.gLr = null;
    this.gMk = new LinkedList();
    this.gLC = false;
    this.gMl = false;
    this.gMm = false;
    AppMethodBeat.o(16869);
  }
  
  private void asx()
  {
    AppMethodBeat.i(16873);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.asl();
      this.gMk = com.tencent.mm.plugin.address.a.a.asm().gKJ.nLl;
      this.gMg.items = this.gMk;
      this.gMk.size();
      this.gMg.notifyDataSetChanged();
      AppMethodBeat.o(16873);
      return;
    }
  }
  
  private void nb(int paramInt)
  {
    AppMethodBeat.i(16876);
    Intent localIntent = new Intent();
    if (paramInt != 0)
    {
      localIntent.setClass(this, QrcodeInvoiceUI.class);
      localIntent.putExtra("invoice_id", paramInt);
    }
    for (;;)
    {
      startActivity(localIntent);
      AppMethodBeat.o(16876);
      return;
      localIntent.setClass(this, AddInvoiceUI.class);
      localIntent.putExtra("launch_from_invoicelist_webview", this.gLC);
      localIntent.putExtra("invoice_id", paramInt);
    }
  }
  
  public int getLayoutId()
  {
    return 2130969916;
  }
  
  public void initView()
  {
    AppMethodBeat.i(16874);
    this.gMj = ((TextView)findViewById(2131825163));
    if (this.gMj != null) {
      this.gMj.setVisibility(8);
    }
    if (this.gLC)
    {
      this.gLr = ((TextView)findViewById(2131825164));
      if (this.gLr != null) {
        this.gLr.setVisibility(0);
      }
    }
    for (;;)
    {
      this.gMj.setOnClickListener(new InvoiceListUI.1(this));
      this.gMh = ((ListView)findViewById(2131825161));
      this.gMg = new InvoiceListUI.a(this, this);
      this.gMh.setAdapter(this.gMg);
      this.gMh.setOnItemClickListener(new InvoiceListUI.2(this));
      this.gMh.setOnItemLongClickListener(new InvoiceListUI.3(this));
      this.gMg.notifyDataSetChanged();
      setBackBtn(new InvoiceListUI.4(this));
      addIconOptionMenu(0, 2131303200, 2131230736, new InvoiceListUI.5(this));
      AppMethodBeat.o(16874);
      return;
      this.gLr = ((TextView)findViewById(2131825164));
      if (this.gLr != null) {
        this.gLr.setVisibility(8);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(16877);
    Object localObject;
    if (paramInt1 == 1)
    {
      if (-1 != paramInt2) {
        break label209;
      }
      if (paramIntent != null) {
        break label71;
      }
      ab.e("MicroMsg.InvoiceUtil", "intent is null");
      paramIntent = null;
      localObject = new Intent();
      ((Intent)localObject).putExtra("choose_invoice_title_info", e.a(paramIntent));
      setResult(-1, (Intent)localObject);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(16877);
      return;
      label71:
      localObject = new com.tencent.mm.plugin.j.a.b();
      ((com.tencent.mm.plugin.j.a.b)localObject).type = paramIntent.getStringExtra("type");
      if ((((com.tencent.mm.plugin.j.a.b)localObject).type != null) && (((com.tencent.mm.plugin.j.a.b)localObject).type.equals("1")))
      {
        ((com.tencent.mm.plugin.j.a.b)localObject).nLn = paramIntent.getStringExtra("title");
        paramIntent = (Intent)localObject;
        break;
      }
      ((com.tencent.mm.plugin.j.a.b)localObject).title = paramIntent.getStringExtra("title");
      ((com.tencent.mm.plugin.j.a.b)localObject).nLo = paramIntent.getStringExtra("tax_number");
      ((com.tencent.mm.plugin.j.a.b)localObject).nLu = paramIntent.getStringExtra("company_address");
      ((com.tencent.mm.plugin.j.a.b)localObject).nLs = paramIntent.getStringExtra("telephone");
      ((com.tencent.mm.plugin.j.a.b)localObject).nLq = paramIntent.getStringExtra("bank_name");
      ((com.tencent.mm.plugin.j.a.b)localObject).nLp = paramIntent.getStringExtra("bank_account");
      paramIntent = (Intent)localObject;
      break;
      label209:
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(16870);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.gLC = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.gMl = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((this.gLC) || (this.gMl)) {
      this.gLC = true;
    }
    if (this.gLC)
    {
      aw.aaz();
      boolean bool = ((Boolean)c.Ru().get(ac.a.yDy, Boolean.TRUE)).booleanValue();
      ab.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(bool)));
      if (bool)
      {
        ab.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
        h.a(this, getString(2131300811), getString(2131300812), getString(2131296332), false, new InvoiceListUI.6(this));
        aw.aaz();
        c.Ru().set(ac.a.yDy, Boolean.FALSE);
      }
    }
    setMMTitle(2131303330);
    aw.Rc().a(1194, this);
    aw.Rc().a(1191, this);
    initView();
    asx();
    AppMethodBeat.o(16870);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(16871);
    aw.Rc().b(1194, this);
    aw.Rc().b(1191, this);
    super.onDestroy();
    AppMethodBeat.o(16871);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(16872);
    com.tencent.mm.plugin.address.model.b localb = new com.tencent.mm.plugin.address.model.b();
    aw.Rc().a(localb, 0);
    super.onResume();
    AppMethodBeat.o(16872);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(16875);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramm.getType() == 1191)
      {
        asx();
        if (this.gLC)
        {
          com.tencent.mm.plugin.address.a.a.asl();
          if ((com.tencent.mm.plugin.address.a.a.asm().gKJ.nLl.size() == 0) && (!this.gMm))
          {
            paramString = new Intent();
            paramString.setClass(this, AddInvoiceUI.class);
            paramString.putExtra("launch_from_webview", true);
            startActivityForResult(paramString, 1);
            AppMethodBeat.o(16875);
          }
        }
      }
      else if (paramm.getType() == 1194)
      {
        paramString = new com.tencent.mm.plugin.address.model.b();
        aw.Rc().a(paramString, 0);
        this.gMm = true;
      }
    }
    AppMethodBeat.o(16875);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI
 * JD-Core Version:    0.7.0.1
 */