package com.tencent.mm.plugin.choosemsgfile.logic.ui;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.choosemsgfile.logic.b.l;
import com.tencent.mm.plugin.choosemsgfile.logic.b.m;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  boolean wQp;
  
  public c(e parame, List<com.tencent.mm.plugin.choosemsgfile.logic.b.a> paramList)
  {
    super(parame, paramList);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(262578);
    switch (paramInt)
    {
    default: 
      paramViewGroup = m.t(paramViewGroup);
      AppMethodBeat.o(262578);
      return paramViewGroup;
    }
    paramViewGroup = l.t(paramViewGroup);
    AppMethodBeat.o(262578);
    return paramViewGroup;
  }
  
  public final boolean dqE()
  {
    return this.wQp;
  }
  
  public final int kx(long paramLong)
  {
    AppMethodBeat.i(123308);
    Iterator localIterator = this.uQh.iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)localIterator.next();
      int j = i + 1;
      i = j;
      if (locala.wPy != null)
      {
        i = j;
        if (locala.wPy.field_msgId == paramLong)
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
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.ui.c
 * JD-Core Version:    0.7.0.1
 */