package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class c
{
  private static e lHq;
  private static boolean lHr;
  
  static
  {
    AppMethodBeat.i(201252);
    lHq = new e();
    lHr = false;
    AppMethodBeat.o(201252);
  }
  
  public static IKeyStepAnalyser.StepLogInfo Sl(String paramString)
  {
    AppMethodBeat.i(201251);
    paramString = e.Sm(paramString);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(201251);
      return null;
    }
    paramString = paramString.split("\\|", -1);
    if (paramString == null)
    {
      ae.w("WeAppKeyLogger", "parse items null");
      AppMethodBeat.o(201251);
      return null;
    }
    if (paramString.length != 6)
    {
      ae.w("WeAppKeyLogger", "parse items length illegal:%d", new Object[] { Integer.valueOf(paramString.length) });
      AppMethodBeat.o(201251);
      return null;
    }
    try
    {
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = new IKeyStepAnalyser.StepLogInfo();
      localStepLogInfo.time = bu.getLong(paramString[0], 0L);
      localStepLogInfo.sessionId = paramString[1];
      localStepLogInfo.lHH = paramString[2];
      if (bu.getInt(paramString[3], 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localStepLogInfo.lHI = bool;
        localStepLogInfo.errMsg = paramString[4];
        localStepLogInfo.lHJ = paramString[5];
        AppMethodBeat.o(201251);
        return localStepLogInfo;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ae.i("WeAppKeyLogger", "parse e:%s", new Object[] { paramString });
      AppMethodBeat.o(201251);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c paramc)
  {
    AppMethodBeat.i(201237);
    e locale = lHq;
    ae.i("KeyStepLoggerWrapper", "setLoggerDelegate");
    locale.lHv = paramc;
    AppMethodBeat.o(201237);
  }
  
  public static void a(Class paramClass, String paramString)
  {
    AppMethodBeat.i(201238);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(201238);
      return;
    }
    a(paramString, ((j)paramClass.get(0)).lHR, "");
    d.dJ(((j)paramClass.get(0)).lHR.bri(), paramString);
    AppMethodBeat.o(201238);
  }
  
  public static void a(Class paramClass, String paramString1, String paramString2)
  {
    AppMethodBeat.i(201250);
    if (!lHr)
    {
      AppMethodBeat.o(201250);
      return;
    }
    paramClass = f.ay(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(201250);
      return;
    }
    lHq.c(paramClass, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, "CollectKeyInfo", Integer.valueOf(0), "", paramString2 });
    AppMethodBeat.o(201250);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(201242);
    if (lHr) {
      lHq.c(parama.bri(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString, parama.name(), Integer.valueOf(0), "stepStart", "" });
    }
    d.a(paramString, parama);
    AppMethodBeat.o(201242);
  }
  
  private static void a(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(201243);
    if (lHr) {
      a(parama.bri(), paramString1, parama.name(), parama.brj(), paramString2);
    }
    d.e(paramString1, parama);
    AppMethodBeat.o(201243);
  }
  
  public static void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201241);
    e locale;
    String str1;
    String str2;
    if (lHr)
    {
      lHq.c(parama.bri(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString2 });
      locale = lHq;
      str1 = parama.bri();
      str2 = parama.name();
      if (!parama.brj()) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), "ok", paramString2 });
      d.a(paramString1, parama, paramLong2 - paramLong1);
      AppMethodBeat.o(201241);
      return;
    }
  }
  
  private static void a(String paramString1, a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(201248);
    if (lHr) {
      a(parama.bri(), paramString1, parama.name(), parama.brj(), paramString2, paramString3);
    }
    d.d(paramString1, parama);
    AppMethodBeat.o(201248);
  }
  
  public static void a(String paramString1, a parama, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201245);
    e locale;
    String str1;
    String str2;
    if (lHr)
    {
      lHq.c(parama.bri(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString3 });
      locale = lHq;
      str1 = parama.bri();
      str2 = parama.name();
      if (!parama.brj()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString2 }), paramString3 });
      d.d(paramString1, parama);
      AppMethodBeat.o(201245);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(201244);
    e locale = lHq;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (;;)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), "ok", paramString4 });
      AppMethodBeat.o(201244);
      return;
      i = 0;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    AppMethodBeat.i(201249);
    e locale = lHq;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString4 }), paramString5 });
      AppMethodBeat.o(201249);
      return;
    }
  }
  
  public static void b(Class paramClass, String paramString)
  {
    AppMethodBeat.i(201239);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(201239);
      return;
    }
    a(paramString, ((j)paramClass.get(paramClass.size() - 1)).lHR, "");
    d.dK(((j)paramClass.get(0)).lHR.bri(), paramString);
    AppMethodBeat.o(201239);
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(224448);
    a(paramString, parama, "");
    AppMethodBeat.o(224448);
  }
  
  public static void b(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(201247);
    a(paramString1, parama, paramString2, "");
    AppMethodBeat.o(201247);
  }
  
  public static void brd()
  {
    lHr = true;
  }
  
  public static com.tencent.mm.plugin.appbrand.keylogger.base.c bre()
  {
    return lHq;
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(201246);
    b(paramString, parama, "");
    AppMethodBeat.o(201246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */