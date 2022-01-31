package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class ar$b
  implements Closeable
{
  private final u gWp;
  private final Map<ao, y> gWq;
  
  private ar$b(u paramu)
  {
    AppMethodBeat.i(86802);
    this.gWq = new HashMap();
    this.gWp = paramu;
    AppMethodBeat.o(86802);
  }
  
  final Collection<y> avZ()
  {
    AppMethodBeat.i(86803);
    synchronized (this.gWq)
    {
      Collection localCollection = this.gWq.values();
      AppMethodBeat.o(86803);
      return localCollection;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(86805);
    synchronized (this.gWq)
    {
      this.gWq.clear();
      if (this.gWp != null) {
        this.gWp.close();
      }
      AppMethodBeat.o(86805);
      return;
    }
  }
  
  final y yy(String paramString)
  {
    AppMethodBeat.i(86804);
    if (this.gWp == null)
    {
      AppMethodBeat.o(86804);
      return null;
    }
    ao localao = this.gWp.findAppropriateModuleInfo(paramString);
    if (localao == null)
    {
      AppMethodBeat.o(86804);
      return null;
    }
    synchronized (this.gWq)
    {
      Object localObject = (y)this.gWq.get(localao);
      paramString = (String)localObject;
      if (localObject == null)
      {
        localObject = this.gWq;
        paramString = new y(localao);
        ((Map)localObject).put(localao, paramString);
      }
      AppMethodBeat.o(86804);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ar.b
 * JD-Core Version:    0.7.0.1
 */