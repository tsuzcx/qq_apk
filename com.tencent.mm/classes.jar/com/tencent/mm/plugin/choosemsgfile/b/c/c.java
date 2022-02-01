package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.w;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
  implements g
{
  boolean opw;
  
  public c(com.tencent.mm.plugin.choosemsgfile.ui.c paramc, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    super(paramc, paramList);
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(123307);
    switch (paramInt)
    {
    default: 
      paramViewGroup = m.o(paramViewGroup);
      AppMethodBeat.o(123307);
      return paramViewGroup;
    }
    paramViewGroup = l.o(paramViewGroup);
    AppMethodBeat.o(123307);
    return paramViewGroup;
  }
  
  public final boolean bUT()
  {
    return this.opw;
  }
  
  public final int rB(long paramLong)
  {
    AppMethodBeat.i(123308);
    Iterator localIterator = this.myd.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)localIterator.next();
      int j = i + 1;
      i = j;
      if (locala.ooz != null)
      {
        i = j;
        if (locala.ooz.field_msgId == paramLong)
        {
          AppMethodBeat.o(123308);
          return j;
        }
      }
    }
    AppMethodBeat.o(123308);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.c
 * JD-Core Version:    0.7.0.1
 */