package com.tencent.mm.plugin.hardcoder;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.e.a;
import com.tencent.mm.hardcoder.j;
import com.tencent.mm.hardcoder.j.a;
import com.tencent.mm.hardcoder.k;
import com.tencent.mm.hardcoder.l;
import com.tencent.mm.hardcoder.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public final class a
  implements e.a, j.a
{
  private static String nGG = null;
  private static Long nGH = null;
  public static boolean nGI = false;
  private static a nGJ;
  private c mQa;
  private ArrayList<Pair<Integer, Object[]>> nGK;
  private ArrayList<Object[]> nGL;
  
  public a()
  {
    AppMethodBeat.i(60243);
    this.nGK = new ArrayList();
    this.nGL = new ArrayList();
    this.mQa = new a.1(this);
    AppMethodBeat.o(60243);
  }
  
  public static a bHO()
  {
    AppMethodBeat.i(60244);
    if (nGJ == null) {
      nGJ = new a();
    }
    a locala = nGJ;
    AppMethodBeat.o(60244);
    return locala;
  }
  
  private void e(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60247);
    if ((ah.brt()) && (!g.RJ().eHg))
    {
      ab.w("MicroMsg.HardCoderReporterImpl", "kvStat accountNotInitialReady!");
      this.mQa.alive();
      this.nGK.add(new Pair(Integer.valueOf(paramInt), paramVarArgs));
      AppMethodBeat.o(60247);
      return;
    }
    h.qsU.e(paramInt, paramVarArgs);
    AppMethodBeat.o(60247);
  }
  
  /* Error */
  public final void a(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, int[] paramArrayOfInt2, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:getLogLevel	()I
    //   8: iconst_1
    //   9: if_icmple +15 -> 24
    //   12: getstatic 140	com/tencent/mm/hardcoder/WXHardCoderJNI:hcKVPerReport	Z
    //   15: ifne +9 -> 24
    //   18: ldc 131
    //   20: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: invokestatic 143	com/tencent/mm/hardcoder/WXHardCoderJNI:isHCEnable	()Z
    //   27: ifeq +145 -> 172
    //   30: iconst_1
    //   31: istore 20
    //   33: getstatic 29	com/tencent/mm/plugin/hardcoder/a:nGH	Ljava/lang/Long;
    //   36: ifnonnull +35 -> 71
    //   39: invokestatic 77	com/tencent/mm/sdk/platformtools/ah:brt	()Z
    //   42: ifeq +136 -> 178
    //   45: invokestatic 147	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   48: pop
    //   49: invokestatic 151	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   52: invokevirtual 157	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   55: getstatic 163	com/tencent/mm/storage/ac$a:yFg	Lcom/tencent/mm/storage/ac$a;
    //   58: lconst_0
    //   59: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   62: invokevirtual 174	com/tencent/mm/storage/z:get	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 165	java/lang/Long
    //   68: putstatic 29	com/tencent/mm/plugin/hardcoder/a:nGH	Ljava/lang/Long;
    //   71: getstatic 27	com/tencent/mm/plugin/hardcoder/a:nGG	Ljava/lang/String;
    //   74: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifeq +10 -> 87
    //   80: iconst_0
    //   81: invokestatic 186	com/tencent/mm/compatible/e/q:bP	(Z)Ljava/lang/String;
    //   84: putstatic 27	com/tencent/mm/plugin/hardcoder/a:nGG	Ljava/lang/String;
    //   87: getstatic 27	com/tencent/mm/plugin/hardcoder/a:nGG	Ljava/lang/String;
    //   90: astore 26
    //   92: getstatic 29	com/tencent/mm/plugin/hardcoder/a:nGH	Ljava/lang/Long;
    //   95: invokevirtual 190	java/lang/Long:longValue	()J
    //   98: l2i
    //   99: istore 24
    //   101: new 192	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   108: astore 27
    //   110: aload 10
    //   112: ifnull +76 -> 188
    //   115: aload 10
    //   117: arraylength
    //   118: istore 22
    //   120: iconst_0
    //   121: istore 21
    //   123: iload 21
    //   125: iload 22
    //   127: if_icmpge +61 -> 188
    //   130: aload 10
    //   132: iload 21
    //   134: iaload
    //   135: istore 23
    //   137: aload 27
    //   139: new 192	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   146: iload 23
    //   148: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc 199
    //   153: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: iload 21
    //   165: iconst_1
    //   166: iadd
    //   167: istore 21
    //   169: goto -46 -> 123
    //   172: iconst_0
    //   173: istore 20
    //   175: goto -142 -> 33
    //   178: lconst_0
    //   179: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: putstatic 29	com/tencent/mm/plugin/hardcoder/a:nGH	Ljava/lang/Long;
    //   185: goto -114 -> 71
    //   188: new 192	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   195: astore 10
    //   197: aload 18
    //   199: ifnull +76 -> 275
    //   202: aload 18
    //   204: arraylength
    //   205: istore 25
    //   207: iconst_0
    //   208: istore 21
    //   210: iload 21
    //   212: iload 25
    //   214: if_icmpge +61 -> 275
    //   217: aload 18
    //   219: iload 21
    //   221: iaload
    //   222: istore 23
    //   224: new 192	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   231: astore 28
    //   233: iload 23
    //   235: istore 22
    //   237: iload 23
    //   239: ifge +6 -> 245
    //   242: iconst_0
    //   243: istore 22
    //   245: aload 10
    //   247: aload 28
    //   249: iload 22
    //   251: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: ldc 199
    //   256: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: iload 21
    //   268: iconst_1
    //   269: iadd
    //   270: istore 21
    //   272: goto -62 -> 210
    //   275: new 192	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   282: astore 28
    //   284: aload 19
    //   286: ifnull +76 -> 362
    //   289: aload 19
    //   291: arraylength
    //   292: istore 25
    //   294: iconst_0
    //   295: istore 21
    //   297: iload 21
    //   299: iload 25
    //   301: if_icmpge +61 -> 362
    //   304: aload 19
    //   306: iload 21
    //   308: iaload
    //   309: istore 23
    //   311: new 192	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   318: astore 18
    //   320: iload 23
    //   322: istore 22
    //   324: iload 23
    //   326: ifge +6 -> 332
    //   329: iconst_0
    //   330: istore 22
    //   332: aload 28
    //   334: aload 18
    //   336: iload 22
    //   338: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc 199
    //   343: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: iload 21
    //   355: iconst_1
    //   356: iadd
    //   357: istore 21
    //   359: goto -62 -> 297
    //   362: ldc 208
    //   364: bipush 20
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload 26
    //   373: aastore
    //   374: dup
    //   375: iconst_1
    //   376: aload_1
    //   377: invokestatic 213	java/util/Arrays:toString	([I)Ljava/lang/String;
    //   380: aastore
    //   381: dup
    //   382: iconst_2
    //   383: iload_2
    //   384: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: aastore
    //   388: dup
    //   389: iconst_3
    //   390: iload 24
    //   392: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_4
    //   398: iload 20
    //   400: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: dup
    //   405: iconst_5
    //   406: iload_3
    //   407: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: aastore
    //   411: dup
    //   412: bipush 6
    //   414: iload 4
    //   416: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: dup
    //   421: bipush 7
    //   423: iload 5
    //   425: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: dup
    //   430: bipush 8
    //   432: lload 6
    //   434: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   437: aastore
    //   438: dup
    //   439: bipush 9
    //   441: iload 8
    //   443: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   446: aastore
    //   447: dup
    //   448: bipush 10
    //   450: iload 9
    //   452: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   455: aastore
    //   456: dup
    //   457: bipush 11
    //   459: aload 27
    //   461: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: aastore
    //   465: dup
    //   466: bipush 12
    //   468: iload 11
    //   470: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   473: aastore
    //   474: dup
    //   475: bipush 13
    //   477: iload 12
    //   479: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: aastore
    //   483: dup
    //   484: bipush 14
    //   486: iload 13
    //   488: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   491: aastore
    //   492: dup
    //   493: bipush 15
    //   495: iload 14
    //   497: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: bipush 16
    //   504: iload 15
    //   506: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: dup
    //   511: bipush 17
    //   513: lload 16
    //   515: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   518: aastore
    //   519: dup
    //   520: bipush 18
    //   522: aload 10
    //   524: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: aastore
    //   528: dup
    //   529: bipush 19
    //   531: aload 28
    //   533: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: aastore
    //   537: invokestatic 219	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   540: astore 19
    //   542: ldc 221
    //   544: bipush 20
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: invokestatic 226	java/lang/System:currentTimeMillis	()J
    //   554: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   557: aastore
    //   558: dup
    //   559: iconst_1
    //   560: aload 26
    //   562: aastore
    //   563: dup
    //   564: iconst_2
    //   565: aload_1
    //   566: invokestatic 213	java/util/Arrays:toString	([I)Ljava/lang/String;
    //   569: aastore
    //   570: dup
    //   571: iconst_3
    //   572: iload_2
    //   573: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   576: aastore
    //   577: dup
    //   578: iconst_4
    //   579: iload 24
    //   581: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   584: aastore
    //   585: dup
    //   586: iconst_5
    //   587: iload 20
    //   589: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   592: aastore
    //   593: dup
    //   594: bipush 6
    //   596: iload 4
    //   598: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   601: aastore
    //   602: dup
    //   603: bipush 7
    //   605: iload 5
    //   607: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aastore
    //   611: dup
    //   612: bipush 8
    //   614: lload 6
    //   616: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   619: aastore
    //   620: dup
    //   621: bipush 9
    //   623: iload 8
    //   625: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   628: aastore
    //   629: dup
    //   630: bipush 10
    //   632: iload 9
    //   634: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   637: aastore
    //   638: dup
    //   639: bipush 11
    //   641: aload 27
    //   643: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: aastore
    //   647: dup
    //   648: bipush 12
    //   650: iload 11
    //   652: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   655: aastore
    //   656: dup
    //   657: bipush 13
    //   659: iload 12
    //   661: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: aastore
    //   665: dup
    //   666: bipush 14
    //   668: iload 13
    //   670: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   673: aastore
    //   674: dup
    //   675: bipush 15
    //   677: iload 14
    //   679: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   682: aastore
    //   683: dup
    //   684: bipush 16
    //   686: iload 15
    //   688: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   691: aastore
    //   692: dup
    //   693: bipush 17
    //   695: lload 16
    //   697: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   700: aastore
    //   701: dup
    //   702: bipush 18
    //   704: aload 10
    //   706: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: aastore
    //   710: dup
    //   711: bipush 19
    //   713: aload 28
    //   715: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: aastore
    //   719: invokestatic 219	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   722: astore 18
    //   724: invokestatic 229	com/tencent/mm/hardcoder/WXHardCoderJNI:getDebug	()Z
    //   727: ifeq +10 -> 737
    //   730: ldc 90
    //   732: aload 19
    //   734: invokestatic 231	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   737: aload 27
    //   739: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: astore_1
    //   743: iload 11
    //   745: istore 21
    //   747: iload 11
    //   749: ifge +6 -> 755
    //   752: iconst_0
    //   753: istore 21
    //   755: aload_0
    //   756: sipush 14607
    //   759: bipush 21
    //   761: anewarray 4	java/lang/Object
    //   764: dup
    //   765: iconst_0
    //   766: aload 26
    //   768: aastore
    //   769: dup
    //   770: iconst_1
    //   771: iload 24
    //   773: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: aastore
    //   777: dup
    //   778: iconst_2
    //   779: iload 20
    //   781: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   784: aastore
    //   785: dup
    //   786: iconst_3
    //   787: iload 4
    //   789: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   792: aastore
    //   793: dup
    //   794: iconst_4
    //   795: iload 5
    //   797: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: dup
    //   802: iconst_5
    //   803: lload 6
    //   805: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   808: aastore
    //   809: dup
    //   810: bipush 6
    //   812: iload 8
    //   814: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   817: aastore
    //   818: dup
    //   819: bipush 7
    //   821: iload 9
    //   823: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   826: aastore
    //   827: dup
    //   828: bipush 8
    //   830: aload_1
    //   831: aastore
    //   832: dup
    //   833: bipush 9
    //   835: iload 21
    //   837: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   840: aastore
    //   841: dup
    //   842: bipush 10
    //   844: iload 12
    //   846: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   849: aastore
    //   850: dup
    //   851: bipush 11
    //   853: iload 13
    //   855: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   858: aastore
    //   859: dup
    //   860: bipush 12
    //   862: iload 14
    //   864: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: aastore
    //   868: dup
    //   869: bipush 13
    //   871: iload 15
    //   873: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   876: aastore
    //   877: dup
    //   878: bipush 14
    //   880: lload 16
    //   882: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   885: aastore
    //   886: dup
    //   887: bipush 15
    //   889: aload 10
    //   891: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   894: aastore
    //   895: dup
    //   896: bipush 16
    //   898: aload 28
    //   900: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: aastore
    //   904: dup
    //   905: bipush 17
    //   907: ldc 233
    //   909: aastore
    //   910: dup
    //   911: bipush 18
    //   913: iconst_0
    //   914: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   917: aastore
    //   918: dup
    //   919: bipush 19
    //   921: iload_3
    //   922: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   925: aastore
    //   926: dup
    //   927: bipush 20
    //   929: iload_2
    //   930: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   933: aastore
    //   934: invokespecial 234	com/tencent/mm/plugin/hardcoder/a:e	(I[Ljava/lang/Object;)V
    //   937: getstatic 31	com/tencent/mm/plugin/hardcoder/a:nGI	Z
    //   940: ifeq +327 -> 1267
    //   943: new 192	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   950: astore_1
    //   951: invokestatic 147	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   954: pop
    //   955: aload_1
    //   956: invokestatic 151	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   959: getfield 237	com/tencent/mm/kernel/e:eHQ	Ljava/lang/String;
    //   962: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: ldc 239
    //   967: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: astore_1
    //   974: iconst_1
    //   975: anewarray 215	java/lang/String
    //   978: dup
    //   979: iconst_0
    //   980: aload_1
    //   981: aastore
    //   982: invokestatic 245	com/tencent/mm/a/e:d	([Ljava/lang/String;)V
    //   985: new 247	java/io/File
    //   988: dup
    //   989: aload_1
    //   990: ldc 249
    //   992: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   995: astore_1
    //   996: aload_1
    //   997: invokevirtual 254	java/io/File:exists	()Z
    //   1000: ifne +8 -> 1008
    //   1003: aload_1
    //   1004: invokevirtual 257	java/io/File:createNewFile	()Z
    //   1007: pop
    //   1008: new 259	java/io/FileOutputStream
    //   1011: dup
    //   1012: aload_1
    //   1013: iconst_1
    //   1014: invokespecial 262	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1017: astore 10
    //   1019: aload 10
    //   1021: astore_1
    //   1022: aload 10
    //   1024: new 192	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   1031: aload 18
    //   1033: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: ldc_w 264
    //   1039: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: ldc_w 266
    //   1048: invokevirtual 270	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1051: invokevirtual 276	java/io/OutputStream:write	([B)V
    //   1054: aload 10
    //   1056: astore_1
    //   1057: aload 10
    //   1059: invokevirtual 279	java/io/OutputStream:flush	()V
    //   1062: aload 10
    //   1064: invokevirtual 282	java/io/OutputStream:close	()V
    //   1067: ldc 131
    //   1069: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1072: return
    //   1073: astore 10
    //   1075: ldc 90
    //   1077: new 192	java/lang/StringBuilder
    //   1080: dup
    //   1081: ldc_w 284
    //   1084: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1087: aload 10
    //   1089: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1092: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokestatic 231	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1101: goto -93 -> 1008
    //   1104: astore_1
    //   1105: ldc 90
    //   1107: new 192	java/lang/StringBuilder
    //   1110: dup
    //   1111: ldc_w 292
    //   1114: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1117: aload_1
    //   1118: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1121: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokestatic 231	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1130: ldc 131
    //   1132: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1135: return
    //   1136: astore 18
    //   1138: aconst_null
    //   1139: astore 10
    //   1141: aload 10
    //   1143: astore_1
    //   1144: ldc 90
    //   1146: new 192	java/lang/StringBuilder
    //   1149: dup
    //   1150: ldc_w 294
    //   1153: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1156: aload 18
    //   1158: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1161: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokestatic 231	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1170: aload 10
    //   1172: ifnull +95 -> 1267
    //   1175: aload 10
    //   1177: invokevirtual 282	java/io/OutputStream:close	()V
    //   1180: ldc 131
    //   1182: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1185: return
    //   1186: astore_1
    //   1187: ldc 90
    //   1189: new 192	java/lang/StringBuilder
    //   1192: dup
    //   1193: ldc_w 292
    //   1196: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1199: aload_1
    //   1200: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1203: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 231	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: ldc 131
    //   1214: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1217: return
    //   1218: astore 10
    //   1220: aconst_null
    //   1221: astore_1
    //   1222: aload_1
    //   1223: ifnull +7 -> 1230
    //   1226: aload_1
    //   1227: invokevirtual 282	java/io/OutputStream:close	()V
    //   1230: ldc 131
    //   1232: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1235: aload 10
    //   1237: athrow
    //   1238: astore_1
    //   1239: ldc 90
    //   1241: new 192	java/lang/StringBuilder
    //   1244: dup
    //   1245: ldc_w 292
    //   1248: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1251: aload_1
    //   1252: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1255: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 231	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1264: goto -34 -> 1230
    //   1267: ldc 131
    //   1269: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1272: return
    //   1273: astore 10
    //   1275: goto -53 -> 1222
    //   1278: astore 18
    //   1280: goto -139 -> 1141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1283	0	this	a
    //   0	1283	1	paramArrayOfInt1	int[]
    //   0	1283	2	paramInt1	int
    //   0	1283	3	paramInt2	int
    //   0	1283	4	paramInt3	int
    //   0	1283	5	paramInt4	int
    //   0	1283	6	paramLong1	long
    //   0	1283	8	paramInt5	int
    //   0	1283	9	paramInt6	int
    //   0	1283	10	paramArrayOfInt2	int[]
    //   0	1283	11	paramInt7	int
    //   0	1283	12	paramInt8	int
    //   0	1283	13	paramInt9	int
    //   0	1283	14	paramInt10	int
    //   0	1283	15	paramInt11	int
    //   0	1283	16	paramLong2	long
    //   0	1283	18	paramArrayOfInt3	int[]
    //   0	1283	19	paramArrayOfInt4	int[]
    //   31	749	20	i	int
    //   121	715	21	j	int
    //   118	219	22	k	int
    //   135	190	23	m	int
    //   99	673	24	n	int
    //   205	97	25	i1	int
    //   90	677	26	str	String
    //   108	630	27	localStringBuilder1	java.lang.StringBuilder
    //   231	668	28	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1003	1008	1073	java/lang/Exception
    //   1062	1067	1104	java/lang/Exception
    //   1008	1019	1136	java/lang/Exception
    //   1175	1180	1186	java/lang/Exception
    //   1008	1019	1218	finally
    //   1226	1230	1238	java/lang/Exception
    //   1022	1054	1273	finally
    //   1057	1062	1273	finally
    //   1144	1170	1273	finally
    //   1022	1054	1278	java/lang/Exception
    //   1057	1062	1278	java/lang/Exception
  }
  
  public final void reportInfo(j paramj)
  {
    AppMethodBeat.i(60246);
    long l1;
    if ((paramj instanceof l))
    {
      paramj = (l)paramj;
      ab.i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", new Object[] { Boolean.valueOf(paramj.eCY), Integer.valueOf(paramj.key), Integer.valueOf(paramj.value), Boolean.valueOf(paramj.cIg) });
      if (paramj.eCY) {}
      long l2;
      long l3;
      boolean bool;
      for (l1 = 678L;; l1 = 679L)
      {
        l2 = paramj.key;
        l3 = paramj.value;
        bool = paramj.cIg;
        if ((!ah.brt()) || (g.RJ().eHg)) {
          break;
        }
        ab.w("MicroMsg.HardCoderReporterImpl", "idkeyStat accountNotInitialReady!");
        this.mQa.alive();
        this.nGL.add(new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool) });
        AppMethodBeat.o(60246);
        return;
      }
      h.qsU.idkeyStat(l1, l2, l3, bool);
      AppMethodBeat.o(60246);
      return;
    }
    if ((paramj instanceof k))
    {
      paramj = (k)paramj;
      if (nGH == null)
      {
        g.RM();
        nGH = (Long)g.RL().Ru().get(ac.a.yFg, Long.valueOf(0L));
      }
      if (TextUtils.isEmpty(nGG)) {
        nGG = q.bP(false);
      }
      String str = nGG;
      int k = (int)nGH.longValue();
      int i;
      int m;
      if (WXHardCoderJNI.isHCEnable())
      {
        i = 1;
        m = WXHardCoderJNI.isRunning();
        if (!WXHardCoderJNI.getEnable()) {
          break label567;
        }
      }
      label567:
      for (int j = 1;; j = 0)
      {
        if (paramj.type == 1)
        {
          l1 = paramj.eCX * 100L / paramj.interval;
          e(15187, new Object[] { str, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(paramj.scene), Long.valueOf(paramj.eBR), Integer.valueOf(paramj.type), Long.valueOf(paramj.eCX), Long.valueOf(paramj.interval), Long.valueOf(l1), Integer.valueOf(j) });
          ab.i("MicroMsg.HardCoderReporterImpl", String.format("fpsReport imei:%s enable:%s, heavy:%s speedUp:%s, engineStatus:%s, scene:%s, action:%s, type:%s, totalDroppedFrames:%s, interval:%s, average:%s", new Object[] { str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(paramj.scene), Long.valueOf(paramj.eBR), Integer.valueOf(paramj.type), Long.valueOf(paramj.eCX), Long.valueOf(paramj.interval), Long.valueOf(l1) }));
        }
        AppMethodBeat.o(60246);
        return;
        i = 0;
        break;
      }
    }
    if ((paramj instanceof m)) {
      e(16509, new Object[0]);
    }
    AppMethodBeat.o(60246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.a
 * JD-Core Version:    0.7.0.1
 */