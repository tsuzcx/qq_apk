package com.tencent.liteav.basic.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.UUID;

public class a
{
  public static long a = 0L;
  private static float b = 0.0F;
  private static float c = 0.0F;
  private static float d = 0.0F;
  private static float e = 0.0F;
  private static float f = 0.0F;
  private static float g = 0.0F;
  private static boolean h = true;
  private static int[] i = new int[2];
  private static long j = 0L;
  private static String k = "";
  private static final Object l = new Object();
  private static boolean m = false;
  private static int[] n = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  
  public static int a(int paramInt)
  {
    int i1 = 0;
    while ((i1 < n.length) && (n[i1] != paramInt)) {
      i1 += 1;
    }
    paramInt = i1;
    if (i1 >= n.length) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  @TargetApi(16)
  public static MediaFormat a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = a(paramInt1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.put(0, (byte)(paramInt3 << 3 | i1 >> 1));
    localByteBuffer.put(1, (byte)((i1 & 0x1) << 7 | paramInt2 << 3));
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
    localMediaFormat.setInteger("channel-count", paramInt2);
    localMediaFormat.setInteger("sample-rate", paramInt1);
    localMediaFormat.setByteBuffer("csd-0", localByteBuffer);
    return localMediaFormat;
  }
  
  @TargetApi(16)
  public static MediaFormat a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
    paramInt1 = 0;
    int i6 = 0;
    int i2 = 0;
    int i1 = 0;
    paramInt2 = 0;
    if (paramInt1 + 3 < paramArrayOfByte.length) {
      if ((paramArrayOfByte[paramInt1] != 0) || (paramArrayOfByte[(paramInt1 + 1)] != 0) || (paramArrayOfByte[(paramInt1 + 2)] != 1)) {
        break label299;
      }
    }
    label299:
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
          return localMediaFormat;
        }
        if ((i1 != 0) && (paramInt1 == 7))
        {
          a("csd-0", localMediaFormat, paramArrayOfByte, i2, i6);
          return localMediaFormat;
        }
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
    if (paramInt1 * paramInt4 >= paramInt2 * paramInt3)
    {
      paramInt4 = paramInt2 * paramInt3 / paramInt4;
      paramInt3 = paramInt2;
      if (paramInt1 <= paramInt4) {
        break label67;
      }
    }
    label67:
    for (paramInt1 = paramInt1 - paramInt4 >> 1;; paramInt1 = 0)
    {
      if (paramInt2 > paramInt3) {
        i1 = paramInt2 - paramInt3 >> 1;
      }
      return new com.tencent.liteav.basic.d.a(paramInt1, i1, paramInt4, paramInt3);
      paramInt3 = paramInt1 * paramInt4 / paramInt3;
      paramInt4 = paramInt1;
      break;
    }
  }
  
  public static String a(Context paramContext)
  {
    return TXCDRApi.getSimulateIDFA(paramContext);
  }
  
  public static void a(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return;
    }
    catch (Error localError)
    {
      new StringBuilder("load library : ").append(localError.toString());
      b(k, paramString);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("load library : ").append(localException.toString());
      b(k, paramString);
    }
  }
  
  private static void a(String paramString, MediaFormat paramMediaFormat, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 - paramInt1);
    localByteBuffer.put(paramArrayOfByte, paramInt1, paramInt2 - paramInt1);
    localByteBuffer.position(0);
    paramMediaFormat.setByteBuffer(paramString, localByteBuffer);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, int paramInt, Bundle paramBundle)
  {
    if (paramWeakReference == null) {}
    do
    {
      return;
      paramWeakReference = (com.tencent.liteav.basic.c.a)paramWeakReference.get();
    } while (paramWeakReference == null);
    paramWeakReference.onNotifyEvent(paramInt, paramBundle);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    a(paramWeakReference, paramInt, localBundle);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, long paramLong, int paramInt, Bundle paramBundle)
  {
    if (paramWeakReference == null) {}
    do
    {
      return;
      paramWeakReference = (com.tencent.liteav.basic.c.a)paramWeakReference.get();
    } while (paramWeakReference == null);
    paramBundle.putLong("EVT_USERID", paramLong);
    paramWeakReference.onNotifyEvent(paramInt, paramBundle);
  }
  
  public static void a(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference, long paramLong, int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_USERID", paramLong);
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    a(paramWeakReference, paramInt, localBundle);
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: new 219	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 224	java/io/File:exists	()Z
    //   21: ifeq -13 -> 8
    //   24: new 226	android/media/MediaMetadataRetriever
    //   27: dup
    //   28: invokespecial 227	android/media/MediaMetadataRetriever:<init>	()V
    //   31: astore_2
    //   32: aload_2
    //   33: aload_0
    //   34: invokevirtual 230	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 234	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   41: astore_0
    //   42: new 219	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 224	java/io/File:exists	()Z
    //   55: ifeq +8 -> 63
    //   58: aload_1
    //   59: invokevirtual 237	java/io/File:delete	()Z
    //   62: pop
    //   63: new 239	java/io/FileOutputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 242	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: astore_1
    //   72: aload_0
    //   73: getstatic 248	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   76: bipush 100
    //   78: aload_1
    //   79: invokevirtual 254	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   82: pop
    //   83: aload_1
    //   84: invokevirtual 257	java/io/FileOutputStream:flush	()V
    //   87: aload_1
    //   88: invokevirtual 260	java/io/FileOutputStream:close	()V
    //   91: aload_2
    //   92: invokevirtual 263	android/media/MediaMetadataRetriever:release	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 260	java/io/FileOutputStream:close	()V
    //   110: aload_2
    //   111: ifnull -103 -> 8
    //   114: aload_2
    //   115: invokevirtual 263	android/media/MediaMetadataRetriever:release	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 260	java/io/FileOutputStream:close	()V
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 263	android/media/MediaMetadataRetriever:release	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: goto -53 -> 91
    //   147: astore_0
    //   148: goto -38 -> 110
    //   151: astore_1
    //   152: goto -19 -> 133
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -33 -> 125
    //   161: astore_0
    //   162: goto -37 -> 125
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_0
    //   168: goto -66 -> 102
    //   171: astore_0
    //   172: aload_1
    //   173: astore_0
    //   174: goto -72 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString1	String
    //   0	177	1	paramString2	String
    //   31	107	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   10	32	97	java/lang/Exception
    //   10	32	120	finally
    //   87	91	143	java/io/IOException
    //   106	110	147	java/io/IOException
    //   129	133	151	java/io/IOException
    //   32	63	155	finally
    //   63	72	155	finally
    //   72	87	161	finally
    //   32	63	165	java/lang/Exception
    //   63	72	165	java/lang/Exception
    //   72	87	171	java/lang/Exception
  }
  
  public static int[] a()
  {
    if ((j != 0L) && (TXCTimeUtil.getTimeTick() - j < 2000L)) {
      return i;
    }
    int[] arrayOfInt = new int[2];
    if (h)
    {
      d = (float)f();
      g();
      h = false;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      return arrayOfInt;
    }
    e = (float)f();
    g();
    float f2;
    float f1;
    if (c != b)
    {
      f2 = (e - d) * 100.0F / (c - b);
      f1 = (c - b - (g - f)) * 100.0F / (c - b);
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
      return arrayOfInt;
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static String b(Context paramContext)
  {
    String str = "";
    if (paramContext != null) {}
    try
    {
      str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      return str;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static void b(String paramString)
  {
    k = paramString;
  }
  
  private static void b(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1)) {
        System.load(paramString1 + "/lib" + paramString2 + ".so");
      }
      return;
    }
    catch (Error paramString1)
    {
      new StringBuilder("load library : ").append(paramString1.toString());
      return;
    }
    catch (Exception paramString1)
    {
      new StringBuilder("load library : ").append(paramString1.toString());
    }
  }
  
  public static int c(Context paramContext)
  {
    if (paramContext == null) {
      return 255;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return 255;
    }
    if (!((NetworkInfo)localObject).isConnected()) {
      return 255;
    }
    if (((NetworkInfo)localObject).getType() == 9) {
      return 5;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 1;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      switch (paramContext.getNetworkType())
      {
      default: 
        return 2;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
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
        return 3;
      }
      return 2;
    }
    return 255;
  }
  
  public static String c()
  {
    return UUID.randomUUID().toString();
  }
  
  public static String d(Context paramContext)
  {
    return TXCDRApi.getDevUUID(paramContext, TXCDRApi.getSimulateIDFA(paramContext));
  }
  
  public static void d()
  {
    synchronized (l)
    {
      if (!m)
      {
        a("stlport_shared");
        a("saturn");
        a("txffmpeg");
        a("liteavsdk");
        m = true;
      }
      return;
    }
  }
  
  public static String e()
  {
    return k;
  }
  
  private static long f()
  {
    long l2 = 0L;
    try
    {
      int i1 = Process.myPid();
      Object localObject = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i1 + "/stat")), 1000);
      String str = ((BufferedReader)localObject).readLine();
      ((BufferedReader)localObject).close();
      localObject = str.split(" ");
      long l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!TextUtils.isEmpty(localObject[13]))
        {
          l1 = Long.parseLong(localObject[13]);
          l2 = Long.parseLong(localObject[14]);
          long l3 = Long.parseLong(localObject[15]);
          long l4 = Long.parseLong(localObject[16]);
          l1 = l4 + (l1 + l2 + l3);
        }
      }
      return l1;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  /* Error */
  private static void g()
  {
    // Byte code:
    //   0: getstatic 411	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 26
    //   5: if_icmpge +215 -> 220
    //   8: new 369	java/io/BufferedReader
    //   11: dup
    //   12: new 371	java/io/InputStreamReader
    //   15: dup
    //   16: new 373	java/io/FileInputStream
    //   19: dup
    //   20: ldc_w 413
    //   23: invokespecial 381	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 384	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: sipush 1000
    //   32: invokespecial 387	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   35: astore 14
    //   37: aload 14
    //   39: invokevirtual 390	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 15
    //   44: aload 14
    //   46: invokevirtual 391	java/io/BufferedReader:close	()V
    //   49: aload 15
    //   51: ldc_w 393
    //   54: invokevirtual 399	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore 14
    //   59: aload 14
    //   61: ifnull +159 -> 220
    //   64: aload 14
    //   66: arraylength
    //   67: bipush 9
    //   69: if_icmplt +151 -> 220
    //   72: aload 14
    //   74: iconst_2
    //   75: aaload
    //   76: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   79: lstore_0
    //   80: aload 14
    //   82: iconst_3
    //   83: aaload
    //   84: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   87: lstore_2
    //   88: aload 14
    //   90: iconst_4
    //   91: aaload
    //   92: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   95: lstore 4
    //   97: aload 14
    //   99: bipush 6
    //   101: aaload
    //   102: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: lstore 6
    //   107: aload 14
    //   109: iconst_5
    //   110: aaload
    //   111: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   114: lstore 8
    //   116: aload 14
    //   118: bipush 7
    //   120: aaload
    //   121: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   124: lstore 10
    //   126: aload 14
    //   128: bipush 8
    //   130: aaload
    //   131: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   134: lstore 12
    //   136: lload_0
    //   137: lload_2
    //   138: ladd
    //   139: lload 4
    //   141: ladd
    //   142: lload 6
    //   144: ladd
    //   145: lload 8
    //   147: ladd
    //   148: lload 10
    //   150: ladd
    //   151: lload 12
    //   153: ladd
    //   154: lstore_2
    //   155: aload 14
    //   157: iconst_5
    //   158: aaload
    //   159: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   162: lstore_0
    //   163: aload 14
    //   165: bipush 6
    //   167: aaload
    //   168: invokestatic 405	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   171: lstore 4
    //   173: lload 4
    //   175: lload_0
    //   176: ladd
    //   177: lstore_0
    //   178: getstatic 40	com/tencent/liteav/basic/util/a:h	Z
    //   181: ifeq +23 -> 204
    //   184: lload_2
    //   185: l2f
    //   186: putstatic 28	com/tencent/liteav/basic/util/a:b	F
    //   189: lload_0
    //   190: l2f
    //   191: putstatic 36	com/tencent/liteav/basic/util/a:f	F
    //   194: return
    //   195: astore 14
    //   197: lconst_0
    //   198: lstore_2
    //   199: lconst_0
    //   200: lstore_0
    //   201: goto -23 -> 178
    //   204: lload_2
    //   205: l2f
    //   206: putstatic 30	com/tencent/liteav/basic/util/a:c	F
    //   209: lload_0
    //   210: l2f
    //   211: putstatic 38	com/tencent/liteav/basic/util/a:g	F
    //   214: return
    //   215: astore 14
    //   217: goto -18 -> 199
    //   220: lconst_0
    //   221: lstore_0
    //   222: lconst_0
    //   223: lstore_2
    //   224: goto -46 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   79	143	0	l1	long
    //   87	137	2	l2	long
    //   95	79	4	l3	long
    //   105	38	6	l4	long
    //   114	32	8	l5	long
    //   124	25	10	l6	long
    //   134	18	12	l7	long
    //   35	129	14	localObject	Object
    //   195	1	14	localException1	Exception
    //   215	1	14	localException2	Exception
    //   42	8	15	str	String
    // Exception table:
    //   from	to	target	type
    //   8	59	195	java/lang/Exception
    //   64	136	195	java/lang/Exception
    //   155	173	215	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.util.a
 * JD-Core Version:    0.7.0.1
 */