package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class NotifyFreqLimit
  extends BroadcastReceiver
{
  private static long beginTime;
  private static byte[] lock;
  private static a oMH;
  private static r oMI;
  private static int oMJ;
  private static long[] oMK;
  private static LinkedList<Object> oML;
  private static int oMM;
  private static Boolean oMN;
  private static Boolean oMO;
  private static long oMP;
  private static PendingIntent oMQ;
  
  static
  {
    AppMethodBeat.i(20550);
    lock = new byte[0];
    oMH = null;
    oMI = null;
    oMJ = 0;
    oMK = null;
    oML = new LinkedList();
    oMM = 0;
    beginTime = 0L;
    oMN = null;
    oMO = null;
    oMP = 0L;
    oMQ = null;
    AppMethodBeat.o(20550);
  }
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: sipush 20549
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 39	com/tencent/mm/modelmulti/NotifyFreqLimit:lock	[B
    //   9: astore 13
    //   11: aload 13
    //   13: monitorenter
    //   14: aload_2
    //   15: ifnull +15 -> 30
    //   18: ldc 75
    //   20: aload_2
    //   21: invokevirtual 81	android/content/Intent:getAction	()Ljava/lang/String;
    //   24: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifne +43 -> 70
    //   30: aload_2
    //   31: ifnonnull +31 -> 62
    //   34: ldc 89
    //   36: astore_1
    //   37: ldc 91
    //   39: ldc 93
    //   41: iconst_1
    //   42: anewarray 95	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload 13
    //   54: monitorexit
    //   55: sipush 20549
    //   58: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_2
    //   63: invokevirtual 81	android/content/Intent:getAction	()Ljava/lang/String;
    //   66: astore_1
    //   67: goto -30 -> 37
    //   70: aload_2
    //   71: ldc 103
    //   73: lconst_0
    //   74: invokevirtual 107	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   77: lstore 5
    //   79: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   82: lload 5
    //   84: lsub
    //   85: lstore 7
    //   87: aload_2
    //   88: ldc 115
    //   90: iconst_0
    //   91: invokevirtual 119	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   94: istore_3
    //   95: aload_2
    //   96: ldc 121
    //   98: lconst_0
    //   99: invokevirtual 107	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   102: ldc2_w 122
    //   105: lmul
    //   106: lstore 9
    //   108: invokestatic 129	android/os/Process:myPid	()I
    //   111: istore 4
    //   113: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   116: invokevirtual 138	java/lang/Thread:getId	()J
    //   119: lstore 11
    //   121: ldc 91
    //   123: ldc 140
    //   125: bipush 8
    //   127: anewarray 95	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: lload 5
    //   134: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: iload_3
    //   141: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: dup
    //   146: iconst_2
    //   147: iload 4
    //   149: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_3
    //   155: lload 11
    //   157: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   160: aastore
    //   161: dup
    //   162: iconst_4
    //   163: lload 7
    //   165: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   168: aastore
    //   169: dup
    //   170: iconst_5
    //   171: lload 9
    //   173: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: bipush 6
    //   180: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   183: aastore
    //   184: dup
    //   185: bipush 7
    //   187: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:oMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   190: aastore
    //   191: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   197: ifnonnull +100 -> 297
    //   200: getstatic 159	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   203: ldc2_w 160
    //   206: ldc2_w 162
    //   209: lconst_1
    //   210: iconst_0
    //   211: invokevirtual 167	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   214: ldc 91
    //   216: ldc 169
    //   218: bipush 8
    //   220: anewarray 95	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: lload 5
    //   227: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: iload_3
    //   234: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: iload 4
    //   242: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: lload 11
    //   250: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   253: aastore
    //   254: dup
    //   255: iconst_4
    //   256: lload 7
    //   258: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   261: aastore
    //   262: dup
    //   263: iconst_5
    //   264: lload 9
    //   266: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: dup
    //   271: bipush 6
    //   273: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   276: aastore
    //   277: dup
    //   278: bipush 7
    //   280: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:oMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   283: aastore
    //   284: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 13
    //   289: monitorexit
    //   290: sipush 20549
    //   293: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: return
    //   297: aconst_null
    //   298: putstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   301: iload 4
    //   303: iload_3
    //   304: if_icmpeq +100 -> 404
    //   307: getstatic 159	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   310: ldc2_w 160
    //   313: ldc2_w 170
    //   316: lconst_1
    //   317: iconst_0
    //   318: invokevirtual 167	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   321: ldc 91
    //   323: ldc 173
    //   325: bipush 8
    //   327: anewarray 95	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: lload 5
    //   334: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: iload_3
    //   341: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: dup
    //   346: iconst_2
    //   347: iload 4
    //   349: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_3
    //   355: lload 11
    //   357: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   360: aastore
    //   361: dup
    //   362: iconst_4
    //   363: lload 7
    //   365: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_5
    //   371: lload 9
    //   373: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   376: aastore
    //   377: dup
    //   378: bipush 6
    //   380: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   383: aastore
    //   384: dup
    //   385: bipush 7
    //   387: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:oMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   390: aastore
    //   391: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: aload 13
    //   396: monitorexit
    //   397: sipush 20549
    //   400: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: return
    //   404: ldc2_w 174
    //   407: lload 9
    //   409: lmul
    //   410: lload 7
    //   412: lcmp
    //   413: iflt +15 -> 428
    //   416: ldc2_w 176
    //   419: lload 9
    //   421: ladd
    //   422: lload 7
    //   424: lcmp
    //   425: ifge +204 -> 629
    //   428: ldc 91
    //   430: ldc 179
    //   432: bipush 8
    //   434: anewarray 95	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: lload 5
    //   441: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   444: aastore
    //   445: dup
    //   446: iconst_1
    //   447: iload_3
    //   448: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: aastore
    //   452: dup
    //   453: iconst_2
    //   454: iload 4
    //   456: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: dup
    //   461: iconst_3
    //   462: lload 11
    //   464: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   467: aastore
    //   468: dup
    //   469: iconst_4
    //   470: lload 7
    //   472: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   475: aastore
    //   476: dup
    //   477: iconst_5
    //   478: lload 9
    //   480: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   483: aastore
    //   484: dup
    //   485: bipush 6
    //   487: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   490: aastore
    //   491: dup
    //   492: bipush 7
    //   494: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:oMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   497: aastore
    //   498: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: getstatic 184	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   504: putstatic 62	com/tencent/mm/modelmulti/NotifyFreqLimit:oMO	Ljava/lang/Boolean;
    //   507: invokestatic 190	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   510: ldc 192
    //   512: iconst_0
    //   513: invokevirtual 198	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   516: astore_2
    //   517: aload_2
    //   518: ldc 200
    //   520: ldc 202
    //   522: invokeinterface 208 3 0
    //   527: invokestatic 212	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_1
    //   531: aload_2
    //   532: invokeinterface 216 1 0
    //   537: astore_2
    //   538: aload_2
    //   539: ldc 200
    //   541: new 218	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   548: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   551: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   554: ldc 225
    //   556: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload_1
    //   560: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokeinterface 237 3 0
    //   571: pop
    //   572: aload_2
    //   573: invokeinterface 241 1 0
    //   578: pop
    //   579: aload_1
    //   580: invokestatic 245	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   583: ifeq +25 -> 608
    //   586: getstatic 159	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   589: sipush 11098
    //   592: iconst_1
    //   593: anewarray 95	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: sipush 3103
    //   601: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   604: aastore
    //   605: invokevirtual 249	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   608: ldc 91
    //   610: ldc 251
    //   612: iconst_2
    //   613: anewarray 95	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: getstatic 62	com/tencent/mm/modelmulti/NotifyFreqLimit:oMO	Ljava/lang/Boolean;
    //   621: aastore
    //   622: dup
    //   623: iconst_1
    //   624: aload_1
    //   625: aastore
    //   626: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   629: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:oMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   632: ifnonnull +90 -> 722
    //   635: getstatic 159	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   638: ldc2_w 160
    //   641: ldc2_w 252
    //   644: lconst_1
    //   645: iconst_0
    //   646: invokevirtual 167	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   649: ldc 91
    //   651: ldc 255
    //   653: bipush 8
    //   655: anewarray 95	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: lload 5
    //   662: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   665: aastore
    //   666: dup
    //   667: iconst_1
    //   668: iload_3
    //   669: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   672: aastore
    //   673: dup
    //   674: iconst_2
    //   675: iload 4
    //   677: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: dup
    //   682: iconst_3
    //   683: lload 11
    //   685: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   688: aastore
    //   689: dup
    //   690: iconst_4
    //   691: lload 7
    //   693: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   696: aastore
    //   697: dup
    //   698: iconst_5
    //   699: lload 9
    //   701: invokestatic 146	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   704: aastore
    //   705: dup
    //   706: bipush 6
    //   708: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   711: aastore
    //   712: dup
    //   713: bipush 7
    //   715: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:oMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   718: aastore
    //   719: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   722: aload 13
    //   724: monitorexit
    //   725: sipush 20549
    //   728: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   731: return
    //   732: astore_1
    //   733: aconst_null
    //   734: putstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:oMQ	Landroid/app/PendingIntent;
    //   737: getstatic 159	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   740: ldc2_w 160
    //   743: ldc2_w 256
    //   746: lconst_1
    //   747: iconst_0
    //   748: invokevirtual 167	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   751: ldc 91
    //   753: ldc_w 259
    //   756: iconst_1
    //   757: anewarray 95	java/lang/Object
    //   760: dup
    //   761: iconst_0
    //   762: aload_1
    //   763: invokestatic 263	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   766: aastore
    //   767: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   770: sipush 20549
    //   773: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   776: return
    //   777: astore_1
    //   778: aload 13
    //   780: monitorexit
    //   781: sipush 20549
    //   784: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   787: aload_1
    //   788: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	this	NotifyFreqLimit
    //   0	789	1	paramContext	android.content.Context
    //   0	789	2	paramIntent	android.content.Intent
    //   94	575	3	i	int
    //   111	565	4	j	int
    //   77	584	5	l1	long
    //   85	607	7	l2	long
    //   106	594	9	l3	long
    //   119	565	11	l4	long
    //   9	770	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	14	732	finally
    //   725	731	732	finally
    //   778	789	732	finally
    //   18	30	777	finally
    //   37	55	777	finally
    //   62	67	777	finally
    //   70	290	777	finally
    //   297	301	777	finally
    //   307	397	777	finally
    //   428	608	777	finally
    //   608	629	777	finally
    //   629	722	777	finally
    //   722	725	777	finally
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.NotifyFreqLimit
 * JD-Core Version:    0.7.0.1
 */