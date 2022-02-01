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
  private static final Map<Long, String> kEK;
  private static String kEL;
  private static SimpleDateFormat sDateFormat;
  
  static
  {
    AppMethodBeat.i(186896);
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    kEK = new HashMap();
    AppMethodBeat.o(186896);
  }
  
  private static long Ka(String paramString)
  {
    AppMethodBeat.i(186893);
    if (paramString == null)
    {
      AppMethodBeat.o(186893);
      return 0L;
    }
    String[] arrayOfString = paramString.split("-", -1);
    if ((arrayOfString == null) || (arrayOfString.length != 3))
    {
      ad.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", new Object[] { paramString });
      AppMethodBeat.o(186893);
      return 0L;
    }
    paramString = Calendar.getInstance();
    try
    {
      paramString.set(bt.getInt(arrayOfString[0], 0), bt.getInt(arrayOfString[1], 0), bt.getInt(arrayOfString[2], 0));
      long l = paramString.getTimeInMillis();
      AppMethodBeat.o(186893);
      return l;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", new Object[] { paramString });
      AppMethodBeat.o(186893);
    }
    return 0L;
  }
  
  private static String bfQ()
  {
    AppMethodBeat.i(186890);
    if (!bt.isNullOrNil(kEL))
    {
      localObject = kEL;
      AppMethodBeat.o(186890);
      return localObject;
    }
    String str = bfR();
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(186890);
      return null;
    }
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = String.format("%skeystep/", new Object[] { localObject });
    kEL = (String)localObject;
    AppMethodBeat.o(186890);
    return localObject;
  }
  
  private static String bfR()
  {
    AppMethodBeat.i(186891);
    if (aj.cbv())
    {
      if (!com.tencent.mm.kernel.g.afw())
      {
        ad.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
        AppMethodBeat.o(186891);
        return null;
      }
      localObject = com.tencent.mm.kernel.g.afB().cachePath;
      AppMethodBeat.o(186891);
      return localObject;
    }
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), g.a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(186891);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(186891);
    return localObject;
  }
  
  public static void bfS()
  {
    AppMethodBeat.i(186892);
    ad.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
    if (!aj.cbv())
    {
      AppMethodBeat.o(186892);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = aj.eFE().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0L);
    ad.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l1 - l2 < 604800000L)
    {
      AppMethodBeat.o(186892);
      return;
    }
    h.Iye.f(new g.2(), "MMTempKeyStepLogger#cleanOldLogs");
    AppMethodBeat.o(186892);
  }
  
  private static String nh(long paramLong)
  {
    AppMethodBeat.i(186889);
    if (kEK.containsKey(Long.valueOf(paramLong)))
    {
      str = (String)kEK.get(Long.valueOf(paramLong));
      AppMethodBeat.o(186889);
      return str;
    }
    if (bt.isNullOrNil(bfQ()))
    {
      AppMethodBeat.o(186889);
      return null;
    }
    String str = String.format("%s%s/", new Object[] { bfQ(), sDateFormat.format(Long.valueOf(paramLong)) });
    l.aAk(str);
    kEK.put(Long.valueOf(paramLong), str);
    AppMethodBeat.o(186889);
    return str;
  }
  
  public final List<String> N(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(186888);
    ArrayList localArrayList = new ArrayList();
    Object localObject = nh(paramLong);
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(186888);
      return localArrayList;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).isDirectory())
    {
      AppMethodBeat.o(186888);
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(186888);
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
    AppMethodBeat.o(186888);
    return localArrayList;
  }
  
  public final void c(final String paramString1, final String paramString2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(186887);
    h.Iye.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186884);
        String str = String.format(paramString2, paramVarArgs);
        g.dv(paramString1, str);
        AppMethodBeat.o(186884);
      }
    }, "MMTempKeyStepLogger");
    AppMethodBeat.o(186887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */