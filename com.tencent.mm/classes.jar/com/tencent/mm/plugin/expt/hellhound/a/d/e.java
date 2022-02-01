package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class e
{
  public static final a pGR;
  
  static
  {
    AppMethodBeat.i(122587);
    pGR = new a((byte)0);
    AppMethodBeat.o(122587);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "timestamp", "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"})
  public static final class a
  {
    private static void Z(LinkedList<anc> paramLinkedList)
    {
      AppMethodBeat.i(169401);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
      if (b.a.ccP())
      {
        ad.w("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, report, doNotNeedSessionMonitor FALSE");
        AppMethodBeat.o(169401);
        return;
      }
      ad.i("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, report: " + paramLinkedList.size());
      amz localamz = ccw();
      localObject = localamz;
      if (localamz == null) {
        localObject = new amz();
      }
      ((amz)localObject).DnZ.addAll((Collection)paramLinkedList);
      a((amz)localObject);
      AppMethodBeat.o(169401);
    }
    
    private static void a(amz paramamz)
    {
      AppMethodBeat.i(122584);
      if ((paramamz == null) || (paramamz.DnZ.isEmpty()))
      {
        AppMethodBeat.o(122584);
        return;
      }
      try
      {
        paramamz = paramamz.toByteArray();
        if (paramamz == null)
        {
          AppMethodBeat.o(122584);
          return;
        }
      }
      catch (IOException paramamz)
      {
        ad.printErrStackTrace("FuzzyMatchReport", (Throwable)paramamz, "HABBYGE-MALI, FuzzyMatchReport, _write: %s", new Object[] { paramamz.getMessage() });
        AppMethodBeat.o(122584);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", paramamz);
      AppMethodBeat.o(122584);
    }
    
    public static void a(anc paramanc, long paramLong)
    {
      AppMethodBeat.i(122586);
      if (paramanc == null)
      {
        AppMethodBeat.o(122586);
        return;
      }
      ad.i("FuzzyMatchReport", "HABBYGE-MALI, _updateInOfPageFake: " + paramanc.Dog.size());
      if (paramanc.Dog.isEmpty())
      {
        AppMethodBeat.o(122586);
        return;
      }
      Object localObject = paramanc.Dog;
      k.g(localObject, "fuzzyPath.pages");
      localObject = (anb)((LinkedList)localObject).getLast();
      paramLong -= ((anb)localObject).startTime;
      if (paramLong >= 0L) {}
      for (;;)
      {
        ((anb)localObject).Doc = paramLong;
        ad.i("FuzzyMatchReport", "HABBYGE-MALI, _updateInOfPageFake, lastPage: " + ((anb)localObject).name + ", " + ((anb)localObject).Doc);
        if (paramanc.Dog.size() != 1) {
          break;
        }
        AppMethodBeat.o(122586);
        return;
        paramLong = 0L;
      }
      int i = paramanc.Dog.size() - 1;
      if (i > 0)
      {
        localObject = paramanc.Dog.get(i - 1);
        k.g(localObject, "fuzzyPath.pages[i - 1]");
        localObject = (anb)localObject;
        if (((anb)localObject).Doc <= 0L)
        {
          paramLong = ((anb)paramanc.Dog.get(i)).startTime - ((anb)localObject).startTime;
          if (paramLong < 0L) {
            break label251;
          }
        }
        for (;;)
        {
          ((anb)localObject).Doc = paramLong;
          i -= 1;
          break;
          label251:
          paramLong = 0L;
        }
      }
      AppMethodBeat.o(122586);
    }
    
    static amz ccw()
    {
      AppMethodBeat.i(122585);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_fuzzy_mc_rpt");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(122585);
        return null;
      }
      amz localamz = new amz();
      try
      {
        localamz.parseFrom(arrayOfByte);
        AppMethodBeat.o(122585);
        return localamz;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("FuzzyMatchReport", (Throwable)localIOException, "HABBYGE-MALI, FuzzyMatchReport, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(122585);
      }
      return null;
    }
    
    public static void pj(long paramLong)
    {
      AppMethodBeat.i(184281);
      Object localObject1 = d.pGQ;
      Object localObject2 = d.a.ccv();
      if (localObject2 == null)
      {
        AppMethodBeat.o(184281);
        return;
      }
      ad.w("FuzzyMatchReport", "HABBYGE-MALI, move2ReportCache, fuzzyDao: " + ((ana)localObject2).Doa.size());
      localObject1 = new LinkedList();
      int i = ((ana)localObject2).Doa.size() - 1;
      while (i >= 0)
      {
        localObject3 = (cqn)((ana)localObject2).Doa.get(i);
        int j = ((cqn)localObject3).DnZ.size() - 1;
        if (j >= 0)
        {
          Object localObject4 = ((cqn)localObject3).DnZ.get(j);
          k.g(localObject4, "sessionFuzzyPath.paths[j]");
          localObject4 = (anc)localObject4;
          if (((anc)localObject4).Doh) {
            a((anc)localObject4, paramLong);
          }
          for (;;)
          {
            j -= 1;
            break;
            ((LinkedList)localObject1).addLast(localObject4);
            ((cqn)localObject3).DnZ.remove(j);
          }
        }
        if (((cqn)localObject3).DnZ.isEmpty())
        {
          ad.i("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, paths.isEmpty: " + ((cqn)localObject3).dpw);
          ((ana)localObject2).Doa.remove(i);
        }
        i -= 1;
      }
      Object localObject3 = d.pGQ;
      d.a.a((ana)localObject2);
      if (!((Collection)localObject1).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          ad.i("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, needReportPaths: " + ((LinkedList)localObject1).size());
          Z((LinkedList)localObject1);
          localObject2 = f.pGS;
          f.a.aa((LinkedList)localObject1);
        }
        AppMethodBeat.o(184281);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.e
 * JD-Core Version:    0.7.0.1
 */