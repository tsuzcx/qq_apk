package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import junit.framework.Assert;

public final class i
  extends j
{
  public i(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23160);
    h localh = new h();
    localh.rCa = new c();
    localh.oTm = new b(paramArrayOfByte);
    localh.oUv = paramInt;
    this.rxz = localh;
    this.pkb = paramLong;
    this.rxx = 30001;
    AppMethodBeat.o(23160);
  }
  
  public final byte[] cKi()
  {
    AppMethodBeat.i(23161);
    Assert.assertNotNull(this.rxz);
    try
    {
      byte[] arrayOfByte = this.rxz.toByteArray();
      AppMethodBeat.o(23161);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(23161);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.i
 * JD-Core Version:    0.7.0.1
 */