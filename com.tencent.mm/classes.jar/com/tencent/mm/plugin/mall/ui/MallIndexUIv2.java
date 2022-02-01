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
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.v;
import com.tencent.mm.plugin.wallet_core.ui.v.a;
import com.tencent.mm.plugin.wallet_core.ui.v.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
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
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.k
public class MallIndexUIv2
  extends MallIndexBaseUIv2
  implements MStorageEx.IOnStorageChange
{
  private TextView EQX;
  private boolean EQY;
  private boolean ERA;
  private IListener ERB;
  private IListener<aci> ERC;
  private boolean ERE;
  private RelativeLayout ERO;
  private b ERP;
  private c ERQ;
  private int ERR;
  abc.b ERn;
  private RelativeLayout ERo;
  private boolean ERp;
  private boolean ERq;
  v ERr;
  private boolean ERs;
  private Dialog ERt;
  private boolean ERu;
  private WcPayMoneyLoadingView ERx;
  private ProgressBar ERy;
  private IListener<ps> ERz;
  private String gaK;
  private boolean isFinished;
  private View sBm;
  
  public MallIndexUIv2()
  {
    AppMethodBeat.i(211997);
    this.isFinished = false;
    this.ERr = new v();
    this.sBm = null;
    this.EQY = false;
    this.EQX = null;
    this.ERs = false;
    this.ERu = false;
    this.ERP = null;
    this.ERQ = null;
    this.ERz = new MallIndexUIv2.1(this);
    this.ERA = false;
    this.ERB = new IListener() {};
    this.ERC = new MallIndexUIv2.12(this);
    this.ERE = false;
    AppMethodBeat.o(211997);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(212053);
    if ((paramd == null) || (Util.isNullOrNil(paramd.EOB)))
    {
      AppMethodBeat.o(212053);
      return;
    }
    if (this.EQY)
    {
      if (this.EQX != null)
      {
        this.EQX.setText(a.i.mall_gdpr_mall_index);
        this.EQX.setOnClickListener(new MallIndexUIv2.8(this, paramd));
      }
      AppMethodBeat.o(212053);
      return;
    }
    this.sBm = View.inflate(this, a.g.mall_index_gdpr_foot, null);
    this.sBm.setClickable(false);
    this.sBm.setEnabled(false);
    this.EQX = ((TextView)this.sBm.findViewById(a.f.wallet_region_desc));
    this.EQX.setVisibility(0);
    this.EQX.setText(a.i.mall_gdpr_mall_index);
    this.EQX.setTextColor(getResources().getColor(a.c.link_color));
    this.EQX.setOnClickListener(new MallIndexUIv2.9(this, paramd));
    if (this.EQx != null)
    {
      this.EQx.addFooterView(this.sBm);
      this.EQY = true;
    }
    AppMethodBeat.o(212053);
  }
  
  private void tW(boolean paramBoolean)
  {
    AppMethodBeat.i(212038);
    if (paramBoolean)
    {
      this.EQB.setText(getString(a.i.wallet_index_ui_balance_hide));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.EQB.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
      this.EQB.setLayoutParams(localLayoutParams);
      this.EQB.setVisibility(0);
      this.ERx.setVisibility(8);
      this.ERy.setVisibility(8);
      this.ERO.setVisibility(8);
      this.ERx.reset();
      AppMethodBeat.o(212038);
      return;
    }
    this.EQB.setVisibility(8);
    this.ERx.setVisibility(0);
    this.ERy.setVisibility(0);
    this.ERO.setVisibility(0);
    AppMethodBeat.o(212038);
  }
  
  protected final void eHM()
  {
    AppMethodBeat.i(212065);
    int i = getResources().getColor(a.c.mall_index_new_bg_color);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(a.f.root_layout).setBackgroundColor(i);
    AppMethodBeat.o(212065);
  }
  
  protected final boolean eQB()
  {
    AppMethodBeat.i(212030);
    Log.i("MicorMsg.MallIndexUIv2", "init BankcardList");
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
        AppMethodBeat.i(267594);
        if ((MallIndexUIv2.this.isFinishing()) || (MallIndexUIv2.this.hasFinish()) || (MallIndexUIv2.this.isDestroyed()))
        {
          AppMethodBeat.o(267594);
          return;
        }
        Log.d("MicorMsg.MallIndexUIv2", "mUserInfo needBind : " + MallIndexUIv2.g(MallIndexUIv2.this).gam + " hasNewTips : " + MallIndexUIv2.g(MallIndexUIv2.this).gan + " swipeOn : " + MallIndexUIv2.g(MallIndexUIv2.this).gao);
        if ((MallIndexUIv2.h(MallIndexUIv2.this)) || (MallIndexUIv2.this.getContext().isFinishing()))
        {
          Log.e("MicorMsg.MallIndexUIv2", "error for callback ac finish");
          AppMethodBeat.o(267594);
          return;
        }
        Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localabc.gai.gaM), Boolean.valueOf(this.lCY) });
        MallIndexUIv2.a(MallIndexUIv2.this, localabc.gai);
        int i;
        Object localObject1;
        boolean bool2;
        Object localObject2;
        if (MallIndexUIv2.g(MallIndexUIv2.this).gaN != null)
        {
          i = 1;
          if ((i & MallIndexUIv2.g(MallIndexUIv2.this).gaN instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject1 = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUIv2.g(MallIndexUIv2.this).gaN;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).getJumpRemind().a(MallIndexUIv2.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void eOt() {}
              });
            }
          }
          if (MallIndexUIv2.g(MallIndexUIv2.this).errCode == 0)
          {
            MallIndexUIv2.this.eQL();
            if (MallIndexUIv2.g(MallIndexUIv2.this).gaM) {
              MallIndexUIv2.this.eQH();
            }
            localObject1 = MallIndexUIv2.this;
            Log.i("MicorMsg.MallIndexUIv2", "showGetNewWalletTip call");
            if ((((MallIndexUIv2)localObject1).ERn == null) || ((!((MallIndexUIv2)localObject1).ERn.gal) && (!((MallIndexUIv2)localObject1).ERn.gar))) {
              break label718;
            }
            bool2 = u.gJo().gJY().gJI();
            localObject2 = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VkB, Boolean.FALSE);
            if (localObject2 == null) {
              break label749;
            }
          }
        }
        label454:
        label718:
        label734:
        label749:
        for (boolean bool1 = ((Boolean)localObject2).booleanValue();; bool1 = false)
        {
          Log.i("MicorMsg.MallIndexUIv2", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
          if ((!bool1) && (bool2))
          {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VkB, Boolean.TRUE);
            p.iS((Context)localObject1);
          }
          if (!this.lCY) {
            MallIndexUIv2.eQY();
          }
          MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this));
          MallIndexUIv2.this.eQJ();
          Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).gaI), Boolean.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).gaJ), MallIndexUIv2.g(MallIndexUIv2.this).gaK });
          localObject1 = MallIndexUIv2.this;
          if (MallIndexUIv2.g(MallIndexUIv2.this).gaI == 1)
          {
            bool1 = true;
            MallIndexUIv2.a((MallIndexUIv2)localObject1, bool1);
            MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).gaJ);
            MallIndexUIv2.a(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).gaK);
            if (MallIndexUIv2.i(MallIndexUIv2.this) != null)
            {
              if (!MallIndexUIv2.j(MallIndexUIv2.this)) {
                break label734;
              }
              MallIndexUIv2.i(MallIndexUIv2.this).setVisibility(0);
            }
          }
          for (;;)
          {
            localObject1 = MallIndexUIv2.this;
            localObject2 = new am();
            ((MallIndexUIv2)localObject1).ERr.a(new MallIndexUIv2.3((MallIndexUIv2)localObject1), ((am)localObject2).gJO());
            if ((localabc.gai.gaM) && (this.lCY)) {
              MallIndexUIv2.this.updateView();
            }
            this.lCY = true;
            AppMethodBeat.o(267594);
            return;
            i = 0;
            break;
            Log.e("MicorMsg.MallIndexUIv2", "user is not reg or simplereg，should not show this dialog");
            break label454;
            bool1 = false;
            break label564;
            MallIndexUIv2.i(MallIndexUIv2.this).setVisibility(8);
          }
        }
      }
    };
    EventCenter.instance.asyncPublish(localabc, Looper.myLooper());
    AppMethodBeat.o(212030);
    return false;
  }
  
  protected final void eQF()
  {
    AppMethodBeat.i(212013);
    String str = com.tencent.mm.plugin.wallet_core.model.mall.b.gKK();
    Log.i("MicorMsg.MallIndexUIv2", "emptyHint: %s", new Object[] { str });
    if (this.EQG == null)
    {
      this.EQG = ad.kS(this).inflate(a.g.mall_index_settings_footer, null);
      this.EQx.addFooterView(this.EQG, null, false);
      TextView localTextView = (TextView)this.EQG.findViewById(a.f.misf_settings_tv);
      com.tencent.mm.wallet_core.ui.g.bi(localTextView, 100);
      localTextView.setOnClickListener(new MallIndexUIv2.15(this));
    }
    if (Util.isNullOrNil(str))
    {
      this.EQG.setVisibility(8);
      this.EQG.setPadding(com.tencent.mm.ci.a.aZ(getContext(), a.d.Edge_2A), 0, com.tencent.mm.ci.a.aZ(getContext(), a.d.Edge_2A), 0);
      AppMethodBeat.o(212013);
      return;
    }
    this.EQG.setVisibility(0);
    ((TextView)this.EQG.findViewById(a.f.misf_settings_tv)).setText(str);
    getWindow().getDecorView().post(new MallIndexUIv2.16(this));
    AppMethodBeat.o(212013);
  }
  
  protected final void eQG()
  {
    AppMethodBeat.i(212026);
    final aba localaba = new aba();
    localaba.gac.scene = "1";
    localaba.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267311);
        if (!Util.isNullOrNil(localaba.gad.gae)) {
          com.tencent.mm.wallet_core.ui.g.a(MallIndexUIv2.this.EQC, localaba.gad.gae, localaba.gad.content, localaba.gad.url);
        }
        AppMethodBeat.o(267311);
      }
    };
    EventCenter.instance.publish(localaba);
    AppMethodBeat.o(212026);
  }
  
  protected final void eQH()
  {
    AppMethodBeat.i(212036);
    Log.i("MicorMsg.MallIndexUIv2", "updateBalanceNum");
    Object localObject = new am();
    if (((am)localObject).gJL())
    {
      localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlz, getString(a.i.realname_balance_title));
      this.EQB.setText((CharSequence)localObject);
      localObject = (LinearLayout.LayoutParams)this.EQB.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
      this.EQB.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.EQB.setVisibility(0);
      this.ERx.setVisibility(8);
      this.ERy.setVisibility(8);
      this.ERO.setVisibility(8);
      AppMethodBeat.o(212036);
      return;
    }
    if (((am)localObject).gJN())
    {
      Log.i("MicorMsg.MallIndexUIv2", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.VtM, Long.valueOf(0L))).longValue();
      if (this.ERx != null)
      {
        tW(((am)localObject).gJP());
        if (this.ERx.getVisibility() == 0)
        {
          this.ERx.setMoney(com.tencent.mm.wallet_core.ui.g.formatMoney2f(com.tencent.mm.wallet_core.ui.g.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(212036);
        }
      }
      else
      {
        Log.w("MicorMsg.MallIndexUIv2", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(212036);
  }
  
  protected final void eQJ()
  {
    AppMethodBeat.i(212041);
    removeAllOptionMenu();
    Log.i("MicorMsg.MallIndexUIv2", "addIconOptionMenuByMode");
    addIconOptionMenu(0, a.i.wallet_password_setting_ui_title, a.h.icons_outlined_more, false, new MallIndexUIv2.4(this));
    com.tencent.mm.plugin.report.service.h.IzE.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(212041);
  }
  
  protected final void eQL()
  {
    AppMethodBeat.i(212033);
    if (this.EQA == null)
    {
      AppMethodBeat.o(212033);
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
      Log.i("MicorMsg.MallIndexUIv2", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.EQA.setVisibility(0);
      AppMethodBeat.o(212033);
      return;
      label124:
      Log.i("MicorMsg.MallIndexUIv2", "bankcard do not need red point");
    }
    this.EQA.setVisibility(8);
    AppMethodBeat.o(212033);
  }
  
  protected final void eQM()
  {
    AppMethodBeat.i(212055);
    if (this.zRq == null)
    {
      Log.i("MicorMsg.MallIndexUIv2", "header = null");
      AppMethodBeat.o(212055);
      return;
    }
    final LinearLayout localLinearLayout = (LinearLayout)this.zRq.findViewById(a.f.header_content_layout);
    if (localLinearLayout == null)
    {
      Log.i("MicorMsg.MallIndexUIv2", "headerContentLayout = null");
      AppMethodBeat.o(212055);
      return;
    }
    localLinearLayout.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197283);
        int k = localLinearLayout.getWidth();
        MallIndexUIv2.a(MallIndexUIv2.this, localLinearLayout.getHeight());
        int j = (k - com.tencent.mm.ci.a.fromDPToPix(MallIndexUIv2.this.getContext(), 8) * 3) / 2;
        LinearLayout localLinearLayout1 = (LinearLayout)MallIndexUIv2.this.zRq.findViewById(a.f.minh_wallet_layout);
        LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout1.getLayoutParams();
        int i = localLinearLayout1.getWidth();
        int m = localLinearLayout1.getHeight();
        if (i > j)
        {
          localLayoutParams1.width = j;
          i = j;
        }
        for (;;)
        {
          Log.i("MicorMsg.MallIndexUIv2", "headContentLayoutWidth:%s,itemLayoutMaxWidth ：%s,walletLayoutWidth:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
          LinearLayout localLinearLayout2 = (LinearLayout)MallIndexUIv2.this.zRq.findViewById(a.f.minh_pos_layout);
          LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams();
          localLayoutParams2.width = i;
          localLayoutParams2.height = m;
          i = (k - i * 2) / 3;
          localLayoutParams2.leftMargin = i;
          localLinearLayout2.setLayoutParams(localLayoutParams2);
          localLayoutParams1.rightMargin = i;
          localLinearLayout1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(197283);
          return;
        }
      }
    });
    AppMethodBeat.o(212055);
  }
  
  protected final int eQN()
  {
    return this.ERR;
  }
  
  protected final void eQy()
  {
    AppMethodBeat.i(212069);
    setMMTitle(a.i.mall_index_ui_title);
    AppMethodBeat.o(212069);
  }
  
  protected final void eQz()
  {
    AppMethodBeat.i(212048);
    com.tencent.mm.plugin.mall.b.a.eRc();
    AppMethodBeat.o(212048);
  }
  
  public void finish()
  {
    AppMethodBeat.i(212049);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(212049);
  }
  
  protected final void fo(View paramView)
  {
    AppMethodBeat.i(212018);
    this.ERP = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.fiO().h(this.ERP);
    this.ERQ = new c(this, paramView);
    this.ERQ.eQX();
    com.tencent.mm.plugin.newtips.a.fiO().h(this.ERQ);
    AppMethodBeat.o(212018);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(212010);
    this.zRq = ad.kS(this).inflate(a.g.mall_index_new_header_stub_v2, null);
    this.EQx.addHeaderView(this.zRq, null, false);
    eQM();
    AppMethodBeat.o(212010);
  }
  
  public void initView()
  {
    AppMethodBeat.i(212007);
    super.initView();
    this.EQx.setPadding(a.EPg, 0, a.EPg, 0);
    AppMethodBeat.o(212007);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(212062);
    Log.i("MicorMsg.MallIndexUIv2", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.ERr.eQT();
        AppMethodBeat.o(212062);
        return;
      }
      this.ERr.cancel();
      AppMethodBeat.o(212062);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.h.aHH();
      if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvq, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(212062);
      return;
    }
    if (paramInt1 == 6)
    {
      if ((paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
      {
        finish();
        paramIntent = new te();
        paramIntent.fSz.context = getContext();
        EventCenter.instance.publish(paramIntent);
        AppMethodBeat.o(212062);
      }
    }
    else if ((paramInt1 == 65281) && (paramInt2 == -1))
    {
      if (z.bdr())
      {
        finish();
        AppMethodBeat.o(212062);
        return;
      }
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(212062);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212003);
    fixStatusbar(true);
    if (26 != Build.VERSION.SDK_INT) {
      setRequestedOrientation(1);
    }
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.e.h.ZvG.e(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226335);
        com.tencent.mm.plugin.wallet_core.model.k.amw(2);
        AppMethodBeat.o(226335);
      }
    }, "wxpay_mallindex_refresh_location");
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
        return MallIndexUIv2.this;
      }
    };
    e.eQZ();
    a.k(this);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.ERB);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.az.b.WF((String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null)))
    {
      com.tencent.mm.kernel.h.aHH();
      a(new d((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvr, "")));
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(212003);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(212046);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    this.ERz.dead();
    this.ERC.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    EventCenter.instance.removeListener(this.ERB);
    AppMethodBeat.o(212046);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(212023);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicorMsg.MallIndexUIv2", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        eQH();
      }
    }
    AppMethodBeat.o(212023);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(212044);
    super.onPause();
    this.ERr.onPause();
    if (this.ERx != null) {
      this.ERx.reset();
    }
    AppMethodBeat.o(212044);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(212042);
    Log.v("MicorMsg.MallIndexUIv2", "alvinluo MallIndexUI onResume");
    this.ERr.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.gNk(), null);
    super.onResume();
    eQH();
    AppMethodBeat.o(212042);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(212051);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramq instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramq).EOC);
    }
    do
    {
      do
      {
        AppMethodBeat.o(212051);
        return true;
      } while (!(paramq instanceof ae));
      paramString = (ae)paramq;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void eOt() {}
    })));
    AppMethodBeat.o(212051);
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
    extends MallIndexUIv2.a
  {
    private LinearLayout ERK;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void fo(View paramView)
    {
      AppMethodBeat.i(257320);
      this.ERK = ((LinearLayout)paramView.findViewById(a.f.minh_pos_layout));
      this.ERJ = ((ImageView)this.ERK.findViewById(a.f.minh_pos_reddot_iv));
      this.sJm = ((TextView)this.ERK.findViewById(a.f.minh_pos_unread_tv));
      this.ERK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(268346);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.plugin.newtips.a.fiO().aap(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.by.c.b(MallIndexUIv2.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.ny(9, 0);
          com.tencent.mm.plugin.report.service.h.IzE.a(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.h.IzE.a(14419, new Object[] { MallIndexUIv2.this.uuid, Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268346);
        }
      });
      AppMethodBeat.o(257320);
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
    extends MallIndexUIv2.a
  {
    private LinearLayout ERM;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean eQX()
    {
      AppMethodBeat.i(264364);
      com.tencent.mm.kernel.h.aHH();
      boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vtn, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.h.aHH();
      long l = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vto, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        Log.i("MicorMsg.MallIndexUIv2", "hasRedDot expire, ignore reddot");
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
          AppMethodBeat.o(264364);
          return true;
          this.ERJ.setVisibility(8);
        }
      }
    }
    
    public final void fo(View paramView)
    {
      AppMethodBeat.i(264363);
      this.ERM = ((LinearLayout)paramView.findViewById(a.f.minh_wallet_layout));
      MallIndexUIv2.this.EQB = ((TextView)this.ERM.findViewById(a.f.wallet_bottom_text_tv));
      MallIndexUIv2.a(MallIndexUIv2.this, (WcPayMoneyLoadingView)this.ERM.findViewById(a.f.wallet_bottom_text_view));
      MallIndexUIv2.a(MallIndexUIv2.this, (ProgressBar)this.ERM.findViewById(a.f.wallet_money_load_pb));
      MallIndexUIv2.a(MallIndexUIv2.this, (RelativeLayout)this.ERM.findViewById(a.f.wallet_bottom_text_layout));
      MallIndexUIv2.this.getLifecycle().a(MallIndexUIv2.d(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setLoadingPb(MallIndexUIv2.e(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setPrefixSymbol("¥");
      MallIndexUIv2.d(MallIndexUIv2.this).setTextColor(-1);
      MallIndexUIv2.d(MallIndexUIv2.this).setTextSize(com.tencent.mm.ci.a.fromDPToPix(MallIndexUIv2.this.getContext(), 15));
      this.ERJ = ((ImageView)this.ERM.findViewById(a.f.minh_wallet_reddot_iv));
      this.sJm = ((TextView)this.ERM.findViewById(a.f.minh_wallet_unread_tv));
      this.ERM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(212625);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          MallIndexUIv2.c(MallIndexUIv2.this);
          com.tencent.mm.plugin.newtips.a.fiO().aap(15);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212625);
        }
      });
      AppMethodBeat.o(264363);
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
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2
 * JD-Core Version:    0.7.0.1
 */