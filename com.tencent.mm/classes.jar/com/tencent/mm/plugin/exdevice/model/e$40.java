package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class e$40
  implements h.a
{
  e$40(e parame) {}
  
  public final void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(23272);
    ad.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong2) });
    Object localObject1 = this.oUT;
    String str1 = com.tencent.mm.plugin.exdevice.k.b.pe(paramLong1);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).oUa)
    {
      localLinkedList = new LinkedList(((e)localObject1).oUa);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).c(str1, paramInt2, paramLong2);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).oUb.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).c(str2, paramInt2, paramLong2);
    }
    localObject1 = new ew();
    ((ew)localObject1).dht.mac = str2;
    ((ew)localObject1).dht.dgF = paramInt2;
    ((ew)localObject1).dht.dhq = paramLong2;
    a.ESL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    AppMethodBeat.o(23272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.40
 * JD-Core Version:    0.7.0.1
 */