package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vf.b;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.k;
import java.math.BigDecimal;
import java.math.RoundingMode;

@i
public class MallIndexUI
  extends MallIndexBaseUI
{
  private String cMm;
  private boolean eRZ;
  private View jWo;
  vf.b oAd;
  private RelativeLayout oAe;
  private boolean oAf;
  private boolean oAg;
  s oAh;
  private boolean oAi;
  private Dialog oAj;
  private boolean oAk;
  private ProgressBar oAl;
  private com.tencent.mm.sdk.b.c<lz> oAm;
  private boolean oAn;
  private com.tencent.mm.sdk.b.c oAo;
  private com.tencent.mm.sdk.b.c<wj> oAp;
  private boolean oAq;
  private com.tencent.mm.plugin.wallet_core.model.d oAr;
  private boolean oAs;
  private TextView ozM;
  private boolean ozN;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(43222);
    this.eRZ = false;
    this.oAh = new s();
    this.jWo = null;
    this.ozN = false;
    this.ozM = null;
    this.oAi = false;
    this.oAk = false;
    this.oAm = new com.tencent.mm.sdk.b.c() {};
    this.oAn = false;
    this.oAo = new MallIndexUI.9(this);
    this.oAp = new MallIndexUI.10(this);
    this.oAq = false;
    this.oAs = false;
    AppMethodBeat.o(43222);
  }
  
  private void a(com.tencent.mm.plugin.mall.a.d paramd)
  {
    AppMethodBeat.i(43244);
    if ((paramd == null) || (bo.isNullOrNil(paramd.oxH)))
    {
      AppMethodBeat.o(43244);
      return;
    }
    if (this.ozN)
    {
      if (this.ozM != null)
      {
        this.ozM.setText(2131301440);
        this.ozM.setOnClickListener(new MallIndexUI.7(this, paramd));
      }
      AppMethodBeat.o(43244);
      return;
    }
    this.jWo = View.inflate(this, 2130970081, null);
    this.jWo.setClickable(false);
    this.jWo.setEnabled(false);
    this.ozM = ((TextView)this.jWo.findViewById(2131825926));
    this.ozM.setVisibility(0);
    this.ozM.setText(2131301440);
    this.ozM.setTextColor(getResources().getColor(2131690214));
    this.ozM.setOnClickListener(new MallIndexUI.8(this, paramd));
    this.ozq.addFooterView(this.jWo);
    this.ozN = true;
    AppMethodBeat.o(43244);
  }
  
  private void jg(boolean paramBoolean)
  {
    AppMethodBeat.i(43235);
    if (paramBoolean) {
      this.ozu.setText(getString(2131305106));
    }
    AppMethodBeat.o(43235);
  }
  
  protected final void bHV()
  {
    AppMethodBeat.i(43225);
    int i = getResources().getColor(2131690265);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131825962).setBackgroundColor(i);
    AppMethodBeat.o(43225);
  }
  
  protected final boolean bOB()
  {
    AppMethodBeat.i(43232);
    com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "init BankcardList");
    this.oAr.b(new MallIndexUI.3(this));
    AppMethodBeat.o(43232);
    return false;
  }
  
  protected final void bOE()
  {
    AppMethodBeat.i(43229);
    this.ozy = com.tencent.mm.plugin.mall.a.j.bOs().yJ(this.oxO).field_isShowSetting;
    if (this.ozA == null)
    {
      this.ozA = w.hM(this).inflate(2130970084, null);
      this.ozq.addFooterView(this.ozA, null, false);
      TextView localTextView = (TextView)this.ozA.findViewById(2131825942);
      com.tencent.mm.wallet_core.ui.e.aE(localTextView, 100);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(43217);
          com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "click settings btn");
          com.tencent.mm.bq.d.H(MallIndexUI.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          AppMethodBeat.o(43217);
        }
      });
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.ozy) });
    if (this.ozy == 0)
    {
      this.ozA.setVisibility(8);
      this.ozA.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(43229);
      return;
    }
    this.ozA.setVisibility(0);
    getWindow().getDecorView().post(new MallIndexUI.13(this));
    AppMethodBeat.o(43229);
  }
  
  protected final void bOF()
  {
    AppMethodBeat.i(43231);
    vd localvd = new vd();
    localvd.cLE.bSd = "1";
    localvd.callback = new MallIndexUI.16(this, localvd);
    com.tencent.mm.sdk.b.a.ymk.l(localvd);
    AppMethodBeat.o(43231);
  }
  
  protected final void bOG()
  {
    AppMethodBeat.i(43234);
    com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    ak localak = new ak();
    if ((localak.ulJ & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localak.ulJ) });
      if (!bool) {
        break;
      }
      localObject = (String)g.RL().Ru().get(ac.a.yCx, getString(2131302323));
      this.ozu.setText((CharSequence)localObject);
      jg(localak.cUk());
      AppMethodBeat.o(43234);
      return;
    }
    if ((localak.ulJ & 0x400000) > 0)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(localak.ulJ) });
      if (!bool) {
        break label288;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "show balance amount");
      localObject = t.cTN();
      if (((am)localObject).ulN == null) {
        break label241;
      }
    }
    label241:
    for (long l = ((am)localObject).ulN.field_wallet_balance;; l = -1L)
    {
      if (l >= 0L) {
        break label248;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicorMsg.MallIndexUI", "wallet balance is null!");
      this.ozu.setText("");
      AppMethodBeat.o(43234);
      return;
      bool = false;
      break;
    }
    label248:
    Object localObject = com.tencent.mm.wallet_core.ui.e.F(com.tencent.mm.wallet_core.ui.e.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue());
    this.ozu.setText((CharSequence)localObject);
    jg(localak.cUk());
    label288:
    AppMethodBeat.o(43234);
  }
  
  protected final void bOI()
  {
    AppMethodBeat.i(43236);
    removeAllOptionMenu();
    com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2130839668, false, new MallIndexUI.5(this));
    h.qsU.e(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(43236);
  }
  
  protected final void bOK()
  {
    AppMethodBeat.i(43233);
    if (this.ozt == null)
    {
      AppMethodBeat.o(43233);
      return;
    }
    if ((!com.tencent.mm.x.c.PJ().b(ac.a.yHz, ac.a.yHA)) && (!this.oAd.cLP))
    {
      p localp = t.cTN().ulQ;
      if (localp == null) {
        break label132;
      }
      i = localp.field_red_dot_index;
      g.RM();
      if ((((Integer)g.RL().Ru().get(ac.a.yAU, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.ozt.setVisibility(0);
      AppMethodBeat.o(43233);
      return;
      label124:
      com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.ozt.setVisibility(8);
    AppMethodBeat.o(43233);
  }
  
  protected final void bOx()
  {
    AppMethodBeat.i(43226);
    setMMTitle(2131301445);
    AppMethodBeat.o(43226);
  }
  
  protected final void bOy()
  {
    AppMethodBeat.i(43240);
    com.tencent.mm.plugin.mall.b.a.bOS();
    AppMethodBeat.o(43240);
  }
  
  protected final void bOz()
  {
    AppMethodBeat.i(43241);
    t.cTJ().cVl();
    if (((t.cTJ().cVl().cUo()) || (t.cTJ().cVl().cUn())) && (r.ZB()))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(43241);
  }
  
  protected final void dt(View paramView)
  {
    AppMethodBeat.i(43230);
    g.RM();
    boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yJb, Boolean.FALSE)).booleanValue();
    g.RM();
    long l = ((Long)g.RL().Ru().get(ac.a.yJc, Long.valueOf(0L))).longValue();
    if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
      g.RM();
      g.RL().Ru().set(ac.a.yJb, Boolean.FALSE);
      g.RM();
      g.RL().Ru().set(ac.a.yJc, Long.valueOf(0L));
      bool = false;
    }
    for (;;)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131825937);
      paramView = (LinearLayout)paramView.findViewById(2131825938);
      this.ozu = ((TextView)paramView.findViewById(2131825940));
      this.oAl = ((ProgressBar)paramView.findViewById(2131825941));
      this.oAr = new com.tencent.mm.plugin.wallet_core.model.d(this.ozu, this.oAl, 1);
      ImageView localImageView = (ImageView)paramView.findViewById(2131825939);
      if (bool) {
        localImageView.setVisibility(0);
      }
      for (;;)
      {
        localLinearLayout.setOnClickListener(new MallIndexUI.14(this));
        paramView.setOnClickListener(new MallIndexUI.15(this));
        AppMethodBeat.o(43230);
        return;
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(43242);
    this.eRZ = true;
    super.finish();
    AppMethodBeat.o(43242);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(43228);
    this.ozz = w.hM(this).inflate(2130970083, null);
    this.ozq.addHeaderView(this.ozz, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.ozz.findViewById(2131825936);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.bOu();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(43228);
  }
  
  public void initView()
  {
    AppMethodBeat.i(43227);
    super.initView();
    this.ozq.setPadding(a.oyi, 0, a.oyi, 0);
    AppMethodBeat.o(43227);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(43223);
    com.tencent.mm.sdk.platformtools.ab.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.oAh.bOM();
        AppMethodBeat.o(43223);
        return;
      }
      this.oAh.cancel();
      AppMethodBeat.o(43223);
      return;
    }
    if (paramInt1 == 5)
    {
      g.RM();
      if (!((Boolean)g.RL().Ru().get(ac.a.yKu, Boolean.FALSE)).booleanValue()) {
        finish();
      }
    }
    AppMethodBeat.o(43223);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43224);
    fixStatusbar(true);
    ((com.tencent.mm.plugin.walletlock.a.b)g.E(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.mm.plugin.wallet_core.model.m.Iy(2);
    this.oAd = new vf.b();
    this.oAd.cLN = false;
    this.oAd.cLO = true;
    this.oAd.cLP = false;
    this.oAm.alive();
    this.oAp.alive();
    this.oAh.uuu = new MallIndexUI.11(this);
    c.jh(true);
    a.a(this, false, true);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ymk.c(this.oAo);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.au.b.tM((String)g.RL().Ru().get(274436, null)))
    {
      g.RM();
      a(new com.tencent.mm.plugin.mall.a.d((String)g.RL().Ru().get(ac.a.yKv, "")));
      g.RM();
      ((Boolean)g.RL().Ru().get(ac.a.yKu, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    h.qsU.e(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(43224);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43239);
    super.onDestroy();
    this.oAm.dead();
    this.oAp.dead();
    if (this.oAr != null) {
      this.oAr.release();
    }
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    com.tencent.mm.sdk.b.a.ymk.d(this.oAo);
    AppMethodBeat.o(43239);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(43238);
    super.onPause();
    this.oAh.onPause();
    AppMethodBeat.o(43238);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43237);
    com.tencent.mm.sdk.platformtools.ab.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.oAh.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)g.E(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.cXt(), null);
    super.onResume();
    AppMethodBeat.o(43237);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(43243);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if ((paramm instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramm).oxI);
    }
    do
    {
      do
      {
        AppMethodBeat.o(43243);
        return true;
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab));
      paramString = (com.tencent.mm.plugin.wallet_core.c.ab)paramm;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new MallIndexUI.6(this))));
    AppMethodBeat.o(43243);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */