package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class j
{
  public static final a qZi;
  
  static
  {
    AppMethodBeat.i(185603);
    qZi = new a((byte)0);
    AppMethodBeat.o(185603);
  }
  
  public static final void ZK(String paramString)
  {
    AppMethodBeat.i(185605);
    if (paramString == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    bob localbob = a.cqq();
    if (localbob == null)
    {
      AppMethodBeat.o(185605);
      return;
    }
    int i = localbob.GII.size() - 1;
    if (i >= 0)
    {
      boc localboc = (boc)localbob.GII.get(i);
      if ((localboc == null) || ((p.i(paramString, localboc.dyV) ^ true))) {}
      for (;;)
      {
        i -= 1;
        break;
        localbob.GII.remove(i);
      }
    }
    if ((localbob == null) || (localbob.GII.isEmpty()))
    {
      AppMethodBeat.o(185605);
      return;
    }
    try
    {
      paramString = localbob.toByteArray();
      if (paramString != null) {
        b.p("mmkv_ssionPg_matched_bckup", paramString);
      }
      AppMethodBeat.o(185605);
      return;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", (Throwable)paramString, "SessionPageBackup, _write: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(185605);
    }
  }
  
  public static final List<boc> afh(String paramString)
  {
    AppMethodBeat.i(185604);
    if (paramString == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    Object localObject = a.cqq();
    if (localObject == null)
    {
      AppMethodBeat.o(185604);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((bob)localObject).GII.iterator();
    while (((Iterator)localObject).hasNext())
    {
      boc localboc = (boc)((Iterator)localObject).next();
      if ((localboc != null) && (!(p.i(paramString, localboc.dyV) ^ true))) {
        localArrayList.add(localboc);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(185604);
    return paramString;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionPageBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/HellPageFlow;", "_write", "", "path", "backup", "pageItems", "", "Lcom/tencent/mm/protocal/protobuf/HellPageFlowItem;", "getBackup", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    static bob cqq()
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
      bob localbob = new bob();
      try
      {
        localbob.parseFrom(arrayOfByte);
        AppMethodBeat.o(185602);
        return localbob;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.SessionPageBackup", (Throwable)localIOException, "SessionPageBackup, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185602);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(185601);
      b.p("mmkv_ssionPg_matched_bckup", new byte[0]);
      AppMethodBeat.o(185601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.c.j
 * JD-Core Version:    0.7.0.1
 */