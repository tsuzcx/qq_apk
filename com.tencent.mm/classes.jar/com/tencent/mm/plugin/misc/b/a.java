package com.tencent.mm.plugin.misc.b;

import android.os.Handler;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static volatile a uHM;
  private Handler mHandler;
  
  public a()
  {
    AppMethodBeat.i(127606);
    this.mHandler = new Handler();
    AppMethodBeat.o(127606);
  }
  
  public static void ai(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(161885);
    for (;;)
    {
      try
      {
        bool = ax.isMobile(ai.getContext());
        if (!bool)
        {
          AppMethodBeat.o(161885);
          return;
        }
        i = b.checkSelfPermission(ai.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
        if (i != 0)
        {
          AppMethodBeat.o(161885);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label494;
        }
        bool = true;
        Object localObject2 = fG(ai.getContext());
        i = ((List)localObject2).size();
        if (i == 0)
        {
          AppMethodBeat.o(161885);
          return;
        }
        Object localObject1 = (a)((List)localObject2).get(0);
        Object localObject3 = ((List)localObject2).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label491;
        }
        localObject2 = (a)((Iterator)localObject3).next();
        if (!((a)localObject2).kEu) {
          continue;
        }
        localObject1 = localObject2;
        localObject2 = ((a)localObject1).uHO;
        localObject3 = ((a)localObject1).uHP;
        String str1 = ((a)localObject1).uHR;
        String str2 = ((a)localObject1).uHQ;
        String str3 = ((a)localObject1).type;
        int j = ((a)localObject1).uHS;
        ac.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(j), Integer.valueOf(1), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(3) });
        localObject1 = h.wUl;
        if (bool)
        {
          i = 0;
          localObject1 = h.v(new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(3) });
          if (!ai.ciE()) {
            break label474;
          }
          if (!com.tencent.mm.plugin.report.b.c.wTf) {
            break label454;
          }
          bool = com.tencent.mm.plugin.report.b.c.wTg;
          e.a(15608L, 3L, (String)localObject1, bool, bool, false);
          AppMethodBeat.o(161885);
          return;
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.NetworkOptReport", "getNetType : %s", new Object[] { bs.m(localException) });
        AppMethodBeat.o(161885);
        return;
      }
      int i = 1;
      continue;
      label454:
      e.a(15608L, 3L, localException, false, false, false);
      AppMethodBeat.o(161885);
      return;
      label474:
      h.a(15608, 3, localException, false, false);
      AppMethodBeat.o(161885);
      return;
      label491:
      continue;
      label494:
      boolean bool = false;
    }
  }
  
  public static a dcO()
  {
    try
    {
      AppMethodBeat.i(127607);
      if (uHM == null) {
        uHM = new a();
      }
      a locala = uHM;
      AppMethodBeat.o(127607);
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private static List<a> fG(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 187
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 189	java/util/LinkedList
    //   11: dup
    //   12: invokespecial 190	java/util/LinkedList:<init>	()V
    //   15: astore_3
    //   16: aload_0
    //   17: ldc 192
    //   19: invokevirtual 198	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 200	android/telephony/TelephonyManager
    //   25: astore_0
    //   26: getstatic 205	android/os/Build$VERSION:SDK_INT	I
    //   29: istore_2
    //   30: aload_0
    //   31: invokevirtual 209	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull +267 -> 303
    //   39: aload_0
    //   40: invokeinterface 82 1 0
    //   45: astore_0
    //   46: aload_0
    //   47: invokeinterface 88 1 0
    //   52: ifeq +251 -> 303
    //   55: aload_0
    //   56: invokeinterface 92 1 0
    //   61: checkcast 211	android/telephony/CellInfo
    //   64: astore 4
    //   66: new 14	com/tencent/mm/plugin/misc/b/a$a
    //   69: dup
    //   70: invokespecial 212	com/tencent/mm/plugin/misc/b/a$a:<init>	()V
    //   73: astore 5
    //   75: aload 4
    //   77: instanceof 214
    //   80: ifeq +233 -> 313
    //   83: aload 4
    //   85: checkcast 214	android/telephony/CellInfoGsm
    //   88: invokevirtual 218	android/telephony/CellInfoGsm:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthGsm;
    //   91: astore 6
    //   93: aload 4
    //   95: checkcast 214	android/telephony/CellInfoGsm
    //   98: invokevirtual 222	android/telephony/CellInfoGsm:getCellIdentity	()Landroid/telephony/CellIdentityGsm;
    //   101: astore 7
    //   103: aload 7
    //   105: invokevirtual 227	android/telephony/CellIdentityGsm:getMnc	()I
    //   108: istore_1
    //   109: aload 5
    //   111: new 229	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   118: aload 7
    //   120: invokevirtual 233	android/telephony/CellIdentityGsm:getCid	()I
    //   123: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: putfield 109	com/tencent/mm/plugin/misc/b/a$a:uHQ	Ljava/lang/String;
    //   132: aload 5
    //   134: new 229	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   141: aload 7
    //   143: invokevirtual 244	android/telephony/CellIdentityGsm:getMcc	()I
    //   146: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: putfield 100	com/tencent/mm/plugin/misc/b/a$a:uHO	Ljava/lang/String;
    //   155: aload 5
    //   157: new 229	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   164: aload 7
    //   166: invokevirtual 227	android/telephony/CellIdentityGsm:getMnc	()I
    //   169: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: putfield 103	com/tencent/mm/plugin/misc/b/a$a:uHP	Ljava/lang/String;
    //   178: aload 5
    //   180: new 229	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   187: aload 7
    //   189: invokevirtual 247	android/telephony/CellIdentityGsm:getLac	()I
    //   192: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: putfield 106	com/tencent/mm/plugin/misc/b/a$a:uHR	Ljava/lang/String;
    //   201: aload 5
    //   203: aload 6
    //   205: invokevirtual 252	android/telephony/CellSignalStrengthGsm:getDbm	()I
    //   208: putfield 116	com/tencent/mm/plugin/misc/b/a$a:uHS	I
    //   211: aload 5
    //   213: aload 4
    //   215: invokevirtual 255	android/telephony/CellInfo:isRegistered	()Z
    //   218: putfield 96	com/tencent/mm/plugin/misc/b/a$a:kEu	Z
    //   221: aload 5
    //   223: ldc_w 257
    //   226: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   229: aload 5
    //   231: getfield 103	com/tencent/mm/plugin/misc/b/a$a:uHP	Ljava/lang/String;
    //   234: invokevirtual 262	java/lang/String:length	()I
    //   237: iconst_1
    //   238: if_icmpne +29 -> 267
    //   241: aload 5
    //   243: new 229	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 264
    //   250: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 5
    //   255: getfield 103	com/tencent/mm/plugin/misc/b/a$a:uHP	Ljava/lang/String;
    //   258: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: putfield 103	com/tencent/mm/plugin/misc/b/a$a:uHP	Ljava/lang/String;
    //   267: iload_1
    //   268: ldc_w 271
    //   271: if_icmpeq -225 -> 46
    //   274: aload_3
    //   275: aload 5
    //   277: invokeinterface 275 2 0
    //   282: pop
    //   283: goto -237 -> 46
    //   286: astore_0
    //   287: ldc 118
    //   289: ldc_w 277
    //   292: iconst_1
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_0
    //   299: aastore
    //   300: invokestatic 177	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: ldc 187
    //   305: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: ldc 2
    //   310: monitorexit
    //   311: aload_3
    //   312: areturn
    //   313: aload 4
    //   315: instanceof 279
    //   318: ifeq +129 -> 447
    //   321: aload 4
    //   323: checkcast 279	android/telephony/CellInfoCdma
    //   326: invokevirtual 282	android/telephony/CellInfoCdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthCdma;
    //   329: astore 6
    //   331: aload 4
    //   333: checkcast 279	android/telephony/CellInfoCdma
    //   336: invokevirtual 285	android/telephony/CellInfoCdma:getCellIdentity	()Landroid/telephony/CellIdentityCdma;
    //   339: astore 7
    //   341: aload 7
    //   343: invokevirtual 290	android/telephony/CellIdentityCdma:getSystemId	()I
    //   346: istore_1
    //   347: aload 5
    //   349: new 229	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   356: aload 7
    //   358: invokevirtual 293	android/telephony/CellIdentityCdma:getBasestationId	()I
    //   361: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: putfield 109	com/tencent/mm/plugin/misc/b/a$a:uHQ	Ljava/lang/String;
    //   370: aload 5
    //   372: new 229	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   379: aload 7
    //   381: invokevirtual 290	android/telephony/CellIdentityCdma:getSystemId	()I
    //   384: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: putfield 103	com/tencent/mm/plugin/misc/b/a$a:uHP	Ljava/lang/String;
    //   393: aload 5
    //   395: new 229	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   402: aload 7
    //   404: invokevirtual 296	android/telephony/CellIdentityCdma:getNetworkId	()I
    //   407: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: putfield 106	com/tencent/mm/plugin/misc/b/a$a:uHR	Ljava/lang/String;
    //   416: aload 5
    //   418: aload 6
    //   420: invokevirtual 299	android/telephony/CellSignalStrengthCdma:getDbm	()I
    //   423: putfield 116	com/tencent/mm/plugin/misc/b/a$a:uHS	I
    //   426: aload 5
    //   428: aload 4
    //   430: invokevirtual 255	android/telephony/CellInfo:isRegistered	()Z
    //   433: putfield 96	com/tencent/mm/plugin/misc/b/a$a:kEu	Z
    //   436: aload 5
    //   438: ldc_w 301
    //   441: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   444: goto -215 -> 229
    //   447: aload 4
    //   449: instanceof 303
    //   452: ifeq +152 -> 604
    //   455: aload 4
    //   457: checkcast 303	android/telephony/CellInfoLte
    //   460: invokevirtual 306	android/telephony/CellInfoLte:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthLte;
    //   463: astore 6
    //   465: aload 4
    //   467: checkcast 303	android/telephony/CellInfoLte
    //   470: invokevirtual 309	android/telephony/CellInfoLte:getCellIdentity	()Landroid/telephony/CellIdentityLte;
    //   473: astore 7
    //   475: aload 7
    //   477: invokevirtual 312	android/telephony/CellIdentityLte:getMnc	()I
    //   480: istore_1
    //   481: aload 5
    //   483: new 229	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   490: aload 7
    //   492: invokevirtual 315	android/telephony/CellIdentityLte:getCi	()I
    //   495: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: putfield 109	com/tencent/mm/plugin/misc/b/a$a:uHQ	Ljava/lang/String;
    //   504: aload 5
    //   506: new 229	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   513: aload 7
    //   515: invokevirtual 316	android/telephony/CellIdentityLte:getMcc	()I
    //   518: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: putfield 100	com/tencent/mm/plugin/misc/b/a$a:uHO	Ljava/lang/String;
    //   527: aload 5
    //   529: new 229	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   536: aload 7
    //   538: invokevirtual 312	android/telephony/CellIdentityLte:getMnc	()I
    //   541: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   544: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: putfield 103	com/tencent/mm/plugin/misc/b/a$a:uHP	Ljava/lang/String;
    //   550: aload 5
    //   552: new 229	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   559: aload 7
    //   561: invokevirtual 319	android/telephony/CellIdentityLte:getTac	()I
    //   564: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: putfield 106	com/tencent/mm/plugin/misc/b/a$a:uHR	Ljava/lang/String;
    //   573: aload 5
    //   575: aload 6
    //   577: invokevirtual 322	android/telephony/CellSignalStrengthLte:getDbm	()I
    //   580: putfield 116	com/tencent/mm/plugin/misc/b/a$a:uHS	I
    //   583: aload 5
    //   585: aload 4
    //   587: invokevirtual 255	android/telephony/CellInfo:isRegistered	()Z
    //   590: putfield 96	com/tencent/mm/plugin/misc/b/a$a:kEu	Z
    //   593: aload 5
    //   595: ldc_w 324
    //   598: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   601: goto -372 -> 229
    //   604: iload_2
    //   605: bipush 18
    //   607: if_icmplt +160 -> 767
    //   610: aload 4
    //   612: instanceof 326
    //   615: ifeq +152 -> 767
    //   618: aload 4
    //   620: checkcast 326	android/telephony/CellInfoWcdma
    //   623: invokevirtual 329	android/telephony/CellInfoWcdma:getCellSignalStrength	()Landroid/telephony/CellSignalStrengthWcdma;
    //   626: astore 6
    //   628: aload 4
    //   630: checkcast 326	android/telephony/CellInfoWcdma
    //   633: invokevirtual 332	android/telephony/CellInfoWcdma:getCellIdentity	()Landroid/telephony/CellIdentityWcdma;
    //   636: astore 7
    //   638: aload 7
    //   640: invokevirtual 335	android/telephony/CellIdentityWcdma:getMnc	()I
    //   643: istore_1
    //   644: aload 5
    //   646: new 229	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   653: aload 7
    //   655: invokevirtual 336	android/telephony/CellIdentityWcdma:getCid	()I
    //   658: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: putfield 109	com/tencent/mm/plugin/misc/b/a$a:uHQ	Ljava/lang/String;
    //   667: aload 5
    //   669: new 229	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   676: aload 7
    //   678: invokevirtual 337	android/telephony/CellIdentityWcdma:getMcc	()I
    //   681: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: putfield 100	com/tencent/mm/plugin/misc/b/a$a:uHO	Ljava/lang/String;
    //   690: aload 5
    //   692: new 229	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   699: aload 7
    //   701: invokevirtual 335	android/telephony/CellIdentityWcdma:getMnc	()I
    //   704: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: putfield 103	com/tencent/mm/plugin/misc/b/a$a:uHP	Ljava/lang/String;
    //   713: aload 5
    //   715: new 229	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   722: aload 7
    //   724: invokevirtual 338	android/telephony/CellIdentityWcdma:getLac	()I
    //   727: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   730: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: putfield 106	com/tencent/mm/plugin/misc/b/a$a:uHR	Ljava/lang/String;
    //   736: aload 5
    //   738: aload 6
    //   740: invokevirtual 341	android/telephony/CellSignalStrengthWcdma:getDbm	()I
    //   743: putfield 116	com/tencent/mm/plugin/misc/b/a$a:uHS	I
    //   746: aload 5
    //   748: aload 4
    //   750: invokevirtual 255	android/telephony/CellInfo:isRegistered	()Z
    //   753: putfield 96	com/tencent/mm/plugin/misc/b/a$a:kEu	Z
    //   756: aload 5
    //   758: ldc_w 343
    //   761: putfield 112	com/tencent/mm/plugin/misc/b/a$a:type	Ljava/lang/String;
    //   764: goto -535 -> 229
    //   767: ldc 118
    //   769: new 229	java/lang/StringBuilder
    //   772: dup
    //   773: ldc_w 345
    //   776: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   779: aload 4
    //   781: invokevirtual 349	java/lang/Object:getClass	()Ljava/lang/Class;
    //   784: invokevirtual 354	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   787: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 356
    //   793: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload 4
    //   798: invokevirtual 357	android/telephony/CellInfo:toString	()Ljava/lang/String;
    //   801: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 360	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   810: iconst_0
    //   811: istore_1
    //   812: goto -583 -> 229
    //   815: astore_0
    //   816: ldc 2
    //   818: monitorexit
    //   819: aload_0
    //   820: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	paramContext	android.content.Context
    //   108	704	1	i	int
    //   29	579	2	j	int
    //   15	297	3	localLinkedList	java.util.LinkedList
    //   64	733	4	localCellInfo	android.telephony.CellInfo
    //   73	684	5	locala	a
    //   91	648	6	localObject1	Object
    //   101	622	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	35	286	java/lang/Exception
    //   39	46	286	java/lang/Exception
    //   46	229	286	java/lang/Exception
    //   229	267	286	java/lang/Exception
    //   274	283	286	java/lang/Exception
    //   313	444	286	java/lang/Exception
    //   447	601	286	java/lang/Exception
    //   610	764	286	java/lang/Exception
    //   767	810	286	java/lang/Exception
    //   3	30	815	finally
    //   30	35	815	finally
    //   39	46	815	finally
    //   46	229	815	finally
    //   229	267	815	finally
    //   274	283	815	finally
    //   287	303	815	finally
    //   303	308	815	finally
    //   313	444	815	finally
    //   447	601	815	finally
    //   610	764	815	finally
    //   767	810	815	finally
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127608);
    com.tencent.mm.kernel.g.agi().a(-1, this);
    AppMethodBeat.o(127608);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127609);
    com.tencent.mm.kernel.g.agi().b(-1, this);
    AppMethodBeat.o(127609);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final n paramn)
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
        int k = paramn.getType();
        int j = 0;
        Object localObject = paramn.getReqResp();
        int i;
        if ((k == 1616) || (k == 1518) || (k == 385)) {
          i = 1;
        }
        for (;;)
        {
          if (i == 1) {
            a.ai(paramInt1, paramInt2, k);
          }
          AppMethodBeat.o(127605);
          return;
          i = j;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.network.q)localObject).getUri();
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
    public boolean kEu;
    public String type;
    public String uHO;
    public String uHP;
    public String uHQ;
    public String uHR;
    public int uHS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a
 * JD-Core Version:    0.7.0.1
 */