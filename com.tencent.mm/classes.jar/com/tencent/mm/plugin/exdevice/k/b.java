package com.tencent.mm.plugin.exdevice.k;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

public final class b
{
  public static int I(Context paramContext, int paramInt)
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
      Log.i("MicroMsg.exdevice.Util", "getStatusHeight err: %s", new Object[] { paramContext.toString() });
    }
    finally
    {
      AppMethodBeat.o(24332);
      return 0;
    }
  }
  
  public static String W(byte[] paramArrayOfByte, int paramInt)
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
      Log.w("MicroMsg.exdevice.Util", "data length is shorter then print command length");
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
  
  public static long apW(String paramString)
  {
    int n = 0;
    AppMethodBeat.i(24317);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.exdevice.Util", "mac string is null or nil");
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
        Log.e("MicroMsg.exdevice.Util", "mac string parse fail");
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
  
  public static LinkedList<Integer> apX(String paramString)
  {
    AppMethodBeat.i(274571);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() > 0)
      {
        paramString = paramString.split(",");
        localObject1 = localObject2;
        if (paramString != null)
        {
          localObject1 = localObject2;
          if (paramString.length > 0)
          {
            localObject1 = new LinkedList();
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        ((LinkedList)localObject1).add(Integer.valueOf(Integer.parseInt(paramString[i])));
        label72:
        i += 1;
        continue;
        AppMethodBeat.o(274571);
        return localObject1;
      }
      catch (Exception localException)
      {
        break label72;
      }
    }
  }
  
  public static String apY(String paramString)
  {
    AppMethodBeat.i(24323);
    if ((paramString == null) || (12 != paramString.length()))
    {
      Log.e("MicroMsg.exdevice.Util", "%s is not server string mac", new Object[] { paramString });
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
    Log.i("MicroMsg.exdevice.Util", "%s to %s is ok", new Object[] { paramString, localStringBuilder.toString() });
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(24323);
    return paramString;
  }
  
  public static String bK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24319);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(24319);
      return null;
    }
    paramArrayOfByte = W(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(24319);
    return paramArrayOfByte;
  }
  
  public static long bL(byte[] paramArrayOfByte)
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
  
  public static UUID bM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(24328);
    Log.d("MicroMsg.exdevice.Util", "parseUUIDFromByteArray, uuid byte array = %s", new Object[] { bK(paramArrayOfByte) });
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.exdevice.Util", "aUUIDByteArray is null or nil");
      AppMethodBeat.o(24328);
      return null;
    }
    if (16 != paramArrayOfByte.length)
    {
      Log.e("MicroMsg.exdevice.Util", "the length (%d) of this byte array is not 16", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
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
      Log.d("MicroMsg.exdevice.Util", "parse successful, string of uuid = %s", new Object[] { paramArrayOfByte.toString() });
      AppMethodBeat.o(24328);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.exdevice.Util", "%s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(24328);
    }
    return null;
  }
  
  /* Error */
  public static Object bN(byte[] paramArrayOfByte)
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
    //   20: new 237	java/io/ByteArrayInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 240	java/io/ByteArrayInputStream:<init>	([B)V
    //   28: astore 4
    //   30: new 242	java/io/ObjectInputStream
    //   33: dup
    //   34: aload 4
    //   36: invokespecial 245	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: invokevirtual 249	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 252	java/io/ObjectInputStream:close	()V
    //   53: aload 4
    //   55: invokevirtual 253	java/io/ByteArrayInputStream:close	()V
    //   58: sipush 24331
    //   61: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: areturn
    //   66: astore_1
    //   67: ldc 53
    //   69: aload_1
    //   70: ldc 164
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -26 -> 53
    //   82: astore_1
    //   83: ldc 53
    //   85: aload_1
    //   86: ldc 164
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: goto -37 -> 58
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: ldc 53
    //   105: new 75	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 259
    //   112: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 260	java/io/StreamCorruptedException:getMessage	()Ljava/lang/String;
    //   119: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_1
    //   129: astore_0
    //   130: ldc 53
    //   132: aload_2
    //   133: ldc 164
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 252	java/io/ObjectInputStream:close	()V
    //   150: aload 4
    //   152: invokevirtual 253	java/io/ByteArrayInputStream:close	()V
    //   155: aload_3
    //   156: astore_0
    //   157: goto -99 -> 58
    //   160: astore_0
    //   161: ldc 53
    //   163: aload_0
    //   164: ldc 164
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_3
    //   174: astore_0
    //   175: goto -117 -> 58
    //   178: astore_0
    //   179: ldc 53
    //   181: aload_0
    //   182: ldc 164
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: goto -41 -> 150
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_1
    //   198: astore_0
    //   199: ldc 53
    //   201: new 75	java/lang/StringBuilder
    //   204: dup
    //   205: ldc_w 262
    //   208: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: aload_2
    //   212: invokevirtual 263	java/io/IOException:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_1
    //   225: astore_0
    //   226: ldc 53
    //   228: aload_2
    //   229: ldc 164
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 252	java/io/ObjectInputStream:close	()V
    //   246: aload 4
    //   248: invokevirtual 253	java/io/ByteArrayInputStream:close	()V
    //   251: aload_3
    //   252: astore_0
    //   253: goto -195 -> 58
    //   256: astore_0
    //   257: ldc 53
    //   259: aload_0
    //   260: ldc 164
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload_3
    //   270: astore_0
    //   271: goto -213 -> 58
    //   274: astore_0
    //   275: ldc 53
    //   277: aload_0
    //   278: ldc 164
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: goto -41 -> 246
    //   290: astore_2
    //   291: aconst_null
    //   292: astore_1
    //   293: aload_1
    //   294: astore_0
    //   295: ldc 53
    //   297: new 75	java/lang/StringBuilder
    //   300: dup
    //   301: ldc_w 265
    //   304: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   307: aload_2
    //   308: invokevirtual 266	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_1
    //   321: astore_0
    //   322: ldc 53
    //   324: aload_2
    //   325: ldc 164
    //   327: iconst_0
    //   328: anewarray 4	java/lang/Object
    //   331: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 252	java/io/ObjectInputStream:close	()V
    //   342: aload 4
    //   344: invokevirtual 253	java/io/ByteArrayInputStream:close	()V
    //   347: aload_3
    //   348: astore_0
    //   349: goto -291 -> 58
    //   352: astore_0
    //   353: ldc 53
    //   355: aload_0
    //   356: ldc 164
    //   358: iconst_0
    //   359: anewarray 4	java/lang/Object
    //   362: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload_3
    //   366: astore_0
    //   367: goto -309 -> 58
    //   370: astore_0
    //   371: ldc 53
    //   373: aload_0
    //   374: ldc 164
    //   376: iconst_0
    //   377: anewarray 4	java/lang/Object
    //   380: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: goto -41 -> 342
    //   386: astore_1
    //   387: aconst_null
    //   388: astore_0
    //   389: aload_0
    //   390: ifnull +7 -> 397
    //   393: aload_0
    //   394: invokevirtual 252	java/io/ObjectInputStream:close	()V
    //   397: aload 4
    //   399: invokevirtual 253	java/io/ByteArrayInputStream:close	()V
    //   402: sipush 24331
    //   405: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: aload_1
    //   409: athrow
    //   410: astore_0
    //   411: ldc 53
    //   413: aload_0
    //   414: ldc 164
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -26 -> 397
    //   426: astore_0
    //   427: ldc 53
    //   429: aload_0
    //   430: ldc 164
    //   432: iconst_0
    //   433: anewarray 4	java/lang/Object
    //   436: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: goto -37 -> 402
    //   442: astore_1
    //   443: goto -54 -> 389
    //   446: astore_2
    //   447: goto -154 -> 293
    //   450: astore_2
    //   451: goto -254 -> 197
    //   454: astore_2
    //   455: goto -354 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	paramArrayOfByte	byte[]
    //   39	11	1	localObjectInputStream	java.io.ObjectInputStream
    //   66	4	1	localIOException1	java.io.IOException
    //   82	4	1	localIOException2	java.io.IOException
    //   100	239	1	localObject1	Object
    //   386	23	1	localObject2	Object
    //   442	1	1	localObject3	Object
    //   46	2	2	localObject4	Object
    //   98	35	2	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   194	35	2	localIOException3	java.io.IOException
    //   290	35	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   446	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   450	1	2	localIOException4	java.io.IOException
    //   454	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   1	365	3	localObject5	Object
    //   28	370	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   49	53	66	java/io/IOException
    //   53	58	82	java/io/IOException
    //   30	40	98	java/io/StreamCorruptedException
    //   150	155	160	java/io/IOException
    //   146	150	178	java/io/IOException
    //   30	40	194	java/io/IOException
    //   246	251	256	java/io/IOException
    //   242	246	274	java/io/IOException
    //   30	40	290	java/lang/ClassNotFoundException
    //   342	347	352	java/io/IOException
    //   338	342	370	java/io/IOException
    //   30	40	386	finally
    //   393	397	410	java/io/IOException
    //   397	402	426	java/io/IOException
    //   42	47	442	finally
    //   103	128	442	finally
    //   130	142	442	finally
    //   199	224	442	finally
    //   226	238	442	finally
    //   295	320	442	finally
    //   322	334	442	finally
    //   42	47	446	java/lang/ClassNotFoundException
    //   42	47	450	java/io/IOException
    //   42	47	454	java/io/StreamCorruptedException
  }
  
  public static boolean d(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(24329);
    if ((Util.isNullOrNil(paramArrayOfByte1)) || (Util.isNullOrNil(paramArrayOfByte2)) || (paramArrayOfByte2.length + paramInt > paramArrayOfByte1.length) || (paramInt < 0) || (paramInt >= paramArrayOfByte1.length))
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
  
  public static String dHq()
  {
    i = 7;
    AppMethodBeat.i(24321);
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    Calendar localCalendar = Calendar.getInstance();
    for (;;)
    {
      try
      {
        j = Util.getInt(String.valueOf(localCalendar.get(7)), 0);
        if (j != 1) {
          continue;
        }
      }
      catch (Exception localException)
      {
        int j;
        Log.e("MicroMsg.exdevice.Util", "parse day failed : %s", new Object[] { localException.getMessage() });
        i = 0;
        continue;
      }
      str = str + i;
      AppMethodBeat.o(24321);
      return str;
      i = j - 1;
    }
  }
  
  public static long dHr()
  {
    AppMethodBeat.i(24324);
    String str = i.aRC().getValue("DeviceAutoSyncDuration");
    if (!Util.isNullOrNil(str)) {}
    for (;;)
    {
      try
      {
        l = Long.parseLong(str);
        l *= 1000L;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.exdevice.Util", "parse string to time out long failed : %s", new Object[] { localException.getMessage() });
        l = 60000L;
        continue;
        AppMethodBeat.o(24324);
        return l;
      }
      Log.i("MicroMsg.exdevice.Util", "now sync time out is %d", new Object[] { Long.valueOf(l) });
      if (l == 0L)
      {
        AppMethodBeat.o(24324);
        return 60000L;
      }
      long l = 60000L;
    }
  }
  
  /* Error */
  public static byte[] eZ(Object paramObject)
  {
    // Byte code:
    //   0: sipush 24330
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 338	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 339	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 4
    //   15: new 341	java/io/ObjectOutputStream
    //   18: dup
    //   19: aload 4
    //   21: invokespecial 344	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_3
    //   25: aload_3
    //   26: astore_1
    //   27: aload_3
    //   28: aload_0
    //   29: invokevirtual 348	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   32: aload_3
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 351	java/io/ObjectOutputStream:flush	()V
    //   38: aload_3
    //   39: astore_1
    //   40: aload 4
    //   42: invokevirtual 355	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: astore_0
    //   46: aload_0
    //   47: ifnonnull +13 -> 60
    //   50: aload_3
    //   51: astore_1
    //   52: ldc 53
    //   54: ldc_w 357
    //   57: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_3
    //   61: invokevirtual 358	java/io/ObjectOutputStream:close	()V
    //   64: aload 4
    //   66: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   69: sipush 24330
    //   72: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: ldc 53
    //   80: aload_1
    //   81: ldc 164
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: goto -26 -> 64
    //   93: astore_1
    //   94: ldc 53
    //   96: aload_1
    //   97: ldc 164
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: goto -37 -> 69
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_3
    //   115: astore_1
    //   116: ldc 53
    //   118: new 75	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 361
    //   125: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_2
    //   129: invokevirtual 263	java/io/IOException:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_3
    //   142: astore_1
    //   143: ldc 53
    //   145: aload_2
    //   146: ldc 164
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 358	java/io/ObjectOutputStream:close	()V
    //   163: aload 4
    //   165: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   168: sipush 24330
    //   171: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_0
    //   175: areturn
    //   176: astore_1
    //   177: ldc 53
    //   179: aload_1
    //   180: ldc 164
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: goto -26 -> 163
    //   192: astore_1
    //   193: ldc 53
    //   195: aload_1
    //   196: ldc 164
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: goto -37 -> 168
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_1
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 358	java/io/ObjectOutputStream:close	()V
    //   219: aload 4
    //   221: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   224: sipush 24330
    //   227: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_0
    //   231: athrow
    //   232: astore_1
    //   233: ldc 53
    //   235: aload_1
    //   236: ldc 164
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: goto -26 -> 219
    //   248: astore_1
    //   249: ldc 53
    //   251: aload_1
    //   252: ldc 164
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public static boolean gY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24325);
    Log.i("MicroMsg.exdevice.Util", "isDeviceInDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(24325);
      return false;
    }
    try
    {
      paramString2 = paramString2.split("\\|");
      if (paramString2 == null)
      {
        Log.e("MicroMsg.exdevice.Util", "null == deviceArray");
        AppMethodBeat.o(24325);
        return false;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.exdevice.Util", "aDeviceList.split failed, %s", new Object[] { paramString1.getMessage() });
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
  
  public static String gZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24326);
    Log.i("MicroMsg.exdevice.Util", "addDeviceToDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (paramString2 == null))
    {
      Log.e("MicroMsg.exdevice.Util", "Error parameters!!!");
      AppMethodBeat.o(24326);
      return null;
    }
    String str = new String();
    paramString2 = str + paramString2;
    paramString1 = paramString2 + paramString1;
    paramString1 = paramString1 + "|";
    Log.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[] { paramString1 });
    AppMethodBeat.o(24326);
    return paramString1;
  }
  
  public static String ha(String paramString1, String paramString2)
  {
    AppMethodBeat.i(24327);
    Log.i("MicroMsg.exdevice.Util", "moveDevicefromDeviceList, device = %s, device list = %s", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.w("MicroMsg.exdevice.Util", "parameters is null or nil");
      AppMethodBeat.o(24327);
      return null;
    }
    String[] arrayOfString;
    try
    {
      arrayOfString = paramString2.split("\\|");
      if (arrayOfString == null)
      {
        Log.e("MicroMsg.exdevice.Util", "null == strArray");
        AppMethodBeat.o(24327);
        return null;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.exdevice.Util", "aDeviceList.split failed!!!, %s", new Object[] { paramString1.getMessage() });
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
      Log.e("MicroMsg.exdevice.Util", "remove failed!!!, this device is not in the list");
      AppMethodBeat.o(24327);
      return null;
    }
    Log.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", new Object[] { paramString2 });
    AppMethodBeat.o(24327);
    return str1;
  }
  
  public static String lO(long paramLong)
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
  
  public static String lP(long paramLong)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.k.b
 * JD-Core Version:    0.7.0.1
 */