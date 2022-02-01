package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements g, InvoiceEditView.c
{
  private int aaU;
  private String dur;
  private int iyW;
  private Button iyX;
  private Button iyY;
  private TextView iyZ;
  private TextView iza;
  private TextView izb;
  private InvoiceEditView izc;
  private InvoiceEditView izd;
  private InvoiceEditView ize;
  private InvoiceEditView izf;
  private InvoiceEditView izg;
  private InvoiceEditView izh;
  private InvoiceEditView izi;
  private InvoiceEditView izj;
  private com.tencent.mm.plugin.j.a.b izk;
  private com.tencent.mm.plugin.j.a.b izl;
  private boolean izm;
  private boolean izn;
  private TextView ss;
  private Dialog tipDialog;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(20833);
    this.iyW = 0;
    this.iyX = null;
    this.iyY = null;
    this.izb = null;
    this.izk = null;
    this.izl = new com.tencent.mm.plugin.j.a.b();
    this.tipDialog = null;
    this.izm = false;
    this.izn = false;
    this.dur = "";
    this.aaU = 0;
    AppMethodBeat.o(20833);
  }
  
  private boolean aKT()
  {
    boolean bool3 = false;
    AppMethodBeat.i(20839);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.iyY != null) && (this.iyY.isActivated())) || ((this.izk != null) && (this.izk.type != null) && (this.izk.type.equals("0"))))
    {
      this.izf.setVisibility(0);
      this.izg.setVisibility(0);
      this.izh.setVisibility(0);
      this.izi.setVisibility(0);
      this.izj.setVisibility(0);
      this.izd.setVisibility(0);
      this.ize.setVisibility(8);
      bool1 = bool2;
      if (!this.iyY.isActivated())
      {
        bool1 = bool2;
        if (!this.izk.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.izd.aKX())
      {
        if (this.izd.getText().length() > 100) {
          ay(getString(2131760414), 100);
        }
        bool1 = false;
      }
      if ((this.iyY == null) || (!this.iyY.isActivated()) || (this.izd.getText().length() != 0)) {
        break label914;
      }
      bool1 = false;
    }
    label911:
    label914:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.izf.aKX())
      {
        if (this.izf.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(2131306448);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.iyZ = ((TextView)findViewById(2131306447));
          }
          if (this.iyZ != null) {
            this.iyZ.setVisibility(0);
          }
        }
        if (!this.izg.aKX())
        {
          if (this.izg.getText().length() > 100) {
            ay(getString(2131760393), 100);
          }
          bool1 = false;
        }
        if (!this.izh.aKX())
        {
          if (this.izh.getText().length() > 100) {
            ay(getString(2131760404), 100);
          }
          bool1 = false;
        }
        if (!this.izi.aKX())
        {
          if (this.izi.getText().length() > 100) {
            ay(getString(2131760386), 100);
          }
          bool1 = false;
        }
        if (this.izj.aKX()) {
          break label911;
        }
        bool1 = bool3;
        if (this.izj.getText().length() > 48)
        {
          ay(getString(2131760388), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(20839);
        return bool1;
        if (this.iyZ == null) {
          break;
        }
        this.iyZ.setVisibility(8);
        break;
        if (((this.iyX != null) && (this.iyX.isActivated())) || ((this.izk != null) && (this.izk.type != null) && (this.izk.type.equals("1"))))
        {
          this.izf.setVisibility(8);
          this.izg.setVisibility(8);
          this.izh.setVisibility(8);
          this.izi.setVisibility(8);
          this.izj.setVisibility(8);
          this.izd.setVisibility(8);
          this.ize.setVisibility(0);
          bool1 = bool4;
          if (!this.iyX.isActivated())
          {
            bool1 = bool4;
            if (!this.izk.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.ize.aKX())
          {
            if (this.ize.getText().length() > 100) {
              ay(getString(2131760414), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.iyX != null)
          {
            bool2 = bool1;
            if (this.iyX.isActivated())
            {
              bool2 = bool1;
              if (this.ize.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.izf.setVisibility(0);
          this.izg.setVisibility(0);
          this.izh.setVisibility(0);
          this.izi.setVisibility(0);
          this.izj.setVisibility(0);
          this.ize.setVisibility(8);
          this.izd.setVisibility(0);
          this.ize.setVisibility(8);
          bool1 = bool5;
          if (this.iyX != null)
          {
            bool1 = bool5;
            if (!this.iyX.isActivated())
            {
              bool1 = bool5;
              if (this.iyY != null)
              {
                bool1 = bool5;
                if (!this.iyY.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.izd.aKX()) {
            bool1 = false;
          }
          if (!this.izf.aKX()) {
            bool1 = false;
          }
          if (!this.izg.aKX()) {
            bool1 = false;
          }
          if (!this.izh.aKX()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.izi.aKX()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.izj.aKX()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void aKV()
  {
    int k = 1;
    AppMethodBeat.i(20842);
    if (((this.iyW != 0) && (this.izk != null) && (this.izl.type != null) && (!this.izl.type.equals("")) && (!this.izl.type.equals(this.izk.type))) || ((this.iyW == 0) && (this.izl.type != null) && (!this.izl.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.iyX != null)
      {
        j = i;
        if (this.iyY != null)
        {
          j = i;
          if (!this.iyX.isActivated())
          {
            j = i;
            if (!this.iyY.isActivated())
            {
              j = i;
              if (this.izk == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.izd.aKY()) {
        j = 1;
      }
      if (this.ize.aKY()) {
        j = 1;
      }
      if (this.izf.aKY()) {
        j = 1;
      }
      if (this.izg.aKY()) {
        j = 1;
      }
      if (this.izh.aKY()) {
        j = 1;
      }
      if (this.izi.aKY()) {
        j = 1;
      }
      if (this.izj.aKY()) {}
      for (i = k;; i = j)
      {
        if (i != 0)
        {
          com.tencent.mm.ui.base.h.a(this, false, getContext().getString(2131760385), "", getContext().getString(2131760384), getContext().getString(2131760383), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(20832);
              AddInvoiceUI.this.setResult(0);
              AddInvoiceUI.this.finish();
              AppMethodBeat.o(20832);
            }
          }, null);
          AppMethodBeat.o(20842);
          return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(20842);
        return;
      }
    }
  }
  
  private void ay(String paramString, int paramInt)
  {
    AppMethodBeat.i(20843);
    com.tencent.mm.ui.base.h.a(this, getString(2131760391, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(2131755906), false, null);
    AppMethodBeat.o(20843);
  }
  
  public final void aKU()
  {
    AppMethodBeat.i(20840);
    aKT();
    AppMethodBeat.o(20840);
  }
  
  public final void aKW()
  {
    AppMethodBeat.i(20844);
    com.tencent.mm.ui.base.h.a(this, getString(2131760415), getString(2131755906), false, null);
    AppMethodBeat.o(20844);
  }
  
  public int getLayoutId()
  {
    return 2131494761;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20835);
    this.aaU = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131301095);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.iyX = ((Button)findViewById(2131301086));
    if (this.iyX != null) {
      this.iyX.setVisibility(0);
    }
    this.iyY = ((Button)findViewById(2131301084));
    if (this.iyY != null) {
      this.iyY.setVisibility(0);
    }
    if ((this.iyW == 0) && (this.iyY != null)) {
      this.iyY.setActivated(true);
    }
    if (this.iyY != null) {
      this.iyY.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(20828);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            AppMethodBeat.o(20828);
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() != 1)
          {
            AppMethodBeat.o(20828);
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
          AppMethodBeat.o(20828);
          return true;
        }
      });
    }
    if (this.iyX != null) {
      this.iyX.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(20829);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            AppMethodBeat.o(20829);
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() != 1)
          {
            AppMethodBeat.o(20829);
            return false;
          }
          if (!AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
            AddInvoiceUI.b(AddInvoiceUI.this).setActivated(true);
          }
          if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated())
          {
            AddInvoiceUI.a(AddInvoiceUI.this).setActivated(false);
            AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
          }
          AddInvoiceUI.d(AddInvoiceUI.this);
          AppMethodBeat.o(20829);
          return true;
        }
      });
    }
    this.izc = ((InvoiceEditView)findViewById(2131301098));
    this.izd = ((InvoiceEditView)findViewById(2131301097));
    this.ize = ((InvoiceEditView)findViewById(2131301087));
    this.izf = ((InvoiceEditView)findViewById(2131301096));
    this.izg = ((InvoiceEditView)findViewById(2131301083));
    this.izh = ((InvoiceEditView)findViewById(2131301088));
    this.izi = ((InvoiceEditView)findViewById(2131301080));
    this.izj = ((InvoiceEditView)findViewById(2131301081));
    this.izf.izG = true;
    this.izf.izA = true;
    this.izf.setOnInputValidChangeListener(this);
    this.izc.setOnInputValidChangeListener(this);
    this.izd.setOnInputValidChangeListener(this);
    this.ize.setOnInputValidChangeListener(this);
    this.izg.setOnInputValidChangeListener(this);
    this.izh.setOnInputValidChangeListener(this);
    this.izi.setOnInputValidChangeListener(this);
    this.izj.setOnInputValidChangeListener(this);
    if (this.iyW != 0)
    {
      this.ss = ((TextView)findViewById(2131305880));
      this.ss.setVisibility(8);
      this.iza = ((TextView)findViewById(2131306179));
      this.izk = com.tencent.mm.plugin.address.a.a.aKP().qi(this.iyW);
      if ((this.izk == null) || (this.izk.type == null) || (!this.izk.type.equals("0"))) {
        break label693;
      }
      this.iza.setText(getString(2131760396));
      this.iza.setVisibility(0);
      this.iyY.setVisibility(8);
      this.iyX.setVisibility(8);
      if (this.izk != null)
      {
        this.izc.setValStr(this.izk.type);
        this.izd.setValStr(this.izk.title);
        this.ize.setValStr(this.izk.szf);
        this.izf.setValStr(this.izk.szg);
        this.izg.setValStr(this.izk.szm);
        this.izh.setValStr(this.izk.szk);
        this.izi.setValStr(this.izk.szi);
        this.izj.setValStr(this.izk.szh);
      }
    }
    if ((this.izn) || (this.izm))
    {
      this.izb = ((TextView)findViewById(2131301231));
      if (this.izb != null) {
        this.izb.setVisibility(0);
      }
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20830);
          AddInvoiceUI.e(AddInvoiceUI.this);
          AppMethodBeat.o(20830);
          return true;
        }
      });
      addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20831);
          if (AddInvoiceUI.f(AddInvoiceUI.this) == 0) {
            com.tencent.mm.plugin.report.service.h.vKh.f(14199, new Object[] { Integer.valueOf(3) });
          }
          while ((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aKW();
            AppMethodBeat.o(20831);
            return false;
            com.tencent.mm.plugin.report.service.h.vKh.f(14199, new Object[] { Integer.valueOf(4) });
          }
          if ((AddInvoiceUI.b(AddInvoiceUI.this) != null) && (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aKW();
            AppMethodBeat.o(20831);
            return false;
          }
          if ((AddInvoiceUI.f(AddInvoiceUI.this) != 0) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aKW();
            AppMethodBeat.o(20831);
            return false;
          }
          if (AddInvoiceUI.i(AddInvoiceUI.this).getText().length() > 100)
          {
            paramAnonymousMenuItem = AddInvoiceUI.this;
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760392), paramAnonymousMenuItem.getString(2131755906), false, null);
            AppMethodBeat.o(20831);
            return false;
          }
          if (!AddInvoiceUI.d(AddInvoiceUI.this))
          {
            if (((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated())) || ((AddInvoiceUI.j(AddInvoiceUI.this) != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type.equals("0"))))
            {
              if (!AddInvoiceUI.k(AddInvoiceUI.this).aKX())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760403), paramAnonymousMenuItem.getString(2131755906), false, null);
              }
              if (!AddInvoiceUI.l(AddInvoiceUI.this).aKX())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760389), paramAnonymousMenuItem.getString(2131755906), false, null);
              }
            }
            AppMethodBeat.o(20831);
            return true;
          }
          if (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) {
            AddInvoiceUI.c(AddInvoiceUI.this).type = "0";
          }
          for (;;)
          {
            if (AddInvoiceUI.j(AddInvoiceUI.this) != null) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = AddInvoiceUI.j(AddInvoiceUI.this).type;
            }
            AddInvoiceUI.c(AddInvoiceUI.this).title = AddInvoiceUI.g(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).szf = AddInvoiceUI.h(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).szg = AddInvoiceUI.i(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).sze = AddInvoiceUI.f(AddInvoiceUI.this);
            AddInvoiceUI.c(AddInvoiceUI.this).szk = AddInvoiceUI.k(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).szi = AddInvoiceUI.m(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).szh = AddInvoiceUI.l(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).szm = AddInvoiceUI.n(AddInvoiceUI.this).getText();
            AddInvoiceUI.o(AddInvoiceUI.this);
            AppMethodBeat.o(20831);
            return true;
            if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
            }
          }
        }
      }, null, r.b.FOB);
      enableOptionMenu(false);
      aKT();
      AppMethodBeat.o(20835);
      return;
      label693:
      if ((this.izk == null) || (this.izk.type == null) || (!this.izk.type.equals("1"))) {
        break;
      }
      this.iza.setText(getString(2131760402));
      break;
      this.izb = ((TextView)findViewById(2131301231));
      if (this.izb != null) {
        this.izb.setVisibility(8);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20837);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20837);
      return;
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("karea_result");
        if (!bt.isNullOrNil(str))
        {
          ad.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.izh.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!bt.isNullOrNil(str))
        {
          ad.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.izh.setValStr(str);
        }
        this.dur = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20837);
        return;
        if (paramInt2 != -1) {
          ad.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20834);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.izm = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.izn = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    az.aeS().a(1191, this);
    ad.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.izl = new com.tencent.mm.plugin.j.a.b();
    this.iyW = getIntent().getIntExtra("invoice_id", 0);
    if (this.iyW == 0) {
      setMMTitle(2131763167);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(20834);
      return;
      setMMTitle(2131763294);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20836);
    az.aeS().b(1180, this);
    az.aeS().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(20836);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20841);
    if (paramInt == 4)
    {
      aKV();
      AppMethodBeat.o(20841);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(20841);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    Object localObject = null;
    AppMethodBeat.i(20838);
    ad.i("MicroMsg.AddInvoiceUI", "errType " + paramInt1 + ",errCode " + paramInt2 + ",errMsg " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1180)
      {
        paramString = ((i)paramn).iyy;
        if ((paramString != null) && (paramString.Ehx != null) && (paramString.Ehx.size() > 0) && (paramString.Ehx.get(0) != null)) {
          this.aaU = ((bes)paramString.Ehx.get(0)).DbN;
        }
        az.aeS().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        az.aeS().a(paramString, 0);
        AppMethodBeat.o(20838);
        return;
      }
      if (paramn.getType() == 1191)
      {
        az.aeS().b(1191, this);
        if (this.izm)
        {
          ad.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramn = this.izl;
          if (paramn == null)
          {
            ad.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
            paramString = localObject;
          }
          for (;;)
          {
            setResult(-1, paramString);
            finish();
            AppMethodBeat.o(20838);
            return;
            paramString = new Intent();
            paramString.putExtra("type", paramn.type);
            if ((paramn.type != null) && (paramn.type.equals("1")))
            {
              paramString.putExtra("title", paramn.szf);
            }
            else
            {
              paramString.putExtra("title", paramn.title);
              paramString.putExtra("tax_number", paramn.szg);
              paramString.putExtra("company_address", paramn.szm);
              paramString.putExtra("telephone", paramn.szk);
              paramString.putExtra("bank_name", paramn.szi);
              paramString.putExtra("bank_account", paramn.szh);
            }
          }
        }
        if ((this.iyW == 0) && (this.aaU != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.aaU);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.aaU = 0;
        }
        finish();
        AppMethodBeat.o(20838);
      }
    }
    else
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131760408), getString(2131755906), false, null);
    }
    AppMethodBeat.o(20838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI
 * JD-Core Version:    0.7.0.1
 */