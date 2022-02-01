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
import com.tencent.mm.g.a.nu;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.g.a.xo.b;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.c.ab;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.i
public class MallIndexUI
  extends MallIndexBaseUI
  implements n.b
{
  private String dAW;
  private boolean gnd;
  private View nzT;
  private TextView uCF;
  private boolean uCG;
  private xq.b uCV;
  private RelativeLayout uCW;
  private boolean uCX;
  private boolean uCY;
  com.tencent.mm.plugin.wallet_core.ui.u uCZ;
  private boolean uDa;
  private Dialog uDb;
  private boolean uDc;
  private b uDd;
  private c uDe;
  private WcPayMoneyLoadingView uDf;
  private ProgressBar uDg;
  private com.tencent.mm.sdk.b.c<nu> uDh;
  private boolean uDi;
  private com.tencent.mm.sdk.b.c uDj;
  private com.tencent.mm.sdk.b.c<yt> uDk;
  private boolean uDl;
  private boolean uDm;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(66117);
    this.gnd = false;
    this.uCZ = new com.tencent.mm.plugin.wallet_core.ui.u();
    this.nzT = null;
    this.uCG = false;
    this.uCF = null;
    this.uDa = false;
    this.uDc = false;
    this.uDd = null;
    this.uDe = null;
    this.uDh = new MallIndexUI.1(this);
    this.uDi = false;
    this.uDj = new com.tencent.mm.sdk.b.c() {};
    this.uDk = new MallIndexUI.8(this);
    this.uDl = false;
    this.uDm = false;
    AppMethodBeat.o(66117);
  }
  
  private void a(final com.tencent.mm.plugin.mall.a.d paramd)
  {
    AppMethodBeat.i(66141);
    if ((paramd == null) || (bs.isNullOrNil(paramd.uAA)))
    {
      AppMethodBeat.o(66141);
      return;
    }
    if (this.uCG)
    {
      if (this.uCF != null)
      {
        this.uCF.setText(2131761087);
        this.uCF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66102);
            new Intent();
            com.tencent.mm.wallet_core.ui.e.co(MallIndexUI.this, paramd.uAA);
            AppMethodBeat.o(66102);
          }
        });
      }
      AppMethodBeat.o(66141);
      return;
    }
    this.nzT = View.inflate(this, 2131494695, null);
    this.nzT.setClickable(false);
    this.nzT.setEnabled(false);
    this.uCF = ((TextView)this.nzT.findViewById(2131306829));
    this.uCF.setVisibility(0);
    this.uCF.setText(2131761087);
    this.uCF.setTextColor(getResources().getColor(2131100547));
    this.uCF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66103);
        com.tencent.mm.wallet_core.ui.e.aT(MallIndexUI.this.getContext(), paramd.uAA);
        AppMethodBeat.o(66103);
      }
    });
    if (this.uCk != null)
    {
      this.uCk.addFooterView(this.nzT);
      this.uCG = true;
    }
    AppMethodBeat.o(66141);
  }
  
  private void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(66132);
    if (paramBoolean)
    {
      this.uCo.setText(getString(2131765298));
      this.uCo.setVisibility(0);
      this.uDf.setVisibility(8);
      this.uDg.setVisibility(8);
      this.uDf.reset();
      AppMethodBeat.o(66132);
      return;
    }
    this.uCo.setVisibility(8);
    this.uDf.setVisibility(0);
    this.uDg.setVisibility(0);
    AppMethodBeat.o(66132);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(66126);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      ac.i("MicorMsg.MallIndexUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        dbb();
      }
    }
    AppMethodBeat.o(66126);
  }
  
  protected final void cSW()
  {
    AppMethodBeat.i(66120);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66120);
  }
  
  protected final void daS()
  {
    AppMethodBeat.i(66121);
    setMMTitle(2131761092);
    AppMethodBeat.o(66121);
  }
  
  protected final void daT()
  {
    AppMethodBeat.i(66137);
    com.tencent.mm.plugin.mall.b.a.dbp();
    AppMethodBeat.o(66137);
  }
  
  protected final void daU()
  {
    AppMethodBeat.i(66138);
    s.ert().eta();
    if (((s.ert().eta().esd()) || (s.ert().eta().esc())) && (com.tencent.mm.model.u.axL()))
    {
      ac.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(66138);
  }
  
  protected final boolean daV()
  {
    AppMethodBeat.i(66128);
    ac.i("MicorMsg.MallIndexUI", "init BankcardList");
    final xq localxq = new xq();
    localxq.dAt.scene = 1;
    localxq.dAt.dAv = true;
    localxq.dAt.retryCount = 0;
    localxq.dAt.dAw = true;
    localxq.dAu.dAl = new Runnable()
    {
      boolean hwA = false;
      
      public final void run()
      {
        AppMethodBeat.i(66111);
        if ((MallIndexUI.this.isFinishing()) || (MallIndexUI.this.hasFinish()) || (MallIndexUI.this.isDestroyed()))
        {
          AppMethodBeat.o(66111);
          return;
        }
        ac.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.g(MallIndexUI.this).dAy + " hasNewTips : " + MallIndexUI.g(MallIndexUI.this).dAz + " swipeOn : " + MallIndexUI.g(MallIndexUI.this).dAA);
        if ((MallIndexUI.h(MallIndexUI.this)) || (MallIndexUI.this.getContext().isFinishing()))
        {
          ac.e("MicorMsg.MallIndexUI", "error for callback ac finish");
          AppMethodBeat.o(66111);
          return;
        }
        ac.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localxq.dAu.dAY), Boolean.valueOf(this.hwA) });
        MallIndexUI.a(MallIndexUI.this, localxq.dAu);
        int i;
        Object localObject;
        boolean bool;
        if (MallIndexUI.g(MallIndexUI.this).dAZ != null)
        {
          i = 1;
          if ((i & MallIndexUI.g(MallIndexUI.this).dAZ instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUI.g(MallIndexUI.this).dAZ;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject).getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void dan() {}
              });
            }
          }
          if (MallIndexUI.g(MallIndexUI.this).errCode == 0)
          {
            MallIndexUI.this.dbf();
            if (MallIndexUI.g(MallIndexUI.this).dAY) {
              MallIndexUI.this.dbb();
            }
            MallIndexUI.this.daW();
            if (!this.hwA) {
              MallIndexUI.dbg();
            }
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this));
            MallIndexUI.this.dbd();
            ac.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.g(MallIndexUI.this).dAU), Boolean.valueOf(MallIndexUI.g(MallIndexUI.this).dAV), MallIndexUI.g(MallIndexUI.this).dAW });
            localObject = MallIndexUI.this;
            if (MallIndexUI.g(MallIndexUI.this).dAU != 1) {
              break label575;
            }
            bool = true;
            label425:
            MallIndexUI.a((MallIndexUI)localObject, bool);
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dAV);
            MallIndexUI.a(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dAW);
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
          ak localak = new ak();
          ((MallIndexUI)localObject).uCZ.a(new MallIndexUI.2((MallIndexUI)localObject), localak.erY());
          if ((localxq.dAu.dAY) && (this.hwA)) {
            MallIndexUI.this.cL();
          }
          this.hwA = true;
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
    com.tencent.mm.sdk.b.a.GpY.a(localxq, Looper.myLooper());
    AppMethodBeat.o(66128);
    return false;
  }
  
  protected final void daW()
  {
    AppMethodBeat.i(66129);
    ac.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
    boolean bool2;
    Object localObject;
    if ((this.uCV != null) && ((this.uCV.dAx) || (this.uCV.dAD)))
    {
      bool2 = s.ery().esi().erS();
      localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHK, Boolean.FALSE);
      if (localObject == null) {
        break label263;
      }
    }
    label263:
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      ac.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHK, Boolean.TRUE);
        localObject = new d.a(this);
        View localView = LayoutInflater.from(this).inflate(2131496035, null, false);
        ImageView localImageView = (ImageView)localView.findViewById(2131307100);
        TextView localTextView = (TextView)localView.findViewById(2131307101);
        localImageView.setImageResource(2131234716);
        localTextView.setText(2131761095);
        ((d.a)localObject).yg(true);
        ((d.a)localObject).yf(false);
        ((d.a)localObject).gH(localView);
        ((d.a)localObject).acF(2131765891);
        ((d.a)localObject).acM(2131766205);
        ((d.a)localObject).fvp().show();
      }
      AppMethodBeat.o(66129);
      return;
      ac.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
      AppMethodBeat.o(66129);
      return;
    }
  }
  
  protected final void daZ()
  {
    AppMethodBeat.i(66124);
    this.uCs = j.daN().Ig(this.uAH).field_isShowSetting;
    if (this.uCt == null)
    {
      this.uCt = z.jD(this).inflate(2131494698, null);
      this.uCk.addFooterView(this.uCt, null, false);
      TextView localTextView = (TextView)this.uCt.findViewById(2131302290);
      com.tencent.mm.wallet_core.ui.e.aT(localTextView, 100);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66107);
          ac.i("MicorMsg.MallIndexUI", "click settings btn");
          com.tencent.mm.br.d.N(MallIndexUI.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          AppMethodBeat.o(66107);
        }
      });
    }
    ac.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.uCs) });
    if (this.uCs == 0)
    {
      this.uCt.setVisibility(8);
      this.uCt.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(66124);
      return;
    }
    this.uCt.setVisibility(0);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66108);
        int k = com.tencent.mm.cc.a.ih(MallIndexUI.this.getContext());
        int n = com.tencent.mm.cc.a.fromDPToPix(MallIndexUI.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUI.this.uCk.getLocationInWindow(arrayOfInt);
        int m = MallIndexUI.this.uCt.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUI.this.uCk.getHeight() - MallIndexUI.this.uCt.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cc.a.fromDPToPix(MallIndexUI.this.getContext(), 33);
        ac.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUI.this.uCt.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUI.this.uCt.setPadding(0, j, 0, n);
          AppMethodBeat.o(66108);
          return;
        }
        MallIndexUI.this.uCt.setPadding(0, n, 0, n);
        AppMethodBeat.o(66108);
      }
    });
    AppMethodBeat.o(66124);
  }
  
  protected final void dba()
  {
    AppMethodBeat.i(66127);
    final xo localxo = new xo();
    localxo.dAo.scene = "1";
    localxo.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66109);
        if (!bs.isNullOrNil(localxo.dAp.dAq)) {
          com.tencent.mm.wallet_core.ui.e.a(MallIndexUI.this.uCp, localxo.dAp.dAq, localxo.dAp.content, localxo.dAp.url);
        }
        AppMethodBeat.o(66109);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.l(localxo);
    AppMethodBeat.o(66127);
  }
  
  protected final void dbb()
  {
    AppMethodBeat.i(66131);
    ac.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new ak();
    if (((ak)localObject).erV())
    {
      localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GII, getString(2131762204));
      this.uCo.setText((CharSequence)localObject);
      this.uCo.setVisibility(0);
      this.uDf.setVisibility(8);
      this.uDg.setVisibility(8);
      AppMethodBeat.o(66131);
      return;
    }
    if (((ak)localObject).erX())
    {
      ac.i("MicorMsg.MallIndexUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ah.a.GQn, Long.valueOf(0L))).longValue();
      if (this.uDf != null)
      {
        nQ(((ak)localObject).erZ());
        if (this.uDf.getVisibility() == 0)
        {
          this.uDf.setMoney(com.tencent.mm.wallet_core.ui.e.C(com.tencent.mm.wallet_core.ui.e.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(66131);
        }
      }
      else
      {
        ac.w("MicorMsg.MallIndexUI", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(66131);
  }
  
  protected final void dbd()
  {
    AppMethodBeat.i(66133);
    removeAllOptionMenu();
    ac.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690603, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66101);
        h.wUl.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        h.wUl.f(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUI.this;
        boolean bool = MallIndexUI.g(MallIndexUI.this).dAE;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.br.d.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(66101);
        return true;
      }
    });
    h.wUl.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(66133);
  }
  
  protected final void dbf()
  {
    AppMethodBeat.i(66130);
    if (this.uCn == null)
    {
      AppMethodBeat.o(66130);
      return;
    }
    if ((!com.tencent.mm.y.c.aeH().b(ah.a.GOi, ah.a.GOj)) && (!this.uCV.dAz))
    {
      com.tencent.mm.plugin.wallet_core.model.n localn = s.ery().BAF;
      if (localn == null) {
        break label132;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.g.agS();
      if ((((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHf, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      ac.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.uCn.setVisibility(0);
      AppMethodBeat.o(66130);
      return;
      label124:
      ac.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.uCn.setVisibility(8);
    AppMethodBeat.o(66130);
  }
  
  protected final void ek(View paramView)
  {
    AppMethodBeat.i(66125);
    this.uDd = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.dkb().h(this.uDd);
    this.uDe = new c(this, paramView);
    this.uDe.dbl();
    com.tencent.mm.plugin.newtips.a.dkb().h(this.uDe);
    AppMethodBeat.o(66125);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66139);
    this.gnd = true;
    super.finish();
    AppMethodBeat.o(66139);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66123);
    this.rjd = z.jD(this).inflate(2131494697, null);
    this.uCk.addHeaderView(this.rjd, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.rjd.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.daP();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66123);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66122);
    super.initView();
    this.uCk.setPadding(a.uBc, 0, a.uBc, 0);
    AppMethodBeat.o(66122);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66118);
    ac.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.uCZ.dbh();
        AppMethodBeat.o(66118);
        return;
      }
      this.uCZ.cancel();
      AppMethodBeat.o(66118);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.agS();
      if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRz, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(66118);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new qv();
      paramIntent.dtQ.context = getContext();
      com.tencent.mm.sdk.b.a.GpY.l(paramIntent);
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
    com.tencent.mm.plugin.wallet_core.model.k.TG(2);
    this.uCV = new xq.b();
    this.uCV.dAx = false;
    this.uCV.dAy = true;
    this.uCV.dAz = false;
    this.uDh.alive();
    this.uDk.alive();
    this.uCZ.BJI = new u.b()
    {
      public final int dbj()
      {
        return 3;
      }
      
      public final Context getContext()
      {
        return MallIndexUI.this;
      }
    };
    c.dbm();
    a.c(this, true);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.GpY.c(this.uDj);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null)))
    {
      com.tencent.mm.kernel.g.agS();
      a(new com.tencent.mm.plugin.mall.a.d((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRA, "")));
      com.tencent.mm.kernel.g.agS();
      ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRz, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    h.wUl.f(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(66119);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66136);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    this.uDh.dead();
    this.uDk.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    com.tencent.mm.sdk.b.a.GpY.d(this.uDj);
    AppMethodBeat.o(66136);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66135);
    super.onPause();
    this.uCZ.onPause();
    if (this.uDf != null) {
      this.uDf.reset();
    }
    AppMethodBeat.o(66135);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66134);
    ac.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.uCZ.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.evh(), null);
    super.onResume();
    dbb();
    AppMethodBeat.o(66134);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(66140);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramn).uAB);
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
      public final void dan() {}
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
    private LinearLayout uDt;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void ek(View paramView)
    {
      AppMethodBeat.i(66113);
      this.uDt = ((LinearLayout)paramView.findViewById(2131302280));
      this.uDr = ((ImageView)this.uDt.findViewById(2131302281));
      this.uDs = ((TextView)this.uDt.findViewById(2131302282));
      this.uDt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66112);
          com.tencent.mm.plugin.newtips.a.dkb().Ko(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.br.d.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ab.km(9, 0);
          h.wUl.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          h.wUl.f(14419, new Object[] { MallIndexUI.this.uuid, Integer.valueOf(1) });
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
      return this.uDt;
    }
  }
  
  final class c
    extends MallIndexUI.a
  {
    private LinearLayout uDv;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean dbl()
    {
      AppMethodBeat.i(66116);
      com.tencent.mm.kernel.g.agS();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPP, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.agS();
      long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPQ, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        ac.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPP, Boolean.FALSE);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPQ, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          this.uDr.setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.vnt, bool);
          AppMethodBeat.o(66116);
          return true;
          this.uDr.setVisibility(8);
        }
      }
    }
    
    public final void ek(View paramView)
    {
      AppMethodBeat.i(66115);
      this.uDv = ((LinearLayout)paramView.findViewById(2131302284));
      MallIndexUI.this.uCo = ((TextView)this.uDv.findViewById(2131306696));
      MallIndexUI.a(MallIndexUI.this, (WcPayMoneyLoadingView)this.uDv.findViewById(2131306697));
      MallIndexUI.a(MallIndexUI.this, (ProgressBar)this.uDv.findViewById(2131306757));
      MallIndexUI.this.getLifecycle().addObserver(MallIndexUI.d(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setLoadingPb(MallIndexUI.e(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setPrefixSymbol("¥");
      MallIndexUI.d(MallIndexUI.this).setTextColor(-1);
      MallIndexUI.d(MallIndexUI.this).setTextSize(com.tencent.mm.cc.a.fromDPToPix(MallIndexUI.this.getContext(), 15));
      this.uDr = ((ImageView)this.uDv.findViewById(2131302285));
      this.uDs = ((TextView)this.uDv.findViewById(2131302286));
      this.uDv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66114);
          MallIndexUI.c(MallIndexUI.this);
          com.tencent.mm.plugin.newtips.a.dkb().Ko(15);
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
      return this.uDv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */