package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.y;

public class w
  extends k.a
{
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    y.i("MicroMsg.exdevice.OnStateChangeCallBack", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d, profileType = %d", new Object[] { b.ee(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.w
 * JD-Core Version:    0.7.0.1
 */