package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.RandomAccessFile;
import java.util.List;

public final class f
{
  private long duration;
  private long edP;
  private String filePath;
  public int gmA = 0;
  private long gmt;
  private long[] gmw;
  public int gmx;
  private List<g> gmy;
  private List<Pair> gmz;
  
  private static i a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(117850);
    ab.d("MicroMsg.Mp4Parser", "start to find trak atom.");
    if (!c.a(paramRandomAccessFile, paramLong))
    {
      AppMethodBeat.o(117850);
      return null;
    }
    paramRandomAccessFile = (i)c.a(paramRandomAccessFile, paramArrayOfByte, a.aES);
    AppMethodBeat.o(117850);
    return paramRandomAccessFile;
  }
  
  /* Error */
  public final boolean C(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aconst_null
    //   7: putfield 73	com/tencent/mm/plugin/a/f:filePath	Ljava/lang/String;
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 75	com/tencent/mm/plugin/a/f:gmw	[J
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 77	com/tencent/mm/plugin/a/f:gmx	I
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 79	com/tencent/mm/plugin/a/f:duration	J
    //   25: aload_0
    //   26: lconst_0
    //   27: putfield 81	com/tencent/mm/plugin/a/f:gmt	J
    //   30: aload_0
    //   31: lconst_0
    //   32: putfield 83	com/tencent/mm/plugin/a/f:edP	J
    //   35: aload_0
    //   36: getfield 85	com/tencent/mm/plugin/a/f:gmy	Ljava/util/List;
    //   39: ifnull +12 -> 51
    //   42: aload_0
    //   43: getfield 85	com/tencent/mm/plugin/a/f:gmy	Ljava/util/List;
    //   46: invokeinterface 90 1 0
    //   51: aload_0
    //   52: getfield 92	com/tencent/mm/plugin/a/f:gmz	Ljava/util/List;
    //   55: ifnull +12 -> 67
    //   58: aload_0
    //   59: getfield 92	com/tencent/mm/plugin/a/f:gmz	Ljava/util/List;
    //   62: invokeinterface 90 1 0
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 26	com/tencent/mm/plugin/a/f:gmA	I
    //   72: aload_0
    //   73: aload_1
    //   74: putfield 73	com/tencent/mm/plugin/a/f:filePath	Ljava/lang/String;
    //   77: aload_0
    //   78: lload_2
    //   79: putfield 83	com/tencent/mm/plugin/a/f:edP	J
    //   82: new 94	java/io/File
    //   85: dup
    //   86: aload_0
    //   87: getfield 73	com/tencent/mm/plugin/a/f:filePath	Ljava/lang/String;
    //   90: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 101	java/io/File:exists	()Z
    //   98: ifne +10 -> 108
    //   101: ldc 71
    //   103: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iconst_0
    //   107: ireturn
    //   108: bipush 8
    //   110: newarray byte
    //   112: astore 7
    //   114: new 103	java/io/RandomAccessFile
    //   117: dup
    //   118: aload_1
    //   119: ldc 105
    //   121: invokespecial 108	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   124: astore 6
    //   126: aload 6
    //   128: astore_1
    //   129: aload 6
    //   131: aload 7
    //   133: aload_0
    //   134: getfield 83	com/tencent/mm/plugin/a/f:edP	J
    //   137: invokestatic 110	com/tencent/mm/plugin/a/f:a	(Ljava/io/RandomAccessFile;[BJ)Lcom/tencent/mm/plugin/a/i;
    //   140: astore 5
    //   142: aload 5
    //   144: ifnull +318 -> 462
    //   147: aload 6
    //   149: astore_1
    //   150: ldc 38
    //   152: new 112	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 114
    //   158: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload 5
    //   163: getfield 118	com/tencent/mm/plugin/a/a:glY	J
    //   166: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 46	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload 6
    //   177: astore_1
    //   178: aload 6
    //   180: aload 7
    //   182: invokestatic 130	com/tencent/mm/plugin/a/i:b	(Ljava/io/RandomAccessFile;[B)Lcom/tencent/mm/plugin/a/e;
    //   185: astore 8
    //   187: aload 8
    //   189: ifnull +285 -> 474
    //   192: aload 6
    //   194: astore_1
    //   195: aload 8
    //   197: aload 6
    //   199: aload 7
    //   201: invokevirtual 135	com/tencent/mm/plugin/a/e:a	(Ljava/io/RandomAccessFile;[B)Z
    //   204: ifeq +270 -> 474
    //   207: aload 6
    //   209: astore_1
    //   210: aload 8
    //   212: getfield 138	com/tencent/mm/plugin/a/e:gmu	J
    //   215: getstatic 141	com/tencent/mm/plugin/a/e:gmq	I
    //   218: i2l
    //   219: lcmp
    //   220: ifne +418 -> 638
    //   223: iconst_1
    //   224: istore 4
    //   226: iload 4
    //   228: ifne +51 -> 279
    //   231: aload 6
    //   233: astore_1
    //   234: aload 5
    //   236: invokevirtual 145	com/tencent/mm/plugin/a/i:getEndPos	()J
    //   239: aload 6
    //   241: invokevirtual 148	java/io/RandomAccessFile:getFilePointer	()J
    //   244: lsub
    //   245: lstore_2
    //   246: aload 6
    //   248: astore_1
    //   249: ldc 38
    //   251: ldc 150
    //   253: lload_2
    //   254: invokestatic 156	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   257: invokevirtual 160	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   260: invokestatic 46	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 6
    //   265: astore_1
    //   266: aload 6
    //   268: aload 7
    //   270: lload_2
    //   271: invokestatic 110	com/tencent/mm/plugin/a/f:a	(Ljava/io/RandomAccessFile;[BJ)Lcom/tencent/mm/plugin/a/i;
    //   274: astore 5
    //   276: goto -134 -> 142
    //   279: aload 6
    //   281: astore_1
    //   282: aload_0
    //   283: aload 8
    //   285: getfield 161	com/tencent/mm/plugin/a/e:gmt	J
    //   288: putfield 81	com/tencent/mm/plugin/a/f:gmt	J
    //   291: aload 6
    //   293: astore_1
    //   294: aload_0
    //   295: aload 8
    //   297: getfield 162	com/tencent/mm/plugin/a/e:duration	J
    //   300: putfield 79	com/tencent/mm/plugin/a/f:duration	J
    //   303: aload 6
    //   305: astore_1
    //   306: ldc 38
    //   308: new 112	java/lang/StringBuilder
    //   311: dup
    //   312: ldc 164
    //   314: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload_0
    //   318: getfield 81	com/tencent/mm/plugin/a/f:gmt	J
    //   321: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   324: ldc 166
    //   326: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: getfield 79	com/tencent/mm/plugin/a/f:duration	J
    //   333: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 46	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload 6
    //   344: astore_1
    //   345: aload 6
    //   347: aload 8
    //   349: getfield 172	com/tencent/mm/plugin/a/e:gmv	J
    //   352: invokevirtual 176	java/io/RandomAccessFile:seek	(J)V
    //   355: aload 6
    //   357: astore_1
    //   358: aload 6
    //   360: aload 7
    //   362: getstatic 179	com/tencent/mm/plugin/a/a:aEV	I
    //   365: invokestatic 62	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   368: checkcast 181	com/tencent/mm/plugin/a/h
    //   371: astore 5
    //   373: aload 5
    //   375: ifnull +87 -> 462
    //   378: aload 6
    //   380: astore_1
    //   381: aload 5
    //   383: aload_0
    //   384: getfield 79	com/tencent/mm/plugin/a/f:duration	J
    //   387: putfield 182	com/tencent/mm/plugin/a/h:duration	J
    //   390: aload 6
    //   392: astore_1
    //   393: aload 5
    //   395: aload_0
    //   396: getfield 81	com/tencent/mm/plugin/a/f:gmt	J
    //   399: putfield 183	com/tencent/mm/plugin/a/h:gmt	J
    //   402: aload 6
    //   404: astore_1
    //   405: aload 5
    //   407: aload 6
    //   409: invokevirtual 186	com/tencent/mm/plugin/a/h:d	(Ljava/io/RandomAccessFile;)V
    //   412: aload 6
    //   414: astore_1
    //   415: aload_0
    //   416: aload 5
    //   418: getfield 187	com/tencent/mm/plugin/a/h:gmw	[J
    //   421: putfield 75	com/tencent/mm/plugin/a/f:gmw	[J
    //   424: aload 6
    //   426: astore_1
    //   427: aload_0
    //   428: aload_0
    //   429: getfield 75	com/tencent/mm/plugin/a/f:gmw	[J
    //   432: arraylength
    //   433: iconst_2
    //   434: isub
    //   435: putfield 77	com/tencent/mm/plugin/a/f:gmx	I
    //   438: aload 6
    //   440: astore_1
    //   441: aload_0
    //   442: aload 5
    //   444: getfield 188	com/tencent/mm/plugin/a/h:gmy	Ljava/util/List;
    //   447: putfield 85	com/tencent/mm/plugin/a/f:gmy	Ljava/util/List;
    //   450: aload 6
    //   452: astore_1
    //   453: aload_0
    //   454: aload 5
    //   456: getfield 189	com/tencent/mm/plugin/a/h:gmz	Ljava/util/List;
    //   459: putfield 92	com/tencent/mm/plugin/a/f:gmz	Ljava/util/List;
    //   462: aload 6
    //   464: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   467: ldc 71
    //   469: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   472: iconst_1
    //   473: ireturn
    //   474: aload 6
    //   476: astore_1
    //   477: ldc 38
    //   479: ldc 194
    //   481: invokestatic 197	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aconst_null
    //   485: astore 5
    //   487: goto -345 -> 142
    //   490: astore_1
    //   491: ldc 38
    //   493: aload_1
    //   494: ldc 199
    //   496: iconst_0
    //   497: anewarray 4	java/lang/Object
    //   500: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   503: goto -36 -> 467
    //   506: astore 7
    //   508: aconst_null
    //   509: astore 5
    //   511: aload 5
    //   513: astore_1
    //   514: ldc 38
    //   516: aload 7
    //   518: ldc 199
    //   520: iconst_0
    //   521: anewarray 4	java/lang/Object
    //   524: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   527: aload 5
    //   529: astore_1
    //   530: ldc 38
    //   532: new 112	java/lang/StringBuilder
    //   535: dup
    //   536: ldc 205
    //   538: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   541: aload 7
    //   543: invokevirtual 206	java/lang/Exception:toString	()Ljava/lang/String;
    //   546: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 209	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload 5
    //   557: ifnull +8 -> 565
    //   560: aload 5
    //   562: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   565: ldc 71
    //   567: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: iconst_0
    //   571: ireturn
    //   572: astore_1
    //   573: ldc 38
    //   575: aload_1
    //   576: ldc 199
    //   578: iconst_0
    //   579: anewarray 4	java/lang/Object
    //   582: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   585: goto -20 -> 565
    //   588: astore 5
    //   590: aconst_null
    //   591: astore_1
    //   592: aload_1
    //   593: ifnull +7 -> 600
    //   596: aload_1
    //   597: invokevirtual 192	java/io/RandomAccessFile:close	()V
    //   600: ldc 71
    //   602: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   605: aload 5
    //   607: athrow
    //   608: astore_1
    //   609: ldc 38
    //   611: aload_1
    //   612: ldc 199
    //   614: iconst_0
    //   615: anewarray 4	java/lang/Object
    //   618: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   621: goto -21 -> 600
    //   624: astore 5
    //   626: goto -34 -> 592
    //   629: astore 7
    //   631: aload 6
    //   633: astore 5
    //   635: goto -124 -> 511
    //   638: iconst_0
    //   639: istore 4
    //   641: goto -415 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	f
    //   0	644	1	paramString	String
    //   0	644	2	paramLong	long
    //   224	416	4	i	int
    //   140	421	5	localObject1	Object
    //   588	18	5	localObject2	Object
    //   624	1	5	localObject3	Object
    //   633	1	5	localRandomAccessFile1	RandomAccessFile
    //   124	508	6	localRandomAccessFile2	RandomAccessFile
    //   112	249	7	arrayOfByte	byte[]
    //   506	36	7	localException1	Exception
    //   629	1	7	localException2	Exception
    //   185	163	8	locale	e
    // Exception table:
    //   from	to	target	type
    //   462	467	490	java/io/IOException
    //   108	126	506	java/lang/Exception
    //   560	565	572	java/io/IOException
    //   108	126	588	finally
    //   596	600	608	java/io/IOException
    //   129	142	624	finally
    //   150	175	624	finally
    //   178	187	624	finally
    //   195	207	624	finally
    //   210	223	624	finally
    //   234	246	624	finally
    //   249	263	624	finally
    //   266	276	624	finally
    //   282	291	624	finally
    //   294	303	624	finally
    //   306	342	624	finally
    //   345	355	624	finally
    //   358	373	624	finally
    //   381	390	624	finally
    //   393	402	624	finally
    //   405	412	624	finally
    //   415	424	624	finally
    //   427	438	624	finally
    //   441	450	624	finally
    //   453	462	624	finally
    //   477	484	624	finally
    //   514	527	624	finally
    //   530	555	624	finally
    //   129	142	629	java/lang/Exception
    //   150	175	629	java/lang/Exception
    //   178	187	629	java/lang/Exception
    //   195	207	629	java/lang/Exception
    //   210	223	629	java/lang/Exception
    //   234	246	629	java/lang/Exception
    //   249	263	629	java/lang/Exception
    //   266	276	629	java/lang/Exception
    //   282	291	629	java/lang/Exception
    //   294	303	629	java/lang/Exception
    //   306	342	629	java/lang/Exception
    //   345	355	629	java/lang/Exception
    //   358	373	629	java/lang/Exception
    //   381	390	629	java/lang/Exception
    //   393	402	629	java/lang/Exception
    //   405	412	629	java/lang/Exception
    //   415	424	629	java/lang/Exception
    //   427	438	629	java/lang/Exception
    //   441	450	629	java/lang/Exception
    //   453	462	629	java/lang/Exception
    //   477	484	629	java/lang/Exception
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    if (this.gmw == null) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.gmw.length;
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
    long l1 = this.gmw[i];
    long l2 = this.gmw[paramInt1];
    if (i == 0) {
      paramPInt1.value = 0;
    }
    for (paramPInt2.value = ((int)l2);; paramPInt2.value = ((int)l2 - (int)l1))
    {
      return true;
      paramPInt1.value = ((int)l1);
    }
  }
  
  public final int aoD()
  {
    AppMethodBeat.i(117847);
    for (;;)
    {
      try
      {
        if (this.gmz == null) {
          continue;
        }
        if (this.gmA == 0) {
          this.gmA = ((int)(((Long)((Pair)this.gmz.get(this.gmz.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.gmA;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Mp4Parser", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(117847);
      return i;
      i = 0;
    }
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(117848);
    for (;;)
    {
      try
      {
        if (this.gmz == null) {
          continue;
        }
        j = this.gmz.size();
        long l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.gmz.get(i);
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
        ab.printErrStackTrace("MicroMsg.Mp4Parser", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
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
        paramPInt1.value = ((int)(((Long)((Pair)this.gmz.get(j - 1)).second).longValue() / 1000L / 1000L));
        paramPInt2.value = paramInt;
        bool = true;
        ab.i("MicroMsg.Mp4Parser", "seek key Frame seekTime[%d] pre[%d] next[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
        AppMethodBeat.o(117848);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    AppMethodBeat.o(117848);
    return false;
  }
  
  public final int cP(int paramInt1, int paramInt2)
  {
    if (this.gmw == null) {
      return 0;
    }
    long l = paramInt1 + paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    int i = paramInt2;
    if (paramInt1 < this.gmw.length)
    {
      if (this.gmw[paramInt1] == l) {
        i = paramInt1;
      }
    }
    else {
      label44:
      return i;
    }
    if (this.gmw[paramInt1] < l) {
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      i = paramInt2;
      if (this.gmw[paramInt1] > l) {
        break label44;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.a.f
 * JD-Core Version:    0.7.0.1
 */