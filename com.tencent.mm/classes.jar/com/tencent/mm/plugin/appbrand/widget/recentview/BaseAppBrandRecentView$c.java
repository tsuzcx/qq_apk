package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BaseAppBrandRecentView$c
  extends RecyclerView.v
{
  public View aku;
  public ImageView ivs;
  public ImageView jfs;
  public FrameLayout jft;
  public TextView jfu;
  public TextView titleTv;
  
  public BaseAppBrandRecentView$c(BaseAppBrandRecentView paramBaseAppBrandRecentView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(134352);
    this.aku = paramView;
    paramView.setOnClickListener(new BaseAppBrandRecentView.c.1(this, paramBaseAppBrandRecentView));
    paramView.setOnLongClickListener(new BaseAppBrandRecentView.c.2(this, paramBaseAppBrandRecentView));
    paramView.getLayoutParams().width = (paramBaseAppBrandRecentView.getResources().getDisplayMetrics().widthPixels / 4);
    this.ivs = ((ImageView)paramView.findViewById(2131820929));
    this.jfs = ((ImageView)paramView.findViewById(2131821522));
    this.jft = ((FrameLayout)paramView.findViewById(2131821540));
    this.titleTv = ((TextView)paramView.findViewById(2131820680));
    this.jfu = ((TextView)paramView.findViewById(2131821523));
    AppMethodBeat.o(134352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c
 * JD-Core Version:    0.7.0.1
 */