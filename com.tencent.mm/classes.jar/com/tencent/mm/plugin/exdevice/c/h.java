package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.n;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends j
{
  public h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(23157);
    n localn = new n();
    localn.pAV = new c();
    localn.pAZ = paramInt1;
    localn.pBa = paramInt2;
    this.pwt = localn;
    this.nsB = paramLong;
    this.pwr = 30002;
    AppMethodBeat.o(23157);
  }
  
  public final byte[] cgm()
  {
    AppMethodBeat.i(23158);
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = this.pwt.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(23158);
    return localObject;
  }
  
  public final int cgo()
  {
    AppMethodBeat.i(23159);
    n localn = (n)this.pwt;
    if (localn == null)
    {
      ac.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
      AppMethodBeat.o(23159);
      return -1;
    }
    int i = localn.pAZ;
    AppMethodBeat.o(23159);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.h
 * JD-Core Version:    0.7.0.1
 */