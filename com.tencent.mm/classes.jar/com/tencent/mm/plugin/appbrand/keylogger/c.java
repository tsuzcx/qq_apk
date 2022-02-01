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
  private static e kEA;
  private static boolean kEB;
  
  static
  {
    AppMethodBeat.i(194858);
    kEA = new e();
    kEB = false;
    AppMethodBeat.o(194858);
  }
  
  public static IKeyStepAnalyser.StepLogInfo JX(String paramString)
  {
    AppMethodBeat.i(194857);
    paramString = e.JY(paramString);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(194857);
      return null;
    }
    paramString = paramString.split("\\|", -1);
    if (paramString == null)
    {
      ad.w("WeAppKeyLogger", "parse items null");
      AppMethodBeat.o(194857);
      return null;
    }
    if (paramString.length != 6)
    {
      ad.w("WeAppKeyLogger", "parse items length illegal:%d", new Object[] { Integer.valueOf(paramString.length) });
      AppMethodBeat.o(194857);
      return null;
    }
    try
    {
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = new IKeyStepAnalyser.StepLogInfo();
      localStepLogInfo.time = bt.getLong(paramString[0], 0L);
      localStepLogInfo.sessionId = paramString[1];
      localStepLogInfo.kER = paramString[2];
      if (bt.getInt(paramString[3], 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localStepLogInfo.kES = bool;
        localStepLogInfo.errMsg = paramString[4];
        localStepLogInfo.kET = paramString[5];
        AppMethodBeat.o(194857);
        return localStepLogInfo;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ad.i("WeAppKeyLogger", "parse e:%s", new Object[] { paramString });
      AppMethodBeat.o(194857);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c paramc)
  {
    AppMethodBeat.i(194843);
    e locale = kEA;
    ad.i("KeyStepLoggerWrapper", "setLoggerDelegate");
    locale.kEF = paramc;
    AppMethodBeat.o(194843);
  }
  
  public static void a(Class paramClass, String paramString)
  {
    AppMethodBeat.i(194844);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(194844);
      return;
    }
    a(paramString, ((j)paramClass.get(0)).kFb, "");
    d.dt(((j)paramClass.get(0)).kFb.bfT(), paramString);
    AppMethodBeat.o(194844);
  }
  
  public static void a(Class paramClass, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194856);
    if (!kEB)
    {
      AppMethodBeat.o(194856);
      return;
    }
    paramClass = f.ay(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(194856);
      return;
    }
    kEA.c(paramClass, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, "CollectKeyInfo", Integer.valueOf(0), "", paramString2 });
    AppMethodBeat.o(194856);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(196966);
    if (kEB) {
      kEA.c(parama.bfT(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString, parama.name(), Integer.valueOf(0), "stepStart", "" });
    }
    d.a(paramString, parama);
    AppMethodBeat.o(196966);
  }
  
  private static void a(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(194849);
    if (kEB) {
      a(parama.bfT(), paramString1, parama.name(), parama.bfU(), paramString2);
    }
    d.e(paramString1, parama);
    AppMethodBeat.o(194849);
  }
  
  public static void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194847);
    e locale;
    String str1;
    String str2;
    if (kEB)
    {
      kEA.c(parama.bfT(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString2 });
      locale = kEA;
      str1 = parama.bfT();
      str2 = parama.name();
      if (!parama.bfU()) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), "ok", paramString2 });
      d.a(paramString1, parama, paramLong2 - paramLong1);
      AppMethodBeat.o(194847);
      return;
    }
  }
  
  private static void a(String paramString1, a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194854);
    if (kEB) {
      a(parama.bfT(), paramString1, parama.name(), parama.bfU(), paramString2, paramString3);
    }
    d.d(paramString1, parama);
    AppMethodBeat.o(194854);
  }
  
  public static void a(String paramString1, a parama, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194851);
    e locale;
    String str1;
    String str2;
    if (kEB)
    {
      kEA.c(parama.bfT(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString3 });
      locale = kEA;
      str1 = parama.bfT();
      str2 = parama.name();
      if (!parama.bfU()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString2 }), paramString3 });
      d.d(paramString1, parama);
      AppMethodBeat.o(194851);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(194850);
    e locale = kEA;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (;;)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), "ok", paramString4 });
      AppMethodBeat.o(194850);
      return;
      i = 0;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    AppMethodBeat.i(194855);
    e locale = kEA;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString4 }), paramString5 });
      AppMethodBeat.o(194855);
      return;
    }
  }
  
  public static void b(Class paramClass, String paramString)
  {
    AppMethodBeat.i(194845);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(194845);
      return;
    }
    a(paramString, ((j)paramClass.get(paramClass.size() - 1)).kFb, "");
    d.du(((j)paramClass.get(0)).kFb.bfT(), paramString);
    AppMethodBeat.o(194845);
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(201304);
    a(paramString, parama, "");
    AppMethodBeat.o(201304);
  }
  
  public static void b(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(194853);
    a(paramString1, parama, paramString2, "");
    AppMethodBeat.o(194853);
  }
  
  public static void bfO()
  {
    kEB = true;
  }
  
  public static com.tencent.mm.plugin.appbrand.keylogger.base.c bfP()
  {
    return kEA;
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(194852);
    b(paramString, parama, "");
    AppMethodBeat.o(194852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */