package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.io.IOException;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"})
public final class l
{
  public static final a pHD;
  
  static
  {
    AppMethodBeat.i(185607);
    pHD = new a((byte)0);
    AppMethodBeat.o(185607);
  }
  
  public static final String ccJ()
  {
    AppMethodBeat.i(190934);
    Object localObject = a.cdy();
    if (localObject == null)
    {
      AppMethodBeat.o(190934);
      return null;
    }
    if (((cqv)localObject).DDT.isEmpty())
    {
      AppMethodBeat.o(190934);
      return null;
    }
    localObject = ((cqv)localObject).DDT;
    k.g(localObject, "table.sessions");
    localObject = (String)((LinkedList)localObject).getLast();
    AppMethodBeat.o(190934);
    return localObject;
  }
  
  public static final cqv cdx()
  {
    AppMethodBeat.i(185609);
    cqv localcqv = a.cdy();
    AppMethodBeat.o(185609);
    return localcqv;
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(185610);
    b.o("mmkv_sionId_table_hell", new byte[0]);
    AppMethodBeat.o(185610);
  }
  
  public static final void xe(String paramString)
  {
    AppMethodBeat.i(185608);
    if (paramString == null)
    {
      AppMethodBeat.o(185608);
      return;
    }
    cqv localcqv2 = a.cdy();
    cqv localcqv1 = localcqv2;
    if (localcqv2 == null) {
      localcqv1 = new cqv();
    }
    if (localcqv1.DDT.size() > 100) {
      localcqv1.DDT.removeFirst();
    }
    localcqv1.DDT.addLast(paramString);
    if ((localcqv1 == null) || (localcqv1.DDT.isEmpty()))
    {
      AppMethodBeat.o(185608);
      return;
    }
    try
    {
      paramString = localcqv1.toByteArray();
      if (paramString != null) {
        b.o("mmkv_sionId_table_hell", paramString);
      }
      AppMethodBeat.o(185608);
      return;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("FuzzyMatchedBackup", (Throwable)paramString, "HABBYGE-MALI, SessionTable, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185608);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", "table", "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static cqv cdy()
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
      cqv localcqv = new cqv();
      try
      {
        localcqv.parseFrom(arrayOfByte);
        AppMethodBeat.o(185606);
        return localcqv;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("FuzzyMatchedBackup", (Throwable)localIOException, "HABBYGE-MALI, SessionTable, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185606);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.l
 * JD-Core Version:    0.7.0.1
 */