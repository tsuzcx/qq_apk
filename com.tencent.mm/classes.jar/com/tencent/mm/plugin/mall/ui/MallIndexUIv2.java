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
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.al;
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
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.i
public class MallIndexUIv2
  extends MallIndexBaseUIv2
  implements n.b
{
  private RelativeLayout DVn;
  private String dOz;
  private boolean gJv;
  private View ogP;
  private TextView vRB;
  private boolean vRC;
  yq.b vRR;
  private RelativeLayout vRS;
  private boolean vRT;
  private boolean vRU;
  u vRV;
  private boolean vRW;
  private Dialog vRX;
  private boolean vRY;
  private WcPayMoneyLoadingView vSb;
  private ProgressBar vSc;
  private com.tencent.mm.sdk.b.c<od> vSd;
  private boolean vSe;
  private com.tencent.mm.sdk.b.c vSf;
  private com.tencent.mm.sdk.b.c<zt> vSg;
  private boolean vSi;
  private b vSt;
  private c vSu;
  private int vSv;
  
  public MallIndexUIv2()
  {
    AppMethodBeat.i(189904);
    this.gJv = false;
    this.vRV = new u();
    this.ogP = null;
    this.vRC = false;
    this.vRB = null;
    this.vRW = false;
    this.vRY = false;
    this.vSt = null;
    this.vSu = null;
    this.vSd = new com.tencent.mm.sdk.b.c() {};
    this.vSe = false;
    this.vSf = new com.tencent.mm.sdk.b.c() {};
    this.vSg = new MallIndexUIv2.9(this);
    this.vSi = false;
    AppMethodBeat.o(189904);
  }
  
  private void a(final com.tencent.mm.plugin.mall.a.d paramd)
  {
    AppMethodBeat.i(189923);
    if ((paramd == null) || (bu.isNullOrNil(paramd.vPh)))
    {
      AppMethodBeat.o(189923);
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
            AppMethodBeat.i(189886);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            new Intent();
            f.cu(MallIndexUIv2.this, paramd.vPh);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(189886);
          }
        });
      }
      AppMethodBeat.o(189923);
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
        AppMethodBeat.i(189887);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        f.aY(MallIndexUIv2.this.getContext(), paramd.vPh);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(189887);
      }
    });
    if (this.vRb != null)
    {
      this.vRb.addFooterView(this.ogP);
      this.vRC = true;
    }
    AppMethodBeat.o(189923);
  }
  
  private void op(boolean paramBoolean)
  {
    AppMethodBeat.i(189915);
    if (paramBoolean)
    {
      this.vRf.setText(getString(2131765298));
      this.vRf.setVisibility(0);
      this.vSb.setVisibility(8);
      this.vSc.setVisibility(8);
      this.DVn.setVisibility(8);
      this.vSb.reset();
      AppMethodBeat.o(189915);
      return;
    }
    this.vRf.setVisibility(8);
    this.vSb.setVisibility(0);
    this.vSc.setVisibility(0);
    this.DVn.setVisibility(0);
    AppMethodBeat.o(189915);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(189910);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      ae.i("MicorMsg.MallIndexNewUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        dnp();
      }
    }
    AppMethodBeat.o(189910);
  }
  
  protected final void deV()
  {
    AppMethodBeat.i(189926);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(189926);
  }
  
  protected final void dng()
  {
    AppMethodBeat.i(189927);
    setMMTitle(2131761092);
    AppMethodBeat.o(189927);
  }
  
  protected final void dnh()
  {
    AppMethodBeat.i(189920);
    com.tencent.mm.plugin.mall.b.a.dnJ();
    AppMethodBeat.o(189920);
  }
  
  protected final boolean dnj()
  {
    AppMethodBeat.i(189912);
    ae.i("MicorMsg.MallIndexNewUI", "init BankcardList");
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
        AppMethodBeat.i(189898);
        if ((MallIndexUIv2.this.isFinishing()) || (MallIndexUIv2.this.hasFinish()) || (MallIndexUIv2.this.isDestroyed()))
        {
          AppMethodBeat.o(189898);
          return;
        }
        ae.d("MicorMsg.MallIndexNewUI", "mUserInfo needBind : " + MallIndexUIv2.g(MallIndexUIv2.this).dOb + " hasNewTips : " + MallIndexUIv2.g(MallIndexUIv2.this).dOc + " swipeOn : " + MallIndexUIv2.g(MallIndexUIv2.this).dOd);
        if ((MallIndexUIv2.h(MallIndexUIv2.this)) || (MallIndexUIv2.this.getContext().isFinishing()))
        {
          ae.e("MicorMsg.MallIndexNewUI", "error for callback ac finish");
          AppMethodBeat.o(189898);
          return;
        }
        ae.i("MicorMsg.MallIndexNewUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localyq.dNX.dOB), Boolean.valueOf(this.hRI) });
        MallIndexUIv2.a(MallIndexUIv2.this, localyq.dNX);
        int i;
        Object localObject1;
        boolean bool2;
        Object localObject2;
        if (MallIndexUIv2.g(MallIndexUIv2.this).dOC != null)
        {
          i = 1;
          if ((i & MallIndexUIv2.g(MallIndexUIv2.this).dOC instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject1 = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUIv2.g(MallIndexUIv2.this).dOC;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).getJumpRemind().a(MallIndexUIv2.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void dmz() {}
              });
            }
          }
          if (MallIndexUIv2.g(MallIndexUIv2.this).errCode == 0)
          {
            MallIndexUIv2.this.dnt();
            if (MallIndexUIv2.g(MallIndexUIv2.this).dOB) {
              MallIndexUIv2.this.dnp();
            }
            localObject1 = MallIndexUIv2.this;
            ae.i("MicorMsg.MallIndexNewUI", "showGetNewWalletTip call");
            if ((((MallIndexUIv2)localObject1).vRR == null) || ((!((MallIndexUIv2)localObject1).vRR.dOa) && (!((MallIndexUIv2)localObject1).vRR.dOg))) {
              break label718;
            }
            bool2 = t.eJf().eJP().eJz();
            localObject2 = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IOz, Boolean.FALSE);
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
          ae.i("MicorMsg.MallIndexNewUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
          if ((!bool1) && (bool2))
          {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IOz, Boolean.TRUE);
            o.gR((Context)localObject1);
          }
          if (!this.hRI) {
            MallIndexUIv2.dWj();
          }
          MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this));
          MallIndexUIv2.this.dnr();
          ae.i("MicorMsg.MallIndexNewUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).dOx), Boolean.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).dOy), MallIndexUIv2.g(MallIndexUIv2.this).dOz });
          localObject1 = MallIndexUIv2.this;
          if (MallIndexUIv2.g(MallIndexUIv2.this).dOx == 1)
          {
            bool1 = true;
            MallIndexUIv2.b((MallIndexUIv2)localObject1, bool1);
            MallIndexUIv2.a(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).dOy);
            MallIndexUIv2.a(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).dOz);
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
            ((MallIndexUIv2)localObject1).vRV.a(new MallIndexUIv2.2((MallIndexUIv2)localObject1), ((al)localObject2).eJF());
            if ((localyq.dNX.dOB) && (this.hRI)) {
              MallIndexUIv2.this.updateView();
            }
            this.hRI = true;
            AppMethodBeat.o(189898);
            return;
            i = 0;
            break;
            ae.e("MicorMsg.MallIndexNewUI", "user is not reg or simplereg，should not show this dialog");
            break label454;
            bool1 = false;
            break label564;
            MallIndexUIv2.i(MallIndexUIv2.this).setVisibility(8);
          }
        }
      }
    };
    com.tencent.mm.sdk.b.a.IvT.a(localyq, Looper.myLooper());
    AppMethodBeat.o(189912);
    return false;
  }
  
  protected final void dnn()
  {
    AppMethodBeat.i(189908);
    String str = com.tencent.mm.plugin.wallet_core.model.mall.b.eKA();
    ae.i("MicorMsg.MallIndexNewUI", "emptyHint: %s", new Object[] { str });
    if (this.vRk == null)
    {
      this.vRk = z.jV(this).inflate(2131494698, null);
      this.vRb.addFooterView(this.vRk, null, false);
      TextView localTextView = (TextView)this.vRk.findViewById(2131302290);
      f.aW(localTextView, 100);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189894);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicorMsg.MallIndexNewUI", "click settings btn");
          com.tencent.mm.br.d.Q(MallIndexUIv2.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189894);
        }
      });
    }
    if (bu.isNullOrNil(str))
    {
      this.vRk.setVisibility(8);
      this.vRk.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(189908);
      return;
    }
    this.vRk.setVisibility(0);
    ((TextView)this.vRk.findViewById(2131302290)).setText(str);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189895);
        int k = com.tencent.mm.cb.a.iv(MallIndexUIv2.this.getContext());
        int n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUIv2.this.vRb.getLocationInWindow(arrayOfInt);
        int m = MallIndexUIv2.this.vRk.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUIv2.this.vRb.getHeight() - MallIndexUIv2.this.vRk.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 33);
        ae.d("MicorMsg.MallIndexNewUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUIv2.this.vRk.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUIv2.this.vRk.setPadding(0, j, 0, n);
          AppMethodBeat.o(189895);
          return;
        }
        MallIndexUIv2.this.vRk.setPadding(0, n, 0, n);
        AppMethodBeat.o(189895);
      }
    });
    AppMethodBeat.o(189908);
  }
  
  protected final void dno()
  {
    AppMethodBeat.i(189911);
    final yo localyo = new yo();
    localyo.dNR.scene = "1";
    localyo.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189896);
        if (!bu.isNullOrNil(localyo.dNS.dNT)) {
          f.a(MallIndexUIv2.this.vRg, localyo.dNS.dNT, localyo.dNS.content, localyo.dNS.url);
        }
        AppMethodBeat.o(189896);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.l(localyo);
    AppMethodBeat.o(189911);
  }
  
  protected final void dnp()
  {
    AppMethodBeat.i(189914);
    ae.i("MicorMsg.MallIndexNewUI", "updateBalanceNum");
    Object localObject = new al();
    if (((al)localObject).eJC())
    {
      localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPy, getString(2131762204));
      this.vRf.setText((CharSequence)localObject);
      this.vRf.setVisibility(0);
      this.vSb.setVisibility(8);
      this.vSc.setVisibility(8);
      AppMethodBeat.o(189914);
      return;
    }
    if (((al)localObject).eJE())
    {
      ae.i("MicorMsg.MallIndexNewUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(am.a.IXh, Long.valueOf(0L))).longValue();
      if (this.vSb != null)
      {
        op(((al)localObject).eJG());
        if (this.vSb.getVisibility() == 0)
        {
          this.vSb.setMoney(f.C(f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(189914);
        }
      }
      else
      {
        ae.w("MicorMsg.MallIndexNewUI", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(189914);
  }
  
  protected final void dnr()
  {
    AppMethodBeat.i(189916);
    removeAllOptionMenu();
    ae.i("MicorMsg.MallIndexNewUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690603, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(189885);
        com.tencent.mm.plugin.report.service.g.yxI.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        com.tencent.mm.plugin.report.service.g.yxI.f(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUIv2.this;
        boolean bool = MallIndexUIv2.g(MallIndexUIv2.this).dOh;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.br.d.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(189885);
        return true;
      }
    });
    com.tencent.mm.plugin.report.service.g.yxI.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(189916);
  }
  
  protected final void dnt()
  {
    AppMethodBeat.i(189913);
    if (this.vRe == null)
    {
      AppMethodBeat.o(189913);
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
      ae.i("MicorMsg.MallIndexNewUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.vRe.setVisibility(0);
      AppMethodBeat.o(189913);
      return;
      label124:
      ae.i("MicorMsg.MallIndexNewUI", "bankcard do not need red point");
    }
    this.vRe.setVisibility(8);
    AppMethodBeat.o(189913);
  }
  
  protected final void dnu()
  {
    AppMethodBeat.i(189924);
    final LinearLayout localLinearLayout = (LinearLayout)this.sgg.findViewById(2131300712);
    localLinearLayout.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189888);
        int k = localLinearLayout.getWidth();
        MallIndexUIv2.a(MallIndexUIv2.this, localLinearLayout.getHeight());
        int j = (k - com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 8) * 3) / 2;
        LinearLayout localLinearLayout1 = (LinearLayout)MallIndexUIv2.this.sgg.findViewById(2131302284);
        LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout1.getLayoutParams();
        int i = localLinearLayout1.getWidth();
        int m = localLinearLayout1.getHeight();
        if (i > j)
        {
          ae.i("MicorMsg.MallIndexNewUI", "carsonhe walletLayoutWidth > itemLayoutMaxWidth");
          localLayoutParams1.width = j;
          i = j;
        }
        for (;;)
        {
          ae.i("MicorMsg.MallIndexNewUI", "carsonhe headContentLayoutWidth:%s,itemLayoutMaxWidth ：%s,walletLayoutWidth:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) });
          LinearLayout localLinearLayout2 = (LinearLayout)MallIndexUIv2.this.sgg.findViewById(2131302280);
          LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams();
          localLayoutParams2.width = i;
          localLayoutParams2.height = m;
          i = (k - i * 2) / 3;
          ae.i("MicorMsg.MallIndexNewUI", "carsonhe interval:%s", new Object[] { Integer.valueOf(i) });
          localLayoutParams2.leftMargin = i;
          localLinearLayout2.setLayoutParams(localLayoutParams2);
          localLayoutParams1.rightMargin = i;
          ae.i("MicorMsg.MallIndexNewUI", "carsonhe walletLp.leftMargin:%s，walletLp.rightMargin：%s", new Object[] { Integer.valueOf(localLayoutParams1.leftMargin), Integer.valueOf(localLayoutParams1.rightMargin) });
          localLinearLayout1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(189888);
          return;
        }
      }
    });
    AppMethodBeat.o(189924);
  }
  
  protected final int dnv()
  {
    return this.vSv;
  }
  
  protected final void es(View paramView)
  {
    AppMethodBeat.i(189909);
    this.vSt = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.dxD().h(this.vSt);
    this.vSu = new c(this, paramView);
    this.vSu.dnE();
    com.tencent.mm.plugin.newtips.a.dxD().h(this.vSu);
    AppMethodBeat.o(189909);
  }
  
  public void finish()
  {
    AppMethodBeat.i(189921);
    this.gJv = true;
    super.finish();
    AppMethodBeat.o(189921);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(189907);
    this.sgg = z.jV(this).inflate(2131496476, null);
    this.vRb.addHeaderView(this.sgg, null, false);
    dnu();
    AppMethodBeat.o(189907);
  }
  
  public void initView()
  {
    AppMethodBeat.i(189906);
    super.initView();
    this.vRb.setPadding(a.vPL, 0, a.vPL, 0);
    AppMethodBeat.o(189906);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(189925);
    ae.i("MicorMsg.MallIndexNewUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.vRV.dnA();
        AppMethodBeat.o(189925);
        return;
      }
      this.vRV.cancel();
      AppMethodBeat.o(189925);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.ajS();
      if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYD, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(189925);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new rh();
      paramIntent.dGV.context = getContext();
      com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
    }
    AppMethodBeat.o(189925);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189905);
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
        return MallIndexUIv2.this;
      }
    };
    e.dnG();
    a.j(this);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.IvT.c(this.vSf);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
    {
      com.tencent.mm.kernel.g.ajS();
      a(new com.tencent.mm.plugin.mall.a.d((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYE, "")));
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(189905);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(189919);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    this.vSd.dead();
    this.vSg.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    com.tencent.mm.sdk.b.a.IvT.d(this.vSf);
    AppMethodBeat.o(189919);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(189918);
    super.onPause();
    this.vRV.onPause();
    if (this.vSb != null) {
      this.vSb.reset();
    }
    AppMethodBeat.o(189918);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(189917);
    ae.v("MicorMsg.MallIndexNewUI", "alvinluo MallIndexUI onResume");
    this.vRV.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.eMV(), null);
    super.onResume();
    dnp();
    AppMethodBeat.o(189917);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(189922);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramn).vPi);
    }
    do
    {
      do
      {
        AppMethodBeat.o(189922);
        return true;
      } while (!(paramn instanceof ad));
      paramString = (ad)paramn;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void dmz() {}
    })));
    AppMethodBeat.o(189922);
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
    private LinearLayout vSp;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(189900);
      this.vSp = ((LinearLayout)paramView.findViewById(2131302280));
      this.vSn = ((ImageView)this.vSp.findViewById(2131302281));
      this.vSo = ((TextView)this.vSp.findViewById(2131302282));
      this.vSp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189899);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.plugin.newtips.a.dxD().Mv(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.br.d.b(MallIndexUIv2.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.kI(9, 0);
          com.tencent.mm.plugin.report.service.g.yxI.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.g.yxI.f(14419, new Object[] { MallIndexUIv2.this.uuid, Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189899);
        }
      });
      AppMethodBeat.o(189900);
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
    extends MallIndexUIv2.a
  {
    private LinearLayout vSr;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean dnE()
    {
      AppMethodBeat.i(189903);
      com.tencent.mm.kernel.g.ajS();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWJ, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.ajS();
      long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWK, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        ae.i("MicorMsg.MallIndexNewUI", "hasRedDot expire, ignore reddot");
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
          AppMethodBeat.o(189903);
          return true;
          this.vSn.setVisibility(8);
        }
      }
    }
    
    public final void es(View paramView)
    {
      AppMethodBeat.i(189902);
      this.vSr = ((LinearLayout)paramView.findViewById(2131302284));
      MallIndexUIv2.this.vRf = ((TextView)this.vSr.findViewById(2131306696));
      MallIndexUIv2.a(MallIndexUIv2.this, (WcPayMoneyLoadingView)this.vSr.findViewById(2131306697));
      MallIndexUIv2.a(MallIndexUIv2.this, (ProgressBar)this.vSr.findViewById(2131306757));
      MallIndexUIv2.a(MallIndexUIv2.this, (RelativeLayout)this.vSr.findViewById(2131308531));
      MallIndexUIv2.this.getLifecycle().addObserver(MallIndexUIv2.d(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setLoadingPb(MallIndexUIv2.e(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setPrefixSymbol("¥");
      MallIndexUIv2.d(MallIndexUIv2.this).setTextColor(-1);
      MallIndexUIv2.d(MallIndexUIv2.this).setTextSize(com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 15));
      this.vSn = ((ImageView)this.vSr.findViewById(2131302285));
      this.vSo = ((TextView)this.vSr.findViewById(2131302286));
      this.vSr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(189901);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          MallIndexUIv2.c(MallIndexUIv2.this);
          com.tencent.mm.plugin.newtips.a.dxD().Mv(15);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(189901);
        }
      });
      AppMethodBeat.o(189902);
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
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2
 * JD-Core Version:    0.7.0.1
 */