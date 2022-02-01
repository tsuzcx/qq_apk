package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class c
{
  private static e lCR;
  private static boolean lCS;
  
  static
  {
    AppMethodBeat.i(187685);
    lCR = new e();
    lCS = false;
    AppMethodBeat.o(187685);
  }
  
  public static IKeyStepAnalyser.StepLogInfo RC(String paramString)
  {
    AppMethodBeat.i(187684);
    paramString = e.RD(paramString);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(187684);
      return null;
    }
    paramString = paramString.split("\\|", -1);
    if (paramString == null)
    {
      ad.w("WeAppKeyLogger", "parse items null");
      AppMethodBeat.o(187684);
      return null;
    }
    if (paramString.length != 6)
    {
      ad.w("WeAppKeyLogger", "parse items length illegal:%d", new Object[] { Integer.valueOf(paramString.length) });
      AppMethodBeat.o(187684);
      return null;
    }
    try
    {
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = new IKeyStepAnalyser.StepLogInfo();
      localStepLogInfo.time = bt.getLong(paramString[0], 0L);
      localStepLogInfo.sessionId = paramString[1];
      localStepLogInfo.lDi = paramString[2];
      if (bt.getInt(paramString[3], 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localStepLogInfo.lDj = bool;
        localStepLogInfo.errMsg = paramString[4];
        localStepLogInfo.lDk = paramString[5];
        AppMethodBeat.o(187684);
        return localStepLogInfo;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ad.i("WeAppKeyLogger", "parse e:%s", new Object[] { paramString });
      AppMethodBeat.o(187684);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c paramc)
  {
    AppMethodBeat.i(187670);
    e locale = lCR;
    ad.i("KeyStepLoggerWrapper", "setLoggerDelegate");
    locale.lCW = paramc;
    AppMethodBeat.o(187670);
  }
  
  public static void a(Class paramClass, String paramString)
  {
    AppMethodBeat.i(187671);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(187671);
      return;
    }
    a(paramString, ((j)paramClass.get(0)).lDs, "");
    d.dH(((j)paramClass.get(0)).lDs.bqy(), paramString);
    AppMethodBeat.o(187671);
  }
  
  public static void a(Class paramClass, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187683);
    if (!lCS)
    {
      AppMethodBeat.o(187683);
      return;
    }
    paramClass = f.ay(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(187683);
      return;
    }
    lCR.c(paramClass, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, "CollectKeyInfo", Integer.valueOf(0), "", paramString2 });
    AppMethodBeat.o(187683);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(187675);
    if (lCS) {
      lCR.c(parama.bqy(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString, parama.name(), Integer.valueOf(0), "stepStart", "" });
    }
    d.a(paramString, parama);
    AppMethodBeat.o(187675);
  }
  
  private static void a(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(187676);
    if (lCS) {
      a(parama.bqy(), paramString1, parama.name(), parama.bqz(), paramString2);
    }
    d.e(paramString1, parama);
    AppMethodBeat.o(187676);
  }
  
  public static void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187674);
    e locale;
    String str1;
    String str2;
    if (lCS)
    {
      lCR.c(parama.bqy(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString2 });
      locale = lCR;
      str1 = parama.bqy();
      str2 = parama.name();
      if (!parama.bqz()) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), "ok", paramString2 });
      d.a(paramString1, parama, paramLong2 - paramLong1);
      AppMethodBeat.o(187674);
      return;
    }
  }
  
  private static void a(String paramString1, a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(187681);
    if (lCS) {
      a(parama.bqy(), paramString1, parama.name(), parama.bqz(), paramString2, paramString3);
    }
    d.d(paramString1, parama);
    AppMethodBeat.o(187681);
  }
  
  public static void a(String paramString1, a parama, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187678);
    e locale;
    String str1;
    String str2;
    if (lCS)
    {
      lCR.c(parama.bqy(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString3 });
      locale = lCR;
      str1 = parama.bqy();
      str2 = parama.name();
      if (!parama.bqz()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString2 }), paramString3 });
      d.d(paramString1, parama);
      AppMethodBeat.o(187678);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(187677);
    e locale = lCR;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (;;)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), "ok", paramString4 });
      AppMethodBeat.o(187677);
      return;
      i = 0;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    AppMethodBeat.i(187682);
    e locale = lCR;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString4 }), paramString5 });
      AppMethodBeat.o(187682);
      return;
    }
  }
  
  public static void b(Class paramClass, String paramString)
  {
    AppMethodBeat.i(187672);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(187672);
      return;
    }
    a(paramString, ((j)paramClass.get(paramClass.size() - 1)).lDs, "");
    d.dI(((j)paramClass.get(0)).lDs.bqy(), paramString);
    AppMethodBeat.o(187672);
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(221672);
    a(paramString, parama, "");
    AppMethodBeat.o(221672);
  }
  
  public static void b(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(187680);
    a(paramString1, parama, paramString2, "");
    AppMethodBeat.o(187680);
  }
  
  public static void bqt()
  {
    lCS = true;
  }
  
  public static com.tencent.mm.plugin.appbrand.keylogger.base.c bqu()
  {
    return lCR;
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(187679);
    b(paramString, parama, "");
    AppMethodBeat.o(187679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */