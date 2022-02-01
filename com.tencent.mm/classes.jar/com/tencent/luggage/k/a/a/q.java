package com.tencent.luggage.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class q
  implements h
{
  private Map<Class<? extends i>, i> ckh;
  
  public q()
  {
    AppMethodBeat.i(194939);
    this.ckh = new ConcurrentHashMap();
    AppMethodBeat.o(194939);
  }
  
  public final <AddOn extends i> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(194941);
    i locali = (i)this.ckh.get(paramClass);
    if ((locali != null) && (paramClass.isInstance(locali)))
    {
      AppMethodBeat.o(194941);
      return locali;
    }
    AppMethodBeat.o(194941);
    return null;
  }
  
  public final <AddOn extends i> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(194940);
    if (paramAddOn == null)
    {
      this.ckh.remove(paramClass);
      AppMethodBeat.o(194940);
      return;
    }
    this.ckh.put(paramClass, paramAddOn);
    AppMethodBeat.o(194940);
  }
  
  public final String getName()
  {
    return "VideoPlayer#Stub";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.q
 * JD-Core Version:    0.7.0.1
 */