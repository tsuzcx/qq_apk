package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.e;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

final class az$a
{
  public final m a(az.c paramc)
  {
    AppMethodBeat.i(90595);
    String str1 = paramc.feq();
    for (;;)
    {
      final com.tencent.mm.i.g localg;
      label255:
      boolean bool;
      try
      {
        localCountDownLatch = new CountDownLatch(1);
        locali = new i();
        locala = paramc.baZ();
        final String str2 = locala.Fhz;
        localObject = paramc.jKZ;
        if (paramc.baZ().jMx)
        {
          localObject = new aw(p.ahT().getLooper(), new aw.a()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(90593);
              f.aGZ().Fs(str2);
              this.jKO.aZT();
              o.deleteFile(locala.getFilePath());
              locali.value = null;
              localCountDownLatch.countDown();
              AppMethodBeat.o(90593);
              return false;
            }
          }, false);
          localg = new com.tencent.mm.i.g();
          localg.fLl = "task_WxaPkgDownloadPerformer";
          a local2 = new a(paramc, localg)
          {
            final void c(m paramAnonymousm)
            {
              AppMethodBeat.i(90594);
              if (this.jKS != null) {
                this.jKS.stopTimer();
              }
              locali.value = paramAnonymousm;
              localCountDownLatch.countDown();
              AppMethodBeat.o(90594);
            }
          };
          localg.field_mediaId = str2;
          localg.field_fullpath = locala.getFilePath();
          localg.fLp = locala.url;
          localg.dPh = false;
          localg.fLm = local2;
          localg.fLq = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getConnectTimeout()));
          localg.fLr = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getReadTimeout()));
          localg.field_fileType = com.tencent.mm.i.a.fKO;
          if (!(locala instanceof l)) {
            continue;
          }
          localg.fLt = false;
          if (!localg.fLA) {
            break label493;
          }
          if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
            break label542;
          }
          if (!j.DEBUG) {
            break label557;
          }
          break label542;
          localg.fLB = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBN, bool);
          label277:
          ae.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, cdnTask made, forceUseCronet:%b, forceUseNewDns:%b, url %s", new Object[] { Boolean.valueOf(localg.fLA), Boolean.valueOf(localg.fLB), paramc.getURL() });
          f.aGZ().b(localg, -1);
          if (localObject != null)
          {
            long l = locala.getReadTimeout();
            ((aw)localObject).ay(l, l);
          }
        }
      }
      catch (Exception paramc)
      {
        final CountDownLatch localCountDownLatch;
        final i locali;
        final com.tencent.mm.plugin.appbrand.appcache.a.a locala;
        Object localObject;
        ae.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
        AppMethodBeat.o(90595);
        return null;
      }
      try
      {
        localCountDownLatch.await();
        paramc = (m)locali.value;
        AppMethodBeat.o(90595);
        return paramc;
      }
      catch (Exception paramc)
      {
        label493:
        ae.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
        AppMethodBeat.o(90595);
        return null;
      }
      localObject = null;
      continue;
      if (locala.appId.startsWith("wxfe02ecfe70800f46"))
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBS, false)) {
          localg.fLA = true;
        }
      }
      else
      {
        if ((!j.IS_FLAVOR_RED) && (!j.IS_FLAVOR_PURPLE)) {
          if (!j.DEBUG) {
            break label552;
          }
        }
        for (;;)
        {
          if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNy, bool)) {
            break label555;
          }
          localg.fLA = true;
          break;
          com.tencent.luggage.sdk.g.c.a("WxaDownloadProfile| getHost", new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161748);
              Object localObject = Uri.parse(localg.fLp).getHost();
              if (!bu.isNullOrNil((String)localObject))
              {
                localObject = aa.LU((String)localObject);
                localg.fLs = new String[((ArrayList)localObject).size()];
                ((ArrayList)localObject).toArray(localg.fLs);
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
    private final az.c jKU;
    private final com.tencent.mm.i.g jKV;
    
    a(az.c paramc, com.tencent.mm.i.g paramg)
    {
      this.jKU = paramc;
      this.jKV = paramg;
    }
    
    private void a(m paramm, CdnLogic.CronetTaskResult paramCronetTaskResult)
    {
      Bundle localBundle;
      if (paramCronetTaskResult != null)
      {
        localBundle = paramm.bundle;
        if ((!this.jKV.fLB) && (this.jKV.fLA)) {
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
          ae.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", new Object[] { paramm.Fhz, Integer.valueOf(paramm.status), paramm.url, paramCronetTaskResult.performance });
        }
        return;
      }
    }
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
    {
      if (paramInt != 0)
      {
        c(new m(this.jKU, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.jKU.feq(), Integer.valueOf(paramInt) })), 3));
        ae.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.jKU.feq(), Integer.valueOf(paramInt) });
        return 0;
      }
      if (paramc != null)
      {
        paramString = this.jKU.Fjn;
        if (paramString != null)
        {
          paramc = new WxaPkgLoadProgress((int)((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
          paramString.a(this.jKU.feq(), paramc);
        }
        return 0;
      }
      if (paramd != null)
      {
        paramString = this.jKU.feq();
        paramInt = paramd.field_retCode;
        paramc = paramd.field_httpResponseHeader;
        int i = paramd.field_httpStatusCode;
        if (paramd.cronetTaskResult == null) {
          break label320;
        }
        paramBoolean = true;
        ae.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s, httpStatusCode %d, useCronet %b", new Object[] { paramString, Integer.valueOf(paramInt), paramc, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
        if ((paramd.field_retCode == 0) && (200 == paramd.field_httpStatusCode)) {
          break label387;
        }
        if ((paramd.field_fileLength <= 0L) || (this.jKU.sR(paramd.field_fileLength))) {
          break label326;
        }
        paramString = new m(this.jKU, new com.tencent.mm.pluginsdk.j.a.b.a(), paramd.field_httpStatusCode, 3);
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
        paramString = new m(this.jKU, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.jKU.feq(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
        break label303;
        label387:
        paramString = new m("AppBrandWxaPkgDownloader", this.jKU.feq(), this.jKV.fLp, this.jKU.getFilePath(), -1L, null, 2, null);
        a(paramString, paramd.cronetTaskResult);
        c(paramString);
        paramInt = (int)o.aZR(this.jKU.baZ().getFilePath());
        if (au.a.hIH != null) {
          au.a.hIH.db(paramInt, 0);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    abstract void c(m paramm);
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az.a
 * JD-Core Version:    0.7.0.1
 */