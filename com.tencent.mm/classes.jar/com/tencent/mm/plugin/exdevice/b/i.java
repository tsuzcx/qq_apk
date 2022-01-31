package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import junit.framework.Assert;

public final class i
  extends j
{
  public i(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(19052);
    h localh = new h();
    localh.lGZ = new c();
    localh.jJh = new b(paramArrayOfByte);
    localh.jKs = paramInt;
    this.lCw = localh;
    this.jRn = paramLong;
    this.lCu = 30001;
    AppMethodBeat.o(19052);
  }
  
  public final byte[] bpw()
  {
    AppMethodBeat.i(19053);
    Assert.assertNotNull(this.lCw);
    try
    {
      byte[] arrayOfByte = this.lCw.toByteArray();
      AppMethodBeat.o(19053);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(19053);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.i
 * JD-Core Version:    0.7.0.1
 */