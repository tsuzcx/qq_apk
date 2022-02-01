package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.c.i;

final class bx
  extends b
{
  public final boolean aeZ(String paramString)
  {
    AppMethodBeat.i(324946);
    String str = m.fL(paramString);
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      paramString = (cd)localIterator.next();
      if (i.qA(str, paramString.url)) {
        localIterator.remove();
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        this.ttz.addLast(paramString);
        AppMethodBeat.o(324946);
        return true;
      }
      AppMethodBeat.o(324946);
      return false;
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bx
 * JD-Core Version:    0.7.0.1
 */