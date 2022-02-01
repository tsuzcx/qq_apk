package com.tencent.mm.plugin.hardcoder;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.e.a;
import com.tencent.mm.hardcoder.h.a;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.hardcoder.j;
import com.tencent.mm.hardcoder.k;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;

public final class a
  implements e.a, h.a
{
  private static String Jmq = null;
  private static Long Jmr = null;
  public static boolean Jms = false;
  private static a Jmt;
  private ArrayList<Pair<Integer, Object[]>> Jmu;
  private ArrayList<Object[]> Jmv;
  private IListener wPn;
  
  public a()
  {
    AppMethodBeat.i(130756);
    this.Jmu = new ArrayList();
    this.Jmv = new ArrayList();
    this.wPn = new HardCoderReporterImpl.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(130756);
  }
  
  private void b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130760);
    if ((MMApplicationContext.isMMProcess()) && (!com.tencent.mm.kernel.h.baC().mBZ))
    {
      Log.w("MicroMsg.HardCoderReporterImpl", "kvStat accountNotInitialReady!");
      this.wPn.alive();
      this.Jmu.add(new Pair(Integer.valueOf(paramInt), paramVarArgs));
      AppMethodBeat.o(130760);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(paramInt, paramVarArgs);
    AppMethodBeat.o(130760);
  }
  
  public static a fKh()
  {
    AppMethodBeat.i(130757);
    if (Jmt == null) {
      Jmt = new a();
    }
    a locala = Jmt;
    AppMethodBeat.o(130757);
    return locala;
  }
  
  /* Error */
  public final void a(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, int paramInt6, int[] paramArrayOfInt2, int paramInt7, int paramInt8, int paramInt9, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   8: iconst_1
    //   9: if_icmple +15 -> 24
    //   12: getstatic 144	com/tencent/mm/hardcoder/WXHardCoderJNI:hcKVPerReport	Z
    //   15: ifne +9 -> 24
    //   18: ldc 135
    //   20: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: invokestatic 147	com/tencent/mm/hardcoder/WXHardCoderJNI:isHCEnable	()Z
    //   27: ifeq +145 -> 172
    //   30: iconst_1
    //   31: istore 16
    //   33: getstatic 31	com/tencent/mm/plugin/hardcoder/a:Jmr	Ljava/lang/Long;
    //   36: ifnonnull +35 -> 71
    //   39: invokestatic 76	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
    //   42: ifeq +136 -> 178
    //   45: invokestatic 151	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   48: pop
    //   49: invokestatic 155	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   52: invokevirtual 161	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   55: getstatic 167	com/tencent/mm/storage/at$a:acPU	Lcom/tencent/mm/storage/at$a;
    //   58: lconst_0
    //   59: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   62: invokevirtual 178	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 169	java/lang/Long
    //   68: putstatic 31	com/tencent/mm/plugin/hardcoder/a:Jmr	Ljava/lang/Long;
    //   71: getstatic 29	com/tencent/mm/plugin/hardcoder/a:Jmq	Ljava/lang/String;
    //   74: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifeq +10 -> 87
    //   80: iconst_0
    //   81: invokestatic 190	com/tencent/mm/compatible/deviceinfo/q:eD	(Z)Ljava/lang/String;
    //   84: putstatic 29	com/tencent/mm/plugin/hardcoder/a:Jmq	Ljava/lang/String;
    //   87: getstatic 29	com/tencent/mm/plugin/hardcoder/a:Jmq	Ljava/lang/String;
    //   90: astore 22
    //   92: getstatic 31	com/tencent/mm/plugin/hardcoder/a:Jmr	Ljava/lang/Long;
    //   95: invokevirtual 194	java/lang/Long:longValue	()J
    //   98: l2i
    //   99: istore 20
    //   101: new 196	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   108: astore 23
    //   110: aload 10
    //   112: ifnull +76 -> 188
    //   115: aload 10
    //   117: arraylength
    //   118: istore 18
    //   120: iconst_0
    //   121: istore 17
    //   123: iload 17
    //   125: iload 18
    //   127: if_icmpge +61 -> 188
    //   130: aload 10
    //   132: iload 17
    //   134: iaload
    //   135: istore 19
    //   137: aload 23
    //   139: new 196	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   146: iload 19
    //   148: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc 203
    //   153: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: iload 17
    //   165: iconst_1
    //   166: iadd
    //   167: istore 17
    //   169: goto -46 -> 123
    //   172: iconst_0
    //   173: istore 16
    //   175: goto -142 -> 33
    //   178: lconst_0
    //   179: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: putstatic 31	com/tencent/mm/plugin/hardcoder/a:Jmr	Ljava/lang/Long;
    //   185: goto -114 -> 71
    //   188: new 196	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   195: astore 10
    //   197: aload 14
    //   199: ifnull +76 -> 275
    //   202: aload 14
    //   204: arraylength
    //   205: istore 21
    //   207: iconst_0
    //   208: istore 17
    //   210: iload 17
    //   212: iload 21
    //   214: if_icmpge +61 -> 275
    //   217: aload 14
    //   219: iload 17
    //   221: iaload
    //   222: istore 19
    //   224: new 196	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   231: astore 24
    //   233: iload 19
    //   235: istore 18
    //   237: iload 19
    //   239: ifge +6 -> 245
    //   242: iconst_0
    //   243: istore 18
    //   245: aload 10
    //   247: aload 24
    //   249: iload 18
    //   251: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: ldc 203
    //   256: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: iload 17
    //   268: iconst_1
    //   269: iadd
    //   270: istore 17
    //   272: goto -62 -> 210
    //   275: new 196	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   282: astore 14
    //   284: aload 15
    //   286: ifnull +76 -> 362
    //   289: aload 15
    //   291: arraylength
    //   292: istore 21
    //   294: iconst_0
    //   295: istore 17
    //   297: iload 17
    //   299: iload 21
    //   301: if_icmpge +61 -> 362
    //   304: aload 15
    //   306: iload 17
    //   308: iaload
    //   309: istore 19
    //   311: new 196	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   318: astore 24
    //   320: iload 19
    //   322: istore 18
    //   324: iload 19
    //   326: ifge +6 -> 332
    //   329: iconst_0
    //   330: istore 18
    //   332: aload 14
    //   334: aload 24
    //   336: iload 18
    //   338: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc 203
    //   343: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: iload 17
    //   355: iconst_1
    //   356: iadd
    //   357: istore 17
    //   359: goto -62 -> 297
    //   362: ldc 212
    //   364: bipush 17
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload 22
    //   373: aastore
    //   374: dup
    //   375: iconst_1
    //   376: aload_1
    //   377: invokestatic 217	java/util/Arrays:toString	([I)Ljava/lang/String;
    //   380: aastore
    //   381: dup
    //   382: iconst_2
    //   383: iload_2
    //   384: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: aastore
    //   388: dup
    //   389: iconst_3
    //   390: iload 20
    //   392: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_4
    //   398: iload 16
    //   400: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: dup
    //   405: iconst_5
    //   406: iload_3
    //   407: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: aastore
    //   411: dup
    //   412: bipush 6
    //   414: iload 4
    //   416: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: dup
    //   421: bipush 7
    //   423: iload 5
    //   425: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: dup
    //   430: bipush 8
    //   432: lload 6
    //   434: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   437: aastore
    //   438: dup
    //   439: bipush 9
    //   441: iload 8
    //   443: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   446: aastore
    //   447: dup
    //   448: bipush 10
    //   450: iload 9
    //   452: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: aastore
    //   456: dup
    //   457: bipush 11
    //   459: aload 23
    //   461: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: aastore
    //   465: dup
    //   466: bipush 12
    //   468: iload 11
    //   470: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   473: aastore
    //   474: dup
    //   475: bipush 13
    //   477: iload 12
    //   479: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: aastore
    //   483: dup
    //   484: bipush 14
    //   486: iload 13
    //   488: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: aastore
    //   492: dup
    //   493: bipush 15
    //   495: aload 10
    //   497: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: aastore
    //   501: dup
    //   502: bipush 16
    //   504: aload 14
    //   506: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: aastore
    //   510: invokestatic 223	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   513: astore 24
    //   515: ldc 225
    //   517: bipush 17
    //   519: anewarray 4	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: invokestatic 230	java/lang/System:currentTimeMillis	()J
    //   527: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   530: aastore
    //   531: dup
    //   532: iconst_1
    //   533: aload 22
    //   535: aastore
    //   536: dup
    //   537: iconst_2
    //   538: aload_1
    //   539: invokestatic 217	java/util/Arrays:toString	([I)Ljava/lang/String;
    //   542: aastore
    //   543: dup
    //   544: iconst_3
    //   545: iload_2
    //   546: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   549: aastore
    //   550: dup
    //   551: iconst_4
    //   552: iload 20
    //   554: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   557: aastore
    //   558: dup
    //   559: iconst_5
    //   560: iload 16
    //   562: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: aastore
    //   566: dup
    //   567: bipush 6
    //   569: iload 4
    //   571: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: aastore
    //   575: dup
    //   576: bipush 7
    //   578: iload 5
    //   580: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: aastore
    //   584: dup
    //   585: bipush 8
    //   587: lload 6
    //   589: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   592: aastore
    //   593: dup
    //   594: bipush 9
    //   596: iload 8
    //   598: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   601: aastore
    //   602: dup
    //   603: bipush 10
    //   605: iload 9
    //   607: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aastore
    //   611: dup
    //   612: bipush 11
    //   614: aload 23
    //   616: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: aastore
    //   620: dup
    //   621: bipush 12
    //   623: iload 11
    //   625: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: aastore
    //   629: dup
    //   630: bipush 13
    //   632: iload 12
    //   634: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   637: aastore
    //   638: dup
    //   639: bipush 14
    //   641: iload 13
    //   643: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   646: aastore
    //   647: dup
    //   648: bipush 15
    //   650: aload 10
    //   652: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: aastore
    //   656: dup
    //   657: bipush 16
    //   659: aload 14
    //   661: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: aastore
    //   665: invokestatic 223	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   668: astore 15
    //   670: invokestatic 233	com/tencent/mm/hardcoder/WXHardCoderJNI:getDebug	()Z
    //   673: ifeq +10 -> 683
    //   676: ldc 89
    //   678: aload 24
    //   680: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload 23
    //   685: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: astore_1
    //   689: iload 11
    //   691: istore 17
    //   693: iload 11
    //   695: ifge +6 -> 701
    //   698: iconst_0
    //   699: istore 17
    //   701: aload_0
    //   702: sipush 14607
    //   705: bipush 21
    //   707: anewarray 4	java/lang/Object
    //   710: dup
    //   711: iconst_0
    //   712: aload 22
    //   714: aastore
    //   715: dup
    //   716: iconst_1
    //   717: iload 20
    //   719: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   722: aastore
    //   723: dup
    //   724: iconst_2
    //   725: iload 16
    //   727: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   730: aastore
    //   731: dup
    //   732: iconst_3
    //   733: iload 4
    //   735: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   738: aastore
    //   739: dup
    //   740: iconst_4
    //   741: iload 5
    //   743: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   746: aastore
    //   747: dup
    //   748: iconst_5
    //   749: lload 6
    //   751: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   754: aastore
    //   755: dup
    //   756: bipush 6
    //   758: iload 8
    //   760: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   763: aastore
    //   764: dup
    //   765: bipush 7
    //   767: iload 9
    //   769: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   772: aastore
    //   773: dup
    //   774: bipush 8
    //   776: aload_1
    //   777: aastore
    //   778: dup
    //   779: bipush 9
    //   781: iload 17
    //   783: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   786: aastore
    //   787: dup
    //   788: bipush 10
    //   790: iload 12
    //   792: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   795: aastore
    //   796: dup
    //   797: bipush 11
    //   799: iconst_0
    //   800: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   803: aastore
    //   804: dup
    //   805: bipush 12
    //   807: iconst_0
    //   808: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   811: aastore
    //   812: dup
    //   813: bipush 13
    //   815: iload 13
    //   817: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   820: aastore
    //   821: dup
    //   822: bipush 14
    //   824: iconst_0
    //   825: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: aastore
    //   829: dup
    //   830: bipush 15
    //   832: aload 10
    //   834: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: aastore
    //   838: dup
    //   839: bipush 16
    //   841: aload 14
    //   843: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: aastore
    //   847: dup
    //   848: bipush 17
    //   850: ldc 237
    //   852: aastore
    //   853: dup
    //   854: bipush 18
    //   856: iconst_0
    //   857: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   860: aastore
    //   861: dup
    //   862: bipush 19
    //   864: iload_3
    //   865: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: aastore
    //   869: dup
    //   870: bipush 20
    //   872: iload_2
    //   873: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   876: aastore
    //   877: invokespecial 238	com/tencent/mm/plugin/hardcoder/a:b	(I[Ljava/lang/Object;)V
    //   880: getstatic 33	com/tencent/mm/plugin/hardcoder/a:Jms	Z
    //   883: ifeq +338 -> 1221
    //   886: new 196	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   893: astore_1
    //   894: invokestatic 151	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   897: pop
    //   898: aload_1
    //   899: invokestatic 155	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   902: getfield 241	com/tencent/mm/kernel/f:mCI	Ljava/lang/String;
    //   905: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: ldc 243
    //   910: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   916: astore_1
    //   917: iconst_1
    //   918: anewarray 219	java/lang/String
    //   921: dup
    //   922: iconst_0
    //   923: aload_1
    //   924: aastore
    //   925: invokestatic 249	com/tencent/mm/b/e:d	([Ljava/lang/String;)V
    //   928: new 251	com/tencent/mm/vfs/u
    //   931: dup
    //   932: aload_1
    //   933: ldc 253
    //   935: invokespecial 255	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: astore 14
    //   940: aload 14
    //   942: invokevirtual 258	com/tencent/mm/vfs/u:jKS	()Z
    //   945: ifne +9 -> 954
    //   948: aload 14
    //   950: invokevirtual 261	com/tencent/mm/vfs/u:jKZ	()Z
    //   953: pop
    //   954: aconst_null
    //   955: astore 10
    //   957: aconst_null
    //   958: astore_1
    //   959: aload 14
    //   961: iconst_1
    //   962: invokestatic 267	com/tencent/mm/vfs/y:e	(Lcom/tencent/mm/vfs/u;Z)Ljava/io/OutputStream;
    //   965: astore 14
    //   967: aload 14
    //   969: astore_1
    //   970: aload 14
    //   972: astore 10
    //   974: aload 14
    //   976: new 196	java/lang/StringBuilder
    //   979: dup
    //   980: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   983: aload 15
    //   985: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: ldc_w 269
    //   991: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: ldc_w 271
    //   1000: invokevirtual 275	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1003: invokevirtual 281	java/io/OutputStream:write	([B)V
    //   1006: aload 14
    //   1008: astore_1
    //   1009: aload 14
    //   1011: astore 10
    //   1013: aload 14
    //   1015: invokevirtual 284	java/io/OutputStream:flush	()V
    //   1018: aload 14
    //   1020: ifnull +201 -> 1221
    //   1023: aload 14
    //   1025: invokevirtual 287	java/io/OutputStream:close	()V
    //   1028: ldc 135
    //   1030: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1033: return
    //   1034: astore_1
    //   1035: ldc 89
    //   1037: new 196	java/lang/StringBuilder
    //   1040: dup
    //   1041: ldc_w 289
    //   1044: invokespecial 292	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1047: aload_1
    //   1048: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1051: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1057: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1060: goto -106 -> 954
    //   1063: astore_1
    //   1064: ldc 89
    //   1066: new 196	java/lang/StringBuilder
    //   1069: dup
    //   1070: ldc_w 297
    //   1073: invokespecial 292	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1076: aload_1
    //   1077: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1080: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: ldc 135
    //   1091: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1094: return
    //   1095: astore 14
    //   1097: aload_1
    //   1098: astore 10
    //   1100: ldc 89
    //   1102: new 196	java/lang/StringBuilder
    //   1105: dup
    //   1106: ldc_w 299
    //   1109: invokespecial 292	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1112: aload 14
    //   1114: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1117: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1123: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload_1
    //   1127: ifnull +94 -> 1221
    //   1130: aload_1
    //   1131: invokevirtual 287	java/io/OutputStream:close	()V
    //   1134: ldc 135
    //   1136: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1139: return
    //   1140: astore_1
    //   1141: ldc 89
    //   1143: new 196	java/lang/StringBuilder
    //   1146: dup
    //   1147: ldc_w 297
    //   1150: invokespecial 292	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1153: aload_1
    //   1154: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1157: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1166: ldc 135
    //   1168: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1171: return
    //   1172: astore_1
    //   1173: aload 10
    //   1175: ifnull +8 -> 1183
    //   1178: aload 10
    //   1180: invokevirtual 287	java/io/OutputStream:close	()V
    //   1183: ldc 135
    //   1185: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1188: aload_1
    //   1189: athrow
    //   1190: astore 10
    //   1192: ldc 89
    //   1194: new 196	java/lang/StringBuilder
    //   1197: dup
    //   1198: ldc_w 297
    //   1201: invokespecial 292	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1204: aload 10
    //   1206: invokevirtual 295	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1209: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1215: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1218: goto -35 -> 1183
    //   1221: ldc 135
    //   1223: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1226: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1227	0	this	a
    //   0	1227	1	paramArrayOfInt1	int[]
    //   0	1227	2	paramInt1	int
    //   0	1227	3	paramInt2	int
    //   0	1227	4	paramInt3	int
    //   0	1227	5	paramInt4	int
    //   0	1227	6	paramLong	long
    //   0	1227	8	paramInt5	int
    //   0	1227	9	paramInt6	int
    //   0	1227	10	paramArrayOfInt2	int[]
    //   0	1227	11	paramInt7	int
    //   0	1227	12	paramInt8	int
    //   0	1227	13	paramInt9	int
    //   0	1227	14	paramArrayOfInt3	int[]
    //   0	1227	15	paramArrayOfInt4	int[]
    //   31	695	16	i	int
    //   121	661	17	j	int
    //   118	219	18	k	int
    //   135	190	19	m	int
    //   99	619	20	n	int
    //   205	97	21	i1	int
    //   90	623	22	str	String
    //   108	576	23	localStringBuilder	java.lang.StringBuilder
    //   231	448	24	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   948	954	1034	java/lang/Exception
    //   1023	1028	1063	java/lang/Exception
    //   959	967	1095	java/lang/Exception
    //   974	1006	1095	java/lang/Exception
    //   1013	1018	1095	java/lang/Exception
    //   1130	1134	1140	java/lang/Exception
    //   959	967	1172	finally
    //   974	1006	1172	finally
    //   1013	1018	1172	finally
    //   1100	1126	1172	finally
    //   1178	1183	1190	java/lang/Exception
  }
  
  public final void reportInfo(com.tencent.mm.hardcoder.h paramh)
  {
    AppMethodBeat.i(130759);
    long l1;
    if ((paramh instanceof j))
    {
      paramh = (j)paramh;
      Log.i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", new Object[] { Boolean.valueOf(paramh.mxf), Integer.valueOf(paramh.key), Integer.valueOf(paramh.value), Boolean.valueOf(paramh.ibX) });
      if (paramh.mxf) {}
      long l2;
      long l3;
      boolean bool;
      for (l1 = 678L;; l1 = 679L)
      {
        l2 = paramh.key;
        l3 = paramh.value;
        bool = paramh.ibX;
        if ((!MMApplicationContext.isMMProcess()) || (com.tencent.mm.kernel.h.baC().mBZ)) {
          break;
        }
        Log.w("MicroMsg.HardCoderReporterImpl", "idkeyStat accountNotInitialReady!");
        this.wPn.alive();
        this.Jmv.add(new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool) });
        AppMethodBeat.o(130759);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(l1, l2, l3, bool);
      AppMethodBeat.o(130759);
      return;
    }
    if ((paramh instanceof i))
    {
      paramh = (i)paramh;
      if (Jmr == null)
      {
        com.tencent.mm.kernel.h.baF();
        Jmr = (Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acPU, Long.valueOf(0L));
      }
      if (TextUtils.isEmpty(Jmq)) {
        Jmq = q.eD(false);
      }
      String str = Jmq;
      int k = (int)Jmr.longValue();
      int i;
      int m;
      if (WXHardCoderJNI.isHCEnable())
      {
        i = 1;
        m = WXHardCoderJNI.isRunning();
        if (!WXHardCoderJNI.getEnable()) {
          break label566;
        }
      }
      label566:
      for (int j = 1;; j = 0)
      {
        if (paramh.type == 1)
        {
          l1 = paramh.mxe * 100L / paramh.interval;
          b(15187, new Object[] { str, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(paramh.scene), Long.valueOf(paramh.mwI), Integer.valueOf(paramh.type), Long.valueOf(paramh.mxe), Long.valueOf(paramh.interval), Long.valueOf(l1), Integer.valueOf(j) });
          Log.i("MicroMsg.HardCoderReporterImpl", String.format("fpsReport imei:%s enable:%s, heavy:%s speedUp:%s, engineStatus:%s, scene:%s, action:%s, type:%s, totalDroppedFrames:%s, interval:%s, average:%s", new Object[] { str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(paramh.scene), Long.valueOf(paramh.mwI), Integer.valueOf(paramh.type), Long.valueOf(paramh.mxe), Long.valueOf(paramh.interval), Long.valueOf(l1) }));
        }
        AppMethodBeat.o(130759);
        return;
        i = 0;
        break;
      }
    }
    if ((paramh instanceof k)) {
      b(16509, new Object[0]);
    }
    AppMethodBeat.o(130759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.a
 * JD-Core Version:    0.7.0.1
 */