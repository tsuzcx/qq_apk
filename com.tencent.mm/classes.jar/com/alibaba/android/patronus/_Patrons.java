package com.alibaba.android.patronus;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _Patrons
{
  private static final int ANDROID_VERSION_NOT_SUPPORT = 2001;
  private static final int ERROR_READ_VSS_FAILED = 1001;
  private static final long GB = 1073741824L;
  private static final int HEAP_SIZE_IS_NOT_BIG_ENOUGH = 2002;
  private static final long KB = 1024L;
  private static final int LOWER_LIMIT_IS_TOO_SMALL = 2003;
  private static final int MAX_CHECK_OF_STRICT_MODE = 5;
  private static final long MB = 1048576L;
  private static boolean NATIVE_LIB_LOADED = false;
  private static final long S = 1000L;
  public static final String TAG = "Patrons";
  private static final int VERSION_CODES_R = 30;
  private static final float VSS_MAX_IN_V7A = 4.294967E+009F;
  private static Timer autoCheckVssTimer;
  private static Patrons.PatronsConfig config;
  private static long currentRegionSpaces = 0L;
  private static final Pattern numPattern;
  private static final String numRegEx = "[^0-9]";
  private static final AtomicInteger strictCount;
  
  static
  {
    AppMethodBeat.i(293114);
    numPattern = Pattern.compile("[^0-9]");
    config = new Patrons.PatronsConfig();
    autoCheckVssTimer = null;
    NATIVE_LIB_LOADED = false;
    strictCount = new AtomicInteger(0);
    if (isSupport())
    {
      System.loadLibrary("patrons");
      NATIVE_LIB_LOADED = true;
    }
    AppMethodBeat.o(293114);
  }
  
  protected static int __init()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(293101);
        if (!isSupport())
        {
          i = 2001;
          AppMethodBeat.o(293101);
          return i;
        }
        i = __init(true, config.debuggable, config.fixHuaweiBinderAbort);
        if (i != 0)
        {
          AppMethodBeat.o(293101);
          continue;
        }
        l = getCurrentRegionSpaceSize() / 1048576L;
      }
      finally {}
      long l;
      currentRegionSpaces = l;
      if ((l <= 0L) || (currentRegionSpaces > 1024L))
      {
        i = 2002;
        AppMethodBeat.o(293101);
      }
      else if (currentRegionSpaces < config.lowerLimit)
      {
        i = 2003;
        AppMethodBeat.o(293101);
      }
      else if (config.auto)
      {
        if (readVssSize() < 0L)
        {
          i = 1001;
          AppMethodBeat.o(293101);
        }
        else
        {
          toForeground();
        }
      }
      else
      {
        new StringBuilder("patrons init finish, vss = ").append(readVssSize() / 1048576L).append(" mb, heap = ").append(currentRegionSpaces).append(" mb");
        i = 0;
        AppMethodBeat.o(293101);
      }
    }
  }
  
  private static native int __init(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private static void _start(int paramInt)
  {
    AppMethodBeat.i(293105);
    if (config.auto)
    {
      if (autoCheckVssTimer != null)
      {
        autoCheckVssTimer.cancel();
        autoCheckVssTimer = null;
      }
      Timer localTimer = new Timer();
      autoCheckVssTimer = localTimer;
      localTimer.schedule(new AutoCheckerTask(), paramInt * 1000L, paramInt * 1000L);
    }
    AppMethodBeat.o(293105);
  }
  
  private static void asyncWriteInitResultToFile(Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(293109);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293098);
        try
        {
          String str = this.val$context.getDir("patrons", 0).getAbsolutePath() + File.separator;
          _Patrons.access$500(String.valueOf(paramInt), str + "code.txt");
          if (paramInt != 0) {
            _Patrons.access$500(_Patrons.dumpNativeLogs(), str + "msg.txt");
          }
          AppMethodBeat.o(293098);
          return;
        }
        catch (Exception localException)
        {
          new StringBuilder("record init result failed, code = ").append(paramInt);
          AppMethodBeat.o(293098);
        }
      }
    }).start();
    AppMethodBeat.o(293109);
  }
  
  static native String dumpLogs();
  
  static String dumpNativeLogs()
  {
    AppMethodBeat.i(293107);
    if (NATIVE_LIB_LOADED)
    {
      String str = dumpLogs();
      AppMethodBeat.o(293107);
      return str;
    }
    AppMethodBeat.o(293107);
    return "can not dump logs without native libs";
  }
  
  static native long getCurrentRegionSpaceSize();
  
  static void inBackground()
  {
    AppMethodBeat.i(293103);
    if ((config.auto) && (autoCheckVssTimer != null))
    {
      autoCheckVssTimer.cancel();
      autoCheckVssTimer = null;
    }
    AppMethodBeat.o(293103);
  }
  
  protected static int init(Context paramContext, Patrons.PatronsConfig paramPatronsConfig)
  {
    try
    {
      AppMethodBeat.i(293100);
      if (paramPatronsConfig != null) {
        config = paramPatronsConfig;
      }
      new StringBuilder("patrons start init, config = ").append(config.toString());
      int i = __init();
      if (config.recordInitResult) {
        asyncWriteInitResultToFile(paramContext, i);
      }
      AppMethodBeat.o(293100);
      return i;
    }
    finally {}
  }
  
  private static boolean isSupport()
  {
    AppMethodBeat.i(293108);
    if ((Build.VERSION.SDK_INT >= 26) && (Build.VERSION.SDK_INT <= 30) && (!Process.is64Bit()))
    {
      AppMethodBeat.o(293108);
      return true;
    }
    AppMethodBeat.o(293108);
    return false;
  }
  
  static long readVssSize()
  {
    AppMethodBeat.i(293102);
    long l3 = -1L;
    l2 = l3;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("/proc/" + Process.myPid() + "/status");
      l2 = l3;
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
      String str;
      do
      {
        l2 = l3;
        str = localBufferedReader.readLine();
        l1 = l3;
        if (str == null) {
          break;
        }
        l2 = l3;
        str = str.toLowerCase();
        l2 = l3;
      } while (!str.contains("vmsize"));
      l2 = l3;
      l1 = Integer.parseInt(numPattern.matcher(str).replaceAll("").trim()) * 1024L;
      l2 = l1;
      localFileInputStream.close();
      l2 = l1;
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
      }
    }
    AppMethodBeat.o(293102);
    return l1;
  }
  
  static native boolean shrinkRegionSpace(int paramInt);
  
  private static void stop()
  {
    AppMethodBeat.i(293106);
    inBackground();
    config.auto = false;
    AppMethodBeat.o(293106);
  }
  
  /* Error */
  private static void stringToFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 317
    //   3: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 319	java/io/FileOutputStream
    //   9: dup
    //   10: new 321	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 322	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore_3
    //   22: aconst_null
    //   23: astore_2
    //   24: aload_3
    //   25: new 142	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 326	java/lang/StringBuilder:<init>	()V
    //   32: aload_0
    //   33: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 328
    //   39: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 332	java/lang/String:getBytes	()[B
    //   48: invokevirtual 336	java/io/FileOutputStream:write	([B)V
    //   51: aload_3
    //   52: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   55: ldc_w 317
    //   58: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: astore_2
    //   63: ldc_w 317
    //   66: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_2
    //   70: athrow
    //   71: astore_0
    //   72: aload_2
    //   73: ifnull +53 -> 126
    //   76: aload_3
    //   77: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   80: ldc_w 317
    //   83: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_0
    //   87: athrow
    //   88: astore_0
    //   89: new 142	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 339
    //   96: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_1
    //   100: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 341
    //   106: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc_w 317
    //   113: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_3
    //   118: aload_2
    //   119: aload_3
    //   120: invokevirtual 345	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: goto -43 -> 80
    //   126: aload_3
    //   127: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   130: goto -50 -> 80
    //   133: astore_0
    //   134: goto -62 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString1	String
    //   0	137	1	paramString2	String
    //   23	1	2	localObject	Object
    //   62	57	2	localThrowable1	java.lang.Throwable
    //   21	56	3	localFileOutputStream	java.io.FileOutputStream
    //   117	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   24	51	62	java/lang/Throwable
    //   63	71	71	finally
    //   6	22	88	java/lang/Exception
    //   51	61	88	java/lang/Exception
    //   76	80	88	java/lang/Exception
    //   80	88	88	java/lang/Exception
    //   118	123	88	java/lang/Exception
    //   126	130	88	java/lang/Exception
    //   76	80	117	java/lang/Throwable
    //   24	51	133	finally
  }
  
  static void toForeground()
  {
    AppMethodBeat.i(293104);
    strictCount.set(0);
    _start(config.periodOfCheck);
    AppMethodBeat.o(293104);
  }
  
  public static class AutoCheckerTask
    extends TimerTask
  {
    public void run()
    {
      AppMethodBeat.i(293099);
      if ((_Patrons.strictCount.get() != 0) && (_Patrons.strictCount.addAndGet(1) > 5))
      {
        _Patrons.strictCount.set(0);
        _Patrons.access$200(_Patrons.config.periodOfCheck);
      }
      long l = _Patrons.readVssSize();
      float f = (float)l / 4.294967E+009F;
      if (_Patrons.currentRegionSpaces - _Patrons.config.shrinkStep < _Patrons.config.lowerLimit)
      {
        new StringBuilder("vss has no space to resize, stop watching. current space = ").append(_Patrons.currentRegionSpaces);
        _Patrons.access$400();
        AppMethodBeat.o(293099);
        return;
      }
      if (f > _Patrons.config.periodOfShrink)
      {
        new StringBuilder("vss has over the period, current vss = ").append(l / 1048576L).append("mb, period = ").append(f);
        if (!_Patrons.shrinkRegionSpace((int)_Patrons.access$302(_Patrons.currentRegionSpaces - _Patrons.config.shrinkStep)))
        {
          _Patrons.access$400();
          AppMethodBeat.o(293099);
          return;
        }
        l = _Patrons.readVssSize();
        new StringBuilder("resize success, step = ").append(_Patrons.config.shrinkStep).append("mb, current vss = ").append(l / 1048576L).append("mb");
        _Patrons.strictCount.set(1);
        _Patrons.access$200(_Patrons.config.periodOfCheck / 2);
        AppMethodBeat.o(293099);
        return;
      }
      if (_Patrons.getCurrentRegionSpaceSize() / 1048576L < _Patrons.config.lowerLimit)
      {
        new StringBuilder("current heap size (").append(_Patrons.getCurrentRegionSpaceSize() / 1048576L).append(") less than lower limit (").append(_Patrons.config.lowerLimit).append(") stop watching.");
        _Patrons.access$400();
        AppMethodBeat.o(293099);
        return;
      }
      if (_Patrons.config.debuggable) {
        new StringBuilder("[").append(_Patrons.strictCount.get()).append("] every thing is OK, vss = ").append(l / 1048576L).append(" mb, current period = ").append(f).append(", heap = ").append(_Patrons.getCurrentRegionSpaceSize() / 1048576L).append(" mb");
      }
      AppMethodBeat.o(293099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.alibaba.android.patronus._Patrons
 * JD-Core Version:    0.7.0.1
 */