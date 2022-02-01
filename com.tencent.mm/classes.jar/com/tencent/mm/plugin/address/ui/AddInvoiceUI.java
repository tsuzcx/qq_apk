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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements com.tencent.mm.ak.i, InvoiceEditView.c
{
  private int adT;
  private String dWN;
  private InvoiceEditView ktA;
  private InvoiceEditView ktB;
  private InvoiceEditView ktC;
  private com.tencent.mm.plugin.j.a.b ktD;
  private com.tencent.mm.plugin.j.a.b ktE;
  private boolean ktF;
  private boolean ktG;
  private int ktp;
  private Button ktq;
  private Button ktr;
  private TextView kts;
  private TextView ktt;
  private TextView ktu;
  private InvoiceEditView ktv;
  private InvoiceEditView ktw;
  private InvoiceEditView ktx;
  private InvoiceEditView kty;
  private InvoiceEditView ktz;
  private Dialog tipDialog;
  private TextView vr;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(20833);
    this.ktp = 0;
    this.ktq = null;
    this.ktr = null;
    this.ktu = null;
    this.ktD = null;
    this.ktE = new com.tencent.mm.plugin.j.a.b();
    this.tipDialog = null;
    this.ktF = false;
    this.ktG = false;
    this.dWN = "";
    this.adT = 0;
    AppMethodBeat.o(20833);
  }
  
  private void aJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(20843);
    com.tencent.mm.ui.base.h.a(this, getString(2131761836, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(2131755998), false, null);
    AppMethodBeat.o(20843);
  }
  
  private boolean bqg()
  {
    boolean bool3 = false;
    AppMethodBeat.i(20839);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.ktr != null) && (this.ktr.isActivated())) || ((this.ktD != null) && (this.ktD.type != null) && (this.ktD.type.equals("0"))))
    {
      this.kty.setVisibility(0);
      this.ktz.setVisibility(0);
      this.ktA.setVisibility(0);
      this.ktB.setVisibility(0);
      this.ktC.setVisibility(0);
      this.ktw.setVisibility(0);
      this.ktx.setVisibility(8);
      bool1 = bool2;
      if (!this.ktr.isActivated())
      {
        bool1 = bool2;
        if (!this.ktD.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.ktw.bql())
      {
        if (this.ktw.getText().length() > 100) {
          aJ(getString(2131761859), 100);
        }
        bool1 = false;
      }
      if ((this.ktr == null) || (!this.ktr.isActivated()) || (this.ktw.getText().length() != 0)) {
        break label914;
      }
      bool1 = false;
    }
    label911:
    label914:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.kty.bql())
      {
        if (this.kty.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(2131309890);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.kts = ((TextView)findViewById(2131309889));
          }
          if (this.kts != null) {
            this.kts.setVisibility(0);
          }
        }
        if (!this.ktz.bql())
        {
          if (this.ktz.getText().length() > 100) {
            aJ(getString(2131761838), 100);
          }
          bool1 = false;
        }
        if (!this.ktA.bql())
        {
          if (this.ktA.getText().length() > 100) {
            aJ(getString(2131761849), 100);
          }
          bool1 = false;
        }
        if (!this.ktB.bql())
        {
          if (this.ktB.getText().length() > 100) {
            aJ(getString(2131761831), 100);
          }
          bool1 = false;
        }
        if (this.ktC.bql()) {
          break label911;
        }
        bool1 = bool3;
        if (this.ktC.getText().length() > 48)
        {
          aJ(getString(2131761833), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(20839);
        return bool1;
        if (this.kts == null) {
          break;
        }
        this.kts.setVisibility(8);
        break;
        if (((this.ktq != null) && (this.ktq.isActivated())) || ((this.ktD != null) && (this.ktD.type != null) && (this.ktD.type.equals("1"))))
        {
          this.kty.setVisibility(8);
          this.ktz.setVisibility(8);
          this.ktA.setVisibility(8);
          this.ktB.setVisibility(8);
          this.ktC.setVisibility(8);
          this.ktw.setVisibility(8);
          this.ktx.setVisibility(0);
          bool1 = bool4;
          if (!this.ktq.isActivated())
          {
            bool1 = bool4;
            if (!this.ktD.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.ktx.bql())
          {
            if (this.ktx.getText().length() > 100) {
              aJ(getString(2131761859), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.ktq != null)
          {
            bool2 = bool1;
            if (this.ktq.isActivated())
            {
              bool2 = bool1;
              if (this.ktx.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.kty.setVisibility(0);
          this.ktz.setVisibility(0);
          this.ktA.setVisibility(0);
          this.ktB.setVisibility(0);
          this.ktC.setVisibility(0);
          this.ktx.setVisibility(8);
          this.ktw.setVisibility(0);
          this.ktx.setVisibility(8);
          bool1 = bool5;
          if (this.ktq != null)
          {
            bool1 = bool5;
            if (!this.ktq.isActivated())
            {
              bool1 = bool5;
              if (this.ktr != null)
              {
                bool1 = bool5;
                if (!this.ktr.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.ktw.bql()) {
            bool1 = false;
          }
          if (!this.kty.bql()) {
            bool1 = false;
          }
          if (!this.ktz.bql()) {
            bool1 = false;
          }
          if (!this.ktA.bql()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.ktB.bql()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.ktC.bql()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void bqi()
  {
    int k = 1;
    AppMethodBeat.i(20842);
    if (((this.ktp != 0) && (this.ktD != null) && (this.ktE.type != null) && (!this.ktE.type.equals("")) && (!this.ktE.type.equals(this.ktD.type))) || ((this.ktp == 0) && (this.ktE.type != null) && (!this.ktE.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.ktq != null)
      {
        j = i;
        if (this.ktr != null)
        {
          j = i;
          if (!this.ktq.isActivated())
          {
            j = i;
            if (!this.ktr.isActivated())
            {
              j = i;
              if (this.ktD == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.ktw.bqm()) {
        j = 1;
      }
      if (this.ktx.bqm()) {
        j = 1;
      }
      if (this.kty.bqm()) {
        j = 1;
      }
      if (this.ktz.bqm()) {
        j = 1;
      }
      if (this.ktA.bqm()) {
        j = 1;
      }
      if (this.ktB.bqm()) {
        j = 1;
      }
      if (this.ktC.bqm()) {}
      for (i = k;; i = j)
      {
        if (i != 0)
        {
          com.tencent.mm.ui.base.h.a(this, false, getContext().getString(2131761830), "", getContext().getString(2131761829), getContext().getString(2131761828), new DialogInterface.OnClickListener()
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
  
  public final void bqh()
  {
    AppMethodBeat.i(20840);
    bqg();
    AppMethodBeat.o(20840);
  }
  
  public final void bqj()
  {
    AppMethodBeat.i(20844);
    com.tencent.mm.ui.base.h.a(this, getString(2131761860), getString(2131755998), false, null);
    AppMethodBeat.o(20844);
  }
  
  public int getLayoutId()
  {
    return 2131495495;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20835);
    this.adT = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(2131302749);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.ktq = ((Button)findViewById(2131302740));
    if (this.ktq != null) {
      this.ktq.setVisibility(0);
    }
    this.ktr = ((Button)findViewById(2131302738));
    if (this.ktr != null) {
      this.ktr.setVisibility(0);
    }
    if ((this.ktp == 0) && (this.ktr != null)) {
      this.ktr.setActivated(true);
    }
    if (this.ktr != null) {
      this.ktr.setOnTouchListener(new View.OnTouchListener()
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
    if (this.ktq != null) {
      this.ktq.setOnTouchListener(new View.OnTouchListener()
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
    this.ktv = ((InvoiceEditView)findViewById(2131302752));
    this.ktw = ((InvoiceEditView)findViewById(2131302751));
    this.ktx = ((InvoiceEditView)findViewById(2131302741));
    this.kty = ((InvoiceEditView)findViewById(2131302750));
    this.ktz = ((InvoiceEditView)findViewById(2131302737));
    this.ktA = ((InvoiceEditView)findViewById(2131302742));
    this.ktB = ((InvoiceEditView)findViewById(2131302734));
    this.ktC = ((InvoiceEditView)findViewById(2131302735));
    this.kty.ktZ = true;
    this.kty.ktT = true;
    this.kty.setOnInputValidChangeListener(this);
    this.ktv.setOnInputValidChangeListener(this);
    this.ktw.setOnInputValidChangeListener(this);
    this.ktx.setOnInputValidChangeListener(this);
    this.ktz.setOnInputValidChangeListener(this);
    this.ktA.setOnInputValidChangeListener(this);
    this.ktB.setOnInputValidChangeListener(this);
    this.ktC.setOnInputValidChangeListener(this);
    if (this.ktp != 0)
    {
      this.vr = ((TextView)findViewById(2131309163));
      this.vr.setVisibility(8);
      this.ktt = ((TextView)findViewById(2131309565));
      this.ktD = com.tencent.mm.plugin.address.a.a.bqc().vo(this.ktp);
      if ((this.ktD == null) || (this.ktD.type == null) || (!this.ktD.type.equals("0"))) {
        break label693;
      }
      this.ktt.setText(getString(2131761841));
      this.ktt.setVisibility(0);
      this.ktr.setVisibility(8);
      this.ktq.setVisibility(8);
      if (this.ktD != null)
      {
        this.ktv.setValStr(this.ktD.type);
        this.ktw.setValStr(this.ktD.title);
        this.ktx.setValStr(this.ktD.ynQ);
        this.kty.setValStr(this.ktD.ynR);
        this.ktz.setValStr(this.ktD.ynX);
        this.ktA.setValStr(this.ktD.ynV);
        this.ktB.setValStr(this.ktD.ynT);
        this.ktC.setValStr(this.ktD.ynS);
      }
    }
    if ((this.ktG) || (this.ktF))
    {
      this.ktu = ((TextView)findViewById(2131302919));
      if (this.ktu != null) {
        this.ktu.setVisibility(0);
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
      addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(20831);
          if (AddInvoiceUI.f(AddInvoiceUI.this) == 0) {
            com.tencent.mm.plugin.report.service.h.CyF.a(14199, new Object[] { Integer.valueOf(3) });
          }
          while ((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bqj();
            AppMethodBeat.o(20831);
            return false;
            com.tencent.mm.plugin.report.service.h.CyF.a(14199, new Object[] { Integer.valueOf(4) });
          }
          if ((AddInvoiceUI.b(AddInvoiceUI.this) != null) && (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bqj();
            AppMethodBeat.o(20831);
            return false;
          }
          if ((AddInvoiceUI.f(AddInvoiceUI.this) != 0) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bqj();
            AppMethodBeat.o(20831);
            return false;
          }
          if (AddInvoiceUI.i(AddInvoiceUI.this).getText().length() > 100)
          {
            paramAnonymousMenuItem = AddInvoiceUI.this;
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131761837), paramAnonymousMenuItem.getString(2131755998), false, null);
            AppMethodBeat.o(20831);
            return false;
          }
          if (!AddInvoiceUI.d(AddInvoiceUI.this))
          {
            if (((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated())) || ((AddInvoiceUI.j(AddInvoiceUI.this) != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type.equals("0"))))
            {
              if (!AddInvoiceUI.k(AddInvoiceUI.this).bql())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131761848), paramAnonymousMenuItem.getString(2131755998), false, null);
              }
              if (!AddInvoiceUI.l(AddInvoiceUI.this).bql())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131761834), paramAnonymousMenuItem.getString(2131755998), false, null);
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
            AddInvoiceUI.c(AddInvoiceUI.this).ynQ = AddInvoiceUI.h(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).ynR = AddInvoiceUI.i(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).ynP = AddInvoiceUI.f(AddInvoiceUI.this);
            AddInvoiceUI.c(AddInvoiceUI.this).ynV = AddInvoiceUI.k(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).ynT = AddInvoiceUI.m(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).ynS = AddInvoiceUI.l(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).ynX = AddInvoiceUI.n(AddInvoiceUI.this).getText();
            AddInvoiceUI.o(AddInvoiceUI.this);
            AppMethodBeat.o(20831);
            return true;
            if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
            }
          }
        }
      }, null, t.b.OGU);
      enableOptionMenu(false);
      bqg();
      AppMethodBeat.o(20835);
      return;
      label693:
      if ((this.ktD == null) || (this.ktD.type == null) || (!this.ktD.type.equals("1"))) {
        break;
      }
      this.ktt.setText(getString(2131761847));
      break;
      this.ktu = ((TextView)findViewById(2131302919));
      if (this.ktu != null) {
        this.ktu.setVisibility(8);
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
          this.ktA.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil(str))
        {
          Log.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.ktA.setValStr(str);
        }
        this.dWN = paramIntent.getStringExtra("kwcode");
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
    this.ktF = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.ktG = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    bg.azz().a(1191, this);
    Log.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.ktE = new com.tencent.mm.plugin.j.a.b();
    this.ktp = getIntent().getIntExtra("invoice_id", 0);
    if (this.ktp == 0) {
      setMMTitle(2131765335);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(20834);
      return;
      setMMTitle(2131765469);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20836);
    bg.azz().b(1180, this);
    bg.azz().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(20836);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20841);
    if (paramInt == 4)
    {
      bqi();
      AppMethodBeat.o(20841);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(20841);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(20838);
    Log.i("MicroMsg.AddInvoiceUI", "errType " + paramInt1 + ",errCode " + paramInt2 + ",errMsg " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 1180)
      {
        paramString = ((com.tencent.mm.plugin.address.model.i)paramq).ksS;
        if ((paramString != null) && (paramString.MTy != null) && (paramString.MTy.size() > 0) && (paramString.MTy.get(0) != null)) {
          this.adT = ((cab)paramString.MTy.get(0)).Lqz;
        }
        bg.azz().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        bg.azz().a(paramString, 0);
        AppMethodBeat.o(20838);
        return;
      }
      if (paramq.getType() == 1191)
      {
        bg.azz().b(1191, this);
        if (this.ktF)
        {
          Log.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramq = this.ktE;
          if (paramq == null)
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
            paramString.putExtra("type", paramq.type);
            if ((paramq.type != null) && (paramq.type.equals("1")))
            {
              paramString.putExtra("title", paramq.ynQ);
            }
            else
            {
              paramString.putExtra("title", paramq.title);
              paramString.putExtra("tax_number", paramq.ynR);
              paramString.putExtra("company_address", paramq.ynX);
              paramString.putExtra("telephone", paramq.ynV);
              paramString.putExtra("bank_name", paramq.ynT);
              paramString.putExtra("bank_account", paramq.ynS);
            }
          }
        }
        if ((this.ktp == 0) && (this.adT != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.adT);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.adT = 0;
        }
        finish();
        AppMethodBeat.o(20838);
      }
    }
    else
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131761853), getString(2131755998), false, null);
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