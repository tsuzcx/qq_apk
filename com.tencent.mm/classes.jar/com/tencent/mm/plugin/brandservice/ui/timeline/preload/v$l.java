package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.c;
import com.tencent.mm.plugin.webview.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMCacheSlotManager;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class v$l
  implements Runnable
{
  v$l(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(195707);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)this.pEx).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        Log.i("MicroMsg.WebPrefetcher", "pre dns:".concat(String.valueOf(InetAddress.getByName(str))));
        Object localObject = c.pmm;
        localObject = c.cln();
        p.g(str, "host");
        ((MMCacheSlotManager)localObject).add(str);
        localLinkedList.add(str);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebPrefetcher", "InetAddress Error, " + localException.getMessage());
      }
    }
    b.agp(localLinkedList.size());
    AppMethodBeat.o(195707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.l
 * JD-Core Version:    0.7.0.1
 */