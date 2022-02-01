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

public final class v
  implements ac.b
{
  private static final ConcurrentHashMap<String, Boolean> iMe;
  
  static
  {
    AppMethodBeat.i(44296);
    iMe = new ConcurrentHashMap();
    AppMethodBeat.o(44296);
  }
  
  public static void DT(String paramString)
  {
    AppMethodBeat.i(44294);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44294);
      return;
    }
    iMe.put(paramString, Boolean.TRUE);
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
    private final a iMg;
    private final int iMh;
    private final boolean iMi;
    private a iMj;
    private ArrayList<IDKey> iMk;
    private long iMl;
    private long iMm;
    private long iMn;
    private kv_14609 iMo;
    
    private a(a parama)
    {
      AppMethodBeat.i(44278);
      this.iMl = 0L;
      this.iMm = 0L;
      this.iMn = 0L;
      this.iMg = parama;
      int i;
      if (v.DU(parama.appId))
      {
        i = 776;
        this.iMh = i;
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
        this.iMi = bool;
        AppMethodBeat.o(44278);
        return;
        i = 368;
        break;
        i = parama.length;
        break label67;
      }
    }
    
    private void aPI()
    {
      AppMethodBeat.i(44281);
      try
      {
        e.vIY.b(this.iMk, false);
        this.iMk.clear();
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
      if (this.iMk == null) {
        this.iMk = new ArrayList();
      }
      this.iMk.add(new IDKey(paramInt1, paramInt2, 1));
      AppMethodBeat.o(44280);
    }
    
    private void qF(int paramInt)
    {
      AppMethodBeat.i(44279);
      dA(this.iMh, paramInt);
      AppMethodBeat.o(44279);
    }
    
    public final void a(com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(44285);
      long l = SystemClock.elapsedRealtime() - this.iMl;
      int j;
      if ((paramm != null) && (paramm.status == 2))
      {
        j = 1;
        if (this.iMj != null) {}
        switch (v.1.iMf[this.iMj.ordinal()])
        {
        default: 
          if ((j == 0) && (!"@LibraryAppId".equals(this.iMg.appId)) && (999 != this.iMg.dkC))
          {
            if ((paramm != null) && ((paramm.httpStatusCode == 404) || (paramm.httpStatusCode == 403)))
            {
              i = 23;
              label139:
              com.tencent.mm.plugin.appbrand.report.h.R(this.iMg.appId, i, this.iMg.dkC + 1);
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
          ad.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.iMg.appId });
          label530:
          continue;
          if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_QUIC", false))
          {
            this.iMo.lsi = 1;
          }
          else if (paramm.bundle.getBoolean("RESPONSE_KEY_USE_HTTP2", false))
          {
            this.iMo.lsi = 2;
          }
          else
          {
            this.iMo.lsi = 0;
            continue;
            if (paramm.httpStatusCode == 404)
            {
              this.iMo.dhR = 2;
            }
            else
            {
              this.iMo.dhR = 3;
              continue;
              this.iMo.lrU = i.aMN(this.iMg.getFilePath());
              if ((this.iMg instanceof au))
              {
                this.iMo.lsc = ((int)i.aMN(this.iMg.getFilePath()));
              }
              else
              {
                this.iMo.lsb = ((int)i.aMN(this.iMg.getFilePath()));
                continue;
                String str2 = "";
                continue;
                i = 2;
              }
            }
          }
        }
      }
      if (a.iMr != this.iMj)
      {
        if (a.iMt == this.iMj) {
          break label747;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.report.h.a(str1, this.iMj.value, i, l, this.iMi);
          aPI();
          if (this.iMo != null)
          {
            if ((paramm != null) && (paramm.bundle != null))
            {
              if (!paramm.bundle.getBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", false)) {
                break label587;
              }
              this.iMo.lsi = 4;
              this.iMo.lrT = ((CdnLogic.WebPageProfile)paramm.bundle.getParcelable("RESPONSE_KEY_CRONET_PERFORMANCE"));
            }
            if (j != 0) {
              break label678;
            }
            this.iMo.bmD();
            if (paramm == null) {
              break label667;
            }
            if (paramm.httpStatusCode != 410) {
              break label646;
            }
            this.iMo.dhR = 1;
            if ((this.iMg instanceof bo)) {
              this.iMo.lsh = l;
            }
            this.iMo.report();
            if ((this.iMo.kMz != null) && (this.iMo.lrT != null)) {
              com.tencent.mm.plugin.appbrand.report.quality.h.a(this.iMo.kMz, this.iMo, this.iMg, this.iMo.lrT);
            }
            if ((!(this.iMg instanceof bo)) && (!(this.iMg instanceof au))) {
              this.iMo.lsg = l;
            }
          }
          AppMethodBeat.o(44285);
          return;
          j = 0;
          break;
          if (j != 0) {}
          for (i = 2;; i = 3)
          {
            qF(i);
            break;
          }
          if (j != 0) {}
          for (i = 11;; i = 12)
          {
            qF(i);
            break;
          }
          if (j != 0) {}
          for (i = 21;; i = 22)
          {
            qF(i);
            break;
          }
          if (j != 0) {}
          for (i = 36;; i = 37)
          {
            qF(i);
            break;
          }
          if (j != 0) {}
          for (i = 47;; i = 48)
          {
            qF(i);
            break;
          }
          i = 19;
          break label139;
          if ((paramm == null) || (paramm.status != 4)) {
            break label755;
          }
          i = 3;
          break label173;
          String str1 = this.iMg.appId;
        }
      }
    }
    
    public final void aPi()
    {
      int j = 0;
      AppMethodBeat.i(44282);
      Object localObject;
      label90:
      int i;
      if ((this.iMg instanceof au)) {
        if ("@LibraryAppId".equals(this.iMg.appId))
        {
          localObject = a.iMt;
          this.iMj = ((a)localObject);
          this.iMo = new kv_14609(this.iMg.appId, ((au)this.iMg).iNo, ((au)this.iMg).iNp);
          this.iMo.lsd = bt.eGO();
          switch (v.1.iMf[this.iMj.ordinal()])
          {
          default: 
            i = j;
          }
        }
      }
      for (;;)
      {
        qF(i);
        this.iMl = SystemClock.elapsedRealtime();
        AppMethodBeat.o(44282);
        return;
        localObject = a.iMs;
        break;
        if ("@LibraryAppId".equals(this.iMg.appId))
        {
          this.iMj = a.iMr;
          break label90;
        }
        if (j.a.qD(this.iMg.dkC))
        {
          WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.m.bD(this.iMg.appId, 1);
          if (localWxaPkgWrappingInfo != null)
          {
            localObject = a.iMq;
            label224:
            this.iMj = ((a)localObject);
            localObject = this.iMg.appId;
            if (localWxaPkgWrappingInfo != null) {
              break label284;
            }
          }
          label284:
          for (i = 0;; i = localWxaPkgWrappingInfo.pkgVersion)
          {
            this.iMo = new kv_14609((String)localObject, i, this.iMg.version);
            this.iMo.lsd = bt.eGO();
            break;
            localObject = a.iMp;
            break label224;
          }
        }
        if ((this.iMg instanceof at))
        {
          this.iMo = kv_14609.bN(this.iMg.appId, this.iMg.dkC);
          this.iMo.lsd = bt.eGO();
        }
        this.iMj = a.iMp;
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
    
    public final void aPj()
    {
      AppMethodBeat.i(44283);
      qF(32);
      AppMethodBeat.o(44283);
    }
    
    public final void aPk()
    {
      AppMethodBeat.i(44284);
      switch (v.1.iMf[this.iMj.ordinal()])
      {
      }
      for (int i = 31;; i = 30)
      {
        qF(i);
        AppMethodBeat.o(44284);
        return;
      }
    }
    
    public final void aPl()
    {
      AppMethodBeat.i(44286);
      this.iMn = SystemClock.elapsedRealtime();
      dA(697, 1);
      AppMethodBeat.o(44286);
    }
    
    public final void aPm()
    {
      AppMethodBeat.i(44288);
      if ((a.iMr != this.iMj) && (a.iMt != this.iMj)) {
        com.tencent.mm.plugin.appbrand.report.h.R(this.iMg.appId, 20, this.iMg.dkC + 1);
      }
      AppMethodBeat.o(44288);
    }
    
    public final void aPn()
    {
      AppMethodBeat.i(44289);
      this.iMm = SystemClock.elapsedRealtime();
      switch (v.1.iMf[this.iMj.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(44289);
        return;
        qF(5);
        AppMethodBeat.o(44289);
        return;
        qF(14);
        AppMethodBeat.o(44289);
        return;
        qF(24);
        AppMethodBeat.o(44289);
        return;
        qF(41);
        AppMethodBeat.o(44289);
        return;
        qF(49);
      }
    }
    
    public final void aPo()
    {
      AppMethodBeat.i(44291);
      qF(56);
      AppMethodBeat.o(44291);
    }
    
    public final void fj(boolean paramBoolean)
    {
      AppMethodBeat.i(44290);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.iMm;
      int i;
      String str;
      switch (v.1.iMf[this.iMj.ordinal()])
      {
      default: 
        i = 0;
        qF(i);
        aPI();
        if ((a.iMr == this.iMj) || (a.iMt == this.iMj))
        {
          str = "";
          label100:
          int j = this.iMj.value;
          if (!paramBoolean) {
            break label375;
          }
          i = 1;
          label114:
          com.tencent.mm.plugin.appbrand.report.h.a(str, j + 1, i, l1 - l2, this.iMi);
          if (!paramBoolean) {
            com.tencent.mm.plugin.appbrand.report.h.R(this.iMg.appId, 22, this.iMg.dkC + 1);
          }
          if (this.iMo != null)
          {
            this.iMo.bmD();
            if ((this.iMj != a.iMs) && (this.iMj != a.iMt)) {
              break label380;
            }
            if (paramBoolean)
            {
              this.iMo.lrZ = true;
              this.iMo.lsa = true;
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!paramBoolean) {
          this.iMo.dhR = 6;
        }
        this.iMo.report();
        if ((this.iMo.kMz != null) && (this.iMo.lrT != null)) {
          com.tencent.mm.plugin.appbrand.report.quality.h.a(this.iMo.kMz, this.iMo, this.iMg, this.iMo.lrT);
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
        str = this.iMg.appId;
        break label100;
        label375:
        i = 2;
        break label114;
        label380:
        this.iMo.lrZ = paramBoolean;
      }
    }
    
    public final void fk(boolean paramBoolean)
    {
      AppMethodBeat.i(44292);
      if (!paramBoolean) {
        qF(57);
      }
      for (;;)
      {
        if (this.iMo != null)
        {
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.iMl;
          this.iMo.lsh = (l1 - l2);
        }
        AppMethodBeat.o(44292);
        return;
        if ((this.iMo != null) && ((this.iMg instanceof bo))) {
          this.iMo.lsb = ((int)i.aMN(((bo)this.iMg).aQA()));
        }
      }
    }
    
    public final void qE(int paramInt)
    {
      AppMethodBeat.i(44287);
      SystemClock.elapsedRealtime();
      if (paramInt == 0)
      {
        dA(697, 2);
        aPI();
        if (this.iMo == null) {
          break label182;
        }
        if (paramInt == 0) {
          break label161;
        }
        if (paramInt != -4) {
          break label150;
        }
      }
      label150:
      for (this.iMo.dhR = 4;; this.iMo.dhR = 5)
      {
        this.iMo.bmD();
        this.iMo.report();
        if ((this.iMo.kMz == null) || (this.iMo.lrT == null)) {
          break label182;
        }
        com.tencent.mm.plugin.appbrand.report.quality.h.a(this.iMo.kMz, this.iMo, this.iMg, this.iMo.lrT);
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
      label161:
      this.iMo.lsb = ((int)i.aMN(((au)this.iMg).aPZ()));
      label182:
      AppMethodBeat.o(44287);
    }
    
    static enum a
    {
      final int value;
      
      static
      {
        AppMethodBeat.i(44277);
        iMp = new a("DOWNLOAD", 0, 1);
        iMq = new a("UPDATE", 1, 4);
        iMr = new a("LIB_UPDATE", 2, 7);
        iMs = new a("INCREMENTAL_UPDATE", 3, 10);
        iMt = new a("LIB_INCREMENTAL_UPDATE", 4, 13);
        iMu = new a[] { iMp, iMq, iMr, iMs, iMt };
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.v
 * JD-Core Version:    0.7.0.1
 */