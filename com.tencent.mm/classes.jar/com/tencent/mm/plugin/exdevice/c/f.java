package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.exdevice.f.k;
import com.tencent.mm.plugin.exdevice.f.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class f
  extends d
{
  public f(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.i(23153);
    Log.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23153);
  }
  
  public final void b(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23154);
    Log.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + paramInt + paramString);
    l locall = new l();
    locall.vhK = aP(paramInt, paramString);
    paramString = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramString = new byte[0];
    }
    locall.rVk = new b(paramString);
    this.vdf = locall;
    this.vdd = 20002;
    AppMethodBeat.o(23154);
  }
  
  protected final a bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23155);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
      AppMethodBeat.o(23155);
      return null;
    }
    k localk = new k();
    try
    {
      localk.parseFrom(paramArrayOfByte);
      this.vdg = localk;
      Log.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
      AppMethodBeat.o(23155);
      return localk;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23155);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.f
 * JD-Core Version:    0.7.0.1
 */