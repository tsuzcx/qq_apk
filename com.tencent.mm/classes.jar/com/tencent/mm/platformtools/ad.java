package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.a.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class ad
{
  /* Error */
  static boolean a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 21	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_1
    //   13: invokestatic 21	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
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
    //   35: invokestatic 31	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: ldc 9
    //   40: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_0
    //   46: invokestatic 40	com/tencent/mm/a/e:cM	(Ljava/lang/String;)I
    //   49: istore 5
    //   51: iload 5
    //   53: ifgt +33 -> 86
    //   56: ldc 23
    //   58: ldc 42
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: iload 5
    //   72: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: invokestatic 31	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: ldc 9
    //   81: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: iconst_0
    //   85: ireturn
    //   86: iload 5
    //   88: ldc 49
    //   90: if_icmpgt +94 -> 184
    //   93: aload_0
    //   94: iconst_0
    //   95: iconst_m1
    //   96: invokestatic 53	com/tencent/mm/a/e:j	(Ljava/lang/String;II)[B
    //   99: astore 10
    //   101: aload 10
    //   103: aload_0
    //   104: aload_1
    //   105: iload_3
    //   106: invokestatic 56	com/tencent/mm/platformtools/ad:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   109: istore 9
    //   111: aload 10
    //   113: ifnull +66 -> 179
    //   116: aload 10
    //   118: arraylength
    //   119: istore_3
    //   120: ldc 23
    //   122: ldc 58
    //   124: iconst_3
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: iload 9
    //   132: invokestatic 63	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: iload_3
    //   139: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: aastore
    //   143: dup
    //   144: iconst_2
    //   145: aload_0
    //   146: aastore
    //   147: invokestatic 66	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: iload 9
    //   152: ifeq +19 -> 171
    //   155: iload_2
    //   156: ifeq +15 -> 171
    //   159: new 68	java/io/File
    //   162: dup
    //   163: aload_0
    //   164: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: invokestatic 75	com/tencent/mm/a/e:o	(Ljava/io/File;)Z
    //   170: pop
    //   171: ldc 9
    //   173: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: iload 9
    //   178: ireturn
    //   179: iconst_m1
    //   180: istore_3
    //   181: goto -61 -> 120
    //   184: iload 5
    //   186: ldc 76
    //   188: idiv
    //   189: iconst_1
    //   190: iadd
    //   191: istore 6
    //   193: ldc 49
    //   195: newarray byte
    //   197: astore 12
    //   199: invokestatic 80	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   202: l2i
    //   203: istore 7
    //   205: new 82	java/io/FileInputStream
    //   208: dup
    //   209: aload_0
    //   210: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   213: astore 11
    //   215: iconst_0
    //   216: istore 4
    //   218: iload 4
    //   220: iload 6
    //   222: if_icmpge +232 -> 454
    //   225: aload 11
    //   227: astore 10
    //   229: aload 11
    //   231: aload 12
    //   233: bipush 12
    //   235: ldc 76
    //   237: invokevirtual 87	java/io/FileInputStream:read	([BII)I
    //   240: istore 8
    //   242: iload 8
    //   244: ifge +34 -> 278
    //   247: aload 11
    //   249: astore 10
    //   251: ldc 23
    //   253: ldc 89
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload_0
    //   262: aastore
    //   263: invokestatic 31	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aload 11
    //   268: invokevirtual 93	java/io/FileInputStream:close	()V
    //   271: ldc 9
    //   273: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: iconst_0
    //   277: ireturn
    //   278: aload 11
    //   280: astore 10
    //   282: iload 7
    //   284: aload 12
    //   286: iconst_0
    //   287: invokestatic 96	com/tencent/mm/platformtools/ad:d	(I[BI)Z
    //   290: pop
    //   291: aload 11
    //   293: astore 10
    //   295: iload 4
    //   297: aload 12
    //   299: iconst_4
    //   300: invokestatic 96	com/tencent/mm/platformtools/ad:d	(I[BI)Z
    //   303: pop
    //   304: aload 11
    //   306: astore 10
    //   308: iload 8
    //   310: aload 12
    //   312: bipush 8
    //   314: invokestatic 96	com/tencent/mm/platformtools/ad:d	(I[BI)Z
    //   317: pop
    //   318: iload 8
    //   320: ldc 76
    //   322: if_icmpge +115 -> 437
    //   325: aload 11
    //   327: astore 10
    //   329: iload 8
    //   331: bipush 12
    //   333: iadd
    //   334: newarray byte
    //   336: astore 13
    //   338: aload 11
    //   340: astore 10
    //   342: aload 12
    //   344: iconst_0
    //   345: aload 13
    //   347: iconst_0
    //   348: aload 13
    //   350: arraylength
    //   351: invokestatic 102	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   354: aload 11
    //   356: astore 10
    //   358: aload 13
    //   360: aload_0
    //   361: aload_1
    //   362: iload_3
    //   363: invokestatic 56	com/tencent/mm/platformtools/ad:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   366: istore 9
    //   368: aload 11
    //   370: astore 10
    //   372: ldc 23
    //   374: ldc 104
    //   376: bipush 6
    //   378: anewarray 4	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: iload 4
    //   385: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   388: aastore
    //   389: dup
    //   390: iconst_1
    //   391: iload 6
    //   393: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   396: aastore
    //   397: dup
    //   398: iconst_2
    //   399: iload 8
    //   401: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   404: aastore
    //   405: dup
    //   406: iconst_3
    //   407: iload 9
    //   409: invokestatic 63	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   412: aastore
    //   413: dup
    //   414: iconst_4
    //   415: iload 5
    //   417: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: aastore
    //   421: dup
    //   422: iconst_5
    //   423: aload_0
    //   424: aastore
    //   425: invokestatic 66	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: iload 4
    //   430: iconst_1
    //   431: iadd
    //   432: istore 4
    //   434: goto -216 -> 218
    //   437: aload 11
    //   439: astore 10
    //   441: aload 12
    //   443: aload_0
    //   444: aload_1
    //   445: iload_3
    //   446: invokestatic 56	com/tencent/mm/platformtools/ad:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   449: istore 9
    //   451: goto -83 -> 368
    //   454: iload_2
    //   455: ifeq +19 -> 474
    //   458: aload 11
    //   460: astore 10
    //   462: new 68	java/io/File
    //   465: dup
    //   466: aload_0
    //   467: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   470: invokestatic 75	com/tencent/mm/a/e:o	(Ljava/io/File;)Z
    //   473: pop
    //   474: aload 11
    //   476: invokevirtual 93	java/io/FileInputStream:close	()V
    //   479: ldc 9
    //   481: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   484: iconst_1
    //   485: ireturn
    //   486: astore 12
    //   488: aconst_null
    //   489: astore_1
    //   490: aload_1
    //   491: astore 10
    //   493: ldc 23
    //   495: ldc 106
    //   497: iconst_1
    //   498: anewarray 4	java/lang/Object
    //   501: dup
    //   502: iconst_0
    //   503: aload 12
    //   505: invokestatic 110	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   508: aastore
    //   509: invokestatic 31	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   512: aload_1
    //   513: astore 10
    //   515: ldc 23
    //   517: ldc 112
    //   519: iconst_1
    //   520: anewarray 4	java/lang/Object
    //   523: dup
    //   524: iconst_0
    //   525: aload_0
    //   526: aastore
    //   527: invokestatic 31	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: aload_1
    //   531: ifnull +7 -> 538
    //   534: aload_1
    //   535: invokevirtual 93	java/io/FileInputStream:close	()V
    //   538: ldc 9
    //   540: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: iconst_0
    //   544: ireturn
    //   545: astore_0
    //   546: aconst_null
    //   547: astore 10
    //   549: aload 10
    //   551: ifnull +8 -> 559
    //   554: aload 10
    //   556: invokevirtual 93	java/io/FileInputStream:close	()V
    //   559: ldc 9
    //   561: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   564: aload_0
    //   565: athrow
    //   566: astore_0
    //   567: goto -296 -> 271
    //   570: astore_0
    //   571: goto -92 -> 479
    //   574: astore_0
    //   575: goto -37 -> 538
    //   578: astore_1
    //   579: goto -20 -> 559
    //   582: astore_0
    //   583: goto -34 -> 549
    //   586: astore 12
    //   588: aload 11
    //   590: astore_1
    //   591: goto -101 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	paramString1	String
    //   0	594	1	paramString2	String
    //   0	594	2	paramBoolean	boolean
    //   0	594	3	paramInt	int
    //   216	217	4	i	int
    //   49	367	5	j	int
    //   191	201	6	k	int
    //   203	80	7	m	int
    //   240	160	8	n	int
    //   109	341	9	bool	boolean
    //   99	456	10	localObject	Object
    //   213	376	11	localFileInputStream	java.io.FileInputStream
    //   197	245	12	arrayOfByte1	byte[]
    //   486	18	12	localException1	Exception
    //   586	1	12	localException2	Exception
    //   336	23	13	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   205	215	486	java/lang/Exception
    //   205	215	545	finally
    //   266	271	566	java/lang/Exception
    //   474	479	570	java/lang/Exception
    //   534	538	574	java/lang/Exception
    //   554	559	578	java/lang/Exception
    //   229	242	582	finally
    //   251	266	582	finally
    //   282	291	582	finally
    //   295	304	582	finally
    //   308	318	582	finally
    //   329	338	582	finally
    //   342	354	582	finally
    //   358	368	582	finally
    //   372	428	582	finally
    //   441	451	582	finally
    //   462	474	582	finally
    //   493	512	582	finally
    //   515	530	582	finally
    //   229	242	586	java/lang/Exception
    //   251	266	586	java/lang/Exception
    //   282	291	586	java/lang/Exception
    //   295	304	586	java/lang/Exception
    //   308	318	586	java/lang/Exception
    //   329	338	586	java/lang/Exception
    //   342	354	586	java/lang/Exception
    //   358	368	586	java/lang/Exception
    //   372	428	586	java/lang/Exception
    //   441	451	586	java/lang/Exception
    //   462	474	586	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72655);
    paramBoolean1 = a(paramString1, paramString2, paramBoolean1, paramBoolean2, 20003);
    AppMethodBeat.o(72655);
    return paramBoolean1;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(72654);
    if (paramBoolean2)
    {
      com.tencent.mm.sdk.g.d.f(new ad.1(paramString1, paramString2, paramBoolean1, paramInt), "StackReportUploader_uploadFileDirect");
      AppMethodBeat.o(72654);
      return true;
    }
    paramBoolean1 = a(paramString1, paramString2, paramBoolean1, paramInt);
    AppMethodBeat.o(72654);
    return paramBoolean1;
  }
  
  private static boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(72657);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.StackReportUploader", "read file failed:%s", new Object[] { paramString1 });
      AppMethodBeat.o(72657);
      return false;
    }
    if (paramArrayOfByte.length > 128000)
    {
      ab.e("MicroMsg.StackReportUploader", "file :%s data len error:%d", new Object[] { paramString1, Integer.valueOf(paramArrayOfByte.length) });
      AppMethodBeat.o(72657);
      return false;
    }
    int i = paramArrayOfByte.length;
    String str = g.w(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH), Integer.valueOf(i) }).getBytes()).toLowerCase();
    paramArrayOfByte = r.compress(paramArrayOfByte);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.StackReportUploader", "zip data failed file:%s", new Object[] { paramString1 });
      AppMethodBeat.o(72657);
      return false;
    }
    Object localObject = new PByteArray();
    c.a((PByteArray)localObject, paramArrayOfByte, str.getBytes());
    paramArrayOfByte = ((PByteArray)localObject).value;
    if (bo.ce(paramArrayOfByte)) {
      ab.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", new Object[] { paramString1 });
    }
    paramString1 = ah.getContext().getSharedPreferences("system_config_prefs", 0);
    localObject = "http://" + paramString1.getString("support.weixin.qq.com", "support.weixin.qq.com");
    paramString1 = new StringBuffer();
    paramString1.append((String)localObject + "/cgi-bin/mmsupport-bin/stackreport?version=");
    paramString1.append(Integer.toHexString(com.tencent.mm.protocal.d.whH));
    paramString1.append("&devicetype=");
    paramString1.append(com.tencent.mm.protocal.d.eQs);
    paramString1.append("&filelength=");
    paramString1.append(i);
    paramString1.append("&sum=");
    paramString1.append(str);
    paramString1.append("&reporttype=");
    paramString1.append(paramInt);
    paramString1.append("&reportvalue=");
    paramString1.append(bo.aoy() + ".0.1");
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
        ab.e("MicroMsg.StackReportUploader", "execute http failed resp null");
        AppMethodBeat.o(72657);
        return false;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.StackReportUploader", "exception:%s", new Object[] { bo.l(paramArrayOfByte) });
      ab.d("MicroMsg.StackReportUploader", "execute post failed msg:%s", new Object[] { paramArrayOfByte.getMessage() });
      AppMethodBeat.o(72657);
      return false;
    }
    if (paramArrayOfByte.getStatusLine().getStatusCode() != 200)
    {
      ab.e("MicroMsg.StackReportUploader", "error response code:%d ", new Object[] { Integer.valueOf(paramArrayOfByte.getStatusLine().getStatusCode()) });
      AppMethodBeat.o(72657);
      return false;
    }
    AppMethodBeat.o(72657);
    return true;
  }
  
  private static boolean d(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.ad
 * JD-Core Version:    0.7.0.1
 */