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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.address.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import java.util.LinkedList;

public class AddInvoiceUI
  extends MMActivity
  implements f, InvoiceEditView.c
{
  private int adG;
  private String dFb;
  private int jvb;
  private Button jvc;
  private Button jvd;
  private TextView jve;
  private TextView jvf;
  private TextView jvg;
  private InvoiceEditView jvh;
  private InvoiceEditView jvi;
  private InvoiceEditView jvj;
  private InvoiceEditView jvk;
  private InvoiceEditView jvl;
  private InvoiceEditView jvm;
  private InvoiceEditView jvn;
  private InvoiceEditView jvo;
  private com.tencent.mm.plugin.j.a.b jvp;
  private com.tencent.mm.plugin.j.a.b jvq;
  private boolean jvr;
  private boolean jvs;
  private Dialog tipDialog;
  private TextView vk;
  
  public AddInvoiceUI()
  {
    AppMethodBeat.i(20833);
    this.jvb = 0;
    this.jvc = null;
    this.jvd = null;
    this.jvg = null;
    this.jvp = null;
    this.jvq = new com.tencent.mm.plugin.j.a.b();
    this.tipDialog = null;
    this.jvr = false;
    this.jvs = false;
    this.dFb = "";
    this.adG = 0;
    AppMethodBeat.o(20833);
  }
  
  private void aF(String paramString, int paramInt)
  {
    AppMethodBeat.i(20843);
    h.a(this, getString(2131760391, new Object[] { paramString, Integer.valueOf(paramInt) }), getString(2131755906), false, null);
    AppMethodBeat.o(20843);
  }
  
  private boolean aVv()
  {
    boolean bool3 = false;
    AppMethodBeat.i(20839);
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool2 = true;
    boolean bool1;
    if (((this.jvd != null) && (this.jvd.isActivated())) || ((this.jvp != null) && (this.jvp.type != null) && (this.jvp.type.equals("0"))))
    {
      this.jvk.setVisibility(0);
      this.jvl.setVisibility(0);
      this.jvm.setVisibility(0);
      this.jvn.setVisibility(0);
      this.jvo.setVisibility(0);
      this.jvi.setVisibility(0);
      this.jvj.setVisibility(8);
      bool1 = bool2;
      if (!this.jvd.isActivated())
      {
        bool1 = bool2;
        if (!this.jvp.type.equals("0")) {
          bool1 = false;
        }
      }
      if (!this.jvi.aVz())
      {
        if (this.jvi.getText().length() > 100) {
          aF(getString(2131760414), 100);
        }
        bool1 = false;
      }
      if ((this.jvd == null) || (!this.jvd.isActivated()) || (this.jvi.getText().length() != 0)) {
        break label914;
      }
      bool1 = false;
    }
    label911:
    label914:
    for (;;)
    {
      enableOptionMenu(bool1);
      if (!this.jvk.aVz())
      {
        if (this.jvk.getText().length() > 0)
        {
          ViewStub localViewStub = (ViewStub)findViewById(2131306448);
          if (localViewStub != null)
          {
            localViewStub.inflate();
            this.jve = ((TextView)findViewById(2131306447));
          }
          if (this.jve != null) {
            this.jve.setVisibility(0);
          }
        }
        if (!this.jvl.aVz())
        {
          if (this.jvl.getText().length() > 100) {
            aF(getString(2131760393), 100);
          }
          bool1 = false;
        }
        if (!this.jvm.aVz())
        {
          if (this.jvm.getText().length() > 100) {
            aF(getString(2131760404), 100);
          }
          bool1 = false;
        }
        if (!this.jvn.aVz())
        {
          if (this.jvn.getText().length() > 100) {
            aF(getString(2131760386), 100);
          }
          bool1 = false;
        }
        if (this.jvo.aVz()) {
          break label911;
        }
        bool1 = bool3;
        if (this.jvo.getText().length() > 48)
        {
          aF(getString(2131760388), 39);
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(20839);
        return bool1;
        if (this.jve == null) {
          break;
        }
        this.jve.setVisibility(8);
        break;
        if (((this.jvc != null) && (this.jvc.isActivated())) || ((this.jvp != null) && (this.jvp.type != null) && (this.jvp.type.equals("1"))))
        {
          this.jvk.setVisibility(8);
          this.jvl.setVisibility(8);
          this.jvm.setVisibility(8);
          this.jvn.setVisibility(8);
          this.jvo.setVisibility(8);
          this.jvi.setVisibility(8);
          this.jvj.setVisibility(0);
          bool1 = bool4;
          if (!this.jvc.isActivated())
          {
            bool1 = bool4;
            if (!this.jvp.type.equals("1")) {
              bool1 = false;
            }
          }
          if (!this.jvj.aVz())
          {
            if (this.jvj.getText().length() > 100) {
              aF(getString(2131760414), 100);
            }
            bool1 = false;
          }
          bool2 = bool1;
          if (this.jvc != null)
          {
            bool2 = bool1;
            if (this.jvc.isActivated())
            {
              bool2 = bool1;
              if (this.jvj.getText().length() == 0) {
                bool2 = false;
              }
            }
          }
          enableOptionMenu(bool2);
          bool1 = bool2;
        }
        else
        {
          this.jvk.setVisibility(0);
          this.jvl.setVisibility(0);
          this.jvm.setVisibility(0);
          this.jvn.setVisibility(0);
          this.jvo.setVisibility(0);
          this.jvj.setVisibility(8);
          this.jvi.setVisibility(0);
          this.jvj.setVisibility(8);
          bool1 = bool5;
          if (this.jvc != null)
          {
            bool1 = bool5;
            if (!this.jvc.isActivated())
            {
              bool1 = bool5;
              if (this.jvd != null)
              {
                bool1 = bool5;
                if (!this.jvd.isActivated()) {
                  bool1 = false;
                }
              }
            }
          }
          if (!this.jvi.aVz()) {
            bool1 = false;
          }
          if (!this.jvk.aVz()) {
            bool1 = false;
          }
          if (!this.jvl.aVz()) {
            bool1 = false;
          }
          if (!this.jvm.aVz()) {
            bool1 = false;
          }
          bool2 = bool1;
          if (!this.jvn.aVz()) {
            bool2 = false;
          }
          bool1 = bool3;
          if (this.jvo.aVz()) {
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void aVx()
  {
    int k = 1;
    AppMethodBeat.i(20842);
    if (((this.jvb != 0) && (this.jvp != null) && (this.jvq.type != null) && (!this.jvq.type.equals("")) && (!this.jvq.type.equals(this.jvp.type))) || ((this.jvb == 0) && (this.jvq.type != null) && (!this.jvq.type.equals("")))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (this.jvc != null)
      {
        j = i;
        if (this.jvd != null)
        {
          j = i;
          if (!this.jvc.isActivated())
          {
            j = i;
            if (!this.jvd.isActivated())
            {
              j = i;
              if (this.jvp == null) {
                j = 1;
              }
            }
          }
        }
      }
      if (this.jvi.aVA()) {
        j = 1;
      }
      if (this.jvj.aVA()) {
        j = 1;
      }
      if (this.jvk.aVA()) {
        j = 1;
      }
      if (this.jvl.aVA()) {
        j = 1;
      }
      if (this.jvm.aVA()) {
        j = 1;
      }
      if (this.jvn.aVA()) {
        j = 1;
      }
      if (this.jvo.aVA()) {}
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
  
  public final void aVw()
  {
    AppMethodBeat.i(20840);
    aVv();
    AppMethodBeat.o(20840);
  }
  
  public final void aVy()
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
    this.jvc = ((Button)findViewById(2131301086));
    if (this.jvc != null) {
      this.jvc.setVisibility(0);
    }
    this.jvd = ((Button)findViewById(2131301084));
    if (this.jvd != null) {
      this.jvd.setVisibility(0);
    }
    if ((this.jvb == 0) && (this.jvd != null)) {
      this.jvd.setActivated(true);
    }
    if (this.jvd != null) {
      this.jvd.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(20828);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddInvoiceUI$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
    if (this.jvc != null) {
      this.jvc.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(20829);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/AddInvoiceUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
    this.jvh = ((InvoiceEditView)findViewById(2131301098));
    this.jvi = ((InvoiceEditView)findViewById(2131301097));
    this.jvj = ((InvoiceEditView)findViewById(2131301087));
    this.jvk = ((InvoiceEditView)findViewById(2131301096));
    this.jvl = ((InvoiceEditView)findViewById(2131301083));
    this.jvm = ((InvoiceEditView)findViewById(2131301088));
    this.jvn = ((InvoiceEditView)findViewById(2131301080));
    this.jvo = ((InvoiceEditView)findViewById(2131301081));
    this.jvk.jvL = true;
    this.jvk.jvF = true;
    this.jvk.setOnInputValidChangeListener(this);
    this.jvh.setOnInputValidChangeListener(this);
    this.jvi.setOnInputValidChangeListener(this);
    this.jvj.setOnInputValidChangeListener(this);
    this.jvl.setOnInputValidChangeListener(this);
    this.jvm.setOnInputValidChangeListener(this);
    this.jvn.setOnInputValidChangeListener(this);
    this.jvo.setOnInputValidChangeListener(this);
    if (this.jvb != 0)
    {
      this.vk = ((TextView)findViewById(2131305880));
      this.vk.setVisibility(8);
      this.jvf = ((TextView)findViewById(2131306179));
      this.jvp = com.tencent.mm.plugin.address.a.a.aVr().ry(this.jvb);
      if ((this.jvp == null) || (this.jvp.type == null) || (!this.jvp.type.equals("0"))) {
        break label693;
      }
      this.jvf.setText(getString(2131760396));
      this.jvf.setVisibility(0);
      this.jvd.setVisibility(8);
      this.jvc.setVisibility(8);
      if (this.jvp != null)
      {
        this.jvh.setValStr(this.jvp.type);
        this.jvi.setValStr(this.jvp.title);
        this.jvj.setValStr(this.jvp.uVp);
        this.jvk.setValStr(this.jvp.uVq);
        this.jvl.setValStr(this.jvp.uVw);
        this.jvm.setValStr(this.jvp.uVu);
        this.jvn.setValStr(this.jvp.uVs);
        this.jvo.setValStr(this.jvp.uVr);
      }
    }
    if ((this.jvs) || (this.jvr))
    {
      this.jvg = ((TextView)findViewById(2131301231));
      if (this.jvg != null) {
        this.jvg.setVisibility(0);
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
            g.yxI.f(14199, new Object[] { Integer.valueOf(3) });
          }
          while ((AddInvoiceUI.a(AddInvoiceUI.this) != null) && (AddInvoiceUI.a(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aVy();
            AppMethodBeat.o(20831);
            return false;
            g.yxI.f(14199, new Object[] { Integer.valueOf(4) });
          }
          if ((AddInvoiceUI.b(AddInvoiceUI.this) != null) && (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aVy();
            AppMethodBeat.o(20831);
            return false;
          }
          if ((AddInvoiceUI.f(AddInvoiceUI.this) != 0) && (AddInvoiceUI.h(AddInvoiceUI.this).getText().length() == 0) && (AddInvoiceUI.g(AddInvoiceUI.this).getText().length() == 0))
          {
            AddInvoiceUI.this.aVy();
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
              if (!AddInvoiceUI.k(AddInvoiceUI.this).aVz())
              {
                paramAnonymousMenuItem = AddInvoiceUI.this;
                h.a(paramAnonymousMenuItem, paramAnonymousMenuItem.getString(2131760403), paramAnonymousMenuItem.getString(2131755906), false, null);
              }
              if (!AddInvoiceUI.l(AddInvoiceUI.this).aVz())
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
            AddInvoiceUI.c(AddInvoiceUI.this).uVp = AddInvoiceUI.h(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uVq = AddInvoiceUI.i(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uVo = AddInvoiceUI.f(AddInvoiceUI.this);
            AddInvoiceUI.c(AddInvoiceUI.this).uVu = AddInvoiceUI.k(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uVs = AddInvoiceUI.m(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uVr = AddInvoiceUI.l(AddInvoiceUI.this).getText();
            AddInvoiceUI.c(AddInvoiceUI.this).uVw = AddInvoiceUI.n(AddInvoiceUI.this).getText();
            AddInvoiceUI.o(AddInvoiceUI.this);
            AppMethodBeat.o(20831);
            return true;
            if (AddInvoiceUI.b(AddInvoiceUI.this).isActivated()) {
              AddInvoiceUI.c(AddInvoiceUI.this).type = "1";
            }
          }
        }
      }, null, s.b.JwA);
      enableOptionMenu(false);
      aVv();
      AppMethodBeat.o(20835);
      return;
      label693:
      if ((this.jvp == null) || (this.jvp.type == null) || (!this.jvp.type.equals("1"))) {
        break;
      }
      this.jvf.setText(getString(2131760402));
      break;
      this.jvg = ((TextView)findViewById(2131301231));
      if (this.jvg != null) {
        this.jvg.setVisibility(8);
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
        if (!bu.isNullOrNil(str))
        {
          ae.d("MicroMsg.AddInvoiceUI", "AREA_RESULT:".concat(String.valueOf(str)));
          this.jvm.setValStr(str);
        }
        str = paramIntent.getStringExtra("kpost_code");
        if (!bu.isNullOrNil(str))
        {
          ae.d("MicroMsg.AddInvoiceUI", "post:".concat(String.valueOf(str)));
          this.jvm.setValStr(str);
        }
        this.dFb = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20837);
        return;
        if (paramInt2 != -1) {
          ae.i("MicroMsg.AddInvoiceUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20834);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.jvr = paramBundle.getBooleanExtra("launch_from_webview", false);
    this.jvs = paramBundle.getBooleanExtra("launch_from_invoicelist_webview", false);
    bc.ajj().a(1191, this);
    ae.d("MicroMsg.AddInvoiceUI", "index Oncreate");
    this.jvq = new com.tencent.mm.plugin.j.a.b();
    this.jvb = getIntent().getIntExtra("invoice_id", 0);
    if (this.jvb == 0) {
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
    bc.ajj().b(1180, this);
    bc.ajj().b(1191, this);
    getWindow().setSoftInputMode(3);
    super.onDestroy();
    AppMethodBeat.o(20836);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20841);
    if (paramInt == 4)
    {
      aVx();
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
    ae.i("MicroMsg.AddInvoiceUI", "errType " + paramInt1 + ",errCode " + paramInt2 + ",errMsg " + paramString);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1180)
      {
        paramString = ((i)paramn).juD;
        if ((paramString != null) && (paramString.HIn != null) && (paramString.HIn.size() > 0) && (paramString.HIn.get(0) != null)) {
          this.adG = ((bnk)paramString.HIn.get(0)).GuU;
        }
        bc.ajj().b(1180, this);
        paramString = new com.tencent.mm.plugin.address.model.b();
        bc.ajj().a(paramString, 0);
        AppMethodBeat.o(20838);
        return;
      }
      if (paramn.getType() == 1191)
      {
        bc.ajj().b(1191, this);
        if (this.jvr)
        {
          ae.i("MicroMsg.AddInvoiceUI", "isLaunchFromWebview true...");
          paramn = this.jvq;
          if (paramn == null)
          {
            ae.e("MicroMsg.InvoiceUtil", "invoiceObj == null");
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
              paramString.putExtra("title", paramn.uVp);
            }
            else
            {
              paramString.putExtra("title", paramn.title);
              paramString.putExtra("tax_number", paramn.uVq);
              paramString.putExtra("company_address", paramn.uVw);
              paramString.putExtra("telephone", paramn.uVu);
              paramString.putExtra("bank_name", paramn.uVs);
              paramString.putExtra("bank_account", paramn.uVr);
            }
          }
        }
        if ((this.jvb == 0) && (this.adG != 0))
        {
          paramString = new Intent();
          paramString.setClass(this, QrcodeInvoiceUI.class);
          paramString.putExtra("invoice_id", this.adG);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/address/ui/AddInvoiceUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramString.mt(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddInvoiceUI
 * JD-Core Version:    0.7.0.1
 */