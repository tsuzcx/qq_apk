package com.tencent.mm.plugin.address.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ba.k;
import com.tencent.mm.g.a.km;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.address.model.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI
  extends MMActivity
  implements com.tencent.mm.plugin.address.c.a
{
  private boolean gLC;
  private ListView gMh;
  private List<com.tencent.mm.plugin.address.d.b> gNe;
  private com.tencent.mm.plugin.address.d.b gNf;
  private WalletSelectAddrUI.a gNg;
  private com.tencent.mm.plugin.address.c.b gNh;
  private View gNi;
  private TextView gNj;
  private com.tencent.mm.a.p gNk;
  private boolean gNl;
  private boolean gNm;
  private com.tencent.mm.ui.widget.b.c gNn;
  private Object lockObj;
  
  public WalletSelectAddrUI()
  {
    AppMethodBeat.i(16994);
    this.gNe = new LinkedList();
    this.gNh = null;
    this.gNj = null;
    this.lockObj = new Object();
    this.gLC = false;
    this.gNl = false;
    this.gNm = false;
    this.gNn = null;
    AppMethodBeat.o(16994);
  }
  
  private void asC()
  {
    AppMethodBeat.i(17002);
    km localkm = new km();
    localkm.cAj.cup = this;
    localkm.cAj.cAl = new WalletSelectAddrUI.9(this, localkm);
    com.tencent.mm.sdk.b.a.ymk.a(localkm, Looper.myLooper());
    AppMethodBeat.o(17002);
  }
  
  private void asx()
  {
    AppMethodBeat.i(16998);
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.asl();
      this.gNe = com.tencent.mm.plugin.address.a.a.asn().gKU.gLc;
      this.gNg.items = this.gNe;
      this.gNe.size();
      this.gNi.setVisibility(8);
      this.gNg.notifyDataSetChanged();
      AppMethodBeat.o(16998);
      return;
    }
  }
  
  private void bq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(17001);
    paramString1 = new d(paramString1, paramString2, this.gNk);
    this.gNh.e(paramString1);
    AppMethodBeat.o(17001);
  }
  
  private void nd(int paramInt)
  {
    AppMethodBeat.i(17003);
    Intent localIntent = new Intent();
    localIntent.setClass(this, WalletAddAddressUI.class);
    localIntent.putExtra("address_id", paramInt);
    startActivity(localIntent);
    AppMethodBeat.o(17003);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17000);
    this.gNh.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 417)
      {
        if (((e)paramm).gKN)
        {
          asx();
          getContentView().setVisibility(0);
          if ((this.gLC) && (this.gNe.size() == 0))
          {
            paramString = new Intent();
            paramString.setClass(this, WalletAddAddressUI.class);
            startActivityForResult(paramString, 1);
          }
        }
        AppMethodBeat.o(17000);
        return;
      }
      if (paramm.getType() == 416)
      {
        paramString = (f)paramm;
        com.tencent.mm.plugin.address.a.a.asl();
        paramString = com.tencent.mm.plugin.address.a.a.asn().na(paramString.gKO);
        if (paramString != null)
        {
          com.tencent.mm.plugin.address.a.a.asl();
          ab.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.asn().a(paramString))));
        }
        asx();
        AppMethodBeat.o(17000);
        return;
      }
      if (paramm.getType() == 419)
      {
        if (this.gNf != null)
        {
          setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.gNf));
          finish();
          AppMethodBeat.o(17000);
        }
      }
      else if (paramm.getType() == 582)
      {
        paramString = getString(2131296508);
        switch (((d)paramm).status)
        {
        default: 
        case 1: 
        case 2: 
        case 0: 
          for (;;)
          {
            if (this.gNn != null) {
              this.gNn.dismiss();
            }
            this.gNn = h.a(this, paramString, null, true, null);
            AppMethodBeat.o(17000);
            return;
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(196657, Boolean.TRUE);
            this.gNj.setVisibility(8);
            paramString = getString(2131296509);
            continue;
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(196657, Boolean.TRUE);
            this.gNj.setVisibility(8);
            asx();
            getContentView().setVisibility(0);
            paramString = getString(2131296510);
          }
        }
        asC();
        AppMethodBeat.o(17000);
      }
    }
    else if ((paramm.getType() == 419) && (paramInt2 == -3103))
    {
      h.a(this, true, paramString, "", getString(2131296449), getString(2131296888), new DialogInterface.OnClickListener()new WalletSelectAddrUI.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(16988);
          paramAnonymousDialogInterface.dismiss();
          WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.g(WalletSelectAddrUI.this).id);
          AppMethodBeat.o(16988);
        }
      }, new WalletSelectAddrUI.2(this));
    }
    AppMethodBeat.o(17000);
  }
  
  public int getLayoutId()
  {
    return 2130971122;
  }
  
  public void initView()
  {
    AppMethodBeat.i(16999);
    this.gNj = ((TextView)findViewById(2131828921));
    this.gNj.setVisibility(8);
    this.gNj.setOnClickListener(new WalletSelectAddrUI.3(this));
    this.gMh = ((ListView)findViewById(2131828919));
    this.gNg = new WalletSelectAddrUI.a(this, this);
    this.gNi = findViewById(2131828920);
    this.gNi.findViewById(2131828917).setVisibility(8);
    ((TextView)this.gNi.findViewById(2131828916)).setText(2131296443);
    this.gMh.setAdapter(this.gNg);
    this.gMh.setOnItemClickListener(new WalletSelectAddrUI.4(this));
    this.gMh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(16982);
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(2131755062);
        h.a(WalletSelectAddrUI.this.getContext(), null, paramAnonymousAdapterView, null, new h.c()
        {
          public final void iA(int paramAnonymous2Int)
          {
            AppMethodBeat.i(16981);
            for (;;)
            {
              synchronized (WalletSelectAddrUI.c(WalletSelectAddrUI.this))
              {
                if (paramAnonymousInt >= WalletSelectAddrUI.d(WalletSelectAddrUI.this).size()) {
                  break label203;
                }
                com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)WalletSelectAddrUI.d(WalletSelectAddrUI.this).get(paramAnonymousInt);
                if (localb == null)
                {
                  AppMethodBeat.o(16981);
                  return;
                }
              }
              switch (paramAnonymous2Int)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(16981);
                return;
                WalletSelectAddrUI.a(WalletSelectAddrUI.this, localObject1.id);
                AppMethodBeat.o(16981);
                return;
                localf = new f(localObject1.id);
                WalletSelectAddrUI.a(WalletSelectAddrUI.this, null);
                WalletSelectAddrUI.h(WalletSelectAddrUI.this).e(localf);
                AppMethodBeat.o(16981);
                return;
                WalletSelectAddrUI.b(WalletSelectAddrUI.this, localf);
              }
              label203:
              f localf = null;
            }
          }
        });
        AppMethodBeat.o(16982);
        return true;
      }
    });
    asx();
    this.gNi.setOnClickListener(new WalletSelectAddrUI.6(this));
    this.gNg.notifyDataSetChanged();
    setBackBtn(new WalletSelectAddrUI.7(this));
    addIconOptionMenu(0, 2131296445, 2131230736, new WalletSelectAddrUI.8(this));
    AppMethodBeat.o(16999);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(17004);
    if (paramInt1 == 1)
    {
      if (-1 != paramInt2) {
        break label162;
      }
      if (paramIntent != null) {
        break label51;
      }
      ab.e("MicroMsg.AddrUtil", "intent == null");
      paramIntent = null;
      setResult(-1, com.tencent.mm.plugin.address.e.a.b(paramIntent));
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(17004);
      return;
      label51:
      com.tencent.mm.plugin.address.d.b localb = new com.tencent.mm.plugin.address.d.b();
      localb.gLl = paramIntent.getStringExtra("nationalCode");
      localb.gLj = paramIntent.getStringExtra("userName");
      localb.gLk = paramIntent.getStringExtra("telNumber");
      localb.gLh = paramIntent.getStringExtra("addressPostalCode");
      localb.gLe = paramIntent.getStringExtra("proviceFirstStageName");
      localb.gLf = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.gLg = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.gLi = paramIntent.getStringExtra("addressDetailInfo");
      paramIntent = localb;
      break;
      label162:
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(16995);
    super.onCreate(paramBundle);
    this.gNh = new com.tencent.mm.plugin.address.c.b(this, this);
    paramBundle = getIntent();
    this.gNl = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    this.gNm = paramBundle.getBooleanExtra("launch_from_remittance", false);
    if ((paramBundle.getBooleanExtra("launch_from_webview", false)) || (this.gNl))
    {
      this.gLC = true;
      getContentView().setVisibility(8);
      if (this.gNl) {
        getWindow().setBackgroundDrawableResource(2131690310);
      }
      ab.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yDx, Boolean.TRUE)).booleanValue())
      {
        ab.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
        h.a(this, getString(2131296495), getString(2131296496), getString(2131296332), new WalletSelectAddrUI.1(this));
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yDx, Boolean.FALSE);
      }
    }
    setMMTitle(2131296494);
    this.gNh.addSceneEndListener(417);
    this.gNh.addSceneEndListener(416);
    this.gNh.addSceneEndListener(419);
    this.gNh.addSceneEndListener(582);
    paramBundle = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.gNh.e(paramBundle);
    aw.aaz();
    this.gNk = new com.tencent.mm.a.p(bo.a((Integer)com.tencent.mm.model.c.Ru().get(9, null), 0));
    initView();
    aw.aaz();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      paramBundle = new k(12);
      aw.Rc().a(paramBundle, 0);
    }
    AppMethodBeat.o(16995);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(16996);
    super.onDestroy();
    this.gNh.removeSceneEndListener(417);
    this.gNh.removeSceneEndListener(416);
    this.gNh.removeSceneEndListener(419);
    this.gNh.removeSceneEndListener(582);
    AppMethodBeat.o(16996);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(16997);
    super.onResume();
    asx();
    AppMethodBeat.o(16997);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */