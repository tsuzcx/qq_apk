package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.x;

public class WalletAddAddressUI
  extends MMActivity
  implements i, AddrEditView.b
{
  private String fQz;
  private int nld;
  private AddrEditView nnd;
  private AddrEditView nne;
  private AddrEditView nnf;
  private AddrEditView nng;
  private AddrEditView nnh;
  private com.tencent.mm.plugin.address.d.b nni;
  private com.tencent.mm.plugin.address.d.b nnj;
  private boolean nnk;
  private a nnl;
  private Dialog tipDialog;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(20988);
    this.nld = 0;
    this.nni = null;
    this.nnj = new com.tencent.mm.plugin.address.d.b();
    this.tipDialog = null;
    this.fQz = "";
    this.nnl = null;
    AppMethodBeat.o(20988);
  }
  
  private static void a(com.tencent.mm.plugin.address.d.b paramb1, com.tencent.mm.plugin.address.d.b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.nkU = paramb1.nkU;
      paramb2.nkV = paramb1.nkV;
      paramb2.nkW = paramb1.nkW;
      paramb2.nkY = paramb1.nkY;
      paramb2.nkZ = paramb1.nkZ;
      paramb2.nla = paramb1.nla;
      paramb2.nkX = paramb1.nkX;
      paramb2.nlb = paramb1.nlb;
      paramb2.nlc = paramb1.nlc;
    }
  }
  
  private void bAT()
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
  
  private void bAU()
  {
    AppMethodBeat.i(20999);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.nne.getText())) {
      localStringBuilder.append(this.nne.getText());
    }
    if (!TextUtils.isEmpty(this.nnf.getText())) {
      localStringBuilder.append(this.nnf.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    localIntent.putExtra("type_tag", -1);
    localIntent.putExtra("key_geo_coder_four_level", true);
    c.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(20999);
  }
  
  private boolean bAu()
  {
    boolean bool2 = false;
    AppMethodBeat.i(20994);
    boolean bool1 = true;
    if (!this.nnd.bAz()) {
      bool1 = false;
    }
    if (!this.nnf.bAz()) {
      bool1 = false;
    }
    if (!this.nne.bAz()) {
      bool1 = false;
    }
    if (!this.nng.bAz()) {
      bool1 = false;
    }
    if (!this.nnh.bAz()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(20994);
      return bool1;
    }
  }
  
  private void bAw()
  {
    int k = 1;
    AppMethodBeat.i(20997);
    int j = R.l.emW;
    if (this.nld == 0) {
      j = R.l.emV;
    }
    if (this.nnd.bAA()) {}
    for (int i = 1;; i = 0)
    {
      if (this.nnf.bAA()) {
        i = 1;
      }
      if (this.nne.bAA()) {
        i = 1;
      }
      if (this.nng.bAA()) {
        i = 1;
      }
      if (this.nnh.bAA()) {
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          h.a(this, j, R.l.app_tip, new DialogInterface.OnClickListener()
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
  
  private void d(Addr paramAddr)
  {
    AppMethodBeat.i(293364);
    Object localObject1;
    RcptItem localRcptItem;
    if (paramAddr != null)
    {
      Object localObject2 = paramAddr.lLj;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = paramAddr.lLi;
      }
      localRcptItem = com.tencent.mm.plugin.address.a.a.bAp().g(paramAddr.lLh, (String)localObject1, paramAddr.lLk, paramAddr.lLo);
      if (localRcptItem == null) {
        break label274;
      }
      localObject1 = localRcptItem.name;
      localObject2 = localRcptItem;
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.address.a.a.bAp().vw(((RcptItem)localObject2).nkI);
        if (localObject2 == null) {
          break;
        }
        localObject1 = ((RcptItem)localObject2).name + " " + (String)localObject1;
      }
      this.nne.setValStr((String)localObject1);
      localObject1 = new StringBuilder();
      if (!TextUtils.isEmpty(paramAddr.lLl)) {
        ((StringBuilder)localObject1).append(paramAddr.lLl);
      }
      if (!TextUtils.isEmpty(paramAddr.lLm)) {
        ((StringBuilder)localObject1).append(paramAddr.lLm);
      }
      if (!TextUtils.isEmpty(paramAddr.lLn)) {
        ((StringBuilder)localObject1).append(paramAddr.lLn);
      }
      if (!TextUtils.isEmpty(paramAddr.lLq))
      {
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramAddr.lLq);
      }
      if ((!Util.isNullOrNil(paramAddr.lLq)) || (Util.isNullOrNil(paramAddr.lLg))) {
        break label286;
      }
      this.nnf.setValStr(paramAddr.lLg);
    }
    for (;;)
    {
      if (localRcptItem != null)
      {
        this.nng.setValStr(localRcptItem.nkC);
        this.fQz = localRcptItem.code;
      }
      AppMethodBeat.o(293364);
      return;
      label274:
      this.nne.setValStr("");
      break;
      label286:
      this.nnf.setValStr(((StringBuilder)localObject1).toString());
    }
  }
  
  public final void bAv()
  {
    AppMethodBeat.i(20995);
    bAu();
    AppMethodBeat.o(20995);
  }
  
  public int getLayoutId()
  {
    return R.i.elY;
  }
  
  public void initView()
  {
    AppMethodBeat.i(20990);
    com.tencent.mm.plugin.address.a.a.bAp().bAr();
    Object localObject = (MMScrollView)findViewById(R.h.wallet_sv);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.nnd = ((AddrEditView)findViewById(R.h.dqw));
    this.nne = ((AddrEditView)findViewById(R.h.dqr));
    this.nnf = ((AddrEditView)findViewById(R.h.dqs));
    this.nng = ((AddrEditView)findViewById(R.h.dqE));
    this.nnh = ((AddrEditView)findViewById(R.h.dqy));
    this.nnk = getIntent().getBooleanExtra("force_light_mode", false);
    if (this.nnk)
    {
      findViewById(R.h.wallet_sv).setBackgroundResource(R.e.White);
      this.nnd.bAy();
      this.nne.bAy();
      this.nnf.bAy();
      this.nng.bAy();
      this.nnh.bAy();
      setActionbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
      setNavigationbarColor(getContext().getResources().getColor(R.e.UN_BW_93));
    }
    this.nnd.setOnInputValidChangeListener(this);
    this.nne.setOnInputValidChangeListener(this);
    this.nnf.setOnInputValidChangeListener(this);
    this.nng.setOnInputValidChangeListener(this);
    this.nnh.setOnInputValidChangeListener(this);
    this.nnd.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(20976);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.READ_CONTACTS", 48, null, null);
        Log.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack() });
        if (!bool)
        {
          AppMethodBeat.o(20976);
          return;
        }
        WalletAddAddressUI.a(WalletAddAddressUI.this);
        AppMethodBeat.o(20976);
      }
    });
    this.nne.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(20981);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null, null);
        Log.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(20981);
          return;
        }
        WalletAddAddressUI.b(WalletAddAddressUI.this);
        AppMethodBeat.o(20981);
      }
    });
    this.nne.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(20982);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletAddAddressUI.c(WalletAddAddressUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(20982);
      }
    });
    if (this.nld != 0)
    {
      this.nni = com.tencent.mm.plugin.address.a.a.bAp().yt(this.nld);
      if (this.nni == null)
      {
        Log.w("MicroMsg.WalletAddAddressUI", "addr is null");
        finish();
        AppMethodBeat.o(20990);
        return;
      }
      this.nnd.setValStr(this.nni.nkZ);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.nni.nkU)) {
        ((StringBuilder)localObject).append(this.nni.nkU);
      }
      if (!TextUtils.isEmpty(this.nni.nkV))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.nni.nkV);
      }
      if (!TextUtils.isEmpty(this.nni.nkW))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.nni.nkW);
      }
      if (!TextUtils.isEmpty(this.nni.nlc))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.nni.nlc);
      }
      this.nne.setValStr(((StringBuilder)localObject).toString());
      this.nnf.setValStr(this.nni.nkY);
      this.nng.setValStr(this.nni.nkX);
      this.nnh.setValStr(this.nni.nla);
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
          WalletAddAddressUI.a(WalletAddAddressUI.this, com.tencent.mm.plugin.address.a.a.bAp().yt(WalletAddAddressUI.f(WalletAddAddressUI.this)));
          Log.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(WalletAddAddressUI.this).toString());
          WalletAddAddressUI.b(WalletAddAddressUI.g(WalletAddAddressUI.this), WalletAddAddressUI.h(WalletAddAddressUI.this));
          paramAnonymousMenuItem = WalletAddAddressUI.i(WalletAddAddressUI.this).getText();
          localObject = WalletAddAddressUI.j(WalletAddAddressUI.this).getText();
          str1 = WalletAddAddressUI.k(WalletAddAddressUI.this).getText();
          str2 = WalletAddAddressUI.l(WalletAddAddressUI.this).getText();
          str3 = WalletAddAddressUI.m(WalletAddAddressUI.this).getText();
          localObject = ((String)localObject).split(" ");
          if (localObject.length > 0) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).nkU = localObject[0];
          }
          if (localObject.length >= 2) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).nkV = localObject[1];
          }
          if (localObject.length < 3) {
            break label359;
          }
          WalletAddAddressUI.h(WalletAddAddressUI.this).nkW = localObject[2];
          label230:
          if (localObject.length < 4) {
            break label374;
          }
        }
        label359:
        label374:
        for (WalletAddAddressUI.h(WalletAddAddressUI.this).nlc = localObject[3];; WalletAddAddressUI.h(WalletAddAddressUI.this).nlc = "")
        {
          WalletAddAddressUI.h(WalletAddAddressUI.this).nkY = str1;
          WalletAddAddressUI.h(WalletAddAddressUI.this).nkZ = paramAnonymousMenuItem;
          WalletAddAddressUI.h(WalletAddAddressUI.this).nla = str3;
          WalletAddAddressUI.h(WalletAddAddressUI.this).nkX = str2;
          if (!Util.isNullOrNil(WalletAddAddressUI.n(WalletAddAddressUI.this))) {
            WalletAddAddressUI.h(WalletAddAddressUI.this).nlb = WalletAddAddressUI.n(WalletAddAddressUI.this);
          }
          WalletAddAddressUI.o(WalletAddAddressUI.this);
          AppMethodBeat.o(20984);
          return true;
          WalletAddAddressUI.a(WalletAddAddressUI.this, new com.tencent.mm.plugin.address.d.b());
          break;
          WalletAddAddressUI.h(WalletAddAddressUI.this).nkW = "";
          break label230;
        }
      }
    }, null, w.b.Wao);
    bAu();
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
          this.nne.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.nng.setValStr((String)localObject);
        }
        this.fQz = paramIntent.getStringExtra("kwcode");
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
          localObject = com.tencent.mm.pluginsdk.b.f(getBaseContext(), paramIntent);
          if ((localObject != null) && (localObject.length == 2)) {
            paramIntent = localObject[0];
          }
          for (localObject = localObject[1];; localObject = null)
          {
            this.nnd.setValStr(paramIntent);
            this.nnh.setValStr((String)localObject);
            if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
              break;
            }
            bAu();
            AppMethodBeat.o(20992);
            return;
            h.c(this, getString(R.l.eob), "", true);
            paramIntent = null;
          }
          h.c(this, getString(R.l.eob), "", true);
          AppMethodBeat.o(20992);
          return;
          if (paramInt2 == -1)
          {
            paramIntent = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
            if (paramIntent != null)
            {
              Log.d("MicroMsg.WalletAddAddressUI", "addr: " + paramIntent.toString());
              d(paramIntent);
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
    bh.aGY().a(415, this);
    bh.aGY().a(418, this);
    Log.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    Log.setLevel(0, false);
    this.nld = getIntent().getIntExtra("address_id", 0);
    if (this.nld == 0) {
      setMMTitle(R.l.emT);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(20989);
      return;
      setMMTitle(R.l.enH);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(20991);
    super.onDestroy();
    bh.aGY().b(415, this);
    bh.aGY().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.bAp();
    Log.i("MicroMsg.WalletAddrMgr", "clean data");
    locall.nkM.clear();
    locall.nkL.clear();
    AppMethodBeat.o(20991);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(20996);
    if (paramInt == 4)
    {
      bAw();
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
        bAT();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20978);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = WalletAddAddressUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20978);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20979);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(20979);
        }
      });
      AppMethodBeat.o(21000);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bAU();
        AppMethodBeat.o(21000);
        return;
      }
      h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(20980);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = WalletAddAddressUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$15", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(20980);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(280877);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(280877);
        }
      });
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
      paramString = com.tencent.mm.plugin.address.a.a.bAp().nkJ;
      if (paramString.nkS.size() > 0)
      {
        a(this.nnj, this.nni);
        paramString = (com.tencent.mm.plugin.address.d.b)paramString.nkS.getFirst();
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
      h.a(this, R.l.emQ, 0, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(20993);
      return;
    case -3100: 
      h.a(this, R.l.emS, 0, false, new DialogInterface.OnClickListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI
 * JD-Core Version:    0.7.0.1
 */