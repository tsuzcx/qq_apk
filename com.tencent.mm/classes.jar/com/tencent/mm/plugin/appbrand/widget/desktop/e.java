package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends RecyclerView.v
{
  public ImageView ivs;
  public ImageView jfs;
  public FrameLayout jft;
  public TextView jfu;
  public ImageView jfv;
  public AppBrandDesktopView.c jfw;
  public TextView titleTv;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(133896);
    this.ivs = ((ImageView)paramView.findViewById(2131820929));
    this.jfs = ((ImageView)paramView.findViewById(2131821522));
    this.jft = ((FrameLayout)paramView.findViewById(2131821540));
    this.titleTv = ((TextView)paramView.findViewById(2131820680));
    this.jfu = ((TextView)paramView.findViewById(2131821523));
    this.jfv = ((ImageView)paramView.findViewById(2131823387));
    AppMethodBeat.o(133896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */