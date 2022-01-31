package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class d$3
  implements Runnable
{
  d$3(d paramd, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(78129);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.fCe.aTm.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
      if ((localWeakReference == null) || (localWeakReference.get() == null) || (((b.a)localWeakReference.get()).equals(this.fCo))) {
        ((List)localObject1).add(localWeakReference);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      this.fCe.aTm.remove(localObject2);
    }
    ab.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[] { Integer.valueOf(this.fCe.aTm.size()) });
    if ((this.fCe.aTm.size() == 0) && (this.fCe.fBN != null)) {
      this.fCe.fBN.agV();
    }
    AppMethodBeat.o(78129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d.3
 * JD-Core Version:    0.7.0.1
 */