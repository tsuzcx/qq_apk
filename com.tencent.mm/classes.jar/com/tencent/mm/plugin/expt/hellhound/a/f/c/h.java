package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public final class h
{
  public static void a(dck paramdck)
  {
    AppMethodBeat.i(122167);
    try
    {
      b.p("mkv_k_hellsubascld", paramdck.toByteArray());
      AppMethodBeat.o(122167);
      return;
    }
    catch (Exception paramdck)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", paramdck, "HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122167);
    }
  }
  
  public static dck crR()
  {
    AppMethodBeat.i(122168);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ae.e("HABBYGE-MALI.HellSessionUBACloudConfigDao", "HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(122168);
      return null;
    }
    dck localdck = new dck();
    try
    {
      localdck.parseFrom(arrayOfByte);
      AppMethodBeat.o(122168);
      return localdck;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", localIOException, "SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(122168);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.h
 * JD-Core Version:    0.7.0.1
 */