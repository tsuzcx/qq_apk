package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.pluginsdk.k.a.c.k;
import com.tencent.mm.pluginsdk.k.a.c.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

final class bc$a
{
  public final com.tencent.mm.pluginsdk.k.a.c.l a(bc.c paramc)
  {
    AppMethodBeat.i(90595);
    String str1 = paramc.hig();
    for (;;)
    {
      final g localg;
      try
      {
        localCountDownLatch = new CountDownLatch(1);
        locali = new i();
        locala = paramc.bHu();
        final String str2 = locala.QYU;
        localObject = paramc.nGS;
        if (paramc.bHu().nIE)
        {
          localObject = new MTimerHandler(s.aFz().getLooper(), new MTimerHandler.CallBack()
          {
            public final boolean onTimerExpired()
            {
              AppMethodBeat.i(90593);
              Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "onTimerExpired, cdnTaskId:%s", new Object[] { str2 });
              f.bkg().Vz(str2);
              this.nGI.bGq();
              u.deleteFile(locala.getFilePath());
              locali.value = null;
              localCountDownLatch.countDown();
              AppMethodBeat.o(90593);
              return false;
            }
          }, false);
          localg = new g();
          localg.taskName = "task_WxaPkgDownloadPerformer";
          a local2 = new a(paramc, localg)
          {
            final void c(com.tencent.mm.pluginsdk.k.a.c.l paramAnonymousl)
            {
              AppMethodBeat.i(90594);
              if (this.nGM != null) {
                this.nGM.stopTimer();
              }
              locali.value = paramAnonymousl;
              localCountDownLatch.countDown();
              AppMethodBeat.o(90594);
            }
          };
          localg.field_mediaId = str2;
          localg.field_fullpath = locala.getFilePath();
          localg.iUJ = locala.url;
          localg.gbt = false;
          localg.iUG = local2;
          localg.iUK = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.hiD()));
          localg.iUL = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.hiE()));
          localg.field_fileType = com.tencent.mm.i.a.iUi;
          if (!(locala instanceof l)) {
            continue;
          }
          localg.iUN = false;
          if (!localg.iUU) {
            break label372;
          }
          localg.iUV = true;
          Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, cdnTask made, forceUseCronet:%b, forceUseNewDns:%b, url %s", new Object[] { Boolean.valueOf(localg.iUU), Boolean.valueOf(localg.iUV), paramc.btD() });
          f.bkg().b(localg, -1);
          if (localObject != null) {
            ((MTimerHandler)localObject).startTimer(locala.hiE());
          }
        }
      }
      catch (Exception paramc)
      {
        final CountDownLatch localCountDownLatch;
        final i locali;
        final com.tencent.mm.plugin.appbrand.appcache.a.a locala;
        Object localObject;
        Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
        AppMethodBeat.o(90595);
        return null;
      }
      try
      {
        localCountDownLatch.await();
        paramc = (com.tencent.mm.pluginsdk.k.a.c.l)locali.value;
        AppMethodBeat.o(90595);
        return paramc;
      }
      catch (Exception paramc)
      {
        Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
        AppMethodBeat.o(90595);
      }
      localObject = null;
      continue;
      locala.appId.startsWith("wxfe02ecfe70800f46");
      localg.iUU = true;
      continue;
      label372:
      com.tencent.luggage.sdk.h.d.a("WxaDownloadProfile| getHost", new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(161748);
          Object localObject = Uri.parse(localg.iUJ).getHost();
          if (!Util.isNullOrNil((String)localObject))
          {
            localObject = ab.acN((String)localObject);
            localg.iUM = new String[((ArrayList)localObject).size()];
            ((ArrayList)localObject).toArray(localg.iUM);
          }
          AppMethodBeat.o(161748);
        }
      });
    }
    return null;
  }
  
  static abstract class a
    implements g.a
  {
    private final bc.c nGO;
    private final g nGP;
    
    a(bc.c paramc, g paramg)
    {
      this.nGO = paramc;
      this.nGP = paramg;
    }
    
    private void a(com.tencent.mm.pluginsdk.k.a.c.l paraml, CdnLogic.CronetTaskResult paramCronetTaskResult)
    {
      Bundle localBundle;
      if (paramCronetTaskResult != null)
      {
        localBundle = paraml.bundle;
        if ((!this.nGP.iUV) && (this.nGP.iUU)) {
          break label129;
        }
      }
      label129:
      for (boolean bool = true;; bool = false)
      {
        localBundle.putBoolean("RESPONSE_KEY_USE_NEWDNS", bool);
        paraml.bundle.putBoolean("RESPONSE_KEY_USE_QUIC", paramCronetTaskResult.useQuic);
        paraml.bundle.putBoolean("RESPONSE_KEY_USE_HTTP2", paramCronetTaskResult.useHttp2);
        if (paramCronetTaskResult.performance != null)
        {
          paraml.bundle.putParcelable("RESPONSE_KEY_CRONET_PERFORMANCE", paramCronetTaskResult.performance);
          Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", new Object[] { paraml.QYU, Integer.valueOf(paraml.status), paraml.url, paramCronetTaskResult.performance });
        }
        return;
      }
    }
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      if (paramInt != 0)
      {
        c(new com.tencent.mm.pluginsdk.k.a.c.l(this.nGO, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.nGO.hig(), Integer.valueOf(paramInt) })), 3));
        Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.nGO.hig(), Integer.valueOf(paramInt) });
        return 0;
      }
      if (paramc != null)
      {
        if ((bc.d)this.nGO.RaJ != null)
        {
          paramString = new WxaPkgLoadProgress(Math.round((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
          bq.a(this.nGO.hig(), paramString);
        }
        return 0;
      }
      if (paramd != null)
      {
        paramString = this.nGO.hig();
        paramInt = paramd.field_retCode;
        paramc = paramd.field_httpResponseHeader;
        int i = paramd.field_httpStatusCode;
        if (paramd.cronetTaskResult == null) {
          break label320;
        }
        paramBoolean = true;
        Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s, httpStatusCode %d, useCronet %b", new Object[] { paramString, Integer.valueOf(paramInt), paramc, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
        if ((paramd.field_retCode == 0) && (200 == paramd.field_httpStatusCode)) {
          break label387;
        }
        if ((paramd.field_fileLength <= 0L) || (this.nGO.Hj(paramd.field_fileLength))) {
          break label326;
        }
        paramString = new com.tencent.mm.pluginsdk.k.a.c.l(this.nGO, new com.tencent.mm.pluginsdk.k.a.b.a(), paramd.field_httpStatusCode, 3);
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
        paramString = new com.tencent.mm.pluginsdk.k.a.c.l(this.nGO, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.nGO.hig(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
        break label303;
        label387:
        paramString = new com.tencent.mm.pluginsdk.k.a.c.l("AppBrandWxaPkgDownloader", this.nGO.hig(), this.nGP.iUJ, this.nGO.getFilePath(), -1L, null, 2, null);
        a(paramString, paramd.cronetTaskResult);
        c(paramString);
        paramInt = (int)u.bBQ(this.nGO.bHu().getFilePath());
        if (az.a.lts != null) {
          az.a.lts.dH(paramInt, 0);
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
    
    abstract void c(com.tencent.mm.pluginsdk.k.a.c.l paraml);
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bc.a
 * JD-Core Version:    0.7.0.1
 */