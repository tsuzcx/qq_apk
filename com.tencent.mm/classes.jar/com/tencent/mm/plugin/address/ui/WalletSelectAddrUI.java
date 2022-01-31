package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.R.c;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.k;
import com.tencent.mm.h.a.jz;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.model.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI
  extends MMActivity
  implements com.tencent.mm.plugin.address.c.a
{
  private ListView fuF;
  private boolean fua = false;
  private com.tencent.mm.plugin.address.d.b fvA;
  private WalletSelectAddrUI.a fvB;
  private com.tencent.mm.plugin.address.c.b fvC = null;
  private View fvD;
  private TextView fvE = null;
  private o fvF;
  private boolean fvG = false;
  private com.tencent.mm.ui.widget.a.c fvH = null;
  private List<com.tencent.mm.plugin.address.d.b> fvz = new LinkedList();
  private Object lockObj = new Object();
  
  private void YN()
  {
    synchronized (this.lockObj)
    {
      com.tencent.mm.plugin.address.a.a.YB();
      this.fvz = com.tencent.mm.plugin.address.a.a.YD().fts.ftA;
      this.fvB.items = this.fvz;
      this.fvz.size();
      this.fvD.setVisibility(8);
      this.fvB.notifyDataSetChanged();
      return;
    }
  }
  
  private void YS()
  {
    jz localjz = new jz();
    localjz.bSE.bMV = this;
    localjz.bSE.bSG = new WalletSelectAddrUI.9(this, localjz);
    com.tencent.mm.sdk.b.a.udP.a(localjz, Looper.myLooper());
  }
  
  private void aV(String paramString1, String paramString2)
  {
    paramString1 = new d(paramString1, paramString2, this.fvF);
    this.fvC.g(paramString1);
  }
  
  private void kl(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, WalletAddAddressUI.class);
    localIntent.putExtra("address_id", paramInt);
    startActivity(localIntent);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.fvC.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramm.getType() == 417) {
        if (((e)paramm).ftl)
        {
          YN();
          this.mController.contentView.setVisibility(0);
          if ((this.fua) && (this.fvz.size() == 0))
          {
            paramString = new Intent();
            paramString.setClass(this, WalletAddAddressUI.class);
            startActivityForResult(paramString, 1);
          }
        }
      }
    }
    while ((paramm.getType() != 419) || (paramInt2 != -3103))
    {
      do
      {
        do
        {
          return;
          if (paramm.getType() == 416)
          {
            paramString = (f)paramm;
            com.tencent.mm.plugin.address.a.a.YB();
            paramString = com.tencent.mm.plugin.address.a.a.YD().kg(paramString.ftm);
            if (paramString != null)
            {
              com.tencent.mm.plugin.address.a.a.YB();
              boolean bool = com.tencent.mm.plugin.address.a.a.YD().a(paramString);
              y.d("MicroMsg.WalletSelectAddrUI", "delte addr " + bool);
            }
            YN();
            return;
          }
          if (paramm.getType() != 419) {
            break;
          }
        } while (this.fvA == null);
        setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.fvA));
        finish();
        return;
      } while (paramm.getType() != 582);
      paramString = getString(R.l.addressui_mall_address_import_fail);
      switch (((d)paramm).status)
      {
      default: 
      case 1: 
      case 2: 
      case 0: 
        for (;;)
        {
          if (this.fvH != null) {
            this.fvH.dismiss();
          }
          this.fvH = h.a(this, paramString, null, true, null);
          return;
          au.Hx();
          com.tencent.mm.model.c.Dz().o(196657, Boolean.valueOf(true));
          this.fvE.setVisibility(8);
          paramString = getString(R.l.addressui_mall_address_import_noinfo);
          continue;
          au.Hx();
          com.tencent.mm.model.c.Dz().o(196657, Boolean.valueOf(true));
          this.fvE.setVisibility(8);
          YN();
          this.mController.contentView.setVisibility(0);
          paramString = getString(R.l.addressui_mall_address_import_ok);
        }
      }
      YS();
      return;
    }
    h.a(this, true, paramString, "", getString(R.l.address_change_telephone), getString(R.l.app_cancel), new WalletSelectAddrUI.10(this), new WalletSelectAddrUI.2(this));
  }
  
  protected final int getLayoutId()
  {
    return R.i.wallet_address_select_ui;
  }
  
  public final void initView()
  {
    this.fvE = ((TextView)findViewById(R.h.import_ecc_address_tv));
    this.fvE.setVisibility(8);
    this.fvE.setOnClickListener(new WalletSelectAddrUI.3(this));
    this.fuF = ((ListView)findViewById(R.h.settings_lv_address));
    this.fvB = new WalletSelectAddrUI.a(this, this);
    this.fvD = findViewById(R.h.add_address);
    this.fvD.findViewById(R.h.address_content_tv).setVisibility(8);
    ((TextView)this.fvD.findViewById(R.h.address_name_tv)).setText(R.l.address_add_item);
    this.fuF.setAdapter(this.fvB);
    this.fuF.setOnItemClickListener(new WalletSelectAddrUI.4(this));
    this.fuF.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = WalletSelectAddrUI.this.getResources().getStringArray(R.c.wallet_address_opt_list);
        h.a(WalletSelectAddrUI.this.mController.uMN, null, paramAnonymousAdapterView, null, new h.c()
        {
          public final void gl(int paramAnonymous2Int)
          {
            for (;;)
            {
              synchronized (WalletSelectAddrUI.c(WalletSelectAddrUI.this))
              {
                if (paramAnonymousInt >= WalletSelectAddrUI.d(WalletSelectAddrUI.this).size()) {
                  break label163;
                }
                com.tencent.mm.plugin.address.d.b localb = (com.tencent.mm.plugin.address.d.b)WalletSelectAddrUI.d(WalletSelectAddrUI.this).get(paramAnonymousInt);
                if (localb == null) {
                  return;
                }
              }
              switch (paramAnonymous2Int)
              {
              default: 
                return;
              case 0: 
                WalletSelectAddrUI.a(WalletSelectAddrUI.this, localObject1.id);
                return;
              case 1: 
                localf = new f(localObject1.id);
                WalletSelectAddrUI.a(WalletSelectAddrUI.this, null);
                WalletSelectAddrUI.g(WalletSelectAddrUI.this).g(localf);
                return;
              }
              WalletSelectAddrUI.b(WalletSelectAddrUI.this, localf);
              return;
              label163:
              f localf = null;
            }
          }
        });
        return true;
      }
    });
    YN();
    this.fvD.setOnClickListener(new WalletSelectAddrUI.6(this));
    this.fvB.notifyDataSetChanged();
    setBackBtn(new WalletSelectAddrUI.7(this));
    addIconOptionMenu(0, R.l.address_add_title, R.k.actionbar_icon_dark_add, new WalletSelectAddrUI.8(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (-1 != paramInt2) {
        break label150;
      }
      if (paramIntent != null) {
        break label39;
      }
      y.e("MicroMsg.AddrUtil", "intent == null");
      paramIntent = null;
      setResult(-1, com.tencent.mm.plugin.address.e.a.b(paramIntent));
    }
    for (;;)
    {
      finish();
      return;
      label39:
      com.tencent.mm.plugin.address.d.b localb = new com.tencent.mm.plugin.address.d.b();
      localb.ftJ = paramIntent.getStringExtra("nationalCode");
      localb.ftH = paramIntent.getStringExtra("userName");
      localb.ftI = paramIntent.getStringExtra("telNumber");
      localb.ftF = paramIntent.getStringExtra("addressPostalCode");
      localb.ftC = paramIntent.getStringExtra("proviceFirstStageName");
      localb.ftD = paramIntent.getStringExtra("addressCitySecondStageName");
      localb.ftE = paramIntent.getStringExtra("addressCountiesThirdStageName");
      localb.ftG = paramIntent.getStringExtra("addressDetailInfo");
      paramIntent = localb;
      break;
      label150:
      setResult(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fvC = new com.tencent.mm.plugin.address.c.b(this, this);
    paramBundle = getIntent();
    this.fvG = paramBundle.getBooleanExtra("launch_from_appbrand", false);
    if ((paramBundle.getBooleanExtra("launch_from_webview", false)) || (this.fvG))
    {
      this.fua = true;
      this.mController.contentView.setVisibility(8);
      if (this.fvG) {
        getWindow().setBackgroundDrawableResource(R.e.navpage);
      }
      y.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
      au.Hx();
      if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.utu, Boolean.valueOf(true))).booleanValue())
      {
        y.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
        h.a(this, getString(R.l.address_third_party_disclaimer_content), getString(R.l.address_third_party_disclaimer_title), getString(R.l.I_known), new WalletSelectAddrUI.1(this));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.utu, Boolean.valueOf(false));
      }
    }
    setMMTitle(R.l.address_select_title);
    this.fvC.kh(417);
    this.fvC.kh(416);
    this.fvC.kh(419);
    this.fvC.kh(582);
    paramBundle = new e(paramBundle.getStringExtra("req_url"), paramBundle.getStringExtra("req_app_id"), 2);
    this.fvC.g(paramBundle);
    au.Hx();
    this.fvF = new o(bk.a((Integer)com.tencent.mm.model.c.Dz().get(9, null), 0));
    initView();
    au.Hx();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      paramBundle = new k(12);
      au.Dk().a(paramBundle, 0);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.fvC.ki(417);
    this.fvC.ki(416);
    this.fvC.ki(419);
    this.fvC.ki(582);
  }
  
  public void onResume()
  {
    super.onResume();
    YN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI
 * JD-Core Version:    0.7.0.1
 */