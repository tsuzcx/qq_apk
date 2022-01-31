package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.appbrand.e.a.a;
import com.tencent.mm.plugin.appbrand.e.a.b;
import com.tencent.mm.plugin.appbrand.e.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  implements a
{
  private final List<a.b> byC;
  
  public b()
  {
    AppMethodBeat.i(90762);
    this.byC = new LinkedList();
    a(new c());
    AppMethodBeat.o(90762);
  }
  
  public final Bitmap a(String paramString, Rect paramRect, a.c paramc)
  {
    AppMethodBeat.i(90764);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(90764);
      return null;
    }
    Iterator localIterator = this.byC.iterator();
    while (localIterator.hasNext())
    {
      a.b localb = (a.b)localIterator.next();
      if (localb.match(paramString))
      {
        paramString = localb.b(paramString, paramRect, paramc);
        AppMethodBeat.o(90764);
        return paramString;
      }
    }
    AppMethodBeat.o(90764);
    return null;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(90765);
    if (this.byC.contains(paramb)) {
      this.byC.remove(paramb);
    }
    this.byC.add(paramb);
    AppMethodBeat.o(90765);
  }
  
  public final void a(String paramString, a.a parama)
  {
    AppMethodBeat.i(90766);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(90766);
      return;
    }
    Iterator localIterator = this.byC.iterator();
    while (localIterator.hasNext())
    {
      a.b localb = (a.b)localIterator.next();
      if (localb.match(paramString)) {
        localb.a(paramString, parama);
      }
    }
    AppMethodBeat.o(90766);
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(154528);
    paramString = a(paramString, null, paramc);
    if (paramString != null) {
      paramc.C(paramString);
    }
    AppMethodBeat.o(154528);
  }
  
  public final Bitmap bB(String paramString)
  {
    AppMethodBeat.i(90763);
    paramString = a(paramString, null, null);
    AppMethodBeat.o(90763);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.b
 * JD-Core Version:    0.7.0.1
 */