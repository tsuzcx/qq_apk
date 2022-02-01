package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.w;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import java.util.List;

public final class d
  extends a
{
  public d(c paramc, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    super(paramc, paramList);
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(123309);
    switch (paramInt)
    {
    default: 
      paramViewGroup = n.o(paramViewGroup);
      AppMethodBeat.o(123309);
      return paramViewGroup;
    }
    paramViewGroup = l.o(paramViewGroup);
    AppMethodBeat.o(123309);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.d
 * JD-Core Version:    0.7.0.1
 */