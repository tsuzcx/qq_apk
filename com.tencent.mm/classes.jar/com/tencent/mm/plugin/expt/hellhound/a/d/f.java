package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a qpz;
  
  static
  {
    AppMethodBeat.i(185597);
    qpz = new a((byte)0);
    AppMethodBeat.o(185597);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    public static void Wd(String paramString)
    {
      AppMethodBeat.i(185594);
      if (paramString == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      aqd localaqd = ckf();
      if (localaqd == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      int i = localaqd.EIZ.size() - 1;
      if (i >= 0)
      {
        aqg localaqg = (aqg)localaqd.EIZ.get(i);
        if ((localaqg == null) || ((k.g(paramString, localaqg.dnh) ^ true))) {}
        for (;;)
        {
          i -= 1;
          break;
          localaqd.EIZ.remove(i);
        }
      }
      a(localaqd);
      AppMethodBeat.o(185594);
    }
    
    private static void a(aqd paramaqd)
    {
      AppMethodBeat.i(185595);
      if ((paramaqd == null) || (paramaqd.EIZ.isEmpty()))
      {
        AppMethodBeat.o(185595);
        return;
      }
      try
      {
        paramaqd = paramaqd.toByteArray();
        if (paramaqd == null)
        {
          AppMethodBeat.o(185595);
          return;
        }
      }
      catch (IOException paramaqd)
      {
        ac.printErrStackTrace("FuzzyMatchedBackup", (Throwable)paramaqd, "HABBYGE-MALI, FuzzyMatchedBackup, _write: %s", new Object[] { paramaqd.getMessage() });
        AppMethodBeat.o(185595);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_matched_bckup", paramaqd);
      AppMethodBeat.o(185595);
    }
    
    public static cvu aaM(String paramString)
    {
      AppMethodBeat.i(185592);
      if (paramString == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      Object localObject = ckf();
      if (localObject == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      cvu localcvu = new cvu();
      localcvu.dnh = paramString;
      localObject = ((aqd)localObject).EIZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aqg localaqg = (aqg)((Iterator)localObject).next();
        if ((localaqg != null) && (!(k.g(paramString, localaqg.dnh) ^ true))) {
          localcvu.EIZ.add(localaqg);
        }
      }
      AppMethodBeat.o(185592);
      return localcvu;
    }
    
    public static void ab(LinkedList<aqg> paramLinkedList)
    {
      AppMethodBeat.i(185591);
      k.h(paramLinkedList, "paths");
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
      if (b.a.ckx())
      {
        ac.w("FuzzyMatchedBackup", "HABBYGE-MALI, FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
        AppMethodBeat.o(185591);
        return;
      }
      ac.i("FuzzyMatchedBackup", "HABBYGE-MALI, FuzzyMatchedBackup, report: " + paramLinkedList.size());
      aqd localaqd = ckf();
      localObject = localaqd;
      if (localaqd == null) {
        localObject = new aqd();
      }
      ((aqd)localObject).EIZ.addAll((Collection)paramLinkedList);
      a((aqd)localObject);
      AppMethodBeat.o(185591);
    }
    
    private static aqd ckf()
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
      aqd localaqd = new aqd();
      try
      {
        localaqd.parseFrom(arrayOfByte);
        AppMethodBeat.o(185596);
        return localaqd;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("FuzzyMatchedBackup", (Throwable)localIOException, "HABBYGE-MALI, FuzzyMatchedBackup, _read: %s", new Object[] { localIOException.getMessage() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.f
 * JD-Core Version:    0.7.0.1
 */