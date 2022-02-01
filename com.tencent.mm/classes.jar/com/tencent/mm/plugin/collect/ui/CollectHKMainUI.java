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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.i;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean oBc = false;
  
  protected final void bWB()
  {
    AppMethodBeat.i(64109);
    g.agS();
    this.oBC = ((String)g.agR().agA().get(ah.a.GNk, ""));
    com.tencent.mm.plugin.collect.model.n localn = new com.tencent.mm.plugin.collect.model.n(u.axD());
    if (!bs.isNullOrNil(this.oBC))
    {
      fAS().a(localn, false, 1);
      AppMethodBeat.o(64109);
      return;
    }
    ac.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.oBc = true;
    fAS().a(localn, true, 1);
    AppMethodBeat.o(64109);
  }
  
  protected final String bWC()
  {
    AppMethodBeat.i(64110);
    if (bs.isNullOrNil(this.oBD)) {
      this.oBD = ah.fAw();
    }
    String str = this.oBD;
    AppMethodBeat.o(64110);
    return str;
  }
  
  protected final void bWD()
  {
    AppMethodBeat.i(64112);
    ImageView localImageView1 = (ImageView)this.ozo.findViewById(2131298474);
    ImageView localImageView2 = (ImageView)this.ozo.findViewById(2131298465);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.addRule(13);
    localImageView2.setLayoutParams(localLayoutParams);
    if (ab.eUO().equals("zh_HK"))
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
  
  protected final void bWE()
  {
    AppMethodBeat.i(64113);
    super.bWE();
    if (this.oBK)
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
        if (paramString.dae == 0)
        {
          this.oBC = paramString.oxg;
          this.mTrueName = paramString.oxq;
          this.oBD = paramString.oxp;
          refreshView();
          if (!bs.isNullOrNil(paramString.oxm))
          {
            this.oBY.setText(paramString.oxm);
            this.oCb.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64105);
                com.tencent.mm.wallet_core.ui.e.o(CollectHKMainUI.this.getContext(), paramString.oxn, false);
                AppMethodBeat.o(64105);
              }
            });
            this.oCb.setVisibility(0);
            if (bs.isNullOrNil(paramString.iAx)) {
              break label171;
            }
            this.oBz.setText(paramString.iAx);
            this.oBz.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(64106);
                if (!bs.isNullOrNil(paramString.iAy)) {
                  com.tencent.mm.wallet_core.ui.e.o(CollectHKMainUI.this.getContext(), paramString.iAy, true);
                }
                AppMethodBeat.o(64106);
              }
            });
            this.oBy.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(64111);
            return true;
            this.oCb.setVisibility(8);
            break;
            label171:
            this.oBy.setVisibility(8);
          }
        }
      }
      else {
        ac.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramn });
      }
      if (!this.oBc)
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
    this.oCb.setVisibility(8);
    findViewById(2131298458).setVisibility(0);
    findViewById(2131298479).setVisibility(8);
    fAS().addSceneEndListener(1335);
    addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64104);
        com.tencent.mm.wallet_core.ui.e.o(CollectHKMainUI.this.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
        AppMethodBeat.o(64104);
        return false;
      }
    });
    bWF();
    AppMethodBeat.o(64107);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(64108);
    super.onDestroy();
    fAS().removeSceneEndListener(1335);
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