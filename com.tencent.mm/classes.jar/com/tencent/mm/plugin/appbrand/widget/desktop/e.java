package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends RecyclerView.w
{
  public ImageView lzC;
  public ImageView mxA;
  public FrameLayout mxB;
  public TextView mxC;
  public ImageView mxD;
  public AppBrandDesktopView.c mxE;
  public TextView titleTv;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49643);
    this.lzC = ((ImageView)paramView.findViewById(2131300874));
    this.mxA = ((ImageView)paramView.findViewById(2131300884));
    this.mxB = ((FrameLayout)paramView.findViewById(2131300892));
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.mxC = ((TextView)paramView.findViewById(2131305706));
    this.mxD = ((ImageView)paramView.findViewById(2131305201));
    AppMethodBeat.o(49643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */