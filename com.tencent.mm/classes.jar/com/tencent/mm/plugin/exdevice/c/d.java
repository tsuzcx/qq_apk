package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a rxA = null;
  private short rxB = -1;
  private short rxC = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Log.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.pkb = paramLong;
    this.rxB = ((short)paramInt2);
    this.rxC = ((short)paramInt1);
    bu(paramArrayOfByte);
  }
  
  protected abstract a bu(byte[] paramArrayOfByte);
  
  public final short cKg()
  {
    return this.rxB;
  }
  
  public final short cKh()
  {
    return this.rxC;
  }
  
  public final byte[] cKi()
  {
    try
    {
      byte[] arrayOfByte = this.rxz.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a cKj()
  {
    return this.rxA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.d
 * JD-Core Version:    0.7.0.1
 */