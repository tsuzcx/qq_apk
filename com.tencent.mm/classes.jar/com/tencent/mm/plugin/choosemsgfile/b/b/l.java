package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends RecyclerView.w
{
  public TextView iBM;
  public LinearLayout opd;
  public ProgressBar ope;
  
  private l(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123297);
    this.opd = ((LinearLayout)paramView.findViewById(2131298738));
    this.iBM = ((TextView)paramView.findViewById(2131298933));
    this.ope = ((ProgressBar)paramView.findViewById(2131303528));
    AppMethodBeat.o(123297);
  }
  
  public static RecyclerView.w o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123298);
    paramViewGroup = new l(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493531, paramViewGroup, false));
    AppMethodBeat.o(123298);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.l
 * JD-Core Version:    0.7.0.1
 */