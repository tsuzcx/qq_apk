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
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wallet_core.ui.w;
import com.tencent.mm.plugin.wallet_core.ui.w.a;
import com.tencent.mm.plugin.wallet_core.ui.w.b;
import com.tencent.mm.plugin.wxpay.a.c;
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
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.model.ac;
import java.math.BigDecimal;
import java.math.RoundingMode;

@com.tencent.mm.kernel.k
public class MallIndexUI
  extends MallIndexBaseUI
  implements MStorageEx.IOnStorageChange
{
  private acz.b KLM;
  private RelativeLayout KLN;
  private boolean KLO;
  private boolean KLP;
  w KLQ;
  private boolean KLR;
  private Dialog KLS;
  private boolean KLT;
  private b KLU;
  private c KLV;
  private WcPayMoneyLoadingView KLW;
  private ProgressBar KLX;
  private IListener<rf> KLY;
  private boolean KLZ;
  private TextView KLv;
  private boolean KLw;
  private IListener KMa;
  private IListener<aef> KMb;
  private boolean KMc;
  private boolean KMd;
  private String igU;
  private boolean isFinished;
  private View uiE;
  
  public MallIndexUI()
  {
    AppMethodBeat.i(66117);
    this.isFinished = false;
    this.KLQ = new w();
    this.uiE = null;
    this.KLw = false;
    this.KLv = null;
    this.KLR = false;
    this.KLT = false;
    this.KLU = null;
    this.KLV = null;
    this.KLY = new MallIndexUI.1(this, com.tencent.mm.app.f.hfK);
    this.KLZ = false;
    this.KMa = new IListener(com.tencent.mm.app.f.hfK) {};
    this.KMb = new MallIndexUI.3(this, com.tencent.mm.app.f.hfK);
    this.KMc = false;
    this.KMd = false;
    AppMethodBeat.o(66117);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(66141);
    if ((paramd == null) || (Util.isNullOrNil(paramd.KJa)))
    {
      AppMethodBeat.o(66141);
      return;
    }
    if (this.KLw)
    {
      if (this.KLv != null)
      {
        this.KLv.setText(a.i.mall_gdpr_mall_index);
        this.KLv.setOnClickListener(new MallIndexUI.7(this, paramd));
      }
      AppMethodBeat.o(66141);
      return;
    }
    this.uiE = View.inflate(this, a.g.mall_index_gdpr_foot, null);
    this.uiE.setClickable(false);
    this.uiE.setEnabled(false);
    this.KLv = ((TextView)this.uiE.findViewById(a.f.wallet_region_desc));
    this.KLv.setVisibility(0);
    this.KLv.setText(a.i.mall_gdpr_mall_index);
    this.KLv.setTextColor(getResources().getColor(a.c.link_color));
    this.KLv.setOnClickListener(new MallIndexUI.8(this, paramd));
    if (this.KKV != null)
    {
      this.KKV.addFooterView(this.uiE);
      this.KLw = true;
    }
    AppMethodBeat.o(66141);
  }
  
  private void yl(boolean paramBoolean)
  {
    AppMethodBeat.i(66132);
    if (paramBoolean)
    {
      this.KKZ.setText(getString(a.i.wallet_index_ui_balance_hide));
      this.KKZ.setVisibility(0);
      this.KLW.setVisibility(8);
      this.KLX.setVisibility(8);
      this.KLW.reset();
      AppMethodBeat.o(66132);
      return;
    }
    this.KKZ.setVisibility(8);
    this.KLW.setVisibility(0);
    this.KLX.setVisibility(0);
    AppMethodBeat.o(66132);
  }
  
  protected final void fPx()
  {
    AppMethodBeat.i(66120);
    int i = getResources().getColor(a.c.mall_index_new_bg_color);
    setActionbarColor(i);
    hideActionbarLine();
    findViewById(a.f.root_layout).setBackgroundColor(i);
    AppMethodBeat.o(66120);
  }
  
  protected final void fZi()
  {
    AppMethodBeat.i(66121);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXe, false);
    Log.i("MicorMsg.MallIndexUI", " cn wallet open new name ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      setMMTitle(a.i.mall_index_ui_title_new);
      AppMethodBeat.o(66121);
      return;
    }
    setMMTitle(a.i.mall_index_ui_title);
    AppMethodBeat.o(66121);
  }
  
  protected final void fZj()
  {
    AppMethodBeat.i(66137);
    com.tencent.mm.plugin.mall.b.b.fZL();
    AppMethodBeat.o(66137);
  }
  
  protected final void fZk()
  {
    AppMethodBeat.i(66138);
    if (((u.iix().ijK() == null) || (u.iix().ijK().iji()) || (u.iix().ijK().ijh())) && (z.bBi()))
    {
      Log.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.b.a("", false));
    }
    AppMethodBeat.o(66138);
  }
  
  protected final boolean fZl()
  {
    AppMethodBeat.i(66128);
    Log.i("MicorMsg.MallIndexUI", "init BankcardList");
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
        AppMethodBeat.i(66111);
        if ((MallIndexUI.this.isFinishing()) || (MallIndexUI.this.hasFinish()) || (MallIndexUI.this.isDestroyed()))
        {
          AppMethodBeat.o(66111);
          return;
        }
        Log.d("MicorMsg.MallIndexUI", "mUserInfo needBind : " + MallIndexUI.g(MallIndexUI.this).igv + " hasNewTips : " + MallIndexUI.g(MallIndexUI.this).igw + " swipeOn : " + MallIndexUI.g(MallIndexUI.this).igx);
        if ((MallIndexUI.h(MallIndexUI.this)) || (MallIndexUI.this.getContext().isFinishing()))
        {
          Log.e("MicorMsg.MallIndexUI", "error for callback ac finish");
          AppMethodBeat.o(66111);
          return;
        }
        Log.i("MicorMsg.MallIndexUI", "after get userInfo, isFromCgiEnd: %s, hasCallback: %s", new Object[] { Boolean.valueOf(localacz.igr.igW), Boolean.valueOf(this.ouJ) });
        MallIndexUI.a(MallIndexUI.this, localacz.igr);
        int i;
        Object localObject;
        boolean bool;
        if (MallIndexUI.g(MallIndexUI.this).igX != null)
        {
          i = 1;
          if ((i & MallIndexUI.g(MallIndexUI.this).igX instanceof com.tencent.mm.wallet_core.tenpay.model.m) != 0)
          {
            localObject = (com.tencent.mm.wallet_core.tenpay.model.m)MallIndexUI.g(MallIndexUI.this).igX;
            if (((com.tencent.mm.wallet_core.tenpay.model.m)localObject).isJumpRemind()) {
              ((com.tencent.mm.wallet_core.tenpay.model.m)localObject).getJumpRemind().a(MallIndexUI.this, new com.tencent.mm.wallet_core.model.g()
              {
                public final void fWQ() {}
              });
            }
          }
          if (MallIndexUI.g(MallIndexUI.this).errCode == 0)
          {
            MallIndexUI.this.fZv();
            if (MallIndexUI.g(MallIndexUI.this).igW) {
              MallIndexUI.this.fZr();
            }
            MallIndexUI.this.fZm();
            if (!this.ouJ) {
              MallIndexUI.fZC();
            }
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this));
            MallIndexUI.this.fZt();
            Log.i("MicorMsg.MallIndexUI", "after get userInfo, isShowLqb: %s, isOpenLqb: %s, lqbOpenUrl: %s", new Object[] { Integer.valueOf(MallIndexUI.g(MallIndexUI.this).igS), Boolean.valueOf(MallIndexUI.g(MallIndexUI.this).igT), MallIndexUI.g(MallIndexUI.this).igU });
            localObject = MallIndexUI.this;
            if (MallIndexUI.g(MallIndexUI.this).igS != 1) {
              break label575;
            }
            bool = true;
            label425:
            MallIndexUI.a((MallIndexUI)localObject, bool);
            MallIndexUI.b(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).igT);
            MallIndexUI.a(MallIndexUI.this, MallIndexUI.g(MallIndexUI.this).igU);
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
          ((MallIndexUI)localObject).KLQ.a(new MallIndexUI.4((MallIndexUI)localObject), localak.ijd());
          if ((localacz.igr.igW) && (this.ouJ)) {
            MallIndexUI.this.updateView();
          }
          this.ouJ = true;
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
    localacz.asyncPublish(Looper.myLooper());
    AppMethodBeat.o(66128);
    return false;
  }
  
  protected final void fZm()
  {
    AppMethodBeat.i(66129);
    Log.i("MicorMsg.MallIndexUI", "showGetNewWalletTip call");
    boolean bool2;
    Object localObject;
    if ((this.KLM != null) && ((this.KLM.igu) || (this.KLM.igA)))
    {
      bool2 = u.iiC().ijp().iiW();
      localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acLV, Boolean.FALSE);
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
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acLV, Boolean.TRUE);
        com.tencent.mm.plugin.wallet_core.ui.q.kK(this);
      }
      AppMethodBeat.o(66129);
      return;
      Log.e("MicorMsg.MallIndexUI", "user is not reg or simplereg，should not show this dialog");
      AppMethodBeat.o(66129);
      return;
    }
  }
  
  protected final void fZp()
  {
    AppMethodBeat.i(66124);
    this.KLd = com.tencent.mm.plugin.mall.a.k.fZb().aal(this.KJh).field_isShowSetting;
    if (this.KLe == null)
    {
      this.KLe = af.mU(this).inflate(a.g.mall_index_settings_footer, null);
      this.KKV.addFooterView(this.KLe, null, false);
      TextView localTextView = (TextView)this.KLe.findViewById(a.f.misf_settings_tv);
      com.tencent.mm.wallet_core.ui.i.bG(localTextView, 100);
      localTextView.setOnClickListener(new MallIndexUI.10(this));
    }
    Log.i("MicorMsg.MallIndexUI", "is show setting: %s", new Object[] { Integer.valueOf(this.KLd) });
    if (this.KLd == 0)
    {
      this.KLe.setVisibility(8);
      this.KLe.setPadding(0, 0, 0, 0);
      AppMethodBeat.o(66124);
      return;
    }
    this.KLe.setVisibility(0);
    getWindow().getDecorView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66108);
        int k = com.tencent.mm.cd.a.mt(MallIndexUI.this.getContext());
        int n = com.tencent.mm.cd.a.fromDPToPix(MallIndexUI.this.getContext(), 53);
        int[] arrayOfInt = new int[2];
        MallIndexUI.this.KKV.getLocationInWindow(arrayOfInt);
        int m = MallIndexUI.this.KLe.getBottom() + arrayOfInt[1] - k;
        int j = MallIndexUI.this.KKV.getHeight() - MallIndexUI.this.KLe.getHeight() + arrayOfInt[1];
        int i = j;
        if (m > 0) {
          i = j + m;
        }
        j = k - i - n;
        n = com.tencent.mm.cd.a.fromDPToPix(MallIndexUI.this.getContext(), 33);
        Log.d("MicorMsg.MallIndexUI", "winHeight: %d, height: %d, footerHeight: %s, Y: %d, scrollDiff: %d, diff: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(MallIndexUI.this.KLe.getHeight()), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(m), Integer.valueOf(j) });
        if (j > n)
        {
          MallIndexUI.this.KLe.setPadding(0, j, 0, n);
          AppMethodBeat.o(66108);
          return;
        }
        MallIndexUI.this.KLe.setPadding(0, n, 0, n);
        AppMethodBeat.o(66108);
      }
    });
    AppMethodBeat.o(66124);
  }
  
  protected final void fZq()
  {
    AppMethodBeat.i(66127);
    final acx localacx = new acx();
    localacx.igk.scene = "1";
    localacx.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(66109);
        if (!Util.isNullOrNil(localacx.igl.igm)) {
          com.tencent.mm.wallet_core.ui.i.a(null, MallIndexUI.this.KLa, localacx.igl.igm, localacx.igl.content, localacx.igl.url);
        }
        AppMethodBeat.o(66109);
      }
    };
    localacx.publish();
    AppMethodBeat.o(66127);
  }
  
  protected final void fZr()
  {
    AppMethodBeat.i(66131);
    Log.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new ak();
    if (((ak)localObject).ija())
    {
      localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMT, getString(a.i.realname_balance_title));
      this.KKZ.setText((CharSequence)localObject);
      this.KKZ.setVisibility(0);
      this.KLW.setVisibility(8);
      this.KLX.setVisibility(8);
      AppMethodBeat.o(66131);
      return;
    }
    if (((ak)localObject).ijc())
    {
      Log.i("MicorMsg.MallIndexUI", "show balance amount");
      long l = ((Long)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.acVr, Long.valueOf(0L))).longValue();
      if (this.KLW != null)
      {
        yl(((ak)localObject).ije());
        if (this.KLW.getVisibility() == 0)
        {
          this.KLW.setMoney(com.tencent.mm.wallet_core.ui.i.formatMoney2f(com.tencent.mm.wallet_core.ui.i.b(String.valueOf(l), "100", 2, RoundingMode.HALF_UP).doubleValue()));
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
  
  protected final void fZt()
  {
    AppMethodBeat.i(66133);
    removeAllOptionMenu();
    Log.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode");
    addIconOptionMenu(0, 0, a.h.icons_outlined_more, false, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66101);
        com.tencent.mm.plugin.report.service.h.OAn.b(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
        com.tencent.mm.plugin.report.service.h.OAn.b(16500, new Object[] { Integer.valueOf(3) });
        paramAnonymousMenuItem = MallIndexUI.this;
        boolean bool = MallIndexUI.g(MallIndexUI.this).igB;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_default_show_currency", bool);
        com.tencent.mm.br.c.b(paramAnonymousMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", localIntent, 6);
        AppMethodBeat.o(66101);
        return true;
      }
    });
    com.tencent.mm.plugin.report.service.h.OAn.b(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(1) });
    AppMethodBeat.o(66133);
  }
  
  protected final void fZv()
  {
    AppMethodBeat.i(66130);
    if (this.KKY == null)
    {
      AppMethodBeat.o(66130);
      return;
    }
    if ((!com.tencent.mm.aa.c.aYo().b(at.a.acTj, at.a.acTk)) && (!this.KLM.igw))
    {
      n localn = u.iiC().VKf;
      if (localn == null) {
        break label132;
      }
      i = localn.field_red_dot_index;
      com.tencent.mm.kernel.h.baF();
      if ((((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acLq, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label124;
      }
      Log.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label132:
    for (int i = 1; i != 0; i = 0)
    {
      this.KKY.setVisibility(0);
      AppMethodBeat.o(66130);
      return;
      label124:
      Log.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.KKY.setVisibility(8);
    AppMethodBeat.o(66130);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66139);
    this.isFinished = true;
    super.finish();
    AppMethodBeat.o(66139);
  }
  
  protected final void ib(View paramView)
  {
    AppMethodBeat.i(66125);
    this.KLU = new b(this, paramView);
    com.tencent.mm.plugin.newtips.a.gtf().h(this.KLU);
    this.KLV = new c(this, paramView);
    this.KLV.fZE();
    com.tencent.mm.plugin.newtips.a.gtf().h(this.KLV);
    AppMethodBeat.o(66125);
  }
  
  protected final void initHeaderView()
  {
    AppMethodBeat.i(66123);
    this.Fag = af.mU(this).inflate(a.g.mall_index_new_header_stub, null);
    this.KKV.addHeaderView(this.Fag, null, false);
    LinearLayout localLinearLayout = (LinearLayout)this.Fag.findViewById(a.f.header_content_layout);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    }
    localLayoutParams1.height = a.fZd();
    localLinearLayout.setLayoutParams(localLayoutParams1);
    AppMethodBeat.o(66123);
  }
  
  public void initView()
  {
    AppMethodBeat.i(66122);
    super.initView();
    this.KKV.setPadding(a.DWW, 0, a.DWW, 0);
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
        this.KLQ.agree();
        AppMethodBeat.o(66118);
        return;
      }
      this.KLQ.cancel();
      AppMethodBeat.o(66118);
      return;
    }
    if (paramInt1 == 5)
    {
      com.tencent.mm.kernel.h.baF();
      if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWZ, Boolean.FALSE)).booleanValue()) {
        finish();
      }
      AppMethodBeat.o(66118);
      return;
    }
    if ((paramInt1 == 6) && (paramIntent != null) && (paramIntent.getIntExtra("is_switch_wallet", 0) == 1))
    {
      finish();
      paramIntent = new ut();
      paramIntent.hYw.context = getContext();
      paramIntent.publish();
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
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.mm.plugin.wallet_core.model.k.asj(2);
    this.KLM = new acz.b();
    this.KLM.igu = false;
    this.KLM.igv = true;
    this.KLM.igw = false;
    this.KLY.alive();
    this.KMb.alive();
    this.KLQ.VTP = new w.b()
    {
      public final Context getContext()
      {
        return MallIndexUI.this;
      }
      
      public final int getShowAgreenRequestCode()
      {
        return 3;
      }
    };
    e.fZH();
    a.b(this, true);
    super.onCreate(paramBundle);
    this.KMa.alive();
    addSceneEndListener(2713);
    addSceneEndListener(385);
    if (com.tencent.mm.au.b.OE((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null)))
    {
      com.tencent.mm.kernel.h.baF();
      a(new d((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXa, "")));
      com.tencent.mm.kernel.h.baF();
      ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWZ, Boolean.FALSE)).booleanValue();
      doSceneProgress(new com.tencent.mm.plugin.mall.a.e(), false);
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(16500, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(66119);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66136);
    super.onDestroy();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    this.KLY.dead();
    this.KMb.dead();
    removeSceneEndListener(2713);
    removeSceneEndListener(385);
    this.KMa.dead();
    AppMethodBeat.o(66136);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(66126);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicorMsg.MallIndexUI", "on cache update: %s", new Object[] { paramObject });
      if (paramObject.equals("USERINFO_NEW_BALANCE_LONG")) {
        fZr();
      }
    }
    AppMethodBeat.o(66126);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66135);
    super.onPause();
    this.KLQ.onPause();
    if (this.KLW != null) {
      this.KLW.reset();
    }
    AppMethodBeat.o(66135);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66134);
    Log.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.KLQ.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.imz(), null);
    super.onResume();
    fZr();
    AppMethodBeat.o(66134);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66140);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((paramp instanceof com.tencent.mm.plugin.mall.a.e)) {
      a(((com.tencent.mm.plugin.mall.a.e)paramp).KJb);
    }
    do
    {
      do
      {
        AppMethodBeat.o(66140);
        return true;
      } while (!(paramp instanceof ae));
      paramString = (ae)paramp;
    } while ((!paramString.isJumpRemind()) || (!paramString.getJumpRemind().a(this, new com.tencent.mm.wallet_core.model.g()
    {
      public final void fWQ() {}
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
    extends MallIndexUI.a
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
      AppMethodBeat.i(66113);
      this.KMj = ((LinearLayout)paramView.findViewById(a.f.minh_pos_layout));
      this.KMi = ((ImageView)this.KMj.findViewById(a.f.minh_pos_reddot_iv));
      this.vPl = ((TextView)this.KMj.findViewById(a.f.minh_pos_unread_tv));
      this.KMj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.plugin.newtips.a.gtf().aeI(5);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("key_from_scene", 1);
          com.tencent.mm.br.c.b(MallIndexUI.this.getContext(), "offline", ".ui.WalletOfflineEntranceUI", paramAnonymousView);
          ac.pu(9, 0);
          com.tencent.mm.plugin.report.service.h.OAn.b(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
          com.tencent.mm.plugin.report.service.h.OAn.b(14419, new Object[] { MallIndexUI.this.uuid, Integer.valueOf(1) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$PosView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66112);
        }
      });
      AppMethodBeat.o(66113);
    }
  }
  
  final class c
    extends MallIndexUI.a
  {
    private LinearLayout KMl;
    
    public c(Context paramContext, View paramView)
    {
      super(paramContext, paramView);
    }
    
    public final boolean fZE()
    {
      AppMethodBeat.i(66116);
      com.tencent.mm.kernel.h.baF();
      boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUS, Boolean.FALSE)).booleanValue();
      com.tencent.mm.kernel.h.baF();
      long l = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acUT, Long.valueOf(0L))).longValue();
      if ((bool) && (l > 0L) && (System.currentTimeMillis() >= l))
      {
        Log.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUS, Boolean.FALSE);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acUT, Long.valueOf(0L));
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          this.KMi.setVisibility(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.newtips.a.g.a(this, com.tencent.mm.plugin.newtips.a.k.MsK, bool);
          AppMethodBeat.o(66116);
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
      AppMethodBeat.i(66115);
      this.KMl = ((LinearLayout)paramView.findViewById(a.f.minh_wallet_layout));
      MallIndexUI.this.KKZ = ((TextView)this.KMl.findViewById(a.f.wallet_bottom_text_tv));
      MallIndexUI.a(MallIndexUI.this, (WcPayMoneyLoadingView)this.KMl.findViewById(a.f.wallet_bottom_text_view));
      MallIndexUI.a(MallIndexUI.this, (ProgressBar)this.KMl.findViewById(a.f.wallet_money_load_pb));
      MallIndexUI.this.getLifecycle().addObserver(MallIndexUI.d(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setLoadingPb(MallIndexUI.e(MallIndexUI.this));
      MallIndexUI.d(MallIndexUI.this).setPrefixSymbol("¥");
      MallIndexUI.d(MallIndexUI.this).setTextColor(-1);
      MallIndexUI.d(MallIndexUI.this).setTextSize(com.tencent.mm.cd.a.fromDPToPix(MallIndexUI.this.getContext(), 15));
      this.KMi = ((ImageView)this.KMl.findViewById(a.f.minh_wallet_reddot_iv));
      this.vPl = ((TextView)this.KMl.findViewById(a.f.minh_wallet_unread_tv));
      this.KMl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66114);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          MallIndexUI.c(MallIndexUI.this);
          com.tencent.mm.plugin.newtips.a.gtf().aeI(15);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$WalletView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66114);
        }
      });
      AppMethodBeat.o(66115);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */