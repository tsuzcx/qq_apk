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
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.i
public class MallIndexUIv2
  extends MallIndexBaseUIv2
  implements n.b
{
  private String dNj;
  private boolean gGM;
  private View oaY;
  yk.b vFN;
  private RelativeLayout vFO;
  private boolean vFP;
  private boolean vFQ;
  u vFR;
  private boolean vFS;
  private Dialog vFT;
  private boolean vFU;
  private WcPayMoneyLoadingView vFX;
  private ProgressBar vFY;
  private com.tencent.mm.sdk.b.c<oc> vFZ;
  private TextView vFx;
  private boolean vFy;
  private boolean vGa;
  private com.tencent.mm.sdk.b.c vGb;
  private com.tencent.mm.sdk.b.c<zn> vGc;
  private boolean vGe;
  private b vGp;
  private c vGq;
  private int vGr;
  
  public MallIndexUIv2()
  {
    AppMethodBeat.i(199069);
    this.gGM = false;
    this.vFR = new u();
    this.oaY = null;
    this.vFy = false;
    this.vFx = null;
    this.vFS = false;
    this.vFU = false;
    this.vGp = null;
    this.vGq = null;
    this.vFZ = new com.tencent.mm.sdk.b.c() {};
    this.vGa = false;
    this.vGb = new com.tencent.mm.sdk.b.c() {};
    this.vGc = new MallIndexUIv2.9(this);
    this.vGe = false;
    AppMethodBeat.o(199069);
  }
  
  private void a(com.tencent.mm.plugin.mall.a.d paramd)
  {
    AppMethodBeat.i(199088);
    if ((paramd == null) || (bt.isNullOrNil(paramd.vDd)))
    {
      AppMethodBeat.o(199088);
      return;
    }
    if (this.vFy)
    {
      if (this.vFx != null)
      {
        this.vFx.setText(2131761087);
        this.vFx.setOnClickListener(new MallIndexUIv2.5(this, paramd));
      }
      AppMethodBeat.o(199088);
      return;
    }
    this.oaY = View.inflate(this, 2131494695, null);
    this.oaY.setClickable(false);
    this.oaY.setEnabled(false);
    this.vFx = ((TextView)this.oaY.findViewById(2131306829));
    this.vFx.setVisibility(0);
    this.vFx.setText(2131761087);
    this.vFx.setTextColor(getResources().getColor(2131100547));
    this.vFx.setOnClickListener(new MallIndexUIv2.6(this, paramd));
    if (this.vEX != null)
    {
      this.vEX.addFooterView(this.oaY);
      this.vFy = true;
    }
    AppMethodBeat.o(199088);
  }
  
  private void ok(boolean paramBoolean)
  {
    AppMethodBeat.i(199080);
    if (paramBoolean)
    {
      this.vFb.setText(getString(2131765298));
      this.vFb.setVisibility(0);
      this.vFX.setVisibility(8);
      this.vFY.setVisibility(8);
      this.vFX.reset();
      AppMethodBeat.o(199080);
      return;
    }
    this.vFb.setVisibility(8);
    this.vFX.setVisibility(0);
    this.vFY.setVisibility(0);
    AppMethodBeat.o(199080);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(199075);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        dkq();
      }
    }
    AppMethodBeat.o(199075);
  }
  
  protected final void dcd()
  {
    AppMethodBeat.i(199091);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(199091);
  }
  
  protected final void dkh()
  {
    AppMethodBeat.i(199092);
    setMMTitle(2131761092);
    AppMethodBeat.o(199092);
  }
  
  protected final void dki()
  {
    AppMethodBeat.i(199085);
    com.tencent.mm.plugin.mall.b.a.dkJ();
    AppMethodBeat.o(199085);
  }
  
  protected final boolean dkk()
  {
    AppMethodBeat.i(199077);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "init BankcardList");
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
        AppMethodBeat.i(199063);
        if ((MallIndexUIv2.this.isFinishing()) || (MallIndexUIv2.this.hasFinish()) || (MallIndexUIv2.this.isDestroyed()))
        {
          AppMethodBeat.o(199063);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicorMsg.MallIndexNewUI", "mUserInfo needBind : " + MallIndexUIv2.g(MallIndexUIv2.this).dML + " hasNewTips : " + MallIndexUIv2.g(MallIndexUIv2.this).dMM + " swipeOn : " + MallIndexUIv2.g(MallIndexUIv2.this).dMN);
        if ((MallIndexUIv2.h(MallIndexUIv2.this)) || (MallIndexUIv2.this.getContext().isFinishing()))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexNewUI", "error for callback ac finish");
          AppMethodBeat.o(199063);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localyk.dMH.dNl), Boolean.valueOf(this.hOP) });
        MallIndexUIv2.a(MallIndexUIv2.this, localyk.dMH);
        int i;
        Object localObject1;
        boolean bool2;
        Object localObject2;
        if (MallIndexUIv2.g(MallIndexUIv2.this).dNm != null)
        {
          i = 1;
          if ((i & MallIndexUIv2.g(MallIndexUIv2.this).dNm instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject1 = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUIv2.g(MallIndexUIv2.this).dNm;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).getJumpRemind().a(MallIndexUIv2.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void djA() {}
              });
            }
          }
          if (MallIndexUIv2.g(MallIndexUIv2.this).errCode == 0)
          {
            MallIndexUIv2.this.dku();
            if (MallIndexUIv2.g(MallIndexUIv2.this).dNl) {
              MallIndexUIv2.this.dkq();
            }
            localObject1 = MallIndexUIv2.this;
            com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "showGetNewWalletTip call");
            if ((((MallIndexUIv2)localObject1).vFN == null) || ((!((MallIndexUIv2)localObject1).vFN.dMK) && (!((MallIndexUIv2)localObject1).vFN.dMQ))) {
              break label718;
            }
            bool2 = t.eFy().eGi().eFS();
            localObject2 = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iuc, Boolean.FALSE);
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
          com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
          if ((!bool1) && (bool2))
          {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iuc, Boolean.TRUE);
            o.gM((Context)localObject1);
          }
          if (!this.hOP) {
            MallIndexUIv2.dkF();
          }
          MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this));
          MallIndexUIv2.this.dks();
          com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).dNh), Boolean.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).dNi), MallIndexUIv2.g(MallIndexUIv2.this).dNj });
          localObject1 = MallIndexUIv2.this;
          if (MallIndexUIv2.g(MallIndexUIv2.this).dNh == 1)
          {
            bool1 = true;
            MallIndexUIv2.a((MallIndexUIv2)localObject1, bool1);
            MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).dNi);
            MallIndexUIv2.a(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).dNj);
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
            localObject2 = new al();
            ((MallIndexUIv2)localObject1).vFR.a(new MallIndexUIv2.2((MallIndexUIv2)localObject1), ((al)localObject2).eFY());
            if ((localyk.dMH.dNl) && (this.hOP)) {
              MallIndexUIv2.this.updateView();
            }
            this.hOP = true;
            AppMethodBeat.o(199063);
            return;
            i = 0;
            break;
            com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexNewUI", "user is not reg or simplereg，should not show this dialog");
            break label454;
            bool1 = false;
            break label564;
            MallIndexUIv2.i(MallIndexUIv2.this).setVisibility(8);
          }
        }
      }
    };
    com.tencent.mm.sdk.b.a.IbL.a(localyk, Looper.myLooper());
    AppMethodBeat.o(199077);
    return false;
  }
  
  protected final void dko()
  {
    AppMethodBeat.i(199073);
    String str = com.tencent.mm.plugin.wallet_core.model.mall.b.eGS();
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "emptyHint: %s", new Object[] { str });
    if (this.vFg == null)
    {
      this.vFg = z.jO(this).inflate(2131494698, null);
      this.vEX.addFooterView(this.vFg, null, false);
      TextView localTextView = (TextView)this.vFg.findViewById(2131302290);
      com.tencent.mm.wallet_core.ui.e.aW(localTextView, 100);
      localTextView.setOnClickListener(new MallIndexUIv2.11(this));
    }
    if (bt.isNullOrNil(str))
    {
      this.vFg.setVisibility(8);
      this.vFg.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(199073);
      return;
    }
    this.vFg.setVisibility(0);
    ((TextView)this.vFg.findViewById(2131302290)).setText(str);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199060);
        int k = com.tencent.mm.cc.a.iq(MallIndexUIv2.this.getContext());
        int n = com.tencent.mm.cc.a.fromDPToPix(MallIndexUIv2.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUIv2.this.vEX.getLocationInWindow(arrayOfInt);
        int m = MallIndexUIv2.this.vFg.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUIv2.this.vEX.getHeight() - MallIndexUIv2.this.vFg.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cc.a.fromDPToPix(MallIndexUIv2.this.getContext(), 33);
        com.tencent.mm.sdk.platformtools.ad.d("MicorMsg.MallIndexNewUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUIv2.this.vFg.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUIv2.this.vFg.setPadding(0, j, 0, n);
          AppMethodBeat.o(199060);
          return;
        }
        MallIndexUIv2.this.vFg.setPadding(0, n, 0, n);
        AppMethodBeat.o(199060);
      }
    });
    AppMethodBeat.o(199073);
  }
  
  protected final void dkp()
  {
    AppMethodBeat.i(199076);
    final yi localyi = new yi();
    localyi.dMB.scene = "1";
    localyi.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199061);
        if (!bt.isNullOrNil(localyi.dMC.dMD)) {
          com.tencent.mm.wallet_core.ui.e.a(MallIndexUIv2.this.vFc, localyi.dMC.dMD, localyi.dMC.content, localyi.dMC.url);
        }
        AppMethodBeat.o(199061);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.l(localyi);
    AppMethodBeat.o(199076);
  }
  
  protected final void dkq()
  {
    AppMethodBeat.i(199079);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "updateBalanceNum");
    Object localObject = new al();
    if (((al)localObject).eFV())
    {
      localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Iva, getString(2131762204));
      this.vFb.setText((CharSequence)localObject);
      this.vFb.setVisibility(0);
      this.vFX.setVisibility(8);
      this.vFY.setVisibility(8);
      AppMethodBeat.o(199079);
      return;
    }
    if (((al)localObject).eFX())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(al.a.ICH, Long.valueOf(0L))).longValue();
      if (this.vFX != null)
      {
        ok(((al)localObject).eFZ());
        if (this.vFX.getVisibility() == 0)
        {
          this.vFX.setMoney(com.tencent.mm.wallet_core.ui.e.C(com.tencent.mm.wallet_core.ui.e.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(199079);
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicorMsg.MallIndexNewUI", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(199079);
  }
  
  protected final void dks()
  {
    AppMethodBeat.i(199081);
    removeAllOptionMenu();
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690603, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(199050);
        com.tencent.mm.plugin.report.service.g.yhR.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        com.tencent.mm.plugin.report.service.g.yhR.f(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUIv2.this;
        boolean bool = MallIndexUIv2.g(MallIndexUIv2.this).dMR;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.bs.d.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(199050);
        return true;
      }
    });
    com.tencent.mm.plugin.report.service.g.yhR.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(199081);
  }
  
  protected final void dku()
  {
    AppMethodBeat.i(199078);
    if (this.vFa == null)
    {
      AppMethodBeat.o(199078);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.vFa.setVisibility(0);
      AppMethodBeat.o(199078);
      return;
      label124:
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "bankcard do not need red point");
    }
    this.vFa.setVisibility(8);
    AppMethodBeat.o(199078);
  }
  
  protected final void dkv()
  {
    AppMethodBeat.i(199089);
    final LinearLayout localLinearLayout = (LinearLayout)this.rXv.findViewById(2131300712);
    localLinearLayout.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199053);
        int k = localLinearLayout.getWidth();
        MallIndexUIv2.a(MallIndexUIv2.this, localLinearLayout.getHeight());
        int j = (k - com.tencent.mm.cc.a.fromDPToPix(MallIndexUIv2.this.getContext(), 8) * 3) / 2;
        LinearLayout localLinearLayout1 = (LinearLayout)MallIndexUIv2.this.rXv.findViewById(2131302284);
        LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout1.getLayoutParams();
        int i = localLinearLayout1.getWidth();
        int m = localLinearLayout1.getHeight();
        if (i > j)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "carsonhe walletLayoutWidth > itemLayoutMaxWidth");
          localLayoutParams1.width = j;
          i = j;
        }
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "carsonhe headContentLayoutWidth:%s,itemLayoutMaxWidth ：%s,walletLayoutWidth:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
          LinearLayout localLinearLayout2 = (LinearLayout)MallIndexUIv2.this.rXv.findViewById(2131302280);
          LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams();
          localLayoutParams2.width = i;
          localLayoutParams2.height = m;
          i = (k - i * 2) / 3;
          com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "carsonhe interval:%s", new Object[] { Integer.valueOf(i) });
          localLayoutParams2.leftMargin = i;
          localLinearLayout2.setLayoutParams(localLayoutParams2);
          localLayoutParams1.rightMargin = i;
          com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "carsonhe walletLp.leftMargin:%s，walletLp.rightMargin：%s", new Object[] { Integer.valueOf(localLayoutParams1.leftMargin), Integer.valueOf(localLayoutParams1.rightMargin) });
          localLinearLayout1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(199053);
          return;
        }
      }
    });
    AppMethodBeat.o(199089);
  }
  
  protected final int dkw()
  {
    return this.vGr;
  }
  
  protected final void es(View paramView)
  {
    AppMethodBeat.i(199074);
    this.vGp = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.dun().h(this.vGp);
    this.vGq = new c(this, paramView);
    this.vGq.dkE();
    com.tencent.mm.plugin.newtips.a.dun().h(this.vGq);
    AppMethodBeat.o(199074);
  }
  
  public void finish()
  {
    AppMethodBeat.i(199086);
    this.gGM = true;
    super.finish();
    AppMethodBeat.o(199086);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(199072);
    this.rXv = z.jO(this).inflate(2131496476, null);
    this.vEX.addHeaderView(this.rXv, null, false);
    dkv();
    AppMethodBeat.o(199072);
  }
  
  public void initView()
  {
    AppMethodBeat.i(199071);
    super.initView();
    this.vEX.setPadding(a.vDH, 0, a.vDH, 0);
    AppMethodBeat.o(199071);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(199090);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.vFR.dkA();
        AppMethodBeat.o(199090);
        return;
      }
      this.vFR.cancel();
      AppMethodBeat.o(199090);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.ajD();
      if (!((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEd, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(199090);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new rg();
      paramIntent.dFQ.context = getContext();
      com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
    }
    AppMethodBeat.o(199090);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199070);
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
        return MallIndexUIv2.this;
      }
    };
    e.dkG();
    a.j(this);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.IbL.c(this.vGb);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.ax.b.FU((String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null)))
    {
      com.tencent.mm.kernel.g.ajD();
      a(new com.tencent.mm.plugin.mall.a.d((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEe, "")));
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(199070);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(199084);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    this.vFZ.dead();
    this.vGc.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    com.tencent.mm.sdk.b.a.IbL.d(this.vGb);
    AppMethodBeat.o(199084);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(199083);
    super.onPause();
    this.vFR.onPause();
    if (this.vFX != null) {
      this.vFX.reset();
    }
    AppMethodBeat.o(199083);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(199082);
    com.tencent.mm.sdk.platformtools.ad.v("MicorMsg.MallIndexNewUI", "alvinluo MallIndexUI onResume");
    this.vFR.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.eJn(), null);
    super.onResume();
    dkq();
    AppMethodBeat.o(199082);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(199087);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramn).vDe);
    }
    do
    {
      do
      {
        AppMethodBeat.o(199087);
        return true;
      } while (!(paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad));
      paramString = (com.tencent.mm.plugin.wallet_core.c.ad)paramn;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void djA() {}
    })));
    AppMethodBeat.o(199087);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class b
    extends MallIndexUIv2.a
  {
    private LinearLayout vGl;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(199065);
      this.vGl = ((LinearLayout)paramView.findViewById(2131302280));
      this.vGj = ((ImageView)this.vGl.findViewById(2131302281));
      this.vGk = ((TextView)this.vGl.findViewById(2131302282));
      this.vGl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199064);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.plugin.newtips.a.dun().LQ(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.bs.d.b(MallIndexUIv2.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.kB(9, 0);
          com.tencent.mm.plugin.report.service.g.yhR.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.g.yhR.f(14419, new Object[] { MallIndexUIv2.this.uuid, Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199064);
        }
      });
      AppMethodBeat.o(199065);
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
    extends MallIndexUIv2.a
  {
    private LinearLayout vGn;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean dkE()
    {
      AppMethodBeat.i(199068);
      com.tencent.mm.kernel.g.ajD();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICk, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.ajD();
      long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICl, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexNewUI", "hasRedDot expire, ignore reddot");
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
          AppMethodBeat.o(199068);
          return true;
          this.vGj.setVisibility(8);
        }
      }
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(199067);
      this.vGn = ((LinearLayout)paramView.findViewById(2131302284));
      MallIndexUIv2.this.vFb = ((TextView)this.vGn.findViewById(2131306696));
      MallIndexUIv2.a(MallIndexUIv2.this, (WcPayMoneyLoadingView)this.vGn.findViewById(2131306697));
      MallIndexUIv2.a(MallIndexUIv2.this, (ProgressBar)this.vGn.findViewById(2131306757));
      MallIndexUIv2.this.getLifecycle().addObserver(MallIndexUIv2.d(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setLoadingPb(MallIndexUIv2.e(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setPrefixSymbol("¥");
      MallIndexUIv2.d(MallIndexUIv2.this).setTextColor(-1);
      MallIndexUIv2.d(MallIndexUIv2.this).setTextSize(com.tencent.mm.cc.a.fromDPToPix(MallIndexUIv2.this.getContext(), 15));
      this.vGj = ((ImageView)this.vGn.findViewById(2131302285));
      this.vGk = ((TextView)this.vGn.findViewById(2131302286));
      this.vGn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199066);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          MallIndexUIv2.c(MallIndexUIv2.this);
          com.tencent.mm.plugin.newtips.a.dun().LQ(15);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(199066);
        }
      });
      AppMethodBeat.o(199067);
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
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2
 * JD-Core Version:    0.7.0.1
 */