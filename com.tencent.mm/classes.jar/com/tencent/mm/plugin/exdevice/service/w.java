package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;

public class w
  extends k.a
{
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(23700);
    Log.i("MicroMsg.exdevice.OnStateChangeCallBack", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d, profileType = %d", new Object[] { b.Dj(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong2) });
    AppMethodBeat.o(23700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.w
 * JD-Core Version:    0.7.0.1
 */