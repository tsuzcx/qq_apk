package com.tencent.mm.plugin.expt.hellhound.ext.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a zJW;
  
  static
  {
    AppMethodBeat.i(122581);
    zJW = new a((byte)0);
    AppMethodBeat.o(122581);
  }
  
  public static final void a(cau paramcau)
  {
    AppMethodBeat.i(161614);
    a.a(paramcau);
    AppMethodBeat.o(161614);
  }
  
  public static final void a(String paramString, caw paramcaw, int paramInt)
  {
    AppMethodBeat.i(169400);
    if ((paramString != null) && (paramcaw != null))
    {
      paramString = a.ask(paramString);
      if (paramString != null)
      {
        paramString.aajM.set(paramInt, paramcaw);
        a.a(paramString);
      }
    }
    AppMethodBeat.o(169400);
  }
  
  public static final Pair<caw, Integer> aq(String paramString, long paramLong)
  {
    AppMethodBeat.i(169399);
    paramString = a.ask(paramString);
    int i;
    if (paramString != null)
    {
      i = paramString.aajM.size() - 1;
      if (i < 0) {}
    }
    for (;;)
    {
      int j = i - 1;
      caw localcaw = (caw)paramString.aajM.get(i);
      if (localcaw.aajX == paramLong)
      {
        paramString = Pair.create(localcaw, Integer.valueOf(i));
        AppMethodBeat.o(169399);
        return paramString;
      }
      if (j < 0)
      {
        AppMethodBeat.o(169399);
        return null;
      }
      i = j;
    }
  }
  
  public static final cau dLm()
  {
    AppMethodBeat.i(161613);
    cau localcau = a.dLm();
    AppMethodBeat.o(161613);
    return localcau;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatchDao$Companion;", "", "()V", "KEY_MMKV", "", "TAG", "_read", "", "_write", "", "bytes", "getFuzzyMatchInfo", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchInfo;", "getPaths", "Landroid/util/Pair;", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "", "sessionId", "pagePathId", "", "getSessionFuzzyPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "getSessionFuzzyPath2", "getSessionFuzzyPath3", "reset", "resetOnSessionStart", "curSessionId", "setFuzzyMatchInfo", "info", "updatePaths", "path", "index", "updateSessionMatchInfo", "sessionPath", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(cau paramcau)
    {
      AppMethodBeat.i(122580);
      if (paramcau == null)
      {
        AppMethodBeat.o(122580);
        return;
      }
      try
      {
        paramcau = paramcau.toByteArray();
        if (paramcau == null)
        {
          AppMethodBeat.o(122580);
          return;
        }
      }
      catch (IOException paramcau)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FuzzyMatchDao", (Throwable)paramcau, "FuzzyMatchDao, setFuzzyMatchInfo: %s", new Object[] { paramcau.getMessage() });
        AppMethodBeat.o(122580);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_fuzzy_pgs_io", paramcau);
      AppMethodBeat.o(122580);
    }
    
    public static void a(eyz parameyz)
    {
      AppMethodBeat.i(122579);
      if (parameyz == null)
      {
        AppMethodBeat.o(122579);
        return;
      }
      cau localcau = dLm();
      if (localcau == null)
      {
        localcau = new cau();
        Log.i("HABBYGE-MALI.FuzzyMatchDao", s.X("updateSessionMatchInfo, addNew: ", parameyz.hQR));
        localcau.aajN.addLast(parameyz);
        parameyz = localcau;
        a(parameyz);
        AppMethodBeat.o(122579);
        return;
      }
      int i = localcau.aajN.size() - 1;
      if (i >= 0) {}
      for (;;)
      {
        int j = i - 1;
        eyz localeyz = (eyz)localcau.aajN.get(i);
        if ((localeyz != null) && (s.p(localeyz.hQR, parameyz.hQR))) {
          localcau.aajN.set(i, parameyz);
        }
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            Log.i("HABBYGE-MALI.FuzzyMatchDao", s.X("updateSessionMatchInfo, add: ", parameyz.hQR));
            localcau.aajN.addLast(parameyz);
          }
          parameyz = localcau;
          break;
          if (j >= 0) {
            break label168;
          }
        }
        label168:
        i = j;
      }
    }
    
    public static eyz ask(String paramString)
    {
      AppMethodBeat.i(122578);
      if (paramString == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      cau localcau = dLm();
      if (localcau == null)
      {
        AppMethodBeat.o(122578);
        return null;
      }
      int i = localcau.aajN.size() - 1;
      if (i >= 0) {}
      for (;;)
      {
        int j = i - 1;
        eyz localeyz = (eyz)localcau.aajN.get(i);
        if (s.p(paramString, localeyz.hQR))
        {
          AppMethodBeat.o(122578);
          return localeyz;
        }
        if (j < 0)
        {
          AppMethodBeat.o(122578);
          return null;
        }
        i = j;
      }
    }
    
    public static Pair<eyz, Integer> asl(String paramString)
    {
      AppMethodBeat.i(169396);
      s.u(paramString, "sessionId");
      cau localcau = dLm();
      if (localcau == null) {
        localcau = new cau();
      }
      for (;;)
      {
        int i = localcau.aajN.size() - 1;
        if (i >= 0) {}
        for (;;)
        {
          int j = i - 1;
          Object localObject = localcau.aajN.get(i);
          s.s(localObject, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
          localObject = (eyz)localObject;
          if (s.p(paramString, ((eyz)localObject).hQR))
          {
            paramString = Pair.create(localObject, Integer.valueOf(i));
            s.s(paramString, "create(tmpSessionPath, i)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          if (j < 0)
          {
            paramString = new eyz();
            localcau.aajN.addLast(paramString);
            a(localcau);
            paramString = Pair.create(paramString, Integer.valueOf(localcau.aajN.size() - 1));
            s.s(paramString, "create(tmpSessionPath, f…ssionFuzzyPaths.size - 1)");
            AppMethodBeat.o(169396);
            return paramString;
          }
          i = j;
        }
      }
    }
    
    public static void b(eyz parameyz, int paramInt)
    {
      AppMethodBeat.i(169397);
      if (parameyz == null)
      {
        AppMethodBeat.o(169397);
        return;
      }
      cau localcau = dLm();
      if (localcau == null)
      {
        localcau = new cau();
        localcau.aajN.addLast(parameyz);
      }
      for (parameyz = localcau;; parameyz = localcau)
      {
        a(parameyz);
        AppMethodBeat.o(169397);
        return;
        localcau.aajN.set(paramInt, parameyz);
      }
    }
    
    public static cau dLm()
    {
      AppMethodBeat.i(122577);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("mmkv_fuzzy_pgs_io");
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
      cau localcau = new cau();
      try
      {
        localcau.parseFrom(arrayOfByte);
        AppMethodBeat.o(122577);
        return localcau;
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
      cau localcau = dLm();
      if (localcau == null)
      {
        AppMethodBeat.o(169398);
        return;
      }
      int i = localcau.aajN.size() - 1;
      int k;
      eyz localeyz;
      if (i >= 0)
      {
        k = i - 1;
        localeyz = (eyz)localcau.aajN.get(i);
        if ((localeyz == null) || (localeyz.aajM.isEmpty()))
        {
          localcau.aajN.remove(i);
          label99:
          if (k >= 0) {
            break label215;
          }
        }
      }
      else
      {
        a(localcau);
        AppMethodBeat.o(169398);
        return;
      }
      int j = localeyz.aajM.size() - 1;
      if (j >= 0) {}
      for (;;)
      {
        int m = j - 1;
        Object localObject = localeyz.aajM.get(j);
        s.s(localObject, "sessionPath.paths[j]");
        localObject = (caw)localObject;
        if ((((caw)localObject).aajU.isEmpty()) || (((caw)localObject).aajV)) {
          localeyz.aajM.remove(j);
        }
        if (m < 0)
        {
          if (!localeyz.aajM.isEmpty()) {
            break label99;
          }
          localcau.aajN.remove(i);
          break label99;
          label215:
          i = k;
          break;
        }
        j = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.d.c
 * JD-Core Version:    0.7.0.1
 */