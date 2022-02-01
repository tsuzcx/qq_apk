package com.tencent.mm.plugin.misc.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.m.e;
import com.tencent.mm.model.bm;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements com.tencent.mm.al.g, c, com.tencent.mm.plugin.misc.a.a
{
  private static av cOx = null;
  private static String tzA = "";
  private static String tzz = "";
  private int gOG;
  private int gOH;
  private com.tencent.mm.network.n haH;
  private int type;
  private boolean tzB;
  private final Map<Integer, Set<Object>> tzC;
  private boolean tzw;
  private long tzx;
  private long tzy;
  
  public b()
  {
    AppMethodBeat.i(127615);
    this.tzw = false;
    this.gOG = 0;
    this.gOH = 0;
    this.type = 0;
    this.tzx = 0L;
    this.tzy = 60L;
    this.tzB = false;
    this.tzC = new HashMap();
    this.haH = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(127614);
        for (;;)
        {
          try
          {
            if (!b.cPh())
            {
              b.a(b.this, 0);
              AppMethodBeat.o(127614);
              return;
            }
            if (b.b(b.this))
            {
              String str1 = "";
              ad.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
              if ((b.b(b.this)) || (str1.equals(b.tzz))) {
                break label161;
              }
              ad.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.tzz, str1 });
              b.agV(str1);
              if (paramAnonymousInt == 0) {
                break label204;
              }
              b.c(b.this);
              b.d(b.this);
              b.this.Gx(2);
              AppMethodBeat.o(127614);
              return;
            }
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.SimcardService", localException, "", new Object[0]);
            AppMethodBeat.o(127614);
            return;
          }
          String str2 = com.tencent.mm.compatible.deviceinfo.q.WU();
          continue;
          label161:
          str2 = b.cPi();
          if (!str2.equals(b.cPj()))
          {
            ad.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.cPj(), str2 });
            b.agW(str2);
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
    this.tzB = bool1;
    AppMethodBeat.o(127615);
  }
  
  private static String Ep()
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
      if (bt.isNullOrNil(localInetAddress.getHostAddress()))
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
  
  private void Gy(int paramInt)
  {
    AppMethodBeat.i(127622);
    ad.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.tzC == null)
    {
      AppMethodBeat.o(127622);
      return;
    }
    Iterator localIterator = this.tzC.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = ((Set)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    AppMethodBeat.o(127622);
  }
  
  private static boolean cPg()
  {
    AppMethodBeat.i(127623);
    if (!ay.isMobile(aj.getContext()))
    {
      AppMethodBeat.o(127623);
      return false;
    }
    int i = ay.getISPCode(aj.getContext());
    ad.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 46001) || (i == 46006) || (i == 46009))
    {
      AppMethodBeat.o(127623);
      return true;
    }
    AppMethodBeat.o(127623);
    return false;
  }
  
  public final int Gw(int paramInt)
  {
    AppMethodBeat.i(127619);
    if (!cPg())
    {
      if ((!ay.isMobile(aj.getContext())) && (this.tzw))
      {
        if ((this.gOG & paramInt) == 0)
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
    Gx(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(127619);
      return 0;
    }
    if (this.tzw)
    {
      if ((this.gOG & paramInt) == 0)
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
  
  public final void Gx(int paramInt)
  {
    AppMethodBeat.i(127621);
    if (!cPg())
    {
      AppMethodBeat.o(127621);
      return;
    }
    if (this.tzx != 0L)
    {
      long l3 = bt.aGK();
      ad.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.tzy), Long.valueOf(this.tzx), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.tzy) {
          l1 = this.tzy;
        }
        if (l3 - this.tzx < l1) {
          AppMethodBeat.o(127621);
        }
      }
      else if (l3 - this.tzx < 60L)
      {
        AppMethodBeat.o(127621);
        return;
      }
    }
    this.tzx = bt.aGK();
    tzA = Ep();
    ad.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    if (!this.tzB) {
      tzz = com.tencent.mm.compatible.deviceinfo.q.WU();
    }
    String str2;
    String str3;
    for (Object localObject = new bm(paramInt, tzA, com.tencent.mm.compatible.deviceinfo.q.cG(true), tzz, null, null);; localObject = new bm(paramInt, str2, null, null, str3, (String)localObject))
    {
      com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
      AppMethodBeat.o(127621);
      return;
      String str1 = com.tencent.mm.compatible.deviceinfo.q.getOAID();
      str2 = tzA;
      str3 = com.tencent.mm.compatible.deviceinfo.q.Xd();
      localObject = str1;
      if (str1 == "") {
        localObject = null;
      }
    }
  }
  
  public final int cPe()
  {
    AppMethodBeat.i(127620);
    if (!cPg())
    {
      AppMethodBeat.o(127620);
      return 0;
    }
    int i = this.gOH;
    AppMethodBeat.o(127620);
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127616);
    if (cOx == null)
    {
      paramc = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127613);
          if (!com.tencent.mm.kernel.g.afz().aeI())
          {
            ad.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(127613);
            return true;
          }
          ad.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.Gx(0);
          }
          for (;;)
          {
            AppMethodBeat.o(127613);
            return true;
            b.this.Gx(3);
          }
        }
      }, true);
      cOx = paramc;
      paramc.av(30000L, 30000L);
    }
    com.tencent.mm.kernel.g.aeS().a(813, this);
    com.tencent.mm.kernel.g.afA().a(this.haH);
    AppMethodBeat.o(127616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127617);
    com.tencent.mm.kernel.g.aeS().b(813, this);
    AppMethodBeat.o(127617);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(127618);
    cOx.stopTimer();
    cOx.av(86400000L, 86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.tzy = 60L;
      ad.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      Gy(this.gOG);
      AppMethodBeat.o(127618);
      return;
    }
    paramString = (bm)paramn;
    this.tzw = true;
    this.gOH = paramString.gOH;
    this.type = paramString.type;
    this.gOG = paramString.gOG;
    if ((paramString.gOI < 60L) || (paramString.gOI > 86400L)) {}
    for (this.tzy = 28800L;; this.tzy = paramString.gOI)
    {
      ad.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.gOH), Integer.valueOf(this.gOG), Integer.valueOf(paramString.gOI) });
      Gy(this.gOG);
      AppMethodBeat.o(127618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */