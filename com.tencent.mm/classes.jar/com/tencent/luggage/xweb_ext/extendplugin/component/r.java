package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
  implements i
{
  private Map<Class<? extends j>, j> cEY;
  
  public r()
  {
    AppMethodBeat.i(226724);
    this.cEY = new ConcurrentHashMap();
    AppMethodBeat.o(226724);
  }
  
  public final <AddOn extends j> AddOn X(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(226729);
    j localj = (j)this.cEY.get(paramClass);
    if ((localj != null) && (paramClass.isInstance(localj)))
    {
      AppMethodBeat.o(226729);
      return localj;
    }
    AppMethodBeat.o(226729);
    return null;
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(226725);
    if (paramAddOn == null)
    {
      this.cEY.remove(paramClass);
      AppMethodBeat.o(226725);
      return;
    }
    this.cEY.put(paramClass, paramAddOn);
    AppMethodBeat.o(226725);
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