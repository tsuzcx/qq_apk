package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.ezj;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class h
{
  public static void a(ezj paramezj)
  {
    AppMethodBeat.i(122167);
    try
    {
      b.u("mkv_k_hellsubascld", paramezj.toByteArray());
      AppMethodBeat.o(122167);
      return;
    }
    catch (Exception paramezj)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", paramezj, "HellSessionUBACloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122167);
    }
  }
  
  public static ezj dMh()
  {
    AppMethodBeat.i(122168);
    byte[] arrayOfByte = b.ard("mkv_k_hellsubascld");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("HABBYGE-MALI.HellSessionUBACloudConfigDao", "HellSessionUBACloudConfigDao read(): NULL");
      AppMethodBeat.o(122168);
      return null;
    }
    ezj localezj = new ezj();
    try
    {
      localezj.parseFrom(arrayOfByte);
      AppMethodBeat.o(122168);
      return localezj;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", localIOException, "SessionUBACloudConfig read", new Object[0]);
      AppMethodBeat.o(122168);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.h
 * JD-Core Version:    0.7.0.1
 */