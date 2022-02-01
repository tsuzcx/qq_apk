package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.am.p;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.gec;
import com.tencent.mm.protocal.protobuf.ged;
import com.tencent.mm.protocal.protobuf.geg;
import com.tencent.mm.protocal.protobuf.gej;
import com.tencent.mm.protocal.protobuf.gek;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.s;
import java.util.HashSet;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private String KLA;
  private int KLB;
  private IListener KLC;
  private IListener KLD;
  private a[] KLt;
  private ai KLu;
  private TextView KLv;
  private boolean KLw;
  private long KLx;
  private boolean KLy;
  private boolean KLz;
  private boolean isFinished;
  private boolean isFirst;
  private long lastUpdateTime;
  private View uiE;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(66081);
    this.KLt = new a[4];
    this.KLu = new ai();
    this.KLv = null;
    this.lastUpdateTime = 0L;
    this.uiE = null;
    this.KLw = false;
    this.isFinished = false;
    this.KLx = 0L;
    this.KLy = false;
    this.KLz = false;
    this.KLA = "";
    this.KLB = 0;
    this.isFirst = true;
    this.KLC = new MallIndexOSUI.1(this, com.tencent.mm.app.f.hfK);
    this.KLD = new MallIndexOSUI.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(66081);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(66085);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    String str = paramMallFunction.h5Url;
    long l = Util.safeParseLong(paramMallFunction.qBb);
    com.tencent.mm.kernel.h.baF();
    localh.b(13720, new Object[] { str, Long.valueOf(l), (Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0)) });
    AppMethodBeat.o(66085);
  }
  
  protected final void fPx()
  {
    AppMethodBeat.i(66086);
    int i = getResources().getColor(a.c.mall_index_new_bg_color);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(a.f.root_layout).setBackgroundColor(i);
    AppMethodBeat.o(66086);
  }
  
  protected final void fZi()
  {
    AppMethodBeat.i(66087);
    String str1 = this.KLu.VJR;
    String str2 = this.KLu.VJS;
    setMMTitle(str1);
    if (!Util.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(66087);
  }
  
  protected final void fZj() {}
  
  protected final void fZk() {}
  
  protected final boolean fZl()
  {
    AppMethodBeat.i(66093);
    gec localgec = this.KLu.VJO;
    int i = 0;
    while (i < this.KLt.length)
    {
      this.KLt[i].view.setVisibility(8);
      this.KLt[i].KJD.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localgec.aaoI.size()) && (i < this.KLt.length))
    {
      final ged localged = (ged)localgec.aaoI.get(i);
      this.KLt[i].view.setVisibility(0);
      this.KLt[i].KJD.setUrl(w.a(localged.acbM));
      this.KLt[i].KJD.setVisibility(0);
      this.KLt[i].lKQ.setText(w.a(localged.acbL));
      Log.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), w.a(localged.acbM) });
      this.KLt[i].KLK.setVisibility(8);
      String str = w.a(localged.acbO);
      if (!Util.isNullOrNil(str))
      {
        this.KLt[i].KLK.setText(str);
        this.KLt[i].KLK.setVisibility(0);
      }
      this.KLt[i].view.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(262426);
          com.tencent.mm.plugin.report.service.h.OAn.b(13867, new Object[] { w.a(localged.acbN), Integer.valueOf(MallIndexOSUI.this.KJh) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", w.a(localged.acbN));
          paramAnonymousView.putExtra("geta8key_username", z.bAM());
          paramAnonymousView.putExtra("pay_channel", 1);
          paramAnonymousView.putExtra(f.s.adxf, true);
          com.tencent.mm.wallet_core.ui.i.aS(MallIndexOSUI.this.getContext(), paramAnonymousView);
          AppMethodBeat.o(262426);
        }
      });
      i += 1;
    }
    if ((this.KKV != null) && (this.uiE != null) && (!this.KLw))
    {
      this.KKV.addFooterView(this.uiE);
      this.KLw = true;
    }
    if (!Util.isNullOrNil(this.KLu.VJU))
    {
      this.KLv.setText(this.KLu.VJU);
      this.KLv.setVisibility(0);
    }
    AppMethodBeat.o(66093);
    return true;
  }
  
  protected final void fZm()
  {
    AppMethodBeat.i(66094);
    Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
    boolean bool2 = this.KLu.VJQ;
    com.tencent.mm.kernel.h.baF();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acLV, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acLV, Boolean.TRUE);
        com.tencent.mm.ui.base.k.a(this, getString(a.i.mall_multi_wallet_tip), null, true, null);
      }
      AppMethodBeat.o(66094);
      return;
    }
  }
  
  protected final void fZp() {}
  
  protected final void fZq()
  {
    AppMethodBeat.i(66084);
    com.tencent.mm.wallet_core.ui.i.a((ViewGroup)findViewById(a.f.notice_ui), this.KLa, "1", this.KLu.VJT, this.KLu.Kuq);
    if (!Util.isNullOrNil(this.KLu.VJT))
    {
      MallIndexOSUI.b localb = (MallIndexOSUI.b)component(MallIndexOSUI.b.class);
      localb.focusOrder().next(a.f.notice_ui).next(a.f.offline_area);
      localb.findViewById(a.f.notice_ui).sendAccessibilityEvent(8);
    }
    AppMethodBeat.o(66084);
  }
  
  protected final void fZr() {}
  
  protected final void fZt()
  {
    AppMethodBeat.i(66095);
    removeAllOptionMenu();
    addIconOptionMenu(0, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66080);
        final gej localgej = MallIndexOSUI.e(MallIndexOSUI.this).VJP;
        final boolean bool = MallIndexOSUI.e(MallIndexOSUI.this).VJQ;
        if (bool)
        {
          paramAnonymousMenuItem = new String[localgej.aaoI.size() + 1];
          paramAnonymousMenuItem[localgej.aaoI.size()] = MallIndexOSUI.this.getString(a.i.wallet_index_ui_opt_wallet_switch);
        }
        for (;;)
        {
          int i = 0;
          while (i < localgej.aaoI.size())
          {
            paramAnonymousMenuItem[i] = w.a(((gek)localgej.aaoI.get(i)).acbL);
            i += 1;
          }
          paramAnonymousMenuItem = new String[localgej.aaoI.size()];
        }
        com.tencent.mm.ui.base.k.b(MallIndexOSUI.this.getContext(), null, paramAnonymousMenuItem, null, new k.d()
        {
          public final void qz(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66079);
            if (paramAnonymous2Int < localgej.aaoI.size())
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", w.a(((gek)localgej.aaoI.get(paramAnonymous2Int)).acbX));
              localIntent.putExtra(f.s.adxf, true);
              com.tencent.mm.wallet_core.ui.i.aS(MallIndexOSUI.this.getContext(), localIntent);
              AppMethodBeat.o(66079);
              return;
            }
            if (bool) {
              c.g(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
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
  
  protected final void fZv() {}
  
  public void finish()
  {
    AppMethodBeat.i(66096);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(66096);
  }
  
  protected final void ib(View paramView)
  {
    AppMethodBeat.i(66089);
    this.KLt[0] = new a();
    this.KLt[0].view = paramView.findViewById(a.f.offline_area);
    this.KLt[0].KJD = ((CdnImageView)paramView.findViewById(a.f.offline_pic));
    this.KLt[0].KJD.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.KLt[0].lKQ = ((TextView)paramView.findViewById(a.f.offline_wording));
    this.KLt[0].KLK = ((TextView)paramView.findViewById(a.f.extra_wording_first));
    this.KLt[0].KJD.setVisibility(4);
    this.KLt[1] = new a();
    this.KLt[1].view = paramView.findViewById(a.f.balance_area);
    this.KLt[1].KJD = ((CdnImageView)paramView.findViewById(a.f.balance_pic));
    this.KLt[1].KJD.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.KLt[1].lKQ = ((TextView)paramView.findViewById(a.f.balance_wording));
    this.KLt[1].KLK = ((TextView)paramView.findViewById(a.f.balance_num));
    this.KLt[1].KJD.setVisibility(4);
    this.KLt[2] = new a();
    this.KLt[2].view = paramView.findViewById(a.f.bankcard_area);
    this.KLt[2].KJD = ((CdnImageView)paramView.findViewById(a.f.bankcard_pic));
    this.KLt[2].KJD.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.KLt[2].lKQ = ((TextView)paramView.findViewById(a.f.bankcard_tv));
    this.KLt[2].KLK = ((TextView)paramView.findViewById(a.f.extra_wording_three));
    this.KLt[2].KJD.setVisibility(4);
    this.KLt[3] = new a();
    this.KLt[3].view = paramView.findViewById(a.f.lqt_area);
    this.KLt[3].KJD = ((CdnImageView)paramView.findViewById(a.f.lqt_pic));
    this.KLt[3].lKQ = ((TextView)paramView.findViewById(a.f.lqt_wording));
    this.KLt[3].KJD.setVisibility(4);
    this.KLt[3].view.setVisibility(8);
    AppMethodBeat.o(66089);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66088);
    this.Fag = af.mU(this).inflate(a.g.mall_index_stub_with_bankcard, null);
    this.KKV.addHeaderView(this.Fag);
    AppMethodBeat.o(66088);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66083);
    super.initView();
    this.KKV.setPadding(a.DWW, 0, a.DWW, 0);
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
    e.fZH();
    a.b(this, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.uiE = View.inflate(this, a.g.mall_index_foot, null);
    this.uiE.setClickable(false);
    this.uiE.setEnabled(false);
    this.KLv = ((TextView)this.uiE.findViewById(a.f.wallet_region_desc));
    this.KLu = u.iiI().asq(this.KJh);
    addSceneEndListener(1577);
    paramBundle = new com.tencent.mm.plugin.mall.a.i();
    if (this.KLu != null)
    {
      ai localai = this.KLu;
      if ((localai.VJO != null) && (localai.VJO.aaoI != null) && (localai.VJO.aaoI.size() != 0)) {
        break label158;
      }
    }
    label158:
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
    this.KLC.dead();
    this.KLD.dead();
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
      int i = com.tencent.mm.k.i.aRC().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
      long l = System.currentTimeMillis();
      Log.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
      if (l - this.lastUpdateTime >= i)
      {
        this.lastUpdateTime = System.currentTimeMillis();
        doSceneProgress(new com.tencent.mm.plugin.mall.a.i(), false);
      }
    }
    for (;;)
    {
      fZi();
      AppMethodBeat.o(66090);
      return;
      this.isFirst = false;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66097);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if (paramp.getType() == 1577)
    {
      paramp = (com.tencent.mm.plugin.mall.a.i)paramp;
      if (paramp.KJm == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!Util.isNullOrNil(paramp.fZa()))) {
        if (this.isFinished)
        {
          AppMethodBeat.o(66097);
          return true;
          paramInt1 = paramp.KJm.acbR;
        }
        else if (System.currentTimeMillis() - this.KLx > 500L)
        {
          this.KLx = System.currentTimeMillis();
          this.KLC.alive();
          this.KLD.alive();
          paramString = new Bundle();
          this.KLA = paramp.fZa();
          paramp = new Intent();
          Log.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.KLA });
          paramString.putString("KoriginUrl", this.KLA);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramp.putExtra("rawUrl", this.KLA);
          paramp.putExtra("jsapiargs", paramString);
          paramp.putExtra("geta8key_username", z.bAM());
          paramp.putExtra("pay_channel", 1);
          com.tencent.mm.wallet_core.ui.i.d(getContext(), paramp, 4);
        }
      }
      this.KLu = u.iiI().asq(this.KJh);
      fZq();
      fZl();
      fZi();
      fZm();
    }
    AppMethodBeat.o(66097);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(262464);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(MallIndexOSUI.b.class);
    AppMethodBeat.o(262464);
  }
  
  final class a
  {
    public CdnImageView KJD;
    public TextView KLK;
    public TextView lKQ;
    public View view;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */