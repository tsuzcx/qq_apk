package com.tencent.mm.plugin.choosemsgfile.logic.b;

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
  public TextView pIJ;
  public LinearLayout wPX;
  public ProgressBar wPY;
  
  private l(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123297);
    this.wPX = ((LinearLayout)paramView.findViewById(a.e.container_ll));
    this.pIJ = ((TextView)paramView.findViewById(a.e.date_tv));
    this.wPY = ((ProgressBar)paramView.findViewById(a.e.progress_pb));
    AppMethodBeat.o(123297);
  }
  
  public static RecyclerView.v t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(262589);
    paramViewGroup = new l(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.choose_msg_file_date_item, paramViewGroup, false));
    AppMethodBeat.o(262589);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.l
 * JD-Core Version:    0.7.0.1
 */