package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class h
{
  public static void a(dbq paramdbq)
  {
    AppMethodBeat.i(122167);
    try
    {
      b.p("mkv_k_hellsubascld", paramdbq.toByteArray());
      AppMethodBeat.o(122167);
      return;
    }
    catch (Exception paramdbq)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", paramdbq, "HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122167);
    }
  }
  
  public static dbq cqp()
  {
    AppMethodBeat.i(122168);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("HABBYGE-MALI.HellSessionUBACloudConfigDao", "HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(122168);
      return null;
    }
    dbq localdbq = new dbq();
    try
    {
      localdbq.parseFrom(arrayOfByte);
      AppMethodBeat.o(122168);
      return localdbq;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", localIOException, "SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(122168);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.h
 * JD-Core Version:    0.7.0.1
 */