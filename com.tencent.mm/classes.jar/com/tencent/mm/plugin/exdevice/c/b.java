package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class b
  extends d
{
  public b(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.i(23147);
    ad.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23147);
  }
  
  public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23148);
    ad.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + paramInt + "errMsg = " + paramString);
    com.tencent.mm.plugin.exdevice.f.b localb = new com.tencent.mm.plugin.exdevice.f.b();
    localb.qeC = aM(paramInt, paramString);
    localb.qej = com.tencent.mm.bx.b.cj(paramArrayOfByte);
    this.pZY = localb;
    this.pZW = 20001;
    AppMethodBeat.o(23148);
  }
  
  protected final com.tencent.mm.bx.a be(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23149);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
      AppMethodBeat.o(23149);
      return null;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = new com.tencent.mm.plugin.exdevice.f.a();
    try
    {
      locala.parseFrom(paramArrayOfByte);
      this.pZZ = locala;
      ad.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + locala.qec + " DeviceName = " + locala.nDs + " Language = " + locala.qei + " TimeZone = " + locala.qeh);
      AppMethodBeat.o(23149);
      return locala;
    }
    catch (IOException paramArrayOfByte)
    {
      ad.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      ad.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23149);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.b
 * JD-Core Version:    0.7.0.1
 */