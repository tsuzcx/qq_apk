package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.g.a.od;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yo.b;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.a.yq.b;
import com.tencent.mm.g.a.zc;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.i
public class MallIndexUI
  extends MallIndexBaseUI
  implements n.b
{
  private String dOz;
  private boolean gJv;
  private View ogP;
  private TextView vRB;
  private boolean vRC;
  private yq.b vRR;
  private RelativeLayout vRS;
  private boolean vRT;
  private boolean vRU;
  u vRV;
  private boolean vRW;
  private Dialog vRX;
  private boolean vRY;
  private b vRZ;
  private c vSa;
  private WcPayMoneyLoadingView vSb;
  private ProgressBar vSc;
  private com.tencent.mm.sdk.b.c<od> vSd;
  private boolean vSe;
  private com.tencent.mm.sdk.b.c vSf;
  private com.tencent.mm.sdk.b.c<zt> vSg;
  private boolean vSh;
  private boolean vSi;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(66117);
    this.gJv = false;
    this.vRV = new u();
    this.ogP = null;
    this.vRC = false;
    this.vRB = null;
    this.vRW = false;
    this.vRY = false;
    this.vRZ = null;
    this.vSa = null;
    this.vSd = new com.tencent.mm.sdk.b.c() {};
    this.vSe = false;
    this.vSf = new com.tencent.mm.sdk.b.c() {};
    this.vSg = new MallIndexUI.8(this);
    this.vSh = false;
    this.vSi = false;
    AppMethodBeat.o(66117);
  }
  
  private void a(final com.tencent.mm.plugin.mall.a.d paramd)
  {
    AppMethodBeat.i(66141);
    if ((paramd == null) || (bu.isNullOrNil(paramd.vPh)))
    {
      AppMethodBeat.o(66141);
      return;
    }
    if (this.vRC)
    {
      if (this.vRB != null)
      {
        this.vRB.setText(2131761087);
        this.vRB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66102);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            new Intent();
            f.cu(MallIndexUI.this, paramd.vPh);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66102);
          }
        });
      }
      AppMethodBeat.o(66141);
      return;
    }
    this.ogP = View.inflate(this, 2131494695, null);
    this.ogP.setClickable(false);
    this.ogP.setEnabled(false);
    this.vRB = ((TextView)this.ogP.findViewById(2131306829));
    this.vRB.setVisibility(0);
    this.vRB.setText(2131761087);
    this.vRB.setTextColor(getResources().getColor(2131100547));
    this.vRB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66103);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.aY(MallIndexUI.this.getContext(), paramd.vPh);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(66103);
      }
    });
    if (this.vRb != null)
    {
      this.vRb.addFooterView(this.ogP);
      this.vRC = true;
    }
    AppMethodBeat.o(66141);
  }
  
  private void op(boolean paramBoolean)
  {
    AppMethodBeat.i(66132);
    if (paramBoolean)
    {
      this.vRf.setText(getString(2131765298));
      this.vRf.setVisibility(0);
      this.vSb.setVisibility(8);
      this.vSc.setVisibility(8);
      this.vSb.reset();
      AppMethodBeat.o(66132);
      return;
    }
    this.vRf.setVisibility(8);
    this.vSb.setVisibility(0);
    this.vSc.setVisibility(0);
    AppMethodBeat.o(66132);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(66126);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      ae.i("MicorMsg.MallIndexUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        dnp();
      }
    }
    AppMethodBeat.o(66126);
  }
  
  protected final void deV()
  {
    AppMethodBeat.i(66120);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66120);
  }
  
  protected final void dng()
  {
    AppMethodBeat.i(66121);
    setMMTitle(2131761092);
    AppMethodBeat.o(66121);
  }
  
  protected final void dnh()
  {
    AppMethodBeat.i(66137);
    com.tencent.mm.plugin.mall.b.a.dnJ();
    AppMethodBeat.o(66137);
  }
  
  protected final void dni()
  {
    AppMethodBeat.i(66138);
    t.eJa().eKO();
    if (((t.eJa().eKO().eJK()) || (t.eJa().eKO().eJJ())) && (v.aAR()))
    {
      ae.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(66138);
  }
  
  protected final boolean dnj()
  {
    AppMethodBeat.i(66128);
    ae.i("MicorMsg.MallIndexUI", "init BankcardList");
    final yq localyq = new yq();
    localyq.dNW.scene = 1;
    localyq.dNW.dNY = true;
    localyq.dNW.retryCount = 0;
    localyq.dNW.dNZ = true;
    localyq.dNX.dNO = new Runnable()
    {
      boolean hRI = false;
      
      public final void run()
      {
        AppMethodBeat.i(66111);
        if ((MallIndexUI.this.isFinishing()) || (MallIndexUI.this.hasFinish()) || (MallIndexUI.this.isDestroyed()))
        {
          AppMethodBeat.o(66111);
          return;
        }
        ae.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.g(MallIndexUI.this).dOb + " hasNewTips : " + MallIndexUI.g(MallIndexUI.this).dOc + " swipeOn : " + MallIndexUI.g(MallIndexUI.this).dOd);
        if ((MallIndexUI.h(MallIndexUI.this)) || (MallIndexUI.this.getContext().isFinishing()))
        {
          ae.e("MicorMsg.MallIndexUI", "error for callback ac finish");
          AppMethodBeat.o(66111);
          return;
        }
        ae.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localyq.dNX.dOB), Boolean.valueOf(this.hRI) });
        MallIndexUI.a(MallIndexUI.this, localyq.dNX);
        int i;
        Object localObject;
        boolean bool;
        if (MallIndexUI.g(MallIndexUI.this).dOC != null)
        {
          i = 1;
          if ((i & MallIndexUI.g(MallIndexUI.this).dOC instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUI.g(MallIndexUI.this).dOC;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject).getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void dmz() {}
              });
            }
          }
          if (MallIndexUI.g(MallIndexUI.this).errCode == 0)
          {
            MallIndexUI.this.dnt();
            if (MallIndexUI.g(MallIndexUI.this).dOB) {
              MallIndexUI.this.dnp();
            }
            MallIndexUI.this.dnk();
            if (!this.hRI) {
              MallIndexUI.dnz();
            }
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this));
            MallIndexUI.this.dnr();
            ae.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.g(MallIndexUI.this).dOx), Boolean.valueOf(MallIndexUI.g(MallIndexUI.this).dOy), MallIndexUI.g(MallIndexUI.this).dOz });
            localObject = MallIndexUI.this;
            if (MallIndexUI.g(MallIndexUI.this).dOx != 1) {
              break label575;
            }
            bool = true;
            label425:
            MallIndexUI.a((MallIndexUI)localObject, bool);
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dOy);
            MallIndexUI.a(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dOz);
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
          al localal = new al();
          ((MallIndexUI)localObject).vRV.a(new MallIndexUI.2((MallIndexUI)localObject), localal.eJF());
          if ((localyq.dNX.dOB) && (this.hRI)) {
            MallIndexUI.this.updateView();
          }
          this.hRI = true;
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
    com.tencent.mm.sdk.b.a.IvT.a(localyq, Looper.myLooper());
    AppMethodBeat.o(66128);
    return false;
  }
  
  protected final void dnk()
  {
    AppMethodBeat.i(66129);
    ae.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
    boolean bool2;
    Object localObject;
    if ((this.vRR != null) && ((this.vRR.dOa) || (this.vRR.dOg)))
    {
      bool2 = t.eJf().eJP().eJz();
      localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IOz, Boolean.FALSE);
      if (localObject == null) {
        break label160;
      }
    }
    label160:
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      ae.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IOz, Boolean.TRUE);
        o.gR(this);
      }
      AppMethodBeat.o(66129);
      return;
      ae.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
      AppMethodBeat.o(66129);
      return;
    }
  }
  
  protected final void dnn()
  {
    AppMethodBeat.i(66124);
    this.vRj = com.tencent.mm.plugin.mall.a.k.dmZ().Kb(this.vPo).field_isShowSetting;
    if (this.vRk == null)
    {
      this.vRk = com.tencent.mm.ui.z.jV(this).inflate(2131494698, null);
      this.vRb.addFooterView(this.vRk, null, false);
      TextView localTextView = (TextView)this.vRk.findViewById(2131302290);
      f.aW(localTextView, 100);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66107);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicorMsg.MallIndexUI", "click settings btn");
          com.tencent.mm.br.d.Q(MallIndexUI.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66107);
        }
      });
    }
    ae.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.vRj) });
    if (this.vRj == 0)
    {
      this.vRk.setVisibility(8);
      this.vRk.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(66124);
      return;
    }
    this.vRk.setVisibility(0);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66108);
        int k = com.tencent.mm.cb.a.iv(MallIndexUI.this.getContext());
        int n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUI.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUI.this.vRb.getLocationInWindow(arrayOfInt);
        int m = MallIndexUI.this.vRk.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUI.this.vRb.getHeight() - MallIndexUI.this.vRk.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUI.this.getContext(), 33);
        ae.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUI.this.vRk.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUI.this.vRk.setPadding(0, j, 0, n);
          AppMethodBeat.o(66108);
          return;
        }
        MallIndexUI.this.vRk.setPadding(0, n, 0, n);
        AppMethodBeat.o(66108);
      }
    });
    AppMethodBeat.o(66124);
  }
  
  protected final void dno()
  {
    AppMethodBeat.i(66127);
    final yo localyo = new yo();
    localyo.dNR.scene = "1";
    localyo.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66109);
        if (!bu.isNullOrNil(localyo.dNS.dNT)) {
          f.a(MallIndexUI.this.vRg, localyo.dNS.dNT, localyo.dNS.content, localyo.dNS.url);
        }
        AppMethodBeat.o(66109);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l(localyo);
    AppMethodBeat.o(66127);
  }
  
  protected final void dnp()
  {
    AppMethodBeat.i(66131);
    ae.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new al();
    if (((al)localObject).eJC())
    {
      localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPy, getString(2131762204));
      this.vRf.setText((CharSequence)localObject);
      this.vRf.setVisibility(0);
      this.vSb.setVisibility(8);
      this.vSc.setVisibility(8);
      AppMethodBeat.o(66131);
      return;
    }
    if (((al)localObject).eJE())
    {
      ae.i("MicorMsg.MallIndexUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXh, Long.valueOf(0L))).longValue();
      if (this.vSb != null)
      {
        op(((al)localObject).eJG());
        if (this.vSb.getVisibility() == 0)
        {
          this.vSb.setMoney(f.C(f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(66131);
        }
      }
      else
      {
        ae.w("MicorMsg.MallIndexUI", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(66131);
  }
  
  protected final void dnr()
  {
    AppMethodBeat.i(66133);
    removeAllOptionMenu();
    ae.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690603, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66101);
        com.tencent.mm.plugin.report.service.g.yxI.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        com.tencent.mm.plugin.report.service.g.yxI.f(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUI.this;
        boolean bool = MallIndexUI.g(MallIndexUI.this).dOh;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.br.d.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(66101);
        return true;
      }
    });
    com.tencent.mm.plugin.report.service.g.yxI.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(66133);
  }
  
  protected final void dnt()
  {
    AppMethodBeat.i(66130);
    if (this.vRe == null)
    {
      AppMethodBeat.o(66130);
      return;
    }
    if ((!com.tencent.mm.y.c.ahI().b(am.a.IVc, am.a.IVd)) && (!this.vRR.dOc))
    {
      com.tencent.mm.plugin.wallet_core.model.n localn = t.eJf().DsB;
      if (localn == null) {
        break label132;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.g.ajS();
      if ((((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.INU, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      ae.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.vRe.setVisibility(0);
      AppMethodBeat.o(66130);
      return;
      label124:
      ae.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.vRe.setVisibility(8);
    AppMethodBeat.o(66130);
  }
  
  protected final void es(View paramView)
  {
    AppMethodBeat.i(66125);
    this.vRZ = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.dxD().h(this.vRZ);
    this.vSa = new c(this, paramView);
    this.vSa.dnE();
    com.tencent.mm.plugin.newtips.a.dxD().h(this.vSa);
    AppMethodBeat.o(66125);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66139);
    this.gJv = true;
    super.finish();
    AppMethodBeat.o(66139);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66123);
    this.sgg = com.tencent.mm.ui.z.jV(this).inflate(2131494697, null);
    this.vRb.addHeaderView(this.sgg, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.sgg.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.dnb();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66123);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66122);
    super.initView();
    this.vRb.setPadding(a.vPL, 0, a.vPL, 0);
    AppMethodBeat.o(66122);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66118);
    ae.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.vRV.dnA();
        AppMethodBeat.o(66118);
        return;
      }
      this.vRV.cancel();
      AppMethodBeat.o(66118);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.ajS();
      if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYD, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(66118);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new rh();
      paramIntent.dGV.context = getContext();
      com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
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
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().a(this);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.mm.plugin.wallet_core.model.k.Wf(2);
    this.vRR = new yq.b();
    this.vRR.dOa = false;
    this.vRR.dOb = true;
    this.vRR.dOc = false;
    this.vSd.alive();
    this.vSg.alive();
    this.vRV.DBE = new u.b()
    {
      public final int dnC()
      {
        return 3;
      }
      
      public final Context getContext()
      {
        return MallIndexUI.this;
      }
    };
    e.dnG();
    a.c(this, true);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.IvT.c(this.vSf);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
    {
      com.tencent.mm.kernel.g.ajS();
      a(new com.tencent.mm.plugin.mall.a.d((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYE, "")));
      com.tencent.mm.kernel.g.ajS();
      ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYD, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(66119);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66136);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    this.vSd.dead();
    this.vSg.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    com.tencent.mm.sdk.b.a.IvT.d(this.vSf);
    AppMethodBeat.o(66136);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66135);
    super.onPause();
    this.vRV.onPause();
    if (this.vSb != null) {
      this.vSb.reset();
    }
    AppMethodBeat.o(66135);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66134);
    ae.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.vRV.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.eMV(), null);
    super.onResume();
    dnp();
    AppMethodBeat.o(66134);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(66140);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramn).vPi);
    }
    do
    {
      do
      {
        AppMethodBeat.o(66140);
        return true;
      } while (!(paramn instanceof ad));
      paramString = (ad)paramn;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void dmz() {}
    })));
    AppMethodBeat.o(66140);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
    extends MallIndexUI.a
  {
    private LinearLayout vSp;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(66113);
      this.vSp = ((LinearLayout)paramView.findViewById(2131302280));
      this.vSn = ((ImageView)this.vSp.findViewById(2131302281));
      this.vSo = ((TextView)this.vSp.findViewById(2131302282));
      this.vSp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.newtips.a.dxD().Mv(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.br.d.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.kI(9, 0);
          com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.g.yxI.f(14419, new Object[] { MallIndexUI.this.uuid, Integer.valueOf(1) });
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
      return this.vSp;
    }
  }
  
  final class c
    extends MallIndexUI.a
  {
    private LinearLayout vSr;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean dnE()
    {
      AppMethodBeat.i(66116);
      com.tencent.mm.kernel.g.ajS();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWJ, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.ajS();
      long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWK, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        ae.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWJ, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWK, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          this.vSn.setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wIv, bool);
          AppMethodBeat.o(66116);
          return true;
          this.vSn.setVisibility(8);
        }
      }
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(66115);
      this.vSr = ((LinearLayout)paramView.findViewById(2131302284));
      MallIndexUI.this.vRf = ((TextView)this.vSr.findViewById(2131306696));
      MallIndexUI.a(MallIndexUI.this, (WcPayMoneyLoadingView)this.vSr.findViewById(2131306697));
      MallIndexUI.a(MallIndexUI.this, (ProgressBar)this.vSr.findViewById(2131306757));
      MallIndexUI.this.getLifecycle().addObserver(MallIndexUI.d(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setLoadingPb(MallIndexUI.e(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setPrefixSymbol("¥");
      MallIndexUI.d(MallIndexUI.this).setTextColor(-1);
      MallIndexUI.d(MallIndexUI.this).setTextSize(com.tencent.mm.cb.a.fromDPToPix(MallIndexUI.this.getContext(), 15));
      this.vSn = ((ImageView)this.vSr.findViewById(2131302285));
      this.vSo = ((TextView)this.vSr.findViewById(2131302286));
      this.vSr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66114);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          MallIndexUI.c(MallIndexUI.this);
          com.tencent.mm.plugin.newtips.a.dxD().Mv(15);
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
      return this.vSr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */