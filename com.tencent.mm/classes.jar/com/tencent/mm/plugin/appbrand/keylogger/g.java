package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class g
  implements c
{
  private static final Map<Long, String> lDb;
  private static String lDc;
  private static SimpleDateFormat sDateFormat;
  
  static
  {
    AppMethodBeat.i(192238);
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    lDb = new HashMap();
    AppMethodBeat.o(192238);
  }
  
  private static long RF(String paramString)
  {
    AppMethodBeat.i(192235);
    if (paramString == null)
    {
      AppMethodBeat.o(192235);
      return 0L;
    }
    String[] arrayOfString = paramString.split("-", -1);
    if ((arrayOfString == null) || (arrayOfString.length != 3))
    {
      ad.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", new Object[] { paramString });
      AppMethodBeat.o(192235);
      return 0L;
    }
    paramString = Calendar.getInstance();
    try
    {
      paramString.set(bt.getInt(arrayOfString[0], 0), bt.getInt(arrayOfString[1], 0), bt.getInt(arrayOfString[2], 0));
      long l = paramString.getTimeInMillis();
      AppMethodBeat.o(192235);
      return l;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", new Object[] { paramString });
      AppMethodBeat.o(192235);
    }
    return 0L;
  }
  
  private static String bqv()
  {
    AppMethodBeat.i(192232);
    if (!bt.isNullOrNil(lDc))
    {
      localObject = lDc;
      AppMethodBeat.o(192232);
      return localObject;
    }
    String str = bqw();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(192232);
      return null;
    }
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = String.format("%skeystep/", new Object[] { localObject });
    lDc = (String)localObject;
    AppMethodBeat.o(192232);
    return localObject;
  }
  
  private static String bqw()
  {
    AppMethodBeat.i(192233);
    if (aj.cnC())
    {
      if (!com.tencent.mm.kernel.g.ajx())
      {
        ad.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
        AppMethodBeat.o(192233);
        return null;
      }
      localObject = com.tencent.mm.kernel.g.ajC().cachePath;
      AppMethodBeat.o(192233);
      return localObject;
    }
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), g.a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(192233);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(192233);
    return localObject;
  }
  
  public static void bqx()
  {
    AppMethodBeat.i(192234);
    ad.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
    if (!aj.cnC())
    {
      AppMethodBeat.o(192234);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = aj.fkD().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0L);
    ad.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l1 - l2 < 604800000L)
    {
      AppMethodBeat.o(192234);
      return;
    }
    h.LTJ.f(new g.2(), "MMTempKeyStepLogger#cleanOldLogs");
    AppMethodBeat.o(192234);
  }
  
  private static String sS(long paramLong)
  {
    AppMethodBeat.i(192231);
    if (lDb.containsKey(Long.valueOf(paramLong)))
    {
      str = (String)lDb.get(Long.valueOf(paramLong));
      AppMethodBeat.o(192231);
      return str;
    }
    if (bt.isNullOrNil(bqv()))
    {
      AppMethodBeat.o(192231);
      return null;
    }
    String str = String.format("%s%s/", new Object[] { bqv(), sDateFormat.format(Long.valueOf(paramLong)) });
    m.aLc(str);
    lDb.put(Long.valueOf(paramLong), str);
    AppMethodBeat.o(192231);
    return str;
  }
  
  public final List<String> V(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(192230);
    ArrayList localArrayList = new ArrayList();
    Object localObject = sS(paramLong);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(192230);
      return localArrayList;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).isDirectory())
    {
      AppMethodBeat.o(192230);
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(192230);
      return localArrayList;
    }
    ad.i("MicroMsg.DefaultKeyStepLogger", "collectLogPathsByProcessAndDate : %s", new Object[] { paramString });
    while (i < localObject.length)
    {
      if (localObject[i].getName().startsWith(paramString)) {
        localArrayList.add(localObject[i].getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(192230);
    return localArrayList;
  }
  
  public final void c(final String paramString1, final String paramString2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(192229);
    h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192226);
        String str = String.format(paramString2, paramVarArgs);
        g.dJ(paramString1, str);
        AppMethodBeat.o(192226);
      }
    }, "MMTempKeyStepLogger");
    AppMethodBeat.o(192229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */