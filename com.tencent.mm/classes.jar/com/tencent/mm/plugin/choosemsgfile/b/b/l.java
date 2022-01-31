package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends RecyclerView.v
{
  public TextView gpp;
  public LinearLayout kFc;
  public ProgressBar kFd;
  
  private l(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(54325);
    this.kFc = ((LinearLayout)paramView.findViewById(2131822806));
    this.gpp = ((TextView)paramView.findViewById(2131822808));
    this.kFd = ((ProgressBar)paramView.findViewById(2131822807));
    AppMethodBeat.o(54325);
  }
  
  public static RecyclerView.v m(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(54326);
    paramViewGroup = new l(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969149, paramViewGroup, false));
    AppMethodBeat.o(54326);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.l
 * JD-Core Version:    0.7.0.1
 */