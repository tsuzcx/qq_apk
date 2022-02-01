package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.t.a;
import com.tencent.mm.sdk.platformtools.ad;
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
    AppMethodBeat.i(23273);
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "null";
    }
    ad.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject1 });
    localObject1 = this.oUT;
    paramString = b.pe(paramLong);
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    }
    LinkedList localLinkedList;
    for (;;)
    {
      ad.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (bool) {
        break label250;
      }
      synchronized (((e)localObject1).oUa)
      {
        localLinkedList = new LinkedList(((e)localObject1).oUa);
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
    localObject1 = ((e)localObject1).oUb.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).b(paramString, null, false);
    }
    label250:
    AppMethodBeat.o(23273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.41
 * JD-Core Version:    0.7.0.1
 */