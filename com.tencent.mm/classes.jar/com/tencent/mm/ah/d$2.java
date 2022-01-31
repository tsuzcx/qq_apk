package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class d$2
  implements d.a
{
  d$2(d paramd) {}
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(77874);
    ab.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramString, Integer.valueOf(d.a(this.frO).size()), Integer.valueOf(d.a(this.frO).size()) });
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (d.a(this.frO))
      {
        localIterator = d.a(this.frO).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = (d.a)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
      localIterator.remove();
    }
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      ((d.a)((Iterator)???).next()).re(paramString);
    }
    AppMethodBeat.o(77874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ah.d.2
 * JD-Core Version:    0.7.0.1
 */