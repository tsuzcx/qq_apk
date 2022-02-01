package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.model.ai;
import com.tencent.mm.wallet_core.ui.k;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean xcK = false;
  
  public final boolean d(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(64111);
    if ((paramp instanceof m))
    {
      paramString = (m)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.hAV == 0)
        {
          this.xdl = paramString.wYJ;
          this.mTrueName = paramString.wYT;
          this.xdm = paramString.wYS;
          refreshView();
          if (!Util.isNullOrNil(paramString.wYP))
          {
            this.xdH.setText(paramString.wYP);
            this.xdK.setOnClickListener(new k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(293642);
                com.tencent.mm.wallet_core.ui.i.p(CollectHKMainUI.this.getContext(), paramString.wYQ, false);
                AppMethodBeat.o(293642);
              }
            });
            this.xdK.setVisibility(0);
            if (Util.isNullOrNil(paramString.pHt)) {
              break label171;
            }
            this.xdi.setText(paramString.pHt);
            this.xdi.setOnClickListener(new k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(293644);
                if (!Util.isNullOrNil(paramString.pHu)) {
                  com.tencent.mm.wallet_core.ui.i.p(CollectHKMainUI.this.getContext(), paramString.pHu, true);
                }
                AppMethodBeat.o(293644);
              }
            });
            this.xdh.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(64111);
            return true;
            this.xdK.setVisibility(8);
            break;
            label171:
            this.xdh.setVisibility(8);
          }
        }
      }
      else {
        Log.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramp });
      }
      if (!this.xcK)
      {
        AppMethodBeat.o(64111);
        return true;
      }
    }
    AppMethodBeat.o(64111);
    return false;
  }
  
  protected final void dss()
  {
    AppMethodBeat.i(64109);
    h.baF();
    this.xdl = ((String)h.baE().ban().get(at.a.acRT, ""));
    m localm = new m(z.bAV());
    if (!Util.isNullOrNil(this.xdl))
    {
      jPx().a(localm, false, 1);
      AppMethodBeat.o(64109);
      return;
    }
    Log.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.xcK = true;
    jPx().a(localm, true, 1);
    AppMethodBeat.o(64109);
  }
  
  protected final String dst()
  {
    AppMethodBeat.i(64110);
    if (Util.isNullOrNil(this.xdm)) {
      this.xdm = ai.jOX();
    }
    String str = this.xdm;
    AppMethodBeat.o(64110);
    return str;
  }
  
  protected final void dsu()
  {
    AppMethodBeat.i(64112);
    ImageView localImageView1 = (ImageView)this.xaT.findViewById(a.f.collect_main_save_top_logo_iv);
    ImageView localImageView2 = (ImageView)this.xaT.findViewById(a.f.collect_main_save_bottom_logo_iv);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.addRule(13);
    localImageView2.setLayoutParams(localLayoutParams);
    if (LocaleUtil.getApplicationLanguage().equals("zh_HK"))
    {
      localImageView1.setImageResource(a.h.collect_top_logo_hk_traditional);
      localImageView2.setImageResource(a.h.collect_bottom_logo_hk_traditional);
      AppMethodBeat.o(64112);
      return;
    }
    localImageView1.setImageResource(a.h.collect_top_logo_hk);
    localImageView2.setImageResource(a.h.collect_bottom_logo_hk);
    AppMethodBeat.o(64112);
  }
  
  protected final void dsv()
  {
    AppMethodBeat.i(64113);
    super.dsv();
    if (this.xdt)
    {
      findViewById(a.f.collect_main_hk_tips).setVisibility(8);
      AppMethodBeat.o(64113);
      return;
    }
    findViewById(a.f.collect_main_hk_tips).setVisibility(0);
    AppMethodBeat.o(64113);
  }
  
  protected final String getTrueName()
  {
    return this.mTrueName;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64107);
    super.onCreate(paramBundle);
    this.xdK.setVisibility(8);
    findViewById(a.f.collect_main_hk_tips).setVisibility(0);
    findViewById(a.f.collect_menu_more_btn_layout).setVisibility(8);
    jPx().addSceneEndListener(1335);
    addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64104);
        com.tencent.mm.wallet_core.ui.i.p(CollectHKMainUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
        AppMethodBeat.o(64104);
        return false;
      }
    });
    dsw();
    AppMethodBeat.o(64107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64108);
    super.onDestroy();
    jPx().removeSceneEndListener(1335);
    AppMethodBeat.o(64108);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI
 * JD-Core Version:    0.7.0.1
 */