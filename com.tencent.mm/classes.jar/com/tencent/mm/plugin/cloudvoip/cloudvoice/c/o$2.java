package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

final class o$2
  implements k.a<uy, String>
{
  o$2(o paramo) {}
  
  private static uy aB(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135511);
    uy localuy = new uy();
    try
    {
      localuy.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(135511);
      return localuy;
    }
    catch (IOException paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(135511);
    }
    return null;
  }
  
  public final boolean bhp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.2
 * JD-Core Version:    0.7.0.1
 */