package com.tencent.mm.plugin.choosemsgfile.logic.ui;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.logic.b.l;
import com.tencent.mm.plugin.choosemsgfile.logic.b.n;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import java.util.List;

public final class d
  extends a
{
  public d(e parame, List<com.tencent.mm.plugin.choosemsgfile.logic.b.a> paramList)
  {
    super(parame, paramList);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(262577);
    switch (paramInt)
    {
    default: 
      paramViewGroup = n.t(paramViewGroup);
      AppMethodBeat.o(262577);
      return paramViewGroup;
    }
    paramViewGroup = l.t(paramViewGroup);
    AppMethodBeat.o(262577);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.ui.d
 * JD-Core Version:    0.7.0.1
 */