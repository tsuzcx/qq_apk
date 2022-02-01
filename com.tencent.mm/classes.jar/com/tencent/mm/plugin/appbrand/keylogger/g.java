package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
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
  private static SimpleDateFormat sDateFormat;
  private static final Map<Long, String> sUI;
  private static String sUJ;
  
  static
  {
    AppMethodBeat.i(319579);
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    sUI = new HashMap();
    AppMethodBeat.o(319579);
  }
  
  private static long acP(String paramString)
  {
    AppMethodBeat.i(319547);
    if (paramString == null)
    {
      AppMethodBeat.o(319547);
      return 0L;
    }
    String[] arrayOfString = paramString.split("-", -1);
    if ((arrayOfString == null) || (arrayOfString.length != 3))
    {
      Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", new Object[] { paramString });
      AppMethodBeat.o(319547);
      return 0L;
    }
    paramString = Calendar.getInstance();
    try
    {
      paramString.set(Util.getInt(arrayOfString[0], 0), Util.getInt(arrayOfString[1], 0), Util.getInt(arrayOfString[2], 0));
      long l = paramString.getTimeInMillis();
      AppMethodBeat.o(319547);
      return l;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", new Object[] { paramString });
      AppMethodBeat.o(319547);
    }
    return 0L;
  }
  
  private static String czu()
  {
    AppMethodBeat.i(319516);
    if (!Util.isNullOrNil(sUJ))
    {
      localObject = sUJ;
      AppMethodBeat.o(319516);
      return localObject;
    }
    String str = czv();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(319516);
      return null;
    }
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = String.format("%skeystep/", new Object[] { localObject });
    sUJ = (String)localObject;
    AppMethodBeat.o(319516);
    return localObject;
  }
  
  private static String czv()
  {
    AppMethodBeat.i(319523);
    if (MMApplicationContext.isMMProcess())
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        Log.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
        AppMethodBeat.o(319523);
        return null;
      }
      localObject = com.tencent.mm.kernel.h.baE().cachePath;
      AppMethodBeat.o(319523);
      return localObject;
    }
    Object localObject = (IPCString)XIPCInvoker.a(MMApplicationContext.getApplicationId(), new IPCVoid(), a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(319523);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(319523);
    return localObject;
  }
  
  public static void czw()
  {
    AppMethodBeat.i(319537);
    Log.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(319537);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = MMApplicationContext.getDefaultPreference().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0L);
    Log.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l1 - l2 < 604800000L)
    {
      AppMethodBeat.o(319537);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(319445);
        g.access$100();
        MMApplicationContext.getDefaultPreference().edit().putLong("MMTempKeyStepLogger-Last-Clean-Time", System.currentTimeMillis()).commit();
        AppMethodBeat.o(319445);
      }
    }, "MMTempKeyStepLogger#cleanOldLogs");
    AppMethodBeat.o(319537);
  }
  
  private static String jO(long paramLong)
  {
    AppMethodBeat.i(319507);
    if (sUI.containsKey(Long.valueOf(paramLong)))
    {
      str = (String)sUI.get(Long.valueOf(paramLong));
      AppMethodBeat.o(319507);
      return str;
    }
    if (Util.isNullOrNil(czu()))
    {
      AppMethodBeat.o(319507);
      return null;
    }
    String str = String.format("%s%s/", new Object[] { czu(), sDateFormat.format(Long.valueOf(paramLong)) });
    FilePathGenerator.checkMkdir(str);
    sUI.put(Long.valueOf(paramLong), str);
    AppMethodBeat.o(319507);
    return str;
  }
  
  public final List<String> aa(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(319601);
    ArrayList localArrayList = new ArrayList();
    Object localObject = jO(paramLong);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(319601);
      return localArrayList;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).isDirectory())
    {
      AppMethodBeat.o(319601);
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(319601);
      return localArrayList;
    }
    Log.i("MicroMsg.DefaultKeyStepLogger", "collectLogPathsByProcessAndDate : %s", new Object[] { paramString });
    while (i < localObject.length)
    {
      if (localObject[i].getName().startsWith(paramString)) {
        localArrayList.add(localObject[i].getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(319601);
    return localArrayList;
  }
  
  public final void j(final String paramString1, final String paramString2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(319588);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(319451);
        String str = String.format(paramString2, paramVarArgs);
        g.eG(paramString1, str);
        AppMethodBeat.o(319451);
      }
    }, "MMTempKeyStepLogger");
    AppMethodBeat.o(319588);
  }
  
  static final class a
    implements m<IPCVoid, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */