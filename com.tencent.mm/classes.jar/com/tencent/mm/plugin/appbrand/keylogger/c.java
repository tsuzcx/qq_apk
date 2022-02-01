package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class c
{
  private static e sUy;
  private static boolean sUz;
  
  static
  {
    AppMethodBeat.i(319662);
    sUy = new e();
    sUz = false;
    AppMethodBeat.o(319662);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c paramc)
  {
    AppMethodBeat.i(319502);
    e locale = sUy;
    Log.i("KeyStepLoggerWrapper", "setLoggerDelegate");
    locale.sUD = paramc;
    AppMethodBeat.o(319502);
  }
  
  public static void a(Class paramClass, String paramString1, String paramString2)
  {
    AppMethodBeat.i(319644);
    if (!sUz)
    {
      AppMethodBeat.o(319644);
      return;
    }
    paramClass = f.aV(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(319644);
      return;
    }
    sUy.j(paramClass, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, "CollectKeyInfo", Integer.valueOf(0), "", paramString2 });
    AppMethodBeat.o(319644);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(319546);
    if (sUz) {
      sUy.j(parama.czx(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString, parama.name(), Integer.valueOf(0), "stepStart", "" });
    }
    d.a(paramString, parama);
    AppMethodBeat.o(319546);
  }
  
  private static void a(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(319573);
    if (sUz) {
      a(parama.czx(), paramString1, parama.name(), parama.czy(), paramString2);
    }
    d.e(paramString1, parama);
    AppMethodBeat.o(319573);
  }
  
  public static void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(319555);
    e locale;
    String str1;
    String str2;
    if (sUz)
    {
      sUy.j(parama.czx(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString2 });
      locale = sUy;
      str1 = parama.czx();
      str2 = parama.name();
      if (!parama.czy()) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      locale.j(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), "ok", paramString2 });
      d.a(paramString1, parama, paramLong2 - paramLong1);
      AppMethodBeat.o(319555);
      return;
    }
  }
  
  private static void a(String paramString1, a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(319619);
    if (sUz) {
      a(parama.czx(), paramString1, parama.name(), parama.czy(), paramString2, paramString3);
    }
    d.d(paramString1, parama);
    AppMethodBeat.o(319619);
  }
  
  public static void a(String paramString1, a parama, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(319591);
    e locale;
    String str1;
    String str2;
    if (sUz)
    {
      sUy.j(parama.czx(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString3 });
      locale = sUy;
      str1 = parama.czx();
      str2 = parama.name();
      if (!parama.czy()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      locale.j(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString2 }), paramString3 });
      d.d(paramString1, parama);
      AppMethodBeat.o(319591);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(319581);
    e locale = sUy;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (;;)
    {
      locale.j(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), "ok", paramString4 });
      AppMethodBeat.o(319581);
      return;
      i = 0;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    AppMethodBeat.i(319630);
    e locale = sUy;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.j(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString4 }), paramString5 });
      AppMethodBeat.o(319630);
      return;
    }
  }
  
  public static IKeyStepAnalyser.StepLogInfo acM(String paramString)
  {
    AppMethodBeat.i(319655);
    paramString = e.acN(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(319655);
      return null;
    }
    paramString = paramString.split("\\|", -1);
    if (paramString == null)
    {
      Log.w("WeAppKeyLogger", "parse items null");
      AppMethodBeat.o(319655);
      return null;
    }
    if (paramString.length != 6)
    {
      Log.w("WeAppKeyLogger", "parse items length illegal:%d", new Object[] { Integer.valueOf(paramString.length) });
      AppMethodBeat.o(319655);
      return null;
    }
    try
    {
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = new IKeyStepAnalyser.StepLogInfo();
      localStepLogInfo.time = Util.getLong(paramString[0], 0L);
      localStepLogInfo.sessionId = paramString[1];
      localStepLogInfo.sUP = paramString[2];
      if (Util.getInt(paramString[3], 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localStepLogInfo.sUQ = bool;
        localStepLogInfo.errMsg = paramString[4];
        localStepLogInfo.sUR = paramString[5];
        AppMethodBeat.o(319655);
        return localStepLogInfo;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.i("WeAppKeyLogger", "parse e:%s", new Object[] { paramString });
      AppMethodBeat.o(319655);
    }
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(370010);
    a(paramString, parama, "");
    AppMethodBeat.o(370010);
  }
  
  public static void b(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(319612);
    a(paramString1, parama, paramString2, "");
    AppMethodBeat.o(319612);
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(319602);
    b(paramString, parama, "");
    AppMethodBeat.o(319602);
  }
  
  public static void czs()
  {
    sUz = true;
  }
  
  public static com.tencent.mm.plugin.appbrand.keylogger.base.c czt()
  {
    return sUy;
  }
  
  public static void d(Class paramClass, String paramString)
  {
    AppMethodBeat.i(319524);
    paramClass = f.f(paramClass, null);
    if (paramClass == null)
    {
      AppMethodBeat.o(319524);
      return;
    }
    a(paramString, ((j)paramClass.get(0)).sUZ, "");
    d.eE(((j)paramClass.get(0)).sUZ.czx(), paramString);
    AppMethodBeat.o(319524);
  }
  
  public static void e(Class paramClass, String paramString)
  {
    AppMethodBeat.i(319536);
    paramClass = f.f(paramClass, null);
    if (paramClass == null)
    {
      AppMethodBeat.o(319536);
      return;
    }
    a(paramString, ((j)paramClass.get(paramClass.size() - 1)).sUZ, "");
    d.eF(((j)paramClass.get(0)).sUZ.czx(), paramString);
    AppMethodBeat.o(319536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */