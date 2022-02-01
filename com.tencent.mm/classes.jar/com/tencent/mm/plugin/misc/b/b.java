package com.tencent.mm.plugin.misc.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.m.e;
import com.tencent.mm.model.bm;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g, c, com.tencent.mm.plugin.misc.a.a
{
  private static au cLS = null;
  private static String uHW = "";
  private static String uHX = "";
  private com.tencent.mm.network.n hBi;
  private int hpg;
  private int hph;
  private int type;
  private boolean uHT;
  private long uHU;
  private long uHV;
  private boolean uHY;
  private final Map<Integer, Set<Object>> uHZ;
  
  public b()
  {
    AppMethodBeat.i(127615);
    this.uHT = false;
    this.hpg = 0;
    this.hph = 0;
    this.type = 0;
    this.uHU = 0L;
    this.uHV = 60L;
    this.uHY = false;
    this.uHZ = new HashMap();
    this.hBi = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(127614);
        for (;;)
        {
          try
          {
            if (!b.dcQ())
            {
              b.a(b.this, 0);
              AppMethodBeat.o(127614);
              return;
            }
            if (b.b(b.this))
            {
              String str1 = "";
              ac.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
              if ((b.b(b.this)) || (str1.equals(b.uHW))) {
                break label161;
              }
              ac.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.uHW, str1 });
              b.alP(str1);
              if (paramAnonymousInt == 0) {
                break label204;
              }
              b.c(b.this);
              b.d(b.this);
              b.this.It(2);
              AppMethodBeat.o(127614);
              return;
            }
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.SimcardService", localException, "", new Object[0]);
            AppMethodBeat.o(127614);
            return;
          }
          String str2 = com.tencent.mm.compatible.deviceinfo.q.XR();
          continue;
          label161:
          str2 = b.dcR();
          if (!str2.equals(b.dcS()))
          {
            ac.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.dcS(), str2 });
            b.alQ(str2);
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
    this.uHY = bool1;
    AppMethodBeat.o(127615);
  }
  
  private static String DS()
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
      if (bs.isNullOrNil(localInetAddress.getHostAddress()))
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
  
  private void Iu(int paramInt)
  {
    AppMethodBeat.i(127622);
    ac.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.uHZ == null)
    {
      AppMethodBeat.o(127622);
      return;
    }
    Iterator localIterator = this.uHZ.entrySet().iterator();
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
  
  private static boolean dcP()
  {
    AppMethodBeat.i(127623);
    if (!ax.isMobile(ai.getContext()))
    {
      AppMethodBeat.o(127623);
      return false;
    }
    int i = ax.getISPCode(ai.getContext());
    ac.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 46001) || (i == 46006) || (i == 46009))
    {
      AppMethodBeat.o(127623);
      return true;
    }
    AppMethodBeat.o(127623);
    return false;
  }
  
  public final int Is(int paramInt)
  {
    AppMethodBeat.i(127619);
    if (!dcP())
    {
      if ((!ax.isMobile(ai.getContext())) && (this.uHT))
      {
        if ((this.hpg & paramInt) == 0)
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
    It(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(127619);
      return 0;
    }
    if (this.uHT)
    {
      if ((this.hpg & paramInt) == 0)
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
  
  public final void It(int paramInt)
  {
    AppMethodBeat.i(127621);
    if (!dcP())
    {
      AppMethodBeat.o(127621);
      return;
    }
    if (this.uHU != 0L)
    {
      long l3 = bs.aNx();
      ac.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.uHV), Long.valueOf(this.uHU), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.uHV) {
          l1 = this.uHV;
        }
        if (l3 - this.uHU < l1) {
          AppMethodBeat.o(127621);
        }
      }
      else if (l3 - this.uHU < 60L)
      {
        AppMethodBeat.o(127621);
        return;
      }
    }
    this.uHU = bs.aNx();
    uHX = DS();
    ac.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    if (!this.uHY) {
      uHW = com.tencent.mm.compatible.deviceinfo.q.XR();
    }
    String str2;
    String str3;
    for (Object localObject = new bm(paramInt, uHX, com.tencent.mm.compatible.deviceinfo.q.cF(true), uHW, null, null);; localObject = new bm(paramInt, str2, null, null, str3, (String)localObject))
    {
      com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
      AppMethodBeat.o(127621);
      return;
      String str1 = com.tencent.mm.compatible.deviceinfo.q.getOAID();
      str2 = uHX;
      str3 = com.tencent.mm.compatible.deviceinfo.q.Ya();
      localObject = str1;
      if (str1 == "") {
        localObject = null;
      }
    }
  }
  
  public final int dcN()
  {
    AppMethodBeat.i(127620);
    if (!dcP())
    {
      AppMethodBeat.o(127620);
      return 0;
    }
    int i = this.hph;
    AppMethodBeat.o(127620);
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127616);
    if (cLS == null)
    {
      paramc = new au(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127613);
          if (!com.tencent.mm.kernel.g.agP().afY())
          {
            ac.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(127613);
            return true;
          }
          ac.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.It(0);
          }
          for (;;)
          {
            AppMethodBeat.o(127613);
            return true;
            b.this.It(3);
          }
        }
      }, true);
      cLS = paramc;
      paramc.au(30000L, 30000L);
    }
    com.tencent.mm.kernel.g.agi().a(813, this);
    com.tencent.mm.kernel.g.agQ().a(this.hBi);
    AppMethodBeat.o(127616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127617);
    com.tencent.mm.kernel.g.agi().b(813, this);
    AppMethodBeat.o(127617);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(127618);
    cLS.stopTimer();
    cLS.au(86400000L, 86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.uHV = 60L;
      ac.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      Iu(this.hpg);
      AppMethodBeat.o(127618);
      return;
    }
    paramString = (bm)paramn;
    this.uHT = true;
    this.hph = paramString.hph;
    this.type = paramString.type;
    this.hpg = paramString.hpg;
    if ((paramString.hpi < 60L) || (paramString.hpi > 86400L)) {}
    for (this.uHV = 28800L;; this.uHV = paramString.hpi)
    {
      ac.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.hph), Integer.valueOf(this.hpg), Integer.valueOf(paramString.hpi) });
      Iu(this.hpg);
      AppMethodBeat.o(127618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */