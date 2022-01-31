package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.t.a;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(19200);
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "null";
    }
    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1 });
    localObject1 = this.lEh;
    paramString = b.jw(paramLong);
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    }
    LinkedList localLinkedList;
    for (;;)
    {
      ab.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (bool) {
        break label250;
      }
      synchronized (((e)localObject1).lDo)
      {
        localLinkedList = new LinkedList(((e)localObject1).lDo);
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
    localObject1 = ((e)localObject1).lDp.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(paramString, null, false);
    }
    label250:
    AppMethodBeat.o(19200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.41
 * JD-Core Version:    0.7.0.1
 */