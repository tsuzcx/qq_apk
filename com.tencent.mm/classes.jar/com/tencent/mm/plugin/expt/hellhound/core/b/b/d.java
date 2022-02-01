package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public final class d
{
  public static void a(atz paramatz)
  {
    AppMethodBeat.i(169278);
    if (paramatz == null)
    {
      AppMethodBeat.o(169278);
      return;
    }
    try
    {
      paramatz = paramatz.toByteArray();
      b.p("hell_mmkv_fbm__", paramatz);
      AppMethodBeat.o(169278);
      return;
    }
    catch (IOException paramatz)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", paramatz, "HellMsgQDao, _write, crash: %s", new Object[] { paramatz.getMessage() });
      AppMethodBeat.o(169278);
    }
  }
  
  public static String cpP()
  {
    AppMethodBeat.i(169276);
    Object localObject = cpQ();
    if (localObject == null)
    {
      AppMethodBeat.o(169276);
      return null;
    }
    localObject = ((atz)localObject).GKR;
    AppMethodBeat.o(169276);
    return localObject;
  }
  
  public static atz cpQ()
  {
    AppMethodBeat.i(169277);
    byte[] arrayOfByte = b.getBytes("hell_mmkv_fbm__");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(169277);
      return null;
    }
    atz localatz = new atz();
    try
    {
      localatz.parseFrom(arrayOfByte);
      AppMethodBeat.o(169277);
      return localatz;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", localIOException, "FragmentFrontBack, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(169277);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d
 * JD-Core Version:    0.7.0.1
 */