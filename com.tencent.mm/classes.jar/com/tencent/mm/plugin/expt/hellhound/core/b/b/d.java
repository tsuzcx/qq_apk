package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class d
{
  public static void a(caf paramcaf)
  {
    AppMethodBeat.i(169278);
    if (paramcaf == null)
    {
      AppMethodBeat.o(169278);
      return;
    }
    try
    {
      paramcaf = paramcaf.toByteArray();
      b.u("hell_mmkv_fbm__", paramcaf);
      AppMethodBeat.o(169278);
      return;
    }
    catch (IOException paramcaf)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", paramcaf, "HellMsgQDao, _write, crash: %s", new Object[] { paramcaf.getMessage() });
      AppMethodBeat.o(169278);
    }
  }
  
  public static String dJH()
  {
    AppMethodBeat.i(169276);
    Object localObject = dJI();
    if (localObject == null)
    {
      AppMethodBeat.o(169276);
      return null;
    }
    localObject = ((caf)localObject).aajh;
    AppMethodBeat.o(169276);
    return localObject;
  }
  
  public static caf dJI()
  {
    AppMethodBeat.i(169277);
    byte[] arrayOfByte = b.ard("hell_mmkv_fbm__");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(169277);
      return null;
    }
    caf localcaf = new caf();
    try
    {
      localcaf.parseFrom(arrayOfByte);
      AppMethodBeat.o(169277);
      return localcaf;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", localIOException, "FragmentFrontBack, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(169277);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d
 * JD-Core Version:    0.7.0.1
 */