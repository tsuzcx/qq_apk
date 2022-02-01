package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements com.tencent.mm.am.h, InvoiceEditView.c
{
  private TextView dyR;
  private String hWu;
  private int kW;
  private com.tencent.mm.plugin.o.a.b qiA;
  private com.tencent.mm.plugin.o.a.b qiB;
  private boolean qiC;
  private boolean qiD;
  private int qim;
  private Button qin;
  private Button qio;
  private TextView qip;
  private TextView qiq;
  private TextView qir;
  private InvoiceEditView qis;
  private InvoiceEditView qit;
  private InvoiceEditView qiu;
  private InvoiceEditView qiv;
  private InvoiceEditView qiw;
  private InvoiceEditView qix;
  private InvoiceEditView qiy;
  private InvoiceEditView qiz;
  private Dialog tipDialog;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(20833);
    this.qim = 0;
    this.qin = null;
    this.qio = null;
    this.qir = null;
    this.qiA = null;
    this.qiB = new com.tencent.mm.plugin.o.a.b();
    this.tipDialog = null;
    this.qiC = false;
    this.qiD = false;
    this.hWu = "";
    this.kW = 0;
    AppMethodBeat.o(20833);
  }
  
  private boolean bZk()
  {
    boolean bool3 = false;
    AppMethodBeat.i(20839);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.qio != null) && (this.qio.isActivated())) || ((this.qiA != null) && (this.qiA.type != null) && (this.qiA.type.equals("0"))))
    {
      this.qiv.setVisibility(0);
      this.qiw.setVisibility(0);
      this.qix.setVisibility(0);
      this.qiy.setVisibility(0);
      this.qiz.setVisibility(0);
      this.qit.setVisibility(0);
      this.qiu.setVisibility(8);
      bool1 = bool2;
      if (!this.qio.isActivated())
      {
        bool1 = bool2;
        if (!this.qiA.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.qit.bZp())
      {
        if (this.qit.getText().length() > 100) {
          bs(getString(R.l.fKX), 100);
        }
        bool1 = false;
      }
      if ((this.qio == null) || (!this.qio.isActivated()) || (this.qit.getText().length() != 0)) {
        break label922;
      }
      bool1 = false;
    }
    label919:
    label922:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.qiv.bZp())
      {
        if (this.qiv.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(R.h.gco);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.qip = ((TextView)findViewById(R.h.gcn));
          }
          if (this.qip != null) {
            this.qip.setVisibility(0);
          }
        }
        if (!this.qiw.bZp())
        {
          if (this.qiw.getText().length() > 100) {
            bs(getString(R.l.fKM), 100);
          }
          bool1 = false;
        }
        if (!this.qix.bZp())
        {
          if (this.qix.getText().length() > 100) {
            bs(getString(R.l.fKQ), 100);
          }
          bool1 = false;
        }
        if (!this.qiy.bZp())
        {
          if (this.qiy.getText().length() > 100) {
            bs(getString(R.l.fKK), 100);
          }
          bool1 = false;
        }
        if (this.qiz.bZp()) {
          break label919;
        }
        bool1 = bool3;
        if (this.qiz.getText().length() > 48)
        {
          bs(getString(R.l.fKL), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(20839);
        return bool1;
        if (this.qip == null) {
          break;
        }
        this.qip.setVisibility(8);
        break;
        if (((this.qin != null) && (this.qin.isActivated())) || ((this.qiA != null) && (this.qiA.type != null) && (this.qiA.type.equals("1"))))
        {
          this.qiv.setVisibility(8);
          this.qiw.setVisibility(8);
          this.qix.setVisibility(8);
          this.qiy.setVisibility(8);
          this.qiz.setVisibility(8);
          this.qit.setVisibility(8);
          this.qiu.setVisibility(0);
          bool1 = bool4;
          if (!this.qin.isActivated())
          {
            bool1 = bool4;
            if (!this.qiA.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.qiu.bZp())
          {
            if (this.qiu.getText().length() > 100) {
              bs(getString(R.l.fKX), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.qin != null)
          {
            bool2 = bool1;
            if (this.qin.isActivated())
            {
              bool2 = bool1;
              if (this.qiu.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.qiv.setVisibility(0);
          this.qiw.setVisibility(0);
          this.qix.setVisibility(0);
          this.qiy.setVisibility(0);
          this.qiz.setVisibility(0);
          this.qiu.setVisibility(8);
          this.qit.setVisibility(0);
          this.qiu.setVisibility(8);
          bool1 = bool5;
          if (this.qin != null)
          {
            bool1 = bool5;
            if (!this.qin.isActivated())
            {
              bool1 = bool5;
              if (this.qio != null)
              {
                bool1 = bool5;
                if (!this.qio.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.qit.bZp()) {
            bool1 = false;
          }
          if (!this.qiv.bZp()) {
            bool1 = false;
          }
          if (!this.qiw.bZp()) {
            bool1 = false;
          }
          if (!this.qix.bZp()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.qiy.bZp()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.qiz.bZp()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void bZm()
  {
    int k = 1;
    AppMethodBeat.i(20842);
    if (((this.qim != 0) && (this.qiA != null) && (this.qiB.type != null) && (!this.qiB.type.equals("")) && (!this.qiB.type.equals(this.qiA.type))) || ((this.qim == 0) && (this.qiB.type != null) && (!this.qiB.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.qin != null)
      {
        j = i;
        if (this.qio != null)
        {
          j = i;
          if (!this.qin.isActivated())
          {
            j = i;
            if (!this.qio.isActivated())
            {
              j = i;
              if (this.qiA == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.qit.bZq()) {
        j = 1;
      }
      if (this.qiu.bZq()) {
        j = 1;
      }
      if (this.qiv.bZq()) {
        j = 1;
      }
      if (this.qiw.bZq()) {
        j = 1;
      }
      if (this.qix.bZq()) {
        j = 1;
      }
      if (this.qiy.bZq()) {
        j = 1;
      }
      if (this.qiz.bZq()) {}
      for (i = k;; i = j)
      {
        if (i != 0)
        {
          k.a(this, false, getContext().getString(R.l.gJM), "", getContext().getString(R.l.gJL), getContext().getString(R.l.gJK), new DialogInterface.OnClickListener()
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
  
  private void bs(String paramString, int paramInt)
  {
    AppMethodBeat.i(20843);
    k.a(this, getString(R.l.gJO, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(R.l.app_tip), false, null);
    AppMethodBeat.o(20843);
  }
  
  public final void bZl()
  {
    AppMethodBeat.i(20840);
    bZk();
    AppMethodBeat.o(20840);
  }
  
  public final void bZn()
  {
    AppMethodBeat.i(20844);
    k.a(this, getString(R.l.gJZ), getString(R.l.app_tip), false, null);
    AppMethodBeat.o(20844);
  }
  
  public int getLayoutId()
  {
    return R.i.glF;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20835);
    this.kW = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(R.h.fKV);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.qin = ((Button)findViewById(R.h.fKO));
    if (this.qin != null) {
      this.qin.setVisibility(0);
    }
    this.qio = ((Button)findViewById(R.h.fKN));
    if (this.qio != null) {
      this.qio.setVisibility(0);
    }
    if ((this.qim == 0) && (this.qio != null)) {
      this.qio.setActivated(true);
    }
    if (this.qio != null) {
      this.qio.setOnTouchListener(new View.OnTouchListener()
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
    if (this.qin != null) {
      this.qin.setOnTouchListener(new View.OnTouchListener()
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
    this.qis = ((InvoiceEditView)findViewById(R.h.fKY));
    this.qit = ((InvoiceEditView)findViewById(R.h.fKX));
    this.qiu = ((InvoiceEditView)findViewById(R.h.fKP));
    this.qiv = ((InvoiceEditView)findViewById(R.h.fKW));
    this.qiw = ((InvoiceEditView)findViewById(R.h.fKM));
    this.qix = ((InvoiceEditView)findViewById(R.h.fKQ));
    this.qiy = ((InvoiceEditView)findViewById(R.h.fKK));
    this.qiz = ((InvoiceEditView)findViewById(R.h.fKL));
    this.qiv.qiW = true;
    this.qiv.qiQ = true;
    this.qiv.setOnInputValidChangeListener(this);
    this.qis.setOnInputValidChangeListener(this);
    this.qit.setOnInputValidChangeListener(this);
    this.qiu.setOnInputValidChangeListener(this);
    this.qiw.setOnInputValidChangeListener(this);
    this.qix.setOnInputValidChangeListener(this);
    this.qiy.setOnInputValidChangeListener(this);
    this.qiz.setOnInputValidChangeListener(this);
    if (this.qim != 0)
    {
      this.dyR = ((TextView)findViewById(R.h.tip_tv));
      this.dyR.setVisibility(8);
      this.qiq = ((TextView)findViewById(R.h.gbg));
      this.qiA = com.tencent.mm.plugin.address.a.a.bZf().yy(this.qim);
      if ((this.qiA == null) || (this.qiA.type == null) || (!this.qiA.type.equals("0"))) {
        break label693;
      }
      this.qiq.setText(getString(R.l.gJR));
      this.qiq.setVisibility(0);
      this.qio.setVisibility(8);
      this.qin.setVisibility(8);
      if (this.qiA != null)
      {
        this.qis.setValStr(this.qiA.type);
        this.qit.setValStr(this.qiA.title);
        this.qiu.setValStr(this.qiA.JFh);
        this.qiv.setValStr(this.qiA.JFi);
        this.qiw.setValStr(this.qiA.JFo);
        this.qix.setValStr(this.qiA.JFm);
        this.qiy.setValStr(this.qiA.JFk);
        this.qiz.setValStr(this.qiA.JFj);
      }
    }
    if ((this.qiD) || (this.qiC))
    {
      this.qir = ((TextView)findViewById(R.h.fLR));
      if (this.qir != null) {
        this.qir.setVisibility(0);
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
      addTextOptionMenu(0, getString(R.l.app_save), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20831);
          if (AddInvoiceUI.f(AddInvoiceUI.this) == 0) {
            com.tencent.mm.plugin.report.service.h.OAn.b(14199, new Object[] { Integer.valueOf(3) });
          }
          while ((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bZn();
            AppMethodBeat.o(20831);
            return false;
            com.tencent.mm.plugin.report.service.h.OAn.b(14199, new Object[] { Integer.valueOf(4) });
          }
          if ((AddInvoiceUI.b(AddInvoiceUI.this) != null) && (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bZn();
            AppMethodBeat.o(20831);
            return false;
          }
          if ((AddInvoiceUI.f(AddInvoiceUI.this) != 0) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bZn();
            AppMethodBeat.o(20831);
            return false;
          }
          if (AddInvoiceUI.i(AddInvoiceUI.this).getText().length() > 100)
          {
            paramAnonymousMenuItem = AddInvoiceUI.this;
            k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(R.l.gJP), paramAnonymousMenuItem.getString(R.l.app_tip), false, null);
            AppMethodBeat.o(20831);
            return false;
          }
          if (!AddInvoiceUI.d(AddInvoiceUI.this))
          {
            if (((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated())) || ((AddInvoiceUI.j(AddInvoiceUI.this) != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type.equals("0"))))
            {
              if (!AddInvoiceUI.k(AddInvoiceUI.this).bZp())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(R.l.gJU), paramAnonymousMenuItem.getString(R.l.app_tip), false, null);
              }
              if (!AddInvoiceUI.l(AddInvoiceUI.this).bZp())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                k.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(R.l.gJN), paramAnonymousMenuItem.getString(R.l.app_tip), false, null);
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
            AddInvoiceUI.c(AddInvoiceUI.this).JFh = AddInvoiceUI.h(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).JFi = AddInvoiceUI.i(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).JFg = AddInvoiceUI.f(AddInvoiceUI.this);
            AddInvoiceUI.c(AddInvoiceUI.this).JFm = AddInvoiceUI.k(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).JFk = AddInvoiceUI.m(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).JFj = AddInvoiceUI.l(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).JFo = AddInvoiceUI.n(AddInvoiceUI.this).getText();
            AddInvoiceUI.o(AddInvoiceUI.this);
            AppMethodBeat.o(20831);
            return true;
            if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
            }
          }
        }
      }, null, y.b.adEJ);
      enableOptionMenu(false);
      bZk();
      AppMethodBeat.o(20835);
      return;
      label693:
      if ((this.qiA == null) || (this.qiA.type == null) || (!this.qiA.type.equals("1"))) {
        break;
      }
      this.qiq.setText(getString(R.l.gJT));
      break;
      this.qir = ((TextView)findViewById(R.h.fLR));
      if (this.qir != null) {
        this.qir.setVisibility(8);
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
        if (!Util.isNullOrNil(str))
        {
          Log.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.qix.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil(str))
        {
          Log.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.qix.setValStr(str);
        }
        this.hWu = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20837);
        return;
        if (paramInt2 != -1) {
          Log.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20834);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.qiC = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.qiD = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    bh.aZW().a(1191, this);
    Log.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.qiB = new com.tencent.mm.plugin.o.a.b();
    this.qim = getIntent().getIntExtra("invoice_id", 0);
    if (this.qim == 0) {
      setMMTitle(R.l.settings_add_invoice);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(20834);
      return;
      setMMTitle(R.l.settings_modify_invoice);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20836);
    bh.aZW().b(1180, this);
    bh.aZW().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(20836);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20841);
    if (paramInt == 4)
    {
      bZm();
      AppMethodBeat.o(20841);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(20841);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(20838);
    Log.i("MicroMsg.AddInvoiceUI", "errType " + paramInt1 + ",errCode " + paramInt2 + ",errMsg " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 1180)
      {
        paramString = ((i)paramp).qhI;
        if ((paramString != null) && (paramString.abwX != null) && (paramString.abwX.size() > 0) && (paramString.abwX.get(0) != null)) {
          this.kW = ((cxw)paramString.abwX.get(0)).group_id;
        }
        bh.aZW().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        bh.aZW().a(paramString, 0);
        AppMethodBeat.o(20838);
        return;
      }
      if (paramp.getType() == 1191)
      {
        bh.aZW().b(1191, this);
        if (this.qiC)
        {
          Log.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramp = this.qiB;
          if (paramp == null)
          {
            Log.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
            paramString = localObject;
          }
          for (;;)
          {
            setResult(-1, paramString);
            finish();
            AppMethodBeat.o(20838);
            return;
            paramString = new Intent();
            paramString.putExtra("type", paramp.type);
            if ((paramp.type != null) && (paramp.type.equals("1")))
            {
              paramString.putExtra("title", paramp.JFh);
            }
            else
            {
              paramString.putExtra("title", paramp.title);
              paramString.putExtra("tax_number", paramp.JFi);
              paramString.putExtra("company_address", paramp.JFo);
              paramString.putExtra("telephone", paramp.JFm);
              paramString.putExtra("bank_name", paramp.JFk);
              paramString.putExtra("bank_account", paramp.JFj);
            }
          }
        }
        if ((this.qim == 0) && (this.kW != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.kW);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.kW = 0;
        }
        finish();
        AppMethodBeat.o(20838);
      }
    }
    else
    {
      k.a(this, getString(R.l.gJW), getString(R.l.app_tip), false, null);
    }
    AppMethodBeat.o(20838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI
 * JD-Core Version:    0.7.0.1
 */