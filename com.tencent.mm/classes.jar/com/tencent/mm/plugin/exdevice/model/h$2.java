package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.sdk.platformtools.y;

final class h$2
  extends k.a
{
  h$2(h paramh, h.a parama) {}
  
  public final void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    y.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong2) });
    f.a locala = h.a(this.jvu).dU(paramLong1);
    if (locala != null)
    {
      locala.bKp = paramInt2;
      locala.hUQ = paramLong2;
    }
    for (;;)
    {
      this.jvv.a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
      return;
      y.i(h.TAG, "get connect state faild : %d", new Object[] { Long.valueOf(paramLong1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.h.2
 * JD-Core Version:    0.7.0.1
 */