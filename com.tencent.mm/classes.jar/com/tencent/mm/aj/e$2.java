package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e$2
  implements e.a
{
  e$2(e parame) {}
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(150238);
    Log.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramString, Integer.valueOf(e.a(this.iKB).size()), Integer.valueOf(e.a(this.iKB).size()) });
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (e.a(this.iKB))
      {
        localIterator = e.a(this.iKB).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = (e.a)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
      localIterator.remove();
    }
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      ((e.a)((Iterator)???).next()).Mr(paramString);
    }
    AppMethodBeat.o(150238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.e.2
 * JD-Core Version:    0.7.0.1
 */