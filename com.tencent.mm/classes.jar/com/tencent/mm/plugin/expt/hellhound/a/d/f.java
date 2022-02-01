package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a qYy;
  
  static
  {
    AppMethodBeat.i(185597);
    qYy = new a((byte)0);
    AppMethodBeat.o(185597);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    public static void ZK(String paramString)
    {
      AppMethodBeat.i(185594);
      if (paramString == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      atz localatz = cpu();
      if (localatz == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      int i = localatz.Gsa.size() - 1;
      if (i >= 0)
      {
        auc localauc = (auc)localatz.Gsa.get(i);
        if ((localauc == null) || ((p.i(paramString, localauc.dyV) ^ true))) {}
        for (;;)
        {
          i -= 1;
          break;
          localatz.Gsa.remove(i);
        }
      }
      a(localatz);
      AppMethodBeat.o(185594);
    }
    
    private static void a(atz paramatz)
    {
      AppMethodBeat.i(185595);
      if ((paramatz == null) || (paramatz.Gsa.isEmpty()))
      {
        AppMethodBeat.o(185595);
        return;
      }
      try
      {
        paramatz = paramatz.toByteArray();
        if (paramatz == null)
        {
          AppMethodBeat.o(185595);
          return;
        }
      }
      catch (IOException paramatz)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)paramatz, "FuzzyMatchedBackup, _write: %s", new Object[] { paramatz.getMessage() });
        AppMethodBeat.o(185595);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_matched_bckup", paramatz);
      AppMethodBeat.o(185595);
    }
    
    public static void ac(LinkedList<auc> paramLinkedList)
    {
      AppMethodBeat.i(185591);
      p.h(paramLinkedList, "paths");
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
      if (b.a.cpN())
      {
        ad.w("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
        AppMethodBeat.o(185591);
        return;
      }
      ad.i("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report: " + paramLinkedList.size());
      atz localatz = cpu();
      localObject = localatz;
      if (localatz == null) {
        localObject = new atz();
      }
      ((atz)localObject).Gsa.addAll((Collection)paramLinkedList);
      a((atz)localObject);
      AppMethodBeat.o(185591);
    }
    
    public static dbg aeA(String paramString)
    {
      AppMethodBeat.i(185592);
      if (paramString == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      Object localObject = cpu();
      if (localObject == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      dbg localdbg = new dbg();
      localdbg.dyV = paramString;
      localObject = ((atz)localObject).Gsa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        auc localauc = (auc)((Iterator)localObject).next();
        if ((localauc != null) && (!(p.i(paramString, localauc.dyV) ^ true))) {
          localdbg.Gsa.add(localauc);
        }
      }
      AppMethodBeat.o(185592);
      return localdbg;
    }
    
    private static atz cpu()
    {
      AppMethodBeat.i(185596);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_fuzzy_matched_bckup");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(185596);
        return null;
      }
      atz localatz = new atz();
      try
      {
        localatz.parseFrom(arrayOfByte);
        AppMethodBeat.o(185596);
        return localatz;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)localIOException, "FuzzyMatchedBackup, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185596);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(185593);
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_matched_bckup", new byte[0]);
      AppMethodBeat.o(185593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.f
 * JD-Core Version:    0.7.0.1
 */