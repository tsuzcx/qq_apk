package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"})
public final class m
{
  public static final a qZk;
  
  static
  {
    AppMethodBeat.i(185607);
    qZk = new a((byte)0);
    AppMethodBeat.o(185607);
  }
  
  public static final void Ej(String paramString)
  {
    AppMethodBeat.i(185608);
    if (paramString == null)
    {
      AppMethodBeat.o(185608);
      return;
    }
    dbp localdbp2 = a.cqw();
    dbp localdbp1 = localdbp2;
    if (localdbp2 == null) {
      localdbp1 = new dbp();
    }
    if (localdbp1.GIM.size() > 100) {
      localdbp1.GIM.removeFirst();
    }
    localdbp1.GIM.addLast(paramString);
    if ((localdbp1 == null) || (localdbp1.GIM.isEmpty()))
    {
      AppMethodBeat.o(185608);
      return;
    }
    try
    {
      paramString = localdbp1.toByteArray();
      if (paramString != null) {
        b.p("mmkv_sionId_table_hell", paramString);
      }
      AppMethodBeat.o(185608);
      return;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)paramString, "SessionTable, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185608);
    }
  }
  
  public static final String cpH()
  {
    AppMethodBeat.i(210968);
    Object localObject = a.cqw();
    if (localObject == null)
    {
      AppMethodBeat.o(210968);
      return null;
    }
    if (((dbp)localObject).GIM.isEmpty())
    {
      AppMethodBeat.o(210968);
      return null;
    }
    localObject = ((dbp)localObject).GIM;
    p.g(localObject, "table.sessions");
    localObject = (String)((LinkedList)localObject).getLast();
    AppMethodBeat.o(210968);
    return localObject;
  }
  
  public static final dbp cqv()
  {
    AppMethodBeat.i(185609);
    dbp localdbp = a.cqw();
    AppMethodBeat.o(185609);
    return localdbp;
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(185610);
    b.p("mmkv_sionId_table_hell", new byte[0]);
    AppMethodBeat.o(185610);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", "table", "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static dbp cqw()
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
      dbp localdbp = new dbp();
      try
      {
        localdbp.parseFrom(arrayOfByte);
        AppMethodBeat.o(185606);
        return localdbp;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)localIOException, "SessionTable, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185606);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.m
 * JD-Core Version:    0.7.0.1
 */