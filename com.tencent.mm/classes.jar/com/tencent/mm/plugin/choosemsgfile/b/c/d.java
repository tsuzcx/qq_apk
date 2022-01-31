package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import java.util.List;

public final class d
  extends a
{
  public d(com.tencent.mm.plugin.choosemsgfile.ui.a parama, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    super(parama, paramList);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(54337);
    switch (paramInt)
    {
    default: 
      paramViewGroup = n.m(paramViewGroup);
      AppMethodBeat.o(54337);
      return paramViewGroup;
    }
    paramViewGroup = l.m(paramViewGroup);
    AppMethodBeat.o(54337);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.d
 * JD-Core Version:    0.7.0.1
 */