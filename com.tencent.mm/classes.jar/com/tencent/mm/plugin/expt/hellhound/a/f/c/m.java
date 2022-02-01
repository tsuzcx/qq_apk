package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"})
public final class m
{
  public static final a sIM;
  
  static
  {
    AppMethodBeat.i(185607);
    sIM = new a((byte)0);
    AppMethodBeat.o(185607);
  }
  
  public static final void add(String paramString)
  {
    AppMethodBeat.i(185608);
    if (paramString == null)
    {
      AppMethodBeat.o(185608);
      return;
    }
    dvn localdvn2 = a.cQG();
    dvn localdvn1 = localdvn2;
    if (localdvn2 == null) {
      localdvn1 = new dvn();
    }
    if (localdvn1.Mhr.size() > 100) {
      localdvn1.Mhr.removeFirst();
    }
    localdvn1.Mhr.addLast(paramString);
    if ((localdvn1 == null) || (localdvn1.Mhr.isEmpty()))
    {
      AppMethodBeat.o(185608);
      return;
    }
    try
    {
      paramString = localdvn1.toByteArray();
      if (paramString != null) {
        b.o("mmkv_sionId_table_hell", paramString);
      }
      AppMethodBeat.o(185608);
      return;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)paramString, "SessionTable, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185608);
    }
  }
  
  public static final String cPR()
  {
    AppMethodBeat.i(221131);
    Object localObject = a.cQG();
    if (localObject == null)
    {
      AppMethodBeat.o(221131);
      return null;
    }
    if (((dvn)localObject).Mhr.isEmpty())
    {
      AppMethodBeat.o(221131);
      return null;
    }
    localObject = ((dvn)localObject).Mhr;
    p.g(localObject, "table.sessions");
    localObject = (String)((LinkedList)localObject).getLast();
    AppMethodBeat.o(221131);
    return localObject;
  }
  
  public static final dvn cQF()
  {
    AppMethodBeat.i(185609);
    dvn localdvn = a.cQG();
    AppMethodBeat.o(185609);
    return localdvn;
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(185610);
    b.o("mmkv_sionId_table_hell", new byte[0]);
    AppMethodBeat.o(185610);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", "table", "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static dvn cQG()
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
      dvn localdvn = new dvn();
      try
      {
        localdvn.parseFrom(arrayOfByte);
        AppMethodBeat.o(185606);
        return localdvn;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)localIOException, "SessionTable, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185606);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.m
 * JD-Core Version:    0.7.0.1
 */