package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"sort", "", "invoke"})
final class k$a$1
  extends q
  implements a<x>
{
  k$a$1(k.a parama, List paramList, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AppMethodBeat.i(139809);
    Object localObject = (Iterable)this.mNi;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localCollection.add(Long.valueOf(this.mNh.gUu.getLong(str, 0L)));
    }
    j.n((Iterable)localCollection);
    this.mNh.gUu.removeValueForKey((String)this.mNi.get(0));
    this.mNi.set(0, this.mNj);
    this.mNh.gUu.putLong(this.mNj, System.currentTimeMillis());
    AppMethodBeat.o(139809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.k.a.1
 * JD-Core Version:    0.7.0.1
 */