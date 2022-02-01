package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public abstract class d
  extends c
{
  protected a vdg = null;
  private short vdh = -1;
  private short vdi = -1;
  
  public d(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Log.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    this.smk = paramLong;
    this.vdh = ((short)paramInt2);
    this.vdi = ((short)paramInt1);
    bI(paramArrayOfByte);
  }
  
  protected abstract a bI(byte[] paramArrayOfByte);
  
  public final short cYQ()
  {
    return this.vdh;
  }
  
  public final short cYR()
  {
    return this.vdi;
  }
  
  public final byte[] cYS()
  {
    try
    {
      byte[] arrayOfByte = this.vdf.toByteArray();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", new Object[] { localIOException.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", localIOException, "", new Object[0]);
    }
    return null;
  }
  
  public final a cYT()
  {
    return this.vdg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.d
 * JD-Core Version:    0.7.0.1
 */