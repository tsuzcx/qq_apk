package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.regex.Pattern;

final class m$a
  implements t.a
{
  private final a fCo;
  private final int fCp;
  private final boolean fCq;
  private m.a.a fCr;
  private ArrayList<IDKey> fCs;
  private long fCt = 0L;
  private long fCu = 0L;
  private long fCv = 0L;
  private kv_14609 fCw;
  
  private m$a(a parama)
  {
    this.fCo = parama;
    int i;
    if (m.qU(parama.appId))
    {
      i = 776;
      this.fCp = i;
      parama = parama.appId.split(Pattern.quote("$"));
      if (parama != null) {
        break label82;
      }
      i = -1;
      label62:
      if (i != 2) {
        break label88;
      }
    }
    label82:
    label88:
    for (boolean bool = true;; bool = false)
    {
      this.fCq = bool;
      return;
      i = 368;
      break;
      i = parama.length;
      break label62;
    }
  }
  
  private void abJ()
  {
    try
    {
      f.nEG.b(this.fCs, false);
      this.fCs.clear();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void bI(int paramInt1, int paramInt2)
  {
    if (this.fCs == null) {
      this.fCs = new ArrayList();
    }
    this.fCs.add(new IDKey(paramInt1, paramInt2, 1));
  }
  
  private void ks(int paramInt)
  {
    bI(this.fCp, paramInt);
  }
  
  public final void a(com.tencent.mm.pluginsdk.g.a.c.m paramm)
  {
    long l = SystemClock.elapsedRealtime() - this.fCt;
    int j;
    label68:
    int i;
    if ((paramm != null) && (paramm.status == 2))
    {
      j = 1;
      switch (m.1.fCn[this.fCr.ordinal()])
      {
      default: 
        if ((j == 0) && (!"@LibraryAppId".equals(this.fCo.appId)) && (999 != this.fCo.bOa))
        {
          if ((paramm != null) && ((paramm.httpStatusCode == 404) || (paramm.httpStatusCode == 403)))
          {
            i = 23;
            label127:
            c.H(this.fCo.appId, i, this.fCo.bOa + 1);
          }
        }
        else {
          if (paramm == null) {
            break label381;
          }
        }
        break;
      }
    }
    for (;;)
    {
      try
      {
        if (paramm.status != 2) {
          continue;
        }
        i = 1;
        if (m.a.a.fCz == this.fCr) {
          break label548;
        }
        if (m.a.a.fCB != this.fCr) {
          continue;
        }
      }
      catch (Exception localException)
      {
        String str1;
        label381:
        y.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", localException, "report onEnd, appId %s", new Object[] { this.fCo.appId });
        continue;
        if (paramm.httpStatusCode != 410) {
          continue;
        }
        this.fCw.mn(1);
        continue;
        if (paramm.httpStatusCode != 404) {
          continue;
        }
        this.fCw.mn(2);
        continue;
        this.fCw.mn(3);
        continue;
        this.fCw.mn(0);
        continue;
        if (!(this.fCo instanceof af)) {
          continue;
        }
        this.fCw.gZD = com.tencent.mm.a.e.bJ(this.fCo.bjl());
        return;
        this.fCw.gZC = com.tencent.mm.a.e.bJ(this.fCo.bjl());
        return;
      }
      c.a(str1, this.fCr.value, i, l, this.fCq);
      AppBrandPerformanceManager.w(this.fCo.appId, l);
      abJ();
      if (this.fCw != null)
      {
        if (j != 0) {
          continue;
        }
        this.fCw.aot();
        if (!(this.fCo instanceof af)) {
          continue;
        }
        if (paramm == null)
        {
          this.fCw.mn(3);
          this.fCw.wn();
        }
      }
      else
      {
        return;
        j = 0;
        break;
        if (j != 0)
        {
          i = 2;
          ks(i);
          break label68;
        }
        i = 3;
        continue;
        if (j != 0)
        {
          i = 11;
          ks(i);
          break label68;
        }
        i = 12;
        continue;
        if (j != 0)
        {
          i = 21;
          ks(i);
          break label68;
        }
        i = 22;
        continue;
        if (j != 0)
        {
          i = 36;
          ks(i);
          break label68;
        }
        i = 37;
        continue;
        if (j != 0)
        {
          i = 47;
          ks(i);
          break label68;
        }
        i = 48;
        continue;
        i = 19;
        break label127;
        if ((paramm == null) || (paramm.status != 4)) {
          break label555;
        }
        i = 3;
        continue;
        str1 = this.fCo.appId;
        continue;
      }
      label548:
      String str2 = "";
      continue;
      label555:
      i = 2;
    }
  }
  
  public final void abq()
  {
    int j = 0;
    Object localObject;
    label84:
    int i;
    if ((this.fCo instanceof af)) {
      if ("@LibraryAppId".equals(this.fCo.appId))
      {
        localObject = m.a.a.fCB;
        this.fCr = ((m.a.a)localObject);
        this.fCw = new kv_14609(this.fCo.appId, ((af)this.fCo).fDk, ((af)this.fCo).fDl);
        this.fCw.gZE = bk.UY();
        switch (m.1.fCn[this.fCr.ordinal()])
        {
        default: 
          i = j;
        }
      }
    }
    for (;;)
    {
      ks(i);
      this.fCt = SystemClock.elapsedRealtime();
      return;
      localObject = m.a.a.fCA;
      break;
      if ("@LibraryAppId".equals(this.fCo.appId))
      {
        this.fCr = m.a.a.fCz;
        break label84;
      }
      if (d.a.kq(this.fCo.bOa))
      {
        WxaPkgWrappingInfo localWxaPkgWrappingInfo = com.tencent.mm.plugin.appbrand.launching.e.aU(this.fCo.appId, 1);
        if (localWxaPkgWrappingInfo != null)
        {
          localObject = m.a.a.fCy;
          label210:
          this.fCr = ((m.a.a)localObject);
          localObject = this.fCo.appId;
          if (localWxaPkgWrappingInfo != null) {
            break label270;
          }
        }
        label270:
        for (i = 0;; i = localWxaPkgWrappingInfo.fEN)
        {
          this.fCw = new kv_14609((String)localObject, i, this.fCo.version);
          this.fCw.gZE = bk.UY();
          break;
          localObject = m.a.a.fCx;
          break label210;
        }
      }
      this.fCr = m.a.a.fCx;
      break label84;
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
  
  public final void abr()
  {
    ks(32);
  }
  
  public final void abs()
  {
    switch (m.1.fCn[this.fCr.ordinal()])
    {
    }
    for (int i = 31;; i = 30)
    {
      ks(i);
      return;
    }
  }
  
  public final void abt()
  {
    this.fCv = SystemClock.elapsedRealtime();
    bI(697, 1);
  }
  
  public final void abu()
  {
    if ((m.a.a.fCz != this.fCr) && (m.a.a.fCB != this.fCr)) {
      c.H(this.fCo.appId, 20, this.fCo.bOa + 1);
    }
  }
  
  public final void abv()
  {
    this.fCu = SystemClock.elapsedRealtime();
    switch (m.1.fCn[this.fCr.ordinal()])
    {
    default: 
      return;
    case 1: 
      ks(5);
      return;
    case 2: 
      ks(14);
      return;
    case 3: 
      ks(24);
      return;
    case 4: 
      ks(41);
      return;
    }
    ks(49);
  }
  
  public final void cG(boolean paramBoolean)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.fCu;
    int i;
    String str;
    switch (m.1.fCn[this.fCr.ordinal()])
    {
    default: 
      i = 0;
      ks(i);
      abJ();
      if ((m.a.a.fCz == this.fCr) || (m.a.a.fCB == this.fCr))
      {
        str = "";
        label91:
        int j = this.fCr.value;
        if (!paramBoolean) {
          break label302;
        }
        i = 1;
        label105:
        c.a(str, j + 1, i, l1 - l2, this.fCq);
        if (!paramBoolean) {
          c.H(this.fCo.appId, 22, this.fCo.bOa + 1);
        }
        if (this.fCw != null)
        {
          this.fCw.aot();
          if ((this.fCr != m.a.a.fCA) && (this.fCr != m.a.a.fCB)) {
            break label319;
          }
          if (!paramBoolean) {
            break label307;
          }
          this.fCw.gZA = true;
          this.fCw.gZB = true;
        }
      }
      break;
    }
    for (;;)
    {
      this.fCw.wn();
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
      str = this.fCo.appId;
      break label91;
      label302:
      i = 2;
      break label105;
      label307:
      this.fCw.mn(6);
      continue;
      label319:
      this.fCw.gZA = paramBoolean;
    }
  }
  
  public final void kr(int paramInt)
  {
    SystemClock.elapsedRealtime();
    if (paramInt == 0)
    {
      bI(697, 2);
      abJ();
      if (this.fCw != null)
      {
        if (paramInt == 0) {
          break label104;
        }
        if (paramInt != -4) {
          break label93;
        }
        this.fCw.mn(4);
      }
    }
    for (;;)
    {
      this.fCw.aot();
      this.fCw.wn();
      return;
      if (paramInt < 0)
      {
        bI(697, -paramInt);
        break;
      }
      if (paramInt != 1) {
        break;
      }
      bI(697, 10);
      break;
      label93:
      this.fCw.mn(5);
    }
    label104:
    this.fCw.gZC = com.tencent.mm.a.e.bJ(((af)this.fCo).abS());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.m.a
 * JD-Core Version:    0.7.0.1
 */