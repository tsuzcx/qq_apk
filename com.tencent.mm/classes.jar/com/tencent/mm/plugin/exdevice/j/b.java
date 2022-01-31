package com.tencent.mm.plugin.exdevice.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public final class b
{
  public static int A(Context paramContext, int paramInt)
  {
    int i = 0;
    if (paramContext != null) {
      try
      {
        Rect localRect = new Rect();
        ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        i = ((Activity)paramContext).getWindow().getDecorView().getHeight();
        if (i - localRect.height() >= 0) {
          i -= localRect.height();
        } else {
          i = localRect.top;
        }
      }
      catch (Exception paramContext)
      {
        y.i("MicroMsg.exdevice.Util", "getStatusHeight err: %s", new Object[] { paramContext.toString() });
      }
      finally
      {
        return paramInt;
      }
    }
    while (i > 0) {
      return i;
    }
    return paramInt;
  }
  
  public static long BU(String paramString)
  {
    int n = 0;
    long l2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.exdevice.Util", "mac string is null or nil");
      l2 = 0L;
      return l2;
    }
    paramString = paramString.toUpperCase(Locale.US).split(":");
    Byte[] arrayOfByte = new Byte[paramString.length];
    int i1 = paramString.length;
    int j = 0;
    int i = 0;
    if (j < i1)
    {
      Object localObject = paramString[j];
      if ((byte)localObject.charAt(0) >= 65)
      {
        k = localObject.charAt(0) - 'A' + 10 << 4;
        label93:
        if ((byte)localObject.charAt(1) < 65) {
          break label157;
        }
      }
      label157:
      for (int m = localObject.charAt(1) - 'A' + 10;; m = localObject.charAt(1) - '0')
      {
        arrayOfByte[i] = Byte.valueOf((byte)(k | m));
        j += 1;
        i += 1;
        break;
        k = localObject.charAt(0) - '0' << 4;
        break label93;
      }
    }
    i = paramString.length - 1;
    int k = arrayOfByte.length;
    long l1 = 0L;
    j = n;
    for (;;)
    {
      l2 = l1;
      if (j >= k) {
        break;
      }
      l1 |= (arrayOfByte[j].longValue() & 0xFF) << (i << 3);
      j += 1;
      i -= 1;
    }
  }
  
  public static String BV(String paramString)
  {
    if ((paramString == null) || (12 != paramString.length()))
    {
      y.e("MicroMsg.exdevice.Util", "%s is not server string mac", new Object[] { paramString });
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < paramString.length())
    {
      localStringBuilder.append(paramString.charAt(i));
      if ((i % 2 != 0) && (i < paramString.length() - 1)) {
        localStringBuilder.append(":");
      }
      i += 1;
    }
    y.i("MicroMsg.exdevice.Util", "%s to %s is ok", new Object[] { paramString, localStringBuilder.toString() });
    return localStringBuilder.toString();
  }
  
  public static String Q(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    int i = paramInt;
    if (paramArrayOfByte.length < paramInt)
    {
      y.w("MicroMsg.exdevice.Util", "data length is shorter then print command length");
      i = paramArrayOfByte.length;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < i)
    {
      int j = paramArrayOfByte[paramInt] & 0xFF;
      if (j < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(j));
      paramInt += 1;
    }
    return localStringBuilder.toString().toUpperCase(Locale.US);
  }
  
  public static String aMW()
  {
    i = 7;
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    Calendar localCalendar = Calendar.getInstance();
    for (;;)
    {
      try
      {
        j = bk.getInt(String.valueOf(localCalendar.get(7)), 0);
        if (j != 1) {
          continue;
        }
      }
      catch (Exception localException)
      {
        int j;
        y.e("MicroMsg.exdevice.Util", "parse day failed : %s", new Object[] { localException.getMessage() });
        i = 0;
        continue;
      }
      return str + i;
      i = j - 1;
    }
  }
  
  public static long aMX()
  {
    String str = g.AA().getValue("DeviceAutoSyncDuration");
    if (!bk.bl(str)) {}
    for (;;)
    {
      try
      {
        l = Long.parseLong(str);
        l *= 1000L;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.exdevice.Util", "parse string to time out long failed : %s", new Object[] { localException.getMessage() });
        l = 60000L;
        continue;
      }
      y.i("MicroMsg.exdevice.Util", "now sync time out is %d", new Object[] { Long.valueOf(l) });
      if (l == 0L) {
        return 60000L;
      }
      return l;
      long l = 60000L;
    }
  }
  
  public static String aq(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return Q(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static long ar(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[i] & 0xFF) << (7 - i << 3);
      i += 1;
    }
    return l;
  }
  
  public static UUID as(byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.exdevice.Util", "parseUUIDFromByteArray, uuid byte array = %s", new Object[] { aq(paramArrayOfByte) });
    if (bk.bE(paramArrayOfByte))
    {
      y.e("MicroMsg.exdevice.Util", "aUUIDByteArray is null or nil");
      return null;
    }
    if (16 != paramArrayOfByte.length)
    {
      y.e("MicroMsg.exdevice.Util", "the length (%d) of this byte array is not 16", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      return null;
    }
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(8);
    ByteBuffer localByteBuffer2 = ByteBuffer.allocate(8);
    try
    {
      localByteBuffer1.put(paramArrayOfByte, 0, 8);
      localByteBuffer1.flip();
      localByteBuffer2.put(paramArrayOfByte, 8, 8);
      localByteBuffer2.flip();
      paramArrayOfByte = new UUID(localByteBuffer1.getLong(), localByteBuffer2.getLong());
      y.d("MicroMsg.exdevice.Util", "parse successful, string of uuid = %s", new Object[] { paramArrayOfByte.toString() });
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.exdevice.Util", "%s", new Object[] { paramArrayOfByte.getMessage() });
    }
    return null;
  }
  
  /* Error */
  public static Object at(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 278	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 281	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 283	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 286	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 290	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: astore_2
    //   31: aload_1
    //   32: invokevirtual 293	java/io/ObjectInputStream:close	()V
    //   35: aload_3
    //   36: invokevirtual 294	java/io/ByteArrayInputStream:close	()V
    //   39: aload_2
    //   40: areturn
    //   41: astore_0
    //   42: ldc 45
    //   44: aload_0
    //   45: ldc 113
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_2
    //   55: areturn
    //   56: astore_0
    //   57: ldc 45
    //   59: aload_0
    //   60: ldc 113
    //   62: iconst_0
    //   63: anewarray 4	java/lang/Object
    //   66: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: goto -34 -> 35
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: ldc 45
    //   79: new 111	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 300
    //   86: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: invokevirtual 301	java/io/StreamCorruptedException:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_1
    //   103: astore_0
    //   104: ldc 45
    //   106: aload_2
    //   107: ldc 113
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 293	java/io/ObjectInputStream:close	()V
    //   124: aload_3
    //   125: invokevirtual 294	java/io/ByteArrayInputStream:close	()V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_0
    //   131: ldc 45
    //   133: aload_0
    //   134: ldc 113
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_0
    //   146: ldc 45
    //   148: aload_0
    //   149: ldc 113
    //   151: iconst_0
    //   152: anewarray 4	java/lang/Object
    //   155: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: goto -34 -> 124
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: astore_0
    //   166: ldc 45
    //   168: new 111	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 303
    //   175: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload_2
    //   179: invokevirtual 304	java/io/IOException:getMessage	()Ljava/lang/String;
    //   182: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_1
    //   192: astore_0
    //   193: ldc 45
    //   195: aload_2
    //   196: ldc 113
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload_1
    //   206: ifnull +7 -> 213
    //   209: aload_1
    //   210: invokevirtual 293	java/io/ObjectInputStream:close	()V
    //   213: aload_3
    //   214: invokevirtual 294	java/io/ByteArrayInputStream:close	()V
    //   217: aconst_null
    //   218: areturn
    //   219: astore_0
    //   220: ldc 45
    //   222: aload_0
    //   223: ldc 113
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: ldc 45
    //   237: aload_0
    //   238: ldc 113
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -34 -> 213
    //   250: astore_2
    //   251: aconst_null
    //   252: astore_1
    //   253: aload_1
    //   254: astore_0
    //   255: ldc 45
    //   257: new 111	java/lang/StringBuilder
    //   260: dup
    //   261: ldc_w 306
    //   264: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   267: aload_2
    //   268: invokevirtual 307	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   271: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_1
    //   281: astore_0
    //   282: ldc 45
    //   284: aload_2
    //   285: ldc 113
    //   287: iconst_0
    //   288: anewarray 4	java/lang/Object
    //   291: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 293	java/io/ObjectInputStream:close	()V
    //   302: aload_3
    //   303: invokevirtual 294	java/io/ByteArrayInputStream:close	()V
    //   306: aconst_null
    //   307: areturn
    //   308: astore_0
    //   309: ldc 45
    //   311: aload_0
    //   312: ldc 113
    //   314: iconst_0
    //   315: anewarray 4	java/lang/Object
    //   318: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aconst_null
    //   322: areturn
    //   323: astore_0
    //   324: ldc 45
    //   326: aload_0
    //   327: ldc 113
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: goto -34 -> 302
    //   339: astore_1
    //   340: aconst_null
    //   341: astore_0
    //   342: aload_0
    //   343: ifnull +7 -> 350
    //   346: aload_0
    //   347: invokevirtual 293	java/io/ObjectInputStream:close	()V
    //   350: aload_3
    //   351: invokevirtual 294	java/io/ByteArrayInputStream:close	()V
    //   354: aload_1
    //   355: athrow
    //   356: astore_0
    //   357: ldc 45
    //   359: aload_0
    //   360: ldc 113
    //   362: iconst_0
    //   363: anewarray 4	java/lang/Object
    //   366: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: goto -19 -> 350
    //   372: astore_0
    //   373: ldc 45
    //   375: aload_0
    //   376: ldc 113
    //   378: iconst_0
    //   379: anewarray 4	java/lang/Object
    //   382: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: goto -31 -> 354
    //   388: astore_1
    //   389: goto -47 -> 342
    //   392: astore_2
    //   393: goto -140 -> 253
    //   396: astore_2
    //   397: goto -233 -> 164
    //   400: astore_2
    //   401: goto -326 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramArrayOfByte	byte[]
    //   23	276	1	localObjectInputStream	java.io.ObjectInputStream
    //   339	16	1	localObject1	Object
    //   388	1	1	localObject2	Object
    //   30	25	2	localObject3	Object
    //   72	35	2	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   161	35	2	localIOException1	java.io.IOException
    //   250	35	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   392	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   396	1	2	localIOException2	java.io.IOException
    //   400	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   14	337	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   35	39	41	java/io/IOException
    //   31	35	56	java/io/IOException
    //   15	24	72	java/io/StreamCorruptedException
    //   124	128	130	java/io/IOException
    //   120	124	145	java/io/IOException
    //   15	24	161	java/io/IOException
    //   213	217	219	java/io/IOException
    //   209	213	234	java/io/IOException
    //   15	24	250	java/lang/ClassNotFoundException
    //   302	306	308	java/io/IOException
    //   298	302	323	java/io/IOException
    //   15	24	339	finally
    //   346	350	356	java/io/IOException
    //   350	354	372	java/io/IOException
    //   26	31	388	finally
    //   77	102	388	finally
    //   104	116	388	finally
    //   166	191	388	finally
    //   193	205	388	finally
    //   255	280	388	finally
    //   282	294	388	finally
    //   26	31	392	java/lang/ClassNotFoundException
    //   26	31	396	java/io/IOException
    //   26	31	400	java/io/StreamCorruptedException
  }
  
  public static boolean b(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((bk.bE(paramArrayOfByte1)) || (bk.bE(paramArrayOfByte2)) || (paramArrayOfByte2.length + paramInt > paramArrayOfByte1.length) || (paramInt < 0) || (paramInt >= paramArrayOfByte1.length)) {}
    int i;
    do
    {
      return false;
      i = 0;
      while ((i < paramArrayOfByte2.length) && (paramArrayOfByte2[i] == paramArrayOfByte1[(i + paramInt)])) {
        i += 1;
      }
    } while (i != paramArrayOfByte2.length);
    return true;
  }
  
  /* Error */
  public static byte[] bi(Object paramObject)
  {
    // Byte code:
    //   0: new 313	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 314	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 316	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 319	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 323	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   26: aload_3
    //   27: astore_1
    //   28: aload_3
    //   29: invokevirtual 326	java/io/ObjectOutputStream:flush	()V
    //   32: aload_3
    //   33: astore_1
    //   34: aload 4
    //   36: invokevirtual 330	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   39: astore_0
    //   40: aload_0
    //   41: ifnonnull +13 -> 54
    //   44: aload_3
    //   45: astore_1
    //   46: ldc 45
    //   48: ldc_w 332
    //   51: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_3
    //   55: invokevirtual 333	java/io/ObjectOutputStream:close	()V
    //   58: aload 4
    //   60: invokevirtual 334	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_0
    //   64: areturn
    //   65: astore_1
    //   66: ldc 45
    //   68: aload_1
    //   69: ldc 113
    //   71: iconst_0
    //   72: anewarray 4	java/lang/Object
    //   75: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: goto -20 -> 58
    //   81: astore_1
    //   82: ldc 45
    //   84: aload_1
    //   85: ldc 113
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: areturn
    //   96: astore_2
    //   97: aconst_null
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_3
    //   102: astore_1
    //   103: ldc 45
    //   105: new 111	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 336
    //   112: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 304	java/io/IOException:getMessage	()Ljava/lang/String;
    //   119: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_3
    //   129: astore_1
    //   130: ldc 45
    //   132: aload_2
    //   133: ldc 113
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 333	java/io/ObjectOutputStream:close	()V
    //   150: aload 4
    //   152: invokevirtual 334	java/io/ByteArrayOutputStream:close	()V
    //   155: aload_0
    //   156: areturn
    //   157: astore_1
    //   158: ldc 45
    //   160: aload_1
    //   161: ldc 113
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_0
    //   171: areturn
    //   172: astore_1
    //   173: ldc 45
    //   175: aload_1
    //   176: ldc 113
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -35 -> 150
    //   188: astore_0
    //   189: aconst_null
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 333	java/io/ObjectOutputStream:close	()V
    //   199: aload 4
    //   201: invokevirtual 334	java/io/ByteArrayOutputStream:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: astore_1
    //   207: ldc 45
    //   209: aload_1
    //   210: ldc 113
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: goto -20 -> 199
    //   222: astore_1
    //   223: ldc 45
    //   225: aload_1
    //   226: ldc 113
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 298	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: goto -31 -> 204
    //   238: astore_0
    //   239: goto -48 -> 191
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_0
    //   245: goto -144 -> 101
    //   248: astore_2
    //   249: goto -148 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramObject	Object
    //   20	26	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   65	4	1	localIOException1	java.io.IOException
    //   81	4	1	localIOException2	java.io.IOException
    //   102	28	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   157	4	1	localIOException3	java.io.IOException
    //   172	4	1	localIOException4	java.io.IOException
    //   190	6	1	localObject	Object
    //   206	4	1	localIOException5	java.io.IOException
    //   222	4	1	localIOException6	java.io.IOException
    //   96	37	2	localIOException7	java.io.IOException
    //   242	1	2	localIOException8	java.io.IOException
    //   248	1	2	localIOException9	java.io.IOException
    //   18	129	3	localObjectOutputStream3	java.io.ObjectOutputStream
    //   7	193	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   54	58	65	java/io/IOException
    //   58	63	81	java/io/IOException
    //   9	19	96	java/io/IOException
    //   150	155	157	java/io/IOException
    //   146	150	172	java/io/IOException
    //   9	19	188	finally
    //   195	199	206	java/io/IOException
    //   199	204	222	java/io/IOException
    //   21	26	238	finally
    //   28	32	238	finally
    //   34	40	238	finally
    //   46	54	238	finally
    //   103	128	238	finally
    //   130	142	238	finally
    //   21	26	242	java/io/IOException
    //   28	32	242	java/io/IOException
    //   34	40	242	java/io/IOException
    //   46	54	248	java/io/IOException
  }
  
  public static boolean cV(String paramString1, String paramString2)
  {
    y.i("MicroMsg.exdevice.Util", "isDeviceInDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString2 = paramString2.split("\\|");
        if (paramString2 == null)
        {
          y.e("MicroMsg.exdevice.Util", "null == deviceArray");
          return false;
        }
      }
      catch (Exception paramString1)
      {
        y.e("MicroMsg.exdevice.Util", "aDeviceList.split failed, %s", new Object[] { paramString1.getMessage() });
        return false;
      }
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        if (paramString2[i].equalsIgnoreCase(paramString1)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static String cW(String paramString1, String paramString2)
  {
    y.i("MicroMsg.exdevice.Util", "moveDevicefromDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.w("MicroMsg.exdevice.Util", "parameters is null or nil");
      return null;
    }
    String[] arrayOfString;
    try
    {
      arrayOfString = paramString2.split("\\|");
      if (arrayOfString == null)
      {
        y.e("MicroMsg.exdevice.Util", "null == strArray");
        return null;
      }
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.exdevice.Util", "aDeviceList.split failed!!!, %s", new Object[] { paramString1.getMessage() });
      return null;
    }
    String str1 = new String();
    int k = arrayOfString.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      String str2 = arrayOfString[i];
      if (!str2.equalsIgnoreCase(paramString1))
      {
        str1 = str1 + str2;
        str1 = str1 + "|";
      }
      for (;;)
      {
        i += 1;
        break;
        j = 1;
      }
    }
    if (j == 0)
    {
      y.e("MicroMsg.exdevice.Util", "remove failed!!!, this device is not in the list");
      return null;
    }
    y.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[] { paramString2 });
    return str1;
  }
  
  public static String ee(long paramLong)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[6];
    int i = 0;
    while (i < 6)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> 40 - (i << 3)));
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    i = j;
    while (i < 6)
    {
      if (i != 0) {
        localStringBuilder.append(":");
      }
      j = arrayOfByte[i] & 0xFF;
      if (j < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(j));
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase(Locale.US);
  }
  
  public static String ef(long paramLong)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[6];
    int i = 0;
    while (i < 6)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> 40 - (i << 3)));
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    i = j;
    while (i < 6)
    {
      j = arrayOfByte[i] & 0xFF;
      if (j < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(j));
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase(Locale.US);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.b
 * JD-Core Version:    0.7.0.1
 */