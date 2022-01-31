package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.d.i;

public class CollectHKMainUI
  extends CollectMainUI
{
  private boolean iKM = false;
  
  protected final void aEY()
  {
    g.DQ();
    this.iLi = ((String)g.DP().Dz().get(ac.a.uwB, ""));
    com.tencent.mm.plugin.collect.b.m localm = new com.tencent.mm.plugin.collect.b.m(q.Gq());
    if (!bk.bl(this.iLi))
    {
      cNr().a(localm, false, 1);
      return;
    }
    y.i("MicroMsg.CollectHKMainUI", "force load payurl");
    this.iKM = true;
    cNr().a(localm, true, 1);
  }
  
  protected final String aEZ()
  {
    return this.iLj;
  }
  
  protected final String aFa()
  {
    if (bk.bl(this.iLk)) {
      this.iLk = ab.cML();
    }
    return this.iLk;
  }
  
  protected final void aFb()
  {
    ImageView localImageView1 = (ImageView)this.iIZ.findViewById(a.f.collect_main_save_top_logo_iv);
    ImageView localImageView2 = (ImageView)this.iIZ.findViewById(a.f.collect_main_save_bottom_logo_iv);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.bottomMargin = 0;
    localLayoutParams.addRule(13);
    localImageView2.setLayoutParams(localLayoutParams);
    if (x.cqJ().equals("zh_HK"))
    {
      localImageView1.setImageResource(a.h.collect_top_logo_hk_traditional);
      localImageView2.setImageResource(a.h.collect_bottom_logo_hk_traditional);
      return;
    }
    localImageView1.setImageResource(a.h.collect_top_logo_hk);
    localImageView2.setImageResource(a.h.collect_bottom_logo_hk);
  }
  
  protected final void aFc()
  {
    super.aFc();
    if (this.iLq)
    {
      findViewById(a.f.collect_main_hk_tips).setVisibility(8);
      return;
    }
    findViewById(a.f.collect_main_hk_tips).setVisibility(0);
  }
  
  public final boolean g(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.collect.b.m))
    {
      paramString = (com.tencent.mm.plugin.collect.b.m)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.iHq == 0)
        {
          this.iLi = paramString.iHs;
          this.iLj = paramString.iHE;
          this.iLk = paramString.iHB;
          aqU();
          if (!bk.bl(paramString.iHy))
          {
            this.iLD.setText(paramString.iHy);
            this.iLG.setOnClickListener(new CollectHKMainUI.2(this, paramString));
            this.iLG.setVisibility(0);
            if (bk.bl(paramString.iHC)) {
              break label161;
            }
            this.iLf.setText(paramString.iHC);
            this.iLf.setOnClickListener(new CollectHKMainUI.3(this, paramString));
            this.iLf.setVisibility(0);
          }
          for (;;)
          {
            return true;
            this.iLG.setVisibility(8);
            break;
            label161:
            this.iLf.setVisibility(8);
          }
        }
      }
      else {
        y.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[] { paramm });
      }
      if (!this.iKM) {
        return true;
      }
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.iLG.setVisibility(8);
    findViewById(a.f.collect_main_hk_tips).setVisibility(0);
    findViewById(a.f.collect_menu_more_btn_layout).setVisibility(8);
    cNr().kh(1335);
    addIconOptionMenu(0, a.e.wallet_qanda_icon, new CollectHKMainUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    cNr().ki(1335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectHKMainUI
 * JD-Core Version:    0.7.0.1
 */