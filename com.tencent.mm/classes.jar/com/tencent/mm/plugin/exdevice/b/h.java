package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends j
{
  public h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(19049);
    n localn = new n();
    localn.lGZ = new c();
    localn.lHd = paramInt1;
    localn.lHe = paramInt2;
    this.lCw = localn;
    this.jRn = paramLong;
    this.lCu = 30002;
    AppMethodBeat.o(19049);
  }
  
  public final byte[] bpw()
  {
    AppMethodBeat.i(19050);
    Object localObject = null;
    try
    {
      byte[] arrayOfByte = this.lCw.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(19050);
    return localObject;
  }
  
  public final int bpy()
  {
    AppMethodBeat.i(19051);
    n localn = (n)this.lCw;
    if (localn == null)
    {
      ab.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
      AppMethodBeat.o(19051);
      return -1;
    }
    int i = localn.lHd;
    AppMethodBeat.o(19051);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.h
 * JD-Core Version:    0.7.0.1
 */