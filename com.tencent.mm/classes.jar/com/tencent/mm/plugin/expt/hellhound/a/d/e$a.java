package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "timestamp", "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"})
public final class e$a
{
  public static void Dq(long paramLong)
  {
    AppMethodBeat.i(184281);
    Object localObject1 = d.sHY;
    Object localObject2 = d.a.cPD();
    if (localObject2 == null)
    {
      AppMethodBeat.o(184281);
      return;
    }
    localObject1 = new LinkedList();
    int i = ((bfz)localObject2).LPD.size() - 1;
    while (i >= 0)
    {
      localObject3 = (dve)((bfz)localObject2).LPD.get(i);
      int j = ((dve)localObject3).LPC.size() - 1;
      if (j >= 0)
      {
        Object localObject4 = ((dve)localObject3).LPC.get(j);
        p.g(localObject4, "sessionFuzzyPath.paths[j]");
        localObject4 = (bgb)localObject4;
        if (((bgb)localObject4).LPL) {
          a((bgb)localObject4, paramLong);
        }
        for (;;)
        {
          j -= 1;
          break;
          ((LinkedList)localObject1).addLast(localObject4);
          ((dve)localObject3).LPC.remove(j);
        }
      }
      if (((dve)localObject3).LPC.isEmpty()) {
        ((bfz)localObject2).LPD.remove(i);
      }
      i -= 1;
    }
    Object localObject3 = d.sHY;
    d.a.a((bfz)localObject2);
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ac((LinkedList)localObject1);
        localObject2 = f.sIa;
        f.a.ad((LinkedList)localObject1);
      }
      AppMethodBeat.o(184281);
      return;
    }
  }
  
  private static void a(bfy parambfy)
  {
    AppMethodBeat.i(122584);
    if ((parambfy == null) || (parambfy.LPC.isEmpty()))
    {
      AppMethodBeat.o(122584);
      return;
    }
    try
    {
      parambfy = parambfy.toByteArray();
      if (parambfy == null)
      {
        AppMethodBeat.o(122584);
        return;
      }
    }
    catch (IOException parambfy)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)parambfy, "FuzzyMatchReport, _write: %s", new Object[] { parambfy.getMessage() });
      AppMethodBeat.o(122584);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", parambfy);
    AppMethodBeat.o(122584);
  }
  
  public static void a(bgb parambgb, long paramLong)
  {
    AppMethodBeat.i(122586);
    if (parambgb == null)
    {
      AppMethodBeat.o(122586);
      return;
    }
    if (parambgb.LPK.isEmpty())
    {
      AppMethodBeat.o(122586);
      return;
    }
    Object localObject = parambgb.LPK;
    p.g(localObject, "fuzzyPath.pages");
    localObject = (bga)((LinkedList)localObject).getLast();
    paramLong -= ((bga)localObject).startTime;
    if (paramLong >= 0L) {}
    for (;;)
    {
      ((bga)localObject).LPF = paramLong;
      if (parambgb.LPK.size() != 1) {
        break;
      }
      AppMethodBeat.o(122586);
      return;
      paramLong = 0L;
    }
    int i = parambgb.LPK.size() - 1;
    if (i > 0)
    {
      localObject = parambgb.LPK.get(i - 1);
      p.g(localObject, "fuzzyPath.pages[i - 1]");
      localObject = (bga)localObject;
      if (((bga)localObject).LPF <= 0L)
      {
        paramLong = ((bga)parambgb.LPK.get(i)).startTime - ((bga)localObject).startTime;
        if (paramLong < 0L) {
          break label186;
        }
      }
      for (;;)
      {
        ((bga)localObject).LPF = paramLong;
        i -= 1;
        break;
        label186:
        paramLong = 0L;
      }
    }
    AppMethodBeat.o(122586);
  }
  
  private static void ac(LinkedList<bgb> paramLinkedList)
  {
    AppMethodBeat.i(169401);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
    if (b.a.cPX())
    {
      AppMethodBeat.o(169401);
      return;
    }
    bfy localbfy = cPE();
    localObject = localbfy;
    if (localbfy == null) {
      localObject = new bfy();
    }
    ((bfy)localObject).LPC.addAll((Collection)paramLinkedList);
    a((bfy)localObject);
    AppMethodBeat.o(169401);
  }
  
  static bfy cPE()
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
    bfy localbfy = new bfy();
    try
    {
      localbfy.parseFrom(arrayOfByte);
      AppMethodBeat.o(122585);
      return localbfy;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)localIOException, "FuzzyMatchReport, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122585);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.e.a
 * JD-Core Version:    0.7.0.1
 */