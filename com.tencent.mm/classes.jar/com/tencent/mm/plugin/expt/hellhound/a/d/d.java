package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a pGQ;
  
  static
  {
    AppMethodBeat.i(122581);
    pGQ = new a((byte)0);
    AppMethodBeat.o(122581);
  }
  
  public static final void a(ana paramana)
  {
    AppMethodBeat.i(161614);
    a.a(paramana);
    AppMethodBeat.o(161614);
  }
  
  public static final void a(String paramString, anc paramanc, int paramInt)
  {
    AppMethodBeat.i(169400);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    if (paramanc == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString = a.Wn(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString.DnZ.set(paramInt, paramanc);
    a.a(paramString);
    AppMethodBeat.o(169400);
  }
  
  public static final Pair<anc, Integer> ab(String paramString, long paramLong)
  {
    AppMethodBeat.i(169399);
    paramString = a.Wn(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169399);
      return null;
    }
    int i = paramString.DnZ.size() - 1;
    while (i >= 0)
    {
      anc localanc = (anc)paramString.DnZ.get(i);
      if (localanc.Doj == paramLong)
      {
        paramString = Pair.create(localanc, Integer.valueOf(i));
        AppMethodBeat.o(169399);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(169399);
    return null;
  }
  
  public static final ana ccv()
  {
    AppMethodBeat.i(161613);
    ana localana = a.ccv();
    AppMethodBeat.o(161613);
    return localana;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", "index", "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"})
  public static final class a
  {
    public static cqn Wn(String paramString)
    {
      AppMethodBeat.i(122578);
      if (paramString == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      ana localana = ccv();
      if (localana == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      ad.i("FuzzyMatchDao", "HABBYGE-MALI, getSessionFuzzyPath: session: " + paramString + ", " + localana.Doa.size());
      int i = localana.Doa.size() - 1;
      while (i >= 0)
      {
        cqn localcqn = (cqn)localana.Doa.get(i);
        if (!(k.g(paramString, localcqn.dpw) ^ true))
        {
          ad.i("FuzzyMatchDao", "HABBYGE-MALI, FuzzyMatchDao, getSessionFuzzyPath, sessionId: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(122578);
          return localcqn;
        }
        i -= 1;
      }
      AppMethodBeat.o(122578);
      return null;
    }
    
    public static Pair<cqn, Integer> Wo(String paramString)
    {
      AppMethodBeat.i(169396);
      k.h(paramString, "sessionId");
      ana localana = ccv();
      if (localana == null) {
        localana = new ana();
      }
      for (;;)
      {
        int i = localana.Doa.size() - 1;
        while (i >= 0)
        {
          Object localObject = localana.Doa.get(i);
          k.g(localObject, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
          localObject = (cqn)localObject;
          if (k.g(paramString, ((cqn)localObject).dpw))
          {
            paramString = Pair.create(localObject, Integer.valueOf(i));
            k.g(paramString, "Pair.create(tmpSessionPath, i)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          i -= 1;
        }
        paramString = new cqn();
        localana.Doa.addLast(paramString);
        a(localana);
        paramString = Pair.create(paramString, Integer.valueOf(localana.Doa.size() - 1));
        k.g(paramString, "Pair.create(tmpSessionPa…ssionFuzzyPaths.size - 1)");
        AppMethodBeat.o(169396);
        return paramString;
      }
    }
    
    public static void a(ana paramana)
    {
      AppMethodBeat.i(122580);
      if (paramana == null)
      {
        AppMethodBeat.o(122580);
        return;
      }
      try
      {
        paramana = paramana.toByteArray();
        if (paramana == null)
        {
          AppMethodBeat.o(122580);
          return;
        }
      }
      catch (IOException paramana)
      {
        ad.printErrStackTrace("FuzzyMatchDao", (Throwable)paramana, "HABBYGE-MALI, FuzzyMatchDao, setFuzzyMatchInfo: %s", new Object[] { paramana.getMessage() });
        AppMethodBeat.o(122580);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_pgs_io", paramana);
      AppMethodBeat.o(122580);
    }
    
    public static void a(cqn paramcqn)
    {
      AppMethodBeat.i(122579);
      if (paramcqn == null)
      {
        AppMethodBeat.o(122579);
        return;
      }
      ana localana = ccv();
      if (localana == null)
      {
        localana = new ana();
        ad.i("FuzzyMatchDao", "HABBYGE-MALI, updateSessionMatchInfo, addNew: " + paramcqn.dpw);
        localana.Doa.addLast(paramcqn);
        paramcqn = localana;
        a(paramcqn);
        AppMethodBeat.o(122579);
        return;
      }
      int i = localana.Doa.size() - 1;
      label85:
      if (i >= 0)
      {
        cqn localcqn = (cqn)localana.Doa.get(i);
        if ((localcqn != null) && (k.g(localcqn.dpw, paramcqn.dpw)))
        {
          ad.i("FuzzyMatchDao", "HABBYGE-MALI, updateSessionMatchInfo, update: " + i + ", " + paramcqn.dpw);
          localana.Doa.set(i, paramcqn);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          ad.i("FuzzyMatchDao", "HABBYGE-MALI, updateSessionMatchInfo, add: " + paramcqn.dpw);
          localana.Doa.addLast(paramcqn);
        }
        paramcqn = localana;
        break;
        i -= 1;
        break label85;
      }
    }
    
    public static void a(cqn paramcqn, int paramInt)
    {
      AppMethodBeat.i(169397);
      if (paramcqn == null)
      {
        AppMethodBeat.o(169397);
        return;
      }
      ana localana = ccv();
      if (localana == null)
      {
        localana = new ana();
        localana.Doa.addLast(paramcqn);
      }
      for (paramcqn = localana;; paramcqn = localana)
      {
        a(paramcqn);
        AppMethodBeat.o(169397);
        return;
        localana.Doa.set(paramInt, paramcqn);
      }
    }
    
    public static ana ccv()
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
      ana localana = new ana();
      try
      {
        localana.parseFrom(arrayOfByte);
        AppMethodBeat.o(122577);
        return localana;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("FuzzyMatchDao", (Throwable)localException, "HABBYGE-MALI, FuzzyMatchDao, getFuzzyMatchInfo: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(122577);
      }
      return null;
    }
    
    public static void reset()
    {
      AppMethodBeat.i(169398);
      if (!com.tencent.mm.plugin.expt.hellhound.core.b.cbv())
      {
        AppMethodBeat.o(169398);
        return;
      }
      ad.i("FuzzyMatchDao", "HABBYGE-MALI, FuzzyMatchDao, reset...");
      ana localana = ccv();
      if (localana == null)
      {
        AppMethodBeat.o(169398);
        return;
      }
      int i = localana.Doa.size() - 1;
      if (i >= 0)
      {
        cqn localcqn = (cqn)localana.Doa.get(i);
        if ((localcqn == null) || (localcqn.DnZ.isEmpty())) {
          localana.Doa.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          int j = localcqn.DnZ.size() - 1;
          while (j >= 0)
          {
            Object localObject = localcqn.DnZ.get(j);
            k.g(localObject, "sessionPath.paths[j]");
            localObject = (anc)localObject;
            if ((localObject == null) || (((anc)localObject).Dog.isEmpty()) || (((anc)localObject).Doh)) {
              localcqn.DnZ.remove(j);
            }
            j -= 1;
          }
          if (localcqn.DnZ.isEmpty()) {
            localana.Doa.remove(i);
          }
        }
      }
      a(localana);
      AppMethodBeat.o(169398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.d
 * JD-Core Version:    0.7.0.1
 */