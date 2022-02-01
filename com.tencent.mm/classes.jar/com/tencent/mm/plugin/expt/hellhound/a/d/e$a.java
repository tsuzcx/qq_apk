package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "timestamp", "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"})
public final class e$a
{
  private static void a(aup paramaup)
  {
    AppMethodBeat.i(122584);
    if ((paramaup == null) || (paramaup.GLy.isEmpty()))
    {
      AppMethodBeat.o(122584);
      return;
    }
    try
    {
      paramaup = paramaup.toByteArray();
      if (paramaup == null)
      {
        AppMethodBeat.o(122584);
        return;
      }
    }
    catch (IOException paramaup)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)paramaup, "FuzzyMatchReport, _write: %s", new Object[] { paramaup.getMessage() });
      AppMethodBeat.o(122584);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_mc_rpt", paramaup);
    AppMethodBeat.o(122584);
  }
  
  public static void a(aus paramaus, long paramLong)
  {
    AppMethodBeat.i(122586);
    if (paramaus == null)
    {
      AppMethodBeat.o(122586);
      return;
    }
    if (paramaus.GLG.isEmpty())
    {
      AppMethodBeat.o(122586);
      return;
    }
    Object localObject = paramaus.GLG;
    p.g(localObject, "fuzzyPath.pages");
    localObject = (aur)((LinkedList)localObject).getLast();
    paramLong -= ((aur)localObject).startTime;
    if (paramLong >= 0L) {}
    for (;;)
    {
      ((aur)localObject).GLB = paramLong;
      if (paramaus.GLG.size() != 1) {
        break;
      }
      AppMethodBeat.o(122586);
      return;
      paramLong = 0L;
    }
    int i = paramaus.GLG.size() - 1;
    if (i > 0)
    {
      localObject = paramaus.GLG.get(i - 1);
      p.g(localObject, "fuzzyPath.pages[i - 1]");
      localObject = (aur)localObject;
      if (((aur)localObject).GLB <= 0L)
      {
        paramLong = ((aur)paramaus.GLG.get(i)).startTime - ((aur)localObject).startTime;
        if (paramLong < 0L) {
          break label186;
        }
      }
      for (;;)
      {
        ((aur)localObject).GLB = paramLong;
        i -= 1;
        break;
        label186:
        paramLong = 0L;
      }
    }
    AppMethodBeat.o(122586);
  }
  
  private static void ab(LinkedList<aus> paramLinkedList)
  {
    AppMethodBeat.i(169401);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
    if (b.a.crp())
    {
      AppMethodBeat.o(169401);
      return;
    }
    aup localaup = cqW();
    localObject = localaup;
    if (localaup == null) {
      localObject = new aup();
    }
    ((aup)localObject).GLy.addAll((Collection)paramLinkedList);
    a((aup)localObject);
    AppMethodBeat.o(169401);
  }
  
  static aup cqW()
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
    aup localaup = new aup();
    try
    {
      localaup.parseFrom(arrayOfByte);
      AppMethodBeat.o(122585);
      return localaup;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)localIOException, "FuzzyMatchReport, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122585);
    }
    return null;
  }
  
  public static void vm(long paramLong)
  {
    AppMethodBeat.i(184281);
    Object localObject1 = d.rgC;
    Object localObject2 = d.a.cqV();
    if (localObject2 == null)
    {
      AppMethodBeat.o(184281);
      return;
    }
    localObject1 = new LinkedList();
    int i = ((auq)localObject2).GLz.size() - 1;
    while (i >= 0)
    {
      localObject3 = (dca)((auq)localObject2).GLz.get(i);
      int j = ((dca)localObject3).GLy.size() - 1;
      if (j >= 0)
      {
        Object localObject4 = ((dca)localObject3).GLy.get(j);
        p.g(localObject4, "sessionFuzzyPath.paths[j]");
        localObject4 = (aus)localObject4;
        if (((aus)localObject4).GLH) {
          a((aus)localObject4, paramLong);
        }
        for (;;)
        {
          j -= 1;
          break;
          ((LinkedList)localObject1).addLast(localObject4);
          ((dca)localObject3).GLy.remove(j);
        }
      }
      if (((dca)localObject3).GLy.isEmpty()) {
        ((auq)localObject2).GLz.remove(i);
      }
      i -= 1;
    }
    Object localObject3 = d.rgC;
    d.a.a((auq)localObject2);
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ab((LinkedList)localObject1);
        localObject2 = f.rgE;
        f.a.ac((LinkedList)localObject1);
      }
      AppMethodBeat.o(184281);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.e.a
 * JD-Core Version:    0.7.0.1
 */