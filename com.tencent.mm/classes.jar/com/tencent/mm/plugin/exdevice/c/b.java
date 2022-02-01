package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class b
  extends d
{
  public b(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.i(23147);
    Log.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23147);
  }
  
  public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23148);
    Log.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + paramInt + "errMsg = " + paramString);
    com.tencent.mm.plugin.exdevice.f.b localb = new com.tencent.mm.plugin.exdevice.f.b();
    localb.ytL = bh(paramInt, paramString);
    localb.ytt = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.yoS = localb;
    this.yoQ = 20001;
    AppMethodBeat.o(23148);
  }
  
  protected final com.tencent.mm.bx.a bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23149);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
      AppMethodBeat.o(23149);
      return null;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = new com.tencent.mm.plugin.exdevice.f.a();
    try
    {
      locala.parseFrom(paramArrayOfByte);
      this.yoT = locala;
      Log.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + locala.ytm + " DeviceName = " + locala.vgW + " Language = " + locala.yts + " TimeZone = " + locala.ytr);
      AppMethodBeat.o(23149);
      return locala;
    }
    catch (IOException paramArrayOfByte)
    {
      Log.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23149);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.b
 * JD-Core Version:    0.7.0.1
 */