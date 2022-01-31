package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
  implements b
{
  private List<b> iou;
  
  public m(i parami)
  {
    AppMethodBeat.i(86994);
    this.iou = new LinkedList();
    this.iou.add(new o(parami));
    this.iou.add(new j(parami));
    AppMethodBeat.o(86994);
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(86995);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(86995);
      return false;
    }
    Iterator localIterator = this.iou.iterator();
    while (localIterator.hasNext()) {
      if (((b)localIterator.next()).a(paramc, paramString))
      {
        AppMethodBeat.o(86995);
        return true;
      }
    }
    AppMethodBeat.o(86995);
    return false;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(86996);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(86996);
      return paramString;
    }
    Iterator localIterator = this.iou.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramc, paramString))
      {
        paramc = localb.b(paramc, paramString);
        AppMethodBeat.o(86996);
        return paramc;
      }
    }
    AppMethodBeat.o(86996);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */