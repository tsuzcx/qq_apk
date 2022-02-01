package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.WebPageProfile;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.regex.Pattern;

final class y$a
  implements af.a
{
  private final a gcK;
  private final int nFa;
  private final boolean nFb;
  private a nFc;
  private ArrayList<IDKey> nFd;
  private long nFe;
  private long nFf;
  private long nFg;
  private kv_14609 nFh;
  
  private y$a(a parama)
  {
    AppMethodBeat.i(44278);
    this.nFe = 0L;
    this.nFf = 0L;
    this.nFg = 0L;
    this.gcK = parama;
    int i;
    if (y.acL(parama.appId))
    {
      i = 776;
      this.nFa = i;
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
      this.nFb = bool;
      AppMethodBeat.o(44278);
      return;
      i = 368;
      break;
      i = parama.length;
      break label67;
    }
  }
  
  private void bGP()
  {
    AppMethodBeat.i(44281);
    try
    {
      f.Iyx.b(this.nFd, false);
      this.nFd.clear();
      AppMethodBeat.o(44281);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(44281);
    }
  }
  
  private void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44280);
    if (this.nFd == null) {
      this.nFd = new ArrayList();
    }
    this.nFd.add(new IDKey(paramInt1, paramInt2, 1));
    AppMethodBeat.o(44280);
  }
  
  private void zc(int paramInt)
  {
    AppMethodBeat.i(44279);
    ek(this.nFa, paramInt);
    AppMethodBeat.o(44279);
  }
  
  public final void a(com.tencent.mm.pluginsdk.k.a.c.l paraml)
  {
    AppMethodBeat.i(44285);
    long l = SystemClock.elapsedRealtime() - this.nFe;
    int j;
    if ((paraml != null) && (paraml.status == 2))
    {
      j = 1;
      if (this.nFc != null) {}
      switch (y.1.nEZ[this.nFc.ordinal()])
      {
      default: 
        if ((j == 0) && (!"@LibraryAppId".equals(this.gcK.appId)) && (999 != this.gcK.fES))
        {
          if ((paraml != null) && ((paraml.httpStatusCode == 404) || (paraml.httpStatusCode == 403)))
          {
            i = 23;
            label139:
            j.V(this.gcK.appId, i, this.gcK.fES + 1);
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
        Log.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.gcK.appId });
        label546:
        continue;
        if (paraml.bundle.getBoolean("RESPONSE_KEY_USE_QUIC", false))
        {
          this.nFh.qMc = 1;
        }
        else if (paraml.bundle.getBoolean("RESPONSE_KEY_USE_HTTP2", false))
        {
          this.nFh.qMc = 2;
        }
        else
        {
          this.nFh.qMc = 0;
          continue;
          if (paraml.httpStatusCode == 404)
          {
            this.nFh.fBP = 2;
          }
          else
          {
            this.nFh.fBP = 3;
            continue;
            this.nFh.qLO = u.bBQ(this.gcK.getFilePath());
            if ((this.gcK instanceof az))
            {
              this.nFh.qLX = ((int)u.bBQ(this.gcK.getFilePath()));
            }
            else
            {
              this.nFh.qLW = ((int)u.bBQ(this.gcK.getFilePath()));
              continue;
              String str2 = "";
              continue;
              i = 2;
            }
          }
        }
      }
    }
    if (a.nFk != this.nFc)
    {
      if (a.nFm == this.nFc) {
        break label765;
      }
      for (;;)
      {
        j.a(str1, this.nFc.value, i, l, this.nFb);
        bGP();
        if (this.nFh != null)
        {
          if ((paraml != null) && (paraml.bundle != null))
          {
            if (!paraml.bundle.getBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", false)) {
              break label603;
            }
            this.nFh.qMc = 4;
            this.nFh.qLN = ((CdnLogic.WebPageProfile)paraml.bundle.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE"));
            this.nFh.qMe = paraml.bundle.getBoolean("RESPONSE_KEY_USE_NEWDNS");
          }
          if (j != 0) {
            break label696;
          }
          this.nFh.cia();
          if (paraml == null) {
            break label685;
          }
          if (paraml.httpStatusCode != 410) {
            break label664;
          }
          this.nFh.fBP = 1;
          if ((this.gcK instanceof ca)) {
            this.nFh.qMb = l;
          }
          this.nFh.report();
          if ((this.nFh.pXg != null) && (this.nFh.qLN != null)) {
            i.a(this.nFh.pXg, this.nFh, this.gcK, this.nFh.qLN);
          }
          if ((!(this.gcK instanceof ca)) && (!(this.gcK instanceof az))) {
            this.nFh.qMa = l;
          }
        }
        AppMethodBeat.o(44285);
        return;
        j = 0;
        break;
        if (j != 0) {}
        for (i = 2;; i = 3)
        {
          zc(i);
          break;
        }
        if (j != 0) {}
        for (i = 11;; i = 12)
        {
          zc(i);
          break;
        }
        if (j != 0) {}
        for (i = 21;; i = 22)
        {
          zc(i);
          break;
        }
        if (j != 0) {}
        for (i = 36;; i = 37)
        {
          zc(i);
          break;
        }
        if (j != 0) {}
        for (i = 47;; i = 48)
        {
          zc(i);
          break;
        }
        i = 19;
        break label139;
        if ((paraml == null) || (paraml.status != 4)) {
          break label773;
        }
        i = 3;
        break label173;
        String str1 = this.gcK.appId;
      }
    }
  }
  
  public final void bGp()
  {
    int j = 0;
    AppMethodBeat.i(44282);
    Object localObject;
    label90:
    int i;
    if ((this.gcK instanceof az)) {
      if ("@LibraryAppId".equals(this.gcK.appId))
      {
        localObject = a.nFm;
        this.nFc = ((a)localObject);
        this.nFh = new kv_14609(this.gcK.appId, ((az)this.gcK).nGn, ((az)this.gcK).nGo);
        this.nFh.qLY = Util.nowMilliSecond();
        switch (y.1.nEZ[this.nFc.ordinal()])
        {
        default: 
          i = j;
        }
      }
    }
    for (;;)
    {
      zc(i);
      this.nFe = SystemClock.elapsedRealtime();
      AppMethodBeat.o(44282);
      return;
      localObject = a.nFl;
      break;
      if ("@LibraryAppId".equals(this.gcK.appId))
      {
        this.nFc = a.nFk;
        break label90;
      }
      if (j.a.za(this.gcK.fES))
      {
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.l.cq(this.gcK.appId, 1);
        if (localWxaPkgWrappingInfo != null)
        {
          localObject = a.nFj;
          label224:
          this.nFc = ((a)localObject);
          localObject = this.gcK.appId;
          if (localWxaPkgWrappingInfo != null) {
            break label284;
          }
        }
        label284:
        for (i = 0;; i = localWxaPkgWrappingInfo.pkgVersion)
        {
          this.nFh = new kv_14609((String)localObject, i, this.gcK.version);
          this.nFh.qLY = Util.nowMilliSecond();
          break;
          localObject = a.nFi;
          break label224;
        }
      }
      if ((this.gcK instanceof ay))
      {
        this.nFh = kv_14609.cH(this.gcK.appId, this.gcK.fES);
        this.nFh.qLY = Util.nowMilliSecond();
      }
      this.nFc = a.nFi;
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
  
  public final void bGq()
  {
    AppMethodBeat.i(44283);
    zc(32);
    AppMethodBeat.o(44283);
  }
  
  public final void bGr()
  {
    AppMethodBeat.i(274431);
    switch (y.1.nEZ[this.nFc.ordinal()])
    {
    }
    for (int i = 34;; i = 33)
    {
      zc(i);
      AppMethodBeat.o(274431);
      return;
    }
  }
  
  public final void bGs()
  {
    AppMethodBeat.i(44286);
    this.nFg = SystemClock.elapsedRealtime();
    ek(697, 1);
    AppMethodBeat.o(44286);
  }
  
  public final void bGt()
  {
    AppMethodBeat.i(44288);
    if ((a.nFk != this.nFc) && (a.nFm != this.nFc)) {
      j.V(this.gcK.appId, 20, this.gcK.fES + 1);
    }
    AppMethodBeat.o(44288);
  }
  
  public final void bGu()
  {
    AppMethodBeat.i(44289);
    this.nFf = SystemClock.elapsedRealtime();
    switch (y.1.nEZ[this.nFc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(44289);
      return;
      zc(5);
      AppMethodBeat.o(44289);
      return;
      zc(14);
      AppMethodBeat.o(44289);
      return;
      zc(24);
      AppMethodBeat.o(44289);
      return;
      zc(41);
      AppMethodBeat.o(44289);
      return;
      zc(49);
    }
  }
  
  public final void bGv()
  {
    AppMethodBeat.i(44291);
    zc(56);
    AppMethodBeat.o(44291);
  }
  
  public final void hp(boolean paramBoolean)
  {
    AppMethodBeat.i(44290);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.nFf;
    int i;
    String str;
    switch (y.1.nEZ[this.nFc.ordinal()])
    {
    default: 
      i = 0;
      zc(i);
      if ((this.nFg > 0L) && (!paramBoolean)) {
        ek(697, 11);
      }
      if ((this.nFh != null) && (this.nFh.qMb > 0L) && (!paramBoolean)) {
        zc(58);
      }
      bGP();
      if ((a.nFk == this.nFc) || (a.nFm == this.nFc))
      {
        str = "";
        label151:
        int j = this.nFc.value;
        if (!paramBoolean) {
          break label426;
        }
        i = 1;
        label165:
        j.a(str, j + 1, i, l1 - l2, this.nFb);
        if (!paramBoolean) {
          j.V(this.gcK.appId, 22, this.gcK.fES + 1);
        }
        if (this.nFh != null)
        {
          this.nFh.cia();
          if ((this.nFc != a.nFl) && (this.nFc != a.nFm)) {
            break label431;
          }
          if (paramBoolean)
          {
            this.nFh.qLU = true;
            this.nFh.qLV = true;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (!paramBoolean) {
        this.nFh.fBP = 6;
      }
      this.nFh.report();
      if ((this.nFh.pXg != null) && (this.nFh.qLN != null)) {
        i.a(this.nFh.pXg, this.nFh, this.gcK, this.nFh.qLN);
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
      str = this.gcK.appId;
      break label151;
      label426:
      i = 2;
      break label165;
      label431:
      this.nFh.qLU = paramBoolean;
    }
  }
  
  public final void hq(boolean paramBoolean)
  {
    AppMethodBeat.i(44292);
    if (!paramBoolean) {
      zc(57);
    }
    for (;;)
    {
      if (this.nFh != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = this.nFe;
        this.nFh.qMb = (l1 - l2);
      }
      AppMethodBeat.o(44292);
      return;
      if ((this.nFh != null) && ((this.gcK instanceof ca))) {
        this.nFh.qLW = ((int)u.bBQ(((ca)this.gcK).bHM()));
      }
    }
  }
  
  public final void zb(int paramInt)
  {
    AppMethodBeat.i(44287);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.nFg;
    az localaz = (az)this.gcK;
    Log.i("MicroMsg.AppBrand.PkgDownloadReporterImpl", "onIncrementalMergeEnd, cost[%dms], appId[%s], version[%d->%d]", new Object[] { Long.valueOf(l1 - l2), localaz.appId, Integer.valueOf(localaz.nGn), Integer.valueOf(localaz.nGo) });
    if (paramInt == 0)
    {
      ek(697, 2);
      bGP();
      if (this.nFh == null) {
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
    for (this.nFh.fBP = 4;; this.nFh.fBP = 5)
    {
      this.nFh.cia();
      this.nFh.report();
      if ((this.nFh.pXg == null) || (this.nFh.qLN == null)) {
        break label249;
      }
      i.a(this.nFh.pXg, this.nFh, this.gcK, this.nFh.qLN);
      AppMethodBeat.o(44287);
      return;
      if (paramInt < 0)
      {
        ek(697, -paramInt);
        break;
      }
      if (paramInt != 1) {
        break;
      }
      ek(697, 10);
      break;
    }
    label228:
    this.nFh.qLW = ((int)u.bBQ(((az)this.gcK).bHi()));
    label249:
    AppMethodBeat.o(44287);
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44277);
      nFi = new a("DOWNLOAD", 0, 1);
      nFj = new a("UPDATE", 1, 4);
      nFk = new a("LIB_UPDATE", 2, 7);
      nFl = new a("INCREMENTAL_UPDATE", 3, 10);
      nFm = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
      nFn = new a[] { nFi, nFj, nFk, nFl, nFm };
      AppMethodBeat.o(44277);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.y.a
 * JD-Core Version:    0.7.0.1
 */