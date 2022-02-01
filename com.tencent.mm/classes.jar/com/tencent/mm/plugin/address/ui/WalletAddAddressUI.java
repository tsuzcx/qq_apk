package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletAddAddressUI
  extends MMActivity
  implements i, AddrEditView.b
{
  private String dWN;
  private int ktp;
  private AddrEditView kuS;
  private AddrEditView kuT;
  private AddrEditView kuU;
  private AddrEditView kuV;
  private AddrEditView kuW;
  private com.tencent.mm.plugin.address.d.b kuX;
  private com.tencent.mm.plugin.address.d.b kuY;
  private boolean kuZ;
  private Dialog tipDialog;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(20988);
    this.ktp = 0;
    this.kuX = null;
    this.kuY = new com.tencent.mm.plugin.address.d.b();
    this.tipDialog = null;
    this.dWN = "";
    AppMethodBeat.o(20988);
  }
  
  private static void a(com.tencent.mm.plugin.address.d.b paramb1, com.tencent.mm.plugin.address.d.b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.kth = paramb1.kth;
      paramb2.kti = paramb1.kti;
      paramb2.ktj = paramb1.ktj;
      paramb2.ktl = paramb1.ktl;
      paramb2.ktm = paramb1.ktm;
      paramb2.ktn = paramb1.ktn;
      paramb2.ktk = paramb1.ktk;
      paramb2.kto = paramb1.kto;
    }
  }
  
  private boolean bqg()
  {
    boolean bool2 = false;
    AppMethodBeat.i(20994);
    boolean bool1 = true;
    if (!this.kuS.bql()) {
      bool1 = false;
    }
    if (!this.kuU.bql()) {
      bool1 = false;
    }
    if (!this.kuT.bql()) {
      bool1 = false;
    }
    if (!this.kuV.bql()) {
      bool1 = false;
    }
    if (!this.kuW.bql()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(20994);
      return bool1;
    }
  }
  
  private void bqi()
  {
    int k = 1;
    AppMethodBeat.i(20997);
    int j = 2131755194;
    if (this.ktp == 0) {
      j = 2131755193;
    }
    if (this.kuS.bqm()) {}
    for (int i = 1;; i = 0)
    {
      if (this.kuU.bqm()) {
        i = 1;
      }
      if (this.kuT.bqm()) {
        i = 1;
      }
      if (this.kuV.bqm()) {
        i = 1;
      }
      if (this.kuW.bqm()) {
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          h.a(this, j, 2131755998, new WalletAddAddressUI.15(this), null);
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
  
  private void bqp()
  {
    AppMethodBeat.i(20998);
    Intent localIntent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    if (Util.isIntentAvailable(this, localIntent))
    {
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(20998);
      return;
    }
    Log.w("MicroMsg.WalletAddAddressUI", "intent not available");
    AppMethodBeat.o(20998);
  }
  
  private void bqq()
  {
    AppMethodBeat.i(20999);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.kuT.getText())) {
      localStringBuilder.append(this.kuT.getText());
    }
    if (!TextUtils.isEmpty(this.kuU.getText())) {
      localStringBuilder.append(this.kuU.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    c.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(20999);
  }
  
  public final void bqh()
  {
    AppMethodBeat.i(20995);
    bqg();
    AppMethodBeat.o(20995);
  }
  
  public int getLayoutId()
  {
    return 2131496871;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20990);
    com.tencent.mm.plugin.address.a.a.bqd().bqe();
    Object localObject = (MMScrollView)findViewById(2131310296);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.kuS = ((AddrEditView)findViewById(2131296560));
    this.kuT = ((AddrEditView)findViewById(2131296547));
    this.kuU = ((AddrEditView)findViewById(2131296548));
    this.kuV = ((AddrEditView)findViewById(2131296572));
    this.kuW = ((AddrEditView)findViewById(2131296562));
    this.kuZ = getIntent().getBooleanExtra("force_light_mode", false);
    if (this.kuZ)
    {
      findViewById(2131310296).setBackgroundResource(2131099844);
      this.kuS.bqk();
      this.kuT.bqk();
      this.kuU.bqk();
      this.kuV.bqk();
      this.kuW.bqk();
      setActionbarColor(getContext().getResources().getColor(2131099837));
      setNavigationbarColor(getContext().getResources().getColor(2131099837));
    }
    this.kuS.setOnInputValidChangeListener(this);
    this.kuT.setOnInputValidChangeListener(this);
    this.kuU.setOnInputValidChangeListener(this);
    this.kuV.setOnInputValidChangeListener(this);
    this.kuW.setOnInputValidChangeListener(this);
    this.kuS.setInfoIvOnClickListener(new WalletAddAddressUI.1(this));
    this.kuT.setInfoIvOnClickListener(new WalletAddAddressUI.8(this));
    this.kuT.setOnClickListener(new WalletAddAddressUI.9(this));
    if (this.ktp != 0)
    {
      this.kuX = com.tencent.mm.plugin.address.a.a.bqd().vp(this.ktp);
      if (this.kuX == null)
      {
        Log.w("MicroMsg.WalletAddAddressUI", "addr is null");
        finish();
        AppMethodBeat.o(20990);
        return;
      }
      this.kuS.setValStr(this.kuX.ktm);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.kuX.kth)) {
        ((StringBuilder)localObject).append(this.kuX.kth);
      }
      if (!TextUtils.isEmpty(this.kuX.kti))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.kuX.kti);
      }
      if (!TextUtils.isEmpty(this.kuX.ktj))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.kuX.ktj);
      }
      this.kuT.setValStr(((StringBuilder)localObject).toString());
      this.kuU.setValStr(this.kuX.ktl);
      this.kuV.setValStr(this.kuX.ktk);
      this.kuW.setValStr(this.kuX.ktn);
    }
    setBackBtn(new WalletAddAddressUI.10(this));
    addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
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
          WalletAddAddressUI.a(WalletAddAddressUI.this, com.tencent.mm.plugin.address.a.a.bqd().vp(WalletAddAddressUI.f(WalletAddAddressUI.this)));
          Log.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(WalletAddAddressUI.this).toString());
          WalletAddAddressUI.b(WalletAddAddressUI.g(WalletAddAddressUI.this), WalletAddAddressUI.h(WalletAddAddressUI.this));
          paramAnonymousMenuItem = WalletAddAddressUI.i(WalletAddAddressUI.this).getText();
          localObject = WalletAddAddressUI.j(WalletAddAddressUI.this).getText();
          str1 = WalletAddAddressUI.k(WalletAddAddressUI.this).getText();
          str2 = WalletAddAddressUI.l(WalletAddAddressUI.this).getText();
          str3 = WalletAddAddressUI.m(WalletAddAddressUI.this).getText();
          localObject = ((String)localObject).split(" ");
          if (localObject.length > 0) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).kth = localObject[0];
          }
          if (localObject.length >= 2) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).kti = localObject[1];
          }
          if (localObject.length < 3) {
            break label338;
          }
        }
        label338:
        for (WalletAddAddressUI.h(WalletAddAddressUI.this).ktj = localObject[2];; WalletAddAddressUI.h(WalletAddAddressUI.this).ktj = "")
        {
          WalletAddAddressUI.h(WalletAddAddressUI.this).ktl = str1;
          WalletAddAddressUI.h(WalletAddAddressUI.this).ktm = paramAnonymousMenuItem;
          WalletAddAddressUI.h(WalletAddAddressUI.this).ktn = str3;
          WalletAddAddressUI.h(WalletAddAddressUI.this).ktk = str2;
          if (!Util.isNullOrNil(WalletAddAddressUI.n(WalletAddAddressUI.this))) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).kto = WalletAddAddressUI.n(WalletAddAddressUI.this);
          }
          WalletAddAddressUI.o(WalletAddAddressUI.this);
          AppMethodBeat.o(20984);
          return true;
          WalletAddAddressUI.a(WalletAddAddressUI.this, new com.tencent.mm.plugin.address.d.b());
          break;
        }
      }
    }, null, t.b.OGU);
    bqg();
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
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(localObject)));
          this.kuT.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.kuV.setValStr((String)localObject);
        }
        this.dWN = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20992);
        return;
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getData();
      if (paramIntent == null)
      {
        Log.d("MicroMsg.WalletAddAddressUI", "uri == null");
        AppMethodBeat.o(20992);
        return;
      }
      localObject = com.tencent.mm.pluginsdk.b.i(getBaseContext(), paramIntent);
      if ((localObject != null) && (localObject.length == 2)) {
        paramIntent = localObject[0];
      }
      for (localObject = localObject[1];; localObject = null)
      {
        this.kuS.setValStr(paramIntent);
        this.kuW.setValStr((String)localObject);
        if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
          break;
        }
        bqg();
        AppMethodBeat.o(20992);
        return;
        h.c(this, getString(2131755277), "", true);
        paramIntent = null;
      }
      h.c(this, getString(2131755277), "", true);
      AppMethodBeat.o(20992);
      return;
    }
    if (paramInt2 == -1)
    {
      Addr localAddr = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
      if (localAddr != null)
      {
        Log.d("MicroMsg.WalletAddAddressUI", "addr: " + localAddr.toString());
        if (localAddr != null)
        {
          localObject = localAddr.iUR;
          paramIntent = (Intent)localObject;
          if (Util.isNullOrNil((String)localObject)) {
            paramIntent = localAddr.iUQ;
          }
          if (!com.tencent.mm.plugin.address.a.a.bqd().y(localAddr.iUP, paramIntent, localAddr.iUS)) {
            break label678;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localAddr.iUP);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramIntent);
          if (!TextUtils.isEmpty(localAddr.iUS))
          {
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(localAddr.iUS);
          }
          this.kuT.setValStr(((StringBuilder)localObject).toString());
          label466:
          paramIntent = new StringBuilder();
          if (!TextUtils.isEmpty(localAddr.iUT)) {
            paramIntent.append(localAddr.iUT);
          }
          if (!TextUtils.isEmpty(localAddr.iUU)) {
            paramIntent.append(localAddr.iUU);
          }
          if (!TextUtils.isEmpty(localAddr.iUV)) {
            paramIntent.append(localAddr.iUV);
          }
          if (!TextUtils.isEmpty(localAddr.iUX))
          {
            paramIntent.append(" ");
            paramIntent.append(localAddr.iUX);
          }
          if ((!Util.isNullOrNil(localAddr.iUX)) || (Util.isNullOrNil(localAddr.iUO))) {
            break label690;
          }
          this.kuU.setValStr(localAddr.iUO);
          label600:
          paramIntent = com.tencent.mm.plugin.address.a.a.bqd().x(localAddr.iUP, localAddr.iUR, localAddr.iUS);
          if (paramIntent != null) {
            break label715;
          }
          paramIntent = com.tencent.mm.plugin.address.a.a.bqd().x(localAddr.iUP, localAddr.iUQ, localAddr.iUS);
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
        this.kuV.setValStr(paramIntent.ksV);
        this.dWN = paramIntent.code;
      }
      AppMethodBeat.o(20992);
      return;
      this.kuT.setValStr("");
      break label466;
      this.kuU.setValStr(paramIntent.toString());
      break label600;
      Log.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20989);
    super.onCreate(paramBundle);
    bg.azz().a(415, this);
    bg.azz().a(418, this);
    Log.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    Log.setLevel(0, false);
    this.ktp = getIntent().getIntExtra("address_id", 0);
    if (this.ktp == 0) {
      setMMTitle(2131755191);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(20989);
      return;
      setMMTitle(2131755245);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20991);
    super.onDestroy();
    bg.azz().b(415, this);
    bg.azz().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.bqd();
    Log.i("MicroMsg.WalletAddrMgr", "clean data");
    Iterator localIterator = locall.kta.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    localIterator = locall.ktb.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    locall.ksZ.clear();
    locall.kta.clear();
    locall.ktb.clear();
    AppMethodBeat.o(20991);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20996);
    if (paramInt == 4)
    {
      bqi();
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
      Log.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(21000);
      return;
    }
    Log.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bqp();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(2131763866), getString(2131763890), getString(2131762043), getString(2131756929), false, new WalletAddAddressUI.4(this), new WalletAddAddressUI.5(this));
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bqq();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new WalletAddAddressUI.6(this), new WalletAddAddressUI.7(this));
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(20993);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.address.a.a.bqd().ksX;
      if (paramString.ktf.size() > 0)
      {
        a(this.kuY, this.kuX);
        paramString = (com.tencent.mm.plugin.address.d.b)paramString.ktf.getFirst();
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
      h.a(this, 2131755188, 0, false, new WalletAddAddressUI.14(this));
      AppMethodBeat.o(20993);
      return;
    case -3100: 
      h.a(this, 2131755190, 0, false, new WalletAddAddressUI.12(this));
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