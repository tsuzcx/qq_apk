package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a qgE = null;
  private short qgF = -1;
  private short qgG = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ae.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.nZd = paramLong;
    this.qgF = ((short)paramInt2);
    this.qgG = ((short)paramInt1);
    bd(paramArrayOfByte);
  }
  
  protected abstract a bd(byte[] paramArrayOfByte);
  
  public final short cme()
  {
    return this.qgF;
  }
  
  public final short cmf()
  {
    return this.qgG;
  }
  
  public final byte[] cmg()
  {
    try
    {
      byte[] arrayOfByte = this.qgD.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ae.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      ae.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a cmh()
  {
    return this.qgE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.d
 * JD-Core Version:    0.7.0.1
 */