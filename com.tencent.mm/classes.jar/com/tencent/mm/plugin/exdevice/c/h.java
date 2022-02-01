package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.n;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
  extends j
{
  public h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(23157);
    n localn = new n();
    localn.qlf = new c();
    localn.qlj = paramInt1;
    localn.qlk = paramInt2;
    this.qgD = localn;
    this.nZd = paramLong;
    this.qgB = 30002;
    AppMethodBeat.o(23157);
  }
  
  public final byte[] cmg()
  {
    AppMethodBeat.i(23158);
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = this.qgD.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(23158);
    return localObject;
  }
  
  public final int cmi()
  {
    AppMethodBeat.i(23159);
    n localn = (n)this.qgD;
    if (localn == null)
    {
      ae.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
      AppMethodBeat.o(23159);
      return -1;
    }
    int i = localn.qlj;
    AppMethodBeat.o(23159);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.h
 * JD-Core Version:    0.7.0.1
 */