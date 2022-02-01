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
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ecv;
import com.tencent.mm.protocal.protobuf.ecw;
import com.tencent.mm.protocal.protobuf.ecz;
import com.tencent.mm.protocal.protobuf.edc;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private boolean gJv;
  private long lastUpdateTime;
  private View ogP;
  private com.tencent.mm.plugin.wallet_core.model.aj vRA;
  private TextView vRB;
  private boolean vRC;
  private long vRD;
  private boolean vRE;
  private boolean vRF;
  private String vRG;
  private int vRH;
  private c vRI;
  private c vRJ;
  private a[] vRz;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(66081);
    this.vRz = new a[4];
    this.vRA = new com.tencent.mm.plugin.wallet_core.model.aj();
    this.vRB = null;
    this.lastUpdateTime = 0L;
    this.ogP = null;
    this.vRC = false;
    this.gJv = false;
    this.vRD = 0L;
    this.vRE = false;
    this.vRF = false;
    this.vRG = "";
    this.vRH = 0;
    this.vRI = new MallIndexOSUI.1(this);
    this.vRJ = new MallIndexOSUI.2(this);
    AppMethodBeat.o(66081);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(66085);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    String str = paramMallFunction.uEo;
    long l = bu.aSC(paramMallFunction.jFZ);
    com.tencent.mm.kernel.g.ajS();
    localg.f(13720, new Object[] { str, Long.valueOf(l), (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0)) });
    AppMethodBeat.o(66085);
  }
  
  protected final void deV()
  {
    AppMethodBeat.i(66086);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66086);
  }
  
  protected final void dng()
  {
    AppMethodBeat.i(66087);
    String str1 = this.vRA.Dsn;
    String str2 = this.vRA.Dso;
    setMMTitle(str1);
    if (!bu.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(66087);
  }
  
  protected final void dnh() {}
  
  protected final void dni() {}
  
  protected final boolean dnj()
  {
    AppMethodBeat.i(66093);
    ecv localecv = this.vRA.Dsk;
    int i = 0;
    while (i < this.vRz.length)
    {
      this.vRz[i].view.setVisibility(8);
      this.vRz[i].vPK.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localecv.GOH.size()) && (i < this.vRz.length))
    {
      final ecw localecw = (ecw)localecv.GOH.get(i);
      this.vRz[i].view.setVisibility(0);
      this.vRz[i].vPK.setUrl(com.tencent.mm.platformtools.z.a(localecw.IhY));
      this.vRz[i].vPK.setVisibility(0);
      this.vRz[i].fTl.setText(com.tencent.mm.platformtools.z.a(localecw.IhX));
      ae.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), com.tencent.mm.platformtools.z.a(localecw.IhY) });
      this.vRz[i].vRQ.setVisibility(8);
      String str = com.tencent.mm.platformtools.z.a(localecw.Iia);
      if (!bu.isNullOrNil(str))
      {
        this.vRz[i].vRQ.setText(str);
        this.vRz[i].vRQ.setVisibility(0);
      }
      this.vRz[i].view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66078);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.report.service.g.yxI.f(13867, new Object[] { com.tencent.mm.platformtools.z.a(localecw.IhZ), Integer.valueOf(MallIndexOSUI.this.vPo) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(localecw.IhZ));
          paramAnonymousView.putExtra("geta8key_username", v.aAC());
          paramAnonymousView.putExtra("pay_channel", 1);
          paramAnonymousView.putExtra(e.m.JpI, true);
          f.an(MallIndexOSUI.this.getContext(), paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66078);
        }
      });
      i += 1;
    }
    if ((this.vRb != null) && (this.ogP != null) && (!this.vRC))
    {
      this.vRb.addFooterView(this.ogP);
      this.vRC = true;
    }
    if (!bu.isNullOrNil(this.vRA.Dsq))
    {
      this.vRB.setText(this.vRA.Dsq);
      this.vRB.setVisibility(0);
    }
    AppMethodBeat.o(66093);
    return true;
  }
  
  protected final void dnk()
  {
    AppMethodBeat.i(66094);
    ae.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
    boolean bool2 = this.vRA.Dsm;
    com.tencent.mm.kernel.g.ajS();
    Object localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IOz, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      ae.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IOz, Boolean.TRUE);
        h.a(this, getString(2131761095), null, true, null);
      }
      AppMethodBeat.o(66094);
      return;
    }
  }
  
  protected final void dnn() {}
  
  protected final void dno()
  {
    AppMethodBeat.i(66084);
    f.a(this.vRg, "1", this.vRA.Dsp, this.vRA.vCm);
    AppMethodBeat.o(66084);
  }
  
  protected final void dnp() {}
  
  protected final void dnr()
  {
    AppMethodBeat.i(66095);
    removeAllOptionMenu();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66080);
        final edc localedc = MallIndexOSUI.e(MallIndexOSUI.this).Dsl;
        final boolean bool = MallIndexOSUI.e(MallIndexOSUI.this).Dsm;
        if (bool)
        {
          paramAnonymousMenuItem = new String[localedc.GOH.size() + 1];
          paramAnonymousMenuItem[localedc.GOH.size()] = MallIndexOSUI.this.getString(2131765316);
        }
        for (;;)
        {
          int i = 0;
          while (i < localedc.GOH.size())
          {
            paramAnonymousMenuItem[i] = com.tencent.mm.platformtools.z.a(((edd)localedc.GOH.get(i)).IhX);
            i += 1;
          }
          paramAnonymousMenuItem = new String[localedc.GOH.size()];
        }
        h.b(MallIndexOSUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
        {
          public final void lh(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66079);
            if (paramAnonymous2Int < localedc.GOH.size())
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(((edd)localedc.GOH.get(paramAnonymous2Int)).Iij));
              localIntent.putExtra(e.m.JpI, true);
              f.an(MallIndexOSUI.this.getContext(), localIntent);
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
  
  protected final void dnt() {}
  
  protected final void es(View paramView)
  {
    AppMethodBeat.i(66089);
    this.vRz[0] = new a();
    this.vRz[0].view = paramView.findViewById(2131302990);
    this.vRz[0].vPK = ((CdnImageView)paramView.findViewById(2131302991));
    this.vRz[0].vPK.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.vRz[0].fTl = ((TextView)paramView.findViewById(2131302996));
    this.vRz[0].vRQ = ((TextView)paramView.findViewById(2131299637));
    this.vRz[0].vPK.setVisibility(4);
    this.vRz[1] = new a();
    this.vRz[1].view = paramView.findViewById(2131297089);
    this.vRz[1].vPK = ((CdnImageView)paramView.findViewById(2131297103));
    this.vRz[1].vPK.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.vRz[1].fTl = ((TextView)paramView.findViewById(2131297108));
    this.vRz[1].vRQ = ((TextView)paramView.findViewById(2131297102));
    this.vRz[1].vPK.setVisibility(4);
    this.vRz[2] = new a();
    this.vRz[2].view = paramView.findViewById(2131297137);
    this.vRz[2].vPK = ((CdnImageView)paramView.findViewById(2131297171));
    this.vRz[2].vPK.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.vRz[2].fTl = ((TextView)paramView.findViewById(2131297176));
    this.vRz[2].vRQ = ((TextView)paramView.findViewById(2131299638));
    this.vRz[2].vPK.setVisibility(4);
    this.vRz[3] = new a();
    this.vRz[3].view = paramView.findViewById(2131301637);
    this.vRz[3].vPK = ((CdnImageView)paramView.findViewById(2131301691));
    this.vRz[3].fTl = ((TextView)paramView.findViewById(2131301709));
    this.vRz[3].vPK.setVisibility(4);
    this.vRz[3].view.setVisibility(8);
    AppMethodBeat.o(66089);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66096);
    this.gJv = true;
    super.finish();
    AppMethodBeat.o(66096);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66088);
    this.sgg = com.tencent.mm.ui.z.jV(this).inflate(2131494699, null);
    this.vRb.addHeaderView(this.sgg);
    LinearLayout localLinearLayout = (LinearLayout)this.sgg.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.dnb();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66088);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66083);
    super.initView();
    this.vRb.setPadding(a.vPL, 0, a.vPL, 0);
    AppMethodBeat.o(66083);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66098);
    ae.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(66098);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66082);
    e.dnG();
    a.c(this, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.ogP = View.inflate(this, 2131494692, null);
    this.ogP.setClickable(false);
    this.ogP.setEnabled(false);
    this.vRB = ((TextView)this.ogP.findViewById(2131306829));
    this.vRA = t.eJl().Wk(this.vPo);
    addSceneEndListener(1577);
    ae.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new i();
    if (this.vRA != null)
    {
      com.tencent.mm.plugin.wallet_core.model.aj localaj = this.vRA;
      if ((localaj.Dsk != null) && (localaj.Dsk.GOH != null) && (localaj.Dsk.GOH.size() != 0)) {
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
    this.vRI.dead();
    this.vRJ.dead();
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
    int i = com.tencent.mm.n.g.acL().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
    long l = System.currentTimeMillis();
    ae.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
    if (l - this.lastUpdateTime >= i)
    {
      this.lastUpdateTime = System.currentTimeMillis();
      doSceneProgress(new i(), false);
    }
    dng();
    AppMethodBeat.o(66090);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66097);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if (paramn.getType() == 1577)
    {
      paramn = (i)paramn;
      if (paramn.vPt == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!bu.isNullOrNil(paramn.dmY()))) {
        if (this.gJv)
        {
          AppMethodBeat.o(66097);
          return true;
          paramInt1 = paramn.vPt.Iid;
        }
        else if (System.currentTimeMillis() - this.vRD > 500L)
        {
          this.vRD = System.currentTimeMillis();
          this.vRI.alive();
          this.vRJ.alive();
          paramString = new Bundle();
          this.vRG = paramn.dmY();
          paramn = new Intent();
          ae.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.vRG });
          paramString.putString("KoriginUrl", this.vRG);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramn.putExtra("rawUrl", this.vRG);
          paramn.putExtra("jsapiargs", paramString);
          paramn.putExtra("geta8key_username", v.aAC());
          paramn.putExtra("pay_channel", 1);
          f.b(getContext(), paramn, 4);
        }
      }
      this.vRA = t.eJl().Wk(this.vPo);
      dno();
      dnj();
      dng();
      dnk();
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
    public TextView fTl;
    public CdnImageView vPK;
    public TextView vRQ;
    public View view;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */