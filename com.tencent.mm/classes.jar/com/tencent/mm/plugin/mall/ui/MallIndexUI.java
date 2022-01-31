package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.lk;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.tk;
import com.tencent.mm.h.a.tk.b;
import com.tencent.mm.h.a.uo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;

@com.tencent.mm.kernel.j
public class MallIndexUI
  extends MallIndexBaseUI
{
  private String cdD;
  private boolean gxZ = false;
  private View igy = null;
  private TextView lZP = null;
  private boolean lZQ = false;
  tk.b maf;
  private String mag;
  private ECardInfo mah;
  private boolean mai = true;
  private RelativeLayout maj;
  private View mak;
  private boolean mal;
  private boolean mam;
  com.tencent.mm.plugin.wallet_core.ui.q man = new com.tencent.mm.plugin.wallet_core.ui.q();
  private com.tencent.mm.sdk.b.c<lk> mao = new MallIndexUI.1(this);
  private boolean maq = false;
  private com.tencent.mm.sdk.b.c mar = new MallIndexUI.8(this);
  private com.tencent.mm.sdk.b.c<uo> mas = new MallIndexUI.9(this);
  private boolean mat = false;
  
  private void a(final com.tencent.mm.plugin.mall.a.a parama)
  {
    if ((parama == null) || (bk.bl(parama.lYg))) {}
    do
    {
      return;
      if (!this.lZQ) {
        break;
      }
    } while (this.lZP == null);
    this.lZP.setText(a.i.mall_gdpr_mall_index);
    this.lZP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        new Intent();
        com.tencent.mm.wallet_core.ui.e.bH(MallIndexUI.this, parama.lYg);
      }
    });
    return;
    this.igy = View.inflate(this, a.g.mall_index_gdpr_foot, null);
    this.igy.setClickable(false);
    this.igy.setEnabled(false);
    this.lZP = ((TextView)this.igy.findViewById(a.f.wallet_region_desc));
    this.lZP.setVisibility(0);
    this.lZP.setText(a.i.mall_gdpr_mall_index);
    this.lZP.setTextColor(getResources().getColor(a.c.link_color));
    this.lZP.setOnClickListener(new MallIndexUI.7(this, parama));
    this.lZt.addFooterView(this.igy);
    this.lZQ = true;
  }
  
  protected final void bgE()
  {
    setMMTitle(a.i.mall_index_ui_title);
  }
  
  protected final void bgF() {}
  
  protected final void bgG()
  {
    com.tencent.mm.plugin.wallet_core.model.o.bVo().bWq();
    if (((com.tencent.mm.plugin.wallet_core.model.o.bVo().bWq().bVL()) || (com.tencent.mm.plugin.wallet_core.model.o.bVo().bWq().bVK())) && (com.tencent.mm.model.q.Gw()))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicorMsg.MallIndexUI", "hy: user not open wallet or status unknown. try query");
      a(new com.tencent.mm.plugin.wallet_core.c.b.a("", false), true, false);
    }
  }
  
  protected final boolean bgI()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "init BankcardList");
    tk localtk = new tk();
    localtk.ccZ.scene = 1;
    localtk.ccZ.cdb = true;
    localtk.ccZ.cdc = true;
    localtk.cda.ccT = new MallIndexUI.2(this, localtk);
    com.tencent.mm.sdk.b.a.udP.a(localtk, Looper.myLooper());
    return false;
  }
  
  protected final void bgM()
  {
    ti localti = new ti();
    localti.ccU.bso = "1";
    localti.bFJ = new MallIndexUI.15(this, localti);
    com.tencent.mm.sdk.b.a.udP.m(localti);
  }
  
  protected final void bgN()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "updateBalanceNum");
    Object localObject = new ae();
    if ((((ae)localObject).qza & 0x4000) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSwitchConfig", "isHideBalanceNum, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((ae)localObject).qza) });
      if (!bool) {
        break;
      }
      g.DQ();
      localObject = (String)g.DP().Dz().get(ac.a.usx, getString(a.i.realname_balance_title));
      this.lZx.setTextColor(getResources().getColor(a.c.mall_index_balance_num_text_color_realname));
      this.lZx.setText((CharSequence)localObject);
      this.lZx.setVisibility(0);
      return;
    }
    if ((((ae)localObject).qza & 0x400000) > 0)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletSwitchConfig", "isShowBalanceAmount, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(((ae)localObject).qza) });
      if (!bool) {
        break label266;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "show balance amount");
      this.lZx.setTextColor(getResources().getColor(a.c.mall_index_balance_num_text_color));
      localObject = com.tencent.mm.plugin.wallet_core.model.o.bVs().qhj;
      if ((localObject == null) || (((Bankcard)localObject).qty < 0.0D)) {
        break label249;
      }
      this.lZx.setText(com.tencent.mm.wallet_core.ui.e.B(((Bankcard)localObject).qty));
    }
    for (;;)
    {
      this.lZx.setVisibility(0);
      return;
      bool = false;
      break;
      label249:
      this.lZx.setText(getString(a.i.wallet_index_ui_default_balance));
    }
    label266:
    this.lZx.setVisibility(8);
  }
  
  protected final void bgP()
  {
    int i = 0;
    this.mController.removeAllOptionMenu();
    g.DQ();
    boolean bool2 = ((Boolean)g.DP().Dz().get(ac.a.uyC, Boolean.valueOf(false))).booleanValue();
    g.DQ();
    long l = ((Long)g.DP().Dz().get(ac.a.uyD, Long.valueOf(0L))).longValue();
    final boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (l > 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() >= l)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "hasRedDot expire, ignore reddot");
          g.DQ();
          g.DP().Dz().c(ac.a.uyC, Boolean.valueOf(false));
          g.DQ();
          g.DP().Dz().c(ac.a.uyD, Long.valueOf(0L));
          bool1 = false;
        }
      }
    }
    com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "addIconOptionMenuByMode, hasRedDot: %s", new Object[] { Boolean.valueOf(bool1) });
    int j = a.e.mall_indexui_new_menu_icon;
    Object localObject = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = h.nFQ;
        if (bool1) {}
        for (int i = 1;; i = 0)
        {
          paramAnonymousMenuItem.f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(i), "", "", Integer.valueOf(0) });
          paramAnonymousMenuItem = MallIndexUI.this;
          boolean bool = MallIndexUI.e(MallIndexUI.this).cdk;
          Intent localIntent = new Intent(paramAnonymousMenuItem, MallIndexMenuUI.class);
          localIntent.putExtra("key_default_show_currency", bool);
          paramAnonymousMenuItem.startActivity(localIntent);
          return true;
        }
      }
    };
    this.mController.addIconOptionMenu(0, 0, j, bool1, (MenuItem.OnMenuItemClickListener)localObject);
    localObject = h.nFQ;
    if (bool1) {
      i = 1;
    }
    ((h)localObject).f(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(i), "", "", Integer.valueOf(1) });
  }
  
  protected final void bgQ()
  {
    if (this.lZw == null) {
      return;
    }
    if ((!com.tencent.mm.y.c.BS().b(ac.a.uxq, ac.a.uxr)) && (!this.maf.cdf))
    {
      k localk = com.tencent.mm.plugin.wallet_core.model.o.bVs().qzg;
      if (localk == null) {
        break label114;
      }
      i = localk.field_red_dot_index;
      g.DQ();
      if ((((Integer)g.DP().Dz().get(ac.a.uqT, Integer.valueOf(-1))).intValue() >= i) || (i <= 0)) {
        break label106;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "bankcard need red point");
    }
    label106:
    label114:
    for (int i = 1; i != 0; i = 0)
    {
      this.lZw.setVisibility(0);
      return;
      com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "bankcard do not need red point");
    }
    this.lZw.setVisibility(8);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    super.c(paramInt1, paramInt2, paramString, paramm);
    if ((paramm instanceof com.tencent.mm.plugin.mall.a.b)) {
      a(((com.tencent.mm.plugin.mall.a.b)paramm).lYh);
    }
    do
    {
      do
      {
        return true;
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_core.c.y));
      paramString = (com.tencent.mm.plugin.wallet_core.c.y)paramm;
    } while ((!paramString.cMv()) || (!paramString.lQQ.a(this, new MallIndexUI.5(this))));
    return true;
  }
  
  protected final void cG(final View paramView)
  {
    Object localObject = (RelativeLayout)paramView.findViewById(a.f.bankcard_area);
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramView.findViewById(a.f.balance_area);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramView.findViewById(a.f.offline_area);
    this.maj = ((RelativeLayout)paramView.findViewById(a.f.lqt_area));
    this.lZx = ((TextView)paramView.findViewById(a.f.balance_num));
    if ((this.lZx instanceof WalletTextView)) {
      ((WalletTextView)this.lZx).setTypeface(7);
    }
    ((RelativeLayout)localObject).setOnClickListener(new MallIndexUI.11(this));
    localRelativeLayout1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "click balance entry");
        g.DQ();
        g.DP().Dz().c(ac.a.uxa, Integer.valueOf(-1));
        paramView.findViewById(a.f.balance_red_dot).setVisibility(8);
        if (!MallIndexUI.a(MallIndexUI.this, MallIndexUI.e(MallIndexUI.this)))
        {
          MallIndexUI.c(MallIndexUI.this);
          MallIndexUI.d(MallIndexUI.this);
        }
      }
    });
    localRelativeLayout2.setOnClickListener(new MallIndexUI.13(this));
    this.maj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "onClick lqtEntrance, isLqbOpen: %s, lqbOpenUrl: %s", new Object[] { Boolean.valueOf(MallIndexUI.f(MallIndexUI.this)), MallIndexUI.g(MallIndexUI.this) });
        g.DQ();
        g.DP().Dz().c(ac.a.uxc, Integer.valueOf(-1));
        MallIndexUI.h(MallIndexUI.this).setVisibility(8);
        if (MallIndexUI.f(MallIndexUI.this)) {
          d.x(MallIndexUI.this.mController.uMN, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        }
        while (bk.bl(MallIndexUI.g(MallIndexUI.this))) {
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", MallIndexUI.g(MallIndexUI.this));
        com.tencent.mm.sdk.platformtools.y.d("MicorMsg.MallIndexUI", "raw url: %s", new Object[] { paramAnonymousView.getStringExtra("rawUrl") });
        d.b(MallIndexUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
      }
    });
    if (this.mal)
    {
      this.maj.setVisibility(0);
      this.lZv = ((ImageView)findViewById(a.f.bankcard_pic));
      this.lZw = ((ImageView)paramView.findViewById(a.f.add_bankcard_new_notify_img));
      localObject = paramView.findViewById(a.f.balance_red_dot);
      g.DQ();
      if (((Integer)g.DP().Dz().get(ac.a.uxa, Integer.valueOf(-1))).intValue() != 1) {
        break label289;
      }
      ((View)localObject).setVisibility(0);
      label223:
      this.mak = paramView.findViewById(a.f.lqt_red_dot);
      g.DQ();
      if (((Integer)g.DP().Dz().get(ac.a.uxc, Integer.valueOf(-1))).intValue() != 1) {
        break label298;
      }
      this.mak.setVisibility(0);
    }
    for (;;)
    {
      bgQ();
      return;
      this.maj.setVisibility(8);
      break;
      label289:
      ((View)localObject).setVisibility(8);
      break label223;
      label298:
      this.mak.setVisibility(8);
    }
  }
  
  public void finish()
  {
    this.gxZ = true;
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicorMsg.MallIndexUI", "onActivityResult %s %s %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 3) {
      if (paramInt2 == -1) {
        this.man.bgR();
      }
    }
    do
    {
      do
      {
        return;
        this.man.cancel();
        return;
      } while (paramInt1 != 5);
      g.DQ();
    } while (((Boolean)g.DP().Dz().get(ac.a.uzC, Boolean.valueOf(false))).booleanValue());
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getWindow().requestFeature(9);
    ((com.tencent.mm.plugin.walletlock.a.b)g.r(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    com.tencent.mm.plugin.wallet_core.model.i.AN(2);
    this.maf = new tk.b();
    this.maf.cdd = false;
    this.maf.cde = true;
    this.maf.cdf = false;
    this.mao.cqo();
    this.mas.cqo();
    this.man.qHp = new MallIndexUI.10(this);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.udP.c(this.mar);
    kh(2713);
    kh(385);
    if (com.tencent.mm.at.b.mC((String)g.DP().Dz().get(274436, null)))
    {
      g.DQ();
      a(new com.tencent.mm.plugin.mall.a.a((String)g.DP().Dz().get(ac.a.uzD, "")));
      g.DQ();
      ((Boolean)g.DP().Dz().get(ac.a.uzC, Boolean.valueOf(false))).booleanValue();
      a(new com.tencent.mm.plugin.mall.a.b(), false, false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mao.dead();
    this.mas.dead();
    ki(2713);
    ki(385);
    com.tencent.mm.sdk.b.a.udP.d(this.mar);
  }
  
  public void onPause()
  {
    super.onPause();
    this.man.onPause();
  }
  
  public void onResume()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicorMsg.MallIndexUI", "alvinluo MallIndexUI onResume");
    this.man.onResume();
    com.tencent.mm.plugin.walletlock.a.b localb = (com.tencent.mm.plugin.walletlock.a.b)g.r(com.tencent.mm.plugin.walletlock.a.b.class);
    localb.a(this, localb.bXL(), null);
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI
 * JD-Core Version:    0.7.0.1
 */