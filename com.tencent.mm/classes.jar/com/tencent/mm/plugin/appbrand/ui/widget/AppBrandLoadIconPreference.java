package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.c.a;
import com.tencent.mm.plugin.appbrand.compat.c.b;
import com.tencent.mm.plugin.appbrand.u.c;
import com.tencent.mm.plugin.appbrand.u.e;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference
  extends Preference
{
  public String drJ;
  private ThreeDotsLoadingView haZ;
  private int hgL;
  private int hgM;
  private int hgN;
  private final int hgO = -1;
  private AppBrandNearbyShowcaseView hgS;
  private b.f hiS;
  private View hkK;
  private boolean hkL = false;
  private int hkM = -1;
  private LinkedList<e> hkN = new LinkedList();
  private Context mContext;
  private View mView = null;
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cy(paramContext);
  }
  
  public AppBrandLoadIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cy(paramContext);
  }
  
  private void bX(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new AppBrandLoadIconPreference.4(this, paramView)).start();
    }
  }
  
  private static void c(View paramView, Runnable paramRunnable)
  {
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
  }
  
  private void cy(Context paramContext)
  {
    setLayoutResource(c.b.appbrand_load_icon_preference);
    this.mContext = paramContext;
  }
  
  public static void onDestroy() {}
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.hgL = a.fromDPToPix(this.mContext, 21);
    this.hgM = a.fromDPToPix(this.mContext, 11);
    this.hgN = a.fromDPToPix(this.mContext, 2);
    this.hkK = paramView.findViewById(c.a.app_brand_loading_icon_layout);
    this.haZ = ((ThreeDotsLoadingView)paramView.findViewById(c.a.app_brand_loading_view));
    this.hgS = ((AppBrandNearbyShowcaseView)paramView.findViewById(c.a.app_brand_loading_icon_view));
    this.hgS.setIconSize(this.hgL + this.hgN * 2);
    this.hgS.setIconGap(this.hgM);
    if ((this.drJ == null) || (this.haZ == null))
    {
      y.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
      return;
    }
    if (this.hkL)
    {
      y.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
      return;
    }
    this.hkL = true;
    bX(this.hkK);
    c(this.haZ, null);
    this.haZ.cKb();
    g.DS().O(new AppBrandLoadIconPreference.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference
 * JD-Core Version:    0.7.0.1
 */