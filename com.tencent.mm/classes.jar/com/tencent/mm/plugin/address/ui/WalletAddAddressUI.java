package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements g, AddrEditView.b
{
  private String dsc;
  private int iYZ;
  private AddrEditView jaB;
  private AddrEditView jaC;
  private AddrEditView jaD;
  private AddrEditView jaE;
  private AddrEditView jaF;
  private b jaG;
  private b jaH;
  private Dialog tipDialog;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(20988);
    this.iYZ = 0;
    this.jaG = null;
    this.jaH = new b();
    this.tipDialog = null;
    this.dsc = "";
    AppMethodBeat.o(20988);
  }
  
  private static void a(b paramb1, b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.iYR = paramb1.iYR;
      paramb2.iYS = paramb1.iYS;
      paramb2.iYT = paramb1.iYT;
      paramb2.iYV = paramb1.iYV;
      paramb2.iYW = paramb1.iYW;
      paramb2.iYX = paramb1.iYX;
      paramb2.iYU = paramb1.iYU;
      paramb2.iYY = paramb1.iYY;
    }
  }
  
  private boolean aRK()
  {
    boolean bool2 = false;
    AppMethodBeat.i(20994);
    boolean bool1 = true;
    if (!this.jaB.aRO()) {
      bool1 = false;
    }
    if (!this.jaD.aRO()) {
      bool1 = false;
    }
    if (!this.jaC.aRO()) {
      bool1 = false;
    }
    if (!this.jaE.aRO()) {
      bool1 = false;
    }
    if (!this.jaF.aRO()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(20994);
      return bool1;
    }
  }
  
  private void aRM()
  {
    int k = 1;
    AppMethodBeat.i(20997);
    int j = 2131755176;
    if (this.iYZ == 0) {
      j = 2131755175;
    }
    if (this.jaB.aRP()) {}
    for (int i = 1;; i = 0)
    {
      if (this.jaD.aRP()) {
        i = 1;
      }
      if (this.jaC.aRP()) {
        i = 1;
      }
      if (this.jaE.aRP()) {
        i = 1;
      }
      if (this.jaF.aRP()) {
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          h.a(this, j, 2131755906, new WalletAddAddressUI.15(this), null);
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
  
  private void aRS()
  {
    AppMethodBeat.i(20998);
    Intent localIntent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    if (bs.ah(this, localIntent))
    {
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(20998);
      return;
    }
    ac.w("MicroMsg.WalletAddAddressUI", "intent not available");
    AppMethodBeat.o(20998);
  }
  
  private void aRT()
  {
    AppMethodBeat.i(20999);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.jaC.getText())) {
      localStringBuilder.append(this.jaC.getText());
    }
    if (!TextUtils.isEmpty(this.jaD.getText())) {
      localStringBuilder.append(this.jaD.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    d.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(20999);
  }
  
  public final void aRL()
  {
    AppMethodBeat.i(20995);
    aRK();
    AppMethodBeat.o(20995);
  }
  
  public int getLayoutId()
  {
    return 2131495891;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20990);
    com.tencent.mm.plugin.address.a.a.aRH().aRI();
    Object localObject = (MMScrollView)findViewById(2131306834);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.jaB = ((AddrEditView)findViewById(2131296486));
    this.jaC = ((AddrEditView)findViewById(2131296473));
    this.jaD = ((AddrEditView)findViewById(2131296474));
    this.jaE = ((AddrEditView)findViewById(2131296498));
    this.jaF = ((AddrEditView)findViewById(2131296488));
    this.jaB.setOnInputValidChangeListener(this);
    this.jaC.setOnInputValidChangeListener(this);
    this.jaD.setOnInputValidChangeListener(this);
    this.jaE.setOnInputValidChangeListener(this);
    this.jaF.setOnInputValidChangeListener(this);
    this.jaB.setInfoIvOnClickListener(new WalletAddAddressUI.1(this));
    this.jaC.setInfoIvOnClickListener(new WalletAddAddressUI.8(this));
    this.jaC.setOnClickListener(new WalletAddAddressUI.9(this));
    if (this.iYZ != 0)
    {
      this.jaG = com.tencent.mm.plugin.address.a.a.aRH().qW(this.iYZ);
      if (this.jaG == null)
      {
        ac.w("MicroMsg.WalletAddAddressUI", "addr is null");
        finish();
        AppMethodBeat.o(20990);
        return;
      }
      this.jaB.setValStr(this.jaG.iYW);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.jaG.iYR)) {
        ((StringBuilder)localObject).append(this.jaG.iYR);
      }
      if (!TextUtils.isEmpty(this.jaG.iYS))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jaG.iYS);
      }
      if (!TextUtils.isEmpty(this.jaG.iYT))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.jaG.iYT);
      }
      this.jaC.setValStr(((StringBuilder)localObject).toString());
      this.jaD.setValStr(this.jaG.iYV);
      this.jaE.setValStr(this.jaG.iYU);
      this.jaF.setValStr(this.jaG.iYX);
    }
    setBackBtn(new WalletAddAddressUI.10(this));
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
          WalletAddAddressUI.a(WalletAddAddressUI.this, com.tencent.mm.plugin.address.a.a.aRH().qW(WalletAddAddressUI.f(WalletAddAddressUI.this)));
          ac.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(WalletAddAddressUI.this).toString());
          WalletAddAddressUI.b(WalletAddAddressUI.g(WalletAddAddressUI.this), WalletAddAddressUI.h(WalletAddAddressUI.this));
          paramAnonymousMenuItem = WalletAddAddressUI.i(WalletAddAddressUI.this).getText();
          localObject = WalletAddAddressUI.j(WalletAddAddressUI.this).getText();
          str1 = WalletAddAddressUI.k(WalletAddAddressUI.this).getText();
          str2 = WalletAddAddressUI.l(WalletAddAddressUI.this).getText();
          str3 = WalletAddAddressUI.m(WalletAddAddressUI.this).getText();
          localObject = ((String)localObject).split(" ");
          if (localObject.length > 0) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).iYR = localObject[0];
          }
          if (localObject.length >= 2) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).iYS = localObject[1];
          }
          if (localObject.length < 3) {
            break label338;
          }
        }
        label338:
        for (WalletAddAddressUI.h(WalletAddAddressUI.this).iYT = localObject[2];; WalletAddAddressUI.h(WalletAddAddressUI.this).iYT = "")
        {
          WalletAddAddressUI.h(WalletAddAddressUI.this).iYV = str1;
          WalletAddAddressUI.h(WalletAddAddressUI.this).iYW = paramAnonymousMenuItem;
          WalletAddAddressUI.h(WalletAddAddressUI.this).iYX = str3;
          WalletAddAddressUI.h(WalletAddAddressUI.this).iYU = str2;
          if (!bs.isNullOrNil(WalletAddAddressUI.n(WalletAddAddressUI.this))) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).iYY = WalletAddAddressUI.n(WalletAddAddressUI.this);
          }
          WalletAddAddressUI.o(WalletAddAddressUI.this);
          AppMethodBeat.o(20984);
          return true;
          WalletAddAddressUI.a(WalletAddAddressUI.this, new b());
          break;
        }
      }
    }, null, s.b.Hom);
    aRK();
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
        if (!bs.isNullOrNil((String)localObject))
        {
          ac.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(localObject)));
          this.jaC.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!bs.isNullOrNil((String)localObject))
        {
          ac.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.jaE.setValStr((String)localObject);
        }
        this.dsc = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20992);
        return;
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getData();
          if (paramIntent == null)
          {
            ac.d("MicroMsg.WalletAddAddressUI", "uri == null");
            AppMethodBeat.o(20992);
            return;
          }
          localObject = com.tencent.mm.pluginsdk.a.f(getBaseContext(), paramIntent);
          if ((localObject != null) && (localObject.length == 2)) {
            paramIntent = localObject[0];
          }
          for (localObject = localObject[1];; localObject = null)
          {
            this.jaB.setValStr(paramIntent);
            this.jaF.setValStr((String)localObject);
            if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
              break;
            }
            aRK();
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
              ac.d("MicroMsg.WalletAddAddressUI", "addr: " + localAddr.toString());
              if (localAddr != null)
              {
                localObject = localAddr.hEw;
                paramIntent = (Intent)localObject;
                if (bs.isNullOrNil((String)localObject)) {
                  paramIntent = localAddr.hEv;
                }
                if (!com.tencent.mm.plugin.address.a.a.aRH().z(localAddr.hEu, paramIntent, localAddr.hEx)) {
                  break label652;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localAddr.hEu);
                ((StringBuilder)localObject).append(" ");
                ((StringBuilder)localObject).append(paramIntent);
                if (!TextUtils.isEmpty(localAddr.hEx))
                {
                  ((StringBuilder)localObject).append(" ");
                  ((StringBuilder)localObject).append(localAddr.hEx);
                }
                this.jaC.setValStr(((StringBuilder)localObject).toString());
                paramIntent = new StringBuilder();
                if (!TextUtils.isEmpty(localAddr.hEy)) {
                  paramIntent.append(localAddr.hEy);
                }
                if (!TextUtils.isEmpty(localAddr.hEz)) {
                  paramIntent.append(localAddr.hEz);
                }
                if (!TextUtils.isEmpty(localAddr.hEA)) {
                  paramIntent.append(localAddr.hEA);
                }
                if (!TextUtils.isEmpty(localAddr.hEC))
                {
                  paramIntent.append(" ");
                  paramIntent.append(localAddr.hEC);
                }
                if ((!bs.isNullOrNil(localAddr.hEC)) || (bs.isNullOrNil(localAddr.hEt))) {
                  break label664;
                }
                this.jaD.setValStr(localAddr.hEt);
              }
            }
            for (;;)
            {
              paramIntent = com.tencent.mm.plugin.address.a.a.aRH().y(localAddr.hEu, localAddr.hEw, localAddr.hEx);
              if (paramIntent != null)
              {
                this.jaE.setValStr(paramIntent.iYE);
                this.dsc = paramIntent.code;
              }
              AppMethodBeat.o(20992);
              return;
              label652:
              this.jaC.setValStr("");
              break;
              label664:
              this.jaD.setValStr(paramIntent.toString());
            }
          }
          ac.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20989);
    super.onCreate(paramBundle);
    az.agi().a(415, this);
    az.agi().a(418, this);
    ac.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    ac.Ys(0);
    this.iYZ = getIntent().getIntExtra("address_id", 0);
    if (this.iYZ == 0) {
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
    az.agi().b(415, this);
    az.agi().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.aRH();
    ac.i("MicroMsg.WalletAddrMgr", "clean data");
    Iterator localIterator = locall.iYJ.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    localIterator = locall.iYK.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    locall.iYI.clear();
    locall.iYJ.clear();
    locall.iYK.clear();
    AppMethodBeat.o(20991);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20996);
    if (paramInt == 4)
    {
      aRM();
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
      ac.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(21000);
      return;
    }
    ac.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aRS();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(2131761862), getString(2131761885), getString(2131760598), getString(2131756766), false, new WalletAddAddressUI.4(this), new WalletAddAddressUI.5(this));
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        aRT();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new WalletAddAddressUI.6(this), new WalletAddAddressUI.7(this));
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
      paramString = com.tencent.mm.plugin.address.a.a.aRH().iYG;
      if (paramString.iYP.size() > 0)
      {
        a(this.jaH, this.jaG);
        paramString = (b)paramString.iYP.getFirst();
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
      h.a(this, 2131755170, 0, false, new WalletAddAddressUI.14(this));
      AppMethodBeat.o(20993);
      return;
    case -3100: 
      h.a(this, 2131755172, 0, false, new WalletAddAddressUI.12(this));
      AppMethodBeat.o(20993);
      return;
    }
    h.d(this, paramString, "", new WalletAddAddressUI.13(this));
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