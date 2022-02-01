package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  boolean tMZ;
  
  public c(e parame, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    super(parame, paramList);
  }
  
  public final int If(long paramLong)
  {
    AppMethodBeat.i(123308);
    Iterator localIterator = this.rEV.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)localIterator.next();
      int j = i + 1;
      i = j;
      if (locala.tMi != null)
      {
        i = j;
        if (locala.tMi.field_msgId == paramLong)
        {
          AppMethodBeat.o(123308);
          return j;
        }
      }
    }
    AppMethodBeat.o(123308);
    return -1;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(243300);
    switch (paramInt)
    {
    default: 
      paramViewGroup = m.p(paramViewGroup);
      AppMethodBeat.o(243300);
      return paramViewGroup;
    }
    paramViewGroup = l.p(paramViewGroup);
    AppMethodBeat.o(243300);
    return paramViewGroup;
  }
  
  public final boolean cMY()
  {
    return this.tMZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.c
 * JD-Core Version:    0.7.0.1
 */