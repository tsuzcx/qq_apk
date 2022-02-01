package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.efq;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class h
{
  public static void a(efq paramefq)
  {
    AppMethodBeat.i(122167);
    try
    {
      b.r("mkv_k_hellsubascld", paramefq.toByteArray());
      AppMethodBeat.o(122167);
      return;
    }
    catch (Exception paramefq)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", paramefq, "HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122167);
    }
  }
  
  public static efq dft()
  {
    AppMethodBeat.i(122168);
    byte[] arrayOfByte = b.awZ("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("HABBYGE-MALI.HellSessionUBACloudConfigDao", "HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(122168);
      return null;
    }
    efq localefq = new efq();
    try
    {
      localefq.parseFrom(arrayOfByte);
      AppMethodBeat.o(122168);
      return localefq;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", localIOException, "SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(122168);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.h
 * JD-Core Version:    0.7.0.1
 */