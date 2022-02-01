package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a oTj = null;
  private short oTk = -1;
  private short oTl = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ad.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.mQq = paramLong;
    this.oTk = ((short)paramInt2);
    this.oTl = ((short)paramInt1);
    bc(paramArrayOfByte);
  }
  
  public final short bZb()
  {
    return this.oTk;
  }
  
  public final short bZc()
  {
    return this.oTl;
  }
  
  public final byte[] bZd()
  {
    try
    {
      byte[] arrayOfByte = this.oTi.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      ad.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a bZe()
  {
    return this.oTj;
  }
  
  protected abstract a bc(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.d
 * JD-Core Version:    0.7.0.1
 */