package com.tencent.mm.plugin.misc.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.am.h, com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static volatile a KSl;
  private static List<a> KSm;
  private static long KSn;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(260868);
    KSm = new LinkedList();
    KSn = 0L;
    AppMethodBeat.o(260868);
  }
  
  public a()
  {
    AppMethodBeat.i(127606);
    this.mHandler = new Handler();
    AppMethodBeat.o(127606);
  }
  
  public static void aQ(int paramInt1, int paramInt2, int paramInt3)
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
          Object localObject2 = iP(MMApplicationContext.getContext());
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
            if (!((a)localObject2).sna) {
              continue;
            }
            localObject1 = localObject2;
            localObject2 = ((a)localObject1).mcc;
            localObject3 = ((a)localObject1).mnc;
            String str1 = ((a)localObject1).KSp;
            String str2 = ((a)localObject1).cellid;
            String str3 = ((a)localObject1).type;
            int j = ((a)localObject1).KSq;
            Log.i("MicroMsg.NetworkOptReport", "reportCellInfo mcc[%s] mnc[%s] lac[%s] cellid[%s] netType[%s] dbm[%d] type[%d] success[%s] errType[%d] errCode[%d] cmdid[%d] reportType[%d]", new Object[] { localObject2, localObject3, str1, str2, str3, Integer.valueOf(j), Integer.valueOf(1), Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(3) });
            localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
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
  
  public static a gbw()
  {
    try
    {
      AppMethodBeat.i(127607);
      if (KSl == null) {
        KSl = new a();
      }
      a locala = KSl;
      AppMethodBeat.o(127607);
      return locala;
    }
    finally {}
  }
  
  private static List<a> iP(Context paramContext)
  {
    for (;;)
    {
      int j;
      CellInfo localCellInfo;
      a locala;
      try
      {
        AppMethodBeat.i(127612);
        if ((KSm.size() > 0) && (System.currentTimeMillis() - KSn < 60000L))
        {
          paramContext = KSm;
          AppMethodBeat.o(127612);
          return paramContext;
        }
        KSn = System.currentTimeMillis();
        KSm.clear();
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        j = Build.VERSION.SDK_INT;
        try
        {
          paramContext = (List)com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/misc/impl/NetworkOptReport", "getExtraCellInfoList", "(Landroid/content/Context;)Ljava/util/List;", "android/telephony/TelephonyManager", "getAllCellInfo", "()Ljava/util/List;");
          if (paramContext != null)
          {
            paramContext = paramContext.iterator();
            if (paramContext.hasNext())
            {
              localCellInfo = (CellInfo)paramContext.next();
              locala = new a();
              if (!(localCellInfo instanceof CellInfoGsm)) {
                break label378;
              }
              localObject1 = ((CellInfoGsm)localCellInfo).getCellSignalStrength();
              localObject2 = ((CellInfoGsm)localCellInfo).getCellIdentity();
              i = ((CellIdentityGsm)localObject2).getMnc();
              locala.cellid = ((CellIdentityGsm)localObject2).getCid();
              locala.mcc = ((CellIdentityGsm)localObject2).getMcc();
              locala.mnc = ((CellIdentityGsm)localObject2).getMnc();
              locala.KSp = ((CellIdentityGsm)localObject2).getLac();
              locala.KSq = ((CellSignalStrengthGsm)localObject1).getDbm();
              locala.sna = localCellInfo.isRegistered();
              locala.type = "gsm";
              if (locala.mnc.length() == 1) {
                locala.mnc = ("0" + locala.mnc);
              }
              if (i == 2147483647) {
                continue;
              }
              KSm.add(locala);
              continue;
            }
          }
        }
        catch (Exception paramContext)
        {
          Log.e("MicroMsg.NetworkOptReport", "loadCellInfo: Unable to obtain cell signal information: ", new Object[] { paramContext });
          paramContext = KSm;
          AppMethodBeat.o(127612);
        }
        if (!(localCellInfo instanceof CellInfoCdma)) {
          break label508;
        }
      }
      finally {}
      label378:
      Object localObject1 = ((CellInfoCdma)localCellInfo).getCellSignalStrength();
      Object localObject2 = ((CellInfoCdma)localCellInfo).getCellIdentity();
      int i = ((CellIdentityCdma)localObject2).getSystemId();
      locala.cellid = ((CellIdentityCdma)localObject2).getBasestationId();
      locala.mnc = ((CellIdentityCdma)localObject2).getSystemId();
      locala.KSp = ((CellIdentityCdma)localObject2).getNetworkId();
      locala.KSq = ((CellSignalStrengthCdma)localObject1).getDbm();
      locala.sna = localCellInfo.isRegistered();
      locala.type = "cdma";
      continue;
      label508:
      if ((localCellInfo instanceof CellInfoLte))
      {
        localObject1 = ((CellInfoLte)localCellInfo).getCellSignalStrength();
        localObject2 = ((CellInfoLte)localCellInfo).getCellIdentity();
        i = ((CellIdentityLte)localObject2).getMnc();
        locala.cellid = ((CellIdentityLte)localObject2).getCi();
        locala.mcc = ((CellIdentityLte)localObject2).getMcc();
        locala.mnc = ((CellIdentityLte)localObject2).getMnc();
        locala.KSp = ((CellIdentityLte)localObject2).getTac();
        locala.KSq = ((CellSignalStrengthLte)localObject1).getDbm();
        locala.sna = localCellInfo.isRegistered();
        locala.type = "lte";
      }
      else if ((j >= 18) && ((localCellInfo instanceof CellInfoWcdma)))
      {
        localObject1 = ((CellInfoWcdma)localCellInfo).getCellSignalStrength();
        localObject2 = ((CellInfoWcdma)localCellInfo).getCellIdentity();
        i = ((CellIdentityWcdma)localObject2).getMnc();
        locala.cellid = ((CellIdentityWcdma)localObject2).getCid();
        locala.mcc = ((CellIdentityWcdma)localObject2).getMcc();
        locala.mnc = ((CellIdentityWcdma)localObject2).getMnc();
        locala.KSp = ((CellIdentityWcdma)localObject2).getLac();
        locala.KSq = ((CellSignalStrengthWcdma)localObject1).getDbm();
        locala.sna = localCellInfo.isRegistered();
        locala.type = "wcdma";
      }
      else
      {
        Log.i("MicroMsg.NetworkOptReport", "Unknown type of cell signal!\n ClassName: " + localCellInfo.getClass().getSimpleName() + "\n ToString: " + localCellInfo.toString());
        i = 0;
      }
    }
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(127608);
    com.tencent.mm.kernel.h.aZW().a(-1, this);
    AppMethodBeat.o(127608);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127609);
    com.tencent.mm.kernel.h.aZW().b(-1, this);
    AppMethodBeat.o(127609);
  }
  
  public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, final p paramp)
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
        int k = paramp.getType();
        int j = 0;
        Object localObject = paramp.getReqResp();
        int i;
        if ((k == 1616) || (k == 1518) || (k == 385)) {
          i = 1;
        }
        for (;;)
        {
          if (i == 1) {
            a.aQ(paramInt1, paramInt2, k);
          }
          AppMethodBeat.o(127605);
          return;
          i = j;
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.network.s)localObject).getUri();
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
    public String KSp;
    public int KSq;
    public String cellid;
    public String mcc;
    public String mnc;
    public boolean sna;
    public String type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.a
 * JD-Core Version:    0.7.0.1
 */