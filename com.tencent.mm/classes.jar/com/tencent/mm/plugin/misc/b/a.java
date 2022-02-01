package com.tencent.mm.plugin.misc.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class a
  implements i, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static volatile a EWB;
  private Handler mHandler;
  
  public a()
  {
    AppMethodBeat.i(127606);
    this.mHandler = new Handler();
    AppMethodBeat.o(127606);
  }
  
  public static void as(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(161885);
    for (;;)
    {
      try
      {
        bool = NetStatusUtil.isMobile(MMApplicationContext.getContext());
        if (!bool)
        {
          AppMethodBeat.o(161885);
          return;
        }
        int i = androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION");
        if (i != 0)
        {
          AppMethodBeat.o(161885);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bool = true;
          Object localObject2 = hu(MMApplicationContext.getContext());
          i = ((List)localObject2).size();
          if (i == 0)
          {
            AppMethodBeat.o(161885);
            return;
          }
          Object localObject1 = (a)((List)localObject2).get(0);
          Object localObject3 = ((List)localObject2).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject2 = (a)((Iterator)localObject3).next();
            if (!((a)localObject2).phH) {
              continue;
            }
            localObject1 = localObject2;
            localObject2 = ((a)localObject1).mcc;
            localObject3 = ((a)localObject1).mnc;
            String str1 = ((a)localObject1).EWD;
            String str2 = ((a)localObject1).cellid;
            String str3 = ((a)localObject1).type;
            int j = ((a)localObject1).EWE;
            Log.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(j), Integer.valueOf(1), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(3) });
            localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
            if (bool)
            {
              i = 0;
              ((com.tencent.mm.plugin.report.service.h)localObject1).a(15608, 3, new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(3) });
              AppMethodBeat.o(161885);
              return;
            }
            i = 1;
            continue;
          }
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.NetworkOptReport", "getNetType : %s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(161885);
        return;
      }
      boolean bool = false;
    }
  }
  
  public static a eSC()
  {
    try
    {
      AppMethodBeat.i(127607);
      if (EWB == null) {
        EWB = new a();
      }
      a locala = EWB;
      AppMethodBeat.o(127607);
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private static List<a> hu(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 161
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 163	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 164	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: ldc 166
    //   19: invokevirtual 172	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 174	android/telephony/TelephonyManager
    //   25: astore_0
    //   26: getstatic 179	android/os/Build$VERSION:SDK_INT	I
    //   29: istore_2
    //   30: aload_0
    //   31: ldc 181
    //   33: ldc 183
    //   35: ldc 184
    //   37: ldc 185
    //   39: ldc 187
    //   41: ldc 189
    //   43: invokestatic 194	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   46: checkcast 68	java/util/List
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull +265 -> 316
    //   54: aload_0
    //   55: invokeinterface 80 1 0
    //   60: astore_0
    //   61: aload_0
    //   62: invokeinterface 86 1 0
    //   67: ifeq +249 -> 316
    //   70: aload_0
    //   71: invokeinterface 90 1 0
    //   76: checkcast 196	android/telephony/CellInfo
    //   79: astore 4
    //   81: new 12	com/tencent/mm/plugin/misc/b/a$a
    //   84: dup
    //   85: invokespecial 197	com/tencent/mm/plugin/misc/b/a$a:<init>	()V
    //   88: astore 5
    //   90: aload 4
    //   92: instanceof 199
    //   95: ifeq +231 -> 326
    //   98: aload 4
    //   100: checkcast 199	android/telephony/CellInfoGsm
    //   103: invokevirtual 203	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   106: astore 6
    //   108: aload 4
    //   110: checkcast 199	android/telephony/CellInfoGsm
    //   113: invokevirtual 207	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   116: astore 7
    //   118: aload 7
    //   120: invokevirtual 212	android/telephony/CellIdentityGsm:getMnc	()I
    //   123: istore_1
    //   124: aload 5
    //   126: new 214	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   133: aload 7
    //   135: invokevirtual 218	android/telephony/CellIdentityGsm:getCid	()I
    //   138: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: putfield 107	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   147: aload 5
    //   149: new 214	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   156: aload 7
    //   158: invokevirtual 229	android/telephony/CellIdentityGsm:getMcc	()I
    //   161: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: putfield 98	com/tencent/mm/plugin/misc/b/a$a:mcc	Ljava/lang/String;
    //   170: aload 5
    //   172: new 214	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   179: aload 7
    //   181: invokevirtual 212	android/telephony/CellIdentityGsm:getMnc	()I
    //   184: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: putfield 101	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   193: aload 5
    //   195: new 214	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   202: aload 7
    //   204: invokevirtual 232	android/telephony/CellIdentityGsm:getLac	()I
    //   207: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: putfield 104	com/tencent/mm/plugin/misc/b/a$a:EWD	Ljava/lang/String;
    //   216: aload 5
    //   218: aload 6
    //   220: invokevirtual 237	android/telephony/CellSignalStrengthGsm:getDbm	()I
    //   223: putfield 114	com/tencent/mm/plugin/misc/b/a$a:EWE	I
    //   226: aload 5
    //   228: aload 4
    //   230: invokevirtual 240	android/telephony/CellInfo:isRegistered	()Z
    //   233: putfield 94	com/tencent/mm/plugin/misc/b/a$a:phH	Z
    //   236: aload 5
    //   238: ldc 242
    //   240: putfield 110	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   243: aload 5
    //   245: getfield 101	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   248: invokevirtual 247	java/lang/String:length	()I
    //   251: iconst_1
    //   252: if_icmpne +28 -> 280
    //   255: aload 5
    //   257: new 214	java/lang/StringBuilder
    //   260: dup
    //   261: ldc 249
    //   263: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload 5
    //   268: getfield 101	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   271: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: putfield 101	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   280: iload_1
    //   281: ldc_w 256
    //   284: if_icmpeq -223 -> 61
    //   287: aload_3
    //   288: aload 5
    //   290: invokeinterface 260 2 0
    //   295: pop
    //   296: goto -235 -> 61
    //   299: astore_0
    //   300: ldc 116
    //   302: ldc_w 262
    //   305: iconst_1
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload_0
    //   312: aastore
    //   313: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: ldc 161
    //   318: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: ldc 2
    //   323: monitorexit
    //   324: aload_3
    //   325: areturn
    //   326: aload 4
    //   328: instanceof 264
    //   331: ifeq +129 -> 460
    //   334: aload 4
    //   336: checkcast 264	android/telephony/CellInfoCdma
    //   339: invokevirtual 267	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   342: astore 6
    //   344: aload 4
    //   346: checkcast 264	android/telephony/CellInfoCdma
    //   349: invokevirtual 270	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   352: astore 7
    //   354: aload 7
    //   356: invokevirtual 275	android/telephony/CellIdentityCdma:getSystemId	()I
    //   359: istore_1
    //   360: aload 5
    //   362: new 214	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   369: aload 7
    //   371: invokevirtual 278	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   374: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: putfield 107	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   383: aload 5
    //   385: new 214	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   392: aload 7
    //   394: invokevirtual 275	android/telephony/CellIdentityCdma:getSystemId	()I
    //   397: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: putfield 101	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   406: aload 5
    //   408: new 214	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   415: aload 7
    //   417: invokevirtual 281	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   420: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: putfield 104	com/tencent/mm/plugin/misc/b/a$a:EWD	Ljava/lang/String;
    //   429: aload 5
    //   431: aload 6
    //   433: invokevirtual 284	android/telephony/CellSignalStrengthCdma:getDbm	()I
    //   436: putfield 114	com/tencent/mm/plugin/misc/b/a$a:EWE	I
    //   439: aload 5
    //   441: aload 4
    //   443: invokevirtual 240	android/telephony/CellInfo:isRegistered	()Z
    //   446: putfield 94	com/tencent/mm/plugin/misc/b/a$a:phH	Z
    //   449: aload 5
    //   451: ldc_w 286
    //   454: putfield 110	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   457: goto -214 -> 243
    //   460: aload 4
    //   462: instanceof 288
    //   465: ifeq +152 -> 617
    //   468: aload 4
    //   470: checkcast 288	android/telephony/CellInfoLte
    //   473: invokevirtual 291	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   476: astore 6
    //   478: aload 4
    //   480: checkcast 288	android/telephony/CellInfoLte
    //   483: invokevirtual 294	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   486: astore 7
    //   488: aload 7
    //   490: invokevirtual 297	android/telephony/CellIdentityLte:getMnc	()I
    //   493: istore_1
    //   494: aload 5
    //   496: new 214	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   503: aload 7
    //   505: invokevirtual 300	android/telephony/CellIdentityLte:getCi	()I
    //   508: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: putfield 107	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   517: aload 5
    //   519: new 214	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   526: aload 7
    //   528: invokevirtual 301	android/telephony/CellIdentityLte:getMcc	()I
    //   531: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: putfield 98	com/tencent/mm/plugin/misc/b/a$a:mcc	Ljava/lang/String;
    //   540: aload 5
    //   542: new 214	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   549: aload 7
    //   551: invokevirtual 297	android/telephony/CellIdentityLte:getMnc	()I
    //   554: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: putfield 101	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   563: aload 5
    //   565: new 214	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   572: aload 7
    //   574: invokevirtual 304	android/telephony/CellIdentityLte:getTac	()I
    //   577: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: putfield 104	com/tencent/mm/plugin/misc/b/a$a:EWD	Ljava/lang/String;
    //   586: aload 5
    //   588: aload 6
    //   590: invokevirtual 307	android/telephony/CellSignalStrengthLte:getDbm	()I
    //   593: putfield 114	com/tencent/mm/plugin/misc/b/a$a:EWE	I
    //   596: aload 5
    //   598: aload 4
    //   600: invokevirtual 240	android/telephony/CellInfo:isRegistered	()Z
    //   603: putfield 94	com/tencent/mm/plugin/misc/b/a$a:phH	Z
    //   606: aload 5
    //   608: ldc_w 309
    //   611: putfield 110	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   614: goto -371 -> 243
    //   617: iload_2
    //   618: bipush 18
    //   620: if_icmplt +160 -> 780
    //   623: aload 4
    //   625: instanceof 311
    //   628: ifeq +152 -> 780
    //   631: aload 4
    //   633: checkcast 311	android/telephony/CellInfoWcdma
    //   636: invokevirtual 314	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   639: astore 6
    //   641: aload 4
    //   643: checkcast 311	android/telephony/CellInfoWcdma
    //   646: invokevirtual 317	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   649: astore 7
    //   651: aload 7
    //   653: invokevirtual 320	android/telephony/CellIdentityWcdma:getMnc	()I
    //   656: istore_1
    //   657: aload 5
    //   659: new 214	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   666: aload 7
    //   668: invokevirtual 321	android/telephony/CellIdentityWcdma:getCid	()I
    //   671: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: putfield 107	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   680: aload 5
    //   682: new 214	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   689: aload 7
    //   691: invokevirtual 322	android/telephony/CellIdentityWcdma:getMcc	()I
    //   694: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   697: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: putfield 98	com/tencent/mm/plugin/misc/b/a$a:mcc	Ljava/lang/String;
    //   703: aload 5
    //   705: new 214	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   712: aload 7
    //   714: invokevirtual 320	android/telephony/CellIdentityWcdma:getMnc	()I
    //   717: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   720: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: putfield 101	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   726: aload 5
    //   728: new 214	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   735: aload 7
    //   737: invokevirtual 323	android/telephony/CellIdentityWcdma:getLac	()I
    //   740: invokevirtual 222	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: putfield 104	com/tencent/mm/plugin/misc/b/a$a:EWD	Ljava/lang/String;
    //   749: aload 5
    //   751: aload 6
    //   753: invokevirtual 326	android/telephony/CellSignalStrengthWcdma:getDbm	()I
    //   756: putfield 114	com/tencent/mm/plugin/misc/b/a$a:EWE	I
    //   759: aload 5
    //   761: aload 4
    //   763: invokevirtual 240	android/telephony/CellInfo:isRegistered	()Z
    //   766: putfield 94	com/tencent/mm/plugin/misc/b/a$a:phH	Z
    //   769: aload 5
    //   771: ldc_w 328
    //   774: putfield 110	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   777: goto -534 -> 243
    //   780: ldc 116
    //   782: new 214	java/lang/StringBuilder
    //   785: dup
    //   786: ldc_w 330
    //   789: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   792: aload 4
    //   794: invokevirtual 334	java/lang/Object:getClass	()Ljava/lang/Class;
    //   797: invokevirtual 339	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   800: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 341
    //   806: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload 4
    //   811: invokevirtual 342	android/telephony/CellInfo:toString	()Ljava/lang/String;
    //   814: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: iconst_0
    //   824: istore_1
    //   825: goto -582 -> 243
    //   828: astore_0
    //   829: ldc 2
    //   831: monitorexit
    //   832: aload_0
    //   833: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	834	0	paramContext	android.content.Context
    //   123	702	1	i	int
    //   29	592	2	j	int
    //   15	310	3	localLinkedList	java.util.LinkedList
    //   79	731	4	localCellInfo	android.telephony.CellInfo
    //   88	682	5	locala	a
    //   106	646	6	localObject1	Object
    //   116	620	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	50	299	java/lang/Exception
    //   54	61	299	java/lang/Exception
    //   61	243	299	java/lang/Exception
    //   243	280	299	java/lang/Exception
    //   287	296	299	java/lang/Exception
    //   326	457	299	java/lang/Exception
    //   460	614	299	java/lang/Exception
    //   623	777	299	java/lang/Exception
    //   780	823	299	java/lang/Exception
    //   3	30	828	finally
    //   30	50	828	finally
    //   54	61	828	finally
    //   61	243	828	finally
    //   243	280	828	finally
    //   287	296	828	finally
    //   300	316	828	finally
    //   316	321	828	finally
    //   326	457	828	finally
    //   460	614	828	finally
    //   623	777	828	finally
    //   780	823	828	finally
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(127608);
    com.tencent.mm.kernel.h.aGY().a(-1, this);
    AppMethodBeat.o(127608);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127609);
    com.tencent.mm.kernel.h.aGY().b(-1, this);
    AppMethodBeat.o(127609);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127610);
    if ((paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      AppMethodBeat.o(127610);
      return;
    }
    this.mHandler.post(new a.1(this, paramq, paramInt1, paramInt2));
    AppMethodBeat.o(127610);
  }
  
  static final class a
  {
    public String EWD;
    public int EWE;
    public String cellid;
    public String mcc;
    public String mnc;
    public boolean phH;
    public String type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a
 * JD-Core Version:    0.7.0.1
 */