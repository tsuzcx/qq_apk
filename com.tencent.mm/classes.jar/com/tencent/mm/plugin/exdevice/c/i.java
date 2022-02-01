package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import junit.framework.Assert;

public final class i
  extends j
{
  public i(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23160);
    h localh = new h();
    localh.oXK = new c();
    localh.mAx = new b(paramArrayOfByte);
    localh.mBH = paramInt;
    this.oTi = localh;
    this.mQq = paramLong;
    this.oTg = 30001;
    AppMethodBeat.o(23160);
  }
  
  public final byte[] bZd()
  {
    AppMethodBeat.i(23161);
    Assert.assertNotNull(this.oTi);
    try
    {
      byte[] arrayOfByte = this.oTi.toByteArray();
      AppMethodBeat.o(23161);
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ad.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(23161);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.i
 * JD-Core Version:    0.7.0.1
 */