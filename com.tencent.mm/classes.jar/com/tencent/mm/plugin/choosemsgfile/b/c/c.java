package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
  implements g
{
  boolean kFv;
  
  public c(com.tencent.mm.plugin.choosemsgfile.ui.a parama, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    super(parama, paramList);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(54335);
    switch (paramInt)
    {
    default: 
      paramViewGroup = m.m(paramViewGroup);
      AppMethodBeat.o(54335);
      return paramViewGroup;
    }
    paramViewGroup = l.m(paramViewGroup);
    AppMethodBeat.o(54335);
    return paramViewGroup;
  }
  
  public final boolean bgx()
  {
    return this.kFv;
  }
  
  public final int ih(long paramLong)
  {
    AppMethodBeat.i(54336);
    Iterator localIterator = this.jfV.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)localIterator.next();
      int j = i + 1;
      i = j;
      if (locala.kEz != null)
      {
        i = j;
        if (locala.kEz.field_msgId == paramLong)
        {
          AppMethodBeat.o(54336);
          return j;
        }
      }
    }
    AppMethodBeat.o(54336);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.c
 * JD-Core Version:    0.7.0.1
 */