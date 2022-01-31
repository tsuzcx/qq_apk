package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import java.util.List;

public abstract class d<_DataSource extends j>
  extends a
  implements View.OnClickListener
{
  private final Class hgK;
  private final int hgL;
  private final int hgM;
  private final int hgN;
  private final int hgO = -1;
  private final com.tencent.mm.plugin.appbrand.ui.widget.a hgP;
  protected final int hgQ = 4;
  private ViewGroup hgR;
  private AppBrandNearbyShowcaseView hgS;
  private volatile List<LocalUsageInfo> hgT;
  private final ViewTreeObserver.OnPreDrawListener hgU = new d.1(this);
  private final j.a hgV = new d.4(this);
  private Activity mActivity;
  private boolean wz;
  
  d(Class<_DataSource> paramClass, Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramActivity;
    this.hgK = paramClass;
    this.hgL = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 25);
    this.hgM = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 19);
    this.hgN = com.tencent.mm.cb.a.fromDPToPix(paramActivity, 2);
    this.hgP = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.hgL, this.hgN);
    this.hgR = ((ViewGroup)LayoutInflater.from(paramActivity).inflate(y.h.app_brand_recents_list_header_folder_entrance, paramViewGroup, false));
    this.hgR.setOnClickListener(this);
    ((TextView)this.hgR.findViewById(y.g.title)).setText(getTitle());
    this.hgS = ((AppBrandNearbyShowcaseView)this.hgR.findViewById(y.g.nearby_icon_showcase));
    this.hgS.setIconLayerCount(4);
    this.hgS.setIconSize(this.hgL + this.hgN * 2);
    this.hgS.setIconGap(this.hgM);
  }
  
  public final void apJ()
  {
    this.wz = true;
    dF(true);
    this.hgR.getViewTreeObserver().addOnPreDrawListener(this.hgU);
  }
  
  public final View apK()
  {
    return this.hgR;
  }
  
  protected abstract List<LocalUsageInfo> apM();
  
  protected final Activity getActivity()
  {
    return this.mActivity;
  }
  
  protected abstract String getTitle();
  
  public void onClick(View paramView) {}
  
  public final void onDetached()
  {
    this.wz = false;
    this.hgR.getViewTreeObserver().removeOnPreDrawListener(this.hgU);
    e.aaT().d(this.hgV);
    ((j)e.G(this.hgK)).d(this.hgV);
  }
  
  public final void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d
 * JD-Core Version:    0.7.0.1
 */