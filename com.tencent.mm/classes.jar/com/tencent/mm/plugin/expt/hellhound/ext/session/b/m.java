package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.ezi;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final a zKO;
  
  static
  {
    AppMethodBeat.i(185607);
    zKO = new a((byte)0);
    AppMethodBeat.o(185607);
  }
  
  public static final void add(String paramString)
  {
    AppMethodBeat.i(185608);
    ezi localezi1;
    if (paramString != null)
    {
      ezi localezi2 = a.dMo();
      localezi1 = localezi2;
      if (localezi2 == null) {
        localezi1 = new ezi();
      }
      if (localezi1.aaFn.size() > 100) {
        localezi1.aaFn.removeFirst();
      }
      localezi1.aaFn.addLast(paramString);
      if ((localezi1 == null) || (localezi1.aaFn.isEmpty()))
      {
        AppMethodBeat.o(185608);
        return;
      }
    }
    try
    {
      paramString = localezi1.toByteArray();
      if (paramString != null) {
        b.u("mmkv_sionId_table_hell", paramString);
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
  
  public static final String dLA()
  {
    AppMethodBeat.i(300194);
    Object localObject = a.dMo();
    if (localObject == null)
    {
      AppMethodBeat.o(300194);
      return null;
    }
    if (((ezi)localObject).aaFn.isEmpty())
    {
      AppMethodBeat.o(300194);
      return null;
    }
    localObject = (String)((ezi)localObject).aaFn.getLast();
    AppMethodBeat.o(300194);
    return localObject;
  }
  
  public static final ezi dMn()
  {
    AppMethodBeat.i(185609);
    ezi localezi = a.dMo();
    AppMethodBeat.o(185609);
    return localezi;
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(185610);
    b.u("mmkv_sionId_table_hell", new byte[0]);
    AppMethodBeat.o(185610);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPath$Companion;", "", "()V", "KEY_MMKV", "", "MAX_ITMES", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/SessionTable;", "_write", "", "table", "add", "sessionId", "get", "getCurSessionId", "reset", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static ezi dMo()
    {
      AppMethodBeat.i(185606);
      byte[] arrayOfByte = b.ard("mmkv_sionId_table_hell");
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
      ezi localezi = new ezi();
      try
      {
        localezi.parseFrom(arrayOfByte);
        AppMethodBeat.o(185606);
        return localezi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.m
 * JD-Core Version:    0.7.0.1
 */