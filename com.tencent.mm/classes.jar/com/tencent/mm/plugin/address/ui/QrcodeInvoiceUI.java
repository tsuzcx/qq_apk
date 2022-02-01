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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private int jvb;
  private TextView jvf;
  private com.tencent.mm.plugin.j.a.b jvp;
  private float jwA;
  private View.OnClickListener jwB;
  private View.OnClickListener jwC;
  private InvoiceQrcodeTextView jwp;
  private InvoiceQrcodeTextView jwq;
  private InvoiceQrcodeTextView jwr;
  private InvoiceQrcodeTextView jws;
  private InvoiceQrcodeTextView jwt;
  private InvoiceQrcodeTextView jwu;
  private InvoiceQrcodeTextView jwv;
  private Bitmap jww;
  private o jwx;
  private ImageView jwy;
  private View jwz;
  private Dialog tipDialog;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(20963);
    this.jvb = 0;
    this.jvp = null;
    this.tipDialog = null;
    this.jwx = null;
    this.jwA = 0.0F;
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20961);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((paramAnonymousView.getId() == 2131301089) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
          QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20961);
      }
    };
    this.jwC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20962);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.jwp = ((InvoiceQrcodeTextView)findViewById(2131303624));
    if (this.jwp != null) {
      this.jwp.aVC();
    }
    this.jwq = ((InvoiceQrcodeTextView)findViewById(2131303620));
    if (this.jwq != null) {
      this.jwq.aVC();
    }
    this.jwr = ((InvoiceQrcodeTextView)findViewById(2131303623));
    if (this.jwr != null) {
      this.jwr.aVC();
    }
    this.jws = ((InvoiceQrcodeTextView)findViewById(2131303619));
    if (this.jws != null) {
      this.jws.aVC();
    }
    this.jwt = ((InvoiceQrcodeTextView)findViewById(2131303621));
    if (this.jwt != null) {
      this.jwt.aVC();
    }
    this.jwu = ((InvoiceQrcodeTextView)findViewById(2131303617));
    if (this.jwu != null) {
      this.jwu.aVC();
    }
    this.jwv = ((InvoiceQrcodeTextView)findViewById(2131303618));
    if (this.jwv != null) {
      this.jwv.aVC();
    }
    this.jwr.jvL = true;
    this.jwr.jvF = true;
    if (this.jvb != 0)
    {
      this.jvf = ((TextView)findViewById(2131303627));
      this.jvp = com.tencent.mm.plugin.address.a.a.aVr().ry(this.jvb);
      if (this.jvp == null)
      {
        ae.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.jvp != null) && (this.jvp.type != null) && (this.jvp.type.equals("0")))
      {
        this.jvf.setText(getString(2131760396));
        this.jwq.setVisibility(8);
        if ((this.jvp.uVq != null) && (!this.jvp.uVq.equals("")))
        {
          this.jwr.setVisibility(0);
          this.jwr.setValStr(this.jvp.uVq);
          if ((this.jvp.uVw == null) || (this.jvp.uVw.equals(""))) {
            break label892;
          }
          this.jws.setVisibility(0);
          this.jws.setValStr(this.jvp.uVw);
          label418:
          if ((this.jvp.uVu == null) || (this.jvp.uVu.equals(""))) {
            break label904;
          }
          this.jwt.setVisibility(0);
          this.jwt.setValStr(this.jvp.uVu);
          label465:
          if ((this.jvp.uVs == null) || (this.jvp.uVs.equals(""))) {
            break label916;
          }
          this.jwu.setVisibility(0);
          this.jwu.setValStr(this.jvp.uVs);
          label512:
          if ((this.jvp.uVr == null) || (this.jvp.uVr.equals(""))) {
            break label928;
          }
          this.jwv.setVisibility(0);
          this.jwv.setValStr(this.jvp.uVr);
          label559:
          this.jvf.setVisibility(0);
          if (this.jvp != null)
          {
            this.jwp.setValStr(this.jvp.title);
            this.jwq.setValStr(this.jvp.uVp);
          }
          if (this.jwx == null)
          {
            localObject = View.inflate(this, 2131494495, null);
            ((View)localObject).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(20959);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if ((QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
                  QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20959);
              }
            });
            this.jwz = ((View)localObject).findViewById(2131301090);
            this.jwy = ((ImageView)((View)localObject).findViewById(2131301089));
            this.jwx = new o((View)localObject, -1, -1, true);
            this.jwx.setClippingEnabled(false);
            this.jwx.update();
            this.jwx.setBackgroundDrawable(new ColorDrawable(16777215));
            this.jwx.setOnDismissListener(new PopupWindow.OnDismissListener()
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
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20958);
          return true;
        }
      }, null, s.b.JwA);
      if ((this.jvp == null) || (this.jvp.uVx == null) || (this.jvp.uVx.equals(""))) {
        break label1059;
      }
      localObject = (ImageView)findViewById(2131301091);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.jww = com.tencent.mm.by.a.a.b(this, this.jvp.uVx, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.jww);
        ((ImageView)localObject).setOnClickListener(this.jwC);
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
      this.jwr.setVisibility(8);
      break;
      label892:
      this.jws.setVisibility(8);
      break label418;
      label904:
      this.jwt.setVisibility(8);
      break label465;
      label916:
      this.jwu.setVisibility(8);
      break label512;
      label928:
      this.jwv.setVisibility(8);
      break label559;
      if ((this.jvp == null) || (this.jvp.type == null) || (!this.jvp.type.equals("1"))) {
        break label559;
      }
      this.jvf.setText(getString(2131760402));
      this.jwp.setVisibility(8);
      this.jwr.setVisibility(8);
      this.jws.setVisibility(8);
      this.jwt.setVisibility(8);
      this.jwu.setVisibility(8);
      this.jwv.setVisibility(8);
      break label559;
      ae.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
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
        if (!bu.isNullOrNil(str))
        {
          ae.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.jwt.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!bu.isNullOrNil(paramIntent))
        {
          ae.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.jwt.setValStr(paramIntent);
        }
        AppMethodBeat.o(20969);
        return;
        if (paramInt2 != -1) {
          ae.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20964);
    super.onCreate(paramBundle);
    ae.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
    this.jvb = getIntent().getIntExtra("invoice_id", 0);
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
    if ((this.jwx != null) && (!this.jwx.isShowing()))
    {
      this.jwx.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.jwx.setFocusable(true);
      this.jwx.setTouchable(true);
      this.jwx.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jwx.setOutsideTouchable(true);
      this.jwz.setVisibility(0);
      this.jwy.setOnClickListener(this.jwB);
      this.jwy.setImageBitmap(this.jww);
      if (this.jww == null) {
        break label138;
      }
      ae.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.jwx.update();
      AppMethodBeat.o(20967);
      return;
      label138:
      ae.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */