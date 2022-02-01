package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "timestamp", "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"})
public final class e$a
{
  private static void a(atz paramatz)
  {
    AppMethodBeat.i(122584);
    if ((paramatz == null) || (paramatz.Gsa.isEmpty()))
    {
      AppMethodBeat.o(122584);
      return;
    }
    try
    {
      paramatz = paramatz.toByteArray();
      if (paramatz == null)
      {
        AppMethodBeat.o(122584);
        return;
      }
    }
    catch (IOException paramatz)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)paramatz, "FuzzyMatchReport, _write: %s", new Object[] { paramatz.getMessage() });
      AppMethodBeat.o(122584);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_mc_rpt", paramatz);
    AppMethodBeat.o(122584);
  }
  
  public static void a(auc paramauc, long paramLong)
  {
    AppMethodBeat.i(122586);
    if (paramauc == null)
    {
      AppMethodBeat.o(122586);
      return;
    }
    if (paramauc.Gsi.isEmpty())
    {
      AppMethodBeat.o(122586);
      return;
    }
    Object localObject = paramauc.Gsi;
    p.g(localObject, "fuzzyPath.pages");
    localObject = (aub)((LinkedList)localObject).getLast();
    paramLong -= ((aub)localObject).startTime;
    if (paramLong >= 0L) {}
    for (;;)
    {
      ((aub)localObject).Gsd = paramLong;
      if (paramauc.Gsi.size() != 1) {
        break;
      }
      AppMethodBeat.o(122586);
      return;
      paramLong = 0L;
    }
    int i = paramauc.Gsi.size() - 1;
    if (i > 0)
    {
      localObject = paramauc.Gsi.get(i - 1);
      p.g(localObject, "fuzzyPath.pages[i - 1]");
      localObject = (aub)localObject;
      if (((aub)localObject).Gsd <= 0L)
      {
        paramLong = ((aub)paramauc.Gsi.get(i)).startTime - ((aub)localObject).startTime;
        if (paramLong < 0L) {
          break label186;
        }
      }
      for (;;)
      {
        ((aub)localObject).Gsd = paramLong;
        i -= 1;
        break;
        label186:
        paramLong = 0L;
      }
    }
    AppMethodBeat.o(122586);
  }
  
  private static void ab(LinkedList<auc> paramLinkedList)
  {
    AppMethodBeat.i(169401);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
    if (b.a.cpN())
    {
      AppMethodBeat.o(169401);
      return;
    }
    atz localatz = cpu();
    localObject = localatz;
    if (localatz == null) {
      localObject = new atz();
    }
    ((atz)localObject).Gsa.addAll((Collection)paramLinkedList);
    a((atz)localObject);
    AppMethodBeat.o(169401);
  }
  
  static atz cpu()
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
    atz localatz = new atz();
    try
    {
      localatz.parseFrom(arrayOfByte);
      AppMethodBeat.o(122585);
      return localatz;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)localIOException, "FuzzyMatchReport, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122585);
    }
    return null;
  }
  
  public static void uV(long paramLong)
  {
    AppMethodBeat.i(184281);
    Object localObject1 = d.qYw;
    Object localObject2 = d.a.cpt();
    if (localObject2 == null)
    {
      AppMethodBeat.o(184281);
      return;
    }
    localObject1 = new LinkedList();
    int i = ((aua)localObject2).Gsb.size() - 1;
    while (i >= 0)
    {
      localObject3 = (dbg)((aua)localObject2).Gsb.get(i);
      int j = ((dbg)localObject3).Gsa.size() - 1;
      if (j >= 0)
      {
        Object localObject4 = ((dbg)localObject3).Gsa.get(j);
        p.g(localObject4, "sessionFuzzyPath.paths[j]");
        localObject4 = (auc)localObject4;
        if (((auc)localObject4).Gsj) {
          a((auc)localObject4, paramLong);
        }
        for (;;)
        {
          j -= 1;
          break;
          ((LinkedList)localObject1).addLast(localObject4);
          ((dbg)localObject3).Gsa.remove(j);
        }
      }
      if (((dbg)localObject3).Gsa.isEmpty()) {
        ((aua)localObject2).Gsb.remove(i);
      }
      i -= 1;
    }
    Object localObject3 = d.qYw;
    d.a.a((aua)localObject2);
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ab((LinkedList)localObject1);
        localObject2 = f.qYy;
        f.a.ac((LinkedList)localObject1);
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