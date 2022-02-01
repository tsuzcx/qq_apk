package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a pwu = null;
  private short pwv = -1;
  private short pww = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ac.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.nsB = paramLong;
    this.pwv = ((short)paramInt2);
    this.pww = ((short)paramInt1);
    bb(paramArrayOfByte);
  }
  
  protected abstract a bb(byte[] paramArrayOfByte);
  
  public final short cgk()
  {
    return this.pwv;
  }
  
  public final short cgl()
  {
    return this.pww;
  }
  
  public final byte[] cgm()
  {
    try
    {
      byte[] arrayOfByte = this.pwt.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ac.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      ac.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a cgn()
  {
    return this.pwu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.d
 * JD-Core Version:    0.7.0.1
 */