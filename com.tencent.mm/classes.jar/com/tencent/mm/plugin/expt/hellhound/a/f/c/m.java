package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"})
public final class m
{
  public static final a woJ;
  
  static
  {
    AppMethodBeat.i(185607);
    woJ = new a((byte)0);
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
    efp localefp2 = a.dfA();
    efp localefp1 = localefp2;
    if (localefp2 == null) {
      localefp1 = new efp();
    }
    if (localefp1.Trf.size() > 100) {
      localefp1.Trf.removeFirst();
    }
    localefp1.Trf.addLast(paramString);
    if ((localefp1 == null) || (localefp1.Trf.isEmpty()))
    {
      AppMethodBeat.o(185608);
      return;
    }
    try
    {
      paramString = localefp1.toByteArray();
      if (paramString != null) {
        b.r("mmkv_sionId_table_hell", paramString);
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
  
  public static final String deL()
  {
    AppMethodBeat.i(256484);
    Object localObject = a.dfA();
    if (localObject == null)
    {
      AppMethodBeat.o(256484);
      return null;
    }
    if (((efp)localObject).Trf.isEmpty())
    {
      AppMethodBeat.o(256484);
      return null;
    }
    localObject = ((efp)localObject).Trf;
    p.j(localObject, "table.sessions");
    localObject = (String)((LinkedList)localObject).getLast();
    AppMethodBeat.o(256484);
    return localObject;
  }
  
  public static final efp dfz()
  {
    AppMethodBeat.i(185609);
    efp localefp = a.dfA();
    AppMethodBeat.o(185609);
    return localefp;
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(185610);
    b.r("mmkv_sionId_table_hell", new byte[0]);
    AppMethodBeat.o(185610);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", "table", "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static efp dfA()
    {
      AppMethodBeat.i(185606);
      byte[] arrayOfByte = b.awZ("mmkv_sionId_table_hell");
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
      efp localefp = new efp();
      try
      {
        localefp.parseFrom(arrayOfByte);
        AppMethodBeat.o(185606);
        return localefp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.m
 * JD-Core Version:    0.7.0.1
 */