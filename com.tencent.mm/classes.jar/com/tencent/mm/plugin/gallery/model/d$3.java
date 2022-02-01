package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class d$3
  implements d.b
{
  d$3(d paramd) {}
  
  public final void alN(String paramString)
  {
    AppMethodBeat.i(179449);
    ae.d("MicroMsg.GalleryCache", "now listener size : " + this.tQS.tQR.size());
    Object localObject;
    if (j.DEBUG)
    {
      localObject = this.tQS.tQR.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ae.d("MicroMsg.GalleryCache", "decodeTaskKey: %s.", new Object[] { ((Map.Entry)((Iterator)localObject).next()).getKey() });
      }
    }
    ae.d("MicroMsg.GalleryCache", "will hit??? decodeTaskKey: %s.", new Object[] { paramString });
    if (this.tQS.tQR.containsKey(paramString))
    {
      ae.d("MicroMsg.GalleryCache", "hit!!!");
      localObject = (d.b)this.tQS.tQR.get(paramString);
      if (localObject != null) {
        ((d.b)localObject).alN(paramString);
      }
      AppMethodBeat.o(179449);
      return;
    }
    ae.w("MicroMsg.GalleryCache", "not hit!!!");
    AppMethodBeat.o(179449);
  }
  
  public final String cXn()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.d.3
 * JD-Core Version:    0.7.0.1
 */