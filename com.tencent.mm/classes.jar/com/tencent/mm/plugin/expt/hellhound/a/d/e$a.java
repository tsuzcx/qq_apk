package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "timestamp", "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"})
public final class e$a
{
  private static void a(aqd paramaqd)
  {
    AppMethodBeat.i(122584);
    if ((paramaqd == null) || (paramaqd.EIZ.isEmpty()))
    {
      AppMethodBeat.o(122584);
      return;
    }
    try
    {
      paramaqd = paramaqd.toByteArray();
      if (paramaqd == null)
      {
        AppMethodBeat.o(122584);
        return;
      }
    }
    catch (IOException paramaqd)
    {
      ac.printErrStackTrace("FuzzyMatchReport", (Throwable)paramaqd, "HABBYGE-MALI, FuzzyMatchReport, _write: %s", new Object[] { paramaqd.getMessage() });
      AppMethodBeat.o(122584);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", paramaqd);
    AppMethodBeat.o(122584);
  }
  
  public static void a(aqg paramaqg, long paramLong)
  {
    AppMethodBeat.i(122586);
    if (paramaqg == null)
    {
      AppMethodBeat.o(122586);
      return;
    }
    ac.i("FuzzyMatchReport", "HABBYGE-MALI, _updateInOfPageFake: " + paramaqg.EJg.size());
    if (paramaqg.EJg.isEmpty())
    {
      AppMethodBeat.o(122586);
      return;
    }
    Object localObject = paramaqg.EJg;
    k.g(localObject, "fuzzyPath.pages");
    localObject = (aqf)((LinkedList)localObject).getLast();
    paramLong -= ((aqf)localObject).startTime;
    if (paramLong >= 0L) {}
    for (;;)
    {
      ((aqf)localObject).EJc = paramLong;
      ac.i("FuzzyMatchReport", "HABBYGE-MALI, _updateInOfPageFake, lastPage: " + ((aqf)localObject).name + ", " + ((aqf)localObject).EJc);
      if (paramaqg.EJg.size() != 1) {
        break;
      }
      AppMethodBeat.o(122586);
      return;
      paramLong = 0L;
    }
    int i = paramaqg.EJg.size() - 1;
    if (i > 0)
    {
      localObject = paramaqg.EJg.get(i - 1);
      k.g(localObject, "fuzzyPath.pages[i - 1]");
      localObject = (aqf)localObject;
      if (((aqf)localObject).EJc <= 0L)
      {
        paramLong = ((aqf)paramaqg.EJg.get(i)).startTime - ((aqf)localObject).startTime;
        if (paramLong < 0L) {
          break label251;
        }
      }
      for (;;)
      {
        ((aqf)localObject).EJc = paramLong;
        i -= 1;
        break;
        label251:
        paramLong = 0L;
      }
    }
    AppMethodBeat.o(122586);
  }
  
  private static void aa(LinkedList<aqg> paramLinkedList)
  {
    AppMethodBeat.i(169401);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
    if (b.a.ckx())
    {
      ac.w("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, report, doNotNeedSessionMonitor FALSE");
      AppMethodBeat.o(169401);
      return;
    }
    ac.i("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, report: " + paramLinkedList.size());
    aqd localaqd = ckf();
    localObject = localaqd;
    if (localaqd == null) {
      localObject = new aqd();
    }
    ((aqd)localObject).EIZ.addAll((Collection)paramLinkedList);
    a((aqd)localObject);
    AppMethodBeat.o(169401);
  }
  
  static aqd ckf()
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
    aqd localaqd = new aqd();
    try
    {
      localaqd.parseFrom(arrayOfByte);
      AppMethodBeat.o(122585);
      return localaqd;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("FuzzyMatchReport", (Throwable)localIOException, "HABBYGE-MALI, FuzzyMatchReport, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122585);
    }
    return null;
  }
  
  public static void sY(long paramLong)
  {
    AppMethodBeat.i(184281);
    Object localObject1 = d.qpx;
    Object localObject2 = d.a.cke();
    if (localObject2 == null)
    {
      AppMethodBeat.o(184281);
      return;
    }
    ac.w("FuzzyMatchReport", "HABBYGE-MALI, move2ReportCache, fuzzyDao: " + ((aqe)localObject2).EJa.size());
    localObject1 = new LinkedList();
    int i = ((aqe)localObject2).EJa.size() - 1;
    while (i >= 0)
    {
      localObject3 = (cvu)((aqe)localObject2).EJa.get(i);
      int j = ((cvu)localObject3).EIZ.size() - 1;
      if (j >= 0)
      {
        Object localObject4 = ((cvu)localObject3).EIZ.get(j);
        k.g(localObject4, "sessionFuzzyPath.paths[j]");
        localObject4 = (aqg)localObject4;
        if (((aqg)localObject4).EJh) {
          a((aqg)localObject4, paramLong);
        }
        for (;;)
        {
          j -= 1;
          break;
          ((LinkedList)localObject1).addLast(localObject4);
          ((cvu)localObject3).EIZ.remove(j);
        }
      }
      if (((cvu)localObject3).EIZ.isEmpty())
      {
        ac.i("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, paths.isEmpty: " + ((cvu)localObject3).dnh);
        ((aqe)localObject2).EJa.remove(i);
      }
      i -= 1;
    }
    Object localObject3 = d.qpx;
    d.a.a((aqe)localObject2);
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac.i("FuzzyMatchReport", "HABBYGE-MALI, FuzzyMatchReport, needReportPaths: " + ((LinkedList)localObject1).size());
        aa((LinkedList)localObject1);
        localObject2 = f.qpz;
        f.a.ab((LinkedList)localObject1);
      }
      AppMethodBeat.o(184281);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.e.a
 * JD-Core Version:    0.7.0.1
 */