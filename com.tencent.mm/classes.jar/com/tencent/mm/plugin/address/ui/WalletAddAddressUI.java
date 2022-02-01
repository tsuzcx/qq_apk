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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private String dFb;
  private int jvb;
  private AddrEditView jwF;
  private AddrEditView jwG;
  private AddrEditView jwH;
  private AddrEditView jwI;
  private AddrEditView jwJ;
  private com.tencent.mm.plugin.address.d.b jwK;
  private com.tencent.mm.plugin.address.d.b jwL;
  private Dialog tipDialog;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(20988);
    this.jvb = 0;
    this.jwK = null;
    this.jwL = new com.tencent.mm.plugin.address.d.b();
    this.tipDialog = null;
    this.dFb = "";
    AppMethodBeat.o(20988);
  }
  
  private static void a(com.tencent.mm.plugin.address.d.b paramb1, com.tencent.mm.plugin.address.d.b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.juT = paramb1.juT;
      paramb2.juU = paramb1.juU;
      paramb2.juV = paramb1.juV;
      paramb2.juX = paramb1.juX;
      paramb2.juY = paramb1.juY;
      paramb2.juZ = paramb1.juZ;
      paramb2.juW = paramb1.juW;
      paramb2.jva = paramb1.jva;
    }
  }
  
  private void aVD()
  {
    AppMethodBeat.i(20998);
    Intent localIntent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    if (bu.aj(this, localIntent))
    {
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(20998);
      return;
    }
    ae.w("MicroMsg.WalletAddAddressUI", "intent not available");
    AppMethodBeat.o(20998);
  }
  
  private void aVE()
  {
    AppMethodBeat.i(20999);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.jwG.getText())) {
      localStringBuilder.append(this.jwG.getText());
    }
    if (!TextUtils.isEmpty(this.jwH.getText())) {
      localStringBuilder.append(this.jwH.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    d.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(20999);
  }
  
  private boolean aVv()
  {
    boolean bool2 = false;
    AppMethodBeat.i(20994);
    boolean bool1 = true;
    if (!this.jwF.aVz()) {
      bool1 = false;
    }
    if (!this.jwH.aVz()) {
      bool1 = false;
    }
    if (!this.jwG.aVz()) {
      bool1 = false;
    }
    if (!this.jwI.aVz()) {
      bool1 = false;
    }
    if (!this.jwJ.aVz()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(20994);
      return bool1;
    }
  }
  
  private void aVx()
  {
    int k = 1;
    AppMethodBeat.i(20997);
    int j = 2131755176;
    if (this.jvb == 0) {
      j = 2131755175;
    }
    if (this.jwF.aVA()) {}
    for (int i = 1;; i = 0)
    {
      if (this.jwH.aVA()) {
        i = 1;
      }
      if (this.jwG.aVA()) {
        i = 1;
      }
      if (this.jwI.aVA()) {
        i = 1;
      }
      if (this.jwJ.aVA()) {
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
  
  public final void aVw()
  {
    AppMethodBeat.i(20995);
    aVv();
    AppMethodBeat.o(20995);
  }
  
  public int getLayoutId()
  {
    return 2131495891;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20990);
    com.tencent.mm.plugin.address.a.a.aVs().aVt();
    Object localObject = (MMScrollView)findViewById(2131306834);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.jwF = ((AddrEditView)findViewById(2131296486));
    this.jwG = ((AddrEditView)findViewById(2131296473));
    this.jwH = ((AddrEditView)findViewById(2131296474));
    this.jwI = ((AddrEditView)findViewById(2131296498));
    this.jwJ = ((AddrEditView)findViewById(2131296488));
    this.jwF.setOnInputValidChangeListener(this);
    this.jwG.setOnInputValidChangeListener(this);
    this.jwH.setOnInputValidChangeListener(this);
    this.jwI.setOnInputValidChangeListener(this);
    this.jwJ.setOnInputValidChangeListener(this);
    this.jwF.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(20976);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null);
        ae.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN() });
        if (!bool)
        {
          AppMethodBeat.o(20976);
          return;
        }
        WalletAddAddressUI.a(WalletAddAddressUI.this);
        AppMethodBeat.o(20976);
      }
    });
    this.jwG.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(20981);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
        ae.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(20981);
          return;
        }
        WalletAddAddressUI.b(WalletAddAddressUI.this);
        AppMethodBeat.o(20981);
      }
    });
    this.jwG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20982);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletAddAddressUI.c(WalletAddAddressUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20982);
      }
    });
    if (this.jvb != 0)
    {
      this.jwK = com.tencent.mm.plugin.address.a.a.aVs().rz(this.jvb);
      if (this.jwK == null)
      {
        ae.w("MicroMsg.WalletAddAddressUI", "addr is null");
        finish();
        AppMethodBeat.o(20990);
        return;
      }
      this.jwF.setValStr(this.jwK.juY);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.jwK.juT)) {
        ((StringBuilder)localObject).append(this.jwK.juT);
      }
      if (!TextUtils.isEmpty(this.jwK.juU))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jwK.juU);
      }
      if (!TextUtils.isEmpty(this.jwK.juV))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jwK.juV);
      }
      this.jwG.setValStr(((StringBuilder)localObject).toString());
      this.jwH.setValStr(this.jwK.juX);
      this.jwI.setValStr(this.jwK.juW);
      this.jwJ.setValStr(this.jwK.juZ);
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
          WalletAddAddressUI.a(WalletAddAddressUI.this, com.tencent.mm.plugin.address.a.a.aVs().rz(WalletAddAddressUI.f(WalletAddAddressUI.this)));
          ae.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(WalletAddAddressUI.this).toString());
          WalletAddAddressUI.b(WalletAddAddressUI.g(WalletAddAddressUI.this), WalletAddAddressUI.h(WalletAddAddressUI.this));
          paramAnonymousMenuItem = WalletAddAddressUI.i(WalletAddAddressUI.this).getText();
          localObject = WalletAddAddressUI.j(WalletAddAddressUI.this).getText();
          str1 = WalletAddAddressUI.k(WalletAddAddressUI.this).getText();
          str2 = WalletAddAddressUI.l(WalletAddAddressUI.this).getText();
          str3 = WalletAddAddressUI.m(WalletAddAddressUI.this).getText();
          localObject = ((String)localObject).split(" ");
          if (localObject.length > 0) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).juT = localObject[0];
          }
          if (localObject.length >= 2) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).juU = localObject[1];
          }
          if (localObject.length < 3) {
            break label338;
          }
        }
        label338:
        for (WalletAddAddressUI.h(WalletAddAddressUI.this).juV = localObject[2];; WalletAddAddressUI.h(WalletAddAddressUI.this).juV = "")
        {
          WalletAddAddressUI.h(WalletAddAddressUI.this).juX = str1;
          WalletAddAddressUI.h(WalletAddAddressUI.this).juY = paramAnonymousMenuItem;
          WalletAddAddressUI.h(WalletAddAddressUI.this).juZ = str3;
          WalletAddAddressUI.h(WalletAddAddressUI.this).juW = str2;
          if (!bu.isNullOrNil(WalletAddAddressUI.n(WalletAddAddressUI.this))) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).jva = WalletAddAddressUI.n(WalletAddAddressUI.this);
          }
          WalletAddAddressUI.o(WalletAddAddressUI.this);
          AppMethodBeat.o(20984);
          return true;
          WalletAddAddressUI.a(WalletAddAddressUI.this, new com.tencent.mm.plugin.address.d.b());
          break;
        }
      }
    }, null, s.b.JwA);
    aVv();
    AppMethodBeat.o(20990);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20992);
    Object localObject;
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          AppMethodBeat.o(20992);
          return;
        } while (paramInt2 != -1);
        localObject = paramIntent.getStringExtra("karea_result");
        if (!bu.isNullOrNil((String)localObject))
        {
          ae.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(localObject)));
          this.jwG.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!bu.isNullOrNil((String)localObject))
        {
          ae.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.jwI.setValStr((String)localObject);
        }
        this.dFb = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20992);
        return;
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getData();
      if (paramIntent == null)
      {
        ae.d("MicroMsg.WalletAddAddressUI", "uri == null");
        AppMethodBeat.o(20992);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.b.g(getBaseContext(), paramIntent);
      if ((localObject != null) && (localObject.length == 2)) {
        paramIntent = localObject[0];
      }
      for (localObject = localObject[1];; localObject = null)
      {
        this.jwF.setValStr(paramIntent);
        this.jwJ.setValStr((String)localObject);
        if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
          break;
        }
        aVv();
        AppMethodBeat.o(20992);
        return;
        h.c(this, getString(2131755243), "", true);
        paramIntent = null;
      }
      h.c(this, getString(2131755243), "", true);
      AppMethodBeat.o(20992);
      return;
    }
    if (paramInt2 == -1)
    {
      Addr localAddr = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
      if (localAddr != null)
      {
        ae.d("MicroMsg.WalletAddAddressUI", "addr: " + localAddr.toString());
        if (localAddr != null)
        {
          localObject = localAddr.hZT;
          paramIntent = (Intent)localObject;
          if (bu.isNullOrNil((String)localObject)) {
            paramIntent = localAddr.hZS;
          }
          if (!com.tencent.mm.plugin.address.a.a.aVs().y(localAddr.hZR, paramIntent, localAddr.hZU)) {
            break label678;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localAddr.hZR);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramIntent);
          if (!TextUtils.isEmpty(localAddr.hZU))
          {
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(localAddr.hZU);
          }
          this.jwG.setValStr(((StringBuilder)localObject).toString());
          label466:
          paramIntent = new StringBuilder();
          if (!TextUtils.isEmpty(localAddr.hZV)) {
            paramIntent.append(localAddr.hZV);
          }
          if (!TextUtils.isEmpty(localAddr.hZW)) {
            paramIntent.append(localAddr.hZW);
          }
          if (!TextUtils.isEmpty(localAddr.hZX)) {
            paramIntent.append(localAddr.hZX);
          }
          if (!TextUtils.isEmpty(localAddr.hZZ))
          {
            paramIntent.append(" ");
            paramIntent.append(localAddr.hZZ);
          }
          if ((!bu.isNullOrNil(localAddr.hZZ)) || (bu.isNullOrNil(localAddr.hZQ))) {
            break label690;
          }
          this.jwH.setValStr(localAddr.hZQ);
          label600:
          paramIntent = com.tencent.mm.plugin.address.a.a.aVs().x(localAddr.hZR, localAddr.hZT, localAddr.hZU);
          if (paramIntent != null) {
            break label715;
          }
          paramIntent = com.tencent.mm.plugin.address.a.a.aVs().x(localAddr.hZR, localAddr.hZS, localAddr.hZU);
        }
      }
    }
    label678:
    label690:
    label715:
    for (;;)
    {
      if (paramIntent != null)
      {
        this.jwI.setValStr(paramIntent.juG);
        this.dFb = paramIntent.code;
      }
      AppMethodBeat.o(20992);
      return;
      this.jwG.setValStr("");
      break label466;
      this.jwH.setValStr(paramIntent.toString());
      break label600;
      ae.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20989);
    super.onCreate(paramBundle);
    bc.ajj().a(415, this);
    bc.ajj().a(418, this);
    ae.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    ae.abd(0);
    this.jvb = getIntent().getIntExtra("address_id", 0);
    if (this.jvb == 0) {
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
    bc.ajj().b(415, this);
    bc.ajj().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.aVs();
    ae.i("MicroMsg.WalletAddrMgr", "clean data");
    Iterator localIterator = locall.juL.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    localIterator = locall.juM.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    locall.juK.clear();
    locall.juL.clear();
    locall.juM.clear();
    AppMethodBeat.o(20991);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20996);
    if (paramInt == 4)
    {
      aVx();
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
      ae.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(21000);
      return;
    }
    ae.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aVD();
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
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        aVE();
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
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
      paramString = com.tencent.mm.plugin.address.a.a.aVs().juI;
      if (paramString.juR.size() > 0)
      {
        a(this.jwL, this.jwK);
        paramString = (com.tencent.mm.plugin.address.d.b)paramString.juR.getFirst();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI
 * JD-Core Version:    0.7.0.1
 */