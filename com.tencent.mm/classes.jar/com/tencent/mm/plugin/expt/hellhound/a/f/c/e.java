package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dcd;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
{
  public static dcd crL()
  {
    AppMethodBeat.i(122153);
    byte[] arrayOfByte = b.getBytes("mkv_k_hellsionpgcldc");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ae.e("HABBYGE-MALI.HellSessionPageCloudConfigDao", "HellSessionPageCloudConfigDao read(): NULL");
      AppMethodBeat.o(122153);
      return null;
    }
    dcd localdcd = new dcd();
    try
    {
      localdcd.parseFrom(arrayOfByte);
      AppMethodBeat.o(122153);
      return localdcd;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", localException, "HellSessionPageCloudConfigDao read", new Object[0]);
      AppMethodBeat.o(122153);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.e
 * JD-Core Version:    0.7.0.1
 */