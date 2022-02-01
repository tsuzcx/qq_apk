package com.tencent.mm.compatible.e;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import java.util.Locale;

public final class a
{
  public static Boolean jvj;
  
  /* Error */
  public static void a(String paramString, java.util.List<b> paramList, java.util.List<a> paramList1)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 30	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   9: ifne +16 -> 25
    //   12: ldc 32
    //   14: ldc 34
    //   16: invokestatic 39	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 18
    //   21: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: invokestatic 48	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 50
    //   32: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +116 -> 151
    //   38: ldc 50
    //   40: astore 4
    //   42: new 58	java/io/BufferedReader
    //   45: dup
    //   46: new 60	com/tencent/mm/vfs/x
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 64	com/tencent/mm/vfs/x:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 67	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_0
    //   60: aload_3
    //   61: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +666 -> 734
    //   71: aload_3
    //   72: astore_0
    //   73: aload 5
    //   75: invokevirtual 73	java/lang/String:trim	()Ljava/lang/String;
    //   78: astore 6
    //   80: aload_3
    //   81: astore_0
    //   82: aload 6
    //   84: invokevirtual 77	java/lang/String:length	()I
    //   87: ifeq -29 -> 58
    //   90: aload_3
    //   91: astore_0
    //   92: aload 6
    //   94: ldc 79
    //   96: aconst_null
    //   97: invokestatic 85	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   100: astore 5
    //   102: aload 5
    //   104: ifnonnull +115 -> 219
    //   107: aload_3
    //   108: astore_0
    //   109: ldc 32
    //   111: ldc 87
    //   113: aload 6
    //   115: invokestatic 91	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: goto -66 -> 58
    //   127: astore_0
    //   128: aload_3
    //   129: astore_0
    //   130: ldc 32
    //   132: ldc 100
    //   134: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: ifnull +614 -> 752
    //   141: aload_0
    //   142: invokevirtual 104	java/io/BufferedReader:close	()V
    //   145: ldc 18
    //   147: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: aload_3
    //   152: ldc 106
    //   154: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   157: ifne +12 -> 169
    //   160: aload_3
    //   161: ldc 108
    //   163: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +28 -> 194
    //   169: new 110	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   176: ldc 114
    //   178: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc 106
    //   183: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore 4
    //   191: goto -149 -> 42
    //   194: new 110	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   201: ldc 114
    //   203: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 123
    //   208: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 4
    //   216: goto -174 -> 42
    //   219: aload_3
    //   220: astore_0
    //   221: aload 5
    //   223: ldc 125
    //   225: invokeinterface 131 2 0
    //   230: checkcast 52	java/lang/String
    //   233: astore 7
    //   235: aload 7
    //   237: ifnonnull +47 -> 284
    //   240: aload_3
    //   241: astore_0
    //   242: ldc 32
    //   244: ldc 133
    //   246: aload 6
    //   248: invokestatic 91	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   251: invokevirtual 95	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   254: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: goto -199 -> 58
    //   260: astore_0
    //   261: aload_3
    //   262: astore_0
    //   263: ldc 32
    //   265: ldc 135
    //   267: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_3
    //   271: ifnull +494 -> 765
    //   274: aload_3
    //   275: invokevirtual 104	java/io/BufferedReader:close	()V
    //   278: ldc 18
    //   280: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: return
    //   284: aload_3
    //   285: astore_0
    //   286: aload 7
    //   288: ldc 137
    //   290: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +223 -> 516
    //   296: aload_3
    //   297: astore_0
    //   298: new 9	com/tencent/mm/compatible/e/a$b
    //   301: dup
    //   302: iconst_0
    //   303: invokespecial 140	com/tencent/mm/compatible/e/a$b:<init>	(B)V
    //   306: astore 6
    //   308: aload_3
    //   309: astore_0
    //   310: aload 6
    //   312: new 142	android/util/SparseArray
    //   315: dup
    //   316: invokespecial 143	android/util/SparseArray:<init>	()V
    //   319: putfield 147	com/tencent/mm/compatible/e/a$b:jvn	Landroid/util/SparseArray;
    //   322: aload_3
    //   323: astore_0
    //   324: aload 6
    //   326: aload 5
    //   328: ldc 149
    //   330: invokeinterface 131 2 0
    //   335: checkcast 52	java/lang/String
    //   338: putfield 153	com/tencent/mm/compatible/e/a$b:jvo	Ljava/lang/String;
    //   341: aload_3
    //   342: astore_0
    //   343: aload 6
    //   345: aload 5
    //   347: ldc 155
    //   349: invokeinterface 131 2 0
    //   354: checkcast 52	java/lang/String
    //   357: putfield 158	com/tencent/mm/compatible/e/a$b:model	Ljava/lang/String;
    //   360: aload_3
    //   361: astore_0
    //   362: aload 6
    //   364: aload 5
    //   366: ldc 160
    //   368: invokeinterface 131 2 0
    //   373: checkcast 52	java/lang/String
    //   376: putfield 163	com/tencent/mm/compatible/e/a$b:version	Ljava/lang/String;
    //   379: aload_3
    //   380: astore_0
    //   381: aload 6
    //   383: getfield 147	com/tencent/mm/compatible/e/a$b:jvn	Landroid/util/SparseArray;
    //   386: iconst_1
    //   387: aload 5
    //   389: new 110	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   396: ldc 165
    //   398: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 4
    //   403: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokeinterface 131 2 0
    //   414: invokevirtual 168	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   417: aload_3
    //   418: astore_0
    //   419: aload 6
    //   421: getfield 147	com/tencent/mm/compatible/e/a$b:jvn	Landroid/util/SparseArray;
    //   424: iconst_2
    //   425: aload 5
    //   427: new 110	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   434: ldc 165
    //   436: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc 170
    //   441: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 4
    //   446: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokeinterface 131 2 0
    //   457: invokevirtual 168	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   460: aload_3
    //   461: astore_0
    //   462: aload 6
    //   464: aload 5
    //   466: ldc 172
    //   468: invokeinterface 131 2 0
    //   473: checkcast 52	java/lang/String
    //   476: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   479: putfield 182	com/tencent/mm/compatible/e/a$b:jvm	I
    //   482: aload_3
    //   483: astore_0
    //   484: aload_1
    //   485: aload 6
    //   487: invokeinterface 187 2 0
    //   492: pop
    //   493: goto -435 -> 58
    //   496: astore_2
    //   497: aload_0
    //   498: astore_1
    //   499: aload_2
    //   500: astore_0
    //   501: aload_1
    //   502: ifnull +7 -> 509
    //   505: aload_1
    //   506: invokevirtual 104	java/io/BufferedReader:close	()V
    //   509: ldc 18
    //   511: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   514: aload_0
    //   515: athrow
    //   516: aload_3
    //   517: astore_0
    //   518: aload 7
    //   520: ldc 189
    //   522: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   525: ifeq -467 -> 58
    //   528: aload_3
    //   529: astore_0
    //   530: new 6	com/tencent/mm/compatible/e/a$a
    //   533: dup
    //   534: iconst_0
    //   535: invokespecial 190	com/tencent/mm/compatible/e/a$a:<init>	(B)V
    //   538: astore 6
    //   540: aload_3
    //   541: astore_0
    //   542: aload 6
    //   544: new 142	android/util/SparseArray
    //   547: dup
    //   548: invokespecial 143	android/util/SparseArray:<init>	()V
    //   551: putfield 191	com/tencent/mm/compatible/e/a$a:jvn	Landroid/util/SparseArray;
    //   554: aload_3
    //   555: astore_0
    //   556: aload 6
    //   558: aload 5
    //   560: ldc 193
    //   562: invokeinterface 131 2 0
    //   567: checkcast 52	java/lang/String
    //   570: putfield 196	com/tencent/mm/compatible/e/a$a:pkgName	Ljava/lang/String;
    //   573: aload_3
    //   574: astore_0
    //   575: aload 6
    //   577: aload 5
    //   579: ldc 198
    //   581: invokeinterface 131 2 0
    //   586: checkcast 52	java/lang/String
    //   589: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   592: putfield 201	com/tencent/mm/compatible/e/a$a:jvk	I
    //   595: aload_3
    //   596: astore_0
    //   597: aload 6
    //   599: aload 5
    //   601: ldc 203
    //   603: invokeinterface 131 2 0
    //   608: checkcast 52	java/lang/String
    //   611: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   614: putfield 206	com/tencent/mm/compatible/e/a$a:jvl	I
    //   617: aload_3
    //   618: astore_0
    //   619: aload 6
    //   621: getfield 191	com/tencent/mm/compatible/e/a$a:jvn	Landroid/util/SparseArray;
    //   624: iconst_1
    //   625: aload 5
    //   627: new 110	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   634: ldc 165
    //   636: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: aload 4
    //   641: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokeinterface 131 2 0
    //   652: invokevirtual 168	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   655: aload_3
    //   656: astore_0
    //   657: aload 6
    //   659: getfield 191	com/tencent/mm/compatible/e/a$a:jvn	Landroid/util/SparseArray;
    //   662: iconst_2
    //   663: aload 5
    //   665: new 110	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   672: ldc 165
    //   674: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: ldc 170
    //   679: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 4
    //   684: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokeinterface 131 2 0
    //   695: invokevirtual 168	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   698: aload_3
    //   699: astore_0
    //   700: aload 6
    //   702: aload 5
    //   704: ldc 172
    //   706: invokeinterface 131 2 0
    //   711: checkcast 52	java/lang/String
    //   714: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:safeParseInt	(Ljava/lang/String;)I
    //   717: putfield 207	com/tencent/mm/compatible/e/a$a:jvm	I
    //   720: aload_3
    //   721: astore_0
    //   722: aload_2
    //   723: aload 6
    //   725: invokeinterface 187 2 0
    //   730: pop
    //   731: goto -673 -> 58
    //   734: aload_3
    //   735: invokevirtual 104	java/io/BufferedReader:close	()V
    //   738: ldc 18
    //   740: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   743: return
    //   744: astore_0
    //   745: ldc 18
    //   747: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: return
    //   751: astore_0
    //   752: ldc 18
    //   754: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   757: return
    //   758: astore_0
    //   759: ldc 18
    //   761: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   764: return
    //   765: ldc 18
    //   767: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: return
    //   771: astore_1
    //   772: goto -263 -> 509
    //   775: astore_0
    //   776: aconst_null
    //   777: astore_1
    //   778: goto -277 -> 501
    //   781: astore_2
    //   782: aload_0
    //   783: astore_1
    //   784: aload_2
    //   785: astore_0
    //   786: goto -285 -> 501
    //   789: astore_0
    //   790: aconst_null
    //   791: astore_3
    //   792: goto -531 -> 261
    //   795: astore_0
    //   796: aconst_null
    //   797: astore_0
    //   798: goto -668 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	801	0	paramString	String
    //   0	801	1	paramList	java.util.List<b>
    //   0	801	2	paramList1	java.util.List<a>
    //   28	764	3	localObject1	Object
    //   40	643	4	str1	String
    //   64	639	5	localObject2	Object
    //   78	646	6	localObject3	Object
    //   233	286	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   60	66	127	java/io/FileNotFoundException
    //   73	80	127	java/io/FileNotFoundException
    //   82	90	127	java/io/FileNotFoundException
    //   92	102	127	java/io/FileNotFoundException
    //   109	124	127	java/io/FileNotFoundException
    //   221	235	127	java/io/FileNotFoundException
    //   242	257	127	java/io/FileNotFoundException
    //   286	296	127	java/io/FileNotFoundException
    //   298	308	127	java/io/FileNotFoundException
    //   310	322	127	java/io/FileNotFoundException
    //   324	341	127	java/io/FileNotFoundException
    //   343	360	127	java/io/FileNotFoundException
    //   362	379	127	java/io/FileNotFoundException
    //   381	417	127	java/io/FileNotFoundException
    //   419	460	127	java/io/FileNotFoundException
    //   462	482	127	java/io/FileNotFoundException
    //   484	493	127	java/io/FileNotFoundException
    //   518	528	127	java/io/FileNotFoundException
    //   530	540	127	java/io/FileNotFoundException
    //   542	554	127	java/io/FileNotFoundException
    //   556	573	127	java/io/FileNotFoundException
    //   575	595	127	java/io/FileNotFoundException
    //   597	617	127	java/io/FileNotFoundException
    //   619	655	127	java/io/FileNotFoundException
    //   657	698	127	java/io/FileNotFoundException
    //   700	720	127	java/io/FileNotFoundException
    //   722	731	127	java/io/FileNotFoundException
    //   60	66	260	java/io/IOException
    //   73	80	260	java/io/IOException
    //   82	90	260	java/io/IOException
    //   92	102	260	java/io/IOException
    //   109	124	260	java/io/IOException
    //   221	235	260	java/io/IOException
    //   242	257	260	java/io/IOException
    //   286	296	260	java/io/IOException
    //   298	308	260	java/io/IOException
    //   310	322	260	java/io/IOException
    //   324	341	260	java/io/IOException
    //   343	360	260	java/io/IOException
    //   362	379	260	java/io/IOException
    //   381	417	260	java/io/IOException
    //   419	460	260	java/io/IOException
    //   462	482	260	java/io/IOException
    //   484	493	260	java/io/IOException
    //   518	528	260	java/io/IOException
    //   530	540	260	java/io/IOException
    //   542	554	260	java/io/IOException
    //   556	573	260	java/io/IOException
    //   575	595	260	java/io/IOException
    //   597	617	260	java/io/IOException
    //   619	655	260	java/io/IOException
    //   657	698	260	java/io/IOException
    //   700	720	260	java/io/IOException
    //   722	731	260	java/io/IOException
    //   60	66	496	finally
    //   73	80	496	finally
    //   82	90	496	finally
    //   92	102	496	finally
    //   109	124	496	finally
    //   221	235	496	finally
    //   242	257	496	finally
    //   263	270	496	finally
    //   286	296	496	finally
    //   298	308	496	finally
    //   310	322	496	finally
    //   324	341	496	finally
    //   343	360	496	finally
    //   362	379	496	finally
    //   381	417	496	finally
    //   419	460	496	finally
    //   462	482	496	finally
    //   484	493	496	finally
    //   518	528	496	finally
    //   530	540	496	finally
    //   542	554	496	finally
    //   556	573	496	finally
    //   575	595	496	finally
    //   597	617	496	finally
    //   619	655	496	finally
    //   657	698	496	finally
    //   700	720	496	finally
    //   722	731	496	finally
    //   734	738	744	java/io/IOException
    //   141	145	751	java/io/IOException
    //   274	278	758	java/io/IOException
    //   505	509	771	java/io/IOException
    //   42	58	775	finally
    //   130	137	781	finally
    //   42	58	789	java/io/IOException
    //   42	58	795	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString1, String paramString2, PInt paramPInt, PBool paramPBool)
  {
    AppMethodBeat.i(155846);
    if (paramString1 == null)
    {
      paramPBool.value = false;
      AppMethodBeat.o(155846);
      return false;
    }
    if (paramString2 == null)
    {
      paramPBool.value = true;
      AppMethodBeat.o(155846);
      return false;
    }
    if (paramString1.equals(paramString2))
    {
      paramPInt.value += 1;
      paramPBool.value = true;
      AppMethodBeat.o(155846);
      return true;
    }
    paramPBool.value = false;
    AppMethodBeat.o(155846);
    return false;
  }
  
  static final class a
  {
    int jvk;
    int jvl;
    int jvm;
    SparseArray<String> jvn;
    String pkgName;
    
    public final String toString()
    {
      AppMethodBeat.i(155844);
      String str = String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[] { this.pkgName, Integer.valueOf(this.jvk), Integer.valueOf(this.jvl), this.jvn, Integer.valueOf(this.jvm) });
      AppMethodBeat.o(155844);
      return str;
    }
  }
  
  public static final class b
  {
    public int jvm;
    SparseArray<String> jvn;
    public String jvo;
    public String model;
    public String version;
    
    public final String toString()
    {
      AppMethodBeat.i(155845);
      String str = String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[] { this.jvo, this.model, this.version, this.jvn, Integer.valueOf(this.jvm) });
      AppMethodBeat.o(155845);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.e.a
 * JD-Core Version:    0.7.0.1
 */