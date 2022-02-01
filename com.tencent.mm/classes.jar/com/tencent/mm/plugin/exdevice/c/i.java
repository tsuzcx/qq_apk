package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.h;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import junit.framework.Assert;

public final class i
  extends j
{
  public i(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23160);
    h localh = new h();
    localh.qlf = new c();
    localh.nIq = new b(paramArrayOfByte);
    localh.nJA = paramInt;
    this.qgD = localh;
    this.nZd = paramLong;
    this.qgB = 30001;
    AppMethodBeat.o(23160);
  }
  
  public final byte[] cmg()
  {
    AppMethodBeat.i(23161);
    Assert.assertNotNull(this.qgD);
    try
    {
      byte[] arrayOfByte = this.qgD.toByteArray();
      AppMethodBeat.o(23161);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ae.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(23161);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.i
 * JD-Core Version:    0.7.0.1
 */