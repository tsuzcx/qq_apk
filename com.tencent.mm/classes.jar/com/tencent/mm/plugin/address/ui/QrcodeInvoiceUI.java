package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private int jsi;
  private TextView jsm;
  private com.tencent.mm.plugin.j.a.b jsw;
  private InvoiceQrcodeTextView jtA;
  private Bitmap jtB;
  private o jtC;
  private ImageView jtD;
  private View jtE;
  private float jtF;
  private View.OnClickListener jtG;
  private View.OnClickListener jtH;
  private InvoiceQrcodeTextView jtu;
  private InvoiceQrcodeTextView jtv;
  private InvoiceQrcodeTextView jtw;
  private InvoiceQrcodeTextView jtx;
  private InvoiceQrcodeTextView jty;
  private InvoiceQrcodeTextView jtz;
  private Dialog tipDialog;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(20963);
    this.jsi = 0;
    this.jsw = null;
    this.tipDialog = null;
    this.jtC = null;
    this.jtF = 0.0F;
    this.jtG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20961);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramAnonymousView.getId() == 2131301089) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
          QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20961);
      }
    };
    this.jtH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20962);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramAnonymousView.getId() == 2131301091) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null))
        {
          QrcodeInvoiceUI.this.showPopupWindow(paramAnonymousView);
          QrcodeInvoiceUI.d(QrcodeInvoiceUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20962);
      }
    };
    AppMethodBeat.o(20963);
  }
  
  public int getLayoutId()
  {
    return 2131494898;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20966);
    findViewById(2131303622);
    this.jtu = ((InvoiceQrcodeTextView)findViewById(2131303624));
    if (this.jtu != null) {
      this.jtu.aVd();
    }
    this.jtv = ((InvoiceQrcodeTextView)findViewById(2131303620));
    if (this.jtv != null) {
      this.jtv.aVd();
    }
    this.jtw = ((InvoiceQrcodeTextView)findViewById(2131303623));
    if (this.jtw != null) {
      this.jtw.aVd();
    }
    this.jtx = ((InvoiceQrcodeTextView)findViewById(2131303619));
    if (this.jtx != null) {
      this.jtx.aVd();
    }
    this.jty = ((InvoiceQrcodeTextView)findViewById(2131303621));
    if (this.jty != null) {
      this.jty.aVd();
    }
    this.jtz = ((InvoiceQrcodeTextView)findViewById(2131303617));
    if (this.jtz != null) {
      this.jtz.aVd();
    }
    this.jtA = ((InvoiceQrcodeTextView)findViewById(2131303618));
    if (this.jtA != null) {
      this.jtA.aVd();
    }
    this.jtw.jsS = true;
    this.jtw.jsM = true;
    if (this.jsi != 0)
    {
      this.jsm = ((TextView)findViewById(2131303627));
      this.jsw = com.tencent.mm.plugin.address.a.a.aUS().rv(this.jsi);
      if (this.jsw == null)
      {
        ad.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.jsw != null) && (this.jsw.type != null) && (this.jsw.type.equals("0")))
      {
        this.jsm.setText(getString(2131760396));
        this.jtv.setVisibility(8);
        if ((this.jsw.uJD != null) && (!this.jsw.uJD.equals("")))
        {
          this.jtw.setVisibility(0);
          this.jtw.setValStr(this.jsw.uJD);
          if ((this.jsw.uJJ == null) || (this.jsw.uJJ.equals(""))) {
            break label892;
          }
          this.jtx.setVisibility(0);
          this.jtx.setValStr(this.jsw.uJJ);
          label418:
          if ((this.jsw.uJH == null) || (this.jsw.uJH.equals(""))) {
            break label904;
          }
          this.jty.setVisibility(0);
          this.jty.setValStr(this.jsw.uJH);
          label465:
          if ((this.jsw.uJF == null) || (this.jsw.uJF.equals(""))) {
            break label916;
          }
          this.jtz.setVisibility(0);
          this.jtz.setValStr(this.jsw.uJF);
          label512:
          if ((this.jsw.uJE == null) || (this.jsw.uJE.equals(""))) {
            break label928;
          }
          this.jtA.setVisibility(0);
          this.jtA.setValStr(this.jsw.uJE);
          label559:
          this.jsm.setVisibility(0);
          if (this.jsw != null)
          {
            this.jtu.setValStr(this.jsw.title);
            this.jtv.setValStr(this.jsw.uJC);
          }
          if (this.jtC == null)
          {
            localObject = View.inflate(this, 2131494495, null);
            ((View)localObject).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(20959);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if ((QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
                  QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20959);
              }
            });
            this.jtE = ((View)localObject).findViewById(2131301090);
            this.jtD = ((ImageView)((View)localObject).findViewById(2131301089));
            this.jtC = new o((View)localObject, -1, -1, true);
            this.jtC.setClippingEnabled(false);
            this.jtC.update();
            this.jtC.setBackgroundDrawable(new ColorDrawable(16777215));
            this.jtC.setOnDismissListener(new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(20960);
                QrcodeInvoiceUI.c(QrcodeInvoiceUI.this);
                AppMethodBeat.o(20960);
              }
            });
          }
        }
      }
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20957);
          QrcodeInvoiceUI.this.setResult(0);
          QrcodeInvoiceUI.this.finish();
          AppMethodBeat.o(20957);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755721), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20958);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(QrcodeInvoiceUI.this, AddInvoiceUI.class);
          ((Intent)localObject).putExtra("invoice_id", QrcodeInvoiceUI.a(QrcodeInvoiceUI.this));
          paramAnonymousMenuItem = QrcodeInvoiceUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20958);
          return true;
        }
      }, null, s.b.JbS);
      if ((this.jsw == null) || (this.jsw.uJK == null) || (this.jsw.uJK.equals(""))) {
        break label1059;
      }
      localObject = (ImageView)findViewById(2131301091);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.jtB = com.tencent.mm.bz.a.a.b(this, this.jsw.uJK, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.jtB);
        ((ImageView)localObject).setOnClickListener(this.jtH);
      }
      localObject = findViewById(2131301092);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = (TextView)findViewById(2131303613);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      AppMethodBeat.o(20966);
      return;
      this.jtw.setVisibility(8);
      break;
      label892:
      this.jtx.setVisibility(8);
      break label418;
      label904:
      this.jty.setVisibility(8);
      break label465;
      label916:
      this.jtz.setVisibility(8);
      break label512;
      label928:
      this.jtA.setVisibility(8);
      break label559;
      if ((this.jsw == null) || (this.jsw.type == null) || (!this.jsw.type.equals("1"))) {
        break label559;
      }
      this.jsm.setText(getString(2131760402));
      this.jtu.setVisibility(8);
      this.jtw.setVisibility(8);
      this.jtx.setVisibility(8);
      this.jty.setVisibility(8);
      this.jtz.setVisibility(8);
      this.jtA.setVisibility(8);
      break label559;
      ad.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
      finish();
    }
    label1059:
    Object localObject = (ImageView)findViewById(2131301091);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = findViewById(2131301092);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)findViewById(2131303613);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(20966);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20969);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20969);
      return;
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("karea_result");
        if (!bt.isNullOrNil(str))
        {
          ad.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.jty.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!bt.isNullOrNil(paramIntent))
        {
          ad.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.jty.setValStr(paramIntent);
        }
        AppMethodBeat.o(20969);
        return;
        if (paramInt2 != -1) {
          ad.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20964);
    super.onCreate(paramBundle);
    ad.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
    this.jsi = getIntent().getIntExtra("invoice_id", 0);
    setMMTitle(2131760407);
    AppMethodBeat.o(20964);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20968);
    super.onDestroy();
    AppMethodBeat.o(20968);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20970);
    if (paramInt == 4)
    {
      setResult(0);
      finish();
      AppMethodBeat.o(20970);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(20970);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20965);
    getWindow().setSoftInputMode(3);
    super.onResume();
    initView();
    AppMethodBeat.o(20965);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void showPopupWindow(View paramView)
  {
    AppMethodBeat.i(20967);
    if ((this.jtC != null) && (!this.jtC.isShowing()))
    {
      this.jtC.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.jtC.setFocusable(true);
      this.jtC.setTouchable(true);
      this.jtC.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jtC.setOutsideTouchable(true);
      this.jtE.setVisibility(0);
      this.jtD.setOnClickListener(this.jtG);
      this.jtD.setImageBitmap(this.jtB);
      if (this.jtB == null) {
        break label138;
      }
      ad.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.jtC.update();
      AppMethodBeat.o(20967);
      return;
      label138:
      ad.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */