package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.r.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private InvoiceQrcodeTextView iAk;
  private InvoiceQrcodeTextView iAl;
  private InvoiceQrcodeTextView iAm;
  private InvoiceQrcodeTextView iAn;
  private InvoiceQrcodeTextView iAo;
  private InvoiceQrcodeTextView iAp;
  private InvoiceQrcodeTextView iAq;
  private Bitmap iAr;
  private o iAs;
  private ImageView iAt;
  private View iAu;
  private float iAv;
  private View.OnClickListener iAw;
  private View.OnClickListener iAx;
  private int iyW;
  private TextView iza;
  private b izk;
  private Dialog tipDialog;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(20963);
    this.iyW = 0;
    this.izk = null;
    this.tipDialog = null;
    this.iAs = null;
    this.iAv = 0.0F;
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20961);
        if ((paramAnonymousView.getId() == 2131301089) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
          QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
        }
        AppMethodBeat.o(20961);
      }
    };
    this.iAx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20962);
        if ((paramAnonymousView.getId() == 2131301091) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null))
        {
          QrcodeInvoiceUI.this.showPopupWindow(paramAnonymousView);
          QrcodeInvoiceUI.d(QrcodeInvoiceUI.this);
        }
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
    this.iAk = ((InvoiceQrcodeTextView)findViewById(2131303624));
    if (this.iAk != null) {
      this.iAk.aLa();
    }
    this.iAl = ((InvoiceQrcodeTextView)findViewById(2131303620));
    if (this.iAl != null) {
      this.iAl.aLa();
    }
    this.iAm = ((InvoiceQrcodeTextView)findViewById(2131303623));
    if (this.iAm != null) {
      this.iAm.aLa();
    }
    this.iAn = ((InvoiceQrcodeTextView)findViewById(2131303619));
    if (this.iAn != null) {
      this.iAn.aLa();
    }
    this.iAo = ((InvoiceQrcodeTextView)findViewById(2131303621));
    if (this.iAo != null) {
      this.iAo.aLa();
    }
    this.iAp = ((InvoiceQrcodeTextView)findViewById(2131303617));
    if (this.iAp != null) {
      this.iAp.aLa();
    }
    this.iAq = ((InvoiceQrcodeTextView)findViewById(2131303618));
    if (this.iAq != null) {
      this.iAq.aLa();
    }
    this.iAm.izG = true;
    this.iAm.izA = true;
    if (this.iyW != 0)
    {
      this.iza = ((TextView)findViewById(2131303627));
      this.izk = com.tencent.mm.plugin.address.a.a.aKP().qi(this.iyW);
      if (this.izk == null)
      {
        ad.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.izk != null) && (this.izk.type != null) && (this.izk.type.equals("0")))
      {
        this.iza.setText(getString(2131760396));
        this.iAl.setVisibility(8);
        if ((this.izk.szg != null) && (!this.izk.szg.equals("")))
        {
          this.iAm.setVisibility(0);
          this.iAm.setValStr(this.izk.szg);
          if ((this.izk.szm == null) || (this.izk.szm.equals(""))) {
            break label892;
          }
          this.iAn.setVisibility(0);
          this.iAn.setValStr(this.izk.szm);
          label418:
          if ((this.izk.szk == null) || (this.izk.szk.equals(""))) {
            break label904;
          }
          this.iAo.setVisibility(0);
          this.iAo.setValStr(this.izk.szk);
          label465:
          if ((this.izk.szi == null) || (this.izk.szi.equals(""))) {
            break label916;
          }
          this.iAp.setVisibility(0);
          this.iAp.setValStr(this.izk.szi);
          label512:
          if ((this.izk.szh == null) || (this.izk.szh.equals(""))) {
            break label928;
          }
          this.iAq.setVisibility(0);
          this.iAq.setValStr(this.izk.szh);
          label559:
          this.iza.setVisibility(0);
          if (this.izk != null)
          {
            this.iAk.setValStr(this.izk.title);
            this.iAl.setValStr(this.izk.szf);
          }
          if (this.iAs == null)
          {
            localObject = View.inflate(this, 2131494495, null);
            ((View)localObject).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(20959);
                if ((QrcodeInvoiceUI.b(QrcodeInvoiceUI.this) != null) && (QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).isShowing())) {
                  QrcodeInvoiceUI.b(QrcodeInvoiceUI.this).dismiss();
                }
                AppMethodBeat.o(20959);
              }
            });
            this.iAu = ((View)localObject).findViewById(2131301090);
            this.iAt = ((ImageView)((View)localObject).findViewById(2131301089));
            this.iAs = new o((View)localObject, -1, -1, true);
            this.iAs.setClippingEnabled(false);
            this.iAs.update();
            this.iAs.setBackgroundDrawable(new ColorDrawable(16777215));
            this.iAs.setOnDismissListener(new PopupWindow.OnDismissListener()
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
      setBackBtn(new QrcodeInvoiceUI.1(this));
      addTextOptionMenu(0, getString(2131755721), new QrcodeInvoiceUI.2(this), null, r.b.FOB);
      if ((this.izk == null) || (this.izk.szn == null) || (this.izk.szn.equals(""))) {
        break label1059;
      }
      localObject = (ImageView)findViewById(2131301091);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.iAr = com.tencent.mm.bz.a.a.b(this, this.izk.szn, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.iAr);
        ((ImageView)localObject).setOnClickListener(this.iAx);
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
      this.iAm.setVisibility(8);
      break;
      label892:
      this.iAn.setVisibility(8);
      break label418;
      label904:
      this.iAo.setVisibility(8);
      break label465;
      label916:
      this.iAp.setVisibility(8);
      break label512;
      label928:
      this.iAq.setVisibility(8);
      break label559;
      if ((this.izk == null) || (this.izk.type == null) || (!this.izk.type.equals("1"))) {
        break label559;
      }
      this.iza.setText(getString(2131760402));
      this.iAk.setVisibility(8);
      this.iAm.setVisibility(8);
      this.iAn.setVisibility(8);
      this.iAo.setVisibility(8);
      this.iAp.setVisibility(8);
      this.iAq.setVisibility(8);
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
          this.iAo.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!bt.isNullOrNil(paramIntent))
        {
          ad.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.iAo.setValStr(paramIntent);
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
    this.iyW = getIntent().getIntExtra("invoice_id", 0);
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
    if ((this.iAs != null) && (!this.iAs.isShowing()))
    {
      this.iAs.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.iAs.setFocusable(true);
      this.iAs.setTouchable(true);
      this.iAs.setBackgroundDrawable(new ColorDrawable(16777215));
      this.iAs.setOutsideTouchable(true);
      this.iAu.setVisibility(0);
      this.iAt.setOnClickListener(this.iAw);
      this.iAt.setImageBitmap(this.iAr);
      if (this.iAr == null) {
        break label138;
      }
      ad.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.iAs.update();
      AppMethodBeat.o(20967);
      return;
      label138:
      ad.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */