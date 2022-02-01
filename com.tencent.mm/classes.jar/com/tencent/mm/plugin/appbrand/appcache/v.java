package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class v
  implements ac.b
{
  private static final ConcurrentHashMap<String, Boolean> jml;
  
  static
  {
    AppMethodBeat.i(44296);
    jml = new ConcurrentHashMap();
    AppMethodBeat.o(44296);
  }
  
  public static void HW(String paramString)
  {
    AppMethodBeat.i(44294);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44294);
      return;
    }
    jml.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(44294);
  }
  
  public final ac.a a(a parama)
  {
    AppMethodBeat.i(44293);
    if ((ay.class == parama.getClass()) || (at.class == parama.getClass()) || (au.class == parama.getClass()) || (bo.class == parama.getClass()))
    {
      parama = new a(parama, (byte)0);
      AppMethodBeat.o(44293);
      return parama;
    }
    AppMethodBeat.o(44293);
    return null;
  }
  
  static final class a
    implements ac.a
  {
    private final a jmn;
    private final int jmo;
    private final boolean jmp;
    private a jmq;
    private ArrayList<IDKey> jmr;
    private long jms;
    private long jmt;
    private long jmu;
    private kv_14609 jmv;
    
    private a(a parama)
    {
      AppMethodBeat.i(44278);
      this.jms = 0L;
      this.jmt = 0L;
      this.jmu = 0L;
      this.jmn = parama;
      int i;
      if (v.HX(parama.appId))
      {
        i = 776;
        this.jmo = i;
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
        this.jmp = bool;
        AppMethodBeat.o(44278);
        return;
        i = 368;
        break;
        i = parama.length;
        break label67;
      }
    }
    
    private void aWA()
    {
      AppMethodBeat.i(44281);
      try
      {
        e.wTc.b(this.jmr, false);
        this.jmr.clear();
        AppMethodBeat.o(44281);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(44281);
      }
    }
    
    private void dA(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44280);
      if (this.jmr == null) {
        this.jmr = new ArrayList();
      }
      this.jmr.add(new IDKey(paramInt1, paramInt2, 1));
      AppMethodBeat.o(44280);
    }
    
    private void rs(int paramInt)
    {
      AppMethodBeat.i(44279);
      dA(this.jmo, paramInt);
      AppMethodBeat.o(44279);
    }
    
    public final void a(com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(44285);
      long l = SystemClock.elapsedRealtime() - this.jms;
      int j;
      if ((paramm != null) && (paramm.status == 2))
      {
        j = 1;
        if (this.jmq != null) {}
        switch (v.1.jmm[this.jmq.ordinal()])
        {
        default: 
          if ((j == 0) && (!"@LibraryAppId".equals(this.jmn.appId)) && (999 != this.jmn.dib))
          {
            if ((paramm != null) && ((paramm.httpStatusCode == 404) || (paramm.httpStatusCode == 403)))
            {
              i = 23;
              label139:
              g.Q(this.jmn.appId, i, this.jmn.dib + 1);
            }
          }
          else {
            if (paramm == null) {
              break label530;
            }
          }
          break;
        }
      }
      try
      {
        if (paramm.status != 2) {
          break label530;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label173:
          ac.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.jmn.appId });
          label530:
          continue;
          if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_QUIC", false))
          {
            this.jmv.lUc = 1;
          }
          else if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_HTTP2", false))
          {
            this.jmv.lUc = 2;
          }
          else
          {
            this.jmv.lUc = 0;
            continue;
            if (paramm.httpStatusCode == 404)
            {
              this.jmv.dfm = 2;
            }
            else
            {
              this.jmv.dfm = 3;
              continue;
              this.jmv.lTP = i.aSp(this.jmn.getFilePath());
              if ((this.jmn instanceof au))
              {
                this.jmv.lTX = ((int)i.aSp(this.jmn.getFilePath()));
              }
              else
              {
                this.jmv.lTW = ((int)i.aSp(this.jmn.getFilePath()));
                continue;
                String str2 = "";
                continue;
                i = 2;
              }
            }
          }
        }
      }
      if (a.jmy != this.jmq)
      {
        if (a.jmA == this.jmq) {
          break label747;
        }
        for (;;)
        {
          g.a(str1, this.jmq.value, i, l, this.jmp);
          aWA();
          if (this.jmv != null)
          {
            if ((paramm != null) && (paramm.bundle != null))
            {
              if (!paramm.bundle.getBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", false)) {
                break label587;
              }
              this.jmv.lUc = 4;
              this.jmv.lTO = ((CdnLogic.WebPageProfile)paramm.bundle.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE"));
            }
            if (j != 0) {
              break label678;
            }
            this.jmv.btz();
            if (paramm == null) {
              break label667;
            }
            if (paramm.httpStatusCode != 410) {
              break label646;
            }
            this.jmv.dfm = 1;
            if ((this.jmn instanceof bo)) {
              this.jmv.lUb = l;
            }
            this.jmv.report();
            if ((this.jmv.lnW != null) && (this.jmv.lTO != null)) {
              h.a(this.jmv.lnW, this.jmv, this.jmn, this.jmv.lTO);
            }
            if ((!(this.jmn instanceof bo)) && (!(this.jmn instanceof au))) {
              this.jmv.lUa = l;
            }
          }
          AppMethodBeat.o(44285);
          return;
          j = 0;
          break;
          if (j != 0) {}
          for (i = 2;; i = 3)
          {
            rs(i);
            break;
          }
          if (j != 0) {}
          for (i = 11;; i = 12)
          {
            rs(i);
            break;
          }
          if (j != 0) {}
          for (i = 21;; i = 22)
          {
            rs(i);
            break;
          }
          if (j != 0) {}
          for (i = 36;; i = 37)
          {
            rs(i);
            break;
          }
          if (j != 0) {}
          for (i = 47;; i = 48)
          {
            rs(i);
            break;
          }
          i = 19;
          break label139;
          if ((paramm == null) || (paramm.status != 4)) {
            break label755;
          }
          i = 3;
          break label173;
          String str1 = this.jmn.appId;
        }
      }
    }
    
    public final void aWa()
    {
      int j = 0;
      AppMethodBeat.i(44282);
      Object localObject;
      label90:
      int i;
      if ((this.jmn instanceof au)) {
        if ("@LibraryAppId".equals(this.jmn.appId))
        {
          localObject = a.jmA;
          this.jmq = ((a)localObject);
          this.jmv = new kv_14609(this.jmn.appId, ((au)this.jmn).jnw, ((au)this.jmn).jnx);
          this.jmv.lTY = bs.eWj();
          switch (v.1.jmm[this.jmq.ordinal()])
          {
          default: 
            i = j;
          }
        }
      }
      for (;;)
      {
        rs(i);
        this.jms = SystemClock.elapsedRealtime();
        AppMethodBeat.o(44282);
        return;
        localObject = a.jmz;
        break;
        if ("@LibraryAppId".equals(this.jmn.appId))
        {
          this.jmq = a.jmy;
          break label90;
        }
        if (j.a.rq(this.jmn.dib))
        {
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.m.bH(this.jmn.appId, 1);
          if (localWxaPkgWrappingInfo != null)
          {
            localObject = a.jmx;
            label224:
            this.jmq = ((a)localObject);
            localObject = this.jmn.appId;
            if (localWxaPkgWrappingInfo != null) {
              break label284;
            }
          }
          label284:
          for (i = 0;; i = localWxaPkgWrappingInfo.pkgVersion)
          {
            this.jmv = new kv_14609((String)localObject, i, this.jmn.version);
            this.jmv.lTY = bs.eWj();
            break;
            localObject = a.jmw;
            break label224;
          }
        }
        if ((this.jmn instanceof at))
        {
          this.jmv = kv_14609.bR(this.jmn.appId, this.jmn.dib);
          this.jmv.lTY = bs.eWj();
        }
        this.jmq = a.jmw;
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
    
    public final void aWb()
    {
      AppMethodBeat.i(44283);
      rs(32);
      AppMethodBeat.o(44283);
    }
    
    public final void aWc()
    {
      AppMethodBeat.i(44284);
      switch (v.1.jmm[this.jmq.ordinal()])
      {
      }
      for (int i = 31;; i = 30)
      {
        rs(i);
        AppMethodBeat.o(44284);
        return;
      }
    }
    
    public final void aWd()
    {
      AppMethodBeat.i(44286);
      this.jmu = SystemClock.elapsedRealtime();
      dA(697, 1);
      AppMethodBeat.o(44286);
    }
    
    public final void aWe()
    {
      AppMethodBeat.i(44288);
      if ((a.jmy != this.jmq) && (a.jmA != this.jmq)) {
        g.Q(this.jmn.appId, 20, this.jmn.dib + 1);
      }
      AppMethodBeat.o(44288);
    }
    
    public final void aWf()
    {
      AppMethodBeat.i(44289);
      this.jmt = SystemClock.elapsedRealtime();
      switch (v.1.jmm[this.jmq.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(44289);
        return;
        rs(5);
        AppMethodBeat.o(44289);
        return;
        rs(14);
        AppMethodBeat.o(44289);
        return;
        rs(24);
        AppMethodBeat.o(44289);
        return;
        rs(41);
        AppMethodBeat.o(44289);
        return;
        rs(49);
      }
    }
    
    public final void aWg()
    {
      AppMethodBeat.i(44291);
      rs(56);
      AppMethodBeat.o(44291);
    }
    
    public final void fF(boolean paramBoolean)
    {
      AppMethodBeat.i(44290);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jmt;
      int i;
      String str;
      switch (v.1.jmm[this.jmq.ordinal()])
      {
      default: 
        i = 0;
        rs(i);
        if ((this.jmu > 0L) && (!paramBoolean)) {
          dA(697, 11);
        }
        aWA();
        if ((a.jmy == this.jmq) || (a.jmA == this.jmq))
        {
          str = "";
          label122:
          int j = this.jmq.value;
          if (!paramBoolean) {
            break label397;
          }
          i = 1;
          label136:
          g.a(str, j + 1, i, l1 - l2, this.jmp);
          if (!paramBoolean) {
            g.Q(this.jmn.appId, 22, this.jmn.dib + 1);
          }
          if (this.jmv != null)
          {
            this.jmv.btz();
            if ((this.jmq != a.jmz) && (this.jmq != a.jmA)) {
              break label402;
            }
            if (paramBoolean)
            {
              this.jmv.lTU = true;
              this.jmv.lTV = true;
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!paramBoolean) {
          this.jmv.dfm = 6;
        }
        this.jmv.report();
        if ((this.jmv.lnW != null) && (this.jmv.lTO != null)) {
          h.a(this.jmv.lnW, this.jmv, this.jmn, this.jmv.lTO);
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
        str = this.jmn.appId;
        break label122;
        label397:
        i = 2;
        break label136;
        label402:
        this.jmv.lTU = paramBoolean;
      }
    }
    
    public final void fG(boolean paramBoolean)
    {
      AppMethodBeat.i(44292);
      if (!paramBoolean) {
        rs(57);
      }
      for (;;)
      {
        if (this.jmv != null)
        {
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.jms;
          this.jmv.lUb = (l1 - l2);
        }
        AppMethodBeat.o(44292);
        return;
        if ((this.jmv != null) && ((this.jmn instanceof bo))) {
          this.jmv.lTW = ((int)i.aSp(((bo)this.jmn).aXs()));
        }
      }
    }
    
    public final void rr(int paramInt)
    {
      AppMethodBeat.i(44287);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jmu;
      au localau = (au)this.jmn;
      ac.i("MicroMsg.AppBrand.PkgDownloadReporterImpl", "onIncrementalMergeEnd, cost[%dms], appId[%s], version[%d->%d]", new Object[] { Long.valueOf(l1 - l2), localau.appId, Integer.valueOf(localau.jnw), Integer.valueOf(localau.jnx) });
      if (paramInt == 0)
      {
        dA(697, 2);
        aWA();
        if (this.jmv == null) {
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
      for (this.jmv.dfm = 4;; this.jmv.dfm = 5)
      {
        this.jmv.btz();
        this.jmv.report();
        if ((this.jmv.lnW == null) || (this.jmv.lTO == null)) {
          break label249;
        }
        h.a(this.jmv.lnW, this.jmv, this.jmn, this.jmv.lTO);
        AppMethodBeat.o(44287);
        return;
        if (paramInt < 0)
        {
          dA(697, -paramInt);
          break;
        }
        if (paramInt != 1) {
          break;
        }
        dA(697, 10);
        break;
      }
      label228:
      this.jmv.lTW = ((int)i.aSp(((au)this.jmn).aWR()));
      label249:
      AppMethodBeat.o(44287);
    }
    
    static enum a
    {
      final int value;
      
      static
      {
        AppMethodBeat.i(44277);
        jmw = new a("DOWNLOAD", 0, 1);
        jmx = new a("UPDATE", 1, 4);
        jmy = new a("LIB_UPDATE", 2, 7);
        jmz = new a("INCREMENTAL_UPDATE", 3, 10);
        jmA = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
        jmB = new a[] { jmw, jmx, jmy, jmz, jmA };
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */