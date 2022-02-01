package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class cl
{
  public static boolean hLp = false;
  private static cl hLs = null;
  private ArrayList<String> hLq;
  private String hLr;
  
  /* Error */
  public cl(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	java/lang/Object:<init>	()V
    //   4: ldc 27
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: new 35	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 36	java/util/ArrayList:<init>	()V
    //   17: putfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: ldc 40
    //   23: putfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   26: aload_0
    //   27: new 44	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   34: aload_1
    //   35: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 51
    //   40: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: putfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   49: new 57	java/io/RandomAccessFile
    //   52: dup
    //   53: aload_0
    //   54: getfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   57: ldc 59
    //   59: invokespecial 62	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: astore 6
    //   64: aload 6
    //   66: astore_1
    //   67: aload 6
    //   69: invokevirtual 66	java/io/RandomAccessFile:length	()J
    //   72: lstore 4
    //   74: aload 6
    //   76: astore_1
    //   77: ldc 68
    //   79: ldc 70
    //   81: iconst_4
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: lload 4
    //   89: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: iload_2
    //   96: invokestatic 81	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   99: aastore
    //   100: dup
    //   101: iconst_2
    //   102: getstatic 87	com/tencent/mm/protocal/d:FFH	I
    //   105: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: dup
    //   110: iconst_3
    //   111: aload_0
    //   112: getfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   115: aastore
    //   116: invokestatic 97	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: lload 4
    //   121: lconst_0
    //   122: lcmp
    //   123: ifle +12 -> 135
    //   126: lload 4
    //   128: ldc2_w 98
    //   131: lcmp
    //   132: ifle +269 -> 401
    //   135: aload 6
    //   137: astore_1
    //   138: aload 6
    //   140: lconst_0
    //   141: invokevirtual 103	java/io/RandomAccessFile:seek	(J)V
    //   144: iload_2
    //   145: ifne +69 -> 214
    //   148: aload 6
    //   150: astore_1
    //   151: ldc 105
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: ldc 106
    //   161: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aastore
    //   165: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   168: astore 7
    //   170: aload 6
    //   172: astore_1
    //   173: aload 6
    //   175: new 44	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   182: aload 7
    //   184: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 114
    //   189: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 118	java/lang/String:getBytes	()[B
    //   198: invokevirtual 122	java/io/RandomAccessFile:write	([B)V
    //   201: aload 6
    //   203: astore_1
    //   204: aload_0
    //   205: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   208: aload 7
    //   210: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   213: pop
    //   214: aload 6
    //   216: astore_1
    //   217: ldc 105
    //   219: iconst_1
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: getstatic 87	com/tencent/mm/protocal/d:FFH	I
    //   228: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   235: astore 7
    //   237: aload 6
    //   239: astore_1
    //   240: aload_0
    //   241: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   244: invokevirtual 130	java/util/ArrayList:size	()I
    //   247: ifeq +30 -> 277
    //   250: aload 6
    //   252: astore_1
    //   253: aload 7
    //   255: aload_0
    //   256: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   259: aload_0
    //   260: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   263: invokevirtual 130	java/util/ArrayList:size	()I
    //   266: iconst_1
    //   267: isub
    //   268: invokevirtual 134	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   271: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifne +501 -> 775
    //   277: aload 6
    //   279: astore_1
    //   280: iconst_1
    //   281: putstatic 17	com/tencent/mm/model/cl:hLp	Z
    //   284: aload 6
    //   286: astore_1
    //   287: aload_0
    //   288: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   291: aload 7
    //   293: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   296: pop
    //   297: aload 6
    //   299: astore_1
    //   300: aload 6
    //   302: lload 4
    //   304: invokevirtual 103	java/io/RandomAccessFile:seek	(J)V
    //   307: aload 6
    //   309: astore_1
    //   310: aload 6
    //   312: new 44	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   319: aload 7
    //   321: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 114
    //   326: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 118	java/lang/String:getBytes	()[B
    //   335: invokevirtual 122	java/io/RandomAccessFile:write	([B)V
    //   338: goto +437 -> 775
    //   341: aload 6
    //   343: astore_1
    //   344: iload_3
    //   345: aload_0
    //   346: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   349: invokevirtual 130	java/util/ArrayList:size	()I
    //   352: if_icmpge +270 -> 622
    //   355: aload 6
    //   357: astore_1
    //   358: new 44	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   365: aload 7
    //   367: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_0
    //   371: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   374: iload_3
    //   375: invokevirtual 134	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   378: checkcast 108	java/lang/String
    //   381: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc 139
    //   386: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: astore 7
    //   394: iload_3
    //   395: iconst_1
    //   396: iadd
    //   397: istore_3
    //   398: goto -57 -> 341
    //   401: aload 6
    //   403: astore_1
    //   404: aload 6
    //   406: invokevirtual 142	java/io/RandomAccessFile:getFilePointer	()J
    //   409: lload 4
    //   411: lcmp
    //   412: ifge -198 -> 214
    //   415: aload 6
    //   417: astore_1
    //   418: aload 6
    //   420: invokevirtual 145	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   423: ldc 40
    //   425: invokestatic 151	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 7
    //   430: aload 6
    //   432: astore_1
    //   433: aload 7
    //   435: invokevirtual 153	java/lang/String:length	()I
    //   438: bipush 8
    //   440: if_icmpeq +104 -> 544
    //   443: aload 6
    //   445: astore_1
    //   446: ldc 68
    //   448: ldc 155
    //   450: iconst_2
    //   451: anewarray 4	java/lang/Object
    //   454: dup
    //   455: iconst_0
    //   456: aload 7
    //   458: invokevirtual 153	java/lang/String:length	()I
    //   461: invokestatic 92	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   464: aastore
    //   465: dup
    //   466: iconst_1
    //   467: aload_0
    //   468: getfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   471: aastore
    //   472: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: goto -74 -> 401
    //   478: astore 7
    //   480: aload 6
    //   482: astore_1
    //   483: ldc 68
    //   485: aload 7
    //   487: ldc 160
    //   489: iconst_1
    //   490: anewarray 4	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: ldc 40
    //   497: aastore
    //   498: invokestatic 164	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: aload 6
    //   503: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   506: getstatic 19	com/tencent/mm/model/cl:hLs	Lcom/tencent/mm/model/cl;
    //   509: ifnull +29 -> 538
    //   512: getstatic 19	com/tencent/mm/model/cl:hLs	Lcom/tencent/mm/model/cl;
    //   515: aload_0
    //   516: if_acmpeq +22 -> 538
    //   519: getstatic 19	com/tencent/mm/model/cl:hLs	Lcom/tencent/mm/model/cl;
    //   522: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   525: invokevirtual 130	java/util/ArrayList:size	()I
    //   528: aload_0
    //   529: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   532: invokevirtual 130	java/util/ArrayList:size	()I
    //   535: if_icmplt +195 -> 730
    //   538: ldc 27
    //   540: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: return
    //   544: aload 6
    //   546: astore_1
    //   547: aload 7
    //   549: ldc 172
    //   551: invokevirtual 176	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   554: ifne +52 -> 606
    //   557: aload 6
    //   559: astore_1
    //   560: ldc 68
    //   562: ldc 178
    //   564: iconst_2
    //   565: anewarray 4	java/lang/Object
    //   568: dup
    //   569: iconst_0
    //   570: aload 7
    //   572: aastore
    //   573: dup
    //   574: iconst_1
    //   575: aload_0
    //   576: getfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   579: aastore
    //   580: invokestatic 158	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   583: goto -182 -> 401
    //   586: astore 7
    //   588: aload_1
    //   589: astore 6
    //   591: aload 7
    //   593: astore_1
    //   594: aload 6
    //   596: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   599: ldc 27
    //   601: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   604: aload_1
    //   605: athrow
    //   606: aload 6
    //   608: astore_1
    //   609: aload_0
    //   610: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   613: aload 7
    //   615: invokevirtual 126	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   618: pop
    //   619: goto -218 -> 401
    //   622: aload 6
    //   624: astore_1
    //   625: ldc 68
    //   627: ldc 180
    //   629: iconst_3
    //   630: anewarray 4	java/lang/Object
    //   633: dup
    //   634: iconst_0
    //   635: getstatic 17	com/tencent/mm/model/cl:hLp	Z
    //   638: invokestatic 81	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   641: aastore
    //   642: dup
    //   643: iconst_1
    //   644: aload 7
    //   646: aastore
    //   647: dup
    //   648: iconst_2
    //   649: aload_0
    //   650: getfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   653: aastore
    //   654: invokestatic 97	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   657: aload 6
    //   659: invokevirtual 167	java/io/RandomAccessFile:close	()V
    //   662: goto -156 -> 506
    //   665: astore_1
    //   666: ldc 68
    //   668: aload_1
    //   669: ldc 182
    //   671: iconst_1
    //   672: anewarray 4	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: ldc 40
    //   679: aastore
    //   680: invokestatic 164	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   683: goto -177 -> 506
    //   686: astore_1
    //   687: ldc 68
    //   689: aload_1
    //   690: ldc 182
    //   692: iconst_1
    //   693: anewarray 4	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: ldc 40
    //   700: aastore
    //   701: invokestatic 164	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   704: goto -198 -> 506
    //   707: astore 6
    //   709: ldc 68
    //   711: aload 6
    //   713: ldc 182
    //   715: iconst_1
    //   716: anewarray 4	java/lang/Object
    //   719: dup
    //   720: iconst_0
    //   721: ldc 40
    //   723: aastore
    //   724: invokestatic 164	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   727: goto -128 -> 599
    //   730: getstatic 19	com/tencent/mm/model/cl:hLs	Lcom/tencent/mm/model/cl;
    //   733: aload_0
    //   734: getfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   737: putfield 38	com/tencent/mm/model/cl:hLq	Ljava/util/ArrayList;
    //   740: aload_0
    //   741: getfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   744: getstatic 19	com/tencent/mm/model/cl:hLs	Lcom/tencent/mm/model/cl;
    //   747: getfield 42	com/tencent/mm/model/cl:hLr	Ljava/lang/String;
    //   750: invokestatic 188	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   753: pop2
    //   754: ldc 27
    //   756: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   759: return
    //   760: astore_1
    //   761: aconst_null
    //   762: astore 6
    //   764: goto -170 -> 594
    //   767: astore 7
    //   769: aconst_null
    //   770: astore 6
    //   772: goto -292 -> 480
    //   775: iconst_0
    //   776: istore_3
    //   777: ldc 40
    //   779: astore 7
    //   781: goto -440 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	this	cl
    //   0	784	1	paramString	String
    //   0	784	2	paramBoolean	boolean
    //   344	433	3	i	int
    //   72	338	4	l	long
    //   62	596	6	localObject1	Object
    //   707	5	6	localException1	java.lang.Exception
    //   762	9	6	localObject2	Object
    //   168	289	7	str1	String
    //   478	93	7	localException2	java.lang.Exception
    //   586	59	7	localObject3	Object
    //   767	1	7	localException3	java.lang.Exception
    //   779	1	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   67	74	478	java/lang/Exception
    //   77	119	478	java/lang/Exception
    //   138	144	478	java/lang/Exception
    //   151	170	478	java/lang/Exception
    //   173	201	478	java/lang/Exception
    //   204	214	478	java/lang/Exception
    //   217	237	478	java/lang/Exception
    //   240	250	478	java/lang/Exception
    //   253	277	478	java/lang/Exception
    //   280	284	478	java/lang/Exception
    //   287	297	478	java/lang/Exception
    //   300	307	478	java/lang/Exception
    //   310	338	478	java/lang/Exception
    //   344	355	478	java/lang/Exception
    //   358	394	478	java/lang/Exception
    //   404	415	478	java/lang/Exception
    //   418	430	478	java/lang/Exception
    //   433	443	478	java/lang/Exception
    //   446	475	478	java/lang/Exception
    //   547	557	478	java/lang/Exception
    //   560	583	478	java/lang/Exception
    //   609	619	478	java/lang/Exception
    //   625	657	478	java/lang/Exception
    //   67	74	586	finally
    //   77	119	586	finally
    //   138	144	586	finally
    //   151	170	586	finally
    //   173	201	586	finally
    //   204	214	586	finally
    //   217	237	586	finally
    //   240	250	586	finally
    //   253	277	586	finally
    //   280	284	586	finally
    //   287	297	586	finally
    //   300	307	586	finally
    //   310	338	586	finally
    //   344	355	586	finally
    //   358	394	586	finally
    //   404	415	586	finally
    //   418	430	586	finally
    //   433	443	586	finally
    //   446	475	586	finally
    //   483	501	586	finally
    //   547	557	586	finally
    //   560	583	586	finally
    //   609	619	586	finally
    //   625	657	586	finally
    //   657	662	665	java/lang/Exception
    //   501	506	686	java/lang/Exception
    //   594	599	707	java/lang/Exception
    //   26	64	760	finally
    //   26	64	767	java/lang/Exception
  }
  
  public static void Cf(String paramString)
  {
    AppMethodBeat.i(132290);
    hLs = new cl(paramString, true);
    AppMethodBeat.o(132290);
  }
  
  public static String oI(int paramInt)
  {
    AppMethodBeat.i(132291);
    if (hLs != null)
    {
      cl localcl = hLs;
      String str = "";
      if (paramInt >= localcl.hLq.size()) {
        paramInt = 0;
      }
      while (paramInt < localcl.hLq.size())
      {
        str = str + (String)localcl.hLq.get(paramInt) + ";";
        paramInt += 1;
        continue;
        paramInt = localcl.hLq.size() - paramInt;
      }
      AppMethodBeat.o(132291);
      return str;
    }
    AppMethodBeat.o(132291);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cl
 * JD-Core Version:    0.7.0.1
 */