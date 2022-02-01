package com.tencent.mm.plugin.misc.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.n.e;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static aw cYd = null;
  private static String vXf = "";
  private static String vXg = "";
  private int hKq;
  private int hKr;
  private com.tencent.mm.network.n hWv;
  private int type;
  private boolean vXc;
  private long vXd;
  private long vXe;
  private boolean vXh;
  private final Map<Integer, Set<Object>> vXi;
  
  public b()
  {
    AppMethodBeat.i(127615);
    this.vXc = false;
    this.hKq = 0;
    this.hKr = 0;
    this.type = 0;
    this.vXd = 0L;
    this.vXe = 60L;
    this.vXh = false;
    this.vXi = new HashMap();
    this.hWv = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(127614);
        for (;;)
        {
          try
          {
            if (!b.dpj())
            {
              b.a(b.this, 0);
              AppMethodBeat.o(127614);
              return;
            }
            if (b.b(b.this))
            {
              String str1 = "";
              ae.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
              if ((b.b(b.this)) || (str1.equals(b.vXf))) {
                break label161;
              }
              ae.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.vXf, str1 });
              b.arJ(str1);
              if (paramAnonymousInt == 0) {
                break label204;
              }
              b.c(b.this);
              b.d(b.this);
              b.this.Kq(2);
              AppMethodBeat.o(127614);
              return;
            }
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.SimcardService", localException, "", new Object[0]);
            AppMethodBeat.o(127614);
            return;
          }
          String str2 = com.tencent.mm.compatible.deviceinfo.q.aaB();
          continue;
          label161:
          str2 = b.dpk();
          if (!str2.equals(b.dcX()))
          {
            ae.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.dcX(), str2 });
            b.arK(str2);
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
    this.vXh = bool1;
    AppMethodBeat.o(127615);
  }
  
  private static String Fy()
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
      if (bu.isNullOrNil(localInetAddress.getHostAddress()))
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
  
  private void Kr(int paramInt)
  {
    AppMethodBeat.i(127622);
    ae.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.vXi == null)
    {
      AppMethodBeat.o(127622);
      return;
    }
    Iterator localIterator = this.vXi.entrySet().iterator();
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
  
  private static boolean dpi()
  {
    AppMethodBeat.i(127623);
    if (!az.isMobile(ak.getContext()))
    {
      AppMethodBeat.o(127623);
      return false;
    }
    int i = az.getISPCode(ak.getContext());
    ae.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", new Object[] { Integer.valueOf(i) });
    if ((i == 46001) || (i == 46006) || (i == 46009))
    {
      AppMethodBeat.o(127623);
      return true;
    }
    AppMethodBeat.o(127623);
    return false;
  }
  
  public final int Kp(int paramInt)
  {
    AppMethodBeat.i(127619);
    if (!dpi())
    {
      if ((!az.isMobile(ak.getContext())) && (this.vXc))
      {
        if ((this.hKq & paramInt) == 0)
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
    Kq(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(127619);
      return 0;
    }
    if (this.vXc)
    {
      if ((this.hKq & paramInt) == 0)
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
  
  public final void Kq(int paramInt)
  {
    AppMethodBeat.i(127621);
    if (!dpi())
    {
      AppMethodBeat.o(127621);
      return;
    }
    if (this.vXd != 0L)
    {
      long l3 = bu.aRi();
      ae.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.vXe), Long.valueOf(this.vXd), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.vXe) {
          l1 = this.vXe;
        }
        if (l3 - this.vXd < l1) {
          AppMethodBeat.o(127621);
        }
      }
      else if (l3 - this.vXd < 60L)
      {
        AppMethodBeat.o(127621);
        return;
      }
    }
    this.vXd = bu.aRi();
    vXg = Fy();
    ae.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    if (!this.vXh) {
      vXf = com.tencent.mm.compatible.deviceinfo.q.aaB();
    }
    String str2;
    String str3;
    for (Object localObject = new bp(paramInt, vXg, com.tencent.mm.compatible.deviceinfo.q.cH(true), vXf, null, null);; localObject = new bp(paramInt, str2, null, null, str3, (String)localObject))
    {
      g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
      AppMethodBeat.o(127621);
      return;
      String str1 = com.tencent.mm.compatible.deviceinfo.q.aaL();
      str2 = vXg;
      str3 = com.tencent.mm.compatible.deviceinfo.q.aaK();
      localObject = str1;
      if (str1 == "") {
        localObject = null;
      }
    }
  }
  
  public final int dpg()
  {
    AppMethodBeat.i(127620);
    if (!dpi())
    {
      AppMethodBeat.o(127620);
      return 0;
    }
    int i = this.hKr;
    AppMethodBeat.o(127620);
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127616);
    if (cYd == null)
    {
      paramc = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127613);
          if (!g.ajP().aiZ())
          {
            ae.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(127613);
            return true;
          }
          ae.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.Kq(0);
          }
          for (;;)
          {
            AppMethodBeat.o(127613);
            return true;
            b.this.Kq(3);
          }
        }
      }, true);
      cYd = paramc;
      paramc.ay(30000L, 30000L);
    }
    g.ajj().a(813, this);
    g.ajQ().a(this.hWv);
    AppMethodBeat.o(127616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127617);
    g.ajj().b(813, this);
    AppMethodBeat.o(127617);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(127618);
    cYd.stopTimer();
    cYd.ay(86400000L, 86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.vXe = 60L;
      ae.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      Kr(this.hKq);
      AppMethodBeat.o(127618);
      return;
    }
    paramString = (bp)paramn;
    this.vXc = true;
    this.hKr = paramString.hKr;
    this.type = paramString.type;
    this.hKq = paramString.hKq;
    if ((paramString.hKs < 60L) || (paramString.hKs > 86400L)) {}
    for (this.vXe = 28800L;; this.vXe = paramString.hKs)
    {
      ae.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.hKr), Integer.valueOf(this.hKq), Integer.valueOf(paramString.hKs) });
      Kr(this.hKq);
      AppMethodBeat.o(127618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */