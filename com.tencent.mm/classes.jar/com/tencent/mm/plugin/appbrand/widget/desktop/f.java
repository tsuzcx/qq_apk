package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends RecyclerView.w
{
  public ImageView lZa;
  public ImageView mYh;
  public ViewGroup mYi;
  public TextView mYj;
  public ImageView mYk;
  public ImageView mYl;
  public AppBrandDesktopView.c mYm;
  public TextView titleTv;
  
  public f(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49643);
    this.lZa = ((ImageView)paramView.findViewById(2131300874));
    this.mYh = ((ImageView)paramView.findViewById(2131300884));
    this.mYi = ((ViewGroup)paramView.findViewById(2131300892));
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.mYj = ((TextView)paramView.findViewById(2131305706));
    this.mYk = ((ImageView)paramView.findViewById(2131305201));
    this.mYl = ((ImageView)paramView.findViewById(2131300952));
    AppMethodBeat.o(49643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f
 * JD-Core Version:    0.7.0.1
 */