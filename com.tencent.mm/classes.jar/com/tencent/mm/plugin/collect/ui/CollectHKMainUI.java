package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.g;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean tZt = false;
  
  protected final void cON()
  {
    AppMethodBeat.i(64109);
    h.aHH();
    this.tZT = ((String)h.aHG().aHp().get(ar.a.Vqr, ""));
    o localo = new o(z.bdg());
    if (!Util.isNullOrNil(this.tZT))
    {
      ijz().a(localo, false, 1);
      AppMethodBeat.o(64109);
      return;
    }
    Log.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.tZt = true;
    ijz().a(localo, true, 1);
    AppMethodBeat.o(64109);
  }
  
  protected final String cOO()
  {
    AppMethodBeat.i(64110);
    if (Util.isNullOrNil(this.tZU)) {
      this.tZU = ah.ijb();
    }
    String str = this.tZU;
    AppMethodBeat.o(64110);
    return str;
  }
  
  protected final void cOP()
  {
    AppMethodBeat.i(64112);
    ImageView localImageView1 = (ImageView)this.tXA.findViewById(a.f.collect_main_save_top_logo_iv);
    ImageView localImageView2 = (ImageView)this.tXA.findViewById(a.f.collect_main_save_bottom_logo_iv);
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
  
  protected final void cOQ()
  {
    AppMethodBeat.i(64113);
    super.cOQ();
    if (this.uab)
    {
      findViewById(a.f.collect_main_hk_tips).setVisibility(8);
      AppMethodBeat.o(64113);
      return;
    }
    findViewById(a.f.collect_main_hk_tips).setVisibility(0);
    AppMethodBeat.o(64113);
  }
  
  public final boolean f(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64111);
    if ((paramq instanceof o))
    {
      paramString = (o)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.fwx == 0)
        {
          this.tZT = paramString.tVp;
          this.mTrueName = paramString.tVz;
          this.tZU = paramString.tVy;
          refreshView();
          if (!Util.isNullOrNil(paramString.tVv))
          {
            this.uap.setText(paramString.tVv);
            this.uas.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64105);
                b localb = new b();
                localb.bn(paramAnonymousView);
                a.c("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                g.p(CollectHKMainUI.this.getContext(), paramString.tVw, false);
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64105);
              }
            });
            this.uas.setVisibility(0);
            if (Util.isNullOrNil(paramString.mKL)) {
              break label171;
            }
            this.tZQ.setText(paramString.mKL);
            this.tZQ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64106);
                b localb = new b();
                localb.bn(paramAnonymousView);
                a.c("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if (!Util.isNullOrNil(paramString.mKM)) {
                  g.p(CollectHKMainUI.this.getContext(), paramString.mKM, true);
                }
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64106);
              }
            });
            this.tZP.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(64111);
            return true;
            this.uas.setVisibility(8);
            break;
            label171:
            this.tZP.setVisibility(8);
          }
        }
      }
      else {
        Log.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramq });
      }
      if (!this.tZt)
      {
        AppMethodBeat.o(64111);
        return true;
      }
    }
    AppMethodBeat.o(64111);
    return false;
  }
  
  protected final String getTrueName()
  {
    return this.mTrueName;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64107);
    super.onCreate(paramBundle);
    this.uas.setVisibility(8);
    findViewById(a.f.collect_main_hk_tips).setVisibility(0);
    findViewById(a.f.collect_menu_more_btn_layout).setVisibility(8);
    ijz().addSceneEndListener(1335);
    addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64104);
        g.p(CollectHKMainUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
        AppMethodBeat.o(64104);
        return false;
      }
    });
    cOR();
    AppMethodBeat.o(64107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64108);
    super.onDestroy();
    ijz().removeSceneEndListener(1335);
    AppMethodBeat.o(64108);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI
 * JD-Core Version:    0.7.0.1
 */