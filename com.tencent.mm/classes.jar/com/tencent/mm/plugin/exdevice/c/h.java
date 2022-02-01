package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.n;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends j
{
  public h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(23157);
    n localn = new n();
    localn.oXK = new c();
    localn.oXO = paramInt1;
    localn.oXP = paramInt2;
    this.oTi = localn;
    this.mQq = paramLong;
    this.oTg = 30002;
    AppMethodBeat.o(23157);
  }
  
  public final byte[] bZd()
  {
    AppMethodBeat.i(23158);
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = this.oTi.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(23158);
    return localObject;
  }
  
  public final int bZf()
  {
    AppMethodBeat.i(23159);
    n localn = (n)this.oTi;
    if (localn == null)
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
      AppMethodBeat.o(23159);
      return -1;
    }
    int i = localn.oXO;
    AppMethodBeat.o(23159);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.h
 * JD-Core Version:    0.7.0.1
 */