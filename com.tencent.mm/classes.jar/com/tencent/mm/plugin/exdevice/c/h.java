package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends j
{
  public h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(23157);
    n localn = new n();
    localn.ytJ = new c();
    localn.ytN = paramInt1;
    localn.ytO = paramInt2;
    this.yoS = localn;
    this.vyj = paramLong;
    this.yoQ = 30002;
    AppMethodBeat.o(23157);
  }
  
  public final byte[] dFj()
  {
    AppMethodBeat.i(23158);
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = this.yoS.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(23158);
    return localObject;
  }
  
  public final int dFl()
  {
    AppMethodBeat.i(23159);
    n localn = (n)this.yoS;
    if (localn == null)
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
      AppMethodBeat.o(23159);
      return -1;
    }
    int i = localn.ytN;
    AppMethodBeat.o(23159);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.h
 * JD-Core Version:    0.7.0.1
 */