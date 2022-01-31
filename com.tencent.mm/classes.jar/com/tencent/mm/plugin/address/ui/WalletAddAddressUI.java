package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private String bWc = "";
  private int ftK = 0;
  private Dialog ftk = null;
  private AddrEditView fvn;
  private AddrEditView fvo;
  private AddrEditView fvp;
  private AddrEditView fvq;
  private AddrEditView fvr;
  private b fvs = null;
  private b fvt = new b();
  
  private boolean YH()
  {
    boolean bool2 = false;
    boolean bool1 = true;
    if (!this.fvn.YL()) {
      bool1 = false;
    }
    if (!this.fvp.YL()) {
      bool1 = false;
    }
    if (!this.fvo.YL()) {
      bool1 = false;
    }
    if (!this.fvq.YL()) {
      bool1 = false;
    }
    if (!this.fvr.YL()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      return bool1;
    }
  }
  
  private void YJ()
  {
    int k = 1;
    int j = R.l.address_back_modify_tip;
    if (this.ftK == 0) {
      j = R.l.address_back_add_tip;
    }
    if (this.fvn.YM()) {}
    for (int i = 1;; i = 0)
    {
      if (this.fvp.YM()) {
        i = 1;
      }
      if (this.fvo.YM()) {
        i = 1;
      }
      if (this.fvq.YM()) {
        i = 1;
      }
      if (this.fvr.YM()) {
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          h.a(this, j, R.l.app_tip, new WalletAddAddressUI.15(this), null);
          return;
        }
        setResult(0);
        finish();
        return;
      }
    }
  }
  
  private void YP()
  {
    startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 2);
  }
  
  private void YQ()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.fvo.getText())) {
      localStringBuilder.append(this.fvo.getText());
    }
    if (!TextUtils.isEmpty(this.fvp.getText())) {
      localStringBuilder.append(this.fvp.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    d.b(this, "location", ".ui.RedirectUI", localIntent, 3);
  }
  
  private static void a(b paramb1, b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.ftC = paramb1.ftC;
      paramb2.ftD = paramb1.ftD;
      paramb2.ftE = paramb1.ftE;
      paramb2.ftG = paramb1.ftG;
      paramb2.ftH = paramb1.ftH;
      paramb2.ftI = paramb1.ftI;
      paramb2.ftF = paramb1.ftF;
      paramb2.ftJ = paramb1.ftJ;
    }
  }
  
  public final void YI()
  {
    YH();
  }
  
  protected final int getLayoutId()
  {
    return R.i.wallet_add_address_ui;
  }
  
  public final void initView()
  {
    com.tencent.mm.plugin.address.a.a.YD().YE();
    Object localObject = (MMScrollView)findViewById(R.h.wallet_sv);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.fvn = ((AddrEditView)findViewById(R.h.address_name));
    this.fvo = ((AddrEditView)findViewById(R.h.address_country));
    this.fvp = ((AddrEditView)findViewById(R.h.address_detail_area));
    this.fvq = ((AddrEditView)findViewById(R.h.addresss_post));
    this.fvr = ((AddrEditView)findViewById(R.h.address_phone));
    this.fvn.setOnInputValidChangeListener(this);
    this.fvo.setOnInputValidChangeListener(this);
    this.fvp.setOnInputValidChangeListener(this);
    this.fvq.setOnInputValidChangeListener(this);
    this.fvr.setOnInputValidChangeListener(this);
    this.fvn.setInfoIvOnClickListener(new WalletAddAddressUI.1(this));
    this.fvo.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        boolean bool = com.tencent.mm.pluginsdk.permission.a.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
        y.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          return;
        }
        WalletAddAddressUI.b(WalletAddAddressUI.this);
      }
    });
    this.fvo.setOnClickListener(new WalletAddAddressUI.9(this));
    if (this.ftK != 0)
    {
      this.fvs = com.tencent.mm.plugin.address.a.a.YD().kg(this.ftK);
      this.fvn.setValStr(this.fvs.ftH);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.fvs.ftC)) {
        ((StringBuilder)localObject).append(this.fvs.ftC);
      }
      if (!TextUtils.isEmpty(this.fvs.ftD))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.fvs.ftD);
      }
      if (!TextUtils.isEmpty(this.fvs.ftE))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.fvs.ftE);
      }
      this.fvo.setValStr(((StringBuilder)localObject).toString());
      this.fvp.setValStr(this.fvs.ftG);
      this.fvq.setValStr(this.fvs.ftF);
      this.fvr.setValStr(this.fvs.ftI);
    }
    setBackBtn(new WalletAddAddressUI.10(this));
    a(0, getString(R.l.app_save), new WalletAddAddressUI.11(this), s.b.uNx);
    YH();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramInt2 != -1);
          localObject = paramIntent.getStringExtra("karea_result");
          if (!bk.bl((String)localObject))
          {
            y.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:" + (String)localObject);
            this.fvo.setValStr((String)localObject);
          }
          localObject = paramIntent.getStringExtra("kpost_code");
          if (!bk.bl((String)localObject))
          {
            y.d("MicroMsg.WalletAddAddressUI", "post:" + (String)localObject);
            this.fvq.setValStr((String)localObject);
          }
          this.bWc = paramIntent.getStringExtra("kwcode");
          return;
        } while (paramInt2 != -1);
        paramIntent = paramIntent.getData();
        if (paramIntent == null)
        {
          y.d("MicroMsg.WalletAddAddressUI", "uri == null");
          return;
        }
        localObject = com.tencent.mm.pluginsdk.a.e(getBaseContext(), paramIntent);
        if ((localObject != null) && (localObject.length == 2)) {
          paramIntent = localObject[0];
        }
        for (localObject = localObject[1];; localObject = null)
        {
          this.fvn.setValStr(paramIntent);
          this.fvr.setValStr((String)localObject);
          if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
            break;
          }
          YH();
          return;
          h.b(this, getString(R.l.addressui_mall_recharge_pick_contact_error), "", true);
          paramIntent = null;
        }
        h.b(this, getString(R.l.addressui_mall_recharge_pick_contact_error), "", true);
        return;
        if (paramInt2 != -1) {
          break;
        }
        paramIntent = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
      } while (paramIntent == null);
      y.d("MicroMsg.WalletAddAddressUI", "addr: " + paramIntent.toString());
    } while (paramIntent == null);
    if (com.tencent.mm.plugin.address.a.a.YD().w(paramIntent.ela, paramIntent.elc, paramIntent.eld))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramIntent.ela);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramIntent.elc);
      if (!TextUtils.isEmpty(paramIntent.eld))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramIntent.eld);
      }
      this.fvo.setValStr(((StringBuilder)localObject).toString());
      label419:
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(paramIntent.ele)) {
        ((StringBuilder)localObject).append(paramIntent.ele);
      }
      if (!TextUtils.isEmpty(paramIntent.elf)) {
        ((StringBuilder)localObject).append(paramIntent.elf);
      }
      if (!TextUtils.isEmpty(paramIntent.elg)) {
        ((StringBuilder)localObject).append(paramIntent.elg);
      }
      if (!TextUtils.isEmpty(paramIntent.eli))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramIntent.eli);
      }
      if ((!bk.bl(paramIntent.eli)) || (bk.bl(paramIntent.ekZ))) {
        break label603;
      }
      this.fvp.setValStr(paramIntent.ekZ);
    }
    for (;;)
    {
      paramIntent = com.tencent.mm.plugin.address.a.a.YD().v(paramIntent.ela, paramIntent.elc, paramIntent.eld);
      if (paramIntent == null) {
        break;
      }
      this.fvq.setValStr(paramIntent.ftq);
      this.bWc = paramIntent.code;
      return;
      this.fvo.setValStr("");
      break label419;
      label603:
      this.fvp.setValStr(((StringBuilder)localObject).toString());
    }
    y.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(415, this);
    au.Dk().a(418, this);
    y.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    y.Fc(0);
    this.ftK = getIntent().getIntExtra("address_id", 0);
    if (this.ftK == 0) {
      setMMTitle(R.l.address_add_title);
    }
    for (;;)
    {
      initView();
      return;
      setMMTitle(R.l.address_modify_title);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(415, this);
    au.Dk().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.YD();
    y.i("MicroMsg.WalletAddrMgr", "clean data");
    Iterator localIterator = locall.ftu.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    localIterator = locall.ftv.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    locall.ftt.clear();
    locall.ftu.clear();
    locall.ftv.clear();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      YJ();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.WalletAddAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    case 48: 
      if (paramArrayOfInt[0] == 0)
      {
        YP();
        return;
      }
      h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new WalletAddAddressUI.4(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
        }
      });
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      YQ();
      return;
    }
    h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new WalletAddAddressUI.6(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    });
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.ftk != null) {
      this.ftk.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.address.a.a.YD().fts;
      if (paramString.ftA.size() > 0)
      {
        a(this.fvt, this.fvs);
        paramString = (b)paramString.ftA.getFirst();
        if (paramString != null) {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(paramString));
        }
      }
      for (;;)
      {
        finish();
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
      h.a(this, R.l.address_add_fail_tips, 0, false, new WalletAddAddressUI.14(this));
      return;
    case -3100: 
      h.a(this, R.l.address_add_limit_tips, 0, false, new WalletAddAddressUI.12(this));
      return;
    }
    h.a(this, paramString, "", new WalletAddAddressUI.13(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI
 * JD-Core Version:    0.7.0.1
 */