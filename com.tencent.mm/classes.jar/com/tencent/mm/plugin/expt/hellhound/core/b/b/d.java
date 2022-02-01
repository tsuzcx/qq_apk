package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class d
{
  public static void a(bfi parambfi)
  {
    AppMethodBeat.i(169278);
    if (parambfi == null)
    {
      AppMethodBeat.o(169278);
      return;
    }
    try
    {
      parambfi = parambfi.toByteArray();
      b.o("hell_mmkv_fbm__", parambfi);
      AppMethodBeat.o(169278);
      return;
    }
    catch (IOException parambfi)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", parambfi, "HellMsgQDao, _write, crash: %s", new Object[] { parambfi.getMessage() });
      AppMethodBeat.o(169278);
    }
  }
  
  public static String cOi()
  {
    AppMethodBeat.i(169276);
    Object localObject = cOj();
    if (localObject == null)
    {
      AppMethodBeat.o(169276);
      return null;
    }
    localObject = ((bfi)localObject).LOU;
    AppMethodBeat.o(169276);
    return localObject;
  }
  
  public static bfi cOj()
  {
    AppMethodBeat.i(169277);
    byte[] arrayOfByte = b.getBytes("hell_mmkv_fbm__");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(169277);
      return null;
    }
    bfi localbfi = new bfi();
    try
    {
      localbfi.parseFrom(arrayOfByte);
      AppMethodBeat.o(169277);
      return localbfi;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", localIOException, "FragmentFrontBack, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(169277);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d
 * JD-Core Version:    0.7.0.1
 */