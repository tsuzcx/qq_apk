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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean pld = false;
  
  protected final void cct()
  {
    AppMethodBeat.i(64109);
    g.ajS();
    this.plD = ((String)g.ajR().ajA().get(am.a.IUa, ""));
    com.tencent.mm.plugin.collect.model.n localn = new com.tencent.mm.plugin.collect.model.n(v.aAJ());
    if (!bu.isNullOrNil(this.plD))
    {
      fWy().a(localn, false, 1);
      AppMethodBeat.o(64109);
      return;
    }
    ae.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.pld = true;
    fWy().a(localn, true, 1);
    AppMethodBeat.o(64109);
  }
  
  protected final String ccu()
  {
    AppMethodBeat.i(64110);
    if (bu.isNullOrNil(this.plE)) {
      this.plE = ah.fWc();
    }
    String str = this.plE;
    AppMethodBeat.o(64110);
    return str;
  }
  
  protected final void ccv()
  {
    AppMethodBeat.i(64112);
    ImageView localImageView1 = (ImageView)this.pjp.findViewById(2131298474);
    ImageView localImageView2 = (ImageView)this.pjp.findViewById(2131298465);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.addRule(13);
    localImageView2.setLayoutParams(localLayoutParams);
    if (ad.fom().equals("zh_HK"))
    {
      localImageView1.setImageResource(2131689962);
      localImageView2.setImageResource(2131689958);
      AppMethodBeat.o(64112);
      return;
    }
    localImageView1.setImageResource(2131689961);
    localImageView2.setImageResource(2131689957);
    AppMethodBeat.o(64112);
  }
  
  protected final void ccw()
  {
    AppMethodBeat.i(64113);
    super.ccw();
    if (this.plL)
    {
      findViewById(2131298458).setVisibility(8);
      AppMethodBeat.o(64113);
      return;
    }
    findViewById(2131298458).setVisibility(0);
    AppMethodBeat.o(64113);
  }
  
  public final boolean e(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(64111);
    if ((paramn instanceof com.tencent.mm.plugin.collect.model.n))
    {
      paramString = (com.tencent.mm.plugin.collect.model.n)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.dmy == 0)
        {
          this.plD = paramString.phf;
          this.mTrueName = paramString.php;
          this.plE = paramString.pho;
          refreshView();
          if (!bu.isNullOrNil(paramString.phl))
          {
            this.plZ.setText(paramString.phl);
            this.pmc.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64105);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                f.p(CollectHKMainUI.this.getContext(), paramString.phm, false);
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64105);
              }
            });
            this.pmc.setVisibility(0);
            if (bu.isNullOrNil(paramString.iWA)) {
              break label171;
            }
            this.plA.setText(paramString.iWA);
            this.plA.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64106);
                b localb = new b();
                localb.bd(paramAnonymousView);
                a.b("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (!bu.isNullOrNil(paramString.iWB)) {
                  f.p(CollectHKMainUI.this.getContext(), paramString.iWB, true);
                }
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64106);
              }
            });
            this.plz.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(64111);
            return true;
            this.pmc.setVisibility(8);
            break;
            label171:
            this.plz.setVisibility(8);
          }
        }
      }
      else {
        ae.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramn });
      }
      if (!this.pld)
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
    this.pmc.setVisibility(8);
    findViewById(2131298458).setVisibility(0);
    findViewById(2131298479).setVisibility(8);
    fWy().addSceneEndListener(1335);
    addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64104);
        f.p(CollectHKMainUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
        AppMethodBeat.o(64104);
        return false;
      }
    });
    ccx();
    AppMethodBeat.o(64107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64108);
    super.onDestroy();
    fWy().removeSceneEndListener(1335);
    AppMethodBeat.o(64108);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI
 * JD-Core Version:    0.7.0.1
 */