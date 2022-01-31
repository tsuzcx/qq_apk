package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.g;

public final class BaseAppBrandRecentView$c
  extends RecyclerView.v
{
  public View aie;
  public TextView eXr;
  public ImageView gSx;
  public FrameLayout hCT;
  public ImageView hqB;
  public TextView hqC;
  
  public BaseAppBrandRecentView$c(BaseAppBrandRecentView paramBaseAppBrandRecentView, View paramView)
  {
    super(paramView);
    this.aie = paramView;
    paramView.setOnClickListener(new BaseAppBrandRecentView.c.1(this, paramBaseAppBrandRecentView));
    paramView.setOnLongClickListener(new BaseAppBrandRecentView.c.2(this, paramBaseAppBrandRecentView));
    paramView.getLayoutParams().width = (paramBaseAppBrandRecentView.getResources().getDisplayMetrics().widthPixels / 4);
    this.gSx = ((ImageView)paramView.findViewById(y.g.icon));
    this.hqB = ((ImageView)paramView.findViewById(y.g.icon_bg));
    this.hCT = ((FrameLayout)paramView.findViewById(y.g.icon_layout));
    this.eXr = ((TextView)paramView.findViewById(y.g.title));
    this.hqC = ((TextView)paramView.findViewById(y.g.test_mask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c
 * JD-Core Version:    0.7.0.1
 */