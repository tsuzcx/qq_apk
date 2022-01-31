package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.exdevice.e.k;
import com.tencent.mm.plugin.exdevice.e.l;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class f
  extends d
{
  public f(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    y.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
  }
  
  protected final a ao(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
      return null;
    }
    k localk = new k();
    try
    {
      localk.aH(paramArrayOfByte);
      this.jsY = localk;
      y.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
      return localk;
    }
    catch (IOException paramArrayOfByte)
    {
      y.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      y.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", paramArrayOfByte, "", new Object[0]);
    }
    return null;
  }
  
  public final void e(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + paramInt + paramString);
    l locall = new l();
    locall.jxC = Z(paramInt, paramString);
    paramString = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramString = new byte[0];
    }
    locall.hPF = new b(paramString);
    this.jsX = locall;
    this.jsV = 20002;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.f
 * JD-Core Version:    0.7.0.1
 */