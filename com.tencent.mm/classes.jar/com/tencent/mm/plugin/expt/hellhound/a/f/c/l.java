package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.io.IOException;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a qqk;
  
  static
  {
    AppMethodBeat.i(185607);
    qqk = new a((byte)0);
    AppMethodBeat.o(185607);
  }
  
  public static final void Bk(String paramString)
  {
    AppMethodBeat.i(185608);
    if (paramString == null)
    {
      AppMethodBeat.o(185608);
      return;
    }
    cwc localcwc2 = a.clg();
    cwc localcwc1 = localcwc2;
    if (localcwc2 == null) {
      localcwc1 = new cwc();
    }
    if (localcwc1.EZo.size() > 100) {
      localcwc1.EZo.removeFirst();
    }
    localcwc1.EZo.addLast(paramString);
    if ((localcwc1 == null) || (localcwc1.EZo.isEmpty()))
    {
      AppMethodBeat.o(185608);
      return;
    }
    try
    {
      paramString = localcwc1.toByteArray();
      if (paramString != null) {
        b.o("mmkv_sionId_table_hell", paramString);
      }
      AppMethodBeat.o(185608);
      return;
    }
    catch (IOException paramString)
    {
      ac.printErrStackTrace("FuzzyMatchedBackup", (Throwable)paramString, "HABBYGE-MALI, SessionTable, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185608);
    }
  }
  
  public static final String ckr()
  {
    AppMethodBeat.i(195595);
    Object localObject = a.clg();
    if (localObject == null)
    {
      AppMethodBeat.o(195595);
      return null;
    }
    if (((cwc)localObject).EZo.isEmpty())
    {
      AppMethodBeat.o(195595);
      return null;
    }
    localObject = ((cwc)localObject).EZo;
    k.g(localObject, "table.sessions");
    localObject = (String)((LinkedList)localObject).getLast();
    AppMethodBeat.o(195595);
    return localObject;
  }
  
  public static final cwc clf()
  {
    AppMethodBeat.i(185609);
    cwc localcwc = a.clg();
    AppMethodBeat.o(185609);
    return localcwc;
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(185610);
    b.o("mmkv_sionId_table_hell", new byte[0]);
    AppMethodBeat.o(185610);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", "table", "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static cwc clg()
    {
      AppMethodBeat.i(185606);
      byte[] arrayOfByte = b.getBytes("mmkv_sionId_table_hell");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(185606);
        return null;
      }
      cwc localcwc = new cwc();
      try
      {
        localcwc.parseFrom(arrayOfByte);
        AppMethodBeat.o(185606);
        return localcwc;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("FuzzyMatchedBackup", (Throwable)localIOException, "HABBYGE-MALI, SessionTable, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185606);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.l
 * JD-Core Version:    0.7.0.1
 */