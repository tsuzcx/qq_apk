package com.tencent.mm.plugin.misc.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.bv;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.misc.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements com.tencent.mm.am.h, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.misc.a.a
{
  private static String KSu = "";
  private static String KSv = "";
  private static MTimerHandler timer = null;
  private boolean KSr;
  private long KSs;
  private long KSt;
  private boolean KSw;
  private final Map<Integer, Set<a.a>> KSx;
  private com.tencent.mm.network.p oAk;
  private int omD;
  private int omE;
  private int type;
  
  public b()
  {
    AppMethodBeat.i(127615);
    this.KSr = false;
    this.omD = 0;
    this.omE = 0;
    this.type = 0;
    this.KSs = 0L;
    this.KSt = 60L;
    this.KSw = false;
    this.KSx = new HashMap();
    this.oAk = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(127614);
        for (;;)
        {
          try
          {
            if (!b.gbx())
            {
              b.a(b.this, 0);
              AppMethodBeat.o(127614);
              return;
            }
            if (b.b(b.this))
            {
              String str1 = "";
              Log.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
              if ((b.b(b.this)) || (str1.equals(b.KSu))) {
                break label161;
              }
              Log.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.KSu, str1 });
              b.aGP(str1);
              if (paramAnonymousInt == 0) {
                break label204;
              }
              b.c(b.this);
              b.d(b.this);
              b.this.aaH(2);
              AppMethodBeat.o(127614);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.SimcardService", localException, "", new Object[0]);
            AppMethodBeat.o(127614);
            return;
          }
          String str2 = q.aOZ();
          continue;
          label161:
          str2 = b.gby();
          if (!str2.equals(b.KSv))
          {
            Log.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.KSv, str2 });
            b.aMn(str2);
            continue;
            label204:
            b.a(b.this, b.e(b.this));
            AppMethodBeat.o(127614);
          }
          else
          {
            paramAnonymousInt = 0;
          }
        }
      }
    };
    boolean bool1;
    if (Build.VERSION.SDK_INT < 29)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 28)
      {
        bool1 = bool2;
        if (Build.VERSION.PREVIEW_SDK_INT == 0) {}
      }
    }
    else
    {
      bool1 = true;
    }
    this.KSw = bool1;
    AppMethodBeat.o(127615);
  }
  
  private static String atl()
  {
    AppMethodBeat.i(127624);
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject1 = NetworkInterface.getNetworkInterfaces();
        Object localObject2;
        while (!((Enumeration)localObject2).hasMoreElements())
        {
          do
          {
            if (!((Enumeration)localObject1).hasMoreElements()) {
              break;
            }
            localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
          } while (localObject2 == null);
          localObject2 = ((NetworkInterface)localObject2).getInetAddresses();
        }
        localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
      } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      if (Util.isNullOrNil(localInetAddress.getHostAddress()))
      {
        AppMethodBeat.o(127624);
        return "127.0.0.1";
      }
      Object localObject1 = localInetAddress.getHostAddress();
      AppMethodBeat.o(127624);
      return localObject1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(127624);
    }
    return "127.0.0.1";
  }
  
  public static boolean gbx()
  {
    AppMethodBeat.i(127623);
    if (!NetStatusUtil.isMobile(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(127623);
      return false;
    }
    int i = NetStatusUtil.getISPCode(MMApplicationContext.getContext());
    Log.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 46001) || (i == 46006) || (i == 46009))
    {
      AppMethodBeat.o(127623);
      return true;
    }
    AppMethodBeat.o(127623);
    return false;
  }
  
  private void jH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260846);
    Log.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt1) });
    if (this.KSx == null)
    {
      AppMethodBeat.o(260846);
      return;
    }
    Iterator localIterator = this.KSx.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ((((Integer)((Map.Entry)localObject).getKey()).intValue() & paramInt1) == 0) {}
      for (int i = 2;; i = 1)
      {
        localObject = ((Set)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.a)((Iterator)localObject).next()).onSIMCardChange(i, paramInt2);
        }
        break;
      }
    }
    AppMethodBeat.o(260846);
  }
  
  public final void a(int paramInt, a.a parama)
  {
    AppMethodBeat.i(260914);
    if (parama == null)
    {
      AppMethodBeat.o(260914);
      return;
    }
    if (!this.KSx.containsKey(Integer.valueOf(paramInt))) {
      this.KSx.put(Integer.valueOf(paramInt), new HashSet());
    }
    ((Set)this.KSx.get(Integer.valueOf(paramInt))).add(parama);
    AppMethodBeat.o(260914);
  }
  
  public final int aaG(int paramInt)
  {
    AppMethodBeat.i(127619);
    if (!gbx())
    {
      if ((!NetStatusUtil.isMobile(MMApplicationContext.getContext())) && (this.KSr))
      {
        if ((this.omD & paramInt) == 0)
        {
          AppMethodBeat.o(127619);
          return 2;
        }
        AppMethodBeat.o(127619);
        return 3;
      }
      AppMethodBeat.o(127619);
      return 2;
    }
    aaH(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(127619);
      return 0;
    }
    if (this.KSr)
    {
      if ((this.omD & paramInt) == 0)
      {
        AppMethodBeat.o(127619);
        return 2;
      }
      AppMethodBeat.o(127619);
      return 1;
    }
    AppMethodBeat.o(127619);
    return 0;
  }
  
  public final void aaH(int paramInt)
  {
    AppMethodBeat.i(127621);
    if (!gbx())
    {
      AppMethodBeat.o(127621);
      return;
    }
    if (this.KSs != 0L)
    {
      long l3 = Util.nowSecond();
      Log.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.KSt), Long.valueOf(this.KSs), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.KSt) {
          l1 = this.KSt;
        }
        if (l3 - this.KSs < l1) {
          AppMethodBeat.o(127621);
        }
      }
      else if (l3 - this.KSs < 60L)
      {
        AppMethodBeat.o(127621);
        return;
      }
    }
    this.KSs = Util.nowSecond();
    KSv = atl();
    Log.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    if (!this.KSw) {
      KSu = q.aOZ();
    }
    String str2;
    String str3;
    for (Object localObject = new bv(paramInt, KSv, q.eD(true), KSu, null, null);; localObject = new bv(paramInt, str2, null, null, str3, (String)localObject))
    {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      AppMethodBeat.o(127621);
      return;
      String str1 = q.aPk();
      str2 = KSv;
      str3 = q.aPj();
      localObject = str1;
      if (str1 == "") {
        localObject = null;
      }
    }
  }
  
  public final void b(int paramInt, a.a parama)
  {
    AppMethodBeat.i(260917);
    if (parama == null)
    {
      AppMethodBeat.o(260917);
      return;
    }
    if (!this.KSx.containsKey(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(260917);
      return;
    }
    ((Set)this.KSx.get(Integer.valueOf(paramInt))).remove(parama);
    AppMethodBeat.o(260917);
  }
  
  public final int gbv()
  {
    AppMethodBeat.i(127620);
    if (!gbx())
    {
      AppMethodBeat.o(127620);
      return 0;
    }
    int i = this.omE;
    AppMethodBeat.o(127620);
    return i;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(127616);
    if (timer == null)
    {
      paramc = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127613);
          if (!com.tencent.mm.kernel.h.baC().aZN())
          {
            Log.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(127613);
            return true;
          }
          Log.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.aaH(0);
          }
          for (;;)
          {
            AppMethodBeat.o(127613);
            return true;
            b.this.aaH(3);
          }
        }
      }, true);
      timer = paramc;
      paramc.startTimer(30000L);
    }
    com.tencent.mm.kernel.h.aZW().a(813, this);
    com.tencent.mm.kernel.h.baD().a(this.oAk);
    AppMethodBeat.o(127616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127617);
    com.tencent.mm.kernel.h.aZW().b(813, this);
    AppMethodBeat.o(127617);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(127618);
    timer.stopTimer();
    timer.startTimer(86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.KSt = 60L;
      Log.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      jH(this.omD, 2);
      AppMethodBeat.o(127618);
      return;
    }
    paramString = (bv)paramp;
    this.KSr = true;
    this.omE = paramString.omE;
    this.type = paramString.type;
    this.omD = paramString.omD;
    if ((paramString.omF < 60L) || (paramString.omF > 86400L)) {}
    for (this.KSt = 28800L;; this.KSt = paramString.omF)
    {
      Log.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.omE), Integer.valueOf(this.omD), Integer.valueOf(paramString.omF) });
      jH(this.omD, 3);
      AppMethodBeat.o(127618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */