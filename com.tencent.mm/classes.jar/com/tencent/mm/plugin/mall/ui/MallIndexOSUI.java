package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.m.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.w;
import java.util.LinkedList;

public class MallIndexOSUI
  extends MallIndexBaseUI
{
  private boolean eRZ;
  private View jWo;
  private long lastUpdateTime;
  private MallIndexOSUI.a[] ozK;
  private ai ozL;
  private TextView ozM;
  private boolean ozN;
  private long ozO;
  private boolean ozP;
  private boolean ozQ;
  private String ozR;
  private int ozS;
  private com.tencent.mm.sdk.b.c ozT;
  private com.tencent.mm.sdk.b.c ozU;
  
  public MallIndexOSUI()
  {
    AppMethodBeat.i(43187);
    this.ozK = new MallIndexOSUI.a[4];
    this.ozL = new ai();
    this.ozM = null;
    this.lastUpdateTime = 0L;
    this.jWo = null;
    this.ozN = false;
    this.eRZ = false;
    this.ozO = 0L;
    this.ozP = false;
    this.ozQ = false;
    this.ozR = "";
    this.ozS = 0;
    this.ozT = new MallIndexOSUI.1(this);
    this.ozU = new MallIndexOSUI.2(this);
    AppMethodBeat.o(43187);
  }
  
  public final void a(MallFunction paramMallFunction, int paramInt)
  {
    AppMethodBeat.i(43191);
    super.a(paramMallFunction, paramInt);
    com.tencent.mm.plugin.report.service.h.qsU.e(13720, new Object[] { paramMallFunction.nDe, Long.valueOf(bo.apW(paramMallFunction.pUM)) });
    AppMethodBeat.o(43191);
  }
  
  protected final void bHV()
  {
    AppMethodBeat.i(43192);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(2131690266));
    }
    if (com.tencent.mm.compatible.util.d.fv(21)) {
      getWindow().setStatusBarColor(getResources().getColor(2131690652));
    }
    setTitleDividerVis(false);
    if (Build.VERSION.SDK_INT >= 16) {
      getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    setActionbarColor(getContext().getResources().getColor(2131690605));
    AppMethodBeat.o(43192);
  }
  
  protected final boolean bOB()
  {
    AppMethodBeat.i(43199);
    cvj localcvj = this.ozL.ulA;
    int i = 0;
    while (i < this.ozK.length)
    {
      this.ozK[i].view.setVisibility(8);
      this.ozK[i].oyh.setImageBitmap(null);
      i += 1;
    }
    i = 0;
    while ((i < localcvj.wZn.size()) && (i < this.ozK.length))
    {
      cvk localcvk = (cvk)localcvj.wZn.get(i);
      this.ozK[i].view.setVisibility(0);
      this.ozK[i].oyh.setUrl(aa.a(localcvk.ydP));
      this.ozK[i].oyh.setVisibility(0);
      this.ozK[i].ehx.setText(aa.a(localcvk.ydO));
      ab.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[] { Integer.valueOf(i), aa.a(localcvk.ydP) });
      this.ozK[i].oAc.setVisibility(8);
      String str = aa.a(localcvk.ydR);
      if (!bo.isNullOrNil(str))
      {
        this.ozK[i].oAc.setText(str);
        this.ozK[i].oAc.setVisibility(0);
      }
      this.ozK[i].view.setOnClickListener(new MallIndexOSUI.4(this, localcvk));
      i += 1;
    }
    if ((this.ozq != null) && (this.jWo != null) && (!this.ozN))
    {
      this.ozq.addFooterView(this.jWo);
      this.ozN = true;
    }
    if (!bo.isNullOrNil(this.ozL.ulG))
    {
      this.ozM.setText(this.ozL.ulG);
      this.ozM.setVisibility(0);
    }
    AppMethodBeat.o(43199);
    return true;
  }
  
  protected final void bOE() {}
  
  protected final void bOF()
  {
    AppMethodBeat.i(43190);
    com.tencent.mm.wallet_core.ui.e.a(this.ozv, "1", this.ozL.ulF, this.ozL.oph);
    bOA();
    AppMethodBeat.o(43190);
  }
  
  protected final void bOG() {}
  
  protected final void bOI()
  {
    AppMethodBeat.i(43200);
    removeAllOptionMenu();
    addIconOptionMenu(0, 2130839668, new MallIndexOSUI.5(this));
    AppMethodBeat.o(43200);
  }
  
  protected final void bOK() {}
  
  protected final void bOx()
  {
    AppMethodBeat.i(43193);
    String str1 = this.ozL.ulD;
    String str2 = this.ozL.ulE;
    setMMTitle(str1);
    if (!bo.isNullOrNil(str2)) {
      setMMSubTitle(str2);
    }
    AppMethodBeat.o(43193);
  }
  
  protected final void bOy() {}
  
  protected final void bOz() {}
  
  protected final void dt(View paramView)
  {
    AppMethodBeat.i(43195);
    this.ozK[0] = new MallIndexOSUI.a(this);
    this.ozK[0].view = paramView.findViewById(2131825944);
    this.ozK[0].oyh = ((CdnImageView)paramView.findViewById(2131825945));
    this.ozK[0].ehx = ((TextView)paramView.findViewById(2131825946));
    this.ozK[0].oAc = ((TextView)paramView.findViewById(2131825947));
    this.ozK[0].oyh.setVisibility(4);
    this.ozK[1] = new MallIndexOSUI.a(this);
    this.ozK[1].view = paramView.findViewById(2131825948);
    this.ozK[1].oyh = ((CdnImageView)paramView.findViewById(2131825949));
    this.ozK[1].ehx = ((TextView)paramView.findViewById(2131825950));
    this.ozK[1].oAc = ((TextView)paramView.findViewById(2131825951));
    this.ozK[1].oyh.setVisibility(4);
    this.ozK[2] = new MallIndexOSUI.a(this);
    this.ozK[2].view = paramView.findViewById(2131825957);
    this.ozK[2].oyh = ((CdnImageView)paramView.findViewById(2131825958));
    this.ozK[2].ehx = ((TextView)paramView.findViewById(2131825959));
    this.ozK[2].oAc = ((TextView)paramView.findViewById(2131825961));
    this.ozK[2].oyh.setVisibility(4);
    this.ozK[3] = new MallIndexOSUI.a(this);
    this.ozK[3].view = paramView.findViewById(2131825953);
    this.ozK[3].oyh = ((CdnImageView)paramView.findViewById(2131825954));
    this.ozK[3].ehx = ((TextView)paramView.findViewById(2131825955));
    this.ozK[3].oyh.setVisibility(4);
    this.ozK[3].view.setVisibility(8);
    AppMethodBeat.o(43195);
  }
  
  public void finish()
  {
    AppMethodBeat.i(43201);
    this.eRZ = true;
    super.finish();
    AppMethodBeat.o(43201);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(43194);
    this.ozz = w.hM(this).inflate(2130970085, null);
    this.ozq.addHeaderView(this.ozz);
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)this.ozz.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.bOu();
    this.ozz.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(43194);
  }
  
  public void initView()
  {
    AppMethodBeat.i(43189);
    super.initView();
    this.ozq.setOnScrollListener(new MallIndexOSUI.3(this));
    AppMethodBeat.o(43189);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(43203);
    ab.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(43203);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43188);
    c.jh(false);
    a.a(this, false, false);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    this.jWo = View.inflate(this, 2130970078, null);
    this.jWo.setClickable(false);
    this.jWo.setEnabled(false);
    this.ozM = ((TextView)this.jWo.findViewById(2131825926));
    this.ozL = t.cTT().IC(this.oxO);
    addSceneEndListener(1577);
    ab.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
    paramBundle = new com.tencent.mm.plugin.mall.a.h();
    if (this.ozL != null)
    {
      ai localai = this.ozL;
      if ((localai.ulA != null) && (localai.ulA.wZn != null) && (localai.ulA.wZn.size() != 0)) {
        break label169;
      }
    }
    label169:
    for (int i = 1; i != 0; i = 0)
    {
      doSceneForceProgress(paramBundle);
      AppMethodBeat.o(43188);
      return;
    }
    doSceneProgress(paramBundle, false);
    AppMethodBeat.o(43188);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43198);
    super.onDestroy();
    removeSceneEndListener(1577);
    this.ozT.dead();
    this.ozU.dead();
    AppMethodBeat.o(43198);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(43197);
    super.onPause();
    AppMethodBeat.o(43197);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43196);
    super.onResume();
    int i = g.Nq().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000;
    long l = System.currentTimeMillis();
    ab.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.lastUpdateTime), Long.valueOf(l) });
    if (l - this.lastUpdateTime >= i)
    {
      this.lastUpdateTime = System.currentTimeMillis();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.h(), false);
    }
    bOx();
    AppMethodBeat.o(43196);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43202);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if (paramm.getType() == 1577)
    {
      paramm = (com.tencent.mm.plugin.mall.a.h)paramm;
      if (paramm.oxR == null) {
        paramInt1 = 0;
      }
      while ((paramInt1 == 1) && (!bo.isNullOrNil(paramm.bOr()))) {
        if (this.eRZ)
        {
          AppMethodBeat.o(43202);
          return true;
          paramInt1 = paramm.oxR.ydS;
        }
        else if (System.currentTimeMillis() - this.ozO > 500L)
        {
          this.ozO = System.currentTimeMillis();
          this.ozT.alive();
          this.ozU.alive();
          paramString = new Bundle();
          this.ozR = paramm.bOr();
          paramm = new Intent();
          ab.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", new Object[] { this.ozR });
          paramString.putString("KoriginUrl", this.ozR);
          paramString.putBoolean("KIsHKAgreeUrl", true);
          paramm.putExtra("rawUrl", this.ozR);
          paramm.putExtra("jsapiargs", paramString);
          paramm.putExtra("geta8key_username", r.Zn());
          paramm.putExtra("pay_channel", 1);
          com.tencent.mm.bq.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramm, 4);
        }
      }
      this.ozL = t.cTT().IC(this.oxO);
      bOF();
      bOB();
      bOx();
    }
    AppMethodBeat.o(43202);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI
 * JD-Core Version:    0.7.0.1
 */