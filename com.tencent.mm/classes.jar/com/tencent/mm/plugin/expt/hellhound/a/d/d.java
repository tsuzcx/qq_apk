package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a rgC;
  
  static
  {
    AppMethodBeat.i(122581);
    rgC = new a((byte)0);
    AppMethodBeat.o(122581);
  }
  
  public static final void a(auq paramauq)
  {
    AppMethodBeat.i(161614);
    a.a(paramauq);
    AppMethodBeat.o(161614);
  }
  
  public static final void a(String paramString, aus paramaus, int paramInt)
  {
    AppMethodBeat.i(169400);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    if (paramaus == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString = a.afu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString.GLy.set(paramInt, paramaus);
    a.a(paramString);
    AppMethodBeat.o(169400);
  }
  
  public static final Pair<aus, Integer> ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(169399);
    paramString = a.afu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169399);
      return null;
    }
    int i = paramString.GLy.size() - 1;
    while (i >= 0)
    {
      aus localaus = (aus)paramString.GLy.get(i);
      if (localaus.GLJ == paramLong)
      {
        paramString = Pair.create(localaus, Integer.valueOf(i));
        AppMethodBeat.o(169399);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(169399);
    return null;
  }
  
  public static final auq cqV()
  {
    AppMethodBeat.i(161613);
    auq localauq = a.cqV();
    AppMethodBeat.o(161613);
    return localauq;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "getSessionFuzzyPath3", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", "index", "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"})
  public static final class a
  {
    public static void a(auq paramauq)
    {
      AppMethodBeat.i(122580);
      if (paramauq == null)
      {
        AppMethodBeat.o(122580);
        return;
      }
      try
      {
        paramauq = paramauq.toByteArray();
        if (paramauq == null)
        {
          AppMethodBeat.o(122580);
          return;
        }
      }
      catch (IOException paramauq)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)paramauq, "FuzzyMatchDao, setFuzzyMatchInfo: %s", new Object[] { paramauq.getMessage() });
        AppMethodBeat.o(122580);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_pgs_io", paramauq);
      AppMethodBeat.o(122580);
    }
    
    public static void a(dca paramdca)
    {
      AppMethodBeat.i(122579);
      if (paramdca == null)
      {
        AppMethodBeat.o(122579);
        return;
      }
      auq localauq = cqV();
      if (localauq == null)
      {
        localauq = new auq();
        ae.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, addNew: " + paramdca.dAa);
        localauq.GLz.addLast(paramdca);
        paramdca = localauq;
        a(paramdca);
        AppMethodBeat.o(122579);
        return;
      }
      int i = localauq.GLz.size() - 1;
      label85:
      if (i >= 0)
      {
        dca localdca = (dca)localauq.GLz.get(i);
        if ((localdca != null) && (p.i(localdca.dAa, paramdca.dAa))) {
          localauq.GLz.set(i, paramdca);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          ae.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, add: " + paramdca.dAa);
          localauq.GLz.addLast(paramdca);
        }
        paramdca = localauq;
        break;
        i -= 1;
        break label85;
      }
    }
    
    public static dca afu(String paramString)
    {
      AppMethodBeat.i(122578);
      if (paramString == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      auq localauq = cqV();
      if (localauq == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      int i = localauq.GLz.size() - 1;
      while (i >= 0)
      {
        dca localdca = (dca)localauq.GLz.get(i);
        if (!(p.i(paramString, localdca.dAa) ^ true))
        {
          AppMethodBeat.o(122578);
          return localdca;
        }
        i -= 1;
      }
      AppMethodBeat.o(122578);
      return null;
    }
    
    public static Pair<dca, Integer> afv(String paramString)
    {
      AppMethodBeat.i(169396);
      p.h(paramString, "sessionId");
      auq localauq = cqV();
      if (localauq == null) {
        localauq = new auq();
      }
      for (;;)
      {
        int i = localauq.GLz.size() - 1;
        while (i >= 0)
        {
          Object localObject = localauq.GLz.get(i);
          p.g(localObject, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
          localObject = (dca)localObject;
          if (p.i(paramString, ((dca)localObject).dAa))
          {
            paramString = Pair.create(localObject, Integer.valueOf(i));
            p.g(paramString, "Pair.create(tmpSessionPath, i)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          i -= 1;
        }
        paramString = new dca();
        localauq.GLz.addLast(paramString);
        a(localauq);
        paramString = Pair.create(paramString, Integer.valueOf(localauq.GLz.size() - 1));
        p.g(paramString, "Pair.create(tmpSessionPa…ssionFuzzyPaths.size - 1)");
        AppMethodBeat.o(169396);
        return paramString;
      }
    }
    
    public static void b(dca paramdca, int paramInt)
    {
      AppMethodBeat.i(169397);
      if (paramdca == null)
      {
        AppMethodBeat.o(169397);
        return;
      }
      auq localauq = cqV();
      if (localauq == null)
      {
        localauq = new auq();
        localauq.GLz.addLast(paramdca);
      }
      for (paramdca = localauq;; paramdca = localauq)
      {
        a(paramdca);
        AppMethodBeat.o(169397);
        return;
        localauq.GLz.set(paramInt, paramdca);
      }
    }
    
    public static auq cqV()
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
      auq localauq = new auq();
      try
      {
        localauq.parseFrom(arrayOfByte);
        AppMethodBeat.o(122577);
        return localauq;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)localException, "FuzzyMatchDao, getFuzzyMatchInfo: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(122577);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(169398);
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.cpe())
      {
        AppMethodBeat.o(169398);
        return;
      }
      ae.i("HABBYGE-MALI.FuzzyMatchDao", "FuzzyMatchDao, reset...");
      auq localauq = cqV();
      if (localauq == null)
      {
        AppMethodBeat.o(169398);
        return;
      }
      int i = localauq.GLz.size() - 1;
      if (i >= 0)
      {
        dca localdca = (dca)localauq.GLz.get(i);
        if ((localdca == null) || (localdca.GLy.isEmpty())) {
          localauq.GLz.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          int j = localdca.GLy.size() - 1;
          while (j >= 0)
          {
            Object localObject = localdca.GLy.get(j);
            p.g(localObject, "sessionPath.paths[j]");
            localObject = (aus)localObject;
            if ((localObject == null) || (((aus)localObject).GLG.isEmpty()) || (((aus)localObject).GLH)) {
              localdca.GLy.remove(j);
            }
            j -= 1;
          }
          if (localdca.GLy.isEmpty()) {
            localauq.GLz.remove(i);
          }
        }
      }
      a(localauq);
      AppMethodBeat.o(169398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.d
 * JD-Core Version:    0.7.0.1
 */