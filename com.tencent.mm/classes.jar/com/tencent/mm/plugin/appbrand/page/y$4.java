package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.sdk.platformtools.bf;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class y$4
  extends bf<Boolean>
{
  y$4(y paramy, Boolean paramBoolean)
  {
    super(1000L, paramBoolean, (byte)0);
  }
  
  private Boolean anE()
  {
    Object localObject;
    try
    {
      y localy = this.gVq;
      localObject = new LinkedList();
      Iterator localIterator = localy.gVk.iterator();
      while (localIterator.hasNext())
      {
        ((LinkedList)localObject).add(Integer.valueOf(((y.b)localIterator.next()).id));
        continue;
        return Boolean.valueOf(false);
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error " + localException);
    }
    for (;;)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localException.md(((Integer)((Iterator)localObject).next()).intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.y.4
 * JD-Core Version:    0.7.0.1
 */