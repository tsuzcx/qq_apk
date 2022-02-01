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
import com.tencent.mm.g.a.nl;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.xd.b;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.a.xf.b;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.aa;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.i
public class MallIndexUI
  extends MallIndexBaseUI
  implements n.b
{
  private String dDk;
  private boolean goa;
  private View mXu;
  private xf.b tuC;
  private RelativeLayout tuD;
  private boolean tuE;
  private boolean tuF;
  com.tencent.mm.plugin.wallet_core.ui.u tuG;
  private boolean tuH;
  private Dialog tuI;
  private boolean tuJ;
  private b tuK;
  private c tuL;
  private WcPayMoneyLoadingView tuM;
  private ProgressBar tuN;
  private com.tencent.mm.sdk.b.c<nl> tuO;
  private boolean tuP;
  private com.tencent.mm.sdk.b.c tuQ;
  private com.tencent.mm.sdk.b.c<yi> tuR;
  private boolean tuS;
  private boolean tuT;
  private TextView tum;
  private boolean tun;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(66117);
    this.goa = false;
    this.tuG = new com.tencent.mm.plugin.wallet_core.ui.u();
    this.mXu = null;
    this.tun = false;
    this.tum = null;
    this.tuH = false;
    this.tuJ = false;
    this.tuK = null;
    this.tuL = null;
    this.tuO = new com.tencent.mm.sdk.b.c() {};
    this.tuP = false;
    this.tuQ = new com.tencent.mm.sdk.b.c() {};
    this.tuR = new MallIndexUI.8(this);
    this.tuS = false;
    this.tuT = false;
    AppMethodBeat.o(66117);
  }
  
  private void a(final com.tencent.mm.plugin.mall.a.d paramd)
  {
    AppMethodBeat.i(66141);
    if ((paramd == null) || (bt.isNullOrNil(paramd.tsh)))
    {
      AppMethodBeat.o(66141);
      return;
    }
    if (this.tun)
    {
      if (this.tum != null)
      {
        this.tum.setText(2131761087);
        this.tum.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66102);
            new Intent();
            com.tencent.mm.wallet_core.ui.e.co(MallIndexUI.this, paramd.tsh);
            AppMethodBeat.o(66102);
          }
        });
      }
      AppMethodBeat.o(66141);
      return;
    }
    this.mXu = View.inflate(this, 2131494695, null);
    this.mXu.setClickable(false);
    this.mXu.setEnabled(false);
    this.tum = ((TextView)this.mXu.findViewById(2131306829));
    this.tum.setVisibility(0);
    this.tum.setText(2131761087);
    this.tum.setTextColor(getResources().getColor(2131100547));
    this.tum.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66103);
        com.tencent.mm.wallet_core.ui.e.aS(MallIndexUI.this.getContext(), paramd.tsh);
        AppMethodBeat.o(66103);
      }
    });
    if (this.ttR != null)
    {
      this.ttR.addFooterView(this.mXu);
      this.tun = true;
    }
    AppMethodBeat.o(66141);
  }
  
  private void mX(boolean paramBoolean)
  {
    AppMethodBeat.i(66132);
    if (paramBoolean)
    {
      this.ttV.setText(getString(2131765298));
      this.ttV.setVisibility(0);
      this.tuM.setVisibility(8);
      this.tuN.setVisibility(8);
      this.tuM.reset();
      AppMethodBeat.o(66132);
      return;
    }
    this.ttV.setVisibility(8);
    this.tuM.setVisibility(0);
    this.tuN.setVisibility(0);
    AppMethodBeat.o(66132);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(66126);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        cNu();
      }
    }
    AppMethodBeat.o(66126);
  }
  
  protected final void cFM()
  {
    AppMethodBeat.i(66120);
    int i = getResources().getColor(2131100605);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(2131304246).setBackgroundColor(i);
    AppMethodBeat.o(66120);
  }
  
  protected final void cNl()
  {
    AppMethodBeat.i(66121);
    setMMTitle(2131761092);
    AppMethodBeat.o(66121);
  }
  
  protected final void cNm()
  {
    AppMethodBeat.i(66137);
    com.tencent.mm.plugin.mall.b.a.cNI();
    AppMethodBeat.o(66137);
  }
  
  protected final void cNn()
  {
    AppMethodBeat.i(66138);
    s.ebX().edF();
    if (((s.ebX().edF().ecI()) || (s.ebX().edF().ecH())) && (com.tencent.mm.model.u.aqV()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(66138);
  }
  
  protected final boolean cNo()
  {
    AppMethodBeat.i(66128);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "init BankcardList");
    final xf localxf = new xf();
    localxf.dCH.scene = 1;
    localxf.dCH.dCJ = true;
    localxf.dCH.retryCount = 0;
    localxf.dCH.dCK = true;
    localxf.dCI.dCz = new Runnable()
    {
      boolean gWb = false;
      
      public final void run()
      {
        AppMethodBeat.i(66111);
        if ((MallIndexUI.this.isFinishing()) || (MallIndexUI.this.hasFinish()) || (MallIndexUI.this.isDestroyed()))
        {
          AppMethodBeat.o(66111);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.g(MallIndexUI.this).dCM + " hasNewTips : " + MallIndexUI.g(MallIndexUI.this).dCN + " swipeOn : " + MallIndexUI.g(MallIndexUI.this).dCO);
        if ((MallIndexUI.h(MallIndexUI.this)) || (MallIndexUI.this.getContext().isFinishing()))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexUI", "error for callback ac finish");
          AppMethodBeat.o(66111);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localxf.dCI.dDm), Boolean.valueOf(this.gWb) });
        MallIndexUI.a(MallIndexUI.this, localxf.dCI);
        int i;
        Object localObject;
        boolean bool;
        if (MallIndexUI.g(MallIndexUI.this).dDn != null)
        {
          i = 1;
          if ((i & MallIndexUI.g(MallIndexUI.this).dDn instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUI.g(MallIndexUI.this).dDn;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject).getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.c.g()
              {
                public final void cMH() {}
              });
            }
          }
          if (MallIndexUI.g(MallIndexUI.this).errCode == 0)
          {
            MallIndexUI.this.cNy();
            if (MallIndexUI.g(MallIndexUI.this).dDm) {
              MallIndexUI.this.cNu();
            }
            MallIndexUI.this.cNp();
            if (!this.gWb) {
              MallIndexUI.cNz();
            }
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this));
            MallIndexUI.this.cNw();
            com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.g(MallIndexUI.this).dDi), Boolean.valueOf(MallIndexUI.g(MallIndexUI.this).dDj), MallIndexUI.g(MallIndexUI.this).dDk });
            localObject = MallIndexUI.this;
            if (MallIndexUI.g(MallIndexUI.this).dDi != 1) {
              break label575;
            }
            bool = true;
            label425:
            MallIndexUI.a((MallIndexUI)localObject, bool);
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dDj);
            MallIndexUI.a(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).dDk);
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
          ((MallIndexUI)localObject).tuG.a(new MallIndexUI.2((MallIndexUI)localObject), localak.ecD());
          if ((localxf.dCI.dDm) && (this.gWb)) {
            MallIndexUI.this.cE();
          }
          this.gWb = true;
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
    com.tencent.mm.sdk.b.a.ESL.a(localxf, Looper.myLooper());
    AppMethodBeat.o(66128);
    return false;
  }
  
  protected final void cNp()
  {
    AppMethodBeat.i(66129);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
    boolean bool2;
    Object localObject;
    if ((this.tuC != null) && ((this.tuC.dCL) || (this.tuC.dCR)))
    {
      bool2 = s.ecc().ecN().ecw();
      localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FjV, Boolean.FALSE);
      if (localObject == null) {
        break label263;
      }
    }
    label263:
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
      if ((!bool1) && (bool2))
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FjV, Boolean.TRUE);
        localObject = new d.a(this);
        View localView = LayoutInflater.from(this).inflate(2131496035, null, false);
        ImageView localImageView = (ImageView)localView.findViewById(2131307100);
        TextView localTextView = (TextView)localView.findViewById(2131307101);
        localImageView.setImageResource(2131234716);
        localTextView.setText(2131761095);
        ((d.a)localObject).wY(true);
        ((d.a)localObject).wX(false);
        ((d.a)localObject).gs(localView);
        ((d.a)localObject).aau(2131765891);
        ((d.a)localObject).aaB(2131766205);
        ((d.a)localObject).fft().show();
      }
      AppMethodBeat.o(66129);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
      AppMethodBeat.o(66129);
      return;
    }
  }
  
  protected final void cNs()
  {
    AppMethodBeat.i(66124);
    this.ttZ = j.cNg().Gk(this.tso).field_isShowSetting;
    if (this.tua == null)
    {
      this.tua = com.tencent.mm.ui.y.js(this).inflate(2131494698, null);
      this.ttR.addFooterView(this.tua, null, false);
      TextView localTextView = (TextView)this.tua.findViewById(2131302290);
      com.tencent.mm.wallet_core.ui.e.aS(localTextView, 100);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66107);
          com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "click settings btn");
          com.tencent.mm.bs.d.O(MallIndexUI.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          AppMethodBeat.o(66107);
        }
      });
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.ttZ) });
    if (this.ttZ == 0)
    {
      this.tua.setVisibility(8);
      this.tua.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(66124);
      return;
    }
    this.tua.setVisibility(0);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66108);
        int k = com.tencent.mm.cd.a.hW(MallIndexUI.this.getContext());
        int n = com.tencent.mm.cd.a.fromDPToPix(MallIndexUI.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUI.this.ttR.getLocationInWindow(arrayOfInt);
        int m = MallIndexUI.this.tua.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUI.this.ttR.getHeight() - MallIndexUI.this.tua.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cd.a.fromDPToPix(MallIndexUI.this.getContext(), 33);
        com.tencent.mm.sdk.platformtools.ad.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUI.this.tua.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUI.this.tua.setPadding(0, j, 0, n);
          AppMethodBeat.o(66108);
          return;
        }
        MallIndexUI.this.tua.setPadding(0, n, 0, n);
        AppMethodBeat.o(66108);
      }
    });
    AppMethodBeat.o(66124);
  }
  
  protected final void cNt()
  {
    AppMethodBeat.i(66127);
    final xd localxd = new xd();
    localxd.dCC.scene = "1";
    localxd.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66109);
        if (!bt.isNullOrNil(localxd.dCD.dCE)) {
          com.tencent.mm.wallet_core.ui.e.a(MallIndexUI.this.ttW, localxd.dCD.dCE, localxd.dCD.content, localxd.dCD.url);
        }
        AppMethodBeat.o(66109);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.l(localxd);
    AppMethodBeat.o(66127);
  }
  
  protected final void cNu()
  {
    AppMethodBeat.i(66131);
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new ak();
    if (((ak)localObject).ecA())
    {
      localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkT, getString(2131762204));
      this.ttV.setText((CharSequence)localObject);
      this.ttV.setVisibility(0);
      this.tuM.setVisibility(8);
      this.tuN.setVisibility(8);
      AppMethodBeat.o(66131);
      return;
    }
    if (((ak)localObject).ecC())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ae.a.Fsw, Long.valueOf(0L))).longValue();
      if (this.tuM != null)
      {
        mX(((ak)localObject).ecE());
        if (this.tuM.getVisibility() == 0)
        {
          this.tuM.setMoney(com.tencent.mm.wallet_core.ui.e.D(com.tencent.mm.wallet_core.ui.e.a(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
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
  
  protected final void cNw()
  {
    AppMethodBeat.i(66133);
    removeAllOptionMenu();
    com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, 2131690603, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66101);
        h.vKh.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        h.vKh.f(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUI.this;
        boolean bool = MallIndexUI.g(MallIndexUI.this).dCS;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.bs.d.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(66101);
        return true;
      }
    });
    h.vKh.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(66133);
  }
  
  protected final void cNy()
  {
    AppMethodBeat.i(66130);
    if (this.ttU == null)
    {
      AppMethodBeat.o(66130);
      return;
    }
    if ((!com.tencent.mm.z.c.adr().b(ae.a.Fqs, ae.a.Fqt)) && (!this.tuC.dCN))
    {
      com.tencent.mm.plugin.wallet_core.model.n localn = s.ecc().Aik;
      if (localn == null) {
        break label132;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.g.afC();
      if ((((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fjq, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.ttU.setVisibility(0);
      AppMethodBeat.o(66130);
      return;
      label124:
      com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.ttU.setVisibility(8);
    AppMethodBeat.o(66130);
  }
  
  protected final void eb(View paramView)
  {
    AppMethodBeat.i(66125);
    this.tuK = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.cWs().h(this.tuK);
    this.tuL = new c(this, paramView);
    this.tuL.cNE();
    com.tencent.mm.plugin.newtips.a.cWs().h(this.tuL);
    AppMethodBeat.o(66125);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66139);
    this.goa = true;
    super.finish();
    AppMethodBeat.o(66139);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66123);
    this.qwn = com.tencent.mm.ui.y.js(this).inflate(2131494697, null);
    this.ttR.addHeaderView(this.qwn, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.qwn.findViewById(2131300712);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.cNi();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66123);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66122);
    super.initView();
    this.ttR.setPadding(a.tsJ, 0, a.tsJ, 0);
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
        this.tuG.cNA();
        AppMethodBeat.o(66118);
        return;
      }
      this.tuG.cancel();
      AppMethodBeat.o(66118);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.g.afC();
      if (!((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtF, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(66118);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new qm();
      paramIntent.dwd.context = getContext();
      com.tencent.mm.sdk.b.a.ESL.l(paramIntent);
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
    com.tencent.mm.plugin.wallet_core.model.k.Rx(2);
    this.tuC = new xf.b();
    this.tuC.dCL = false;
    this.tuC.dCM = true;
    this.tuC.dCN = false;
    this.tuO.alive();
    this.tuR.alive();
    this.tuG.Aro = new u.b()
    {
      public final int cNC()
      {
        return 3;
      }
      
      public final Context getContext()
      {
        return MallIndexUI.this;
      }
    };
    c.cNF();
    a.b(this, true);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ESL.c(this.tuQ);
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.ax.b.yL((String)com.tencent.mm.kernel.g.afB().afk().get(274436, null)))
    {
      com.tencent.mm.kernel.g.afC();
      a(new com.tencent.mm.plugin.mall.a.d((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtG, "")));
      com.tencent.mm.kernel.g.afC();
      ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FtF, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    h.vKh.f(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(66119);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66136);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    this.tuO.dead();
    this.tuR.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    com.tencent.mm.sdk.b.a.ESL.d(this.tuQ);
    AppMethodBeat.o(66136);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66135);
    super.onPause();
    this.tuG.onPause();
    if (this.tuM != null) {
      this.tuM.reset();
    }
    AppMethodBeat.o(66135);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66134);
    com.tencent.mm.sdk.platformtools.ad.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.tuG.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.efN(), null);
    super.onResume();
    cNu();
    AppMethodBeat.o(66134);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(66140);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
    if ((paramn instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramn).tsi);
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
      public final void cMH() {}
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
    private LinearLayout tva;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final void eb(View paramView)
    {
      AppMethodBeat.i(66113);
      this.tva = ((LinearLayout)paramView.findViewById(2131302280));
      this.tuY = ((ImageView)this.tva.findViewById(2131302281));
      this.tuZ = ((TextView)this.tva.findViewById(2131302282));
      this.tva.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66112);
          com.tencent.mm.plugin.newtips.a.cWs().Ip(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.bs.d.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          com.tencent.mm.wallet_core.c.ab.jZ(9, 0);
          h.vKh.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          h.vKh.f(14419, new Object[] { MallIndexUI.this.uuid, Integer.valueOf(1) });
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
      return this.tva;
    }
  }
  
  final class c
    extends MallIndexUI.a
  {
    private LinearLayout tvc;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean cNE()
    {
      AppMethodBeat.i(66116);
      com.tencent.mm.kernel.g.afC();
      boolean bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FrZ, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.g.afC();
      long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fsa, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FrZ, Boolean.FALSE);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fsa, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          this.tuY.setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.uev, bool);
          AppMethodBeat.o(66116);
          return true;
          this.tuY.setVisibility(8);
        }
      }
    }
    
    public final void eb(View paramView)
    {
      AppMethodBeat.i(66115);
      this.tvc = ((LinearLayout)paramView.findViewById(2131302284));
      MallIndexUI.this.ttV = ((TextView)this.tvc.findViewById(2131306696));
      MallIndexUI.a(MallIndexUI.this, (WcPayMoneyLoadingView)this.tvc.findViewById(2131306697));
      MallIndexUI.a(MallIndexUI.this, (ProgressBar)this.tvc.findViewById(2131306757));
      MallIndexUI.this.getLifecycle().addObserver(MallIndexUI.d(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setLoadingPb(MallIndexUI.e(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setPrefixSymbol("¥");
      MallIndexUI.d(MallIndexUI.this).setTextColor(-1);
      MallIndexUI.d(MallIndexUI.this).setTextSize(com.tencent.mm.cd.a.fromDPToPix(MallIndexUI.this.getContext(), 15));
      this.tuY = ((ImageView)this.tvc.findViewById(2131302285));
      this.tuZ = ((TextView)this.tvc.findViewById(2131302286));
      this.tvc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66114);
          MallIndexUI.c(MallIndexUI.this);
          com.tencent.mm.plugin.newtips.a.cWs().Ip(15);
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
      return this.tvc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */