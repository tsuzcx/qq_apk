package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class b
{
  public static void a(bzz parambzz)
  {
    AppMethodBeat.i(152375);
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.v("mkv_k_hellsscld", parambzz.toByteArray());
      AppMethodBeat.o(152375);
      return;
    }
    catch (Exception parambzz)
    {
      ab.printErrStackTrace("HellSessionCloudConfigDao", parambzz, "habbyge-mali, HellSessionCloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(152375);
    }
  }
  
  public static bzz bsn()
  {
    AppMethodBeat.i(152376);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mkv_k_hellsscld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ab.e("HellSessionCloudConfigDao", "habbyge-mali, HellSessionCloudConfigDao read(): NULL");
      AppMethodBeat.o(152376);
      return null;
    }
    bzz localbzz = new bzz();
    try
    {
      localbzz.parseFrom(arrayOfByte);
      AppMethodBeat.o(152376);
      return localbzz;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("HellSessionCloudConfigDao", localIOException, "habbyge-mali, SessionConfigCloud read", new Object[0]);
      AppMethodBeat.o(152376);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */