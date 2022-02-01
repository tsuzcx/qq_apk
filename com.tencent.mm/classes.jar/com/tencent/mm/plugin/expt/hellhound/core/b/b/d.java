package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class d
{
  public static void a(atj paramatj)
  {
    AppMethodBeat.i(169278);
    if (paramatj == null)
    {
      AppMethodBeat.o(169278);
      return;
    }
    try
    {
      paramatj = paramatj.toByteArray();
      b.p("hell_mmkv_fbm__", paramatj);
      AppMethodBeat.o(169278);
      return;
    }
    catch (IOException paramatj)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", paramatj, "HellMsgQDao, _write, crash: %s", new Object[] { paramatj.getMessage() });
      AppMethodBeat.o(169278);
    }
  }
  
  public static String con()
  {
    AppMethodBeat.i(169276);
    Object localObject = coo();
    if (localObject == null)
    {
      AppMethodBeat.o(169276);
      return null;
    }
    localObject = ((atj)localObject).Grt;
    AppMethodBeat.o(169276);
    return localObject;
  }
  
  public static atj coo()
  {
    AppMethodBeat.i(169277);
    byte[] arrayOfByte = b.getBytes("hell_mmkv_fbm__");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(169277);
      return null;
    }
    atj localatj = new atj();
    try
    {
      localatj.parseFrom(arrayOfByte);
      AppMethodBeat.o(169277);
      return localatj;
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
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.b.d
 * JD-Core Version:    0.7.0.1
 */