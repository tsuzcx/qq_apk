package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.IndexCallback;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.math.BigDecimal;
import java.security.SecureRandom;

public final class kr
{
  public static double a(double paramDouble)
  {
    double d = paramDouble % 360.0D;
    if (d > 180.0D) {
      paramDouble = d - 360.0D;
    }
    do
    {
      return paramDouble;
      paramDouble = d;
    } while (d >= -180.0D);
    return d + 360.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return (paramDouble2 - paramDouble4) * paramDouble5 + (paramDouble3 - paramDouble1) * paramDouble6 + paramDouble1 * paramDouble4 - paramDouble3 * paramDouble2;
  }
  
  private static double a(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(222379);
    try
    {
      double d = new BigDecimal(paramDouble).setScale(paramInt, 4).doubleValue();
      AppMethodBeat.o(222379);
      return d;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(222379);
    }
    return paramDouble;
  }
  
  public static double a(Coordinate paramCoordinate1, Coordinate paramCoordinate2)
  {
    AppMethodBeat.i(222494);
    double d1 = paramCoordinate1.x() - paramCoordinate2.x();
    double d2 = paramCoordinate1.y() - paramCoordinate2.y();
    d1 = Math.sqrt(d1 * d1 + d2 * d2);
    AppMethodBeat.o(222494);
    return d1;
  }
  
