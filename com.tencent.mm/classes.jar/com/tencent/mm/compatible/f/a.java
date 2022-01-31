package com.tencent.mm.compatible.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;

public final class a
{
  public static Boolean erW;
  
  /* Error */
  public static void a(String paramString, java.util.List<a.b> paramList, java.util.List<a.a> paramList1)
  {
    // Byte code:
    //   0: ldc 17
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 29	com/tencent/mm/a/e:cN	(Ljava/lang/String;)Z
    //   9: ifne +16 -> 25
    //   12: ldc 31
    //   14: ldc 33
    //   16: invokestatic 38	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 17
    //   21: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: invokestatic 47	com/tencent/mm/sdk/platformtools/aa:dsG	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 49
    //   32: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +115 -> 150
    //   38: ldc 49
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_3
    //   44: new 57	java/io/BufferedReader
    //   47: dup
    //   48: new 59	java/io/FileReader
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 63	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   56: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_0
    //   60: aload_0
    //   61: astore_3
    //   62: aload_0
    //   63: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +659 -> 729
    //   73: aload_0
    //   74: astore_3
    //   75: aload 5
    //   77: invokevirtual 72	java/lang/String:trim	()Ljava/lang/String;
    //   80: astore 6
    //   82: aload_0
    //   83: astore_3
    //   84: aload 6
    //   86: invokevirtual 76	java/lang/String:length	()I
    //   89: ifeq -29 -> 60
    //   92: aload_0
    //   93: astore_3
    //   94: aload 6
    //   96: ldc 78
    //   98: invokestatic 84	com/tencent/mm/sdk/platformtools/br:F	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   101: astore 5
    //   103: aload 5
    //   105: ifnonnull +113 -> 218
    //   108: aload_0
    //   109: astore_3
    //   110: ldc 31
    //   112: ldc 86
    //   114: aload 6
    //   116: invokestatic 90	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokestatic 97	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: goto -65 -> 60
    //   128: astore_1
    //   129: ldc 31
    //   131: ldc 99
    //   133: invokestatic 97	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: ifnull +610 -> 747
    //   140: aload_0
    //   141: invokevirtual 103	java/io/BufferedReader:close	()V
    //   144: ldc 17
    //   146: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: return
    //   150: aload_3
    //   151: ldc 105
    //   153: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifne +12 -> 168
    //   159: aload_3
    //   160: ldc 107
    //   162: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +28 -> 193
    //   168: new 109	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   175: ldc 113
    //   177: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 105
    //   182: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: astore 4
    //   190: goto -148 -> 42
    //   193: new 109	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   200: ldc 113
    //   202: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 122
    //   207: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore 4
    //   215: goto -173 -> 42
    //   218: aload_0
    //   219: astore_3
    //   220: aload 5
    //   222: ldc 124
    //   224: invokeinterface 130 2 0
    //   229: checkcast 51	java/lang/String
    //   232: astore 7
    //   234: aload 7
    //   236: ifnonnull +47 -> 283
    //   239: aload_0
    //   240: astore_3
    //   241: ldc 31
    //   243: ldc 132
    //   245: aload 6
    //   247: invokestatic 90	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   250: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   253: invokestatic 97	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: goto -196 -> 60
    //   259: astore_1
    //   260: aload_0
    //   261: astore_3
    //   262: ldc 31
    //   264: ldc 134
    //   266: invokestatic 97	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_0
    //   270: ifnull +490 -> 760
    //   273: aload_0
    //   274: invokevirtual 103	java/io/BufferedReader:close	()V
    //   277: ldc 17
    //   279: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: aload_0
    //   284: astore_3
    //   285: aload 7
    //   287: ldc 136
    //   289: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifeq +219 -> 511
    //   295: aload_0
    //   296: astore_3
    //   297: new 8	com/tencent/mm/compatible/f/a$b
    //   300: dup
    //   301: iconst_0
    //   302: invokespecial 139	com/tencent/mm/compatible/f/a$b:<init>	(B)V
    //   305: astore 6
    //   307: aload_0
    //   308: astore_3
    //   309: aload 6
    //   311: new 141	android/util/SparseArray
    //   314: dup
    //   315: invokespecial 142	android/util/SparseArray:<init>	()V
    //   318: putfield 146	com/tencent/mm/compatible/f/a$b:esa	Landroid/util/SparseArray;
    //   321: aload_0
    //   322: astore_3
    //   323: aload 6
    //   325: aload 5
    //   327: ldc 148
    //   329: invokeinterface 130 2 0
    //   334: checkcast 51	java/lang/String
    //   337: putfield 152	com/tencent/mm/compatible/f/a$b:esb	Ljava/lang/String;
    //   340: aload_0
    //   341: astore_3
    //   342: aload 6
    //   344: aload 5
    //   346: ldc 154
    //   348: invokeinterface 130 2 0
    //   353: checkcast 51	java/lang/String
    //   356: putfield 157	com/tencent/mm/compatible/f/a$b:model	Ljava/lang/String;
    //   359: aload_0
    //   360: astore_3
    //   361: aload 6
    //   363: aload 5
    //   365: ldc 159
    //   367: invokeinterface 130 2 0
    //   372: checkcast 51	java/lang/String
    //   375: putfield 162	com/tencent/mm/compatible/f/a$b:version	Ljava/lang/String;
    //   378: aload_0
    //   379: astore_3
    //   380: aload 6
    //   382: getfield 146	com/tencent/mm/compatible/f/a$b:esa	Landroid/util/SparseArray;
    //   385: iconst_1
    //   386: aload 5
    //   388: new 109	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   395: ldc 164
    //   397: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 4
    //   402: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokeinterface 130 2 0
    //   413: invokevirtual 167	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   416: aload_0
    //   417: astore_3
    //   418: aload 6
    //   420: getfield 146	com/tencent/mm/compatible/f/a$b:esa	Landroid/util/SparseArray;
    //   423: iconst_2
    //   424: aload 5
    //   426: new 109	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   433: ldc 164
    //   435: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc 169
    //   440: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 4
    //   445: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokeinterface 130 2 0
    //   456: invokevirtual 167	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   459: aload_0
    //   460: astore_3
    //   461: aload 6
    //   463: aload 5
    //   465: ldc 171
    //   467: invokeinterface 130 2 0
    //   472: checkcast 51	java/lang/String
    //   475: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:apV	(Ljava/lang/String;)I
    //   478: putfield 181	com/tencent/mm/compatible/f/a$b:erZ	I
    //   481: aload_0
    //   482: astore_3
    //   483: aload_1
    //   484: aload 6
    //   486: invokeinterface 186 2 0
    //   491: pop
    //   492: goto -432 -> 60
    //   495: astore_0
    //   496: aload_3
    //   497: ifnull +7 -> 504
    //   500: aload_3
    //   501: invokevirtual 103	java/io/BufferedReader:close	()V
    //   504: ldc 17
    //   506: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   509: aload_0
    //   510: athrow
    //   511: aload_0
    //   512: astore_3
    //   513: aload 7
    //   515: ldc 188
    //   517: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   520: ifeq -460 -> 60
    //   523: aload_0
    //   524: astore_3
    //   525: new 6	com/tencent/mm/compatible/f/a$a
    //   528: dup
    //   529: iconst_0
    //   530: invokespecial 189	com/tencent/mm/compatible/f/a$a:<init>	(B)V
    //   533: astore 6
    //   535: aload_0
    //   536: astore_3
    //   537: aload 6
    //   539: new 141	android/util/SparseArray
    //   542: dup
    //   543: invokespecial 142	android/util/SparseArray:<init>	()V
    //   546: putfield 190	com/tencent/mm/compatible/f/a$a:esa	Landroid/util/SparseArray;
    //   549: aload_0
    //   550: astore_3
    //   551: aload 6
    //   553: aload 5
    //   555: ldc 192
    //   557: invokeinterface 130 2 0
    //   562: checkcast 51	java/lang/String
    //   565: putfield 195	com/tencent/mm/compatible/f/a$a:bYA	Ljava/lang/String;
    //   568: aload_0
    //   569: astore_3
    //   570: aload 6
    //   572: aload 5
    //   574: ldc 197
    //   576: invokeinterface 130 2 0
    //   581: checkcast 51	java/lang/String
    //   584: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:apV	(Ljava/lang/String;)I
    //   587: putfield 200	com/tencent/mm/compatible/f/a$a:erX	I
    //   590: aload_0
    //   591: astore_3
    //   592: aload 6
    //   594: aload 5
    //   596: ldc 202
    //   598: invokeinterface 130 2 0
    //   603: checkcast 51	java/lang/String
    //   606: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:apV	(Ljava/lang/String;)I
    //   609: putfield 205	com/tencent/mm/compatible/f/a$a:erY	I
    //   612: aload_0
    //   613: astore_3
    //   614: aload 6
    //   616: getfield 190	com/tencent/mm/compatible/f/a$a:esa	Landroid/util/SparseArray;
    //   619: iconst_1
    //   620: aload 5
    //   622: new 109	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   629: ldc 164
    //   631: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 4
    //   636: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokeinterface 130 2 0
    //   647: invokevirtual 167	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   650: aload_0
    //   651: astore_3
    //   652: aload 6
    //   654: getfield 190	com/tencent/mm/compatible/f/a$a:esa	Landroid/util/SparseArray;
    //   657: iconst_2
    //   658: aload 5
    //   660: new 109	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   667: ldc 164
    //   669: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: ldc 169
    //   674: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload 4
    //   679: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokeinterface 130 2 0
    //   690: invokevirtual 167	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   693: aload_0
    //   694: astore_3
    //   695: aload 6
    //   697: aload 5
    //   699: ldc 171
    //   701: invokeinterface 130 2 0
    //   706: checkcast 51	java/lang/String
    //   709: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:apV	(Ljava/lang/String;)I
    //   712: putfield 206	com/tencent/mm/compatible/f/a$a:erZ	I
    //   715: aload_0
    //   716: astore_3
    //   717: aload_2
    //   718: aload 6
    //   720: invokeinterface 186 2 0
    //   725: pop
    //   726: goto -666 -> 60
    //   729: aload_0
    //   730: invokevirtual 103	java/io/BufferedReader:close	()V
    //   733: ldc 17
    //   735: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   738: return
    //   739: astore_0
    //   740: ldc 17
    //   742: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   745: return
    //   746: astore_0
    //   747: ldc 17
    //   749: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   752: return
    //   753: astore_0
    //   754: ldc 17
    //   756: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   759: return
    //   760: ldc 17
    //   762: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   765: return
    //   766: astore_1
    //   767: goto -263 -> 504
    //   770: astore_0
    //   771: aconst_null
    //   772: astore_3
    //   773: goto -277 -> 496
    //   776: astore_1
    //   777: aload_0
    //   778: astore_3
    //   779: aload_1
    //   780: astore_0
    //   781: goto -285 -> 496
    //   784: astore_0
    //   785: aconst_null
    //   786: astore_0
    //   787: goto -527 -> 260
    //   790: astore_0
    //   791: aload_3
    //   792: astore_0
    //   793: goto -664 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	796	0	paramString	String
    //   0	796	1	paramList	java.util.List<a.b>
    //   0	796	2	paramList1	java.util.List<a.a>
    //   28	764	3	str1	String
    //   40	638	4	str2	String
    //   66	632	5	localObject1	Object
    //   80	639	6	localObject2	Object
    //   232	282	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   62	68	128	java/io/FileNotFoundException
    //   75	82	128	java/io/FileNotFoundException
    //   84	92	128	java/io/FileNotFoundException
    //   94	103	128	java/io/FileNotFoundException
    //   110	125	128	java/io/FileNotFoundException
    //   220	234	128	java/io/FileNotFoundException
    //   241	256	128	java/io/FileNotFoundException
    //   285	295	128	java/io/FileNotFoundException
    //   297	307	128	java/io/FileNotFoundException
    //   309	321	128	java/io/FileNotFoundException
    //   323	340	128	java/io/FileNotFoundException
    //   342	359	128	java/io/FileNotFoundException
    //   361	378	128	java/io/FileNotFoundException
    //   380	416	128	java/io/FileNotFoundException
    //   418	459	128	java/io/FileNotFoundException
    //   461	481	128	java/io/FileNotFoundException
    //   483	492	128	java/io/FileNotFoundException
    //   513	523	128	java/io/FileNotFoundException
    //   525	535	128	java/io/FileNotFoundException
    //   537	549	128	java/io/FileNotFoundException
    //   551	568	128	java/io/FileNotFoundException
    //   570	590	128	java/io/FileNotFoundException
    //   592	612	128	java/io/FileNotFoundException
    //   614	650	128	java/io/FileNotFoundException
    //   652	693	128	java/io/FileNotFoundException
    //   695	715	128	java/io/FileNotFoundException
    //   717	726	128	java/io/FileNotFoundException
    //   62	68	259	java/io/IOException
    //   75	82	259	java/io/IOException
    //   84	92	259	java/io/IOException
    //   94	103	259	java/io/IOException
    //   110	125	259	java/io/IOException
    //   220	234	259	java/io/IOException
    //   241	256	259	java/io/IOException
    //   285	295	259	java/io/IOException
    //   297	307	259	java/io/IOException
    //   309	321	259	java/io/IOException
    //   323	340	259	java/io/IOException
    //   342	359	259	java/io/IOException
    //   361	378	259	java/io/IOException
    //   380	416	259	java/io/IOException
    //   418	459	259	java/io/IOException
    //   461	481	259	java/io/IOException
    //   483	492	259	java/io/IOException
    //   513	523	259	java/io/IOException
    //   525	535	259	java/io/IOException
    //   537	549	259	java/io/IOException
    //   551	568	259	java/io/IOException
    //   570	590	259	java/io/IOException
    //   592	612	259	java/io/IOException
    //   614	650	259	java/io/IOException
    //   652	693	259	java/io/IOException
    //   695	715	259	java/io/IOException
    //   717	726	259	java/io/IOException
    //   62	68	495	finally
    //   75	82	495	finally
    //   84	92	495	finally
    //   94	103	495	finally
    //   110	125	495	finally
    //   220	234	495	finally
    //   241	256	495	finally
    //   262	269	495	finally
    //   285	295	495	finally
    //   297	307	495	finally
    //   309	321	495	finally
    //   323	340	495	finally
    //   342	359	495	finally
    //   361	378	495	finally
    //   380	416	495	finally
    //   418	459	495	finally
    //   461	481	495	finally
    //   483	492	495	finally
    //   513	523	495	finally
    //   525	535	495	finally
    //   537	549	495	finally
    //   551	568	495	finally
    //   570	590	495	finally
    //   592	612	495	finally
    //   614	650	495	finally
    //   652	693	495	finally
    //   695	715	495	finally
    //   717	726	495	finally
    //   729	733	739	java/io/IOException
    //   140	144	746	java/io/IOException
    //   273	277	753	java/io/IOException
    //   500	504	766	java/io/IOException
    //   44	60	770	finally
    //   129	136	776	finally
    //   44	60	784	java/io/IOException
    //   44	60	790	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString1, String paramString2, PInt paramPInt, PBool paramPBool)
  {
    AppMethodBeat.i(93041);
    if (paramString1 == null)
    {
      paramPBool.value = false;
      AppMethodBeat.o(93041);
      return false;
    }
    if (paramString2 == null)
    {
      paramPBool.value = true;
      AppMethodBeat.o(93041);
      return false;
    }
    if (paramString1.equals(paramString2))
    {
      paramPInt.value += 1;
      paramPBool.value = true;
      AppMethodBeat.o(93041);
      return true;
    }
    paramPBool.value = false;
    AppMethodBeat.o(93041);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a
 * JD-Core Version:    0.7.0.1
 */