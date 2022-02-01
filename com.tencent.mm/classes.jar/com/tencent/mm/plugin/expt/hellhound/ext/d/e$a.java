package com.tencent.mm.plugin.expt.hellhound.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$a
{
  private static void a(cat paramcat)
  {
    AppMethodBeat.i(185595);
    if ((paramcat == null) || (paramcat.aajM.isEmpty()))
    {
      AppMethodBeat.o(185595);
      return;
    }
    try
    {
      paramcat = paramcat.toByteArray();
      if (paramcat == null)
      {
        AppMethodBeat.o(185595);
        return;
      }
    }
    catch (IOException paramcat)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)paramcat, "FuzzyMatchedBackup, _write: %s", new Object[] { paramcat.getMessage() });
      AppMethodBeat.o(185595);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_fuzzy_matched_bckup", paramcat);
    AppMethodBeat.o(185595);
  }
  
  public static void af(LinkedList<caw> paramLinkedList)
  {
    AppMethodBeat.i(185591);
    s.u(paramLinkedList, "paths");
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    if (b.a.dLF())
    {
      Log.w("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
      AppMethodBeat.o(185591);
      return;
    }
    Log.i("HABBYGE-MALI.FuzzyMatchedBackup", s.X("FuzzyMatchedBackup, report: ", Integer.valueOf(paramLinkedList.size())));
    cat localcat = dLn();
    localObject = localcat;
    if (localcat == null) {
      localObject = new cat();
    }
    ((cat)localObject).aajM.addAll((Collection)paramLinkedList);
    a((cat)localObject);
    AppMethodBeat.o(185591);
  }
  
  public static void ama(String paramString)
  {
    AppMethodBeat.i(185594);
    if (paramString == null)
    {
      AppMethodBeat.o(185594);
      return;
    }
    cat localcat = dLn();
    if (localcat == null)
    {
      AppMethodBeat.o(185594);
      return;
    }
    int i = localcat.aajM.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      caw localcaw = (caw)localcat.aajM.get(i);
      if ((localcaw == null) || (!s.p(paramString, localcaw.hQR))) {}
      while (j < 0)
      {
        a(localcat);
        AppMethodBeat.o(185594);
        return;
        localcat.aajM.remove(i);
      }
      i = j;
    }
  }
  
  public static eyz asm(String paramString)
  {
    AppMethodBeat.i(185592);
    if (paramString == null)
    {
      AppMethodBeat.o(185592);
      return null;
    }
    Object localObject = dLn();
    if (localObject == null)
    {
      AppMethodBeat.o(185592);
      return null;
    }
    eyz localeyz = new eyz();
    localeyz.hQR = paramString;
    localObject = ((cat)localObject).aajM.iterator();
    while (((Iterator)localObject).hasNext())
    {
      caw localcaw = (caw)((Iterator)localObject).next();
      if ((localcaw != null) && (s.p(paramString, localcaw.hQR))) {
        localeyz.aajM.add(localcaw);
      }
    }
    AppMethodBeat.o(185592);
    return localeyz;
  }
  
  private static cat dLn()
  {
    AppMethodBeat.i(185596);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("mmkv_fuzzy_matched_bckup");
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
    cat localcat = new cat();
    try
    {
      localcat.parseFrom(arrayOfByte);
      AppMethodBeat.o(185596);
      return localcat;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)localIOException, "FuzzyMatchedBackup, _read: %s", new Object[] { localIOException.getMessage() });
      AppMethodBeat.o(185596);
    }
    return null;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(185593);
    com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_fuzzy_matched_bckup", new byte[0]);
    AppMethodBeat.o(185593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.d.e.a
 * JD-Core Version:    0.7.0.1
 */