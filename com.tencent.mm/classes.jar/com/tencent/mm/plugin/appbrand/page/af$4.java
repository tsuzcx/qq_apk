package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class af$4
  extends bj<Boolean>
{
  af$4(af paramaf, Boolean paramBoolean)
  {
    super(1000L, paramBoolean, (byte)0);
  }
  
  private Boolean aJK()
  {
    AppMethodBeat.i(91090);
    LinkedList localLinkedList;
    Iterator localIterator;
    try
    {
      af localaf = this.iyF;
      localLinkedList = new LinkedList();
      localIterator = localaf.iyx.iterator();
      while (localIterator.hasNext())
      {
        localLinkedList.add((af.b)localIterator.next());
        continue;
        localBoolean = Boolean.FALSE;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error ".concat(String.valueOf(localException)));
    }
    for (;;)
    {
      Boolean localBoolean;
      AppMethodBeat.o(91090);
      return localBoolean;
      localIterator = localLinkedList.iterator();
      while (localIterator.hasNext()) {
        localBoolean.pg(((af.b)localIterator.next()).id);
      }
      localLinkedList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af.4
 * JD-Core Version:    0.7.0.1
 */