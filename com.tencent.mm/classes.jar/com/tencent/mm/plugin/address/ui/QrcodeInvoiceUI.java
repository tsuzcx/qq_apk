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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q.b;

public class QrcodeInvoiceUI
  extends MMActivity
{
  private Dialog gKM;
  private b gLA;
  private int gLm;
  private TextView gLq;
  private InvoiceQrcodeTextView gMC;
  private InvoiceQrcodeTextView gMD;
  private InvoiceQrcodeTextView gME;
  private InvoiceQrcodeTextView gMF;
  private InvoiceQrcodeTextView gMG;
  private InvoiceQrcodeTextView gMH;
  private InvoiceQrcodeTextView gMI;
  private Bitmap gMJ;
  private o gMK;
  private ImageView gML;
  private View gMM;
  private float gMN;
  private View.OnClickListener gMO;
  private View.OnClickListener gMP;
  
  public QrcodeInvoiceUI()
  {
    AppMethodBeat.i(16918);
    this.gLm = 0;
    this.gLA = null;
    this.gKM = null;
    this.gMK = null;
    this.gMN = 0.0F;
    this.gMO = new QrcodeInvoiceUI.5(this);
    this.gMP = new QrcodeInvoiceUI.6(this);
    AppMethodBeat.o(16918);
  }
  
  public int getLayoutId()
  {
    return 2130970268;
  }
  
  public void initView()
  {
    AppMethodBeat.i(16922);
    findViewById(2131826265);
    this.gMC = ((InvoiceQrcodeTextView)findViewById(2131826267));
    if (this.gMC != null) {
      this.gMC.asy();
    }
    this.gMD = ((InvoiceQrcodeTextView)findViewById(2131826268));
    if (this.gMD != null) {
      this.gMD.asy();
    }
    this.gME = ((InvoiceQrcodeTextView)findViewById(2131826269));
    if (this.gME != null) {
      this.gME.asy();
    }
    this.gMF = ((InvoiceQrcodeTextView)findViewById(2131826270));
    if (this.gMF != null) {
      this.gMF.asy();
    }
    this.gMG = ((InvoiceQrcodeTextView)findViewById(2131826271));
    if (this.gMG != null) {
      this.gMG.asy();
    }
    this.gMH = ((InvoiceQrcodeTextView)findViewById(2131826272));
    if (this.gMH != null) {
      this.gMH.asy();
    }
    this.gMI = ((InvoiceQrcodeTextView)findViewById(2131826273));
    if (this.gMI != null) {
      this.gMI.asy();
    }
    this.gME.gLY = true;
    this.gME.gLR = true;
    if (this.gLm != 0)
    {
      this.gLq = ((TextView)findViewById(2131826266));
      this.gLA = com.tencent.mm.plugin.address.a.a.asm().mZ(this.gLm);
      if (this.gLA == null)
      {
        ab.i("MicroMsg.QrcodeInvoiceUI", "invoiceSvrObj is null ,now finish..");
        finish();
      }
      if ((this.gLA != null) && (this.gLA.type != null) && (this.gLA.type.equals("0")))
      {
        this.gLq.setText(getString(2131300795));
        this.gMD.setVisibility(8);
        if ((this.gLA.nLo != null) && (!this.gLA.nLo.equals("")))
        {
          this.gME.setVisibility(0);
          this.gME.setValStr(this.gLA.nLo);
          if ((this.gLA.nLu == null) || (this.gLA.nLu.equals(""))) {
            break label892;
          }
          this.gMF.setVisibility(0);
          this.gMF.setValStr(this.gLA.nLu);
          label418:
          if ((this.gLA.nLs == null) || (this.gLA.nLs.equals(""))) {
            break label904;
          }
          this.gMG.setVisibility(0);
          this.gMG.setValStr(this.gLA.nLs);
          label465:
          if ((this.gLA.nLq == null) || (this.gLA.nLq.equals(""))) {
            break label916;
          }
          this.gMH.setVisibility(0);
          this.gMH.setValStr(this.gLA.nLq);
          label512:
          if ((this.gLA.nLp == null) || (this.gLA.nLp.equals(""))) {
            break label928;
          }
          this.gMI.setVisibility(0);
          this.gMI.setValStr(this.gLA.nLp);
          label559:
          this.gLq.setVisibility(0);
          if (this.gLA != null)
          {
            this.gMC.setValStr(this.gLA.title);
            this.gMD.setValStr(this.gLA.nLn);
          }
          if (this.gMK == null)
          {
            localObject = View.inflate(this, 2130969917, null);
            ((View)localObject).setOnClickListener(new QrcodeInvoiceUI.3(this));
            this.gMM = ((View)localObject).findViewById(2131825165);
            this.gML = ((ImageView)((View)localObject).findViewById(2131825166));
            this.gMK = new o((View)localObject, -1, -1, true);
            this.gMK.setClippingEnabled(false);
            this.gMK.update();
            this.gMK.setBackgroundDrawable(new ColorDrawable(16777215));
            this.gMK.setOnDismissListener(new QrcodeInvoiceUI.4(this));
          }
        }
      }
    }
    for (;;)
    {
      setBackBtn(new QrcodeInvoiceUI.1(this));
      addTextOptionMenu(0, getString(2131296914), new QrcodeInvoiceUI.2(this), null, q.b.zby);
      if ((this.gLA == null) || (this.gLA.nLv == null) || (this.gLA.nLv.equals(""))) {
        break label1059;
      }
      localObject = (ImageView)findViewById(2131826275);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        this.gMJ = com.tencent.mm.by.a.a.b(this, this.gLA.nLv, 12, 3);
        ((ImageView)localObject).setImageBitmap(this.gMJ);
        ((ImageView)localObject).setOnClickListener(this.gMP);
      }
      localObject = findViewById(2131826274);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = (TextView)findViewById(2131826276);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      AppMethodBeat.o(16922);
      return;
      this.gME.setVisibility(8);
      break;
      label892:
      this.gMF.setVisibility(8);
      break label418;
      label904:
      this.gMG.setVisibility(8);
      break label465;
      label916:
      this.gMH.setVisibility(8);
      break label512;
      label928:
      this.gMI.setVisibility(8);
      break label559;
      if ((this.gLA == null) || (this.gLA.type == null) || (!this.gLA.type.equals("1"))) {
        break label559;
      }
      this.gLq.setText(getString(2131300801));
      this.gMC.setVisibility(8);
      this.gME.setVisibility(8);
      this.gMF.setVisibility(8);
      this.gMG.setVisibility(8);
      this.gMH.setVisibility(8);
      this.gMI.setVisibility(8);
      break label559;
      ab.i("MicroMsg.QrcodeInvoiceUI", "serverId is 0,now finish...");
      finish();
    }
    label1059:
    Object localObject = (ImageView)findViewById(2131826275);
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = findViewById(2131826274);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = (TextView)findViewById(2131826276);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(16922);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(16925);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(16925);
      return;
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("karea_result");
        if (!bo.isNullOrNil(str))
        {
          ab.d("MicroMsg.QrcodeInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.gMG.setValStr(str);
        }
        paramIntent = paramIntent.getStringExtra("kpost_code");
        if (!bo.isNullOrNil(paramIntent))
        {
          ab.d("MicroMsg.QrcodeInvoiceUI", "post:".concat(String.valueOf(paramIntent)));
          this.gMG.setValStr(paramIntent);
        }
        AppMethodBeat.o(16925);
        return;
        if (paramInt2 != -1) {
          ab.i("MicroMsg.QrcodeInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(16919);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.QrcodeInvoiceUI", "index Oncreate");
    this.gLm = getIntent().getIntExtra("invoice_id", 0);
    setMMTitle(2131300806);
    AppMethodBeat.o(16919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(16924);
    super.onDestroy();
    AppMethodBeat.o(16924);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(16926);
    if (paramInt == 4)
    {
      setResult(0);
      finish();
      AppMethodBeat.o(16926);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(16926);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(16920);
    getWindow().setSoftInputMode(3);
    super.onResume();
    initView();
    AppMethodBeat.o(16920);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void showPopupWindow(View paramView)
  {
    AppMethodBeat.i(16923);
    if ((this.gMK != null) && (!this.gMK.isShowing()))
    {
      this.gMK.showAtLocation(paramView.getRootView(), 17, 0, 0);
      this.gMK.setFocusable(true);
      this.gMK.setTouchable(true);
      this.gMK.setBackgroundDrawable(new ColorDrawable(16777215));
      this.gMK.setOutsideTouchable(true);
      this.gMM.setVisibility(0);
      this.gML.setOnClickListener(this.gMO);
      this.gML.setImageBitmap(this.gMJ);
      if (this.gMJ == null) {
        break label138;
      }
      ab.e("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp != null");
    }
    for (;;)
    {
      this.gMK.update();
      AppMethodBeat.o(16923);
      return;
      label138:
      ab.i("MicroMsg.QrcodeInvoiceUI", "updatePopWindowContent mQRCodeBmp == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.QrcodeInvoiceUI
 * JD-Core Version:    0.7.0.1
 */