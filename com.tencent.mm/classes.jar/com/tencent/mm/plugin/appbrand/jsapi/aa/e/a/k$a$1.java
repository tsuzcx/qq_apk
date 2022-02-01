package com.tencent.mm.plugin.appbrand.jsapi.aa.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.j;
import d.g.a.a;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"sort", "", "invoke"})
final class k$a$1
  extends d.g.b.l
  implements a<y>
{
  k$a$1(k.a parama, List paramList, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AppMethodBeat.i(139809);
    Object localObject = (Iterable)this.kCK;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localCollection.add(Long.valueOf(this.kCJ.fKK.getLong(str, 0L)));
    }
    j.k((Iterable)localCollection);
    this.kCJ.fKK.removeValueForKey((String)this.kCK.get(0));
    this.kCK.set(0, this.kCL);
    this.kCJ.fKK.putLong(this.kCL, System.currentTimeMillis());
    AppMethodBeat.o(139809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.e.a.k.a.1
 * JD-Core Version:    0.7.0.1
 */