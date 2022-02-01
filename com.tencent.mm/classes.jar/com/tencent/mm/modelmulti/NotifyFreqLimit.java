package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class NotifyFreqLimit
  extends BroadcastReceiver
{
  private static long beginTime;
  private static a hMH;
  private static m hMI;
  private static int hMJ;
  private static long[] hMK;
  private static LinkedList<Object> hML;
  private static int hMM;
  private static Boolean hMN;
  private static Boolean hMO;
  private static long hMP;
  private static PendingIntent hMQ;
  private static byte[] lock;
  
  static
  {
    AppMethodBeat.i(20550);
    lock = new byte[0];
    hMH = null;
    hMI = null;
    hMJ = 0;
    hMK = null;
    hML = new LinkedList();
    hMM = 0;
    beginTime = 0L;
    hMN = null;
    hMO = null;
    hMP = 0L;
    hMQ = null;
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
    //   18: ldc 77
    //   20: aload_2
    //   21: invokevirtual 83	android/content/Intent:getAction	()Ljava/lang/String;
    //   24: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifne +43 -> 70
    //   30: aload_2
    //   31: ifnonnull +31 -> 62
    //   34: ldc 91
    //   36: astore_1
    //   37: ldc 93
    //   39: ldc 95
    //   41: iconst_1
    //   42: anewarray 97	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload 13
    //   54: monitorexit
    //   55: sipush 20549
    //   58: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_2
    //   63: invokevirtual 83	android/content/Intent:getAction	()Ljava/lang/String;
    //   66: astore_1
    //   67: goto -30 -> 37
    //   70: aload_2
    //   71: ldc 105
    //   73: lconst_0
    //   74: invokevirtual 109	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   77: lstore 5
    //   79: invokestatic 115	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   82: lload 5
    //   84: lsub
    //   85: lstore 7
    //   87: aload_2
    //   88: ldc 117
    //   90: iconst_0
    //   91: invokevirtual 121	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   94: istore_3
    //   95: aload_2
    //   96: ldc 123
    //   98: lconst_0
    //   99: invokevirtual 109	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   102: ldc2_w 124
    //   105: lmul
    //   106: lstore 9
    //   108: invokestatic 131	android/os/Process:myPid	()I
    //   111: istore 4
    //   113: invokestatic 137	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   116: invokevirtual 140	java/lang/Thread:getId	()J
    //   119: lstore 11
    //   121: ldc 93
    //   123: ldc 142
    //   125: bipush 8
    //   127: anewarray 97	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: lload 5
    //   134: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: iload_3
    //   141: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: dup
    //   146: iconst_2
    //   147: iload 4
    //   149: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_3
    //   155: lload 11
    //   157: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   160: aastore
    //   161: dup
    //   162: iconst_4
    //   163: lload 7
    //   165: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   168: aastore
    //   169: dup
    //   170: iconst_5
    //   171: lload 9
    //   173: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: bipush 6
    //   180: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   183: aastore
    //   184: dup
    //   185: bipush 7
    //   187: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:hMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   190: aastore
    //   191: invokestatic 155	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   197: ifnonnull +100 -> 297
    //   200: getstatic 161	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   203: ldc2_w 162
    //   206: ldc2_w 164
    //   209: lconst_1
    //   210: iconst_0
    //   211: invokevirtual 169	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   214: ldc 93
    //   216: ldc 171
    //   218: bipush 8
    //   220: anewarray 97	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: lload 5
    //   227: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: iload_3
    //   234: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_2
    //   240: iload 4
    //   242: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: dup
    //   247: iconst_3
    //   248: lload 11
    //   250: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   253: aastore
    //   254: dup
    //   255: iconst_4
    //   256: lload 7
    //   258: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   261: aastore
    //   262: dup
    //   263: iconst_5
    //   264: lload 9
    //   266: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: aastore
    //   270: dup
    //   271: bipush 6
    //   273: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   276: aastore
    //   277: dup
    //   278: bipush 7
    //   280: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:hMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   283: aastore
    //   284: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 13
    //   289: monitorexit
    //   290: sipush 20549
    //   293: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: return
    //   297: aconst_null
    //   298: putstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   301: iload 4
    //   303: iload_3
    //   304: if_icmpeq +100 -> 404
    //   307: getstatic 161	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   310: ldc2_w 162
    //   313: ldc2_w 172
    //   316: lconst_1
    //   317: iconst_0
    //   318: invokevirtual 169	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   321: ldc 93
    //   323: ldc 175
    //   325: bipush 8
    //   327: anewarray 97	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: lload 5
    //   334: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: iload_3
    //   341: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: dup
    //   346: iconst_2
    //   347: iload 4
    //   349: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_3
    //   355: lload 11
    //   357: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   360: aastore
    //   361: dup
    //   362: iconst_4
    //   363: lload 7
    //   365: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_5
    //   371: lload 9
    //   373: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   376: aastore
    //   377: dup
    //   378: bipush 6
    //   380: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   383: aastore
    //   384: dup
    //   385: bipush 7
    //   387: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:hMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   390: aastore
    //   391: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: aload 13
    //   396: monitorexit
    //   397: sipush 20549
    //   400: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: return
    //   404: ldc2_w 176
    //   407: lload 9
    //   409: lmul
    //   410: lload 7
    //   412: lcmp
    //   413: iflt +15 -> 428
    //   416: ldc2_w 178
    //   419: lload 9
    //   421: ladd
    //   422: lload 7
    //   424: lcmp
    //   425: ifge +204 -> 629
    //   428: ldc 93
    //   430: ldc 181
    //   432: bipush 8
    //   434: anewarray 97	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: lload 5
    //   441: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   444: aastore
    //   445: dup
    //   446: iconst_1
    //   447: iload_3
    //   448: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: aastore
    //   452: dup
    //   453: iconst_2
    //   454: iload 4
    //   456: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: dup
    //   461: iconst_3
    //   462: lload 11
    //   464: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   467: aastore
    //   468: dup
    //   469: iconst_4
    //   470: lload 7
    //   472: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   475: aastore
    //   476: dup
    //   477: iconst_5
    //   478: lload 9
    //   480: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   483: aastore
    //   484: dup
    //   485: bipush 6
    //   487: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   490: aastore
    //   491: dup
    //   492: bipush 7
    //   494: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:hMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   497: aastore
    //   498: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   501: getstatic 186	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   504: putstatic 62	com/tencent/mm/modelmulti/NotifyFreqLimit:hMO	Ljava/lang/Boolean;
    //   507: invokestatic 192	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   510: ldc 194
    //   512: iconst_0
    //   513: invokevirtual 200	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   516: astore_2
    //   517: aload_2
    //   518: ldc 202
    //   520: ldc 204
    //   522: invokeinterface 210 3 0
    //   527: invokestatic 214	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_1
    //   531: aload_2
    //   532: invokeinterface 218 1 0
    //   537: astore_2
    //   538: aload_2
    //   539: ldc 202
    //   541: new 220	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   548: invokestatic 115	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   551: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   554: ldc 227
    //   556: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload_1
    //   560: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokeinterface 239 3 0
    //   571: pop
    //   572: aload_2
    //   573: invokeinterface 243 1 0
    //   578: pop
    //   579: aload_1
    //   580: invokestatic 247	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   583: ifeq +25 -> 608
    //   586: getstatic 161	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   589: sipush 11098
    //   592: iconst_1
    //   593: anewarray 97	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: sipush 3103
    //   601: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   604: aastore
    //   605: invokevirtual 251	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   608: ldc 93
    //   610: ldc 253
    //   612: iconst_2
    //   613: anewarray 97	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: getstatic 62	com/tencent/mm/modelmulti/NotifyFreqLimit:hMO	Ljava/lang/Boolean;
    //   621: aastore
    //   622: dup
    //   623: iconst_1
    //   624: aload_1
    //   625: aastore
    //   626: invokestatic 155	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   629: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:hMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   632: ifnonnull +91 -> 723
    //   635: getstatic 161	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   638: ldc2_w 162
    //   641: ldc2_w 254
    //   644: lconst_1
    //   645: iconst_0
    //   646: invokevirtual 169	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   649: ldc 93
    //   651: ldc_w 257
    //   654: bipush 8
    //   656: anewarray 97	java/lang/Object
    //   659: dup
    //   660: iconst_0
    //   661: lload 5
    //   663: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   666: aastore
    //   667: dup
    //   668: iconst_1
    //   669: iload_3
    //   670: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   673: aastore
    //   674: dup
    //   675: iconst_2
    //   676: iload 4
    //   678: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   681: aastore
    //   682: dup
    //   683: iconst_3
    //   684: lload 11
    //   686: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   689: aastore
    //   690: dup
    //   691: iconst_4
    //   692: lload 7
    //   694: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   697: aastore
    //   698: dup
    //   699: iconst_5
    //   700: lload 9
    //   702: invokestatic 148	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   705: aastore
    //   706: dup
    //   707: bipush 6
    //   709: getstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   712: aastore
    //   713: dup
    //   714: bipush 7
    //   716: getstatic 41	com/tencent/mm/modelmulti/NotifyFreqLimit:hMH	Lcom/tencent/mm/modelmulti/NotifyFreqLimit$a;
    //   719: aastore
    //   720: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   723: aload 13
    //   725: monitorexit
    //   726: sipush 20549
    //   729: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   732: return
    //   733: astore_1
    //   734: aconst_null
    //   735: putstatic 66	com/tencent/mm/modelmulti/NotifyFreqLimit:hMQ	Landroid/app/PendingIntent;
    //   738: getstatic 161	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   741: ldc2_w 162
    //   744: ldc2_w 258
    //   747: lconst_1
    //   748: iconst_0
    //   749: invokevirtual 169	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   752: ldc 93
    //   754: ldc_w 261
    //   757: iconst_1
    //   758: anewarray 97	java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: aload_1
    //   764: invokestatic 265	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   767: aastore
    //   768: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   771: sipush 20549
    //   774: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   777: return
    //   778: astore_1
    //   779: aload 13
    //   781: monitorexit
    //   782: sipush 20549
    //   785: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   788: aload_1
    //   789: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	790	0	this	NotifyFreqLimit
    //   0	790	1	paramContext	android.content.Context
    //   0	790	2	paramIntent	android.content.Intent
    //   94	576	3	i	int
    //   111	566	4	j	int
    //   77	585	5	l1	long
    //   85	608	7	l2	long
    //   106	595	9	l3	long
    //   119	566	11	l4	long
    //   9	771	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	14	733	java/lang/Throwable
    //   726	732	733	java/lang/Throwable
    //   782	790	733	java/lang/Throwable
    //   18	30	778	finally
    //   37	55	778	finally
    //   62	67	778	finally
    //   70	290	778	finally
    //   297	301	778	finally
    //   307	397	778	finally
    //   428	608	778	finally
    //   608	629	778	finally
    //   629	723	778	finally
    //   723	726	778	finally
    //   779	782	778	finally
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.NotifyFreqLimit
 * JD-Core Version:    0.7.0.1
 */