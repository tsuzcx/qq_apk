package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public final class aa
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
    //   46: invokestatic 40	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
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
    //   91: if_icmpgt +87 -> 178
    //   94: aload_0
    //   95: iconst_0
    //   96: iconst_m1
    //   97: invokestatic 53	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
    //   100: astore 10
    //   102: aload 10
    //   104: aload_0
    //   105: aload_1
    //   106: iload_3
    //   107: invokestatic 56	com/tencent/mm/platformtools/aa:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   110: istore 9
    //   112: aload 10
    //   114: ifnull +59 -> 173
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
    //   153: ifeq +12 -> 165
    //   156: iload_2
    //   157: ifeq +8 -> 165
    //   160: aload_0
    //   161: invokestatic 69	com/tencent/mm/vfs/u:deleteDir	(Ljava/lang/String;)Z
    //   164: pop
    //   165: ldc 9
    //   167: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iload 9
    //   172: ireturn
    //   173: iconst_m1
    //   174: istore_3
    //   175: goto -54 -> 121
    //   178: iload 5
    //   180: ldc 70
    //   182: idiv
    //   183: iconst_1
    //   184: iadd
    //   185: istore 6
    //   187: ldc 49
    //   189: newarray byte
    //   191: astore 13
    //   193: invokestatic 74	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   196: l2i
    //   197: istore 7
    //   199: aconst_null
    //   200: astore 11
    //   202: aconst_null
    //   203: astore 10
    //   205: aload_0
    //   206: invokestatic 78	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   209: astore 12
    //   211: iconst_0
    //   212: istore 4
    //   214: iload 4
    //   216: iload 6
    //   218: if_icmpge +277 -> 495
    //   221: aload 12
    //   223: astore 10
    //   225: aload 12
    //   227: astore 11
    //   229: aload 12
    //   231: aload 13
    //   233: bipush 12
    //   235: ldc 70
    //   237: invokevirtual 84	java/io/InputStream:read	([BII)I
    //   240: istore 8
    //   242: iload 8
    //   244: ifge +43 -> 287
    //   247: aload 12
    //   249: astore 10
    //   251: aload 12
    //   253: astore 11
    //   255: ldc 23
    //   257: ldc 86
    //   259: iconst_1
    //   260: anewarray 4	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload_0
    //   266: aastore
    //   267: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload 12
    //   272: ifnull +8 -> 280
    //   275: aload 12
    //   277: invokevirtual 90	java/io/InputStream:close	()V
    //   280: ldc 9
    //   282: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: iconst_0
    //   286: ireturn
    //   287: aload 12
    //   289: astore 10
    //   291: aload 12
    //   293: astore 11
    //   295: iload 7
    //   297: aload 13
    //   299: iconst_0
    //   300: invokestatic 93	com/tencent/mm/platformtools/aa:d	(I[BI)Z
    //   303: pop
    //   304: aload 12
    //   306: astore 10
    //   308: aload 12
    //   310: astore 11
    //   312: iload 4
    //   314: aload 13
    //   316: iconst_4
    //   317: invokestatic 93	com/tencent/mm/platformtools/aa:d	(I[BI)Z
    //   320: pop
    //   321: aload 12
    //   323: astore 10
    //   325: aload 12
    //   327: astore 11
    //   329: iload 8
    //   331: aload 13
    //   333: bipush 8
    //   335: invokestatic 93	com/tencent/mm/platformtools/aa:d	(I[BI)Z
    //   338: pop
    //   339: iload 8
    //   341: ldc 70
    //   343: if_icmpge +131 -> 474
    //   346: aload 12
    //   348: astore 10
    //   350: aload 12
    //   352: astore 11
    //   354: iload 8
    //   356: bipush 12
    //   358: iadd
    //   359: newarray byte
    //   361: astore 14
    //   363: aload 12
    //   365: astore 10
    //   367: aload 12
    //   369: astore 11
    //   371: aload 13
    //   373: iconst_0
    //   374: aload 14
    //   376: iconst_0
    //   377: aload 14
    //   379: arraylength
    //   380: invokestatic 99	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   383: aload 12
    //   385: astore 10
    //   387: aload 12
    //   389: astore 11
    //   391: aload 14
    //   393: aload_0
    //   394: aload_1
    //   395: iload_3
    //   396: invokestatic 56	com/tencent/mm/platformtools/aa:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   399: istore 9
    //   401: aload 12
    //   403: astore 10
    //   405: aload 12
    //   407: astore 11
    //   409: ldc 23
    //   411: ldc 101
    //   413: bipush 6
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: iload 4
    //   422: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: aastore
    //   426: dup
    //   427: iconst_1
    //   428: iload 6
    //   430: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: aastore
    //   434: dup
    //   435: iconst_2
    //   436: iload 8
    //   438: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: aastore
    //   442: dup
    //   443: iconst_3
    //   444: iload 9
    //   446: invokestatic 63	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   449: aastore
    //   450: dup
    //   451: iconst_4
    //   452: iload 5
    //   454: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: aastore
    //   458: dup
    //   459: iconst_5
    //   460: aload_0
    //   461: aastore
    //   462: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: iload 4
    //   467: iconst_1
    //   468: iadd
    //   469: istore 4
    //   471: goto -257 -> 214
    //   474: aload 12
    //   476: astore 10
    //   478: aload 12
    //   480: astore 11
    //   482: aload 13
    //   484: aload_0
    //   485: aload_1
    //   486: iload_3
    //   487: invokestatic 56	com/tencent/mm/platformtools/aa:a	([BLjava/lang/String;Ljava/lang/String;I)Z
    //   490: istore 9
    //   492: goto -91 -> 401
    //   495: iload_2
    //   496: ifeq +16 -> 512
    //   499: aload 12
    //   501: astore 10
    //   503: aload 12
    //   505: astore 11
    //   507: aload_0
    //   508: invokestatic 69	com/tencent/mm/vfs/u:deleteDir	(Ljava/lang/String;)Z
    //   511: pop
    //   512: aload 12
    //   514: ifnull +8 -> 522
    //   517: aload 12
    //   519: invokevirtual 90	java/io/InputStream:close	()V
    //   522: ldc 9
    //   524: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: iconst_1
    //   528: ireturn
    //   529: astore_1
    //   530: aload 10
    //   532: astore 11
    //   534: ldc 23
    //   536: ldc 103
    //   538: iconst_1
    //   539: anewarray 4	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: aload_1
    //   545: invokestatic 107	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   548: aastore
    //   549: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: aload 10
    //   554: astore 11
    //   556: ldc 23
    //   558: ldc 109
    //   560: iconst_1
    //   561: anewarray 4	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: aload_0
    //   567: aastore
    //   568: invokestatic 31	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload 10
    //   573: ifnull +8 -> 581
    //   576: aload 10
    //   578: invokevirtual 90	java/io/InputStream:close	()V
    //   581: ldc 9
    //   583: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: iconst_0
    //   587: ireturn
    //   588: astore_0
    //   589: aload 11
    //   591: ifnull +8 -> 599
    //   594: aload 11
    //   596: invokevirtual 90	java/io/InputStream:close	()V
    //   599: ldc 9
    //   601: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   604: aload_0
    //   605: athrow
    //   606: astore_0
    //   607: goto -327 -> 280
    //   610: astore_0
    //   611: goto -89 -> 522
    //   614: astore_0
    //   615: goto -34 -> 581
    //   618: astore_1
    //   619: goto -20 -> 599
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	paramString1	String
    //   0	622	1	paramString2	String
    //   0	622	2	paramBoolean	boolean
    //   0	622	3	paramInt	int
    //   212	258	4	i	int
    //   50	403	5	j	int
    //   185	244	6	k	int
    //   197	99	7	m	int
    //   240	197	8	n	int
    //   110	381	9	bool	boolean
    //   100	477	10	localObject1	Object
    //   200	395	11	localObject2	Object
    //   209	309	12	localInputStream	java.io.InputStream
    //   191	292	13	arrayOfByte1	byte[]
    //   361	31	14	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   205	211	529	java/lang/Exception
    //   229	242	529	java/lang/Exception
    //   255	270	529	java/lang/Exception
    //   295	304	529	java/lang/Exception
    //   312	321	529	java/lang/Exception
    //   329	339	529	java/lang/Exception
    //   354	363	529	java/lang/Exception
    //   371	383	529	java/lang/Exception
    //   391	401	529	java/lang/Exception
    //   409	465	529	java/lang/Exception
    //   482	492	529	java/lang/Exception
    //   507	512	529	java/lang/Exception
    //   205	211	588	finally
    //   229	242	588	finally
    //   255	270	588	finally
    //   295	304	588	finally
    //   312	321	588	finally
    //   329	339	588	finally
    //   354	363	588	finally
    //   371	383	588	finally
    //   391	401	588	finally
    //   409	465	588	finally
    //   482	492	588	finally
    //   507	512	588	finally
    //   534	552	588	finally
    //   556	571	588	finally
    //   275	280	606	java/lang/Exception
    //   517	522	610	java/lang/Exception
    //   576	581	614	java/lang/Exception
    //   594	599	618	java/lang/Exception
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
    String str1 = g.getMessageDigest(String.format("weixin#$()%d%d", new Object[] { Integer.valueOf(d.RAD), Integer.valueOf(i) }).getBytes()).toLowerCase();
    paramArrayOfByte = s.compress(paramArrayOfByte);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.StackReportUploader", "zip data failed file:%s", new Object[] { paramString1 });
      AppMethodBeat.o(143773);
      return false;
    }
    Object localObject = new PByteArray();
    com.tencent.mm.b.c.a((PByteArray)localObject, paramArrayOfByte, str1.getBytes());
    paramArrayOfByte = ((PByteArray)localObject).value;
    if (Util.isNullOrNil(paramArrayOfByte)) {
      Log.e("MicroMsg.StackReportUploader", "encrypt data failed file:%s", new Object[] { paramString1 });
    }
    paramString1 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
    localObject = new StringBuilder("https://");
    String str2 = com.tencent.mm.network.c.kRi;
    localObject = paramString1.getString(str2, str2);
    paramString1 = new StringBuffer();
    paramString1.append((String)localObject + "/cgi-bin/mmsupport-bin/stackreport?version=");
    paramString1.append(Integer.toHexString(d.RAD));
    paramString1.append("&devicetype=");
    paramString1.append(d.kQZ);
    paramString1.append("&filelength=");
    paramString1.append(i);
    paramString1.append("&sum=");
    paramString1.append(str1);
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
    AppMethodBeat.i(194151);
    if (paramBoolean)
    {
      ThreadPool.post(new aa.1(paramString1, paramString2, false, paramInt2), "StackReportUploader_uploadFileDirect", paramInt1);
      AppMethodBeat.o(194151);
      return true;
    }
    paramBoolean = a(paramString1, paramString2, false, paramInt2);
    AppMethodBeat.o(194151);
    return paramBoolean;
  }
  
  public static boolean bW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194152);
    boolean bool = b(paramString1, paramString2, true, 1, 20003);
    AppMethodBeat.o(194152);
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.aa
 * JD-Core Version:    0.7.0.1
 */