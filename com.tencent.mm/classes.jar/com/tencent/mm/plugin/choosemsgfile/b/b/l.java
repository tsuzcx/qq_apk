package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.a.e;
import com.tencent.mm.plugin.choosemsgfile.a.f;

public final class l
  extends RecyclerView.v
{
  public TextView mMb;
  public LinearLayout tMH;
  public ProgressBar tMI;
  
  private l(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123297);
    this.tMH = ((LinearLayout)paramView.findViewById(a.e.container_ll));
    this.mMb = ((TextView)paramView.findViewById(a.e.date_tv));
    this.tMI = ((ProgressBar)paramView.findViewById(a.e.progress_pb));
    AppMethodBeat.o(123297);
  }
  
  public static RecyclerView.v p(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(243361);
    paramViewGroup = new l(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.choose_msg_file_date_item, paramViewGroup, false));
    AppMethodBeat.o(243361);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.l
 * JD-Core Version:    0.7.0.1
 */