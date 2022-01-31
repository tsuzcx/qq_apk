package com.tencent.mm.plugin.ad.a;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString, b.a parama, Set paramSet) {}
  
  public final void run()
  {
    b localb = this.nkf;
    Object localObject1 = this.nkc;
    b.a locala1 = this.nkd;
    Object localObject2 = this.nke;
    localb.njZ.put(localObject1, localObject2);
    if (localb.bV.containsKey(localObject1))
    {
      localObject1 = (List)localb.bV.get(localObject1);
      label98:
      int i;
      if (localObject1 != null)
      {
        if (localObject1 != null)
        {
          if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
            break label116;
          }
          y.e("MicroMsg.FileScanQueueService", "isCallbackInList, list is null or nil");
          break label125;
          i = 0;
          label100:
          if (i == 0) {
            break label163;
          }
        }
        y.e("MicroMsg.FileScanQueueService", "addToCallbackList, list is null or callback is already in list");
      }
      for (;;)
      {
        localb.buv();
        return;
        label116:
        localObject2 = ((List)localObject1).iterator();
        label125:
        if (!((Iterator)localObject2).hasNext()) {
          break label98;
        }
        b.a locala2 = (b.a)((Iterator)localObject2).next();
        if ((locala2 == null) || (locala2 != locala1)) {
          break;
        }
        i = 1;
        break label100;
        label163:
        ((List)localObject1).add(locala1);
      }
    }
    localObject2 = new LinkedList();
    ((List)localObject2).add(locala1);
    localb.bV.put(localObject1, localObject2);
    localb.eqn.add(localObject1);
    localb.buv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.b.1
 * JD-Core Version:    0.7.0.1
 */