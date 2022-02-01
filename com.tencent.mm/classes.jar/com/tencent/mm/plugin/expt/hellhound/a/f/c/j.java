package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a woH;
  
  static
  {
    AppMethodBeat.i(185603);
    woH = new a((byte)0);
    AppMethodBeat.o(185603);
  }
  
  public static final void asv(String paramString)
  {
    AppMethodBeat.i(185605);
    if (paramString == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    cjo localcjo = a.dfu();
    if (localcjo == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    int i = localcjo.Trb.size() - 1;
    if (i >= 0)
    {
      cjp localcjp = (cjp)localcjo.Trb.get(i);
      if ((localcjp == null) || ((p.h(paramString, localcjp.fLj) ^ true))) {}
      for (;;)
      {
        i -= 1;
        break;
        localcjo.Trb.remove(i);
      }
    }
    if ((localcjo == null) || (localcjo.Trb.isEmpty()))
    {
      AppMethodBeat.o(185605);
      return;
    }
    try
    {
      paramString = localcjo.toByteArray();
      if (paramString != null) {
        b.r("mmkv_ssionPg_matched_bckup", paramString);
      }
      AppMethodBeat.o(185605);
      return;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", (Throwable)paramString, "SessionPageBackup, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185605);
    }
  }
  
  public static final List<cjp> ayP(String paramString)
  {
    AppMethodBeat.i(185604);
    if (paramString == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    Object localObject = a.dfu();
    if (localObject == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((cjo)localObject).Trb.iterator();
    while (((Iterator)localObject).hasNext())
    {
      cjp localcjp = (cjp)((Iterator)localObject).next();
      if ((localcjp != null) && (!(p.h(paramString, localcjp.fLj) ^ true))) {
        localArrayList.add(localcjp);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(185604);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static cjo dfu()
    {
      AppMethodBeat.i(185602);
      byte[] arrayOfByte = b.awZ("mmkv_ssionPg_matched_bckup");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(185602);
        return null;
      }
      cjo localcjo = new cjo();
      try
      {
        localcjo.parseFrom(arrayOfByte);
        AppMethodBeat.o(185602);
        return localcjo;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", (Throwable)localIOException, "SessionPageBackup, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185602);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(185601);
      b.r("mmkv_ssionPg_matched_bckup", new byte[0]);
      AppMethodBeat.o(185601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.j
 * JD-Core Version:    0.7.0.1
 */