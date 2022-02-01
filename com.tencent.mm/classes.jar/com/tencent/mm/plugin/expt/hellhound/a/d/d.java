package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a wnT;
  
  static
  {
    AppMethodBeat.i(122581);
    wnT = new a((byte)0);
    AppMethodBeat.o(122581);
  }
  
  public static final void a(bna parambna)
  {
    AppMethodBeat.i(161614);
    a.a(parambna);
    AppMethodBeat.o(161614);
  }
  
  public static final void a(String paramString, bnc parambnc, int paramInt)
  {
    AppMethodBeat.i(169400);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    if (parambnc == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString = a.ayf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString.SXQ.set(paramInt, parambnc);
    a.a(paramString);
    AppMethodBeat.o(169400);
  }
  
  public static final Pair<bnc, Integer> ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(169399);
    paramString = a.ayf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169399);
      return null;
    }
    int i = paramString.SXQ.size() - 1;
    while (i >= 0)
    {
      bnc localbnc = (bnc)paramString.SXQ.get(i);
      if (localbnc.SYb == paramLong)
      {
        paramString = Pair.create(localbnc, Integer.valueOf(i));
        AppMethodBeat.o(169399);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(169399);
    return null;
  }
  
  public static final bna dex()
  {
    AppMethodBeat.i(161613);
    bna localbna = a.dex();
    AppMethodBeat.o(161613);
    return localbna;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "getSessionFuzzyPath3", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", "index", "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"})
  public static final class a
  {
    public static void a(bna parambna)
    {
      AppMethodBeat.i(122580);
      if (parambna == null)
      {
        AppMethodBeat.o(122580);
        return;
      }
      try
      {
        parambna = parambna.toByteArray();
        if (parambna == null)
        {
          AppMethodBeat.o(122580);
          return;
        }
      }
      catch (IOException parambna)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)parambna, "FuzzyMatchDao, setFuzzyMatchInfo: %s", new Object[] { parambna.getMessage() });
        AppMethodBeat.o(122580);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_fuzzy_pgs_io", parambna);
      AppMethodBeat.o(122580);
    }
    
    public static void a(efg paramefg)
    {
      AppMethodBeat.i(122579);
      if (paramefg == null)
      {
        AppMethodBeat.o(122579);
        return;
      }
      bna localbna = dex();
      if (localbna == null)
      {
        localbna = new bna();
        Log.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, addNew: " + paramefg.fLj);
        localbna.SXR.addLast(paramefg);
        paramefg = localbna;
        a(paramefg);
        AppMethodBeat.o(122579);
        return;
      }
      int i = localbna.SXR.size() - 1;
      label85:
      if (i >= 0)
      {
        efg localefg = (efg)localbna.SXR.get(i);
        if ((localefg != null) && (p.h(localefg.fLj, paramefg.fLj))) {
          localbna.SXR.set(i, paramefg);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          Log.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, add: " + paramefg.fLj);
          localbna.SXR.addLast(paramefg);
        }
        paramefg = localbna;
        break;
        i -= 1;
        break label85;
      }
    }
    
    public static efg ayf(String paramString)
    {
      AppMethodBeat.i(122578);
      if (paramString == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      bna localbna = dex();
      if (localbna == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      int i = localbna.SXR.size() - 1;
      while (i >= 0)
      {
        efg localefg = (efg)localbna.SXR.get(i);
        if (!(p.h(paramString, localefg.fLj) ^ true))
        {
          AppMethodBeat.o(122578);
          return localefg;
        }
        i -= 1;
      }
      AppMethodBeat.o(122578);
      return null;
    }
    
    public static Pair<efg, Integer> ayg(String paramString)
    {
      AppMethodBeat.i(169396);
      p.k(paramString, "sessionId");
      bna localbna = dex();
      if (localbna == null) {
        localbna = new bna();
      }
      for (;;)
      {
        int i = localbna.SXR.size() - 1;
        while (i >= 0)
        {
          Object localObject = localbna.SXR.get(i);
          p.j(localObject, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
          localObject = (efg)localObject;
          if (p.h(paramString, ((efg)localObject).fLj))
          {
            paramString = Pair.create(localObject, Integer.valueOf(i));
            p.j(paramString, "Pair.create(tmpSessionPath, i)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          i -= 1;
        }
        paramString = new efg();
        localbna.SXR.addLast(paramString);
        a(localbna);
        paramString = Pair.create(paramString, Integer.valueOf(localbna.SXR.size() - 1));
        p.j(paramString, "Pair.create(tmpSessionPa…ssionFuzzyPaths.size - 1)");
        AppMethodBeat.o(169396);
        return paramString;
      }
    }
    
    public static void b(efg paramefg, int paramInt)
    {
      AppMethodBeat.i(169397);
      if (paramefg == null)
      {
        AppMethodBeat.o(169397);
        return;
      }
      bna localbna = dex();
      if (localbna == null)
      {
        localbna = new bna();
        localbna.SXR.addLast(paramefg);
      }
      for (paramefg = localbna;; paramefg = localbna)
      {
        a(paramefg);
        AppMethodBeat.o(169397);
        return;
        localbna.SXR.set(paramInt, paramefg);
      }
    }
    
    public static bna dex()
    {
      AppMethodBeat.i(122577);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("mmkv_fuzzy_pgs_io");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(122577);
        return null;
      }
      bna localbna = new bna();
      try
      {
        localbna.parseFrom(arrayOfByte);
        AppMethodBeat.o(122577);
        return localbna;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)localException, "FuzzyMatchDao, getFuzzyMatchInfo: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(122577);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(169398);
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
      {
        AppMethodBeat.o(169398);
        return;
      }
      Log.i("HABBYGE-MALI.FuzzyMatchDao", "FuzzyMatchDao, reset...");
      bna localbna = dex();
      if (localbna == null)
      {
        AppMethodBeat.o(169398);
        return;
      }
      int i = localbna.SXR.size() - 1;
      if (i >= 0)
      {
        efg localefg = (efg)localbna.SXR.get(i);
        if ((localefg == null) || (localefg.SXQ.isEmpty())) {
          localbna.SXR.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          int j = localefg.SXQ.size() - 1;
          while (j >= 0)
          {
            Object localObject = localefg.SXQ.get(j);
            p.j(localObject, "sessionPath.paths[j]");
            localObject = (bnc)localObject;
            if ((localObject == null) || (((bnc)localObject).SXY.isEmpty()) || (((bnc)localObject).SXZ)) {
              localefg.SXQ.remove(j);
            }
            j -= 1;
          }
          if (localefg.SXQ.isEmpty()) {
            localbna.SXR.remove(i);
          }
        }
      }
      a(localbna);
      AppMethodBeat.o(169398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.d
 * JD-Core Version:    0.7.0.1
 */