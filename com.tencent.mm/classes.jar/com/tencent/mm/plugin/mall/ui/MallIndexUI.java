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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
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
public class MallIndexUI
  extends MallIndexBaseUI
  implements MStorageEx.IOnStorageChange
{
  private String egv;
  private boolean isFinished;
  private View psf;
  private TextView zlH;
  private boolean zlI;
  private zv.b zlX;
  private RelativeLayout zlY;
  private boolean zlZ;
  private boolean zma;
  u zmb;
  private boolean zmc;
  private Dialog zmd;
  private boolean zme;
  private b zmf;
  private c zmg;
  private WcPayMoneyLoadingView zmh;
  private ProgressBar zmi;
  private IListener<ov> zmj;
  private boolean zmk;
  private IListener zml;
  private IListener<aba> zmm;
  private boolean zmn;
  private boolean zmo;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(66117);
    this.isFinished = false;
    this.zmb = new u();
    this.psf = null;
    this.zlI = false;
    this.zlH = null;
    this.zmc = false;
    this.zme = false;
    this.zmf = null;
    this.zmg = null;
    this.zmj = new IListener() {};
    this.zmk = false;
    this.zml = new IListener() {};
    this.zmm = new MallIndexUI.8(this);
    this.zmn = false;
    this.zmo = false;
    AppMethodBeat.o(66117);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(66141);
    if ((paramd == null) || (Util.isNullOrNil(paramd.zjl)))
    {
      AppMethodBeat.o(66141);
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
            AppMethodBeat.i(66102);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            new Intent();
            f.cN(MallIndexUI.this, paramd.zjl);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66102);
          }
        });
      }
      AppMethodBeat.o(66141);
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
        AppMethodBeat.i(66103);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        f.bn(MallIndexUI.this.getContext(), paramd.zjl);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(66103);
      }
    });
    if (this.zlh != null)
    {
      this.zlh.addFooterView(this.psf);
      this.zlI = true;
    }
    AppMethodBeat.o(66141);
  }
  
  private void qU(boolean paramBoolean)
  {
    AppMethodBeat.i(66132);
    if (paramBoolean)
    {
      this.zll.setText(getString(2131767741));
      this.zll.setVisibility(0);
      this.zmh.setVisibility(8);
      this.zmi.setVisibility(8);
      this.zmh.reset();
      AppMethodBeat.o(66132);
      return;
    }
    this.zll.setVisibility(8);
    this.zmh.setVisibility(0);
    this.zmi.setVisibility(0);
    AppMethodBeat.o(66132);
  }
  
  protected final void dYP()
  {
    AppMethodBeat.i(66120);
    int i = getResources().getColor(2131100773);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131307165).setBackgroundColor(i);
    AppMethodBeat.o(66120);
  }
  
  protected final void egS()
  {
    AppMethodBeat.i(66121);
    setMMTitle(2131762879);
    AppMethodBeat.o(66121);
  }
  
  protected final void egT()
  {
    AppMethodBeat.i(66137);
    com.tencent.mm.plugin.mall.b.a.ehv();
    AppMethodBeat.o(66137);
  }
  
  protected final void egU()
  {
    AppMethodBeat.i(66138);
    t.fQD().fRN();
    if (((t.fQD().fRN().fRn()) || (t.fQD().fRN().fRm())) && (com.tencent.mm.model.z.aUo()))
    {
      Log.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(66138);
  }
  
  protected final boolean egV()
  {
    AppMethodBeat.i(66128);
    Log.i("MicorMsg.MallIndexUI", "init BankcardList");
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
        AppMethodBeat.i(66111);
        if ((MallIndexUI.this.isFinishing()) || (MallIndexUI.this.hasFinish()) || (MallIndexUI.this.isDestroyed()))
        {
          AppMethodBeat.o(66111);
          return;
        }
        Log.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.g(MallIndexUI.this).efW + " hasNewTips : " + MallIndexUI.g(MallIndexUI.this).efX + " swipeOn : " + MallIndexUI.g(MallIndexUI.this).efY);
        if ((MallIndexUI.h(MallIndexUI.this)) || (MallIndexUI.this.getContext().isFinishing()))
        {
          Log.e("MicorMsg.MallIndexUI", "error for callback ac finish");
          AppMethodBeat.o(66111);
          return;
        }
        Log.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localzv.efS.egx), Boolean.valueOf(this.iMQ) });
        MallIndexUI.a(MallIndexUI.this, localzv.efS);
        int i;
        Object localObject;
        boolean bool;
        if (MallIndexUI.g(MallIndexUI.this).egy != null)
        {
          i = 1;
          if ((i & MallIndexUI.g(MallIndexUI.this).egy instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUI.g(MallIndexUI.this).egy;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject).getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void eeY() {}
              });
            }
          }
          if (MallIndexUI.g(MallIndexUI.this).errCode == 0)
          {
            MallIndexUI.this.ehf();
            if (MallIndexUI.g(MallIndexUI.this).egx) {
              MallIndexUI.this.ehb();
            }
            MallIndexUI.this.egW();
            if (!this.iMQ) {
              MallIndexUI.ehl();
            }
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this));
            MallIndexUI.this.ehd();
            Log.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.g(MallIndexUI.this).egt), Boolean.valueOf(MallIndexUI.g(MallIndexUI.this).egu), MallIndexUI.g(MallIndexUI.this).egv });
            localObject = MallIndexUI.this;
            if (MallIndexUI.g(MallIndexUI.this).egt != 1) {
              break label575;
            }
            bool = true;
            label425:
            MallIndexUI.a((MallIndexUI)localObject, bool);
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).egu);
            MallIndexUI.a(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).egv);
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
          ((MallIndexUI)localObject).zmb.a(new MallIndexUI.2((MallIndexUI)localObject), localal.fRi());
          if ((localzv.efS.egx) && (this.iMQ)) {
            MallIndexUI.this.updateView();
          }
          this.iMQ = true;
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
    EventCenter.instance.asyncPublish(localzv, Looper.myLooper());
    AppMethodBeat.o(66128);
    return false;
  }
  
  protected final void egW()
  {
    AppMethodBeat.i(66129);
    Log.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
    boolean bool2;
    Object localObject;
    if ((this.zlX != null) && ((this.zlX.efV) || (this.zlX.egb)))
    {
      bool2 = t.fQI().fRs().fRc();
      localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWB, Boolean.FALSE);
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
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWB, Boolean.TRUE);
        o.hN(this);
      }
      AppMethodBeat.o(66129);
      return;
      Log.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
      AppMethodBeat.o(66129);
      return;
    }
  }
  
  protected final void egZ()
  {
    AppMethodBeat.i(66124);
    this.zlp = com.tencent.mm.plugin.mall.a.k.egL().Qd(this.zjs).field_isShowSetting;
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
          AppMethodBeat.i(66107);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicorMsg.MallIndexUI", "click settings btn");
          com.tencent.mm.br.c.V(MallIndexUI.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66107);
        }
      });
    }
    Log.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.zlp) });
    if (this.zlp == 0)
    {
      this.zlq.setVisibility(8);
      this.zlq.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(66124);
      return;
    }
    this.zlq.setVisibility(0);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66108);
        int k = com.tencent.mm.cb.a.jo(MallIndexUI.this.getContext());
        int n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUI.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUI.this.zlh.getLocationInWindow(arrayOfInt);
        int m = MallIndexUI.this.zlq.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUI.this.zlh.getHeight() - MallIndexUI.this.zlq.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cb.a.fromDPToPix(MallIndexUI.this.getContext(), 33);
        Log.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUI.this.zlq.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUI.this.zlq.setPadding(0, j, 0, n);
          AppMethodBeat.o(66108);
          return;
        }
        MallIndexUI.this.zlq.setPadding(0, n, 0, n);
        AppMethodBeat.o(66108);
      }
    });
    AppMethodBeat.o(66124);
  }
  
  protected final void eha()
  {
    AppMethodBeat.i(66127);
    final zt localzt = new zt();
    localzt.efM.scene = "1";
    localzt.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66109);
        if (!Util.isNullOrNil(localzt.efN.efO)) {
          f.a(MallIndexUI.this.zlm, localzt.efN.efO, localzt.efN.content, localzt.efN.url);
        }
        AppMethodBeat.o(66109);
      }
    };
    EventCenter.instance.publish(localzt);
    AppMethodBeat.o(66127);
  }
  
  protected final void ehb()
  {
    AppMethodBeat.i(66131);
    Log.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new al();
    if (((al)localObject).fRf())
    {
      localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXz, getString(2131764226));
      this.zll.setText((CharSequence)localObject);
      this.zll.setVisibility(0);
      this.zmh.setVisibility(8);
      this.zmi.setVisibility(8);
      AppMethodBeat.o(66131);
      return;
    }
    if (((al)localObject).fRh())
    {
      Log.i("MicorMsg.MallIndexUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.OfA, Long.valueOf(0L))).longValue();
      if (this.zmh != null)
      {
        qU(((al)localObject).fRj());
        if (this.zmh.getVisibility() == 0)
        {
          this.zmh.setMoney(f.formatMoney2f(f.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
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
  
  protected final void ehd()
  {
    AppMethodBeat.i(66133);
    removeAllOptionMenu();
    Log.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690843, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66101);
        h.CyF.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        h.CyF.a(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUI.this;
        boolean bool = MallIndexUI.g(MallIndexUI.this).egc;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.br.c.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(66101);
        return true;
      }
    });
    h.CyF.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(66133);
  }
  
  protected final void ehf()
  {
    AppMethodBeat.i(66130);
    if (this.zlk == null)
    {
      AppMethodBeat.o(66130);
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
      Log.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.zlk.setVisibility(0);
      AppMethodBeat.o(66130);
      return;
      label124:
      Log.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.zlk.setVisibility(8);
    AppMethodBeat.o(66130);
  }
  
  protected final void eq(View paramView)
  {
    AppMethodBeat.i(66125);
    this.zmf = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.exl().h(this.zmf);
    this.zmg = new c(this, paramView);
    this.zmg.ehq();
    com.tencent.mm.plugin.newtips.a.exl().h(this.zmg);
    AppMethodBeat.o(66125);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66139);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(66139);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66123);
    this.vbj = com.tencent.mm.ui.aa.jQ(this).inflate(2131495425, null);
    this.zlh.addHeaderView(this.vbj, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.vbj.findViewById(2131302284);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.egN();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66123);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66122);
    super.initView();
    this.zlh.setPadding(a.zjP, 0, a.zjP, 0);
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
        this.zmb.ehm();
        AppMethodBeat.o(66118);
        return;
      }
      this.zmb.cancel();
      AppMethodBeat.o(66118);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.aAi();
      if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oha, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(66118);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new sd();
      paramIntent.dYH.context = getContext();
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
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.mm.plugin.wallet_core.model.k.aeJ(2);
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
        return MallIndexUI.this;
      }
    };
    e.ehs();
    a.b(this, true);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.zml);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null)))
    {
      com.tencent.mm.kernel.g.aAi();
      a(new d((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ohb, "")));
      com.tencent.mm.kernel.g.aAi();
      ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oha, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    h.CyF.a(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(66119);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66136);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    this.zmj.dead();
    this.zmm.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    EventCenter.instance.removeListener(this.zml);
    AppMethodBeat.o(66136);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(66126);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicorMsg.MallIndexUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        ehb();
      }
    }
    AppMethodBeat.o(66126);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66135);
    super.onPause();
    this.zmb.onPause();
    if (this.zmh != null) {
      this.zmh.reset();
    }
    AppMethodBeat.o(66135);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66134);
    Log.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.zmb.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.fUE(), null);
    super.onResume();
    ehb();
    AppMethodBeat.o(66134);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66140);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if ((paramq instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramq).zjm);
    }
    do
    {
      do
      {
        AppMethodBeat.o(66140);
        return true;
      } while (!(paramq instanceof ad));
      paramString = (ad)paramq;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.c.g()
    {
      public final void eeY() {}
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
    extends MallIndexUI.a
  {
    private LinearLayout zmu;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void eq(View paramView)
    {
      AppMethodBeat.i(66113);
      this.zmu = ((LinearLayout)paramView.findViewById(2131304674));
      this.zmt = ((ImageView)this.zmu.findViewById(2131304675));
      this.pzn = ((TextView)this.zmu.findViewById(2131304676));
      this.zmu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.plugin.newtips.a.exl().TC(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.br.c.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.mg(9, 0);
          h.CyF.a(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          h.CyF.a(14419, new Object[] { MallIndexUI.this.uuid, Integer.valueOf(1) });
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
      return this.zmu;
    }
  }
  
  final class c
    extends MallIndexUI.a
  {
    private LinearLayout zmw;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean ehq()
    {
      AppMethodBeat.i(66116);
      com.tencent.mm.kernel.g.aAi();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofb, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.aAi();
      long l = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ofc, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        Log.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
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
          AppMethodBeat.o(66116);
          return true;
          this.zmt.setVisibility(8);
        }
      }
    }
    
    public final void eq(View paramView)
    {
      AppMethodBeat.i(66115);
      this.zmw = ((LinearLayout)paramView.findViewById(2131304678));
      MallIndexUI.this.zll = ((TextView)this.zmw.findViewById(2131310157));
      MallIndexUI.a(MallIndexUI.this, (WcPayMoneyLoadingView)this.zmw.findViewById(2131310158));
      MallIndexUI.a(MallIndexUI.this, (ProgressBar)this.zmw.findViewById(2131310218));
      MallIndexUI.this.getLifecycle().addObserver(MallIndexUI.d(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setLoadingPb(MallIndexUI.e(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setPrefixSymbol("¥");
      MallIndexUI.d(MallIndexUI.this).setTextColor(-1);
      MallIndexUI.d(MallIndexUI.this).setTextSize(com.tencent.mm.cb.a.fromDPToPix(MallIndexUI.this.getContext(), 15));
      this.zmt = ((ImageView)this.zmw.findViewById(2131304679));
      this.pzn = ((TextView)this.zmw.findViewById(2131304680));
      this.zmw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66114);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MallIndexUI.c(MallIndexUI.this);
          com.tencent.mm.plugin.newtips.a.exl().TC(15);
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
      return this.zmw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */