package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.d;

public final class BizTimeLineHotListView$b
  extends RecyclerView.v
{
  public View aie;
  public TextView eXr;
  public ImageView gSx;
  public FrameLayout hCT;
  public ImageView hqB;
  public ImageView ihv;
  
  public BizTimeLineHotListView$b(BizTimeLineHotListView paramBizTimeLineHotListView, View paramView)
  {
    super(paramView);
    this.aie = paramView;
    paramView.getLayoutParams().width = (paramBizTimeLineHotListView.getResources().getDisplayMetrics().widthPixels / 4);
    this.gSx = ((ImageView)paramView.findViewById(b.d.biz_time_line_hot_view_item_icon));
    this.hqB = ((ImageView)paramView.findViewById(b.d.biz_time_line_hot_view_item_icon_bg));
    this.hCT = ((FrameLayout)paramView.findViewById(b.d.biz_time_line_hot_view_item_icon_layout));
    this.eXr = ((TextView)paramView.findViewById(b.d.biz_time_line_hot_view_item_title));
    this.ihv = ((ImageView)paramView.findViewById(b.d.biz_time_line_hot_view_item_unread_dot));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.b
 * JD-Core Version:    0.7.0.1
 */