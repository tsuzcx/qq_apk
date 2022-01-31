package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private int ftK = 0;
  private TextView ftO;
  private b ftY = null;
  private Dialog ftk = null;
  private InvoiceQrcodeTextView fuX;
  private InvoiceQrcodeTextView fuY;
  private InvoiceQrcodeTextView fuZ;
  private InvoiceQrcodeTextView fva;
  private InvoiceQrcodeTextView fvb;
  private InvoiceQrcodeTextView fvc;
  private InvoiceQrcodeTextView fvd;
  private Bitmap fve;
  private o fvf = null;
  private ImageView fvg;
  private View fvh;
  private float fvi = 0.0F;
  private View.OnClickListener fvj = new QrcodeInvoiceUI.5(this);
  private View.OnClickListener fvk = new QrcodeInvoiceUI.6(this);
  
  protected final int getLayoutId()
  {
    return R.i.mm_qrcode_invoice_ui;
  }
  
  public final void initView()
  {
    findViewById(R.h.qrcode_invoice_sv);
    this.fuX = ((InvoiceQrcodeTextView)findViewById(R.h.qrcode_invoice_title));
    if (this.fuX != null) {
      this.fuX.YO();
    }
    this.fuY = ((InvoiceQrcodeTextView)findViewById(R.h.qrcode_invoice_person_title));
    if (this.fuY != null) {
      this.fuY.YO();
    }
    this.fuZ = ((InvoiceQrcodeTextView)findViewById(R.h.qrcode_invoice_tax_number));
    if (this.fuZ != null) {
      this.fuZ.YO();
    }
    this.fva = ((InvoiceQrcodeTextView)findViewById(R.h.qrcode_invoice_company_address));
    if (this.fva != null) {
      this.fva.YO();
    }
    this.fvb = ((InvoiceQrcodeTextView)findViewById(R.h.qrcode_invoice_phone_number));
    if (this.fvb != null) {
      this.fvb.YO();
    }
    this.fvc = ((InvoiceQrcodeTextView)findViewById(R.h.qrcode_invoice_bank_name));
    if (this.fvc != null) {
      this.fvc.YO();
    }
    this.fvd = ((InvoiceQrcodeTextView)findViewById(R.h.qrcode_invoice_bank_number));
    if (this.fvd != null) {
      this.fvd.YO();
    }
    this.fuZ.fuw = true;
    this.fuZ.fup = true;
    label422:
    label469:
    Object localObject;
    if (this.ftK != 0)
    {
      this.ftO = ((TextView)findViewById(R.h.qrcode_type_tv));
      this.ftY = com.tencent.mm.plugin.address.a.a.YC().kf(this.ftK);
      if (this.ftY == null)
      {
        y.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.ftY != null) && (this.ftY.type != null) && (this.ftY.type.equals("0")))
      {
        this.ftO.setText(getString(R.l.invoice_company_type_title));
        this.fuY.setVisibility(8);
        if ((this.ftY.lnR != null) && (!this.ftY.lnR.equals("")))
        {
          this.fuZ.setVisibility(0);
          this.fuZ.setValStr(this.ftY.lnR);
          if ((this.ftY.lnX == null) || (this.ftY.lnX.equals(""))) {
            break label892;
          }
          this.fva.setVisibility(0);
          this.fva.setValStr(this.ftY.lnX);
          if ((this.ftY.lnV == null) || (this.ftY.lnV.equals(""))) {
            break label904;
          }
          this.fvb.setVisibility(0);
          this.fvb.setValStr(this.ftY.lnV);
          if ((this.ftY.lnT == null) || (this.ftY.lnT.equals(""))) {
            break label916;
          }
          this.fvc.setVisibility(0);
          this.fvc.setValStr(this.ftY.lnT);
          label516:
          if ((this.ftY.lnS == null) || (this.ftY.lnS.equals(""))) {
            break label928;
          }
          this.fvd.setVisibility(0);
          this.fvd.setValStr(this.ftY.lnS);
          label563:
          this.ftO.setVisibility(0);
          if (this.ftY != null)
          {
            this.fuX.setValStr(this.ftY.title);
            this.fuY.setValStr(this.ftY.lnQ);
          }
          if (this.fvf == null)
          {
            localObject = View.inflate(this, R.i.invoice_popup_window, null);
            ((View)localObject).setOnClickListener(new QrcodeInvoiceUI.3(this));
            this.fvh = ((View)localObject).findViewById(R.h.invoice_popup_qrcode_layout);
            this.fvg = ((ImageView)((View)localObject).findViewById(R.h.invoice_popup_qrcode_iv));
            this.fvf = new o((View)localObject, -1, -1, true);
            this.fvf.setClippingEnabled(false);
            this.fvf.update();
            this.fvf.setBackgroundDrawable(new ColorDrawable(16777215));
            this.fvf.setOnDismissListener(new PopupWindow.OnDismissListener()
            {
              public final void onDismiss()
              {
                QrcodeInvoiceUI.c(QrcodeInvoiceUI.this);
              }
            });
          }
          label721:
          setBackBtn(new QrcodeInvoiceUI.1(this));
          a(0, getString(R.l.app_edit), new QrcodeInvoiceUI.2(this), s.b.uNx);
          if ((this.ftY == null) || (this.ftY.lnY == null) || (this.ftY.lnY.equals(""))) {
            break label1059;
          }
          localObject = (ImageView)findViewById(R.h.invoice_qrcode_bar_area);
          if (localObject != null)
          {
            ((ImageView)localObject).setVisibility(0);
            this.fve = com.tencent.mm.by.a.a.b(this, this.ftY.lnY, 12, 3);
            ((ImageView)localObject).setImageBitmap(this.fve);
            ((ImageView)localObject).setOnClickListener(this.fvk);
          }
          localObject = findViewById(R.h.invoice_qrcode_line);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          localObject = (TextView)findViewById(R.h.qrcode_bitmap_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
      }
    }
    label892:
    do
    {
      return;
      this.fuZ.setVisibility(8);
      break;
      this.fva.setVisibility(8);
      break label422;
      this.fvb.setVisibility(8);
      break label469;
      this.fvc.setVisibility(8);
      break label516;
      this.fvd.setVisibility(8);
      break label563;
      if ((this.ftY == null) || (this.ftY.type == null) || (!this.ftY.type.equals("1"))) {
        break label563;
      }
      this.ftO.setText(getString(R.l.invoice_personal_type_title));
      this.fuX.setVisibility(8);
      this.fuZ.setVisibility(8);
      this.fva.setVisibility(8);
      this.fvb.setVisibility(8);
      this.fvc.setVisibility(8);
      this.fvd.setVisibility(8);
      break label563;
      y.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
      finish();
      break label721;
      localObject = (ImageView)findViewById(R.h.invoice_qrcode_bar_area);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = findViewById(R.h.invoice_qrcode_line);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = (TextView)findViewById(R.h.qrcode_bitmap_tip_tv);
    } while (localObject == null);
    label904:
    label916:
    label928:
    label1059:
    ((TextView)localObject).setVisibility(8);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        String str = paramIntent.getStringExtra("karea_result");
        if (!bk.bl(str))
        {
          y.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:" + str);
          this.fvb.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
      } while (bk.bl(paramIntent));
      y.d("MicroMsg.QrcodeInvoiceUI", "post:" + paramIntent);
      this.fvb.setValStr(paramIntent);
      return;
    } while (paramInt2 == -1);
    y.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
    this.ftK = getIntent().getIntExtra("invoice_id", 0);
    setMMTitle(R.l.invoice_qrcode_title);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      setResult(0);
      finish();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onResume()
  {
    getWindow().setSoftInputMode(3);
    super.onResume();
    initView();
  }
  
  public void showPopupWindow(View paramView)
  {
    if ((this.fvf != null) && (!this.fvf.isShowing()))
    {
      this.fvf.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.fvf.setFocusable(true);
      this.fvf.setTouchable(true);
      this.fvf.setBackgroundDrawable(new ColorDrawable(16777215));
      this.fvf.setOutsideTouchable(true);
      this.fvh.setVisibility(0);
      this.fvg.setOnClickListener(this.fvj);
      this.fvg.setImageBitmap(this.fve);
      if (this.fve == null) {
        break label126;
      }
      y.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.fvf.update();
      return;
      label126:
      y.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */