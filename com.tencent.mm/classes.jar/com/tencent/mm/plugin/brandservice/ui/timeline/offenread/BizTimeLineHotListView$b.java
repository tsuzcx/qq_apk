package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BizTimeLineHotListView$b
  extends RecyclerView.v
{
  public View aku;
  public ImageView ivs;
  public ImageView jZd;
  public ImageView jfs;
  public FrameLayout jft;
  public TextView titleTv;
  
  public BizTimeLineHotListView$b(BizTimeLineHotListView paramBizTimeLineHotListView, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(14289);
    this.aku = paramView;
    paramView.getLayoutParams().width = (paramBizTimeLineHotListView.getResources().getDisplayMetrics().widthPixels / 4);
    this.ivs = ((ImageView)paramView.findViewById(2131821869));
    this.jfs = ((ImageView)paramView.findViewById(2131821870));
    this.jft = ((FrameLayout)paramView.findViewById(2131821868));
    this.titleTv = ((TextView)paramView.findViewById(2131821872));
    this.jZd = ((ImageView)paramView.findViewById(2131821871));
    AppMethodBeat.o(14289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView.b
 * JD-Core Version:    0.7.0.1
 */