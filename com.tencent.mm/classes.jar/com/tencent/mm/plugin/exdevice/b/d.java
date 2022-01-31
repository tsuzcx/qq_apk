package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a jsY = null;
  private short jsZ = -1;
  private short jta = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.hXu = paramLong;
    this.jsZ = ((short)paramInt2);
    this.jta = ((short)paramInt1);
    ao(paramArrayOfByte);
  }
  
  public final short aLh()
  {
    return this.jsZ;
  }
  
  public final short aLi()
  {
    return this.jta;
  }
  
  public final byte[] aLj()
  {
    try
    {
      byte[] arrayOfByte = this.jsX.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a aLk()
  {
    return this.jsY;
  }
  
  protected abstract a ao(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.d
 * JD-Core Version:    0.7.0.1
 */