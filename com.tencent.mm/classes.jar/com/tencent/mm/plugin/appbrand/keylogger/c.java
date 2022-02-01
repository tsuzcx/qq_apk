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
  private static e pPY;
  private static boolean pPZ;
  
  static
  {
    AppMethodBeat.i(210617);
    pPY = new e();
    pPZ = false;
    AppMethodBeat.o(210617);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c paramc)
  {
    AppMethodBeat.i(210591);
    e locale = pPY;
    Log.i("KeyStepLoggerWrapper", "setLoggerDelegate");
    locale.pQd = paramc;
    AppMethodBeat.o(210591);
  }
  
  public static void a(Class paramClass, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210615);
    if (!pPZ)
    {
      AppMethodBeat.o(210615);
      return;
    }
    paramClass = f.aB(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(210615);
      return;
    }
    pPY.h(paramClass, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, "CollectKeyInfo", Integer.valueOf(0), "", paramString2 });
    AppMethodBeat.o(210615);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(210601);
    if (pPZ) {
      pPY.h(parama.bZl(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString, parama.name(), Integer.valueOf(0), "stepStart", "" });
    }
    d.a(paramString, parama);
    AppMethodBeat.o(210601);
  }
  
  private static void a(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(210606);
    if (pPZ) {
      a(parama.bZl(), paramString1, parama.name(), parama.bZm(), paramString2);
    }
    d.e(paramString1, parama);
    AppMethodBeat.o(210606);
  }
  
  public static void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210603);
    e locale;
    String str1;
    String str2;
    if (pPZ)
    {
      pPY.h(parama.bZl(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString2 });
      locale = pPY;
      str1 = parama.bZl();
      str2 = parama.name();
      if (!parama.bZm()) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      locale.h(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), "ok", paramString2 });
      d.a(paramString1, parama, paramLong2 - paramLong1);
      AppMethodBeat.o(210603);
      return;
    }
  }
  
  private static void a(String paramString1, a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(210613);
    if (pPZ) {
      a(parama.bZl(), paramString1, parama.name(), parama.bZm(), paramString2, paramString3);
    }
    d.d(paramString1, parama);
    AppMethodBeat.o(210613);
  }
  
  public static void a(String paramString1, a parama, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210610);
    e locale;
    String str1;
    String str2;
    if (pPZ)
    {
      pPY.h(parama.bZl(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString3 });
      locale = pPY;
      str1 = parama.bZl();
      str2 = parama.name();
      if (!parama.bZm()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      locale.h(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString2 }), paramString3 });
      d.d(paramString1, parama);
      AppMethodBeat.o(210610);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(210607);
    e locale = pPY;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (;;)
    {
      locale.h(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), "ok", paramString4 });
      AppMethodBeat.o(210607);
      return;
      i = 0;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    AppMethodBeat.i(210614);
    e locale = pPY;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.h(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString4 }), paramString5 });
      AppMethodBeat.o(210614);
      return;
    }
  }
  
  public static IKeyStepAnalyser.StepLogInfo ajM(String paramString)
  {
    AppMethodBeat.i(210616);
    paramString = e.ajN(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(210616);
      return null;
    }
    paramString = paramString.split("\\|", -1);
    if (paramString == null)
    {
      Log.w("WeAppKeyLogger", "parse items null");
      AppMethodBeat.o(210616);
      return null;
    }
    if (paramString.length != 6)
    {
      Log.w("WeAppKeyLogger", "parse items length illegal:%d", new Object[] { Integer.valueOf(paramString.length) });
      AppMethodBeat.o(210616);
      return null;
    }
    try
    {
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = new IKeyStepAnalyser.StepLogInfo();
      localStepLogInfo.time = Util.getLong(paramString[0], 0L);
      localStepLogInfo.sessionId = paramString[1];
      localStepLogInfo.pQp = paramString[2];
      if (Util.getInt(paramString[3], 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localStepLogInfo.pQq = bool;
        localStepLogInfo.errMsg = paramString[4];
        localStepLogInfo.pQr = paramString[5];
        AppMethodBeat.o(210616);
        return localStepLogInfo;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.i("WeAppKeyLogger", "parse e:%s", new Object[] { paramString });
      AppMethodBeat.o(210616);
    }
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(293014);
    a(paramString, parama, "");
    AppMethodBeat.o(293014);
  }
  
  public static void b(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(210612);
    a(paramString1, parama, paramString2, "");
    AppMethodBeat.o(210612);
  }
  
  public static void bZg()
  {
    pPZ = true;
  }
  
  public static com.tencent.mm.plugin.appbrand.keylogger.base.c bZh()
  {
    return pPY;
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(210611);
    b(paramString, parama, "");
    AppMethodBeat.o(210611);
  }
  
  public static void d(Class paramClass, String paramString)
  {
    AppMethodBeat.i(210596);
    paramClass = f.f(paramClass, null);
    if (paramClass == null)
    {
      AppMethodBeat.o(210596);
      return;
    }
    a(paramString, ((j)paramClass.get(0)).pQz, "");
    d.el(((j)paramClass.get(0)).pQz.bZl(), paramString);
    AppMethodBeat.o(210596);
  }
  
  public static void e(Class paramClass, String paramString)
  {
    AppMethodBeat.i(210599);
    paramClass = f.f(paramClass, null);
    if (paramClass == null)
    {
      AppMethodBeat.o(210599);
      return;
    }
    a(paramString, ((j)paramClass.get(paramClass.size() - 1)).pQz, "");
    d.em(((j)paramClass.get(0)).pQz.bZl(), paramString);
    AppMethodBeat.o(210599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */