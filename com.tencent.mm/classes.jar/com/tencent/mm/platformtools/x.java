package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.b.s;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class x
{
  /* Error */
  static boolean a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 21	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_1
    //   13: invokestatic 21	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   16: ifeq +29 -> 45
    //   19: ldc 23
    //   21: ldc 25
    //   23: iconst_2
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_0
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: aload_1
    //   34: aastore
    //   35: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc 9
    //   40: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_0
    //   46: invokestatic 40	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   49: l2i
    //   50: istore 5
    //   52: iload 5
    //   54: ifgt +33 -> 87
    //   57: ldc 23
    //   59: ldc 42
    //   61: iconst_2
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: iload 5
    //   73: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: ldc 9
    //   82: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_0
    //   86: ireturn
    //   87: iload 5
    //   89: ldc 49
    //   91: if_icmpgt +88 -> 179
    //   94: aload_0
    //   95: iconst_0
    //   96: iconst_m1
    //   97: invokestatic 53	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   100: astore 10
    //   102: aload 10
    //   104: aload_0
    //   105: aload_1
    //   106: iload_3
    //   107: invokestatic 56	com/tencent/mm/platformtools/x:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   110: istore 9
    //   112: aload 10
    //   114: ifnull +60 -> 174
    //   117: aload 10
    //   119: arraylength
    //   120: istore_3
    //   121: ldc 23
    //   123: ldc 58
    //   125: iconst_3
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iload 9
    //   133: invokestatic 63	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: iload_3
    //   140: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: aload_0
    //   147: aastore
    //   148: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: iload 9
    //   153: ifeq +13 -> 166
    //   156: iload_2
    //   157: ifeq +9 -> 166
    //   160: aload_0
    //   161: iconst_1
    //   162: invokestatic 70	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   165: pop
    //   166: ldc 9
    //   168: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iload 9
    //   173: ireturn
    //   174: iconst_m1
    //   175: istore_3
    //   176: goto -55 -> 121
    //   179: iload 5
    //   181: ldc 71
    //   183: idiv
    //   184: iconst_1
    //   185: iadd
    //   186: istore 6
    //   188: ldc 49
    //   190: newarray byte
    //   192: astore 13
    //   194: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   197: l2i
    //   198: istore 7
    //   200: aconst_null
    //   201: astore 11
    //   203: aconst_null
    //   204: astore 10
    //   206: aload_0
    //   207: invokestatic 79	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   210: astore 12
    //   212: iconst_0
    //   213: istore 4
    //   215: iload 4
    //   217: iload 6
    //   219: if_icmpge +277 -> 496
    //   222: aload 12
    //   224: astore 10
    //   226: aload 12
    //   228: astore 11
    //   230: aload 12
    //   232: aload 13
    //   234: bipush 12
    //   236: ldc 71
    //   238: invokevirtual 85	java/io/InputStream:read	([BII)I
    //   241: istore 8
    //   243: iload 8
    //   245: ifge +43 -> 288
    //   248: aload 12
    //   250: astore 10
    //   252: aload 12
    //   254: astore 11
    //   256: ldc 23
    //   258: ldc 87
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: aastore
    //   268: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 12
    //   273: ifnull +8 -> 281
    //   276: aload 12
    //   278: invokevirtual 91	java/io/InputStream:close	()V
    //   281: ldc 9
    //   283: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: iconst_0
    //   287: ireturn
    //   288: aload 12
    //   290: astore 10
    //   292: aload 12
    //   294: astore 11
    //   296: iload 7
    //   298: aload 13
    //   300: iconst_0
    //   301: invokestatic 95	com/tencent/mm/platformtools/x:c	(I[BI)Z
    //   304: pop
    //   305: aload 12
    //   307: astore 10
    //   309: aload 12
    //   311: astore 11
    //   313: iload 4
    //   315: aload 13
    //   317: iconst_4
    //   318: invokestatic 95	com/tencent/mm/platformtools/x:c	(I[BI)Z
    //   321: pop
    //   322: aload 12
    //   324: astore 10
    //   326: aload 12
    //   328: astore 11
    //   330: iload 8
    //   332: aload 13
    //   334: bipush 8
    //   336: invokestatic 95	com/tencent/mm/platformtools/x:c	(I[BI)Z
    //   339: pop
    //   340: iload 8
    //   342: ldc 71
    //   344: if_icmpge +131 -> 475
    //   347: aload 12
    //   349: astore 10
    //   351: aload 12
    //   353: astore 11
    //   355: iload 8
    //   357: bipush 12
    //   359: iadd
    //   360: newarray byte
    //   362: astore 14
    //   364: aload 12
    //   366: astore 10
    //   368: aload 12
    //   370: astore 11
    //   372: aload 13
    //   374: iconst_0
    //   375: aload 14
    //   377: iconst_0
    //   378: aload 14
    //   380: arraylength
    //   381: invokestatic 101	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   384: aload 12
    //   386: astore 10
    //   388: aload 12
    //   390: astore 11
    //   392: aload 14
    //   394: aload_0
    //   395: aload_1
    //   396: iload_3
    //   397: invokestatic 56	com/tencent/mm/platformtools/x:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   400: istore 9
    //   402: aload 12
    //   404: astore 10
    //   406: aload 12
    //   408: astore 11
    //   410: ldc 23
    //   412: ldc 103
    //   414: bipush 6
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: iload 4
    //   423: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: aastore
    //   427: dup
    //   428: iconst_1
    //   429: iload 6
    //   431: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   434: aastore
    //   435: dup
    //   436: iconst_2
    //   437: iload 8
    //   439: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   442: aastore
    //   443: dup
    //   444: iconst_3
    //   445: iload 9
    //   447: invokestatic 63	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   450: aastore
    //   451: dup
    //   452: iconst_4
    //   453: iload 5
    //   455: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: aastore
    //   459: dup
    //   460: iconst_5
    //   461: aload_0
    //   462: aastore
    //   463: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: iload 4
    //   468: iconst_1
    //   469: iadd
    //   470: istore 4
    //   472: goto -257 -> 215
    //   475: aload 12
    //   477: astore 10
    //   479: aload 12
    //   481: astore 11
    //   483: aload 13
    //   485: aload_0
    //   486: aload_1
    //   487: iload_3
    //   488: invokestatic 56	com/tencent/mm/platformtools/x:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   491: istore 9
    //   493: goto -91 -> 402
    //   496: iload_2
    //   497: ifeq +17 -> 514
    //   500: aload 12
    //   502: astore 10
    //   504: aload 12
    //   506: astore 11
    //   508: aload_0
    //   509: iconst_1
    //   510: invokestatic 70	com/tencent/mm/vfs/y:ew	(Ljava/lang/String;Z)Z
    //   513: pop
    //   514: aload 12
    //   516: ifnull +8 -> 524
    //   519: aload 12
    //   521: invokevirtual 91	java/io/InputStream:close	()V
    //   524: ldc 9
    //   526: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: iconst_1
    //   530: ireturn
    //   531: astore_1
    //   532: aload 10
    //   534: astore 11
    //   536: ldc 23
    //   538: ldc 105
    //   540: iconst_1
    //   541: anewarray 4	java/lang/Object
    //   544: dup
    //   545: iconst_0
    //   546: aload_1
    //   547: invokestatic 109	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   550: aastore
    //   551: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: aload 10
    //   556: astore 11
    //   558: ldc 23
    //   560: ldc 111
    //   562: iconst_1
    //   563: anewarray 4	java/lang/Object
    //   566: dup
    //   567: iconst_0
    //   568: aload_0
    //   569: aastore
    //   570: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   573: aload 10
    //   575: ifnull +8 -> 583
    //   578: aload 10
    //   580: invokevirtual 91	java/io/InputStream:close	()V
    //   583: ldc 9
    //   585: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   588: iconst_0
    //   589: ireturn
    //   590: astore_0
    //   591: aload 11
    //   593: ifnull +8 -> 601
    //   596: aload 11
    //   598: invokevirtual 91	java/io/InputStream:close	()V
    //   601: ldc 9
    //   603: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: aload_0
    //   607: athrow
    //   608: astore_0
    //   609: goto -328 -> 281
    //   612: astore_0
    //   613: goto -89 -> 524
    //   616: astore_0
    //   617: goto -34 -> 583
    //   620: astore_1
    //   621: goto -20 -> 601
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	paramString1	String
    //   0	624	1	paramString2	String
    //   0	624	2	paramBoolean	boolean
    //   0	624	3	paramInt	int
    //   213	258	4	i	int
    //   50	404	5	j	int
    //   186	244	6	k	int
    //   198	99	7	m	int
    //   241	197	8	n	int
    //   110	382	9	bool	boolean
    //   100	479	10	localObject1	Object
    //   201	396	11	localObject2	Object
    //   210	310	12	localInputStream	java.io.InputStream
    //   192	292	13	arrayOfByte1	byte[]
    //   362	31	14	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   206	212	531	java/lang/Exception
    //   230	243	531	java/lang/Exception
    //   256	271	531	java/lang/Exception
    //   296	305	531	java/lang/Exception
    //   313	322	531	java/lang/Exception
    //   330	340	531	java/lang/Exception
    //   355	364	531	java/lang/Exception
    //   372	384	531	java/lang/Exception
    //   392	402	531	java/lang/Exception
    //   410	466	531	java/lang/Exception
    //   483	493	531	java/lang/Exception
    //   508	514	531	java/lang/Exception
    //   206	212	590	finally
    //   230	243	590	finally
    //   256	271	590	finally
    //   296	305	590	finally
    //   313	322	590	finally
    //   330	340	590	finally
    //   355	364	590	finally
    //   372	384	590	finally
    //   392	402	590	finally
    //   410	466	590	finally
    //   483	493	590	finally
    //   508	514	590	finally
    //   536	554	590	finally
    //   558	573	590	finally
    //   276	281	608	java/lang/Exception
    //   519	524	612	java/lang/Exception
    //   578	583	616	java/lang/Exception
    //   596	601	620	java/lang/Exception
  }
  
  private static boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(143773);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.StackReportUploader", "read file failed:%s", new Object[] { paramString1 });
      AppMethodBeat.o(143773);
      return false;
    }
    if (paramArrayOfByte.length > 128000)
    {
      Log.e("MicroMsg.StackReportUploader", "file :%s data len error:%d", new Object[] { paramString1, Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(143773);
      return false;
    }
    int i = paramArrayOfByte.length;
    String str = g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.Yxh), Integer.valueOf(i) }).getBytes()).toLowerCase();
    paramArrayOfByte = s.compress(paramArrayOfByte);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.StackReportUploader", "zip data failed file:%s", new Object[] { paramString1 });
      AppMethodBeat.o(143773);
      return false;
    }
    Object localObject = new PByteArray();
    c.a((PByteArray)localObject, paramArrayOfByte, str.getBytes());
    paramArrayOfByte = ((PByteArray)localObject).value;
    if (Util.isNullOrNil(paramArrayOfByte)) {
      Log.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", new Object[] { paramString1 });
    }
    paramString1 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
    localObject = "https://" + paramString1.getString("support.weixin.qq.com", "support.weixin.qq.com");
    paramString1 = new StringBuffer();
    paramString1.append((String)localObject + "/cgi-bin/mmsupport-bin/stackreport?version=");
    paramString1.append(Integer.toHexString(d.Yxh));
    paramString1.append("&devicetype=");
    paramString1.append(d.nsC);
    paramString1.append("&filelength=");
    paramString1.append(i);
    paramString1.append("&sum=");
    paramString1.append(str);
    paramString1.append("&reporttype=");
    paramString1.append(paramInt);
    paramString1.append("&reportvalue=");
    paramString1.append(Util.nowMilliSecond() + ".0.1");
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      paramString1.append("&username=");
      paramString1.append(paramString2);
    }
    paramString2 = new DefaultHttpClient();
    paramString1 = new HttpPost(paramString1.toString());
    try
    {
      paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);
      paramArrayOfByte.setContentType("binary/octet-stream");
      paramString1.setEntity(paramArrayOfByte);
      paramArrayOfByte = paramString2.execute(paramString1);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.getStatusLine() == null))
      {
        Log.e("MicroMsg.StackReportUploader", "execute http failed resp null");
        AppMethodBeat.o(143773);
        return false;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.StackReportUploader", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      Log.d("MicroMsg.StackReportUploader", "execute post failed msg:%s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(143773);
      return false;
    }
    if (paramArrayOfByte.getStatusLine().getStatusCode() != 200)
    {
      Log.e("MicroMsg.StackReportUploader", "error response code:%d ", new Object[] { Integer.valueOf(paramArrayOfByte.getStatusLine().getStatusCode()) });
      AppMethodBeat.o(143773);
      return false;
    }
    AppMethodBeat.o(143773);
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234040);
    if (paramBoolean)
    {
      ThreadPool.post(new x.1(paramString1, paramString2, false, paramInt2), "StackReportUploader_uploadFileDirect", paramInt1);
      AppMethodBeat.o(234040);
      return true;
    }
    paramBoolean = a(paramString1, paramString2, false, paramInt2);
    AppMethodBeat.o(234040);
    return paramBoolean;
  }
  
  private static boolean c(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (128000 < paramInt2 + 4) {
      return false;
    }
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0xFF));
    return true;
  }
  
  public static boolean cj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234042);
    boolean bool = b(paramString1, paramString2, true, 1, 20003);
    AppMethodBeat.o(234042);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.x
 * JD-Core Version:    0.7.0.1
 */