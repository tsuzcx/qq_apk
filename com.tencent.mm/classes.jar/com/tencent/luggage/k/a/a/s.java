package com.tencent.luggage.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class s
  implements p
{
  private Map<Class<? extends q>, q> chi;
  
  public s()
  {
    AppMethodBeat.i(210404);
    this.chi = new ConcurrentHashMap();
    AppMethodBeat.o(210404);
  }
  
  public final <AddOn extends q> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(210406);
    q localq = (q)this.chi.get(paramClass);
    if ((localq != null) && (paramClass.isInstance(localq)))
    {
      AppMethodBeat.o(210406);
      return localq;
    }
    AppMethodBeat.o(210406);
    return null;
  }
  
  public final <AddOn extends q> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(210405);
    if (paramAddOn == null)
    {
      this.chi.remove(paramClass);
      AppMethodBeat.o(210405);
      return;
    }
    this.chi.put(paramClass, paramAddOn);
    AppMethodBeat.o(210405);
  }
  
  public final String getName()
  {
    return "VideoPlayer#Stub";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.s
 * JD-Core Version:    0.7.0.1
 */