package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a qqj;
  
  static
  {
    AppMethodBeat.i(185603);
    qqj = new a((byte)0);
    AppMethodBeat.o(185603);
  }
  
  public static final void Wd(String paramString)
  {
    AppMethodBeat.i(185605);
    if (paramString == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    bjt localbjt = a.clc();
    if (localbjt == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    int i = localbjt.EZk.size() - 1;
    if (i >= 0)
    {
      bju localbju = (bju)localbjt.EZk.get(i);
      if ((localbju == null) || ((k.g(paramString, localbju.dnh) ^ true))) {}
      for (;;)
      {
        i -= 1;
        break;
        localbjt.EZk.remove(i);
      }
    }
    if ((localbjt == null) || (localbjt.EZk.isEmpty()))
    {
      AppMethodBeat.o(185605);
      return;
    }
    try
    {
      paramString = localbjt.toByteArray();
      if (paramString != null) {
        b.o("mmkv_ssionPg_matched_bckup", paramString);
      }
      AppMethodBeat.o(185605);
      return;
    }
    catch (IOException paramString)
    {
      ac.printErrStackTrace("SessionPageBackup", (Throwable)paramString, "HABBYGE-MALI, SessionPageBackup, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185605);
    }
  }
  
  public static final List<bju> abu(String paramString)
  {
    AppMethodBeat.i(185604);
    if (paramString == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    Object localObject = a.clc();
    if (localObject == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((bjt)localObject).EZk.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bju localbju = (bju)((Iterator)localObject).next();
      if ((localbju != null) && (!(k.g(paramString, localbju.dnh) ^ true))) {
        localArrayList.add(localbju);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(185604);
    return paramString;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static bjt clc()
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
      bjt localbjt = new bjt();
      try
      {
        localbjt.parseFrom(arrayOfByte);
        AppMethodBeat.o(185602);
        return localbjt;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("SessionPageBackup", (Throwable)localIOException, "HABBYGE-MALI, SessionPageBackup, _read: %s", new Object[] { localIOException.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.j
 * JD-Core Version:    0.7.0.1
 */