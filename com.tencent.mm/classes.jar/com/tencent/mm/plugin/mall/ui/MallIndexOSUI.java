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
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebl;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.e.m;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private boolean gGM;
  private long lastUpdateTime;
  private View oaY;
  private boolean vFA;
  private boolean vFB;
  private String vFC;
  private int vFD;
  private c vFE;
  private c vFF;
  private a[] vFv;
  private aj vFw;
  private TextView vFx;
  private boolean vFy;
  private long vFz;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(66081);
    this.vFv = new a[4];
    this.vFw = new aj();
    this.vFx = null;
    this.lastUpdateTime = 0L;
    this.oaY = null;
    this.vFy = false;
    this.gGM = false;
    this.vFz = 0L;
    this.vFA = false;
    this.vFB = false;
    this.vFC = "";
    this.vFD = 0;
    this.vFE = new MallIndexOSUI.1(this);
    this.vFF = new MallIndexOSUI.2(this);
    AppMethodBeat.o(66081);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(66085);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    String str = paramMallFunction.usV;
    long l = bt.aRf(paramMallFunction.jDb);
    com.tencent.mm.kernel.g.ajD();
    localg.f(13720, new Object[] { str, Long.valueOf(l), (Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0)) });
    AppMethodBeat.o(66085);
  }
  
  protected final void dcd()
  {
    AppMethodBeat.i(66086);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66086);
  }
  
  protected final void dkh()
  {
    AppMethodBeat.i(66087);
    String str1 = this.vFw.DaJ;
    String str2 = this.vFw.DaK;
    setMMTitle(str1);
    if (!bt.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(66087);
  }
  
  protected final void dki() {}
  
  protected final void dkj() {}
  
  protected final boolean dkk()
  {
    AppMethodBeat.i(66093);
    ebe localebe = this.vFw.DaG;
    int i = 0;
    while (i < this.vFv.length)
    {
      this.vFv[i].view.setVisibility(8);
      this.vFv[i].vDG.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localebe.Gvi.size()) && (i < this.vFv.length))
    {
      final ebf localebf = (ebf)localebe.Gvi.get(i);
      this.vFv[i].view.setVisibility(0);
      this.vFv[i].vDG.setUrl(com.tencent.mm.platformtools.z.a(localebf.HNR));
      this.vFv[i].vDG.setVisibility(0);
      this.vFv[i].fRf.setText(com.tencent.mm.platformtools.z.a(localebf.HNQ));
      ad.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), com.tencent.mm.platformtools.z.a(localebf.HNR) });
      this.vFv[i].vFM.setVisibility(8);
      String str = com.tencent.mm.platformtools.z.a(localebf.HNT);
      if (!bt.isNullOrNil(str))
      {
        this.vFv[i].vFM.setText(str);
        this.vFv[i].vFM.setVisibility(0);
      }
      this.vFv[i].view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66078);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.report.service.g.yhR.f(13867, new Object[] { com.tencent.mm.platformtools.z.a(localebf.HNS), Integer.valueOf(MallIndexOSUI.this.vDk) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(localebf.HNS));
          paramAnonymousView.putExtra("geta8key_username", u.aAm());
          paramAnonymousView.putExtra("pay_channel", 1);
          paramAnonymousView.putExtra(e.m.IVa, true);
          com.tencent.mm.wallet_core.ui.e.an(MallIndexOSUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66078);
        }
      });
      i += 1;
    }
    if ((this.vEX != null) && (this.oaY != null) && (!this.vFy))
    {
      this.vEX.addFooterView(this.oaY);
      this.vFy = true;
    }
    if (!bt.isNullOrNil(this.vFw.DaM))
    {
      this.vFx.setText(this.vFw.DaM);
      this.vFx.setVisibility(0);
    }
    AppMethodBeat.o(66093);
    return true;
  }
  
  protected final void dkl()
  {
    AppMethodBeat.i(66094);
    ad.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
    boolean bool2 = this.vFw.DaI;
    com.tencent.mm.kernel.g.ajD();
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iuc, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      ad.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iuc, Boolean.TRUE);
        h.a(this, getString(2131761095), null, true, null);
      }
      AppMethodBeat.o(66094);
      return;
    }
  }
  
  protected final void dko() {}
  
  protected final void dkp()
  {
    AppMethodBeat.i(66084);
    com.tencent.mm.wallet_core.ui.e.a(this.vFc, "1", this.vFw.DaL, this.vFw.vqh);
    AppMethodBeat.o(66084);
  }
  
  protected final void dkq() {}
  
  protected final void dks()
  {
    AppMethodBeat.i(66095);
    removeAllOptionMenu();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66080);
        final ebl localebl = MallIndexOSUI.e(MallIndexOSUI.this).DaH;
        final boolean bool = MallIndexOSUI.e(MallIndexOSUI.this).DaI;
        if (bool)
        {
          paramAnonymousMenuItem = new String[localebl.Gvi.size() + 1];
          paramAnonymousMenuItem[localebl.Gvi.size()] = MallIndexOSUI.this.getString(2131765316);
        }
        for (;;)
        {
          int i = 0;
          while (i < localebl.Gvi.size())
          {
            paramAnonymousMenuItem[i] = com.tencent.mm.platformtools.z.a(((ebm)localebl.Gvi.get(i)).HNQ);
            i += 1;
          }
          paramAnonymousMenuItem = new String[localebl.Gvi.size()];
        }
        h.b(MallIndexOSUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
        {
          public final void lf(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66079);
            if (paramAnonymous2Int < localebl.Gvi.size())
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(((ebm)localebl.Gvi.get(paramAnonymous2Int)).HOc));
              localIntent.putExtra(e.m.IVa, true);
              com.tencent.mm.wallet_core.ui.e.an(MallIndexOSUI.this.getContext(), localIntent);
              AppMethodBeat.o(66079);
              return;
            }
            if (bool) {
              d.c(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
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
  
  protected final void dku() {}
  
  protected final void es(View paramView)
  {
    AppMethodBeat.i(66089);
    this.vFv[0] = new a();
    this.vFv[0].view = paramView.findViewById(2131302990);
    this.vFv[0].vDG = ((CdnImageView)paramView.findViewById(2131302991));
    this.vFv[0].vDG.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.vFv[0].fRf = ((TextView)paramView.findViewById(2131302996));
    this.vFv[0].vFM = ((TextView)paramView.findViewById(2131299637));
    this.vFv[0].vDG.setVisibility(4);
    this.vFv[1] = new a();
    this.vFv[1].view = paramView.findViewById(2131297089);
    this.vFv[1].vDG = ((CdnImageView)paramView.findViewById(2131297103));
    this.vFv[1].vDG.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.vFv[1].fRf = ((TextView)paramView.findViewById(2131297108));
    this.vFv[1].vFM = ((TextView)paramView.findViewById(2131297102));
    this.vFv[1].vDG.setVisibility(4);
    this.vFv[2] = new a();
    this.vFv[2].view = paramView.findViewById(2131297137);
    this.vFv[2].vDG = ((CdnImageView)paramView.findViewById(2131297171));
    this.vFv[2].vDG.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.vFv[2].fRf = ((TextView)paramView.findViewById(2131297176));
    this.vFv[2].vFM = ((TextView)paramView.findViewById(2131299638));
    this.vFv[2].vDG.setVisibility(4);
    this.vFv[3] = new a();
    this.vFv[3].view = paramView.findViewById(2131301637);
    this.vFv[3].vDG = ((CdnImageView)paramView.findViewById(2131301691));
    this.vFv[3].fRf = ((TextView)paramView.findViewById(2131301709));
    this.vFv[3].vDG.setVisibility(4);
    this.vFv[3].view.setVisibility(8);
    AppMethodBeat.o(66089);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66096);
    this.gGM = true;
    super.finish();
    AppMethodBeat.o(66096);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66088);
    this.rXv = com.tencent.mm.ui.z.jO(this).inflate(2131494699, null);
    this.vEX.addHeaderView(this.rXv);
    LinearLayout localLinearLayout = (LinearLayout)this.rXv.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.dkc();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66088);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66083);
    super.initView();
    this.vEX.setPadding(a.vDH, 0, a.vDH, 0);
    AppMethodBeat.o(66083);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66098);
    ad.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(66098);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66082);
    e.dkG();
    a.c(this, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.oaY = View.inflate(this, 2131494692, null);
    this.oaY.setClickable(false);
    this.oaY.setEnabled(false);
    this.vFx = ((TextView)this.oaY.findViewById(2131306829));
    this.vFw = t.eFE().VD(this.vDk);
    addSceneEndListener(1577);
    ad.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new i();
    if (this.vFw != null)
    {
      aj localaj = this.vFw;
      if ((localaj.DaG != null) && (localaj.DaG.Gvi != null) && (localaj.DaG.Gvi.size() != 0)) {
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
    this.vFE.dead();
    this.vFF.dead();
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
    int i = com.tencent.mm.n.g.acA().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
    if (l - this.lastUpdateTime >= i)
    {
      this.lastUpdateTime = System.currentTimeMillis();
      doSceneProgress(new i(), false);
    }
    dkh();
    AppMethodBeat.o(66090);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66097);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if (paramn.getType() == 1577)
    {
      paramn = (i)paramn;
      if (paramn.vDp == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!bt.isNullOrNil(paramn.djZ()))) {
        if (this.gGM)
        {
          AppMethodBeat.o(66097);
          return true;
          paramInt1 = paramn.vDp.HNW;
        }
        else if (System.currentTimeMillis() - this.vFz > 500L)
        {
          this.vFz = System.currentTimeMillis();
          this.vFE.alive();
          this.vFF.alive();
          paramString = new Bundle();
          this.vFC = paramn.djZ();
          paramn = new Intent();
          ad.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.vFC });
          paramString.putString("KoriginUrl", this.vFC);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramn.putExtra("rawUrl", this.vFC);
          paramn.putExtra("jsapiargs", paramString);
          paramn.putExtra("geta8key_username", u.aAm());
          paramn.putExtra("pay_channel", 1);
          com.tencent.mm.wallet_core.ui.e.b(getContext(), paramn, 4);
        }
      }
      this.vFw = t.eFE().VD(this.vDk);
      dkp();
      dkk();
      dkh();
      dkl();
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
    public TextView fRf;
    public CdnImageView vDG;
    public TextView vFM;
    public View view;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */