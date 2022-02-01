package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a qYw;
  
  static
  {
    AppMethodBeat.i(122581);
    qYw = new a((byte)0);
    AppMethodBeat.o(122581);
  }
  
  public static final void a(aua paramaua)
  {
    AppMethodBeat.i(161614);
    a.a(paramaua);
    AppMethodBeat.o(161614);
  }
  
  public static final void a(String paramString, auc paramauc, int paramInt)
  {
    AppMethodBeat.i(169400);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    if (paramauc == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString = a.aey(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString.Gsa.set(paramInt, paramauc);
    a.a(paramString);
    AppMethodBeat.o(169400);
  }
  
  public static final Pair<auc, Integer> ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(169399);
    paramString = a.aey(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169399);
      return null;
    }
    int i = paramString.Gsa.size() - 1;
    while (i >= 0)
    {
      auc localauc = (auc)paramString.Gsa.get(i);
      if (localauc.Gsl == paramLong)
      {
        paramString = Pair.create(localauc, Integer.valueOf(i));
        AppMethodBeat.o(169399);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(169399);
    return null;
  }
  
  public static final aua cpt()
  {
    AppMethodBeat.i(161613);
    aua localaua = a.cpt();
    AppMethodBeat.o(161613);
    return localaua;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "getSessionFuzzyPath3", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", "index", "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"})
  public static final class a
  {
    public static void a(aua paramaua)
    {
      AppMethodBeat.i(122580);
      if (paramaua == null)
      {
        AppMethodBeat.o(122580);
        return;
      }
      try
      {
        paramaua = paramaua.toByteArray();
        if (paramaua == null)
        {
          AppMethodBeat.o(122580);
          return;
        }
      }
      catch (IOException paramaua)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)paramaua, "FuzzyMatchDao, setFuzzyMatchInfo: %s", new Object[] { paramaua.getMessage() });
        AppMethodBeat.o(122580);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_pgs_io", paramaua);
      AppMethodBeat.o(122580);
    }
    
    public static void a(dbg paramdbg)
    {
      AppMethodBeat.i(122579);
      if (paramdbg == null)
      {
        AppMethodBeat.o(122579);
        return;
      }
      aua localaua = cpt();
      if (localaua == null)
      {
        localaua = new aua();
        ad.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, addNew: " + paramdbg.dyV);
        localaua.Gsb.addLast(paramdbg);
        paramdbg = localaua;
        a(paramdbg);
        AppMethodBeat.o(122579);
        return;
      }
      int i = localaua.Gsb.size() - 1;
      label85:
      if (i >= 0)
      {
        dbg localdbg = (dbg)localaua.Gsb.get(i);
        if ((localdbg != null) && (p.i(localdbg.dyV, paramdbg.dyV))) {
          localaua.Gsb.set(i, paramdbg);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          ad.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, add: " + paramdbg.dyV);
          localaua.Gsb.addLast(paramdbg);
        }
        paramdbg = localaua;
        break;
        i -= 1;
        break label85;
      }
    }
    
    public static dbg aey(String paramString)
    {
      AppMethodBeat.i(122578);
      if (paramString == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      aua localaua = cpt();
      if (localaua == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      int i = localaua.Gsb.size() - 1;
      while (i >= 0)
      {
        dbg localdbg = (dbg)localaua.Gsb.get(i);
        if (!(p.i(paramString, localdbg.dyV) ^ true))
        {
          AppMethodBeat.o(122578);
          return localdbg;
        }
        i -= 1;
      }
      AppMethodBeat.o(122578);
      return null;
    }
    
    public static Pair<dbg, Integer> aez(String paramString)
    {
      AppMethodBeat.i(169396);
      p.h(paramString, "sessionId");
      aua localaua = cpt();
      if (localaua == null) {
        localaua = new aua();
      }
      for (;;)
      {
        int i = localaua.Gsb.size() - 1;
        while (i >= 0)
        {
          Object localObject = localaua.Gsb.get(i);
          p.g(localObject, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
          localObject = (dbg)localObject;
          if (p.i(paramString, ((dbg)localObject).dyV))
          {
            paramString = Pair.create(localObject, Integer.valueOf(i));
            p.g(paramString, "Pair.create(tmpSessionPath, i)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          i -= 1;
        }
        paramString = new dbg();
        localaua.Gsb.addLast(paramString);
        a(localaua);
        paramString = Pair.create(paramString, Integer.valueOf(localaua.Gsb.size() - 1));
        p.g(paramString, "Pair.create(tmpSessionPa…ssionFuzzyPaths.size - 1)");
        AppMethodBeat.o(169396);
        return paramString;
      }
    }
    
    public static void b(dbg paramdbg, int paramInt)
    {
      AppMethodBeat.i(169397);
      if (paramdbg == null)
      {
        AppMethodBeat.o(169397);
        return;
      }
      aua localaua = cpt();
      if (localaua == null)
      {
        localaua = new aua();
        localaua.Gsb.addLast(paramdbg);
      }
      for (paramdbg = localaua;; paramdbg = localaua)
      {
        a(paramdbg);
        AppMethodBeat.o(169397);
        return;
        localaua.Gsb.set(paramInt, paramdbg);
      }
    }
    
    public static aua cpt()
    {
      AppMethodBeat.i(122577);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_fuzzy_pgs_io");
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
      aua localaua = new aua();
      try
      {
        localaua.parseFrom(arrayOfByte);
        AppMethodBeat.o(122577);
        return localaua;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)localException, "FuzzyMatchDao, getFuzzyMatchInfo: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(122577);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(169398);
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.cnC())
      {
        AppMethodBeat.o(169398);
        return;
      }
      ad.i("HABBYGE-MALI.FuzzyMatchDao", "FuzzyMatchDao, reset...");
      aua localaua = cpt();
      if (localaua == null)
      {
        AppMethodBeat.o(169398);
        return;
      }
      int i = localaua.Gsb.size() - 1;
      if (i >= 0)
      {
        dbg localdbg = (dbg)localaua.Gsb.get(i);
        if ((localdbg == null) || (localdbg.Gsa.isEmpty())) {
          localaua.Gsb.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          int j = localdbg.Gsa.size() - 1;
          while (j >= 0)
          {
            Object localObject = localdbg.Gsa.get(j);
            p.g(localObject, "sessionPath.paths[j]");
            localObject = (auc)localObject;
            if ((localObject == null) || (((auc)localObject).Gsi.isEmpty()) || (((auc)localObject).Gsj)) {
              localdbg.Gsa.remove(j);
            }
            j -= 1;
          }
          if (localdbg.Gsa.isEmpty()) {
            localaua.Gsb.remove(i);
          }
        }
      }
      a(localaua);
      AppMethodBeat.o(169398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.d
 * JD-Core Version:    0.7.0.1
 */