package com.tencent.mm.plugin.misc.b;

import android.os.Handler;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class a
  implements f, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static volatile a oEk;
  private Handler mHandler;
  
  public a()
  {
    AppMethodBeat.i(50505);
    this.mHandler = new Handler();
    AppMethodBeat.o(50505);
  }
  
  public static a bQk()
  {
    try
    {
      AppMethodBeat.i(50506);
      if (oEk == null) {
        oEk = new a();
      }
      a locala = oEk;
      AppMethodBeat.o(50506);
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private static List<a.a> ew(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 47
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 49	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 50	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: ldc 52
    //   19: invokevirtual 58	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 60	android/telephony/TelephonyManager
    //   25: astore_0
    //   26: getstatic 66	android/os/Build$VERSION:SDK_INT	I
    //   29: istore_2
    //   30: aload_0
    //   31: invokevirtual 70	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull +263 -> 299
    //   39: aload_0
    //   40: invokeinterface 76 1 0
    //   45: astore_0
    //   46: aload_0
    //   47: invokeinterface 82 1 0
    //   52: ifeq +247 -> 299
    //   55: aload_0
    //   56: invokeinterface 86 1 0
    //   61: checkcast 88	android/telephony/CellInfo
    //   64: astore 4
    //   66: new 12	com/tencent/mm/plugin/misc/b/a$a
    //   69: dup
    //   70: invokespecial 89	com/tencent/mm/plugin/misc/b/a$a:<init>	()V
    //   73: astore 5
    //   75: aload 4
    //   77: instanceof 91
    //   80: ifeq +229 -> 309
    //   83: aload 4
    //   85: checkcast 91	android/telephony/CellInfoGsm
    //   88: invokevirtual 95	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   91: astore 6
    //   93: aload 4
    //   95: checkcast 91	android/telephony/CellInfoGsm
    //   98: invokevirtual 99	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   101: astore 7
    //   103: aload 7
    //   105: invokevirtual 105	android/telephony/CellIdentityGsm:getMnc	()I
    //   108: istore_1
    //   109: aload 5
    //   111: new 107	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   118: aload 7
    //   120: invokevirtual 111	android/telephony/CellIdentityGsm:getCid	()I
    //   123: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: putfield 123	com/tencent/mm/plugin/misc/b/a$a:oEo	Ljava/lang/String;
    //   132: aload 5
    //   134: new 107	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   141: aload 7
    //   143: invokevirtual 126	android/telephony/CellIdentityGsm:getMcc	()I
    //   146: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: putfield 129	com/tencent/mm/plugin/misc/b/a$a:oEm	Ljava/lang/String;
    //   155: aload 5
    //   157: new 107	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   164: aload 7
    //   166: invokevirtual 105	android/telephony/CellIdentityGsm:getMnc	()I
    //   169: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: putfield 132	com/tencent/mm/plugin/misc/b/a$a:oEn	Ljava/lang/String;
    //   178: aload 5
    //   180: new 107	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   187: aload 7
    //   189: invokevirtual 135	android/telephony/CellIdentityGsm:getLac	()I
    //   192: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: putfield 138	com/tencent/mm/plugin/misc/b/a$a:oEp	Ljava/lang/String;
    //   201: aload 5
    //   203: aload 6
    //   205: invokevirtual 143	android/telephony/CellSignalStrengthGsm:getDbm	()I
    //   208: putfield 146	com/tencent/mm/plugin/misc/b/a$a:oEq	I
    //   211: aload 5
    //   213: aload 4
    //   215: invokevirtual 149	android/telephony/CellInfo:isRegistered	()Z
    //   218: putfield 153	com/tencent/mm/plugin/misc/b/a$a:hVn	Z
    //   221: aload 5
    //   223: ldc 155
    //   225: putfield 158	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   228: aload 5
    //   230: getfield 132	com/tencent/mm/plugin/misc/b/a$a:oEn	Ljava/lang/String;
    //   233: invokevirtual 163	java/lang/String:length	()I
    //   236: iconst_1
    //   237: if_icmpne +28 -> 265
    //   240: aload 5
    //   242: new 107	java/lang/StringBuilder
    //   245: dup
    //   246: ldc 165
    //   248: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: aload 5
    //   253: getfield 132	com/tencent/mm/plugin/misc/b/a$a:oEn	Ljava/lang/String;
    //   256: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: putfield 132	com/tencent/mm/plugin/misc/b/a$a:oEn	Ljava/lang/String;
    //   265: iload_1
    //   266: ldc 172
    //   268: if_icmpeq -222 -> 46
    //   271: aload_3
    //   272: aload 5
    //   274: invokeinterface 176 2 0
    //   279: pop
    //   280: goto -234 -> 46
    //   283: astore_0
    //   284: ldc 178
    //   286: ldc 180
    //   288: iconst_1
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload_0
    //   295: aastore
    //   296: invokestatic 186	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: ldc 47
    //   301: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: ldc 2
    //   306: monitorexit
    //   307: aload_3
    //   308: areturn
    //   309: aload 4
    //   311: instanceof 188
    //   314: ifeq +128 -> 442
    //   317: aload 4
    //   319: checkcast 188	android/telephony/CellInfoCdma
    //   322: invokevirtual 191	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   325: astore 6
    //   327: aload 4
    //   329: checkcast 188	android/telephony/CellInfoCdma
    //   332: invokevirtual 194	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   335: astore 7
    //   337: aload 7
    //   339: invokevirtual 199	android/telephony/CellIdentityCdma:getSystemId	()I
    //   342: istore_1
    //   343: aload 5
    //   345: new 107	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   352: aload 7
    //   354: invokevirtual 202	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   357: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: putfield 123	com/tencent/mm/plugin/misc/b/a$a:oEo	Ljava/lang/String;
    //   366: aload 5
    //   368: new 107	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   375: aload 7
    //   377: invokevirtual 199	android/telephony/CellIdentityCdma:getSystemId	()I
    //   380: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: putfield 132	com/tencent/mm/plugin/misc/b/a$a:oEn	Ljava/lang/String;
    //   389: aload 5
    //   391: new 107	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   398: aload 7
    //   400: invokevirtual 205	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   403: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: putfield 138	com/tencent/mm/plugin/misc/b/a$a:oEp	Ljava/lang/String;
    //   412: aload 5
    //   414: aload 6
    //   416: invokevirtual 208	android/telephony/CellSignalStrengthCdma:getDbm	()I
    //   419: putfield 146	com/tencent/mm/plugin/misc/b/a$a:oEq	I
    //   422: aload 5
    //   424: aload 4
    //   426: invokevirtual 149	android/telephony/CellInfo:isRegistered	()Z
    //   429: putfield 153	com/tencent/mm/plugin/misc/b/a$a:hVn	Z
    //   432: aload 5
    //   434: ldc 210
    //   436: putfield 158	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   439: goto -211 -> 228
    //   442: aload 4
    //   444: instanceof 212
    //   447: ifeq +151 -> 598
    //   450: aload 4
    //   452: checkcast 212	android/telephony/CellInfoLte
    //   455: invokevirtual 215	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   458: astore 6
    //   460: aload 4
    //   462: checkcast 212	android/telephony/CellInfoLte
    //   465: invokevirtual 218	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   468: astore 7
    //   470: aload 7
    //   472: invokevirtual 221	android/telephony/CellIdentityLte:getMnc	()I
    //   475: istore_1
    //   476: aload 5
    //   478: new 107	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   485: aload 7
    //   487: invokevirtual 224	android/telephony/CellIdentityLte:getCi	()I
    //   490: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: putfield 123	com/tencent/mm/plugin/misc/b/a$a:oEo	Ljava/lang/String;
    //   499: aload 5
    //   501: new 107	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   508: aload 7
    //   510: invokevirtual 225	android/telephony/CellIdentityLte:getMcc	()I
    //   513: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: putfield 129	com/tencent/mm/plugin/misc/b/a$a:oEm	Ljava/lang/String;
    //   522: aload 5
    //   524: new 107	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   531: aload 7
    //   533: invokevirtual 221	android/telephony/CellIdentityLte:getMnc	()I
    //   536: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   539: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: putfield 132	com/tencent/mm/plugin/misc/b/a$a:oEn	Ljava/lang/String;
    //   545: aload 5
    //   547: new 107	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   554: aload 7
    //   556: invokevirtual 228	android/telephony/CellIdentityLte:getTac	()I
    //   559: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: putfield 138	com/tencent/mm/plugin/misc/b/a$a:oEp	Ljava/lang/String;
    //   568: aload 5
    //   570: aload 6
    //   572: invokevirtual 231	android/telephony/CellSignalStrengthLte:getDbm	()I
    //   575: putfield 146	com/tencent/mm/plugin/misc/b/a$a:oEq	I
    //   578: aload 5
    //   580: aload 4
    //   582: invokevirtual 149	android/telephony/CellInfo:isRegistered	()Z
    //   585: putfield 153	com/tencent/mm/plugin/misc/b/a$a:hVn	Z
    //   588: aload 5
    //   590: ldc 233
    //   592: putfield 158	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   595: goto -367 -> 228
    //   598: iload_2
    //   599: bipush 18
    //   601: if_icmplt +159 -> 760
    //   604: aload 4
    //   606: instanceof 235
    //   609: ifeq +151 -> 760
    //   612: aload 4
    //   614: checkcast 235	android/telephony/CellInfoWcdma
    //   617: invokevirtual 238	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   620: astore 6
    //   622: aload 4
    //   624: checkcast 235	android/telephony/CellInfoWcdma
    //   627: invokevirtual 241	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   630: astore 7
    //   632: aload 7
    //   634: invokevirtual 244	android/telephony/CellIdentityWcdma:getMnc	()I
    //   637: istore_1
    //   638: aload 5
    //   640: new 107	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   647: aload 7
    //   649: invokevirtual 245	android/telephony/CellIdentityWcdma:getCid	()I
    //   652: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   655: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: putfield 123	com/tencent/mm/plugin/misc/b/a$a:oEo	Ljava/lang/String;
    //   661: aload 5
    //   663: new 107	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   670: aload 7
    //   672: invokevirtual 246	android/telephony/CellIdentityWcdma:getMcc	()I
    //   675: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   678: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: putfield 129	com/tencent/mm/plugin/misc/b/a$a:oEm	Ljava/lang/String;
    //   684: aload 5
    //   686: new 107	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   693: aload 7
    //   695: invokevirtual 244	android/telephony/CellIdentityWcdma:getMnc	()I
    //   698: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   701: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: putfield 132	com/tencent/mm/plugin/misc/b/a$a:oEn	Ljava/lang/String;
    //   707: aload 5
    //   709: new 107	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   716: aload 7
    //   718: invokevirtual 247	android/telephony/CellIdentityWcdma:getLac	()I
    //   721: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   724: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: putfield 138	com/tencent/mm/plugin/misc/b/a$a:oEp	Ljava/lang/String;
    //   730: aload 5
    //   732: aload 6
    //   734: invokevirtual 250	android/telephony/CellSignalStrengthWcdma:getDbm	()I
    //   737: putfield 146	com/tencent/mm/plugin/misc/b/a$a:oEq	I
    //   740: aload 5
    //   742: aload 4
    //   744: invokevirtual 149	android/telephony/CellInfo:isRegistered	()Z
    //   747: putfield 153	com/tencent/mm/plugin/misc/b/a$a:hVn	Z
    //   750: aload 5
    //   752: ldc 252
    //   754: putfield 158	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   757: goto -529 -> 228
    //   760: ldc 178
    //   762: new 107	java/lang/StringBuilder
    //   765: dup
    //   766: ldc 254
    //   768: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   771: aload 4
    //   773: invokevirtual 258	java/lang/Object:getClass	()Ljava/lang/Class;
    //   776: invokevirtual 263	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   779: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc_w 265
    //   785: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload 4
    //   790: invokevirtual 266	android/telephony/CellInfo:toString	()Ljava/lang/String;
    //   793: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: iconst_0
    //   803: istore_1
    //   804: goto -576 -> 228
    //   807: astore_0
    //   808: ldc 2
    //   810: monitorexit
    //   811: aload_0
    //   812: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	813	0	paramContext	android.content.Context
    //   108	696	1	i	int
    //   29	573	2	j	int
    //   15	293	3	localLinkedList	java.util.LinkedList
    //   64	725	4	localCellInfo	android.telephony.CellInfo
    //   73	678	5	locala	a.a
    //   91	642	6	localObject1	Object
    //   101	616	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	35	283	java/lang/Exception
    //   39	46	283	java/lang/Exception
    //   46	228	283	java/lang/Exception
    //   228	265	283	java/lang/Exception
    //   271	280	283	java/lang/Exception
    //   309	439	283	java/lang/Exception
    //   442	595	283	java/lang/Exception
    //   604	757	283	java/lang/Exception
    //   760	802	283	java/lang/Exception
    //   3	30	807	finally
    //   30	35	807	finally
    //   39	46	807	finally
    //   46	228	807	finally
    //   228	265	807	finally
    //   271	280	807	finally
    //   284	299	807	finally
    //   299	304	807	finally
    //   309	439	807	finally
    //   442	595	807	finally
    //   604	757	807	finally
    //   760	802	807	finally
  }
  
  public static void z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(50510);
    for (;;)
    {
      boolean bool;
      int i;
      int j;
      long l;
      try
      {
        bool = at.isMobile(ah.getContext());
        if (!bool)
        {
          AppMethodBeat.o(50510);
          return;
        }
        i = b.checkSelfPermission(ah.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
        if (i != 0)
        {
          AppMethodBeat.o(50510);
          return;
        }
        if ((paramInt2 != 0) || (paramInt3 != 0)) {
          break label548;
        }
        bool = true;
        Object localObject2 = ew(ah.getContext());
        i = ((List)localObject2).size();
        if (i == 0)
        {
          AppMethodBeat.o(50510);
          return;
        }
        Object localObject1 = (a.a)((List)localObject2).get(0);
        Object localObject3 = ((List)localObject2).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label545;
        }
        localObject2 = (a.a)((Iterator)localObject3).next();
        if (!((a.a)localObject2).hVn) {
          continue;
        }
        localObject1 = localObject2;
        localObject2 = ((a.a)localObject1).oEm;
        localObject3 = ((a.a)localObject1).oEn;
        String str1 = ((a.a)localObject1).oEp;
        String str2 = ((a.a)localObject1).oEo;
        String str3 = ((a.a)localObject1).type;
        int k = ((a.a)localObject1).oEq;
        if (paramInt1 == 1)
        {
          i = 3;
          ab.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(k), Integer.valueOf(paramInt1), Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i) });
          localObject1 = h.qsU;
          if (!bool) {
            break label489;
          }
          j = 0;
          localObject1 = h.t(new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i) });
          if (!ah.brt()) {
            break label520;
          }
          if (!com.tencent.mm.plugin.report.a.c.qrL) {
            break label495;
          }
          l = i;
          bool = com.tencent.mm.plugin.report.a.c.qrM;
          e.a(15608L, l, (String)localObject1, bool, bool, false);
          AppMethodBeat.o(50510);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.NetworkOptReport", "getNetType : %s", new Object[] { bo.l(localException) });
        AppMethodBeat.o(50510);
        return;
      }
      if (!bool)
      {
        i = 2;
        continue;
        label489:
        j = 1;
        continue;
        label495:
        l = i;
        e.a(15608L, l, localException, false, false, false);
        AppMethodBeat.o(50510);
        return;
        label520:
        h.a(15608, i, localException, false, false);
        AppMethodBeat.o(50510);
      }
      else
      {
        i = 1;
        continue;
        label545:
        continue;
        label548:
        bool = false;
      }
    }
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(50507);
    g.Rc().a(-1, this);
    AppMethodBeat.o(50507);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(50508);
    g.Rc().b(-1, this);
    AppMethodBeat.o(50508);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(50509);
    if ((paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      AppMethodBeat.o(50509);
      return;
    }
    this.mHandler.post(new a.1(this, paramm, paramInt1, paramInt2));
    AppMethodBeat.o(50509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a
 * JD-Core Version:    0.7.0.1
 */