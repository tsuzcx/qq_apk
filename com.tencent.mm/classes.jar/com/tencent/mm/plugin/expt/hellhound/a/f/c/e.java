package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static void a(efj paramefj)
  {
    AppMethodBeat.i(122152);
    try
    {
      b.r("mkv_k_hellsionpgcldc", paramefj.toByteArray());
      AppMethodBeat.o(122152);
      return;
    }
    catch (Exception paramefj)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", paramefj, "HellSessionPageCloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122152);
    }
  }
  
  public static efj dfn()
  {
    AppMethodBeat.i(122153);
    byte[] arrayOfByte = b.awZ("mkv_k_hellsionpgcldc");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("HABBYGE-MALI.HellSessionPageCloudConfigDao", "HellSessionPageCloudConfigDao read(): NULL");
      AppMethodBeat.o(122153);
      return null;
    }
    efj localefj = new efj();
    try
    {
      localefj.parseFrom(arrayOfByte);
      AppMethodBeat.o(122153);
      return localefj;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", localException, "HellSessionPageCloudConfigDao read", new Object[0]);
      AppMethodBeat.o(122153);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.e
 * JD-Core Version:    0.7.0.1
 */