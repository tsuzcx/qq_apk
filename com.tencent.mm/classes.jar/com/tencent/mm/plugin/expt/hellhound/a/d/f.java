package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a wnV;
  
  static
  {
    AppMethodBeat.i(185597);
    wnV = new a((byte)0);
    AppMethodBeat.o(185597);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    private static void a(bmz parambmz)
    {
      AppMethodBeat.i(185595);
      if ((parambmz == null) || (parambmz.SXQ.isEmpty()))
      {
        AppMethodBeat.o(185595);
        return;
      }
      try
      {
        parambmz = parambmz.toByteArray();
        if (parambmz == null)
        {
          AppMethodBeat.o(185595);
          return;
        }
      }
      catch (IOException parambmz)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)parambmz, "FuzzyMatchedBackup, _write: %s", new Object[] { parambmz.getMessage() });
        AppMethodBeat.o(185595);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_fuzzy_matched_bckup", parambmz);
      AppMethodBeat.o(185595);
    }
    
    public static void ab(LinkedList<bnc> paramLinkedList)
    {
      AppMethodBeat.i(185591);
      p.k(paramLinkedList, "paths");
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
      if (b.a.deR())
      {
        Log.w("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
        AppMethodBeat.o(185591);
        return;
      }
      Log.i("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report: " + paramLinkedList.size());
      bmz localbmz = dey();
      localObject = localbmz;
      if (localbmz == null) {
        localObject = new bmz();
      }
      ((bmz)localObject).SXQ.addAll((Collection)paramLinkedList);
      a((bmz)localObject);
      AppMethodBeat.o(185591);
    }
    
    public static void asv(String paramString)
    {
      AppMethodBeat.i(185594);
      if (paramString == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      bmz localbmz = dey();
      if (localbmz == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      int i = localbmz.SXQ.size() - 1;
      if (i >= 0)
      {
        bnc localbnc = (bnc)localbmz.SXQ.get(i);
        if ((localbnc == null) || ((p.h(paramString, localbnc.fLj) ^ true))) {}
        for (;;)
        {
          i -= 1;
          break;
          localbmz.SXQ.remove(i);
        }
      }
      a(localbmz);
      AppMethodBeat.o(185594);
    }
    
    public static efg ayh(String paramString)
    {
      AppMethodBeat.i(185592);
      if (paramString == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      Object localObject = dey();
      if (localObject == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      efg localefg = new efg();
      localefg.fLj = paramString;
      localObject = ((bmz)localObject).SXQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bnc localbnc = (bnc)((Iterator)localObject).next();
        if ((localbnc != null) && (!(p.h(paramString, localbnc.fLj) ^ true))) {
          localefg.SXQ.add(localbnc);
        }
      }
      AppMethodBeat.o(185592);
      return localefg;
    }
    
    private static bmz dey()
    {
      AppMethodBeat.i(185596);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("mmkv_fuzzy_matched_bckup");
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
      bmz localbmz = new bmz();
      try
      {
        localbmz.parseFrom(arrayOfByte);
        AppMethodBeat.o(185596);
        return localbmz;
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
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_fuzzy_matched_bckup", new byte[0]);
      AppMethodBeat.o(185593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.f
 * JD-Core Version:    0.7.0.1
 */