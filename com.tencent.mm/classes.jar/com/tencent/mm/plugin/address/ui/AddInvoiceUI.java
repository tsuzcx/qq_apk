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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements f, InvoiceEditView.c
{
  private int adG;
  private String dDW;
  private int jsi;
  private Button jsj;
  private Button jsk;
  private TextView jsl;
  private TextView jsm;
  private TextView jsn;
  private InvoiceEditView jso;
  private InvoiceEditView jsp;
  private InvoiceEditView jsq;
  private InvoiceEditView jsr;
  private InvoiceEditView jss;
  private InvoiceEditView jst;
  private InvoiceEditView jsu;
  private InvoiceEditView jsv;
  private com.tencent.mm.plugin.j.a.b jsw;
  private com.tencent.mm.plugin.j.a.b jsx;
  private boolean jsy;
  private boolean jsz;
  private Dialog tipDialog;
  private TextView vk;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(20833);
    this.jsi = 0;
    this.jsj = null;
    this.jsk = null;
    this.jsn = null;
    this.jsw = null;
    this.jsx = new com.tencent.mm.plugin.j.a.b();
    this.tipDialog = null;
    this.jsy = false;
    this.jsz = false;
    this.dDW = "";
    this.adG = 0;
    AppMethodBeat.o(20833);
  }
  
  private void aE(String paramString, int paramInt)
  {
    AppMethodBeat.i(20843);
    h.a(this, getString(2131760391, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(2131755906), false, null);
    AppMethodBeat.o(20843);
  }
  
  private boolean aUW()
  {
    boolean bool3 = false;
    AppMethodBeat.i(20839);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.jsk != null) && (this.jsk.isActivated())) || ((this.jsw != null) && (this.jsw.type != null) && (this.jsw.type.equals("0"))))
    {
      this.jsr.setVisibility(0);
      this.jss.setVisibility(0);
      this.jst.setVisibility(0);
      this.jsu.setVisibility(0);
      this.jsv.setVisibility(0);
      this.jsp.setVisibility(0);
      this.jsq.setVisibility(8);
      bool1 = bool2;
      if (!this.jsk.isActivated())
      {
        bool1 = bool2;
        if (!this.jsw.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.jsp.aVa())
      {
        if (this.jsp.getText().length() > 100) {
          aE(getString(2131760414), 100);
        }
        bool1 = false;
      }
      if ((this.jsk == null) || (!this.jsk.isActivated()) || (this.jsp.getText().length() != 0)) {
        break label914;
      }
      bool1 = false;
    }
    label911:
    label914:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.jsr.aVa())
      {
        if (this.jsr.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(2131306448);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.jsl = ((TextView)findViewById(2131306447));
          }
          if (this.jsl != null) {
            this.jsl.setVisibility(0);
          }
        }
        if (!this.jss.aVa())
        {
          if (this.jss.getText().length() > 100) {
            aE(getString(2131760393), 100);
          }
          bool1 = false;
        }
        if (!this.jst.aVa())
        {
          if (this.jst.getText().length() > 100) {
            aE(getString(2131760404), 100);
          }
          bool1 = false;
        }
        if (!this.jsu.aVa())
        {
          if (this.jsu.getText().length() > 100) {
            aE(getString(2131760386), 100);
          }
          bool1 = false;
        }
        if (this.jsv.aVa()) {
          break label911;
        }
        bool1 = bool3;
        if (this.jsv.getText().length() > 48)
        {
          aE(getString(2131760388), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(20839);
        return bool1;
        if (this.jsl == null) {
          break;
        }
        this.jsl.setVisibility(8);
        break;
        if (((this.jsj != null) && (this.jsj.isActivated())) || ((this.jsw != null) && (this.jsw.type != null) && (this.jsw.type.equals("1"))))
        {
          this.jsr.setVisibility(8);
          this.jss.setVisibility(8);
          this.jst.setVisibility(8);
          this.jsu.setVisibility(8);
          this.jsv.setVisibility(8);
          this.jsp.setVisibility(8);
          this.jsq.setVisibility(0);
          bool1 = bool4;
          if (!this.jsj.isActivated())
          {
            bool1 = bool4;
            if (!this.jsw.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.jsq.aVa())
          {
            if (this.jsq.getText().length() > 100) {
              aE(getString(2131760414), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.jsj != null)
          {
            bool2 = bool1;
            if (this.jsj.isActivated())
            {
              bool2 = bool1;
              if (this.jsq.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.jsr.setVisibility(0);
          this.jss.setVisibility(0);
          this.jst.setVisibility(0);
          this.jsu.setVisibility(0);
          this.jsv.setVisibility(0);
          this.jsq.setVisibility(8);
          this.jsp.setVisibility(0);
          this.jsq.setVisibility(8);
          bool1 = bool5;
          if (this.jsj != null)
          {
            bool1 = bool5;
            if (!this.jsj.isActivated())
            {
              bool1 = bool5;
              if (this.jsk != null)
              {
                bool1 = bool5;
                if (!this.jsk.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.jsp.aVa()) {
            bool1 = false;
          }
          if (!this.jsr.aVa()) {
            bool1 = false;
          }
          if (!this.jss.aVa()) {
            bool1 = false;
          }
          if (!this.jst.aVa()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.jsu.aVa()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.jsv.aVa()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void aUY()
  {
    int k = 1;
    AppMethodBeat.i(20842);
    if (((this.jsi != 0) && (this.jsw != null) && (this.jsx.type != null) && (!this.jsx.type.equals("")) && (!this.jsx.type.equals(this.jsw.type))) || ((this.jsi == 0) && (this.jsx.type != null) && (!this.jsx.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.jsj != null)
      {
        j = i;
        if (this.jsk != null)
        {
          j = i;
          if (!this.jsj.isActivated())
          {
            j = i;
            if (!this.jsk.isActivated())
            {
              j = i;
              if (this.jsw == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.jsp.aVb()) {
        j = 1;
      }
      if (this.jsq.aVb()) {
        j = 1;
      }
      if (this.jsr.aVb()) {
        j = 1;
      }
      if (this.jss.aVb()) {
        j = 1;
      }
      if (this.jst.aVb()) {
        j = 1;
      }
      if (this.jsu.aVb()) {
        j = 1;
      }
      if (this.jsv.aVb()) {}
      for (i = k;; i = j)
      {
        if (i != 0)
        {
          h.a(this, false, getContext().getString(2131760385), "", getContext().getString(2131760384), getContext().getString(2131760383), new DialogInterface.OnClickListener()
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
  
  public final void aUX()
  {
    AppMethodBeat.i(20840);
    aUW();
    AppMethodBeat.o(20840);
  }
  
  public final void aUZ()
  {
    AppMethodBeat.i(20844);
    h.a(this, getString(2131760415), getString(2131755906), false, null);
    AppMethodBeat.o(20844);
  }
  
  public int getLayoutId()
  {
    return 2131494761;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20835);
    this.adG = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131301095);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.jsj = ((Button)findViewById(2131301086));
    if (this.jsj != null) {
      this.jsj.setVisibility(0);
    }
    this.jsk = ((Button)findViewById(2131301084));
    if (this.jsk != null) {
      this.jsk.setVisibility(0);
    }
    if ((this.jsi == 0) && (this.jsk != null)) {
      this.jsk.setActivated(true);
    }
    if (this.jsk != null) {
      this.jsk.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(20828);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddInvoiceUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(20828);
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() != 1)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(20828);
          return true;
        }
      });
    }
    if (this.jsj != null) {
      this.jsj.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(20829);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddInvoiceUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(20829);
            return true;
          }
          if (paramAnonymousMotionEvent.getAction() != 1)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(20829);
          return true;
        }
      });
    }
    this.jso = ((InvoiceEditView)findViewById(2131301098));
    this.jsp = ((InvoiceEditView)findViewById(2131301097));
    this.jsq = ((InvoiceEditView)findViewById(2131301087));
    this.jsr = ((InvoiceEditView)findViewById(2131301096));
    this.jss = ((InvoiceEditView)findViewById(2131301083));
    this.jst = ((InvoiceEditView)findViewById(2131301088));
    this.jsu = ((InvoiceEditView)findViewById(2131301080));
    this.jsv = ((InvoiceEditView)findViewById(2131301081));
    this.jsr.jsS = true;
    this.jsr.jsM = true;
    this.jsr.setOnInputValidChangeListener(this);
    this.jso.setOnInputValidChangeListener(this);
    this.jsp.setOnInputValidChangeListener(this);
    this.jsq.setOnInputValidChangeListener(this);
    this.jss.setOnInputValidChangeListener(this);
    this.jst.setOnInputValidChangeListener(this);
    this.jsu.setOnInputValidChangeListener(this);
    this.jsv.setOnInputValidChangeListener(this);
    if (this.jsi != 0)
    {
      this.vk = ((TextView)findViewById(2131305880));
      this.vk.setVisibility(8);
      this.jsm = ((TextView)findViewById(2131306179));
      this.jsw = com.tencent.mm.plugin.address.a.a.aUS().rv(this.jsi);
      if ((this.jsw == null) || (this.jsw.type == null) || (!this.jsw.type.equals("0"))) {
        break label693;
      }
      this.jsm.setText(getString(2131760396));
      this.jsm.setVisibility(0);
      this.jsk.setVisibility(8);
      this.jsj.setVisibility(8);
      if (this.jsw != null)
      {
        this.jso.setValStr(this.jsw.type);
        this.jsp.setValStr(this.jsw.title);
        this.jsq.setValStr(this.jsw.uJC);
        this.jsr.setValStr(this.jsw.uJD);
        this.jss.setValStr(this.jsw.uJJ);
        this.jst.setValStr(this.jsw.uJH);
        this.jsu.setValStr(this.jsw.uJF);
        this.jsv.setValStr(this.jsw.uJE);
      }
    }
    if ((this.jsz) || (this.jsy))
    {
      this.jsn = ((TextView)findViewById(2131301231));
      if (this.jsn != null) {
        this.jsn.setVisibility(0);
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
            g.yhR.f(14199, new Object[] { Integer.valueOf(3) });
          }
          while ((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aUZ();
            AppMethodBeat.o(20831);
            return false;
            g.yhR.f(14199, new Object[] { Integer.valueOf(4) });
          }
          if ((AddInvoiceUI.b(AddInvoiceUI.this) != null) && (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aUZ();
            AppMethodBeat.o(20831);
            return false;
          }
          if ((AddInvoiceUI.f(AddInvoiceUI.this) != 0) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aUZ();
            AppMethodBeat.o(20831);
            return false;
          }
          if (AddInvoiceUI.i(AddInvoiceUI.this).getText().length() > 100)
          {
            paramAnonymousMenuItem = AddInvoiceUI.this;
            h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760392), paramAnonymousMenuItem.getString(2131755906), false, null);
            AppMethodBeat.o(20831);
            return false;
          }
          if (!AddInvoiceUI.d(AddInvoiceUI.this))
          {
            if (((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated())) || ((AddInvoiceUI.j(AddInvoiceUI.this) != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type.equals("0"))))
            {
              if (!AddInvoiceUI.k(AddInvoiceUI.this).aVa())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760403), paramAnonymousMenuItem.getString(2131755906), false, null);
              }
              if (!AddInvoiceUI.l(AddInvoiceUI.this).aVa())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760389), paramAnonymousMenuItem.getString(2131755906), false, null);
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
            AddInvoiceUI.c(AddInvoiceUI.this).uJC = AddInvoiceUI.h(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uJD = AddInvoiceUI.i(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uJB = AddInvoiceUI.f(AddInvoiceUI.this);
            AddInvoiceUI.c(AddInvoiceUI.this).uJH = AddInvoiceUI.k(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uJF = AddInvoiceUI.m(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uJE = AddInvoiceUI.l(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uJJ = AddInvoiceUI.n(AddInvoiceUI.this).getText();
            AddInvoiceUI.o(AddInvoiceUI.this);
            AppMethodBeat.o(20831);
            return true;
            if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
            }
          }
        }
      }, null, s.b.JbS);
      enableOptionMenu(false);
      aUW();
      AppMethodBeat.o(20835);
      return;
      label693:
      if ((this.jsw == null) || (this.jsw.type == null) || (!this.jsw.type.equals("1"))) {
        break;
      }
      this.jsm.setText(getString(2131760402));
      break;
      this.jsn = ((TextView)findViewById(2131301231));
      if (this.jsn != null) {
        this.jsn.setVisibility(8);
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
          this.jst.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!bt.isNullOrNil(str))
        {
          ad.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.jst.setValStr(str);
        }
        this.dDW = paramIntent.getStringExtra("kwcode");
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
    this.jsy = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.jsz = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    ba.aiU().a(1191, this);
    ad.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.jsx = new com.tencent.mm.plugin.j.a.b();
    this.jsi = getIntent().getIntExtra("invoice_id", 0);
    if (this.jsi == 0) {
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
    ba.aiU().b(1180, this);
    ba.aiU().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(20836);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20841);
    if (paramInt == 4)
    {
      aUY();
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
        paramString = ((i)paramn).jrK;
        if ((paramString != null) && (paramString.HoL != null) && (paramString.HoL.size() > 0) && (paramString.HoL.get(0) != null)) {
          this.adG = ((bms)paramString.HoL.get(0)).Gcn;
        }
        ba.aiU().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        ba.aiU().a(paramString, 0);
        AppMethodBeat.o(20838);
        return;
      }
      if (paramn.getType() == 1191)
      {
        ba.aiU().b(1191, this);
        if (this.jsy)
        {
          ad.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramn = this.jsx;
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
              paramString.putExtra("title", paramn.uJC);
            }
            else
            {
              paramString.putExtra("title", paramn.title);
              paramString.putExtra("tax_number", paramn.uJD);
              paramString.putExtra("company_address", paramn.uJJ);
              paramString.putExtra("telephone", paramn.uJH);
              paramString.putExtra("bank_name", paramn.uJF);
              paramString.putExtra("bank_account", paramn.uJE);
            }
          }
        }
        if ((this.jsi == 0) && (this.adG != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.adG);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.adG = 0;
        }
        finish();
        AppMethodBeat.o(20838);
      }
    }
    else
    {
      h.a(this, getString(2131760408), getString(2131755906), false, null);
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