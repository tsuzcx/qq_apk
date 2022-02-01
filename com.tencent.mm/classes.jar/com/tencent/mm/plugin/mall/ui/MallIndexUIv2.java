package com.tencent.mm.plugin.mall.ui;

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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.autogen.a.acz;
import com.tencent.mm.autogen.a.acz.b;
import com.tencent.mm.autogen.a.adl;
import com.tencent.mm.autogen.a.aef;
import com.tencent.mm.autogen.a.rf;
import com.tencent.mm.autogen.a.ut;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wallet_core.ui.w;
import com.tencent.mm.plugin.wallet_core.ui.w.a;
import com.tencent.mm.plugin.wallet_core.ui.w.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

@com.tencent.mm.kernel.k
public class MallIndexUIv2
  extends MallIndexBaseUIv2
  implements MStorageEx.IOnStorageChange
{
  acz.b KLM;
  private RelativeLayout KLN;
  private boolean KLO;
  private boolean KLP;
  w KLQ;
  private boolean KLR;
  private Dialog KLS;
  private boolean KLT;
  private WcPayMoneyLoadingView KLW;
  private ProgressBar KLX;
  private IListener<rf> KLY;
  private boolean KLZ;
  private TextView KLv;
  private boolean KLw;
  private IListener KMa;
  private IListener<aef> KMb;
  private boolean KMd;
  private RelativeLayout KMn;
  private b KMo;
  private c KMp;
  private int KMq;
  private ArrayList<t> KMr;
  private String igU;
  private boolean isFinished;
  private View uiE;
  
  public MallIndexUIv2()
  {
    AppMethodBeat.i(262472);
    this.isFinished = false;
    this.KLQ = new w();
    this.uiE = null;
    this.KLw = false;
    this.KLv = null;
    this.KLR = false;
    this.KLT = false;
    this.KMo = null;
    this.KMp = null;
    this.KLY = new MallIndexUIv2.1(this, com.tencent.mm.app.f.hfK);
    this.KLZ = false;
    this.KMa = new IListener(com.tencent.mm.app.f.hfK) {};
    this.KMb = new MallIndexUIv2.3(this, com.tencent.mm.app.f.hfK);
    this.KMd = false;
    AppMethodBeat.o(262472);
  }
  
  private void a(final d paramd)
  {
    AppMethodBeat.i(262477);
    if ((paramd == null) || (Util.isNullOrNil(paramd.KJa)))
    {
      AppMethodBeat.o(262477);
      return;
    }
    if (this.KLw)
    {
      if (this.KLv != null)
      {
        this.KLv.setText(a.i.mall_gdpr_mall_index);
        this.KLv.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
        {
          public final void dr(View paramAnonymousView)
          {
            AppMethodBeat.i(262402);
            new Intent();
            com.tencent.mm.wallet_core.ui.i.dh(MallIndexUIv2.this, paramd.KJa);
            AppMethodBeat.o(262402);
          }
        });
      }
      AppMethodBeat.o(262477);
      return;
    }
    this.uiE = View.inflate(this, a.g.mall_index_gdpr_foot, null);
    this.uiE.setClickable(false);
    this.uiE.setEnabled(false);
    this.KLv = ((TextView)this.uiE.findViewById(a.f.wallet_region_desc));
    this.KLv.setVisibility(0);
    this.KLv.setText(a.i.mall_gdpr_mall_index);
    this.KLv.setTextColor(getResources().getColor(a.c.link_color));
    this.KLv.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(262395);
        com.tencent.mm.wallet_core.ui.i.bC(MallIndexUIv2.this.getContext(), paramd.KJa);
        AppMethodBeat.o(262395);
      }
    });
    if (this.KKV != null)
    {
      this.KKV.addFooterView(this.uiE);
      this.KLw = true;
    }
    AppMethodBeat.o(262477);
  }
  
  private void fZF()
  {
    AppMethodBeat.i(262478);
    LinearLayout localLinearLayout1 = (LinearLayout)this.Fag.findViewById(a.f.minh_wallet_layout);
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLinearLayout1.getLayoutParams();
    LinearLayout localLinearLayout2 = (LinearLayout)this.Fag.findViewById(a.f.minh_pos_layout);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams();
    int i = ((Integer)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.adga, Integer.valueOf(0))).intValue();
    Log.i("MicorMsg.MallIndexUIv2", "init lastInterval:%s", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      AppMethodBeat.o(262478);
      return;
    }
    localLayoutParams2.leftMargin = i;
    localLinearLayout2.setLayoutParams(localLayoutParams2);
    localLayoutParams1.rightMargin = i;
    localLinearLayout1.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(262478);
  }
  
  private void yl(boolean paramBoolean)
  {
    AppMethodBeat.i(262475);
    if (paramBoolean)
    {
      this.KKZ.setText(getString(a.i.wallet_index_ui_balance_hide));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.KKZ.getLayoutParams();
      localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
      this.KKZ.setLayoutParams(localLayoutParams);
      this.KKZ.setVisibility(0);
      this.KLW.setVisibility(8);
      this.KLX.setVisibility(8);
      this.KMn.setVisibility(8);
      this.KLW.reset();
      AppMethodBeat.o(262475);
      return;
    }
    this.KKZ.setVisibility(8);
    this.KLW.setVisibility(0);
    this.KLX.setVisibility(0);
    this.KMn.setVisibility(0);
    AppMethodBeat.o(262475);
  }
  
  protected final void fPx()
  {
    AppMethodBeat.i(262515);
    int i = getResources().getColor(a.c.mall_index_new_bg_color);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(a.f.root_layout).setBackgroundColor(i);
    AppMethodBeat.o(262515);
  }
  
  protected final void fZi()
  {
    AppMethodBeat.i(262517);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXe, false);
    Log.i("MicorMsg.MallIndexUIv2", " cn wallet open new name ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      setMMTitle(a.i.mall_index_ui_title_new);
      AppMethodBeat.o(262517);
      return;
    }
    setMMTitle(a.i.mall_index_ui_title);
    AppMethodBeat.o(262517);
  }
  
  protected final void fZj()
  {
    AppMethodBeat.i(262507);
    com.tencent.mm.plugin.mall.b.b.fZL();
    AppMethodBeat.o(262507);
  }
  
  protected final boolean fZl()
  {
    AppMethodBeat.i(262494);
    Log.i("MicorMsg.MallIndexUIv2", "init BankcardList");
    final acz localacz = new acz();
    localacz.igq.scene = 1;
    localacz.igq.igs = true;
    localacz.igq.retryCount = 0;
    localacz.igq.igt = true;
    localacz.igr.igh = new Runnable()
    {
      boolean ouJ = false;
      
      public final void run()
      {
        AppMethodBeat.i(262422);
        if ((MallIndexUIv2.this.isFinishing()) || (MallIndexUIv2.this.hasFinish()) || (MallIndexUIv2.this.isDestroyed()))
        {
          AppMethodBeat.o(262422);
          return;
        }
        Log.d("MicorMsg.MallIndexUIv2", "mUserInfo needBind : " + MallIndexUIv2.g(MallIndexUIv2.this).igv + " hasNewTips : " + MallIndexUIv2.g(MallIndexUIv2.this).igw + " swipeOn : " + MallIndexUIv2.g(MallIndexUIv2.this).igx);
        if ((MallIndexUIv2.h(MallIndexUIv2.this)) || (MallIndexUIv2.this.getContext().isFinishing()))
        {
          Log.e("MicorMsg.MallIndexUIv2", "error for callback ac finish");
          AppMethodBeat.o(262422);
          return;
        }
        Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localacz.igr.igW), Boolean.valueOf(this.ouJ) });
        MallIndexUIv2.a(MallIndexUIv2.this, localacz.igr);
        int i;
        Object localObject1;
        boolean bool2;
        Object localObject2;
        if (MallIndexUIv2.g(MallIndexUIv2.this).igX != null)
        {
          i = 1;
          if ((i & MallIndexUIv2.g(MallIndexUIv2.this).igX instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject1 = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUIv2.g(MallIndexUIv2.this).igX;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).isJumpRemind())
            {
              localObject1 = ((com.tencent.mm.wallet_core.tenpay.model.m)localObject1).getJumpRemind();
              ((com.tencent.mm.wallet_core.model.m)localObject1).jOK();
              ((com.tencent.mm.wallet_core.model.m)localObject1).a(MallIndexUIv2.this, new com.tencent.mm.wallet_core.model.g()
              {
                public final void fWQ() {}
              });
            }
          }
          if (MallIndexUIv2.g(MallIndexUIv2.this).errCode == 0)
          {
            MallIndexUIv2.this.fZv();
            if (MallIndexUIv2.g(MallIndexUIv2.this).igW) {
              MallIndexUIv2.this.fZr();
            }
            localObject1 = MallIndexUIv2.this;
            Log.i("MicorMsg.MallIndexUIv2", "showGetNewWalletTip call");
            if ((((MallIndexUIv2)localObject1).KLM == null) || ((!((MallIndexUIv2)localObject1).KLM.igu) && (!((MallIndexUIv2)localObject1).KLM.igA))) {
              break label746;
            }
            bool2 = u.iiC().ijp().iiW();
            localObject2 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acLV, Boolean.FALSE);
            if (localObject2 == null) {
              break label777;
            }
          }
        }
        label777:
        for (boolean bool1 = ((Boolean)localObject2).booleanValue();; bool1 = false)
        {
          Log.i("MicorMsg.MallIndexUIv2", "showGetNewWalletTip hadShow=" + bool1 + ";isswc=" + bool2);
          if ((!bool1) && (bool2))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acLV, Boolean.TRUE);
            com.tencent.mm.plugin.wallet_core.ui.q.kK((Context)localObject1);
          }
          label463:
          if (!this.ouJ) {
            MallIndexUIv2.fZG();
          }
          MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this));
          MallIndexUIv2.this.fZt();
          Log.i("MicorMsg.MallIndexUIv2", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).igS), Boolean.valueOf(MallIndexUIv2.g(MallIndexUIv2.this).igT), MallIndexUIv2.g(MallIndexUIv2.this).igU });
          localObject1 = MallIndexUIv2.this;
          if (MallIndexUIv2.g(MallIndexUIv2.this).igS == 1)
          {
            bool1 = true;
            label574:
            MallIndexUIv2.a((MallIndexUIv2)localObject1, bool1);
            MallIndexUIv2.b(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).igT);
            MallIndexUIv2.a(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).igU);
            if (MallIndexUIv2.i(MallIndexUIv2.this) != null)
            {
              if (!MallIndexUIv2.j(MallIndexUIv2.this)) {
                break label762;
              }
              MallIndexUIv2.i(MallIndexUIv2.this).setVisibility(0);
            }
          }
          for (;;)
          {
            localObject1 = MallIndexUIv2.this;
            localObject2 = new ak();
            ((MallIndexUIv2)localObject1).KLQ.a(new MallIndexUIv2.5((MallIndexUIv2)localObject1), ((ak)localObject2).ijd());
            if ((localacz.igr.igW) && (this.ouJ))
            {
              MallIndexUIv2.a(MallIndexUIv2.this, MallIndexUIv2.g(MallIndexUIv2.this).igY);
              MallIndexUIv2.this.updateView();
            }
            this.ouJ = true;
            AppMethodBeat.o(262422);
            return;
            i = 0;
            break;
            label746:
            Log.e("MicorMsg.MallIndexUIv2", "user is not reg or simplereg，should not show this dialog");
            break label463;
            bool1 = false;
            break label574;
            label762:
            MallIndexUIv2.i(MallIndexUIv2.this).setVisibility(8);
          }
        }
      }
    };
    localacz.asyncPublish(Looper.myLooper());
    AppMethodBeat.o(262494);
    return false;
  }
  
  protected final void fZp()
  {
    AppMethodBeat.i(262489);
    String str = com.tencent.mm.plugin.wallet_core.model.mall.b.ikc();
    Log.i("MicorMsg.MallIndexUIv2", "emptyHint: %s", new Object[] { str });
    if (this.KLe == null)
    {
      this.KLe = af.mU(this).inflate(a.g.mall_index_settings_footer, null);
      this.KKV.addFooterView(this.KLe, null, false);
      TextView localTextView = (TextView)this.KLe.findViewById(a.f.misf_settings_tv);
      com.tencent.mm.wallet_core.ui.i.bG(localTextView, 100);
      localTextView.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(262404);
          Log.i("MicorMsg.MallIndexUIv2", "click settings btn");
          com.tencent.mm.br.c.ai(MallIndexUIv2.this.getContext(), "mall", ".ui.MallFunctionSettingsUI");
          AppMethodBeat.o(262404);
        }
      });
    }
    if (Util.isNullOrNil(str))
    {
      this.KLe.setVisibility(8);
      this.KLe.setPadding(com.tencent.mm.cd.a.bs(getContext(), a.d.Edge_2A), 0, com.tencent.mm.cd.a.bs(getContext(), a.d.Edge_2A), 0);
      AppMethodBeat.o(262489);
      return;
    }
    this.KLe.setVisibility(0);
    ((TextView)this.KLe.findViewById(a.f.misf_settings_tv)).setText(str);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262407);
        int k = com.tencent.mm.cd.a.mt(MallIndexUIv2.this.getContext());
        int n = com.tencent.mm.cd.a.fromDPToPix(MallIndexUIv2.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUIv2.this.KKV.getLocationInWindow(arrayOfInt);
        int m = MallIndexUIv2.this.KLe.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUIv2.this.KKV.getHeight() - MallIndexUIv2.this.KLe.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cd.a.fromDPToPix(MallIndexUIv2.this.getContext(), 33);
        Log.d("MicorMsg.MallIndexUIv2", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUIv2.this.KLe.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUIv2.this.KLe.setPadding(com.tencent.mm.cd.a.bs(MallIndexUIv2.this.getContext(), a.d.Edge_2A), j, com.tencent.mm.cd.a.bs(MallIndexUIv2.this.getContext(), a.d.Edge_2A), n);
          AppMethodBeat.o(262407);
          return;
        }
        MallIndexUIv2.this.KLe.setPadding(com.tencent.mm.cd.a.bs(MallIndexUIv2.this.getContext(), a.d.Edge_2A), n, com.tencent.mm.cd.a.bs(MallIndexUIv2.this.getContext(), a.d.Edge_2A), n);
        AppMethodBeat.o(262407);
      }
    });
    AppMethodBeat.o(262489);
  }
  
  protected final void fZq()
  {
    AppMethodBeat.i(262493);
    final acx localacx = new acx();
    localacx.igk.scene = "1";
    localacx.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262413);
        if ((localacx.igl.type == 2) && (localacx.igl.ign != null))
        {
          MallIndexUIv2.this.pLM.setBannerData(localacx.igl.ign);
          AppMethodBeat.o(262413);
          return;
        }
        if (!Util.isNullOrNil(localacx.igl.igm)) {
          com.tencent.mm.wallet_core.ui.i.a(null, MallIndexUIv2.this.KLa, localacx.igl.igm, localacx.igl.content, localacx.igl.url);
        }
        AppMethodBeat.o(262413);
      }
    };
    localacx.publish();
    AppMethodBeat.o(262493);
  }
  
  protected final void fZr()
  {
    AppMethodBeat.i(262499);
    Log.i("MicorMsg.MallIndexUIv2", "updateBalanceNum");
    Object localObject = new ak();
    if (((ak)localObject).ija())
    {
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMT, getString(a.i.realname_balance_title));
      this.KKZ.setText((CharSequence)localObject);
      localObject = (LinearLayout.LayoutParams)this.KKZ.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
      this.KKZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.KKZ.setVisibility(0);
      this.KLW.setVisibility(8);
      this.KLX.setVisibility(8);
      this.KMn.setVisibility(8);
      AppMethodBeat.o(262499);
      return;
    }
    if (((ak)localObject).ijc())
    {
      Log.i("MicorMsg.MallIndexUIv2", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVr, Long.valueOf(0L))).longValue();
      if (this.KLW != null)
      {
        yl(((ak)localObject).ije());
        if (this.KLW.getVisibility() == 0)
        {
          this.KLW.setMoney(com.tencent.mm.wallet_core.ui.i.formatMoney2f(com.tencent.mm.wallet_core.ui.i.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
          AppMethodBeat.o(262499);
        }
      }
      else
      {
        Log.w("MicorMsg.MallIndexUIv2", "moneyLoadingView is null");
      }
    }
    AppMethodBeat.o(262499);
  }
  
  protected final void fZt()
  {
    AppMethodBeat.i(262501);
    removeAllOptionMenu();
    Log.i("MicorMsg.MallIndexUIv2", "addIconOptionMenuByMode");
    addIconOptionMenu(0, a.i.wallet_password_setting_ui_title, a.h.icons_outlined_more, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(262410);
        com.tencent.mm.plugin.report.service.h.OAn.b(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        com.tencent.mm.plugin.report.service.h.OAn.b(16500, new Object[] { Integer.valueOf(3) });
        Object localObject;
        if ((u.iiC().ijp().iiX()) && (MallIndexUIv2.k(MallIndexUIv2.this) != null) && (MallIndexUIv2.k(MallIndexUIv2.this).size() > 0))
        {
          paramAnonymousMenuItem = MallIndexUIv2.this;
          Log.i("MicorMsg.MallIndexUIv2", "openNewPayManageMenu");
          localObject = new l(paramAnonymousMenuItem.getContext());
          ((l)localObject).Vtg = new MallIndexUIv2.7(paramAnonymousMenuItem);
          ((l)localObject).GAC = new MallIndexUIv2.8(paramAnonymousMenuItem);
          ((l)localObject).jDd();
        }
        for (;;)
        {
          AppMethodBeat.o(262410);
          return true;
          paramAnonymousMenuItem = MallIndexUIv2.this;
          boolean bool = MallIndexUIv2.g(MallIndexUIv2.this).igB;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_default_show_currency", bool);
          com.tencent.mm.br.c.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", (Intent)localObject, 6);
        }
      }
    });
    com.tencent.mm.plugin.report.service.h.OAn.b(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(262501);
  }
  
  protected final void fZv()
  {
    AppMethodBeat.i(262496);
    if (this.KKY == null)
    {
      AppMethodBeat.o(262496);
      return;
    }
    if ((!com.tencent.mm.aa.c.aYo().b(at.a.acTj, at.a.acTk)) && (!this.KLM.igw))
    {
      n localn = u.iiC().VKf;
      if (localn == null) {
        break label134;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.h.baF();
      if ((((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acLq, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label125;
      }
      Log.i("MicorMsg.MallIndexUIv2", "bankcard need red point");
    }
    label134:
    for (int i = 1; i != 0; i = 0)
    {
      this.KKY.setVisibility(0);
      AppMethodBeat.o(262496);
      return;
      label125:
      Log.i("MicorMsg.MallIndexUIv2", "bankcard do not need red point");
    }
    this.KKY.setVisibility(8);
    AppMethodBeat.o(262496);
  }
  
  protected final void fZw()
  {
    AppMethodBeat.i(262513);
    if (this.Fag == null)
    {
      Log.i("MicorMsg.MallIndexUIv2", "header = null");
      AppMethodBeat.o(262513);
      return;
    }
    final LinearLayout localLinearLayout = (LinearLayout)this.Fag.findViewById(a.f.header_content_layout);
    if (localLinearLayout == null)
    {
      Log.i("MicorMsg.MallIndexUIv2", "headerContentLayout = null");
      AppMethodBeat.o(262513);
      return;
    }
    if (com.tencent.mm.ce.b.iRp()) {
      localLinearLayout.setBackgroundResource(a.e.mall_index_new_header_bg_for_care);
    }
    fZF();
    localLinearLayout.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262403);
        int k = localLinearLayout.getWidth();
        MallIndexUIv2.a(MallIndexUIv2.this, localLinearLayout.getHeight());
        int j = (k - com.tencent.mm.cd.a.fromDPToPix(MallIndexUIv2.this.getContext(), 8) * 3) / 2;
        LinearLayout localLinearLayout1 = (LinearLayout)MallIndexUIv2.this.Fag.findViewById(a.f.minh_wallet_layout);
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
          LinearLayout localLinearLayout2 = (LinearLayout)MallIndexUIv2.this.Fag.findViewById(a.f.minh_pos_layout);
          LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams();
          localLayoutParams2.width = i;
          localLayoutParams2.height = m;
          i = (k - i * 2) / 3;
          j = ((Integer)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.adga, Integer.valueOf(0))).intValue();
          Log.i("MicorMsg.MallIndexUIv2", "caculate interval:%s lastInterval:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == i)
          {
            AppMethodBeat.o(262403);
            return;
          }
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(at.a.adga, Integer.valueOf(i));
          ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().iZy();
          localLayoutParams2.leftMargin = i;
          localLinearLayout2.setLayoutParams(localLayoutParams2);
          localLayoutParams1.rightMargin = i;
          localLinearLayout1.setLayoutParams(localLayoutParams1);
          AppMethodBeat.o(262403);
          return;
        }
      }
    });
    AppMethodBeat.o(262513);
  }
  
  protected final int fZx()
  {
    return this.KMq;
  }
  
  public void finish()
  {
    AppMethodBeat.i(262510);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(262510);
  }
  
  protected final void ib(View paramView)
  {
    AppMethodBeat.i(262490);
    this.KMo = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.gtf().h(this.KMo);
    this.KMp = new c(this, paramView);
    this.KMp.fZE();
    com.tencent.mm.plugin.newtips.a.gtf().h(this.KMp);
    AppMethodBeat.o(262490);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(262488);
    this.Fag = af.mU(this).inflate(a.g.mall_index_new_header_stub_v2, null);
    this.KKV.addHeaderView(this.Fag, null, false);
    fZw();
    AppMethodBeat.o(262488);
  }
  
  public void initView()
  {
    AppMethodBeat.i(262486);
    super.initView();
    this.KKV.setPadding(a.DWW, 0, a.DWW, 0);
    AppMethodBeat.o(262486);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(262514);
    Log.i("MicorMsg.MallIndexUIv2", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        this.KLQ.agree();
        AppMethodBeat.o(262514);
        return;
      }
      this.KLQ.cancel();
      AppMethodBeat.o(262514);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.h.baF();
      if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWZ, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(262514);
      return;
    }
    if (paramInt1 == 6)
    {
      if ((paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
      {
        finish();
        paramIntent = new ut();
        paramIntent.hYw.context = getContext();
        paramIntent.publish();
        AppMethodBeat.o(262514);
      }
    }
    else if ((paramInt1 == 65281) && (paramInt2 == -1))
    {
      if (z.bBj())
      {
        finish();
        AppMethodBeat.o(262514);
        return;
      }
      setResult(-1, paramIntent);
      finish();
    }
    AppMethodBeat.o(262514);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262484);
    fixStatusbar(true);
    if (26 != Build.VERSION.SDK_INT) {
      setRequestedOrientation(1);
    }
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.threadpool.h.ahAA.h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262406);
        com.tencent.mm.plugin.wallet_core.model.k.asj(2);
        AppMethodBeat.o(262406);
      }
    }, "wxpay_mallindex_refresh_location");
    this.KLM = new acz.b();
    this.KLM.igu = false;
    this.KLM.igv = true;
    this.KLM.igw = false;
    this.KLY.alive();
    this.KMb.alive();
    com.tencent.mm.kernel.h.baF();
    this.KMr = t.bgx((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acTJ, ""));
    this.KLQ.VTP = new w.b()
    {
      public final Context getContext()
      {
        return MallIndexUIv2.this;
      }
      
      public final int getShowAgreenRequestCode()
      {
        return 3;
      }
    };
    e.fZH();
    a.n(this);
    super.onCreate(paramBundle);
    this.KMa.alive();
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
    {
      com.tencent.mm.kernel.h.baF();
      a(new d((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXa, "")));
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(262484);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(262506);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    this.KLY.dead();
    this.KMb.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    this.KMa.dead();
    AppMethodBeat.o(262506);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(262492);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicorMsg.MallIndexUIv2", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        fZr();
      }
    }
    AppMethodBeat.o(262492);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(262504);
    super.onPause();
    this.KLQ.onPause();
    if (this.KLW != null) {
      this.KLW.reset();
    }
    AppMethodBeat.o(262504);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(262502);
    Log.v("MicorMsg.MallIndexUIv2", "alvinluo MallIndexUI onResume");
    this.KLQ.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.imz(), null);
    super.onResume();
    fZr();
    AppMethodBeat.o(262502);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(262511);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramp instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramp).KJb);
    }
    do
    {
      do
      {
        AppMethodBeat.o(262511);
        return true;
      } while (!(paramp instanceof ae));
      paramString = (ae)paramp;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.model.g()
    {
      public final void fWQ() {}
    })));
    AppMethodBeat.o(262511);
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
    protected ImageView KMi;
    private Context context;
    protected TextView vPl;
    
    public a(Context paramContext, View paramView)
    {
      this.context = paramContext;
      ib(paramView);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    }
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      if (paramBoolean)
      {
        this.vPl.setVisibility(0);
        String str = paramfng.num;
        if (paramfng.num > 99) {
          str = this.context.getString(a.i.tab_msg_tip_over);
        }
        this.vPl.setText(str);
      }
      for (;;)
      {
        return true;
        this.vPl.setVisibility(8);
      }
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public abstract void ib(View paramView);
    
    public final boolean ym(boolean paramBoolean)
    {
      return com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.KMi.setVisibility(0);
      }
      for (;;)
      {
        return true;
        this.KMi.setVisibility(8);
      }
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.vPl.setVisibility(0);
        this.vPl.setText(this.context.getString(a.i.app_new));
      }
      for (;;)
      {
        return true;
        this.vPl.setVisibility(8);
      }
    }
  }
  
  final class b
    extends MallIndexUIv2.a
  {
    private LinearLayout KMj;
    
    public b(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final String getPath()
    {
      return "pay_receiveorpay";
    }
    
    public final View getRoot()
    {
      return this.KMj;
    }
    
    public final void ib(View paramView)
    {
      AppMethodBeat.i(262393);
      this.KMj = ((LinearLayout)paramView.findViewById(a.f.minh_pos_layout));
      this.KMi = ((ImageView)this.KMj.findViewById(a.f.minh_pos_reddot_iv));
      this.vPl = ((TextView)this.KMj.findViewById(a.f.minh_pos_unread_tv));
      this.KMj.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(262462);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.br.c.b(MallIndexUIv2.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ac.pu(9, 0);
          com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.h.OAn.b(14419, new Object[] { MallIndexUIv2.this.uuid, Integer.valueOf(1) });
          AppMethodBeat.o(262462);
        }
      });
      AppMethodBeat.o(262393);
    }
  }
  
  final class c
    extends MallIndexUIv2.a
  {
    private LinearLayout KMl;
    private boolean KMw = false;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean fZE()
    {
      AppMethodBeat.i(262398);
      com.tencent.mm.kernel.h.baF();
      boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUS, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.h.baF();
      long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUT, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        Log.i("MicorMsg.MallIndexUIv2", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUS, Boolean.FALSE);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUT, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool)
        {
          this.KMi.setVisibility(0);
          if (!this.KMw)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(25075, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            this.KMw = true;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MsK, bool);
          AppMethodBeat.o(262398);
          return true;
          this.KMi.setVisibility(8);
        }
      }
    }
    
    public final String getPath()
    {
      return "wallet";
    }
    
    public final View getRoot()
    {
      return this.KMl;
    }
    
    public final void ib(View paramView)
    {
      AppMethodBeat.i(262392);
      this.KMl = ((LinearLayout)paramView.findViewById(a.f.minh_wallet_layout));
      MallIndexUIv2.this.KKZ = ((TextView)this.KMl.findViewById(a.f.wallet_bottom_text_tv));
      MallIndexUIv2.a(MallIndexUIv2.this, (WcPayMoneyLoadingView)this.KMl.findViewById(a.f.wallet_bottom_text_view));
      MallIndexUIv2.a(MallIndexUIv2.this, (ProgressBar)this.KMl.findViewById(a.f.wallet_money_load_pb));
      MallIndexUIv2.a(MallIndexUIv2.this, (RelativeLayout)this.KMl.findViewById(a.f.wallet_bottom_text_layout));
      if (com.tencent.mm.ce.b.iRp())
      {
        MallIndexUIv2.this.KKZ.setAlpha(1.0F);
        MallIndexUIv2.d(MallIndexUIv2.this).setAlpha(1.0F);
      }
      MallIndexUIv2.this.getLifecycle().addObserver(MallIndexUIv2.d(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setLoadingPb(MallIndexUIv2.e(MallIndexUIv2.this));
      MallIndexUIv2.d(MallIndexUIv2.this).setPrefixSymbol("¥");
      MallIndexUIv2.d(MallIndexUIv2.this).setTextColor(-1);
      MallIndexUIv2.d(MallIndexUIv2.this).setTextSize(com.tencent.mm.cd.a.fromDPToPix(MallIndexUIv2.this.getContext(), 15));
      this.KMi = ((ImageView)this.KMl.findViewById(a.f.minh_wallet_reddot_iv));
      this.vPl = ((TextView)this.KMl.findViewById(a.f.minh_wallet_unread_tv));
      this.KMl.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(262427);
          if (MallIndexUIv2.c.this.KMi.getVisibility() == 0) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              com.tencent.mm.plugin.report.service.h.OAn.b(25075, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
            }
            MallIndexUIv2.c(MallIndexUIv2.this);
            com.tencent.mm.plugin.newtips.a.gtf().aeI(15);
            AppMethodBeat.o(262427);
            return;
          }
        }
      });
      AppMethodBeat.o(262392);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2
 * JD-Core Version:    0.7.0.1
 */