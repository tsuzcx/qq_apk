package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.y.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private com.tencent.mm.plugin.o.a.b qiA;
  private int qim;
  private TextView qiq;
  private InvoiceQrcodeTextView qjA;
  private InvoiceQrcodeTextView qjB;
  private InvoiceQrcodeTextView qjC;
  private InvoiceQrcodeTextView qjD;
  private InvoiceQrcodeTextView qjE;
  private InvoiceQrcodeTextView qjF;
  private Bitmap qjG;
  private v qjH;
  private ImageView qjI;
  private View qjJ;
  private float qjK;
  private View.OnClickListener qjL;
  private View.OnClickListener qjM;
  private InvoiceQrcodeTextView qjz;
  private Dialog tipDialog;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(20963);
    this.qim = 0;
    this.qiA = null;
    this.tipDialog = null;
    this.qjH = null;
    this.qjK = 0.0F;
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20961);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getId() == R.h.fKR) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
          QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20961);
      }
    };
    this.qjM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20962);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getId() == R.h.fKT) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null))
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
    return R.i.gmi;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20966);
    findViewById(R.h.fTT);
    this.qjz = ((InvoiceQrcodeTextView)findViewById(R.h.fTV));
    if (this.qjz != null) {
      this.qjz.bZs();
    }
    this.qjA = ((InvoiceQrcodeTextView)findViewById(R.h.fTR));
    if (this.qjA != null) {
      this.qjA.bZs();
    }
    this.qjB = ((InvoiceQrcodeTextView)findViewById(R.h.fTU));
    if (this.qjB != null) {
      this.qjB.bZs();
    }
    this.qjC = ((InvoiceQrcodeTextView)findViewById(R.h.fTQ));
    if (this.qjC != null) {
      this.qjC.bZs();
    }
    this.qjD = ((InvoiceQrcodeTextView)findViewById(R.h.fTS));
    if (this.qjD != null) {
      this.qjD.bZs();
    }
    this.qjE = ((InvoiceQrcodeTextView)findViewById(R.h.fTO));
    if (this.qjE != null) {
      this.qjE.bZs();
    }
    this.qjF = ((InvoiceQrcodeTextView)findViewById(R.h.fTP));
    if (this.qjF != null) {
      this.qjF.bZs();
    }
    this.qjB.qiW = true;
    this.qjB.qiQ = true;
    if (this.qim != 0)
    {
      this.qiq = ((TextView)findViewById(R.h.fTX));
      this.qiA = com.tencent.mm.plugin.address.a.a.bZf().yy(this.qim);
      if (this.qiA == null)
      {
        Log.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.qiA != null) && (this.qiA.type != null) && (this.qiA.type.equals("0")))
      {
        this.qiq.setText(getString(R.l.gJR));
        this.qjA.setVisibility(8);
        if ((this.qiA.JFi != null) && (!this.qiA.JFi.equals("")))
        {
          this.qjB.setVisibility(0);
          this.qjB.setValStr(this.qiA.JFi);
          if ((this.qiA.JFo == null) || (this.qiA.JFo.equals(""))) {
            break label905;
          }
          this.qjC.setVisibility(0);
          this.qjC.setValStr(this.qiA.JFo);
          label428:
          if ((this.qiA.JFm == null) || (this.qiA.JFm.equals(""))) {
            break label917;
          }
          this.qjD.setVisibility(0);
          this.qjD.setValStr(this.qiA.JFm);
          label475:
          if ((this.qiA.JFk == null) || (this.qiA.JFk.equals(""))) {
            break label929;
          }
          this.qjE.setVisibility(0);
          this.qjE.setValStr(this.qiA.JFk);
          label522:
          if ((this.qiA.JFj == null) || (this.qiA.JFj.equals(""))) {
            break label941;
          }
          this.qjF.setVisibility(0);
          this.qjF.setValStr(this.qiA.JFj);
          label569:
          this.qiq.setVisibility(0);
          if (this.qiA != null)
          {
            this.qjz.setValStr(this.qiA.title);
            this.qjA.setValStr(this.qiA.JFh);
          }
          if (this.qjH == null)
          {
            localObject = View.inflate(this, R.i.gkC, null);
            ((View)localObject).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(20959);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if ((QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
                  QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20959);
              }
            });
            this.qjJ = ((View)localObject).findViewById(R.h.fKS);
            this.qjI = ((ImageView)((View)localObject).findViewById(R.h.fKR));
            this.qjH = new v((View)localObject, -1, -1, true);
            this.qjH.setClippingEnabled(false);
            this.qjH.update();
            this.qjH.setBackgroundDrawable(new ColorDrawable(16777215));
            this.qjH.setOnDismissListener(new PopupWindow.OnDismissListener()
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20958);
          return true;
        }
      }, null, y.b.adEJ);
      if ((this.qiA == null) || (this.qiA.JFp == null) || (this.qiA.JFp.equals(""))) {
        break label1072;
      }
      localObject = (ImageView)findViewById(R.h.fKT);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.qjG = com.tencent.mm.bz.a.a.d(this, this.qiA.JFp, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.qjG);
        ((ImageView)localObject).setOnClickListener(this.qjM);
      }
      localObject = findViewById(R.h.fKU);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = (TextView)findViewById(R.h.fTN);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      AppMethodBeat.o(20966);
      return;
      this.qjB.setVisibility(8);
      break;
      label905:
      this.qjC.setVisibility(8);
      break label428;
      label917:
      this.qjD.setVisibility(8);
      break label475;
      label929:
      this.qjE.setVisibility(8);
      break label522;
      label941:
      this.qjF.setVisibility(8);
      break label569;
      if ((this.qiA == null) || (this.qiA.type == null) || (!this.qiA.type.equals("1"))) {
        break label569;
      }
      this.qiq.setText(getString(R.l.gJT));
      this.qjz.setVisibility(8);
      this.qjB.setVisibility(8);
      this.qjC.setVisibility(8);
      this.qjD.setVisibility(8);
      this.qjE.setVisibility(8);
      this.qjF.setVisibility(8);
      break label569;
      Log.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
      finish();
    }
    label1072:
    Object localObject = (ImageView)findViewById(R.h.fKT);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = findViewById(R.h.fKU);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)findViewById(R.h.fTN);
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
          this.qjD.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.qjD.setValStr(paramIntent);
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
    this.qim = getIntent().getIntExtra("invoice_id", 0);
    setMMTitle(R.l.gJV);
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
    if ((this.qjH != null) && (!this.qjH.isShowing()))
    {
      this.qjH.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.qjH.setFocusable(true);
      this.qjH.setTouchable(true);
      this.qjH.setBackgroundDrawable(new ColorDrawable(16777215));
      this.qjH.setOutsideTouchable(true);
      this.qjJ.setVisibility(0);
      this.qjI.setOnClickListener(this.qjL);
      this.qjI.setImageBitmap(this.qjG);
      if (this.qjG == null) {
        break label138;
      }
      Log.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.qjH.update();
      AppMethodBeat.o(20967);
      return;
      label138:
      Log.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */