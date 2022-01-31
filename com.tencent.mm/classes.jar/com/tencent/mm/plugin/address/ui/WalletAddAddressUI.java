package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletAddAddressUI
  extends MMActivity
  implements f, AddrEditView.b
{
  private String cDP;
  private Dialog gKM;
  private int gLm;
  private AddrEditView gMS;
  private AddrEditView gMT;
  private AddrEditView gMU;
  private AddrEditView gMV;
  private AddrEditView gMW;
  private com.tencent.mm.plugin.address.d.b gMX;
  private com.tencent.mm.plugin.address.d.b gMY;
  
  public WalletAddAddressUI()
  {
    AppMethodBeat.i(16944);
    this.gLm = 0;
    this.gMX = null;
    this.gMY = new com.tencent.mm.plugin.address.d.b();
    this.gKM = null;
    this.cDP = "";
    AppMethodBeat.o(16944);
  }
  
  private static void a(com.tencent.mm.plugin.address.d.b paramb1, com.tencent.mm.plugin.address.d.b paramb2)
  {
    if ((paramb1 != null) && (paramb2 != null))
    {
      paramb2.id = paramb1.id;
      paramb2.gLe = paramb1.gLe;
      paramb2.gLf = paramb1.gLf;
      paramb2.gLg = paramb1.gLg;
      paramb2.gLi = paramb1.gLi;
      paramb2.gLj = paramb1.gLj;
      paramb2.gLk = paramb1.gLk;
      paramb2.gLh = paramb1.gLh;
      paramb2.gLl = paramb1.gLl;
    }
  }
  
  private void asA()
  {
    AppMethodBeat.i(16955);
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.gMT.getText())) {
      localStringBuilder.append(this.gMT.getText());
    }
    if (!TextUtils.isEmpty(this.gMU.getText())) {
      localStringBuilder.append(this.gMU.getText());
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("wallet_address", localStringBuilder.toString());
    localIntent.putExtra("map_view_type", 8);
    d.b(this, "location", ".ui.RedirectUI", localIntent, 3);
    AppMethodBeat.o(16955);
  }
  
  private boolean asr()
  {
    boolean bool2 = false;
    AppMethodBeat.i(16950);
    boolean bool1 = true;
    if (!this.gMS.asv()) {
      bool1 = false;
    }
    if (!this.gMU.asv()) {
      bool1 = false;
    }
    if (!this.gMT.asv()) {
      bool1 = false;
    }
    if (!this.gMV.asv()) {
      bool1 = false;
    }
    if (!this.gMW.asv()) {
      bool1 = bool2;
    }
    for (;;)
    {
      enableOptionMenu(bool1);
      AppMethodBeat.o(16950);
      return bool1;
    }
  }
  
  private void ast()
  {
    int k = 1;
    AppMethodBeat.i(16953);
    int j = 2131296448;
    if (this.gLm == 0) {
      j = 2131296447;
    }
    if (this.gMS.asw()) {}
    for (int i = 1;; i = 0)
    {
      if (this.gMU.asw()) {
        i = 1;
      }
      if (this.gMT.asw()) {
        i = 1;
      }
      if (this.gMV.asw()) {
        i = 1;
      }
      if (this.gMW.asw()) {
        i = k;
      }
      for (;;)
      {
        if (i != 0)
        {
          h.a(this, j, 2131297087, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(16943);
              WalletAddAddressUI.this.setResult(0);
              WalletAddAddressUI.this.finish();
              AppMethodBeat.o(16943);
            }
          }, null);
          AppMethodBeat.o(16953);
          return;
        }
        setResult(0);
        finish();
        AppMethodBeat.o(16953);
        return;
      }
    }
  }
  
  private void asz()
  {
    AppMethodBeat.i(16954);
    Intent localIntent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
    if (bo.k(this, localIntent))
    {
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(16954);
      return;
    }
    ab.w("MicroMsg.WalletAddAddressUI", "intent not available");
    AppMethodBeat.o(16954);
  }
  
  public final void ass()
  {
    AppMethodBeat.i(16951);
    asr();
    AppMethodBeat.o(16951);
  }
  
  public int getLayoutId()
  {
    return 2130971119;
  }
  
  public void initView()
  {
    AppMethodBeat.i(16946);
    com.tencent.mm.plugin.address.a.a.asn().aso();
    Object localObject = (MMScrollView)findViewById(2131823477);
    ((MMScrollView)localObject).a((ViewGroup)localObject, (View.OnFocusChangeListener)localObject);
    this.gMS = ((AddrEditView)findViewById(2131828911));
    this.gMT = ((AddrEditView)findViewById(2131828913));
    this.gMU = ((AddrEditView)findViewById(2131828914));
    this.gMV = ((AddrEditView)findViewById(2131828915));
    this.gMW = ((AddrEditView)findViewById(2131828912));
    this.gMS.setOnInputValidChangeListener(this);
    this.gMT.setOnInputValidChangeListener(this);
    this.gMU.setOnInputValidChangeListener(this);
    this.gMV.setOnInputValidChangeListener(this);
    this.gMW.setOnInputValidChangeListener(this);
    this.gMS.setInfoIvOnClickListener(new WalletAddAddressUI.1(this));
    this.gMT.setInfoIvOnClickListener(new AddrEditView.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(16937);
        boolean bool = com.tencent.mm.pluginsdk.permission.b.a(WalletAddAddressUI.this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
        ab.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          AppMethodBeat.o(16937);
          return;
        }
        WalletAddAddressUI.b(WalletAddAddressUI.this);
        AppMethodBeat.o(16937);
      }
    });
    this.gMT.setOnClickListener(new WalletAddAddressUI.9(this));
    if (this.gLm != 0)
    {
      this.gMX = com.tencent.mm.plugin.address.a.a.asn().na(this.gLm);
      this.gMS.setValStr(this.gMX.gLj);
      localObject = new StringBuilder();
      if (!TextUtils.isEmpty(this.gMX.gLe)) {
        ((StringBuilder)localObject).append(this.gMX.gLe);
      }
      if (!TextUtils.isEmpty(this.gMX.gLf))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.gMX.gLf);
      }
      if (!TextUtils.isEmpty(this.gMX.gLg))
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.gMX.gLg);
      }
      this.gMT.setValStr(((StringBuilder)localObject).toString());
      this.gMU.setValStr(this.gMX.gLi);
      this.gMV.setValStr(this.gMX.gLh);
      this.gMW.setValStr(this.gMX.gLk);
    }
    setBackBtn(new WalletAddAddressUI.10(this));
    addTextOptionMenu(0, getString(2131297063), new WalletAddAddressUI.11(this), null, q.b.zby);
    asr();
    AppMethodBeat.o(16946);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(16948);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(16948);
      return;
      if (paramInt2 == -1)
      {
        Object localObject = paramIntent.getStringExtra("karea_result");
        if (!bo.isNullOrNil((String)localObject))
        {
          ab.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:".concat(String.valueOf(localObject)));
          this.gMT.setValStr((String)localObject);
        }
        localObject = paramIntent.getStringExtra("kpost_code");
        if (!bo.isNullOrNil((String)localObject))
        {
          ab.d("MicroMsg.WalletAddAddressUI", "post:".concat(String.valueOf(localObject)));
          this.gMV.setValStr((String)localObject);
        }
        this.cDP = paramIntent.getStringExtra("kwcode");
        AppMethodBeat.o(16948);
        return;
        if (paramInt2 == -1)
        {
          paramIntent = paramIntent.getData();
          if (paramIntent == null)
          {
            ab.d("MicroMsg.WalletAddAddressUI", "uri == null");
            AppMethodBeat.o(16948);
            return;
          }
          localObject = com.tencent.mm.pluginsdk.a.f(getBaseContext(), paramIntent);
          if ((localObject != null) && (localObject.length == 2)) {
            paramIntent = localObject[0];
          }
          for (localObject = localObject[1];; localObject = null)
          {
            this.gMS.setValStr(paramIntent);
            this.gMW.setValStr((String)localObject);
            if (!PhoneNumberUtils.isGlobalPhoneNumber((String)localObject)) {
              break;
            }
            asr();
            AppMethodBeat.o(16948);
            return;
            h.b(this, getString(2131296511), "", true);
            paramIntent = null;
          }
          h.b(this, getString(2131296511), "", true);
          AppMethodBeat.o(16948);
          return;
          if (paramInt2 == -1)
          {
            Addr localAddr = (Addr)paramIntent.getParcelableExtra("key_pick_addr");
            if (localAddr != null)
            {
              ab.d("MicroMsg.WalletAddAddressUI", "addr: " + localAddr.toString());
              if (localAddr != null)
              {
                localObject = localAddr.fBt;
                paramIntent = (Intent)localObject;
                if (bo.isNullOrNil((String)localObject)) {
                  paramIntent = localAddr.fBs;
                }
                if (!com.tencent.mm.plugin.address.a.a.asn().A(localAddr.fBr, paramIntent, localAddr.fBu)) {
                  break label652;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(localAddr.fBr);
                ((StringBuilder)localObject).append(" ");
                ((StringBuilder)localObject).append(paramIntent);
                if (!TextUtils.isEmpty(localAddr.fBu))
                {
                  ((StringBuilder)localObject).append(" ");
                  ((StringBuilder)localObject).append(localAddr.fBu);
                }
                this.gMT.setValStr(((StringBuilder)localObject).toString());
                paramIntent = new StringBuilder();
                if (!TextUtils.isEmpty(localAddr.fBv)) {
                  paramIntent.append(localAddr.fBv);
                }
                if (!TextUtils.isEmpty(localAddr.fBw)) {
                  paramIntent.append(localAddr.fBw);
                }
                if (!TextUtils.isEmpty(localAddr.fBx)) {
                  paramIntent.append(localAddr.fBx);
                }
                if (!TextUtils.isEmpty(localAddr.fBz))
                {
                  paramIntent.append(" ");
                  paramIntent.append(localAddr.fBz);
                }
                if ((!bo.isNullOrNil(localAddr.fBz)) || (bo.isNullOrNil(localAddr.fBq))) {
                  break label664;
                }
                this.gMU.setValStr(localAddr.fBq);
              }
            }
            for (;;)
            {
              paramIntent = com.tencent.mm.plugin.address.a.a.asn().z(localAddr.fBr, localAddr.fBt, localAddr.fBu);
              if (paramIntent != null)
              {
                this.gMV.setValStr(paramIntent.gKS);
                this.cDP = paramIntent.code;
              }
              AppMethodBeat.o(16948);
              return;
              label652:
              this.gMT.setValStr("");
              break;
              label664:
              this.gMU.setValStr(paramIntent.toString());
            }
          }
          ab.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(16945);
    super.onCreate(paramBundle);
    aw.Rc().a(415, this);
    aw.Rc().a(418, this);
    ab.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
    ab.Ne(0);
    this.gLm = getIntent().getIntExtra("address_id", 0);
    if (this.gLm == 0) {
      setMMTitle(2131296445);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(16945);
      return;
      setMMTitle(2131296480);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(16947);
    super.onDestroy();
    aw.Rc().b(415, this);
    aw.Rc().b(418, this);
    l locall = com.tencent.mm.plugin.address.a.a.asn();
    ab.i("MicroMsg.WalletAddrMgr", "clean data");
    Iterator localIterator = locall.gKW.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    localIterator = locall.gKX.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).clear();
    }
    locall.gKV.clear();
    locall.gKW.clear();
    locall.gKX.clear();
    AppMethodBeat.o(16947);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(16952);
    if (paramInt == 4)
    {
      ast();
      AppMethodBeat.o(16952);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(16952);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(16956);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(16956);
      return;
    }
    ab.i("MicroMsg.WalletAddAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(16956);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        asz();
        AppMethodBeat.o(16956);
        return;
      }
      h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131297837), false, new WalletAddAddressUI.4(this), new WalletAddAddressUI.5(this));
      AppMethodBeat.o(16956);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        asA();
        AppMethodBeat.o(16956);
        return;
      }
      h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new WalletAddAddressUI.6(this), new WalletAddAddressUI.7(this));
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(16949);
    if (this.gKM != null) {
      this.gKM.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.address.a.a.asn().gKU;
      if (paramString.gLc.size() > 0)
      {
        a(this.gMY, this.gMX);
        paramString = (com.tencent.mm.plugin.address.d.b)paramString.gLc.getFirst();
        if (paramString != null) {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(paramString));
        }
      }
      for (;;)
      {
        finish();
        AppMethodBeat.o(16949);
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
      h.a(this, 2131296442, 0, false, new WalletAddAddressUI.14(this));
      AppMethodBeat.o(16949);
      return;
    case -3100: 
      h.a(this, 2131296444, 0, false, new WalletAddAddressUI.12(this));
      AppMethodBeat.o(16949);
      return;
    }
    h.a(this, paramString, "", new WalletAddAddressUI.13(this));
    AppMethodBeat.o(16949);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI
 * JD-Core Version:    0.7.0.1
 */