package com.tencent.mm.compatible.f;

import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;

public final class a
{
  public static Boolean dzh;
  
  /* Error */
  public static void a(String paramString, java.util.List<a.b> paramList, java.util.List<a.a> paramList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 22	com/tencent/mm/a/e:bK	(Ljava/lang/String;)Z
    //   4: ifne +11 -> 15
    //   7: ldc 24
    //   9: ldc 26
    //   11: invokestatic 32	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: return
    //   15: invokestatic 38	com/tencent/mm/sdk/platformtools/x:cqJ	()Ljava/lang/String;
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 40
    //   22: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +119 -> 144
    //   28: ldc 40
    //   30: astore 4
    //   32: aconst_null
    //   33: astore_3
    //   34: new 48	java/io/BufferedReader
    //   37: dup
    //   38: new 50	java/io/FileReader
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 54	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 57	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_0
    //   50: aload_0
    //   51: astore_3
    //   52: aload_0
    //   53: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull +662 -> 722
    //   63: aload_0
    //   64: astore_3
    //   65: aload 5
    //   67: invokevirtual 63	java/lang/String:trim	()Ljava/lang/String;
    //   70: astore 6
    //   72: aload_0
    //   73: astore_3
    //   74: aload 6
    //   76: invokevirtual 67	java/lang/String:length	()I
    //   79: ifeq -29 -> 50
    //   82: aload_0
    //   83: astore_3
    //   84: aload 6
    //   86: ldc 69
    //   88: invokestatic 75	com/tencent/mm/sdk/platformtools/bn:s	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnonnull +117 -> 212
    //   98: aload_0
    //   99: astore_3
    //   100: ldc 24
    //   102: new 77	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 79
    //   108: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload 6
    //   113: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -72 -> 50
    //   125: astore_1
    //   126: ldc 24
    //   128: ldc 92
    //   130: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: ifnull -120 -> 14
    //   137: aload_0
    //   138: invokevirtual 96	java/io/BufferedReader:close	()V
    //   141: return
    //   142: astore_0
    //   143: return
    //   144: aload_3
    //   145: ldc 98
    //   147: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifne +12 -> 162
    //   153: aload_3
    //   154: ldc 100
    //   156: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   159: ifeq +28 -> 187
    //   162: new 77	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   169: ldc 104
    //   171: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 98
    //   176: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: astore 4
    //   184: goto -152 -> 32
    //   187: new 77	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   194: ldc 104
    //   196: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 106
    //   201: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore 4
    //   209: goto -177 -> 32
    //   212: aload_0
    //   213: astore_3
    //   214: aload 5
    //   216: ldc 108
    //   218: invokeinterface 114 2 0
    //   223: checkcast 42	java/lang/String
    //   226: astore 7
    //   228: aload 7
    //   230: ifnonnull +51 -> 281
    //   233: aload_0
    //   234: astore_3
    //   235: ldc 24
    //   237: new 77	java/lang/StringBuilder
    //   240: dup
    //   241: ldc 116
    //   243: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload 6
    //   248: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto -207 -> 50
    //   260: astore_1
    //   261: aload_0
    //   262: astore_3
    //   263: ldc 24
    //   265: ldc 118
    //   267: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: ifnull -257 -> 14
    //   274: aload_0
    //   275: invokevirtual 96	java/io/BufferedReader:close	()V
    //   278: return
    //   279: astore_0
    //   280: return
    //   281: aload_0
    //   282: astore_3
    //   283: aload 7
    //   285: ldc 120
    //   287: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifeq +214 -> 504
    //   293: aload_0
    //   294: astore_3
    //   295: new 8	com/tencent/mm/compatible/f/a$b
    //   298: dup
    //   299: iconst_0
    //   300: invokespecial 123	com/tencent/mm/compatible/f/a$b:<init>	(B)V
    //   303: astore 6
    //   305: aload_0
    //   306: astore_3
    //   307: aload 6
    //   309: new 125	android/util/SparseArray
    //   312: dup
    //   313: invokespecial 126	android/util/SparseArray:<init>	()V
    //   316: putfield 130	com/tencent/mm/compatible/f/a$b:dzl	Landroid/util/SparseArray;
    //   319: aload_0
    //   320: astore_3
    //   321: aload 6
    //   323: aload 5
    //   325: ldc 132
    //   327: invokeinterface 114 2 0
    //   332: checkcast 42	java/lang/String
    //   335: putfield 136	com/tencent/mm/compatible/f/a$b:dzm	Ljava/lang/String;
    //   338: aload_0
    //   339: astore_3
    //   340: aload 6
    //   342: aload 5
    //   344: ldc 138
    //   346: invokeinterface 114 2 0
    //   351: checkcast 42	java/lang/String
    //   354: putfield 141	com/tencent/mm/compatible/f/a$b:model	Ljava/lang/String;
    //   357: aload_0
    //   358: astore_3
    //   359: aload 6
    //   361: aload 5
    //   363: ldc 143
    //   365: invokeinterface 114 2 0
    //   370: checkcast 42	java/lang/String
    //   373: putfield 146	com/tencent/mm/compatible/f/a$b:version	Ljava/lang/String;
    //   376: aload_0
    //   377: astore_3
    //   378: aload 6
    //   380: getfield 130	com/tencent/mm/compatible/f/a$b:dzl	Landroid/util/SparseArray;
    //   383: iconst_1
    //   384: aload 5
    //   386: new 77	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   393: ldc 148
    //   395: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 4
    //   400: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokeinterface 114 2 0
    //   411: invokevirtual 151	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   414: aload_0
    //   415: astore_3
    //   416: aload 6
    //   418: getfield 130	com/tencent/mm/compatible/f/a$b:dzl	Landroid/util/SparseArray;
    //   421: iconst_2
    //   422: aload 5
    //   424: new 77	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   431: ldc 148
    //   433: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc 153
    //   438: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 4
    //   443: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokeinterface 114 2 0
    //   454: invokevirtual 151	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   457: aload_0
    //   458: astore_3
    //   459: aload 6
    //   461: aload 5
    //   463: ldc 155
    //   465: invokeinterface 114 2 0
    //   470: checkcast 42	java/lang/String
    //   473: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   476: putfield 165	com/tencent/mm/compatible/f/a$b:dzk	I
    //   479: aload_0
    //   480: astore_3
    //   481: aload_1
    //   482: aload 6
    //   484: invokeinterface 170 2 0
    //   489: pop
    //   490: goto -440 -> 50
    //   493: astore_0
    //   494: aload_3
    //   495: ifnull +7 -> 502
    //   498: aload_3
    //   499: invokevirtual 96	java/io/BufferedReader:close	()V
    //   502: aload_0
    //   503: athrow
    //   504: aload_0
    //   505: astore_3
    //   506: aload 7
    //   508: ldc 172
    //   510: invokevirtual 46	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   513: ifeq -463 -> 50
    //   516: aload_0
    //   517: astore_3
    //   518: new 6	com/tencent/mm/compatible/f/a$a
    //   521: dup
    //   522: iconst_0
    //   523: invokespecial 173	com/tencent/mm/compatible/f/a$a:<init>	(B)V
    //   526: astore 6
    //   528: aload_0
    //   529: astore_3
    //   530: aload 6
    //   532: new 125	android/util/SparseArray
    //   535: dup
    //   536: invokespecial 126	android/util/SparseArray:<init>	()V
    //   539: putfield 174	com/tencent/mm/compatible/f/a$a:dzl	Landroid/util/SparseArray;
    //   542: aload_0
    //   543: astore_3
    //   544: aload 6
    //   546: aload 5
    //   548: ldc 176
    //   550: invokeinterface 114 2 0
    //   555: checkcast 42	java/lang/String
    //   558: putfield 179	com/tencent/mm/compatible/f/a$a:bwQ	Ljava/lang/String;
    //   561: aload_0
    //   562: astore_3
    //   563: aload 6
    //   565: aload 5
    //   567: ldc 181
    //   569: invokeinterface 114 2 0
    //   574: checkcast 42	java/lang/String
    //   577: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   580: putfield 184	com/tencent/mm/compatible/f/a$a:dzi	I
    //   583: aload_0
    //   584: astore_3
    //   585: aload 6
    //   587: aload 5
    //   589: ldc 186
    //   591: invokeinterface 114 2 0
    //   596: checkcast 42	java/lang/String
    //   599: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   602: putfield 189	com/tencent/mm/compatible/f/a$a:dzj	I
    //   605: aload_0
    //   606: astore_3
    //   607: aload 6
    //   609: getfield 174	com/tencent/mm/compatible/f/a$a:dzl	Landroid/util/SparseArray;
    //   612: iconst_1
    //   613: aload 5
    //   615: new 77	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   622: ldc 148
    //   624: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload 4
    //   629: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokeinterface 114 2 0
    //   640: invokevirtual 151	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   643: aload_0
    //   644: astore_3
    //   645: aload 6
    //   647: getfield 174	com/tencent/mm/compatible/f/a$a:dzl	Landroid/util/SparseArray;
    //   650: iconst_2
    //   651: aload 5
    //   653: new 77	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   660: ldc 148
    //   662: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: ldc 153
    //   667: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload 4
    //   672: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokeinterface 114 2 0
    //   683: invokevirtual 151	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   686: aload_0
    //   687: astore_3
    //   688: aload 6
    //   690: aload 5
    //   692: ldc 155
    //   694: invokeinterface 114 2 0
    //   699: checkcast 42	java/lang/String
    //   702: invokestatic 161	com/tencent/mm/sdk/platformtools/bk:ZR	(Ljava/lang/String;)I
    //   705: putfield 190	com/tencent/mm/compatible/f/a$a:dzk	I
    //   708: aload_0
    //   709: astore_3
    //   710: aload_2
    //   711: aload 6
    //   713: invokeinterface 170 2 0
    //   718: pop
    //   719: goto -669 -> 50
    //   722: aload_0
    //   723: invokevirtual 96	java/io/BufferedReader:close	()V
    //   726: return
    //   727: astore_0
    //   728: return
    //   729: astore_1
    //   730: goto -228 -> 502
    //   733: astore_0
    //   734: aconst_null
    //   735: astore_3
    //   736: goto -242 -> 494
    //   739: astore_1
    //   740: aload_0
    //   741: astore_3
    //   742: aload_1
    //   743: astore_0
    //   744: goto -250 -> 494
    //   747: astore_0
    //   748: aconst_null
    //   749: astore_0
    //   750: goto -489 -> 261
    //   753: astore_0
    //   754: aload_3
    //   755: astore_0
    //   756: goto -630 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	759	0	paramString	String
    //   0	759	1	paramList	java.util.List<a.b>
    //   0	759	2	paramList1	java.util.List<a.a>
    //   18	737	3	str1	String
    //   30	641	4	str2	String
    //   56	635	5	localObject1	Object
    //   70	642	6	localObject2	Object
    //   226	281	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   52	58	125	java/io/FileNotFoundException
    //   65	72	125	java/io/FileNotFoundException
    //   74	82	125	java/io/FileNotFoundException
    //   84	93	125	java/io/FileNotFoundException
    //   100	122	125	java/io/FileNotFoundException
    //   214	228	125	java/io/FileNotFoundException
    //   235	257	125	java/io/FileNotFoundException
    //   283	293	125	java/io/FileNotFoundException
    //   295	305	125	java/io/FileNotFoundException
    //   307	319	125	java/io/FileNotFoundException
    //   321	338	125	java/io/FileNotFoundException
    //   340	357	125	java/io/FileNotFoundException
    //   359	376	125	java/io/FileNotFoundException
    //   378	414	125	java/io/FileNotFoundException
    //   416	457	125	java/io/FileNotFoundException
    //   459	479	125	java/io/FileNotFoundException
    //   481	490	125	java/io/FileNotFoundException
    //   506	516	125	java/io/FileNotFoundException
    //   518	528	125	java/io/FileNotFoundException
    //   530	542	125	java/io/FileNotFoundException
    //   544	561	125	java/io/FileNotFoundException
    //   563	583	125	java/io/FileNotFoundException
    //   585	605	125	java/io/FileNotFoundException
    //   607	643	125	java/io/FileNotFoundException
    //   645	686	125	java/io/FileNotFoundException
    //   688	708	125	java/io/FileNotFoundException
    //   710	719	125	java/io/FileNotFoundException
    //   137	141	142	java/io/IOException
    //   52	58	260	java/io/IOException
    //   65	72	260	java/io/IOException
    //   74	82	260	java/io/IOException
    //   84	93	260	java/io/IOException
    //   100	122	260	java/io/IOException
    //   214	228	260	java/io/IOException
    //   235	257	260	java/io/IOException
    //   283	293	260	java/io/IOException
    //   295	305	260	java/io/IOException
    //   307	319	260	java/io/IOException
    //   321	338	260	java/io/IOException
    //   340	357	260	java/io/IOException
    //   359	376	260	java/io/IOException
    //   378	414	260	java/io/IOException
    //   416	457	260	java/io/IOException
    //   459	479	260	java/io/IOException
    //   481	490	260	java/io/IOException
    //   506	516	260	java/io/IOException
    //   518	528	260	java/io/IOException
    //   530	542	260	java/io/IOException
    //   544	561	260	java/io/IOException
    //   563	583	260	java/io/IOException
    //   585	605	260	java/io/IOException
    //   607	643	260	java/io/IOException
    //   645	686	260	java/io/IOException
    //   688	708	260	java/io/IOException
    //   710	719	260	java/io/IOException
    //   274	278	279	java/io/IOException
    //   52	58	493	finally
    //   65	72	493	finally
    //   74	82	493	finally
    //   84	93	493	finally
    //   100	122	493	finally
    //   214	228	493	finally
    //   235	257	493	finally
    //   263	270	493	finally
    //   283	293	493	finally
    //   295	305	493	finally
    //   307	319	493	finally
    //   321	338	493	finally
    //   340	357	493	finally
    //   359	376	493	finally
    //   378	414	493	finally
    //   416	457	493	finally
    //   459	479	493	finally
    //   481	490	493	finally
    //   506	516	493	finally
    //   518	528	493	finally
    //   530	542	493	finally
    //   544	561	493	finally
    //   563	583	493	finally
    //   585	605	493	finally
    //   607	643	493	finally
    //   645	686	493	finally
    //   688	708	493	finally
    //   710	719	493	finally
    //   722	726	727	java/io/IOException
    //   498	502	729	java/io/IOException
    //   34	50	733	finally
    //   126	133	739	finally
    //   34	50	747	java/io/IOException
    //   34	50	753	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString1, String paramString2, PInt paramPInt, PBool paramPBool)
  {
    if (paramString1 == null)
    {
      paramPBool.value = false;
      return false;
    }
    if (paramString2 == null)
    {
      paramPBool.value = true;
      return false;
    }
    if (paramString1.equals(paramString2))
    {
      paramPInt.value += 1;
      paramPBool.value = true;
      return true;
    }
    paramPBool.value = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.f.a
 * JD-Core Version:    0.7.0.1
 */