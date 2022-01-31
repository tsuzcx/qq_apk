package com.tencent.mm.plugin.misc.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.model.bj;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static ap caS = null;
  private static String oEu = "";
  private static String oEv = "";
  private int fne;
  private int fnf;
  private n fyJ;
  private boolean oEr;
  private long oEs;
  private long oEt;
  private final Map<Integer, Set<Object>> oEw;
  private int type;
  
  public b()
  {
    AppMethodBeat.i(50514);
    this.oEr = false;
    this.fne = 0;
    this.fnf = 0;
    this.type = 0;
    this.oEs = 0L;
    this.oEt = 60L;
    this.oEw = new HashMap();
    this.fyJ = new b.2(this);
    AppMethodBeat.o(50514);
  }
  
  private static boolean bQl()
  {
    AppMethodBeat.i(50522);
    if (!at.isMobile(ah.getContext()))
    {
      AppMethodBeat.o(50522);
      return false;
    }
    int i = at.getISPCode(ah.getContext());
    ab.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 46001) || (i == 46006) || (i == 46009))
    {
      AppMethodBeat.o(50522);
      return true;
    }
    AppMethodBeat.o(50522);
    return false;
  }
  
  private static String bQm()
  {
    AppMethodBeat.i(50523);
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
      if (bo.isNullOrNil(localInetAddress.getHostAddress()))
      {
        AppMethodBeat.o(50523);
        return "127.0.0.1";
      }
      Object localObject1 = localInetAddress.getHostAddress();
      AppMethodBeat.o(50523);
      return localObject1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50523);
    }
    return "127.0.0.1";
  }
  
  private void yY(int paramInt)
  {
    AppMethodBeat.i(50521);
    ab.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.oEw == null)
    {
      AppMethodBeat.o(50521);
      return;
    }
    Iterator localIterator = this.oEw.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = ((Set)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    AppMethodBeat.o(50521);
  }
  
  public final int bQj()
  {
    AppMethodBeat.i(50519);
    if (!bQl())
    {
      AppMethodBeat.o(50519);
      return 0;
    }
    int i = this.fnf;
    AppMethodBeat.o(50519);
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(50515);
    if (caS == null)
    {
      paramc = new ap(new ap.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(50512);
          if (!g.RJ().QU())
          {
            ab.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(50512);
            return true;
          }
          ab.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.yX(0);
          }
          for (;;)
          {
            AppMethodBeat.o(50512);
            return true;
            b.this.yX(3);
          }
        }
      }, true);
      caS = paramc;
      paramc.ag(30000L, 30000L);
    }
    g.Rc().a(813, this);
    g.RK().a(this.fyJ);
    AppMethodBeat.o(50515);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(50516);
    g.Rc().b(813, this);
    AppMethodBeat.o(50516);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(50517);
    caS.stopTimer();
    caS.ag(86400000L, 86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.oEt = 60L;
      ab.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      yY(this.fne);
      AppMethodBeat.o(50517);
      return;
    }
    paramString = (bj)paramm;
    this.oEr = true;
    this.fnf = paramString.fnf;
    this.type = paramString.type;
    this.fne = paramString.fne;
    if ((paramString.fng < 60L) || (paramString.fng > 86400L)) {}
    for (this.oEt = 28800L;; this.oEt = paramString.fng)
    {
      ab.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.fnf), Integer.valueOf(this.fne), Integer.valueOf(paramString.fng) });
      yY(this.fne);
      AppMethodBeat.o(50517);
      return;
    }
  }
  
  public final int yW(int paramInt)
  {
    AppMethodBeat.i(142688);
    if (!bQl())
    {
      AppMethodBeat.o(142688);
      return 2;
    }
    yX(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(142688);
      return 0;
    }
    if (this.oEr)
    {
      if ((this.fne & paramInt) == 0)
      {
        AppMethodBeat.o(142688);
        return 2;
      }
      AppMethodBeat.o(142688);
      return 1;
    }
    AppMethodBeat.o(142688);
    return 0;
  }
  
  public final void yX(int paramInt)
  {
    AppMethodBeat.i(50520);
    if (!bQl())
    {
      AppMethodBeat.o(50520);
      return;
    }
    if (this.oEs != 0L)
    {
      long l3 = bo.aox();
      ab.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.oEt), Long.valueOf(this.oEs), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.oEt) {
          l1 = this.oEt;
        }
        if (l3 - this.oEs < l1) {
          AppMethodBeat.o(50520);
        }
      }
      else if (l3 - this.oEs < 60L)
      {
        AppMethodBeat.o(50520);
        return;
      }
    }
    this.oEs = bo.aox();
    oEu = q.LE();
    oEv = bQm();
    ab.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    bj localbj = new bj(paramInt, oEv, q.bP(true), oEu);
    g.Rc().a(localbj, 0);
    AppMethodBeat.o(50520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */