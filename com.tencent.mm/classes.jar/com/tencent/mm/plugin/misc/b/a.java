package com.tencent.mm.plugin.misc.b;

import android.os.Handler;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class a
  implements i, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static volatile a zra;
  private Handler mHandler;
  
  public a()
  {
    AppMethodBeat.i(127606);
    this.mHandler = new Handler();
    AppMethodBeat.o(127606);
  }
  
  public static void an(int paramInt1, int paramInt2, int paramInt3)
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
        int i = b.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.ACCESS_FINE_LOCATION");
        if (i != 0)
        {
          AppMethodBeat.o(161885);
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          bool = true;
          Object localObject2 = gw(MMApplicationContext.getContext());
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
            if (!((a)localObject2).mjF) {
              continue;
            }
            localObject1 = localObject2;
            localObject2 = ((a)localObject1).mcc;
            localObject3 = ((a)localObject1).mnc;
            String str1 = ((a)localObject1).zrc;
            String str2 = ((a)localObject1).cellid;
            String str3 = ((a)localObject1).type;
            int j = ((a)localObject1).zrd;
            Log.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(j), Integer.valueOf(1), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(3) });
            localObject1 = h.CyF;
            if (bool)
            {
              i = 0;
              ((h)localObject1).a(15608, 3, h.u(new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(3) }), false, false);
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
  
  public static a eiW()
  {
    try
    {
      AppMethodBeat.i(127607);
      if (zra == null) {
        zra = new a();
      }
      a locala = zra;
      AppMethodBeat.o(127607);
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private static List<a> gw(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 167
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 169	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 170	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: ldc 172
    //   19: invokevirtual 178	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 180	android/telephony/TelephonyManager
    //   25: astore_0
    //   26: getstatic 185	android/os/Build$VERSION:SDK_INT	I
    //   29: istore_2
    //   30: aload_0
    //   31: invokevirtual 189	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull +264 -> 300
    //   39: aload_0
    //   40: invokeinterface 82 1 0
    //   45: astore_0
    //   46: aload_0
    //   47: invokeinterface 88 1 0
    //   52: ifeq +248 -> 300
    //   55: aload_0
    //   56: invokeinterface 92 1 0
    //   61: checkcast 191	android/telephony/CellInfo
    //   64: astore 4
    //   66: new 14	com/tencent/mm/plugin/misc/b/a$a
    //   69: dup
    //   70: invokespecial 192	com/tencent/mm/plugin/misc/b/a$a:<init>	()V
    //   73: astore 5
    //   75: aload 4
    //   77: instanceof 194
    //   80: ifeq +230 -> 310
    //   83: aload 4
    //   85: checkcast 194	android/telephony/CellInfoGsm
    //   88: invokevirtual 198	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   91: astore 6
    //   93: aload 4
    //   95: checkcast 194	android/telephony/CellInfoGsm
    //   98: invokevirtual 202	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   101: astore 7
    //   103: aload 7
    //   105: invokevirtual 207	android/telephony/CellIdentityGsm:getMnc	()I
    //   108: istore_1
    //   109: aload 5
    //   111: new 209	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   118: aload 7
    //   120: invokevirtual 213	android/telephony/CellIdentityGsm:getCid	()I
    //   123: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: putfield 109	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   132: aload 5
    //   134: new 209	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   141: aload 7
    //   143: invokevirtual 224	android/telephony/CellIdentityGsm:getMcc	()I
    //   146: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: putfield 100	com/tencent/mm/plugin/misc/b/a$a:mcc	Ljava/lang/String;
    //   155: aload 5
    //   157: new 209	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   164: aload 7
    //   166: invokevirtual 207	android/telephony/CellIdentityGsm:getMnc	()I
    //   169: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: putfield 103	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   178: aload 5
    //   180: new 209	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   187: aload 7
    //   189: invokevirtual 227	android/telephony/CellIdentityGsm:getLac	()I
    //   192: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: putfield 106	com/tencent/mm/plugin/misc/b/a$a:zrc	Ljava/lang/String;
    //   201: aload 5
    //   203: aload 6
    //   205: invokevirtual 232	android/telephony/CellSignalStrengthGsm:getDbm	()I
    //   208: putfield 116	com/tencent/mm/plugin/misc/b/a$a:zrd	I
    //   211: aload 5
    //   213: aload 4
    //   215: invokevirtual 235	android/telephony/CellInfo:isRegistered	()Z
    //   218: putfield 96	com/tencent/mm/plugin/misc/b/a$a:mjF	Z
    //   221: aload 5
    //   223: ldc 237
    //   225: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   228: aload 5
    //   230: getfield 103	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   233: invokevirtual 242	java/lang/String:length	()I
    //   236: iconst_1
    //   237: if_icmpne +28 -> 265
    //   240: aload 5
    //   242: new 209	java/lang/StringBuilder
    //   245: dup
    //   246: ldc 244
    //   248: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: aload 5
    //   253: getfield 103	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   256: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: putfield 103	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   265: iload_1
    //   266: ldc 251
    //   268: if_icmpeq -222 -> 46
    //   271: aload_3
    //   272: aload 5
    //   274: invokeinterface 255 2 0
    //   279: pop
    //   280: goto -234 -> 46
    //   283: astore_0
    //   284: ldc 118
    //   286: ldc_w 257
    //   289: iconst_1
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload_0
    //   296: aastore
    //   297: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: ldc 167
    //   302: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: ldc 2
    //   307: monitorexit
    //   308: aload_3
    //   309: areturn
    //   310: aload 4
    //   312: instanceof 259
    //   315: ifeq +129 -> 444
    //   318: aload 4
    //   320: checkcast 259	android/telephony/CellInfoCdma
    //   323: invokevirtual 262	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   326: astore 6
    //   328: aload 4
    //   330: checkcast 259	android/telephony/CellInfoCdma
    //   333: invokevirtual 265	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   336: astore 7
    //   338: aload 7
    //   340: invokevirtual 270	android/telephony/CellIdentityCdma:getSystemId	()I
    //   343: istore_1
    //   344: aload 5
    //   346: new 209	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   353: aload 7
    //   355: invokevirtual 273	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   358: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: putfield 109	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   367: aload 5
    //   369: new 209	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   376: aload 7
    //   378: invokevirtual 270	android/telephony/CellIdentityCdma:getSystemId	()I
    //   381: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: putfield 103	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   390: aload 5
    //   392: new 209	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   399: aload 7
    //   401: invokevirtual 276	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   404: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   407: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: putfield 106	com/tencent/mm/plugin/misc/b/a$a:zrc	Ljava/lang/String;
    //   413: aload 5
    //   415: aload 6
    //   417: invokevirtual 279	android/telephony/CellSignalStrengthCdma:getDbm	()I
    //   420: putfield 116	com/tencent/mm/plugin/misc/b/a$a:zrd	I
    //   423: aload 5
    //   425: aload 4
    //   427: invokevirtual 235	android/telephony/CellInfo:isRegistered	()Z
    //   430: putfield 96	com/tencent/mm/plugin/misc/b/a$a:mjF	Z
    //   433: aload 5
    //   435: ldc_w 281
    //   438: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   441: goto -213 -> 228
    //   444: aload 4
    //   446: instanceof 283
    //   449: ifeq +152 -> 601
    //   452: aload 4
    //   454: checkcast 283	android/telephony/CellInfoLte
    //   457: invokevirtual 286	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   460: astore 6
    //   462: aload 4
    //   464: checkcast 283	android/telephony/CellInfoLte
    //   467: invokevirtual 289	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   470: astore 7
    //   472: aload 7
    //   474: invokevirtual 292	android/telephony/CellIdentityLte:getMnc	()I
    //   477: istore_1
    //   478: aload 5
    //   480: new 209	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   487: aload 7
    //   489: invokevirtual 295	android/telephony/CellIdentityLte:getCi	()I
    //   492: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: putfield 109	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   501: aload 5
    //   503: new 209	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   510: aload 7
    //   512: invokevirtual 296	android/telephony/CellIdentityLte:getMcc	()I
    //   515: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: putfield 100	com/tencent/mm/plugin/misc/b/a$a:mcc	Ljava/lang/String;
    //   524: aload 5
    //   526: new 209	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   533: aload 7
    //   535: invokevirtual 292	android/telephony/CellIdentityLte:getMnc	()I
    //   538: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: putfield 103	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   547: aload 5
    //   549: new 209	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   556: aload 7
    //   558: invokevirtual 299	android/telephony/CellIdentityLte:getTac	()I
    //   561: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: putfield 106	com/tencent/mm/plugin/misc/b/a$a:zrc	Ljava/lang/String;
    //   570: aload 5
    //   572: aload 6
    //   574: invokevirtual 302	android/telephony/CellSignalStrengthLte:getDbm	()I
    //   577: putfield 116	com/tencent/mm/plugin/misc/b/a$a:zrd	I
    //   580: aload 5
    //   582: aload 4
    //   584: invokevirtual 235	android/telephony/CellInfo:isRegistered	()Z
    //   587: putfield 96	com/tencent/mm/plugin/misc/b/a$a:mjF	Z
    //   590: aload 5
    //   592: ldc_w 304
    //   595: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   598: goto -370 -> 228
    //   601: iload_2
    //   602: bipush 18
    //   604: if_icmplt +160 -> 764
    //   607: aload 4
    //   609: instanceof 306
    //   612: ifeq +152 -> 764
    //   615: aload 4
    //   617: checkcast 306	android/telephony/CellInfoWcdma
    //   620: invokevirtual 309	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   623: astore 6
    //   625: aload 4
    //   627: checkcast 306	android/telephony/CellInfoWcdma
    //   630: invokevirtual 312	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   633: astore 7
    //   635: aload 7
    //   637: invokevirtual 315	android/telephony/CellIdentityWcdma:getMnc	()I
    //   640: istore_1
    //   641: aload 5
    //   643: new 209	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   650: aload 7
    //   652: invokevirtual 316	android/telephony/CellIdentityWcdma:getCid	()I
    //   655: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: putfield 109	com/tencent/mm/plugin/misc/b/a$a:cellid	Ljava/lang/String;
    //   664: aload 5
    //   666: new 209	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   673: aload 7
    //   675: invokevirtual 317	android/telephony/CellIdentityWcdma:getMcc	()I
    //   678: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: putfield 100	com/tencent/mm/plugin/misc/b/a$a:mcc	Ljava/lang/String;
    //   687: aload 5
    //   689: new 209	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   696: aload 7
    //   698: invokevirtual 315	android/telephony/CellIdentityWcdma:getMnc	()I
    //   701: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   704: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: putfield 103	com/tencent/mm/plugin/misc/b/a$a:mnc	Ljava/lang/String;
    //   710: aload 5
    //   712: new 209	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   719: aload 7
    //   721: invokevirtual 318	android/telephony/CellIdentityWcdma:getLac	()I
    //   724: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   727: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: putfield 106	com/tencent/mm/plugin/misc/b/a$a:zrc	Ljava/lang/String;
    //   733: aload 5
    //   735: aload 6
    //   737: invokevirtual 321	android/telephony/CellSignalStrengthWcdma:getDbm	()I
    //   740: putfield 116	com/tencent/mm/plugin/misc/b/a$a:zrd	I
    //   743: aload 5
    //   745: aload 4
    //   747: invokevirtual 235	android/telephony/CellInfo:isRegistered	()Z
    //   750: putfield 96	com/tencent/mm/plugin/misc/b/a$a:mjF	Z
    //   753: aload 5
    //   755: ldc_w 323
    //   758: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   761: goto -533 -> 228
    //   764: ldc 118
    //   766: new 209	java/lang/StringBuilder
    //   769: dup
    //   770: ldc_w 325
    //   773: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   776: aload 4
    //   778: invokevirtual 329	java/lang/Object:getClass	()Ljava/lang/Class;
    //   781: invokevirtual 334	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   784: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: ldc_w 336
    //   790: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 4
    //   795: invokevirtual 337	android/telephony/CellInfo:toString	()Ljava/lang/String;
    //   798: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 340	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: iconst_0
    //   808: istore_1
    //   809: goto -581 -> 228
    //   812: astore_0
    //   813: ldc 2
    //   815: monitorexit
    //   816: aload_0
    //   817: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	paramContext	android.content.Context
    //   108	701	1	i	int
    //   29	576	2	j	int
    //   15	294	3	localLinkedList	java.util.LinkedList
    //   64	730	4	localCellInfo	android.telephony.CellInfo
    //   73	681	5	locala	a
    //   91	645	6	localObject1	Object
    //   101	619	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	35	283	java/lang/Exception
    //   39	46	283	java/lang/Exception
    //   46	228	283	java/lang/Exception
    //   228	265	283	java/lang/Exception
    //   271	280	283	java/lang/Exception
    //   310	441	283	java/lang/Exception
    //   444	598	283	java/lang/Exception
    //   607	761	283	java/lang/Exception
    //   764	807	283	java/lang/Exception
    //   3	30	812	finally
    //   30	35	812	finally
    //   39	46	812	finally
    //   46	228	812	finally
    //   228	265	812	finally
    //   271	280	812	finally
    //   284	300	812	finally
    //   300	305	812	finally
    //   310	441	812	finally
    //   444	598	812	finally
    //   607	761	812	finally
    //   764	807	812	finally
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127608);
    g.azz().a(-1, this);
    AppMethodBeat.o(127608);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127609);
    g.azz().b(-1, this);
    AppMethodBeat.o(127609);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(127610);
    if ((paramString != null) && (paramString.startsWith("autoauth_errmsg_")))
    {
      AppMethodBeat.o(127610);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(127605);
        int k = paramq.getType();
        int j = 0;
        Object localObject = paramq.getReqResp();
        int i;
        if ((k == 1616) || (k == 1518) || (k == 385)) {
          i = 1;
        }
        for (;;)
        {
          if (i == 1) {
            a.an(paramInt1, paramInt2, k);
          }
          AppMethodBeat.o(127605);
          return;
          i = j;
          if (localObject != null)
          {
            localObject = ((s)localObject).getUri();
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((String)localObject).startsWith("/cgi-bin/mmpay-bin/")) {
                i = 1;
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(127610);
  }
  
  static final class a
  {
    public String cellid;
    public String mcc;
    public boolean mjF;
    public String mnc;
    public String type;
    public String zrc;
    public int zrd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a
 * JD-Core Version:    0.7.0.1
 */