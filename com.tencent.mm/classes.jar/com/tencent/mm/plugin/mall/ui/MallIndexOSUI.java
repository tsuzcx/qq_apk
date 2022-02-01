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
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.y;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private boolean goa;
  private long lastUpdateTime;
  private View mXu;
  private a[] tuk;
  private ai tul;
  private TextView tum;
  private boolean tun;
  private long tuo;
  private boolean tup;
  private boolean tuq;
  private String tur;
  private int tus;
  private com.tencent.mm.sdk.b.c tut;
  private com.tencent.mm.sdk.b.c tuu;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(66081);
    this.tuk = new a[4];
    this.tul = new ai();
    this.tum = null;
    this.lastUpdateTime = 0L;
    this.mXu = null;
    this.tun = false;
    this.goa = false;
    this.tuo = 0L;
    this.tup = false;
    this.tuq = false;
    this.tur = "";
    this.tus = 0;
    this.tut = new MallIndexOSUI.1(this);
    this.tuu = new MallIndexOSUI.2(this);
    AppMethodBeat.o(66081);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(66085);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.h.vKh.f(13720, new Object[] { paramMallFunction.smD, Long.valueOf(bt.aGi(paramMallFunction.uWF)) });
    AppMethodBeat.o(66085);
  }
  
  protected final void cFM()
  {
    AppMethodBeat.i(66086);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66086);
  }
  
  protected final void cNl()
  {
    AppMethodBeat.i(66087);
    String str1 = this.tul.AhX;
    String str2 = this.tul.AhY;
    setMMTitle(str1);
    if (!bt.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(66087);
  }
  
  protected final void cNm() {}
  
  protected final void cNn() {}
  
  protected final boolean cNo()
  {
    AppMethodBeat.i(66093);
    dpq localdpq = this.tul.AhU;
    int i = 0;
    while (i < this.tuk.length)
    {
      this.tuk[i].view.setVisibility(8);
      this.tuk[i].tsI.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localdpq.Drc.size()) && (i < this.tuk.length))
    {
      final dpr localdpr = (dpr)localdpq.Drc.get(i);
      this.tuk[i].view.setVisibility(0);
      this.tuk[i].tsI.setUrl(z.a(localdpr.EFB));
      this.tuk[i].tsI.setVisibility(0);
      this.tuk[i].ful.setText(z.a(localdpr.EFA));
      ad.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), z.a(localdpr.EFB) });
      this.tuk[i].tuB.setVisibility(8);
      String str = z.a(localdpr.EFD);
      if (!bt.isNullOrNil(str))
      {
        this.tuk[i].tuB.setText(str);
        this.tuk[i].tuB.setVisibility(0);
      }
      this.tuk[i].view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66078);
          com.tencent.mm.plugin.report.service.h.vKh.f(13867, new Object[] { z.a(localdpr.EFC), Integer.valueOf(MallIndexOSUI.this.tso) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", z.a(localdpr.EFC));
          paramAnonymousView.putExtra("geta8key_username", u.aqG());
          paramAnonymousView.putExtra("pay_channel", 1);
          paramAnonymousView.putExtra(e.m.FIC, true);
          com.tencent.mm.wallet_core.ui.e.X(MallIndexOSUI.this.getContext(), paramAnonymousView);
          AppMethodBeat.o(66078);
        }
      });
      i += 1;
    }
    if ((this.ttR != null) && (this.mXu != null) && (!this.tun))
    {
      this.ttR.addFooterView(this.mXu);
      this.tun = true;
    }
    if (!bt.isNullOrNil(this.tul.Aia))
    {
      this.tum.setText(this.tul.Aia);
      this.tum.setVisibility(0);
    }
    AppMethodBeat.o(66093);
    return true;
  }
  
  protected final void cNp()
  {
    AppMethodBeat.i(66094);
    ad.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
    boolean bool2 = this.tul.AhW;
    com.tencent.mm.kernel.g.afC();
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FjV, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      ad.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FjV, Boolean.TRUE);
        com.tencent.mm.ui.base.h.a(this, getString(2131761095), null, true, null);
      }
      AppMethodBeat.o(66094);
      return;
    }
  }
  
  protected final void cNs() {}
  
  protected final void cNt()
  {
    AppMethodBeat.i(66084);
    com.tencent.mm.wallet_core.ui.e.a(this.ttW, "1", this.tul.AhZ, this.tul.tfm);
    AppMethodBeat.o(66084);
  }
  
  protected final void cNu() {}
  
  protected final void cNw()
  {
    AppMethodBeat.i(66095);
    removeAllOptionMenu();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66080);
        final dpv localdpv = MallIndexOSUI.e(MallIndexOSUI.this).AhV;
        final boolean bool = MallIndexOSUI.e(MallIndexOSUI.this).AhW;
        if (bool)
        {
          paramAnonymousMenuItem = new String[localdpv.Drc.size() + 1];
          paramAnonymousMenuItem[localdpv.Drc.size()] = MallIndexOSUI.this.getString(2131765316);
        }
        for (;;)
        {
          int i = 0;
          while (i < localdpv.Drc.size())
          {
            paramAnonymousMenuItem[i] = z.a(((dpw)localdpv.Drc.get(i)).EFA);
            i += 1;
          }
          paramAnonymousMenuItem = new String[localdpv.Drc.size()];
        }
        com.tencent.mm.ui.base.h.b(MallIndexOSUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
        {
          public final void kM(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66079);
            if (paramAnonymous2Int < localdpv.Drc.size())
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", z.a(((dpw)localdpv.Drc.get(paramAnonymous2Int)).EFK));
              localIntent.putExtra(e.m.FIC, true);
              com.tencent.mm.wallet_core.ui.e.X(MallIndexOSUI.this.getContext(), localIntent);
              AppMethodBeat.o(66079);
              return;
            }
            if (bool) {
              d.b(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
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
  
  protected final void cNy() {}
  
  protected final void eb(View paramView)
  {
    AppMethodBeat.i(66089);
    this.tuk[0] = new a();
    this.tuk[0].view = paramView.findViewById(2131302990);
    this.tuk[0].tsI = ((CdnImageView)paramView.findViewById(2131302991));
    this.tuk[0].tsI.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.tuk[0].ful = ((TextView)paramView.findViewById(2131302996));
    this.tuk[0].tuB = ((TextView)paramView.findViewById(2131299637));
    this.tuk[0].tsI.setVisibility(4);
    this.tuk[1] = new a();
    this.tuk[1].view = paramView.findViewById(2131297089);
    this.tuk[1].tsI = ((CdnImageView)paramView.findViewById(2131297103));
    this.tuk[1].tsI.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.tuk[1].ful = ((TextView)paramView.findViewById(2131297108));
    this.tuk[1].tuB = ((TextView)paramView.findViewById(2131297102));
    this.tuk[1].tsI.setVisibility(4);
    this.tuk[2] = new a();
    this.tuk[2].view = paramView.findViewById(2131297137);
    this.tuk[2].tsI = ((CdnImageView)paramView.findViewById(2131297171));
    this.tuk[2].tsI.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.tuk[2].ful = ((TextView)paramView.findViewById(2131297176));
    this.tuk[2].tuB = ((TextView)paramView.findViewById(2131299638));
    this.tuk[2].tsI.setVisibility(4);
    this.tuk[3] = new a();
    this.tuk[3].view = paramView.findViewById(2131301637);
    this.tuk[3].tsI = ((CdnImageView)paramView.findViewById(2131301691));
    this.tuk[3].ful = ((TextView)paramView.findViewById(2131301709));
    this.tuk[3].tsI.setVisibility(4);
    this.tuk[3].view.setVisibility(8);
    AppMethodBeat.o(66089);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66096);
    this.goa = true;
    super.finish();
    AppMethodBeat.o(66096);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66088);
    this.qwn = y.js(this).inflate(2131494699, null);
    this.ttR.addHeaderView(this.qwn);
    LinearLayout localLinearLayout = (LinearLayout)this.qwn.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.cNi();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66088);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66083);
    super.initView();
    this.ttR.setPadding(a.tsJ, 0, a.tsJ, 0);
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
    c.cNF();
    a.b(this, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.mXu = View.inflate(this, 2131494692, null);
    this.mXu.setClickable(false);
    this.mXu.setEnabled(false);
    this.tum = ((TextView)this.mXu.findViewById(2131306829));
    this.tul = s.eci().RC(this.tso);
    addSceneEndListener(1577);
    ad.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new com.tencent.mm.plugin.mall.a.h();
    if (this.tul != null)
    {
      ai localai = this.tul;
      if ((localai.AhU != null) && (localai.AhU.Drc != null) && (localai.AhU.Drc.size() != 0)) {
        break label166;
      }
    }
    label166:
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
    this.tut.dead();
    this.tuu.dead();
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
    int i = com.tencent.mm.m.g.Zd().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
    long l = System.currentTimeMillis();
    ad.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
    if (l - this.lastUpdateTime >= i)
    {
      this.lastUpdateTime = System.currentTimeMillis();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.h(), false);
    }
    cNl();
    AppMethodBeat.o(66090);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66097);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if (paramn.getType() == 1577)
    {
      paramn = (com.tencent.mm.plugin.mall.a.h)paramn;
      if (paramn.tsr == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!bt.isNullOrNil(paramn.cNf()))) {
        if (this.goa)
        {
          AppMethodBeat.o(66097);
          return true;
          paramInt1 = paramn.tsr.EFE;
        }
        else if (System.currentTimeMillis() - this.tuo > 500L)
        {
          this.tuo = System.currentTimeMillis();
          this.tut.alive();
          this.tuu.alive();
          paramString = new Bundle();
          this.tur = paramn.cNf();
          paramn = new Intent();
          ad.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.tur });
          paramString.putString("KoriginUrl", this.tur);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramn.putExtra("rawUrl", this.tur);
          paramn.putExtra("jsapiargs", paramString);
          paramn.putExtra("geta8key_username", u.aqG());
          paramn.putExtra("pay_channel", 1);
          com.tencent.mm.wallet_core.ui.e.b(getContext(), paramn, 4);
        }
      }
      this.tul = s.eci().RC(this.tso);
      cNt();
      cNo();
      cNl();
      cNp();
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
    public TextView ful;
    public CdnImageView tsI;
    public TextView tuB;
    public View view;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */