package com.tencent.mm.plugin.misc.b;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static am byQ = null;
  private static String imsi = "";
  private int dWW = 0;
  private int dWX = 0;
  private n eiF = new b.2(this);
  private boolean mdV = false;
  private long mdW = 0L;
  private long mdX = 60L;
  private final Map<Integer, Set<Object>> mdY = new HashMap();
  private int type = 0;
  
  private static boolean bik()
  {
    if (!aq.isMobile(ae.getContext())) {}
    int i;
    do
    {
      return false;
      i = aq.getISPCode(ae.getContext());
      y.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", new Object[] { Integer.valueOf(i) });
    } while ((i != 46001) && (i != 46006) && (i != 46009));
    return true;
  }
  
  private static String bil()
  {
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
      if (bk.bl(localInetAddress.getHostAddress())) {
        return "127.0.0.1";
      }
      Object localObject1 = localInetAddress.getHostAddress();
      return localObject1;
    }
    catch (Exception localException) {}
    return "127.0.0.1";
  }
  
  private void tG(int paramInt)
  {
    y.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.mdY == null) {
      return;
    }
    Iterator localIterator = this.mdY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = ((Set)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  public final int bih()
  {
    if (!bik()) {}
    do
    {
      return 2;
      tF(1);
      if (2 == this.type) {
        return 0;
      }
      if (!this.mdV) {
        break;
      }
    } while ((this.dWW & 0x2) == 0);
    return 1;
    return 0;
  }
  
  public final int bii()
  {
    return this.dWX;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    if (byQ == null)
    {
      paramc = new am(new am.a()
      {
        public final boolean tC()
        {
          if (!g.DN().Dc())
          {
            y.w("MicroMsg.SimcardService", "account not init.");
            return true;
          }
          y.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L)
          {
            b.this.tF(0);
            return true;
          }
          b.this.tF(3);
          return true;
        }
      }, true);
      byQ = paramc;
      paramc.S(30000L, 30000L);
    }
    g.Dk().a(813, this);
    g.DO().a(this.eiF);
  }
  
  public final void onAccountRelease()
  {
    g.Dk().b(813, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    byQ.stopTimer();
    byQ.S(86400000L, 86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.mdX = 60L;
      y.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      tG(this.dWW);
      return;
    }
    paramString = (bh)paramm;
    this.mdV = true;
    this.dWX = paramString.dWX;
    this.type = paramString.type;
    this.dWW = paramString.dWW;
    if ((paramString.dWY < 60L) || (paramString.dWY > 86400L)) {}
    for (this.mdX = 28800L;; this.mdX = paramString.dWY)
    {
      y.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.dWX), Integer.valueOf(this.dWW), Integer.valueOf(paramString.dWY) });
      tG(this.dWW);
      return;
    }
  }
  
  public final void tF(int paramInt)
  {
    if (!bik()) {}
    long l3;
    do
    {
      return;
      if (this.mdW == 0L) {
        break;
      }
      l3 = bk.UX();
      y.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.mdX), Long.valueOf(this.mdW), Long.valueOf(l3) });
      if (paramInt == 2) {
        break label180;
      }
      l2 = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
      l1 = l2;
      if (l2 > this.mdX) {
        l1 = this.mdX;
      }
    } while (l3 - this.mdW < l1);
    label180:
    while (l3 - this.mdW >= 60L)
    {
      long l2;
      long l1;
      this.mdW = bk.UX();
      imsi = q.zq();
      y.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
      bh localbh = new bh(paramInt, bil(), q.zf(), imsi);
      g.Dk().a(localbh, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */