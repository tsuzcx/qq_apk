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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aah;
import com.tencent.mm.g.a.aba;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.b;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.g.a.zv.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.f;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.i
public class MallIndexUIv2
  extends MallIndexBaseUIv2
  implements MStorageEx.IOnStorageChange
{
  private String egv;
  private boolean isFinished;
  private View psf;
  private TextView zlH;
  private boolean zlI;
  zv.b zlX;
  private RelativeLayout zlY;
  private boolean zlZ;
  private c zmA;
  private int zmB;
  private boolean zma;
  u zmb;
  private boolean zmc;
  private Dialog zmd;
  private boolean zme;
  private WcPayMoneyLoadingView zmh;
  private ProgressBar zmi;
  private IListener<ov> zmj;
  private boolean zmk;
  private IListener zml;
  private IListener<aba> zmm;
  private boolean zmo;
  private RelativeLayout zmy;
  private b zmz;
  
  public MallIndexUIv2()
  {
    AppMethodBeat.i(213584);
    this.isFinished = false;
    this.zmb = new u();
    this.psf = null;
    this.zlI = false;
    this.zlH = null;
    this.zmc = false;
    this.zme = false;
    this.zmz = null;
    this.zmA = null;
    this.zmj = new IListener() {};
    this.zmk = false;
    this.zml = new IListener() {};
    this.zmm = new MallIndexUIv2.10(this);
    this.zmo = false;
    AppMethodBeat.o(213584);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(213603);
    if ((paramd == null) || (Util.isNullOrNil(paramd.zjl)))
    {
      AppMethodBeat.o(213603);
      return;
    }
    if (this.zlI)
    {
      if (this.zlH != null)
      {
        this.zlH.setText(2131762874);
        this.zlH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213566);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            new Intent();
            f.cN(MallIndexUIv2.this, paramd.zjl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213566);
          }
        });
      }
      AppMethodBeat.o(213603);
      return;
    }
    this.psf = View.inflate(this, 2131495423, null);
    this.psf.setClickable(false);
    this.psf.setEnabled(false);
    this.zlH = ((TextView)this.psf.findViewById(2131310290));
    this.zlH.setVisibility(0);
    this.zlH.setText(2131762874);
    this.zlH.setTextColor(getResources().getColor(2131100685));
    this.zlH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(213567);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.bn(MallIndexUIv2.this.getContext(), paramd.zjl);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213567);
      }
    });
    if (this.zlh != null)
    {
      this.zlh.addFooterView(this.psf);
      this.zlI = true;
    }
    AppMethodBeat.o(213603);
  }
  
  private void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(213595);
    if (paramBoolean)
    {
      this.zll.setText(getString(2131767741));
      this.zll.setVisibility(0);
      this.zmh.setVisibility(8);
      this.zmi.setVisibility(8);
      this.zmy.setVisibility(8);
      this.zmh.reset();
      AppMethodBeat.o(213595);
      return;
    }
    this.zll.setVisibility(8);
    this.zmh.setVisibility(0);
    this.zmi.setVisibility(0);
    this.zmy.setVisibility(0);
    AppMethodBeat.o(213595);
  }
  
  protected final void dYP()
  {
    AppMethodBeat.i(213606);
    int i = getResources().getColor(2131100773);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131307165).setBackgroundColor(i);
    AppMethodBeat.o(213606);
  }
  
  protected final void egS()
  {
    AppMethodBeat.i(213607);
    setMMTitle(2131762879);
    AppMethodBeat.o(213607);
  }
  
  protected final void egT()
  {
    AppMethodBeat.i(213600);
    com.tencent.mm.plugin.mall.b.a.ehv();
    AppMethodBeat.o(213600);
  }
  
  protected final boolean egV()
  {
    AppMethodBeat.i(213592);
    Log.i("MicorMsg.MallIndexUIv2", "init BankcardList");
    final zv localzv = new zv();
    localzv.efR.scene = 1;
    localzv.efR.efT = true;
    localzv.efR.retryCount = 0;
    localzv.efR.efU = true;
    localzv.efS.efJ = new Runnable()
    {
      boolean iMQ = false;
      
      public final void run()
      {
        AppMethodBeat.i(213563);
        if ((MallIndexUIv2.this.isFinishing()) || (MallIndexUIv2.this.hasFinish()) || (MallIndexUIv2.this.isDestroyed()))
        {
          AppMethodBeat.o(213563);
          return;
        }
        Log.d("MicorMsg.MallIndexUIv2", "mUserInfo needBind : " + MallIndexUIv2.g(MallIndexUIv2.this).efW + " hasNewTips : " + MallIndexUIv2.g(MallIndexUIv2.this).efX + " swipeOn : " + MallIndexUIv2.g(MallIndexUIv2.this).efY);
        if ((MallIndexUIv2.h(MallIndexUIv2.this)) || (MallIndexUIv2.this.getContext().isFinishing()))
        {
          Log.e("MicorMsg.MallIndexUIv2", "error for callback ac finish");
          AppMethodBeat.o(213563);
          return;
        }
        Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localzv.efS.egx), Boolean.valueOf(this.iMQ) });
        MallIndexUIv2.a(MallIndexUIv2.this, localzv.efS);
        int i;
        Object localObject1;
        boolean bool2;
        Object localObject2;
        if (MallIndexUIv2.g(MallIndexUIv2.this).egy != null)
        {
          i = 1;
          if ((i & MallIndexUIv2.g(MallIndexUIv2.this).egy instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject1 = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUIv2.g(MallIndexUIv2.this).egy;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).getJumpRemind().a(MallIndexUIv2.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void eeY() {}
              });
            }
          }
          if (MallIndexUIv2.g(MallIndexUIv2.this).errCode == 0)
          {
            MallIndexUIv2.this.ehf();
            if (MallIndexUIv2.g(MallIndexUIv2.this).egx) {
              MallIndexUIv2.this.ehb();
            }
            localObject1 = MallIndexUIv2.this;
            Log.i("MicorMsg.MallIndexUIv2", "showGetNewWalletTip call");
            if ((((MallIndexUIv2)localObject1).zlX == null) || ((!((MallIndexUIv2)localObject1).zlX.efV) && (!((MallIndexUIv2)localObject1).zlX.egb))) {
              break label718;
            }
            bool2 = t.fQI().fRs().fRc();
            localObject2 = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWB, Boolean.FALSE);
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
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWB, Boolean.TRUE);
            o.hN((Context)localObject1);
          }
          if (!this.iMQ) {
            MallIndexUIv2.ehr();
          }
          MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this));
          MallIndexUIv2.this.ehd();
          Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).egt), Boolean.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).egu), MallIndexUIv2.g(MallIndexUIv2.this).egv });
          localObject1 = MallIndexUIv2.this;
          if (MallIndexUIv2.g(MallIndexUIv2.this).egt == 1)
          {
            bool1 = true;
            MallIndexUIv2.a((MallIndexUIv2)localObject1, bool1);
            MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).egu);
            MallIndexUIv2.a(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).egv);
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
            ((MallIndexUIv2)localObject1).zmb.a(new MallIndexUIv2.3((MallIndexUIv2)localObject1), ((al)localObject2).fRi());
            if ((localzv.efS.egx) && (this.iMQ)) {
              MallIndexUIv2.this.updateView();
            }
            this.iMQ = true;
            AppMethodBeat.o(213563);
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
    EventCenter.instance.asyncPublish(localzv, Looper.myLooper());
    AppMethodBeat.o(213592);
    return false;
  }
  
  protected final void egZ()
  {
    AppMethodBeat.i(213588);
    String str = com.tencent.mm.plugin.wallet_core.model.mall.b.fSf();
    Log.i("MicorMsg.MallIndexUIv2", "emptyHint: %s", new Object[] { str });
    if (this.zlq == null)
    {
      this.zlq = com.tencent.mm.ui.aa.jQ(this).inflate(2131495427, null);
      this.zlh.addFooterView(this.zlq, null, false);
      TextView localTextView = (TextView)this.zlq.findViewById(2131304684);
      f.aZ(localTextView, 100);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213575);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicorMsg.MallIndexUIv2", "click settings btn");
          com.tencent.mm.br.c.V(MallIndexUIv2.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213575);
        }
      });
    }
    if (Util.isNullOrNil(str))
    {
      this.zlq.setVisibility(8);
      this.zlq.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(213588);
      return;
    }
    this.zlq.setVisibility(0);
    ((TextView)this.zlq.findViewById(2131304684)).setText(str);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213576);
        int k = com.tencent.mm.cb.a.jo(MallIndexUIv2.this.getContext());
        int n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUIv2.this.zlh.getLocationInWindow(arrayOfInt);
        int m = MallIndexUIv2.this.zlq.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUIv2.this.zlh.getHeight() - MallIndexUIv2.this.zlq.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 33);
        Log.d("MicorMsg.MallIndexUIv2", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUIv2.this.zlq.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUIv2.this.zlq.setPadding(0, j, 0, n);
          AppMethodBeat.o(213576);
          return;
        }
        MallIndexUIv2.this.zlq.setPadding(0, n, 0, n);
        AppMethodBeat.o(213576);
      }
    });
    AppMethodBeat.o(213588);
  }
  
  protected final void eha()
  {
    AppMethodBeat.i(213591);
    final zt localzt = new zt();
    localzt.efM.scene = "1";
    localzt.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213577);
        if (!Util.isNullOrNil(localzt.efN.efO)) {
          f.a(MallIndexUIv2.this.zlm, localzt.efN.efO, localzt.efN.content, localzt.efN.url);
        }
        AppMethodBeat.o(213577);
      }
    };
    EventCenter.instance.publish(localzt);
    AppMethodBeat.o(213591);
  }
  
  protected final void ehb()
  {
    AppMethodBeat.i(213594);
    Log.i("MicorMsg.MallIndexUIv2", "updateBalanceNum");
    Object localObject = new al();
    if (((al)localObject).fRf())
    {
      localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXz, getString(2131764226));
      this.zll.setText((CharSequence)localObject);
      this.zll.setVisibility(0);
      this.zmh.setVisibility(8);
      this.zmi.setVisibility(8);
      AppMethodBeat.o(213594);
      return;
    }
    if (((al)localObject).fRh())
    {
      Log.i("MicorMsg.MallIndexUIv2", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OfA, Long.valueOf(0L))).longValue();
      if (this.zmh != null)
      {
        qU(((al)localObject).fRj());
        if (this.zmh.getVisibility() == 0)
        {
          this.zmh.setMoney(f.formatMoney2f(f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(213594);
        }
      }
      else
      {
        Log.w("MicorMsg.MallIndexUIv2", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(213594);
  }
  
  protected final void ehd()
  {
    AppMethodBeat.i(213596);
    removeAllOptionMenu();
    Log.i("MicorMsg.MallIndexUIv2", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690843, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(213565);
        com.tencent.mm.plugin.report.service.h.CyF.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        com.tencent.mm.plugin.report.service.h.CyF.a(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUIv2.this;
        boolean bool = MallIndexUIv2.g(MallIndexUIv2.this).egc;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.br.c.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(213565);
        return true;
      }
    });
    com.tencent.mm.plugin.report.service.h.CyF.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(213596);
  }
  
  protected final void ehf()
  {
    AppMethodBeat.i(213593);
    if (this.zlk == null)
    {
      AppMethodBeat.o(213593);
      return;
    }
    if ((!com.tencent.mm.y.c.axV().b(ar.a.Odu, ar.a.Odv)) && (!this.zlX.efX))
    {
      n localn = t.fQI().IbN;
      if (localn == null) {
        break label132;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.g.aAi();
      if ((((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NVW, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      Log.i("MicorMsg.MallIndexUIv2", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.zlk.setVisibility(0);
      AppMethodBeat.o(213593);
      return;
      label124:
      Log.i("MicorMsg.MallIndexUIv2", "bankcard do not need red point");
    }
    this.zlk.setVisibility(8);
    AppMethodBeat.o(213593);
  }
  
  protected final void ehg()
  {
    AppMethodBeat.i(213604);
    if (this.vbj == null)
    {
      Log.i("MicorMsg.MallIndexUIv2", "header = null");
      AppMethodBeat.o(213604);
      return;
    }
    final LinearLayout localLinearLayout = (LinearLayout)this.vbj.findViewById(2131302284);
    if (localLinearLayout == null)
    {
      Log.i("MicorMsg.MallIndexUIv2", "headerContentLayout = null");
      AppMethodBeat.o(213604);
      return;
    }
    localLinearLayout.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213568);
        int k = localLinearLayout.getWidth();
        MallIndexUIv2.a(MallIndexUIv2.this, localLinearLayout.getHeight());
        int j = (k - com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 8) * 3) / 2;
        LinearLayout localLinearLayout1 = (LinearLayout)MallIndexUIv2.this.vbj.findViewById(2131304678);
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
          LinearLayout localLinearLayout2 = (LinearLayout)MallIndexUIv2.this.vbj.findViewById(2131304674);
          LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams();
          localLayoutParams2.width = i;
          localLayoutParams2.height = m;
          i = (k - i * 2) / 3;
          localLayoutParams2.leftMargin = i;
          localLinearLayout2.setLayoutParams(localLayoutParams2);
          localLayoutParams1.rightMargin = i;
          localLinearLayout1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(213568);
          return;
        }
      }
    });
    AppMethodBeat.o(213604);
  }
  
  protected final int ehh()
  {
    return this.zmB;
  }
  
  protected final void eq(View paramView)
  {
    AppMethodBeat.i(213589);
    this.zmz = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.exl().h(this.zmz);
    this.zmA = new c(this, paramView);
    this.zmA.ehq();
    com.tencent.mm.plugin.newtips.a.exl().h(this.zmA);
    AppMethodBeat.o(213589);
  }
  
  public void finish()
  {
    AppMethodBeat.i(213601);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(213601);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(213587);
    this.vbj = com.tencent.mm.ui.aa.jQ(this).inflate(2131495426, null);
    this.zlh.addHeaderView(this.vbj, null, false);
    ehg();
    AppMethodBeat.o(213587);
  }
  
  public void initView()
  {
    AppMethodBeat.i(213586);
    super.initView();
    this.zlh.setPadding(a.zjP, 0, a.zjP, 0);
    AppMethodBeat.o(213586);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(213605);
    Log.i("MicorMsg.MallIndexUIv2", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.zmb.ehm();
        AppMethodBeat.o(213605);
        return;
      }
      this.zmb.cancel();
      AppMethodBeat.o(213605);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.aAi();
      if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oha, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(213605);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new sd();
      paramIntent.dYH.context = getContext();
      EventCenter.instance.publish(paramIntent);
    }
    AppMethodBeat.o(213605);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213585);
    fixStatusbar(true);
    if (26 != Build.VERSION.SDK_INT) {
      setRequestedOrientation(1);
    }
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.f.h.RTc.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213574);
        com.tencent.mm.plugin.wallet_core.model.k.aeJ(2);
        AppMethodBeat.o(213574);
      }
    }, "wxpay_mallindex_refresh_location");
    this.zlX = new zv.b();
    this.zlX.efV = false;
    this.zlX.efW = true;
    this.zlX.efX = false;
    this.zmj.alive();
    this.zmm.alive();
    this.zmb.IkQ = new u.b()
    {
      public final int eho()
      {
        return 3;
      }
      
      public final Context getContext()
      {
        return MallIndexUIv2.this;
      }
    };
    e.ehs();
    a.j(this);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.zml);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null)))
    {
      com.tencent.mm.kernel.g.aAi();
      a(new d((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ohb, "")));
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(213585);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(213599);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    this.zmj.dead();
    this.zmm.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    EventCenter.instance.removeListener(this.zml);
    AppMethodBeat.o(213599);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(213590);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicorMsg.MallIndexUIv2", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        ehb();
      }
    }
    AppMethodBeat.o(213590);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(213598);
    super.onPause();
    this.zmb.onPause();
    if (this.zmh != null) {
      this.zmh.reset();
    }
    AppMethodBeat.o(213598);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(213597);
    Log.v("MicorMsg.MallIndexUIv2", "alvinluo MallIndexUI onResume");
    this.zmb.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.fUE(), null);
    super.onResume();
    ehb();
    AppMethodBeat.o(213597);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(213602);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramq instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramq).zjm);
    }
    do
    {
      do
      {
        AppMethodBeat.o(213602);
        return true;
      } while (!(paramq instanceof ad));
      paramString = (ad)paramq;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void eeY() {}
    })));
    AppMethodBeat.o(213602);
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
    private Context context;
    protected TextView pzn;
    protected ImageView zmt;
    
    public a(Context paramContext, View paramView)
    {
      this.context = paramContext;
      eq(paramView);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    }
    
    public final boolean a(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, ehv paramehv)
    {
      if (paramBoolean)
      {
        this.pzn.setVisibility(0);
        String str = paramehv.ibS;
        if (paramehv.ibS > 99) {
          str = this.context.getString(2131766602);
        }
        this.pzn.setText(str);
      }
      for (;;)
      {
        return true;
        this.pzn.setVisibility(8);
      }
    }
    
    public final boolean ehp()
    {
      return false;
    }
    
    public abstract void eq(View paramView);
    
    public final boolean qV(boolean paramBoolean)
    {
      return com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    }
    
    public final boolean qW(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.zmt.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.zmt.setVisibility(8);
      }
    }
    
    public final boolean qX(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.pzn.setVisibility(0);
        this.pzn.setText(this.context.getString(2131755915));
      }
      for (;;)
      {
        return true;
        this.pzn.setVisibility(8);
      }
    }
  }
  
  final class b
    extends MallIndexUIv2.a
  {
    private LinearLayout zmu;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void eq(View paramView)
    {
      AppMethodBeat.i(213580);
      this.zmu = ((LinearLayout)paramView.findViewById(2131304674));
      this.zmt = ((ImageView)this.zmu.findViewById(2131304675));
      this.pzn = ((TextView)this.zmu.findViewById(2131304676));
      this.zmu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213579);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.newtips.a.exl().TC(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.br.c.b(MallIndexUIv2.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.mg(9, 0);
          com.tencent.mm.plugin.report.service.h.CyF.a(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.h.CyF.a(14419, new Object[] { MallIndexUIv2.this.uuid, Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213579);
        }
      });
      AppMethodBeat.o(213580);
    }
    
    public final String getPath()
    {
      return "pay_receiveorpay";
    }
    
    public final View getRoot()
    {
      return this.zmu;
    }
  }
  
  final class c
    extends MallIndexUIv2.a
  {
    private LinearLayout zmw;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean ehq()
    {
      AppMethodBeat.i(213583);
      com.tencent.mm.kernel.g.aAi();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofb, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.aAi();
      long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofc, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        Log.i("MicorMsg.MallIndexUIv2", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ofb, Boolean.FALSE);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ofc, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          this.zmt.setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.ADG, bool);
          AppMethodBeat.o(213583);
          return true;
          this.zmt.setVisibility(8);
        }
      }
    }
    
    public final void eq(View paramView)
    {
      AppMethodBeat.i(213582);
      this.zmw = ((LinearLayout)paramView.findViewById(2131304678));
      MallIndexUIv2.this.zll = ((TextView)this.zmw.findViewById(2131310157));
      MallIndexUIv2.a(MallIndexUIv2.this, (WcPayMoneyLoadingView)this.zmw.findViewById(2131310158));
      MallIndexUIv2.a(MallIndexUIv2.this, (ProgressBar)this.zmw.findViewById(2131310218));
      MallIndexUIv2.a(MallIndexUIv2.this, (RelativeLayout)this.zmw.findViewById(2131310156));
      MallIndexUIv2.this.getLifecycle().addObserver(MallIndexUIv2.d(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setLoadingPb(MallIndexUIv2.e(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setPrefixSymbol("¥");
      MallIndexUIv2.d(MallIndexUIv2.this).setTextColor(-1);
      MallIndexUIv2.d(MallIndexUIv2.this).setTextSize(com.tencent.mm.cb.a.fromDPToPix(MallIndexUIv2.this.getContext(), 15));
      this.zmt = ((ImageView)this.zmw.findViewById(2131304679));
      this.pzn = ((TextView)this.zmw.findViewById(2131304680));
      this.zmw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213581);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MallIndexUIv2.c(MallIndexUIv2.this);
          com.tencent.mm.plugin.newtips.a.exl().TC(15);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213581);
        }
      });
      AppMethodBeat.o(213582);
    }
    
    public final String getPath()
    {
      return "wallet";
    }
    
    public final View getRoot()
    {
      return this.zmw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2
 * JD-Core Version:    0.7.0.1
 */