  public static double a(Coordinate paramCoordinate1, Coordinate paramCoordinate2, double paramDouble, boolean paramBoolean, Coordinate paramCoordinate3)
  {
    AppMethodBeat.i(222615);
    double d5 = a(paramCoordinate1, paramCoordinate2) * 0.5D / Math.sin(b(0.5D * paramDouble));
    double d7 = (paramCoordinate1.x() + paramCoordinate2.x()) / 2.0D;
    double d6 = (paramCoordinate1.y() + paramCoordinate2.y()) / 2.0D;
    double d1 = Math.sqrt(Math.pow(d5, 2.0D) / (Math.pow(paramCoordinate1.x() - paramCoordinate2.x(), 2.0D) + Math.pow(paramCoordinate1.y() - paramCoordinate2.y(), 2.0D)) - 0.25D);
    double d3 = (paramCoordinate1.y() - paramCoordinate2.y()) * d1;
    double d4 = d1 * (paramCoordinate2.x() - paramCoordinate1.x());
    d1 = d4;
    double d2 = d3;
    if (paramDouble - 90.0D <= 1.0E-006D)
    {
      d2 = -d3;
      d1 = -d4;
    }
    paramDouble = d2;
    if (Double.isNaN(d2)) {
      paramDouble = 0.0D;
    }
    if (Double.isNaN(d1)) {
      d1 = 0.0D;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramDouble = d7 + paramDouble;
        if (!paramBoolean) {
          break label268;
        }
      }
      label268:
      for (d1 = d6 + d1;; d1 = d6 - d1)
      {
        paramCoordinate3.setX(paramDouble);
        paramCoordinate3.setY(d1);
        AppMethodBeat.o(222615);
        return d5;
        paramDouble = d7 - paramDouble;
        break;
      }
    }
  }
  
  public static double a(Coordinate paramCoordinate1, Coordinate paramCoordinate2, Coordinate paramCoordinate3)
  {
    AppMethodBeat.i(222459);
    double d1 = a(paramCoordinate1, paramCoordinate2);
    double d2 = a(paramCoordinate1, paramCoordinate3);
    double d3 = a(paramCoordinate2, paramCoordinate3);
    if (d1 + d2 == d3)
    {
      AppMethodBeat.o(222459);
      return 0.0D;
    }
    if (d3 <= 1.0E-006D)
    {
      AppMethodBeat.o(222459);
      return d1;
    }
    if (d2 * d2 >= d1 * d1 + d3 * d3)
    {
      AppMethodBeat.o(222459);
      return d1;
    }
    if (d1 * d1 >= d2 * d2 + d3 * d3)
    {
      AppMethodBeat.o(222459);
      return d2;
    }
    double d4 = (d1 + d2 + d3) / 2.0D;
    d1 = Math.sqrt((d4 - d1) * d4 * (d4 - d2) * (d4 - d3)) * 2.0D / d3;
    AppMethodBeat.o(222459);
    return d1;
  }
  
  public static double a(Coordinate paramCoordinate1, Coordinate paramCoordinate2, Coordinate paramCoordinate3, Coordinate paramCoordinate4)
  {
    AppMethodBeat.i(222608);
    double d2 = 2.0D * (paramCoordinate2.x() - paramCoordinate1.x());
    double d3 = 2.0D * (paramCoordinate2.y() - paramCoordinate1.y());
    double d4 = paramCoordinate2.x() * paramCoordinate2.x() + paramCoordinate2.y() * paramCoordinate2.y() - paramCoordinate1.x() * paramCoordinate1.x() - paramCoordinate1.y() * paramCoordinate1.y();
    double d5 = 2.0D * (paramCoordinate3.x() - paramCoordinate2.x());
    double d6 = 2.0D * (paramCoordinate3.y() - paramCoordinate2.y());
    double d7 = paramCoordinate3.x() * paramCoordinate3.x() + paramCoordinate3.y() * paramCoordinate3.y() - paramCoordinate2.x() * paramCoordinate2.x() - paramCoordinate2.y() * paramCoordinate2.y();
    double d1 = (d4 * d6 - d7 * d3) / (d2 * d6 - d5 * d3);
    d2 = (d7 * d2 - d4 * d5) / (d2 * d6 - d3 * d5);
    paramCoordinate4.setX(d1);
    paramCoordinate4.setY(d2);
    d1 = Math.pow(paramCoordinate1.x() - d1, 2.0D);
    d1 = Math.sqrt(Math.pow(paramCoordinate1.y() - d2, 2.0D) + d1);
    AppMethodBeat.o(222608);
    return d1;
  }
  
  private static float a(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(222387);
    try
    {
      float f = new BigDecimal(paramFloat).setScale(paramInt, 4).floatValue();
      AppMethodBeat.o(222387);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(222387);
    }
    return paramFloat;
  }
  
  private static int a(int paramInt)
  {
    AppMethodBeat.i(222576);
    if (paramInt + 0 > 0)
    {
      paramInt = new SecureRandom().nextInt(paramInt + 0);
      AppMethodBeat.o(222576);
      return paramInt + 0;
    }
    if (paramInt + 0 == 0)
    {
      AppMethodBeat.o(222576);
      return 0;
    }
    AppMethodBeat.o(222576);
    return 0;
  }
  
  private static PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    AppMethodBeat.i(222400);
    if ((paramPointF2.x == paramPointF1.x) || (paramPointF4.x == paramPointF3.x))
    {
      AppMethodBeat.o(222400);
      return null;
    }
    float f3 = (paramPointF2.y - paramPointF1.y) / (paramPointF2.x - paramPointF1.x);
    float f1 = (paramPointF4.y - paramPointF3.y) / (paramPointF4.x - paramPointF3.x);
    if (f3 == f1)
    {
      AppMethodBeat.o(222400);
      return null;
    }
    float f4 = (paramPointF1.y * paramPointF2.x - paramPointF2.y * paramPointF1.x) / (paramPointF2.x - paramPointF1.x);
    float f2 = (paramPointF3.y * paramPointF4.x - paramPointF4.y * paramPointF3.x) / (paramPointF4.x - paramPointF3.x);
    f3 = (f2 - f4) / (f3 - f1);
    paramPointF1 = new PointF(f3, f1 * f3 + f2);
    AppMethodBeat.o(222400);
    return paramPointF1;
  }
  
  private static Rect a(GeoPoint paramGeoPoint, Rect paramRect)
  {
    AppMethodBeat.i(222417);
    int i = Math.max(Math.abs(paramRect.left - paramGeoPoint.getLongitudeE6()), Math.abs(paramRect.right - paramGeoPoint.getLongitudeE6()));
    int j = Math.max(Math.abs(paramRect.top - paramGeoPoint.getLatitudeE6()), Math.abs(paramRect.bottom - paramGeoPoint.getLatitudeE6()));
    paramGeoPoint = new Rect(paramGeoPoint.getLongitudeE6() - j, paramGeoPoint.getLatitudeE6() - i, j + paramGeoPoint.getLongitudeE6(), i + paramGeoPoint.getLatitudeE6());
    AppMethodBeat.o(222417);
    return paramGeoPoint;
  }
  
  private static Rect a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(222425);
    if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null) || (paramGeoPoint1.equals(paramGeoPoint2)))
    {
      AppMethodBeat.o(222425);
      return null;
    }
    int i = Math.abs(paramGeoPoint1.getLongitudeE6() - paramGeoPoint2.getLongitudeE6());
    int j = Math.abs(paramGeoPoint1.getLatitudeE6() - paramGeoPoint2.getLatitudeE6());
    paramGeoPoint1 = new Rect(paramGeoPoint1.getLongitudeE6() - i, paramGeoPoint1.getLatitudeE6() - j, i + paramGeoPoint1.getLongitudeE6(), j + paramGeoPoint1.getLatitudeE6());
    AppMethodBeat.o(222425);
    return paramGeoPoint1;
  }
  
  private static GeoPoint a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, GeoPoint paramGeoPoint3)
  {
    AppMethodBeat.i(222432);
    int k = paramGeoPoint2.getLatitudeE6() - paramGeoPoint1.getLatitudeE6();
    int i = paramGeoPoint2.getLongitudeE6() - paramGeoPoint1.getLongitudeE6();
    if ((k == 0) && (i == 0))
    {
      AppMethodBeat.o(222432);
      return null;
    }
    double d = ((paramGeoPoint3.getLatitudeE6() - paramGeoPoint1.getLatitudeE6()) * k + (paramGeoPoint3.getLongitudeE6() - paramGeoPoint1.getLongitudeE6()) * i) / (k * k + i * i);
    if (d < 0.0D)
    {
      paramGeoPoint1 = new GeoPoint(paramGeoPoint1);
      AppMethodBeat.o(222432);
      return paramGeoPoint1;
    }
    if (d > 1.0D)
    {
      paramGeoPoint1 = new GeoPoint(paramGeoPoint2);
      AppMethodBeat.o(222432);
      return paramGeoPoint1;
    }
    int j = paramGeoPoint1.getLatitudeE6();
    k = (int)(k * d);
    int m = paramGeoPoint1.getLongitudeE6();
    paramGeoPoint1 = new GeoPoint(k + j, (int)(d * i) + m);
    AppMethodBeat.o(222432);
    return paramGeoPoint1;
  }
  
  public static LatLng a(LatLng paramLatLng1, LatLng paramLatLng2, int paramInt)
  {
    AppMethodBeat.i(222486);
    double d1;
    if (paramLatLng2.longitude > paramLatLng1.longitude)
    {
      d1 = paramLatLng1.longitude - paramInt;
      if (paramLatLng2.latitude <= paramLatLng1.latitude) {
        break label75;
      }
    }
    label75:
    for (double d2 = paramLatLng1.latitude - paramInt;; d2 = paramLatLng1.latitude + paramInt)
    {
      paramLatLng1 = new LatLng(d2, d1);
      AppMethodBeat.o(222486);
      return paramLatLng1;
      d1 = paramLatLng1.longitude + paramInt;
      break;
    }
  }
  
  public static LatLng a(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    AppMethodBeat.i(222478);
    paramLatLng3 = a(paramLatLng2, paramLatLng3);
    double d2;
    double d1;
    if (Double.isNaN(paramLatLng3[0]))
    {
      d2 = paramLatLng2.longitude;
      d1 = paramLatLng1.latitude;
    }
    for (;;)
    {
      paramLatLng1 = new LatLng(d1, d2);
      AppMethodBeat.o(222478);
      return paramLatLng1;
      if (paramLatLng3[0] == 0.0D)
      {
        d2 = paramLatLng1.longitude;
        d1 = paramLatLng2.latitude;
      }
      else
      {
        d1 = paramLatLng3[0];
        d2 = d1 * d1;
        d2 = (paramLatLng2.longitude * d2 + (paramLatLng1.latitude - paramLatLng2.latitude) * d1 + paramLatLng1.longitude) / (d2 + 1.0D);
        d1 = d1 * (d2 - paramLatLng2.longitude) + paramLatLng2.latitude;
      }
    }
  }
  
  private static String a()
  {
    AppMethodBeat.i(222565);
    Object localObject = new SecureRandom();
    byte[] arrayOfByte = new byte[20];
    ((SecureRandom)localObject).nextBytes(arrayOfByte);
    localObject = new String(arrayOfByte);
    AppMethodBeat.o(222565);
    return localObject;
  }
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 210
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aconst_null
    //   8: astore_3
    //   9: new 212	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: ldc 217
    //   20: invokestatic 223	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   23: astore_3
    //   24: ldc 224
    //   26: newarray byte
    //   28: astore 4
    //   30: aload_0
    //   31: aload 4
    //   33: invokevirtual 228	java/io/FileInputStream:read	([B)I
    //   36: istore_2
    //   37: iload_2
    //   38: ifle +27 -> 65
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: iload_2
    //   46: invokevirtual 232	java/security/MessageDigest:update	([BII)V
    //   49: goto -19 -> 30
    //   52: astore_3
    //   53: aload_0
    //   54: invokestatic 237	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   57: ldc 210
    //   59: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc 239
    //   64: areturn
    //   65: new 241	java/math/BigInteger
    //   68: dup
    //   69: iconst_1
    //   70: aload_3
    //   71: invokevirtual 245	java/security/MessageDigest:digest	()[B
    //   74: invokespecial 248	java/math/BigInteger:<init>	(I[B)V
    //   77: bipush 16
    //   79: invokevirtual 252	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   82: astore_3
    //   83: bipush 40
    //   85: aload_3
    //   86: invokevirtual 255	java/lang/String:length	()I
    //   89: isub
    //   90: istore_2
    //   91: aload_3
    //   92: astore 4
    //   94: iload_2
    //   95: ifle +29 -> 124
    //   98: aload_3
    //   99: astore 4
    //   101: iload_1
    //   102: iload_2
    //   103: if_icmpge +21 -> 124
    //   106: ldc_w 257
    //   109: aload_3
    //   110: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore_3
    //   117: iload_1
    //   118: iconst_1
    //   119: iadd
    //   120: istore_1
    //   121: goto -23 -> 98
    //   124: aload_0
    //   125: invokestatic 237	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   128: ldc 210
    //   130: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload 4
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: invokestatic 237	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   143: goto -86 -> 57
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_3
    //   149: aload_3
    //   150: invokestatic 237	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   153: ldc 210
    //   155: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_0
    //   159: athrow
    //   160: astore_3
    //   161: aload_0
    //   162: astore 4
    //   164: aload_3
    //   165: astore_0
    //   166: aload 4
    //   168: astore_3
    //   169: goto -20 -> 149
    //   172: astore_3
    //   173: goto -34 -> 139
    //   176: astore_0
    //   177: aload_3
    //   178: astore_0
    //   179: goto -126 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramFile	java.io.File
    //   1	120	1	i	int
    //   36	68	2	j	int
    //   8	34	3	localMessageDigest	java.security.MessageDigest
    //   52	19	3	localIOException	java.io.IOException
    //   82	68	3	str	String
    //   160	5	3	localObject1	Object
    //   168	1	3	localObject2	Object
    //   172	6	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   28	139	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	30	52	java/io/IOException
    //   30	37	52	java/io/IOException
    //   41	49	52	java/io/IOException
    //   65	91	52	java/io/IOException
    //   106	117	52	java/io/IOException
    //   9	18	136	java/security/NoSuchAlgorithmException
    //   9	18	146	finally
    //   18	30	160	finally
    //   30	37	160	finally
    //   41	49	160	finally
    //   65	91	160	finally
    //   106	117	160	finally
    //   18	30	172	java/security/NoSuchAlgorithmException
    //   30	37	172	java/security/NoSuchAlgorithmException
    //   41	49	172	java/security/NoSuchAlgorithmException
    //   65	91	172	java/security/NoSuchAlgorithmException
    //   106	117	172	java/security/NoSuchAlgorithmException
    //   9	18	176	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(222583);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(222583);
      return paramString;
    }
    paramString = Util.getMD5String(paramString.getBytes());
    AppMethodBeat.o(222583);
    return paramString;
  }
  
  public static <T extends Coordinate> void a(T paramT1, double paramDouble, T paramT2, T paramT3, boolean paramBoolean, IndexCallback<Pair<Double, Double>> paramIndexCallback)
  {
    AppMethodBeat.i(222629);
    double d6 = Math.atan((paramT1.y() - paramT2.y()) / (paramT1.x() - paramT2.x())) * 180.0D / 3.141592653589793D;
    boolean bool;
    double d1;
    int i;
    label76:
    double d2;
    label97:
    double d3;
    if (paramT1.x() > paramT2.x()) {
      if (!paramBoolean)
      {
        bool = true;
        d1 = 0.0D;
        i = 0;
        if (i >= 360) {
          break label454;
        }
        if (!paramBoolean) {
          break label399;
        }
        d2 = d6 - i;
        d3 = Math.tan(b(d2));
        if ((d1 == 0.0D) || (d1 * d3 >= 0.0D) || (Math.abs(d3) <= 1.0D)) {
          break label461;
        }
        if (bool) {
          break label410;
        }
        bool = true;
      }
    }
    label142:
    label284:
    label300:
    label430:
    label444:
    label454:
    label461:
    for (;;)
    {
      double d5 = paramDouble / Math.sqrt(d3 * d3 + 1.0D);
      double d4 = d3 * d5;
      kh.b("TDZ", i + ":curDeltaK[" + d3 + "]deltaKChanged[" + bool + "]clockwise[" + paramBoolean + "]deltaX[" + d5 + "]deltaY[" + d4 + "]");
      d1 = d4;
      d2 = d5;
      if (bool)
      {
        d2 = -d5;
        d1 = -d4;
      }
      if (paramBoolean)
      {
        d2 = paramT1.x() - d2;
        if (!paramBoolean) {
          break label430;
        }
        d1 = paramT1.y() - d1;
        d4 = a(paramT2.x(), paramT2.y(), paramT3.x(), paramT3.y(), d2, d1);
        if (!paramBoolean) {
          break label444;
        }
        if (d4 <= 0.0D) {}
      }
      for (;;)
      {
        paramIndexCallback.callback(i, new Pair(Double.valueOf(d2), Double.valueOf(d1)));
        do
        {
          i += 1;
          d1 = d3;
          break label76;
          bool = false;
          break;
          bool = paramBoolean;
          break;
          d2 = i + d6;
          break label97;
          bool = false;
          break label142;
          d2 = paramT1.x() + d2;
          break label284;
          d1 = paramT1.y() + d1;
          break label300;
        } while (d4 >= 0.0D);
      }
      AppMethodBeat.o(222629);
      return;
    }
  }
  
  public static boolean a(LatLng paramLatLng1, double paramDouble, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    AppMethodBeat.i(222504);
    if (a(paramLatLng1, paramLatLng2, paramLatLng3) - paramDouble > 1.0E-006D)
    {
      AppMethodBeat.o(222504);
      return false;
    }
    paramLatLng1 = a(paramLatLng1, paramLatLng2, paramLatLng3);
    paramDouble = a(paramLatLng1, paramLatLng2);
    double d = a(paramLatLng1, paramLatLng3);
    if (a(paramLatLng2, paramLatLng3) - paramDouble - d < 1.0E-006D)
    {
      AppMethodBeat.o(222504);
      return true;
    }
    AppMethodBeat.o(222504);
    return false;
  }
  
  private static double[] a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(222449);
    double d1;
    double d2;
    if (Math.abs(paramLatLng1.longitude - paramLatLng2.longitude) < 1.0E-006D)
    {
      d1 = (0.0D / 0.0D);
      d2 = (0.0D / 0.0D);
    }
    for (;;)
    {
      AppMethodBeat.o(222449);
      return new double[] { d2, d1 };
      if (Math.abs(paramLatLng1.latitude - paramLatLng2.latitude) < 1.0E-006D)
      {
        d1 = paramLatLng1.latitude;
        d2 = 0.0D;
      }
      else
      {
        d2 = (paramLatLng2.latitude - paramLatLng1.latitude) / (paramLatLng2.longitude - paramLatLng1.longitude);
        d1 = (paramLatLng2.longitude * paramLatLng1.latitude - paramLatLng1.longitude * paramLatLng2.latitude) / (paramLatLng2.longitude - paramLatLng1.latitude);
      }
    }
  }
  
  private static double b(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  private static double b(Coordinate paramCoordinate1, Coordinate paramCoordinate2)
  {
    AppMethodBeat.i(222526);
    double d = (paramCoordinate1.y() - paramCoordinate2.y()) / (paramCoordinate1.x() - paramCoordinate2.x());
    AppMethodBeat.o(222526);
    return d;
  }
  
  public static double b(Coordinate paramCoordinate1, Coordinate paramCoordinate2, Coordinate paramCoordinate3)
  {
    AppMethodBeat.i(222555);
    double d1 = a(paramCoordinate1, paramCoordinate2);
    double d2 = a(paramCoordinate3, paramCoordinate1, paramCoordinate2);
    d1 = Math.atan(d1 / 2.0D / d2);
    d2 = a(paramCoordinate1, paramCoordinate3);
    AppMethodBeat.o(222555);
    return d1 * 2.0D * d2;
  }
  
  private static double[] b(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    double d2 = 0.0D;
    AppMethodBeat.i(222469);
    paramLatLng2 = a(paramLatLng2, paramLatLng3);
    double d1;
    if (Double.isNaN(paramLatLng2[0])) {
      d1 = paramLatLng1.latitude;
    }
    for (;;)
    {
      AppMethodBeat.o(222469);
      return new double[] { d2, d1 };
      if (paramLatLng2[0] == 0.0D)
      {
        d1 = (0.0D / 0.0D);
        d2 = (0.0D / 0.0D);
      }
      else
      {
        d2 = -1.0D / paramLatLng2[0];
        d1 = 1.0D / paramLatLng2[0] * paramLatLng1.longitude + paramLatLng1.latitude;
      }
    }
  }
  
  private static double c(double paramDouble)
  {
    return 180.0D * paramDouble / 3.141592653589793D;
  }
  
  private static double c(Coordinate paramCoordinate1, Coordinate paramCoordinate2)
  {
    AppMethodBeat.i(222536);
    double d = Math.atan((paramCoordinate1.y() - paramCoordinate2.y()) / (paramCoordinate1.x() - paramCoordinate2.x())) * 180.0D / 3.141592653589793D;
    AppMethodBeat.o(222536);
    return d;
  }
  
  private static double c(Coordinate paramCoordinate1, Coordinate paramCoordinate2, Coordinate paramCoordinate3)
  {
    AppMethodBeat.i(222545);
    double d1 = a(paramCoordinate1, paramCoordinate2);
    double d2 = a(paramCoordinate3, paramCoordinate1, paramCoordinate2);
    d1 = Math.atan(d1 / 2.0D / d2);
    AppMethodBeat.o(222545);
    return d1 * 2.0D;
  }
  
  private static boolean c(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    AppMethodBeat.i(222510);
    double d1 = a(paramLatLng1, paramLatLng2);
    double d2 = a(paramLatLng1, paramLatLng3);
    if (a(paramLatLng2, paramLatLng3) - d1 - d2 < 1.0E-006D)
    {
      AppMethodBeat.o(222510);
      return true;
    }
    AppMethodBeat.o(222510);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kr
 * JD-Core Version:    0.7.0.1
 */