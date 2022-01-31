package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class am$3
  implements Runnable
{
  am$3(am paramam, apo paramapo) {}
  
  public final void run()
  {
    AppMethodBeat.i(129729);
    if (!bo.es(this.hcX.xfp))
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.hcX.xfp.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((ccn)localIterator.next()).username);
      }
      s.a(localLinkedList, k.a.hjf);
    }
    AppMethodBeat.o(129729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am.3
 * JD-Core Version:    0.7.0.1
 */