package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class h
{
  public static void a(dvo paramdvo)
  {
    AppMethodBeat.i(122167);
    try
    {
      b.o("mkv_k_hellsubascld", paramdvo.toByteArray());
      AppMethodBeat.o(122167);
      return;
    }
    catch (Exception paramdvo)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", paramdvo, "HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122167);
    }
  }
  
  public static dvo cQz()
  {
    AppMethodBeat.i(122168);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("HABBYGE-MALI.HellSessionUBACloudConfigDao", "HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(122168);
      return null;
    }
    dvo localdvo = new dvo();
    try
    {
      localdvo.parseFrom(arrayOfByte);
      AppMethodBeat.o(122168);
      return localdvo;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", localIOException, "SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(122168);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.h
 * JD-Core Version:    0.7.0.1
 */