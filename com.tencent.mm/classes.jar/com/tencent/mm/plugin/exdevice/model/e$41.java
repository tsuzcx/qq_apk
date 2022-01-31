package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.t.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class e$41
  extends t.a
{
  e$41(e parame) {}
  
  public final void b(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "null";
    }
    y.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1 });
    localObject1 = this.juI;
    paramString = b.ee(paramLong);
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    }
    LinkedList localLinkedList;
    for (;;)
    {
      y.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (bool) {
        return;
      }
      synchronized (((e)localObject1).jtP)
      {
        localLinkedList = new LinkedList(((e)localObject1).jtP);
        ??? = localLinkedList.iterator();
        while (((Iterator)???).hasNext())
        {
          ((e.b)((Iterator)???).next()).b(paramString, null, false);
          continue;
          bool = false;
        }
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).jtQ.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(paramString, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.41
 * JD-Core Version:    0.7.0.1
 */