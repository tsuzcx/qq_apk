package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.g;

public final class e
  extends RecyclerView.v
{
  public TextView eXr;
  public ImageView gSx;
  public ImageView hqB;
  public TextView hqC;
  public ImageView hqD;
  public AppBrandDesktopView.a hqE;
  
  public e(View paramView)
  {
    super(paramView);
    this.gSx = ((ImageView)paramView.findViewById(y.g.icon));
    this.hqB = ((ImageView)paramView.findViewById(y.g.icon_bg));
    this.eXr = ((TextView)paramView.findViewById(y.g.title));
    this.hqC = ((TextView)paramView.findViewById(y.g.test_mask));
    this.hqD = ((ImageView)paramView.findViewById(y.g.status_icon));
    paramView.setOnClickListener(new e.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */