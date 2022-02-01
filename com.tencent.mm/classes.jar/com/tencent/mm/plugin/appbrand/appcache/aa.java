package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.res.downloader.model.l;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class aa
  implements ag.b
{
  private static final ConcurrentHashMap<String, Boolean> qEU;
  
  static
  {
    AppMethodBeat.i(44296);
    qEU = new ConcurrentHashMap();
    AppMethodBeat.o(44296);
  }
  
  public static void Vj(String paramString)
  {
    AppMethodBeat.i(44294);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44294);
      return;
    }
    qEU.put(paramString, Boolean.TRUE);
    AppMethodBeat.o(44294);
  }
  
  public static boolean a(a parama)
  {
    AppMethodBeat.i(320269);
    if (parama == null)
    {
      AppMethodBeat.o(320269);
      return false;
    }
    if ((be.class == parama.getClass()) || (az.class == parama.getClass()) || (ba.class == parama.getClass()) || (bz.class == parama.getClass()))
    {
      AppMethodBeat.o(320269);
      return true;
    }
    AppMethodBeat.o(320269);
    return false;
  }
  
  public final ag.a b(a parama)
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
    implements ag.a
  {
    private final a ija;
    private final int qEW;
    private final boolean qEX;
    private a qEY;
    private ArrayList<IDKey> qEZ;
    private long qFa;
    private long qFb;
    private long qFc;
    private kv_14609 qFd;
    
    private a(a parama)
    {
      AppMethodBeat.i(44278);
      this.qFa = 0L;
      this.qFb = 0L;
      this.qFc = 0L;
      this.ija = parama;
      int i;
      if (aa.Vk(parama.appId))
      {
        i = 776;
        this.qEW = i;
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
        this.qEX = bool;
        AppMethodBeat.o(44278);
        return;
        i = 368;
        break;
        i = parama.length;
        break label67;
      }
    }
    
    private void cgn()
    {
      AppMethodBeat.i(44281);
      try
      {
        f.Ozc.b(this.qEZ, false);
        this.qEZ.clear();
        AppMethodBeat.o(44281);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(44281);
      }
    }
    
    private void fe(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(44280);
      if (this.qEZ == null) {
        this.qEZ = new ArrayList();
      }
      this.qEZ.add(new IDKey(paramInt1, paramInt2, 1));
      AppMethodBeat.o(44280);
    }
    
    private void zp(int paramInt)
    {
      AppMethodBeat.i(44279);
      fe(this.qEW, paramInt);
      AppMethodBeat.o(44279);
    }
    
    public final void a(l paraml)
    {
      AppMethodBeat.i(44285);
      long l = SystemClock.elapsedRealtime() - this.qFa;
      int j;
      if ((paraml != null) && (paraml.status == 2))
      {
        j = 1;
        if (this.qEY != null) {}
        switch (aa.1.qEV[this.qEY.ordinal()])
        {
        default: 
          if ((j == 0) && (!"@LibraryAppId".equals(this.ija.appId)) && (999 != this.ija.hJK))
          {
            if ((paraml != null) && ((paraml.httpStatusCode == 404) || (paraml.httpStatusCode == 403)))
            {
              i = 23;
              label139:
              j.Z(this.ija.appId, i, this.ija.hJK + 1);
            }
          }
          else {
            if (paraml == null) {
              break label546;
            }
          }
          break;
        }
      }
      try
      {
        if (paraml.status != 2) {
          break label546;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label173:
          Log.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.ija.appId });
          label546:
          continue;
          if (paraml.bundle.getBoolean("RESPONSE_KEY_USE_QUIC", false))
          {
            this.qFd.tQJ = 1;
          }
          else if (paraml.bundle.getBoolean("RESPONSE_KEY_USE_HTTP2", false))
          {
            this.qFd.tQJ = 2;
          }
          else
          {
            this.qFd.tQJ = 0;
            continue;
            if (paraml.httpStatusCode == 404)
            {
              this.qFd.hGE = 2;
            }
            else
            {
              this.qFd.hGE = 3;
              continue;
              this.qFd.tQv = y.bEl(this.ija.getFilePath());
              if ((this.ija instanceof ba))
              {
                this.qFd.tQE = ((int)y.bEl(this.ija.getFilePath()));
              }
              else
              {
                this.qFd.tQD = ((int)y.bEl(this.ija.getFilePath()));
                continue;
                String str2 = "";
                continue;
                i = 2;
              }
            }
          }
        }
      }
      if (a.qFg != this.qEY)
      {
        if (a.qFi == this.qEY) {
          break label765;
        }
        for (;;)
        {
          j.a(str1, this.qEY.value, i, l, this.qEX);
          cgn();
          if (this.qFd != null)
          {
            if ((paraml != null) && (paraml.bundle != null))
            {
              if (!paraml.bundle.getBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", false)) {
                break label603;
              }
              this.qFd.tQJ = 4;
              this.qFd.tQu = ((CdnLogic.WebPageProfile)paraml.bundle.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE"));
              this.qFd.tQL = paraml.bundle.getBoolean("RESPONSE_KEY_USE_NEWDNS");
            }
            if (j != 0) {
              break label696;
            }
            this.qFd.cIW();
            if (paraml == null) {
              break label685;
            }
            if (paraml.httpStatusCode != 410) {
              break label664;
            }
            this.qFd.hGE = 1;
            if ((this.ija instanceof bz)) {
              this.qFd.tQI = l;
            }
            this.qFd.report();
            if ((this.qFd.tbW != null) && (this.qFd.tQu != null)) {
              h.a(this.qFd.tbW, this.qFd, this.ija, this.qFd.tQu);
            }
            if ((!(this.ija instanceof bz)) && (!(this.ija instanceof ba))) {
              this.qFd.tQH = l;
            }
          }
          AppMethodBeat.o(44285);
          return;
          j = 0;
          break;
          if (j != 0) {}
          for (i = 2;; i = 3)
          {
            zp(i);
            break;
          }
          if (j != 0) {}
          for (i = 11;; i = 12)
          {
            zp(i);
            break;
          }
          if (j != 0) {}
          for (i = 21;; i = 22)
          {
            zp(i);
            break;
          }
          if (j != 0) {}
          for (i = 36;; i = 37)
          {
            zp(i);
            break;
          }
          if (j != 0) {}
          for (i = 47;; i = 48)
          {
            zp(i);
            break;
          }
          i = 19;
          break label139;
          if ((paraml == null) || (paraml.status != 4)) {
            break label773;
          }
          i = 3;
          break label173;
          String str1 = this.ija.appId;
        }
      }
    }
    
    public final void cfP()
    {
      int j = 1;
      AppMethodBeat.i(44282);
      Object localObject;
      if ((this.ija instanceof ba)) {
        label138:
        if ("@LibraryAppId".equals(this.ija.appId))
        {
          localObject = a.qFi;
          this.qEY = ((a)localObject);
          this.qFd = new kv_14609(this.ija.appId, ((ba)this.ija).qGg, ((ba)this.ija).qGh);
          this.qFd.tQF = Util.nowMilliSecond();
          label90:
          switch (aa.1.qEV[this.qEY.ordinal()])
          {
          default: 
            i = 0;
            zp(i);
            this.qFa = SystemClock.elapsedRealtime();
            if (this.ija.qIv != null)
            {
              this.qFd.tQM = this.ija.qIv.ZmB;
              localObject = this.qFd;
              if (!this.ija.qIv.ZmA) {
                break label442;
              }
            }
            break;
          }
        }
      }
      label293:
      label442:
      for (int i = j;; i = 0)
      {
        ((kv_14609)localObject).tQN = i;
        this.qFd.tQO = this.ija.qIv.ZmC;
        AppMethodBeat.o(44282);
        return;
        localObject = a.qFh;
        break;
        if ("@LibraryAppId".equals(this.ija.appId))
        {
          this.qEY = a.qFg;
          break label90;
        }
        if (k.a.zn(this.ija.hJK))
        {
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = m.cQ(this.ija.appId, 1);
          if (localWxaPkgWrappingInfo != null)
          {
            localObject = a.qFf;
            this.qEY = ((a)localObject);
            localObject = this.ija.appId;
            if (localWxaPkgWrappingInfo != null) {
              break label353;
            }
          }
          label353:
          for (i = 0;; i = localWxaPkgWrappingInfo.pkgVersion)
          {
            this.qFd = new kv_14609((String)localObject, i, this.ija.version);
            this.qFd.tQF = Util.nowMilliSecond();
            break;
            localObject = a.qFe;
            break label293;
          }
        }
        if ((this.ija instanceof az))
        {
          this.qFd = kv_14609.dg(this.ija.appId, this.ija.hJK);
          this.qFd.tQF = Util.nowMilliSecond();
        }
        this.qEY = a.qFe;
        break label90;
        i = 1;
        break label138;
        i = 10;
        break label138;
        i = 20;
        break label138;
        i = 35;
        break label138;
        i = 46;
        break label138;
      }
    }
    
    public final void cfQ()
    {
      AppMethodBeat.i(44283);
      zp(32);
      AppMethodBeat.o(44283);
    }
    
    public final void cfR()
    {
      AppMethodBeat.i(320285);
      switch (aa.1.qEV[this.qEY.ordinal()])
      {
      }
      for (int i = 34;; i = 33)
      {
        zp(i);
        AppMethodBeat.o(320285);
        return;
      }
    }
    
    public final void cfS()
    {
      AppMethodBeat.i(44286);
      this.qFc = SystemClock.elapsedRealtime();
      fe(697, 1);
      AppMethodBeat.o(44286);
    }
    
    public final void cfT()
    {
      AppMethodBeat.i(44288);
      if ((a.qFg != this.qEY) && (a.qFi != this.qEY)) {
        j.Z(this.ija.appId, 20, this.ija.hJK + 1);
      }
      AppMethodBeat.o(44288);
    }
    
    public final void cfU()
    {
      AppMethodBeat.i(44289);
      this.qFb = SystemClock.elapsedRealtime();
      switch (aa.1.qEV[this.qEY.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(44289);
        return;
        zp(5);
        AppMethodBeat.o(44289);
        return;
        zp(14);
        AppMethodBeat.o(44289);
        return;
        zp(24);
        AppMethodBeat.o(44289);
        return;
        zp(41);
        AppMethodBeat.o(44289);
        return;
        zp(49);
      }
    }
    
    public final void cfV()
    {
      AppMethodBeat.i(44291);
      zp(56);
      AppMethodBeat.o(44291);
    }
    
    public final void ig(boolean paramBoolean)
    {
      AppMethodBeat.i(44290);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.qFb;
      int i;
      String str;
      switch (aa.1.qEV[this.qEY.ordinal()])
      {
      default: 
        i = 0;
        zp(i);
        if ((this.qFc > 0L) && (!paramBoolean)) {
          fe(697, 11);
        }
        if ((this.qFd != null) && (this.qFd.tQI > 0L) && (!paramBoolean)) {
          zp(58);
        }
        cgn();
        if ((a.qFg == this.qEY) || (a.qFi == this.qEY))
        {
          str = "";
          label151:
          int j = this.qEY.value;
          if (!paramBoolean) {
            break label426;
          }
          i = 1;
          label165:
          j.a(str, j + 1, i, l1 - l2, this.qEX);
          if (!paramBoolean) {
            j.Z(this.ija.appId, 22, this.ija.hJK + 1);
          }
          if (this.qFd != null)
          {
            this.qFd.cIW();
            if ((this.qEY != a.qFh) && (this.qEY != a.qFi)) {
              break label431;
            }
            if (paramBoolean)
            {
              this.qFd.tQB = true;
              this.qFd.tQC = true;
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!paramBoolean) {
          this.qFd.hGE = 6;
        }
        this.qFd.report();
        if ((this.qFd.tbW != null) && (this.qFd.tQu != null)) {
          h.a(this.qFd.tbW, this.qFd, this.ija, this.qFd.tQu);
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
        str = this.ija.appId;
        break label151;
        label426:
        i = 2;
        break label165;
        label431:
        this.qFd.tQB = paramBoolean;
      }
    }
    
    public final void ih(boolean paramBoolean)
    {
      AppMethodBeat.i(44292);
      if (!paramBoolean) {
        zp(57);
      }
      for (;;)
      {
        if (this.qFd != null)
        {
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.qFa;
          this.qFd.tQI = (l1 - l2);
        }
        AppMethodBeat.o(44292);
        return;
        if ((this.qFd != null) && ((this.ija instanceof bz))) {
          this.qFd.tQD = ((int)y.bEl(((bz)this.ija).chi()));
        }
      }
    }
    
    public final void zo(int paramInt)
    {
      AppMethodBeat.i(44287);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.qFc;
      ba localba = (ba)this.ija;
      Log.i("MicroMsg.AppBrand.PkgDownloadReporterImpl", "onIncrementalMergeEnd, cost[%dms], appId[%s], version[%d->%d]", new Object[] { Long.valueOf(l1 - l2), localba.appId, Integer.valueOf(localba.qGg), Integer.valueOf(localba.qGh) });
      if (paramInt == 0)
      {
        fe(697, 2);
        cgn();
        if (this.qFd == null) {
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
      for (this.qFd.hGE = 4;; this.qFd.hGE = 5)
      {
        this.qFd.cIW();
        this.qFd.report();
        if ((this.qFd.tbW == null) || (this.qFd.tQu == null)) {
          break label249;
        }
        h.a(this.qFd.tbW, this.qFd, this.ija, this.qFd.tQu);
        AppMethodBeat.o(44287);
        return;
        if (paramInt < 0)
        {
          fe(697, -paramInt);
          break;
        }
        if (paramInt != 1) {
          break;
        }
        fe(697, 10);
        break;
      }
      label228:
      this.qFd.tQD = ((int)y.bEl(((ba)this.ija).cgF()));
      label249:
      AppMethodBeat.o(44287);
    }
    
    static enum a
    {
      final int value;
      
      static
      {
        AppMethodBeat.i(44277);
        qFe = new a("DOWNLOAD", 0, 1);
        qFf = new a("UPDATE", 1, 4);
        qFg = new a("LIB_UPDATE", 2, 7);
        qFh = new a("INCREMENTAL_UPDATE", 3, 10);
        qFi = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
        qFj = new a[] { qFe, qFf, qFg, qFh, qFi };
        AppMethodBeat.o(44277);
      }
      
      private a(int paramInt)
      {
        this.value = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */