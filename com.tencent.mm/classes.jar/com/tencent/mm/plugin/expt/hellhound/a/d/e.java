package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class e
{
  public static final a wnU;
  
  static
  {
    AppMethodBeat.i(122587);
    wnU = new a((byte)0);
    AppMethodBeat.o(122587);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "timestamp", "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"})
  public static final class a
  {
    public static void JE(long paramLong)
    {
      AppMethodBeat.i(184281);
      Object localObject1 = d.wnT;
      Object localObject2 = d.a.dex();
      if (localObject2 == null)
      {
        AppMethodBeat.o(184281);
        return;
      }
      localObject1 = new LinkedList();
      int i = ((bna)localObject2).SXR.size() - 1;
      while (i >= 0)
      {
        localObject3 = (efg)((bna)localObject2).SXR.get(i);
        int j = ((efg)localObject3).SXQ.size() - 1;
        if (j >= 0)
        {
          Object localObject4 = ((efg)localObject3).SXQ.get(j);
          p.j(localObject4, "sessionFuzzyPath.paths[j]");
          localObject4 = (bnc)localObject4;
          if (((bnc)localObject4).SXZ) {
            a((bnc)localObject4, paramLong);
          }
          for (;;)
          {
            j -= 1;
            break;
            ((LinkedList)localObject1).addLast(localObject4);
            ((efg)localObject3).SXQ.remove(j);
          }
        }
        if (((efg)localObject3).SXQ.isEmpty()) {
          ((bna)localObject2).SXR.remove(i);
        }
        i -= 1;
      }
      Object localObject3 = d.wnT;
      d.a.a((bna)localObject2);
      if (!((Collection)localObject1).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          aa((LinkedList)localObject1);
          localObject2 = f.wnV;
          f.a.ab((LinkedList)localObject1);
        }
        AppMethodBeat.o(184281);
        return;
      }
    }
    
    private static void a(bmz parambmz)
    {
      AppMethodBeat.i(122584);
      if ((parambmz == null) || (parambmz.SXQ.isEmpty()))
      {
        AppMethodBeat.o(122584);
        return;
      }
      try
      {
        parambmz = parambmz.toByteArray();
        if (parambmz == null)
        {
          AppMethodBeat.o(122584);
          return;
        }
      }
      catch (IOException parambmz)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)parambmz, "FuzzyMatchReport, _write: %s", new Object[] { parambmz.getMessage() });
        AppMethodBeat.o(122584);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_fuzzy_mc_rpt", parambmz);
      AppMethodBeat.o(122584);
    }
    
    public static void a(bnc parambnc, long paramLong)
    {
      AppMethodBeat.i(122586);
      if (parambnc == null)
      {
        AppMethodBeat.o(122586);
        return;
      }
      if (parambnc.SXY.isEmpty())
      {
        AppMethodBeat.o(122586);
        return;
      }
      Object localObject = parambnc.SXY;
      p.j(localObject, "fuzzyPath.pages");
      localObject = (bnb)((LinkedList)localObject).getLast();
      paramLong -= ((bnb)localObject).startTime;
      if (paramLong >= 0L) {}
      for (;;)
      {
        ((bnb)localObject).SXT = paramLong;
        if (parambnc.SXY.size() != 1) {
          break;
        }
        AppMethodBeat.o(122586);
        return;
        paramLong = 0L;
      }
      int i = parambnc.SXY.size() - 1;
      if (i > 0)
      {
        localObject = parambnc.SXY.get(i - 1);
        p.j(localObject, "fuzzyPath.pages[i - 1]");
        localObject = (bnb)localObject;
        if (((bnb)localObject).SXT <= 0L)
        {
          paramLong = ((bnb)parambnc.SXY.get(i)).startTime - ((bnb)localObject).startTime;
          if (paramLong < 0L) {
            break label186;
          }
        }
        for (;;)
        {
          ((bnb)localObject).SXT = paramLong;
          i -= 1;
          break;
          label186:
          paramLong = 0L;
        }
      }
      AppMethodBeat.o(122586);
    }
    
    private static void aa(LinkedList<bnc> paramLinkedList)
    {
      AppMethodBeat.i(169401);
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
      if (b.a.deR())
      {
        AppMethodBeat.o(169401);
        return;
      }
      bmz localbmz = dey();
      localObject = localbmz;
      if (localbmz == null) {
        localObject = new bmz();
      }
      ((bmz)localObject).SXQ.addAll((Collection)paramLinkedList);
      a((bmz)localObject);
      AppMethodBeat.o(169401);
    }
    
    static bmz dey()
    {
      AppMethodBeat.i(122585);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("mmkv_fuzzy_mc_rpt");
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
      bmz localbmz = new bmz();
      try
      {
        localbmz.parseFrom(arrayOfByte);
        AppMethodBeat.o(122585);
        return localbmz;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)localIOException, "FuzzyMatchReport, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(122585);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.e
 * JD-Core Version:    0.7.0.1
 */