package com.tencent.mm.performance.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
  implements Application.ActivityLifecycleCallbacks, Runnable
{
  private static final a gij;
  private volatile String activity;
  public boolean bSe = true;
  private boolean gik = true;
  private int gil = 0;
  public int gim;
  public int gin;
  private long gio = 0L;
  private boolean gip = false;
  
  static
  {
    AppMethodBeat.i(76881);
    gij = new a();
    AppMethodBeat.o(76881);
  }
  
  public static a aob()
  {
    return gij;
  }
  
  private void aoc()
  {
    AppMethodBeat.i(76873);
    d.ysm.execute(new a.1(this));
    AppMethodBeat.o(76873);
  }
  
  private boolean aod()
  {
    AppMethodBeat.i(76877);
    long l = SystemClock.uptimeMillis();
    if (l - this.gio > 5000L) {}
    for (boolean bool = true;; bool = false)
    {
      this.gio = l;
      AppMethodBeat.o(76877);
      return bool;
    }
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(76875);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label61;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label61:
    AppMethodBeat.o(76875);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(76875);
    return paramInputStream;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(76876);
    paramString = new File(paramString);
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null) {
        break label50;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localFileInputStream);
        localFileInputStream.close();
        AppMethodBeat.o(76876);
        return paramString;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label50:
    AppMethodBeat.o(76876);
    throw paramString;
  }
  
  private static String getVmSize()
  {
    AppMethodBeat.i(76874);
    Object localObject = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      localObject = getStringFromFile((String)localObject).trim().split("\n");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        boolean bool = str.startsWith("VmSize");
        if (bool)
        {
          AppMethodBeat.o(76874);
          return str;
        }
        i += 1;
      }
      ab.w("MicroMsg.MemoryWatchDog", "[getVmSize] Wrong!", new Object[] { localObject[12] });
      localObject = localObject[12];
      AppMethodBeat.o(76874);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(76874);
    }
    return "";
  }
  
  public final a dr(boolean paramBoolean)
  {
    AppMethodBeat.i(76872);
    long l = System.currentTimeMillis();
    a locala = new a();
    if (this.activity != null) {
      locala.activity = this.activity;
    }
    locala.giy = this.gim;
    locala.giz = this.gin;
    try
    {
      if ((Build.VERSION.SDK_INT >= 23) && (paramBoolean))
      {
        localObject1 = new Debug.MemoryInfo();
        Debug.getMemoryInfo((Debug.MemoryInfo)localObject1);
        locala.map = ((Debug.MemoryInfo)localObject1).getMemoryStats();
      }
      Object localObject1 = Pattern.compile("\\d+").matcher(getVmSize());
      if (((Matcher)localObject1).find()) {
        locala.gir = bo.apV(((Matcher)localObject1).group());
      }
      locala.gis = Debug.getNativeHeapSize();
      locala.git = Debug.getNativeHeapAllocatedSize();
      locala.giu = Debug.getNativeHeapFreeSize();
      locala.giv = Runtime.getRuntime().totalMemory();
      locala.giw = Runtime.getRuntime().freeMemory();
      locala.gix = Runtime.getRuntime().maxMemory();
      return locala;
    }
    finally
    {
      locala.giA = (System.currentTimeMillis() - l);
      if ((locala.giA > 30L) && (this.gik))
      {
        this.gil += 1;
        if (this.gil > 10) {
          this.gik = false;
        }
      }
      AppMethodBeat.o(76872);
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(76878);
    this.activity = paramActivity.getClass().getSimpleName();
    if (aod())
    {
      if (this.gik)
      {
        ab.i("MicroMsg.MemoryWatchDog", "[onActivityResumed] activity:%s %s", new Object[] { this.activity, dr(false) });
        AppMethodBeat.o(76878);
        return;
      }
      aoc();
    }
    AppMethodBeat.o(76878);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(76879);
    if (aod())
    {
      if (this.gik)
      {
        ab.i("MicroMsg.MemoryWatchDog", "[onActivityStopped] activity:%s %s", new Object[] { paramActivity.getClass().getSimpleName(), dr(false) });
        AppMethodBeat.o(76879);
        return;
      }
      aoc();
    }
    AppMethodBeat.o(76879);
  }
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(76880);
    Object localObject1 = dr(true);
    ab.i("MicroMsg.MemoryWatchDog", "[AutoCheck] %s", new Object[] { localObject1 });
    Object localObject2 = new ArrayList();
    Object localObject3 = new IDKey();
    ((IDKey)localObject3).SetID(959);
    ((IDKey)localObject3).SetValue(1L);
    if (((a)localObject1).giv - ((a)localObject1).giw < 104857600L)
    {
      ((IDKey)localObject3).SetKey(120);
      ((ArrayList)localObject2).add(localObject3);
      localObject3 = new IDKey();
      ((IDKey)localObject3).SetID(959);
      ((IDKey)localObject3).SetValue(1L);
      if (((a)localObject1).git >= 104857600L) {
        break label794;
      }
      ((IDKey)localObject3).SetKey(131);
      label140:
      ((ArrayList)localObject2).add(localObject3);
      localObject3 = new IDKey();
      ((IDKey)localObject3).SetID(959);
      ((IDKey)localObject3).SetValue(1L);
      if (((a)localObject1).gir >= 2097152) {
        break label966;
      }
      ((IDKey)localObject3).SetKey(142);
      label190:
      if (((a)localObject1).gir >= 3858759.8F)
      {
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(959);
        localIDKey.SetValue(1L);
        localIDKey.SetKey(149);
        ((ArrayList)localObject2).add(localIDKey);
      }
      ((ArrayList)localObject2).add(localObject3);
      localObject3 = new IDKey();
      ((IDKey)localObject3).SetID(959);
      ((IDKey)localObject3).SetValue(1L);
      ((IDKey)localObject3).SetKey(151);
      ((ArrayList)localObject2).add(localObject3);
      com.tencent.mm.plugin.report.e.qrI.b((ArrayList)localObject2, false);
      int k = Integer.decode(f.CLIENT_VERSION).intValue();
      int i = j;
      if ((k & 0xFF) >= 48)
      {
        i = j;
        if ((k & 0xFF) <= 95) {
          i = 1;
        }
      }
      if ((i == 0) && (!this.gip) && (((a)localObject1).gir > 3984588.8F))
      {
        com.tencent.mm.plugin.report.e.qrI.g("MicroMsg.MemoryWatchDog", ((a)localObject1).toString(), null);
        localObject2 = com.tencent.mm.plugin.report.e.qrI;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("| Activity:\t ").append(((a)localObject1).activity).append("\n| VmSize:\t ").append(((a)localObject1).gir).append("kB\n| Dalvik:\t memClass=").append(((a)localObject1).giy).append(", memLargeClass=").append(((a)localObject1).giz).append("b, TalMemory=").append(((a)localObject1).giv).append("b, FreeMemory=").append(((a)localObject1).giw).append("b, MaxMemory=").append(((a)localObject1).gix).append("b\n| NATIVE:\t HeapSize=").append(((a)localObject1).gis).append("b, AllocatedSize=").append(((a)localObject1).git).append("b, FreeSize=").append(((a)localObject1).giu).append("b\n");
        ((com.tencent.mm.plugin.report.e)localObject2).kvStat(17068, ((StringBuilder)localObject3).toString());
        this.gip = true;
      }
      localObject1 = d.ysm;
      if (!this.bSe) {
        break label1097;
      }
    }
    label794:
    label966:
    label1097:
    for (long l = 300000L;; l = 1800000L)
    {
      ((com.tencent.mm.sdk.g.a.e)localObject1).r(this, l);
      AppMethodBeat.o(76880);
      return;
      if (((a)localObject1).giv - ((a)localObject1).giw < 209715200L)
      {
        ((IDKey)localObject3).SetKey(121);
        break;
      }
      if (((a)localObject1).giv - ((a)localObject1).giw < 314572800L)
      {
        ((IDKey)localObject3).SetKey(122);
        break;
      }
      if (((a)localObject1).giv - ((a)localObject1).giw < 419430400L)
      {
        ((IDKey)localObject3).SetKey(123);
        break;
      }
      if (((a)localObject1).giv - ((a)localObject1).giw < 524288000L)
      {
        ((IDKey)localObject3).SetKey(124);
        break;
      }
      if (((a)localObject1).giv - ((a)localObject1).giw < 629145600L)
      {
        ((IDKey)localObject3).SetKey(125);
        break;
      }
      if (((a)localObject1).giv - ((a)localObject1).giw < 734003200L)
      {
        ((IDKey)localObject3).SetKey(126);
        break;
      }
      if (((a)localObject1).giv - ((a)localObject1).giw < 838860800L)
      {
        ((IDKey)localObject3).SetKey(127);
        break;
      }
      ((IDKey)localObject3).SetKey(128);
      break;
      if (((a)localObject1).git < 209715200L)
      {
        ((IDKey)localObject3).SetKey(132);
        break label140;
      }
      if (((a)localObject1).git < 314572800L)
      {
        ((IDKey)localObject3).SetKey(133);
        break label140;
      }
      if (((a)localObject1).git < 419430400L)
      {
        ((IDKey)localObject3).SetKey(134);
        break label140;
      }
      if (((a)localObject1).git < 524288000L)
      {
        ((IDKey)localObject3).SetKey(135);
        break label140;
      }
      if (((a)localObject1).git < 629145600L)
      {
        ((IDKey)localObject3).SetKey(136);
        break label140;
      }
      if (((a)localObject1).git < 734003200L)
      {
        ((IDKey)localObject3).SetKey(137);
        break label140;
      }
      if (((a)localObject1).git < 838860800L)
      {
        ((IDKey)localObject3).SetKey(138);
        break label140;
      }
      ((IDKey)localObject3).SetKey(139);
      break label140;
      if (((a)localObject1).gir < 2516582.5F)
      {
        ((IDKey)localObject3).SetKey(143);
        break label190;
      }
      if (((a)localObject1).gir < 2936012.8F)
      {
        ((IDKey)localObject3).SetKey(144);
        break label190;
      }
      if (((a)localObject1).gir < 3145728.0F)
      {
        ((IDKey)localObject3).SetKey(145);
        break label190;
      }
      if (((a)localObject1).gir < 3565158.5F)
      {
        ((IDKey)localObject3).SetKey(146);
        break label190;
      }
      if (((a)localObject1).gir < 3984588.8F)
      {
        ((IDKey)localObject3).SetKey(147);
        break label190;
      }
      ((IDKey)localObject3).SetKey(148);
      break label190;
    }
  }
  
  public static final class a
  {
    String activity;
    long giA;
    long giB;
    int gir;
    long gis;
    long git;
    long giu;
    long giv;
    long giw;
    long gix;
    long giy;
    long giz;
    Map<String, String> map;
    
    public a()
    {
      AppMethodBeat.i(76869);
      this.activity = "default";
      this.giB = Thread.currentThread().getId();
      AppMethodBeat.o(76869);
    }
    
    private static String r(Map<String, String> paramMap)
    {
      AppMethodBeat.i(76871);
      if (paramMap == null)
      {
        AppMethodBeat.o(76871);
        return "null";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((!((String)localEntry.getKey()).equals("java-heap")) && (!((String)localEntry.getKey()).equals("native-heap"))) {
          localStringBuilder.append(((String)localEntry.getKey()).replaceFirst("summary.", "")).append("=").append((String)localEntry.getValue()).append(", ");
        }
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      paramMap = localStringBuilder.toString();
      AppMethodBeat.o(76871);
      return paramMap;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(76870);
      Object localObject = new StringBuilder(" \n");
      ((StringBuilder)localObject).append(String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> MemoryInfo(%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { Long.valueOf(this.giB) })).append("\n| Activity:\t ").append(this.activity).append("\n| VmSize:\t ").append(this.gir).append("kB\n| Dalvik:\t memClass=").append(this.giy).append(", memLargeClass=").append(this.giz).append("b, TalMemory=").append(this.giv).append("b, FreeMemory=").append(this.giw).append("b, MaxMemory=").append(this.gix).append("b\n| NATIVE:\t HeapSize=").append(this.gis).append("b, AllocatedSize=").append(this.git).append("b, FreeSize=").append(this.giu).append("b\n| Stats:\t ").append(r(this.map)).append("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:").append(this.giA).append("ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(76870);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.a.a
 * JD-Core Version:    0.7.0.1
 */