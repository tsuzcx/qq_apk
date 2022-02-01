package com.tencent.mm.plugin.appbrand.a;

import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wexnet.SessionKeeper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ai/AppBrandXNetSessionMgr;", "Lcom/tencent/luggage/base/ICustomize;", "()V", "idCounter", "", "getIdCounter", "()I", "setIdCounter", "(I)V", "sessionMap", "", "Lcom/tencent/mm/wexnet/SessionKeeper;", "getSessionMap", "()Ljava/util/Map;", "setSessionMap", "(Ljava/util/Map;)V", "getSessionKeeper", "sessionId", "release", "", "releaseAll", "storeSessionKeeper", "sessionPtr", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  private int qAw;
  private Map<Integer, SessionKeeper> qAx;
  
  public a()
  {
    AppMethodBeat.i(317254);
    this.qAx = ((Map)new LinkedHashMap());
    AppMethodBeat.o(317254);
  }
  
  public final int a(SessionKeeper paramSessionKeeper)
  {
    try
    {
      AppMethodBeat.i(317258);
      s.u(paramSessionKeeper, "sessionPtr");
      int i = this.qAw;
      this.qAw = (i + 1);
      this.qAx.put(Integer.valueOf(i), paramSessionKeeper);
      AppMethodBeat.o(317258);
      return i;
    }
    finally
    {
      paramSessionKeeper = finally;
      throw paramSessionKeeper;
    }
  }
  
  public final void releaseAll()
  {
    try
    {
      AppMethodBeat.i(317265);
      Iterator localIterator = ((Iterable)this.qAx.values()).iterator();
      while (localIterator.hasNext()) {
        ((SessionKeeper)localIterator.next()).close();
      }
      AppMethodBeat.o(317265);
    }
    finally {}
  }
  
  public final SessionKeeper zg(int paramInt)
  {
    try
    {
      AppMethodBeat.i(317262);
      SessionKeeper localSessionKeeper = (SessionKeeper)this.qAx.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(317262);
      return localSessionKeeper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.a
 * JD-Core Version:    0.7.0.1
 */