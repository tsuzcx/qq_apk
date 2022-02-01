package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class c
{
  public static void a(amm paramamm)
  {
    AppMethodBeat.i(169278);
    if (paramamm == null)
    {
      AppMethodBeat.o(169278);
      return;
    }
    try
    {
      paramamm = paramamm.toByteArray();
      b.o("hell_mmkv_fbm__", paramamm);
      AppMethodBeat.o(169278);
      return;
    }
    catch (IOException paramamm)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", paramamm, "HellMsgQDao, _write, crash: %s", new Object[] { paramamm.getMessage() });
      AppMethodBeat.o(169278);
    }
  }
  
  public static String cbV()
  {
    AppMethodBeat.i(169276);
    Object localObject = cbW();
    if (localObject == null)
    {
      AppMethodBeat.o(169276);
      return null;
    }
    localObject = ((amm)localObject).DnC;
    AppMethodBeat.o(169276);
    return localObject;
  }
  
  public static amm cbW()
  {
    AppMethodBeat.i(169277);
    byte[] arrayOfByte = b.getBytes("hell_mmkv_fbm__");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(169277);
      return null;
    }
    amm localamm = new amm();
    try
    {
      localamm.parseFrom(arrayOfByte);
      AppMethodBeat.o(169277);
      return localamm;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", localIOException, "FragmentFrontBack, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(169277);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.c
 * JD-Core Version:    0.7.0.1
 */