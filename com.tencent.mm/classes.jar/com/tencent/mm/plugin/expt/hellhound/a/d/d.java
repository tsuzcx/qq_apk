package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a qpx;
  
  static
  {
    AppMethodBeat.i(122581);
    qpx = new a((byte)0);
    AppMethodBeat.o(122581);
  }
  
  public static final void a(aqe paramaqe)
  {
    AppMethodBeat.i(161614);
    a.a(paramaqe);
    AppMethodBeat.o(161614);
  }
  
  public static final void a(String paramString, aqg paramaqg, int paramInt)
  {
    AppMethodBeat.i(169400);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    if (paramaqg == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString = a.aaK(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString.EIZ.set(paramInt, paramaqg);
    a.a(paramString);
    AppMethodBeat.o(169400);
  }
  
  public static final Pair<aqg, Integer> ad(String paramString, long paramLong)
  {
    AppMethodBeat.i(169399);
    paramString = a.aaK(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169399);
      return null;
    }
    int i = paramString.EIZ.size() - 1;
    while (i >= 0)
    {
      aqg localaqg = (aqg)paramString.EIZ.get(i);
      if (localaqg.EJj == paramLong)
      {
        paramString = Pair.create(localaqg, Integer.valueOf(i));
        AppMethodBeat.o(169399);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(169399);
    return null;
  }
  
  public static final aqe cke()
  {
    AppMethodBeat.i(161613);
    aqe localaqe = a.cke();
    AppMethodBeat.o(161613);
    return localaqe;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", "index", "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"})
  public static final class a
  {
    public static void a(aqe paramaqe)
    {
      AppMethodBeat.i(122580);
      if (paramaqe == null)
      {
        AppMethodBeat.o(122580);
        return;
      }
      try
      {
        paramaqe = paramaqe.toByteArray();
        if (paramaqe == null)
        {
          AppMethodBeat.o(122580);
          return;
        }
      }
      catch (IOException paramaqe)
      {
        ac.printErrStackTrace("FuzzyMatchDao", (Throwable)paramaqe, "HABBYGE-MALI, FuzzyMatchDao, setFuzzyMatchInfo: %s", new Object[] { paramaqe.getMessage() });
        AppMethodBeat.o(122580);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_pgs_io", paramaqe);
      AppMethodBeat.o(122580);
    }
    
    public static void a(cvu paramcvu)
    {
      AppMethodBeat.i(122579);
      if (paramcvu == null)
      {
        AppMethodBeat.o(122579);
        return;
      }
      aqe localaqe = cke();
      if (localaqe == null)
      {
        localaqe = new aqe();
        ac.i("FuzzyMatchDao", "HABBYGE-MALI, updateSessionMatchInfo, addNew: " + paramcvu.dnh);
        localaqe.EJa.addLast(paramcvu);
        paramcvu = localaqe;
        a(paramcvu);
        AppMethodBeat.o(122579);
        return;
      }
      int i = localaqe.EJa.size() - 1;
      label85:
      if (i >= 0)
      {
        cvu localcvu = (cvu)localaqe.EJa.get(i);
        if ((localcvu != null) && (k.g(localcvu.dnh, paramcvu.dnh)))
        {
          ac.i("FuzzyMatchDao", "HABBYGE-MALI, updateSessionMatchInfo, update: " + i + ", " + paramcvu.dnh);
          localaqe.EJa.set(i, paramcvu);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          ac.i("FuzzyMatchDao", "HABBYGE-MALI, updateSessionMatchInfo, add: " + paramcvu.dnh);
          localaqe.EJa.addLast(paramcvu);
        }
        paramcvu = localaqe;
        break;
        i -= 1;
        break label85;
      }
    }
    
    public static void a(cvu paramcvu, int paramInt)
    {
      AppMethodBeat.i(169397);
      if (paramcvu == null)
      {
        AppMethodBeat.o(169397);
        return;
      }
      aqe localaqe = cke();
      if (localaqe == null)
      {
        localaqe = new aqe();
        localaqe.EJa.addLast(paramcvu);
      }
      for (paramcvu = localaqe;; paramcvu = localaqe)
      {
        a(paramcvu);
        AppMethodBeat.o(169397);
        return;
        localaqe.EJa.set(paramInt, paramcvu);
      }
    }
    
    public static cvu aaK(String paramString)
    {
      AppMethodBeat.i(122578);
      if (paramString == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      aqe localaqe = cke();
      if (localaqe == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      ac.i("FuzzyMatchDao", "HABBYGE-MALI, getSessionFuzzyPath: session: " + paramString + ", " + localaqe.EJa.size());
      int i = localaqe.EJa.size() - 1;
      while (i >= 0)
      {
        cvu localcvu = (cvu)localaqe.EJa.get(i);
        if (!(k.g(paramString, localcvu.dnh) ^ true))
        {
          ac.i("FuzzyMatchDao", "HABBYGE-MALI, FuzzyMatchDao, getSessionFuzzyPath, sessionId: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(122578);
          return localcvu;
        }
        i -= 1;
      }
      AppMethodBeat.o(122578);
      return null;
    }
    
    public static Pair<cvu, Integer> aaL(String paramString)
    {
      AppMethodBeat.i(169396);
      k.h(paramString, "sessionId");
      aqe localaqe = cke();
      if (localaqe == null) {
        localaqe = new aqe();
      }
      for (;;)
      {
        int i = localaqe.EJa.size() - 1;
        while (i >= 0)
        {
          Object localObject = localaqe.EJa.get(i);
          k.g(localObject, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
          localObject = (cvu)localObject;
          if (k.g(paramString, ((cvu)localObject).dnh))
          {
            paramString = Pair.create(localObject, Integer.valueOf(i));
            k.g(paramString, "Pair.create(tmpSessionPath, i)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          i -= 1;
        }
        paramString = new cvu();
        localaqe.EJa.addLast(paramString);
        a(localaqe);
        paramString = Pair.create(paramString, Integer.valueOf(localaqe.EJa.size() - 1));
        k.g(paramString, "Pair.create(tmpSessionPa…ssionFuzzyPaths.size - 1)");
        AppMethodBeat.o(169396);
        return paramString;
      }
    }
    
    public static aqe cke()
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
      aqe localaqe = new aqe();
      try
      {
        localaqe.parseFrom(arrayOfByte);
        AppMethodBeat.o(122577);
        return localaqe;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("FuzzyMatchDao", (Throwable)localException, "HABBYGE-MALI, FuzzyMatchDao, getFuzzyMatchInfo: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(122577);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(169398);
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.ciE())
      {
        AppMethodBeat.o(169398);
        return;
      }
      ac.i("FuzzyMatchDao", "HABBYGE-MALI, FuzzyMatchDao, reset...");
      aqe localaqe = cke();
      if (localaqe == null)
      {
        AppMethodBeat.o(169398);
        return;
      }
      int i = localaqe.EJa.size() - 1;
      if (i >= 0)
      {
        cvu localcvu = (cvu)localaqe.EJa.get(i);
        if ((localcvu == null) || (localcvu.EIZ.isEmpty())) {
          localaqe.EJa.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          int j = localcvu.EIZ.size() - 1;
          while (j >= 0)
          {
            Object localObject = localcvu.EIZ.get(j);
            k.g(localObject, "sessionPath.paths[j]");
            localObject = (aqg)localObject;
            if ((localObject == null) || (((aqg)localObject).EJg.isEmpty()) || (((aqg)localObject).EJh)) {
              localcvu.EIZ.remove(j);
            }
            j -= 1;
          }
          if (localcvu.EIZ.isEmpty()) {
            localaqe.EJa.remove(i);
          }
        }
      }
      a(localaqe);
      AppMethodBeat.o(169398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.d
 * JD-Core Version:    0.7.0.1
 */