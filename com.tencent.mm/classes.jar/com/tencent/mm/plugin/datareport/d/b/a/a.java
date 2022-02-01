package com.tencent.mm.plugin.datareport.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.c.i;

public final class a
{
  public Map<String, com.tencent.mm.plugin.datareport.d.a.a> xhk;
  public Map<String, com.tencent.mm.plugin.datareport.d.a.a> xhl;
  
  public a()
  {
    AppMethodBeat.i(262849);
    this.xhk = new ConcurrentHashMap();
    this.xhl = new ConcurrentHashMap();
    AppMethodBeat.o(262849);
  }
  
  public final void b(Object paramObject, com.tencent.mm.plugin.datareport.d.a.a parama)
  {
    AppMethodBeat.i(262858);
    if ((paramObject == null) || (!(paramObject instanceof c)))
    {
      AppMethodBeat.o(262858);
      return;
    }
    paramObject = (c)paramObject;
    if (paramObject.xho)
    {
      str = paramObject.xhn;
      if (!i.hm(str))
      {
        this.xhl.put(str, parama);
        Log.i("PageDataEntityStorage", "[save] page : " + paramObject + ", mPageDataMap size : " + this.xhk.size() + ", mFragDataMap size : " + this.xhl.size());
        com.tencent.mm.plugin.datareport.h.a.Jw(this.xhk.size() + this.xhl.size());
      }
      AppMethodBeat.o(262858);
      return;
    }
    String str = paramObject.xhn + "_" + paramObject.hIa;
    if (!i.hm(str))
    {
      this.xhk.put(str, parama);
      Log.i("PageDataEntityStorage", "[save] page : " + paramObject + ", mPageDataMap size : " + this.xhk.size() + ", mFragDataMap size : " + this.xhl.size());
      com.tencent.mm.plugin.datareport.h.a.Jw(this.xhk.size() + this.xhl.size());
    }
    AppMethodBeat.o(262858);
  }
  
  public final com.tencent.mm.plugin.datareport.d.a.a eT(Object paramObject)
  {
    AppMethodBeat.i(262865);
    if ((paramObject == null) || (!(paramObject instanceof c)))
    {
      AppMethodBeat.o(262865);
      return null;
    }
    paramObject = (c)paramObject;
    if (paramObject.xho)
    {
      paramObject = paramObject.xhn;
      if (!i.hm(paramObject))
      {
        paramObject = (com.tencent.mm.plugin.datareport.d.a.a)this.xhl.get(paramObject);
        AppMethodBeat.o(262865);
        return paramObject;
      }
    }
    else
    {
      paramObject = paramObject.xhn + "_" + paramObject.hIa;
      if (!i.hm(paramObject))
      {
        paramObject = (com.tencent.mm.plugin.datareport.d.a.a)this.xhk.get(paramObject);
        AppMethodBeat.o(262865);
        return paramObject;
      }
    }
    AppMethodBeat.o(262865);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */