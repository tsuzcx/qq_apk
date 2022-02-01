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

public class d
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
    AppMethodBeat.i(14765);
    b = true;
    c = "";
    a = 0L;
    d = 0;
    e = 0L;
    f = false;
    g = new a(new d.1());
    h = new Object();
    i = false;
    j = new int[] { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
    AppMethodBeat.o(14765);
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
    AppMethodBeat.i(14761);
    int k = a(paramInt1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.put(0, (byte)(paramInt3 << 3 | k >> 1));
    localByteBuffer.put(1, (byte)((k & 0x1) << 7 | paramInt2 << 3));
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    localMediaFormat.setInteger("channel-count", paramInt2);
    localMediaFormat.setInteger("sample-rate", paramInt1);
    localMediaFormat.setByteBuffer("csd-0", localByteBuffer);
    AppMethodBeat.o(14761);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  public static MediaFormat a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14764);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    paramInt1 = 0;
    int i3 = 0;
    int m = 0;
    int k = 0;
    paramInt2 = 0;
    if (paramInt1 + 3 < paramArrayOfByte.length) {
      if ((paramArrayOfByte[paramInt1] != 0) || (paramArrayOfByte[(paramInt1 + 1)] != 0) || (paramArrayOfByte[(paramInt1 + 2)] != 1)) {
        break label329;
      }
    }
    label329:
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
          AppMethodBeat.o(14764);
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
          AppMethodBeat.o(14764);
          return localMediaFormat;
        }
        if ((k != 0) && (paramInt1 == 7))
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, m, i3);
          AppMethodBeat.o(14764);
          return localMediaFormat;
        }
        AppMethodBeat.o(14764);
        return null;
        n = paramInt2;
        i3 = paramInt1;
        m = paramInt2;
        paramInt2 = i1;
      }
    }
  }
  
  public static com.tencent.liteav.basic.d.a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 0;
    AppMethodBeat.i(14757);
    if (paramInt1 * paramInt4 >= paramInt2 * paramInt3)
    {
      paramInt3 = paramInt2 * paramInt3 / paramInt4;
      paramInt4 = paramInt2;
      if (paramInt1 <= paramInt3) {
        break label83;
      }
    }
    label83:
    for (paramInt1 = paramInt1 - paramInt3 >> 1;; paramInt1 = 0)
    {
      if (paramInt2 > paramInt4) {
        k = paramInt2 - paramInt4 >> 1;
      }
      com.tencent.liteav.basic.d.a locala = new com.tencent.liteav.basic.d.a(paramInt1, k, paramInt3, paramInt4);
      AppMethodBeat.o(14757);
      return locala;
      paramInt4 = paramInt1 * paramInt4 / paramInt3;
      paramInt3 = paramInt1;
      break;
    }
  }
  
  private static void a(String paramString, MediaFormat paramMediaFormat, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14763);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 - paramInt1);
    localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2 - paramInt1);
    localByteBuffer.position(0);
    paramMediaFormat.setByteBuffer(paramString, localByteBuffer);
    AppMethodBeat.o(14763);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(14755);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(14755);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.a)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(14755);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, int paramInt, String paramString)
  {
    AppMethodBeat.i(14754);
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(14754);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(14756);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(14756);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.a)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      paramBundle.putString("EVT_USERID", paramString);
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(14756);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(14753);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", paramString1);
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString2 != null) {
      localBundle.putCharSequence("EVT_MSG", paramString2);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(14753);
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(14746);
    if (paramContext == null)
    {
      AppMethodBeat.o(14746);
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      if (((ActivityManager)localObject).getRunningTasks(1) == null)
      {
        TXCLog.e("TXCSystemUtil", "running task is null, ams is abnormal!!!");
        AppMethodBeat.o(14746);
        return false;
      }
      localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).topActivity == null))
      {
        TXCLog.e("TXCSystemUtil", "failed to get RunningTaskInfo");
        AppMethodBeat.o(14746);
        return false;
      }
      if (!((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(paramContext.getPackageName()))
      {
        AppMethodBeat.o(14746);
        return true;
      }
      AppMethodBeat.o(14746);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(14746);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(14759);
    boolean bool;
    try
    {
      new StringBuilder("load library ").append(paramString).append(" from system path ");
      System.loadLibrary(paramString);
      AppMethodBeat.o(14759);
      return true;
    }
    catch (Error localError)
    {
      new StringBuilder("load library : ").append(localError.toString());
      bool = b(c, paramString);
      AppMethodBeat.o(14759);
      return bool;
    }
    catch (Exception localException)
    {
      new StringBuilder("load library : ").append(localException.toString());
      bool = b(c, paramString);
      AppMethodBeat.o(14759);
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 14762
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +11 -> 22
    //   14: sipush 14762
    //   17: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: new 278	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 279	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 283	java/io/File:exists	()Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifne +11 -> 46
    //   38: sipush 14762
    //   41: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: new 285	android/media/MediaMetadataRetriever
    //   49: dup
    //   50: invokespecial 286	android/media/MediaMetadataRetriever:<init>	()V
    //   53: astore_3
    //   54: aload_3
    //   55: aload_0
    //   56: invokevirtual 289	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   59: aload_3
    //   60: invokevirtual 293	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   63: astore_0
    //   64: new 278	java/io/File
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 279	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 283	java/io/File:exists	()Z
    //   77: ifeq +8 -> 85
    //   80: aload_1
    //   81: invokevirtual 296	java/io/File:delete	()Z
    //   84: pop
    //   85: new 298	java/io/FileOutputStream
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 301	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: astore_1
    //   94: aload_0
    //   95: getstatic 307	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   98: bipush 100
    //   100: aload_1
    //   101: invokevirtual 313	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   104: pop
    //   105: aload_1
    //   106: invokevirtual 316	java/io/FileOutputStream:flush	()V
    //   109: aload_1
    //   110: invokevirtual 319	java/io/FileOutputStream:close	()V
    //   113: aload_3
    //   114: invokevirtual 322	android/media/MediaMetadataRetriever:release	()V
    //   117: sipush 14762
    //   120: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: iconst_1
    //   124: ireturn
    //   125: astore_0
    //   126: aconst_null
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 319	java/io/FileOutputStream:close	()V
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 322	android/media/MediaMetadataRetriever:release	()V
    //   146: sipush 14762
    //   149: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_1
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 319	java/io/FileOutputStream:close	()V
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 322	android/media/MediaMetadataRetriever:release	()V
    //   175: sipush 14762
    //   178: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: goto -71 -> 113
    //   187: astore_0
    //   188: goto -50 -> 138
    //   191: astore_1
    //   192: goto -25 -> 167
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -39 -> 159
    //   201: astore_0
    //   202: goto -43 -> 159
    //   205: astore_0
    //   206: aconst_null
    //   207: astore_0
    //   208: goto -78 -> 130
    //   211: astore_0
    //   212: aload_1
    //   213: astore_0
    //   214: goto -84 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramString1	String
    //   0	217	1	paramString2	String
    //   33	2	2	bool	boolean
    //   53	119	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   22	34	125	java/lang/Exception
    //   46	54	125	java/lang/Exception
    //   22	34	154	finally
    //   46	54	154	finally
    //   109	113	183	java/io/IOException
    //   134	138	187	java/io/IOException
    //   163	167	191	java/io/IOException
    //   54	85	195	finally
    //   85	94	195	finally
    //   94	109	201	finally
    //   54	85	205	java/lang/Exception
    //   85	94	205	java/lang/Exception
    //   94	109	211	java/lang/Exception
  }
  
  public static int[] a()
  {
    AppMethodBeat.i(14744);
    if (b)
    {
      b = false;
      ((b)g.a()).a();
      AppMethodBeat.o(14744);
      return new int[] { 0, 0 };
    }
    int[] arrayOfInt = ((b)g.a()).a();
    AppMethodBeat.o(14744);
    return arrayOfInt;
  }
  
  public static int b()
  {
    AppMethodBeat.i(14745);
    if ((f) || ((e != 0L) && (TXCTimeUtil.getTimeTick() - e < 15000L)))
    {
      k = d;
      AppMethodBeat.o(14745);
      return k;
    }
    f = true;
    AsyncTask.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(14721);
        System.currentTimeMillis();
        d.a(false);
        try
        {
          Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
          Debug.getMemoryInfo(localMemoryInfo);
          int i = localMemoryInfo.getTotalPss();
          d.a(TXCTimeUtil.getTimeTick());
          d.b(i / 1024);
          AppMethodBeat.o(14721);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(14721);
        }
      }
    });
    int k = d;
    AppMethodBeat.o(14745);
    return k;
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(14747);
    paramContext = TXCDRApi.getSimulateIDFA(paramContext);
    AppMethodBeat.o(14747);
    return paramContext;
  }
  
  public static void b(String paramString)
  {
    c = paramString;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14760);
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
    AppMethodBeat.o(14760);
    return bool1;
  }
  
  public static String c()
  {
    return Build.MODEL;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(14748);
    String str2 = "";
    String str1 = str2;
    if (paramContext != null) {}
    try
    {
      str1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      AppMethodBeat.o(14748);
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
    AppMethodBeat.i(14749);
    try
    {
      System.currentTimeMillis();
      if (paramContext != null)
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null)
        {
          boolean bool = paramContext.isAvailable();
          AppMethodBeat.o(14749);
          return bool;
        }
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(14749);
    }
    return false;
  }
  
  public static int e(Context paramContext)
  {
    AppMethodBeat.i(14750);
    if (paramContext == null)
    {
      AppMethodBeat.o(14750);
      return 0;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(14750);
      return 0;
    }
    if (!((NetworkInfo)localObject).isConnected())
    {
      AppMethodBeat.o(14750);
      return 0;
    }
    if (((NetworkInfo)localObject).getType() == 9)
    {
      AppMethodBeat.o(14750);
      return 5;
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(14750);
      return 1;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      switch (paramContext.getNetworkType())
      {
      default: 
        AppMethodBeat.o(14750);
        return 2;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        AppMethodBeat.o(14750);
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
        AppMethodBeat.o(14750);
        return 3;
      }
      AppMethodBeat.o(14750);
      return 2;
    }
    AppMethodBeat.o(14750);
    return 0;
  }
  
  public static String e()
  {
    AppMethodBeat.i(14751);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(14751);
    return str;
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(14752);
    paramContext = TXCDRApi.getDevUUID(paramContext, TXCDRApi.getSimulateIDFA(paramContext));
    AppMethodBeat.o(14752);
    return paramContext;
  }
  
  public static boolean f()
  {
    AppMethodBeat.i(14758);
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
      AppMethodBeat.o(14758);
      return bool;
    }
  }
  
  public static String g()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.d
 * JD-Core Version:    0.7.0.1
 */