package com.tencent.mm.plugin.expt.hellhound.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchReport$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_updateInOfPageFake", "", "fuzzyPath", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "timestamp", "", "_write", "cache", "getReportCache", "move2ReportCache", "reset", "store2ReportCache", "paths", "Ljava/util/LinkedList;", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  private static void a(cat paramcat)
  {
    AppMethodBeat.i(122584);
    if ((paramcat == null) || (paramcat.aajM.isEmpty()))
    {
      AppMethodBeat.o(122584);
      return;
    }
    try
    {
      paramcat = paramcat.toByteArray();
      if (paramcat == null)
      {
        AppMethodBeat.o(122584);
        return;
      }
    }
    catch (IOException paramcat)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)paramcat, "FuzzyMatchReport, _write: %s", new Object[] { paramcat.getMessage() });
      AppMethodBeat.o(122584);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_fuzzy_mc_rpt", paramcat);
    AppMethodBeat.o(122584);
  }
  
  public static void a(caw paramcaw, long paramLong)
  {
    AppMethodBeat.i(122586);
    if (paramcaw == null)
    {
      AppMethodBeat.o(122586);
      return;
    }
    if (paramcaw.aajU.isEmpty())
    {
      AppMethodBeat.o(122586);
      return;
    }
    Object localObject = (cav)paramcaw.aajU.getLast();
    paramLong -= ((cav)localObject).startTime;
    if (paramLong >= 0L) {}
    for (;;)
    {
      ((cav)localObject).aajP = paramLong;
      if (paramcaw.aajU.size() != 1) {
        break;
      }
      AppMethodBeat.o(122586);
      return;
      paramLong = 0L;
    }
    int i = paramcaw.aajU.size() - 1;
    if (i > 0) {}
    for (;;)
    {
      int j = i - 1;
      localObject = paramcaw.aajU.get(i - 1);
      s.s(localObject, "fuzzyPath.pages[i - 1]");
      localObject = (cav)localObject;
      if (((cav)localObject).aajP <= 0L)
      {
        paramLong = ((cav)paramcaw.aajU.get(i)).startTime - ((cav)localObject).startTime;
        if (paramLong < 0L) {
          break label184;
        }
      }
      for (;;)
      {
        ((cav)localObject).aajP = paramLong;
        if (j > 0) {
          break;
        }
        AppMethodBeat.o(122586);
        return;
        label184:
        paramLong = 0L;
      }
      i = j;
    }
  }
  
  private static void ae(LinkedList<caw> paramLinkedList)
  {
    AppMethodBeat.i(169401);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    if (b.a.dLF())
    {
      AppMethodBeat.o(169401);
      return;
    }
    cat localcat = dLn();
    localObject = localcat;
    if (localcat == null) {
      localObject = new cat();
    }
    ((cat)localObject).aajM.addAll((Collection)paramLinkedList);
    a((cat)localObject);
    AppMethodBeat.o(169401);
  }
  
  static cat dLn()
  {
    AppMethodBeat.i(122585);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("mmkv_fuzzy_mc_rpt");
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
    cat localcat = new cat();
    try
    {
      localcat.parseFrom(arrayOfByte);
      AppMethodBeat.o(122585);
      return localcat;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchReport", (Throwable)localIOException, "FuzzyMatchReport, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(122585);
    }
    return null;
  }
  
  public static void mc(long paramLong)
  {
    AppMethodBeat.i(184281);
    Object localObject1 = c.zJW;
    Object localObject2 = c.a.dLm();
    if (localObject2 == null)
    {
      AppMethodBeat.o(184281);
      return;
    }
    localObject1 = new LinkedList();
    int i = ((cau)localObject2).aajN.size() - 1;
    int k;
    Object localObject3;
    int j;
    if (i >= 0)
    {
      k = i - 1;
      localObject3 = (eyz)((cau)localObject2).aajN.get(i);
      j = ((eyz)localObject3).aajM.size() - 1;
      if (j < 0) {}
    }
    for (;;)
    {
      int m = j - 1;
      Object localObject4 = ((eyz)localObject3).aajM.get(j);
      s.s(localObject4, "sessionFuzzyPath.paths[j]");
      localObject4 = (caw)localObject4;
      if (((caw)localObject4).aajV)
      {
        a((caw)localObject4, paramLong);
        if (m >= 0) {
          break label240;
        }
        if (((eyz)localObject3).aajM.isEmpty()) {
          ((cau)localObject2).aajN.remove(i);
        }
        if (k >= 0) {
          break label234;
        }
        localObject3 = c.zJW;
        c.a.a((cau)localObject2);
        if (((Collection)localObject1).isEmpty()) {
          break label229;
        }
      }
      label229:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          ae((LinkedList)localObject1);
          localObject2 = e.zJY;
          e.a.af((LinkedList)localObject1);
        }
        AppMethodBeat.o(184281);
        return;
        ((LinkedList)localObject1).addLast(localObject4);
        ((eyz)localObject3).aajM.remove(j);
        break;
      }
      label234:
      i = k;
      break;
      label240:
      j = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.d.d.a
 * JD-Core Version:    0.7.0.1
 */