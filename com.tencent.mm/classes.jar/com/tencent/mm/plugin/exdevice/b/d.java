package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a lCx = null;
  private short lCy = -1;
  private short lCz = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ab.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.jRn = paramLong;
    this.lCy = ((short)paramInt2);
    this.lCz = ((short)paramInt1);
    aM(paramArrayOfByte);
  }
  
  protected abstract a aM(byte[] paramArrayOfByte);
  
  public final short bpu()
  {
    return this.lCy;
  }
  
  public final short bpv()
  {
    return this.lCz;
  }
  
  public final byte[] bpw()
  {
    try
    {
      byte[] arrayOfByte = this.lCw.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a bpx()
  {
    return this.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.d
 * JD-Core Version:    0.7.0.1
 */