package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
  implements i
{
  private Map<Class<? extends j>, j> cEr;
  
  public r()
  {
    AppMethodBeat.i(215555);
    this.cEr = new ConcurrentHashMap();
    AppMethodBeat.o(215555);
  }
  
  public final <AddOn extends j> AddOn X(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(215557);
    j localj = (j)this.cEr.get(paramClass);
    if ((localj != null) && (paramClass.isInstance(localj)))
    {
      AppMethodBeat.o(215557);
      return localj;
    }
    AppMethodBeat.o(215557);
    return null;
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(215556);
    if (paramAddOn == null)
    {
      this.cEr.remove(paramClass);
      AppMethodBeat.o(215556);
      return;
    }
    this.cEr.put(paramClass, paramAddOn);
    AppMethodBeat.o(215556);
  }
  
  public final String getName()
  {
    return "VideoPlayer#Stub";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.r
 * JD-Core Version:    0.7.0.1
 */