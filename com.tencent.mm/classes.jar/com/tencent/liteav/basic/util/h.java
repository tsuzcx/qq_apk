package com.tencent.liteav.basic.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class h
{
  public static long a;
  private static boolean b;
  private static String c;
  private static int d;
  private static long e;
  private static boolean f;
  private static String g;
  private static String h;
  private static a<b> i;
  private static final Object j;
  private static boolean k;
  private static int[] l;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(230323);
    b = true;
    c = "";
    a = 0L;
    d = 0;
    e = 0L;
    f = false;
    g = "";
    h = "";
    i = new a(new a.a()
    {
      public final b b()
      {
        AppMethodBeat.i(230172);
        b localb = new b();
        AppMethodBeat.o(230172);
        return localb;
      }
    });
    j = new Object();
    k = false;
    l = new int[] { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
    AppMethodBeat.o(230323);
  }
  
  public static int a(int paramInt)
  {
    int m = 0;
    while ((m < l.length) && (l[m] != paramInt)) {
      m += 1;
    }
    paramInt = m;
    if (m >= l.length) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public static MediaFormat a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(230263);
    int m = a(paramInt1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.put(0, (byte)(paramInt3 << 3 | m >> 1));
    localByteBuffer.put(1, (byte)((m & 0x1) << 7 | paramInt2 << 3));
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    localMediaFormat.setInteger("channel-count", paramInt2);
    localMediaFormat.setInteger("sample-rate", paramInt1);
    localMediaFormat.setByteBuffer("csd-0", localByteBuffer);
    AppMethodBeat.o(230263);
    return localMediaFormat;
  }
  
  public static MediaFormat a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230296);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    paramInt1 = 0;
    int i4 = 0;
    int n = 0;
    int m = 0;
    paramInt2 = 0;
    if (paramInt1 + 3 < paramArrayOfByte.length) {
      if ((paramArrayOfByte[paramInt1] != 0) || (paramArrayOfByte[(paramInt1 + 1)] != 0) || (paramArrayOfByte[(paramInt1 + 2)] != 1)) {
        break label324;
      }
    }
    label324:
    for (int i2 = 3;; i2 = 0)
    {
      int i1 = i2;
      if (paramArrayOfByte[paramInt1] == 0)
      {
        i1 = i2;
        if (paramArrayOfByte[(paramInt1 + 1)] == 0)
        {
          i1 = i2;
          if (paramArrayOfByte[(paramInt1 + 2)] == 0)
          {
            i1 = i2;
            if (paramArrayOfByte[(paramInt1 + 3)] == 1) {
              i1 = 4;
            }
          }
        }
      }
      int i3 = paramInt1;
      i2 = n;
      if (i1 > 0)
      {
        if (n == 0)
        {
          i3 = paramInt1 + i1;
          i2 = i1;
        }
      }
      else
      {
        i1 = i3;
        n = i2;
      }
      for (;;)
      {
        paramInt1 = i1 + 1;
        break;
        i3 = paramArrayOfByte[n] & 0x1F;
        if (i3 == 7)
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, n, paramInt1);
          i2 = 1;
        }
        for (;;)
        {
          paramInt2 = paramInt1 + i1;
          if ((i2 == 0) || (m == 0)) {
            break;
          }
          AppMethodBeat.o(230296);
          return localMediaFormat;
          i2 = paramInt2;
          if (i3 == 8)
          {
            a("csd-1", localMediaFormat, paramArrayOfByte, n, paramInt1);
            m = 1;
            i2 = paramInt2;
          }
        }
        paramInt1 = paramArrayOfByte[n] & 0x1F;
        if ((paramInt2 != 0) && (paramInt1 == 8))
        {
          a("csd-1", localMediaFormat, paramArrayOfByte, n, i4);
          AppMethodBeat.o(230296);
          return localMediaFormat;
        }
        if ((m != 0) && (paramInt1 == 7))
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, n, i4);
          AppMethodBeat.o(230296);
          return localMediaFormat;
        }
        AppMethodBeat.o(230296);
        return null;
        i1 = paramInt2;
        i4 = paramInt1;
        n = paramInt2;
        paramInt2 = i2;
      }
    }
  }
  
  public static com.tencent.liteav.basic.opengl.a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = 0;
    AppMethodBeat.i(230215);
    if (paramInt1 * paramInt4 >= paramInt2 * paramInt3)
    {
      paramInt3 = paramInt2 * paramInt3 / paramInt4;
      paramInt4 = paramInt2;
      if (paramInt1 <= paramInt3) {
        break label81;
      }
    }
    label81:
    for (paramInt1 = paramInt1 - paramInt3 >> 1;; paramInt1 = 0)
    {
      if (paramInt2 > paramInt4) {
        m = paramInt2 - paramInt4 >> 1;
      }
      com.tencent.liteav.basic.opengl.a locala = new com.tencent.liteav.basic.opengl.a(paramInt1, m, paramInt3, paramInt4);
      AppMethodBeat.o(230215);
      return locala;
      paramInt4 = paramInt1 * paramInt4 / paramInt3;
      paramInt3 = paramInt1;
      break;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(230155);
    if (!TextUtils.isEmpty(h))
    {
      paramContext = h;
      AppMethodBeat.o(230155);
      return paramContext;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      h = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      paramContext = h;
      AppMethodBeat.o(230155);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h = "";
      }
    }
  }
  
  private static void a(String paramString, MediaFormat paramMediaFormat, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230281);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 - paramInt1);
    localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2 - paramInt1);
    localByteBuffer.position(0);
    paramMediaFormat.setByteBuffer(paramString, localByteBuffer);
    AppMethodBeat.o(230281);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(230199);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(230199);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.b)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(230199);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, int paramInt, String paramString)
  {
    AppMethodBeat.i(230192);
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(230192);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(230207);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(230207);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.b)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      paramBundle.putString("EVT_USERID", paramString);
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(230207);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(230186);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", paramString1);
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    localBundle.putLong("EVT_BLOCK_DURATION", paramLong);
    if (paramString2 != null) {
      localBundle.putCharSequence("EVT_MSG", paramString2);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(230186);
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(230138);
    if (paramContext == null)
    {
      AppMethodBeat.o(230138);
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      if (((ActivityManager)localObject).getRunningTasks(1) == null)
      {
        TXCLog.e("TXCSystemUtil", "running task is null, ams is abnormal!!!");
        AppMethodBeat.o(230138);
        return false;
      }
      localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).topActivity == null))
      {
        TXCLog.e("TXCSystemUtil", "failed to get RunningTaskInfo");
        AppMethodBeat.o(230138);
        return false;
      }
      if (!((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(paramContext.getPackageName()))
      {
        AppMethodBeat.o(230138);
        return true;
      }
      AppMethodBeat.o(230138);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(230138);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(230231);
    boolean bool;
    try
    {
      new StringBuilder("load library ").append(paramString).append(" from system path ");
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/liteav/basic/util/h", "a", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/liteav/basic/util/h", "a", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      AppMethodBeat.o(230231);
      return true;
    }
    catch (Error localError)
    {
      new StringBuilder("load library : ").append(localError.toString());
      bool = b(c, paramString);
      AppMethodBeat.o(230231);
      return bool;
    }
    catch (Exception localException)
    {
      new StringBuilder("load library : ").append(localException.toString());
      bool = b(c, paramString);
      AppMethodBeat.o(230231);
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 353
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +11 -> 22
    //   14: ldc_w 353
    //   17: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: new 355	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 356	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 360	java/io/File:exists	()Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifne +11 -> 46
    //   38: ldc_w 353
    //   41: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: new 362	android/media/MediaMetadataRetriever
    //   49: dup
    //   50: invokespecial 363	android/media/MediaMetadataRetriever:<init>	()V
    //   53: astore_3
    //   54: aload_3
    //   55: aload_0
    //   56: invokevirtual 366	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   59: aload_3
    //   60: invokevirtual 370	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   63: astore 5
    //   65: new 355	java/io/File
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 356	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 360	java/io/File:exists	()Z
    //   78: ifeq +8 -> 86
    //   81: aload_0
    //   82: invokevirtual 373	java/io/File:delete	()Z
    //   85: pop
    //   86: new 375	java/io/FileOutputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 378	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore_0
    //   95: aload_3
    //   96: astore 4
    //   98: aload_0
    //   99: astore_1
    //   100: aload 5
    //   102: getstatic 384	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   105: bipush 100
    //   107: aload_0
    //   108: invokevirtual 390	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: aload_3
    //   113: astore 4
    //   115: aload_0
    //   116: astore_1
    //   117: aload_0
    //   118: invokevirtual 393	java/io/FileOutputStream:flush	()V
    //   121: aload_0
    //   122: invokevirtual 396	java/io/FileOutputStream:close	()V
    //   125: aload_3
    //   126: invokevirtual 399	android/media/MediaMetadataRetriever:release	()V
    //   129: ldc_w 353
    //   132: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iconst_1
    //   136: ireturn
    //   137: astore 5
    //   139: aconst_null
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_3
    //   144: astore 4
    //   146: aload_0
    //   147: astore_1
    //   148: ldc_w 261
    //   151: ldc_w 401
    //   154: aload 5
    //   156: invokestatic 404	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 396	java/io/FileOutputStream:close	()V
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 399	android/media/MediaMetadataRetriever:release	()V
    //   175: ldc_w 353
    //   178: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 396	java/io/FileOutputStream:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 399	android/media/MediaMetadataRetriever:release	()V
    //   204: ldc_w 353
    //   207: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_0
    //   211: athrow
    //   212: astore_0
    //   213: goto -88 -> 125
    //   216: astore_0
    //   217: goto -50 -> 167
    //   220: astore_1
    //   221: goto -25 -> 196
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: goto -39 -> 188
    //   230: astore_0
    //   231: aload 4
    //   233: astore_3
    //   234: goto -46 -> 188
    //   237: astore 5
    //   239: aconst_null
    //   240: astore_0
    //   241: goto -98 -> 143
    //   244: astore 5
    //   246: goto -103 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString1	String
    //   0	249	1	paramString2	String
    //   33	2	2	bool	boolean
    //   53	181	3	localObject1	Object
    //   96	136	4	localObject2	Object
    //   63	38	5	localBitmap	android.graphics.Bitmap
    //   137	18	5	localException1	Exception
    //   237	1	5	localException2	Exception
    //   244	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   22	34	137	java/lang/Exception
    //   46	54	137	java/lang/Exception
    //   22	34	183	finally
    //   46	54	183	finally
    //   121	125	212	java/io/IOException
    //   163	167	216	java/io/IOException
    //   192	196	220	java/io/IOException
    //   54	86	224	finally
    //   86	95	224	finally
    //   100	112	230	finally
    //   117	121	230	finally
    //   148	159	230	finally
    //   54	86	237	java/lang/Exception
    //   86	95	237	java/lang/Exception
    //   100	112	244	java/lang/Exception
    //   117	121	244	java/lang/Exception
  }
  
  public static int[] a()
  {
    AppMethodBeat.i(230123);
    if (b)
    {
      b = false;
      ((b)i.a()).a();
      AppMethodBeat.o(230123);
      return new int[] { 0, 0 };
    }
    int[] arrayOfInt = ((b)i.a()).a();
    AppMethodBeat.o(230123);
    return arrayOfInt;
  }
  
  public static int b()
  {
    AppMethodBeat.i(230130);
    int m;
    if ((f) || ((e != 0L) && (TXCTimeUtil.getTimeTick() - e < 15000L)))
    {
      m = d;
      AppMethodBeat.o(230130);
      return m;
    }
    f = true;
    try
    {
      AsyncTask.execute(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230174);
          System.currentTimeMillis();
          h.a(false);
          try
          {
            Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(localMemoryInfo);
            int i = localMemoryInfo.getTotalPss();
            h.a(TXCTimeUtil.getTimeTick());
            h.b(i / 1024);
            AppMethodBeat.o(230174);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(230174);
          }
        }
      });
      m = d;
      AppMethodBeat.o(230130);
      return m;
    }
    finally
    {
      for (;;)
      {
        TXCLog.e("TXCSystemUtil", "getAppMemory error : ".concat(String.valueOf(localObject)));
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(230143);
    paramContext = TXCDRApi.getSimulateIDFA(paramContext);
    AppMethodBeat.o(230143);
    return paramContext;
  }
  
  public static void b(String paramString)
  {
    c = paramString;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(230238);
    bool2 = false;
    bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        new StringBuilder("load library ").append(paramString2).append(" from path ").append(paramString1);
        System.load(paramString1 + "/lib" + paramString2 + ".so");
        bool1 = true;
      }
    }
    catch (Error paramString1)
    {
      for (;;)
      {
        new StringBuilder("load library : ").append(paramString1.toString());
        bool1 = bool2;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        new StringBuilder("load library : ").append(paramString1.toString());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(230238);
    return bool1;
  }
  
  public static String c()
  {
    AppMethodBeat.i(230173);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(230173);
    return str;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(230149);
    if (!TextUtils.isEmpty(g))
    {
      paramContext = g;
      AppMethodBeat.o(230149);
      return paramContext;
    }
    if (paramContext != null) {}
    try
    {
      g = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      label49:
      paramContext = g;
      AppMethodBeat.o(230149);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label49;
    }
  }
  
  public static boolean d()
  {
    AppMethodBeat.i(230222);
    synchronized (j)
    {
      if (!k)
      {
        a("txffmpeg");
        a("traeimp-rtmp");
        a("txsoundtouch");
        k = a("liteavsdk");
        new StringBuilder("load library liteavsdk ").append(k);
      }
      boolean bool = k;
      AppMethodBeat.o(230222);
      return bool;
    }
  }
  
  public static boolean d(Context paramContext)
  {
    AppMethodBeat.i(230163);
    try
    {
      System.currentTimeMillis();
      if (paramContext != null)
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.isAvailable();
          AppMethodBeat.o(230163);
          return bool;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(230163);
    }
    return false;
  }
  
  public static int e(Context paramContext)
  {
    AppMethodBeat.i(230167);
    if (paramContext == null)
    {
      AppMethodBeat.o(230167);
      return 0;
    }
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    try
    {
      paramContext = localConnectivityManager.getActiveNetworkInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(230167);
        return 0;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        TXCLog.e("TXCSystemUtil", "getNetworkType: error occurred.", paramContext);
        paramContext = null;
      }
      if (!paramContext.isConnected())
      {
        AppMethodBeat.o(230167);
        return 0;
      }
      if (paramContext.getType() == 9)
      {
        AppMethodBeat.o(230167);
        return 5;
      }
      if (paramContext.getType() == 1)
      {
        AppMethodBeat.o(230167);
        return 1;
      }
      if (paramContext.getType() != 0) {}
    }
    for (;;)
    {
      try
      {
        int m = localTelephonyManager.getNetworkType();
        switch (m)
        {
        case 1: 
          int n = TXCBuild.VersionInt();
          if ((n >= 29) && (m == 20))
          {
            AppMethodBeat.o(230167);
            return 6;
          }
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          AppMethodBeat.o(230167);
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          AppMethodBeat.o(230167);
          return 3;
        case 13: 
          AppMethodBeat.o(230167);
          return 2;
          AppMethodBeat.o(230167);
          return 2;
        }
      }
      catch (Exception paramContext)
      {
        TXCLog.e("TXCSystemUtil", "getNetworkType: error occurred.", paramContext);
        AppMethodBeat.o(230167);
        return 2;
      }
      AppMethodBeat.o(230167);
      return 0;
    }
  }
  
  public static String e()
  {
    return c;
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(230176);
    paramContext = TXCDRApi.getDevUUID(paramContext, TXCDRApi.getSimulateIDFA(paramContext));
    AppMethodBeat.o(230176);
    return paramContext;
  }
  
  public static int g(Context paramContext)
  {
    AppMethodBeat.i(230181);
    if (paramContext == null)
    {
      AppMethodBeat.o(230181);
      return 0;
    }
    try
    {
      m = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
      AppMethodBeat.o(230181);
      return m;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int m = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.util.h
 * JD-Core Version:    0.7.0.1
 */