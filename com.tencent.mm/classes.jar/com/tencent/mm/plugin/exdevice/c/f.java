package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.exdevice.f.k;
import com.tencent.mm.plugin.exdevice.f.l;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class f
  extends d
{
  public f(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.i(23153);
    ad.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23153);
  }
  
  public final void b(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23154);
    ad.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + paramInt + paramString);
    l locall = new l();
    locall.oXM = aH(paramInt, paramString);
    paramString = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramString = new byte[0];
    }
    locall.mAx = new b(paramString);
    this.oTi = locall;
    this.oTg = 20002;
    AppMethodBeat.o(23154);
  }
  
  protected final a bc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23155);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
      AppMethodBeat.o(23155);
      return null;
    }
    k localk = new k();
    try
    {
      localk.parseFrom(paramArrayOfByte);
      this.oTj = localk;
      ad.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
      AppMethodBeat.o(23155);
      return localk;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      ad.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23155);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.f
 * JD-Core Version:    0.7.0.1
 */