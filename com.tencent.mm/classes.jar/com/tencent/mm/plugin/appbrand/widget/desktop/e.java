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
  public ImageView kXS;
  public TextView lVA;
  public ImageView lVB;
  public AppBrandDesktopView.c lVC;
  public ImageView lVy;
  public FrameLayout lVz;
  public TextView titleTv;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49643);
    this.kXS = ((ImageView)paramView.findViewById(2131300874));
    this.lVy = ((ImageView)paramView.findViewById(2131300884));
    this.lVz = ((FrameLayout)paramView.findViewById(2131300892));
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.lVA = ((TextView)paramView.findViewById(2131305706));
    this.lVB = ((ImageView)paramView.findViewById(2131305201));
    AppMethodBeat.o(49643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */