package com.tencent.mm.plugin.misc.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bu;
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
  implements i, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.misc.a.a
{
  private static String EWI = "";
  private static String EWJ = "";
  private static MTimerHandler timer = null;
  private boolean EWF;
  private long EWG;
  private long EWH;
  private boolean EWK;
  private final Map<Integer, Set<a.a>> EWL;
  private p lHL;
  private int lvg;
  private int lvh;
  private int type;
  
  public b()
  {
    AppMethodBeat.i(127615);
    this.EWF = false;
    this.lvg = 0;
    this.lvh = 0;
    this.type = 0;
    this.EWG = 0L;
    this.EWH = 60L;
    this.EWK = false;
    this.EWL = new HashMap();
    this.lHL = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(127614);
        for (;;)
        {
          try
          {
            if (!b.eSE())
            {
              b.a(b.this, 0);
              AppMethodBeat.o(127614);
              return;
            }
            if (b.b(b.this))
            {
              String str1 = "";
              Log.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", new Object[] { str1 });
              if ((b.b(b.this)) || (str1.equals(b.EWI))) {
                break label161;
              }
              Log.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", new Object[] { b.EWI, str1 });
              b.aPo(str1);
              if (paramAnonymousInt == 0) {
                break label204;
              }
              b.c(b.this);
              b.d(b.this);
              b.this.WF(2);
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
          String str2 = com.tencent.mm.compatible.deviceinfo.q.auF();
          continue;
          label161:
          str2 = b.eSF();
          if (!str2.equals(b.bzf()))
          {
            Log.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", new Object[] { b.bzf(), str2 });
            b.aPp(str2);
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
    this.EWK = bool1;
    AppMethodBeat.o(127615);
  }
  
  private static String SH()
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
  
  private static boolean eSD()
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
  
  private void ic(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(246718);
    Log.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", new Object[] { Integer.valueOf(paramInt1) });
    if (this.EWL == null)
    {
      AppMethodBeat.o(246718);
      return;
    }
    Iterator localIterator = this.EWL.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if ((((Integer)((Map.Entry)localObject).getKey()).intValue() & paramInt1) == 0) {}
      for (int i = 2;; i = 1)
      {
        localObject = ((Set)((Map.Entry)localObject).getValue()).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.a)((Iterator)localObject).next()).dM(i, paramInt2);
        }
        break;
      }
    }
    AppMethodBeat.o(246718);
  }
  
  public final int WE(int paramInt)
  {
    AppMethodBeat.i(127619);
    if (!eSD())
    {
      if ((!NetStatusUtil.isMobile(MMApplicationContext.getContext())) && (this.EWF))
      {
        if ((this.lvg & paramInt) == 0)
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
    WF(1);
    if (2 == this.type)
    {
      AppMethodBeat.o(127619);
      return 0;
    }
    if (this.EWF)
    {
      if ((this.lvg & paramInt) == 0)
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
  
  public final void WF(int paramInt)
  {
    AppMethodBeat.i(127621);
    if (!eSD())
    {
      AppMethodBeat.o(127621);
      return;
    }
    if (this.EWG != 0L)
    {
      long l3 = Util.nowSecond();
      Log.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.EWH), Long.valueOf(this.EWG), Long.valueOf(l3) });
      if (paramInt != 2)
      {
        long l2 = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
        long l1 = l2;
        if (l2 > this.EWH) {
          l1 = this.EWH;
        }
        if (l3 - this.EWG < l1) {
          AppMethodBeat.o(127621);
        }
      }
      else if (l3 - this.EWG < 60L)
      {
        AppMethodBeat.o(127621);
        return;
      }
    }
    this.EWG = Util.nowSecond();
    EWJ = SH();
    Log.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
    if (!this.EWK) {
      EWI = com.tencent.mm.compatible.deviceinfo.q.auF();
    }
    String str2;
    String str3;
    for (Object localObject = new bu(paramInt, EWJ, com.tencent.mm.compatible.deviceinfo.q.dR(true), EWI, null, null);; localObject = new bu(paramInt, str2, null, null, str3, (String)localObject))
    {
      h.aGY().a((com.tencent.mm.an.q)localObject, 0);
      AppMethodBeat.o(127621);
      return;
      String str1 = com.tencent.mm.compatible.deviceinfo.q.auQ();
      str2 = EWJ;
      str3 = com.tencent.mm.compatible.deviceinfo.q.auP();
      localObject = str1;
      if (str1 == "") {
        localObject = null;
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(246714);
    if (parama == null)
    {
      AppMethodBeat.o(246714);
      return;
    }
    if (!this.EWL.containsKey(Integer.valueOf(2))) {
      this.EWL.put(Integer.valueOf(2), new HashSet());
    }
    ((Set)this.EWL.get(Integer.valueOf(2))).add(parama);
    AppMethodBeat.o(246714);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(246715);
    if (parama == null)
    {
      AppMethodBeat.o(246715);
      return;
    }
    if (!this.EWL.containsKey(Integer.valueOf(2)))
    {
      AppMethodBeat.o(246715);
      return;
    }
    ((Set)this.EWL.get(Integer.valueOf(2))).remove(parama);
    AppMethodBeat.o(246715);
  }
  
  public final int eSB()
  {
    AppMethodBeat.i(127620);
    if (!eSD())
    {
      AppMethodBeat.o(127620);
      return 0;
    }
    int i = this.lvh;
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
          if (!h.aHE().aGM())
          {
            Log.w("MicroMsg.SimcardService", "account not init.");
            AppMethodBeat.o(127613);
            return true;
          }
          Log.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
          if (b.a(b.this) == 0L) {
            b.this.WF(0);
          }
          for (;;)
          {
            AppMethodBeat.o(127613);
            return true;
            b.this.WF(3);
          }
        }
      }, true);
      timer = paramc;
      paramc.startTimer(30000L);
    }
    h.aGY().a(813, this);
    h.aHF().a(this.lHL);
    AppMethodBeat.o(127616);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(127617);
    h.aGY().b(813, this);
    AppMethodBeat.o(127617);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(127618);
    timer.stopTimer();
    timer.startTimer(86400000L);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.EWH = 60L;
      Log.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + paramInt1 + "," + paramInt2 + ")");
      ic(this.lvg, 2);
      AppMethodBeat.o(127618);
      return;
    }
    paramString = (bu)paramq;
    this.EWF = true;
    this.lvh = paramString.lvh;
    this.type = paramString.type;
    this.lvg = paramString.lvg;
    if ((paramString.lvi < 60L) || (paramString.lvi > 86400L)) {}
    for (this.EWH = 28800L;; this.EWH = paramString.lvi)
    {
      Log.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", new Object[] { Integer.valueOf(this.type), Integer.valueOf(this.lvh), Integer.valueOf(this.lvg), Integer.valueOf(paramString.lvi) });
      ic(this.lvg, 3);
      AppMethodBeat.o(127618);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.b.b
 * JD-Core Version:    0.7.0.1
 */