package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aba;
import com.tencent.mm.f.a.aba.b;
import com.tencent.mm.f.a.abc;
import com.tencent.mm.f.a.abc.b;
import com.tencent.mm.f.a.abo;
import com.tencent.mm.f.a.aci;
import com.tencent.mm.f.a.ps;
import com.tencent.mm.f.a.te;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.v;
import com.tencent.mm.plugin.wallet_core.ui.v.a;
import com.tencent.mm.plugin.wallet_core.ui.v.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.wallet_core.c.ab;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.k
public class MallIndexUI
  extends MallIndexBaseUI
  implements MStorageEx.IOnStorageChange
{
  private TextView EQX;
  private boolean EQY;
  private boolean ERA;
  private IListener ERB;
  private IListener<aci> ERC;
  private boolean ERD;
  private boolean ERE;
  private abc.b ERn;
  private RelativeLayout ERo;
  private boolean ERp;
  private boolean ERq;
  v ERr;
  private boolean ERs;
  private Dialog ERt;
  private boolean ERu;
  private b ERv;
  private c ERw;
  private WcPayMoneyLoadingView ERx;
  private ProgressBar ERy;
  private IListener<ps> ERz;
  private String gaK;
  private boolean isFinished;
  private View sBm;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(66117);
    this.isFinished = false;
    this.ERr = new v();
    this.sBm = null;
    this.EQY = false;
    this.EQX = null;
    this.ERs = false;
    this.ERu = false;
    this.ERv = null;
    this.ERw = null;
    this.ERz = new MallIndexUI.1(this);
    this.ERA = false;
    this.ERB = new IListener() {};
    this.ERC = new MallIndexUI.8(this);
    this.ERD = false;
    this.ERE = false;
    AppMethodBeat.o(66117);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(66141);
    if ((paramd == null) || (Util.isNullOrNil(paramd.EOB)))
    {
      AppMethodBeat.o(66141);
      return;
    }
    if (this.EQY)
    {
      if (this.EQX != null)
      {
        this.EQX.setText(a.i.mall_gdpr_mall_index);
        this.EQX.setOnClickListener(new MallIndexUI.5(this, paramd));
      }
      AppMethodBeat.o(66141);
      return;
    }
    this.sBm = View.inflate(this, a.g.mall_index_gdpr_foot, null);
    this.sBm.setClickable(false);
    this.sBm.setEnabled(false);
    this.EQX = ((TextView)this.sBm.findViewById(a.f.wallet_region_desc));
    this.EQX.setVisibility(0);
    this.EQX.setText(a.i.mall_gdpr_mall_index);
    this.EQX.setTextColor(getResources().getColor(a.c.link_color));
    this.EQX.setOnClickListener(new MallIndexUI.6(this, paramd));
    if (this.EQx != null)
    {
      this.EQx.addFooterView(this.sBm);
      this.EQY = true;
    }
    AppMethodBeat.o(66141);
  }
  
  private void tW(boolean paramBoolean)
  {
    AppMethodBeat.i(66132);
    if (paramBoolean)
    {
      this.EQB.setText(getString(a.i.wallet_index_ui_balance_hide));
      this.EQB.setVisibility(0);
      this.ERx.setVisibility(8);
      this.ERy.setVisibility(8);
      this.ERx.reset();
      AppMethodBeat.o(66132);
      return;
    }
    this.EQB.setVisibility(8);
    this.ERx.setVisibility(0);
    this.ERy.setVisibility(0);
    AppMethodBeat.o(66132);
  }
  
  protected final void eHM()
  {
    AppMethodBeat.i(66120);
    int i = getResources().getColor(a.c.mall_index_new_bg_color);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(a.f.root_layout).setBackgroundColor(i);
    AppMethodBeat.o(66120);
  }
  
  protected final void eQA()
  {
    AppMethodBeat.i(66138);
    u.gJj().gKZ();
    if (((u.gJj().gKZ().gJT()) || (u.gJj().gKZ().gJS())) && (z.bdq()))
    {
      Log.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(66138);
  }
  
  protected final boolean eQB()
  {
    AppMethodBeat.i(66128);
    Log.i("MicorMsg.MallIndexUI", "init BankcardList");
    final abc localabc = new abc();
    localabc.gah.scene = 1;
    localabc.gah.gaj = true;
    localabc.gah.retryCount = 0;
    localabc.gah.gak = true;
    localabc.gai.fZZ = new Runnable()
    {
      boolean lCY = false;
      
      public final void run()
      {
        AppMethodBeat.i(66111);
        if ((MallIndexUI.this.isFinishing()) || (MallIndexUI.this.hasFinish()) || (MallIndexUI.this.isDestroyed()))
        {
          AppMethodBeat.o(66111);
          return;
        }
        Log.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.g(MallIndexUI.this).gam + " hasNewTips : " + MallIndexUI.g(MallIndexUI.this).gan + " swipeOn : " + MallIndexUI.g(MallIndexUI.this).gao);
        if ((MallIndexUI.h(MallIndexUI.this)) || (MallIndexUI.this.getContext().isFinishing()))
        {
          Log.e("MicorMsg.MallIndexUI", "error for callback ac finish");
          AppMethodBeat.o(66111);
          return;
        }
        Log.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localabc.gai.gaM), Boolean.valueOf(this.lCY) });
        MallIndexUI.a(MallIndexUI.this, localabc.gai);
        int i;
        Object localObject;
        boolean bool;
        if (MallIndexUI.g(MallIndexUI.this).gaN != null)
        {
          i = 1;
          if ((i & MallIndexUI.g(MallIndexUI.this).gaN instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUI.g(MallIndexUI.this).gaN;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject).getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void eOt() {}
              });
            }
          }
          if (MallIndexUI.g(MallIndexUI.this).errCode == 0)
          {
            MallIndexUI.this.eQL();
            if (MallIndexUI.g(MallIndexUI.this).gaM) {
              MallIndexUI.this.eQH();
            }
            MallIndexUI.this.eQC();
            if (!this.lCY) {
              MallIndexUI.eQS();
            }
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this));
            MallIndexUI.this.eQJ();
            Log.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.g(MallIndexUI.this).gaI), Boolean.valueOf(MallIndexUI.g(MallIndexUI.this).gaJ), MallIndexUI.g(MallIndexUI.this).gaK });
            localObject = MallIndexUI.this;
            if (MallIndexUI.g(MallIndexUI.this).gaI != 1) {
              break label575;
            }
            bool = true;
            label425:
            MallIndexUI.a((MallIndexUI)localObject, bool);
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).gaJ);
            MallIndexUI.a(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).gaK);
            if (MallIndexUI.i(MallIndexUI.this) != null)
            {
              if (!MallIndexUI.j(MallIndexUI.this)) {
                break label580;
              }
              MallIndexUI.i(MallIndexUI.this).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          localObject = MallIndexUI.this;
          am localam = new am();
          ((MallIndexUI)localObject).ERr.a(new MallIndexUI.2((MallIndexUI)localObject), localam.gJO());
          if ((localabc.gai.gaM) && (this.lCY)) {
            MallIndexUI.this.updateView();
          }
          this.lCY = true;
          AppMethodBeat.o(66111);
          return;
          i = 0;
          break;
          label575:
          bool = false;
          break label425;
          label580:
          MallIndexUI.i(MallIndexUI.this).setVisibility(8);
        }
      }
    };
    EventCenter.instance.asyncPublish(localabc, Looper.myLooper());
    AppMethodBeat.o(66128);
    return false;
  }
  
  protected final void eQC()
  {
    AppMethodBeat.i(66129);
    Log.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
    boolean bool2;
    Object localObject;
    if ((this.ERn != null) && ((this.ERn.gal) || (this.ERn.gar)))
    {
      bool2 = u.gJo().gJY().gJI();
      localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VkB, Boolean.FALSE);
      if (localObject == null) {
        break label160;
      }
    }
    label160:
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      Log.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VkB, Boolean.TRUE);
        p.iS(this);
      }
      AppMethodBeat.o(66129);
      return;
      Log.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
      AppMethodBeat.o(66129);
      return;
    }
  }
  
  protected final void eQF()
  {
    AppMethodBeat.i(66124);
    this.EQF = com.tencent.mm.plugin.mall.a.k.eQr().Wp(this.EOJ).field_isShowSetting;
    if (this.EQG == null)
    {
      this.EQG = ad.kS(this).inflate(a.g.mall_index_settings_footer, null);
      this.EQx.addFooterView(this.EQG, null, false);
      TextView localTextView = (TextView)this.EQG.findViewById(a.f.misf_settings_tv);
      com.tencent.mm.wallet_core.ui.g.bi(localTextView, 100);
      localTextView.setOnClickListener(new MallIndexUI.10(this));
    }
    Log.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.EQF) });
    if (this.EQF == 0)
    {
      this.EQG.setVisibility(8);
      this.EQG.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(66124);
      return;
    }
    this.EQG.setVisibility(0);
    getWindow().getDecorView().post(new MallIndexUI.11(this));
    AppMethodBeat.o(66124);
  }
  
  protected final void eQG()
  {
    AppMethodBeat.i(66127);
    final aba localaba = new aba();
    localaba.gac.scene = "1";
    localaba.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66109);
        if (!Util.isNullOrNil(localaba.gad.gae)) {
          com.tencent.mm.wallet_core.ui.g.a(MallIndexUI.this.EQC, localaba.gad.gae, localaba.gad.content, localaba.gad.url);
        }
        AppMethodBeat.o(66109);
      }
    };
    EventCenter.instance.publish(localaba);
    AppMethodBeat.o(66127);
  }
  
  protected final void eQH()
  {
    AppMethodBeat.i(66131);
    Log.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new am();
    if (((am)localObject).gJL())
    {
      localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlz, getString(a.i.realname_balance_title));
      this.EQB.setText((CharSequence)localObject);
      this.EQB.setVisibility(0);
      this.ERx.setVisibility(8);
      this.ERy.setVisibility(8);
      AppMethodBeat.o(66131);
      return;
    }
    if (((am)localObject).gJN())
    {
      Log.i("MicorMsg.MallIndexUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtM, Long.valueOf(0L))).longValue();
      if (this.ERx != null)
      {
        tW(((am)localObject).gJP());
        if (this.ERx.getVisibility() == 0)
        {
          this.ERx.setMoney(com.tencent.mm.wallet_core.ui.g.formatMoney2f(com.tencent.mm.wallet_core.ui.g.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(66131);
        }
      }
      else
      {
        Log.w("MicorMsg.MallIndexUI", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(66131);
  }
  
  protected final void eQJ()
  {
    AppMethodBeat.i(66133);
    removeAllOptionMenu();
    Log.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, a.h.icons_outlined_more, false, new MallIndexUI.3(this));
    com.tencent.mm.plugin.report.service.h.IzE.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(66133);
  }
  
  protected final void eQL()
  {
    AppMethodBeat.i(66130);
    if (this.EQA == null)
    {
      AppMethodBeat.o(66130);
      return;
    }
    if ((!com.tencent.mm.aa.c.aFn().b(ar.a.VrF, ar.a.VrG)) && (!this.ERn.gan))
    {
      n localn = u.gJo().OTZ;
      if (localn == null) {
        break label132;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.h.aHH();
      if ((((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VjW, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      Log.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.EQA.setVisibility(0);
      AppMethodBeat.o(66130);
      return;
      label124:
      Log.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.EQA.setVisibility(8);
    AppMethodBeat.o(66130);
  }
  
  protected final void eQy()
  {
    AppMethodBeat.i(66121);
    setMMTitle(a.i.mall_index_ui_title);
    AppMethodBeat.o(66121);
  }
  
  protected final void eQz()
  {
    AppMethodBeat.i(66137);
    com.tencent.mm.plugin.mall.b.a.eRc();
    AppMethodBeat.o(66137);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66139);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(66139);
  }
  
  protected final void fo(View paramView)
  {
    AppMethodBeat.i(66125);
    this.ERv = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.fiO().h(this.ERv);
    this.ERw = new c(this, paramView);
    this.ERw.eQX();
    com.tencent.mm.plugin.newtips.a.fiO().h(this.ERw);
    AppMethodBeat.o(66125);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66123);
    this.zRq = ad.kS(this).inflate(a.g.mall_index_new_header_stub, null);
    this.EQx.addHeaderView(this.zRq, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.zRq.findViewById(a.f.header_content_layout);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.eQt();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66123);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66122);
    super.initView();
    this.EQx.setPadding(a.EPg, 0, a.EPg, 0);
    AppMethodBeat.o(66122);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66118);
    Log.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.ERr.eQT();
        AppMethodBeat.o(66118);
        return;
      }
      this.ERr.cancel();
      AppMethodBeat.o(66118);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.h.aHH();
      if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvq, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(66118);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new te();
      paramIntent.fSz.context = getContext();
      EventCenter.instance.publish(paramIntent);
    }
    AppMethodBeat.o(66118);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66119);
    fixStatusbar(true);
    if (26 != Build.VERSION.SDK_INT) {
      setRequestedOrientation(1);
    }
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.mm.plugin.wallet_core.model.k.amw(2);
    this.ERn = new abc.b();
    this.ERn.gal = false;
    this.ERn.gam = true;
    this.ERn.gan = false;
    this.ERz.alive();
    this.ERC.alive();
    this.ERr.Pdi = new v.b()
    {
      public final int eQV()
      {
        return 3;
      }
      
      public final Context getContext()
      {
        return MallIndexUI.this;
      }
    };
    e.eQZ();
    a.b(this, true);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.ERB);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
    {
      com.tencent.mm.kernel.h.aHH();
      a(new d((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvr, "")));
      com.tencent.mm.kernel.h.aHH();
      ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvq, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(66119);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66136);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    this.ERz.dead();
    this.ERC.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    EventCenter.instance.removeListener(this.ERB);
    AppMethodBeat.o(66136);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(66126);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicorMsg.MallIndexUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        eQH();
      }
    }
    AppMethodBeat.o(66126);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66135);
    super.onPause();
    this.ERr.onPause();
    if (this.ERx != null) {
      this.ERx.reset();
    }
    AppMethodBeat.o(66135);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66134);
    Log.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.ERr.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.gNk(), null);
    super.onResume();
    eQH();
    AppMethodBeat.o(66134);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66140);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramq instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramq).EOC);
    }
    do
    {
      do
      {
        AppMethodBeat.o(66140);
        return true;
      } while (!(paramq instanceof ae));
      paramString = (ae)paramq;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void eOt() {}
    })));
    AppMethodBeat.o(66140);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  abstract class a
    implements com.tencent.mm.plugin.newtips.a.a
  {
    protected ImageView ERJ;
    private Context context;
    protected TextView sJm;
    
    public a(Context paramContext, View paramView)
    {
      this.context = paramContext;
      fo(paramView);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    }
    
    public final boolean a(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, erx paramerx)
    {
      if (paramBoolean)
      {
        this.sJm.setVisibility(0);
        String str = paramerx.num;
        if (paramerx.num > 99) {
          str = this.context.getString(a.i.tab_msg_tip_over);
        }
        this.sJm.setText(str);
      }
      for (;;)
      {
        return true;
        this.sJm.setVisibility(8);
      }
    }
    
    public final boolean eQW()
    {
      return false;
    }
    
    public abstract void fo(View paramView);
    
    public final boolean tX(boolean paramBoolean)
    {
      return com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    }
    
    public final boolean tY(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.ERJ.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.ERJ.setVisibility(8);
      }
    }
    
    public final boolean tZ(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.sJm.setVisibility(0);
        this.sJm.setText(this.context.getString(a.i.app_new));
      }
      for (;;)
      {
        return true;
        this.sJm.setVisibility(8);
      }
    }
  }
  
  final class b
    extends MallIndexUI.a
  {
    private LinearLayout ERK;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void fo(View paramView)
    {
      AppMethodBeat.i(66113);
      this.ERK = ((LinearLayout)paramView.findViewById(a.f.minh_pos_layout));
      this.ERJ = ((ImageView)this.ERK.findViewById(a.f.minh_pos_reddot_iv));
      this.sJm = ((TextView)this.ERK.findViewById(a.f.minh_pos_unread_tv));
      this.ERK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.newtips.a.fiO().aap(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.by.c.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.ny(9, 0);
          com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.h.IzE.a(14419, new Object[] { MallIndexUI.this.uuid, Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66112);
        }
      });
      AppMethodBeat.o(66113);
    }
    
    public final String getPath()
    {
      return "pay_receiveorpay";
    }
    
    public final View getRoot()
    {
      return this.ERK;
    }
  }
  
  final class c
    extends MallIndexUI.a
  {
    private LinearLayout ERM;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean eQX()
    {
      AppMethodBeat.i(66116);
      com.tencent.mm.kernel.h.aHH();
      boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtn, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.h.aHH();
      long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vto, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        Log.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtn, Boolean.FALSE);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vto, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          this.ERJ.setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.GwK, bool);
          AppMethodBeat.o(66116);
          return true;
          this.ERJ.setVisibility(8);
        }
      }
    }
    
    public final void fo(View paramView)
    {
      AppMethodBeat.i(66115);
      this.ERM = ((LinearLayout)paramView.findViewById(a.f.minh_wallet_layout));
      MallIndexUI.this.EQB = ((TextView)this.ERM.findViewById(a.f.wallet_bottom_text_tv));
      MallIndexUI.a(MallIndexUI.this, (WcPayMoneyLoadingView)this.ERM.findViewById(a.f.wallet_bottom_text_view));
      MallIndexUI.a(MallIndexUI.this, (ProgressBar)this.ERM.findViewById(a.f.wallet_money_load_pb));
      MallIndexUI.this.getLifecycle().a(MallIndexUI.d(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setLoadingPb(MallIndexUI.e(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setPrefixSymbol("¥");
      MallIndexUI.d(MallIndexUI.this).setTextColor(-1);
      MallIndexUI.d(MallIndexUI.this).setTextSize(com.tencent.mm.ci.a.fromDPToPix(MallIndexUI.this.getContext(), 15));
      this.ERJ = ((ImageView)this.ERM.findViewById(a.f.minh_wallet_reddot_iv));
      this.sJm = ((TextView)this.ERM.findViewById(a.f.minh_wallet_unread_tv));
      this.ERM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66114);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          MallIndexUI.c(MallIndexUI.this);
          com.tencent.mm.plugin.newtips.a.fiO().aap(15);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66114);
        }
      });
      AppMethodBeat.o(66115);
    }
    
    public final String getPath()
    {
      return "wallet";
    }
    
    public final View getRoot()
    {
      return this.ERM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */