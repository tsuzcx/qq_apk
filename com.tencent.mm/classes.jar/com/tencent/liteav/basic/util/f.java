package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
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
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class f
{
  public static long a;
  private static boolean b;
  private static String c;
  private static int d;
  private static long e;
  private static boolean f;
  private static a<b> g;
  private static final Object h;
  private static boolean i;
  private static int[] j;
  
  static
  {
    AppMethodBeat.i(222110);
    b = true;
    c = "";
    a = 0L;
    d = 0;
    e = 0L;
    f = false;
    g = new a(new a.a()
    {
      public final b b()
      {
        AppMethodBeat.i(222126);
        b localb = new b();
        AppMethodBeat.o(222126);
        return localb;
      }
    });
    h = new Object();
    i = false;
    j = new int[] { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
    AppMethodBeat.o(222110);
  }
  
  public static int a(int paramInt)
  {
    int k = 0;
    while ((k < j.length) && (j[k] != paramInt)) {
      k += 1;
    }
    paramInt = k;
    if (k >= j.length) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  @TargetApi(16)
  public static MediaFormat a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(222106);
    int k = a(paramInt1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.put(0, (byte)(paramInt3 << 3 | k >> 1));
    localByteBuffer.put(1, (byte)((k & 0x1) << 7 | paramInt2 << 3));
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    localMediaFormat.setInteger("channel-count", paramInt2);
    localMediaFormat.setInteger("sample-rate", paramInt1);
    localMediaFormat.setByteBuffer("csd-0", localByteBuffer);
    AppMethodBeat.o(222106);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  public static MediaFormat a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222109);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    paramInt1 = 0;
    int i3 = 0;
    int m = 0;
    int k = 0;
    paramInt2 = 0;
    if (paramInt1 + 3 < paramArrayOfByte.length) {
      if ((paramArrayOfByte[paramInt1] != 0) || (paramArrayOfByte[(paramInt1 + 1)] != 0) || (paramArrayOfByte[(paramInt1 + 2)] != 1)) {
        break label324;
      }
    }
    label324:
    for (int i1 = 3;; i1 = 0)
    {
      int n = i1;
      if (paramArrayOfByte[paramInt1] == 0)
      {
        n = i1;
        if (paramArrayOfByte[(paramInt1 + 1)] == 0)
        {
          n = i1;
          if (paramArrayOfByte[(paramInt1 + 2)] == 0)
          {
            n = i1;
            if (paramArrayOfByte[(paramInt1 + 3)] == 1) {
              n = 4;
            }
          }
        }
      }
      int i2 = paramInt1;
      i1 = m;
      if (n > 0)
      {
        if (m == 0)
        {
          i2 = paramInt1 + n;
          i1 = n;
        }
      }
      else
      {
        n = i2;
        m = i1;
      }
      for (;;)
      {
        paramInt1 = n + 1;
        break;
        i2 = paramArrayOfByte[m] & 0x1F;
        if (i2 == 7)
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, m, paramInt1);
          i1 = 1;
        }
        for (;;)
        {
          paramInt2 = paramInt1 + n;
          if ((i1 == 0) || (k == 0)) {
            break;
          }
          AppMethodBeat.o(222109);
          return localMediaFormat;
          i1 = paramInt2;
          if (i2 == 8)
          {
            a("csd-1", localMediaFormat, paramArrayOfByte, m, paramInt1);
            k = 1;
            i1 = paramInt2;
          }
        }
        paramInt1 = paramArrayOfByte[m] & 0x1F;
        if ((paramInt2 != 0) && (paramInt1 == 8))
        {
          a("csd-1", localMediaFormat, paramArrayOfByte, m, i3);
          AppMethodBeat.o(222109);
          return localMediaFormat;
        }
        if ((k != 0) && (paramInt1 == 7))
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, m, i3);
          AppMethodBeat.o(222109);
          return localMediaFormat;
        }
        AppMethodBeat.o(222109);
        return null;
        n = paramInt2;
        i3 = paramInt1;
        m = paramInt2;
        paramInt2 = i1;
      }
    }
  }
  
  public static com.tencent.liteav.basic.c.a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 0;
    AppMethodBeat.i(222102);
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
        k = paramInt2 - paramInt4 >> 1;
      }
      com.tencent.liteav.basic.c.a locala = new com.tencent.liteav.basic.c.a(paramInt1, k, paramInt3, paramInt4);
      AppMethodBeat.o(222102);
      return locala;
      paramInt4 = paramInt1 * paramInt4 / paramInt3;
      paramInt3 = paramInt1;
      break;
    }
  }
  
  private static void a(String paramString, MediaFormat paramMediaFormat, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222108);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 - paramInt1);
    localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2 - paramInt1);
    localByteBuffer.position(0);
    paramMediaFormat.setByteBuffer(paramString, localByteBuffer);
    AppMethodBeat.o(222108);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(222100);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(222100);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.b.b)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(222100);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference, int paramInt, String paramString)
  {
    AppMethodBeat.i(222099);
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(222099);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference, String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(222101);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(222101);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.b.b)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      paramBundle.putString("EVT_USERID", paramString);
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(222101);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(222098);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", paramString1);
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString2 != null) {
      localBundle.putCharSequence("EVT_MSG", paramString2);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(222098);
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(222091);
    if (paramContext == null)
    {
      AppMethodBeat.o(222091);
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      if (((ActivityManager)localObject).getRunningTasks(1) == null)
      {
        TXCLog.e("TXCSystemUtil", "running task is null, ams is abnormal!!!");
        AppMethodBeat.o(222091);
        return false;
      }
      localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).topActivity == null))
      {
        TXCLog.e("TXCSystemUtil", "failed to get RunningTaskInfo");
        AppMethodBeat.o(222091);
        return false;
      }
      if (!((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(paramContext.getPackageName()))
      {
        AppMethodBeat.o(222091);
        return true;
      }
      AppMethodBeat.o(222091);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(222091);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(222104);
    boolean bool;
    try
    {
      new StringBuilder("load library ").append(paramString).append(" from system path ");
      System.loadLibrary(paramString);
      AppMethodBeat.o(222104);
      return true;
    }
    catch (Error localError)
    {
      new StringBuilder("load library : ").append(localError.toString());
      bool = b(c, paramString);
      AppMethodBeat.o(222104);
      return bool;
    }
    catch (Exception localException)
    {
      new StringBuilder("load library : ").append(localException.toString());
      bool = b(c, paramString);
      AppMethodBeat.o(222104);
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 288
    //   3: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +11 -> 22
    //   14: ldc_w 288
    //   17: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: new 290	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 295	java/io/File:exists	()Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifne +11 -> 46
    //   38: ldc_w 288
    //   41: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: new 297	android/media/MediaMetadataRetriever
    //   49: dup
    //   50: invokespecial 298	android/media/MediaMetadataRetriever:<init>	()V
    //   53: astore_3
    //   54: aload_3
    //   55: aload_0
    //   56: invokevirtual 301	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   59: aload_3
    //   60: invokevirtual 305	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   63: astore 5
    //   65: new 290	java/io/File
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 295	java/io/File:exists	()Z
    //   78: ifeq +8 -> 86
    //   81: aload_0
    //   82: invokevirtual 308	java/io/File:delete	()Z
    //   85: pop
    //   86: new 310	java/io/FileOutputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 313	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore_0
    //   95: aload_3
    //   96: astore 4
    //   98: aload_0
    //   99: astore_1
    //   100: aload 5
    //   102: getstatic 319	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   105: bipush 100
    //   107: aload_0
    //   108: invokevirtual 325	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: aload_3
    //   113: astore 4
    //   115: aload_0
    //   116: astore_1
    //   117: aload_0
    //   118: invokevirtual 328	java/io/FileOutputStream:flush	()V
    //   121: aload_0
    //   122: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   125: aload_3
    //   126: invokevirtual 334	android/media/MediaMetadataRetriever:release	()V
    //   129: ldc_w 288
    //   132: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   148: ldc 222
    //   150: ldc_w 336
    //   153: aload 5
    //   155: invokestatic 339	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 334	android/media/MediaMetadataRetriever:release	()V
    //   174: ldc_w 288
    //   177: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +7 -> 195
    //   191: aload_1
    //   192: invokevirtual 331	java/io/FileOutputStream:close	()V
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 334	android/media/MediaMetadataRetriever:release	()V
    //   203: ldc_w 288
    //   206: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: goto -87 -> 125
    //   215: astore_0
    //   216: goto -50 -> 166
    //   219: astore_1
    //   220: goto -25 -> 195
    //   223: astore_0
    //   224: aconst_null
    //   225: astore_1
    //   226: goto -39 -> 187
    //   229: astore_0
    //   230: aload 4
    //   232: astore_3
    //   233: goto -46 -> 187
    //   236: astore 5
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -97 -> 143
    //   243: astore 5
    //   245: goto -102 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramString1	String
    //   0	248	1	paramString2	String
    //   33	2	2	bool	boolean
    //   53	180	3	localObject1	Object
    //   96	135	4	localObject2	Object
    //   63	38	5	localBitmap	android.graphics.Bitmap
    //   137	17	5	localException1	Exception
    //   236	1	5	localException2	Exception
    //   243	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   22	34	137	java/lang/Exception
    //   46	54	137	java/lang/Exception
    //   22	34	182	finally
    //   46	54	182	finally
    //   121	125	211	java/io/IOException
    //   162	166	215	java/io/IOException
    //   191	195	219	java/io/IOException
    //   54	86	223	finally
    //   86	95	223	finally
    //   100	112	229	finally
    //   117	121	229	finally
    //   148	158	229	finally
    //   54	86	236	java/lang/Exception
    //   86	95	236	java/lang/Exception
    //   100	112	243	java/lang/Exception
    //   117	121	243	java/lang/Exception
  }
  
  public static int[] a()
  {
    AppMethodBeat.i(222089);
    if (b)
    {
      b = false;
      ((b)g.a()).a();
      AppMethodBeat.o(222089);
      return new int[] { 0, 0 };
    }
    int[] arrayOfInt = ((b)g.a()).a();
    AppMethodBeat.o(222089);
    return arrayOfInt;
  }
  
  public static int b()
  {
    AppMethodBeat.i(222090);
    if ((f) || ((e != 0L) && (TXCTimeUtil.getTimeTick() - e < 15000L)))
    {
      k = d;
      AppMethodBeat.o(222090);
      return k;
    }
    f = true;
    AsyncTask.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222125);
        System.currentTimeMillis();
        f.a(false);
        try
        {
          Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
          Debug.getMemoryInfo(localMemoryInfo);
          int i = localMemoryInfo.getTotalPss();
          f.a(TXCTimeUtil.getTimeTick());
          f.b(i / 1024);
          AppMethodBeat.o(222125);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(222125);
        }
      }
    });
    int k = d;
    AppMethodBeat.o(222090);
    return k;
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(222092);
    paramContext = TXCDRApi.getSimulateIDFA(paramContext);
    AppMethodBeat.o(222092);
    return paramContext;
  }
  
  public static void b(String paramString)
  {
    c = paramString;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222105);
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
    AppMethodBeat.o(222105);
    return bool1;
  }
  
  public static String c()
  {
    return Build.MODEL;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(222093);
    String str2 = "";
    String str1 = str2;
    if (paramContext != null) {}
    try
    {
      str1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      AppMethodBeat.o(222093);
      return str1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        str1 = str2;
      }
    }
  }
  
  public static String d()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static boolean d(Context paramContext)
  {
    AppMethodBeat.i(222094);
    try
    {
      System.currentTimeMillis();
      if (paramContext != null)
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.isAvailable();
          AppMethodBeat.o(222094);
          return bool;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(222094);
    }
    return false;
  }
  
  public static int e(Context paramContext)
  {
    AppMethodBeat.i(222095);
    if (paramContext == null)
    {
      AppMethodBeat.o(222095);
      return 0;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(222095);
      return 0;
    }
    if (!((NetworkInfo)localObject).isConnected())
    {
      AppMethodBeat.o(222095);
      return 0;
    }
    if (((NetworkInfo)localObject).getType() == 9)
    {
      AppMethodBeat.o(222095);
      return 5;
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(222095);
      return 1;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      switch (paramContext.getNetworkType())
      {
      default: 
        AppMethodBeat.o(222095);
        return 2;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        AppMethodBeat.o(222095);
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
        AppMethodBeat.o(222095);
        return 3;
      }
      AppMethodBeat.o(222095);
      return 2;
    }
    AppMethodBeat.o(222095);
    return 0;
  }
  
  public static String e()
  {
    AppMethodBeat.i(222096);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(222096);
    return str;
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(222097);
    paramContext = TXCDRApi.getDevUUID(paramContext, TXCDRApi.getSimulateIDFA(paramContext));
    AppMethodBeat.o(222097);
    return paramContext;
  }
  
  public static boolean f()
  {
    AppMethodBeat.i(222103);
    synchronized (h)
    {
      if (!i)
      {
        a("txffmpeg");
        a("traeimp-rtmp");
        i = a("liteavsdk");
        new StringBuilder("load library liteavsdk ").append(i);
      }
      boolean bool = i;
      AppMethodBeat.o(222103);
      return bool;
    }
  }
  
  public static String g()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.util.f
 * JD-Core Version:    0.7.0.1
 */