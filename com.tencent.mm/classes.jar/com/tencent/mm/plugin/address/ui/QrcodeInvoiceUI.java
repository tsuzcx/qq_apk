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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.s.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private int iYZ;
  private TextView iZd;
  private b iZn;
  private InvoiceQrcodeTextView jal;
  private InvoiceQrcodeTextView jam;
  private InvoiceQrcodeTextView jan;
  private InvoiceQrcodeTextView jao;
  private InvoiceQrcodeTextView jap;
  private InvoiceQrcodeTextView jaq;
  private InvoiceQrcodeTextView jar;
  private Bitmap jas;
  private o jat;
  private ImageView jau;
  private View jav;
  private float jaw;
  private View.OnClickListener jax;
  private View.OnClickListener jay;
  private Dialog tipDialog;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(20963);
    this.iYZ = 0;
    this.iZn = null;
    this.tipDialog = null;
    this.jat = null;
    this.jaw = 0.0F;
    this.jax = new View.OnClickListener()
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
    this.jay = new View.OnClickListener()
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
    this.jal = ((InvoiceQrcodeTextView)findViewById(2131303624));
    if (this.jal != null) {
      this.jal.aRR();
    }
    this.jam = ((InvoiceQrcodeTextView)findViewById(2131303620));
    if (this.jam != null) {
      this.jam.aRR();
    }
    this.jan = ((InvoiceQrcodeTextView)findViewById(2131303623));
    if (this.jan != null) {
      this.jan.aRR();
    }
    this.jao = ((InvoiceQrcodeTextView)findViewById(2131303619));
    if (this.jao != null) {
      this.jao.aRR();
    }
    this.jap = ((InvoiceQrcodeTextView)findViewById(2131303621));
    if (this.jap != null) {
      this.jap.aRR();
    }
    this.jaq = ((InvoiceQrcodeTextView)findViewById(2131303617));
    if (this.jaq != null) {
      this.jaq.aRR();
    }
    this.jar = ((InvoiceQrcodeTextView)findViewById(2131303618));
    if (this.jar != null) {
      this.jar.aRR();
    }
    this.jan.iZJ = true;
    this.jan.iZD = true;
    if (this.iYZ != 0)
    {
      this.iZd = ((TextView)findViewById(2131303627));
      this.iZn = com.tencent.mm.plugin.address.a.a.aRG().qV(this.iYZ);
      if (this.iZn == null)
      {
        ac.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.iZn != null) && (this.iZn.type != null) && (this.iZn.type.equals("0")))
      {
        this.iZd.setText(getString(2131760396));
        this.jam.setVisibility(8);
        if ((this.iZn.tGQ != null) && (!this.iZn.tGQ.equals("")))
        {
          this.jan.setVisibility(0);
          this.jan.setValStr(this.iZn.tGQ);
          if ((this.iZn.tGW == null) || (this.iZn.tGW.equals(""))) {
            break label892;
          }
          this.jao.setVisibility(0);
          this.jao.setValStr(this.iZn.tGW);
          label418:
          if ((this.iZn.tGU == null) || (this.iZn.tGU.equals(""))) {
            break label904;
          }
          this.jap.setVisibility(0);
          this.jap.setValStr(this.iZn.tGU);
          label465:
          if ((this.iZn.tGS == null) || (this.iZn.tGS.equals(""))) {
            break label916;
          }
          this.jaq.setVisibility(0);
          this.jaq.setValStr(this.iZn.tGS);
          label512:
          if ((this.iZn.tGR == null) || (this.iZn.tGR.equals(""))) {
            break label928;
          }
          this.jar.setVisibility(0);
          this.jar.setValStr(this.iZn.tGR);
          label559:
          this.iZd.setVisibility(0);
          if (this.iZn != null)
          {
            this.jal.setValStr(this.iZn.title);
            this.jam.setValStr(this.iZn.tGP);
          }
          if (this.jat == null)
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
            this.jav = ((View)localObject).findViewById(2131301090);
            this.jau = ((ImageView)((View)localObject).findViewById(2131301089));
            this.jat = new o((View)localObject, -1, -1, true);
            this.jat.setClippingEnabled(false);
            this.jat.update();
            this.jat.setBackgroundDrawable(new ColorDrawable(16777215));
            this.jat.setOnDismissListener(new QrcodeInvoiceUI.4(this));
          }
        }
      }
    }
    for (;;)
    {
      setBackBtn(new QrcodeInvoiceUI.1(this));
      addTextOptionMenu(0, getString(2131755721), new QrcodeInvoiceUI.2(this), null, s.b.Hom);
      if ((this.iZn == null) || (this.iZn.tGX == null) || (this.iZn.tGX.equals(""))) {
        break label1059;
      }
      localObject = (ImageView)findViewById(2131301091);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.jas = com.tencent.mm.by.a.a.b(this, this.iZn.tGX, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.jas);
        ((ImageView)localObject).setOnClickListener(this.jay);
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
      this.jan.setVisibility(8);
      break;
      label892:
      this.jao.setVisibility(8);
      break label418;
      label904:
      this.jap.setVisibility(8);
      break label465;
      label916:
      this.jaq.setVisibility(8);
      break label512;
      label928:
      this.jar.setVisibility(8);
      break label559;
      if ((this.iZn == null) || (this.iZn.type == null) || (!this.iZn.type.equals("1"))) {
        break label559;
      }
      this.iZd.setText(getString(2131760402));
      this.jal.setVisibility(8);
      this.jan.setVisibility(8);
      this.jao.setVisibility(8);
      this.jap.setVisibility(8);
      this.jaq.setVisibility(8);
      this.jar.setVisibility(8);
      break label559;
      ac.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
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
        if (!bs.isNullOrNil(str))
        {
          ac.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.jap.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!bs.isNullOrNil(paramIntent))
        {
          ac.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.jap.setValStr(paramIntent);
        }
        AppMethodBeat.o(20969);
        return;
        if (paramInt2 != -1) {
          ac.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20964);
    super.onCreate(paramBundle);
    ac.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
    this.iYZ = getIntent().getIntExtra("invoice_id", 0);
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
    if ((this.jat != null) && (!this.jat.isShowing()))
    {
      this.jat.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.jat.setFocusable(true);
      this.jat.setTouchable(true);
      this.jat.setBackgroundDrawable(new ColorDrawable(16777215));
      this.jat.setOutsideTouchable(true);
      this.jav.setVisibility(0);
      this.jau.setOnClickListener(this.jax);
      this.jau.setImageBitmap(this.jas);
      if (this.jas == null) {
        break label138;
      }
      ac.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.jat.update();
      AppMethodBeat.o(20967);
      return;
      label138:
      ac.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */