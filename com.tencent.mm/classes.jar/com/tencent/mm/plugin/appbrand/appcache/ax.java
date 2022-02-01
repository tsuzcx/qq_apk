package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.StatFs;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.h.a.c.f.d;
import com.tencent.mm.pluginsdk.h.a.c.j;
import com.tencent.mm.pluginsdk.h.a.c.n;
import com.tencent.mm.pluginsdk.h.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;

public final class ax
{
  final b jnO;
  
  ax()
  {
    AppMethodBeat.i(90618);
    this.jnO = new b();
    AppMethodBeat.o(90618);
  }
  
  public static String aXb()
  {
    AppMethodBeat.i(90619);
    String str2 = com.tencent.mm.kernel.g.agR().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    com.tencent.mm.sdk.platformtools.l.aFC(str1);
    AppMethodBeat.o(90619);
    return str1;
  }
  
  public final int b(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(90620);
    if (this.jnO.aGF(parama.Dkb))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.Dkb });
      AppMethodBeat.o(90620);
      return 0;
    }
    int i = this.jnO.b(parama);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.Dkb, Integer.valueOf(i) });
    AppMethodBeat.o(90620);
    return i;
  }
  
  static final class a
  {
    private static final AtomicInteger jnP;
    
    static
    {
      AppMethodBeat.i(206848);
      jnP = new AtomicInteger(0);
      AppMethodBeat.o(206848);
    }
    
    public final com.tencent.mm.pluginsdk.h.a.c.m a(ax.c paramc)
    {
      AppMethodBeat.i(90595);
      String str1 = paramc.eLF();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", new Object[] { paramc.getURL() });
      for (;;)
      {
        try
        {
          localCountDownLatch = new CountDownLatch(1);
          locali = new com.tencent.mm.plugin.appbrand.z.i();
          locala = paramc.aXc();
          final String str2 = locala.Dkb;
          localObject = paramc.joc;
          if (paramc.aXc().jpB)
          {
            localObject = new com.tencent.mm.sdk.platformtools.au(p.aeS().getLooper(), new au.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(90593);
                f.aDD().BR(str2);
                this.jnR.aWb();
                com.tencent.mm.vfs.i.deleteFile(locala.getFilePath());
                locali.value = null;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90593);
                return false;
              }
            }, false);
            localg = new com.tencent.mm.i.g();
            paramc = new a(paramc, localg)
            {
              final void b(com.tencent.mm.pluginsdk.h.a.c.m paramAnonymousm)
              {
                AppMethodBeat.i(90594);
                if (this.jnV != null) {
                  this.jnV.stopTimer();
                }
                locali.value = paramAnonymousm;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90594);
              }
            };
            localg.field_mediaId = str2;
            localg.field_fullpath = locala.getFilePath();
            localg.fre = locala.url;
            localg.dBE = false;
            localg.frb = paramc;
            localg.frf = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getConnectTimeout()));
            localg.frg = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getReadTimeout()));
            localg.field_fileType = com.tencent.mm.i.a.fqD;
            if (!(locala instanceof l)) {
              continue;
            }
            localg.fri = false;
            com.tencent.luggage.sdk.g.c.a("WxaDownloadProfile| getHost", new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(161748);
                Object localObject = Uri.parse(localg.fre).getHost();
                if (!bs.isNullOrNil((String)localObject))
                {
                  localObject = y.HZ((String)localObject);
                  localg.frh = new String[((ArrayList)localObject).size()];
                  ((ArrayList)localObject).toArray(localg.frh);
                }
                AppMethodBeat.o(161748);
              }
            });
            f.aDD().b(localg, -1);
            if (localObject != null)
            {
              long l = locala.getReadTimeout();
              ((com.tencent.mm.sdk.platformtools.au)localObject).au(l, l);
            }
          }
        }
        catch (Exception paramc)
        {
          final CountDownLatch localCountDownLatch;
          final com.tencent.mm.plugin.appbrand.z.i locali;
          final com.tencent.mm.plugin.appbrand.appcache.a.a locala;
          Object localObject;
          final com.tencent.mm.i.g localg;
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
          AppMethodBeat.o(90595);
          return null;
        }
        try
        {
          localCountDownLatch.await();
          paramc = (com.tencent.mm.pluginsdk.h.a.c.m)locali.value;
          AppMethodBeat.o(90595);
          return paramc;
        }
        catch (Exception paramc)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
          AppMethodBeat.o(90595);
        }
        localObject = null;
        continue;
        if ((locala.appId.startsWith("wxfe02ecfe70800f46")) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQD, false))) {
          localg.frp = true;
        }
      }
      return null;
    }
    
    static abstract class a
      implements g.a
    {
      private final ax.c jnX;
      private final com.tencent.mm.i.g jnY;
      
      a(ax.c paramc, com.tencent.mm.i.g paramg)
      {
        this.jnX = paramc;
        this.jnY = paramg;
      }
      
      private static void a(com.tencent.mm.pluginsdk.h.a.c.m paramm, CdnLogic.CronetTaskResult paramCronetTaskResult)
      {
        if (paramCronetTaskResult != null)
        {
          paramm.bundle.putBoolean("RESPONSE_KEY_USE_QUIC", paramCronetTaskResult.useQuic);
          paramm.bundle.putBoolean("RESPONSE_KEY_USE_HTTP2", paramCronetTaskResult.useHttp2);
          if (paramCronetTaskResult.performance != null)
          {
            paramm.bundle.putParcelable("RESPONSE_KEY_CRONET_PERFORMANCE", paramCronetTaskResult.performance);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", new Object[] { paramm.Dkb, Integer.valueOf(paramm.status), paramm.url, paramCronetTaskResult.performance });
          }
        }
      }
      
      public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
      {
        if (paramInt != 0)
        {
          b(new com.tencent.mm.pluginsdk.h.a.c.m(this.jnX, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.jnX.eLF(), Integer.valueOf(paramInt) })), 3));
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.jnX.eLF(), Integer.valueOf(paramInt) });
          return 0;
        }
        if (paramc != null)
        {
          paramString = this.jnX.DlQ;
          if (paramString != null)
          {
            paramc = new WxaPkgLoadProgress((int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
            paramString.a(this.jnX.eLF(), paramc);
          }
          return 0;
        }
        if (paramd != null)
        {
          paramString = this.jnX.eLF();
          paramInt = paramd.field_retCode;
          paramc = paramd.field_httpResponseHeader;
          int i = paramd.field_httpStatusCode;
          if (paramd.cronetTaskResult == null) {
            break label319;
          }
          paramBoolean = true;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s, httpStatusCode %d, useCronet %b", new Object[] { paramString, Integer.valueOf(paramInt), paramc, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          if ((paramd.field_retCode == 0) && (200 == paramd.field_httpStatusCode)) {
            break label386;
          }
          if ((paramd.field_fileLength <= 0L) || (this.jnX.qG(paramd.field_fileLength))) {
            break label325;
          }
          paramString = new com.tencent.mm.pluginsdk.h.a.c.m(this.jnX, new com.tencent.mm.pluginsdk.h.a.b.a(), paramd.field_httpStatusCode, 3);
          label303:
          a(paramString, paramd.cronetTaskResult);
          b(paramString);
        }
        for (;;)
        {
          return 0;
          label319:
          paramBoolean = false;
          break;
          label325:
          paramString = new com.tencent.mm.pluginsdk.h.a.c.m(this.jnX, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.jnX.eLF(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
          break label303;
          label386:
          paramString = new com.tencent.mm.pluginsdk.h.a.c.m("AppBrandWxaPkgDownloader", this.jnX.eLF(), this.jnY.fre, this.jnX.getFilePath(), -1L, null, 2, null);
          a(paramString, paramd.cronetTaskResult);
          b(paramString);
          paramInt = (int)com.tencent.mm.vfs.i.aSp(this.jnX.aXc().getFilePath());
          if (ar.a.hnx != null) {
            ar.a.hnx.cZ(paramInt, 0);
          }
        }
      }
      
      public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
      
      abstract void b(com.tencent.mm.pluginsdk.h.a.c.m paramm);
      
      public final byte[] f(String paramString, byte[] paramArrayOfByte)
      {
        return new byte[0];
      }
    }
  }
  
  final class b
    extends n
  {
    b()
    {
      super(new ax.d(ax.this));
      AppMethodBeat.i(90596);
      AppMethodBeat.o(90596);
    }
    
    public final f.d a(com.tencent.mm.pluginsdk.h.a.c.l paraml)
    {
      AppMethodBeat.i(90598);
      paraml = new ax.c((com.tencent.mm.plugin.appbrand.appcache.a.a)paraml);
      paraml.DlQ = this.DlN;
      AppMethodBeat.o(90598);
      return paraml;
    }
    
    public final int b(com.tencent.mm.pluginsdk.h.a.c.l paraml)
    {
      AppMethodBeat.i(90599);
      int i = super.b(paraml);
      if (i == 1)
      {
        super.b(paraml);
        AppMethodBeat.o(90599);
        return 2;
      }
      AppMethodBeat.o(90599);
      return i;
    }
    
    public final void shutdown()
    {
      AppMethodBeat.i(90597);
      super.shutdown();
      ((ax.d)this.DlN).jod.quit();
      AppMethodBeat.o(90597);
    }
  }
  
  static final class c
    extends n.a<com.tencent.mm.plugin.appbrand.appcache.a.a>
  {
    private static final ThreadLocal<ax.a> joa;
    private String job;
    final ac.a joc;
    
    static
    {
      AppMethodBeat.i(90609);
      joa = new ThreadLocal() {};
      AppMethodBeat.o(90609);
    }
    
    c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
    {
      super();
      AppMethodBeat.i(90602);
      this.job = null;
      ac.a locala = ac.a(parama);
      parama = locala;
      if (locala == null) {
        parama = m.jlQ;
      }
      this.joc = parama;
      AppMethodBeat.o(90602);
    }
    
    private com.tencent.mm.pluginsdk.h.a.c.m a(j paramj)
    {
      AppMethodBeat.i(90604);
      paramj = super.b(paramj);
      if (paramj != null) {
        paramj.bundle.putBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", true);
      }
      AppMethodBeat.o(90604);
      return paramj;
    }
    
    protected final com.tencent.mm.plugin.appbrand.appcache.a.a aXc()
    {
      AppMethodBeat.i(90603);
      com.tencent.mm.plugin.appbrand.appcache.a.a locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.aXi();
      AppMethodBeat.o(90603);
      return locala;
    }
    
    public final boolean aXd()
    {
      return true;
    }
    
    public final boolean aXe()
    {
      return false;
    }
    
    public final boolean aXf()
    {
      return true;
    }
    
    public final boolean aXg()
    {
      return false;
    }
    
    public final boolean aXh()
    {
      AppMethodBeat.i(90607);
      switch (ab.Yu())
      {
      default: 
        AppMethodBeat.o(90607);
        return false;
      case 0: 
        AppMethodBeat.o(90607);
        return false;
      }
      boolean bool = super.aXh();
      AppMethodBeat.o(90607);
      return bool;
    }
    
    public final String azp()
    {
      return "AppBrandWxaPkgDownloader";
    }
    
    public final com.tencent.mm.pluginsdk.h.a.c.m b(j paramj)
    {
      AppMethodBeat.i(90605);
      try
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.aXi();
        com.tencent.mm.vfs.i.deleteFile(((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).getFilePath());
        this.job = ((com.tencent.mm.pluginsdk.h.a.c.l)localObject1).url;
        localObject2 = this.joc;
        this.job.startsWith("https");
        ((ac.a)localObject2).aWa();
        localm = ((ax.a)joa.get()).a(this);
        if (localm != null) {
          localObject2 = localm;
        }
      }
      catch (Exception paramj)
      {
        Object localObject1;
        for (;;)
        {
          com.tencent.mm.pluginsdk.h.a.c.m localm;
          label163:
          Object localObject2 = null;
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", paramj, "perform failed", new Object[0]);
          localObject1 = localObject2;
        }
        AppMethodBeat.o(90605);
        return localObject1;
      }
      try
      {
        if (localm.status != 3) {
          break label232;
        }
        localObject2 = localm;
        if (!this.job.startsWith("http://")) {
          break label232;
        }
        i = 1;
        if (localm != null)
        {
          localObject2 = localm;
          if (localm.status != 3) {
            break label237;
          }
        }
        localObject2 = localm;
        if (!this.job.startsWith("https")) {
          break label237;
        }
        localObject2 = localm;
        this.joc.aWc();
        localObject2 = localm;
        if (!(localObject1 instanceof at)) {
          break label295;
        }
        i = 0;
      }
      catch (Exception paramj)
      {
        break label266;
        i = 1;
        break label163;
      }
      if (i != 0)
      {
        localObject2 = localm;
        this.job = this.job.replaceFirst("https", "http");
      }
      localObject2 = localm;
      localObject1 = a(paramj);
      for (;;)
      {
        localObject2 = localObject1;
        this.joc.a((com.tencent.mm.pluginsdk.h.a.c.m)localObject1);
        if (localObject1 != null) {
          break label284;
        }
        paramj = new com.tencent.mm.pluginsdk.h.a.c.m(this, null, -1, 3);
        AppMethodBeat.o(90605);
        return paramj;
        label232:
        i = 0;
        break;
        label237:
        if (localm != null)
        {
          localObject1 = localm;
          if (i == 0) {}
        }
        else
        {
          localObject2 = localm;
          localObject1 = a(paramj);
        }
      }
    }
    
    public final String getURL()
    {
      return this.job;
    }
    
    public final boolean qG(long paramLong)
    {
      AppMethodBeat.i(90606);
      StatFs localStatFs = new StatFs(q.B(new com.tencent.mm.vfs.e(getFilePath()).fxU().fxV()));
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if ((l < 0L) || (l > paramLong))
      {
        AppMethodBeat.o(90606);
        return true;
      }
      AppMethodBeat.o(90606);
      return false;
    }
  }
  
  final class d
    implements com.tencent.mm.pluginsdk.h.a.c.c
  {
    final ao jod;
    
    d()
    {
      AppMethodBeat.i(90611);
      this.jod = new ao("WxaPkgDownloadPerformerEventDispatchThread");
      AppMethodBeat.o(90611);
    }
    
    private static void a(ax.c paramc, com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90617);
      com.tencent.mm.vfs.i.deleteFile(paramm.filePath);
      if ((paramc.aXc() instanceof l))
      {
        k.jlM.a((l)paramc.aXc(), paramm);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.aXc() instanceof au))
      {
        s.a((au)paramc.aXc(), paramm, paramc.joc);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.aXc() instanceof bo))
      {
        bp.a((bo)paramc.aXc(), paramm, paramc.joc);
        AppMethodBeat.o(90617);
        return;
      }
      String str = paramc.aXc().appId;
      if ((paramm.DlL instanceof com.tencent.mm.pluginsdk.h.a.b.a)) {
        paramc = b.a.a.jpI;
      }
      for (;;)
      {
        bh.a(paramm.Dkb, str, paramc);
        AppMethodBeat.o(90617);
        return;
        switch (paramm.httpStatusCode)
        {
        default: 
          paramc = b.a.a.jpD;
          break;
        case 403: 
        case 404: 
          paramc = b.a.a.jpH;
        }
      }
    }
    
    public static void b(com.tencent.mm.pluginsdk.h.a.c.e parame, com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90613);
      a((ax.c)parame, paramm);
      AppMethodBeat.o(90613);
    }
    
    public static void c(com.tencent.mm.pluginsdk.h.a.c.e parame, com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90614);
      Object localObject = ((ax.c)parame).aXc();
      if ((localObject instanceof au))
      {
        paramm = (au)localObject;
        parame = ((ax.c)parame).joc;
        localObject = ((com.tencent.mm.plugin.appbrand.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aVa();
        if (localObject == null)
        {
          bh.a(paramm.Dkb, paramm.appId, b.a.a.jpJ, null);
          AppMethodBeat.o(90614);
          return;
        }
        String str1 = paramm.appId;
        j = paramm.jnw;
        i = paramm.jnx;
        String str2 = paramm.aWR();
        bb localbb = ((bf)localObject).a(str1, j, 0, new String[] { "pkgPath" });
        if (localbb == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, get NULL oldInfo with appId[%s] version[%d]", new Object[] { str1, Integer.valueOf(j) });
          bh.a(paramm.Dkb, paramm.appId, b.a.a.jpJ, null);
          AppMethodBeat.o(90614);
          return;
        }
        parame.aWd();
        long l1 = SystemClock.elapsedRealtime();
        j = s.A(localbb.field_pkgPath, str2, paramm.getFilePath());
        long l2 = SystemClock.elapsedRealtime();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paramm.appId, localbb.field_pkgPath, str2, paramm.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
        parame.rr(j);
        if (j == 0)
        {
          bh.a(paramm.Dkb, paramm.appId, str2, i, 0, parame);
          AppMethodBeat.o(90614);
          return;
        }
        com.tencent.mm.vfs.i.deleteFile(str2);
        bh.Iq(paramm.Dkb);
        if ((paramm.jny instanceof b.b)) {
          ((b.b)paramm.jny).aXt();
        }
        parame = ((bf)localObject).a(paramm.appId, paramm.jnx, 0, new String[] { "downloadURL" });
        if (parame == null)
        {
          bh.a(paramm.Dkb, paramm.appId, b.a.a.jpJ, null);
          AppMethodBeat.o(90614);
          return;
        }
        if (!bh.b(paramm.appId, 0, paramm.jnx, parame.field_downloadURL, paramm.jny)) {
          paramm.jny.a(paramm.appId, b.a.a.jpJ, null);
        }
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject instanceof bo))
      {
        bp.a((bo)localObject, ((ax.c)parame).joc);
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject instanceof l))
      {
        k.jlM.a((l)localObject, paramm);
        AppMethodBeat.o(90614);
        return;
      }
      localObject = ((ax.c)parame).aXc().appId;
      int i = ((ax.c)parame).aXc().version;
      int j = ((ax.c)parame).aXc().dib;
      try
      {
        bh.a(paramm.Dkb, (String)localObject, paramm.filePath, i, j, ((ax.c)parame).joc);
        AppMethodBeat.o(90614);
        return;
      }
      catch (Exception parame)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
        bh.cd(paramm.Dkb, (String)localObject);
        AppMethodBeat.o(90614);
      }
    }
    
    public static void d(com.tencent.mm.pluginsdk.h.a.c.e parame, com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90615);
      a((ax.c)parame, paramm);
      AppMethodBeat.o(90615);
    }
    
    public final void A(String paramString, int paramInt1, int paramInt2) {}
    
    public final void H(String paramString, long paramLong) {}
    
    public final void a(final com.tencent.mm.pluginsdk.h.a.c.e parame, final com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90612);
      this.jod.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(90610);
          switch (paramm.status)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(90610);
            return;
            ax.d.d(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            ax.d.c(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            ax.d.b(parame, paramm);
          }
        }
      });
      AppMethodBeat.o(90612);
    }
    
    public final void a(String paramString, com.tencent.mm.pluginsdk.h.a.c.k paramk)
    {
      AppMethodBeat.i(90616);
      bh.a(paramString, (WxaPkgLoadProgress)paramk);
      AppMethodBeat.o(90616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */