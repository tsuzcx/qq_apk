package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
  implements i
{
  private Map<Class<? extends j>, j> csb;
  
  public r()
  {
    AppMethodBeat.i(220418);
    this.csb = new ConcurrentHashMap();
    AppMethodBeat.o(220418);
  }
  
  public final <AddOn extends j> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(220420);
    j localj = (j)this.csb.get(paramClass);
    if ((localj != null) && (paramClass.isInstance(localj)))
    {
      AppMethodBeat.o(220420);
      return localj;
    }
    AppMethodBeat.o(220420);
    return null;
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(220419);
    if (paramAddOn == null)
    {
      this.csb.remove(paramClass);
      AppMethodBeat.o(220419);
      return;
    }
    this.csb.put(paramClass, paramAddOn);
    AppMethodBeat.o(220419);
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