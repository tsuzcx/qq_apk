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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
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
  private static final Map<Long, String> lHA;
  private static String lHB;
  private static SimpleDateFormat sDateFormat;
  
  static
  {
    AppMethodBeat.i(220811);
    sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    lHA = new HashMap();
    AppMethodBeat.o(220811);
  }
  
  private static long So(String paramString)
  {
    AppMethodBeat.i(220808);
    if (paramString == null)
    {
      AppMethodBeat.o(220808);
      return 0L;
    }
    String[] arrayOfString = paramString.split("-", -1);
    if ((arrayOfString == null) || (arrayOfString.length != 3))
    {
      ae.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", new Object[] { paramString });
      AppMethodBeat.o(220808);
      return 0L;
    }
    paramString = Calendar.getInstance();
    try
    {
      paramString.set(bu.getInt(arrayOfString[0], 0), bu.getInt(arrayOfString[1], 0), bu.getInt(arrayOfString[2], 0));
      long l = paramString.getTimeInMillis();
      AppMethodBeat.o(220808);
      return l;
    }
    catch (Exception paramString)
    {
      ae.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", new Object[] { paramString });
      AppMethodBeat.o(220808);
    }
    return 0L;
  }
  
  private static String brf()
  {
    AppMethodBeat.i(220805);
    if (!bu.isNullOrNil(lHB))
    {
      localObject = lHB;
      AppMethodBeat.o(220805);
      return localObject;
    }
    String str = brg();
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(220805);
      return null;
    }
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = String.format("%skeystep/", new Object[] { localObject });
    lHB = (String)localObject;
    AppMethodBeat.o(220805);
    return localObject;
  }
  
  private static String brg()
  {
    AppMethodBeat.i(220806);
    if (ak.cpe())
    {
      if (!com.tencent.mm.kernel.g.ajM())
      {
        ae.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
        AppMethodBeat.o(220806);
        return null;
      }
      localObject = com.tencent.mm.kernel.g.ajR().cachePath;
      AppMethodBeat.o(220806);
      return localObject;
    }
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", new IPCVoid(), g.a.class);
    if (localObject == null)
    {
      AppMethodBeat.o(220806);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(220806);
    return localObject;
  }
  
  public static void brh()
  {
    AppMethodBeat.i(220807);
    ae.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
    if (!ak.cpe())
    {
      AppMethodBeat.o(220807);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = ak.fox().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0L);
    ae.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l1 - l2 < 604800000L)
    {
      AppMethodBeat.o(220807);
      return;
    }
    h.MqF.f(new g.2(), "MMTempKeyStepLogger#cleanOldLogs");
    AppMethodBeat.o(220807);
  }
  
  private static String tf(long paramLong)
  {
    AppMethodBeat.i(220804);
    if (lHA.containsKey(Long.valueOf(paramLong)))
    {
      str = (String)lHA.get(Long.valueOf(paramLong));
      AppMethodBeat.o(220804);
      return str;
    }
    if (bu.isNullOrNil(brf()))
    {
      AppMethodBeat.o(220804);
      return null;
    }
    String str = String.format("%s%s/", new Object[] { brf(), sDateFormat.format(Long.valueOf(paramLong)) });
    n.aMy(str);
    lHA.put(Long.valueOf(paramLong), str);
    AppMethodBeat.o(220804);
    return str;
  }
  
  public final List<String> V(String paramString, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(220803);
    ArrayList localArrayList = new ArrayList();
    Object localObject = tf(paramLong);
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(220803);
      return localArrayList;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).isDirectory())
    {
      AppMethodBeat.o(220803);
      return localArrayList;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null)
    {
      AppMethodBeat.o(220803);
      return localArrayList;
    }
    ae.i("MicroMsg.DefaultKeyStepLogger", "collectLogPathsByProcessAndDate : %s", new Object[] { paramString });
    while (i < localObject.length)
    {
      if (localObject[i].getName().startsWith(paramString)) {
        localArrayList.add(localObject[i].getAbsolutePath());
      }
      i += 1;
    }
    AppMethodBeat.o(220803);
    return localArrayList;
  }
  
  public final void c(final String paramString1, final String paramString2, final Object... paramVarArgs)
  {
    AppMethodBeat.i(220802);
    h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220799);
        String str = String.format(paramString2, paramVarArgs);
        g.dL(paramString1, str);
        AppMethodBeat.o(220799);
      }
    }, "MMTempKeyStepLogger");
    AppMethodBeat.o(220802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.g
 * JD-Core Version:    0.7.0.1
 */