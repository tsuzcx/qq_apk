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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.protocal.protobuf.exe;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.protocal.protobuf.exk;
import com.tencent.mm.protocal.protobuf.exl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.e.p;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private boolean isFinished;
  private boolean isFirst;
  private long lastUpdateTime;
  private View psf;
  private a[] zlF;
  private aj zlG;
  private TextView zlH;
  private boolean zlI;
  private long zlJ;
  private boolean zlK;
  private boolean zlL;
  private String zlM;
  private int zlN;
  private IListener zlO;
  private IListener zlP;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(66081);
    this.zlF = new a[4];
    this.zlG = new aj();
    this.zlH = null;
    this.lastUpdateTime = 0L;
    this.psf = null;
    this.zlI = false;
    this.isFinished = false;
    this.zlJ = 0L;
    this.zlK = false;
    this.zlL = false;
    this.zlM = "";
    this.zlN = 0;
    this.isFirst = true;
    this.zlO = new MallIndexOSUI.1(this);
    this.zlP = new MallIndexOSUI.2(this);
    AppMethodBeat.o(66081);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(66085);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    String str = paramMallFunction.h5Url;
    long l = Util.safeParseLong(paramMallFunction.kHR);
    g.aAi();
    localh.a(13720, new Object[] { str, Long.valueOf(l), (Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0)) });
    AppMethodBeat.o(66085);
  }
  
  protected final void dYP()
  {
    AppMethodBeat.i(66086);
    int i = getResources().getColor(2131100773);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131307165).setBackgroundColor(i);
    AppMethodBeat.o(66086);
  }
  
  protected final void egS()
  {
    AppMethodBeat.i(66087);
    String str1 = this.zlG.Ibz;
    String str2 = this.zlG.IbA;
    setMMTitle(str1);
    if (!Util.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(66087);
  }
  
  protected final void egT() {}
  
  protected final void egU() {}
  
  protected final boolean egV()
  {
    AppMethodBeat.i(66093);
    exd localexd = this.zlG.Ibw;
    int i = 0;
    while (i < this.zlF.length)
    {
      this.zlF[i].view.setVisibility(8);
      this.zlF[i].zjO.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localexd.LSL.size()) && (i < this.zlF.length))
    {
      exe localexe = (exe)localexd.LSL.get(i);
      this.zlF[i].view.setVisibility(0);
      this.zlF[i].zjO.setUrl(com.tencent.mm.platformtools.z.a(localexe.NuC));
      this.zlF[i].zjO.setVisibility(0);
      this.zlF[i].gyt.setText(com.tencent.mm.platformtools.z.a(localexe.NuB));
      Log.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), com.tencent.mm.platformtools.z.a(localexe.NuC) });
      this.zlF[i].zlW.setVisibility(8);
      String str = com.tencent.mm.platformtools.z.a(localexe.NuE);
      if (!Util.isNullOrNil(str))
      {
        this.zlF[i].zlW.setText(str);
        this.zlF[i].zlW.setVisibility(0);
      }
      this.zlF[i].view.setOnClickListener(new MallIndexOSUI.3(this, localexe));
      i += 1;
    }
    if ((this.zlh != null) && (this.psf != null) && (!this.zlI))
    {
      this.zlh.addFooterView(this.psf);
      this.zlI = true;
    }
    if (!Util.isNullOrNil(this.zlG.IbC))
    {
      this.zlH.setText(this.zlG.IbC);
      this.zlH.setVisibility(0);
    }
    AppMethodBeat.o(66093);
    return true;
  }
  
  protected final void egW()
  {
    AppMethodBeat.i(66094);
    Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip call");
    boolean bool2 = this.zlG.Iby;
    g.aAi();
    Object localObject = g.aAh().azQ().get(ar.a.NWB, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      Log.i("MicroMsg.MallIndexOSUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        g.aAi();
        g.aAh().azQ().set(ar.a.NWB, Boolean.TRUE);
        com.tencent.mm.ui.base.h.a(this, getString(2131762882), null, true, null);
      }
      AppMethodBeat.o(66094);
      return;
    }
  }
  
  protected final void egZ() {}
  
  protected final void eha()
  {
    AppMethodBeat.i(66084);
    com.tencent.mm.wallet_core.ui.f.a(this.zlm, "1", this.zlG.IbB, this.zlG.yXn);
    AppMethodBeat.o(66084);
  }
  
  protected final void ehb() {}
  
  protected final void ehd()
  {
    AppMethodBeat.i(66095);
    removeAllOptionMenu();
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66080);
        final exk localexk = MallIndexOSUI.e(MallIndexOSUI.this).Ibx;
        final boolean bool = MallIndexOSUI.e(MallIndexOSUI.this).Iby;
        if (bool)
        {
          paramAnonymousMenuItem = new String[localexk.LSL.size() + 1];
          paramAnonymousMenuItem[localexk.LSL.size()] = MallIndexOSUI.this.getString(2131767759);
        }
        for (;;)
        {
          int i = 0;
          while (i < localexk.LSL.size())
          {
            paramAnonymousMenuItem[i] = com.tencent.mm.platformtools.z.a(((exl)localexk.LSL.get(i)).NuB);
            i += 1;
          }
          paramAnonymousMenuItem = new String[localexk.LSL.size()];
        }
        com.tencent.mm.ui.base.h.b(MallIndexOSUI.this.getContext(), null, paramAnonymousMenuItem, null, new h.d()
        {
          public final void oj(int paramAnonymous2Int)
          {
            AppMethodBeat.i(66079);
            if (paramAnonymous2Int < localexk.LSL.size())
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(((exl)localexk.LSL.get(paramAnonymous2Int)).NuN));
              localIntent.putExtra(e.p.OzJ, true);
              com.tencent.mm.wallet_core.ui.f.aA(MallIndexOSUI.this.getContext(), localIntent);
              AppMethodBeat.o(66079);
              return;
            }
            if (bool) {
              c.d(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
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
  
  protected final void ehf() {}
  
  protected final void eq(View paramView)
  {
    AppMethodBeat.i(66089);
    this.zlF[0] = new a();
    this.zlF[0].view = paramView.findViewById(2131305581);
    this.zlF[0].zjO = ((CdnImageView)paramView.findViewById(2131305583));
    this.zlF[0].zjO.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.zlF[0].gyt = ((TextView)paramView.findViewById(2131305589));
    this.zlF[0].zlW = ((TextView)paramView.findViewById(2131300271));
    this.zlF[0].zjO.setVisibility(4);
    this.zlF[1] = new a();
    this.zlF[1].view = paramView.findViewById(2131297234);
    this.zlF[1].zjO = ((CdnImageView)paramView.findViewById(2131297246));
    this.zlF[1].zjO.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.zlF[1].gyt = ((TextView)paramView.findViewById(2131297252));
    this.zlF[1].zlW = ((TextView)paramView.findViewById(2131297245));
    this.zlF[1].zjO.setVisibility(4);
    this.zlF[2] = new a();
    this.zlF[2].view = paramView.findViewById(2131297281);
    this.zlF[2].zjO = ((CdnImageView)paramView.findViewById(2131297315));
    this.zlF[2].zjO.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    this.zlF[2].gyt = ((TextView)paramView.findViewById(2131297320));
    this.zlF[2].zlW = ((TextView)paramView.findViewById(2131300272));
    this.zlF[2].zjO.setVisibility(4);
    this.zlF[3] = new a();
    this.zlF[3].view = paramView.findViewById(2131303906);
    this.zlF[3].zjO = ((CdnImageView)paramView.findViewById(2131303990));
    this.zlF[3].gyt = ((TextView)paramView.findViewById(2131304008));
    this.zlF[3].zjO.setVisibility(4);
    this.zlF[3].view.setVisibility(8);
    AppMethodBeat.o(66089);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66096);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(66096);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66088);
    this.vbj = aa.jQ(this).inflate(2131495428, null);
    this.zlh.addHeaderView(this.vbj);
    LinearLayout localLinearLayout = (LinearLayout)this.vbj.findViewById(2131302284);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.egN();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66088);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66083);
    super.initView();
    this.zlh.setPadding(a.zjP, 0, a.zjP, 0);
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
    e.ehs();
    a.b(this, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.psf = View.inflate(this, 2131495419, null);
    this.psf.setClickable(false);
    this.psf.setEnabled(false);
    this.zlH = ((TextView)this.psf.findViewById(2131310290));
    this.zlG = t.fQO().aeO(this.zjs);
    addSceneEndListener(1577);
    Log.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new i();
    if (this.zlG != null)
    {
      aj localaj = this.zlG;
      if ((localaj.Ibw != null) && (localaj.Ibw.LSL != null) && (localaj.Ibw.LSL.size() != 0)) {
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
    this.zlO.dead();
    this.zlP.dead();
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
      int i = com.tencent.mm.n.h.aqJ().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
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
      egS();
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
      if (paramq.zjx == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!Util.isNullOrNil(paramq.egK()))) {
        if (this.isFinished)
        {
          AppMethodBeat.o(66097);
          return true;
          paramInt1 = paramq.zjx.NuH;
        }
        else if (System.currentTimeMillis() - this.zlJ > 500L)
        {
          this.zlJ = System.currentTimeMillis();
          this.zlO.alive();
          this.zlP.alive();
          paramString = new Bundle();
          this.zlM = paramq.egK();
          paramq = new Intent();
          Log.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.zlM });
          paramString.putString("KoriginUrl", this.zlM);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramq.putExtra("rawUrl", this.zlM);
          paramq.putExtra("jsapiargs", paramString);
          paramq.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
          paramq.putExtra("pay_channel", 1);
          com.tencent.mm.wallet_core.ui.f.b(getContext(), paramq, 4);
        }
      }
      this.zlG = t.fQO().aeO(this.zjs);
      eha();
      egV();
      egS();
      egW();
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
    public TextView gyt;
    public View view;
    public CdnImageView zjO;
    public TextView zlW;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */