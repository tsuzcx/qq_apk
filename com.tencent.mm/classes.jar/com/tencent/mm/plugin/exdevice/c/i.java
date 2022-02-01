package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import junit.framework.Assert;

public final class i
  extends j
{
  public i(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23160);
    h localh = new h();
    localh.pAV = new c();
    localh.ncy = new b(paramArrayOfByte);
    localh.ndI = paramInt;
    this.pwt = localh;
    this.nsB = paramLong;
    this.pwr = 30001;
    AppMethodBeat.o(23160);
  }
  
  public final byte[] cgm()
  {
    AppMethodBeat.i(23161);
    Assert.assertNotNull(this.pwt);
    try
    {
      byte[] arrayOfByte = this.pwt.toByteArray();
      AppMethodBeat.o(23161);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ac.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(23161);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.i
 * JD-Core Version:    0.7.0.1
 */