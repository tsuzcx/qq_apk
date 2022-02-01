package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static final Map<Long, String> mPp;
  private static String mPq;
  private static SimpleDateFormat sDateFormat;
  
  static
  {
    AppMethodBeat.i(229920);
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    mPp = new HashMap();
    AppMethodBeat.o(229920);
  }
  
  private static String Bk(long paramLong)
  {
    AppMethodBeat.i(229913);
    if (mPp.containsKey(Long.valueOf(paramLong)))
    {
      str = (String)mPp.get(Long.valueOf(paramLong));
      AppMethodBeat.o(229913);
      return str;
    }
    if (Util.isNullOrNil(bMR()))
    {
      AppMethodBeat.o(229913);
      return null;
    }
    String str = String.format("%s%s/", new Object[] { bMR(), sDateFormat.format(Long.valueOf(paramLong)) });
    FilePathGenerator.checkMkdir(str);
    mPp.put(Long.valueOf(paramLong), str);
    AppMethodBeat.o(229913);
    return str;
  }
  
  private static long abU(String paramString)
  {
    AppMethodBeat.i(229917);
    if (paramString == null)
    {
      AppMethodBeat.o(229917);
      return 0L;
    }
    String[] arrayOfString = paramString.split("-", -1);
    if ((arrayOfString == null) || (arrayOfString.length != 3))
    {
      Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", new Object[] { paramString });
      AppMethodBeat.o(229917);
      return 0L;
    }
    paramString = Calendar.getInstance();
    try
    {
      paramString.set(Util.getInt(arrayOfString[0], 0), Util.getInt(arrayOfString[1], 0), Util.getInt(arrayOfString[2], 0));
      long l = paramString.getTimeInMillis();
      AppMethodBeat.o(229917);
      return l;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", new Object[] { paramString });
      AppMethodBeat.o(229917);
    }
    return 0L;
  }
  
  private static String bMR()
  {
    AppMethodBeat.i(229914);
    if (!Util.isNullOrNil(mPq))
    {
      localObject = mPq;
      AppMethodBeat.o(229914);
      return localObject;
    }
    String str = bMS();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(229914);
      return null;
    }
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = String.format("%skeystep/", new Object[] { localObject });
    mPq = (String)localObject;
    AppMethodBeat.o(229914);
    return localObject;
  }
  
  private static String bMS()
  {
    AppMethodBeat.i(229915);
    if (MMApplicationContext.isMMProcess())
    {
      if (!com.tencent.mm.kernel.g.aAc())
      {
        Log.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
        AppMethodBeat.o(229915);
        return null;
      }
      localObject = com.tencent.mm.kernel.g.aAh().cachePath;
      AppMethodBeat.o(229915);
      return localObject;
    }
    Object localObject = (IPCString)XIPCInvoker.a(MMApplicationContext.getApplicationId(), new IPCVoid(), g.a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(229915);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(229915);
    return localObject;
  }
  
  public static void bMT()
  {
    AppMethodBeat.i(229916);
    Log.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(229916);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = MMApplicationContext.getDefaultPreference().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0L);
    Log.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l1 - l2 < 604800000L)
    {
      AppMethodBeat.o(229916);
      return;
    }
    h.RTc.b(new g.2(), "MMTempKeyStepLogger#cleanOldLogs");
    AppMethodBeat.o(229916);
  }
  
  public final List<String> V(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(229912);
    ArrayList localArrayList = new ArrayList();
    Object localObject = Bk(paramLong);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(229912);
      return localArrayList;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).isDirectory())
    {
      AppMethodBeat.o(229912);
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(229912);
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
    AppMethodBeat.o(229912);
    return localArrayList;
  }
  
  public final void g(final String paramString1, final String paramString2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(229911);
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(229908);
        String str = String.format(paramString2, paramVarArgs);
        g.ec(paramString1, str);
        AppMethodBeat.o(229908);
      }
    }, "MMTempKeyStepLogger");
    AppMethodBeat.o(229911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */