package com.tencent.mm.plugin.gallery.ui;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f$a
  extends RecyclerView.v
{
  public ImageView mZY;
  public ImageView neb;
  public RelativeLayout nec;
  public TextView ned;
  public ImageView nef;
  public ImageView neg;
  public ImageView neh;
  public ImageView ngY;
  public View ngZ;
  public int nha;
  
  public f$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(21577);
    this.ngZ = paramView;
    this.neg = ((ImageView)paramView.findViewById(2131826762));
    this.neh = ((ImageView)paramView.findViewById(2131826763));
    this.ngY = ((ImageView)paramView.findViewById(2131822585));
    this.neb = ((ImageView)paramView.findViewById(2131826765));
    this.mZY = ((ImageView)paramView.findViewById(2131822416));
    this.nec = ((RelativeLayout)paramView.findViewById(2131825137));
    this.ned = ((TextView)paramView.findViewById(2131826761));
    this.nef = ((ImageView)paramView.findViewById(2131826764));
    this.nef.setBackgroundResource(2131690159);
    this.nef.setVisibility(8);
    AppMethodBeat.o(21577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.f.a
 * JD-Core Version:    0.7.0.1
 */