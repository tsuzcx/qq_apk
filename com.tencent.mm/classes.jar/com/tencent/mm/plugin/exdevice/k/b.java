package com.tencent.mm.plugin.exdevice.k;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public final class b
{
  public static int B(Context paramContext, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(24332);
    try
    {
      Rect localRect = new Rect();
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      paramInt = ((Activity)paramContext).getWindow().getDecorView().getHeight();
      if (paramInt - localRect.height() >= 0)
      {
        int j = localRect.height();
        paramInt -= j;
        if (paramInt > 0) {
          break label125;
        }
        paramInt = i;
      }
      for (;;)
      {
        AppMethodBeat.o(24332);
        return paramInt;
        paramInt = localRect.top;
        break;
      }
    }
    catch (Exception paramContext)
    {
      ad.i("MicroMsg.exdevice.Util", "getStatusHeight err: %s", new Object[] { paramContext.toString() });
    }
    finally
    {
      AppMethodBeat.o(24332);
      return 0;
    }
  }
  
  public static String T(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24320);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(24320);
      return null;
    }
    int i = paramInt;
    if (paramArrayOfByte.length < paramInt)
    {
      ad.w("MicroMsg.exdevice.Util", "data length is shorter then print command length");
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
    paramArrayOfByte = localStringBuilder.toString().toUpperCase(Locale.US);
    AppMethodBeat.o(24320);
    return paramArrayOfByte;
  }
  
  public static long acY(String paramString)
  {
    int n = 0;
    AppMethodBeat.i(24317);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.exdevice.Util", "mac string is null or nil");
      AppMethodBeat.o(24317);
      return 0L;
    }
    paramString = paramString.toUpperCase(Locale.US).split(":");
    Byte[] arrayOfByte = new Byte[paramString.length];
    int i1 = paramString.length;
    int j = 0;
    int i = 0;
    if (j < i1)
    {
      Object localObject = paramString[j];
      if (localObject.length() == 0)
      {
        ad.e("MicroMsg.exdevice.Util", "mac string parse fail");
        AppMethodBeat.o(24317);
        return 0L;
      }
      if ((byte)localObject.charAt(0) >= 65)
      {
        k = localObject.charAt(0) - 'A' + 10 << 4;
        label124:
        if ((byte)localObject.charAt(1) < 65) {
          break label188;
        }
      }
      label188:
      for (int m = localObject.charAt(1) - 'A' + 10;; m = localObject.charAt(1) - '0')
      {
        arrayOfByte[i] = Byte.valueOf((byte)(k | m));
        j += 1;
        i += 1;
        break;
        k = localObject.charAt(0) - '0' << 4;
        break label124;
      }
    }
    i = paramString.length - 1;
    int k = arrayOfByte.length;
    long l = 0L;
    j = n;
    while (j < k)
    {
      l |= (arrayOfByte[j].longValue() & 0xFF) << (i << 3);
      j += 1;
      i -= 1;
    }
    AppMethodBeat.o(24317);
    return l;
  }
  
  public static String acZ(String paramString)
  {
    AppMethodBeat.i(24323);
    if ((paramString == null) || (12 != paramString.length()))
    {
      ad.e("MicroMsg.exdevice.Util", "%s is not server string mac", new Object[] { paramString });
      AppMethodBeat.o(24323);
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
    ad.i("MicroMsg.exdevice.Util", "%s to %s is ok", new Object[] { paramString, localStringBuilder.toString() });
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(24323);
    return paramString;
  }
  
  public static String bg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24319);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(24319);
      return null;
    }
    paramArrayOfByte = T(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(24319);
    return paramArrayOfByte;
  }
  
  public static long bh(byte[] paramArrayOfByte)
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
  
  public static UUID bi(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24328);
    ad.d("MicroMsg.exdevice.Util", "parseUUIDFromByteArray, uuid byte array = %s", new Object[] { bg(paramArrayOfByte) });
    if (bt.cC(paramArrayOfByte))
    {
      ad.e("MicroMsg.exdevice.Util", "aUUIDByteArray is null or nil");
      AppMethodBeat.o(24328);
      return null;
    }
    if (16 != paramArrayOfByte.length)
    {
      ad.e("MicroMsg.exdevice.Util", "the length (%d) of this byte array is not 16", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(24328);
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
      ad.d("MicroMsg.exdevice.Util", "parse successful, string of uuid = %s", new Object[] { paramArrayOfByte.toString() });
      AppMethodBeat.o(24328);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.exdevice.Util", "%s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(24328);
    }
    return null;
  }
  
  /* Error */
  public static Object bj(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: sipush 24331
    //   5: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnonnull +11 -> 20
    //   12: sipush 24331
    //   15: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aconst_null
    //   19: areturn
    //   20: new 220	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 223	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: astore 4
    //   30: new 225	java/io/ObjectInputStream
    //   33: dup
    //   34: aload 4
    //   36: invokespecial 228	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 232	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   53: aload 4
    //   55: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   58: sipush 24331
    //   61: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: areturn
    //   66: astore_1
    //   67: ldc 54
    //   69: aload_1
    //   70: ldc 144
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -26 -> 53
    //   82: astore_1
    //   83: ldc 54
    //   85: aload_1
    //   86: ldc 144
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: goto -37 -> 58
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: ldc 54
    //   105: new 76	java/lang/StringBuilder
    //   108: dup
    //   109: ldc 242
    //   111: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_2
    //   115: invokevirtual 243	java/io/StreamCorruptedException:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: astore_0
    //   129: ldc 54
    //   131: aload_2
    //   132: ldc 144
    //   134: iconst_0
    //   135: anewarray 4	java/lang/Object
    //   138: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   149: aload 4
    //   151: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   154: aload_3
    //   155: astore_0
    //   156: goto -98 -> 58
    //   159: astore_0
    //   160: ldc 54
    //   162: aload_0
    //   163: ldc 144
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_3
    //   173: astore_0
    //   174: goto -116 -> 58
    //   177: astore_0
    //   178: ldc 54
    //   180: aload_0
    //   181: ldc 144
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: goto -41 -> 149
    //   193: astore_2
    //   194: aconst_null
    //   195: astore_1
    //   196: aload_1
    //   197: astore_0
    //   198: ldc 54
    //   200: new 76	java/lang/StringBuilder
    //   203: dup
    //   204: ldc 245
    //   206: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload_2
    //   210: invokevirtual 246	java/io/IOException:getMessage	()Ljava/lang/String;
    //   213: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: astore_0
    //   224: ldc 54
    //   226: aload_2
    //   227: ldc 144
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   244: aload 4
    //   246: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   249: aload_3
    //   250: astore_0
    //   251: goto -193 -> 58
    //   254: astore_0
    //   255: ldc 54
    //   257: aload_0
    //   258: ldc 144
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: aload_3
    //   268: astore_0
    //   269: goto -211 -> 58
    //   272: astore_0
    //   273: ldc 54
    //   275: aload_0
    //   276: ldc 144
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: goto -41 -> 244
    //   288: astore_2
    //   289: aconst_null
    //   290: astore_1
    //   291: aload_1
    //   292: astore_0
    //   293: ldc 54
    //   295: new 76	java/lang/StringBuilder
    //   298: dup
    //   299: ldc 248
    //   301: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   304: aload_2
    //   305: invokevirtual 249	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   308: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_1
    //   318: astore_0
    //   319: ldc 54
    //   321: aload_2
    //   322: ldc 144
    //   324: iconst_0
    //   325: anewarray 4	java/lang/Object
    //   328: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: aload_1
    //   332: ifnull +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   339: aload 4
    //   341: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   344: aload_3
    //   345: astore_0
    //   346: goto -288 -> 58
    //   349: astore_0
    //   350: ldc 54
    //   352: aload_0
    //   353: ldc 144
    //   355: iconst_0
    //   356: anewarray 4	java/lang/Object
    //   359: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: aload_3
    //   363: astore_0
    //   364: goto -306 -> 58
    //   367: astore_0
    //   368: ldc 54
    //   370: aload_0
    //   371: ldc 144
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: goto -41 -> 339
    //   383: astore_1
    //   384: aconst_null
    //   385: astore_0
    //   386: aload_0
    //   387: ifnull +7 -> 394
    //   390: aload_0
    //   391: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   394: aload 4
    //   396: invokevirtual 236	java/io/ByteArrayInputStream:close	()V
    //   399: sipush 24331
    //   402: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: aload_1
    //   406: athrow
    //   407: astore_0
    //   408: ldc 54
    //   410: aload_0
    //   411: ldc 144
    //   413: iconst_0
    //   414: anewarray 4	java/lang/Object
    //   417: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: goto -26 -> 394
    //   423: astore_0
    //   424: ldc 54
    //   426: aload_0
    //   427: ldc 144
    //   429: iconst_0
    //   430: anewarray 4	java/lang/Object
    //   433: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: goto -37 -> 399
    //   439: astore_1
    //   440: goto -54 -> 386
    //   443: astore_2
    //   444: goto -153 -> 291
    //   447: astore_2
    //   448: goto -252 -> 196
    //   451: astore_2
    //   452: goto -351 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	paramArrayOfByte	byte[]
    //   39	11	1	localObjectInputStream	java.io.ObjectInputStream
    //   66	4	1	localIOException1	java.io.IOException
    //   82	4	1	localIOException2	java.io.IOException
    //   100	236	1	localObject1	Object
    //   383	23	1	localObject2	Object
    //   439	1	1	localObject3	Object
    //   46	2	2	localObject4	Object
    //   98	34	2	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   193	34	2	localIOException3	java.io.IOException
    //   288	34	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   443	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   447	1	2	localIOException4	java.io.IOException
    //   451	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   1	362	3	localObject5	Object
    //   28	367	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   49	53	66	java/io/IOException
    //   53	58	82	java/io/IOException
    //   30	40	98	java/io/StreamCorruptedException
    //   149	154	159	java/io/IOException
    //   145	149	177	java/io/IOException
    //   30	40	193	java/io/IOException
    //   244	249	254	java/io/IOException
    //   240	244	272	java/io/IOException
    //   30	40	288	java/lang/ClassNotFoundException
    //   339	344	349	java/io/IOException
    //   335	339	367	java/io/IOException
    //   30	40	383	finally
    //   390	394	407	java/io/IOException
    //   394	399	423	java/io/IOException
    //   42	47	439	finally
    //   103	127	439	finally
    //   129	141	439	finally
    //   198	222	439	finally
    //   224	236	439	finally
    //   293	317	439	finally
    //   319	331	439	finally
    //   42	47	443	java/lang/ClassNotFoundException
    //   42	47	447	java/io/IOException
    //   42	47	451	java/io/StreamCorruptedException
  }
  
  public static boolean c(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(24329);
    if ((bt.cC(paramArrayOfByte1)) || (bt.cC(paramArrayOfByte2)) || (paramArrayOfByte2.length + paramInt > paramArrayOfByte1.length) || (paramInt < 0) || (paramInt >= paramArrayOfByte1.length))
    {
      AppMethodBeat.o(24329);
      return false;
    }
    int i = 0;
    while ((i < paramArrayOfByte2.length) && (paramArrayOfByte2[i] == paramArrayOfByte1[(i + paramInt)])) {
      i += 1;
    }
    if (i != paramArrayOfByte2.length)
    {
      AppMethodBeat.o(24329);
      return false;
    }
    AppMethodBeat.o(24329);
    return true;
  }
  
  /* Error */
  public static byte[] cW(Object paramObject)
  {
    // Byte code:
    //   0: sipush 24330
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 255	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 256	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: new 258	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 261	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: aload_3
    //   28: aload_0
    //   29: invokevirtual 265	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 268	java/io/ObjectOutputStream:flush	()V
    //   38: aload_3
    //   39: astore_1
    //   40: aload 4
    //   42: invokevirtual 272	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: astore_0
    //   46: aload_0
    //   47: ifnonnull +13 -> 60
    //   50: aload_3
    //   51: astore_1
    //   52: ldc 54
    //   54: ldc_w 274
    //   57: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_3
    //   61: invokevirtual 275	java/io/ObjectOutputStream:close	()V
    //   64: aload 4
    //   66: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   69: sipush 24330
    //   72: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: ldc 54
    //   80: aload_1
    //   81: ldc 144
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: goto -26 -> 64
    //   93: astore_1
    //   94: ldc 54
    //   96: aload_1
    //   97: ldc 144
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: goto -37 -> 69
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_3
    //   115: astore_1
    //   116: ldc 54
    //   118: new 76	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 278
    //   125: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_2
    //   129: invokevirtual 246	java/io/IOException:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 112	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_3
    //   142: astore_1
    //   143: ldc 54
    //   145: aload_2
    //   146: ldc 144
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 275	java/io/ObjectOutputStream:close	()V
    //   163: aload 4
    //   165: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   168: sipush 24330
    //   171: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_0
    //   175: areturn
    //   176: astore_1
    //   177: ldc 54
    //   179: aload_1
    //   180: ldc 144
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -26 -> 163
    //   192: astore_1
    //   193: ldc 54
    //   195: aload_1
    //   196: ldc 144
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: goto -37 -> 168
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_1
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 275	java/io/ObjectOutputStream:close	()V
    //   219: aload 4
    //   221: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   224: sipush 24330
    //   227: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_0
    //   231: athrow
    //   232: astore_1
    //   233: ldc 54
    //   235: aload_1
    //   236: ldc 144
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: goto -26 -> 219
    //   248: astore_1
    //   249: ldc 54
    //   251: aload_1
    //   252: ldc 144
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 240	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: goto -37 -> 224
    //   264: astore_0
    //   265: goto -54 -> 211
    //   268: astore_2
    //   269: aconst_null
    //   270: astore_0
    //   271: goto -157 -> 114
    //   274: astore_2
    //   275: goto -161 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramObject	Object
    //   26	26	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   77	4	1	localIOException1	java.io.IOException
    //   93	4	1	localIOException2	java.io.IOException
    //   115	28	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   176	4	1	localIOException3	java.io.IOException
    //   192	4	1	localIOException4	java.io.IOException
    //   210	6	1	localObject	Object
    //   232	4	1	localIOException5	java.io.IOException
    //   248	4	1	localIOException6	java.io.IOException
    //   109	37	2	localIOException7	java.io.IOException
    //   268	1	2	localIOException8	java.io.IOException
    //   274	1	2	localIOException9	java.io.IOException
    //   24	136	3	localObjectOutputStream3	java.io.ObjectOutputStream
    //   13	207	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   60	64	77	java/io/IOException
    //   64	69	93	java/io/IOException
    //   15	25	109	java/io/IOException
    //   159	163	176	java/io/IOException
    //   163	168	192	java/io/IOException
    //   15	25	208	finally
    //   215	219	232	java/io/IOException
    //   219	224	248	java/io/IOException
    //   27	32	264	finally
    //   34	38	264	finally
    //   40	46	264	finally
    //   52	60	264	finally
    //   116	141	264	finally
    //   143	155	264	finally
    //   27	32	268	java/io/IOException
    //   34	38	268	java/io/IOException
    //   40	46	268	java/io/IOException
    //   52	60	274	java/io/IOException
  }
  
  public static String cmG()
  {
    i = 7;
    AppMethodBeat.i(24321);
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    Calendar localCalendar = Calendar.getInstance();
    for (;;)
    {
      try
      {
        j = bt.getInt(String.valueOf(localCalendar.get(7)), 0);
        if (j != 1) {
          continue;
        }
      }
      catch (Exception localException)
      {
        int j;
        ad.e("MicroMsg.exdevice.Util", "parse day failed : %s", new Object[] { localException.getMessage() });
        i = 0;
        continue;
      }
      str = str + i;
      AppMethodBeat.o(24321);
      return str;
      i = j - 1;
    }
  }
  
  public static long cmH()
  {
    AppMethodBeat.i(24324);
    String str = g.acA().getValue("DeviceAutoSyncDuration");
    if (!bt.isNullOrNil(str)) {}
    for (;;)
    {
      try
      {
        l = Long.parseLong(str);
        l *= 1000L;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.exdevice.Util", "parse string to time out long failed : %s", new Object[] { localException.getMessage() });
        l = 60000L;
        continue;
        AppMethodBeat.o(24324);
        return l;
      }
      ad.i("MicroMsg.exdevice.Util", "now sync time out is %d", new Object[] { Long.valueOf(l) });
      if (l == 0L)
      {
        AppMethodBeat.o(24324);
        return 60000L;
      }
      long l = 60000L;
    }
  }
  
  public static boolean fJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24325);
    ad.i("MicroMsg.exdevice.Util", "isDeviceInDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(24325);
      return false;
    }
    try
    {
      paramString2 = paramString2.split("\\|");
      if (paramString2 == null)
      {
        ad.e("MicroMsg.exdevice.Util", "null == deviceArray");
        AppMethodBeat.o(24325);
        return false;
      }
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.exdevice.Util", "aDeviceList.split failed, %s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(24325);
      return false;
    }
    int j = paramString2.length;
    int i = 0;
    while (i < j)
    {
      if (paramString2[i].equalsIgnoreCase(paramString1))
      {
        AppMethodBeat.o(24325);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(24325);
    return false;
  }
  
  public static String fK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24326);
    ad.i("MicroMsg.exdevice.Util", "addDeviceToDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((bt.isNullOrNil(paramString1)) || (paramString2 == null))
    {
      ad.e("MicroMsg.exdevice.Util", "Error parameters!!!");
      AppMethodBeat.o(24326);
      return null;
    }
    String str = new String();
    paramString2 = str + paramString2;
    paramString1 = paramString2 + paramString1;
    paramString1 = paramString1 + "|";
    ad.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[] { paramString1 });
    AppMethodBeat.o(24326);
    return paramString1;
  }
  
  public static String fL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24327);
    ad.i("MicroMsg.exdevice.Util", "moveDevicefromDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.w("MicroMsg.exdevice.Util", "parameters is null or nil");
      AppMethodBeat.o(24327);
      return null;
    }
    String[] arrayOfString;
    try
    {
      arrayOfString = paramString2.split("\\|");
      if (arrayOfString == null)
      {
        ad.e("MicroMsg.exdevice.Util", "null == strArray");
        AppMethodBeat.o(24327);
        return null;
      }
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.exdevice.Util", "aDeviceList.split failed!!!, %s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(24327);
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
      ad.e("MicroMsg.exdevice.Util", "remove failed!!!, this device is not in the list");
      AppMethodBeat.o(24327);
      return null;
    }
    ad.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[] { paramString2 });
    AppMethodBeat.o(24327);
    return str1;
  }
  
  public static String uO(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(24318);
    Object localObject = new byte[6];
    int i = 0;
    while (i < 6)
    {
      localObject[i] = ((byte)(int)(paramLong >> 40 - (i << 3)));
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    i = j;
    while (i < 6)
    {
      if (i != 0) {
        localStringBuilder.append(":");
      }
      j = localObject[i] & 0xFF;
      if (j < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(j));
      i += 1;
    }
    localObject = localStringBuilder.toString().toUpperCase(Locale.US);
    AppMethodBeat.o(24318);
    return localObject;
  }
  
  public static String uP(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(24322);
    Object localObject = new byte[6];
    int i = 0;
    while (i < 6)
    {
      localObject[i] = ((byte)(int)(paramLong >> 40 - (i << 3)));
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    i = j;
    while (i < 6)
    {
      j = localObject[i] & 0xFF;
      if (j < 16) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(Integer.toHexString(j));
      i += 1;
    }
    localObject = localStringBuilder.toString().toUpperCase(Locale.US);
    AppMethodBeat.o(24322);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.k.b
 * JD-Core Version:    0.7.0.1
 */