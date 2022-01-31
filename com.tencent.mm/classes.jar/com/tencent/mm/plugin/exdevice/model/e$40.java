package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.h.a.en;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class e$40
  implements h.a
{
  e$40(e parame) {}
  
  public final void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    y.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong2) });
    Object localObject1 = this.juI;
    String str1 = com.tencent.mm.plugin.exdevice.j.b.ee(paramLong1);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).jtP)
    {
      localLinkedList = new LinkedList(((e)localObject1).jtP);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).d(str1, paramInt2, paramLong2);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).jtQ.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).d(str2, paramInt2, paramLong2);
    }
    localObject1 = new en();
    ((en)localObject1).bLd.mac = str2;
    ((en)localObject1).bLd.bKp = paramInt2;
    ((en)localObject1).bLd.bLa = paramLong2;
    a.udP.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.40
 * JD-Core Version:    0.7.0.1
 */