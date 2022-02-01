package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class b
  extends d
{
  public b(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    super(paramLong, paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.i(23147);
    ac.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + paramLong + " seq = " + paramInt1 + " cmdId = " + paramInt2);
    AppMethodBeat.o(23147);
  }
  
  public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23148);
    ac.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + paramInt + "errMsg = " + paramString);
    com.tencent.mm.plugin.exdevice.f.b localb = new com.tencent.mm.plugin.exdevice.f.b();
    localb.pAX = aJ(paramInt, paramString);
    localb.pAE = com.tencent.mm.bw.b.cc(paramArrayOfByte);
    this.pwt = localb;
    this.pwr = 20001;
    AppMethodBeat.o(23148);
  }
  
  protected final com.tencent.mm.bw.a bb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23149);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ac.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
      AppMethodBeat.o(23149);
      return null;
    }
    com.tencent.mm.plugin.exdevice.f.a locala = new com.tencent.mm.plugin.exdevice.f.a();
    try
    {
      locala.parseFrom(paramArrayOfByte);
      this.pwu = locala;
      ac.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + locala.pAx + " DeviceName = " + locala.ncV + " Language = " + locala.pAD + " TimeZone = " + locala.pAC);
      AppMethodBeat.o(23149);
      return locala;
    }
    catch (IOException paramArrayOfByte)
    {
      ac.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", new Object[] { paramArrayOfByte.getMessage() });
      ac.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(23149);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.b
 * JD-Core Version:    0.7.0.1
 */