package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a sIK;
  
  static
  {
    AppMethodBeat.i(185603);
    sIK = new a((byte)0);
    AppMethodBeat.o(185603);
  }
  
  public static final void akH(String paramString)
  {
    AppMethodBeat.i(185605);
    if (paramString == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    cbl localcbl = a.cQA();
    if (localcbl == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    int i = localcbl.Mhn.size() - 1;
    if (i >= 0)
    {
      cbm localcbm = (cbm)localcbl.Mhn.get(i);
      if ((localcbm == null) || ((p.j(paramString, localcbm.dRM) ^ true))) {}
      for (;;)
      {
        i -= 1;
        break;
        localcbl.Mhn.remove(i);
      }
    }
    if ((localcbl == null) || (localcbl.Mhn.isEmpty()))
    {
      AppMethodBeat.o(185605);
      return;
    }
    try
    {
      paramString = localcbl.toByteArray();
      if (paramString != null) {
        b.o("mmkv_ssionPg_matched_bckup", paramString);
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
  
  public static final List<cbm> aqO(String paramString)
  {
    AppMethodBeat.i(185604);
    if (paramString == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    Object localObject = a.cQA();
    if (localObject == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((cbl)localObject).Mhn.iterator();
    while (((Iterator)localObject).hasNext())
    {
      cbm localcbm = (cbm)((Iterator)localObject).next();
      if ((localcbm != null) && (!(p.j(paramString, localcbm.dRM) ^ true))) {
        localArrayList.add(localcbm);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(185604);
    return paramString;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static cbl cQA()
    {
      AppMethodBeat.i(185602);
      byte[] arrayOfByte = b.getBytes("mmkv_ssionPg_matched_bckup");
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
      cbl localcbl = new cbl();
      try
      {
        localcbl.parseFrom(arrayOfByte);
        AppMethodBeat.o(185602);
        return localcbl;
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
      b.o("mmkv_ssionPg_matched_bckup", new byte[0]);
      AppMethodBeat.o(185601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.j
 * JD-Core Version:    0.7.0.1
 */