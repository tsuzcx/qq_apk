package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class d
{
  public static void a(bmm parambmm)
  {
    AppMethodBeat.i(169278);
    if (parambmm == null)
    {
      AppMethodBeat.o(169278);
      return;
    }
    try
    {
      parambmm = parambmm.toByteArray();
      b.r("hell_mmkv_fbm__", parambmm);
      AppMethodBeat.o(169278);
      return;
    }
    catch (IOException parambmm)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", parambmm, "HellMsgQDao, _write, crash: %s", new Object[] { parambmm.getMessage() });
      AppMethodBeat.o(169278);
    }
  }
  
  public static String dda()
  {
    AppMethodBeat.i(169276);
    Object localObject = ddb();
    if (localObject == null)
    {
      AppMethodBeat.o(169276);
      return null;
    }
    localObject = ((bmm)localObject).SXp;
    AppMethodBeat.o(169276);
    return localObject;
  }
  
  public static bmm ddb()
  {
    AppMethodBeat.i(169277);
    byte[] arrayOfByte = b.awZ("hell_mmkv_fbm__");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(169277);
      return null;
    }
    bmm localbmm = new bmm();
    try
    {
      localbmm.parseFrom(arrayOfByte);
      AppMethodBeat.o(169277);
      return localbmm;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", localIOException, "FragmentFrontBack, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(169277);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d
 * JD-Core Version:    0.7.0.1
 */