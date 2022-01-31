package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class b
  extends d
{
  public b(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    y.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
  }
  
  protected final com.tencent.mm.bv.a ao(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
      return null;
    }
    com.tencent.mm.plugin.exdevice.e.a locala = new com.tencent.mm.plugin.exdevice.e.a();
    try
    {
      locala.aH(paramArrayOfByte);
      this.jsY = locala;
      y.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + locala.jxc + " DeviceName = " + locala.hQc + " Language = " + locala.jxi + " TimeZone = " + locala.jxh);
      return locala;
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", paramArrayOfByte, "", new Object[0]);
    }
    return null;
  }
  
  public final void d(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + paramInt + "errMsg = " + paramString);
    com.tencent.mm.plugin.exdevice.e.b localb = new com.tencent.mm.plugin.exdevice.e.b();
    localb.jxC = Z(paramInt, paramString);
    localb.jxj = com.tencent.mm.bv.b.bk(paramArrayOfByte);
    this.jsX = localb;
    this.jsV = 20001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.b
 * JD-Core Version:    0.7.0.1
 */