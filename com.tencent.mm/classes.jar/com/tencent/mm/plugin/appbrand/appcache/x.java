package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class x
  implements ae.b
{
  private static final ConcurrentHashMap<String, Boolean> kLf;
  
  static
  {
    AppMethodBeat.i(44296);
    kLf = new ConcurrentHashMap();
    AppMethodBeat.o(44296);
  }
  
  public static void Va(String paramString)
  {
    AppMethodBeat.i(44294);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44294);
      return;
    }
    kLf.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(44294);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(226357);
    if (parama == null)
    {
      AppMethodBeat.o(226357);
      return false;
    }
    if ((ba.class == parama.getClass()) || (av.class == parama.getClass()) || (aw.class == parama.getClass()) || (bs.class == parama.getClass()))
    {
      AppMethodBeat.o(226357);
      return true;
    }
    AppMethodBeat.o(226357);
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
    private final a eiu;
    private final int kLh;
    private final boolean kLi;
    private a kLj;
    private ArrayList<IDKey> kLk;
    private long kLl;
    private long kLm;
    private long kLn;
    private kv_14609 kLo;
    
    private a(a parama)
    {
      AppMethodBeat.i(44278);
      this.kLl = 0L;
      this.kLm = 0L;
      this.kLn = 0L;
      this.eiu = parama;
      int i;
      if (x.Vb(parama.appId))
      {
        i = 776;
        this.kLh = i;
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
        this.kLi = bool;
        AppMethodBeat.o(44278);
        return;
        i = 368;
        break;
        i = parama.length;
        break label67;
      }
    }
    
    private void bvI()
    {
      AppMethodBeat.i(44281);
      try
      {
        e.Cxv.b(this.kLk, false);
        this.kLk.clear();
        AppMethodBeat.o(44281);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(44281);
      }
    }
    
    private void dM(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44280);
      if (this.kLk == null) {
        this.kLk = new ArrayList();
      }
      this.kLk.add(new IDKey(paramInt1, paramInt2, 1));
      AppMethodBeat.o(44280);
    }
    
    private void vR(int paramInt)
    {
      AppMethodBeat.i(44279);
      dM(this.kLh, paramInt);
      AppMethodBeat.o(44279);
    }
    
    public final void a(com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(44285);
      long l = SystemClock.elapsedRealtime() - this.kLl;
      int j;
      if ((paramm != null) && (paramm.status == 2))
      {
        j = 1;
        if (this.kLj != null) {}
        switch (x.1.kLg[this.kLj.ordinal()])
        {
        default: 
          if ((j == 0) && (!"@LibraryAppId".equals(this.eiu.appId)) && (999 != this.eiu.dMe))
          {
            if ((paramm != null) && ((paramm.httpStatusCode == 404) || (paramm.httpStatusCode == 403)))
            {
              i = 23;
              label139:
              com.tencent.mm.plugin.appbrand.report.i.T(this.eiu.appId, i, this.eiu.dMe + 1);
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
          Log.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.eiu.appId });
          label546:
          continue;
          if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_QUIC", false))
          {
            this.kLo.nJP = 1;
          }
          else if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_HTTP2", false))
          {
            this.kLo.nJP = 2;
          }
          else
          {
            this.kLo.nJP = 0;
            continue;
            if (paramm.httpStatusCode == 404)
            {
              this.kLo.dIZ = 2;
            }
            else
            {
              this.kLo.dIZ = 3;
              continue;
              this.kLo.nJC = s.boW(this.eiu.getFilePath());
              if ((this.eiu instanceof aw))
              {
                this.kLo.nJK = ((int)s.boW(this.eiu.getFilePath()));
              }
              else
              {
                this.kLo.nJJ = ((int)s.boW(this.eiu.getFilePath()));
                continue;
                String str2 = "";
                continue;
                i = 2;
              }
            }
          }
        }
      }
      if (a.kLr != this.kLj)
      {
        if (a.kLt == this.kLj) {
          break label765;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.report.i.a(str1, this.kLj.value, i, l, this.kLi);
          bvI();
          if (this.kLo != null)
          {
            if ((paramm != null) && (paramm.bundle != null))
            {
              if (!paramm.bundle.getBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", false)) {
                break label603;
              }
              this.kLo.nJP = 4;
              this.kLo.nJB = ((CdnLogic.WebPageProfile)paramm.bundle.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE"));
              this.kLo.nJR = paramm.bundle.getBoolean("RESPONSE_KEY_USE_NEWDNS");
            }
            if (j != 0) {
              break label696;
            }
            this.kLo.bUP();
            if (paramm == null) {
              break label685;
            }
            if (paramm.httpStatusCode != 410) {
              break label664;
            }
            this.kLo.dIZ = 1;
            if ((this.eiu instanceof bs)) {
              this.kLo.nJO = l;
            }
            this.kLo.report();
            if ((this.kLo.mWO != null) && (this.kLo.nJB != null)) {
              com.tencent.mm.plugin.appbrand.report.quality.i.a(this.kLo.mWO, this.kLo, this.eiu, this.kLo.nJB);
            }
            if ((!(this.eiu instanceof bs)) && (!(this.eiu instanceof aw))) {
              this.kLo.nJN = l;
            }
          }
          AppMethodBeat.o(44285);
          return;
          j = 0;
          break;
          if (j != 0) {}
          for (i = 2;; i = 3)
          {
            vR(i);
            break;
          }
          if (j != 0) {}
          for (i = 11;; i = 12)
          {
            vR(i);
            break;
          }
          if (j != 0) {}
          for (i = 21;; i = 22)
          {
            vR(i);
            break;
          }
          if (j != 0) {}
          for (i = 36;; i = 37)
          {
            vR(i);
            break;
          }
          if (j != 0) {}
          for (i = 47;; i = 48)
          {
            vR(i);
            break;
          }
          i = 19;
          break label139;
          if ((paramm == null) || (paramm.status != 4)) {
            break label773;
          }
          i = 3;
          break label173;
          String str1 = this.eiu.appId;
        }
      }
    }
    
    public final void bvj()
    {
      int j = 0;
      AppMethodBeat.i(44282);
      Object localObject;
      label90:
      int i;
      if ((this.eiu instanceof aw)) {
        if ("@LibraryAppId".equals(this.eiu.appId))
        {
          localObject = a.kLt;
          this.kLj = ((a)localObject);
          this.kLo = new kv_14609(this.eiu.appId, ((aw)this.eiu).kMt, ((aw)this.eiu).kMu);
          this.kLo.nJL = Util.nowMilliSecond();
          switch (x.1.kLg[this.kLj.ordinal()])
          {
          default: 
            i = j;
          }
        }
      }
      for (;;)
      {
        vR(i);
        this.kLl = SystemClock.elapsedRealtime();
        AppMethodBeat.o(44282);
        return;
        localObject = a.kLs;
        break;
        if ("@LibraryAppId".equals(this.eiu.appId))
        {
          this.kLj = a.kLr;
          break label90;
        }
        if (j.a.vP(this.eiu.dMe))
        {
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.m.bS(this.eiu.appId, 1);
          if (localWxaPkgWrappingInfo != null)
          {
            localObject = a.kLq;
            label224:
            this.kLj = ((a)localObject);
            localObject = this.eiu.appId;
            if (localWxaPkgWrappingInfo != null) {
              break label284;
            }
          }
          label284:
          for (i = 0;; i = localWxaPkgWrappingInfo.pkgVersion)
          {
            this.kLo = new kv_14609((String)localObject, i, this.eiu.version);
            this.kLo.nJL = Util.nowMilliSecond();
            break;
            localObject = a.kLp;
            break label224;
          }
        }
        if ((this.eiu instanceof av))
        {
          this.kLo = kv_14609.ci(this.eiu.appId, this.eiu.dMe);
          this.kLo.nJL = Util.nowMilliSecond();
        }
        this.kLj = a.kLp;
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
    
    public final void bvk()
    {
      AppMethodBeat.i(44283);
      vR(32);
      AppMethodBeat.o(44283);
    }
    
    public final void bvl()
    {
      AppMethodBeat.i(226356);
      switch (x.1.kLg[this.kLj.ordinal()])
      {
      }
      for (int i = 34;; i = 33)
      {
        vR(i);
        AppMethodBeat.o(226356);
        return;
      }
    }
    
    public final void bvm()
    {
      AppMethodBeat.i(44286);
      this.kLn = SystemClock.elapsedRealtime();
      dM(697, 1);
      AppMethodBeat.o(44286);
    }
    
    public final void bvn()
    {
      AppMethodBeat.i(44288);
      if ((a.kLr != this.kLj) && (a.kLt != this.kLj)) {
        com.tencent.mm.plugin.appbrand.report.i.T(this.eiu.appId, 20, this.eiu.dMe + 1);
      }
      AppMethodBeat.o(44288);
    }
    
    public final void bvo()
    {
      AppMethodBeat.i(44289);
      this.kLm = SystemClock.elapsedRealtime();
      switch (x.1.kLg[this.kLj.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(44289);
        return;
        vR(5);
        AppMethodBeat.o(44289);
        return;
        vR(14);
        AppMethodBeat.o(44289);
        return;
        vR(24);
        AppMethodBeat.o(44289);
        return;
        vR(41);
        AppMethodBeat.o(44289);
        return;
        vR(49);
      }
    }
    
    public final void bvp()
    {
      AppMethodBeat.i(44291);
      vR(56);
      AppMethodBeat.o(44291);
    }
    
    public final void gE(boolean paramBoolean)
    {
      AppMethodBeat.i(44290);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.kLm;
      int i;
      String str;
      switch (x.1.kLg[this.kLj.ordinal()])
      {
      default: 
        i = 0;
        vR(i);
        if ((this.kLn > 0L) && (!paramBoolean)) {
          dM(697, 11);
        }
        if ((this.kLo != null) && (this.kLo.nJO > 0L) && (!paramBoolean)) {
          vR(58);
        }
        bvI();
        if ((a.kLr == this.kLj) || (a.kLt == this.kLj))
        {
          str = "";
          label151:
          int j = this.kLj.value;
          if (!paramBoolean) {
            break label426;
          }
          i = 1;
          label165:
          com.tencent.mm.plugin.appbrand.report.i.a(str, j + 1, i, l1 - l2, this.kLi);
          if (!paramBoolean) {
            com.tencent.mm.plugin.appbrand.report.i.T(this.eiu.appId, 22, this.eiu.dMe + 1);
          }
          if (this.kLo != null)
          {
            this.kLo.bUP();
            if ((this.kLj != a.kLs) && (this.kLj != a.kLt)) {
              break label431;
            }
            if (paramBoolean)
            {
              this.kLo.nJH = true;
              this.kLo.nJI = true;
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!paramBoolean) {
          this.kLo.dIZ = 6;
        }
        this.kLo.report();
        if ((this.kLo.mWO != null) && (this.kLo.nJB != null)) {
          com.tencent.mm.plugin.appbrand.report.quality.i.a(this.kLo.mWO, this.kLo, this.eiu, this.kLo.nJB);
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
        str = this.eiu.appId;
        break label151;
        label426:
        i = 2;
        break label165;
        label431:
        this.kLo.nJH = paramBoolean;
      }
    }
    
    public final void gF(boolean paramBoolean)
    {
      AppMethodBeat.i(44292);
      if (!paramBoolean) {
        vR(57);
      }
      for (;;)
      {
        if (this.kLo != null)
        {
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.kLl;
          this.kLo.nJO = (l1 - l2);
        }
        AppMethodBeat.o(44292);
        return;
        if ((this.kLo != null) && ((this.eiu instanceof bs))) {
          this.kLo.nJJ = ((int)s.boW(((bs)this.eiu).bwC()));
        }
      }
    }
    
    public final void vQ(int paramInt)
    {
      AppMethodBeat.i(44287);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.kLn;
      aw localaw = (aw)this.eiu;
      Log.i("MicroMsg.AppBrand.PkgDownloadReporterImpl", "onIncrementalMergeEnd, cost[%dms], appId[%s], version[%d->%d]", new Object[] { Long.valueOf(l1 - l2), localaw.appId, Integer.valueOf(localaw.kMt), Integer.valueOf(localaw.kMu) });
      if (paramInt == 0)
      {
        dM(697, 2);
        bvI();
        if (this.kLo == null) {
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
      for (this.kLo.dIZ = 4;; this.kLo.dIZ = 5)
      {
        this.kLo.bUP();
        this.kLo.report();
        if ((this.kLo.mWO == null) || (this.kLo.nJB == null)) {
          break label249;
        }
        com.tencent.mm.plugin.appbrand.report.quality.i.a(this.kLo.mWO, this.kLo, this.eiu, this.kLo.nJB);
        AppMethodBeat.o(44287);
        return;
        if (paramInt < 0)
        {
          dM(697, -paramInt);
          break;
        }
        if (paramInt != 1) {
          break;
        }
        dM(697, 10);
        break;
      }
      label228:
      this.kLo.nJJ = ((int)s.boW(((aw)this.eiu).bwb()));
      label249:
      AppMethodBeat.o(44287);
    }
    
    static enum a
    {
      final int value;
      
      static
      {
        AppMethodBeat.i(44277);
        kLp = new a("DOWNLOAD", 0, 1);
        kLq = new a("UPDATE", 1, 4);
        kLr = new a("LIB_UPDATE", 2, 7);
        kLs = new a("INCREMENTAL_UPDATE", 3, 10);
        kLt = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
        kLu = new a[] { kLp, kLq, kLr, kLs, kLt };
        AppMethodBeat.o(44277);
      }
      
      private a(int paramInt)
      {
        this.value = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x
 * JD-Core Version:    0.7.0.1
 */