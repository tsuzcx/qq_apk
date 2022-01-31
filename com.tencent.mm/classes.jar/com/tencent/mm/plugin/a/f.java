package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.y;
import java.io.RandomAccessFile;
import java.util.List;

public final class f
{
  private long dmm;
  private long duration;
  private List<g> eUA;
  private List<Pair> eUB;
  public int eUC = 0;
  private long eUv;
  private long[] eUy;
  public int eUz;
  private String filePath;
  
  private static i a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, long paramLong)
  {
    y.d("MicroMsg.Mp4Parser", "start to find trak atom.");
    if (!c.a(paramRandomAccessFile, paramLong)) {
      return null;
    }
    return (i)c.a(paramRandomAccessFile, paramArrayOfByte, a.aAn);
  }
  
  public final int Vf()
  {
    try
    {
      if (this.eUB != null)
      {
        if (this.eUC == 0) {
          this.eUC = ((int)(((Long)((Pair)this.eUB.get(this.eUB.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        int i = this.eUC;
        return i;
      }
      return 0;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Mp4Parser", localException, "get last key frame error.", new Object[0]);
    }
    return 0;
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    if (this.eUy == null) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.eUy.length;
    if (i < j)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < j) {}
    }
    else
    {
      i = j - 2;
      paramInt1 = j - 1;
    }
    long l1 = this.eUy[i];
    long l2 = this.eUy[paramInt1];
    if (i == 0) {
      paramPInt1.value = 0;
    }
    for (paramPInt2.value = ((int)l2);; paramPInt2.value = ((int)l2 - (int)l1))
    {
      return true;
      paramPInt1.value = ((int)l1);
    }
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    for (;;)
    {
      try
      {
        if (this.eUB == null) {
          continue;
        }
        j = this.eUB.size();
        long l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.eUB.get(i);
        if (((Long)localPair.second).longValue() <= 1000L * (l * 1000L)) {
          continue;
        }
        paramPInt2.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        bool = true;
      }
      catch (Exception localException1)
      {
        int j;
        int i;
        Pair localPair;
        boolean bool = false;
        y.printErrStackTrace("MicroMsg.Mp4Parser", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
        continue;
        continue;
        bool = false;
        continue;
      }
      if (bool) {
        continue;
      }
      try
      {
        paramPInt1.value = ((int)(((Long)((Pair)this.eUB.get(j - 1)).second).longValue() / 1000L / 1000L));
        paramPInt2.value = paramInt;
        bool = true;
        y.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    return false;
  }
  
  public final int bE(int paramInt1, int paramInt2)
  {
    if (this.eUy == null) {
      return 0;
    }
    long l = paramInt1 + paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    int i = paramInt2;
    if (paramInt1 < this.eUy.length)
    {
      if (this.eUy[paramInt1] == l) {
        i = paramInt1;
      }
    }
    else {
      label44:
      return i;
    }
    if (this.eUy[paramInt1] < l) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      i = paramInt2;
      if (this.eUy[paramInt1] > l) {
        break label44;
      }
    }
  }
  
  /* Error */
  public final boolean t(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 124	com/tencent/mm/plugin/a/f:filePath	Ljava/lang/String;
    //   5: aload_0
    //   6: aconst_null
    //   7: putfield 92	com/tencent/mm/plugin/a/f:eUy	[J
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 126	com/tencent/mm/plugin/a/f:eUz	I
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 128	com/tencent/mm/plugin/a/f:duration	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 130	com/tencent/mm/plugin/a/f:eUv	J
    //   25: aload_0
    //   26: lconst_0
    //   27: putfield 132	com/tencent/mm/plugin/a/f:dmm	J
    //   30: aload_0
    //   31: getfield 134	com/tencent/mm/plugin/a/f:eUA	Ljava/util/List;
    //   34: ifnull +12 -> 46
    //   37: aload_0
    //   38: getfield 134	com/tencent/mm/plugin/a/f:eUA	Ljava/util/List;
    //   41: invokeinterface 137 1 0
    //   46: aload_0
    //   47: getfield 60	com/tencent/mm/plugin/a/f:eUB	Ljava/util/List;
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 60	com/tencent/mm/plugin/a/f:eUB	Ljava/util/List;
    //   57: invokeinterface 137 1 0
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 26	com/tencent/mm/plugin/a/f:eUC	I
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 124	com/tencent/mm/plugin/a/f:filePath	Ljava/lang/String;
    //   72: aload_0
    //   73: lload_2
    //   74: putfield 132	com/tencent/mm/plugin/a/f:dmm	J
    //   77: new 139	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: getfield 124	com/tencent/mm/plugin/a/f:filePath	Ljava/lang/String;
    //   85: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 146	java/io/File:exists	()Z
    //   93: ifne +5 -> 98
    //   96: iconst_0
    //   97: ireturn
    //   98: bipush 8
    //   100: newarray byte
    //   102: astore 6
    //   104: new 148	java/io/RandomAccessFile
    //   107: dup
    //   108: aload_1
    //   109: ldc 150
    //   111: invokespecial 153	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   114: astore 5
    //   116: aload 5
    //   118: aload 6
    //   120: aload_0
    //   121: getfield 132	com/tencent/mm/plugin/a/f:dmm	J
    //   124: invokestatic 155	com/tencent/mm/plugin/a/f:a	(Ljava/io/RandomAccessFile;[BJ)Lcom/tencent/mm/plugin/a/i;
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +257 -> 386
    //   132: ldc 31
    //   134: new 157	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 159
    //   140: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: getfield 163	com/tencent/mm/plugin/a/a:eUa	J
    //   147: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 39	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload 5
    //   158: aload 6
    //   160: invokestatic 174	com/tencent/mm/plugin/a/i:b	(Ljava/io/RandomAccessFile;[B)Lcom/tencent/mm/plugin/a/e;
    //   163: astore 7
    //   165: aload 7
    //   167: ifnull +226 -> 393
    //   170: aload 7
    //   172: aload 5
    //   174: aload 6
    //   176: invokevirtual 179	com/tencent/mm/plugin/a/e:a	(Ljava/io/RandomAccessFile;[B)Z
    //   179: ifeq +214 -> 393
    //   182: aload 7
    //   184: getfield 182	com/tencent/mm/plugin/a/e:eUw	J
    //   187: getstatic 185	com/tencent/mm/plugin/a/e:eUs	I
    //   190: i2l
    //   191: lcmp
    //   192: ifne +358 -> 550
    //   195: iconst_1
    //   196: istore 4
    //   198: iload 4
    //   200: ifne +47 -> 247
    //   203: aload_1
    //   204: invokevirtual 188	com/tencent/mm/plugin/a/i:Ve	()J
    //   207: aload 5
    //   209: invokevirtual 191	java/io/RandomAccessFile:getFilePointer	()J
    //   212: lsub
    //   213: lstore_2
    //   214: ldc 31
    //   216: new 157	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 193
    //   222: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: lload_2
    //   226: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   229: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 39	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 5
    //   237: aload 6
    //   239: lload_2
    //   240: invokestatic 155	com/tencent/mm/plugin/a/f:a	(Ljava/io/RandomAccessFile;[BJ)Lcom/tencent/mm/plugin/a/i;
    //   243: astore_1
    //   244: goto -116 -> 128
    //   247: aload_0
    //   248: aload 7
    //   250: getfield 194	com/tencent/mm/plugin/a/e:eUv	J
    //   253: putfield 130	com/tencent/mm/plugin/a/f:eUv	J
    //   256: aload_0
    //   257: aload 7
    //   259: getfield 195	com/tencent/mm/plugin/a/e:duration	J
    //   262: putfield 128	com/tencent/mm/plugin/a/f:duration	J
    //   265: ldc 31
    //   267: new 157	java/lang/StringBuilder
    //   270: dup
    //   271: ldc 197
    //   273: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: aload_0
    //   277: getfield 130	com/tencent/mm/plugin/a/f:eUv	J
    //   280: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   283: ldc 199
    //   285: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: getfield 128	com/tencent/mm/plugin/a/f:duration	J
    //   292: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   295: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 39	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 5
    //   303: aload 7
    //   305: getfield 205	com/tencent/mm/plugin/a/e:eUx	J
    //   308: invokevirtual 209	java/io/RandomAccessFile:seek	(J)V
    //   311: aload 5
    //   313: aload 6
    //   315: getstatic 212	com/tencent/mm/plugin/a/a:aAq	I
    //   318: invokestatic 52	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   321: checkcast 214	com/tencent/mm/plugin/a/h
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +60 -> 386
    //   329: aload_1
    //   330: aload_0
    //   331: getfield 128	com/tencent/mm/plugin/a/f:duration	J
    //   334: putfield 215	com/tencent/mm/plugin/a/h:duration	J
    //   337: aload_1
    //   338: aload_0
    //   339: getfield 130	com/tencent/mm/plugin/a/f:eUv	J
    //   342: putfield 216	com/tencent/mm/plugin/a/h:eUv	J
    //   345: aload_1
    //   346: aload 5
    //   348: invokevirtual 219	com/tencent/mm/plugin/a/h:d	(Ljava/io/RandomAccessFile;)V
    //   351: aload_0
    //   352: aload_1
    //   353: getfield 220	com/tencent/mm/plugin/a/h:eUy	[J
    //   356: putfield 92	com/tencent/mm/plugin/a/f:eUy	[J
    //   359: aload_0
    //   360: aload_0
    //   361: getfield 92	com/tencent/mm/plugin/a/f:eUy	[J
    //   364: arraylength
    //   365: iconst_2
    //   366: isub
    //   367: putfield 126	com/tencent/mm/plugin/a/f:eUz	I
    //   370: aload_0
    //   371: aload_1
    //   372: getfield 221	com/tencent/mm/plugin/a/h:eUA	Ljava/util/List;
    //   375: putfield 134	com/tencent/mm/plugin/a/f:eUA	Ljava/util/List;
    //   378: aload_0
    //   379: aload_1
    //   380: getfield 222	com/tencent/mm/plugin/a/h:eUB	Ljava/util/List;
    //   383: putfield 60	com/tencent/mm/plugin/a/f:eUB	Ljava/util/List;
    //   386: aload 5
    //   388: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   391: iconst_1
    //   392: ireturn
    //   393: ldc 31
    //   395: ldc 227
    //   397: invokestatic 230	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aconst_null
    //   401: astore_1
    //   402: goto -274 -> 128
    //   405: astore_1
    //   406: ldc 31
    //   408: aload_1
    //   409: ldc 232
    //   411: iconst_0
    //   412: anewarray 4	java/lang/Object
    //   415: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: goto -27 -> 391
    //   421: astore 5
    //   423: aconst_null
    //   424: astore_1
    //   425: ldc 31
    //   427: aload 5
    //   429: ldc 232
    //   431: iconst_0
    //   432: anewarray 4	java/lang/Object
    //   435: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: ldc 31
    //   440: new 157	java/lang/StringBuilder
    //   443: dup
    //   444: ldc 234
    //   446: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: aload 5
    //   451: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   454: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 238	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: aload_1
    //   464: ifnull +7 -> 471
    //   467: aload_1
    //   468: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   471: iconst_0
    //   472: ireturn
    //   473: astore_1
    //   474: ldc 31
    //   476: aload_1
    //   477: ldc 232
    //   479: iconst_0
    //   480: anewarray 4	java/lang/Object
    //   483: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   486: goto -15 -> 471
    //   489: astore_1
    //   490: aconst_null
    //   491: astore 5
    //   493: aload 5
    //   495: ifnull +8 -> 503
    //   498: aload 5
    //   500: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   503: aload_1
    //   504: athrow
    //   505: astore 5
    //   507: ldc 31
    //   509: aload 5
    //   511: ldc 232
    //   513: iconst_0
    //   514: anewarray 4	java/lang/Object
    //   517: invokestatic 89	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   520: goto -17 -> 503
    //   523: astore_1
    //   524: goto -31 -> 493
    //   527: astore 6
    //   529: aload_1
    //   530: astore 5
    //   532: aload 6
    //   534: astore_1
    //   535: goto -42 -> 493
    //   538: astore 6
    //   540: aload 5
    //   542: astore_1
    //   543: aload 6
    //   545: astore 5
    //   547: goto -122 -> 425
    //   550: iconst_0
    //   551: istore 4
    //   553: goto -355 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	f
    //   0	556	1	paramString	String
    //   0	556	2	paramLong	long
    //   196	356	4	i	int
    //   114	273	5	localRandomAccessFile	RandomAccessFile
    //   421	29	5	localException1	Exception
    //   491	8	5	localObject1	Object
    //   505	5	5	localIOException	java.io.IOException
    //   530	16	5	localObject2	Object
    //   102	212	6	arrayOfByte	byte[]
    //   527	6	6	localObject3	Object
    //   538	6	6	localException2	Exception
    //   163	141	7	locale	e
    // Exception table:
    //   from	to	target	type
    //   386	391	405	java/io/IOException
    //   98	116	421	java/lang/Exception
    //   467	471	473	java/io/IOException
    //   98	116	489	finally
    //   498	503	505	java/io/IOException
    //   116	128	523	finally
    //   132	165	523	finally
    //   170	195	523	finally
    //   203	244	523	finally
    //   247	325	523	finally
    //   329	386	523	finally
    //   393	400	523	finally
    //   425	463	527	finally
    //   116	128	538	java/lang/Exception
    //   132	165	538	java/lang/Exception
    //   170	195	538	java/lang/Exception
    //   203	244	538	java/lang/Exception
    //   247	325	538	java/lang/Exception
    //   329	386	538	java/lang/Exception
    //   393	400	538	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.a.f
 * JD-Core Version:    0.7.0.1
 */