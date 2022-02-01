package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

final class p$4
  implements k.a<abb, String>
{
  p$4(p paramp) {}
  
  private static abb aS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211575);
    abb localabb = new abb();
    try
    {
      localabb.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(211575);
      return localabb;
    }
    catch (IOException paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
      AppMethodBeat.o(211575);
    }
    return null;
  }
  
  public final boolean cbm()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.4
 * JD-Core Version:    0.7.0.1
 */