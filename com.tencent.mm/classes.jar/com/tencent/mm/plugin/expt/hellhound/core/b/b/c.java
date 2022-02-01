package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class c
{
  public static void a(app paramapp)
  {
    AppMethodBeat.i(169278);
    if (paramapp == null)
    {
      AppMethodBeat.o(169278);
      return;
    }
    try
    {
      paramapp = paramapp.toByteArray();
      b.o("hell_mmkv_fbm__", paramapp);
      AppMethodBeat.o(169278);
      return;
    }
    catch (IOException paramapp)
    {
      ac.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", paramapp, "HellMsgQDao, _write, crash: %s", new Object[] { paramapp.getMessage() });
      AppMethodBeat.o(169278);
    }
  }
  
  public static String cjg()
  {
    AppMethodBeat.i(169276);
    Object localObject = cjh();
    if (localObject == null)
    {
      AppMethodBeat.o(169276);
      return null;
    }
    localObject = ((app)localObject).EIC;
    AppMethodBeat.o(169276);
    return localObject;
  }
  
  public static app cjh()
  {
    AppMethodBeat.i(169277);
    byte[] arrayOfByte = b.getBytes("hell_mmkv_fbm__");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(169277);
      return null;
    }
    app localapp = new app();
    try
    {
      localapp.parseFrom(arrayOfByte);
      AppMethodBeat.o(169277);
      return localapp;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", localIOException, "FragmentFrontBack, _read, crash: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(169277);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.c
 * JD-Core Version:    0.7.0.1
 */