package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class w
  implements ad.b
{
  private static final ConcurrentHashMap<String, Boolean> jGi;
  
  static
  {
    AppMethodBeat.i(44296);
    jGi = new ConcurrentHashMap();
    AppMethodBeat.o(44296);
  }
  
  public static void Lo(String paramString)
  {
    AppMethodBeat.i(44294);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44294);
      return;
    }
    jGi.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(44294);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(188011);
    if (parama == null)
    {
      AppMethodBeat.o(188011);
      return false;
    }
    if ((az.class == parama.getClass()) || (au.class == parama.getClass()) || (av.class == parama.getClass()) || (bq.class == parama.getClass()))
    {
      AppMethodBeat.o(188011);
      return true;
    }
    AppMethodBeat.o(188011);
    return false;
  }
  
  public final ad.a b(a parama)
  {
    AppMethodBeat.i(44293);
    if (a(parama))
    {
      parama = new a(parama, (byte)0);
      AppMethodBeat.o(44293);
      return parama;
    }
    AppMethodBeat.o(44293);
    return null;
  }
  
  static final class a
    implements ad.a
  {
    private final a dPc;
    private final int jGk;
    private final boolean jGl;
    private a jGm;
    private ArrayList<IDKey> jGn;
    private long jGo;
    private long jGp;
    private long jGq;
    private kv_14609 jGr;
    
    private a(a parama)
    {
      AppMethodBeat.i(44278);
      this.jGo = 0L;
      this.jGp = 0L;
      this.jGq = 0L;
      this.dPc = parama;
      int i;
      if (w.Lp(parama.appId))
      {
        i = 776;
        this.jGk = i;
        parama = parama.appId.split(Pattern.quote("$"));
        if (parama != null) {
          break label92;
        }
        i = -1;
        label67:
        if (i != 2) {
          break label98;
        }
      }
      label92:
      label98:
      for (boolean bool = true;; bool = false)
      {
        this.jGl = bool;
        AppMethodBeat.o(44278);
        return;
        i = 368;
        break;
        i = parama.length;
        break label67;
      }
    }
    
    private void aZV()
    {
      AppMethodBeat.i(44281);
      try
      {
        e.ygI.b(this.jGn, false);
        this.jGn.clear();
        AppMethodBeat.o(44281);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(44281);
      }
    }
    
    private void dC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44280);
      if (this.jGn == null) {
        this.jGn = new ArrayList();
      }
      this.jGn.add(new IDKey(paramInt1, paramInt2, 1));
      AppMethodBeat.o(44280);
    }
    
    private void rS(int paramInt)
    {
      AppMethodBeat.i(44279);
      dC(this.jGk, paramInt);
      AppMethodBeat.o(44279);
    }
    
    public final void a(com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(44285);
      long l = SystemClock.elapsedRealtime() - this.jGo;
      int j;
      if ((paramm != null) && (paramm.status == 2))
      {
        j = 1;
        if (this.jGm != null) {}
        switch (w.1.jGj[this.jGm.ordinal()])
        {
        default: 
          if ((j == 0) && (!"@LibraryAppId".equals(this.dPc.appId)) && (999 != this.dPc.dtF))
          {
            if ((paramm != null) && ((paramm.httpStatusCode == 404) || (paramm.httpStatusCode == 403)))
            {
              i = 23;
              label139:
              com.tencent.mm.plugin.appbrand.report.h.S(this.dPc.appId, i, this.dPc.dtF + 1);
            }
          }
          else {
            if (paramm == null) {
              break label546;
            }
          }
          break;
        }
      }
      try
      {
        if (paramm.status != 2) {
          break label546;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label173:
          ad.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.dPc.appId });
          label546:
          continue;
          if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_QUIC", false))
          {
            this.jGr.mtR = 1;
          }
          else if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_HTTP2", false))
          {
            this.jGr.mtR = 2;
          }
          else
          {
            this.jGr.mtR = 0;
            continue;
            if (paramm.httpStatusCode == 404)
            {
              this.jGr.dqI = 2;
            }
            else
            {
              this.jGr.dqI = 3;
              continue;
              this.jGr.mtE = i.aYo(this.dPc.getFilePath());
              if ((this.dPc instanceof av))
              {
                this.jGr.mtM = ((int)i.aYo(this.dPc.getFilePath()));
              }
              else
              {
                this.jGr.mtL = ((int)i.aYo(this.dPc.getFilePath()));
                continue;
                String str2 = "";
                continue;
                i = 2;
              }
            }
          }
        }
      }
      if (a.jGu != this.jGm)
      {
        if (a.jGw == this.jGm) {
          break label765;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.report.h.a(str1, this.jGm.value, i, l, this.jGl);
          aZV();
          if (this.jGr != null)
          {
            if ((paramm != null) && (paramm.bundle != null))
            {
              if (!paramm.bundle.getBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", false)) {
                break label603;
              }
              this.jGr.mtR = 4;
              this.jGr.mtD = ((CdnLogic.WebPageProfile)paramm.bundle.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE"));
              this.jGr.mtT = paramm.bundle.getBoolean("RESPONSE_KEY_USE_NEWDNS");
            }
            if (j != 0) {
              break label696;
            }
            this.jGr.bxE();
            if (paramm == null) {
              break label685;
            }
            if (paramm.httpStatusCode != 410) {
              break label664;
            }
            this.jGr.dqI = 1;
            if ((this.dPc instanceof bq)) {
              this.jGr.mtQ = l;
            }
            this.jGr.report();
            if ((this.jGr.lLo != null) && (this.jGr.mtD != null)) {
              com.tencent.mm.plugin.appbrand.report.quality.h.a(this.jGr.lLo, this.jGr, this.dPc, this.jGr.mtD);
            }
            if ((!(this.dPc instanceof bq)) && (!(this.dPc instanceof av))) {
              this.jGr.mtP = l;
            }
          }
          AppMethodBeat.o(44285);
          return;
          j = 0;
          break;
          if (j != 0) {}
          for (i = 2;; i = 3)
          {
            rS(i);
            break;
          }
          if (j != 0) {}
          for (i = 11;; i = 12)
          {
            rS(i);
            break;
          }
          if (j != 0) {}
          for (i = 21;; i = 22)
          {
            rS(i);
            break;
          }
          if (j != 0) {}
          for (i = 36;; i = 37)
          {
            rS(i);
            break;
          }
          if (j != 0) {}
          for (i = 47;; i = 48)
          {
            rS(i);
            break;
          }
          i = 19;
          break label139;
          if ((paramm == null) || (paramm.status != 4)) {
            break label773;
          }
          i = 3;
          break label173;
          String str1 = this.dPc.appId;
        }
      }
    }
    
    public final void aZA()
    {
      AppMethodBeat.i(44289);
      this.jGp = SystemClock.elapsedRealtime();
      switch (w.1.jGj[this.jGm.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(44289);
        return;
        rS(5);
        AppMethodBeat.o(44289);
        return;
        rS(14);
        AppMethodBeat.o(44289);
        return;
        rS(24);
        AppMethodBeat.o(44289);
        return;
        rS(41);
        AppMethodBeat.o(44289);
        return;
        rS(49);
      }
    }
    
    public final void aZB()
    {
      AppMethodBeat.i(44291);
      rS(56);
      AppMethodBeat.o(44291);
    }
    
    public final void aZv()
    {
      int j = 0;
      AppMethodBeat.i(44282);
      Object localObject;
      label90:
      int i;
      if ((this.dPc instanceof av)) {
        if ("@LibraryAppId".equals(this.dPc.appId))
        {
          localObject = a.jGw;
          this.jGm = ((a)localObject);
          this.jGr = new kv_14609(this.dPc.appId, ((av)this.dPc).jHt, ((av)this.dPc).jHu);
          this.jGr.mtN = bt.flT();
          switch (w.1.jGj[this.jGm.ordinal()])
          {
          default: 
            i = j;
          }
        }
      }
      for (;;)
      {
        rS(i);
        this.jGo = SystemClock.elapsedRealtime();
        AppMethodBeat.o(44282);
        return;
        localObject = a.jGv;
        break;
        if ("@LibraryAppId".equals(this.dPc.appId))
        {
          this.jGm = a.jGu;
          break label90;
        }
        if (j.a.rQ(this.dPc.dtF))
        {
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.m.bK(this.dPc.appId, 1);
          if (localWxaPkgWrappingInfo != null)
          {
            localObject = a.jGt;
            label224:
            this.jGm = ((a)localObject);
            localObject = this.dPc.appId;
            if (localWxaPkgWrappingInfo != null) {
              break label284;
            }
          }
          label284:
          for (i = 0;; i = localWxaPkgWrappingInfo.pkgVersion)
          {
            this.jGr = new kv_14609((String)localObject, i, this.dPc.version);
            this.jGr.mtN = bt.flT();
            break;
            localObject = a.jGs;
            break label224;
          }
        }
        if ((this.dPc instanceof au))
        {
          this.jGr = kv_14609.bU(this.dPc.appId, this.dPc.dtF);
          this.jGr.mtN = bt.flT();
        }
        this.jGm = a.jGs;
        break label90;
        i = 1;
        continue;
        i = 10;
        continue;
        i = 20;
        continue;
        i = 35;
        continue;
        i = 46;
      }
    }
    
    public final void aZw()
    {
      AppMethodBeat.i(44283);
      rS(32);
      AppMethodBeat.o(44283);
    }
    
    public final void aZx()
    {
      AppMethodBeat.i(44284);
      switch (w.1.jGj[this.jGm.ordinal()])
      {
      }
      for (int i = 31;; i = 30)
      {
        rS(i);
        AppMethodBeat.o(44284);
        return;
      }
    }
    
    public final void aZy()
    {
      AppMethodBeat.i(44286);
      this.jGq = SystemClock.elapsedRealtime();
      dC(697, 1);
      AppMethodBeat.o(44286);
    }
    
    public final void aZz()
    {
      AppMethodBeat.i(44288);
      if ((a.jGu != this.jGm) && (a.jGw != this.jGm)) {
        com.tencent.mm.plugin.appbrand.report.h.S(this.dPc.appId, 20, this.dPc.dtF + 1);
      }
      AppMethodBeat.o(44288);
    }
    
    public final void fJ(boolean paramBoolean)
    {
      AppMethodBeat.i(44290);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jGp;
      int i;
      String str;
      switch (w.1.jGj[this.jGm.ordinal()])
      {
      default: 
        i = 0;
        rS(i);
        if ((this.jGq > 0L) && (!paramBoolean)) {
          dC(697, 11);
        }
        if ((this.jGr != null) && (this.jGr.mtQ > 0L) && (!paramBoolean)) {
          rS(58);
        }
        aZV();
        if ((a.jGu == this.jGm) || (a.jGw == this.jGm))
        {
          str = "";
          label151:
          int j = this.jGm.value;
          if (!paramBoolean) {
            break label426;
          }
          i = 1;
          label165:
          com.tencent.mm.plugin.appbrand.report.h.a(str, j + 1, i, l1 - l2, this.jGl);
          if (!paramBoolean) {
            com.tencent.mm.plugin.appbrand.report.h.S(this.dPc.appId, 22, this.dPc.dtF + 1);
          }
          if (this.jGr != null)
          {
            this.jGr.bxE();
            if ((this.jGm != a.jGv) && (this.jGm != a.jGw)) {
              break label431;
            }
            if (paramBoolean)
            {
              this.jGr.mtJ = true;
              this.jGr.mtK = true;
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!paramBoolean) {
          this.jGr.dqI = 6;
        }
        this.jGr.report();
        if ((this.jGr.lLo != null) && (this.jGr.mtD != null)) {
          com.tencent.mm.plugin.appbrand.report.quality.h.a(this.jGr.lLo, this.jGr, this.dPc, this.jGr.mtD);
        }
        AppMethodBeat.o(44290);
        return;
        if (paramBoolean)
        {
          i = 6;
          break;
        }
        i = 7;
        break;
        if (paramBoolean)
        {
          i = 15;
          break;
        }
        i = 16;
        break;
        if (paramBoolean)
        {
          i = 25;
          break;
        }
        i = 26;
        break;
        if (paramBoolean)
        {
          i = 42;
          break;
        }
        i = 43;
        break;
        if (paramBoolean)
        {
          i = 50;
          break;
        }
        i = 51;
        break;
        str = this.dPc.appId;
        break label151;
        label426:
        i = 2;
        break label165;
        label431:
        this.jGr.mtJ = paramBoolean;
      }
    }
    
    public final void fK(boolean paramBoolean)
    {
      AppMethodBeat.i(44292);
      if (!paramBoolean) {
        rS(57);
      }
      for (;;)
      {
        if (this.jGr != null)
        {
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.jGo;
          this.jGr.mtQ = (l1 - l2);
        }
        AppMethodBeat.o(44292);
        return;
        if ((this.jGr != null) && ((this.dPc instanceof bq))) {
          this.jGr.mtL = ((int)i.aYo(((bq)this.dPc).baQ()));
        }
      }
    }
    
    public final void rR(int paramInt)
    {
      AppMethodBeat.i(44287);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jGq;
      av localav = (av)this.dPc;
      ad.i("MicroMsg.AppBrand.PkgDownloadReporterImpl", "onIncrementalMergeEnd, cost[%dms], appId[%s], version[%d->%d]", new Object[] { Long.valueOf(l1 - l2), localav.appId, Integer.valueOf(localav.jHt), Integer.valueOf(localav.jHu) });
      if (paramInt == 0)
      {
        dC(697, 2);
        aZV();
        if (this.jGr == null) {
          break label249;
        }
        if (paramInt == 0) {
          break label228;
        }
        if (paramInt != -4) {
          break label217;
        }
      }
      label217:
      for (this.jGr.dqI = 4;; this.jGr.dqI = 5)
      {
        this.jGr.bxE();
        this.jGr.report();
        if ((this.jGr.lLo == null) || (this.jGr.mtD == null)) {
          break label249;
        }
        com.tencent.mm.plugin.appbrand.report.quality.h.a(this.jGr.lLo, this.jGr, this.dPc, this.jGr.mtD);
        AppMethodBeat.o(44287);
        return;
        if (paramInt < 0)
        {
          dC(697, -paramInt);
          break;
        }
        if (paramInt != 1) {
          break;
        }
        dC(697, 10);
        break;
      }
      label228:
      this.jGr.mtL = ((int)i.aYo(((av)this.dPc).bao()));
      label249:
      AppMethodBeat.o(44287);
    }
    
    static enum a
    {
      final int value;
      
      static
      {
        AppMethodBeat.i(44277);
        jGs = new a("DOWNLOAD", 0, 1);
        jGt = new a("UPDATE", 1, 4);
        jGu = new a("LIB_UPDATE", 2, 7);
        jGv = new a("INCREMENTAL_UPDATE", 3, 10);
        jGw = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
        jGx = new a[] { jGs, jGt, jGu, jGv, jGw };
        AppMethodBeat.o(44277);
      }
      
      private a(int paramInt)
      {
        this.value = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */