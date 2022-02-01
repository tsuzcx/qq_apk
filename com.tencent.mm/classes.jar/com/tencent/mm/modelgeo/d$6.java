package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class d$6
  implements Runnable
{
  d$6(d paramd, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(231735);
    Object localObject1 = new ArrayList();
    Object localObject2 = d.d(this.oEE).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
      if ((localWeakReference == null) || (localWeakReference.get() == null) || (((b.a)localWeakReference.get()).equals(this.oED))) {
        ((List)localObject1).add(localWeakReference);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      d.d(this.oEE).remove(localObject2);
    }
    Log.i("MicroMsg.LocationGeo", "stop listeners size %d", new Object[] { Integer.valueOf(d.d(this.oEE).size()) });
    if ((d.d(this.oEE).size() == 0) && (d.e(this.oEE) != null)) {
      d.e(this.oEE).bJp();
    }
    AppMethodBeat.o(231735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelgeo.d.6
 * JD-Core Version:    0.7.0.1
 */