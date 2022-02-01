package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class c
{
  private static e lfT;
  private static boolean lfU;
  
  static
  {
    AppMethodBeat.i(201013);
    lfT = new e();
    lfU = false;
    AppMethodBeat.o(201013);
  }
  
  public static IKeyStepAnalyser.StepLogInfo Oe(String paramString)
  {
    AppMethodBeat.i(201012);
    paramString = e.Of(paramString);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(201012);
      return null;
    }
    paramString = paramString.split("\\|", -1);
    if (paramString == null)
    {
      ac.w("WeAppKeyLogger", "parse items null");
      AppMethodBeat.o(201012);
      return null;
    }
    if (paramString.length != 6)
    {
      ac.w("WeAppKeyLogger", "parse items length illegal:%d", new Object[] { Integer.valueOf(paramString.length) });
      AppMethodBeat.o(201012);
      return null;
    }
    try
    {
      IKeyStepAnalyser.StepLogInfo localStepLogInfo = new IKeyStepAnalyser.StepLogInfo();
      localStepLogInfo.time = bs.getLong(paramString[0], 0L);
      localStepLogInfo.sessionId = paramString[1];
      localStepLogInfo.lgk = paramString[2];
      if (bs.getInt(paramString[3], 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localStepLogInfo.lgl = bool;
        localStepLogInfo.errMsg = paramString[4];
        localStepLogInfo.lgm = paramString[5];
        AppMethodBeat.o(201012);
        return localStepLogInfo;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ac.i("WeAppKeyLogger", "parse e:%s", new Object[] { paramString });
      AppMethodBeat.o(201012);
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.keylogger.base.c paramc)
  {
    AppMethodBeat.i(200998);
    e locale = lfT;
    ac.i("KeyStepLoggerWrapper", "setLoggerDelegate");
    locale.lfY = paramc;
    AppMethodBeat.o(200998);
  }
  
  public static void a(Class paramClass, String paramString)
  {
    AppMethodBeat.i(200999);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(200999);
      return;
    }
    a(paramString, ((j)paramClass.get(0)).lgu, "");
    d.dF(((j)paramClass.get(0)).lgu.bmN(), paramString);
    AppMethodBeat.o(200999);
  }
  
  public static void a(Class paramClass, String paramString1, String paramString2)
  {
    AppMethodBeat.i(201011);
    if (!lfU)
    {
      AppMethodBeat.o(201011);
      return;
    }
    paramClass = f.ay(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(201011);
      return;
    }
    lfT.c(paramClass, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString1, "CollectKeyInfo", Integer.valueOf(0), "", paramString2 });
    AppMethodBeat.o(201011);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(201003);
    if (lfU) {
      lfT.c(parama.bmN(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(System.currentTimeMillis()), paramString, parama.name(), Integer.valueOf(0), "stepStart", "" });
    }
    d.a(paramString, parama);
    AppMethodBeat.o(201003);
  }
  
  private static void a(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(201004);
    if (lfU) {
      a(parama.bmN(), paramString1, parama.name(), parama.bmO(), paramString2);
    }
    d.e(paramString1, parama);
    AppMethodBeat.o(201004);
  }
  
  public static void a(String paramString1, a parama, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201002);
    e locale;
    String str1;
    String str2;
    if (lfU)
    {
      lfT.c(parama.bmN(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString2 });
      locale = lfT;
      str1 = parama.bmN();
      str2 = parama.name();
      if (!parama.bmO()) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), "ok", paramString2 });
      d.a(paramString1, parama, paramLong2 - paramLong1);
      AppMethodBeat.o(201002);
      return;
    }
  }
  
  private static void a(String paramString1, a parama, String paramString2, String paramString3)
  {
    AppMethodBeat.i(201009);
    if (lfU) {
      a(parama.bmN(), paramString1, parama.name(), parama.bmO(), paramString2, paramString3);
    }
    d.d(paramString1, parama);
    AppMethodBeat.o(201009);
  }
  
  public static void a(String paramString1, a parama, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201006);
    e locale;
    String str1;
    String str2;
    if (lfU)
    {
      lfT.c(parama.bmN(), "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong1), paramString1, parama.name(), Integer.valueOf(0), "stepStart", paramString3 });
      locale = lfT;
      str1 = parama.bmN();
      str2 = parama.name();
      if (!parama.bmO()) {
        break label170;
      }
    }
    label170:
    for (int i = 1;; i = 0)
    {
      locale.c(str1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(paramLong2), paramString1, str2, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString2 }), paramString3 });
      d.d(paramString1, parama);
      AppMethodBeat.o(201006);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    int i = 1;
    AppMethodBeat.i(201005);
    e locale = lfT;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (;;)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), "ok", paramString4 });
      AppMethodBeat.o(201005);
      return;
      i = 0;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    AppMethodBeat.i(201010);
    e locale = lfT;
    long l = System.currentTimeMillis();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      locale.c(paramString1, "%d|%s|%s|%d|%s|%s", new Object[] { Long.valueOf(l), paramString2, paramString3, Integer.valueOf(i), String.format("fail:%s", new Object[] { paramString4 }), paramString5 });
      AppMethodBeat.o(201010);
      return;
    }
  }
  
  public static void b(Class paramClass, String paramString)
  {
    AppMethodBeat.i(201000);
    paramClass = f.az(paramClass);
    if (paramClass == null)
    {
      AppMethodBeat.o(201000);
      return;
    }
    a(paramString, ((j)paramClass.get(paramClass.size() - 1)).lgu, "");
    d.dG(((j)paramClass.get(0)).lgu.bmN(), paramString);
    AppMethodBeat.o(201000);
  }
  
  public static void b(String paramString, a parama)
  {
    AppMethodBeat.i(210332);
    a(paramString, parama, "");
    AppMethodBeat.o(210332);
  }
  
  public static void b(String paramString1, a parama, String paramString2)
  {
    AppMethodBeat.i(201008);
    a(paramString1, parama, paramString2, "");
    AppMethodBeat.o(201008);
  }
  
  public static void bmI()
  {
    lfU = true;
  }
  
  public static com.tencent.mm.plugin.appbrand.keylogger.base.c bmJ()
  {
    return lfT;
  }
  
  public static void c(String paramString, a parama)
  {
    AppMethodBeat.i(201007);
    b(paramString, parama, "");
    AppMethodBeat.o(201007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.c
 * JD-Core Version:    0.7.0.1
 */