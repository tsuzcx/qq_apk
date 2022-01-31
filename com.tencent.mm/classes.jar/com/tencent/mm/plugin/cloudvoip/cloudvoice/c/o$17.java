package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

final class o$17
  implements k.a<uu, String>
{
  o$17(o paramo, b paramb) {}
  
  private static uu aC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135542);
    uu localuu = new uu();
    try
    {
      localuu.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(135542);
      return localuu;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(135542);
    }
    return null;
  }
  
  public final boolean bhp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.17
 * JD-Core Version:    0.7.0.1
 */