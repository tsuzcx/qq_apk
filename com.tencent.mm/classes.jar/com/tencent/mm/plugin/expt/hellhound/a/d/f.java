package com.tencent.mm.plugin.expt.hellhound.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a rgE;
  
  static
  {
    AppMethodBeat.i(185597);
    rgE = new a((byte)0);
    AppMethodBeat.o(185597);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchedBackup$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "_write", "", "cache", "backup", "paths", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "getBackup", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "sessionId", "reset", "plugin-expt_release"})
  public static final class a
  {
    private static void a(aup paramaup)
    {
      AppMethodBeat.i(185595);
      if ((paramaup == null) || (paramaup.GLy.isEmpty()))
      {
        AppMethodBeat.o(185595);
        return;
      }
      try
      {
        paramaup = paramaup.toByteArray();
        if (paramaup == null)
        {
          AppMethodBeat.o(185595);
          return;
        }
      }
      catch (IOException paramaup)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)paramaup, "FuzzyMatchedBackup, _write: %s", new Object[] { paramaup.getMessage() });
        AppMethodBeat.o(185595);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_matched_bckup", paramaup);
      AppMethodBeat.o(185595);
    }
    
    public static void aaB(String paramString)
    {
      AppMethodBeat.i(185594);
      if (paramString == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      aup localaup = cqW();
      if (localaup == null)
      {
        AppMethodBeat.o(185594);
        return;
      }
      int i = localaup.GLy.size() - 1;
      if (i >= 0)
      {
        aus localaus = (aus)localaup.GLy.get(i);
        if ((localaus == null) || ((p.i(paramString, localaus.dAa) ^ true))) {}
        for (;;)
        {
          i -= 1;
          break;
          localaup.GLy.remove(i);
        }
      }
      a(localaup);
      AppMethodBeat.o(185594);
    }
    
    public static void ac(LinkedList<aus> paramLinkedList)
    {
      AppMethodBeat.i(185591);
      p.h(paramLinkedList, "paths");
      Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
      if (b.a.crp())
      {
        ae.w("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report, doNotNeedSessionMonitor FALSE");
        AppMethodBeat.o(185591);
        return;
      }
      ae.i("HABBYGE-MALI.FuzzyMatchedBackup", "FuzzyMatchedBackup, report: " + paramLinkedList.size());
      aup localaup = cqW();
      localObject = localaup;
      if (localaup == null) {
        localObject = new aup();
      }
      ((aup)localObject).GLy.addAll((Collection)paramLinkedList);
      a((aup)localObject);
      AppMethodBeat.o(185591);
    }
    
    public static dca afw(String paramString)
    {
      AppMethodBeat.i(185592);
      if (paramString == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      Object localObject = cqW();
      if (localObject == null)
      {
        AppMethodBeat.o(185592);
        return null;
      }
      dca localdca = new dca();
      localdca.dAa = paramString;
      localObject = ((aup)localObject).GLy.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aus localaus = (aus)((Iterator)localObject).next();
        if ((localaus != null) && (!(p.i(paramString, localaus.dAa) ^ true))) {
          localdca.GLy.add(localaus);
        }
      }
      AppMethodBeat.o(185592);
      return localdca;
    }
    
    private static aup cqW()
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
      aup localaup = new aup();
      try
      {
        localaup.parseFrom(arrayOfByte);
        AppMethodBeat.o(185596);
        return localaup;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchedBackup", (Throwable)localIOException, "FuzzyMatchedBackup, _read: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(185596);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(185593);
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_matched_bckup", new byte[0]);
      AppMethodBeat.o(185593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.f
 * JD-Core Version:    0.7.0.1
 */