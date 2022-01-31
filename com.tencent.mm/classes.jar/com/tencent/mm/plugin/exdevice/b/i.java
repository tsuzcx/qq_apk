package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.exdevice.e.c;
import com.tencent.mm.plugin.exdevice.e.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import junit.framework.Assert;

public final class i
  extends j
{
  public i(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    h localh = new h();
    localh.jxA = new c();
    localh.hPF = new b(paramArrayOfByte);
    localh.hQR = paramInt;
    this.jsX = localh;
    this.hXu = paramLong;
    this.jsV = 30001;
  }
  
  public final byte[] aLj()
  {
    Assert.assertNotNull(this.jsX);
    try
    {
      byte[] arrayOfByte = this.jsX.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.i
 * JD-Core Version:    0.7.0.1
 */