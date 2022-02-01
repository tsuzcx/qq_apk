package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletAddAddressUI
  extends MMActivity
  implements f, AddrEditView.b
{
  private String dDW;
  private int jsi;
  private AddrEditView jtK;
  private AddrEditView jtL;
  private AddrEditView jtM;
  private AddrEditView jtN;
  private AddrEditView jtO;
  private com.tencent.mm.plugin.address.d.b jtP;
  private com.tencent.mm.plugin.address.d.b jtQ;
  private Dialog tipDialog;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(20988);
    this.jsi = 0;
    this.jtP = null;
    this.jtQ = new com.tencent.mm.plugin.address.d.b();
    this.tipDialog = null;
    this.dDW = "";
    AppMethodBeat.o(20988);
  }
  
  private static void a(com.tencent.mm.plugin.address.d.b paramb1, com.tencent.mm.plugin.address.d.b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.jsa = paramb1.jsa;
      paramb2.jsb = paramb1.jsb;
      paramb2.jsc = paramb1.jsc;
      paramb2.jse = paramb1.jse;
      paramb2.jsf = paramb1.jsf;
      paramb2.jsg = paramb1.jsg;
      paramb2.jsd = paramb1.jsd;
      paramb2.jsh = paramb1.jsh;
    }
  }
  
  private boolean aUW()
  {
    boolean bool2 = false;
    AppMethodBeat.i(20994);
    boolean bool1 = true;
    if (!this.jtK.aVa()) {
      bool1 = false;
    }
    if (!this.jtM.aVa()) {
      bool1 = false;
    }
    if (!this.jtL.aVa()) {
      bool1 = false;
    }
    if (!this.jtN.aVa()) {
      bool1 = false;
    }
    if (!this.jtO.aVa()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(20994);
      return bool1;
    }
  }
  
  private void aUY()
  {
    int k = 1;
    AppMethodBeat.i(20997);
    int j = 2131755176;
    if (this.jsi == 0) {
      j = 2131755175;
    }
    if (this.jtK.aVb()) {}
    for (int i = 1;; i = 0)
    {
      if (this.jtM.aVb()) {
        i = 1;
      }
      if (this.jtL.aVb()) {
        i = 1;
      }
      if (this.jtN.aVb()) {
        i = 1;
      }
      if (this.jtO.aVb()) {
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          h.a(this, j, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(20987);
              WalletAddAddressUI.this.setResult(0);
              WalletAddAddressUI.this.finish();
              AppMethodBeat.o(20987);
            }
          }, null);
          AppMethodBeat.o(20997);
          return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(20997);
        return;
      }
    }
  }
  
  private void aVe()
  {
    AppMethodBeat.i(20998);
    Intent localIntent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    if (bt.aj(this, localIntent))
    {
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(20998);
      return;
    }
    ad.w("MicroMsg.WalletAddAddressUI", "intent not available");
    AppMethodBeat.o(20998);
  }
  
  private void aVf()
  {
    AppMethodBeat.i(20999);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.jtL.getText())) {
      localStringBuilder.append(this.jtL.getText());
    }
    if (!TextUtils.isEmpty(this.jtM.getText())) {
      localStringBuilder.append(this.jtM.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    d.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(20999);
  }
  
  public final void aUX()
  {
    AppMethodBeat.i(20995);
    aUW();
    AppMethodBeat.o(20995);
  }
  
  public int getLayoutId()
  {
    return 2131495891;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20990);
    com.tencent.mm.plugin.address.a.a.aUT().aUU();
    Object localObject = (MMScrollView)findViewById(2131306834);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.jtK = ((AddrEditView)findViewById(2131296486));
    this.jtL = ((AddrEditView)findViewById(2131296473));
    this.jtM = ((AddrEditView)findViewById(2131296474));
    this.jtN = ((AddrEditView)findViewById(2131296498));
    this.jtO = ((AddrEditView)findViewById(2131296488));
    this.jtK.setOnInputValidChangeListener(this);
    this.jtL.setOnInputValidChangeListener(this);
    this.jtM.setOnInputValidChangeListener(this);
    this.jtN.setOnInputValidChangeListener(this);
    this.jtO.setOnInputValidChangeListener(this);
    this.jtK.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(20976);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null);
        ad.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.flS() });
        if (!bool)
        {
          AppMethodBeat.o(20976);
          return;
        }
        WalletAddAddressUI.a(WalletAddAddressUI.this);
        AppMethodBeat.o(20976);
      }
    });
    this.jtL.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(20981);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
        ad.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(20981);
          return;
        }
        WalletAddAddressUI.b(WalletAddAddressUI.this);
        AppMethodBeat.o(20981);
      }
    });
    this.jtL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20982);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletAddAddressUI.c(WalletAddAddressUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20982);
      }
    });
    if (this.jsi != 0)
    {
      this.jtP = com.tencent.mm.plugin.address.a.a.aUT().rw(this.jsi);
      if (this.jtP == null)
      {
        ad.w("MicroMsg.WalletAddAddressUI", "addr is null");
        finish();
        AppMethodBeat.o(20990);
        return;
      }
      this.jtK.setValStr(this.jtP.jsf);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.jtP.jsa)) {
        ((StringBuilder)localObject).append(this.jtP.jsa);
      }
      if (!TextUtils.isEmpty(this.jtP.jsb))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jtP.jsb);
      }
      if (!TextUtils.isEmpty(this.jtP.jsc))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jtP.jsc);
      }
      this.jtL.setValStr(((StringBuilder)localObject).toString());
      this.jtM.setValStr(this.jtP.jse);
      this.jtN.setValStr(this.jtP.jsd);
      this.jtO.setValStr(this.jtP.jsg);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(20983);
        WalletAddAddressUI.d(WalletAddAddressUI.this);
        AppMethodBeat.o(20983);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(20984);
        if (!WalletAddAddressUI.e(WalletAddAddressUI.this))
        {
          AppMethodBeat.o(20984);
          return true;
        }
        Object localObject;
        String str1;
        String str2;
        String str3;
        if (WalletAddAddressUI.f(WalletAddAddressUI.this) != 0)
        {
          WalletAddAddressUI.a(WalletAddAddressUI.this, com.tencent.mm.plugin.address.a.a.aUT().rw(WalletAddAddressUI.f(WalletAddAddressUI.this)));
          ad.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(WalletAddAddressUI.this).toString());
          WalletAddAddressUI.b(WalletAddAddressUI.g(WalletAddAddressUI.this), WalletAddAddressUI.h(WalletAddAddressUI.this));
          paramAnonymousMenuItem = WalletAddAddressUI.i(WalletAddAddressUI.this).getText();
          localObject = WalletAddAddressUI.j(WalletAddAddressUI.this).getText();
          str1 = WalletAddAddressUI.k(WalletAddAddressUI.this).getText();
          str2 = WalletAddAddressUI.l(WalletAddAddressUI.this).getText();
          str3 = WalletAddAddressUI.m(WalletAddAddressUI.this).getText();
          localObject = ((String)localObject).split(" ");
          if (localObject.length > 0) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).jsa = localObject[0];
          }
          if (localObject.length >= 2) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).jsb = localObject[1];
          }
          if (localObject.length < 3) {
            break label338;
          }
        }
        label338:
        for (WalletAddAddressUI.h(WalletAddAddressUI.this).jsc = localObject[2];; WalletAddAddressUI.h(WalletAddAddressUI.this).jsc = "")
        {
          WalletAddAddressUI.h(WalletAddAddressUI.this).jse = str1;
          WalletAddAddressUI.h(WalletAddAddressUI.this).jsf = paramAnonymousMenuItem;
          WalletAddAddressUI.h(WalletAddAddressUI.this).jsg = str3;
          WalletAddAddressUI.h(WalletAddAddressUI.this).jsd = str2;
          if (!bt.isNullOrNil(WalletAddAddressUI.n(WalletAddAddressUI.this))) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).jsh = WalletAddAddressUI.n(WalletAddAddressUI.this);
          }
          WalletAddAddressUI.o(WalletAddAddressUI.this);
          AppMethodBeat.o(20984);
          return true;
          WalletAddAddressUI.a(WalletAddAddressUI.this, new com.tencent.mm.plugin.address.d.b());
          break;
        }
      }
    }, null, s.b.JbS);
    aUW();
    AppMethodBeat.o(20990);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20992);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20992);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = paramIntent.getStringExtra("karea_result");
        if (!bt.isNullOrNil((String)localObject))
        {
          ad.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(localObject)));
          this.jtL.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!bt.isNullOrNil((String)localObject))
        {
          ad.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.jtN.setValStr((String)localObject);
        }
        this.dDW = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20992);
        return;
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getData();
          if (paramIntent == null)
          {
            ad.d("MicroMsg.WalletAddAddressUI", "uri == null");
            AppMethodBeat.o(20992);
            return;
          }
          localObject = com.tencent.mm.pluginsdk.b.g(getBaseContext(), paramIntent);
          if ((localObject != null) && (localObject.length == 2)) {
            paramIntent = localObject[0];
          }
          for (localObject = localObject[1];; localObject = null)
          {
            this.jtK.setValStr(paramIntent);
            this.jtO.setValStr((String)localObject);
            if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
              break;
            }
            aUW();
            AppMethodBeat.o(20992);
            return;
            h.c(this, getString(2131755243), "", true);
            paramIntent = null;
          }
          h.c(this, getString(2131755243), "", true);
          AppMethodBeat.o(20992);
          return;
          if (paramInt2 == -1)
          {
            Addr localAddr = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
            if (localAddr != null)
            {
              ad.d("MicroMsg.WalletAddAddressUI", "addr: " + localAddr.toString());
              if (localAddr != null)
              {
                localObject = localAddr.hXb;
                paramIntent = (Intent)localObject;
                if (bt.isNullOrNil((String)localObject)) {
                  paramIntent = localAddr.hXa;
                }
                if (!com.tencent.mm.plugin.address.a.a.aUT().y(localAddr.hWZ, paramIntent, localAddr.hXc)) {
                  break label652;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localAddr.hWZ);
                ((StringBuilder)localObject).append(" ");
                ((StringBuilder)localObject).append(paramIntent);
                if (!TextUtils.isEmpty(localAddr.hXc))
                {
                  ((StringBuilder)localObject).append(" ");
                  ((StringBuilder)localObject).append(localAddr.hXc);
                }
                this.jtL.setValStr(((StringBuilder)localObject).toString());
                paramIntent = new StringBuilder();
                if (!TextUtils.isEmpty(localAddr.hXd)) {
                  paramIntent.append(localAddr.hXd);
                }
                if (!TextUtils.isEmpty(localAddr.hXe)) {
                  paramIntent.append(localAddr.hXe);
                }
                if (!TextUtils.isEmpty(localAddr.hXf)) {
                  paramIntent.append(localAddr.hXf);
                }
                if (!TextUtils.isEmpty(localAddr.hXh))
                {
                  paramIntent.append(" ");
                  paramIntent.append(localAddr.hXh);
                }
                if ((!bt.isNullOrNil(localAddr.hXh)) || (bt.isNullOrNil(localAddr.hWY))) {
                  break label664;
                }
                this.jtM.setValStr(localAddr.hWY);
              }
            }
            for (;;)
            {
              paramIntent = com.tencent.mm.plugin.address.a.a.aUT().x(localAddr.hWZ, localAddr.hXb, localAddr.hXc);
              if (paramIntent != null)
              {
                this.jtN.setValStr(paramIntent.jrN);
                this.dDW = paramIntent.code;
              }
              AppMethodBeat.o(20992);
              return;
              label652:
              this.jtL.setValStr("");
              break;
              label664:
              this.jtM.setValStr(paramIntent.toString());
            }
          }
          ad.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20989);
    super.onCreate(paramBundle);
    ba.aiU().a(415, this);
    ba.aiU().a(418, this);
    ad.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    ad.aax(0);
    this.jsi = getIntent().getIntExtra("address_id", 0);
    if (this.jsi == 0) {
      setMMTitle(2131755173);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(20989);
      return;
      setMMTitle(2131755212);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20991);
    super.onDestroy();
    ba.aiU().b(415, this);
    ba.aiU().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.aUT();
    ad.i("MicroMsg.WalletAddrMgr", "clean data");
    Iterator localIterator = locall.jrS.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    localIterator = locall.jrT.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    locall.jrR.clear();
    locall.jrS.clear();
    locall.jrT.clear();
    AppMethodBeat.o(20991);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20996);
    if (paramInt == 4)
    {
      aUY();
      AppMethodBeat.o(20996);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(20996);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(21000);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(21000);
      return;
    }
    ad.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aVe();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20977);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = WalletAddAddressUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20977);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20978);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(20978);
        }
      });
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aVf();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20979);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = WalletAddAddressUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20979);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20980);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(20980);
        }
      });
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20993);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.address.a.a.aUT().jrP;
      if (paramString.jrY.size() > 0)
      {
        a(this.jtQ, this.jtP);
        paramString = (com.tencent.mm.plugin.address.d.b)paramString.jrY.getFirst();
        if (paramString != null) {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(paramString));
        }
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(20993);
        return;
        setResult(0);
        continue;
        setResult(0);
      }
    }
    switch (paramInt2)
    {
    case -3101: 
    default: 
      h.a(this, 2131755170, 0, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(20993);
      return;
    case -3100: 
      h.a(this, 2131755172, 0, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20985);
          WalletAddAddressUI.this.finish();
          AppMethodBeat.o(20985);
        }
      });
      AppMethodBeat.o(20993);
      return;
    }
    h.d(this, paramString, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(20986);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(20986);
      }
    });
    AppMethodBeat.o(20993);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI
 * JD-Core Version:    0.7.0.1
 */