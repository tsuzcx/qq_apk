package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class h
  implements View.OnClickListener
{
  h.c hiA = h.c.hiH;
  final h.d hiB = new h.d((byte)0);
  private final int hiC;
  private final int hiD = 200;
  private final h.a hiE;
  b hiz;
  
  public h(ViewGroup paramViewGroup, int paramInt)
  {
    Context localContext = paramViewGroup.getContext();
    this.hiE = new h.a(this, localContext, (byte)0);
    paramViewGroup = LayoutInflater.from(localContext).inflate(y.h.app_brand_recents_list_header_v2, paramViewGroup, false);
    this.hiB.aie = paramViewGroup;
    this.hiB.hiM = ((TextView)paramViewGroup.findViewById(y.g.title));
    this.hiB.hiN = paramViewGroup.findViewById(y.g.nearby_showcase_container);
    this.hiB.hiP = ((TextView)paramViewGroup.findViewById(y.g.notice_text));
    this.hiB.hiO = ((AppBrandNearbyShowcaseView)paramViewGroup.findViewById(y.g.nearby_icon_showcase));
    this.hiB.him = ((ThreeDotsLoadingView)paramViewGroup.findViewById(y.g.nearby_loading_view));
    this.hiB.hiQ = ((ImageView)paramViewGroup.findViewById(y.g.nearby_refresh_view));
    this.hiB.aie.setOnClickListener(this);
    this.hiB.hiM.setText(paramInt);
    paramViewGroup = this.hiB.hiO;
    if (paramViewGroup != null)
    {
      paramViewGroup.setIconLayerCount(4);
      paramViewGroup.setIconSize(this.hiE.hgL + this.hiE.hgN * 2);
      paramViewGroup.setIconGap(this.hiE.hgM);
    }
    this.hiC = com.tencent.mm.cb.a.i(localContext, y.d.grey_text_color);
  }
  
  static void bY(View paramView)
  {
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(null).start();
  }
  
  protected final void a(List<String> paramList, String paramString, Integer paramInteger)
  {
    y.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingSuccess");
    this.hiA = h.c.hiJ;
    this.hiB.him.cKc();
    bX(this.hiB.him);
    if ((paramList == null) || (paramList.size() == 0))
    {
      y.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.showLoadingSuccess empty iconUrl list");
      return;
    }
    if (paramList == null)
    {
      y.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "prepareIconList without icon urls");
      label67:
      if (paramInteger != null) {
        break label331;
      }
    }
    label331:
    for (int i = this.hiC;; i = paramInteger.intValue())
    {
      if (this.hiB.hiP != null)
      {
        this.hiB.hiP.setText(paramString);
        this.hiB.hiP.setTextColor(i);
      }
      if (this.hiB.hiN == null) {
        break;
      }
      bY(this.hiB.hiN);
      if (this.hiB.hiO != null) {
        this.hiB.hiO.aqT();
      }
      if (this.hiB.hiP == null) {
        break;
      }
      this.hiB.hiP.setAlpha(0.0F);
      this.hiB.hiP.animate().alpha(1.0F).setDuration(500L).start();
      return;
      this.hiB.hiO.setIconLayerCount(Math.min(paramList.size(), 4));
      this.hiB.hiO.dK(false);
      Object localObject = this.hiE;
      if (((h.a)localObject).hiG == null) {
        ((h.a)localObject).hiG = new com.tencent.mm.plugin.appbrand.ui.widget.a(((h.a)localObject).hgL, ((h.a)localObject).hgN);
      }
      localObject = ((h.a)localObject).hiG;
      i = 0;
      while (i < this.hiB.hiO.getChildCount())
      {
        b.JD().a(this.hiB.hiO.mB(i), (String)paramList.get(i), com.tencent.mm.modelappbrand.a.a.JC(), (b.f)localObject);
        i += 1;
      }
      break label67;
    }
  }
  
  protected final void apT()
  {
    y.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loading");
    this.hiA = h.c.hiI;
    bX(this.hiB.hiN);
    bX(this.hiB.hiQ);
    bY(this.hiB.him);
    this.hiB.him.cKb();
  }
  
  final void bX(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new h.1(this, paramView)).start();
    }
  }
  
  public final void onClick(View paramView)
  {
    if (this.hiz != null) {
      this.hiz.a(this.hiA, paramView);
    }
  }
  
  static abstract interface b
  {
    public abstract void a(h.c paramc, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.h
 * JD-Core Version:    0.7.0.1
 */