package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

final class p$5
  implements k.a<aat, String>
{
  p$5(p paramp) {}
  
  private static aat aT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211577);
    aat localaat = new aat();
    try
    {
      localaat.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(211577);
      return localaat;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(211577);
    }
    return null;
  }
  
  public final boolean cbm()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.5
 * JD-Core Version:    0.7.0.1
 */