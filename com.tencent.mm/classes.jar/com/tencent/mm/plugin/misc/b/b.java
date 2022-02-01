package com.tencent.mm.plugin.misc.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.n.e;
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
  implements f, c, com.tencent.mm.plugin.misc.a.a
{
  private static av cXg = null;
  private static String vLb = "";
  private static String vLc = "";
  private int hHy;
  private int hHz;
  private com.tencent.mm.network.n hTD;
  private int type;
  private boolean vKY;
  private long vKZ;
  private long vLa;
  private boolean vLd;
  private final Map<Integer, Set<Object>> vLe;
  
  public b()
  {
    AppMethodBeat.i(127615);
    this.vKY = false;
    this.hHy = 0;
    this.hHz = 0;
    this.type = 0;
    this.vKZ = 0L;
    this.vLa = 60L;
    this.vLd = false;
    this.vLe = new HashMap();
    this.hTD = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(127614);
        for (;;)
        {
          try
          {
            if (!b.dmk())
            {
              b.a(b.this, 0);
              AppMethodBeat.o(127614);
              return;
            }
            if (b.b(b.this))
            {
              String str1 = "";
              ad.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
              if ((b.b(b.this)) || (str1.equals(b.vLb))) {
                break label161;
              }
              ad.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.vLb, str1 });
              b.aqE(str1);
              if (paramAnonymousInt == 0) {
                break label204;
              }
              b.c(b.this);
              b.d(b.this);
              b.this.JQ(2);
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
          String str2 = com.tencent.mm.compatible.deviceinfo.q.aas();
          continue;
          label161:
          str2 = b.dml();
          if (!str2.equals(b.dmm()))
          {
            ad.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.dmm(), str2 });
            b.aqF(str2);
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
    this.vLd = bool1;
    AppMethodBeat.o(127615);
  }
  
  private static String Fs()
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
  
  private void JR(int paramInt)
  {
    AppMethodBeat.i(127622);
    ad.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.vLe == null)
    {
      AppMethodBeat.o(127622);
      return;
    }
    Iterator localIterator = this.vLe.entrySet().iterator();
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
  
  private static boolean dmj()
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
  
  public final int JP(int paramInt)
  {
    AppMethodBeat.i(127619);
    if (!dmj())
    {
      if ((!ay.isMobile(aj.getContext())) && (this.vKY))
      {
        if ((this.hHy & paramInt) == 0)
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
    JQ(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(127619);
      return 0;
    }
    if (this.vKY)
    {
      if ((this.hHy & paramInt) == 0)
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
  
  public final void JQ(int paramInt)
  {
    AppMethodBeat.i(127621);
    if (!dmj())
    {
      AppMethodBeat.o(127621);
      return;
    }
    if (this.vKZ != 0L)
    {
      long l3 = bt.aQJ();
      ad.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.vLa), Long.valueOf(this.vKZ), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.vLa) {
          l1 = this.vLa;
        }
        if (l3 - this.vKZ < l1) {
          AppMethodBeat.o(127621);
        }
      }
      else if (l3 - this.vKZ < 60L)
      {
        AppMethodBeat.o(127621);
        return;
      }
    }
    this.vKZ = bt.aQJ();
    vLc = Fs();
    ad.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    if (!this.vLd) {
      vLb = com.tencent.mm.compatible.deviceinfo.q.aas();
    }
    String str2;
    String str3;
    for (Object localObject = new bn(paramInt, vLc, com.tencent.mm.compatible.deviceinfo.q.cH(true), vLb, null, null);; localObject = new bn(paramInt, str2, null, null, str3, (String)localObject))
    {
      g.aiU().a((com.tencent.mm.al.n)localObject, 0);
      AppMethodBeat.o(127621);
      return;
      String str1 = com.tencent.mm.compatible.deviceinfo.q.aaC();
      str2 = vLc;
      str3 = com.tencent.mm.compatible.deviceinfo.q.aaB();
      localObject = str1;
      if (str1 == "") {
        localObject = null;
      }
    }
  }
  
  public final int dmh()
  {
    AppMethodBeat.i(127620);
    if (!dmj())
    {
      AppMethodBeat.o(127620);
      return 0;
    }
    int i = this.hHz;
    AppMethodBeat.o(127620);
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127616);
    if (cXg == null)
    {
      paramc = new av(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127613);
          if (!g.ajA().aiK())
          {
            ad.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(127613);
            return true;
          }
          ad.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.JQ(0);
          }
          for (;;)
          {
            AppMethodBeat.o(127613);
            return true;
            b.this.JQ(3);
          }
        }
      }, true);
      cXg = paramc;
      paramc.az(30000L, 30000L);
    }
    g.aiU().a(813, this);
    g.ajB().a(this.hTD);
    AppMethodBeat.o(127616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127617);
    g.aiU().b(813, this);
    AppMethodBeat.o(127617);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(127618);
    cXg.stopTimer();
    cXg.az(86400000L, 86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.vLa = 60L;
      ad.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      JR(this.hHy);
      AppMethodBeat.o(127618);
      return;
    }
    paramString = (bn)paramn;
    this.vKY = true;
    this.hHz = paramString.hHz;
    this.type = paramString.type;
    this.hHy = paramString.hHy;
    if ((paramString.hHA < 60L) || (paramString.hHA > 86400L)) {}
    for (this.vLa = 28800L;; this.vLa = paramString.hHA)
    {
      ad.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.hHz), Integer.valueOf(this.hHy), Integer.valueOf(paramString.hHA) });
      JR(this.hHy);
      AppMethodBeat.o(127618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */