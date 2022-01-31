package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.q.b;
import com.tencent.mm.plugin.appbrand.appusage.r.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.protocal.c.ayr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

final class i
  extends a
  implements View.OnClickListener, q.b
{
  View aie;
  private Activity bMV;
  private final int hgL;
  private final int hgM;
  private final int hgN;
  private final int hgO = -1;
  private View hiN;
  private i.a hiR = i.a.hjc;
  private b.f hiS;
  private final int hiT;
  private TextView hiU;
  private AppBrandNearbyShowcaseView hiV;
  private View hiW;
  private ImageView hiX;
  private boolean hiY = false;
  private ThreeDotsLoadingView him;
  
  i(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.bMV = paramActivity;
    this.hgL = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 25);
    this.hgM = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 19);
    this.hgN = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 2);
    this.aie = LayoutInflater.from(paramActivity).inflate(y.h.app_brand_recents_list_header_v2, paramViewGroup, false);
    paramViewGroup = this.aie.findViewById(y.g.content_root);
    this.hiW = paramViewGroup;
    paramViewGroup.setOnClickListener(this);
    this.hiN = this.aie.findViewById(y.g.nearby_showcase_container);
    this.hiU = ((TextView)this.aie.findViewById(y.g.notice_text));
    this.hiV = ((AppBrandNearbyShowcaseView)this.aie.findViewById(y.g.nearby_icon_showcase));
    this.hiV.setIconLayerCount(4);
    this.hiV.setIconSize(this.hgL + this.hgN * 2);
    this.hiV.setIconGap(this.hgM);
    this.him = ((ThreeDotsLoadingView)this.aie.findViewById(y.g.nearby_loading_view));
    this.hiX = ((ImageView)this.aie.findViewById(y.g.nearby_refresh_view));
    this.hiT = com.tencent.mm.cb.a.i(paramActivity, y.d.grey_text_color);
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramActivity, "android.permission.ACCESS_COARSE_LOCATION")) {
      this.hiR = i.a.hje;
    }
  }
  
  private void apT()
  {
    this.hiR = i.a.hjd;
    bX(this.hiN);
    bX(this.hiX);
    bY(this.him);
    this.him.cKb();
  }
  
  private void apU()
  {
    int i = 1;
    int k = 0;
    if (this.aie == null) {}
    do
    {
      do
      {
        return;
        if (q.acZ())
        {
          dF(true);
          localObject = ((AppBrandLauncherUI)this.bMV).hcW;
          if (localObject != null) {
            ((r.d)localObject).fJi[5] = "1";
          }
        }
        for (;;)
        {
          this.him.cKc();
          bX(this.him);
          if (i.a.hje != this.hiR) {
            break;
          }
          bX(this.hiN);
          bX(this.hiX);
          return;
          dF(false);
        }
        Object localObject = q.ade();
        if (localObject == null)
        {
          this.hiR = i.a.hja;
          bX(this.hiN);
          bY(this.hiX);
          return;
        }
        if ((((ang)localObject).hHm <= 0) || (bk.dk(((ang)localObject).tjf)))
        {
          this.hiR = i.a.hjc;
          bX(this.hiN);
          return;
        }
        this.hiR = i.a.hjb;
        r.d locald = ((AppBrandLauncherUI)this.bMV).hcW;
        if (locald != null) {
          locald.fJi[3] = "1";
        }
        if (this.hiU != null)
        {
          this.hiU.setText(((ang)localObject).tjl);
          this.hiU.setTextColor(bb(((ang)localObject).tjm, this.hiT));
        }
        this.hiV.setIconLayerCount(Math.min(((ang)localObject).tjf.size(), 4));
        if (this.hiN.getVisibility() != 0) {}
        for (;;)
        {
          if (i != 0) {
            this.hiV.dK(false);
          }
          int j = k;
          if (this.hiS == null)
          {
            this.hiS = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.hgL, this.hgN);
            j = k;
          }
          while (j < this.hiV.getChildCount())
          {
            b.JD().a(this.hiV.mB(j), ((ayr)((ang)localObject).tjf.get(j)).tux, com.tencent.mm.modelappbrand.a.a.JC(), this.hiS);
            j += 1;
          }
          i = 0;
        }
        bY(this.hiN);
      } while (i == 0);
      if (this.hiV != null) {
        this.hiV.aqT();
      }
    } while (this.hiU == null);
    this.hiU.setAlpha(0.0F);
    this.hiU.animate().alpha(1.0F).setDuration(500L).start();
  }
  
  private void apV()
  {
    if (this.bMV == null) {}
    r.d locald;
    do
    {
      return;
      locald = ((AppBrandLauncherUI)this.bMV).hcW;
    } while (locald == null);
    locald.fJi[8] = "1";
  }
  
  private void bX(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new i.2(this, paramView)).start();
    }
  }
  
  private static void bY(View paramView)
  {
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(null).start();
  }
  
  private static int bb(String paramString, int paramInt)
  {
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public final void adh()
  {
    if (this.aie != null) {
      this.aie.post(new i.3(this));
    }
  }
  
  public final void apJ()
  {
    dF(q.acZ());
    if (i.a.hje == this.hiR)
    {
      apU();
      return;
    }
    q.a(this);
    if (!q.adf())
    {
      this.aie.post(new i.1(this));
      return;
    }
    if (q.refresh())
    {
      apT();
      return;
    }
    dF(false);
  }
  
  public final View apK()
  {
    return this.aie;
  }
  
  public final void onClick(View paramView)
  {
    int i = 0;
    if ((paramView.getId() != y.g.content_root) || (this.bMV == null)) {}
    do
    {
      do
      {
        return;
      } while (i.a.hjd == this.hiR);
      if (i.a.hjc == this.hiR)
      {
        apV();
        this.bMV.startActivityForResult(new Intent(this.bMV, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 0), 3);
        return;
      }
      if (i.a.hje == this.hiR)
      {
        apV();
        this.bMV.startActivityForResult(new Intent(this.bMV, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
        return;
      }
      if ((q.ade() != null) && (q.adf())) {}
      for (boolean bool = true;; bool = false)
      {
        this.hiY = bool;
        if ((i.a.hja == this.hiR) || (this.hiY)) {
          i = 1;
        }
        paramView = new i.4(this);
        if (i == 0) {
          break;
        }
        apT();
        q.refresh();
        return;
      }
      paramView.run();
    } while ((q.ade() == null) || (q.ade().tjn != 1) || (this.hiU == null));
    this.hiU.animate().alpha(0.0F).setDuration(200L);
  }
  
  public final void onDetached()
  {
    q.b(this);
    this.bMV = null;
    this.aie = null;
    this.hiV = null;
    this.hiN = null;
  }
  
  public final void onResume()
  {
    if ((i.a.hje == this.hiR) && (com.tencent.mm.pluginsdk.permission.a.j(this.bMV, "android.permission.ACCESS_COARSE_LOCATION")))
    {
      this.hiR = i.a.hjc;
      apJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.i
 * JD-Core Version:    0.7.0.1
 */