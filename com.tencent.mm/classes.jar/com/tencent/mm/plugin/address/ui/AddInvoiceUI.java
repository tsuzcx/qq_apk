package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements com.tencent.mm.an.i, InvoiceEditView.c
{
  private TextView bFR;
  private String fQz;
  private int ka;
  private int nld;
  private Button nle;
  private Button nlf;
  private TextView nlg;
  private TextView nlh;
  private TextView nli;
  private InvoiceEditView nlj;
  private InvoiceEditView nlk;
  private InvoiceEditView nll;
  private InvoiceEditView nlm;
  private InvoiceEditView nln;
  private InvoiceEditView nlo;
  private InvoiceEditView nlp;
  private InvoiceEditView nlq;
  private com.tencent.mm.plugin.o.a.b nlr;
  private com.tencent.mm.plugin.o.a.b nls;
  private boolean nlt;
  private boolean nlu;
  private Dialog tipDialog;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(20833);
    this.nld = 0;
    this.nle = null;
    this.nlf = null;
    this.nli = null;
    this.nlr = null;
    this.nls = new com.tencent.mm.plugin.o.a.b();
    this.tipDialog = null;
    this.nlt = false;
    this.nlu = false;
    this.fQz = "";
    this.ka = 0;
    AppMethodBeat.o(20833);
  }
  
  private boolean bAu()
  {
    boolean bool3 = false;
    AppMethodBeat.i(20839);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.nlf != null) && (this.nlf.isActivated())) || ((this.nlr != null) && (this.nlr.type != null) && (this.nlr.type.equals("0"))))
    {
      this.nlm.setVisibility(0);
      this.nln.setVisibility(0);
      this.nlo.setVisibility(0);
      this.nlp.setVisibility(0);
      this.nlq.setVisibility(0);
      this.nlk.setVisibility(0);
      this.nll.setVisibility(8);
      bool1 = bool2;
      if (!this.nlf.isActivated())
      {
        bool1 = bool2;
        if (!this.nlr.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.nlk.bAz())
      {
        if (this.nlk.getText().length() > 100) {
          bc(getString(R.l.dJD), 100);
        }
        bool1 = false;
      }
      if ((this.nlf == null) || (!this.nlf.isActivated()) || (this.nlk.getText().length() != 0)) {
        break label922;
      }
      bool1 = false;
    }
    label919:
    label922:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.nlm.bAz())
      {
        if (this.nlm.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(R.h.dZu);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.nlg = ((TextView)findViewById(R.h.dZt));
          }
          if (this.nlg != null) {
            this.nlg.setVisibility(0);
          }
        }
        if (!this.nln.bAz())
        {
          if (this.nln.getText().length() > 100) {
            bc(getString(R.l.dJs), 100);
          }
          bool1 = false;
        }
        if (!this.nlo.bAz())
        {
          if (this.nlo.getText().length() > 100) {
            bc(getString(R.l.dJw), 100);
          }
          bool1 = false;
        }
        if (!this.nlp.bAz())
        {
          if (this.nlp.getText().length() > 100) {
            bc(getString(R.l.dJq), 100);
          }
          bool1 = false;
        }
        if (this.nlq.bAz()) {
          break label919;
        }
        bool1 = bool3;
        if (this.nlq.getText().length() > 48)
        {
          bc(getString(R.l.dJr), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(20839);
        return bool1;
        if (this.nlg == null) {
          break;
        }
        this.nlg.setVisibility(8);
        break;
        if (((this.nle != null) && (this.nle.isActivated())) || ((this.nlr != null) && (this.nlr.type != null) && (this.nlr.type.equals("1"))))
        {
          this.nlm.setVisibility(8);
          this.nln.setVisibility(8);
          this.nlo.setVisibility(8);
          this.nlp.setVisibility(8);
          this.nlq.setVisibility(8);
          this.nlk.setVisibility(8);
          this.nll.setVisibility(0);
          bool1 = bool4;
          if (!this.nle.isActivated())
          {
            bool1 = bool4;
            if (!this.nlr.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.nll.bAz())
          {
            if (this.nll.getText().length() > 100) {
              bc(getString(R.l.dJD), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.nle != null)
          {
            bool2 = bool1;
            if (this.nle.isActivated())
            {
              bool2 = bool1;
              if (this.nll.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.nlm.setVisibility(0);
          this.nln.setVisibility(0);
          this.nlo.setVisibility(0);
          this.nlp.setVisibility(0);
          this.nlq.setVisibility(0);
          this.nll.setVisibility(8);
          this.nlk.setVisibility(0);
          this.nll.setVisibility(8);
          bool1 = bool5;
          if (this.nle != null)
          {
            bool1 = bool5;
            if (!this.nle.isActivated())
            {
              bool1 = bool5;
              if (this.nlf != null)
              {
                bool1 = bool5;
                if (!this.nlf.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.nlk.bAz()) {
            bool1 = false;
          }
          if (!this.nlm.bAz()) {
            bool1 = false;
          }
          if (!this.nln.bAz()) {
            bool1 = false;
          }
          if (!this.nlo.bAz()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.nlp.bAz()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.nlq.bAz()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void bAw()
  {
    int k = 1;
    AppMethodBeat.i(20842);
    if (((this.nld != 0) && (this.nlr != null) && (this.nls.type != null) && (!this.nls.type.equals("")) && (!this.nls.type.equals(this.nlr.type))) || ((this.nld == 0) && (this.nls.type != null) && (!this.nls.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.nle != null)
      {
        j = i;
        if (this.nlf != null)
        {
          j = i;
          if (!this.nle.isActivated())
          {
            j = i;
            if (!this.nlf.isActivated())
            {
              j = i;
              if (this.nlr == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.nlk.bAA()) {
        j = 1;
      }
      if (this.nll.bAA()) {
        j = 1;
      }
      if (this.nlm.bAA()) {
        j = 1;
      }
      if (this.nln.bAA()) {
        j = 1;
      }
      if (this.nlo.bAA()) {
        j = 1;
      }
      if (this.nlp.bAA()) {
        j = 1;
      }
      if (this.nlq.bAA()) {}
      for (i = k;; i = j)
      {
        if (i != 0)
        {
          com.tencent.mm.ui.base.h.a(this, false, getContext().getString(R.l.eIf), "", getContext().getString(R.l.eIe), getContext().getString(R.l.eId), new DialogInterface.OnClickListener()
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
  
  private void bc(String paramString, int paramInt)
  {
    AppMethodBeat.i(20843);
    com.tencent.mm.ui.base.h.a(this, getString(R.l.eIh, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(R.l.app_tip), false, null);
    AppMethodBeat.o(20843);
  }
  
  public final void bAv()
  {
    AppMethodBeat.i(20840);
    bAu();
    AppMethodBeat.o(20840);
  }
  
  public final void bAx()
  {
    AppMethodBeat.i(20844);
    com.tencent.mm.ui.base.h.a(this, getString(R.l.eIs), getString(R.l.app_tip), false, null);
    AppMethodBeat.o(20844);
  }
  
  public int getLayoutId()
  {
    return R.i.eiG;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20835);
    this.ka = 0;
    MMScrollView localMMScrollView = (MMScrollView)findViewById(R.h.dJB);
    if (localMMScrollView != null) {
      localMMScrollView.a(localMMScrollView, localMMScrollView);
    }
    this.nle = ((Button)findViewById(R.h.dJu));
    if (this.nle != null) {
      this.nle.setVisibility(0);
    }
    this.nlf = ((Button)findViewById(R.h.dJt));
    if (this.nlf != null) {
      this.nlf.setVisibility(0);
    }
    if ((this.nld == 0) && (this.nlf != null)) {
      this.nlf.setActivated(true);
    }
    if (this.nlf != null) {
      this.nlf.setOnTouchListener(new View.OnTouchListener()
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
    if (this.nle != null) {
      this.nle.setOnTouchListener(new View.OnTouchListener()
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
    this.nlj = ((InvoiceEditView)findViewById(R.h.dJE));
    this.nlk = ((InvoiceEditView)findViewById(R.h.dJD));
    this.nll = ((InvoiceEditView)findViewById(R.h.dJv));
    this.nlm = ((InvoiceEditView)findViewById(R.h.dJC));
    this.nln = ((InvoiceEditView)findViewById(R.h.dJs));
    this.nlo = ((InvoiceEditView)findViewById(R.h.dJw));
    this.nlp = ((InvoiceEditView)findViewById(R.h.dJq));
    this.nlq = ((InvoiceEditView)findViewById(R.h.dJr));
    this.nlm.nlN = true;
    this.nlm.nlH = true;
    this.nlm.setOnInputValidChangeListener(this);
    this.nlj.setOnInputValidChangeListener(this);
    this.nlk.setOnInputValidChangeListener(this);
    this.nll.setOnInputValidChangeListener(this);
    this.nln.setOnInputValidChangeListener(this);
    this.nlo.setOnInputValidChangeListener(this);
    this.nlp.setOnInputValidChangeListener(this);
    this.nlq.setOnInputValidChangeListener(this);
    if (this.nld != 0)
    {
      this.bFR = ((TextView)findViewById(R.h.tip_tv));
      this.bFR.setVisibility(8);
      this.nlh = ((TextView)findViewById(R.h.dYs));
      this.nlr = com.tencent.mm.plugin.address.a.a.bAo().ys(this.nld);
      if ((this.nlr == null) || (this.nlr.type == null) || (!this.nlr.type.equals("0"))) {
        break label693;
      }
      this.nlh.setText(getString(R.l.eIk));
      this.nlh.setVisibility(0);
      this.nlf.setVisibility(8);
      this.nle.setVisibility(8);
      if (this.nlr != null)
      {
        this.nlj.setValStr(this.nlr.type);
        this.nlk.setValStr(this.nlr.title);
        this.nll.setValStr(this.nlr.DNS);
        this.nlm.setValStr(this.nlr.DNT);
        this.nln.setValStr(this.nlr.DNZ);
        this.nlo.setValStr(this.nlr.DNX);
        this.nlp.setValStr(this.nlr.DNV);
        this.nlq.setValStr(this.nlr.DNU);
      }
    }
    if ((this.nlu) || (this.nlt))
    {
      this.nli = ((TextView)findViewById(R.h.dKt));
      if (this.nli != null) {
        this.nli.setVisibility(0);
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
            com.tencent.mm.plugin.report.service.h.IzE.a(14199, new Object[] { Integer.valueOf(3) });
          }
          while ((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bAx();
            AppMethodBeat.o(20831);
            return false;
            com.tencent.mm.plugin.report.service.h.IzE.a(14199, new Object[] { Integer.valueOf(4) });
          }
          if ((AddInvoiceUI.b(AddInvoiceUI.this) != null) && (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bAx();
            AppMethodBeat.o(20831);
            return false;
          }
          if ((AddInvoiceUI.f(AddInvoiceUI.this) != 0) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.bAx();
            AppMethodBeat.o(20831);
            return false;
          }
          if (AddInvoiceUI.i(AddInvoiceUI.this).getText().length() > 100)
          {
            paramAnonymousMenuItem = AddInvoiceUI.this;
            com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(R.l.eIi), paramAnonymousMenuItem.getString(R.l.app_tip), false, null);
            AppMethodBeat.o(20831);
            return false;
          }
          if (!AddInvoiceUI.d(AddInvoiceUI.this))
          {
            if (((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated())) || ((AddInvoiceUI.j(AddInvoiceUI.this) != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type != null) && (AddInvoiceUI.j(AddInvoiceUI.this).type.equals("0"))))
            {
              if (!AddInvoiceUI.k(AddInvoiceUI.this).bAz())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(R.l.eIn), paramAnonymousMenuItem.getString(R.l.app_tip), false, null);
              }
              if (!AddInvoiceUI.l(AddInvoiceUI.this).bAz())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                com.tencent.mm.ui.base.h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(R.l.eIg), paramAnonymousMenuItem.getString(R.l.app_tip), false, null);
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
            AddInvoiceUI.c(AddInvoiceUI.this).DNS = AddInvoiceUI.h(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).DNT = AddInvoiceUI.i(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).DNR = AddInvoiceUI.f(AddInvoiceUI.this);
            AddInvoiceUI.c(AddInvoiceUI.this).DNX = AddInvoiceUI.k(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).DNV = AddInvoiceUI.m(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).DNU = AddInvoiceUI.l(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).DNZ = AddInvoiceUI.n(AddInvoiceUI.this).getText();
            AddInvoiceUI.o(AddInvoiceUI.this);
            AppMethodBeat.o(20831);
            return true;
            if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
            }
          }
        }
      }, null, w.b.Wao);
      enableOptionMenu(false);
      bAu();
      AppMethodBeat.o(20835);
      return;
      label693:
      if ((this.nlr == null) || (this.nlr.type == null) || (!this.nlr.type.equals("1"))) {
        break;
      }
      this.nlh.setText(getString(R.l.eIm));
      break;
      this.nli = ((TextView)findViewById(R.h.dKt));
      if (this.nli != null) {
        this.nli.setVisibility(8);
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
          this.nlo.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil(str))
        {
          Log.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.nlo.setValStr(str);
        }
        this.fQz = paramIntent.getStringExtra("kwcode");
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
    this.nlt = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.nlu = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    bh.aGY().a(1191, this);
    Log.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.nls = new com.tencent.mm.plugin.o.a.b();
    this.nld = getIntent().getIntExtra("invoice_id", 0);
    if (this.nld == 0) {
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
    bh.aGY().b(1180, this);
    bh.aGY().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(20836);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20841);
    if (paramInt == 4)
    {
      bAw();
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
        paramString = ((com.tencent.mm.plugin.address.model.i)paramq).nkz;
        if ((paramString != null) && (paramString.UfI != null) && (paramString.UfI.size() > 0) && (paramString.UfI.get(0) != null)) {
          this.ka = ((chw)paramString.UfI.get(0)).group_id;
        }
        bh.aGY().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        bh.aGY().a(paramString, 0);
        AppMethodBeat.o(20838);
        return;
      }
      if (paramq.getType() == 1191)
      {
        bh.aGY().b(1191, this);
        if (this.nlt)
        {
          Log.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramq = this.nls;
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
              paramString.putExtra("title", paramq.DNS);
            }
            else
            {
              paramString.putExtra("title", paramq.title);
              paramString.putExtra("tax_number", paramq.DNT);
              paramString.putExtra("company_address", paramq.DNZ);
              paramString.putExtra("telephone", paramq.DNX);
              paramString.putExtra("bank_name", paramq.DNV);
              paramString.putExtra("bank_account", paramq.DNU);
            }
          }
        }
        if ((this.nld == 0) && (this.ka != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.ka);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.ka = 0;
        }
        finish();
        AppMethodBeat.o(20838);
      }
    }
    else
    {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.eIp), getString(R.l.app_tip), false, null);
    }
    AppMethodBeat.o(20838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI
 * JD-Core Version:    0.7.0.1
 */