package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a pGS;
  
  static
  {
    AppMethodBeat.i(185597);
    pGS = new a((byte)0);
    AppMethodBeat.o(185597);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    public static void RR(String paramString)
    {
      AppMethodBeat.i(185594);
      if (paramString == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      amz localamz = ccw();
      if (localamz == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      int i = localamz.DnZ.size() - 1;
      if (i >= 0)
      {
        anc localanc = (anc)localamz.DnZ.get(i);
        if ((localanc == null) || ((k.g(paramString, localanc.dpw) ^ true))) {}
        for (;;)
        {
          i -= 1;
          break;
          localamz.DnZ.remove(i);
        }
      }
      a(localamz);
      AppMethodBeat.o(185594);
    }
    
    public static cqn Wp(String paramString)
    {
      AppMethodBeat.i(185592);
      if (paramString == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      Object localObject = ccw();
      if (localObject == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      cqn localcqn = new cqn();
      localcqn.dpw = paramString;
      localObject = ((amz)localObject).DnZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        anc localanc = (anc)((Iterator)localObject).next();
        if ((localanc != null) && (!(k.g(paramString, localanc.dpw) ^ true))) {
          localcqn.DnZ.add(localanc);
        }
      }
      AppMethodBeat.o(185592);
      return localcqn;
    }
    
    private static void a(amz paramamz)
    {
      AppMethodBeat.i(185595);
      if ((paramamz == null) || (paramamz.DnZ.isEmpty()))
      {
        AppMethodBeat.o(185595);
        return;
      }
      try
      {
        paramamz = paramamz.toByteArray();
        if (paramamz == null)
        {
          AppMethodBeat.o(185595);
          return;
        }
      }
      catch (IOException paramamz)
      {
        ad.printErrStackTrace("FuzzyMatchedBackup", (Throwable)paramamz, "HABBYGE-MALI, FuzzyMatchedBackup, _write: %s", new Object[] { paramamz.getMessage() });
        AppMethodBeat.o(185595);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_matched_bckup", paramamz);
      AppMethodBeat.o(185595);
    }
    
    public static void aa(LinkedList<anc> paramLinkedList)
    {
      AppMethodBeat.i(185591);
      k.h(paramLinkedList, "paths");
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
      if (b.a.ccP())
      {
        ad.w("FuzzyMatchedBackup", "HABBYGE-MALI, FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
        AppMethodBeat.o(185591);
        return;
      }
      ad.i("FuzzyMatchedBackup", "HABBYGE-MALI, FuzzyMatchedBackup, report: " + paramLinkedList.size());
      amz localamz = ccw();
      localObject = localamz;
      if (localamz == null) {
        localObject = new amz();
      }
      ((amz)localObject).DnZ.addAll((Collection)paramLinkedList);
      a((amz)localObject);
      AppMethodBeat.o(185591);
    }
    
    private static amz ccw()
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
      amz localamz = new amz();
      try
      {
        localamz.parseFrom(arrayOfByte);
        AppMethodBeat.o(185596);
        return localamz;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("FuzzyMatchedBackup", (Throwable)localIOException, "HABBYGE-MALI, FuzzyMatchedBackup, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185596);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(185593);
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_matched_bckup", new byte[0]);
      AppMethodBeat.o(185593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.f
 * JD-Core Version:    0.7.0.1
 */