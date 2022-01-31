package com.tencent.mm.plugin.exdevice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class b
  extends d
{
  public b(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.i(19039);
    ab.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(19039);
  }
  
  protected final com.tencent.mm.bv.a aM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19041);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ab.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
      AppMethodBeat.o(19041);
      return null;
    }
    com.tencent.mm.plugin.exdevice.e.a locala = new com.tencent.mm.plugin.exdevice.e.a();
    try
    {
      locala.parseFrom(paramArrayOfByte);
      this.lCx = locala;
      ab.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + locala.lGB + " DeviceName = " + locala.jJE + " Language = " + locala.lGH + " TimeZone = " + locala.lGG);
      AppMethodBeat.o(19041);
      return locala;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(19041);
    }
    return null;
  }
  
  public final void e(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19040);
    ab.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + paramInt + "errMsg = " + paramString);
    com.tencent.mm.plugin.exdevice.e.b localb = new com.tencent.mm.plugin.exdevice.e.b();
    localb.lHb = as(paramInt, paramString);
    localb.lGI = com.tencent.mm.bv.b.bL(paramArrayOfByte);
    this.lCw = localb;
    this.lCu = 20001;
    AppMethodBeat.o(19040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.b
 * JD-Core Version:    0.7.0.1
 */