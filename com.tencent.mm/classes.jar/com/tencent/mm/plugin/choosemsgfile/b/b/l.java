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
  public TextView jUO;
  public LinearLayout qnZ;
  public ProgressBar qoa;
  
  private l(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123297);
    this.qnZ = ((LinearLayout)paramView.findViewById(2131299179));
    this.jUO = ((TextView)paramView.findViewById(2131299419));
    this.qoa = ((ProgressBar)paramView.findViewById(2131306296));
    AppMethodBeat.o(123297);
  }
  
  public static RecyclerView.v o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123298);
    paramViewGroup = new l(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493643, paramViewGroup, false));
    AppMethodBeat.o(123298);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.l
 * JD-Core Version:    0.7.0.1
 */