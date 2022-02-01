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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletAddAddressUI
  extends MMActivity
  implements g, AddrEditView.b
{
  private String dur;
  private AddrEditView iAA;
  private AddrEditView iAB;
  private AddrEditView iAC;
  private AddrEditView iAD;
  private AddrEditView iAE;
  private com.tencent.mm.plugin.address.d.b iAF;
  private com.tencent.mm.plugin.address.d.b iAG;
  private int iyW;
  private Dialog tipDialog;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(20988);
    this.iyW = 0;
    this.iAF = null;
    this.iAG = new com.tencent.mm.plugin.address.d.b();
    this.tipDialog = null;
    this.dur = "";
    AppMethodBeat.o(20988);
  }
  
  private static void a(com.tencent.mm.plugin.address.d.b paramb1, com.tencent.mm.plugin.address.d.b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.iyO = paramb1.iyO;
      paramb2.iyP = paramb1.iyP;
      paramb2.iyQ = paramb1.iyQ;
      paramb2.iyS = paramb1.iyS;
      paramb2.iyT = paramb1.iyT;
      paramb2.iyU = paramb1.iyU;
      paramb2.iyR = paramb1.iyR;
      paramb2.iyV = paramb1.iyV;
    }
  }
  
  private boolean aKT()
  {
    boolean bool2 = false;
    AppMethodBeat.i(20994);
    boolean bool1 = true;
    if (!this.iAA.aKX()) {
      bool1 = false;
    }
    if (!this.iAC.aKX()) {
      bool1 = false;
    }
    if (!this.iAB.aKX()) {
      bool1 = false;
    }
    if (!this.iAD.aKX()) {
      bool1 = false;
    }
    if (!this.iAE.aKX()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(20994);
      return bool1;
    }
  }
  
  private void aKV()
  {
    int k = 1;
    AppMethodBeat.i(20997);
    int j = 2131755176;
    if (this.iyW == 0) {
      j = 2131755175;
    }
    if (this.iAA.aKY()) {}
    for (int i = 1;; i = 0)
    {
      if (this.iAC.aKY()) {
        i = 1;
      }
      if (this.iAB.aKY()) {
        i = 1;
      }
      if (this.iAD.aKY()) {
        i = 1;
      }
      if (this.iAE.aKY()) {
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
  
  private void aLb()
  {
    AppMethodBeat.i(20998);
    Intent localIntent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    if (bt.T(this, localIntent))
    {
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(20998);
      return;
    }
    ad.w("MicroMsg.WalletAddAddressUI", "intent not available");
    AppMethodBeat.o(20998);
  }
  
  private void aLc()
  {
    AppMethodBeat.i(20999);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.iAB.getText())) {
      localStringBuilder.append(this.iAB.getText());
    }
    if (!TextUtils.isEmpty(this.iAC.getText())) {
      localStringBuilder.append(this.iAC.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    d.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(20999);
  }
  
  public final void aKU()
  {
    AppMethodBeat.i(20995);
    aKT();
    AppMethodBeat.o(20995);
  }
  
  public int getLayoutId()
  {
    return 2131495891;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20990);
    com.tencent.mm.plugin.address.a.a.aKQ().aKR();
    Object localObject = (MMScrollView)findViewById(2131306834);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.iAA = ((AddrEditView)findViewById(2131296486));
    this.iAB = ((AddrEditView)findViewById(2131296473));
    this.iAC = ((AddrEditView)findViewById(2131296474));
    this.iAD = ((AddrEditView)findViewById(2131296498));
    this.iAE = ((AddrEditView)findViewById(2131296488));
    this.iAA.setOnInputValidChangeListener(this);
    this.iAB.setOnInputValidChangeListener(this);
    this.iAC.setOnInputValidChangeListener(this);
    this.iAD.setOnInputValidChangeListener(this);
    this.iAE.setOnInputValidChangeListener(this);
    this.iAA.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(20976);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null);
        ad.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN() });
        if (!bool)
        {
          AppMethodBeat.o(20976);
          return;
        }
        WalletAddAddressUI.a(WalletAddAddressUI.this);
        AppMethodBeat.o(20976);
      }
    });
    this.iAB.setInfoIvOnClickListener(new AddrEditView.a()
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
    this.iAB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20982);
        WalletAddAddressUI.c(WalletAddAddressUI.this);
        AppMethodBeat.o(20982);
      }
    });
    if (this.iyW != 0)
    {
      this.iAF = com.tencent.mm.plugin.address.a.a.aKQ().qj(this.iyW);
      if (this.iAF == null)
      {
        ad.w("MicroMsg.WalletAddAddressUI", "addr is null");
        finish();
        AppMethodBeat.o(20990);
        return;
      }
      this.iAA.setValStr(this.iAF.iyT);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.iAF.iyO)) {
        ((StringBuilder)localObject).append(this.iAF.iyO);
      }
      if (!TextUtils.isEmpty(this.iAF.iyP))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.iAF.iyP);
      }
      if (!TextUtils.isEmpty(this.iAF.iyQ))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.iAF.iyQ);
      }
      this.iAB.setValStr(((StringBuilder)localObject).toString());
      this.iAC.setValStr(this.iAF.iyS);
      this.iAD.setValStr(this.iAF.iyR);
      this.iAE.setValStr(this.iAF.iyU);
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
          WalletAddAddressUI.a(WalletAddAddressUI.this, com.tencent.mm.plugin.address.a.a.aKQ().qj(WalletAddAddressUI.f(WalletAddAddressUI.this)));
          ad.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(WalletAddAddressUI.this).toString());
          WalletAddAddressUI.b(WalletAddAddressUI.g(WalletAddAddressUI.this), WalletAddAddressUI.h(WalletAddAddressUI.this));
          paramAnonymousMenuItem = WalletAddAddressUI.i(WalletAddAddressUI.this).getText();
          localObject = WalletAddAddressUI.j(WalletAddAddressUI.this).getText();
          str1 = WalletAddAddressUI.k(WalletAddAddressUI.this).getText();
          str2 = WalletAddAddressUI.l(WalletAddAddressUI.this).getText();
          str3 = WalletAddAddressUI.m(WalletAddAddressUI.this).getText();
          localObject = ((String)localObject).split(" ");
          if (localObject.length > 0) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).iyO = localObject[0];
          }
          if (localObject.length >= 2) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).iyP = localObject[1];
          }
          if (localObject.length < 3) {
            break label338;
          }
        }
        label338:
        for (WalletAddAddressUI.h(WalletAddAddressUI.this).iyQ = localObject[2];; WalletAddAddressUI.h(WalletAddAddressUI.this).iyQ = "")
        {
          WalletAddAddressUI.h(WalletAddAddressUI.this).iyS = str1;
          WalletAddAddressUI.h(WalletAddAddressUI.this).iyT = paramAnonymousMenuItem;
          WalletAddAddressUI.h(WalletAddAddressUI.this).iyU = str3;
          WalletAddAddressUI.h(WalletAddAddressUI.this).iyR = str2;
          if (!bt.isNullOrNil(WalletAddAddressUI.n(WalletAddAddressUI.this))) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).iyV = WalletAddAddressUI.n(WalletAddAddressUI.this);
          }
          WalletAddAddressUI.o(WalletAddAddressUI.this);
          AppMethodBeat.o(20984);
          return true;
          WalletAddAddressUI.a(WalletAddAddressUI.this, new com.tencent.mm.plugin.address.d.b());
          break;
        }
      }
    }, null, r.b.FOB);
    aKT();
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
          this.iAB.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!bt.isNullOrNil((String)localObject))
        {
          ad.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.iAD.setValStr((String)localObject);
        }
        this.dur = paramIntent.getStringExtra("kwcode");
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
          localObject = com.tencent.mm.pluginsdk.a.f(getBaseContext(), paramIntent);
          if ((localObject != null) && (localObject.length == 2)) {
            paramIntent = localObject[0];
          }
          for (localObject = localObject[1];; localObject = null)
          {
            this.iAA.setValStr(paramIntent);
            this.iAE.setValStr((String)localObject);
            if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
              break;
            }
            aKT();
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
                localObject = localAddr.hdT;
                paramIntent = (Intent)localObject;
                if (bt.isNullOrNil((String)localObject)) {
                  paramIntent = localAddr.hdS;
                }
                if (!com.tencent.mm.plugin.address.a.a.aKQ().z(localAddr.hdR, paramIntent, localAddr.hdU)) {
                  break label652;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localAddr.hdR);
                ((StringBuilder)localObject).append(" ");
                ((StringBuilder)localObject).append(paramIntent);
                if (!TextUtils.isEmpty(localAddr.hdU))
                {
                  ((StringBuilder)localObject).append(" ");
                  ((StringBuilder)localObject).append(localAddr.hdU);
                }
                this.iAB.setValStr(((StringBuilder)localObject).toString());
                paramIntent = new StringBuilder();
                if (!TextUtils.isEmpty(localAddr.hdV)) {
                  paramIntent.append(localAddr.hdV);
                }
                if (!TextUtils.isEmpty(localAddr.hdW)) {
                  paramIntent.append(localAddr.hdW);
                }
                if (!TextUtils.isEmpty(localAddr.hdX)) {
                  paramIntent.append(localAddr.hdX);
                }
                if (!TextUtils.isEmpty(localAddr.hdZ))
                {
                  paramIntent.append(" ");
                  paramIntent.append(localAddr.hdZ);
                }
                if ((!bt.isNullOrNil(localAddr.hdZ)) || (bt.isNullOrNil(localAddr.hdQ))) {
                  break label664;
                }
                this.iAC.setValStr(localAddr.hdQ);
              }
            }
            for (;;)
            {
              paramIntent = com.tencent.mm.plugin.address.a.a.aKQ().y(localAddr.hdR, localAddr.hdT, localAddr.hdU);
              if (paramIntent != null)
              {
                this.iAD.setValStr(paramIntent.iyB);
                this.dur = paramIntent.code;
              }
              AppMethodBeat.o(20992);
              return;
              label652:
              this.iAB.setValStr("");
              break;
              label664:
              this.iAC.setValStr(paramIntent.toString());
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
    az.aeS().a(415, this);
    az.aeS().a(418, this);
    ad.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    ad.Wj(0);
    this.iyW = getIntent().getIntExtra("address_id", 0);
    if (this.iyW == 0) {
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
    az.aeS().b(415, this);
    az.aeS().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.aKQ();
    ad.i("MicroMsg.WalletAddrMgr", "clean data");
    Iterator localIterator = locall.iyG.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    localIterator = locall.iyH.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    locall.iyF.clear();
    locall.iyG.clear();
    locall.iyH.clear();
    AppMethodBeat.o(20991);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20996);
    if (paramInt == 4)
    {
      aKV();
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
        aLb();
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
        aLc();
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$14", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
      paramString = com.tencent.mm.plugin.address.a.a.aKQ().iyD;
      if (paramString.iyM.size() > 0)
      {
        a(this.iAG, this.iAF);
        paramString = (com.tencent.mm.plugin.address.d.b)paramString.iyM.getFirst();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI
 * JD-Core Version:    0.7.0.1
 */