package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class r
  implements i
{
  private Map<Class<? extends j>, j> cry;
  
  public r()
  {
    AppMethodBeat.i(186735);
    this.cry = new ConcurrentHashMap();
    AppMethodBeat.o(186735);
  }
  
  public final <AddOn extends j> AddOn U(Class<AddOn> paramClass)
  {
    AppMethodBeat.i(186737);
    j localj = (j)this.cry.get(paramClass);
    if ((localj != null) && (paramClass.isInstance(localj)))
    {
      AppMethodBeat.o(186737);
      return localj;
    }
    AppMethodBeat.o(186737);
    return null;
  }
  
  public final <AddOn extends j> void a(Class<AddOn> paramClass, AddOn paramAddOn)
  {
    AppMethodBeat.i(186736);
    if (paramAddOn == null)
    {
      this.cry.remove(paramClass);
      AppMethodBeat.o(186736);
      return;
    }
    this.cry.put(paramClass, paramAddOn);
    AppMethodBeat.o(186736);
  }
  
  public final String getName()
  {
    return "VideoPlayer#Stub";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.r
 * JD-Core Version:    0.7.0.1
 */