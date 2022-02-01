package com.tencent.mm.audio.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i.e;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public final class c
  implements a
{
  private static a.a hyy;
  public BlockingQueue<g.a> hym;
  public boolean hyn;
  private String hyo;
  private int hyp;
  private byte[] hyq;
  private int hyr;
  private Object hys;
  public a hyt;
  private boolean hyu;
  private int hyv;
  private boolean hyw;
  private i hyx;
  private volatile OutputStream mFileOutputStream;
  private int mSampleRate;
  
  static
  {
    AppMethodBeat.i(130022);
    hyy = new a.a();
    AppMethodBeat.o(130022);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130015);
    this.hym = new ArrayBlockingQueue(1024);
    this.hyn = false;
    this.hyp = 0;
    this.hyq = null;
    this.mSampleRate = 16000;
    this.hyr = 16000;
    this.hys = new Object();
    this.hyt = null;
    this.hyu = false;
    this.hyw = false;
    this.mSampleRate = paramInt1;
    this.hyr = paramInt2;
    AppMethodBeat.o(130015);
  }
  
  private void aIB()
  {
    AppMethodBeat.i(130018);
    synchronized (this.hys)
    {
      if (this.hyx != null) {
        MediaRecorder.SilkEncUnInit(this.hyx.pdE);
      }
      Log.i("MicroMsg.SilkWriter", "finish Thread file:" + this.hyo);
      if (this.mFileOutputStream == null) {}
    }
    try
    {
      this.mFileOutputStream.close();
      this.mFileOutputStream = null;
      AppMethodBeat.o(130018);
      return;
      localObject2 = finally;
      AppMethodBeat.o(130018);
      throw localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SilkWriter", "close silk file:" + this.hyo + "msg:" + localException.getMessage());
      }
    }
  }
  
  public final int a(g.a parama)
  {
    AppMethodBeat.i(130020);
    int i = a(parama, 0, false);
    AppMethodBeat.o(130020);
    return i;
  }
  
  /* Error */
  public final int a(g.a parama, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 158	com/tencent/mm/compatible/util/f$a
    //   8: dup
    //   9: invokespecial 159	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   12: astore 15
    //   14: aload_0
    //   15: getfield 72	com/tencent/mm/audio/e/c:mSampleRate	I
    //   18: bipush 20
    //   20: imul
    //   21: iconst_2
    //   22: imul
    //   23: sipush 1000
    //   26: idiv
    //   27: i2s
    //   28: istore 4
    //   30: aload_0
    //   31: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   34: aload_1
    //   35: getfield 164	com/tencent/mm/audio/b/g$a:hxg	I
    //   38: iadd
    //   39: istore 7
    //   41: iload 4
    //   43: newarray byte
    //   45: astore 16
    //   47: aload_0
    //   48: getfield 82	com/tencent/mm/audio/e/c:hyw	Z
    //   51: ifeq +526 -> 577
    //   54: bipush 6
    //   56: istore 5
    //   58: iload 5
    //   60: iload 4
    //   62: imul
    //   63: newarray byte
    //   65: astore 17
    //   67: iconst_1
    //   68: istore 12
    //   70: iload 12
    //   72: istore 11
    //   74: invokestatic 170	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   77: ifeq +48 -> 125
    //   80: ldc 172
    //   82: invokestatic 178	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   85: checkcast 172	com/tencent/mm/plugin/zero/b/a
    //   88: invokeinterface 182 1 0
    //   93: ldc 184
    //   95: invokevirtual 190	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 18
    //   100: iload 12
    //   102: istore 11
    //   104: aload 18
    //   106: invokestatic 196	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   109: ifne +16 -> 125
    //   112: aload 18
    //   114: iconst_1
    //   115: invokestatic 200	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   118: iconst_1
    //   119: if_icmpne +464 -> 583
    //   122: iconst_1
    //   123: istore 11
    //   125: iload_3
    //   126: ifeq +6 -> 132
    //   129: iconst_0
    //   130: istore 11
    //   132: ldc 103
    //   134: ldc 202
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: iload 11
    //   144: invokestatic 208	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   147: aastore
    //   148: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: iconst_0
    //   152: istore 5
    //   154: iconst_0
    //   155: istore 6
    //   157: iload 7
    //   159: iload 4
    //   161: if_icmplt +767 -> 928
    //   164: aload_0
    //   165: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   168: ifle +471 -> 639
    //   171: aload_0
    //   172: getfield 70	com/tencent/mm/audio/e/c:hyq	[B
    //   175: iconst_0
    //   176: aload 16
    //   178: iconst_0
    //   179: aload_0
    //   180: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   183: invokestatic 218	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   186: aload_1
    //   187: getfield 221	com/tencent/mm/audio/b/g$a:buf	[B
    //   190: astore 18
    //   192: aload_0
    //   193: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   196: istore 8
    //   198: aload 18
    //   200: iconst_0
    //   201: aload 16
    //   203: iload 8
    //   205: iload 4
    //   207: iload 8
    //   209: isub
    //   210: invokestatic 218	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   213: iload 4
    //   215: aload_0
    //   216: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   219: isub
    //   220: iload 6
    //   222: iadd
    //   223: istore 6
    //   225: aload_0
    //   226: iconst_0
    //   227: putfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   230: iload 7
    //   232: iload 4
    //   234: isub
    //   235: istore 7
    //   237: iconst_1
    //   238: newarray short
    //   240: astore 18
    //   242: aload_0
    //   243: getfield 76	com/tencent/mm/audio/e/c:hys	Ljava/lang/Object;
    //   246: astore 19
    //   248: aload 19
    //   250: monitorenter
    //   251: aload_0
    //   252: getfield 82	com/tencent/mm/audio/e/c:hyw	Z
    //   255: ifeq +43 -> 298
    //   258: iload 7
    //   260: iload 4
    //   262: if_icmpge +444 -> 706
    //   265: aload_1
    //   266: getfield 224	com/tencent/mm/audio/b/g$a:hxh	Z
    //   269: ifeq +437 -> 706
    //   272: aload_0
    //   273: getfield 89	com/tencent/mm/audio/e/c:hyx	Lcom/tencent/mm/modelvoice/i;
    //   276: ifnull +15 -> 291
    //   279: aload_0
    //   280: getfield 89	com/tencent/mm/audio/e/c:hyx	Lcom/tencent/mm/modelvoice/i;
    //   283: sipush 201
    //   286: iconst_1
    //   287: invokevirtual 228	com/tencent/mm/modelvoice/i:eR	(II)I
    //   290: pop
    //   291: ldc 103
    //   293: ldc 230
    //   295: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_0
    //   299: getfield 89	com/tencent/mm/audio/e/c:hyx	Lcom/tencent/mm/modelvoice/i;
    //   302: ifnull +875 -> 1177
    //   305: aload 16
    //   307: iload 4
    //   309: aload 17
    //   311: aload 18
    //   313: iload 11
    //   315: aload_0
    //   316: getfield 89	com/tencent/mm/audio/e/c:hyx	Lcom/tencent/mm/modelvoice/i;
    //   319: getfield 95	com/tencent/mm/modelvoice/i:pdE	J
    //   322: invokestatic 234	com/tencent/mm/modelvoice/MediaRecorder:SilkDoEnc	([BS[B[SZJ)I
    //   325: istore 8
    //   327: aload 19
    //   329: monitorexit
    //   330: iconst_0
    //   331: istore 10
    //   333: iload 10
    //   335: istore 9
    //   337: iload_3
    //   338: ifeq +159 -> 497
    //   341: iload 10
    //   343: istore 9
    //   345: aload 18
    //   347: iconst_0
    //   348: saload
    //   349: bipush 10
    //   351: if_icmplt +146 -> 497
    //   354: iload 10
    //   356: istore 9
    //   358: aload 17
    //   360: iconst_0
    //   361: baload
    //   362: iconst_2
    //   363: if_icmpne +134 -> 497
    //   366: iload 10
    //   368: istore 9
    //   370: aload 17
    //   372: iconst_1
    //   373: baload
    //   374: bipush 35
    //   376: if_icmpne +121 -> 497
    //   379: iload 10
    //   381: istore 9
    //   383: aload 17
    //   385: iconst_2
    //   386: baload
    //   387: bipush 33
    //   389: if_icmpne +108 -> 497
    //   392: iload 10
    //   394: istore 9
    //   396: aload 17
    //   398: iconst_3
    //   399: baload
    //   400: bipush 83
    //   402: if_icmpne +95 -> 497
    //   405: iload 10
    //   407: istore 9
    //   409: aload 17
    //   411: iconst_4
    //   412: baload
    //   413: bipush 73
    //   415: if_icmpne +82 -> 497
    //   418: iload 10
    //   420: istore 9
    //   422: aload 17
    //   424: iconst_5
    //   425: baload
    //   426: bipush 76
    //   428: if_icmpne +69 -> 497
    //   431: iload 10
    //   433: istore 9
    //   435: aload 17
    //   437: bipush 6
    //   439: baload
    //   440: bipush 75
    //   442: if_icmpne +55 -> 497
    //   445: iload 10
    //   447: istore 9
    //   449: aload 17
    //   451: bipush 7
    //   453: baload
    //   454: bipush 95
    //   456: if_icmpne +41 -> 497
    //   459: iload 10
    //   461: istore 9
    //   463: aload 17
    //   465: bipush 8
    //   467: baload
    //   468: bipush 86
    //   470: if_icmpne +27 -> 497
    //   473: iload 10
    //   475: istore 9
    //   477: aload 17
    //   479: bipush 9
    //   481: baload
    //   482: bipush 51
    //   484: if_icmpne +13 -> 497
    //   487: ldc 103
    //   489: ldc 236
    //   491: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: iconst_1
    //   495: istore 9
    //   497: iload 8
    //   499: ifeq +240 -> 739
    //   502: aload_0
    //   503: iconst_0
    //   504: putfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   507: ldc 103
    //   509: ldc 238
    //   511: iconst_1
    //   512: anewarray 4	java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: iload 8
    //   519: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: aastore
    //   523: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: aload_0
    //   527: getfield 80	com/tencent/mm/audio/e/c:hyu	Z
    //   530: ifne +40 -> 570
    //   533: getstatic 251	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   536: ldc2_w 252
    //   539: ldc2_w 254
    //   542: lconst_1
    //   543: invokevirtual 259	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   546: aload_0
    //   547: iconst_1
    //   548: putfield 80	com/tencent/mm/audio/e/c:hyu	Z
    //   551: getstatic 264	com/tencent/mm/protocal/d:Yxk	Z
    //   554: ifeq +16 -> 570
    //   557: getstatic 251	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   560: ldc_w 266
    //   563: ldc_w 268
    //   566: aconst_null
    //   567: invokevirtual 271	com/tencent/mm/plugin/report/service/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   570: ldc 156
    //   572: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   575: iconst_m1
    //   576: ireturn
    //   577: iconst_1
    //   578: istore 5
    //   580: goto -522 -> 58
    //   583: iconst_0
    //   584: istore 11
    //   586: goto -461 -> 125
    //   589: astore_1
    //   590: ldc 103
    //   592: ldc_w 273
    //   595: iconst_3
    //   596: anewarray 4	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload_0
    //   602: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   605: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   608: aastore
    //   609: dup
    //   610: iconst_1
    //   611: iload 4
    //   613: aload_0
    //   614: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   617: isub
    //   618: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   621: aastore
    //   622: dup
    //   623: iconst_2
    //   624: aload_1
    //   625: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   628: aastore
    //   629: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   632: ldc 156
    //   634: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   637: iconst_m1
    //   638: ireturn
    //   639: aload_1
    //   640: getfield 221	com/tencent/mm/audio/b/g$a:buf	[B
    //   643: iload 6
    //   645: aload 16
    //   647: iconst_0
    //   648: iload 4
    //   650: invokestatic 218	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   653: iload 6
    //   655: iload 4
    //   657: iadd
    //   658: istore 6
    //   660: goto -430 -> 230
    //   663: astore_1
    //   664: ldc 103
    //   666: ldc_w 275
    //   669: iconst_3
    //   670: anewarray 4	java/lang/Object
    //   673: dup
    //   674: iconst_0
    //   675: iload 6
    //   677: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: dup
    //   682: iconst_1
    //   683: iload 4
    //   685: invokestatic 280	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   688: aastore
    //   689: dup
    //   690: iconst_2
    //   691: aload_1
    //   692: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   695: aastore
    //   696: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   699: ldc 156
    //   701: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   704: iconst_m1
    //   705: ireturn
    //   706: aload_0
    //   707: getfield 89	com/tencent/mm/audio/e/c:hyx	Lcom/tencent/mm/modelvoice/i;
    //   710: ifnull -412 -> 298
    //   713: aload_0
    //   714: getfield 89	com/tencent/mm/audio/e/c:hyx	Lcom/tencent/mm/modelvoice/i;
    //   717: sipush 201
    //   720: iconst_0
    //   721: invokevirtual 228	com/tencent/mm/modelvoice/i:eR	(II)I
    //   724: pop
    //   725: goto -427 -> 298
    //   728: astore_1
    //   729: aload 19
    //   731: monitorexit
    //   732: ldc 156
    //   734: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   737: aload_1
    //   738: athrow
    //   739: ldc 103
    //   741: ldc_w 282
    //   744: iconst_4
    //   745: anewarray 4	java/lang/Object
    //   748: dup
    //   749: iconst_0
    //   750: aload 18
    //   752: iconst_0
    //   753: saload
    //   754: invokestatic 280	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   757: aastore
    //   758: dup
    //   759: iconst_1
    //   760: iload 4
    //   762: invokestatic 280	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   765: aastore
    //   766: dup
    //   767: iconst_2
    //   768: aload_1
    //   769: getfield 224	com/tencent/mm/audio/b/g$a:hxh	Z
    //   772: invokestatic 208	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   775: aastore
    //   776: dup
    //   777: iconst_3
    //   778: aload_1
    //   779: getfield 164	com/tencent/mm/audio/b/g$a:hxg	I
    //   782: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   785: aastore
    //   786: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   789: aload 18
    //   791: iconst_0
    //   792: saload
    //   793: aload 17
    //   795: arraylength
    //   796: if_icmpge +378 -> 1174
    //   799: aload 18
    //   801: iconst_0
    //   802: saload
    //   803: ifle +371 -> 1174
    //   806: aload_0
    //   807: getfield 127	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   810: ifnull +364 -> 1174
    //   813: iload_3
    //   814: ifeq +57 -> 871
    //   817: iload 9
    //   819: ifeq +52 -> 871
    //   822: ldc 103
    //   824: ldc_w 287
    //   827: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 17
    //   832: iconst_1
    //   833: aload 17
    //   835: arraylength
    //   836: invokestatic 293	java/util/Arrays:copyOfRange	([BII)[B
    //   839: astore 19
    //   841: aload_0
    //   842: getfield 127	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   845: aload 19
    //   847: iconst_0
    //   848: aload 18
    //   850: iconst_0
    //   851: saload
    //   852: iconst_1
    //   853: isub
    //   854: invokevirtual 297	java/io/OutputStream:write	([BII)V
    //   857: iload 5
    //   859: aload 18
    //   861: iconst_0
    //   862: saload
    //   863: iconst_1
    //   864: isub
    //   865: iadd
    //   866: istore 5
    //   868: goto -711 -> 157
    //   871: aload_0
    //   872: getfield 127	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   875: aload 17
    //   877: iconst_0
    //   878: aload 18
    //   880: iconst_0
    //   881: saload
    //   882: invokevirtual 297	java/io/OutputStream:write	([BII)V
    //   885: aload 18
    //   887: iconst_0
    //   888: saload
    //   889: istore 8
    //   891: iload 8
    //   893: iload 5
    //   895: iadd
    //   896: istore 5
    //   898: goto -741 -> 157
    //   901: astore_1
    //   902: ldc 103
    //   904: ldc_w 299
    //   907: iconst_1
    //   908: anewarray 4	java/lang/Object
    //   911: dup
    //   912: iconst_0
    //   913: aload_0
    //   914: getfield 112	com/tencent/mm/audio/e/c:hyo	Ljava/lang/String;
    //   917: aastore
    //   918: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   921: ldc 156
    //   923: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   926: iconst_m1
    //   927: ireturn
    //   928: aload_0
    //   929: getfield 127	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   932: ifnull +10 -> 942
    //   935: aload_0
    //   936: getfield 127	com/tencent/mm/audio/e/c:mFileOutputStream	Ljava/io/OutputStream;
    //   939: invokevirtual 302	java/io/OutputStream:flush	()V
    //   942: aload_1
    //   943: getfield 221	com/tencent/mm/audio/b/g$a:buf	[B
    //   946: iload 6
    //   948: aload_0
    //   949: getfield 70	com/tencent/mm/audio/e/c:hyq	[B
    //   952: aload_0
    //   953: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   956: iload 7
    //   958: invokestatic 218	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   961: aload_0
    //   962: aload_0
    //   963: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   966: iload 7
    //   968: iadd
    //   969: putfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   972: aload 15
    //   974: invokevirtual 306	com/tencent/mm/compatible/util/f$a:aPY	()J
    //   977: lstore 13
    //   979: iload_2
    //   980: iconst_1
    //   981: if_icmpne +42 -> 1023
    //   984: getstatic 51	com/tencent/mm/audio/e/c:hyy	Lcom/tencent/mm/audio/e/a$a;
    //   987: astore_1
    //   988: aload_1
    //   989: aload_1
    //   990: getfield 309	com/tencent/mm/audio/e/a$a:hyj	J
    //   993: aload_1
    //   994: getfield 312	com/tencent/mm/audio/e/a$a:count	I
    //   997: i2l
    //   998: lmul
    //   999: lload 13
    //   1001: ladd
    //   1002: aload_1
    //   1003: getfield 312	com/tencent/mm/audio/e/a$a:count	I
    //   1006: iconst_1
    //   1007: iadd
    //   1008: i2l
    //   1009: ldiv
    //   1010: putfield 309	com/tencent/mm/audio/e/a$a:hyj	J
    //   1013: aload_1
    //   1014: aload_1
    //   1015: getfield 312	com/tencent/mm/audio/e/a$a:count	I
    //   1018: iconst_1
    //   1019: iadd
    //   1020: putfield 312	com/tencent/mm/audio/e/a$a:count	I
    //   1023: ldc 103
    //   1025: new 105	java/lang/StringBuilder
    //   1028: dup
    //   1029: ldc_w 314
    //   1032: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1035: lload 13
    //   1037: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1040: ldc_w 319
    //   1043: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: iload_2
    //   1047: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1050: ldc_w 324
    //   1053: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: getstatic 51	com/tencent/mm/audio/e/c:hyy	Lcom/tencent/mm/audio/e/a$a;
    //   1059: getfield 309	com/tencent/mm/audio/e/a$a:hyj	J
    //   1062: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1065: ldc_w 326
    //   1068: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: getstatic 51	com/tencent/mm/audio/e/c:hyy	Lcom/tencent/mm/audio/e/a$a;
    //   1074: getfield 312	com/tencent/mm/audio/e/a$a:count	I
    //   1077: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1080: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1083: invokestatic 328	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1086: ldc 156
    //   1088: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1091: iload 5
    //   1093: ireturn
    //   1094: astore_1
    //   1095: ldc 103
    //   1097: ldc_w 330
    //   1100: iconst_1
    //   1101: anewarray 4	java/lang/Object
    //   1104: dup
    //   1105: iconst_0
    //   1106: aload_0
    //   1107: getfield 112	com/tencent/mm/audio/e/c:hyo	Ljava/lang/String;
    //   1110: aastore
    //   1111: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1114: ldc 156
    //   1116: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1119: iconst_m1
    //   1120: ireturn
    //   1121: astore_1
    //   1122: ldc 103
    //   1124: ldc_w 332
    //   1127: iconst_4
    //   1128: anewarray 4	java/lang/Object
    //   1131: dup
    //   1132: iconst_0
    //   1133: iload 6
    //   1135: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1138: aastore
    //   1139: dup
    //   1140: iconst_1
    //   1141: aload_0
    //   1142: getfield 68	com/tencent/mm/audio/e/c:hyp	I
    //   1145: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1148: aastore
    //   1149: dup
    //   1150: iconst_2
    //   1151: iload 7
    //   1153: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1156: aastore
    //   1157: dup
    //   1158: iconst_3
    //   1159: aload_1
    //   1160: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1163: aastore
    //   1164: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1167: ldc 156
    //   1169: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1172: iconst_m1
    //   1173: ireturn
    //   1174: goto -276 -> 898
    //   1177: iconst_0
    //   1178: istore 8
    //   1180: goto -853 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1183	0	this	c
    //   0	1183	1	parama	g.a
    //   0	1183	2	paramInt	int
    //   0	1183	3	paramBoolean	boolean
    //   28	733	4	i	int
    //   56	7	5	j	int
    //   152	940	5	k	int
    //   155	503	6	m	int
    //   658	476	6	n	int
    //   39	196	7	i1	int
    //   235	917	7	i2	int
    //   196	14	8	i3	int
    //   325	854	8	i4	int
    //   335	483	9	i5	int
    //   331	143	10	i6	int
    //   72	513	11	bool1	boolean
    //   68	33	12	bool2	boolean
    //   977	59	13	l	long
    //   12	961	15	locala	com.tencent.mm.compatible.util.f.a
    //   45	601	16	arrayOfByte1	byte[]
    //   65	811	17	arrayOfByte2	byte[]
    //   98	788	18	localObject1	Object
    //   246	600	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   171	213	589	java/lang/Exception
    //   639	653	663	java/lang/Exception
    //   251	258	728	finally
    //   265	291	728	finally
    //   291	298	728	finally
    //   298	327	728	finally
    //   327	330	728	finally
    //   706	725	728	finally
    //   789	799	901	java/io/IOException
    //   806	813	901	java/io/IOException
    //   822	857	901	java/io/IOException
    //   871	885	901	java/io/IOException
    //   935	942	1094	java/io/IOException
    //   942	972	1121	java/lang/Exception
  }
  
  public final boolean aIA()
  {
    AppMethodBeat.i(130019);
    Log.i("MicroMsg.SilkWriter", "resetWriter");
    synchronized (this.hys)
    {
      if (this.hyx != null) {
        MediaRecorder.SilkEncUnInit(this.hyx.pdE);
      }
      this.hyx = new i(this.mSampleRate, this.hyr, this.hyv);
      if (0L == this.hyx.pdE)
      {
        Log.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error");
        this.hyx = null;
        AppMethodBeat.o(130019);
        return false;
      }
    }
    AppMethodBeat.o(130019);
    return true;
  }
  
  /* Error */
  public final void aIz()
  {
    // Byte code:
    //   0: ldc_w 349
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 103
    //   8: ldc_w 351
    //   11: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 66	com/tencent/mm/audio/e/c:hyn	Z
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: getfield 78	com/tencent/mm/audio/e/c:hyt	Lcom/tencent/mm/audio/e/c$a;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 78	com/tencent/mm/audio/e/c:hyt	Lcom/tencent/mm/audio/e/c$a;
    //   34: invokevirtual 354	com/tencent/mm/audio/e/c$a:aID	()V
    //   37: aload_0
    //   38: invokespecial 356	com/tencent/mm/audio/e/c:aIB	()V
    //   41: ldc_w 349
    //   44: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: ldc_w 349
    //   54: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: ldc 103
    //   62: ldc_w 358
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_1
    //   72: invokestatic 362	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: goto -42 -> 37
    //   82: astore_1
    //   83: ldc 103
    //   85: ldc_w 358
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: invokestatic 362	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   98: aastore
    //   99: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: goto -65 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	c
    //   48	10	1	localObject	Object
    //   59	13	1	localInterruptedException	InterruptedException
    //   82	13	1	localExecutionException	java.util.concurrent.ExecutionException
    // Exception table:
    //   from	to	target	type
    //   16	23	48	finally
    //   30	37	59	java/lang/InterruptedException
    //   30	37	82	java/util/concurrent/ExecutionException
  }
  
  public final boolean jO(String paramString)
  {
    AppMethodBeat.i(130016);
    Log.i("MicroMsg.SilkWriter", "initWriter path: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      Log.e("MicroMsg.SilkWriter", "path is null");
      AppMethodBeat.o(130016);
      return false;
    }
    try
    {
      localObject1 = new u(paramString);
      localu = new u(paramString);
      String str = paramString.substring(0, paramString.lastIndexOf("/") + 1);
      Log.e("MicroMsg.SilkWriter", "[carl] !!!! VFS parent! exists(ret %s). Parent dir(%s)", new Object[] { Boolean.valueOf(new u(str).jKS()), str });
      if (((u)localObject1).jKP().jKS())
      {
        if (!localu.jKP().jKS())
        {
          Log.e("MicroMsg.SilkWriter", "[carl] !!!! VFS not created dir! Do mkdirs(ret %s). Parent dir(%s)", new Object[] { Boolean.valueOf(localu.jKP().jKY()), ah.v(((u)localObject1).jKP().jKT()) });
          com.tencent.mm.plugin.report.service.h.OAn.p(357L, 57L, 1L);
        }
        localu = null;
      }
    }
    finally
    {
      try
      {
        localObject1 = y.ev(paramString, false);
        label193:
        if (localObject1 == null) {
          break label631;
        }
      }
      catch (Exception localException)
      {
        try
        {
          Object localObject1;
          u localu;
          this.hyo = paramString;
          this.mFileOutputStream = ((OutputStream)localObject1);
          this.hyu = false;
          i = m.aOK();
          if ((i & 0x400) != 0) {}
          for (this.hyv = 4;; this.hyv = 2)
          {
            this.hyx = new i(this.mSampleRate, this.hyr, this.hyv);
            if (0L != this.hyx.pdE) {
              break label502;
            }
            Log.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error");
            this.hyx = null;
            AppMethodBeat.o(130016);
            return false;
            Log.e("MicroMsg.SilkWriter", "[carl] ???? Dir not created! Do mkdirs(ret %s). Parent dir(%s)", new Object[] { Boolean.valueOf(((u)localObject1).jKP().jKY()), ah.v(((u)localObject1).jKP().jKT()) });
            com.tencent.mm.plugin.report.service.h.OAn.p(357L, 58L, 1L);
            break;
            localThrowable = finally;
            Log.printErrStackTrace("MicroMsg.SilkWriter", localThrowable, "Check out file dir error.", new Object[0]);
            break;
            localException = localException;
            Log.printErrStackTrace("MicroMsg.SilkWriter", localException, "initWriter openWrite failed: %s", new Object[] { localException.getMessage() });
            com.tencent.mm.plugin.report.service.h.OAn.p(357L, 55L, 1L);
            Object localObject2 = localu;
            if (!d.Yxk) {
              break label193;
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("stack", localException.getMessage());
            com.tencent.mm.plugin.report.service.h.OAn.e("Record", "Write failed", (Map)localObject2);
            localObject2 = localu;
            break label193;
            if ((i & 0x200) == 0) {
              break label486;
            }
          }
          Log.e("MicroMsg.SilkWriter", "initWriter cpuType error! silk don't support arm_v5!!!!");
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", new Object[] { paramString.getMessage() });
          AppMethodBeat.o(130016);
          return false;
        }
        label486:
        AppMethodBeat.o(130016);
        return false;
      }
    }
    label502:
    this.hyq = new byte[this.mSampleRate * 20 * 2 / 1000];
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziB, -1);
    if (1 == i) {
      this.hyw = true;
    }
    if (i == 0) {
      this.hyw = false;
    }
    if (this.hyw)
    {
      if (this.hyx != null) {
        this.hyx.eR(200, 1);
      }
      Log.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
    }
    for (;;)
    {
      AppMethodBeat.o(130016);
      return true;
      if (this.hyx != null) {
        this.hyx.eR(200, 0);
      }
      Log.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
    }
    label631:
    AppMethodBeat.o(130016);
    return false;
  }
  
  public final class a
    implements e, com.tencent.threadpool.i.h
  {
    private Future<?> dBj;
    
    private a() {}
    
    public final void aID()
    {
      AppMethodBeat.i(184404);
      if (this.dBj != null) {
        this.dBj.get();
      }
      AppMethodBeat.o(184404);
    }
    
    public final void c(Future<?> paramFuture)
    {
      this.dBj = paramFuture;
    }
    
    public final String getKey()
    {
      return "SilkWriter_run";
    }
    
    public final void run()
    {
      AppMethodBeat.i(130014);
      Log.i("MicroMsg.SilkWriter", "Silk Thread start run");
      int i;
      for (;;)
      {
        boolean bool;
        synchronized (c.this)
        {
          bool = c.a(c.this);
          Log.d("MicroMsg.SilkWriter", "ThreadSilk in :" + bool + " cnt :" + c.b(c.this).size());
          if (bool) {
            if (c.b(c.this).isEmpty()) {
              break label286;
            }
          }
        }
        continue;
        i = c.b(c.this).size();
        if ((i > 10) || (bool))
        {
          Log.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + i + " stop:" + bool);
          i = 0;
        }
      }
      for (;;)
      {
        int j = i;
        if (c.aIC().count >= 10)
        {
          j = i;
          if (c.aIC().hyj > 240L) {
            j = 0;
          }
        }
        c.this.a(localInterruptedException, j, false);
        break;
        if (i < 9)
        {
          i = 1;
          continue;
          label286:
          AppMethodBeat.o(130014);
        }
        else
        {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.audio.e.c
 * JD-Core Version:    0.7.0.1
 */