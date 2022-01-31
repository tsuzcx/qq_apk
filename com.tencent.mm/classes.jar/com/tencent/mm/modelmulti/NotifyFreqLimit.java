package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class NotifyFreqLimit
  extends BroadcastReceiver
{
  private static long beginTime;
  private static byte[] eKs;
  private static NotifyFreqLimit.a fJb;
  private static l fJc;
  private static int fJd;
  private static long[] fJe;
  private static LinkedList<Object> fJf;
  private static int fJg;
  private static Boolean fJh;
  private static Boolean fJi;
  private static long fJj;
  private static PendingIntent fJk;
  
  static
  {
    AppMethodBeat.i(16504);
    eKs = new byte[0];
    fJb = null;
    fJc = null;
    fJd = 0;
    fJe = null;
    fJf = new LinkedList();
    fJg = 0;
    beginTime = 0L;
    fJh = null;
    fJi = null;
    fJj = 0L;
    fJk = null;
    AppMethodBeat.o(16504);
  }
  
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: sipush 16503
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 38	com/tencent/mm/modelmulti/NotifyFreqLimit:eKs	[B
    //   9: astore 13
    //   11: aload 13
    //   13: monitorenter
    //   14: aload_2
    //   15: ifnull +15 -> 30
    //   18: ldc 76
    //   20: aload_2
    //   21: invokevirtual 82	android/content/Intent:getAction	()Ljava/lang/String;
    //   24: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifne +43 -> 70
    //   30: aload_2
    //   31: ifnonnull +31 -> 62
    //   34: ldc 90
    //   36: astore_1
    //   37: ldc 92
    //   39: ldc 94
    //   41: iconst_1
    //   42: anewarray 96	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload 13
    //   54: monitorexit
    //   55: sipush 16503
    //   58: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_2
    //   63: invokevirtual 82	android/content/Intent:getAction	()Ljava/lang/String;
    //   66: astore_1
    //   67: goto -30 -> 37
    //   70: aload_2
    //   71: ldc 104
    //   73: lconst_0
    //   74: invokevirtual 108	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   77: lstore 5
    //   79: invokestatic 114	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   82: lload 5
    //   84: lsub
    //   85: lstore 7
    //   87: aload_2
    //   88: ldc 116
    //   90: iconst_0
    //   91: invokevirtual 120	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   94: istore_3
    //   95: aload_2
    //   96: ldc 122
    //   98: lconst_0
    //   99: invokevirtual 108	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   102: ldc2_w 123
    //   105: lmul
    //   106: lstore 9
    //   108: invokestatic 130	android/os/Process:myPid	()I
    //   111: istore 4
    //   113: invokestatic 136	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   116: invokevirtual 139	java/lang/Thread:getId	()J
    //   119: lstore 11
    //   121: ldc 92
    //   123: ldc 141
    //   125: bipush 8
    //   127: anewarray 96	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: lload 5
    //   134: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: iload_3
    //   141: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: dup
    //   146: iconst_2
    //   147: iload 4
    //   149: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_3
    //   155: lload 11
    //   157: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   160: aastore
    //   161: dup
    //   162: iconst_4
    //   163: lload 7
    //   165: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   168: aastore
    //   169: dup
    //   170: iconst_5
    //   171: lload 9
    //   173: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: bipush 6
    //   180: getstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   183: aastore
    //   184: dup
    //   185: bipush 7
    //   187: getstatic 40	com/tencent/mm/modelmulti/NotifyFreqLimit:fJb	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   190: aastore
    //   191: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: getstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   197: ifnonnull +100 -> 297
    //   200: getstatic 160	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   203: ldc2_w 161
    //   206: ldc2_w 163
    //   209: lconst_1
    //   210: iconst_0
    //   211: invokevirtual 168	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   214: ldc 92
    //   216: ldc 170
    //   218: bipush 8
    //   220: anewarray 96	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: lload 5
    //   227: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: iload_3
    //   234: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: iload 4
    //   242: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: lload 11
    //   250: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   253: aastore
    //   254: dup
    //   255: iconst_4
    //   256: lload 7
    //   258: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   261: aastore
    //   262: dup
    //   263: iconst_5
    //   264: lload 9
    //   266: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: dup
    //   271: bipush 6
    //   273: getstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   276: aastore
    //   277: dup
    //   278: bipush 7
    //   280: getstatic 40	com/tencent/mm/modelmulti/NotifyFreqLimit:fJb	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   283: aastore
    //   284: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 13
    //   289: monitorexit
    //   290: sipush 16503
    //   293: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: return
    //   297: aconst_null
    //   298: putstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   301: iload 4
    //   303: iload_3
    //   304: if_icmpeq +100 -> 404
    //   307: getstatic 160	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   310: ldc2_w 161
    //   313: ldc2_w 171
    //   316: lconst_1
    //   317: iconst_0
    //   318: invokevirtual 168	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   321: ldc 92
    //   323: ldc 174
    //   325: bipush 8
    //   327: anewarray 96	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: lload 5
    //   334: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: iload_3
    //   341: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: dup
    //   346: iconst_2
    //   347: iload 4
    //   349: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_3
    //   355: lload 11
    //   357: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   360: aastore
    //   361: dup
    //   362: iconst_4
    //   363: lload 7
    //   365: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_5
    //   371: lload 9
    //   373: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   376: aastore
    //   377: dup
    //   378: bipush 6
    //   380: getstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   383: aastore
    //   384: dup
    //   385: bipush 7
    //   387: getstatic 40	com/tencent/mm/modelmulti/NotifyFreqLimit:fJb	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   390: aastore
    //   391: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: aload 13
    //   396: monitorexit
    //   397: sipush 16503
    //   400: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: return
    //   404: ldc2_w 175
    //   407: lload 9
    //   409: lmul
    //   410: lload 7
    //   412: lcmp
    //   413: iflt +15 -> 428
    //   416: ldc2_w 177
    //   419: lload 9
    //   421: ladd
    //   422: lload 7
    //   424: lcmp
    //   425: ifge +204 -> 629
    //   428: ldc 92
    //   430: ldc 180
    //   432: bipush 8
    //   434: anewarray 96	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: lload 5
    //   441: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   444: aastore
    //   445: dup
    //   446: iconst_1
    //   447: iload_3
    //   448: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: aastore
    //   452: dup
    //   453: iconst_2
    //   454: iload 4
    //   456: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: dup
    //   461: iconst_3
    //   462: lload 11
    //   464: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   467: aastore
    //   468: dup
    //   469: iconst_4
    //   470: lload 7
    //   472: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   475: aastore
    //   476: dup
    //   477: iconst_5
    //   478: lload 9
    //   480: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   483: aastore
    //   484: dup
    //   485: bipush 6
    //   487: getstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   490: aastore
    //   491: dup
    //   492: bipush 7
    //   494: getstatic 40	com/tencent/mm/modelmulti/NotifyFreqLimit:fJb	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   497: aastore
    //   498: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: getstatic 185	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   504: putstatic 61	com/tencent/mm/modelmulti/NotifyFreqLimit:fJi	Ljava/lang/Boolean;
    //   507: invokestatic 191	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   510: ldc 193
    //   512: iconst_0
    //   513: invokevirtual 199	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   516: astore_2
    //   517: aload_2
    //   518: ldc 201
    //   520: ldc 203
    //   522: invokeinterface 209 3 0
    //   527: invokestatic 213	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_1
    //   531: aload_2
    //   532: invokeinterface 217 1 0
    //   537: astore_2
    //   538: aload_2
    //   539: ldc 201
    //   541: new 219	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   548: invokestatic 114	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   551: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   554: ldc 226
    //   556: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload_1
    //   560: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokeinterface 238 3 0
    //   571: pop
    //   572: aload_2
    //   573: invokeinterface 242 1 0
    //   578: pop
    //   579: aload_1
    //   580: invokestatic 246	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   583: ifeq +25 -> 608
    //   586: getstatic 160	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   589: sipush 11098
    //   592: iconst_1
    //   593: anewarray 96	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: sipush 3103
    //   601: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   604: aastore
    //   605: invokevirtual 249	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   608: ldc 92
    //   610: ldc 251
    //   612: iconst_2
    //   613: anewarray 96	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: getstatic 61	com/tencent/mm/modelmulti/NotifyFreqLimit:fJi	Ljava/lang/Boolean;
    //   621: aastore
    //   622: dup
    //   623: iconst_1
    //   624: aload_1
    //   625: aastore
    //   626: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   629: getstatic 40	com/tencent/mm/modelmulti/NotifyFreqLimit:fJb	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   632: ifnonnull +90 -> 722
    //   635: getstatic 160	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   638: ldc2_w 161
    //   641: ldc2_w 252
    //   644: lconst_1
    //   645: iconst_0
    //   646: invokevirtual 168	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   649: ldc 92
    //   651: ldc 255
    //   653: bipush 8
    //   655: anewarray 96	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: lload 5
    //   662: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   665: aastore
    //   666: dup
    //   667: iconst_1
    //   668: iload_3
    //   669: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   672: aastore
    //   673: dup
    //   674: iconst_2
    //   675: iload 4
    //   677: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: dup
    //   682: iconst_3
    //   683: lload 11
    //   685: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   688: aastore
    //   689: dup
    //   690: iconst_4
    //   691: lload 7
    //   693: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   696: aastore
    //   697: dup
    //   698: iconst_5
    //   699: lload 9
    //   701: invokestatic 147	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   704: aastore
    //   705: dup
    //   706: bipush 6
    //   708: getstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   711: aastore
    //   712: dup
    //   713: bipush 7
    //   715: getstatic 40	com/tencent/mm/modelmulti/NotifyFreqLimit:fJb	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   718: aastore
    //   719: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   722: aload 13
    //   724: monitorexit
    //   725: sipush 16503
    //   728: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   731: return
    //   732: astore_1
    //   733: aconst_null
    //   734: putstatic 65	com/tencent/mm/modelmulti/NotifyFreqLimit:fJk	Landroid/app/PendingIntent;
    //   737: getstatic 160	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   740: ldc2_w 161
    //   743: ldc2_w 256
    //   746: lconst_1
    //   747: iconst_0
    //   748: invokevirtual 168	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   751: ldc 92
    //   753: ldc_w 259
    //   756: iconst_1
    //   757: anewarray 96	java/lang/Object
    //   760: dup
    //   761: iconst_0
    //   762: aload_1
    //   763: invokestatic 263	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   766: aastore
    //   767: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   770: sipush 16503
    //   773: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   776: return
    //   777: astore_1
    //   778: aload 13
    //   780: monitorexit
    //   781: sipush 16503
    //   784: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   6	14	732	java/lang/Throwable
    //   725	731	732	java/lang/Throwable
    //   781	789	732	java/lang/Throwable
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
    //   778	781	777	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.NotifyFreqLimit
 * JD-Core Version:    0.7.0.1
 */