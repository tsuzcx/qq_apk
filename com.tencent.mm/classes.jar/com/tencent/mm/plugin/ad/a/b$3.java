package com.tencent.mm.plugin.ad.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class b$3
  implements Runnable
{
  b$3(b paramb, d paramd) {}
  
  public final void run()
  {
    b localb = this.nkf;
    Object localObject1 = this.nkg;
    y.i("MicroMsg.FileScanQueueService", "onFinishScan fileUri: %s, result: %s", new Object[] { localb.nka, localObject1 });
    Object localObject2 = (List)localb.bV.get(localb.nka);
    if ((localObject2 != null) && (localObject1 != null))
    {
      y.d("MicroMsg.FileScanQueueService", "onFinishScan, callback size: %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
      localObject2 = ((List)localObject2).iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      ((b.a)((Iterator)localObject2).next()).a(localb.nka, ((d)localObject1).result, ((d)localObject1).rawData, ((d)localObject1).bIj, ((d)localObject1).bIk);
      continue;
      if (localObject2 != null)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((b.a)((Iterator)localObject1).next()).Lv(localb.nka);
        }
      }
    }
    localb.bV.remove(localb.nka);
    localb.njZ.remove(localb.nka);
    localb.nka = null;
    localb.nkb = null;
    localb.buv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.b.3
 * JD-Core Version:    0.7.0.1
 */