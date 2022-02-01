package com.tencent.mm.plugin.misc.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bt;
import com.tencent.mm.n.f;
import com.tencent.mm.network.p;
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
  implements i, c, com.tencent.mm.plugin.misc.a.a
{
  private static MTimerHandler timer = null;
  private static String zrh = "";
  private static String zri = "";
  private int iFe;
  private int iFf;
  private p iRt;
  private int type;
  private boolean zre;
  private long zrf;
  private long zrg;
  private boolean zrj;
  private final Map<Integer, Set<a.a>> zrk;
  
  public b()
  {
    AppMethodBeat.i(127615);
    this.zre = false;
    this.iFe = 0;
    this.iFf = 0;
    this.type = 0;
    this.zrf = 0L;
    this.zrg = 60L;
    this.zrj = false;
    this.zrk = new HashMap();
    this.iRt = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(127614);
        for (;;)
        {
          try
          {
            if (!b.eiY())
            {
              b.a(b.this, 0);
              AppMethodBeat.o(127614);
              return;
            }
            if (b.b(b.this))
            {
              String str1 = "";
              Log.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
              if ((b.b(b.this)) || (str1.equals(b.zrh))) {
                break label161;
              }
              Log.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.zrh, str1 });
              b.aFe(str1);
              if (paramAnonymousInt == 0) {
                break label204;
              }
              b.c(b.this);
              b.d(b.this);
              b.this.Qs(2);
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
          String str2 = com.tencent.mm.compatible.deviceinfo.q.aoA();
          continue;
          label161:
          str2 = b.eiZ();
          if (!str2.equals(b.boU()))
          {
            Log.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.boU(), str2 });
            b.aFf(str2);
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
    this.zrj = bool1;
    AppMethodBeat.o(127615);
  }
  
  private static String Ph()
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
  
  private static boolean eiX()
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
  
  private void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199073);
    Log.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt1) });
    if (this.zrk == null)
    {
      AppMethodBeat.o(199073);
      return;
    }
    Iterator localIterator = this.zrk.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ((((Integer)((Map.Entry)localObject).getKey()).intValue() & paramInt1) == 0) {}
      for (int i = 2;; i = 1)
      {
        localObject = ((Set)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.a)((Iterator)localObject).next()).gX(i, paramInt2);
        }
        break;
      }
    }
    AppMethodBeat.o(199073);
  }
  
  public final int Qr(int paramInt)
  {
    AppMethodBeat.i(127619);
    if (!eiX())
    {
      if ((!NetStatusUtil.isMobile(MMApplicationContext.getContext())) && (this.zre))
      {
        if ((this.iFe & paramInt) == 0)
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
    Qs(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(127619);
      return 0;
    }
    if (this.zre)
    {
      if ((this.iFe & paramInt) == 0)
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
  
  public final void Qs(int paramInt)
  {
    AppMethodBeat.i(127621);
    if (!eiX())
    {
      AppMethodBeat.o(127621);
      return;
    }
    if (this.zrf != 0L)
    {
      long l3 = Util.nowSecond();
      Log.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.zrg), Long.valueOf(this.zrf), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.zrg) {
          l1 = this.zrg;
        }
        if (l3 - this.zrf < l1) {
          AppMethodBeat.o(127621);
        }
      }
      else if (l3 - this.zrf < 60L)
      {
        AppMethodBeat.o(127621);
        return;
      }
    }
    this.zrf = Util.nowSecond();
    zri = Ph();
    Log.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    if (!this.zrj) {
      zrh = com.tencent.mm.compatible.deviceinfo.q.aoA();
    }
    String str2;
    String str3;
    for (Object localObject = new bt(paramInt, zri, com.tencent.mm.compatible.deviceinfo.q.dr(true), zrh, null, null);; localObject = new bt(paramInt, str2, null, null, str3, (String)localObject))
    {
      g.azz().a((com.tencent.mm.ak.q)localObject, 0);
      AppMethodBeat.o(127621);
      return;
      String str1 = com.tencent.mm.compatible.deviceinfo.q.aoK();
      str2 = zri;
      str3 = com.tencent.mm.compatible.deviceinfo.q.aoJ();
      localObject = str1;
      if (str1 == "") {
        localObject = null;
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(199071);
    if (parama == null)
    {
      AppMethodBeat.o(199071);
      return;
    }
    if (!this.zrk.containsKey(Integer.valueOf(2))) {
      this.zrk.put(Integer.valueOf(2), new HashSet());
    }
    ((Set)this.zrk.get(Integer.valueOf(2))).add(parama);
    AppMethodBeat.o(199071);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(199072);
    if (parama == null)
    {
      AppMethodBeat.o(199072);
      return;
    }
    if (!this.zrk.containsKey(Integer.valueOf(2)))
    {
      AppMethodBeat.o(199072);
      return;
    }
    ((Set)this.zrk.get(Integer.valueOf(2))).remove(parama);
    AppMethodBeat.o(199072);
  }
  
  public final int eiV()
  {
    AppMethodBeat.i(127620);
    if (!eiX())
    {
      AppMethodBeat.o(127620);
      return 0;
    }
    int i = this.iFf;
    AppMethodBeat.o(127620);
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(127616);
    if (timer == null)
    {
      paramc = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(127613);
          if (!g.aAf().azp())
          {
            Log.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(127613);
            return true;
          }
          Log.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.Qs(0);
          }
          for (;;)
          {
            AppMethodBeat.o(127613);
            return true;
            b.this.Qs(3);
          }
        }
      }, true);
      timer = paramc;
      paramc.startTimer(30000L);
    }
    g.azz().a(813, this);
    g.aAg().a(this.iRt);
    AppMethodBeat.o(127616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127617);
    g.azz().b(813, this);
    AppMethodBeat.o(127617);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(127618);
    timer.stopTimer();
    timer.startTimer(86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.zrg = 60L;
      Log.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      gY(this.iFe, 2);
      AppMethodBeat.o(127618);
      return;
    }
    paramString = (bt)paramq;
    this.zre = true;
    this.iFf = paramString.iFf;
    this.type = paramString.type;
    this.iFe = paramString.iFe;
    if ((paramString.iFg < 60L) || (paramString.iFg > 86400L)) {}
    for (this.zrg = 28800L;; this.zrg = paramString.iFg)
    {
      Log.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.iFf), Integer.valueOf(this.iFe), Integer.valueOf(paramString.iFg) });
      gY(this.iFe, 3);
      AppMethodBeat.o(127618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */