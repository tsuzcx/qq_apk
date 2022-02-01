package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a pHC;
  
  static
  {
    AppMethodBeat.i(185603);
    pHC = new a((byte)0);
    AppMethodBeat.o(185603);
  }
  
  public static final void RR(String paramString)
  {
    AppMethodBeat.i(185605);
    if (paramString == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    bgb localbgb = a.cdu();
    if (localbgb == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    int i = localbgb.DDO.size() - 1;
    if (i >= 0)
    {
      bgc localbgc = (bgc)localbgb.DDO.get(i);
      if ((localbgc == null) || ((k.g(paramString, localbgc.dpw) ^ true))) {}
      for (;;)
      {
        i -= 1;
        break;
        localbgb.DDO.remove(i);
      }
    }
    if ((localbgb == null) || (localbgb.DDO.isEmpty()))
    {
      AppMethodBeat.o(185605);
      return;
    }
    try
    {
      paramString = localbgb.toByteArray();
      if (paramString != null) {
        b.o("mmkv_ssionPg_matched_bckup", paramString);
      }
      AppMethodBeat.o(185605);
      return;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("SessionPageBackup", (Throwable)paramString, "HABBYGE-MALI, SessionPageBackup, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185605);
    }
  }
  
  public static final List<bgc> WX(String paramString)
  {
    AppMethodBeat.i(185604);
    if (paramString == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    Object localObject = a.cdu();
    if (localObject == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((bgb)localObject).DDO.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bgc localbgc = (bgc)((Iterator)localObject).next();
      if ((localbgc != null) && (!(k.g(paramString, localbgc.dpw) ^ true))) {
        localArrayList.add(localbgc);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(185604);
    return paramString;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static bgb cdu()
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
      bgb localbgb = new bgb();
      try
      {
        localbgb.parseFrom(arrayOfByte);
        AppMethodBeat.o(185602);
        return localbgb;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("SessionPageBackup", (Throwable)localIOException, "HABBYGE-MALI, SessionPageBackup, _read: %s", new Object[] { localIOException.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.j
 * JD-Core Version:    0.7.0.1
 */