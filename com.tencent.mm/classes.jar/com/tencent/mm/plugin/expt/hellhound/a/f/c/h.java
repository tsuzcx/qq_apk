package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class h
{
  public static void a(cwd paramcwd)
  {
    AppMethodBeat.i(122167);
    try
    {
      b.o("mkv_k_hellsubascld", paramcwd.toByteArray());
      AppMethodBeat.o(122167);
      return;
    }
    catch (Exception paramcwd)
    {
      ac.printErrStackTrace("HellSessionUBACloudConfigDao", paramcwd, "habbyge-mali, HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122167);
    }
  }
  
  public static cwd clb()
  {
    AppMethodBeat.i(122168);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ac.e("HellSessionUBACloudConfigDao", "habbyge-mali, HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(122168);
      return null;
    }
    cwd localcwd = new cwd();
    try
    {
      localcwd.parseFrom(arrayOfByte);
      AppMethodBeat.o(122168);
      return localcwd;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("HellSessionUBACloudConfigDao", localIOException, "habbyge-mali, SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(122168);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.h
 * JD-Core Version:    0.7.0.1
 */