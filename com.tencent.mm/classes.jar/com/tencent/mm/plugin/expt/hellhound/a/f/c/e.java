package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static void a(dvh paramdvh)
  {
    AppMethodBeat.i(122152);
    try
    {
      b.o("mkv_k_hellsionpgcldc", paramdvh.toByteArray());
      AppMethodBeat.o(122152);
      return;
    }
    catch (Exception paramdvh)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", paramdvh, "HellSessionPageCloudConfigDao writeBack", new Object[0]);
      AppMethodBeat.o(122152);
    }
  }
  
  public static dvh cQt()
  {
    AppMethodBeat.i(122153);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsionpgcldc");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      Log.e("HABBYGE-MALI.HellSessionPageCloudConfigDao", "HellSessionPageCloudConfigDao read(): NULL");
      AppMethodBeat.o(122153);
      return null;
    }
    dvh localdvh = new dvh();
    try
    {
      localdvh.parseFrom(arrayOfByte);
      AppMethodBeat.o(122153);
      return localdvh;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", localException, "HellSessionPageCloudConfigDao read", new Object[0]);
      AppMethodBeat.o(122153);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.e
 * JD-Core Version:    0.7.0.1
 */