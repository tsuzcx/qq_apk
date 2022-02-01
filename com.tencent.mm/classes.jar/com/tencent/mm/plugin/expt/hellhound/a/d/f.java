package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a sIa;
  
  static
  {
    AppMethodBeat.i(185597);
    sIa = new a((byte)0);
    AppMethodBeat.o(185597);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    private static void a(bfy parambfy)
    {
      AppMethodBeat.i(185595);
      if ((parambfy == null) || (parambfy.LPC.isEmpty()))
      {
        AppMethodBeat.o(185595);
        return;
      }
      try
      {
        parambfy = parambfy.toByteArray();
        if (parambfy == null)
        {
          AppMethodBeat.o(185595);
          return;
        }
      }
      catch (IOException parambfy)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)parambfy, "FuzzyMatchedBackup, _write: %s", new Object[] { parambfy.getMessage() });
        AppMethodBeat.o(185595);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_matched_bckup", parambfy);
      AppMethodBeat.o(185595);
    }
    
    public static void ad(LinkedList<bgb> paramLinkedList)
    {
      AppMethodBeat.i(185591);
      p.h(paramLinkedList, "paths");
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
      if (b.a.cPX())
      {
        Log.w("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
        AppMethodBeat.o(185591);
        return;
      }
      Log.i("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report: " + paramLinkedList.size());
      bfy localbfy = cPE();
      localObject = localbfy;
      if (localbfy == null) {
        localObject = new bfy();
      }
      ((bfy)localObject).LPC.addAll((Collection)paramLinkedList);
      a((bfy)localObject);
      AppMethodBeat.o(185591);
    }
    
    public static void akH(String paramString)
    {
      AppMethodBeat.i(185594);
      if (paramString == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      bfy localbfy = cPE();
      if (localbfy == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      int i = localbfy.LPC.size() - 1;
      if (i >= 0)
      {
        bgb localbgb = (bgb)localbfy.LPC.get(i);
        if ((localbgb == null) || ((p.j(paramString, localbgb.dRM) ^ true))) {}
        for (;;)
        {
          i -= 1;
          break;
          localbfy.LPC.remove(i);
        }
      }
      a(localbfy);
      AppMethodBeat.o(185594);
    }
    
    public static dve aqh(String paramString)
    {
      AppMethodBeat.i(185592);
      if (paramString == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      Object localObject = cPE();
      if (localObject == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      dve localdve = new dve();
      localdve.dRM = paramString;
      localObject = ((bfy)localObject).LPC.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bgb localbgb = (bgb)((Iterator)localObject).next();
        if ((localbgb != null) && (!(p.j(paramString, localbgb.dRM) ^ true))) {
          localdve.LPC.add(localbgb);
        }
      }
      AppMethodBeat.o(185592);
      return localdve;
    }
    
    private static bfy cPE()
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
      bfy localbfy = new bfy();
      try
      {
        localbfy.parseFrom(arrayOfByte);
        AppMethodBeat.o(185596);
        return localbfy;
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_matched_bckup", new byte[0]);
      AppMethodBeat.o(185593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.f
 * JD-Core Version:    0.7.0.1
 */