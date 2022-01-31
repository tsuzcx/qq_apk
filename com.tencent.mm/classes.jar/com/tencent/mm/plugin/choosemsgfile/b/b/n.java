package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class n
  extends RecyclerView.v
{
  public final ImageView ehv;
  public final ProgressBar gvS;
  public final TextView gve;
  public final TextView hsI;
  public final ImageView iQd;
  public final LinearLayout kFc;
  public final MMPinProgressBtn kFf;
  public final CheckBox kFl;
  public final ImageView kFn;
  public final View kFp;
  public final TextView timeTv;
  public final TextView titleTv;
  
  private n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(54333);
    this.kFc = ((LinearLayout)paramView.findViewById(2131822806));
    this.ehv = ((ImageView)paramView.findViewById(2131821210));
    this.gve = ((TextView)paramView.findViewById(2131821254));
    this.timeTv = ((TextView)paramView.findViewById(2131821004));
    this.kFl = ((CheckBox)paramView.findViewById(2131821631));
    this.kFp = paramView.findViewById(2131822815);
    this.kFn = ((ImageView)paramView.findViewById(2131822491));
    this.iQd = ((ImageView)paramView.findViewById(2131821253));
    this.titleTv = ((TextView)paramView.findViewById(2131821212));
    this.hsI = ((TextView)paramView.findViewById(2131821009));
    this.kFf = ((MMPinProgressBtn)paramView.findViewById(2131822683));
    this.gvS = ((ProgressBar)paramView.findViewById(2131821643));
    this.kFc.setOnClickListener(new n.1(this));
    this.kFp.setOnClickListener(new n.2(this));
    AppMethodBeat.o(54333);
  }
  
  public static RecyclerView.v m(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(54334);
    paramViewGroup = new n(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969151, paramViewGroup, false));
    AppMethodBeat.o(54334);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.n
 * JD-Core Version:    0.7.0.1
 */