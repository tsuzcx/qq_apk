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
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.e.m;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private boolean gnd;
  private long lastUpdateTime;
  private View nzT;
  private a[] uCD;
  private ai uCE;
  private TextView uCF;
  private boolean uCG;
  private long uCH;
  private boolean uCI;
  private boolean uCJ;
  private String uCK;
  private int uCL;
  private com.tencent.mm.sdk.b.c uCM;
  private com.tencent.mm.sdk.b.c uCN;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(66081);
    this.uCD = new a[4];
    this.uCE = new ai();
    this.uCF = null;
    this.lastUpdateTime = 0L;
    this.nzT = null;
    this.uCG = false;
    this.gnd = false;
    this.uCH = 0L;
    this.uCI = false;
    this.uCJ = false;
    this.uCK = "";
    this.uCL = 0;
    this.uCM = new MallIndexOSUI.1(this);
    this.uCN = new MallIndexOSUI.2(this);
    AppMethodBeat.o(66081);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(66085);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.h.wUl.f(13720, new Object[] { paramMallFunction.tuw, Long.valueOf(bs.aLz(paramMallFunction.wfu)) });
    AppMethodBeat.o(66085);
  }
  
  protected final void cSW()
  {
    AppMethodBeat.i(66086);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66086);
  }
  
  protected final void daS()
  {
    AppMethodBeat.i(66087);
    String str1 = this.uCE.BAr;
    String str2 = this.uCE.BAs;
    setMMTitle(str1);
    if (!bs.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(66087);
  }
  
  protected final void daT() {}
  
  protected final void daU() {}
  
  protected final boolean daV()
  {
    AppMethodBeat.i(66093);
    dvh localdvh = this.uCE.BAo;
    int i = 0;
    while (i < this.uCD.length)
    {
      this.uCD[i].view.setVisibility(8);
      this.uCD[i].uBb.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localdvh.EMe.size()) && (i < this.uCD.length))
    {
      final dvi localdvi = (dvi)localdvh.EMe.get(i);
      this.uCD[i].view.setVisibility(0);
      this.uCD[i].uBb.setUrl(com.tencent.mm.platformtools.z.a(localdvi.GcN));
      this.uCD[i].uBb.setVisibility(0);
      this.uCD[i].fxS.setText(com.tencent.mm.platformtools.z.a(localdvi.GcM));
      ac.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), com.tencent.mm.platformtools.z.a(localdvi.GcN) });
      this.uCD[i].uCU.setVisibility(8);
      String str = com.tencent.mm.platformtools.z.a(localdvi.GcP);
      if (!bs.isNullOrNil(str))
      {
        this.uCD[i].uCU.setText(str);
        this.uCD[i].uCU.setVisibility(0);
      }
      this.uCD[i].view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66078);
          com.tencent.mm.plugin.report.service.h.wUl.f(13867, new Object[] { com.tencent.mm.platformtools.z.a(localdvi.GcO), Integer.valueOf(MallIndexOSUI.this.uAH) });
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(localdvi.GcO));
          paramAnonymousView.putExtra("geta8key_username", u.axw());
          paramAnonymousView.putExtra("pay_channel", 1);
          paramAnonymousView.putExtra(e.m.HhK, true);
          com.tencent.mm.wallet_core.ui.e.al(MallIndexOSUI.this.getContext(), paramAnonymousView);
          AppMethodBeat.o(66078);
        }
      });
      i += 1;
    }
    if ((this.uCk != null) && (this.nzT != null) && (!this.uCG))
    {
      this.uCk.addFooterView(this.nzT);
      this.uCG = true;
    }
    if (!bs.isNullOrNil(this.uCE.BAu))
    {
      this.uCF.setText(this.uCE.BAu);
      this.uCF.setVisibility(0);
    }
    AppMethodBeat.o(66093);
    return true;
  }
  
  protected final void daW()
  {
    AppMethodBeat.i(66094);
    ac.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
    boolean bool2 = this.uCE.BAq;
    com.tencent.mm.kernel.g.agS();
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHK, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      ac.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHK, Boolean.TRUE);
        com.tencent.mm.ui.base.h.a(this, getString(2131761095), null, true, null);
      }
      AppMethodBeat.o(66094);
      return;
    }
  }
  
  protected final void daZ() {}
  
  protected final void dba()
  {
    AppMethodBeat.i(66084);
    com.tencent.mm.wallet_core.ui.e.a(this.uCp, "1", this.uCE.BAt, this.uCE.unB);
    AppMethodBeat.o(66084);
  }
  
  protected final void dbb() {}
  
  protected final void dbd()
  {
    AppMethodBeat.i(66095);
    removeAllOptionMenu();
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66080);
        final dvm localdvm = MallIndexOSUI.e(MallIndexOSUI.this).BAp;
        final boolean bool = MallIndexOSUI.e(MallIndexOSUI.this).BAq;
        if (bool)
        {
          paramAnonymousMenuItem = new String[localdvm.EMe.size() + 1];
          paramAnonymousMenuItem[localdvm.EMe.size()] = MallIndexOSUI.this.getString(2131765316);
        }
        for (;;)
        {
          int i = 0;
          while (i < localdvm.EMe.size())
          {
            paramAnonymousMenuItem[i] = com.tencent.mm.platformtools.z.a(((dvn)localdvm.EMe.get(i)).GcM);
            i += 1;
          }
          paramAnonymousMenuItem = new String[localdvm.EMe.size()];
        }
        com.tencent.mm.ui.base.h.b(MallIndexOSUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.c()
        {
          public final void kG(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66079);
            if (paramAnonymous2Int < localdvm.EMe.size())
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(((dvn)localdvm.EMe.get(paramAnonymous2Int)).GcW));
              localIntent.putExtra(e.m.HhK, true);
              com.tencent.mm.wallet_core.ui.e.al(MallIndexOSUI.this.getContext(), localIntent);
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
  
  protected final void dbf() {}
  
  protected final void ek(View paramView)
  {
    AppMethodBeat.i(66089);
    this.uCD[0] = new a();
    this.uCD[0].view = paramView.findViewById(2131302990);
    this.uCD[0].uBb = ((CdnImageView)paramView.findViewById(2131302991));
    this.uCD[0].uBb.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.uCD[0].fxS = ((TextView)paramView.findViewById(2131302996));
    this.uCD[0].uCU = ((TextView)paramView.findViewById(2131299637));
    this.uCD[0].uBb.setVisibility(4);
    this.uCD[1] = new a();
    this.uCD[1].view = paramView.findViewById(2131297089);
    this.uCD[1].uBb = ((CdnImageView)paramView.findViewById(2131297103));
    this.uCD[1].uBb.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.uCD[1].fxS = ((TextView)paramView.findViewById(2131297108));
    this.uCD[1].uCU = ((TextView)paramView.findViewById(2131297102));
    this.uCD[1].uBb.setVisibility(4);
    this.uCD[2] = new a();
    this.uCD[2].view = paramView.findViewById(2131297137);
    this.uCD[2].uBb = ((CdnImageView)paramView.findViewById(2131297171));
    this.uCD[2].uBb.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.uCD[2].fxS = ((TextView)paramView.findViewById(2131297176));
    this.uCD[2].uCU = ((TextView)paramView.findViewById(2131299638));
    this.uCD[2].uBb.setVisibility(4);
    this.uCD[3] = new a();
    this.uCD[3].view = paramView.findViewById(2131301637);
    this.uCD[3].uBb = ((CdnImageView)paramView.findViewById(2131301691));
    this.uCD[3].fxS = ((TextView)paramView.findViewById(2131301709));
    this.uCD[3].uBb.setVisibility(4);
    this.uCD[3].view.setVisibility(8);
    AppMethodBeat.o(66089);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66096);
    this.gnd = true;
    super.finish();
    AppMethodBeat.o(66096);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66088);
    this.rjd = com.tencent.mm.ui.z.jD(this).inflate(2131494699, null);
    this.uCk.addHeaderView(this.rjd);
    LinearLayout localLinearLayout = (LinearLayout)this.rjd.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.daP();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66088);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66083);
    super.initView();
    this.uCk.setPadding(a.uBc, 0, a.uBc, 0);
    AppMethodBeat.o(66083);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66098);
    ac.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(66098);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66082);
    c.dbm();
    a.c(this, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.nzT = View.inflate(this, 2131494692, null);
    this.nzT.setClickable(false);
    this.nzT.setEnabled(false);
    this.uCF = ((TextView)this.nzT.findViewById(2131306829));
    this.uCE = s.erE().TL(this.uAH);
    addSceneEndListener(1577);
    ac.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new com.tencent.mm.plugin.mall.a.h();
    if (this.uCE != null)
    {
      ai localai = this.uCE;
      if ((localai.BAo != null) && (localai.BAo.EMe != null) && (localai.BAo.EMe.size() != 0)) {
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
    this.uCM.dead();
    this.uCN.dead();
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
    int i = com.tencent.mm.m.g.ZY().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
    long l = System.currentTimeMillis();
    ac.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
    if (l - this.lastUpdateTime >= i)
    {
      this.lastUpdateTime = System.currentTimeMillis();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.h(), false);
    }
    daS();
    AppMethodBeat.o(66090);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66097);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if (paramn.getType() == 1577)
    {
      paramn = (com.tencent.mm.plugin.mall.a.h)paramn;
      if (paramn.uAK == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!bs.isNullOrNil(paramn.daM()))) {
        if (this.gnd)
        {
          AppMethodBeat.o(66097);
          return true;
          paramInt1 = paramn.uAK.GcQ;
        }
        else if (System.currentTimeMillis() - this.uCH > 500L)
        {
          this.uCH = System.currentTimeMillis();
          this.uCM.alive();
          this.uCN.alive();
          paramString = new Bundle();
          this.uCK = paramn.daM();
          paramn = new Intent();
          ac.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.uCK });
          paramString.putString("KoriginUrl", this.uCK);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramn.putExtra("rawUrl", this.uCK);
          paramn.putExtra("jsapiargs", paramString);
          paramn.putExtra("geta8key_username", u.axw());
          paramn.putExtra("pay_channel", 1);
          com.tencent.mm.wallet_core.ui.e.b(getContext(), paramn, 4);
        }
      }
      this.uCE = s.erE().TL(this.uAH);
      dba();
      daV();
      daS();
      daW();
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
    public TextView fxS;
    public CdnImageView uBb;
    public TextView uCU;
    public View view;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */