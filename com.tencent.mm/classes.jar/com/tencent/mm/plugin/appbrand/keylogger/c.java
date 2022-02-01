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
  private static e mPf;
  private static boolean mPg;
  
  static
  {
    AppMethodBeat.i(221296);
    mPf = new e();
    mPg = false;
    AppMethodBeat.o(221296);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c paramc)
  {
    AppMethodBeat.i(221281);
    e locale = mPf;
    Log.i("KeyStepLoggerWrapper", "setLoggerDelegate");
    locale.mPk = paramc;
    AppMethodBeat.o(221281);
  }
  
  public static void a(Class paramClass, String paramString1, String paramString2)
  {
    AppMethodBeat.i(221294);
    if (!mPg)
    {
      AppMethodBeat.o(221294);
      return;
    }
    paramClass = f.aC(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(221294);
      return;
    }
    mPf.g(paramClass, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, "CollectKeyInfo", Integer.valueOf(0), "", paramString2 });
    AppMethodBeat.o(221294);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(221284);
    if (mPg) {
      mPf.g(parama.bMU(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString, parama.name(), Integer.valueOf(0), "stepStart", "" });
    }
    d.a(paramString, parama);
    AppMethodBeat.o(221284);
  }
  
  private static void a(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(221287);
    if (mPg) {
      a(parama.bMU(), paramString1, parama.name(), parama.bMV(), paramString2);
    }
    d.e(paramString1, parama);
    AppMethodBeat.o(221287);
  }
  
  public static void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221285);
    e locale;
    String str1;
    String str2;
    if (mPg)
    {
      mPf.g(parama.bMU(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString2 });
      locale = mPf;
      str1 = parama.bMU();
      str2 = parama.name();
      if (!parama.bMV()) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      locale.g(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), "ok", paramString2 });
      d.a(paramString1, parama, paramLong2 - paramLong1);
      AppMethodBeat.o(221285);
      return;
    }
  }
  
  private static void a(String paramString1, a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221292);
    if (mPg) {
      a(parama.bMU(), paramString1, parama.name(), parama.bMV(), paramString2, paramString3);
    }
    d.d(paramString1, parama);
    AppMethodBeat.o(221292);
  }
  
  public static void a(String paramString1, a parama, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221289);
    e locale;
    String str1;
    String str2;
    if (mPg)
    {
      mPf.g(parama.bMU(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString3 });
      locale = mPf;
      str1 = parama.bMU();
      str2 = parama.name();
      if (!parama.bMV()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      locale.g(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString2 }), paramString3 });
      d.d(paramString1, parama);
      AppMethodBeat.o(221289);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(221288);
    e locale = mPf;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (;;)
    {
      locale.g(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), "ok", paramString4 });
      AppMethodBeat.o(221288);
      return;
      i = 0;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    AppMethodBeat.i(221293);
    e locale = mPf;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.g(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString4 }), paramString5 });
      AppMethodBeat.o(221293);
      return;
    }
  }
  
  public static IKeyStepAnalyser.StepLogInfo abR(String paramString)
  {
    AppMethodBeat.i(221295);
    paramString = e.abS(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(221295);
      return null;
    }
    paramString = paramString.split("\\|", -1);
    if (paramString == null)
    {
      Log.w("WeAppKeyLogger", "parse items null");
      AppMethodBeat.o(221295);
      return null;
    }
    if (paramString.length != 6)
    {
      Log.w("WeAppKeyLogger", "parse items length illegal:%d", new Object[] { Integer.valueOf(paramString.length) });
      AppMethodBeat.o(221295);
      return null;
    }
    try
    {
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = new IKeyStepAnalyser.StepLogInfo();
      localStepLogInfo.time = Util.getLong(paramString[0], 0L);
      localStepLogInfo.sessionId = paramString[1];
      localStepLogInfo.mPw = paramString[2];
      if (Util.getInt(paramString[3], 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localStepLogInfo.mPx = bool;
        localStepLogInfo.errMsg = paramString[4];
        localStepLogInfo.mPy = paramString[5];
        AppMethodBeat.o(221295);
        return localStepLogInfo;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.i("WeAppKeyLogger", "parse e:%s", new Object[] { paramString });
      AppMethodBeat.o(221295);
    }
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(258651);
    a(paramString, parama, "");
    AppMethodBeat.o(258651);
  }
  
  public static void b(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(221291);
    a(paramString1, parama, paramString2, "");
    AppMethodBeat.o(221291);
  }
  
  public static void bMP()
  {
    mPg = true;
  }
  
  public static com.tencent.mm.plugin.appbrand.keylogger.base.c bMQ()
  {
    return mPf;
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(221290);
    b(paramString, parama, "");
    AppMethodBeat.o(221290);
  }
  
  public static void e(Class paramClass, String paramString)
  {
    AppMethodBeat.i(221282);
    paramClass = f.g(paramClass, null);
    if (paramClass == null)
    {
      AppMethodBeat.o(221282);
      return;
    }
    a(paramString, ((j)paramClass.get(0)).mPG, "");
    d.ea(((j)paramClass.get(0)).mPG.bMU(), paramString);
    AppMethodBeat.o(221282);
  }
  
  public static void f(Class paramClass, String paramString)
  {
    AppMethodBeat.i(221283);
    paramClass = f.g(paramClass, null);
    if (paramClass == null)
    {
      AppMethodBeat.o(221283);
      return;
    }
    a(paramString, ((j)paramClass.get(paramClass.size() - 1)).mPG, "");
    d.eb(((j)paramClass.get(0)).mPG.bMU(), paramString);
    AppMethodBeat.o(221283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */