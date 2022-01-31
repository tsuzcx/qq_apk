package com.tencent.mm.plugin.misc.b;

import android.os.Handler;
import android.support.v4.content.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class a
  implements f, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static volatile a mdO;
  private Handler mHandler = new Handler();
  
  public static a bij()
  {
    try
    {
      if (mdO == null) {
        mdO = new a();
      }
      a locala = mdO;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private static List<a.a> dK(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 37	java/util/LinkedList
    //   6: dup
    //   7: invokespecial 38	java/util/LinkedList:<init>	()V
    //   10: astore_3
    //   11: aload_0
    //   12: ldc 40
    //   14: invokevirtual 46	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 48	android/telephony/TelephonyManager
    //   20: astore_0
    //   21: getstatic 54	android/os/Build$VERSION:SDK_INT	I
    //   24: istore_2
    //   25: aload_0
    //   26: invokevirtual 58	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +263 -> 294
    //   34: aload_0
    //   35: invokeinterface 64 1 0
    //   40: astore_0
    //   41: aload_0
    //   42: invokeinterface 70 1 0
    //   47: ifeq +247 -> 294
    //   50: aload_0
    //   51: invokeinterface 74 1 0
    //   56: checkcast 76	android/telephony/CellInfo
    //   59: astore 4
    //   61: new 12	com/tencent/mm/plugin/misc/b/a$a
    //   64: dup
    //   65: invokespecial 77	com/tencent/mm/plugin/misc/b/a$a:<init>	()V
    //   68: astore 5
    //   70: aload 4
    //   72: instanceof 79
    //   75: ifeq +224 -> 299
    //   78: aload 4
    //   80: checkcast 79	android/telephony/CellInfoGsm
    //   83: invokevirtual 83	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   86: astore 6
    //   88: aload 4
    //   90: checkcast 79	android/telephony/CellInfoGsm
    //   93: invokevirtual 87	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   96: astore 7
    //   98: aload 7
    //   100: invokevirtual 93	android/telephony/CellIdentityGsm:getMnc	()I
    //   103: istore_1
    //   104: aload 5
    //   106: new 95	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   113: aload 7
    //   115: invokevirtual 99	android/telephony/CellIdentityGsm:getCid	()I
    //   118: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: putfield 111	com/tencent/mm/plugin/misc/b/a$a:mdS	Ljava/lang/String;
    //   127: aload 5
    //   129: new 95	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   136: aload 7
    //   138: invokevirtual 114	android/telephony/CellIdentityGsm:getMcc	()I
    //   141: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: putfield 117	com/tencent/mm/plugin/misc/b/a$a:mdQ	Ljava/lang/String;
    //   150: aload 5
    //   152: new 95	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   159: aload 7
    //   161: invokevirtual 93	android/telephony/CellIdentityGsm:getMnc	()I
    //   164: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: putfield 120	com/tencent/mm/plugin/misc/b/a$a:mdR	Ljava/lang/String;
    //   173: aload 5
    //   175: new 95	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   182: aload 7
    //   184: invokevirtual 123	android/telephony/CellIdentityGsm:getLac	()I
    //   187: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: putfield 126	com/tencent/mm/plugin/misc/b/a$a:mdT	Ljava/lang/String;
    //   196: aload 5
    //   198: aload 6
    //   200: invokevirtual 131	android/telephony/CellSignalStrengthGsm:getDbm	()I
    //   203: putfield 134	com/tencent/mm/plugin/misc/b/a$a:mdU	I
    //   206: aload 5
    //   208: aload 4
    //   210: invokevirtual 137	android/telephony/CellInfo:isRegistered	()Z
    //   213: putfield 141	com/tencent/mm/plugin/misc/b/a$a:gyD	Z
    //   216: aload 5
    //   218: ldc 143
    //   220: putfield 146	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   223: aload 5
    //   225: getfield 120	com/tencent/mm/plugin/misc/b/a$a:mdR	Ljava/lang/String;
    //   228: invokevirtual 151	java/lang/String:length	()I
    //   231: iconst_1
    //   232: if_icmpne +28 -> 260
    //   235: aload 5
    //   237: new 95	java/lang/StringBuilder
    //   240: dup
    //   241: ldc 153
    //   243: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload 5
    //   248: getfield 120	com/tencent/mm/plugin/misc/b/a$a:mdR	Ljava/lang/String;
    //   251: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: putfield 120	com/tencent/mm/plugin/misc/b/a$a:mdR	Ljava/lang/String;
    //   260: iload_1
    //   261: ldc 160
    //   263: if_icmpeq -222 -> 41
    //   266: aload_3
    //   267: aload 5
    //   269: invokeinterface 164 2 0
    //   274: pop
    //   275: goto -234 -> 41
    //   278: astore_0
    //   279: ldc 166
    //   281: ldc 168
    //   283: iconst_1
    //   284: anewarray 4	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload_0
    //   290: aastore
    //   291: invokestatic 174	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: ldc 2
    //   296: monitorexit
    //   297: aload_3
    //   298: areturn
    //   299: aload 4
    //   301: instanceof 176
    //   304: ifeq +128 -> 432
    //   307: aload 4
    //   309: checkcast 176	android/telephony/CellInfoCdma
    //   312: invokevirtual 179	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   315: astore 6
    //   317: aload 4
    //   319: checkcast 176	android/telephony/CellInfoCdma
    //   322: invokevirtual 182	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   325: astore 7
    //   327: aload 7
    //   329: invokevirtual 187	android/telephony/CellIdentityCdma:getSystemId	()I
    //   332: istore_1
    //   333: aload 5
    //   335: new 95	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   342: aload 7
    //   344: invokevirtual 190	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   347: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: putfield 111	com/tencent/mm/plugin/misc/b/a$a:mdS	Ljava/lang/String;
    //   356: aload 5
    //   358: new 95	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   365: aload 7
    //   367: invokevirtual 187	android/telephony/CellIdentityCdma:getSystemId	()I
    //   370: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: putfield 120	com/tencent/mm/plugin/misc/b/a$a:mdR	Ljava/lang/String;
    //   379: aload 5
    //   381: new 95	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   388: aload 7
    //   390: invokevirtual 193	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   393: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: putfield 126	com/tencent/mm/plugin/misc/b/a$a:mdT	Ljava/lang/String;
    //   402: aload 5
    //   404: aload 6
    //   406: invokevirtual 196	android/telephony/CellSignalStrengthCdma:getDbm	()I
    //   409: putfield 134	com/tencent/mm/plugin/misc/b/a$a:mdU	I
    //   412: aload 5
    //   414: aload 4
    //   416: invokevirtual 137	android/telephony/CellInfo:isRegistered	()Z
    //   419: putfield 141	com/tencent/mm/plugin/misc/b/a$a:gyD	Z
    //   422: aload 5
    //   424: ldc 198
    //   426: putfield 146	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   429: goto -206 -> 223
    //   432: aload 4
    //   434: instanceof 200
    //   437: ifeq +151 -> 588
    //   440: aload 4
    //   442: checkcast 200	android/telephony/CellInfoLte
    //   445: invokevirtual 203	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   448: astore 6
    //   450: aload 4
    //   452: checkcast 200	android/telephony/CellInfoLte
    //   455: invokevirtual 206	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   458: astore 7
    //   460: aload 7
    //   462: invokevirtual 209	android/telephony/CellIdentityLte:getMnc	()I
    //   465: istore_1
    //   466: aload 5
    //   468: new 95	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   475: aload 7
    //   477: invokevirtual 212	android/telephony/CellIdentityLte:getCi	()I
    //   480: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: putfield 111	com/tencent/mm/plugin/misc/b/a$a:mdS	Ljava/lang/String;
    //   489: aload 5
    //   491: new 95	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   498: aload 7
    //   500: invokevirtual 213	android/telephony/CellIdentityLte:getMcc	()I
    //   503: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: putfield 117	com/tencent/mm/plugin/misc/b/a$a:mdQ	Ljava/lang/String;
    //   512: aload 5
    //   514: new 95	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   521: aload 7
    //   523: invokevirtual 209	android/telephony/CellIdentityLte:getMnc	()I
    //   526: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: putfield 120	com/tencent/mm/plugin/misc/b/a$a:mdR	Ljava/lang/String;
    //   535: aload 5
    //   537: new 95	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   544: aload 7
    //   546: invokevirtual 216	android/telephony/CellIdentityLte:getTac	()I
    //   549: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   552: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: putfield 126	com/tencent/mm/plugin/misc/b/a$a:mdT	Ljava/lang/String;
    //   558: aload 5
    //   560: aload 6
    //   562: invokevirtual 219	android/telephony/CellSignalStrengthLte:getDbm	()I
    //   565: putfield 134	com/tencent/mm/plugin/misc/b/a$a:mdU	I
    //   568: aload 5
    //   570: aload 4
    //   572: invokevirtual 137	android/telephony/CellInfo:isRegistered	()Z
    //   575: putfield 141	com/tencent/mm/plugin/misc/b/a$a:gyD	Z
    //   578: aload 5
    //   580: ldc 221
    //   582: putfield 146	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   585: goto -362 -> 223
    //   588: iload_2
    //   589: bipush 18
    //   591: if_icmplt +159 -> 750
    //   594: aload 4
    //   596: instanceof 223
    //   599: ifeq +151 -> 750
    //   602: aload 4
    //   604: checkcast 223	android/telephony/CellInfoWcdma
    //   607: invokevirtual 226	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   610: astore 6
    //   612: aload 4
    //   614: checkcast 223	android/telephony/CellInfoWcdma
    //   617: invokevirtual 229	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   620: astore 7
    //   622: aload 7
    //   624: invokevirtual 232	android/telephony/CellIdentityWcdma:getMnc	()I
    //   627: istore_1
    //   628: aload 5
    //   630: new 95	java/lang/StringBuilder
    //   633: dup
    //   634: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   637: aload 7
    //   639: invokevirtual 233	android/telephony/CellIdentityWcdma:getCid	()I
    //   642: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   645: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: putfield 111	com/tencent/mm/plugin/misc/b/a$a:mdS	Ljava/lang/String;
    //   651: aload 5
    //   653: new 95	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   660: aload 7
    //   662: invokevirtual 234	android/telephony/CellIdentityWcdma:getMcc	()I
    //   665: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: putfield 117	com/tencent/mm/plugin/misc/b/a$a:mdQ	Ljava/lang/String;
    //   674: aload 5
    //   676: new 95	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   683: aload 7
    //   685: invokevirtual 232	android/telephony/CellIdentityWcdma:getMnc	()I
    //   688: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: putfield 120	com/tencent/mm/plugin/misc/b/a$a:mdR	Ljava/lang/String;
    //   697: aload 5
    //   699: new 95	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   706: aload 7
    //   708: invokevirtual 235	android/telephony/CellIdentityWcdma:getLac	()I
    //   711: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   714: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: putfield 126	com/tencent/mm/plugin/misc/b/a$a:mdT	Ljava/lang/String;
    //   720: aload 5
    //   722: aload 6
    //   724: invokevirtual 238	android/telephony/CellSignalStrengthWcdma:getDbm	()I
    //   727: putfield 134	com/tencent/mm/plugin/misc/b/a$a:mdU	I
    //   730: aload 5
    //   732: aload 4
    //   734: invokevirtual 137	android/telephony/CellInfo:isRegistered	()Z
    //   737: putfield 141	com/tencent/mm/plugin/misc/b/a$a:gyD	Z
    //   740: aload 5
    //   742: ldc 240
    //   744: putfield 146	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   747: goto -524 -> 223
    //   750: ldc 166
    //   752: new 95	java/lang/StringBuilder
    //   755: dup
    //   756: ldc 242
    //   758: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   761: aload 4
    //   763: invokevirtual 246	java/lang/Object:getClass	()Ljava/lang/Class;
    //   766: invokevirtual 251	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   769: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: ldc 253
    //   774: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload 4
    //   779: invokevirtual 254	android/telephony/CellInfo:toString	()Ljava/lang/String;
    //   782: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 258	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: iconst_0
    //   792: istore_1
    //   793: goto -570 -> 223
    //   796: astore_0
    //   797: ldc 2
    //   799: monitorexit
    //   800: aload_0
    //   801: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	802	0	paramContext	android.content.Context
    //   103	690	1	i	int
    //   24	568	2	j	int
    //   10	288	3	localLinkedList	java.util.LinkedList
    //   59	719	4	localCellInfo	android.telephony.CellInfo
    //   68	673	5	locala	a.a
    //   86	637	6	localObject1	Object
    //   96	611	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	30	278	java/lang/Exception
    //   34	41	278	java/lang/Exception
    //   41	223	278	java/lang/Exception
    //   223	260	278	java/lang/Exception
    //   266	275	278	java/lang/Exception
    //   299	429	278	java/lang/Exception
    //   432	585	278	java/lang/Exception
    //   594	747	278	java/lang/Exception
    //   750	791	278	java/lang/Exception
    //   3	25	796	finally
    //   25	30	796	finally
    //   34	41	796	finally
    //   41	223	796	finally
    //   223	260	796	finally
    //   266	275	796	finally
    //   279	294	796	finally
    //   299	429	796	finally
    //   432	585	796	finally
    //   594	747	796	finally
    //   750	791	796	finally
  }
  
  public static void t(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      boolean bool;
      int i;
      int j;
      try
      {
        if (!aq.isMobile(ae.getContext())) {
          return;
        }
        if (b.checkSelfPermission(ae.getContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
          break;
        }
        if ((paramInt2 != 0) || (paramInt3 != 0)) {
          break label424;
        }
        bool = true;
        Object localObject2 = dK(ae.getContext());
        if (((List)localObject2).size() == 0) {
          break;
        }
        Object localObject1 = (a.a)((List)localObject2).get(0);
        Object localObject3 = ((List)localObject2).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label421;
        }
        localObject2 = (a.a)((Iterator)localObject3).next();
        if (!((a.a)localObject2).gyD) {
          continue;
        }
        localObject1 = localObject2;
        localObject2 = ((a.a)localObject1).mdQ;
        localObject3 = ((a.a)localObject1).mdR;
        String str1 = ((a.a)localObject1).mdT;
        String str2 = ((a.a)localObject1).mdS;
        String str3 = ((a.a)localObject1).type;
        int k = ((a.a)localObject1).mdU;
        if (paramInt1 == 1)
        {
          i = 3;
          y.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(k), Integer.valueOf(paramInt1), Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i) });
          localObject1 = h.nFQ;
          if (!bool) {
            break label409;
          }
          j = 0;
          h.d(15608, i, h.o(new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i) }), false);
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.NetworkOptReport", "getNetType : %s", new Object[] { bk.j(localException) });
        return;
      }
      if (!bool)
      {
        i = 2;
        continue;
        label409:
        j = 1;
      }
      else
      {
        i = 1;
        continue;
        label421:
        continue;
        label424:
        bool = false;
      }
    }
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    g.Dk().a(-1, this);
  }
  
  public final void onAccountRelease()
  {
    g.Dk().b(-1, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramString != null) && (paramString.startsWith("autoauth_errmsg_"))) {
      return;
    }
    this.mHandler.post(new a.1(this, paramm, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a
 * JD-Core Version:    0.7.0.1
 */