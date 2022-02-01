package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class x
  implements ae.b
{
  private static final ConcurrentHashMap<String, Boolean> jJi;
  
  static
  {
    AppMethodBeat.i(44296);
    jJi = new ConcurrentHashMap();
    AppMethodBeat.o(44296);
  }
  
  public static void LR(String paramString)
  {
    AppMethodBeat.i(44294);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44294);
      return;
    }
    jJi.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(44294);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(222128);
    if (parama == null)
    {
      AppMethodBeat.o(222128);
      return false;
    }
    if ((ba.class == parama.getClass()) || (av.class == parama.getClass()) || (aw.class == parama.getClass()) || (bs.class == parama.getClass()))
    {
      AppMethodBeat.o(222128);
      return true;
    }
    AppMethodBeat.o(222128);
    return false;
  }
  
  public final ae.a b(a parama)
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
    implements ae.a
  {
    private final a dQs;
    private final int jJk;
    private final boolean jJl;
    private a jJm;
    private ArrayList<IDKey> jJn;
    private long jJo;
    private long jJp;
    private long jJq;
    private kv_14609 jJr;
    
    private a(a parama)
    {
      AppMethodBeat.i(44278);
      this.jJo = 0L;
      this.jJp = 0L;
      this.jJq = 0L;
      this.dQs = parama;
      int i;
      if (x.LS(parama.appId))
      {
        i = 776;
        this.jJk = i;
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
        this.jJl = bool;
        AppMethodBeat.o(44278);
        return;
        i = 368;
        break;
        i = parama.length;
        break label67;
      }
    }
    
    private void bau()
    {
      AppMethodBeat.i(44281);
      try
      {
        e.ywz.b(this.jJn, false);
        this.jJn.clear();
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
      if (this.jJn == null) {
        this.jJn = new ArrayList();
      }
      this.jJn.add(new IDKey(paramInt1, paramInt2, 1));
      AppMethodBeat.o(44280);
    }
    
    private void rV(int paramInt)
    {
      AppMethodBeat.i(44279);
      dC(this.jJk, paramInt);
      AppMethodBeat.o(44279);
    }
    
    public final void a(com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(44285);
      long l = SystemClock.elapsedRealtime() - this.jJo;
      int j;
      if ((paramm != null) && (paramm.status == 2))
      {
        j = 1;
        if (this.jJm != null) {}
        switch (x.1.jJj[this.jJm.ordinal()])
        {
        default: 
          if ((j == 0) && (!"@LibraryAppId".equals(this.dQs.appId)) && (999 != this.dQs.duK))
          {
            if ((paramm != null) && ((paramm.httpStatusCode == 404) || (paramm.httpStatusCode == 403)))
            {
              i = 23;
              label139:
              com.tencent.mm.plugin.appbrand.report.h.S(this.dQs.appId, i, this.dQs.duK + 1);
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
          ae.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.dQs.appId });
          label546:
          continue;
          if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_QUIC", false))
          {
            this.jJr.myO = 1;
          }
          else if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_HTTP2", false))
          {
            this.jJr.myO = 2;
          }
          else
          {
            this.jJr.myO = 0;
            continue;
            if (paramm.httpStatusCode == 404)
            {
              this.jJr.drN = 2;
            }
            else
            {
              this.jJr.drN = 3;
              continue;
              this.jJr.myB = o.aZR(this.dQs.getFilePath());
              if ((this.dQs instanceof aw))
              {
                this.jJr.myJ = ((int)o.aZR(this.dQs.getFilePath()));
              }
              else
              {
                this.jJr.myI = ((int)o.aZR(this.dQs.getFilePath()));
                continue;
                String str2 = "";
                continue;
                i = 2;
              }
            }
          }
        }
      }
      if (a.jJu != this.jJm)
      {
        if (a.jJw == this.jJm) {
          break label765;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.report.h.a(str1, this.jJm.value, i, l, this.jJl);
          bau();
          if (this.jJr != null)
          {
            if ((paramm != null) && (paramm.bundle != null))
            {
              if (!paramm.bundle.getBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", false)) {
                break label603;
              }
              this.jJr.myO = 4;
              this.jJr.myA = ((CdnLogic.WebPageProfile)paramm.bundle.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE"));
              this.jJr.myQ = paramm.bundle.getBoolean("RESPONSE_KEY_USE_NEWDNS");
            }
            if (j != 0) {
              break label696;
            }
            this.jJr.byx();
            if (paramm == null) {
              break label685;
            }
            if (paramm.httpStatusCode != 410) {
              break label664;
            }
            this.jJr.drN = 1;
            if ((this.dQs instanceof bs)) {
              this.jJr.myN = l;
            }
            this.jJr.report();
            if ((this.jJr.lPO != null) && (this.jJr.myA != null)) {
              com.tencent.mm.plugin.appbrand.report.quality.h.a(this.jJr.lPO, this.jJr, this.dQs, this.jJr.myA);
            }
            if ((!(this.dQs instanceof bs)) && (!(this.dQs instanceof aw))) {
              this.jJr.myM = l;
            }
          }
          AppMethodBeat.o(44285);
          return;
          j = 0;
          break;
          if (j != 0) {}
          for (i = 2;; i = 3)
          {
            rV(i);
            break;
          }
          if (j != 0) {}
          for (i = 11;; i = 12)
          {
            rV(i);
            break;
          }
          if (j != 0) {}
          for (i = 21;; i = 22)
          {
            rV(i);
            break;
          }
          if (j != 0) {}
          for (i = 36;; i = 37)
          {
            rV(i);
            break;
          }
          if (j != 0) {}
          for (i = 47;; i = 48)
          {
            rV(i);
            break;
          }
          i = 19;
          break label139;
          if ((paramm == null) || (paramm.status != 4)) {
            break label773;
          }
          i = 3;
          break label173;
          String str1 = this.dQs.appId;
        }
      }
    }
    
    public final void aZS()
    {
      int j = 0;
      AppMethodBeat.i(44282);
      Object localObject;
      label90:
      int i;
      if ((this.dQs instanceof aw)) {
        if ("@LibraryAppId".equals(this.dQs.appId))
        {
          localObject = a.jJw;
          this.jJm = ((a)localObject);
          this.jJr = new kv_14609(this.dQs.appId, ((aw)this.dQs).jKu, ((aw)this.dQs).jKv);
          this.jJr.myK = bu.fpO();
          switch (x.1.jJj[this.jJm.ordinal()])
          {
          default: 
            i = j;
          }
        }
      }
      for (;;)
      {
        rV(i);
        this.jJo = SystemClock.elapsedRealtime();
        AppMethodBeat.o(44282);
        return;
        localObject = a.jJv;
        break;
        if ("@LibraryAppId".equals(this.dQs.appId))
        {
          this.jJm = a.jJu;
          break label90;
        }
        if (j.a.rT(this.dQs.duK))
        {
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.m.bN(this.dQs.appId, 1);
          if (localWxaPkgWrappingInfo != null)
          {
            localObject = a.jJt;
            label224:
            this.jJm = ((a)localObject);
            localObject = this.dQs.appId;
            if (localWxaPkgWrappingInfo != null) {
              break label284;
            }
          }
          label284:
          for (i = 0;; i = localWxaPkgWrappingInfo.pkgVersion)
          {
            this.jJr = new kv_14609((String)localObject, i, this.dQs.version);
            this.jJr.myK = bu.fpO();
            break;
            localObject = a.jJs;
            break label224;
          }
        }
        if ((this.dQs instanceof av))
        {
          this.jJr = kv_14609.bY(this.dQs.appId, this.dQs.duK);
          this.jJr.myK = bu.fpO();
        }
        this.jJm = a.jJs;
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
    
    public final void aZT()
    {
      AppMethodBeat.i(44283);
      rV(32);
      AppMethodBeat.o(44283);
    }
    
    public final void aZU()
    {
      AppMethodBeat.i(44284);
      switch (x.1.jJj[this.jJm.ordinal()])
      {
      }
      for (int i = 31;; i = 30)
      {
        rV(i);
        AppMethodBeat.o(44284);
        return;
      }
    }
    
    public final void aZV()
    {
      AppMethodBeat.i(44286);
      this.jJq = SystemClock.elapsedRealtime();
      dC(697, 1);
      AppMethodBeat.o(44286);
    }
    
    public final void aZW()
    {
      AppMethodBeat.i(44288);
      if ((a.jJu != this.jJm) && (a.jJw != this.jJm)) {
        com.tencent.mm.plugin.appbrand.report.h.S(this.dQs.appId, 20, this.dQs.duK + 1);
      }
      AppMethodBeat.o(44288);
    }
    
    public final void aZX()
    {
      AppMethodBeat.i(44289);
      this.jJp = SystemClock.elapsedRealtime();
      switch (x.1.jJj[this.jJm.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(44289);
        return;
        rV(5);
        AppMethodBeat.o(44289);
        return;
        rV(14);
        AppMethodBeat.o(44289);
        return;
        rV(24);
        AppMethodBeat.o(44289);
        return;
        rV(41);
        AppMethodBeat.o(44289);
        return;
        rV(49);
      }
    }
    
    public final void aZY()
    {
      AppMethodBeat.i(44291);
      rV(56);
      AppMethodBeat.o(44291);
    }
    
    public final void fI(boolean paramBoolean)
    {
      AppMethodBeat.i(44290);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jJp;
      int i;
      String str;
      switch (x.1.jJj[this.jJm.ordinal()])
      {
      default: 
        i = 0;
        rV(i);
        if ((this.jJq > 0L) && (!paramBoolean)) {
          dC(697, 11);
        }
        if ((this.jJr != null) && (this.jJr.myN > 0L) && (!paramBoolean)) {
          rV(58);
        }
        bau();
        if ((a.jJu == this.jJm) || (a.jJw == this.jJm))
        {
          str = "";
          label151:
          int j = this.jJm.value;
          if (!paramBoolean) {
            break label426;
          }
          i = 1;
          label165:
          com.tencent.mm.plugin.appbrand.report.h.a(str, j + 1, i, l1 - l2, this.jJl);
          if (!paramBoolean) {
            com.tencent.mm.plugin.appbrand.report.h.S(this.dQs.appId, 22, this.dQs.duK + 1);
          }
          if (this.jJr != null)
          {
            this.jJr.byx();
            if ((this.jJm != a.jJv) && (this.jJm != a.jJw)) {
              break label431;
            }
            if (paramBoolean)
            {
              this.jJr.myG = true;
              this.jJr.myH = true;
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!paramBoolean) {
          this.jJr.drN = 6;
        }
        this.jJr.report();
        if ((this.jJr.lPO != null) && (this.jJr.myA != null)) {
          com.tencent.mm.plugin.appbrand.report.quality.h.a(this.jJr.lPO, this.jJr, this.dQs, this.jJr.myA);
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
        str = this.dQs.appId;
        break label151;
        label426:
        i = 2;
        break label165;
        label431:
        this.jJr.myG = paramBoolean;
      }
    }
    
    public final void fJ(boolean paramBoolean)
    {
      AppMethodBeat.i(44292);
      if (!paramBoolean) {
        rV(57);
      }
      for (;;)
      {
        if (this.jJr != null)
        {
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.jJo;
          this.jJr.myN = (l1 - l2);
        }
        AppMethodBeat.o(44292);
        return;
        if ((this.jJr != null) && ((this.dQs instanceof bs))) {
          this.jJr.myI = ((int)o.aZR(((bs)this.dQs).bbp()));
        }
      }
    }
    
    public final void rU(int paramInt)
    {
      AppMethodBeat.i(44287);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jJq;
      aw localaw = (aw)this.dQs;
      ae.i("MicroMsg.AppBrand.PkgDownloadReporterImpl", "onIncrementalMergeEnd, cost[%dms], appId[%s], version[%d->%d]", new Object[] { Long.valueOf(l1 - l2), localaw.appId, Integer.valueOf(localaw.jKu), Integer.valueOf(localaw.jKv) });
      if (paramInt == 0)
      {
        dC(697, 2);
        bau();
        if (this.jJr == null) {
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
      for (this.jJr.drN = 4;; this.jJr.drN = 5)
      {
        this.jJr.byx();
        this.jJr.report();
        if ((this.jJr.lPO == null) || (this.jJr.myA == null)) {
          break label249;
        }
        com.tencent.mm.plugin.appbrand.report.quality.h.a(this.jJr.lPO, this.jJr, this.dQs, this.jJr.myA);
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
      this.jJr.myI = ((int)o.aZR(((aw)this.dQs).baN()));
      label249:
      AppMethodBeat.o(44287);
    }
    
    static enum a
    {
      final int value;
      
      static
      {
        AppMethodBeat.i(44277);
        jJs = new a("DOWNLOAD", 0, 1);
        jJt = new a("UPDATE", 1, 4);
        jJu = new a("LIB_UPDATE", 2, 7);
        jJv = new a("INCREMENTAL_UPDATE", 3, 10);
        jJw = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
        jJx = new a[] { jJs, jJt, jJu, jJv, jJw };
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */