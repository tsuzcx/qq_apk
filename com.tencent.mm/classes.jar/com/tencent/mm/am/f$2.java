package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f$2
  implements f.a
{
  f$2(f paramf) {}
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(150238);
    Log.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramString, Integer.valueOf(f.a(this.lAH).size()), Integer.valueOf(f.a(this.lAH).size()) });
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Iterator localIterator;
      synchronized (f.a(this.lAH))
      {
        localIterator = f.a(this.lAH).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = (f.a)((WeakReference)localObject2).get();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
      localIterator.remove();
    }
    ??? = localArrayList.iterator();
    while (((Iterator)???).hasNext()) {
      ((f.a)((Iterator)???).next()).TM(paramString);
    }
    AppMethodBeat.o(150238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.f.2
 * JD-Core Version:    0.7.0.1
 */