package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.StatFs;
import android.os.SystemClock;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  final b iNG;
  
  ax()
  {
    AppMethodBeat.i(90618);
    this.iNG = new b();
    AppMethodBeat.o(90618);
  }
  
  public static String aQj()
  {
    AppMethodBeat.i(90619);
    String str2 = com.tencent.mm.kernel.g.afB().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    com.tencent.mm.sdk.platformtools.l.aAk(str1);
    AppMethodBeat.o(90619);
    return str1;
  }
  
  public final int b(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(90620);
    if (this.iNG.aBn(parama.BRL))
    {
      ad.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.BRL });
      AppMethodBeat.o(90620);
      return 0;
    }
    int i = this.iNG.b(parama);
    ad.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.BRL, Integer.valueOf(i) });
    AppMethodBeat.o(90620);
    return i;
  }
  
  static final class a
  {
    private static final AtomicInteger iNH;
    
    static
    {
      AppMethodBeat.i(192858);
      iNH = new AtomicInteger(0);
      AppMethodBeat.o(192858);
    }
    
    public final com.tencent.mm.pluginsdk.h.a.c.m a(ax.c paramc)
    {
      AppMethodBeat.i(90595);
      String str1 = paramc.ewl();
      ad.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", new Object[] { paramc.getURL() });
      for (;;)
      {
        try
        {
          localCountDownLatch = new CountDownLatch(1);
          locali = new com.tencent.mm.plugin.appbrand.aa.i();
          locala = paramc.aQk();
          final String str2 = locala.BRL;
          localObject = paramc.iNU;
          if (paramc.aQk().iPr)
          {
            localObject = new av(p.adC().getLooper(), new av.a()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(90593);
                f.awL().xL(str2);
                this.iNJ.aPj();
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
                if (this.iNN != null) {
                  this.iNN.stopTimer();
                }
                locali.value = paramAnonymousm;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90594);
              }
            };
            localg.field_mediaId = str2;
            localg.field_fullpath = locala.getFilePath();
            localg.fnK = locala.url;
            localg.dDS = false;
            localg.fnH = paramc;
            localg.fnL = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getConnectTimeout()));
            localg.fnM = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getReadTimeout()));
            localg.field_fileType = com.tencent.mm.i.a.fnj;
            if (!(locala instanceof l)) {
              continue;
            }
            localg.fnO = false;
            com.tencent.luggage.sdk.g.c.a("WxaDownloadProfile| getHost", new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(161748);
                Object localObject = Uri.parse(localg.fnK).getHost();
                if (!bt.isNullOrNil((String)localObject))
                {
                  localObject = y.DW((String)localObject);
                  localg.fnN = new String[((ArrayList)localObject).size()];
                  ((ArrayList)localObject).toArray(localg.fnN);
                }
                AppMethodBeat.o(161748);
              }
            });
            f.awL().b(localg, -1);
            if (localObject != null)
            {
              long l = locala.getReadTimeout();
              ((av)localObject).av(l, l);
            }
          }
        }
        catch (Exception paramc)
        {
          final CountDownLatch localCountDownLatch;
          final com.tencent.mm.plugin.appbrand.aa.i locali;
          final com.tencent.mm.plugin.appbrand.appcache.a.a locala;
          Object localObject;
          final com.tencent.mm.i.g localg;
          ad.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
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
          ad.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
          AppMethodBeat.o(90595);
        }
        localObject = null;
        continue;
        if ((locala.appId.startsWith("wxfe02ecfe70800f46")) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pnd, false))) {
          localg.fnV = true;
        }
      }
      return null;
    }
    
    static abstract class a
      implements g.a
    {
      private final ax.c iNP;
      private final com.tencent.mm.i.g iNQ;
      
      a(ax.c paramc, com.tencent.mm.i.g paramg)
      {
        this.iNP = paramc;
        this.iNQ = paramg;
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
            ad.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", new Object[] { paramm.BRL, Integer.valueOf(paramm.status), paramm.url, paramCronetTaskResult.performance });
          }
        }
      }
      
      public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
      {
        if (paramInt != 0)
        {
          b(new com.tencent.mm.pluginsdk.h.a.c.m(this.iNP, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.iNP.ewl(), Integer.valueOf(paramInt) })), 3));
          ad.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.iNP.ewl(), Integer.valueOf(paramInt) });
          return 0;
        }
        if (paramc != null)
        {
          paramString = this.iNP.BTA;
          if (paramString != null)
          {
            paramc = new WxaPkgLoadProgress((int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
            paramString.a(this.iNP.ewl(), paramc);
          }
          return 0;
        }
        if (paramd != null)
        {
          paramString = this.iNP.ewl();
          paramInt = paramd.field_retCode;
          paramc = paramd.field_httpResponseHeader;
          int i = paramd.field_httpStatusCode;
          if (paramd.cronetTaskResult == null) {
            break label319;
          }
          paramBoolean = true;
          ad.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s, httpStatusCode %d, useCronet %b", new Object[] { paramString, Integer.valueOf(paramInt), paramc, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          if ((paramd.field_retCode == 0) && (200 == paramd.field_httpStatusCode)) {
            break label386;
          }
          if ((paramd.field_fileLength <= 0L) || (this.iNP.mR(paramd.field_fileLength))) {
            break label325;
          }
          paramString = new com.tencent.mm.pluginsdk.h.a.c.m(this.iNP, new com.tencent.mm.pluginsdk.h.a.b.a(), paramd.field_httpStatusCode, 3);
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
          paramString = new com.tencent.mm.pluginsdk.h.a.c.m(this.iNP, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.iNP.ewl(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
          break label303;
          label386:
          paramString = new com.tencent.mm.pluginsdk.h.a.c.m("AppBrandWxaPkgDownloader", this.iNP.ewl(), this.iNQ.fnK, this.iNP.getFilePath(), -1L, null, 2, null);
          a(paramString, paramd.cronetTaskResult);
          b(paramString);
          paramInt = (int)com.tencent.mm.vfs.i.aMN(this.iNP.aQk().getFilePath());
          if (ar.a.gMX != null) {
            ar.a.gMX.cZ(paramInt, 0);
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
      paraml.BTA = this.BTx;
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
      ((ax.d)this.BTx).iNV.quit();
      AppMethodBeat.o(90597);
    }
  }
  
  static final class c
    extends n.a<com.tencent.mm.plugin.appbrand.appcache.a.a>
  {
    private static final ThreadLocal<ax.a> iNS;
    private String iNT;
    final ac.a iNU;
    
    static
    {
      AppMethodBeat.i(90609);
      iNS = new ThreadLocal() {};
      AppMethodBeat.o(90609);
    }
    
    c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
    {
      super();
      AppMethodBeat.i(90602);
      this.iNT = null;
      ac.a locala = ac.a(parama);
      parama = locala;
      if (locala == null) {
        parama = m.iLJ;
      }
      this.iNU = parama;
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
    
    protected final com.tencent.mm.plugin.appbrand.appcache.a.a aQk()
    {
      AppMethodBeat.i(90603);
      com.tencent.mm.plugin.appbrand.appcache.a.a locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.aQq();
      AppMethodBeat.o(90603);
      return locala;
    }
    
    public final boolean aQl()
    {
      return true;
    }
    
    public final boolean aQm()
    {
      return false;
    }
    
    public final boolean aQn()
    {
      return true;
    }
    
    public final boolean aQo()
    {
      return false;
    }
    
    public final boolean aQp()
    {
      AppMethodBeat.i(90607);
      switch (ab.Xx())
      {
      default: 
        AppMethodBeat.o(90607);
        return false;
      case 0: 
        AppMethodBeat.o(90607);
        return false;
      }
      boolean bool = super.aQp();
      AppMethodBeat.o(90607);
      return bool;
    }
    
    public final String asy()
    {
      return "AppBrandWxaPkgDownloader";
    }
    
    public final com.tencent.mm.pluginsdk.h.a.c.m b(j paramj)
    {
      AppMethodBeat.i(90605);
      try
      {
        localObject1 = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.aQq();
        com.tencent.mm.vfs.i.deleteFile(((com.tencent.mm.plugin.appbrand.appcache.a.a)localObject1).getFilePath());
        this.iNT = ((com.tencent.mm.pluginsdk.h.a.c.l)localObject1).url;
        localObject2 = this.iNU;
        this.iNT.startsWith("https");
        ((ac.a)localObject2).aPi();
        localm = ((ax.a)iNS.get()).a(this);
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
          ad.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", paramj, "perform failed", new Object[0]);
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
        if (!this.iNT.startsWith("http://")) {
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
        if (!this.iNT.startsWith("https")) {
          break label237;
        }
        localObject2 = localm;
        this.iNU.aPk();
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
        this.iNT = this.iNT.replaceFirst("https", "http");
      }
      localObject2 = localm;
      localObject1 = a(paramj);
      for (;;)
      {
        localObject2 = localObject1;
        this.iNU.a((com.tencent.mm.pluginsdk.h.a.c.m)localObject1);
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
      return this.iNT;
    }
    
    public final boolean mR(long paramLong)
    {
      AppMethodBeat.i(90606);
      StatFs localStatFs = new StatFs(q.B(new com.tencent.mm.vfs.e(getFilePath()).fhT().fhU()));
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
    final ap iNV;
    
    d()
    {
      AppMethodBeat.i(90611);
      this.iNV = new ap("WxaPkgDownloadPerformerEventDispatchThread");
      AppMethodBeat.o(90611);
    }
    
    private static void a(ax.c paramc, com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90617);
      com.tencent.mm.vfs.i.deleteFile(paramm.filePath);
      if ((paramc.aQk() instanceof l))
      {
        k.iLF.a((l)paramc.aQk(), paramm);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.aQk() instanceof au))
      {
        s.a((au)paramc.aQk(), paramm, paramc.iNU);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.aQk() instanceof bo))
      {
        bp.a((bo)paramc.aQk(), paramm, paramc.iNU);
        AppMethodBeat.o(90617);
        return;
      }
      String str = paramc.aQk().appId;
      if ((paramm.BTv instanceof com.tencent.mm.pluginsdk.h.a.b.a)) {
        paramc = b.a.a.iPz;
      }
      for (;;)
      {
        bh.a(paramm.BRL, str, paramc);
        AppMethodBeat.o(90617);
        return;
        switch (paramm.httpStatusCode)
        {
        default: 
          paramc = b.a.a.iPt;
          break;
        case 403: 
        case 404: 
          paramc = b.a.a.iPy;
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
      Object localObject1 = ((ax.c)parame).aQk();
      if ((localObject1 instanceof au))
      {
        paramm = (au)localObject1;
        parame = ((ax.c)parame).iNU;
        localObject1 = ((com.tencent.mm.plugin.appbrand.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk();
        if (localObject1 == null)
        {
          bh.a(paramm.BRL, paramm.appId, b.a.a.iPA, null);
          AppMethodBeat.o(90614);
          return;
        }
        Object localObject2 = paramm.appId;
        j = paramm.iNo;
        i = paramm.iNp;
        String str = paramm.aPZ();
        bb localbb = ((bf)localObject1).a((String)localObject2, j, 0, new String[] { "pkgPath" });
        localObject2 = ((bf)localObject1).a((String)localObject2, i, 0, new String[] { "versionMd5" });
        if ((localbb == null) || (localObject2 == null))
        {
          bh.a(paramm.BRL, paramm.appId, b.a.a.iPA, null);
          AppMethodBeat.o(90614);
          return;
        }
        parame.aPl();
        long l1 = SystemClock.elapsedRealtime();
        j = s.A(localbb.field_pkgPath, str, paramm.getFilePath());
        long l2 = SystemClock.elapsedRealtime();
        ad.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paramm.appId, localbb.field_pkgPath, str, paramm.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
        parame.qE(j);
        if (j == 0)
        {
          bh.a(paramm.BRL, paramm.appId, str, i, 0, parame);
          AppMethodBeat.o(90614);
          return;
        }
        com.tencent.mm.vfs.i.deleteFile(str);
        bh.En(paramm.BRL);
        if ((paramm.iNq instanceof b.b)) {
          ((b.b)paramm.iNq).aQB();
        }
        parame = ((bf)localObject1).a(paramm.appId, paramm.iNp, 0, new String[] { "downloadURL" });
        if (parame == null)
        {
          bh.a(paramm.BRL, paramm.appId, b.a.a.iPA, null);
          AppMethodBeat.o(90614);
          return;
        }
        if (!bh.b(paramm.appId, 0, paramm.iNp, parame.field_downloadURL, paramm.iNq)) {
          paramm.iNq.a(paramm.appId, b.a.a.iPA, null);
        }
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof bo))
      {
        bp.a((bo)localObject1, ((ax.c)parame).iNU);
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof l))
      {
        k.iLF.a((l)localObject1, paramm);
        AppMethodBeat.o(90614);
        return;
      }
      localObject1 = ((ax.c)parame).aQk().appId;
      int i = ((ax.c)parame).aQk().version;
      int j = ((ax.c)parame).aQk().dkC;
      try
      {
        bh.a(paramm.BRL, (String)localObject1, paramm.filePath, i, j, ((ax.c)parame).iNU);
        AppMethodBeat.o(90614);
        return;
      }
      catch (Exception parame)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
        bh.bU(paramm.BRL, (String)localObject1);
        AppMethodBeat.o(90614);
      }
    }
    
    public static void d(com.tencent.mm.pluginsdk.h.a.c.e parame, com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90615);
      a((ax.c)parame, paramm);
      AppMethodBeat.o(90615);
    }
    
    public final void B(String paramString, int paramInt1, int paramInt2) {}
    
    public final void G(String paramString, long paramLong) {}
    
    public final void a(final com.tencent.mm.pluginsdk.h.a.c.e parame, final com.tencent.mm.pluginsdk.h.a.c.m paramm)
    {
      AppMethodBeat.i(90612);
      this.iNV.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */