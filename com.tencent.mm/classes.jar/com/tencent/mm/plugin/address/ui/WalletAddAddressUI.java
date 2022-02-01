package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.ah;

public class WalletAddAddressUI
  extends MMActivity
  implements h, AddrEditView.b
{
  private String hWu;
  private int qim;
  private AddrEditView qkj;
  private AddrEditView qkk;
  private AddrEditView qkl;
  private AddrEditView qkm;
  private AddrEditView qkn;
  private com.tencent.mm.plugin.address.d.b qko;
  private com.tencent.mm.plugin.address.d.b qkp;
  private boolean qkq;
  private a qkr;
  private Dialog tipDialog;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(20988);
    this.qim = 0;
    this.qko = null;
    this.qkp = new com.tencent.mm.plugin.address.d.b();
    this.tipDialog = null;
    this.hWu = "";
    this.qkr = null;
    AppMethodBeat.o(20988);
  }
  
  private static void a(com.tencent.mm.plugin.address.d.b paramb1, com.tencent.mm.plugin.address.d.b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.qid = paramb1.qid;
      paramb2.qie = paramb1.qie;
      paramb2.qif = paramb1.qif;
      paramb2.qih = paramb1.qih;
      paramb2.qii = paramb1.qii;
      paramb2.qij = paramb1.qij;
      paramb2.qig = paramb1.qig;
      paramb2.qik = paramb1.qik;
      paramb2.qil = paramb1.qil;
    }
  }
  
  private void bZE()
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
  
  private void bZF()
  {
    AppMethodBeat.i(20999);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.qkk.getText())) {
      localStringBuilder.append(this.qkk.getText());
    }
    if (!TextUtils.isEmpty(this.qkl.getText())) {
      localStringBuilder.append(this.qkl.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    localIntent.putExtra("key_geo_coder_four_level", true);
    c.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(20999);
  }
  
  private boolean bZk()
  {
    boolean bool2 = false;
    AppMethodBeat.i(20994);
    boolean bool1 = true;
    if (!this.qkj.bZp()) {
      bool1 = false;
    }
    if (!this.qkl.bZp()) {
      bool1 = false;
    }
    if (!this.qkk.bZp()) {
      bool1 = false;
    }
    if (!this.qkm.bZp()) {
      bool1 = false;
    }
    if (!this.qkn.bZp()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(20994);
      return bool1;
    }
  }
  
  private void bZm()
  {
    int k = 1;
    AppMethodBeat.i(20997);
    int j = R.l.gpX;
    if (this.qim == 0) {
      j = R.l.gpW;
    }
    if (this.qkj.bZq()) {}
    for (int i = 1;; i = 0)
    {
      if (this.qkl.bZq()) {
        i = 1;
      }
      if (this.qkk.bZq()) {
        i = 1;
      }
      if (this.qkm.bZq()) {
        i = 1;
      }
      if (this.qkn.bZq()) {
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          k.a(this, j, R.l.app_tip, new WalletAddAddressUI.16(this), null);
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
  
  private void c(Addr paramAddr)
  {
    AppMethodBeat.i(267156);
    Object localObject1;
    RcptItem localRcptItem;
    if (paramAddr != null)
    {
      Object localObject2 = paramAddr.oDL;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = paramAddr.oDK;
      }
      localRcptItem = com.tencent.mm.plugin.address.a.a.bZg().g(paramAddr.oDJ, (String)localObject1, paramAddr.oDM, paramAddr.oDQ);
      if (localRcptItem == null) {
        break label272;
      }
      localObject1 = localRcptItem.name;
      localObject2 = localRcptItem;
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.address.a.a.bZg().yB(((RcptItem)localObject2).qhR);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((RcptItem)localObject2).name + " " + (String)localObject1;
      }
      this.qkk.setValStr((String)localObject1);
      localObject1 = new StringBuilder();
      if (!TextUtils.isEmpty(paramAddr.oDN)) {
        ((StringBuilder)localObject1).append(paramAddr.oDN);
      }
      if (!TextUtils.isEmpty(paramAddr.oDO)) {
        ((StringBuilder)localObject1).append(paramAddr.oDO);
      }
      if (!TextUtils.isEmpty(paramAddr.oDP)) {
        ((StringBuilder)localObject1).append(paramAddr.oDP);
      }
      if (!TextUtils.isEmpty(paramAddr.oDS))
      {
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramAddr.oDS);
      }
      if ((!Util.isNullOrNil(paramAddr.oDS)) || (Util.isNullOrNil(paramAddr.oDI))) {
        break label284;
      }
      this.qkl.setValStr(paramAddr.oDI);
    }
    for (;;)
    {
      if (localRcptItem != null)
      {
        this.qkm.setValStr(localRcptItem.qhL);
        this.hWu = localRcptItem.code;
      }
      AppMethodBeat.o(267156);
      return;
      label272:
      this.qkk.setValStr("");
      break;
      label284:
      this.qkl.setValStr(((StringBuilder)localObject1).toString());
    }
  }
  
  public final void bZl()
  {
    AppMethodBeat.i(20995);
    bZk();
    AppMethodBeat.o(20995);
  }
  
  public int getLayoutId()
  {
    return R.i.gpc;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20990);
    com.tencent.mm.plugin.address.a.a.bZg().bZi();
    Object localObject = (MMScrollView)findViewById(R.h.wallet_sv);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.qkj = ((AddrEditView)findViewById(R.h.fqK));
    this.qkk = ((AddrEditView)findViewById(R.h.fqF));
    this.qkl = ((AddrEditView)findViewById(R.h.fqG));
    this.qkm = ((AddrEditView)findViewById(R.h.fqS));
    this.qkn = ((AddrEditView)findViewById(R.h.fqM));
    this.qkq = getIntent().getBooleanExtra("force_light_mode", false);
    if (this.qkq)
    {
      findViewById(R.h.wallet_sv).setBackgroundResource(R.e.White);
      this.qkj.bZo();
      this.qkk.bZo();
      this.qkl.bZo();
      this.qkm.bZo();
      this.qkn.bZo();
      setActionbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
      setNavigationbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
    }
    this.qkj.setOnInputValidChangeListener(this);
    this.qkk.setOnInputValidChangeListener(this);
    this.qkl.setOnInputValidChangeListener(this);
    this.qkm.setOnInputValidChangeListener(this);
    this.qkn.setOnInputValidChangeListener(this);
    this.qkj.setInfoIvOnClickListener(new WalletAddAddressUI.1(this));
    this.qkk.setInfoIvOnClickListener(new WalletAddAddressUI.9(this));
    this.qkk.setOnClickListener(new WalletAddAddressUI.10(this));
    if (this.qim != 0)
    {
      this.qko = com.tencent.mm.plugin.address.a.a.bZg().yz(this.qim);
      if (this.qko == null)
      {
        Log.w("MicroMsg.WalletAddAddressUI", "addr is null");
        finish();
        AppMethodBeat.o(20990);
        return;
      }
      this.qkj.setValStr(this.qko.qii);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.qko.qid)) {
        ((StringBuilder)localObject).append(this.qko.qid);
      }
      if (!TextUtils.isEmpty(this.qko.qie))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.qko.qie);
      }
      if (!TextUtils.isEmpty(this.qko.qif))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.qko.qif);
      }
      if (!TextUtils.isEmpty(this.qko.qil))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.qko.qil);
      }
      this.qkk.setValStr(((StringBuilder)localObject).toString());
      this.qkl.setValStr(this.qko.qih);
      this.qkm.setValStr(this.qko.qig);
      this.qkn.setValStr(this.qko.qij);
    }
    setBackBtn(new WalletAddAddressUI.11(this));
    addTextOptionMenu(0, getString(R.l.app_save), new MenuItem.OnMenuItemClickListener()
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
          WalletAddAddressUI.a(WalletAddAddressUI.this, com.tencent.mm.plugin.address.a.a.bZg().yz(WalletAddAddressUI.f(WalletAddAddressUI.this)));
          Log.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(WalletAddAddressUI.this).toString());
          WalletAddAddressUI.b(WalletAddAddressUI.g(WalletAddAddressUI.this), WalletAddAddressUI.h(WalletAddAddressUI.this));
          paramAnonymousMenuItem = WalletAddAddressUI.i(WalletAddAddressUI.this).getText();
          localObject = WalletAddAddressUI.j(WalletAddAddressUI.this).getText();
          str1 = WalletAddAddressUI.k(WalletAddAddressUI.this).getText();
          str2 = WalletAddAddressUI.l(WalletAddAddressUI.this).getText();
          str3 = WalletAddAddressUI.m(WalletAddAddressUI.this).getText();
          localObject = ((String)localObject).split(" ");
          if (localObject.length > 0) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).qid = localObject[0];
          }
          if (localObject.length >= 2) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).qie = localObject[1];
          }
          if (localObject.length < 3) {
            break label365;
          }
          WalletAddAddressUI.h(WalletAddAddressUI.this).qif = localObject[2];
          label230:
          if (localObject.length < 4) {
            break label380;
          }
        }
        label365:
        label380:
        for (WalletAddAddressUI.h(WalletAddAddressUI.this).qil = localObject[3];; WalletAddAddressUI.h(WalletAddAddressUI.this).qil = "")
        {
          WalletAddAddressUI.h(WalletAddAddressUI.this).qih = str1;
          WalletAddAddressUI.h(WalletAddAddressUI.this).qii = paramAnonymousMenuItem;
          WalletAddAddressUI.h(WalletAddAddressUI.this).qij = str3;
          WalletAddAddressUI.h(WalletAddAddressUI.this).qig = str2;
          if (!Util.isNullOrNil(WalletAddAddressUI.n(WalletAddAddressUI.this))) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).qik = WalletAddAddressUI.n(WalletAddAddressUI.this);
          }
          WalletAddAddressUI.o(WalletAddAddressUI.this);
          l.kK(4, 7);
          AppMethodBeat.o(20984);
          return true;
          WalletAddAddressUI.a(WalletAddAddressUI.this, new com.tencent.mm.plugin.address.d.b());
          break;
          WalletAddAddressUI.h(WalletAddAddressUI.this).qif = "";
          break label230;
        }
      }
    }, null, y.b.adEJ);
    bZk();
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
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(localObject)));
          this.qkk.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.qkm.setValStr((String)localObject);
        }
        this.hWu = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(20992);
        return;
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getData();
          if (paramIntent == null)
          {
            Log.d("MicroMsg.WalletAddAddressUI", "uri == null");
            AppMethodBeat.o(20992);
            return;
          }
          localObject = com.tencent.mm.pluginsdk.b.d(getBaseContext(), paramIntent);
          if ((localObject != null) && (localObject.length == 2)) {
            paramIntent = localObject[0];
          }
          for (localObject = localObject[1];; localObject = null)
          {
            this.qkj.setValStr(paramIntent);
            this.qkn.setValStr((String)localObject);
            if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
              break;
            }
            bZk();
            AppMethodBeat.o(20992);
            return;
            k.c(this, getString(R.l.grb), "", true);
            paramIntent = null;
          }
          k.c(this, getString(R.l.grb), "", true);
          AppMethodBeat.o(20992);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
            if (paramIntent != null)
            {
              Log.d("MicroMsg.WalletAddAddressUI", "addr: " + paramIntent.toString());
              c(paramIntent);
            }
            AppMethodBeat.o(20992);
            return;
          }
          Log.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20989);
    super.onCreate(paramBundle);
    bh.aZW().a(415, this);
    bh.aZW().a(418, this);
    Log.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    Log.setLevel(0, false);
    this.qim = getIntent().getIntExtra("address_id", 0);
    if (this.qim == 0) {
      setMMTitle(R.l.gpU);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(20989);
      return;
      setMMTitle(R.l.gqI);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20991);
    super.onDestroy();
    bh.aZW().b(415, this);
    bh.aZW().b(418, this);
    j localj = com.tencent.mm.plugin.address.a.a.bZg();
    Log.i("MicroMsg.WalletAddrMgr", "clean data");
    localj.qhV.clear();
    localj.qhU.clear();
    AppMethodBeat.o(20991);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20996);
    if (paramInt == 4)
    {
      bZm();
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
        bZE();
        AppMethodBeat.o(21000);
        return;
      }
      k.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new WalletAddAddressUI.5(this), new WalletAddAddressUI.6(this));
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bZF();
        AppMethodBeat.o(21000);
        return;
      }
      k.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new WalletAddAddressUI.7(this), new WalletAddAddressUI.8(this));
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(20993);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.address.a.a.bZg().qhS;
      if (paramString.qib.size() > 0)
      {
        a(this.qkp, this.qko);
        paramString = (com.tencent.mm.plugin.address.d.b)paramString.qib.getFirst();
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
      k.a(this, R.l.gpR, 0, false, new WalletAddAddressUI.15(this));
      AppMethodBeat.o(20993);
      return;
    case -3100: 
      k.a(this, R.l.gpT, 0, false, new WalletAddAddressUI.13(this));
      AppMethodBeat.o(20993);
      return;
    }
    k.d(this, paramString, "", new WalletAddAddressUI.14(this));
    AppMethodBeat.o(20993);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI
 * JD-Core Version:    0.7.0.1
 */