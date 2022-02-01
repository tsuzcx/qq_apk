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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements g, InvoiceEditView.c
{
  private int abP;
  private String dsc;
  private int iYZ;
  private Button iZa;
  private Button iZb;
  private TextView iZc;
  private TextView iZd;
  private TextView iZe;
  private InvoiceEditView iZf;
  private InvoiceEditView iZg;
  private InvoiceEditView iZh;
  private InvoiceEditView iZi;
  private InvoiceEditView iZj;
  private InvoiceEditView iZk;
  private InvoiceEditView iZl;
  private InvoiceEditView iZm;
  private com.tencent.mm.plugin.j.a.b iZn;
  private com.tencent.mm.plugin.j.a.b iZo;
  private boolean iZp;
  private boolean iZq;
  private Dialog tipDialog;
  private TextView tr;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(20833);
    this.iYZ = 0;
    this.iZa = null;
    this.iZb = null;
    this.iZe = null;
    this.iZn = null;
    this.iZo = new com.tencent.mm.plugin.j.a.b();
    this.tipDialog = null;
    this.iZp = false;
    this.iZq = false;
    this.dsc = "";
    this.abP = 0;
    AppMethodBeat.o(20833);
  }
  
  private void aC(String paramString, int paramInt)
  {
    AppMethodBeat.i(20843);
    com.tencent.mm.ui.base.h.a(this, getString(2131760391, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(2131755906), false, null);
    AppMethodBeat.o(20843);
  }
  
  private boolean aRK()
  {
    boolean bool3 = false;
    AppMethodBeat.i(20839);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.iZb != null) && (this.iZb.isActivated())) || ((this.iZn != null) && (this.iZn.type != null) && (this.iZn.type.equals("0"))))
    {
      this.iZi.setVisibility(0);
      this.iZj.setVisibility(0);
      this.iZk.setVisibility(0);
      this.iZl.setVisibility(0);
      this.iZm.setVisibility(0);
      this.iZg.setVisibility(0);
      this.iZh.setVisibility(8);
      bool1 = bool2;
      if (!this.iZb.isActivated())
      {
        bool1 = bool2;
        if (!this.iZn.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.iZg.aRO())
      {
        if (this.iZg.getText().length() > 100) {
          aC(getString(2131760414), 100);
        }
        bool1 = false;
      }
      if ((this.iZb == null) || (!this.iZb.isActivated()) || (this.iZg.getText().length() != 0)) {
        break label914;
      }
      bool1 = false;
    }
    label911:
    label914:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.iZi.aRO())
      {
        if (this.iZi.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(2131306448);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.iZc = ((TextView)findViewById(2131306447));
          }
          if (this.iZc != null) {
            this.iZc.setVisibility(0);
          }
        }
        if (!this.iZj.aRO())
        {
          if (this.iZj.getText().length() > 100) {
            aC(getString(2131760393), 100);
          }
          bool1 = false;
        }
        if (!this.iZk.aRO())
        {
          if (this.iZk.getText().length() > 100) {
            aC(getString(2131760404), 100);
          }
          bool1 = false;
        }
        if (!this.iZl.aRO())
        {
          if (this.iZl.getText().length() > 100) {
            aC(getString(2131760386), 100);
          }
          bool1 = false;
        }
        if (this.iZm.aRO()) {
          break label911;
        }
        bool1 = bool3;
        if (this.iZm.getText().length() > 48)
        {
          aC(getString(2131760388), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(20839);
        return bool1;
        if (this.iZc == null) {
          break;
        }
        this.iZc.setVisibility(8);
        break;
        if (((this.iZa != null) && (this.iZa.isActivated())) || ((this.iZn != null) && (this.iZn.type != null) && (this.iZn.type.equals("1"))))
        {
          this.iZi.setVisibility(8);
          this.iZj.setVisibility(8);
          this.iZk.setVisibility(8);
          this.iZl.setVisibility(8);
          this.iZm.setVisibility(8);
          this.iZg.setVisibility(8);
          this.iZh.setVisibility(0);
          bool1 = bool4;
          if (!this.iZa.isActivated())
          {
            bool1 = bool4;
            if (!this.iZn.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.iZh.aRO())
          {
            if (this.iZh.getText().length() > 100) {
              aC(getString(2131760414), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.iZa != null)
          {
            bool2 = bool1;
            if (this.iZa.isActivated())
            {
              bool2 = bool1;
              if (this.iZh.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.iZi.setVisibility(0);
          this.iZj.setVisibility(0);
          this.iZk.setVisibility(0);
          this.iZl.setVisibility(0);
          this.iZm.setVisibility(0);
          this.iZh.setVisibility(8);
          this.iZg.setVisibility(0);
          this.iZh.setVisibility(8);
          bool1 = bool5;
          if (this.iZa != null)
          {
            bool1 = bool5;
            if (!this.iZa.isActivated())
            {
              bool1 = bool5;
              if (this.iZb != null)
              {
                bool1 = bool5;
                if (!this.iZb.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.iZg.aRO()) {
            bool1 = false;
          }
          if (!this.iZi.aRO()) {
            bool1 = false;
          }
          if (!this.iZj.aRO()) {
            bool1 = false;
          }
          if (!this.iZk.aRO()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.iZl.aRO()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.iZm.aRO()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void aRM()
  {
    int k = 1;
    AppMethodBeat.i(20842);
    if (((this.iYZ != 0) && (this.iZn != null) && (this.iZo.type != null) && (!this.iZo.type.equals("")) && (!this.iZo.type.equals(this.iZn.type))) || ((this.iYZ == 0) && (this.iZo.type != null) && (!this.iZo.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.iZa != null)
      {
        j = i;
        if (this.iZb != null)
        {
          j = i;
          if (!this.iZa.isActivated())
          {
            j = i;
            if (!this.iZb.isActivated())
            {
              j = i;
              if (this.iZn == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.iZg.aRP()) {
        j = 1;
      }
      if (this.iZh.aRP()) {
        j = 1;
      }
      if (this.iZi.aRP()) {
        j = 1;
      }
      if (this.iZj.aRP()) {
        j = 1;
      }
      if (this.iZk.aRP()) {
        j = 1;
      }
      if (this.iZl.aRP()) {
        j = 1;
      }
      if (this.iZm.aRP()) {}
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
  
  public final void aRL()
  {
    AppMethodBeat.i(20840);
    aRK();
    AppMethodBeat.o(20840);
  }
  
  public final void aRN()
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
    this.abP = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131301095);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.iZa = ((Button)findViewById(2131301086));
    if (this.iZa != null) {
      this.iZa.setVisibility(0);
    }
    this.iZb = ((Button)findViewById(2131301084));
    if (this.iZb != null) {
      this.iZb.setVisibility(0);
    }
    if ((this.iYZ == 0) && (this.iZb != null)) {
      this.iZb.setActivated(true);
    }
    if (this.iZb != null) {
      this.iZb.setOnTouchListener(new View.OnTouchListener()
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
    if (this.iZa != null) {
      this.iZa.setOnTouchListener(new View.OnTouchListener()
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
    this.iZf = ((InvoiceEditView)findViewById(2131301098));
    this.iZg = ((InvoiceEditView)findViewById(2131301097));
    this.iZh = ((InvoiceEditView)findViewById(2131301087));
    this.iZi = ((InvoiceEditView)findViewById(2131301096));
    this.iZj = ((InvoiceEditView)findViewById(2131301083));
    this.iZk = ((InvoiceEditView)findViewById(2131301088));
    this.iZl = ((InvoiceEditView)findViewById(2131301080));
    this.iZm = ((InvoiceEditView)findViewById(2131301081));
    this.iZi.iZJ = true;
    this.iZi.iZD = true;
    this.iZi.setOnInputValidChangeListener(this);
    this.iZf.setOnInputValidChangeListener(this);
    this.iZg.setOnInputValidChangeListener(this);
    this.iZh.setOnInputValidChangeListener(this);
    this.iZj.setOnInputValidChangeListener(this);
    this.iZk.setOnInputValidChangeListener(this);
    this.iZl.setOnInputValidChangeListener(this);
    this.iZm.setOnInputValidChangeListener(this);
    if (this.iYZ != 0)
    {
      this.tr = ((TextView)findViewById(2131305880));
      this.tr.setVisibility(8);
      this.iZd = ((TextView)findViewById(2131306179));
      this.iZn = com.tencent.mm.plugin.address.a.a.aRG().qV(this.iYZ);
      if ((this.iZn == null) || (this.iZn.type == null) || (!this.iZn.type.equals("0"))) {
        break label693;
      }
      this.iZd.setText(getString(2131760396));
      this.iZd.setVisibility(0);
      this.iZb.setVisibility(8);
      this.iZa.setVisibility(8);
      if (this.iZn != null)
      {
        this.iZf.setValStr(this.iZn.type);
        this.iZg.setValStr(this.iZn.title);
        this.iZh.setValStr(this.iZn.tGP);
        this.iZi.setValStr(this.iZn.tGQ);
        this.iZj.setValStr(this.iZn.tGW);
        this.iZk.setValStr(this.iZn.tGU);
        this.iZl.setValStr(this.iZn.tGS);
        this.iZm.setValStr(this.iZn.tGR);
      }
    }
    if ((this.iZq) || (this.iZp))
    {
      this.iZe = ((TextView)findViewById(2131301231));
      if (this.iZe != null) {
        this.iZe.setVisibility(0);
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
            com.tencent.mm.plugin.report.service.h.wUl.f(14199, new Object[] { Integer.valueOf(3) });
          }
          while ((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aRN();
            AppMethodBeat.o(20831);
            return false;
            com.tencent.mm.plugin.report.service.h.wUl.f(14199, new Object[] { Integer.valueOf(4) });
          }
          if ((AddInvoiceUI.b(AddInvoiceUI.this) != null) && (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aRN();
            AppMethodBeat.o(20831);
            return false;
          }
          if ((AddInvoiceUI.f(AddInvoiceUI.this) != 0) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aRN();
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
              if (!AddInvoiceUI.k(AddInvoiceUI.this).aRO())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760403), paramAnonymousMenuItem.getString(2131755906), false, null);
              }
              if (!AddInvoiceUI.l(AddInvoiceUI.this).aRO())
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
            AddInvoiceUI.c(AddInvoiceUI.this).tGP = AddInvoiceUI.h(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).tGQ = AddInvoiceUI.i(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).tGO = AddInvoiceUI.f(AddInvoiceUI.this);
            AddInvoiceUI.c(AddInvoiceUI.this).tGU = AddInvoiceUI.k(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).tGS = AddInvoiceUI.m(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).tGR = AddInvoiceUI.l(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).tGW = AddInvoiceUI.n(AddInvoiceUI.this).getText();
            AddInvoiceUI.o(AddInvoiceUI.this);
            AppMethodBeat.o(20831);
            return true;
            if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
            }
          }
        }
      }, null, s.b.Hom);
      enableOptionMenu(false);
      aRK();
      AppMethodBeat.o(20835);
      return;
      label693:
      if ((this.iZn == null) || (this.iZn.type == null) || (!this.iZn.type.equals("1"))) {
        break;
      }
      this.iZd.setText(getString(2131760402));
      break;
      this.iZe = ((TextView)findViewById(2131301231));
      if (this.iZe != null) {
        this.iZe.setVisibility(8);
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
        if (!bs.isNullOrNil(str))
        {
          ac.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.iZk.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!bs.isNullOrNil(str))
        {
          ac.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.iZk.setValStr(str);
        }
        this.dsc = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20837);
        return;
        if (paramInt2 != -1) {
          ac.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20834);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.iZp = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.iZq = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    az.agi().a(1191, this);
    ac.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.iZo = new com.tencent.mm.plugin.j.a.b();
    this.iYZ = getIntent().getIntExtra("invoice_id", 0);
    if (this.iYZ == 0) {
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
    az.agi().b(1180, this);
    az.agi().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(20836);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20841);
    if (paramInt == 4)
    {
      aRM();
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
    ac.i("MicroMsg.AddInvoiceUI", "errType " + paramInt1 + ",errCode " + paramInt2 + ",errMsg " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1180)
      {
        paramString = ((i)paramn).iYB;
        if ((paramString != null) && (paramString.FEw != null) && (paramString.FEw.size() > 0) && (paramString.FEw.get(0) != null)) {
          this.abP = ((bik)paramString.FEw.get(0)).EuT;
        }
        az.agi().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        az.agi().a(paramString, 0);
        AppMethodBeat.o(20838);
        return;
      }
      if (paramn.getType() == 1191)
      {
        az.agi().b(1191, this);
        if (this.iZp)
        {
          ac.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramn = this.iZo;
          if (paramn == null)
          {
            ac.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
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
              paramString.putExtra("title", paramn.tGP);
            }
            else
            {
              paramString.putExtra("title", paramn.title);
              paramString.putExtra("tax_number", paramn.tGQ);
              paramString.putExtra("company_address", paramn.tGW);
              paramString.putExtra("telephone", paramn.tGU);
              paramString.putExtra("bank_name", paramn.tGS);
              paramString.putExtra("bank_account", paramn.tGR);
            }
          }
        }
        if ((this.iYZ == 0) && (this.abP != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.abP);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.abP = 0;
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