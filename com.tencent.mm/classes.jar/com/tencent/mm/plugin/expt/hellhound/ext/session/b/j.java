package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final a zKM;
  
  static
  {
    AppMethodBeat.i(185603);
    zKM = new a((byte)0);
    AppMethodBeat.o(185603);
  }
  
  public static final void ama(String paramString)
  {
    AppMethodBeat.i(185605);
    czt localczt;
    int i;
    if (paramString != null)
    {
      localczt = a.dMi();
      if (localczt != null)
      {
        i = localczt.aaFj.size() - 1;
        if (i < 0) {}
      }
    }
    for (;;)
    {
      int j = i - 1;
      czu localczu = (czu)localczt.aaFj.get(i);
      if ((localczu == null) || (!s.p(paramString, localczu.hQR))) {}
      while (j < 0) {
        if ((localczt == null) || (localczt.aaFj.isEmpty()))
        {
          AppMethodBeat.o(185605);
          return;
          localczt.aaFj.remove(i);
        }
        else
        {
          try
          {
            paramString = localczt.toByteArray();
            if (paramString != null) {
              b.u("mmkv_ssionPg_matched_bckup", paramString);
            }
            AppMethodBeat.o(185605);
            return;
          }
          catch (IOException paramString)
          {
            Log.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", (Throwable)paramString, "SessionPageBackup, _write: %s", new Object[] { paramString.getMessage() });
            AppMethodBeat.o(185605);
            return;
          }
        }
      }
      i = j;
    }
  }
  
  public static final List<czu> asU(String paramString)
  {
    AppMethodBeat.i(185604);
    if (paramString == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    Object localObject = a.dMi();
    if (localObject == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((czt)localObject).aaFj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      czu localczu = (czu)((Iterator)localObject).next();
      if ((localczu != null) && (s.p(paramString, localczu.hQR))) {
        localArrayList.add(localczu);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(185604);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static czt dMi()
    {
      AppMethodBeat.i(185602);
      byte[] arrayOfByte = b.ard("mmkv_ssionPg_matched_bckup");
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
      czt localczt = new czt();
      try
      {
        localczt.parseFrom(arrayOfByte);
        AppMethodBeat.o(185602);
        return localczt;
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
      b.u("mmkv_ssionPg_matched_bckup", new byte[0]);
      AppMethodBeat.o(185601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.j
 * JD-Core Version:    0.7.0.1
 */