package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends RecyclerView.v
{
  public ImageView nnL;
  public ImageView ooB;
  public ViewGroup ooC;
  public TextView ooD;
  public ImageView ooE;
  public ImageView ooF;
  public AppBrandDesktopView.c ooG;
  public TextView titleTv;
  
  public d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(49643);
    this.nnL = ((ImageView)paramView.findViewById(2131302468));
    this.ooB = ((ImageView)paramView.findViewById(2131302483));
    this.ooC = ((ViewGroup)paramView.findViewById(2131302498));
    this.titleTv = ((TextView)paramView.findViewById(2131309195));
    this.ooD = ((TextView)paramView.findViewById(2131308973));
    this.ooE = ((ImageView)paramView.findViewById(2131308398));
    this.ooF = ((ImageView)paramView.findViewById(2131302585));
    AppMethodBeat.o(49643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.d
 * JD-Core Version:    0.7.0.1
 */