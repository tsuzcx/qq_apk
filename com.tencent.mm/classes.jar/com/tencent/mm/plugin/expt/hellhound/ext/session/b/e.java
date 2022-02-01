package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.ezc;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static void a(ezc paramezc)
  {
    AppMethodBeat.i(122152);
    try
    {
      b.u("mkv_k_hellsionpgcldc", paramezc.toByteArray());
      AppMethodBeat.o(122152);
      return;
    }
    catch (Exception paramezc)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", paramezc, "HellSessionPageCloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122152);
    }
  }
  
  public static ezc dMb()
  {
    AppMethodBeat.i(122153);
    byte[] arrayOfByte = b.ard("mkv_k_hellsionpgcldc");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("HABBYGE-MALI.HellSessionPageCloudConfigDao", "HellSessionPageCloudConfigDao read(): NULL");
      AppMethodBeat.o(122153);
      return null;
    }
    ezc localezc = new ezc();
    try
    {
      localezc.parseFrom(arrayOfByte);
      AppMethodBeat.o(122153);
      return localezc;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", localException, "HellSessionPageCloudConfigDao read", new Object[0]);
      AppMethodBeat.o(122153);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.e
 * JD-Core Version:    0.7.0.1
 */