package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class d
{
  public static final a sHY;
  
  static
  {
    AppMethodBeat.i(122581);
    sHY = new a((byte)0);
    AppMethodBeat.o(122581);
  }
  
  public static final void a(bfz parambfz)
  {
    AppMethodBeat.i(161614);
    a.a(parambfz);
    AppMethodBeat.o(161614);
  }
  
  public static final void a(String paramString, bgb parambgb, int paramInt)
  {
    AppMethodBeat.i(169400);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    if (parambgb == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString = a.aqf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169400);
      return;
    }
    paramString.LPC.set(paramInt, parambgb);
    a.a(paramString);
    AppMethodBeat.o(169400);
  }
  
  public static final Pair<bgb, Integer> ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(169399);
    paramString = a.aqf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(169399);
      return null;
    }
    int i = paramString.LPC.size() - 1;
    while (i >= 0)
    {
      bgb localbgb = (bgb)paramString.LPC.get(i);
      if (localbgb.LPN == paramLong)
      {
        paramString = Pair.create(localbgb, Integer.valueOf(i));
        AppMethodBeat.o(169399);
        return paramString;
      }
      i -= 1;
    }
    AppMethodBeat.o(169399);
    return null;
  }
  
  public static final bfz cPD()
  {
    AppMethodBeat.i(161613);
    bfz localbfz = a.cPD();
    AppMethodBeat.o(161613);
    return localbfz;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "getSessionFuzzyPath3", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", "index", "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"})
  public static final class a
  {
    public static void a(bfz parambfz)
    {
      AppMethodBeat.i(122580);
      if (parambfz == null)
      {
        AppMethodBeat.o(122580);
        return;
      }
      try
      {
        parambfz = parambfz.toByteArray();
        if (parambfz == null)
        {
          AppMethodBeat.o(122580);
          return;
        }
      }
      catch (IOException parambfz)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)parambfz, "FuzzyMatchDao, setFuzzyMatchInfo: %s", new Object[] { parambfz.getMessage() });
        AppMethodBeat.o(122580);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_pgs_io", parambfz);
      AppMethodBeat.o(122580);
    }
    
    public static void a(dve paramdve)
    {
      AppMethodBeat.i(122579);
      if (paramdve == null)
      {
        AppMethodBeat.o(122579);
        return;
      }
      bfz localbfz = cPD();
      if (localbfz == null)
      {
        localbfz = new bfz();
        Log.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, addNew: " + paramdve.dRM);
        localbfz.LPD.addLast(paramdve);
        paramdve = localbfz;
        a(paramdve);
        AppMethodBeat.o(122579);
        return;
      }
      int i = localbfz.LPD.size() - 1;
      label85:
      if (i >= 0)
      {
        dve localdve = (dve)localbfz.LPD.get(i);
        if ((localdve != null) && (p.j(localdve.dRM, paramdve.dRM))) {
          localbfz.LPD.set(i, paramdve);
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          Log.i("HABBYGE-MALI.FuzzyMatchDao", "updateSessionMatchInfo, add: " + paramdve.dRM);
          localbfz.LPD.addLast(paramdve);
        }
        paramdve = localbfz;
        break;
        i -= 1;
        break label85;
      }
    }
    
    public static dve aqf(String paramString)
    {
      AppMethodBeat.i(122578);
      if (paramString == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      bfz localbfz = cPD();
      if (localbfz == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      int i = localbfz.LPD.size() - 1;
      while (i >= 0)
      {
        dve localdve = (dve)localbfz.LPD.get(i);
        if (!(p.j(paramString, localdve.dRM) ^ true))
        {
          AppMethodBeat.o(122578);
          return localdve;
        }
        i -= 1;
      }
      AppMethodBeat.o(122578);
      return null;
    }
    
    public static Pair<dve, Integer> aqg(String paramString)
    {
      AppMethodBeat.i(169396);
      p.h(paramString, "sessionId");
      bfz localbfz = cPD();
      if (localbfz == null) {
        localbfz = new bfz();
      }
      for (;;)
      {
        int i = localbfz.LPD.size() - 1;
        while (i >= 0)
        {
          Object localObject = localbfz.LPD.get(i);
          p.g(localObject, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
          localObject = (dve)localObject;
          if (p.j(paramString, ((dve)localObject).dRM))
          {
            paramString = Pair.create(localObject, Integer.valueOf(i));
            p.g(paramString, "Pair.create(tmpSessionPath, i)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          i -= 1;
        }
        paramString = new dve();
        localbfz.LPD.addLast(paramString);
        a(localbfz);
        paramString = Pair.create(paramString, Integer.valueOf(localbfz.LPD.size() - 1));
        p.g(paramString, "Pair.create(tmpSessionPa…ssionFuzzyPaths.size - 1)");
        AppMethodBeat.o(169396);
        return paramString;
      }
    }
    
    public static void b(dve paramdve, int paramInt)
    {
      AppMethodBeat.i(169397);
      if (paramdve == null)
      {
        AppMethodBeat.o(169397);
        return;
      }
      bfz localbfz = cPD();
      if (localbfz == null)
      {
        localbfz = new bfz();
        localbfz.LPD.addLast(paramdve);
      }
      for (paramdve = localbfz;; paramdve = localbfz)
      {
        a(paramdve);
        AppMethodBeat.o(169397);
        return;
        localbfz.LPD.set(paramInt, paramdve);
      }
    }
    
    public static bfz cPD()
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
      bfz localbfz = new bfz();
      try
      {
        localbfz.parseFrom(arrayOfByte);
        AppMethodBeat.o(122577);
        return localbfz;
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
      bfz localbfz = cPD();
      if (localbfz == null)
      {
        AppMethodBeat.o(169398);
        return;
      }
      int i = localbfz.LPD.size() - 1;
      if (i >= 0)
      {
        dve localdve = (dve)localbfz.LPD.get(i);
        if ((localdve == null) || (localdve.LPC.isEmpty())) {
          localbfz.LPD.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          int j = localdve.LPC.size() - 1;
          while (j >= 0)
          {
            Object localObject = localdve.LPC.get(j);
            p.g(localObject, "sessionPath.paths[j]");
            localObject = (bgb)localObject;
            if ((localObject == null) || (((bgb)localObject).LPK.isEmpty()) || (((bgb)localObject).LPL)) {
              localdve.LPC.remove(j);
            }
            j -= 1;
          }
          if (localdve.LPC.isEmpty()) {
            localbfz.LPD.remove(i);
          }
        }
      }
      a(localbfz);
      AppMethodBeat.o(169398);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.d
 * JD-Core Version:    0.7.0.1
 */