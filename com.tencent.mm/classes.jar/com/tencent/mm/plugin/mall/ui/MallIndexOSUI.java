package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.fhq;
import com.tencent.mm.protocal.protobuf.fhr;
import com.tencent.mm.protocal.protobuf.fhu;
import com.tencent.mm.protocal.protobuf.fhx;
import com.tencent.mm.protocal.protobuf.fhy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.wallet_core.ui.g;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private a[] EQV;
  private ak EQW;
  private TextView EQX;
  private boolean EQY;
  private long EQZ;
  private boolean ERa;
  private boolean ERb;
  private String ERc;
  private int ERd;
  private IListener ERe;
  private IListener ERf;
  private boolean isFinished;
  private boolean isFirst;
  private long lastUpdateTime;
  private View sBm;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(66081);
    this.EQV = new a[4];
    this.EQW = new ak();
    this.EQX = null;
    this.lastUpdateTime = 0L;
    this.sBm = null;
    this.EQY = false;
    this.isFinished = false;
    this.EQZ = 0L;
    this.ERa = false;
    this.ERb = false;
    this.ERc = "";
    this.ERd = 0;
    this.isFirst = true;
    this.ERe = new MallIndexOSUI.1(this);
    this.ERf = new MallIndexOSUI.2(this);
    AppMethodBeat.o(66081);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(66085);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    String str = paramMallFunction.h5Url;
    long l = Util.safeParseLong(paramMallFunction.nBK);
    com.tencent.mm.kernel.h.aHH();
    localh.a(13720, new Object[] { str, Long.valueOf(l), (Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0)) });
    AppMethodBeat.o(66085);
  }
  
  protected final void eHM()
  {
    AppMethodBeat.i(66086);
    int i = getResources().getColor(a.c.mall_index_new_bg_color);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(a.f.root_layout).setBackgroundColor(i);
    AppMethodBeat.o(66086);
  }
  
  protected final void eQA() {}
  
  protected final boolean eQB()
  {
    AppMethodBeat.i(66093);
    fhq localfhq = this.EQW.OTI;
    int i = 0;
    while (i < this.EQV.length)
    {
      this.EQV[i].view.setVisibility(8);
      this.EQV[i].EPf.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localfhq.Tbw.size()) && (i < this.EQV.length))
    {
      fhr localfhr = (fhr)localfhq.Tbw.get(i);
      this.EQV[i].view.setVisibility(0);
      this.EQV[i].EPf.setUrl(com.tencent.mm.platformtools.z.a(localfhr.UHD));
      this.EQV[i].EPf.setVisibility(0);
      this.EQV[i].jiw.setText(com.tencent.mm.platformtools.z.a(localfhr.UHC));
      Log.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), com.tencent.mm.platformtools.z.a(localfhr.UHD) });
      this.EQV[i].ERm.setVisibility(8);
      String str = com.tencent.mm.platformtools.z.a(localfhr.UHF);
      if (!Util.isNullOrNil(str))
      {
        this.EQV[i].ERm.setText(str);
        this.EQV[i].ERm.setVisibility(0);
      }
      this.EQV[i].view.setOnClickListener(new MallIndexOSUI.3(this, localfhr));
      i += 1;
    }
    if ((this.EQx != null) && (this.sBm != null) && (!this.EQY))
    {
      this.EQx.addFooterView(this.sBm);
      this.EQY = true;
    }
    if (!Util.isNullOrNil(this.EQW.OTO))
    {
      this.EQX.setText(this.EQW.OTO);
      this.EQX.setVisibility(0);
    }
    AppMethodBeat.o(66093);
    return true;
  }
  
  protected final void eQC()
  {
    AppMethodBeat.i(66094);
    Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
    boolean bool2 = this.EQW.OTK;
    com.tencent.mm.kernel.h.aHH();
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VkB, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VkB, Boolean.TRUE);
        com.tencent.mm.ui.base.h.a(this, getString(a.i.mall_multi_wallet_tip), null, true, null);
      }
      AppMethodBeat.o(66094);
      return;
    }
  }
  
  protected final void eQF() {}
  
  protected final void eQG()
  {
    AppMethodBeat.i(66084);
    g.a(this.EQC, "1", this.EQW.OTN, this.EQW.EBs);
    AppMethodBeat.o(66084);
  }
  
  protected final void eQH() {}
  
  protected final void eQJ()
  {
    AppMethodBeat.i(66095);
    removeAllOptionMenu();
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66080);
        final fhx localfhx = MallIndexOSUI.e(MallIndexOSUI.this).OTJ;
        final boolean bool = MallIndexOSUI.e(MallIndexOSUI.this).OTK;
        if (bool)
        {
          paramAnonymousMenuItem = new String[localfhx.Tbw.size() + 1];
          paramAnonymousMenuItem[localfhx.Tbw.size()] = MallIndexOSUI.this.getString(a.i.wallet_index_ui_opt_wallet_switch);
        }
        for (;;)
        {
          int i = 0;
          while (i < localfhx.Tbw.size())
          {
            paramAnonymousMenuItem[i] = com.tencent.mm.platformtools.z.a(((fhy)localfhx.Tbw.get(i)).UHC);
            i += 1;
          }
          paramAnonymousMenuItem = new String[localfhx.Tbw.size()];
        }
        com.tencent.mm.ui.base.h.b(MallIndexOSUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.d()
        {
          public final void qy(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66079);
            if (paramAnonymous2Int < localfhx.Tbw.size())
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(((fhy)localfhx.Tbw.get(paramAnonymous2Int)).UHO));
              localIntent.putExtra(f.r.VSX, true);
              g.aJ(MallIndexOSUI.this.getContext(), localIntent);
              AppMethodBeat.o(66079);
              return;
            }
            if (bool) {
              c.f(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
            }
            AppMethodBeat.o(66079);
          }
        });
        AppMethodBeat.o(66080);
        return true;
      }
    });
    AppMethodBeat.o(66095);
  }
  
  protected final void eQL() {}
  
  protected final void eQy()
  {
    AppMethodBeat.i(66087);
    String str1 = this.EQW.OTL;
    String str2 = this.EQW.OTM;
    setMMTitle(str1);
    if (!Util.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(66087);
  }
  
  protected final void eQz() {}
  
  public void finish()
  {
    AppMethodBeat.i(66096);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(66096);
  }
  
  protected final void fo(View paramView)
  {
    AppMethodBeat.i(66089);
    this.EQV[0] = new a();
    this.EQV[0].view = paramView.findViewById(a.f.offline_area);
    this.EQV[0].EPf = ((CdnImageView)paramView.findViewById(a.f.offline_pic));
    this.EQV[0].EPf.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.EQV[0].jiw = ((TextView)paramView.findViewById(a.f.offline_wording));
    this.EQV[0].ERm = ((TextView)paramView.findViewById(a.f.extra_wording_first));
    this.EQV[0].EPf.setVisibility(4);
    this.EQV[1] = new a();
    this.EQV[1].view = paramView.findViewById(a.f.balance_area);
    this.EQV[1].EPf = ((CdnImageView)paramView.findViewById(a.f.balance_pic));
    this.EQV[1].EPf.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.EQV[1].jiw = ((TextView)paramView.findViewById(a.f.balance_wording));
    this.EQV[1].ERm = ((TextView)paramView.findViewById(a.f.balance_num));
    this.EQV[1].EPf.setVisibility(4);
    this.EQV[2] = new a();
    this.EQV[2].view = paramView.findViewById(a.f.bankcard_area);
    this.EQV[2].EPf = ((CdnImageView)paramView.findViewById(a.f.bankcard_pic));
    this.EQV[2].EPf.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.EQV[2].jiw = ((TextView)paramView.findViewById(a.f.bankcard_tv));
    this.EQV[2].ERm = ((TextView)paramView.findViewById(a.f.extra_wording_three));
    this.EQV[2].EPf.setVisibility(4);
    this.EQV[3] = new a();
    this.EQV[3].view = paramView.findViewById(a.f.lqt_area);
    this.EQV[3].EPf = ((CdnImageView)paramView.findViewById(a.f.lqt_pic));
    this.EQV[3].jiw = ((TextView)paramView.findViewById(a.f.lqt_wording));
    this.EQV[3].EPf.setVisibility(4);
    this.EQV[3].view.setVisibility(8);
    AppMethodBeat.o(66089);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66088);
    this.zRq = ad.kS(this).inflate(a.g.mall_index_stub_with_bankcard, null);
    this.EQx.addHeaderView(this.zRq);
    LinearLayout localLinearLayout = (LinearLayout)this.zRq.findViewById(a.f.header_content_layout);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.eQt();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66088);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66083);
    super.initView();
    this.EQx.setPadding(a.EPg, 0, a.EPg, 0);
    AppMethodBeat.o(66083);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66098);
    Log.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(66098);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66082);
    e.eQZ();
    a.b(this, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.sBm = View.inflate(this, a.g.mall_index_foot, null);
    this.sBm.setClickable(false);
    this.sBm.setEnabled(false);
    this.EQX = ((TextView)this.sBm.findViewById(a.f.wallet_region_desc));
    this.EQW = u.gJu().amB(this.EOJ);
    addSceneEndListener(1577);
    Log.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new i();
    if (this.EQW != null)
    {
      ak localak = this.EQW;
      if ((localak.OTI != null) && (localak.OTI.Tbw != null) && (localak.OTI.Tbw.size() != 0)) {
        break label167;
      }
    }
    label167:
    for (int i = 1; i != 0; i = 0)
    {
      doSceneForceProgress(paramBundle);
      AppMethodBeat.o(66082);
      return;
    }
    doSceneProgress(paramBundle, false);
    AppMethodBeat.o(66082);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66092);
    super.onDestroy();
    removeSceneEndListener(1577);
    this.ERe.dead();
    this.ERf.dead();
    AppMethodBeat.o(66092);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66091);
    super.onPause();
    AppMethodBeat.o(66091);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66090);
    super.onResume();
    if (!this.isFirst)
    {
      int i = com.tencent.mm.n.h.axc().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
      long l = System.currentTimeMillis();
      Log.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
      if (l - this.lastUpdateTime >= i)
      {
        this.lastUpdateTime = System.currentTimeMillis();
        doSceneProgress(new i(), false);
      }
    }
    for (;;)
    {
      eQy();
      AppMethodBeat.o(66090);
      return;
      this.isFirst = false;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66097);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if (paramq.getType() == 1577)
    {
      paramq = (i)paramq;
      if (paramq.EOO == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!Util.isNullOrNil(paramq.eQq()))) {
        if (this.isFinished)
        {
          AppMethodBeat.o(66097);
          return true;
          paramInt1 = paramq.EOO.UHI;
        }
        else if (System.currentTimeMillis() - this.EQZ > 500L)
        {
          this.EQZ = System.currentTimeMillis();
          this.ERe.alive();
          this.ERf.alive();
          paramString = new Bundle();
          this.ERc = paramq.eQq();
          paramq = new Intent();
          Log.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.ERc });
          paramString.putString("KoriginUrl", this.ERc);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramq.putExtra("rawUrl", this.ERc);
          paramq.putExtra("jsapiargs", paramString);
          paramq.putExtra("geta8key_username", com.tencent.mm.model.z.bcZ());
          paramq.putExtra("pay_channel", 1);
          g.c(getContext(), paramq, 4);
        }
      }
      this.EQW = u.gJu().amB(this.EOJ);
      eQG();
      eQB();
      eQy();
      eQC();
    }
    AppMethodBeat.o(66097);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    public CdnImageView EPf;
    public TextView ERm;
    public TextView jiw;
    public View view;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */