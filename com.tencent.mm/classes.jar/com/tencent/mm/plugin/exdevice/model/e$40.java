package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(19199);
    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong2) });
    Object localObject1 = this.lEh;
    String str1 = com.tencent.mm.plugin.exdevice.j.b.jw(paramLong1);
    LinkedList localLinkedList;
    synchronized (((e)localObject1).lDo)
    {
      localLinkedList = new LinkedList(((e)localObject1).lDo);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).c(str1, paramInt2, paramLong2);
      }
    }
    localLinkedList.clear();
    localObject1 = ((e)localObject1).lDp.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((e.b)((Iterator)localObject1).next()).c(str2, paramInt2, paramLong2);
    }
    localObject1 = new eq();
    ((eq)localObject1).csx.mac = str2;
    ((eq)localObject1).csx.crJ = paramInt2;
    ((eq)localObject1).csx.csu = paramLong2;
    a.ymk.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
    AppMethodBeat.o(19199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.40
 * JD-Core Version:    0.7.0.1
 */