package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ac
{
  final a[] imM;
  
  public ac()
  {
    AppMethodBeat.i(132894);
    this.imM = new a[100];
    AppMethodBeat.o(132894);
  }
  
  static boolean qb(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 268369922);
  }
  
  /* Error */
  final int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   9: astore 12
    //   11: aload 12
    //   13: monitorenter
    //   14: aload_0
    //   15: iload_1
    //   16: invokevirtual 41	com/tencent/mm/network/ac:qd	(I)I
    //   19: istore 8
    //   21: iconst_m1
    //   22: iload 8
    //   24: if_icmpne +13 -> 37
    //   27: aload 12
    //   29: monitorexit
    //   30: ldc 37
    //   32: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_m1
    //   36: ireturn
    //   37: getstatic 47	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_DEFAULT	I
    //   40: istore 6
    //   42: iload 6
    //   44: istore_1
    //   45: iload 6
    //   47: istore 5
    //   49: aload_0
    //   50: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   53: iload 8
    //   55: aaload
    //   56: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   59: invokeinterface 57 1 0
    //   64: invokeinterface 63 1 0
    //   69: astore 13
    //   71: iload 6
    //   73: istore_1
    //   74: iload 6
    //   76: istore 5
    //   78: aload_0
    //   79: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   82: iload 8
    //   84: aaload
    //   85: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   88: invokeinterface 57 1 0
    //   93: invokeinterface 67 1 0
    //   98: lstore 9
    //   100: iload 6
    //   102: istore_1
    //   103: iload 6
    //   105: istore 5
    //   107: aload_0
    //   108: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   111: iload 8
    //   113: aaload
    //   114: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   117: invokeinterface 71 1 0
    //   122: astore 14
    //   124: iload 6
    //   126: istore_1
    //   127: iload 6
    //   129: istore 5
    //   131: aload 14
    //   133: aload_0
    //   134: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   137: iload 8
    //   139: aaload
    //   140: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   143: invokeinterface 75 1 0
    //   148: aload_2
    //   149: aload 13
    //   151: lload 9
    //   153: invokeinterface 80 6 0
    //   158: istore 11
    //   160: iload 6
    //   162: istore_1
    //   163: iload 6
    //   165: istore 5
    //   167: aload_0
    //   168: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   171: iload 8
    //   173: aaload
    //   174: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   177: invokeinterface 57 1 0
    //   182: invokeinterface 84 1 0
    //   187: ifeq +458 -> 645
    //   190: iload 6
    //   192: istore_1
    //   193: iload 6
    //   195: istore 5
    //   197: ldc 86
    //   199: ldc 88
    //   201: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: iload 11
    //   206: ifeq +663 -> 869
    //   209: iload 6
    //   211: istore_1
    //   212: iload 6
    //   214: istore 5
    //   216: aload 14
    //   218: invokeinterface 97 1 0
    //   223: istore 7
    //   225: aload 4
    //   227: iconst_0
    //   228: iconst_0
    //   229: iastore
    //   230: iload 6
    //   232: istore_1
    //   233: iload 6
    //   235: istore 5
    //   237: aload 14
    //   239: invokeinterface 100 1 0
    //   244: istore 6
    //   246: iload 7
    //   248: iconst_2
    //   249: iand
    //   250: ifne +32 -> 282
    //   253: aload 4
    //   255: iconst_0
    //   256: aload 4
    //   258: iconst_0
    //   259: iaload
    //   260: iconst_2
    //   261: ior
    //   262: iastore
    //   263: iload 6
    //   265: istore_1
    //   266: iload 6
    //   268: istore 5
    //   270: getstatic 106	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   273: ldc2_w 107
    //   276: lconst_0
    //   277: lconst_1
    //   278: iconst_0
    //   279: invokevirtual 112	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   282: iload 7
    //   284: iconst_4
    //   285: iand
    //   286: ifne +32 -> 318
    //   289: aload 4
    //   291: iconst_0
    //   292: aload 4
    //   294: iconst_0
    //   295: iaload
    //   296: iconst_4
    //   297: ior
    //   298: iastore
    //   299: iload 6
    //   301: istore_1
    //   302: iload 6
    //   304: istore 5
    //   306: getstatic 106	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   309: ldc2_w 107
    //   312: lconst_1
    //   313: lconst_1
    //   314: iconst_0
    //   315: invokevirtual 112	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   318: iload 6
    //   320: istore_1
    //   321: iload 6
    //   323: istore 5
    //   325: aload 14
    //   327: invokeinterface 115 1 0
    //   332: ifnull +114 -> 446
    //   335: iload 6
    //   337: istore_1
    //   338: iload 6
    //   340: istore 5
    //   342: bipush 243
    //   344: aload 14
    //   346: invokeinterface 100 1 0
    //   351: if_icmpne +95 -> 446
    //   354: iload 6
    //   356: istore_1
    //   357: iload 6
    //   359: istore 5
    //   361: aload_0
    //   362: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   365: iload 8
    //   367: aaload
    //   368: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   371: invokeinterface 57 1 0
    //   376: invokeinterface 84 1 0
    //   381: ifeq +38 -> 419
    //   384: iload 6
    //   386: istore_1
    //   387: iload 6
    //   389: istore 5
    //   391: ldc 86
    //   393: ldc 117
    //   395: invokestatic 120	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: iload 6
    //   400: istore_1
    //   401: iload 6
    //   403: istore 5
    //   405: getstatic 106	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   408: ldc2_w 121
    //   411: ldc2_w 123
    //   414: lconst_1
    //   415: iconst_0
    //   416: invokevirtual 112	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   419: iload 6
    //   421: istore_1
    //   422: iload 6
    //   424: istore 5
    //   426: invokestatic 130	com/tencent/mm/network/ad:aMf	()Lcom/tencent/mm/network/t;
    //   429: ifnull +17 -> 446
    //   432: iload 6
    //   434: istore_1
    //   435: iload 6
    //   437: istore 5
    //   439: invokestatic 130	com/tencent/mm/network/ad:aMf	()Lcom/tencent/mm/network/t;
    //   442: invokevirtual 135	com/tencent/mm/network/t:aLD	()Z
    //   445: pop
    //   446: iload 6
    //   448: istore_1
    //   449: iload 6
    //   451: istore 5
    //   453: bipush 243
    //   455: aload 14
    //   457: invokeinterface 100 1 0
    //   462: if_icmpne +239 -> 701
    //   465: iload 6
    //   467: istore_1
    //   468: iload 6
    //   470: istore 5
    //   472: getstatic 138	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   475: istore 6
    //   477: iload 6
    //   479: istore_1
    //   480: iload 6
    //   482: istore 5
    //   484: aload_3
    //   485: iconst_0
    //   486: aload 14
    //   488: invokeinterface 100 1 0
    //   493: iastore
    //   494: iload 6
    //   496: istore_1
    //   497: iload_1
    //   498: istore 6
    //   500: iload_1
    //   501: istore 7
    //   503: aload_0
    //   504: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   507: iload 8
    //   509: aaload
    //   510: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   513: invokeinterface 142 1 0
    //   518: astore_2
    //   519: iload_1
    //   520: istore 5
    //   522: iload_1
    //   523: istore 6
    //   525: iload_1
    //   526: istore 7
    //   528: getstatic 146	com/tencent/mm/network/t:ilp	Ljava/lang/String;
    //   531: invokevirtual 151	java/lang/String:isEmpty	()Z
    //   534: ifne +100 -> 634
    //   537: iload_1
    //   538: istore 5
    //   540: iload_1
    //   541: istore 6
    //   543: iload_1
    //   544: istore 7
    //   546: aload_2
    //   547: getstatic 146	com/tencent/mm/network/t:ilp	Ljava/lang/String;
    //   550: invokevirtual 155	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   553: ifeq +81 -> 634
    //   556: iload_1
    //   557: istore 6
    //   559: iload_1
    //   560: istore 7
    //   562: ldc 86
    //   564: ldc 157
    //   566: iconst_1
    //   567: anewarray 4	java/lang/Object
    //   570: dup
    //   571: iconst_0
    //   572: aload_2
    //   573: aastore
    //   574: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   577: iload_1
    //   578: istore 6
    //   580: iload_1
    //   581: istore 7
    //   583: ldc 162
    //   585: putstatic 146	com/tencent/mm/network/t:ilp	Ljava/lang/String;
    //   588: iload_1
    //   589: istore 6
    //   591: iload_1
    //   592: istore 7
    //   594: getstatic 138	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   597: istore_1
    //   598: aload_3
    //   599: iconst_0
    //   600: bipush 243
    //   602: iastore
    //   603: iload_1
    //   604: istore 5
    //   606: iload_1
    //   607: istore 6
    //   609: iload_1
    //   610: istore 7
    //   612: invokestatic 130	com/tencent/mm/network/ad:aMf	()Lcom/tencent/mm/network/t;
    //   615: ifnull +19 -> 634
    //   618: iload_1
    //   619: istore 6
    //   621: iload_1
    //   622: istore 7
    //   624: invokestatic 130	com/tencent/mm/network/ad:aMf	()Lcom/tencent/mm/network/t;
    //   627: invokevirtual 135	com/tencent/mm/network/t:aLD	()Z
    //   630: pop
    //   631: iload_1
    //   632: istore 5
    //   634: aload 12
    //   636: monitorexit
    //   637: ldc 37
    //   639: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   642: iload 5
    //   644: ireturn
    //   645: iload 6
    //   647: istore_1
    //   648: iload 6
    //   650: istore 5
    //   652: ldc 86
    //   654: ldc 164
    //   656: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: goto -455 -> 204
    //   662: astore_2
    //   663: getstatic 106	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   666: ldc2_w 121
    //   669: ldc2_w 165
    //   672: lconst_1
    //   673: iconst_0
    //   674: invokevirtual 112	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   677: ldc 86
    //   679: ldc 168
    //   681: iconst_1
    //   682: anewarray 4	java/lang/Object
    //   685: dup
    //   686: iconst_0
    //   687: aload_2
    //   688: invokestatic 174	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   691: aastore
    //   692: invokestatic 177	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   695: iload_1
    //   696: istore 5
    //   698: goto -64 -> 634
    //   701: iload 6
    //   703: istore_1
    //   704: iload 6
    //   706: istore 5
    //   708: sipush -3002
    //   711: aload 14
    //   713: invokeinterface 100 1 0
    //   718: if_icmpeq +43 -> 761
    //   721: iload 6
    //   723: istore_1
    //   724: iload 6
    //   726: istore 5
    //   728: sipush -3003
    //   731: aload 14
    //   733: invokeinterface 100 1 0
    //   738: if_icmpeq +23 -> 761
    //   741: iload 6
    //   743: istore_1
    //   744: iload 6
    //   746: istore 5
    //   748: sipush -3006
    //   751: aload 14
    //   753: invokeinterface 100 1 0
    //   758: if_icmpne +38 -> 796
    //   761: iload 6
    //   763: istore_1
    //   764: iload 6
    //   766: istore 5
    //   768: getstatic 180	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_TASK_END	I
    //   771: istore 6
    //   773: iload 6
    //   775: istore_1
    //   776: iload 6
    //   778: istore 5
    //   780: aload_3
    //   781: iconst_0
    //   782: aload 14
    //   784: invokeinterface 100 1 0
    //   789: iastore
    //   790: iload 6
    //   792: istore_1
    //   793: goto -296 -> 497
    //   796: iload 6
    //   798: istore_1
    //   799: iload 6
    //   801: istore 5
    //   803: sipush -3001
    //   806: aload 14
    //   808: invokeinterface 100 1 0
    //   813: if_icmpne +38 -> 851
    //   816: iload 6
    //   818: istore_1
    //   819: iload 6
    //   821: istore 5
    //   823: getstatic 138	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_SESSION_TIMEOUT	I
    //   826: istore 6
    //   828: iload 6
    //   830: istore_1
    //   831: iload 6
    //   833: istore 5
    //   835: aload_3
    //   836: iconst_0
    //   837: aload 14
    //   839: invokeinterface 100 1 0
    //   844: iastore
    //   845: iload 6
    //   847: istore_1
    //   848: goto -351 -> 497
    //   851: iload 6
    //   853: istore_1
    //   854: iload 6
    //   856: istore 5
    //   858: getstatic 183	com/tencent/mars/stn/StnLogic:RESP_FAIL_HANDLE_NORMAL	I
    //   861: istore 6
    //   863: iload 6
    //   865: istore_1
    //   866: goto -369 -> 497
    //   869: iload 6
    //   871: istore_1
    //   872: iload 6
    //   874: istore 5
    //   876: getstatic 106	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   879: ldc2_w 121
    //   882: ldc2_w 184
    //   885: lconst_1
    //   886: iconst_0
    //   887: invokevirtual 112	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   890: iload 6
    //   892: istore_1
    //   893: iload 6
    //   895: istore 5
    //   897: ldc 86
    //   899: ldc 187
    //   901: invokestatic 189	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   904: iload 6
    //   906: istore 5
    //   908: goto -274 -> 634
    //   911: astore_2
    //   912: iload 5
    //   914: istore_1
    //   915: getstatic 106	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
    //   918: ldc2_w 121
    //   921: ldc2_w 190
    //   924: lconst_1
    //   925: iconst_0
    //   926: invokevirtual 112	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   929: ldc 86
    //   931: ldc 168
    //   933: iconst_1
    //   934: anewarray 4	java/lang/Object
    //   937: dup
    //   938: iconst_0
    //   939: aload_2
    //   940: invokestatic 174	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   943: aastore
    //   944: invokestatic 177	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: iload_1
    //   948: istore 5
    //   950: goto -316 -> 634
    //   953: astore_2
    //   954: aload 12
    //   956: monitorexit
    //   957: ldc 37
    //   959: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   962: aload_2
    //   963: athrow
    //   964: astore_2
    //   965: goto -50 -> 915
    //   968: astore_2
    //   969: iload 6
    //   971: istore_1
    //   972: goto -57 -> 915
    //   975: astore_2
    //   976: iload 5
    //   978: istore_1
    //   979: goto -316 -> 663
    //   982: astore_2
    //   983: iload 7
    //   985: istore_1
    //   986: goto -323 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	989	0	this	ac
    //   0	989	1	paramInt	int
    //   0	989	2	paramArrayOfByte	byte[]
    //   0	989	3	paramArrayOfInt1	int[]
    //   0	989	4	paramArrayOfInt2	int[]
    //   47	930	5	i	int
    //   40	930	6	j	int
    //   223	761	7	k	int
    //   19	489	8	m	int
    //   98	54	9	l	long
    //   158	47	11	bool	boolean
    //   9	946	12	arrayOfa	a[]
    //   69	81	13	arrayOfByte	byte[]
    //   122	716	14	locali	i
    // Exception table:
    //   from	to	target	type
    //   49	71	662	android/os/RemoteException
    //   78	100	662	android/os/RemoteException
    //   107	124	662	android/os/RemoteException
    //   131	160	662	android/os/RemoteException
    //   167	190	662	android/os/RemoteException
    //   197	204	662	android/os/RemoteException
    //   216	225	662	android/os/RemoteException
    //   237	246	662	android/os/RemoteException
    //   270	282	662	android/os/RemoteException
    //   306	318	662	android/os/RemoteException
    //   325	335	662	android/os/RemoteException
    //   342	354	662	android/os/RemoteException
    //   361	384	662	android/os/RemoteException
    //   391	398	662	android/os/RemoteException
    //   405	419	662	android/os/RemoteException
    //   426	432	662	android/os/RemoteException
    //   439	446	662	android/os/RemoteException
    //   453	465	662	android/os/RemoteException
    //   472	477	662	android/os/RemoteException
    //   652	659	662	android/os/RemoteException
    //   708	721	662	android/os/RemoteException
    //   728	741	662	android/os/RemoteException
    //   748	761	662	android/os/RemoteException
    //   768	773	662	android/os/RemoteException
    //   803	816	662	android/os/RemoteException
    //   823	828	662	android/os/RemoteException
    //   858	863	662	android/os/RemoteException
    //   876	890	662	android/os/RemoteException
    //   897	904	662	android/os/RemoteException
    //   49	71	911	java/lang/Exception
    //   78	100	911	java/lang/Exception
    //   107	124	911	java/lang/Exception
    //   131	160	911	java/lang/Exception
    //   167	190	911	java/lang/Exception
    //   197	204	911	java/lang/Exception
    //   216	225	911	java/lang/Exception
    //   237	246	911	java/lang/Exception
    //   270	282	911	java/lang/Exception
    //   306	318	911	java/lang/Exception
    //   325	335	911	java/lang/Exception
    //   342	354	911	java/lang/Exception
    //   361	384	911	java/lang/Exception
    //   391	398	911	java/lang/Exception
    //   405	419	911	java/lang/Exception
    //   426	432	911	java/lang/Exception
    //   439	446	911	java/lang/Exception
    //   453	465	911	java/lang/Exception
    //   472	477	911	java/lang/Exception
    //   652	659	911	java/lang/Exception
    //   708	721	911	java/lang/Exception
    //   728	741	911	java/lang/Exception
    //   748	761	911	java/lang/Exception
    //   768	773	911	java/lang/Exception
    //   803	816	911	java/lang/Exception
    //   823	828	911	java/lang/Exception
    //   858	863	911	java/lang/Exception
    //   876	890	911	java/lang/Exception
    //   897	904	911	java/lang/Exception
    //   14	21	953	finally
    //   27	30	953	finally
    //   37	42	953	finally
    //   49	71	953	finally
    //   78	100	953	finally
    //   107	124	953	finally
    //   131	160	953	finally
    //   167	190	953	finally
    //   197	204	953	finally
    //   216	225	953	finally
    //   237	246	953	finally
    //   270	282	953	finally
    //   306	318	953	finally
    //   325	335	953	finally
    //   342	354	953	finally
    //   361	384	953	finally
    //   391	398	953	finally
    //   405	419	953	finally
    //   426	432	953	finally
    //   439	446	953	finally
    //   453	465	953	finally
    //   472	477	953	finally
    //   484	494	953	finally
    //   503	519	953	finally
    //   528	537	953	finally
    //   546	556	953	finally
    //   562	577	953	finally
    //   583	588	953	finally
    //   594	598	953	finally
    //   612	618	953	finally
    //   624	631	953	finally
    //   634	637	953	finally
    //   652	659	953	finally
    //   663	695	953	finally
    //   708	721	953	finally
    //   728	741	953	finally
    //   748	761	953	finally
    //   768	773	953	finally
    //   780	790	953	finally
    //   803	816	953	finally
    //   823	828	953	finally
    //   835	845	953	finally
    //   858	863	953	finally
    //   876	890	953	finally
    //   897	904	953	finally
    //   915	947	953	finally
    //   954	957	953	finally
    //   484	494	964	java/lang/Exception
    //   780	790	964	java/lang/Exception
    //   835	845	964	java/lang/Exception
    //   503	519	968	java/lang/Exception
    //   528	537	968	java/lang/Exception
    //   546	556	968	java/lang/Exception
    //   562	577	968	java/lang/Exception
    //   583	588	968	java/lang/Exception
    //   594	598	968	java/lang/Exception
    //   612	618	968	java/lang/Exception
    //   624	631	968	java/lang/Exception
    //   484	494	975	android/os/RemoteException
    //   780	790	975	android/os/RemoteException
    //   835	845	975	android/os/RemoteException
    //   503	519	982	android/os/RemoteException
    //   528	537	982	android/os/RemoteException
    //   546	556	982	android/os/RemoteException
    //   562	577	982	android/os/RemoteException
    //   583	588	982	android/os/RemoteException
    //   594	598	982	android/os/RemoteException
    //   612	618	982	android/os/RemoteException
    //   624	631	982	android/os/RemoteException
  }
  
  public final int a(r paramr, l paraml, c paramc, int paramInt)
  {
    AppMethodBeat.i(132901);
    if (paramr == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
      AppMethodBeat.o(132901);
      return -1;
    }
    paramr.hashCode();
    StnLogic.Task localTask = new StnLogic.Task();
    a[] arrayOfa = this.imM;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      for (;;)
      {
        int j;
        try
        {
          if (this.imM[i] != null) {
            break;
          }
          this.imM[i] = new a(0);
          this.imM[i].imQ = paramr;
          this.imM[i].imR = paraml;
          this.imM[i].imS = paramc;
          this.imM[i].startTime = bs.eWj();
          this.imM[i].taskId = localTask.taskID;
          localTask.cmdID = paramr.aCf().getCmdId();
          localTask.cgi = paramr.getUri();
          j = paramr.getType();
          boolean bool;
          if ((paramr.getOptions() & 0x1) != 1)
          {
            bool = true;
            localTask.needAuthed = bool;
            if ((j == 126) || (j == 252) || (j == 701) || (j == 702) || (j == 763) || (j == 3941))
            {
              localTask.needAuthed = false;
              if ((j == 701) || (j == 252)) {
                localTask.retryCount = 1;
              }
            }
            if (j == 2962) {
              localTask.retryCount = 2;
            }
            localTask.limitFlow = true;
            if ((j != 149) && (j != 193) && (j != 110) && (j != 220) && (j != 323) && (j != 324) && (j != 326) && (j != 327) && (j != 703) && (j != 2580) && (j != 3767)) {
              break label843;
            }
            localTask.limitFlow = false;
            break label843;
            localTask.limitFrequency = false;
            localTask.channelStrategy = 0;
            if ((j == 233) || (j == 835) || (j == 238)) {
              localTask.channelStrategy = 1;
            }
            localTask.sendOnly = false;
            if (qb(j)) {
              localTask.sendOnly = true;
            }
            if ((paramr.aCf().getShortSupport()) && (paramr.getUri() != null) && (paramr.getUri().length() > 0)) {
              localTask.channelSelect |= 0x1;
            }
            if (localTask.cmdID != 0) {
              localTask.channelSelect |= 0x2;
            }
            localTask.reportArg = String.valueOf(j);
            if (j == 522)
            {
              localTask.totalTimeout = 300000;
              localTask.priority = 0;
            }
            if (j == 710)
            {
              localTask.totalTimeout = 15000;
              localTask.serverProcessCost = 0;
            }
            if (j == 2632)
            {
              j = paramr.getTimeOut();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
            }
            if (paramr.getIsLongPolling())
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "this is long-polling cgi");
              localTask.longPolling = true;
              localTask.longPollingTimeout = paramr.getLongPollingTimeout();
              j = paramr.getTimeOut();
              if (j != 0) {
                localTask.totalTimeout = j;
              }
              localTask.retryCount = 0;
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(localTask.taskID), Integer.valueOf(paramr.getMMReqRespHash()), Integer.valueOf(localTask.channelSelect), localTask.cgi, Boolean.valueOf(localTask.needAuthed) });
            if (-1 != i)
            {
              if (paramInt == 1) {
                localTask.retryCount = 0;
              }
              StnLogic.startTask(localTask);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=".concat(String.valueOf(i)));
              AppMethodBeat.o(132901);
              return i;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        catch (RemoteException localRemoteException)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bs.m(localRemoteException) });
        }
        finally
        {
          AppMethodBeat.o(132901);
        }
        continue;
        i = -1;
        continue;
        label843:
        if (j != 703) {
          if (j != 3767) {}
        }
      }
      i += 1;
    }
  }
  
  final boolean a(int paramInt1, ByteArrayOutputStream paramByteArrayOutputStream, int[] paramArrayOfInt, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132905);
    for (;;)
    {
      int i;
      synchronized (this.imM)
      {
        i = qd(paramInt1);
        if (-1 == i)
        {
          AppMethodBeat.o(132905);
          return false;
        }
        try
        {
          bool = this.imM[i].imS.Ar(paramString);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s, type: %d host[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(this.imM[i].imS.isForeground()), bs.cx(this.imM[i].imS.aBS()), Integer.valueOf(this.imM[i].imQ.getType()), paramString });
          paramInt1 = 1;
          if (!this.imM[i].imQ.isSingleSession())
          {
            paramInt1 = 2;
            this.imM[i].imQ.aCf().setPassKey(this.imM[i].imS.mp(3));
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "summerauths isSingleSession false type:[%s]", new Object[] { Integer.valueOf(this.imM[i].imQ.getType()) });
          }
          if (!bool) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "set axauth sessionkey ".concat(String.valueOf(paramString)));
          this.imM[i].imQ.aCf().setPassKey(this.imM[i].imS.Aq(paramString));
          localObject1 = this.imM[i].imS.Ap(paramString);
          localObject2 = this.imM[i].imS.Ao(paramString);
          this.imM[i].imQ.aCf().setUseAxsession(true);
          if (localObject1 == null) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "axauth sessionkey length[%d]", new Object[] { Integer.valueOf(localObject1.length) });
          if (localObject2 == null) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie length[%d]", new Object[] { Integer.valueOf(localObject2.length) });
        }
        catch (RemoteException paramByteArrayOutputStream)
        {
          Object localObject2;
          paramArrayOfInt[0] = 1;
          e.wTc.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[] { bs.m(paramByteArrayOutputStream) });
          bool = false;
          continue;
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie is null");
          continue;
        }
        catch (IOException paramByteArrayOutputStream)
        {
          paramArrayOfInt[0] = 2;
          e.wTc.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[] { bs.m(paramByteArrayOutputStream) });
          bool = false;
          continue;
          paramString = this.imM[i].imS.mp(paramInt1);
          Object localObject1 = this.imM[i].imS.aBS();
          continue;
          paramArrayOfInt[0] = 0;
          e.wTc.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
          continue;
        }
        catch (Exception paramByteArrayOutputStream)
        {
          paramArrayOfInt[0] = 3;
          e.wTc.idkeyStat(162L, paramArrayOfInt[0], 1L, false);
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[] { bs.m(paramByteArrayOutputStream) });
          boolean bool = false;
          continue;
        }
        e.wTc.idkeyStat(148L, 123L, 1L, false);
        paramString = (String)localObject1;
        localObject1 = localObject2;
        paramInt1 = 2;
        this.imM[i].imQ.aCf().setSessionKey(paramString);
        if (paramInt1 == 1)
        {
          paramInt2 = this.imM[i].imQ.getType();
          if ((paramInt2 == 1000) || (paramInt2 == 502) || (paramInt2 == 930) || (paramInt2 == 503) || (paramInt2 == 654) || (paramInt2 == 755) || (paramInt2 == 931) || (paramInt2 == 733) || (paramInt2 == 784) || (paramInt2 == 722)) {
            break label1013;
          }
          if (paramInt2 != 627) {
            break label1019;
          }
          break label1013;
          if (paramInt2 == 0) {
            this.imM[i].imQ.aCf().setPassKey(null);
          }
        }
        this.imM[i].imQ.aCf().setUin(this.imM[i].imS.getUin());
        localObject2 = this.imM[i].imQ.aCf();
        paramInt2 = this.imM[i].imQ.getType();
        if (paramInt1 != 2) {
          break label1025;
        }
        paramInt1 = 13;
        bool = ((h)localObject2).a(paramInt2, paramString, paramInt1, (byte[])localObject1, this.imM[i].imS.aBU(), 0, this.imM[i].imS.isForeground());
        if (bool)
        {
          paramByteArrayOutputStream.write(this.imM[i].imQ.aCf().aCd());
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[] { Boolean.valueOf(bool) });
          AppMethodBeat.o(132905);
          return bool;
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MMNativeNetTaskAdapter", "axauth axsessionkey is null");
        }
      }
      label1013:
      paramInt2 = 1;
      continue;
      label1019:
      paramInt2 = 0;
      continue;
      label1025:
      paramInt1 = 0;
    }
  }
  
  final boolean aLS()
  {
    AppMethodBeat.i(132896);
    a[] arrayOfa = this.imM;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if (this.imM[i] != null)
        {
          boolean bool = this.imM[i].imQ.aCf().isAxAuth();
          if (bool) {
            return true;
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.imM[i] = null;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bs.m(localRemoteException), Integer.valueOf(i) });
        break label126;
        return false;
      }
      finally
      {
        AppMethodBeat.o(132896);
      }
      label126:
      i += 1;
    }
  }
  
  final boolean aLT()
  {
    AppMethodBeat.i(132897);
    a[] arrayOfa = this.imM;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.imM[i] != null) && ((252 == this.imM[i].imQ.getType()) || (701 == this.imM[i].imQ.getType()) || (702 == this.imM[i].imQ.getType()) || (763 == this.imM[i].imQ.getType()) || (3941 == this.imM[i].imQ.getType())))
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.imM[i].imQ.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.imM[i] = null;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bs.m(localRemoteException), Integer.valueOf(i) });
        break label243;
        return false;
      }
      finally
      {
        AppMethodBeat.o(132897);
      }
      label243:
      i += 1;
    }
  }
  
  final boolean aLU()
  {
    AppMethodBeat.i(132898);
    a[] arrayOfa = this.imM;
    int i = 0;
    for (;;)
    {
      if (i < 100) {}
      try
      {
        if ((this.imM[i] != null) && (1000 == this.imM[i].imQ.getType()))
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.imM[i].imQ.getType());
          return true;
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.imM[i] = null;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bs.m(localRemoteException), Integer.valueOf(i) });
        break label163;
        return false;
      }
      finally
      {
        AppMethodBeat.o(132898);
      }
      label163:
      i += 1;
    }
  }
  
  public final int aLV()
  {
    AppMethodBeat.i(132900);
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i >= 100) {
        break label96;
      }
      k = j;
      try
      {
        if (this.imM[i] != null)
        {
          this.imM[i].imQ.getType();
          k = j;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[] { bs.m(localRemoteException), Integer.valueOf(i) });
          k = j + 1;
          this.imM[i] = null;
        }
      }
      i += 1;
    }
    label96:
    AppMethodBeat.o(132900);
    return j;
  }
  
  final r ff(boolean paramBoolean)
  {
    AppMethodBeat.i(132899);
    a[] arrayOfa = this.imM;
    int i = 0;
    Object localObject4;
    label315:
    Object localObject2;
    for (Object localObject1 = null;; localObject2 = localObject4)
    {
      if (i < 100)
      {
        try
        {
          a locala = this.imM[i];
          Object localObject3 = localObject1;
          if (locala == null) {
            break label315;
          }
          if (paramBoolean) {
            localObject3 = localObject1;
          }
          try
          {
            if ((this.imM[i].imQ instanceof r.a)) {
              break label315;
            }
            if ((!paramBoolean) && (!(this.imM[i].imQ instanceof r.a)))
            {
              localObject3 = localObject1;
              break label315;
            }
            if ((252 == this.imM[i].imQ.getType()) || (701 == this.imM[i].imQ.getType()) || (763 == this.imM[i].imQ.getType()) || (702 == this.imM[i].imQ.getType()) || (3941 == this.imM[i].imQ.getType()))
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.imM[i].imQ.getType());
              return null;
            }
          }
          catch (RemoteException localRemoteException)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bs.m(localRemoteException) });
            localObject4 = localObject1;
          }
          localObject4 = localr;
        }
        finally
        {
          AppMethodBeat.o(132899);
        }
        if (localr == null) {
          localObject4 = this.imM[i].imQ;
        }
      }
      else
      {
        AppMethodBeat.o(132899);
        return localr;
      }
      i += 1;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(132895);
    reset();
    super.finalize();
    AppMethodBeat.o(132895);
  }
  
  /* Error */
  public final void m(int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: ldc_w 481
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 86
    //   8: new 440	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 483
    //   15: invokespecial 445	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_1
    //   19: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc_w 485
    //   25: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 449	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 487
    //   35: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 457	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 294	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: invokestatic 490	com/tencent/mars/stn/StnLogic:clearTask	()V
    //   51: invokestatic 491	com/tencent/mars/stn/StnLogic:reset	()V
    //   54: bipush 100
    //   56: anewarray 8	com/tencent/mm/network/ac$a
    //   59: astore 5
    //   61: aload_0
    //   62: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   65: astore 6
    //   67: aload 6
    //   69: monitorenter
    //   70: iconst_0
    //   71: istore 4
    //   73: iload 4
    //   75: bipush 100
    //   77: if_icmpge +32 -> 109
    //   80: aload 5
    //   82: iload 4
    //   84: aload_0
    //   85: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   88: iload 4
    //   90: aaload
    //   91: aastore
    //   92: aload_0
    //   93: getfield 24	com/tencent/mm/network/ac:imM	[Lcom/tencent/mm/network/ac$a;
    //   96: iload 4
    //   98: aconst_null
    //   99: aastore
    //   100: iload 4
    //   102: iconst_1
    //   103: iadd
    //   104: istore 4
    //   106: goto -33 -> 73
    //   109: aload 6
    //   111: monitorexit
    //   112: iconst_0
    //   113: istore 4
    //   115: iload 4
    //   117: bipush 100
    //   119: if_icmpge +141 -> 260
    //   122: aload 5
    //   124: iload 4
    //   126: aaload
    //   127: ifnull +88 -> 215
    //   130: ldc 86
    //   132: ldc_w 493
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: iload 4
    //   143: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload 5
    //   151: iload 4
    //   153: aaload
    //   154: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   157: invokeinterface 75 1 0
    //   162: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: dup
    //   167: iconst_2
    //   168: aload 5
    //   170: iload 4
    //   172: aaload
    //   173: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   176: invokeinterface 313 1 0
    //   181: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 5
    //   190: iload 4
    //   192: aaload
    //   193: getfield 208	com/tencent/mm/network/ac$a:imR	Lcom/tencent/mm/network/l;
    //   196: iload 4
    //   198: iload_1
    //   199: iload_2
    //   200: aload_3
    //   201: aload 5
    //   203: iload 4
    //   205: aaload
    //   206: getfield 51	com/tencent/mm/network/ac$a:imQ	Lcom/tencent/mm/network/r;
    //   209: aconst_null
    //   210: invokeinterface 498 7 0
    //   215: iload 4
    //   217: iconst_1
    //   218: iadd
    //   219: istore 4
    //   221: goto -106 -> 115
    //   224: astore_3
    //   225: aload 6
    //   227: monitorexit
    //   228: ldc_w 481
    //   231: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_3
    //   235: athrow
    //   236: astore 6
    //   238: ldc 86
    //   240: ldc 168
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload 6
    //   250: invokestatic 174	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   253: aastore
    //   254: invokestatic 177	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: goto -42 -> 215
    //   260: ldc_w 481
    //   263: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	ac
    //   0	267	1	paramInt1	int
    //   0	267	2	paramInt2	int
    //   0	267	3	paramString	String
    //   71	149	4	i	int
    //   59	143	5	arrayOfa1	a[]
    //   65	161	6	arrayOfa2	a[]
    //   236	13	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   80	100	224	finally
    //   109	112	224	finally
    //   225	228	224	finally
    //   130	215	236	java/lang/Exception
  }
  
  final int qc(int paramInt)
  {
    AppMethodBeat.i(132904);
    synchronized (this.imM)
    {
      paramInt = qd(paramInt);
      if (-1 == paramInt)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
        AppMethodBeat.o(132904);
        return 0;
      }
      try
      {
        paramInt = this.imM[paramInt].imQ.aCg().getRetCode();
        AppMethodBeat.o(132904);
        return paramInt;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bs.m(localException) });
        AppMethodBeat.o(132904);
        return 0;
      }
    }
  }
  
  final int qd(int paramInt)
  {
    int i = 0;
    while ((i < 100) && ((this.imM[i] == null) || (paramInt != this.imM[i].taskId))) {
      i += 1;
    }
    paramInt = i;
    if (100 <= i) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132902);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
    StnLogic.reset();
    a[] arrayOfa = this.imM;
    int i = 0;
    while (i < 100) {
      try
      {
        a locala = this.imM[i];
        if (locala != null) {}
        try
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.imM[i].imQ.getType()), Integer.valueOf(this.imM[i].imQ.getMMReqRespHash()) });
          this.imM[i] = null;
          i += 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[] { bs.m(localRemoteException) });
          }
        }
      }
      finally
      {
        AppMethodBeat.o(132902);
      }
    }
    AppMethodBeat.o(132902);
  }
  
  static final class a
  {
    r imQ;
    l imR;
    c imS;
    long startTime;
    int taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ac
 * JD-Core Version:    0.7.0.1
 */