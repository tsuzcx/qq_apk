package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.plugin.appbrand.config.l.a;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.bsc;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class am$3
  implements Runnable
{
  am$3(am paramam, akd paramakd) {}
  
  public final void run()
  {
    if (!bk.dk(this.fKi.tgH))
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.fKi.tgH.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((bsc)localIterator.next()).username);
      }
      s.a(localLinkedList, l.a.fQu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.am.3
 * JD-Core Version:    0.7.0.1
 */