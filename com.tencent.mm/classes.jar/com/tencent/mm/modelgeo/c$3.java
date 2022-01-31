package com.tencent.mm.modelgeo;

import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c$3
  implements Runnable
{
  c$3(c paramc, a.a parama) {}
  
  public final void run()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.elM.aLS.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
      if ((localWeakReference == null) || (localWeakReference.get() == null) || (((a.a)localWeakReference.get()).equals(this.elW))) {
        ((List)localObject1).add(localWeakReference);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      this.elM.aLS.remove(localObject2);
    }
    y.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[] { Integer.valueOf(this.elM.aLS.size()) });
    if ((this.elM.aLS.size() == 0) && (this.elM.elv != null)) {
      g.Og();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c.3
 * JD-Core Version:    0.7.0.1
 */