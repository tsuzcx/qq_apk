package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
  implements i
{
  private Map<Class<? extends j>, j> eyk;
  
  public r()
  {
    AppMethodBeat.i(220594);
    this.eyk = new ConcurrentHashMap();
    AppMethodBeat.o(220594);
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(220601);
    if (paramAddOn == null)
    {
      this.eyk.remove(paramClass);
      AppMethodBeat.o(220601);
      return;
    }
    this.eyk.put(paramClass, paramAddOn);
    AppMethodBeat.o(220601);
  }
  
  public final <AddOn extends j> AddOn ah(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(220605);
    j localj = (j)this.eyk.get(paramClass);
    if ((localj != null) && (paramClass.isInstance(localj)))
    {
      AppMethodBeat.o(220605);
      return localj;
    }
    AppMethodBeat.o(220605);
    return null;
  }
  
  public final String getName()
  {
    return "VideoPlayer#Stub";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.r
 * JD-Core Version:    0.7.0.1
 */