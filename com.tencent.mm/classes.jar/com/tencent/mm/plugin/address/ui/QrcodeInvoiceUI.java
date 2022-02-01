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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.t.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private com.tencent.mm.plugin.j.a.b ktD;
  private int ktp;
  private TextView ktt;
  private InvoiceQrcodeTextView kuC;
  private InvoiceQrcodeTextView kuD;
  private InvoiceQrcodeTextView kuE;
  private InvoiceQrcodeTextView kuF;
  private InvoiceQrcodeTextView kuG;
  private InvoiceQrcodeTextView kuH;
  private InvoiceQrcodeTextView kuI;
  private Bitmap kuJ;
  private p kuK;
  private ImageView kuL;
  private View kuM;
  private float kuN;
  private View.OnClickListener kuO;
  private View.OnClickListener kuP;
  private Dialog tipDialog;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(20963);
    this.ktp = 0;
    this.ktD = null;
    this.tipDialog = null;
    this.kuK = null;
    this.kuN = 0.0F;
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20961);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((paramAnonymousView.getId() == 2131302743) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
          QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20961);
      }
    };
    this.kuP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20962);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((paramAnonymousView.getId() == 2131302745) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null))
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
    return 2131495636;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20966);
    findViewById(2131306400);
    this.kuC = ((InvoiceQrcodeTextView)findViewById(2131306402));
    if (this.kuC != null) {
      this.kuC.bqo();
    }
    this.kuD = ((InvoiceQrcodeTextView)findViewById(2131306398));
    if (this.kuD != null) {
      this.kuD.bqo();
    }
    this.kuE = ((InvoiceQrcodeTextView)findViewById(2131306401));
    if (this.kuE != null) {
      this.kuE.bqo();
    }
    this.kuF = ((InvoiceQrcodeTextView)findViewById(2131306397));
    if (this.kuF != null) {
      this.kuF.bqo();
    }
    this.kuG = ((InvoiceQrcodeTextView)findViewById(2131306399));
    if (this.kuG != null) {
      this.kuG.bqo();
    }
    this.kuH = ((InvoiceQrcodeTextView)findViewById(2131306395));
    if (this.kuH != null) {
      this.kuH.bqo();
    }
    this.kuI = ((InvoiceQrcodeTextView)findViewById(2131306396));
    if (this.kuI != null) {
      this.kuI.bqo();
    }
    this.kuE.ktZ = true;
    this.kuE.ktT = true;
    if (this.ktp != 0)
    {
      this.ktt = ((TextView)findViewById(2131306406));
      this.ktD = com.tencent.mm.plugin.address.a.a.bqc().vo(this.ktp);
      if (this.ktD == null)
      {
        Log.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.ktD != null) && (this.ktD.type != null) && (this.ktD.type.equals("0")))
      {
        this.ktt.setText(getString(2131761841));
        this.kuD.setVisibility(8);
        if ((this.ktD.ynR != null) && (!this.ktD.ynR.equals("")))
        {
          this.kuE.setVisibility(0);
          this.kuE.setValStr(this.ktD.ynR);
          if ((this.ktD.ynX == null) || (this.ktD.ynX.equals(""))) {
            break label892;
          }
          this.kuF.setVisibility(0);
          this.kuF.setValStr(this.ktD.ynX);
          label418:
          if ((this.ktD.ynV == null) || (this.ktD.ynV.equals(""))) {
            break label904;
          }
          this.kuG.setVisibility(0);
          this.kuG.setValStr(this.ktD.ynV);
          label465:
          if ((this.ktD.ynT == null) || (this.ktD.ynT.equals(""))) {
            break label916;
          }
          this.kuH.setVisibility(0);
          this.kuH.setValStr(this.ktD.ynT);
          label512:
          if ((this.ktD.ynS == null) || (this.ktD.ynS.equals(""))) {
            break label928;
          }
          this.kuI.setVisibility(0);
          this.kuI.setValStr(this.ktD.ynS);
          label559:
          this.ktt.setVisibility(0);
          if (this.ktD != null)
          {
            this.kuC.setValStr(this.ktD.title);
            this.kuD.setValStr(this.ktD.ynQ);
          }
          if (this.kuK == null)
          {
            localObject = View.inflate(this, 2131495087, null);
            ((View)localObject).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(20959);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if ((QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
                  QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(20959);
              }
            });
            this.kuM = ((View)localObject).findViewById(2131302744);
            this.kuL = ((ImageView)((View)localObject).findViewById(2131302743));
            this.kuK = new p((View)localObject, -1, -1, true);
            this.kuK.setClippingEnabled(false);
            this.kuK.update();
            this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
            this.kuK.setOnDismissListener(new PopupWindow.OnDismissListener()
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
      addTextOptionMenu(0, getString(2131755792), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20958);
          Object localObject = new Intent();
          ((Intent)localObject).setClass(QrcodeInvoiceUI.this, AddInvoiceUI.class);
          ((Intent)localObject).putExtra("invoice_id", QrcodeInvoiceUI.a(QrcodeInvoiceUI.this));
          paramAnonymousMenuItem = QrcodeInvoiceUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/address/ui/QrcodeInvoiceUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20958);
          return true;
        }
      }, null, t.b.OGU);
      if ((this.ktD == null) || (this.ktD.ynY == null) || (this.ktD.ynY.equals(""))) {
        break label1059;
      }
      localObject = (ImageView)findViewById(2131302745);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.kuJ = com.tencent.mm.by.a.a.b(this, this.ktD.ynY, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.kuJ);
        ((ImageView)localObject).setOnClickListener(this.kuP);
      }
      localObject = findViewById(2131302746);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = (TextView)findViewById(2131306391);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      AppMethodBeat.o(20966);
      return;
      this.kuE.setVisibility(8);
      break;
      label892:
      this.kuF.setVisibility(8);
      break label418;
      label904:
      this.kuG.setVisibility(8);
      break label465;
      label916:
      this.kuH.setVisibility(8);
      break label512;
      label928:
      this.kuI.setVisibility(8);
      break label559;
      if ((this.ktD == null) || (this.ktD.type == null) || (!this.ktD.type.equals("1"))) {
        break label559;
      }
      this.ktt.setText(getString(2131761847));
      this.kuC.setVisibility(8);
      this.kuE.setVisibility(8);
      this.kuF.setVisibility(8);
      this.kuG.setVisibility(8);
      this.kuH.setVisibility(8);
      this.kuI.setVisibility(8);
      break label559;
      Log.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
      finish();
    }
    label1059:
    Object localObject = (ImageView)findViewById(2131302745);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = findViewById(2131302746);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)findViewById(2131306391);
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
          this.kuG.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.kuG.setValStr(paramIntent);
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
    this.ktp = getIntent().getIntExtra("invoice_id", 0);
    setMMTitle(2131761852);
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
    if ((this.kuK != null) && (!this.kuK.isShowing()))
    {
      this.kuK.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.kuK.setFocusable(true);
      this.kuK.setTouchable(true);
      this.kuK.setBackgroundDrawable(new ColorDrawable(16777215));
      this.kuK.setOutsideTouchable(true);
      this.kuM.setVisibility(0);
      this.kuL.setOnClickListener(this.kuO);
      this.kuL.setImageBitmap(this.kuJ);
      if (this.kuJ == null) {
        break label138;
      }
      Log.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.kuK.update();
      AppMethodBeat.o(20967);
      return;
      label138:
      Log.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */