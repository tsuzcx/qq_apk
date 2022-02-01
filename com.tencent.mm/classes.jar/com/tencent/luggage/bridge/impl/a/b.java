package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.a.a;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class b
  implements a
{
  private final List<a.a> eiW;
  
  public b()
  {
    AppMethodBeat.i(140362);
    this.eiW = new LinkedList();
    a(new c());
    AppMethodBeat.o(140362);
  }
  
  public final Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    AppMethodBeat.i(140364);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140364);
      return null;
    }
    Iterator localIterator = this.eiW.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (locala.match(paramString))
      {
        paramString = locala.b(paramString, paramRect, paramb);
        AppMethodBeat.o(140364);
        return paramString;
      }
    }
    AppMethodBeat.o(140364);
    return null;
  }
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(140366);
    this.eiW.remove(parama);
    this.eiW.add(parama);
    AppMethodBeat.o(140366);
  }
  
  public final void a(String paramString, a.c paramc)
  {
    AppMethodBeat.i(220100);
    a(paramString, null, paramc);
    AppMethodBeat.o(220100);
  }
  
  public final void a(String paramString, Map<String, String> paramMap, a.c paramc)
  {
    AppMethodBeat.i(220102);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramc != null)
      {
        paramc.N(null);
        AppMethodBeat.o(220102);
      }
    }
    else
    {
      Iterator localIterator = this.eiW.iterator();
      while (localIterator.hasNext())
      {
        a.a locala = (a.a)localIterator.next();
        if (locala.match(paramString))
        {
          locala.a(paramString, paramMap, paramc);
          AppMethodBeat.o(220102);
          return;
        }
      }
    }
    AppMethodBeat.o(220102);
  }
  
  public final Bitmap eC(String paramString)
  {
    AppMethodBeat.i(140363);
    paramString = a(paramString, null, null);
    AppMethodBeat.o(140363);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.b
 * JD-Core Version:    0.7.0.1
 */