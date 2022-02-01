package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bx.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a yoT = null;
  private short yoU = -1;
  private short yoV = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Log.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.vyj = paramLong;
    this.yoU = ((short)paramInt2);
    this.yoV = ((short)paramInt1);
    bI(paramArrayOfByte);
  }
  
  protected abstract a bI(byte[] paramArrayOfByte);
  
  public final short dFh()
  {
    return this.yoU;
  }
  
  public final short dFi()
  {
    return this.yoV;
  }
  
  public final byte[] dFj()
  {
    try
    {
      byte[] arrayOfByte = this.yoS.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a dFk()
  {
    return this.yoT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.d
 * JD-Core Version:    0.7.0.1
 */