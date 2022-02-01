package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.f;
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
  private static final Map<Long, String> pQi;
  private static String pQj;
  private static SimpleDateFormat sDateFormat;
  
  static
  {
    AppMethodBeat.i(243942);
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    pQi = new HashMap();
    AppMethodBeat.o(243942);
  }
  
  private static String Hy(long paramLong)
  {
    AppMethodBeat.i(243929);
    if (pQi.containsKey(Long.valueOf(paramLong)))
    {
      str = (String)pQi.get(Long.valueOf(paramLong));
      AppMethodBeat.o(243929);
      return str;
    }
    if (Util.isNullOrNil(bZi()))
    {
      AppMethodBeat.o(243929);
      return null;
    }
    String str = String.format("%s%s/", new Object[] { bZi(), sDateFormat.format(Long.valueOf(paramLong)) });
    FilePathGenerator.checkMkdir(str);
    pQi.put(Long.valueOf(paramLong), str);
    AppMethodBeat.o(243929);
    return str;
  }
  
  private static long ajP(String paramString)
  {
    AppMethodBeat.i(243937);
    if (paramString == null)
    {
      AppMethodBeat.o(243937);
      return 0L;
    }
    String[] arrayOfString = paramString.split("-", -1);
    if ((arrayOfString == null) || (arrayOfString.length != 3))
    {
      Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", new Object[] { paramString });
      AppMethodBeat.o(243937);
      return 0L;
    }
    paramString = Calendar.getInstance();
    try
    {
      paramString.set(Util.getInt(arrayOfString[0], 0), Util.getInt(arrayOfString[1], 0), Util.getInt(arrayOfString[2], 0));
      long l = paramString.getTimeInMillis();
      AppMethodBeat.o(243937);
      return l;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", new Object[] { paramString });
      AppMethodBeat.o(243937);
    }
    return 0L;
  }
  
  private static String bZi()
  {
    AppMethodBeat.i(243930);
    if (!Util.isNullOrNil(pQj))
    {
      localObject = pQj;
      AppMethodBeat.o(243930);
      return localObject;
    }
    String str = bZj();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(243930);
      return null;
    }
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = String.format("%skeystep/", new Object[] { localObject });
    pQj = (String)localObject;
    AppMethodBeat.o(243930);
    return localObject;
  }
  
  private static String bZj()
  {
    AppMethodBeat.i(243932);
    if (MMApplicationContext.isMMProcess())
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        Log.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
        AppMethodBeat.o(243932);
        return null;
      }
      localObject = com.tencent.mm.kernel.h.aHG().cachePath;
      AppMethodBeat.o(243932);
      return localObject;
    }
    Object localObject = (IPCString)XIPCInvoker.a(MMApplicationContext.getApplicationId(), new IPCVoid(), g.a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(243932);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(243932);
    return localObject;
  }
  
  public static void bZk()
  {
    AppMethodBeat.i(243934);
    Log.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(243934);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = MMApplicationContext.getDefaultPreference().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0L);
    Log.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l1 - l2 < 604800000L)
    {
      AppMethodBeat.o(243934);
      return;
    }
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235080);
        g.access$100();
        MMApplicationContext.getDefaultPreference().edit().putLong("MMTempKeyStepLogger-Last-Clean-Time", System.currentTimeMillis()).commit();
        AppMethodBeat.o(235080);
      }
    }, "MMTempKeyStepLogger#cleanOldLogs");
    AppMethodBeat.o(243934);
  }
  
  public final List<String> V(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(243927);
    ArrayList localArrayList = new ArrayList();
    Object localObject = Hy(paramLong);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(243927);
      return localArrayList;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).isDirectory())
    {
      AppMethodBeat.o(243927);
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(243927);
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
    AppMethodBeat.o(243927);
    return localArrayList;
  }
  
  public final void h(final String paramString1, final String paramString2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(243925);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239882);
        String str = String.format(paramString2, paramVarArgs);
        g.en(paramString1, str);
        AppMethodBeat.o(239882);
      }
    }, "MMTempKeyStepLogger");
    AppMethodBeat.o(243925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */