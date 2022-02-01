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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.w.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private int nld;
  private TextView nlh;
  private com.tencent.mm.plugin.o.a.b nlr;
  private View nmA;
  private float nmB;
  private View.OnClickListener nmC;
  private View.OnClickListener nmD;
  private InvoiceQrcodeTextView nmq;
  private InvoiceQrcodeTextView nmr;
  private InvoiceQrcodeTextView nms;
  private InvoiceQrcodeTextView nmt;
  private InvoiceQrcodeTextView nmu;
  private InvoiceQrcodeTextView nmv;
  private InvoiceQrcodeTextView nmw;
  private Bitmap nmx;
  private r nmy;
  private ImageView nmz;
  private Dialog tipDialog;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(20963);
    this.nld = 0;
    this.nlr = null;
    this.tipDialog = null;
    this.nmy = null;
    this.nmB = 0.0F;
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20961);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((paramAnonymousView.getId() == R.h.dJx) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
          QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20961);
      }
    };
    this.nmD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20962);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((paramAnonymousView.getId() == R.h.dJz) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null))
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
    return R.i.ejh;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20966);
    findViewById(R.h.dRT);
    this.nmq = ((InvoiceQrcodeTextView)findViewById(R.h.dRV));
    if (this.nmq != null) {
      this.nmq.bAC();
    }
    this.nmr = ((InvoiceQrcodeTextView)findViewById(R.h.dRR));
    if (this.nmr != null) {
      this.nmr.bAC();
    }
    this.nms = ((InvoiceQrcodeTextView)findViewById(R.h.dRU));
    if (this.nms != null) {
      this.nms.bAC();
    }
    this.nmt = ((InvoiceQrcodeTextView)findViewById(R.h.dRQ));
    if (this.nmt != null) {
      this.nmt.bAC();
    }
    this.nmu = ((InvoiceQrcodeTextView)findViewById(R.h.dRS));
    if (this.nmu != null) {
      this.nmu.bAC();
    }
    this.nmv = ((InvoiceQrcodeTextView)findViewById(R.h.dRO));
    if (this.nmv != null) {
      this.nmv.bAC();
    }
    this.nmw = ((InvoiceQrcodeTextView)findViewById(R.h.dRP));
    if (this.nmw != null) {
      this.nmw.bAC();
    }
    this.nms.nlN = true;
    this.nms.nlH = true;
    if (this.nld != 0)
    {
      this.nlh = ((TextView)findViewById(R.h.dRX));
      this.nlr = com.tencent.mm.plugin.address.a.a.bAo().ys(this.nld);
      if (this.nlr == null)
      {
        Log.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.nlr != null) && (this.nlr.type != null) && (this.nlr.type.equals("0")))
      {
        this.nlh.setText(getString(R.l.eIk));
        this.nmr.setVisibility(8);
        if ((this.nlr.DNT != null) && (!this.nlr.DNT.equals("")))
        {
          this.nms.setVisibility(0);
          this.nms.setValStr(this.nlr.DNT);
          if ((this.nlr.DNZ == null) || (this.nlr.DNZ.equals(""))) {
            break label905;
          }
          this.nmt.setVisibility(0);
          this.nmt.setValStr(this.nlr.DNZ);
          label428:
          if ((this.nlr.DNX == null) || (this.nlr.DNX.equals(""))) {
            break label917;
          }
          this.nmu.setVisibility(0);
          this.nmu.setValStr(this.nlr.DNX);
          label475:
          if ((this.nlr.DNV == null) || (this.nlr.DNV.equals(""))) {
            break label929;
          }
          this.nmv.setVisibility(0);
          this.nmv.setValStr(this.nlr.DNV);
          label522:
          if ((this.nlr.DNU == null) || (this.nlr.DNU.equals(""))) {
            break label941;
          }
          this.nmw.setVisibility(0);
          this.nmw.setValStr(this.nlr.DNU);
          label569:
          this.nlh.setVisibility(0);
          if (this.nlr != null)
          {
            this.nmq.setValStr(this.nlr.title);
            this.nmr.setValStr(this.nlr.DNS);
          }
          if (this.nmy == null)
          {
            localObject = View.inflate(this, R.i.ehH, null);
            ((View)localObject).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(20959);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if ((QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
                  QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20959);
              }
            });
            this.nmA = ((View)localObject).findViewById(R.h.dJy);
            this.nmz = ((ImageView)((View)localObject).findViewById(R.h.dJx));
            this.nmy = new r((View)localObject, -1, -1, true);
            this.nmy.setClippingEnabled(false);
            this.nmy.update();
            this.nmy.setBackgroundDrawable(new ColorDrawable(16777215));
            this.nmy.setOnDismissListener(new PopupWindow.OnDismissListener()
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
      addTextOptionMenu(0, getString(R.l.app_edit), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20958);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(QrcodeInvoiceUI.this, AddInvoiceUI.class);
          ((Intent)localObject).putExtra("invoice_id", QrcodeInvoiceUI.a(QrcodeInvoiceUI.this));
          paramAnonymousMenuItem = QrcodeInvoiceUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20958);
          return true;
        }
      }, null, w.b.Wao);
      if ((this.nlr == null) || (this.nlr.DOa == null) || (this.nlr.DOa.equals(""))) {
        break label1072;
      }
      localObject = (ImageView)findViewById(R.h.dJz);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.nmx = com.tencent.mm.cf.a.a.c(this, this.nlr.DOa, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.nmx);
        ((ImageView)localObject).setOnClickListener(this.nmD);
      }
      localObject = findViewById(R.h.dJA);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = (TextView)findViewById(R.h.dRN);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      AppMethodBeat.o(20966);
      return;
      this.nms.setVisibility(8);
      break;
      label905:
      this.nmt.setVisibility(8);
      break label428;
      label917:
      this.nmu.setVisibility(8);
      break label475;
      label929:
      this.nmv.setVisibility(8);
      break label522;
      label941:
      this.nmw.setVisibility(8);
      break label569;
      if ((this.nlr == null) || (this.nlr.type == null) || (!this.nlr.type.equals("1"))) {
        break label569;
      }
      this.nlh.setText(getString(R.l.eIm));
      this.nmq.setVisibility(8);
      this.nms.setVisibility(8);
      this.nmt.setVisibility(8);
      this.nmu.setVisibility(8);
      this.nmv.setVisibility(8);
      this.nmw.setVisibility(8);
      break label569;
      Log.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
      finish();
    }
    label1072:
    Object localObject = (ImageView)findViewById(R.h.dJz);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = findViewById(R.h.dJA);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)findViewById(R.h.dRN);
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
        if (!Util.isNullOrNil(str))
        {
          Log.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.nmu.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.nmu.setValStr(paramIntent);
        }
        AppMethodBeat.o(20969);
        return;
        if (paramInt2 != -1) {
          Log.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20964);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
    this.nld = getIntent().getIntExtra("invoice_id", 0);
    setMMTitle(R.l.eIo);
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
    if ((this.nmy != null) && (!this.nmy.isShowing()))
    {
      this.nmy.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.nmy.setFocusable(true);
      this.nmy.setTouchable(true);
      this.nmy.setBackgroundDrawable(new ColorDrawable(16777215));
      this.nmy.setOutsideTouchable(true);
      this.nmA.setVisibility(0);
      this.nmz.setOnClickListener(this.nmC);
      this.nmz.setImageBitmap(this.nmx);
      if (this.nmx == null) {
        break label138;
      }
      Log.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.nmy.update();
      AppMethodBeat.o(20967);
      return;
      label138:
      Log.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */