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
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.b;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.a.yk.b;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.g.a.zn;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.i
public class MallIndexUI
  extends MallIndexBaseUI
  implements n.b
{
  private String dNj;
  private boolean gGM;
  private View oaY;
  private yk.b vFN;
  private RelativeLayout vFO;
  private boolean vFP;
  private boolean vFQ;
  com.tencent.mm.plugin.wallet_core.ui.u vFR;
  private boolean vFS;
  private Dialog vFT;
  private boolean vFU;
  private b vFV;
  private c vFW;
  private WcPayMoneyLoadingView vFX;
  private ProgressBar vFY;
  private com.tencent.mm.sdk.b.c<oc> vFZ;
  private TextView vFx;
  private boolean vFy;
  private boolean vGa;
  private com.tencent.mm.sdk.b.c vGb;
  private com.tencent.mm.sdk.b.c<zn> vGc;
  private boolean vGd;
  private boolean vGe;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(66117);
    this.gGM = false;
    this.vFR = new com.tencent.mm.plugin.wallet_core.ui.u();
    this.oaY = null;
    this.vFy = false;
    this.vFx = null;
    this.vFS = false;
    this.vFU = false;
    this.vFV = null;
    this.vFW = null;
    this.vFZ = new com.tencent.mm.sdk.b.c() {};
    this.vGa = false;
    this.vGb = new com.tencent.mm.sdk.b.c() {};
    this.vGc = new MallIndexUI.8(this);
    this.vGd = false;
    this.vGe = false;
    AppMethodBeat.o(66117);
  }
  
  private void a(com.tencent.mm.plugin.mall.a.d paramd)
  {
    AppMethodBeat.i(66141);
    if ((paramd == null) || (bt.isNullOrNil(paramd.vDd)))
    {
      AppMethodBeat.o(66141);
      return;
    }
    if (this.vFy)
    {
      if (this.vFx != null)
      {
        this.vFx.setText(2131761087);
        this.vFx.setOnClickListener(new MallIndexUI.5(this, paramd));
      }
      AppMethodBeat.o(66141);
      return;
    }
    this.oaY = View.inflate(this, 2131494695, null);
    this.oaY.setClickable(false);
    this.oaY.setEnabled(false);
    this.vFx = ((TextView)this.oaY.findViewById(2131306829));
    this.vFx.setVisibility(0);
    this.vFx.setText(2131761087);
    this.vFx.setTextColor(getResources().getColor(2131100547));
    this.vFx.setOnClickListener(new MallIndexUI.6(this, paramd));
    if (this.vEX != null)
    {
      this.vEX.addFooterView(this.oaY);
      this.vFy = true;
    }
    AppMethodBeat.o(66141);
  }
  
  private void ok(boolean paramBoolean)
  {
    AppMethodBeat.i(66132);
    if (paramBoolean)
    {
      this.vFb.setText(getString(2131765298));
      this.vFb.setVisibility(0);
      this.vFX.setVisibility(8);
      this.vFY.setVisibility(8);
      this.vFX.reset();
      AppMethodBeat.o(66132);
      return;
    }
    this.vFb.setVisibility(8);
    this.vFX.setVisibility(0);
    this.vFY.setVisibility(0);
    AppMethodBeat.o(66132);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(66126);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        dkq();
      }
    }
    AppMethodBeat.o(66126);
  }
  
  protected final void dcd()
  {
    AppMethodBeat.i(66120);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66120);
  }
  
  protected final void dkh()
  {
    AppMethodBeat.i(66121);
    setMMTitle(2131761092);
    AppMethodBeat.o(66121);
  }
  
  protected final void dki()
  {
    AppMethodBeat.i(66137);
    com.tencent.mm.plugin.mall.b.a.dkJ();
    AppMethodBeat.o(66137);
  }
  
  protected final void dkj()
  {
    AppMethodBeat.i(66138);
    t.eFt().eHg();
    if (((t.eFt().eHg().eGd()) || (t.eFt().eHg().eGc())) && (com.tencent.mm.model.u.aAB()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(66138);
  }
  
  protected final boolean dkk()
  {
    AppMethodBeat.i(66128);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "init BankcardList");
    final yk localyk = new yk();
    localyk.dMG.scene = 1;
    localyk.dMG.dMI = true;
    localyk.dMG.retryCount = 0;
    localyk.dMG.dMJ = true;
    localyk.dMH.dMy = new Runnable()
    {
      boolean hOP = false;
      
      public final void run()
      {
        AppMethodBeat.i(66111);
        if ((MallIndexUI.this.isFinishing()) || (MallIndexUI.this.hasFinish()) || (MallIndexUI.this.isDestroyed()))
        {
          AppMethodBeat.o(66111);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.g(MallIndexUI.this).dML + " hasNewTips : " + MallIndexUI.g(MallIndexUI.this).dMM + " swipeOn : " + MallIndexUI.g(MallIndexUI.this).dMN);
        if ((MallIndexUI.h(MallIndexUI.this)) || (MallIndexUI.this.getContext().isFinishing()))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexUI", "error for callback ac finish");
          AppMethodBeat.o(66111);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localyk.dMH.dNl), Boolean.valueOf(this.hOP) });
        MallIndexUI.a(MallIndexUI.this, localyk.dMH);
        int i;
        Object localObject;
        boolean bool;
        if (MallIndexUI.g(MallIndexUI.this).dNm != null)
        {
          i = 1;
          if ((i & MallIndexUI.g(MallIndexUI.this).dNm instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUI.g(MallIndexUI.this).dNm;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject).getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void djA() {}
              });
            }
          }
          if (MallIndexUI.g(MallIndexUI.this).errCode == 0)
          {
            MallIndexUI.this.dku();
            if (MallIndexUI.g(MallIndexUI.this).dNl) {
              MallIndexUI.this.dkq();
            }
            MallIndexUI.this.dkl();
            if (!this.hOP) {
              MallIndexUI.dkz();
            }
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this));
            MallIndexUI.this.dks();
            com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.g(MallIndexUI.this).dNh), Boolean.valueOf(MallIndexUI.g(MallIndexUI.this).dNi), MallIndexUI.g(MallIndexUI.this).dNj });
            localObject = MallIndexUI.this;
            if (MallIndexUI.g(MallIndexUI.this).dNh != 1) {
              break label575;
            }
            bool = true;
            label425:
            MallIndexUI.a((MallIndexUI)localObject, bool);
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dNi);
            MallIndexUI.a(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dNj);
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
          ((MallIndexUI)localObject).vFR.a(new MallIndexUI.2((MallIndexUI)localObject), localal.eFY());
          if ((localyk.dMH.dNl) && (this.hOP)) {
            MallIndexUI.this.updateView();
          }
          this.hOP = true;
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
    com.tencent.mm.sdk.b.a.IbL.a(localyk, Looper.myLooper());
    AppMethodBeat.o(66128);
    return false;
  }
  
  protected final void dkl()
  {
    AppMethodBeat.i(66129);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
    boolean bool2;
    Object localObject;
    if ((this.vFN != null) && ((this.vFN.dMK) || (this.vFN.dMQ)))
    {
      bool2 = t.eFy().eGi().eFS();
      localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iuc, Boolean.FALSE);
      if (localObject == null) {
        break label160;
      }
    }
    label160:
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iuc, Boolean.TRUE);
        o.gM(this);
      }
      AppMethodBeat.o(66129);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
      AppMethodBeat.o(66129);
      return;
    }
  }
  
  protected final void dko()
  {
    AppMethodBeat.i(66124);
    this.vFf = com.tencent.mm.plugin.mall.a.k.dka().JC(this.vDk).field_isShowSetting;
    if (this.vFg == null)
    {
      this.vFg = com.tencent.mm.ui.z.jO(this).inflate(2131494698, null);
      this.vEX.addFooterView(this.vFg, null, false);
      TextView localTextView = (TextView)this.vFg.findViewById(2131302290);
      com.tencent.mm.wallet_core.ui.e.aW(localTextView, 100);
      localTextView.setOnClickListener(new MallIndexUI.10(this));
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.vFf) });
    if (this.vFf == 0)
    {
      this.vFg.setVisibility(8);
      this.vFg.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(66124);
      return;
    }
    this.vFg.setVisibility(0);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66108);
        int k = com.tencent.mm.cc.a.iq(MallIndexUI.this.getContext());
        int n = com.tencent.mm.cc.a.fromDPToPix(MallIndexUI.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUI.this.vEX.getLocationInWindow(arrayOfInt);
        int m = MallIndexUI.this.vFg.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUI.this.vEX.getHeight() - MallIndexUI.this.vFg.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cc.a.fromDPToPix(MallIndexUI.this.getContext(), 33);
        com.tencent.mm.sdk.platformtools.ad.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUI.this.vFg.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUI.this.vFg.setPadding(0, j, 0, n);
          AppMethodBeat.o(66108);
          return;
        }
        MallIndexUI.this.vFg.setPadding(0, n, 0, n);
        AppMethodBeat.o(66108);
      }
    });
    AppMethodBeat.o(66124);
  }
  
  protected final void dkp()
  {
    AppMethodBeat.i(66127);
    final yi localyi = new yi();
    localyi.dMB.scene = "1";
    localyi.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66109);
        if (!bt.isNullOrNil(localyi.dMC.dMD)) {
          com.tencent.mm.wallet_core.ui.e.a(MallIndexUI.this.vFc, localyi.dMC.dMD, localyi.dMC.content, localyi.dMC.url);
        }
        AppMethodBeat.o(66109);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l(localyi);
    AppMethodBeat.o(66127);
  }
  
  protected final void dkq()
  {
    AppMethodBeat.i(66131);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new al();
    if (((al)localObject).eFV())
    {
      localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iva, getString(2131762204));
      this.vFb.setText((CharSequence)localObject);
      this.vFb.setVisibility(0);
      this.vFX.setVisibility(8);
      this.vFY.setVisibility(8);
      AppMethodBeat.o(66131);
      return;
    }
    if (((al)localObject).eFX())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICH, Long.valueOf(0L))).longValue();
      if (this.vFX != null)
      {
        ok(((al)localObject).eFZ());
        if (this.vFX.getVisibility() == 0)
        {
          this.vFX.setMoney(com.tencent.mm.wallet_core.ui.e.C(com.tencent.mm.wallet_core.ui.e.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(66131);
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicorMsg.MallIndexUI", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(66131);
  }
  
  protected final void dks()
  {
    AppMethodBeat.i(66133);
    removeAllOptionMenu();
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690603, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66101);
        com.tencent.mm.plugin.report.service.g.yhR.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        com.tencent.mm.plugin.report.service.g.yhR.f(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUI.this;
        boolean bool = MallIndexUI.g(MallIndexUI.this).dMR;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.bs.d.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(66101);
        return true;
      }
    });
    com.tencent.mm.plugin.report.service.g.yhR.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(66133);
  }
  
  protected final void dku()
  {
    AppMethodBeat.i(66130);
    if (this.vFa == null)
    {
      AppMethodBeat.o(66130);
      return;
    }
    if ((!com.tencent.mm.z.c.aht().b(al.a.IAD, al.a.IAE)) && (!this.vFN.dMM))
    {
      com.tencent.mm.plugin.wallet_core.model.n localn = t.eFy().DaX;
      if (localn == null) {
        break label132;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.g.ajD();
      if ((((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Itx, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.vFa.setVisibility(0);
      AppMethodBeat.o(66130);
      return;
      label124:
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.vFa.setVisibility(8);
    AppMethodBeat.o(66130);
  }
  
  protected final void es(View paramView)
  {
    AppMethodBeat.i(66125);
    this.vFV = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.dun().h(this.vFV);
    this.vFW = new c(this, paramView);
    this.vFW.dkE();
    com.tencent.mm.plugin.newtips.a.dun().h(this.vFW);
    AppMethodBeat.o(66125);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66139);
    this.gGM = true;
    super.finish();
    AppMethodBeat.o(66139);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66123);
    this.rXv = com.tencent.mm.ui.z.jO(this).inflate(2131494697, null);
    this.vEX.addHeaderView(this.rXv, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.rXv.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.dkc();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66123);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66122);
    super.initView();
    this.vEX.setPadding(a.vDH, 0, a.vDH, 0);
    AppMethodBeat.o(66122);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66118);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.vFR.dkA();
        AppMethodBeat.o(66118);
        return;
      }
      this.vFR.cancel();
      AppMethodBeat.o(66118);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.ajD();
      if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEd, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(66118);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new rg();
      paramIntent.dFQ.context = getContext();
      com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
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
    com.tencent.mm.plugin.wallet_core.model.k.Vy(2);
    this.vFN = new yk.b();
    this.vFN.dMK = false;
    this.vFN.dML = true;
    this.vFN.dMM = false;
    this.vFZ.alive();
    this.vGc.alive();
    this.vFR.Dka = new u.b()
    {
      public final int dkC()
      {
        return 3;
      }
      
      public final Context getContext()
      {
        return MallIndexUI.this;
      }
    };
    e.dkG();
    a.c(this, true);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.IbL.c(this.vGb);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
    {
      com.tencent.mm.kernel.g.ajD();
      a(new com.tencent.mm.plugin.mall.a.d((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEe, "")));
      com.tencent.mm.kernel.g.ajD();
      ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEd, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(66119);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66136);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    this.vFZ.dead();
    this.vGc.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    com.tencent.mm.sdk.b.a.IbL.d(this.vGb);
    AppMethodBeat.o(66136);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66135);
    super.onPause();
    this.vFR.onPause();
    if (this.vFX != null) {
      this.vFX.reset();
    }
    AppMethodBeat.o(66135);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66134);
    com.tencent.mm.sdk.platformtools.ad.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.vFR.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.eJn(), null);
    super.onResume();
    dkq();
    AppMethodBeat.o(66134);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(66140);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramn).vDe);
    }
    do
    {
      do
      {
        AppMethodBeat.o(66140);
        return true;
      } while (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad));
      paramString = (com.tencent.mm.plugin.wallet_core.c.ad)paramn;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void djA() {}
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
    private LinearLayout vGl;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(66113);
      this.vGl = ((LinearLayout)paramView.findViewById(2131302280));
      this.vGj = ((ImageView)this.vGl.findViewById(2131302281));
      this.vGk = ((TextView)this.vGl.findViewById(2131302282));
      this.vGl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.newtips.a.dun().LQ(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.bs.d.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.kB(9, 0);
          com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.g.yhR.f(14419, new Object[] { MallIndexUI.this.uuid, Integer.valueOf(1) });
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
      return this.vGl;
    }
  }
  
  final class c
    extends MallIndexUI.a
  {
    private LinearLayout vGn;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean dkE()
    {
      AppMethodBeat.i(66116);
      com.tencent.mm.kernel.g.ajD();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICk, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.ajD();
      long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICl, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICk, Boolean.FALSE);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICl, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          this.vGj.setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.wsL, bool);
          AppMethodBeat.o(66116);
          return true;
          this.vGj.setVisibility(8);
        }
      }
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(66115);
      this.vGn = ((LinearLayout)paramView.findViewById(2131302284));
      MallIndexUI.this.vFb = ((TextView)this.vGn.findViewById(2131306696));
      MallIndexUI.a(MallIndexUI.this, (WcPayMoneyLoadingView)this.vGn.findViewById(2131306697));
      MallIndexUI.a(MallIndexUI.this, (ProgressBar)this.vGn.findViewById(2131306757));
      MallIndexUI.this.getLifecycle().addObserver(MallIndexUI.d(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setLoadingPb(MallIndexUI.e(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setPrefixSymbol("¥");
      MallIndexUI.d(MallIndexUI.this).setTextColor(-1);
      MallIndexUI.d(MallIndexUI.this).setTextSize(com.tencent.mm.cc.a.fromDPToPix(MallIndexUI.this.getContext(), 15));
      this.vGj = ((ImageView)this.vGn.findViewById(2131302285));
      this.vGk = ((TextView)this.vGn.findViewById(2131302286));
      this.vGn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66114);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          MallIndexUI.c(MallIndexUI.this);
          com.tencent.mm.plugin.newtips.a.dun().LQ(15);
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
      return this.vGn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */