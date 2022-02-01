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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.collect.model.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.f;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean qAt = false;
  
  protected final void cAn()
  {
    AppMethodBeat.i(64109);
    g.aAi();
    this.qAT = ((String)g.aAh().azQ().get(ar.a.Oco, ""));
    n localn = new n(z.aUf());
    if (!Util.isNullOrNil(this.qAT))
    {
      hhW().a(localn, false, 1);
      AppMethodBeat.o(64109);
      return;
    }
    Log.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.qAt = true;
    hhW().a(localn, true, 1);
    AppMethodBeat.o(64109);
  }
  
  protected final String cAo()
  {
    AppMethodBeat.i(64110);
    if (Util.isNullOrNil(this.qAU)) {
      this.qAU = ah.hhz();
    }
    String str = this.qAU;
    AppMethodBeat.o(64110);
    return str;
  }
  
  protected final void cAp()
  {
    AppMethodBeat.i(64112);
    ImageView localImageView1 = (ImageView)this.qyA.findViewById(2131298888);
    ImageView localImageView2 = (ImageView)this.qyA.findViewById(2131298879);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.addRule(13);
    localImageView2.setLayoutParams(localLayoutParams);
    if (LocaleUtil.getApplicationLanguage().equals("zh_HK"))
    {
      localImageView1.setImageResource(2131689986);
      localImageView2.setImageResource(2131689982);
      AppMethodBeat.o(64112);
      return;
    }
    localImageView1.setImageResource(2131689985);
    localImageView2.setImageResource(2131689981);
    AppMethodBeat.o(64112);
  }
  
  protected final void cAq()
  {
    AppMethodBeat.i(64113);
    super.cAq();
    if (this.qBb)
    {
      findViewById(2131298871).setVisibility(8);
      AppMethodBeat.o(64113);
      return;
    }
    findViewById(2131298871).setVisibility(0);
    AppMethodBeat.o(64113);
  }
  
  public final boolean e(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(64111);
    if ((paramq instanceof n))
    {
      paramString = (n)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.dDN == 0)
        {
          this.qAT = paramString.qwo;
          this.mTrueName = paramString.qwy;
          this.qAU = paramString.qwx;
          refreshView();
          if (!Util.isNullOrNil(paramString.qwu))
          {
            this.qBp.setText(paramString.qwu);
            this.qBs.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64105);
                b localb = new b();
                localb.bm(paramAnonymousView);
                a.b("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                f.p(CollectHKMainUI.this.getContext(), paramString.qwv, false);
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64105);
              }
            });
            this.qBs.setVisibility(0);
            if (Util.isNullOrNil(paramString.jTx)) {
              break label171;
            }
            this.qAQ.setText(paramString.jTx);
            this.qAQ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64106);
                b localb = new b();
                localb.bm(paramAnonymousView);
                a.b("com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (!Util.isNullOrNil(paramString.jTy)) {
                  f.p(CollectHKMainUI.this.getContext(), paramString.jTy, true);
                }
                a.a(this, "com/tencent/mm/plugin/collect/ui/CollectHKMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64106);
              }
            });
            this.qAP.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(64111);
            return true;
            this.qBs.setVisibility(8);
            break;
            label171:
            this.qAP.setVisibility(8);
          }
        }
      }
      else {
        Log.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramq });
      }
      if (!this.qAt)
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
    this.qBs.setVisibility(8);
    findViewById(2131298871).setVisibility(0);
    findViewById(2131298898).setVisibility(8);
    hhW().addSceneEndListener(1335);
    addIconOptionMenu(0, 2131235663, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64104);
        f.p(CollectHKMainUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
        AppMethodBeat.o(64104);
        return false;
      }
    });
    cAr();
    AppMethodBeat.o(64107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64108);
    super.onDestroy();
    hhW().removeSceneEndListener(1335);
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