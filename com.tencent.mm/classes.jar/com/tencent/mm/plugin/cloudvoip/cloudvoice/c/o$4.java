package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

final class o$4
  implements k.a<String, uv>
{
  o$4(o paramo) {}
  
  private static byte[] a(uv paramuv)
  {
    AppMethodBeat.i(135517);
    if (paramuv != null) {
      try
      {
        paramuv = paramuv.toByteArray();
        AppMethodBeat.o(135517);
        return paramuv;
      }
      catch (IOException paramuv)
      {
        ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramuv, "hy: error when convert to byte array", new Object[0]);
      }
    }
    AppMethodBeat.o(135517);
    return new byte[0];
  }
  
  public final boolean bhp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o.4
 * JD-Core Version:    0.7.0.1
 */