package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements f, InvoiceEditView.c
{
  private int TR;
  private String cDP;
  private TextView euY;
  private Dialog gKM;
  private com.tencent.mm.plugin.j.a.b gLA;
  private com.tencent.mm.plugin.j.a.b gLB;
  private boolean gLC;
  private boolean gLD;
  private int gLm;
  private Button gLn;
  private Button gLo;
  private TextView gLp;
  private TextView gLq;
  private TextView gLr;
  private InvoiceEditView gLs;
  private InvoiceEditView gLt;
  private InvoiceEditView gLu;
  private InvoiceEditView gLv;
  private InvoiceEditView gLw;
  private InvoiceEditView gLx;
  private InvoiceEditView gLy;
  private InvoiceEditView gLz;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(16792);
    this.gLm = 0;
    this.gLn = null;
    this.gLo = null;
    this.gLr = null;
    this.gLA = null;
    this.gLB = new com.tencent.mm.plugin.j.a.b();
    this.gKM = null;
    this.gLC = false;
    this.gLD = false;
    this.cDP = "";
    this.TR = 0;
    AppMethodBeat.o(16792);
  }
  
  private void al(String paramString, int paramInt)
  {
    AppMethodBeat.i(16802);
    h.a(this, getString(2131300790, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(2131297087), false, null);
    AppMethodBeat.o(16802);
  }
  
  private boolean asr()
  {
    boolean bool3 = false;
    AppMethodBeat.i(16798);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.gLo != null) && (this.gLo.isActivated())) || ((this.gLA != null) && (this.gLA.type != null) && (this.gLA.type.equals("0"))))
    {
      this.gLv.setVisibility(0);
      this.gLw.setVisibility(0);
      this.gLx.setVisibility(0);
      this.gLy.setVisibility(0);
      this.gLz.setVisibility(0);
      this.gLt.setVisibility(0);
      this.gLu.setVisibility(8);
      bool1 = bool2;
      if (!this.gLo.isActivated())
      {
        bool1 = bool2;
        if (!this.gLA.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.gLt.asv())
      {
        if (this.gLt.getText().length() > 100) {
          al(getString(2131300813), 100);
        }
        bool1 = false;
      }
      if ((this.gLo == null) || (!this.gLo.isActivated()) || (this.gLt.getText().length() != 0)) {
        break label914;
      }
      bool1 = false;
    }
    label911:
    label914:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.gLv.asv())
      {
        if (this.gLv.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(2131826127);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.gLp = ((TextView)findViewById(2131828745));
          }
          if (this.gLp != null) {
            this.gLp.setVisibility(0);
          }
        }
        if (!this.gLw.asv())
        {
          if (this.gLw.getText().length() > 100) {
            al(getString(2131300792), 100);
          }
          bool1 = false;
        }
        if (!this.gLx.asv())
        {
          if (this.gLx.getText().length() > 100) {
            al(getString(2131300803), 100);
          }
          bool1 = false;
        }
        if (!this.gLy.asv())
        {
          if (this.gLy.getText().length() > 100) {
            al(getString(2131300785), 100);
          }
          bool1 = false;
        }
        if (this.gLz.asv()) {
          break label911;
        }
        bool1 = bool3;
        if (this.gLz.getText().length() > 48)
        {
          al(getString(2131300787), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(16798);
        return bool1;
        if (this.gLp == null) {
          break;
        }
        this.gLp.setVisibility(8);
        break;
        if (((this.gLn != null) && (this.gLn.isActivated())) || ((this.gLA != null) && (this.gLA.type != null) && (this.gLA.type.equals("1"))))
        {
          this.gLv.setVisibility(8);
          this.gLw.setVisibility(8);
          this.gLx.setVisibility(8);
          this.gLy.setVisibility(8);
          this.gLz.setVisibility(8);
          this.gLt.setVisibility(8);
          this.gLu.setVisibility(0);
          bool1 = bool4;
          if (!this.gLn.isActivated())
          {
            bool1 = bool4;
            if (!this.gLA.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.gLu.asv())
          {
            if (this.gLu.getText().length() > 100) {
              al(getString(2131300813), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.gLn != null)
          {
            bool2 = bool1;
            if (this.gLn.isActivated())
            {
              bool2 = bool1;
              if (this.gLu.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.gLv.setVisibility(0);
          this.gLw.setVisibility(0);
          this.gLx.setVisibility(0);
          this.gLy.setVisibility(0);
          this.gLz.setVisibility(0);
          this.gLu.setVisibility(8);
          this.gLt.setVisibility(0);
          this.gLu.setVisibility(8);
          bool1 = bool5;
          if (this.gLn != null)
          {
            bool1 = bool5;
            if (!this.gLn.isActivated())
            {
              bool1 = bool5;
              if (this.gLo != null)
              {
                bool1 = bool5;
                if (!this.gLo.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.gLt.asv()) {
            bool1 = false;
          }
          if (!this.gLv.asv()) {
            bool1 = false;
          }
          if (!this.gLw.asv()) {
            bool1 = false;
          }
          if (!this.gLx.asv()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.gLy.asv()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.gLz.asv()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void ast()
  {
    int k = 1;
    AppMethodBeat.i(16801);
    if (((this.gLm != 0) && (this.gLA != null) && (this.gLB.type != null) && (!this.gLB.type.equals("")) && (!this.gLB.type.equals(this.gLA.type))) || ((this.gLm == 0) && (this.gLB.type != null) && (!this.gLB.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.gLn != null)
      {
        j = i;
        if (this.gLo != null)
        {
          j = i;
          if (!this.gLn.isActivated())
          {
            j = i;
            if (!this.gLo.isActivated())
            {
              j = i;
              if (this.gLA == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.gLt.asw()) {
        j = 1;
      }
      if (this.gLu.asw()) {
        j = 1;
      }
      if (this.gLv.asw()) {
        j = 1;
      }
      if (this.gLw.asw()) {
        j = 1;
      }
      if (this.gLx.asw()) {
        j = 1;
      }
      if (this.gLy.asw()) {
        j = 1;
      }
      if (this.gLz.asw()) {}
      for (i = k;; i = j)
      {
        if (i != 0)
        {
          h.a(this, false, getContext().getString(2131300784), "", getContext().getString(2131300783), getContext().getString(2131300782), new AddInvoiceUI.5(this), null);
          AppMethodBeat.o(16801);
          return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(16801);
        return;
      }
    }
  }
  
  public final void ass()
  {
    AppMethodBeat.i(16799);
    asr();
    AppMethodBeat.o(16799);
  }
  
  public final void asu()
  {
    AppMethodBeat.i(16803);
    h.a(this, getString(2131300814), getString(2131297087), false, null);
    AppMethodBeat.o(16803);
  }
  
  public int getLayoutId()
  {
    return 2130970139;
  }
  
  public void initView()
  {
    AppMethodBeat.i(16794);
    this.TR = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131826126);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.gLn = ((Button)findViewById(2131826129));
    if (this.gLn != null) {
      this.gLn.setVisibility(0);
    }
    this.gLo = ((Button)findViewById(2131826130));
    if (this.gLo != null) {
      this.gLo.setVisibility(0);
    }
    if ((this.gLm == 0) && (this.gLo != null)) {
      this.gLo.setActivated(true);
    }
    if (this.gLo != null) {
      this.gLo.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(16787);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            AppMethodBeat.o(16787);
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() != 1)
          {
            AppMethodBeat.o(16787);
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
          AppMethodBeat.o(16787);
          return true;
        }
      });
    }
    if (this.gLn != null) {
      this.gLn.setOnTouchListener(new AddInvoiceUI.2(this));
    }
    this.gLs = ((InvoiceEditView)findViewById(2131826131));
    this.gLt = ((InvoiceEditView)findViewById(2131822351));
    this.gLu = ((InvoiceEditView)findViewById(2131826132));
    this.gLv = ((InvoiceEditView)findViewById(2131826133));
    this.gLw = ((InvoiceEditView)findViewById(2131826134));
    this.gLx = ((InvoiceEditView)findViewById(2131826135));
    this.gLy = ((InvoiceEditView)findViewById(2131826136));
    this.gLz = ((InvoiceEditView)findViewById(2131826137));
    this.gLv.gLY = true;
    this.gLv.gLR = true;
    this.gLv.setOnInputValidChangeListener(this);
    this.gLs.setOnInputValidChangeListener(this);
    this.gLt.setOnInputValidChangeListener(this);
    this.gLu.setOnInputValidChangeListener(this);
    this.gLw.setOnInputValidChangeListener(this);
    this.gLx.setOnInputValidChangeListener(this);
    this.gLy.setOnInputValidChangeListener(this);
    this.gLz.setOnInputValidChangeListener(this);
    if (this.gLm != 0)
    {
      this.euY = ((TextView)findViewById(2131821071));
      this.euY.setVisibility(8);
      this.gLq = ((TextView)findViewById(2131826128));
      this.gLA = com.tencent.mm.plugin.address.a.a.asm().mZ(this.gLm);
      if ((this.gLA == null) || (this.gLA.type == null) || (!this.gLA.type.equals("0"))) {
        break label693;
      }
      this.gLq.setText(getString(2131300795));
      this.gLq.setVisibility(0);
      this.gLo.setVisibility(8);
      this.gLn.setVisibility(8);
      if (this.gLA != null)
      {
        this.gLs.setValStr(this.gLA.type);
        this.gLt.setValStr(this.gLA.title);
        this.gLu.setValStr(this.gLA.nLn);
        this.gLv.setValStr(this.gLA.nLo);
        this.gLw.setValStr(this.gLA.nLu);
        this.gLx.setValStr(this.gLA.nLs);
        this.gLy.setValStr(this.gLA.nLq);
        this.gLz.setValStr(this.gLA.nLp);
      }
    }
    if ((this.gLD) || (this.gLC))
    {
      this.gLr = ((TextView)findViewById(2131825164));
      if (this.gLr != null) {
        this.gLr.setVisibility(0);
      }
    }
    for (;;)
    {
      setBackBtn(new AddInvoiceUI.3(this));
      addTextOptionMenu(0, getString(2131297063), new AddInvoiceUI.4(this), null, q.b.zby);
      enableOptionMenu(false);
      asr();
      AppMethodBeat.o(16794);
      return;
      label693:
      if ((this.gLA == null) || (this.gLA.type == null) || (!this.gLA.type.equals("1"))) {
        break;
      }
      this.gLq.setText(getString(2131300801));
      break;
      this.gLr = ((TextView)findViewById(2131825164));
      if (this.gLr != null) {
        this.gLr.setVisibility(8);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(16796);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(16796);
      return;
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("karea_result");
        if (!bo.isNullOrNil(str))
        {
          ab.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.gLx.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!bo.isNullOrNil(str))
        {
          ab.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.gLx.setValStr(str);
        }
        this.cDP = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(16796);
        return;
        if (paramInt2 != -1) {
          ab.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(16793);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.gLC = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.gLD = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    aw.Rc().a(1191, this);
    ab.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.gLB = new com.tencent.mm.plugin.j.a.b();
    this.gLm = getIntent().getIntExtra("invoice_id", 0);
    if (this.gLm == 0) {
      setMMTitle(2131303200);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(16793);
      return;
      setMMTitle(2131303314);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(16795);
    aw.Rc().b(1180, this);
    aw.Rc().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(16795);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(16800);
    if (paramInt == 4)
    {
      ast();
      AppMethodBeat.o(16800);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(16800);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    Object localObject = null;
    AppMethodBeat.i(16797);
    ab.i("MicroMsg.AddInvoiceUI", "errType " + paramInt1 + ",errCode " + paramInt2 + ",errMsg " + paramString);
    if (this.gKM != null) {
      this.gKM.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 1180)
      {
        paramString = ((i)paramm).gKP;
        if ((paramString != null) && (paramString.xJO != null) && (paramString.xJO.size() > 0) && (paramString.xJO.get(0) != null)) {
          this.TR = ((atr)paramString.xJO.get(0)).wPj;
        }
        aw.Rc().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        aw.Rc().a(paramString, 0);
        AppMethodBeat.o(16797);
        return;
      }
      if (paramm.getType() == 1191)
      {
        aw.Rc().b(1191, this);
        if (this.gLC)
        {
          ab.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramm = this.gLB;
          if (paramm == null)
          {
            ab.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
            paramString = localObject;
          }
          for (;;)
          {
            setResult(-1, paramString);
            finish();
            AppMethodBeat.o(16797);
            return;
            paramString = new Intent();
            paramString.putExtra("type", paramm.type);
            if ((paramm.type != null) && (paramm.type.equals("1")))
            {
              paramString.putExtra("title", paramm.nLn);
            }
            else
            {
              paramString.putExtra("title", paramm.title);
              paramString.putExtra("tax_number", paramm.nLo);
              paramString.putExtra("company_address", paramm.nLu);
              paramString.putExtra("telephone", paramm.nLs);
              paramString.putExtra("bank_name", paramm.nLq);
              paramString.putExtra("bank_account", paramm.nLp);
            }
          }
        }
        if ((this.gLm == 0) && (this.TR != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.TR);
          startActivity(paramString);
          this.TR = 0;
        }
        finish();
        AppMethodBeat.o(16797);
      }
    }
    else
    {
      h.a(this, getString(2131300807), getString(2131297087), false, null);
    }
    AppMethodBeat.o(16797);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI
 * JD-Core Version:    0.7.0.1
 */