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
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class b
{
  public static long a;
  private static float b;
  private static float c;
  private static float d;
  private static float e;
  private static float f;
  private static float g;
  private static boolean h;
  private static int[] i;
  private static long j;
  private static String k;
  private static int l;
  private static long m;
  private static final Object n;
  private static boolean o;
  private static int[] p;
  
  static
  {
    AppMethodBeat.i(66021);
    b = 0.0F;
    c = 0.0F;
    d = 0.0F;
    e = 0.0F;
    f = 0.0F;
    g = 0.0F;
    h = true;
    i = new int[2];
    j = 0L;
    k = "";
    a = 0L;
    l = 0;
    m = 0L;
    n = new Object();
    o = false;
    p = new int[] { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
    AppMethodBeat.o(66021);
  }
  
  public static int a(int paramInt)
  {
    int i1 = 0;
    while ((i1 < p.length) && (p[i1] != paramInt)) {
      i1 += 1;
    }
    paramInt = i1;
    if (i1 >= p.length) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  @TargetApi(16)
  public static MediaFormat a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66017);
    int i1 = a(paramInt1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.put(0, (byte)(paramInt3 << 3 | i1 >> 1));
    localByteBuffer.put(1, (byte)((i1 & 0x1) << 7 | paramInt2 << 3));
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    localMediaFormat.setInteger("channel-count", paramInt2);
    localMediaFormat.setInteger("sample-rate", paramInt1);
    localMediaFormat.setByteBuffer("csd-0", localByteBuffer);
    AppMethodBeat.o(66017);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  public static MediaFormat a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66020);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    paramInt1 = 0;
    int i6 = 0;
    int i2 = 0;
    int i1 = 0;
    paramInt2 = 0;
    if (paramInt1 + 3 < paramArrayOfByte.length) {
      if ((paramArrayOfByte[paramInt1] != 0) || (paramArrayOfByte[(paramInt1 + 1)] != 0) || (paramArrayOfByte[(paramInt1 + 2)] != 1)) {
        break label324;
      }
    }
    label324:
    for (int i4 = 3;; i4 = 0)
    {
      int i3 = i4;
      if (paramArrayOfByte[paramInt1] == 0)
      {
        i3 = i4;
        if (paramArrayOfByte[(paramInt1 + 1)] == 0)
        {
          i3 = i4;
          if (paramArrayOfByte[(paramInt1 + 2)] == 0)
          {
            i3 = i4;
            if (paramArrayOfByte[(paramInt1 + 3)] == 1) {
              i3 = 4;
            }
          }
        }
      }
      int i5 = paramInt1;
      i4 = i2;
      if (i3 > 0)
      {
        if (i2 == 0)
        {
          i5 = paramInt1 + i3;
          i4 = i3;
        }
      }
      else
      {
        i3 = i5;
        i2 = i4;
      }
      for (;;)
      {
        paramInt1 = i3 + 1;
        break;
        i5 = paramArrayOfByte[i2] & 0x1F;
        if (i5 == 7)
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, i2, paramInt1);
          i4 = 1;
        }
        for (;;)
        {
          paramInt2 = paramInt1 + i3;
          if ((i4 == 0) || (i1 == 0)) {
            break;
          }
          AppMethodBeat.o(66020);
          return localMediaFormat;
          i4 = paramInt2;
          if (i5 == 8)
          {
            a("csd-1", localMediaFormat, paramArrayOfByte, i2, paramInt1);
            i1 = 1;
            i4 = paramInt2;
          }
        }
        paramInt1 = paramArrayOfByte[i2] & 0x1F;
        if ((paramInt2 != 0) && (paramInt1 == 8))
        {
          a("csd-1", localMediaFormat, paramArrayOfByte, i2, i6);
          AppMethodBeat.o(66020);
          return localMediaFormat;
        }
        if ((i1 != 0) && (paramInt1 == 7))
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, i2, i6);
          AppMethodBeat.o(66020);
          return localMediaFormat;
        }
        AppMethodBeat.o(66020);
        return null;
        i3 = paramInt2;
        i6 = paramInt1;
        i2 = paramInt2;
        paramInt2 = i4;
      }
    }
  }
  
  public static com.tencent.liteav.basic.d.a a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    AppMethodBeat.i(146645);
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
        i1 = paramInt2 - paramInt4 >> 1;
      }
      com.tencent.liteav.basic.d.a locala = new com.tencent.liteav.basic.d.a(paramInt1, i1, paramInt3, paramInt4);
      AppMethodBeat.o(146645);
      return locala;
      paramInt4 = paramInt1 * paramInt4 / paramInt3;
      paramInt3 = paramInt1;
      break;
    }
  }
  
  private static void a(String paramString, MediaFormat paramMediaFormat, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66019);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 - paramInt1);
    localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2 - paramInt1);
    localByteBuffer.position(0);
    paramMediaFormat.setByteBuffer(paramString, localByteBuffer);
    AppMethodBeat.o(66019);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66011);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(66011);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.a)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(66011);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, int paramInt, String paramString)
  {
    AppMethodBeat.i(66010);
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(66010);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, String paramString, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(146644);
    if (paramWeakReference == null)
    {
      AppMethodBeat.o(146644);
      return;
    }
    paramWeakReference = (com.tencent.liteav.basic.c.a)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      paramBundle.putString("EVT_USERID", paramString);
      paramWeakReference.onNotifyEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(146644);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(146643);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", paramString1);
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString2 != null) {
      localBundle.putCharSequence("EVT_MSG", paramString2);
    }
    a(paramWeakReference, paramInt, localBundle);
    AppMethodBeat.o(146643);
  }
  
  public static boolean a(Context paramContext)
  {
    AppMethodBeat.i(146638);
    if (paramContext == null)
    {
      AppMethodBeat.o(146638);
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      if (((ActivityManager)localObject).getRunningTasks(1) == null)
      {
        TXCLog.e("TXCSystemUtil", "running task is null, ams is abnormal!!!");
        AppMethodBeat.o(146638);
        return false;
      }
      localObject = (ActivityManager.RunningTaskInfo)((ActivityManager)localObject).getRunningTasks(1).get(0);
      if ((localObject == null) || (((ActivityManager.RunningTaskInfo)localObject).topActivity == null))
      {
        TXCLog.e("TXCSystemUtil", "failed to get RunningTaskInfo");
        AppMethodBeat.o(146638);
        return false;
      }
      if (!((ActivityManager.RunningTaskInfo)localObject).topActivity.getPackageName().equals(paramContext.getPackageName()))
      {
        AppMethodBeat.o(146638);
        return true;
      }
      AppMethodBeat.o(146638);
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(146638);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(146647);
    boolean bool;
    try
    {
      System.loadLibrary(paramString);
      AppMethodBeat.o(146647);
      return true;
    }
    catch (Error localError)
    {
      new StringBuilder("load library : ").append(localError.toString());
      bool = b(k, paramString);
      AppMethodBeat.o(146647);
      return bool;
    }
    catch (Exception localException)
    {
      new StringBuilder("load library : ").append(localException.toString());
      bool = b(k, paramString);
      AppMethodBeat.o(146647);
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 289
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +11 -> 22
    //   14: ldc_w 289
    //   17: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: new 291	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 296	java/io/File:exists	()Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifne +11 -> 46
    //   38: ldc_w 289
    //   41: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: new 298	android/media/MediaMetadataRetriever
    //   49: dup
    //   50: invokespecial 299	android/media/MediaMetadataRetriever:<init>	()V
    //   53: astore_3
    //   54: aload_3
    //   55: aload_0
    //   56: invokevirtual 302	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   59: aload_3
    //   60: invokevirtual 306	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   63: astore_0
    //   64: new 291	java/io/File
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 296	java/io/File:exists	()Z
    //   77: ifeq +8 -> 85
    //   80: aload_1
    //   81: invokevirtual 309	java/io/File:delete	()Z
    //   84: pop
    //   85: new 311	java/io/FileOutputStream
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 314	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: astore_1
    //   94: aload_0
    //   95: getstatic 320	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   98: bipush 100
    //   100: aload_1
    //   101: invokevirtual 326	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   104: pop
    //   105: aload_1
    //   106: invokevirtual 329	java/io/FileOutputStream:flush	()V
    //   109: aload_1
    //   110: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   113: aload_3
    //   114: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   117: ldc_w 289
    //   120: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   135: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   146: ldc_w 289
    //   149: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   164: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   175: ldc_w 289
    //   178: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(66002);
    if ((j != 0L) && (TXCTimeUtil.getTimeTick() - j < 2000L))
    {
      arrayOfInt = i;
      AppMethodBeat.o(66002);
      return arrayOfInt;
    }
    int[] arrayOfInt = new int[2];
    if (h)
    {
      d = (float)h();
      i();
      h = false;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      AppMethodBeat.o(66002);
      return arrayOfInt;
    }
    e = (float)h();
    i();
    float f2;
    float f1;
    if (c != b)
    {
      f2 = 100.0F * (e - d) / (c - b);
      f1 = 100.0F * (c - b - (g - f)) / (c - b);
    }
    for (;;)
    {
      b = c;
      d = e;
      f = g;
      arrayOfInt[0] = ((int)(f2 * 10.0F));
      arrayOfInt[1] = ((int)(f1 * 10.0F));
      i[0] = arrayOfInt[0];
      i[1] = arrayOfInt[1];
      j = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(66002);
      return arrayOfInt;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public static int b()
  {
    AppMethodBeat.i(66003);
    try
    {
      if ((m != 0L) && (TXCTimeUtil.getTimeTick() - m < 10000L))
      {
        i1 = l;
        AppMethodBeat.o(66003);
        return i1;
      }
      Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
      Debug.getMemoryInfo(localMemoryInfo);
      i1 = localMemoryInfo.getTotalPss();
      m = TXCTimeUtil.getTimeTick();
      l = i1 / 1024;
    }
    catch (Exception localException)
    {
      int i1;
      label71:
      break label71;
    }
    i1 = l;
    AppMethodBeat.o(66003);
    return i1;
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(66005);
    paramContext = TXCDRApi.getSimulateIDFA(paramContext);
    AppMethodBeat.o(66005);
    return paramContext;
  }
  
  public static void b(String paramString)
  {
    k = paramString;
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(146648);
    bool2 = false;
    bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
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
    AppMethodBeat.o(146648);
    return bool1;
  }
  
  public static String c()
  {
    return Build.MODEL;
  }
  
  public static String c(Context paramContext)
  {
    AppMethodBeat.i(146639);
    String str2 = "";
    String str1 = str2;
    if (paramContext != null) {}
    try
    {
      str1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      AppMethodBeat.o(146639);
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
  
  public static int d(Context paramContext)
  {
    AppMethodBeat.i(146640);
    if (paramContext == null)
    {
      AppMethodBeat.o(146640);
      return 0;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(146640);
      return 0;
    }
    if (!((NetworkInfo)localObject).isConnected())
    {
      AppMethodBeat.o(146640);
      return 0;
    }
    if (((NetworkInfo)localObject).getType() == 9)
    {
      AppMethodBeat.o(146640);
      return 5;
    }
    if (((NetworkInfo)localObject).getType() == 1)
    {
      AppMethodBeat.o(146640);
      return 1;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      switch (paramContext.getNetworkType())
      {
      default: 
        AppMethodBeat.o(146640);
        return 2;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        AppMethodBeat.o(146640);
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
        AppMethodBeat.o(146640);
        return 3;
      }
      AppMethodBeat.o(146640);
      return 2;
    }
    AppMethodBeat.o(146640);
    return 0;
  }
  
  public static String d()
  {
    AppMethodBeat.i(66007);
    String str = Build.VERSION.RELEASE;
    AppMethodBeat.o(66007);
    return str;
  }
  
  public static String e()
  {
    AppMethodBeat.i(146641);
    String str = UUID.randomUUID().toString();
    AppMethodBeat.o(146641);
    return str;
  }
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(146642);
    paramContext = TXCDRApi.getDevUUID(paramContext, TXCDRApi.getSimulateIDFA(paramContext));
    AppMethodBeat.o(146642);
    return paramContext;
  }
  
  public static boolean f()
  {
    AppMethodBeat.i(146646);
    synchronized (n)
    {
      if (!o)
      {
        a("stlport_shared");
        a("saturn");
        a("txffmpeg");
        o = a("liteavsdk");
        new StringBuilder("load library success ").append(o);
      }
      boolean bool = o;
      AppMethodBeat.o(146646);
      return bool;
    }
  }
  
  public static String g()
  {
    return k;
  }
  
  private static long h()
  {
    AppMethodBeat.i(146636);
    l2 = 0L;
    try
    {
      int i1 = Process.myPid();
      Object localObject = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i1 + "/stat")), 1000);
      String str = ((BufferedReader)localObject).readLine();
      ((BufferedReader)localObject).close();
      localObject = str.split(" ");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!TextUtils.isEmpty(localObject[13]))
        {
          l1 = Long.parseLong(localObject[13]);
          long l3 = Long.parseLong(localObject[14]);
          long l4 = Long.parseLong(localObject[15]);
          long l5 = Long.parseLong(localObject[16]);
          l1 = l5 + (l1 + l3 + l4);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
      }
    }
    AppMethodBeat.o(146636);
    return l1;
  }
  
  /* Error */
  private static void i()
  {
    // Byte code:
    //   0: ldc_w 508
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 511	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 26
    //   11: if_icmpge +227 -> 238
    //   14: new 473	java/io/BufferedReader
    //   17: dup
    //   18: new 475	java/io/InputStreamReader
    //   21: dup
    //   22: new 477	java/io/FileInputStream
    //   25: dup
    //   26: ldc_w 513
    //   29: invokespecial 485	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 488	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   35: sipush 1000
    //   38: invokespecial 491	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   41: astore 14
    //   43: aload 14
    //   45: invokevirtual 494	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 15
    //   50: aload 14
    //   52: invokevirtual 495	java/io/BufferedReader:close	()V
    //   55: aload 15
    //   57: ldc_w 497
    //   60: invokevirtual 501	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   63: astore 14
    //   65: aload 14
    //   67: ifnull +171 -> 238
    //   70: aload 14
    //   72: arraylength
    //   73: bipush 9
    //   75: if_icmplt +163 -> 238
    //   78: aload 14
    //   80: iconst_2
    //   81: aaload
    //   82: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   85: lstore_0
    //   86: aload 14
    //   88: iconst_3
    //   89: aaload
    //   90: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   93: lstore_2
    //   94: aload 14
    //   96: iconst_4
    //   97: aaload
    //   98: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   101: lstore 4
    //   103: aload 14
    //   105: bipush 6
    //   107: aaload
    //   108: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   111: lstore 6
    //   113: aload 14
    //   115: iconst_5
    //   116: aaload
    //   117: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   120: lstore 8
    //   122: aload 14
    //   124: bipush 7
    //   126: aaload
    //   127: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   130: lstore 10
    //   132: aload 14
    //   134: bipush 8
    //   136: aaload
    //   137: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   140: lstore 12
    //   142: lload_0
    //   143: lload_2
    //   144: ladd
    //   145: lload 4
    //   147: ladd
    //   148: lload 6
    //   150: ladd
    //   151: lload 8
    //   153: ladd
    //   154: lload 10
    //   156: ladd
    //   157: lload 12
    //   159: ladd
    //   160: lstore_2
    //   161: aload 14
    //   163: iconst_5
    //   164: aaload
    //   165: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   168: lstore_0
    //   169: aload 14
    //   171: bipush 6
    //   173: aaload
    //   174: invokestatic 507	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   177: lstore 4
    //   179: lload 4
    //   181: lload_0
    //   182: ladd
    //   183: lstore_0
    //   184: getstatic 49	com/tencent/liteav/basic/util/b:h	Z
    //   187: ifeq +29 -> 216
    //   190: lload_2
    //   191: l2f
    //   192: putstatic 37	com/tencent/liteav/basic/util/b:b	F
    //   195: lload_0
    //   196: l2f
    //   197: putstatic 45	com/tencent/liteav/basic/util/b:f	F
    //   200: ldc_w 508
    //   203: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: return
    //   207: astore 14
    //   209: lconst_0
    //   210: lstore_2
    //   211: lconst_0
    //   212: lstore_0
    //   213: goto -29 -> 184
    //   216: lload_2
    //   217: l2f
    //   218: putstatic 39	com/tencent/liteav/basic/util/b:c	F
    //   221: lload_0
    //   222: l2f
    //   223: putstatic 47	com/tencent/liteav/basic/util/b:g	F
    //   226: ldc_w 508
    //   229: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: return
    //   233: astore 14
    //   235: goto -24 -> 211
    //   238: lconst_0
    //   239: lstore_0
    //   240: lconst_0
    //   241: lstore_2
    //   242: goto -58 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   85	155	0	l1	long
    //   93	149	2	l2	long
    //   101	79	4	l3	long
    //   111	38	6	l4	long
    //   120	32	8	l5	long
    //   130	25	10	l6	long
    //   140	18	12	l7	long
    //   41	129	14	localObject	Object
    //   207	1	14	localException1	Exception
    //   233	1	14	localException2	Exception
    //   48	8	15	str	String
    // Exception table:
    //   from	to	target	type
    //   14	65	207	java/lang/Exception
    //   70	142	207	java/lang/Exception
    //   161	179	233	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.basic.util.b
 * JD-Core Version:    0.7.0.1
 */