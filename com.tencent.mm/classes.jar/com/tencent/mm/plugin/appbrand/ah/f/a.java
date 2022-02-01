package com.tencent.mm.plugin.appbrand.ah.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class a
{
  private static final byte[] uvu = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] uvv = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] uvw = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] uvx = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  private static final byte[] uvy = { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final byte[] uvz = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 };
  
  private static final byte[] DP(int paramInt)
  {
    if ((paramInt & 0x10) == 16) {
      return uvx;
    }
    if ((paramInt & 0x20) == 32) {
      return uvz;
    }
    return uvv;
  }
  
  private static String I(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(156671);
    if (paramArrayOfByte == null)
    {
      Log.i("MicroMsg.AppBrandNetWork.Base64", "Cannot serialize a null array.");
      paramArrayOfByte = new byte[0];
    }
    for (;;)
    {
      try
      {
        localObject = new String(paramArrayOfByte, "US-ASCII");
        AppMethodBeat.o(156671);
        return localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Object localObject;
        int j;
        int i;
        int k;
        paramArrayOfByte = new String(paramArrayOfByte);
        AppMethodBeat.o(156671);
      }
      if (paramInt < 0)
      {
        Log.i("MicroMsg.AppBrandNetWork.Base64", "Cannot have length offset: ".concat(String.valueOf(paramInt)));
        paramArrayOfByte = new byte[0];
      }
      else if (paramInt + 0 > paramArrayOfByte.length)
      {
        Log.i("MicroMsg.AppBrandNetWork.Base64", "off + len > source.length  ");
        paramArrayOfByte = new byte[0];
      }
      else
      {
        j = paramInt / 3;
        if (paramInt % 3 > 0)
        {
          i = 4;
          localObject = new byte[i + j * 4];
          i = 0;
          j = 0;
          if (j < paramInt - 2)
          {
            a(paramArrayOfByte, j + 0, 3, (byte[])localObject, i, 0);
            i += 4;
            j += 3;
            continue;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        k = i;
        if (j < paramInt)
        {
          a(paramArrayOfByte, j + 0, paramInt - j, (byte[])localObject, i, 0);
          k = i + 4;
        }
        paramArrayOfByte = (byte[])localObject;
        if (k <= localObject.length - 1)
        {
          paramArrayOfByte = new byte[k];
          System.arraycopy(localObject, 0, paramArrayOfByte, 0, k);
        }
      }
    }
    return paramArrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    int j = 0;
    byte[] arrayOfByte = uvu;
    if (paramInt2 > 0)
    {
      paramInt4 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label23:
      if (paramInt2 <= 1) {
        break label104;
      }
    }
    label104:
    for (int i = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; i = 0)
    {
      if (paramInt2 > 2) {
        j = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = j | i | paramInt4;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        paramInt4 = 0;
        break label23;
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
  
  public static String be(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156670);
    Object localObject = null;
    try
    {
      paramArrayOfByte = I(paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(156670);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = localObject;
      }
    }
  }
  
  public static byte[] decode(String paramString)
  {
    AppMethodBeat.i(319664);
    paramString = decode(paramString, 0);
    AppMethodBeat.o(319664);
    return paramString;
  }
  
  /* Error */
  public static byte[] decode(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 220
    //   2: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +19 -> 25
    //   9: ldc 161
    //   11: ldc 222
    //   13: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 220
    //   18: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: newarray byte
    //   24: areturn
    //   25: aload_0
    //   26: ldc 172
    //   28: invokevirtual 225	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   31: astore 8
    //   33: aload 8
    //   35: astore_0
    //   36: aload_0
    //   37: arraylength
    //   38: istore 7
    //   40: aload_0
    //   41: ifnonnull +203 -> 244
    //   44: ldc 161
    //   46: ldc 227
    //   48: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iconst_0
    //   52: newarray byte
    //   54: astore_0
    //   55: iload_1
    //   56: iconst_4
    //   57: iand
    //   58: ifeq +728 -> 786
    //   61: iconst_1
    //   62: istore_1
    //   63: aload_0
    //   64: arraylength
    //   65: iconst_4
    //   66: if_icmplt +882 -> 948
    //   69: iload_1
    //   70: ifne +878 -> 948
    //   73: ldc 228
    //   75: aload_0
    //   76: iconst_0
    //   77: baload
    //   78: sipush 255
    //   81: iand
    //   82: aload_0
    //   83: iconst_1
    //   84: baload
    //   85: bipush 8
    //   87: ishl
    //   88: ldc 229
    //   90: iand
    //   91: ior
    //   92: if_icmpne +856 -> 948
    //   95: aconst_null
    //   96: astore 13
    //   98: aconst_null
    //   99: astore 8
    //   101: aconst_null
    //   102: astore 14
    //   104: sipush 2048
    //   107: newarray byte
    //   109: astore 15
    //   111: new 231	java/io/ByteArrayOutputStream
    //   114: dup
    //   115: invokespecial 233	java/io/ByteArrayOutputStream:<init>	()V
    //   118: astore 10
    //   120: new 235	java/io/ByteArrayInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 236	java/io/ByteArrayInputStream:<init>	([B)V
    //   128: astore 9
    //   130: aload 10
    //   132: astore 12
    //   134: aload 8
    //   136: astore 13
    //   138: aload 9
    //   140: astore 11
    //   142: new 238	java/util/zip/GZIPInputStream
    //   145: dup
    //   146: aload 9
    //   148: invokespecial 241	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   151: astore 8
    //   153: aload 8
    //   155: aload 15
    //   157: invokevirtual 245	java/util/zip/GZIPInputStream:read	([B)I
    //   160: istore_1
    //   161: iload_1
    //   162: iflt +629 -> 791
    //   165: aload 10
    //   167: aload 15
    //   169: iconst_0
    //   170: iload_1
    //   171: invokevirtual 249	java/io/ByteArrayOutputStream:write	([BII)V
    //   174: goto -21 -> 153
    //   177: astore 11
    //   179: aload 8
    //   181: astore 14
    //   183: aload 11
    //   185: astore 8
    //   187: aload 10
    //   189: astore 12
    //   191: aload 14
    //   193: astore 13
    //   195: aload 9
    //   197: astore 11
    //   199: ldc 161
    //   201: aload 8
    //   203: ldc 251
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload 10
    //   214: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   217: aload 14
    //   219: invokevirtual 259	java/util/zip/GZIPInputStream:close	()V
    //   222: aload 9
    //   224: invokevirtual 260	java/io/ByteArrayInputStream:close	()V
    //   227: ldc 220
    //   229: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_0
    //   233: areturn
    //   234: astore 8
    //   236: aload_0
    //   237: invokevirtual 263	java/lang/String:getBytes	()[B
    //   240: astore_0
    //   241: goto -205 -> 36
    //   244: iload 7
    //   246: iconst_0
    //   247: iadd
    //   248: aload_0
    //   249: arraylength
    //   250: if_icmple +45 -> 295
    //   253: ldc 161
    //   255: ldc_w 265
    //   258: iconst_3
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload_0
    //   265: arraylength
    //   266: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: dup
    //   271: iconst_1
    //   272: iconst_0
    //   273: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_2
    //   279: iload 7
    //   281: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   284: aastore
    //   285: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: iconst_0
    //   289: newarray byte
    //   291: astore_0
    //   292: goto -237 -> 55
    //   295: iload 7
    //   297: ifne +10 -> 307
    //   300: iconst_0
    //   301: newarray byte
    //   303: astore_0
    //   304: goto -249 -> 55
    //   307: iload 7
    //   309: iconst_4
    //   310: if_icmpge +26 -> 336
    //   313: ldc 161
    //   315: ldc_w 275
    //   318: iload 7
    //   320: invokestatic 185	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   323: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   326: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: iconst_0
    //   330: newarray byte
    //   332: astore_0
    //   333: goto -278 -> 55
    //   336: iload_1
    //   337: invokestatic 277	com/tencent/mm/plugin/appbrand/ah/f/a:DP	(I)[B
    //   340: astore 9
    //   342: iload 7
    //   344: iconst_3
    //   345: imul
    //   346: iconst_4
    //   347: idiv
    //   348: newarray byte
    //   350: astore 8
    //   352: iconst_0
    //   353: istore_3
    //   354: iconst_4
    //   355: newarray byte
    //   357: astore 10
    //   359: iconst_0
    //   360: istore_2
    //   361: iconst_0
    //   362: istore 4
    //   364: iload 4
    //   366: iload 7
    //   368: iconst_0
    //   369: iadd
    //   370: if_icmpge +587 -> 957
    //   373: aload 9
    //   375: aload_0
    //   376: iload 4
    //   378: baload
    //   379: sipush 255
    //   382: iand
    //   383: baload
    //   384: istore 5
    //   386: iload 5
    //   388: bipush 251
    //   390: if_icmplt +332 -> 722
    //   393: iload 5
    //   395: iconst_m1
    //   396: if_icmplt +555 -> 951
    //   399: iload_2
    //   400: iconst_1
    //   401: iadd
    //   402: istore 6
    //   404: aload 10
    //   406: iload_2
    //   407: aload_0
    //   408: iload 4
    //   410: baload
    //   411: bastore
    //   412: iload 6
    //   414: istore_2
    //   415: iload_3
    //   416: istore 5
    //   418: iload 6
    //   420: iconst_3
    //   421: if_icmple +353 -> 774
    //   424: iload_3
    //   425: iflt +12 -> 437
    //   428: iload_3
    //   429: iconst_2
    //   430: iadd
    //   431: aload 8
    //   433: arraylength
    //   434: if_icmplt +44 -> 478
    //   437: ldc 161
    //   439: ldc_w 279
    //   442: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: iconst_0
    //   446: istore_2
    //   447: iload_3
    //   448: iload_2
    //   449: iadd
    //   450: istore_2
    //   451: iconst_0
    //   452: istore_3
    //   453: aload_0
    //   454: iload 4
    //   456: baload
    //   457: bipush 61
    //   459: if_icmpne +310 -> 769
    //   462: iload_2
    //   463: newarray byte
    //   465: astore_0
    //   466: aload 8
    //   468: iconst_0
    //   469: aload_0
    //   470: iconst_0
    //   471: iload_2
    //   472: invokestatic 201	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   475: goto -420 -> 55
    //   478: iload_1
    //   479: invokestatic 277	com/tencent/mm/plugin/appbrand/ah/f/a:DP	(I)[B
    //   482: astore 11
    //   484: aload 10
    //   486: iconst_2
    //   487: baload
    //   488: bipush 61
    //   490: if_icmpne +47 -> 537
    //   493: aload 11
    //   495: aload 10
    //   497: iconst_0
    //   498: baload
    //   499: baload
    //   500: istore_2
    //   501: aload 8
    //   503: iload_3
    //   504: aload 11
    //   506: aload 10
    //   508: iconst_1
    //   509: baload
    //   510: baload
    //   511: sipush 255
    //   514: iand
    //   515: bipush 12
    //   517: ishl
    //   518: iload_2
    //   519: sipush 255
    //   522: iand
    //   523: bipush 18
    //   525: ishl
    //   526: ior
    //   527: bipush 16
    //   529: iushr
    //   530: i2b
    //   531: bastore
    //   532: iconst_1
    //   533: istore_2
    //   534: goto -87 -> 447
    //   537: aload 10
    //   539: iconst_3
    //   540: baload
    //   541: bipush 61
    //   543: if_icmpne +79 -> 622
    //   546: aload 11
    //   548: aload 10
    //   550: iconst_0
    //   551: baload
    //   552: baload
    //   553: istore_2
    //   554: aload 11
    //   556: aload 10
    //   558: iconst_1
    //   559: baload
    //   560: baload
    //   561: istore 5
    //   563: aload 11
    //   565: aload 10
    //   567: iconst_2
    //   568: baload
    //   569: baload
    //   570: sipush 255
    //   573: iand
    //   574: bipush 6
    //   576: ishl
    //   577: iload_2
    //   578: sipush 255
    //   581: iand
    //   582: bipush 18
    //   584: ishl
    //   585: iload 5
    //   587: sipush 255
    //   590: iand
    //   591: bipush 12
    //   593: ishl
    //   594: ior
    //   595: ior
    //   596: istore_2
    //   597: aload 8
    //   599: iload_3
    //   600: iload_2
    //   601: bipush 16
    //   603: iushr
    //   604: i2b
    //   605: bastore
    //   606: aload 8
    //   608: iload_3
    //   609: iconst_1
    //   610: iadd
    //   611: iload_2
    //   612: bipush 8
    //   614: iushr
    //   615: i2b
    //   616: bastore
    //   617: iconst_2
    //   618: istore_2
    //   619: goto -172 -> 447
    //   622: aload 11
    //   624: aload 10
    //   626: iconst_0
    //   627: baload
    //   628: baload
    //   629: istore_2
    //   630: aload 11
    //   632: aload 10
    //   634: iconst_1
    //   635: baload
    //   636: baload
    //   637: istore 5
    //   639: aload 11
    //   641: aload 10
    //   643: iconst_2
    //   644: baload
    //   645: baload
    //   646: istore 6
    //   648: aload 11
    //   650: aload 10
    //   652: iconst_3
    //   653: baload
    //   654: baload
    //   655: sipush 255
    //   658: iand
    //   659: iload_2
    //   660: sipush 255
    //   663: iand
    //   664: bipush 18
    //   666: ishl
    //   667: iload 5
    //   669: sipush 255
    //   672: iand
    //   673: bipush 12
    //   675: ishl
    //   676: ior
    //   677: iload 6
    //   679: sipush 255
    //   682: iand
    //   683: bipush 6
    //   685: ishl
    //   686: ior
    //   687: ior
    //   688: istore_2
    //   689: aload 8
    //   691: iload_3
    //   692: iload_2
    //   693: bipush 16
    //   695: ishr
    //   696: i2b
    //   697: bastore
    //   698: aload 8
    //   700: iload_3
    //   701: iconst_1
    //   702: iadd
    //   703: iload_2
    //   704: bipush 8
    //   706: ishr
    //   707: i2b
    //   708: bastore
    //   709: aload 8
    //   711: iload_3
    //   712: iconst_2
    //   713: iadd
    //   714: iload_2
    //   715: i2b
    //   716: bastore
    //   717: iconst_3
    //   718: istore_2
    //   719: goto -272 -> 447
    //   722: new 208	java/io/IOException
    //   725: dup
    //   726: ldc_w 281
    //   729: iconst_2
    //   730: anewarray 4	java/lang/Object
    //   733: dup
    //   734: iconst_0
    //   735: aload_0
    //   736: iload 4
    //   738: baload
    //   739: sipush 255
    //   742: iand
    //   743: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: iload 4
    //   751: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   754: aastore
    //   755: invokestatic 285	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   758: invokespecial 288	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   761: astore_0
    //   762: ldc 220
    //   764: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   767: aload_0
    //   768: athrow
    //   769: iload_2
    //   770: istore 5
    //   772: iload_3
    //   773: istore_2
    //   774: iload 4
    //   776: iconst_1
    //   777: iadd
    //   778: istore 4
    //   780: iload 5
    //   782: istore_3
    //   783: goto -419 -> 364
    //   786: iconst_0
    //   787: istore_1
    //   788: goto -725 -> 63
    //   791: aload 10
    //   793: invokevirtual 291	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   796: astore 11
    //   798: aload 11
    //   800: astore_0
    //   801: aload 10
    //   803: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   806: aload 8
    //   808: invokevirtual 259	java/util/zip/GZIPInputStream:close	()V
    //   811: aload 9
    //   813: invokevirtual 260	java/io/ByteArrayInputStream:close	()V
    //   816: goto -589 -> 227
    //   819: astore 8
    //   821: goto -594 -> 227
    //   824: astore 8
    //   826: goto -599 -> 227
    //   829: astore_0
    //   830: aconst_null
    //   831: astore 10
    //   833: aconst_null
    //   834: astore 8
    //   836: aload 10
    //   838: invokevirtual 258	java/io/ByteArrayOutputStream:close	()V
    //   841: aload 13
    //   843: invokevirtual 259	java/util/zip/GZIPInputStream:close	()V
    //   846: aload 8
    //   848: invokevirtual 260	java/io/ByteArrayInputStream:close	()V
    //   851: ldc 220
    //   853: invokestatic 179	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   856: aload_0
    //   857: athrow
    //   858: astore 10
    //   860: goto -54 -> 806
    //   863: astore 8
    //   865: goto -54 -> 811
    //   868: astore 8
    //   870: goto -653 -> 217
    //   873: astore 8
    //   875: goto -653 -> 222
    //   878: astore 9
    //   880: goto -39 -> 841
    //   883: astore 9
    //   885: goto -39 -> 846
    //   888: astore 8
    //   890: goto -39 -> 851
    //   893: astore_0
    //   894: aconst_null
    //   895: astore 8
    //   897: goto -61 -> 836
    //   900: astore_0
    //   901: aload 12
    //   903: astore 10
    //   905: aload 11
    //   907: astore 8
    //   909: goto -73 -> 836
    //   912: astore_0
    //   913: aload 8
    //   915: astore 13
    //   917: aload 9
    //   919: astore 8
    //   921: goto -85 -> 836
    //   924: astore 8
    //   926: aconst_null
    //   927: astore 10
    //   929: aconst_null
    //   930: astore 9
    //   932: goto -745 -> 187
    //   935: astore 8
    //   937: aconst_null
    //   938: astore 9
    //   940: goto -753 -> 187
    //   943: astore 8
    //   945: goto -758 -> 187
    //   948: goto -721 -> 227
    //   951: iload_3
    //   952: istore 5
    //   954: goto -180 -> 774
    //   957: iload_3
    //   958: istore_2
    //   959: goto -497 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	paramString	String
    //   0	962	1	paramInt	int
    //   360	599	2	i	int
    //   353	605	3	j	int
    //   362	417	4	k	int
    //   384	569	5	m	int
    //   402	281	6	n	int
    //   38	332	7	i1	int
    //   31	171	8	localObject1	Object
    //   234	1	8	localUnsupportedEncodingException	UnsupportedEncodingException
    //   350	457	8	arrayOfByte1	byte[]
    //   819	1	8	localException1	java.lang.Exception
    //   824	1	8	localException2	java.lang.Exception
    //   834	13	8	localObject2	Object
    //   863	1	8	localException3	java.lang.Exception
    //   868	1	8	localException4	java.lang.Exception
    //   873	1	8	localException5	java.lang.Exception
    //   888	1	8	localException6	java.lang.Exception
    //   895	25	8	localObject3	Object
    //   924	1	8	localIOException1	IOException
    //   935	1	8	localIOException2	IOException
    //   943	1	8	localIOException3	IOException
    //   128	684	9	localObject4	Object
    //   878	1	9	localException7	java.lang.Exception
    //   883	35	9	localException8	java.lang.Exception
    //   930	9	9	localObject5	Object
    //   118	719	10	localObject6	Object
    //   858	1	10	localException9	java.lang.Exception
    //   903	25	10	localObject7	Object
    //   140	1	11	localObject8	Object
    //   177	7	11	localIOException4	IOException
    //   197	709	11	localObject9	Object
    //   132	770	12	localObject10	Object
    //   96	820	13	localObject11	Object
    //   102	116	14	localObject12	Object
    //   109	59	15	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   153	161	177	java/io/IOException
    //   165	174	177	java/io/IOException
    //   791	798	177	java/io/IOException
    //   25	33	234	java/io/UnsupportedEncodingException
    //   811	816	819	java/lang/Exception
    //   222	227	824	java/lang/Exception
    //   111	120	829	finally
    //   801	806	858	java/lang/Exception
    //   806	811	863	java/lang/Exception
    //   212	217	868	java/lang/Exception
    //   217	222	873	java/lang/Exception
    //   836	841	878	java/lang/Exception
    //   841	846	883	java/lang/Exception
    //   846	851	888	java/lang/Exception
    //   120	130	893	finally
    //   142	153	900	finally
    //   199	212	900	finally
    //   153	161	912	finally
    //   165	174	912	finally
    //   791	798	912	finally
    //   111	120	924	java/io/IOException
    //   120	130	935	java/io/IOException
    //   142	153	943	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.f.a
 * JD-Core Version:    0.7.0.1
 */