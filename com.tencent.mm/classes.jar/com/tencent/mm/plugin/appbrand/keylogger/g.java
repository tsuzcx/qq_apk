package com.tencent.mm.plugin.appbrand.keylogger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
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
  private static final Map<Long, String> lgd;
  private static String lge;
  private static SimpleDateFormat sDateFormat;
  
  static
  {
    AppMethodBeat.i(206161);
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    lgd = new HashMap();
    AppMethodBeat.o(206161);
  }
  
  private static long Oh(String paramString)
  {
    AppMethodBeat.i(206158);
    if (paramString == null)
    {
      AppMethodBeat.o(206158);
      return 0L;
    }
    String[] arrayOfString = paramString.split("-", -1);
    if ((arrayOfString == null) || (arrayOfString.length != 3))
    {
      ac.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", new Object[] { paramString });
      AppMethodBeat.o(206158);
      return 0L;
    }
    paramString = Calendar.getInstance();
    try
    {
      paramString.set(bs.getInt(arrayOfString[0], 0), bs.getInt(arrayOfString[1], 0), bs.getInt(arrayOfString[2], 0));
      long l = paramString.getTimeInMillis();
      AppMethodBeat.o(206158);
      return l;
    }
    catch (Exception paramString)
    {
      ac.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", new Object[] { paramString });
      AppMethodBeat.o(206158);
    }
    return 0L;
  }
  
  private static String bmK()
  {
    AppMethodBeat.i(206155);
    if (!bs.isNullOrNil(lge))
    {
      localObject = lge;
      AppMethodBeat.o(206155);
      return localObject;
    }
    String str = bmL();
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(206155);
      return null;
    }
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = String.format("%skeystep/", new Object[] { localObject });
    lge = (String)localObject;
    AppMethodBeat.o(206155);
    return localObject;
  }
  
  private static String bmL()
  {
    AppMethodBeat.i(206156);
    if (ai.ciE())
    {
      if (!com.tencent.mm.kernel.g.agM())
      {
        ac.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
        AppMethodBeat.o(206156);
        return null;
      }
      localObject = com.tencent.mm.kernel.g.agR().cachePath;
      AppMethodBeat.o(206156);
      return localObject;
    }
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), g.a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(206156);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(206156);
    return localObject;
  }
  
  public static void bmM()
  {
    AppMethodBeat.i(206157);
    ac.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
    if (!ai.ciE())
    {
      AppMethodBeat.o(206157);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = ai.eUY().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0L);
    ac.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l1 - l2 < 604800000L)
    {
      AppMethodBeat.o(206157);
      return;
    }
    h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206150);
        g.access$100();
        ai.eUY().edit().putLong("MMTempKeyStepLogger-Last-Clean-Time", System.currentTimeMillis()).commit();
        AppMethodBeat.o(206150);
      }
    }, "MMTempKeyStepLogger#cleanOldLogs");
    AppMethodBeat.o(206157);
  }
  
  private static String qT(long paramLong)
  {
    AppMethodBeat.i(206154);
    if (lgd.containsKey(Long.valueOf(paramLong)))
    {
      str = (String)lgd.get(Long.valueOf(paramLong));
      AppMethodBeat.o(206154);
      return str;
    }
    if (bs.isNullOrNil(bmK()))
    {
      AppMethodBeat.o(206154);
      return null;
    }
    String str = String.format("%s%s/", new Object[] { bmK(), sDateFormat.format(Long.valueOf(paramLong)) });
    l.aFC(str);
    lgd.put(Long.valueOf(paramLong), str);
    AppMethodBeat.o(206154);
    return str;
  }
  
  public final List<String> O(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(206153);
    ArrayList localArrayList = new ArrayList();
    Object localObject = qT(paramLong);
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(206153);
      return localArrayList;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).isDirectory())
    {
      AppMethodBeat.o(206153);
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(206153);
      return localArrayList;
    }
    ac.i("MicroMsg.DefaultKeyStepLogger", "collectLogPathsByProcessAndDate : %s", new Object[] { paramString });
    while (i < localObject.length)
    {
      if (localObject[i].getName().startsWith(paramString)) {
        localArrayList.add(localObject[i].getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(206153);
    return localArrayList;
  }
  
  public final void c(final String paramString1, final String paramString2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(206152);
    h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206149);
        String str = String.format(paramString2, paramVarArgs);
        g.dH(paramString1, str);
        AppMethodBeat.o(206149);
      }
    }, "MMTempKeyStepLogger");
    AppMethodBeat.o(206152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */