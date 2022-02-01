package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.j.a.c.f.d;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.pluginsdk.j.a.c.n.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public final class az
{
  final b kML;
  
  az()
  {
    AppMethodBeat.i(90618);
    this.kML = new b();
    AppMethodBeat.o(90618);
  }
  
  public static String bwm()
  {
    AppMethodBeat.i(90619);
    String str2 = com.tencent.mm.kernel.g.aAh().cachePath;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "appbrand/pkg/";
    FilePathGenerator.checkMkdir(str1);
    AppMethodBeat.o(90619);
    return str1;
  }
  
  public final int c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
  {
    AppMethodBeat.i(90620);
    if (this.kML.bed(parama.JYs))
    {
      Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.JYs });
      AppMethodBeat.o(90620);
      return 0;
    }
    int i = this.kML.b(parama);
    Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.JYs, Integer.valueOf(i) });
    AppMethodBeat.o(90620);
    return i;
  }
  
  static final class a
  {
    public final com.tencent.mm.pluginsdk.j.a.c.m a(az.c paramc)
    {
      AppMethodBeat.i(90595);
      String str1 = paramc.gnA();
      for (;;)
      {
        final com.tencent.mm.i.g localg;
        label251:
        boolean bool;
        try
        {
          localCountDownLatch = new CountDownLatch(1);
          locali = new i();
          locala = paramc.bwn();
          final String str2 = locala.JYs;
          localObject = paramc.kMY;
          if (paramc.bwn().kOB)
          {
            localObject = new MTimerHandler(p.ayg().getLooper(), new MTimerHandler.CallBack()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(90593);
                f.baQ().Oc(str2);
                this.kMN.bvk();
                com.tencent.mm.vfs.s.deleteFile(locala.getFilePath());
                locali.value = null;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90593);
                return false;
              }
            }, false);
            localg = new com.tencent.mm.i.g();
            localg.taskName = "task_WxaPkgDownloadPerformer";
            a local2 = new a(paramc, localg)
            {
              final void c(com.tencent.mm.pluginsdk.j.a.c.m paramAnonymousm)
              {
                AppMethodBeat.i(90594);
                if (this.kMR != null) {
                  this.kMR.stopTimer();
                }
                locali.value = paramAnonymousm;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90594);
              }
            };
            localg.field_mediaId = str2;
            localg.field_fullpath = locala.getFilePath();
            localg.gqB = locala.url;
            localg.ehd = false;
            localg.gqy = local2;
            localg.gqC = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getConnectTimeout()));
            localg.gqD = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getReadTimeout()));
            localg.field_fileType = com.tencent.mm.i.a.gqa;
            if (!(locala instanceof l)) {
              continue;
            }
            localg.gqF = false;
            if (!localg.gqM) {
              break label483;
            }
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
              break label532;
            }
            if (!BuildInfo.DEBUG) {
              break label547;
            }
            break label532;
            localg.gqN = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUz, bool);
            label273:
            Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, cdnTask made, forceUseCronet:%b, forceUseNewDns:%b, url %s", new Object[] { Boolean.valueOf(localg.gqM), Boolean.valueOf(localg.gqN), paramc.getURL() });
            f.baQ().b(localg, -1);
            if (localObject != null) {
              ((MTimerHandler)localObject).startTimer(locala.getReadTimeout());
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
          paramc = (com.tencent.mm.pluginsdk.j.a.c.m)locali.value;
          AppMethodBeat.o(90595);
          return paramc;
        }
        catch (Exception paramc)
        {
          label483:
          Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
          AppMethodBeat.o(90595);
          return null;
        }
        localObject = null;
        continue;
        if (locala.appId.startsWith("wxfe02ecfe70800f46"))
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUF, false)) {
            localg.gqM = true;
          }
        }
        else
        {
          if ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
            if (!BuildInfo.DEBUG) {
              break label542;
            }
          }
          for (;;)
          {
            if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sku, bool)) {
              break label545;
            }
            localg.gqM = true;
            break;
            com.tencent.luggage.sdk.g.c.a("WxaDownloadProfile| getHost", new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(161748);
                Object localObject = Uri.parse(localg.gqB).getHost();
                if (!Util.isNullOrNil((String)localObject))
                {
                  localObject = aa.Vd((String)localObject);
                  localg.gqE = new String[((ArrayList)localObject).size()];
                  ((ArrayList)localObject).toArray(localg.gqE);
                }
                AppMethodBeat.o(161748);
              }
            });
            break label273;
            label532:
            bool = true;
            break label251;
            bool = true;
            continue;
            label542:
            bool = false;
          }
          label545:
          continue;
          label547:
          bool = false;
        }
      }
    }
    
    static abstract class a
      implements g.a
    {
      private final az.c kMT;
      private final com.tencent.mm.i.g kMU;
      
      a(az.c paramc, com.tencent.mm.i.g paramg)
      {
        this.kMT = paramc;
        this.kMU = paramg;
      }
      
      private void a(com.tencent.mm.pluginsdk.j.a.c.m paramm, CdnLogic.CronetTaskResult paramCronetTaskResult)
      {
        Bundle localBundle;
        if (paramCronetTaskResult != null)
        {
          localBundle = paramm.bundle;
          if ((!this.kMU.gqN) && (this.kMU.gqM)) {
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
            Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", new Object[] { paramm.JYs, Integer.valueOf(paramm.status), paramm.url, paramCronetTaskResult.performance });
          }
          return;
        }
      }
      
      public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
      {
        if (paramInt != 0)
        {
          c(new com.tencent.mm.pluginsdk.j.a.c.m(this.kMT, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.kMT.gnA(), Integer.valueOf(paramInt) })), 3));
          Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.kMT.gnA(), Integer.valueOf(paramInt) });
          return 0;
        }
        if (paramc != null)
        {
          paramString = this.kMT.Kag;
          if (paramString != null)
          {
            paramc = new WxaPkgLoadProgress(Math.round((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
            paramString.a(this.kMT.gnA(), paramc);
          }
          return 0;
        }
        if (paramd != null)
        {
          paramString = this.kMT.gnA();
          paramInt = paramd.field_retCode;
          paramc = paramd.field_httpResponseHeader;
          int i = paramd.field_httpStatusCode;
          if (paramd.cronetTaskResult == null) {
            break label322;
          }
          paramBoolean = true;
          Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s, httpStatusCode %d, useCronet %b", new Object[] { paramString, Integer.valueOf(paramInt), paramc, Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          if ((paramd.field_retCode == 0) && (200 == paramd.field_httpStatusCode)) {
            break label389;
          }
          if ((paramd.field_fileLength <= 0L) || (this.kMT.AX(paramd.field_fileLength))) {
            break label328;
          }
          paramString = new com.tencent.mm.pluginsdk.j.a.c.m(this.kMT, new com.tencent.mm.pluginsdk.j.a.b.a(), paramd.field_httpStatusCode, 3);
          label305:
          a(paramString, paramd.cronetTaskResult);
          c(paramString);
        }
        for (;;)
        {
          return 0;
          label322:
          paramBoolean = false;
          break;
          label328:
          paramString = new com.tencent.mm.pluginsdk.j.a.c.m(this.kMT, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.kMT.gnA(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
          break label305;
          label389:
          paramString = new com.tencent.mm.pluginsdk.j.a.c.m("AppBrandWxaPkgDownloader", this.kMT.gnA(), this.kMU.gqB, this.kMT.getFilePath(), -1L, null, 2, null);
          a(paramString, paramd.cronetTaskResult);
          c(paramString);
          paramInt = (int)com.tencent.mm.vfs.s.boW(this.kMT.bwn().getFilePath());
          if (ay.a.iDr != null) {
            ay.a.iDr.dl(paramInt, 0);
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
      super(new az.d(az.this));
      AppMethodBeat.i(90596);
      AppMethodBeat.o(90596);
    }
    
    public final f.d a(com.tencent.mm.pluginsdk.j.a.c.l paraml)
    {
      AppMethodBeat.i(90598);
      paraml = new az.c((com.tencent.mm.plugin.appbrand.appcache.a.a)paraml);
      paraml.Kag = this.Kad;
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
      ((az.d)this.Kad).kMZ.quit();
      AppMethodBeat.o(90597);
    }
  }
  
  static final class c
    extends n.a<com.tencent.mm.plugin.appbrand.appcache.a.a>
  {
    private static final ThreadLocal<az.a> kMW;
    private String kMX;
    final ae.a kMY;
    
    static
    {
      AppMethodBeat.i(90609);
      kMW = new ThreadLocal() {};
      AppMethodBeat.o(90609);
    }
    
    c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
    {
      super();
      AppMethodBeat.i(90602);
      this.kMX = null;
      ae.a locala = ae.b(parama);
      parama = locala;
      if (locala == null) {
        parama = m.kKB;
      }
      this.kMY = parama;
      AppMethodBeat.o(90602);
    }
    
    public final boolean AX(long paramLong)
    {
      AppMethodBeat.i(90606);
      StatFs localStatFs = new StatFs(com.tencent.mm.vfs.aa.z(new o(getFilePath()).heq().her()));
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if ((l < 0L) || (l > paramLong))
      {
        AppMethodBeat.o(90606);
        return true;
      }
      AppMethodBeat.o(90606);
      return false;
    }
    
    /* Error */
    public final com.tencent.mm.pluginsdk.j.a.c.m a(com.tencent.mm.pluginsdk.j.a.c.j paramj)
    {
      // Byte code:
      //   0: ldc 96
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokespecial 100	com/tencent/mm/pluginsdk/j/a/c/n$a:bwt	()Lcom/tencent/mm/pluginsdk/j/a/c/f$b;
      //   9: checkcast 102	com/tencent/mm/plugin/appbrand/appcache/a/a
      //   12: astore_3
      //   13: aload_3
      //   14: invokevirtual 103	com/tencent/mm/plugin/appbrand/appcache/a/a:getFilePath	()Ljava/lang/String;
      //   17: invokestatic 109	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
      //   20: pop
      //   21: aload_0
      //   22: aload_3
      //   23: getfield 114	com/tencent/mm/pluginsdk/j/a/c/l:url	Ljava/lang/String;
      //   26: putfield 42	com/tencent/mm/plugin/appbrand/appcache/az$c:kMX	Ljava/lang/String;
      //   29: aload_0
      //   30: getfield 55	com/tencent/mm/plugin/appbrand/appcache/az$c:kMY	Lcom/tencent/mm/plugin/appbrand/appcache/ae$a;
      //   33: astore_2
      //   34: aload_0
      //   35: getfield 42	com/tencent/mm/plugin/appbrand/appcache/az$c:kMX	Ljava/lang/String;
      //   38: ldc 116
      //   40: invokevirtual 121	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   43: pop
      //   44: aload_2
      //   45: invokeinterface 126 1 0
      //   50: getstatic 31	com/tencent/mm/plugin/appbrand/appcache/az$c:kMW	Ljava/lang/ThreadLocal;
      //   53: invokevirtual 132	java/lang/ThreadLocal:get	()Ljava/lang/Object;
      //   56: checkcast 134	com/tencent/mm/plugin/appbrand/appcache/az$a
      //   59: astore_2
      //   60: new 136	com/tencent/mm/g/a/abd
      //   63: dup
      //   64: invokespecial 137	com/tencent/mm/g/a/abd:<init>	()V
      //   67: astore 4
      //   69: aload 4
      //   71: getfield 141	com/tencent/mm/g/a/abd:eit	Lcom/tencent/mm/g/a/abd$a;
      //   74: aload_0
      //   75: invokespecial 100	com/tencent/mm/pluginsdk/j/a/c/n$a:bwt	()Lcom/tencent/mm/pluginsdk/j/a/c/f$b;
      //   78: checkcast 102	com/tencent/mm/plugin/appbrand/appcache/a/a
      //   81: putfield 147	com/tencent/mm/g/a/abd$a:eiu	Lcom/tencent/mm/plugin/appbrand/appcache/a/a;
      //   84: aload 4
      //   86: getfield 141	com/tencent/mm/g/a/abd:eit	Lcom/tencent/mm/g/a/abd$a;
      //   89: iconst_1
      //   90: putfield 151	com/tencent/mm/g/a/abd$a:event	I
      //   93: getstatic 157	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
      //   96: aload 4
      //   98: invokestatic 163	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   101: invokevirtual 167	com/tencent/mm/sdk/event/EventCenter:asyncPublish	(Lcom/tencent/mm/sdk/event/IEvent;Landroid/os/Looper;)V
      //   104: aload_2
      //   105: aload_0
      //   106: invokevirtual 170	com/tencent/mm/plugin/appbrand/appcache/az$a:a	(Lcom/tencent/mm/plugin/appbrand/appcache/az$c;)Lcom/tencent/mm/pluginsdk/j/a/c/m;
      //   109: astore_2
      //   110: new 136	com/tencent/mm/g/a/abd
      //   113: dup
      //   114: invokespecial 137	com/tencent/mm/g/a/abd:<init>	()V
      //   117: astore 4
      //   119: aload 4
      //   121: getfield 141	com/tencent/mm/g/a/abd:eit	Lcom/tencent/mm/g/a/abd$a;
      //   124: aload_0
      //   125: invokespecial 100	com/tencent/mm/pluginsdk/j/a/c/n$a:bwt	()Lcom/tencent/mm/pluginsdk/j/a/c/f$b;
      //   128: checkcast 102	com/tencent/mm/plugin/appbrand/appcache/a/a
      //   131: putfield 147	com/tencent/mm/g/a/abd$a:eiu	Lcom/tencent/mm/plugin/appbrand/appcache/a/a;
      //   134: aload 4
      //   136: getfield 141	com/tencent/mm/g/a/abd:eit	Lcom/tencent/mm/g/a/abd$a;
      //   139: aload_2
      //   140: putfield 174	com/tencent/mm/g/a/abd$a:eiv	Lcom/tencent/mm/pluginsdk/j/a/c/m;
      //   143: aload 4
      //   145: getfield 141	com/tencent/mm/g/a/abd:eit	Lcom/tencent/mm/g/a/abd$a;
      //   148: iconst_2
      //   149: putfield 151	com/tencent/mm/g/a/abd$a:event	I
      //   152: getstatic 157	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
      //   155: aload 4
      //   157: invokestatic 163	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   160: invokevirtual 167	com/tencent/mm/sdk/event/EventCenter:asyncPublish	(Lcom/tencent/mm/sdk/event/IEvent;Landroid/os/Looper;)V
      //   163: aload_2
      //   164: ifnull +11 -> 175
      //   167: aload_2
      //   168: getfield 179	com/tencent/mm/pluginsdk/j/a/c/m:status	I
      //   171: iconst_3
      //   172: if_icmpne +124 -> 296
      //   175: ldc 181
      //   177: ldc 183
      //   179: iconst_1
      //   180: anewarray 185	java/lang/Object
      //   183: dup
      //   184: iconst_0
      //   185: aload_3
      //   186: getfield 188	com/tencent/mm/pluginsdk/j/a/c/l:JYs	Ljava/lang/String;
      //   189: aastore
      //   190: invokestatic 194	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   193: aload_0
      //   194: getfield 55	com/tencent/mm/plugin/appbrand/appcache/az$c:kMY	Lcom/tencent/mm/plugin/appbrand/appcache/ae$a;
      //   197: invokeinterface 197 1 0
      //   202: aload_0
      //   203: aload_1
      //   204: invokespecial 199	com/tencent/mm/pluginsdk/j/a/c/n$a:a	(Lcom/tencent/mm/pluginsdk/j/a/c/j;)Lcom/tencent/mm/pluginsdk/j/a/c/m;
      //   207: astore_3
      //   208: aload_3
      //   209: astore_1
      //   210: aload_3
      //   211: ifnull +15 -> 226
      //   214: aload_3
      //   215: getfield 203	com/tencent/mm/pluginsdk/j/a/c/m:bundle	Landroid/os/Bundle;
      //   218: ldc 205
      //   220: iconst_1
      //   221: invokevirtual 211	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
      //   224: aload_3
      //   225: astore_1
      //   226: aload_0
      //   227: getfield 55	com/tencent/mm/plugin/appbrand/appcache/az$c:kMY	Lcom/tencent/mm/plugin/appbrand/appcache/ae$a;
      //   230: aload_1
      //   231: invokeinterface 214 2 0
      //   236: aload_1
      //   237: ifnonnull +40 -> 277
      //   240: new 176	com/tencent/mm/pluginsdk/j/a/c/m
      //   243: dup
      //   244: aload_0
      //   245: aconst_null
      //   246: iconst_m1
      //   247: iconst_3
      //   248: invokespecial 217	com/tencent/mm/pluginsdk/j/a/c/m:<init>	(Lcom/tencent/mm/pluginsdk/j/a/c/e;Ljava/lang/Exception;II)V
      //   251: astore_1
      //   252: ldc 96
      //   254: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   257: aload_1
      //   258: areturn
      //   259: astore_2
      //   260: aconst_null
      //   261: astore_1
      //   262: ldc 181
      //   264: aload_2
      //   265: ldc 219
      //   267: iconst_0
      //   268: anewarray 185	java/lang/Object
      //   271: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   274: goto -38 -> 236
      //   277: ldc 96
      //   279: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   282: aload_1
      //   283: areturn
      //   284: astore_3
      //   285: aload_2
      //   286: astore_1
      //   287: aload_3
      //   288: astore_2
      //   289: goto -27 -> 262
      //   292: astore_2
      //   293: goto -31 -> 262
      //   296: aload_2
      //   297: astore_1
      //   298: goto -72 -> 226
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	301	0	this	c
      //   0	301	1	paramj	com.tencent.mm.pluginsdk.j.a.c.j
      //   33	135	2	localObject1	Object
      //   259	27	2	localException1	Exception
      //   288	1	2	localException2	Exception
      //   292	5	2	localException3	Exception
      //   12	213	3	localObject2	Object
      //   284	4	3	localException4	Exception
      //   67	89	4	localabd	com.tencent.mm.g.a.abd
      // Exception table:
      //   from	to	target	type
      //   5	163	259	java/lang/Exception
      //   167	175	284	java/lang/Exception
      //   175	208	284	java/lang/Exception
      //   214	224	284	java/lang/Exception
      //   226	236	292	java/lang/Exception
    }
    
    public final String avy()
    {
      return "AppBrandWxaPkgDownloader";
    }
    
    protected final com.tencent.mm.plugin.appbrand.appcache.a.a bwn()
    {
      AppMethodBeat.i(90603);
      com.tencent.mm.plugin.appbrand.appcache.a.a locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.bwt();
      AppMethodBeat.o(90603);
      return locala;
    }
    
    public final boolean bwo()
    {
      return true;
    }
    
    public final boolean bwp()
    {
      return false;
    }
    
    public final boolean bwq()
    {
      return true;
    }
    
    public final boolean bwr()
    {
      return false;
    }
    
    public final boolean bws()
    {
      AppMethodBeat.i(90607);
      switch (ab.ape())
      {
      default: 
        AppMethodBeat.o(90607);
        return false;
      case 0: 
        AppMethodBeat.o(90607);
        return false;
      }
      boolean bool = super.bws();
      AppMethodBeat.o(90607);
      return bool;
    }
    
    public final String getURL()
    {
      return this.kMX;
    }
  }
  
  final class d
    implements com.tencent.mm.pluginsdk.j.a.c.c
  {
    final MMHandler kMZ;
    
    d()
    {
      AppMethodBeat.i(90611);
      this.kMZ = new MMHandler("WxaPkgDownloadPerformerEventDispatchThread");
      AppMethodBeat.o(90611);
    }
    
    private static void a(az.c paramc, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90617);
      com.tencent.mm.vfs.s.deleteFile(paramm.filePath);
      if ((paramc.bwn() instanceof l))
      {
        k.kKx.a((l)paramc.bwn(), paramm);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.bwn() instanceof aw))
      {
        s.a((aw)paramc.bwn(), paramm, paramc.kMY);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.bwn() instanceof bs))
      {
        bt.a((bs)paramc.bwn(), paramm, paramc.kMY);
        AppMethodBeat.o(90617);
        return;
      }
      String str = paramc.bwn().appId;
      if ((paramm.Kab instanceof com.tencent.mm.pluginsdk.j.a.b.a)) {
        paramc = b.a.a.kOI;
      }
      for (;;)
      {
        bj.a(paramm.JYs, str, paramc);
        AppMethodBeat.o(90617);
        return;
        switch (paramm.httpStatusCode)
        {
        default: 
          paramc = b.a.a.kOD;
          break;
        case 403: 
        case 404: 
          paramc = b.a.a.kOH;
        }
      }
    }
    
    public static void b(com.tencent.mm.pluginsdk.j.a.c.e parame, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90613);
      a((az.c)parame, paramm);
      AppMethodBeat.o(90613);
    }
    
    public static void c(com.tencent.mm.pluginsdk.j.a.c.e parame, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90614);
      Object localObject1 = ((az.c)parame).bwn();
      if ((localObject1 instanceof aw))
      {
        paramm = (aw)localObject1;
        localObject1 = ((az.c)parame).kMY;
        parame = ((com.tencent.mm.plugin.appbrand.api.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub();
        if (parame == null)
        {
          bj.a(paramm.JYs, paramm.appId, b.a.a.kOJ, null);
          AppMethodBeat.o(90614);
          return;
        }
        Object localObject2 = paramm.appId;
        j = paramm.kMt;
        i = paramm.kMu;
        String str = paramm.bwb();
        Object localObject3 = parame.a((String)localObject2, j, 0, new String[] { "pkgPath" });
        if (localObject3 == null)
        {
          Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, get NULL oldInfo with appId[%s] version[%d]", new Object[] { localObject2, Integer.valueOf(j) });
          bj.a(paramm.JYs, paramm.appId, b.a.a.kOJ, null);
          AppMethodBeat.o(90614);
          return;
        }
        ((ae.a)localObject1).bvm();
        long l1 = SystemClock.elapsedRealtime();
        j = s.B(((bd)localObject3).field_pkgPath, str, paramm.getFilePath());
        long l2 = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paramm.appId, ((bd)localObject3).field_pkgPath, str, paramm.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
        ((ae.a)localObject1).vQ(j);
        boolean bool2 = paramm.kMv instanceof b.b;
        if (j == 0)
        {
          Collection localCollection = bj.Vu(paramm.JYs);
          localObject2 = new i();
          localObject3 = new i();
          i locali = new i();
          s.1 local1 = new s.1((i)localObject2, (i)localObject3, locali);
          bj.a(paramm.JYs, local1);
          bj.a(paramm.JYs, paramm.appId, str, i, 0, (ae.a)localObject1);
          if (b.a.a.kOC == ((i)localObject3).value) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, urlKey[%s] verifyOk[%s] canFallback[%b]", new Object[] { paramm.JYs, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if ((!bool1) && (bool2)) {
              break label484;
            }
            if (localCollection == null) {
              break;
            }
            parame = localCollection.iterator();
            while (parame.hasNext()) {
              ((bj.a)parame.next()).a((String)((i)localObject2).value, (b.a.a)((i)localObject3).value, locali.value);
            }
          }
          AppMethodBeat.o(90614);
          return;
          label484:
          bj.a(paramm.JYs, localCollection);
        }
        com.tencent.mm.vfs.s.deleteFile(str);
        com.tencent.mm.vfs.s.deleteFile(paramm.getFilePath());
        localObject1 = new s.2(bj.Vu(paramm.JYs), paramm);
        if ((paramm.kMv instanceof b.b)) {
          ((b.b)paramm.kMv).bwD();
        }
        parame = parame.a(paramm.appId, paramm.kMu, 0, new String[] { "downloadURL" });
        if ((parame == null) || (TextUtils.isEmpty(parame.field_downloadURL)))
        {
          Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, fallback non-incremental get EMPTY url with key[%s]", new Object[] { paramm.JYs });
          ((bj.a)localObject1).a(paramm.appId, b.a.a.kOJ, null);
          AppMethodBeat.o(90614);
          return;
        }
        if (!bj.c(paramm.appId, 0, paramm.kMu, parame.field_downloadURL, (bj.a)localObject1)) {
          ((bj.a)localObject1).a(paramm.appId, b.a.a.kOJ, null);
        }
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof bs))
      {
        bt.a((bs)localObject1, ((az.c)parame).kMY);
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof l))
      {
        k.kKx.a((l)localObject1, paramm);
        AppMethodBeat.o(90614);
        return;
      }
      localObject1 = ((az.c)parame).bwn().appId;
      int i = ((az.c)parame).bwn().version;
      int j = ((az.c)parame).bwn().dMe;
      try
      {
        bj.a(paramm.JYs, (String)localObject1, paramm.filePath, i, j, ((az.c)parame).kMY);
        AppMethodBeat.o(90614);
        return;
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.WxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
        bj.cu(paramm.JYs, (String)localObject1);
        AppMethodBeat.o(90614);
      }
    }
    
    public static void d(com.tencent.mm.pluginsdk.j.a.c.e parame, com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90615);
      a((az.c)parame, paramm);
      AppMethodBeat.o(90615);
    }
    
    public final void C(String paramString, int paramInt1, int paramInt2) {}
    
    public final void O(String paramString, long paramLong) {}
    
    public final void a(final com.tencent.mm.pluginsdk.j.a.c.e parame, final com.tencent.mm.pluginsdk.j.a.c.m paramm)
    {
      AppMethodBeat.i(90612);
      this.kMZ.post(new Runnable()
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
            az.d.d(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            az.d.c(parame, paramm);
            AppMethodBeat.o(90610);
            return;
            az.d.b(parame, paramm);
          }
        }
      });
      AppMethodBeat.o(90612);
    }
    
    public final void a(String paramString, com.tencent.mm.pluginsdk.j.a.c.k paramk)
    {
      AppMethodBeat.i(90616);
      bj.a(paramString, (WxaPkgLoadProgress)paramk);
      AppMethodBeat.o(90616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az
 * JD-Core Version:    0.7.0.1
 */