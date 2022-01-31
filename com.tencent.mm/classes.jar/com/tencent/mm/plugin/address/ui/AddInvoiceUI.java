package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.bms;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements f, InvoiceEditView.c
{
  private int Th = 0;
  private String bWc = "";
  private TextView flb;
  private int ftK = 0;
  private Button ftL = null;
  private Button ftM = null;
  private TextView ftN;
  private TextView ftO;
  private TextView ftP = null;
  private InvoiceEditView ftQ;
  private InvoiceEditView ftR;
  private InvoiceEditView ftS;
  private InvoiceEditView ftT;
  private InvoiceEditView ftU;
  private InvoiceEditView ftV;
  private InvoiceEditView ftW;
  private InvoiceEditView ftX;
  private com.tencent.mm.plugin.o.a.b ftY = null;
  private com.tencent.mm.plugin.o.a.b ftZ = new com.tencent.mm.plugin.o.a.b();
  private Dialog ftk = null;
  private boolean fua = false;
  private boolean fub = false;
  
  private boolean YH()
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.ftM != null) && (this.ftM.isActivated())) || ((this.ftY != null) && (this.ftY.type != null) && (this.ftY.type.equals("0"))))
    {
      this.ftT.setVisibility(0);
      this.ftU.setVisibility(0);
      this.ftV.setVisibility(0);
      this.ftW.setVisibility(0);
      this.ftX.setVisibility(0);
      this.ftR.setVisibility(0);
      this.ftS.setVisibility(8);
      bool1 = bool2;
      if (!this.ftM.isActivated())
      {
        bool1 = bool2;
        if (!this.ftY.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.ftR.YL())
      {
        if (this.ftR.getText().length() > 100) {
          ad(getString(R.l.invoice_title), 100);
        }
        bool1 = false;
      }
      if ((this.ftM == null) || (!this.ftM.isActivated()) || (this.ftR.getText().length() != 0)) {
        break label890;
      }
      bool1 = false;
    }
    label888:
    label890:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.ftT.YL())
      {
        if (this.ftT.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(R.h.viewstub_tax_tips_vs);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.ftN = ((TextView)findViewById(R.h.viewstub_tax_tips_tv));
          }
          if (this.ftN != null) {
            this.ftN.setVisibility(0);
          }
        }
        if (!this.ftU.YL())
        {
          if (this.ftU.getText().length() > 100) {
            ad(getString(R.l.invoice_company_address), 100);
          }
          bool1 = false;
        }
        if (!this.ftV.YL())
        {
          if (this.ftV.getText().length() > 100) {
            ad(getString(R.l.invoice_phone_number), 100);
          }
          bool1 = false;
        }
        if (!this.ftW.YL())
        {
          if (this.ftW.getText().length() > 100) {
            ad(getString(R.l.invoice_bank_name), 100);
          }
          bool1 = false;
        }
        if (this.ftX.YL()) {
          break label888;
        }
        if (this.ftX.getText().length() > 48) {
          ad(getString(R.l.invoice_bank_number), 39);
        }
      }
      do
      {
        return false;
        if (this.ftN == null) {
          break;
        }
        this.ftN.setVisibility(8);
        break;
        if (((this.ftL != null) && (this.ftL.isActivated())) || ((this.ftY != null) && (this.ftY.type != null) && (this.ftY.type.equals("1"))))
        {
          this.ftT.setVisibility(8);
          this.ftU.setVisibility(8);
          this.ftV.setVisibility(8);
          this.ftW.setVisibility(8);
          this.ftX.setVisibility(8);
          this.ftR.setVisibility(8);
          this.ftS.setVisibility(0);
          bool1 = bool3;
          if (!this.ftL.isActivated())
          {
            bool1 = bool3;
            if (!this.ftY.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.ftS.YL())
          {
            if (this.ftS.getText().length() > 100) {
              ad(getString(R.l.invoice_title), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.ftL != null)
          {
            bool2 = bool1;
            if (this.ftL.isActivated())
            {
              bool2 = bool1;
              if (this.ftS.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          return bool2;
        }
        this.ftT.setVisibility(0);
        this.ftU.setVisibility(0);
        this.ftV.setVisibility(0);
        this.ftW.setVisibility(0);
        this.ftX.setVisibility(0);
        this.ftS.setVisibility(8);
        this.ftR.setVisibility(0);
        this.ftS.setVisibility(8);
        bool1 = bool4;
        if (this.ftL != null)
        {
          bool1 = bool4;
          if (!this.ftL.isActivated())
          {
            bool1 = bool4;
            if (this.ftM != null)
            {
              bool1 = bool4;
              if (!this.ftM.isActivated()) {
                bool1 = false;
              }
            }
          }
        }
        if (!this.ftR.YL()) {
          bool1 = false;
        }
        if (!this.ftT.YL()) {
          bool1 = false;
        }
        if (!this.ftU.YL()) {
          bool1 = false;
        }
        if (!this.ftV.YL()) {
          bool1 = false;
        }
        if (!this.ftW.YL()) {
          bool1 = false;
        }
      } while (!this.ftX.YL());
      return bool1;
      return bool1;
    }
  }
  
  private void YJ()
  {
    int k = 1;
    if (((this.ftK != 0) && (this.ftY != null) && (this.ftZ.type != null) && (!this.ftZ.type.equals("")) && (!this.ftZ.type.equals(this.ftY.type))) || ((this.ftK == 0) && (this.ftZ.type != null) && (!this.ftZ.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.ftL != null)
      {
        j = i;
        if (this.ftM != null)
        {
          j = i;
          if (!this.ftL.isActivated())
          {
            j = i;
            if (!this.ftM.isActivated())
            {
              j = i;
              if (this.ftY == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.ftR.YM()) {
        j = 1;
      }
      if (this.ftS.YM()) {
        j = 1;
      }
      if (this.ftT.YM()) {
        j = 1;
      }
      if (this.ftU.YM()) {
        j = 1;
      }
      if (this.ftV.YM()) {
        j = 1;
      }
      if (this.ftW.YM()) {
        j = 1;
      }
      if (this.ftX.YM()) {}
      for (i = k;; i = j)
      {
        if (i != 0)
        {
          h.a(this, false, this.mController.uMN.getString(R.l.invoice_back_modify_tip), "", this.mController.uMN.getString(R.l.invoice_back_modify_confirm_tip), this.mController.uMN.getString(R.l.invoice_back_cancel_tip), new AddInvoiceUI.5(this), null);
          return;
        }
        setResult(0);
        finish();
        return;
      }
    }
  }
  
  private void ad(String paramString, int paramInt)
  {
    h.a(this, getString(R.l.invoice_bytes_limit_error, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(R.l.app_tip), false, null);
  }
  
  public final void YI()
  {
    YH();
  }
  
  public final void YK()
  {
    h.a(this, getString(R.l.invoice_title_limit_error), getString(R.l.app_tip), false, null);
  }
  
  protected final int getLayoutId()
  {
    return R.i.mm_add_invoice_ui;
  }
  
  public final void initView()
  {
    this.Th = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(R.h.invoice_sv);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.ftL = ((Button)findViewById(R.h.invoice_person_btn));
    if (this.ftL != null) {
      this.ftL.setVisibility(0);
    }
    this.ftM = ((Button)findViewById(R.h.invoice_company_btn));
    if (this.ftM != null) {
      this.ftM.setVisibility(0);
    }
    if ((this.ftK == 0) && (this.ftM != null)) {
      this.ftM.setActivated(true);
    }
    if (this.ftM != null) {
      this.ftM.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (paramAnonymousMotionEvent.getAction() == 0) {
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() != 1) {
            return false;
          }
          if (!AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) {
            AddInvoiceUI.a(AddInvoiceUI.this).setActivated(true);
          }
          if (AddInvoiceUI.a(AddInvoiceUI.this).isActivated())
          {
            AddInvoiceUI.b(AddInvoiceUI.this).setActivated(false);
            AddInvoiceUI.c(AddInvoiceUI.this).type = "0";
          }
          AddInvoiceUI.d(AddInvoiceUI.this);
          return true;
        }
      });
    }
    if (this.ftL != null) {
      this.ftL.setOnTouchListener(new AddInvoiceUI.2(this));
    }
    this.ftQ = ((InvoiceEditView)findViewById(R.h.invoice_title_type));
    this.ftR = ((InvoiceEditView)findViewById(R.h.invoice_title));
    this.ftS = ((InvoiceEditView)findViewById(R.h.invoice_person_title));
    this.ftT = ((InvoiceEditView)findViewById(R.h.invoice_tax_number));
    this.ftU = ((InvoiceEditView)findViewById(R.h.invoice_company_address));
    this.ftV = ((InvoiceEditView)findViewById(R.h.invoice_phone_number));
    this.ftW = ((InvoiceEditView)findViewById(R.h.invoice_bank_name));
    this.ftX = ((InvoiceEditView)findViewById(R.h.invoice_bank_number));
    this.ftT.fuw = true;
    this.ftT.fup = true;
    this.ftT.setOnInputValidChangeListener(this);
    this.ftQ.setOnInputValidChangeListener(this);
    this.ftR.setOnInputValidChangeListener(this);
    this.ftS.setOnInputValidChangeListener(this);
    this.ftU.setOnInputValidChangeListener(this);
    this.ftV.setOnInputValidChangeListener(this);
    this.ftW.setOnInputValidChangeListener(this);
    this.ftX.setOnInputValidChangeListener(this);
    if (this.ftK != 0)
    {
      this.flb = ((TextView)findViewById(R.h.tip_tv));
      this.flb.setVisibility(8);
      this.ftO = ((TextView)findViewById(R.h.type_tv));
      this.ftY = com.tencent.mm.plugin.address.a.a.YC().kf(this.ftK);
      if ((this.ftY == null) || (this.ftY.type == null) || (!this.ftY.type.equals("0"))) {
        break label680;
      }
      this.ftO.setText(getString(R.l.invoice_company_type_title));
      this.ftO.setVisibility(0);
      this.ftM.setVisibility(8);
      this.ftL.setVisibility(8);
      if (this.ftY != null)
      {
        this.ftQ.setValStr(this.ftY.type);
        this.ftR.setValStr(this.ftY.title);
        this.ftS.setValStr(this.ftY.lnQ);
        this.ftT.setValStr(this.ftY.lnR);
        this.ftU.setValStr(this.ftY.lnX);
        this.ftV.setValStr(this.ftY.lnV);
        this.ftW.setValStr(this.ftY.lnT);
        this.ftX.setValStr(this.ftY.lnS);
      }
    }
    if ((this.fub) || (this.fua))
    {
      this.ftP = ((TextView)findViewById(R.h.jsapi_tips_tv));
      if (this.ftP != null) {
        this.ftP.setVisibility(0);
      }
    }
    for (;;)
    {
      setBackBtn(new AddInvoiceUI.3(this));
      a(0, getString(R.l.app_save), new AddInvoiceUI.4(this), s.b.uNx);
      enableOptionMenu(false);
      YH();
      return;
      label680:
      if ((this.ftY == null) || (this.ftY.type == null) || (!this.ftY.type.equals("1"))) {
        break;
      }
      this.ftO.setText(getString(R.l.invoice_personal_type_title));
      break;
      this.ftP = ((TextView)findViewById(R.h.jsapi_tips_tv));
      if (this.ftP != null) {
        this.ftP.setVisibility(8);
      }
    }
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
        return;
      } while (paramInt2 != -1);
      String str = paramIntent.getStringExtra("karea_result");
      if (!bk.bl(str))
      {
        y.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:" + str);
        this.ftV.setValStr(str);
      }
      str = paramIntent.getStringExtra("kpost_code");
      if (!bk.bl(str))
      {
        y.d("MicroMsg.AddInvoiceUI", "post:" + str);
        this.ftV.setValStr(str);
      }
      this.bWc = paramIntent.getStringExtra("kwcode");
      return;
    } while (paramInt2 == -1);
    y.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.fua = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.fub = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    au.Dk().a(1191, this);
    y.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.ftZ = new com.tencent.mm.plugin.o.a.b();
    this.ftK = getIntent().getIntExtra("invoice_id", 0);
    if (this.ftK == 0) {
      setMMTitle(R.l.settings_add_invoice);
    }
    for (;;)
    {
      initView();
      return;
      setMMTitle(R.l.settings_modify_invoice);
    }
  }
  
  public void onDestroy()
  {
    au.Dk().b(1180, this);
    au.Dk().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      YJ();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject = null;
    y.i("MicroMsg.AddInvoiceUI", "errType " + paramInt1 + ",errCode " + paramInt2 + ",errMsg " + paramString);
    if (this.ftk != null) {
      this.ftk.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 1180)
      {
        paramString = ((i)paramm).ftn;
        if ((paramString != null) && (paramString.tFY != null) && (paramString.tFY.size() > 0) && (paramString.tFY.get(0) != null)) {
          this.Th = ((aob)paramString.tFY.get(0)).group_id;
        }
        au.Dk().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        au.Dk().a(paramString, 0);
      }
      while (paramm.getType() != 1191) {
        return;
      }
      au.Dk().b(1191, this);
      if (this.fua)
      {
        y.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
        paramm = this.ftZ;
        if (paramm == null)
        {
          y.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
          paramString = localObject;
        }
        for (;;)
        {
          setResult(-1, paramString);
          finish();
          return;
          paramString = new Intent();
          paramString.putExtra("type", paramm.type);
          if ((paramm.type != null) && (paramm.type.equals("1")))
          {
            paramString.putExtra("title", paramm.lnQ);
          }
          else
          {
            paramString.putExtra("title", paramm.title);
            paramString.putExtra("tax_number", paramm.lnR);
            paramString.putExtra("company_address", paramm.lnX);
            paramString.putExtra("telephone", paramm.lnV);
            paramString.putExtra("bank_name", paramm.lnT);
            paramString.putExtra("bank_account", paramm.lnS);
          }
        }
      }
      if ((this.ftK == 0) && (this.Th != 0))
      {
        paramString = new Intent();
        paramString.setClass(this, QrcodeInvoiceUI.class);
        paramString.putExtra("invoice_id", this.Th);
        startActivity(paramString);
        this.Th = 0;
      }
      finish();
      return;
    }
    h.a(this, getString(R.l.invoice_save_fail), getString(R.l.app_tip), false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI
 * JD-Core Version:    0.7.0.1
 */