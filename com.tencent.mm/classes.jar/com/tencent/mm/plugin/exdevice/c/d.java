package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a pZZ = null;
  private short qaa = -1;
  private short qab = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ad.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.nTx = paramLong;
    this.qaa = ((short)paramInt2);
    this.qab = ((short)paramInt1);
    be(paramArrayOfByte);
  }
  
  protected abstract a be(byte[] paramArrayOfByte);
  
  public final short ckO()
  {
    return this.qaa;
  }
  
  public final short ckP()
  {
    return this.qab;
  }
  
  public final byte[] ckQ()
  {
    try
    {
      byte[] arrayOfByte = this.pZY.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      ad.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a ckR()
  {
    return this.pZZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.d
 * JD-Core Version:    0.7.0.1
 */