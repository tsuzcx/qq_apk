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
  private static final boolean[] NATIVE_LIB_LOADED;
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
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(207214);
    numPattern = Pattern.compile("[^0-9]");
    config = new Patrons.PatronsConfig();
    autoCheckVssTimer = null;
    NATIVE_LIB_LOADED = new boolean[] { false };
    strictCount = new AtomicInteger(0);
    if (isSupport()) {
      synchronized (NATIVE_LIB_LOADED)
      {
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("patrons");
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, locala.aYi(), "com/alibaba/android/patronus/_Patrons", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)locala.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/alibaba/android/patronus/_Patrons", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        NATIVE_LIB_LOADED[0] = true;
        AppMethodBeat.o(207214);
        return;
      }
    }
    AppMethodBeat.o(207214);
  }
  
  protected static int __init()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(206990);
        if (!isSupport())
        {
          i = 2001;
          AppMethodBeat.o(206990);
          return i;
        }
        i = __init(true, config.debuggable, config.fixHuaweiBinderAbort);
        if (i != 0)
        {
          AppMethodBeat.o(206990);
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
        AppMethodBeat.o(206990);
      }
      else if (currentRegionSpaces < config.lowerLimit)
      {
        i = 2003;
        AppMethodBeat.o(206990);
      }
      else if (config.auto)
      {
        if (readVssSize() < 0L)
        {
          i = 1001;
          AppMethodBeat.o(206990);
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
        AppMethodBeat.o(206990);
      }
    }
  }
  
  private static native int __init(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private static void _start(int paramInt)
  {
    AppMethodBeat.i(207015);
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
    AppMethodBeat.o(207015);
  }
  
  private static void asyncWriteInitResultToFile(Context paramContext, final int paramInt)
  {
    AppMethodBeat.i(207116);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206950);
        try
        {
          String str = this.val$context.getDir("patrons", 0).getAbsolutePath() + File.separator;
          _Patrons.access$500(String.valueOf(paramInt), str + "code.txt");
          if (paramInt != 0) {
            _Patrons.access$500(_Patrons.dumpNativeLogs(), str + "msg.txt");
          }
          AppMethodBeat.o(206950);
          return;
        }
        catch (Exception localException)
        {
          new StringBuilder("record init result failed, code = ").append(paramInt);
          AppMethodBeat.o(206950);
        }
      }
    }).start();
    AppMethodBeat.o(207116);
  }
  
  static native String dumpLogs();
  
  static String dumpNativeLogs()
  {
    AppMethodBeat.i(207092);
    if (isNativeLibLoaded())
    {
      String str = dumpLogs();
      AppMethodBeat.o(207092);
      return str;
    }
    AppMethodBeat.o(207092);
    return "can not dump logs without native libs";
  }
  
  static native long getCurrentMaxAvailableVmAddr();
  
  static native long getCurrentRegionSpaceSize();
  
  static void inBackground()
  {
    AppMethodBeat.i(207001);
    if ((config.auto) && (autoCheckVssTimer != null))
    {
      autoCheckVssTimer.cancel();
      autoCheckVssTimer = null;
    }
    AppMethodBeat.o(207001);
  }
  
  protected static int init(Context paramContext, Patrons.PatronsConfig paramPatronsConfig)
  {
    try
    {
      AppMethodBeat.i(206981);
      if (paramPatronsConfig != null) {
        config = paramPatronsConfig;
      }
      new StringBuilder("patrons start init, config = ").append(config.toString());
      int i = __init();
      if (config.recordInitResult) {
        asyncWriteInitResultToFile(paramContext, i);
      }
      AppMethodBeat.o(206981);
      return i;
    }
    finally {}
  }
  
  static boolean isNativeLibLoaded()
  {
    synchronized (NATIVE_LIB_LOADED)
    {
      int i = NATIVE_LIB_LOADED[0];
      return i;
    }
  }
  
  private static boolean isSupport()
  {
    AppMethodBeat.i(207106);
    if ((Build.VERSION.SDK_INT >= 26) && (Build.VERSION.SDK_INT <= 30) && (!Process.is64Bit()))
    {
      AppMethodBeat.o(207106);
      return true;
    }
    AppMethodBeat.o(207106);
    return false;
  }
  
  static long readVssSize()
  {
    AppMethodBeat.i(206996);
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
    AppMethodBeat.o(206996);
    return l1;
  }
  
  static native boolean shrinkRegionSpace(int paramInt);
  
  private static void stop()
  {
    AppMethodBeat.i(207071);
    inBackground();
    config.auto = false;
    AppMethodBeat.o(207071);
  }
  
  /* Error */
  private static void stringToFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 353
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 355	java/io/FileOutputStream
    //   9: dup
    //   10: new 357	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 358	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 361	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore_2
    //   22: aload_2
    //   23: new 178	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 364
    //   37: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 368	java/lang/String:getBytes	()[B
    //   46: invokevirtual 372	java/io/FileOutputStream:write	([B)V
    //   49: aload_2
    //   50: invokevirtual 373	java/io/FileOutputStream:close	()V
    //   53: ldc_w 353
    //   56: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore_0
    //   61: ldc_w 353
    //   64: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: athrow
    //   69: astore_3
    //   70: aload_0
    //   71: ifnull +53 -> 124
    //   74: aload_2
    //   75: invokevirtual 373	java/io/FileOutputStream:close	()V
    //   78: ldc_w 353
    //   81: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_3
    //   85: athrow
    //   86: astore_0
    //   87: new 178	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 375
    //   94: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 377
    //   104: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc_w 353
    //   111: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_2
    //   116: aload_0
    //   117: aload_2
    //   118: invokevirtual 383	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   121: goto -43 -> 78
    //   124: aload_2
    //   125: invokevirtual 373	java/io/FileOutputStream:close	()V
    //   128: goto -50 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString1	String
    //   0	131	1	paramString2	String
    //   21	54	2	localFileOutputStream	java.io.FileOutputStream
    //   115	10	2	localThrowable	java.lang.Throwable
    //   69	16	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	49	60	finally
    //   61	69	69	finally
    //   6	22	86	java/lang/Exception
    //   49	59	86	java/lang/Exception
    //   78	86	86	java/lang/Exception
    //   116	121	86	java/lang/Exception
    //   124	128	86	java/lang/Exception
    //   74	78	115	finally
  }
  
  static void toForeground()
  {
    AppMethodBeat.i(207005);
    strictCount.set(0);
    _start(config.periodOfCheck);
    AppMethodBeat.o(207005);
  }
  
  public static class AutoCheckerTask
    extends TimerTask
  {
    public void run()
    {
      AppMethodBeat.i(206974);
      if ((_Patrons.strictCount.get() != 0) && (_Patrons.strictCount.addAndGet(1) > 5))
      {
        _Patrons.strictCount.set(0);
        _Patrons.access$200(_Patrons.config.periodOfCheck);
      }
      long l = _Patrons.readVssSize();
      float f = (float)(l / _Patrons.getCurrentMaxAvailableVmAddr());
      if (_Patrons.currentRegionSpaces - _Patrons.config.shrinkStep < _Patrons.config.lowerLimit)
      {
        new StringBuilder("vss has no space to resize, stop watching. current space = ").append(_Patrons.currentRegionSpaces);
        _Patrons.access$400();
        AppMethodBeat.o(206974);
        return;
      }
      if (f > _Patrons.config.periodOfShrink)
      {
        new StringBuilder("vss has over the period, current vss = ").append(l / 1048576L).append("mb, period = ").append(f);
        if (!_Patrons.shrinkRegionSpace((int)_Patrons.access$302(_Patrons.currentRegionSpaces - _Patrons.config.shrinkStep)))
        {
          _Patrons.access$400();
          AppMethodBeat.o(206974);
          return;
        }
        l = _Patrons.readVssSize();
        new StringBuilder("resize success, step = ").append(_Patrons.config.shrinkStep).append("mb, current vss = ").append(l / 1048576L).append("mb");
        _Patrons.strictCount.set(1);
        _Patrons.access$200(_Patrons.config.periodOfCheck / 2);
        AppMethodBeat.o(206974);
        return;
      }
      if (_Patrons.getCurrentRegionSpaceSize() / 1048576L < _Patrons.config.lowerLimit)
      {
        new StringBuilder("current heap size (").append(_Patrons.getCurrentRegionSpaceSize() / 1048576L).append(") less than lower limit (").append(_Patrons.config.lowerLimit).append(") stop watching.");
        _Patrons.access$400();
        AppMethodBeat.o(206974);
        return;
      }
      if (_Patrons.config.debuggable) {
        new StringBuilder("[").append(_Patrons.strictCount.get()).append("] every thing is OK, vss = ").append(l / 1048576L).append(" mb, current period = ").append(f).append(", heap = ").append(_Patrons.getCurrentRegionSpaceSize() / 1048576L).append(" mb");
      }
      AppMethodBeat.o(206974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.alibaba.android.patronus._Patrons
 * JD-Core Version:    0.7.0.1
 */