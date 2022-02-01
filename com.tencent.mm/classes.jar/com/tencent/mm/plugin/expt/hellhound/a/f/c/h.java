package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class h
{
  public static void a(cqw paramcqw)
  {
    AppMethodBeat.i(122167);
    try
    {
      b.o("mkv_k_hellsubascld", paramcqw.toByteArray());
      AppMethodBeat.o(122167);
      return;
    }
    catch (Exception paramcqw)
    {
      ad.printErrStackTrace("HellSessionUBACloudConfigDao", paramcqw, "habbyge-mali, HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122167);
    }
  }
  
  public static cqw cdt()
  {
    AppMethodBeat.i(122168);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("HellSessionUBACloudConfigDao", "habbyge-mali, HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(122168);
      return null;
    }
    cqw localcqw = new cqw();
    try
    {
      localcqw.parseFrom(arrayOfByte);
      AppMethodBeat.o(122168);
      return localcqw;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("HellSessionUBACloudConfigDao", localIOException, "habbyge-mali, SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(122168);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.h
 * JD-Core Version:    0.7.0.1
 */