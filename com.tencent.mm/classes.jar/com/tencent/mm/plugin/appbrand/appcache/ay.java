package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.j.a.c.f.d;
import com.tencent.mm.pluginsdk.j.a.c.j;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public final class ay
{
  final b jHL;
  
  ay()
  {
    AppMethodBeat.i(90618);
    this.jHL = new b();
    AppMethodBeat.o(90618);
  }
  
  public static String baz()
  {
    AppMethodBeat.i(90619);
    String str2 = com.tencent.mm.kernel.g.ajC().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    com.tencent.mm.sdk.platformtools.m.aLc(str1);
    AppMethodBeat.o(90619);
    return str1;
  }
  
  public final int c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(90620);
    if (this.jHL.aMf(parama.EPe))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.EPe });
      AppMethodBeat.o(90620);
      return 0;
    }
    int i = this.jHL.b(parama);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.EPe, Integer.valueOf(i) });
    AppMethodBeat.o(90620);
    return i;
  }
  
  static final class a
  {
    public final com.tencent.mm.pluginsdk.j.a.c.m a(ay.c paramc)
    {
      AppMethodBeat.i(90595);
      String str1 = paramc.faC();
      for (;;)
      {
        final com.tencent.mm.i.g localg;
        label255:
        boolean bool;
        try
        {
          localCountDownLatch = new CountDownLatch(1);
          locali = new com.tencent.mm.plugin.appbrand.z.i();
          locala = paramc.baA();
          final String str2 = locala.EPe;
          localObject = paramc.jHY;
          if (paramc.baA().jJv)
          {
            localObject = new com.tencent.mm.sdk.platformtools.av(p.ahE().getLooper(), new av.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(90593);
                f.aGI().EQ(str2);
                this.jHN.aZw();
                com.tencent.mm.vfs.i.deleteFile(locala.getFilePath());
                locali.value = null;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90593);
                return false;
              }
            }, false);
            localg = new com.tencent.mm.i.g();
            localg.fJi = "task_WxaPkgDownloadPerformer";
            a local2 = new a(paramc, localg)
            {
              final void c(com.tencent.mm.pluginsdk.j.a.c.m paramAnonymousm)
              {
                AppMethodBeat.i(90594);
                if (this.jHR != null) {
                  this.jHR.stopTimer();
                }
                locali.value = paramAnonymousm;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90594);
              }
            };
            localg.field_mediaId = str2;
            localg.field_fullpath = locala.getFilePath();
            localg.fJm = locala.url;
            localg.dNR = false;
            localg.fJj = local2;
            localg.fJn = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getConnectTimeout()));
            localg.fJo = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getReadTimeout()));
            localg.field_fileType = com.tencent.mm.i.a.fIK;
            if (!(locala instanceof l)) {
              continue;
            }
            localg.fJq = false;
            if (!localg.fJx) {
              break label493;
            }
            if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
              break label542;
            }
            if (!com.tencent.mm.sdk.platformtools.i.DEBUG) {
              break label557;
            }
            break label542;
            localg.fJy = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quS, bool);
            label277:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, cdnTask made, forceUseCronet:%b, forceUseNewDns:%b, url %s", new Object[] { Boolean.valueOf(localg.fJx), Boolean.valueOf(localg.fJy), paramc.getURL() });
            f.aGI().b(localg, -1);
            if (localObject != null)
            {
              long l = locala.getReadTimeout();
              ((com.tencent.mm.sdk.platformtools.av)localObject).az(l, l);
            }
          }
        }
        catch (Exception paramc)
        {
          final CountDownLatch localCountDownLatch;
          final com.tencent.mm.plugin.appbrand.z.i locali;
          final com.tencent.mm.plugin.appbrand.appcache.a.a locala;
          Object localObject;
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
          AppMethodBeat.o(90595);
          return null;
        }
        try
        {
          localCountDownLatch.await();
          paramc = (com.tencent.mm.pluginsdk.j.a.c.m)locali.value;
          AppMethodBeat.o(90595);
          return paramc;
        }
        catch (Exception paramc)
        {
          label493:
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
          AppMethodBeat.o(90595);
          return null;
        }
        localObject = null;
        continue;
        if (locala.appId.startsWith("wxfe02ecfe70800f46"))
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quU, false)) {
            localg.fJx = true;
          }
        }
        else
        {
          if ((!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
            if (!com.tencent.mm.sdk.platformtools.i.DEBUG) {
              break label552;
            }
          }
          for (;;)
          {
            if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFS, bool)) {
              break label555;
            }
            localg.fJx = true;
            break;
            com.tencent.luggage.sdk.g.c.a("WxaDownloadProfile| getHost", new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(161748);
                Object localObject = Uri.parse(localg.fJm).getHost();
                if (!bt.isNullOrNil((String)localObject))
                {
                  localObject = z.Lr((String)localObject);
                  localg.fJp = new String[((ArrayList)localObject).size()];
                  ((ArrayList)localObject).toArray(localg.fJp);
                }
                AppMethodBeat.o(161748);
              }
            });
            break label277;
            label542:
            bool = true;
            break label255;
            bool = true;
            continue;
            label552:
            bool = false;
          }
          label555:
          continue;
          label557:
          bool = false;
        }
      }
    }
    
    static abstract class a
      implements g.a
    {
      private final ay.c jHT;
      private final com.tencent.mm.i.g jHU;
      
      a(ay.c paramc, com.tencent.mm.i.g paramg)
      {
        this.jHT = paramc;
        this.jHU = paramg;
      }
      
      private void a(com.tencent.mm.pluginsdk.j.a.c.m paramm, CdnLogic.CronetTaskResult paramCronetTaskResult)
      {
        Bundle localBundle;
        if (paramCronetTaskResult != null)
        {
          localBundle = paramm.bundle;
          if ((!this.jHU.fJy) && (this.jHU.fJx)) {
            break label129;
          }
        }
        label129:
        for (boolean bool = true;; bool = false)
        {
          localBundle.putBoolean("RESPONSE_KEY_USE_NEWDNS", bool);
          paramm.bundle.putBoolean("RESPONSE_KEY_USE_QUIC", paramCronetTaskResult.useQuic);
          paramm.bundle.putBoolean("RESPONSE_KEY_USE_HTTP2", paramCronetTaskResult.useHttp2);
          if (paramCronetTaskResult.performance != null)
          {
            paramm.bundle.putParcelable("RESPONSE_KEY_CRONET_PERFORMANCE", paramCronetTaskResult.performance);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", new Object[] { paramm.EPe, Integer.valueOf(paramm.status), paramm.url, paramCronetTaskResult.performance });
          }
          return;
        }
      }
      
      public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
      {
        if (paramInt != 0)
        {
          c(new com.tencent.mm.pluginsdk.j.a.c.m(this.jHT, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.jHT.faC(), Integer.valueOf(paramInt) })), 3));
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.jHT.faC(), Integer.valueOf(paramInt) });
          return 0;
        }
        if (paramc != null)
        {
          paramString = this.jHT.EQS;
          if (paramString != null)
          {
            paramc = new WxaPkgLoadProgress((int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
            paramString.a(this.jHT.faC(), paramc);
          }
          return 0;
        }
        if (paramd != null)
        {
          paramString = this.jHT.faC();
          paramInt = paramd.field_retCode;
          paramc = paramd.field_httpResponseHeader;
          int i = paramd.field_httpStatusCode;
          if (paramd.cronetTaskResult == null) {
            break label320;
          }
          paramBoolean = true;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s, httpStatusCode %d, useCronet %b", new Object[] { paramString, Integer.valueOf(paramInt), paramc, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          if ((paramd.field_retCode == 0) && (200 == paramd.field_httpStatusCode)) {
            break label387;
          }
          if ((paramd.field_fileLength <= 0L) || (this.jHT.sE(paramd.field_fileLength))) {
            break label326;
          }
          paramString = new com.tencent.mm.pluginsdk.j.a.c.m(this.jHT, new com.tencent.mm.pluginsdk.j.a.b.a(), paramd.field_httpStatusCode, 3);
          label303:
          a(paramString, paramd.cronetTaskResult);
          c(paramString);
        }
        for (;;)
        {
          return 0;
          label320:
          paramBoolean = false;
          break;
          label326:
          paramString = new com.tencent.mm.pluginsdk.j.a.c.m(this.jHT, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.jHT.faC(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
          break label303;
          label387:
          paramString = new com.tencent.mm.pluginsdk.j.a.c.m("AppBrandWxaPkgDownloader", this.jHT.faC(), this.jHU.fJm, this.jHT.getFilePath(), -1L, null, 2, null);
          a(paramString, paramd.cronetTaskResult);
          c(paramString);
          paramInt = (int)com.tencent.mm.vfs.i.aYo(this.jHT.baA().getFilePath());
          if (as.a.hFP != null) {
            as.a.hFP.db(paramInt, 0);
          }
        }
      }
      
      public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
      
      abstract void c(com.tencent.mm.pluginsdk.j.a.c.m paramm);
      
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
      super(new ay.d(ay.this));
      AppMethodBeat.i(90596);
      AppMethodBeat.o(90596);
    }
    
    public final f.d a(com.tencent.mm.pluginsdk.j.a.c.l paraml)
    {
      AppMethodBeat.i(90598);
      paraml = new ay.c((com.tencent.mm.plugin.appbrand.appcache.a.a)paraml);
      paraml.EQS = this.EQP;
      AppMethodBeat.o(90598);
      return paraml;
    }
    
    public final int b(com.tencent.mm.pluginsdk.j.a.c.l paraml)
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
      ((ay.d)this.EQP).jHZ.quit();
      AppMethodBeat.o(90597);
    }
  }
  
  static final class c
    extends n.a<com.tencent.mm.plugin.appbrand.appcache.a.a>
  {
    private static final ThreadLocal<ay.a> jHW;
    private String jHX;
    final ad.a jHY;
    
    static
    {
      AppMethodBeat.i(90609);
      jHW = new ThreadLocal() {};
      AppMethodBeat.o(90609);
    }
    
    c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
    {
      super();
      AppMethodBeat.i(90602);
      this.jHX = null;
      ad.a locala = ad.b(parama);
      parama = locala;
      if (locala == null) {
        parama = m.jFG;
      }
      this.jHY = parama;
      AppMethodBeat.o(90602);
    }
    
    private com.tencent.mm.pluginsdk.j.a.c.m a(j paramj)
    {
      AppMethodBeat.i(90604);
      paramj = super.b(paramj);
      if (paramj != null) {
        paramj.bundle.putBoolean("RESPONSE_KEY_FALLBACK_USE_SYSTEM_URL_CONNECTION", true);
      }
      AppMethodBeat.o(90604);
      return paramj;
    }
    
    public final String afw()
    {
      return "AppBrandWxaPkgDownloader";
    }
    
    public final com.tencent.mm.pluginsdk.j.a.c.m b(j paramj)
    {
      AppMethodBeat.i(90605);
      try
      {
        locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.baG();
        com.tencent.mm.vfs.i.deleteFile(locala.getFilePath());
        this.jHX = locala.url;
        localObject = this.jHY;
        this.jHX.startsWith("https");
        ((ad.a)localObject).aZv();
        localObject = (ay.a)jHW.get();
        zq localzq = new zq();
        localzq.dPa.dPc = ((com.tencent.mm.plugin.appbrand.appcache.a.a)super.baG());
        localzq.dPa.dPb = 1;
        com.tencent.mm.sdk.b.a.IbL.a(localzq, Looper.getMainLooper());
        localObject = ((ay.a)localObject).a(this);
        localzq = new zq();
        localzq.dPa.dPc = ((com.tencent.mm.plugin.appbrand.appcache.a.a)super.baG());
        localzq.dPa.dPd = ((com.tencent.mm.pluginsdk.j.a.c.m)localObject);
        localzq.dPa.dPb = 2;
        com.tencent.mm.sdk.b.a.IbL.a(localzq, Looper.getMainLooper());
        if (localObject == null) {}
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.appcache.a.a locala;
          Object localObject;
          label235:
          paramj = null;
          label260:
          label293:
          label298:
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", localException1, "perform failed", new Object[0]);
        }
        AppMethodBeat.o(90605);
        return paramj;
      }
      try
      {
        if ((((com.tencent.mm.pluginsdk.j.a.c.m)localObject).status != 3) || (!this.jHX.startsWith("http://"))) {
          break label293;
        }
        i = 1;
        if (((localObject != null) && (((com.tencent.mm.pluginsdk.j.a.c.m)localObject).status != 3)) || (!this.jHX.startsWith("https"))) {
          break label298;
        }
        this.jHY.aZx();
        if (!(locala instanceof au)) {
          break label359;
        }
        i = 0;
      }
      catch (Exception localException4)
      {
        paramj = localException1;
        localException2 = localException4;
        break label318;
        break label260;
        i = 1;
        break label235;
      }
      if (i != 0) {
        this.jHX = this.jHX.replaceFirst("https", "http");
      }
      for (paramj = a(paramj);; paramj = a(paramj))
      {
        try
        {
          this.jHY.a(paramj);
          if (paramj != null) {
            break label333;
          }
          paramj = new com.tencent.mm.pluginsdk.j.a.c.m(this, null, -1, 3);
          AppMethodBeat.o(90605);
          return paramj;
        }
        catch (Exception localException3)
        {
          Exception localException2;
          break label318;
          paramj = localException3;
        }
        i = 0;
        break;
        if ((localObject != null) && (i == 0)) {
          break label354;
        }
      }
    }
    
    protected final com.tencent.mm.plugin.appbrand.appcache.a.a baA()
    {
      AppMethodBeat.i(90603);
      com.tencent.mm.plugin.appbrand.appcache.a.a locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.baG();
      AppMethodBeat.o(90603);
      return locala;
    }
    
    public final boolean baB()
    {
      return true;
    }
    
    public final boolean baC()
    {
      return false;
    }
    
    public final boolean baD()
    {
      return true;
    }
    
    public final boolean baE()
    {
      return false;
    }
    
    public final boolean baF()
    {
      AppMethodBeat.i(90607);
      switch (ab.aaW())
      {
      default: 
        AppMethodBeat.o(90607);
        return false;
      case 0: 
        AppMethodBeat.o(90607);
        return false;
      }
      boolean bool = super.baF();
      AppMethodBeat.o(90607);
      return bool;
    }
    
    public final String getURL()
    {
      return this.jHX;
    }
    
    public final boolean sE(long paramLong)
    {
      AppMethodBeat.i(90606);
      StatFs localStatFs = new StatFs(q.B(new com.tencent.mm.vfs.e(getFilePath()).fOJ().fOK()));
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
    implements com.tencent.mm.pluginsdk.j.a.c.c
  {
    final ap jHZ;
    
    d()
    {
      AppMethodBeat.i(90611);
      this.jHZ = new ap("WxaPkgDownloadPerformerEventDispatchThread");
      AppMethodBeat.o(90611);
    }
    
    private static void a(ay.c paramc, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90617);
      com.tencent.mm.vfs.i.deleteFile(paramm.filePath);
      if ((paramc.baA() instanceof l))
      {
        k.jFC.a((l)paramc.baA(), paramm);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.baA() instanceof av))
      {
        s.a((av)paramc.baA(), paramm, paramc.jHY);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.baA() instanceof bq))
      {
        br.a((bq)paramc.baA(), paramm, paramc.jHY);
        AppMethodBeat.o(90617);
        return;
      }
      String str = paramc.baA().appId;
      if ((paramm.EQN instanceof com.tencent.mm.pluginsdk.j.a.b.a)) {
        paramc = b.a.a.jJC;
      }
      for (;;)
      {
        bi.a(paramm.EPe, str, paramc);
        AppMethodBeat.o(90617);
        return;
        switch (paramm.httpStatusCode)
        {
        default: 
          paramc = b.a.a.jJx;
          break;
        case 403: 
        case 404: 
          paramc = b.a.a.jJB;
        }
      }
    }
    
    public static void b(com.tencent.mm.pluginsdk.j.a.c.e parame, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90613);
      a((ay.c)parame, paramm);
      AppMethodBeat.o(90613);
    }
    
    public static void c(com.tencent.mm.pluginsdk.j.a.c.e parame, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90614);
      Object localObject1 = ((ay.c)parame).baA();
      if ((localObject1 instanceof av))
      {
        paramm = (av)localObject1;
        localObject1 = ((ay.c)parame).jHY;
        parame = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYu();
        if (parame == null)
        {
          bi.a(paramm.EPe, paramm.appId, b.a.a.jJD, null);
          AppMethodBeat.o(90614);
          return;
        }
        Object localObject2 = paramm.appId;
        j = paramm.jHt;
        i = paramm.jHu;
        String str = paramm.bao();
        Object localObject3 = parame.a((String)localObject2, j, 0, new String[] { "pkgPath" });
        if (localObject3 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, get NULL oldInfo with appId[%s] version[%d]", new Object[] { localObject2, Integer.valueOf(j) });
          bi.a(paramm.EPe, paramm.appId, b.a.a.jJD, null);
          AppMethodBeat.o(90614);
          return;
        }
        ((ad.a)localObject1).aZy();
        long l1 = SystemClock.elapsedRealtime();
        j = s.z(((bc)localObject3).field_pkgPath, str, paramm.getFilePath());
        long l2 = SystemClock.elapsedRealtime();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paramm.appId, ((bc)localObject3).field_pkgPath, str, paramm.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
        ((ad.a)localObject1).rR(j);
        boolean bool2 = paramm.jHv instanceof b.b;
        if (j == 0)
        {
          Collection localCollection = bi.LI(paramm.EPe);
          localObject2 = new com.tencent.mm.plugin.appbrand.z.i();
          localObject3 = new com.tencent.mm.plugin.appbrand.z.i();
          com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
          s.1 local1 = new s.1((com.tencent.mm.plugin.appbrand.z.i)localObject2, (com.tencent.mm.plugin.appbrand.z.i)localObject3, locali);
          bi.a(paramm.EPe, local1);
          bi.a(paramm.EPe, paramm.appId, str, i, 0, (ad.a)localObject1);
          if (b.a.a.jJw == ((com.tencent.mm.plugin.appbrand.z.i)localObject3).value) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, urlKey[%s] verifyOk[%s] canFallback[%b]", new Object[] { paramm.EPe, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if ((!bool1) && (bool2)) {
              break label484;
            }
            if (localCollection == null) {
              break;
            }
            parame = localCollection.iterator();
            while (parame.hasNext()) {
              ((bi.a)parame.next()).a((String)((com.tencent.mm.plugin.appbrand.z.i)localObject2).value, (b.a.a)((com.tencent.mm.plugin.appbrand.z.i)localObject3).value, locali.value);
            }
          }
          AppMethodBeat.o(90614);
          return;
          label484:
          bi.a(paramm.EPe, localCollection);
        }
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.deleteFile(paramm.getFilePath());
        localObject1 = new s.2(bi.LI(paramm.EPe), paramm);
        if ((paramm.jHv instanceof b.b)) {
          ((b.b)paramm.jHv).baR();
        }
        parame = parame.a(paramm.appId, paramm.jHu, 0, new String[] { "downloadURL" });
        if ((parame == null) || (TextUtils.isEmpty(parame.field_downloadURL)))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, fallback non-incremental get EMPTY url with key[%s]", new Object[] { paramm.EPe });
          ((bi.a)localObject1).a(paramm.appId, b.a.a.jJD, null);
          AppMethodBeat.o(90614);
          return;
        }
        if (!bi.b(paramm.appId, 0, paramm.jHu, parame.field_downloadURL, (bi.a)localObject1)) {
          ((bi.a)localObject1).a(paramm.appId, b.a.a.jJD, null);
        }
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof bq))
      {
        br.a((bq)localObject1, ((ay.c)parame).jHY);
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof l))
      {
        k.jFC.a((l)localObject1, paramm);
        AppMethodBeat.o(90614);
        return;
      }
      localObject1 = ((ay.c)parame).baA().appId;
      int i = ((ay.c)parame).baA().version;
      int j = ((ay.c)parame).baA().dtF;
      try
      {
        bi.a(paramm.EPe, (String)localObject1, paramm.filePath, i, j, ((ay.c)parame).jHY);
        AppMethodBeat.o(90614);
        return;
      }
      catch (Exception parame)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
        bi.cf(paramm.EPe, (String)localObject1);
        AppMethodBeat.o(90614);
      }
    }
    
    public static void d(com.tencent.mm.pluginsdk.j.a.c.e parame, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90615);
      a((ay.c)parame, paramm);
      AppMethodBeat.o(90615);
    }
    
    public final void C(String paramString, int paramInt1, int paramInt2) {}
    
    public final void O(String paramString, long paramLong) {}
    
    public final void a(final com.tencent.mm.pluginsdk.j.a.c.e parame, final com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90612);
      this.jHZ.post(new Runnable()
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
            ay.d.d(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            ay.d.c(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            ay.d.b(parame, paramm);
          }
        }
      });
      AppMethodBeat.o(90612);
    }
    
    public final void a(String paramString, com.tencent.mm.pluginsdk.j.a.c.k paramk)
    {
      AppMethodBeat.i(90616);
      bi.a(paramString, (WxaPkgLoadProgress)paramk);
      AppMethodBeat.o(90616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ay
 * JD-Core Version:    0.7.0.1
 */