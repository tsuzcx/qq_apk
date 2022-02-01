package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b.b;
import com.tencent.mm.pluginsdk.res.downloader.model.f.d;
import com.tencent.mm.pluginsdk.res.downloader.model.m.a;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public final class bd
{
  final b qGy;
  
  bd()
  {
    AppMethodBeat.i(90618);
    this.qGy = new b();
    AppMethodBeat.o(90618);
  }
  
  public static String cgP()
  {
    AppMethodBeat.i(90619);
    String str2 = h.baE().cachePath;
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
    if (this.qGy.bqn(parama.XUX))
    {
      Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[] { parama.XUX });
      AppMethodBeat.o(90620);
      return 0;
    }
    int i = this.qGy.b(parama);
    Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[] { parama.XUX, Integer.valueOf(i) });
    AppMethodBeat.o(90620);
    return i;
  }
  
  static final class a
  {
    public final com.tencent.mm.pluginsdk.res.downloader.model.l a(bd.c paramc)
    {
      AppMethodBeat.i(90595);
      String str1 = paramc.iJd();
      for (;;)
      {
        final com.tencent.mm.g.g localg;
        try
        {
          localCountDownLatch = new CountDownLatch(1);
          localk = new com.tencent.mm.plugin.appbrand.af.k();
          locala = paramc.cgQ();
          final String str2 = locala.XUX;
          localObject = paramc.qGK;
          if (paramc.cgQ().qIu)
          {
            localObject = new MTimerHandler(s.aYy().getLooper(), new MTimerHandler.CallBack()
            {
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(90593);
                Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "onTimerExpired, cdnTaskId:%s", new Object[] { str2 });
                com.tencent.mm.modelcdntran.k.bHW().Nz(str2);
                this.qGA.cfQ();
                y.deleteFile(locala.getFilePath());
                localk.value = null;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90593);
                return false;
              }
            }, false);
            localg = new com.tencent.mm.g.g();
            localg.taskName = "task_WxaPkgDownloadPerformer";
            a local2 = new a(paramc, localg)
            {
              final void c(com.tencent.mm.pluginsdk.res.downloader.model.l paramAnonymousl)
              {
                AppMethodBeat.i(90594);
                if (this.qGE != null) {
                  this.qGE.stopTimer();
                }
                localk.value = paramAnonymousl;
                localCountDownLatch.countDown();
                AppMethodBeat.o(90594);
              }
            };
            localg.field_mediaId = str2;
            localg.field_fullpath = locala.getFilePath();
            localg.lwO = locala.url;
            localg.ihD = false;
            localg.lwL = local2;
            localg.lwP = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.iJC()));
            localg.lwQ = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.iJD()));
            localg.field_fileType = com.tencent.mm.g.a.lwn;
            if (!(locala instanceof m)) {
              continue;
            }
            localg.lwS = false;
            if (!localg.lwZ) {
              break label372;
            }
            localg.lxa = true;
            Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, cdnTask made, forceUseCronet:%b, forceUseNewDns:%b, url %s", new Object[] { Boolean.valueOf(localg.lwZ), Boolean.valueOf(localg.lxa), paramc.cgR() });
            com.tencent.mm.modelcdntran.k.bHW().b(localg, -1);
            if (localObject != null) {
              ((MTimerHandler)localObject).startTimer(locala.iJD());
            }
          }
        }
        catch (Exception paramc)
        {
          final CountDownLatch localCountDownLatch;
          final com.tencent.mm.plugin.appbrand.af.k localk;
          final com.tencent.mm.plugin.appbrand.appcache.a.a locala;
          Object localObject;
          Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
          AppMethodBeat.o(90595);
          return null;
        }
        try
        {
          localCountDownLatch.await();
          paramc = (com.tencent.mm.pluginsdk.res.downloader.model.l)localk.value;
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
        localg.lwZ = true;
        continue;
        label372:
        com.tencent.luggage.sdk.h.d.a("WxaDownloadProfile| getHost", new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161748);
            Object localObject = Uri.parse(localg.lwO).getHost();
            if (!Util.isNullOrNil((String)localObject))
            {
              localObject = ac.Vl((String)localObject);
              localg.lwR = new String[((ArrayList)localObject).size()];
              ((ArrayList)localObject).toArray(localg.lwR);
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
      private final bd.c qGG;
      private final com.tencent.mm.g.g qGH;
      
      a(bd.c paramc, com.tencent.mm.g.g paramg)
      {
        this.qGG = paramc;
        this.qGH = paramg;
      }
      
      private void a(com.tencent.mm.pluginsdk.res.downloader.model.l paraml, CdnLogic.CronetTaskResult paramCronetTaskResult)
      {
        Bundle localBundle;
        if (paramCronetTaskResult != null)
        {
          localBundle = paraml.bundle;
          if ((!this.qGH.lxa) && (this.qGH.lwZ)) {
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
            Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", new Object[] { paraml.XUX, Integer.valueOf(paraml.status), paraml.url, paramCronetTaskResult.performance });
          }
          return;
        }
      }
      
      public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
      {
        if (paramInt != 0)
        {
          c(new com.tencent.mm.pluginsdk.res.downloader.model.l(this.qGG, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[] { this.qGG.iJd(), Integer.valueOf(paramInt) })), 3));
          Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", new Object[] { this.qGG.iJd(), Integer.valueOf(paramInt) });
          return 0;
        }
        if (paramc != null)
        {
          if ((bd.d)this.qGG.XWO != null)
          {
            paramString = new WxaPkgLoadProgress(Math.round((float)paramc.field_finishedLength / (float)paramc.field_toltalLength * 100.0F), paramc.field_finishedLength, paramc.field_toltalLength);
            bq.a(this.qGG.iJd(), paramString);
          }
          return 0;
        }
        if (paramd != null)
        {
          paramString = this.qGG.iJd();
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
          if ((paramd.field_fileLength <= 0L) || (this.qGG.jz(paramd.field_fileLength))) {
            break label326;
          }
          paramString = new com.tencent.mm.pluginsdk.res.downloader.model.l(this.qGG, new com.tencent.mm.pluginsdk.res.downloader.a.a(), paramd.field_httpStatusCode, 3);
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
          paramString = new com.tencent.mm.pluginsdk.res.downloader.model.l(this.qGG, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[] { this.qGG.iJd(), Integer.valueOf(paramd.field_retCode) })), paramd.field_httpStatusCode, 3);
          break label303;
          label387:
          paramString = new com.tencent.mm.pluginsdk.res.downloader.model.l("AppBrandWxaPkgDownloader", this.qGG.iJd(), this.qGH.lwO, this.qGG.getFilePath(), -1L, null, 2, null);
          a(paramString, paramd.cronetTaskResult);
          c(paramString);
          paramInt = (int)y.bEl(this.qGG.cgQ().getFilePath());
          if (az.a.okQ != null) {
            az.a.okQ.eB(paramInt, 0);
          }
        }
      }
      
      public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
      
      abstract void c(com.tencent.mm.pluginsdk.res.downloader.model.l paraml);
      
      public final byte[] h(String paramString, byte[] paramArrayOfByte)
      {
        return new byte[0];
      }
    }
  }
  
  static final class b
    extends com.tencent.mm.pluginsdk.res.downloader.model.m
  {
    b()
    {
      super(new bd.d());
      AppMethodBeat.i(320313);
      AppMethodBeat.o(320313);
    }
    
    public final f.d<com.tencent.mm.plugin.appbrand.appcache.a.a> a(com.tencent.mm.pluginsdk.res.downloader.model.k paramk)
    {
      AppMethodBeat.i(90598);
      paramk = new bd.c((com.tencent.mm.plugin.appbrand.appcache.a.a)paramk);
      paramk.XWO = iJI();
      AppMethodBeat.o(90598);
      return paramk;
    }
    
    public final int b(com.tencent.mm.pluginsdk.res.downloader.model.k paramk)
    {
      AppMethodBeat.i(90599);
      int i = super.b(paramk);
      if (i == 1)
      {
        super.b(paramk);
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
      ((bd.d)iJI()).qGL.quit();
      AppMethodBeat.o(90597);
    }
  }
  
  static final class c
    extends m.a<com.tencent.mm.plugin.appbrand.appcache.a.a>
  {
    private static final ThreadLocal<bd.a> qGI;
    private String qGJ;
    final ag.a qGK;
    
    static
    {
      AppMethodBeat.i(90609);
      qGI = new ThreadLocal() {};
      AppMethodBeat.o(90609);
    }
    
    c(com.tencent.mm.plugin.appbrand.appcache.a.a parama)
    {
      super();
      AppMethodBeat.i(90602);
      this.qGJ = null;
      ag.a locala = ag.b(parama);
      parama = locala;
      if (locala == null) {
        parama = n.qEl;
      }
      this.qGK = parama;
      AppMethodBeat.o(90602);
    }
    
    /* Error */
    public final com.tencent.mm.pluginsdk.res.downloader.model.l a(com.tencent.mm.pluginsdk.res.downloader.model.j paramj)
    {
      // Byte code:
      //   0: ldc 60
      //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokespecial 64	com/tencent/mm/pluginsdk/res/downloader/model/m$a:cgY	()Lcom/tencent/mm/pluginsdk/res/downloader/model/f$b;
      //   9: checkcast 66	com/tencent/mm/plugin/appbrand/appcache/a/a
      //   12: astore_3
      //   13: aload_3
      //   14: invokevirtual 70	com/tencent/mm/plugin/appbrand/appcache/a/a:getFilePath	()Ljava/lang/String;
      //   17: invokestatic 76	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
      //   20: pop
      //   21: aload_0
      //   22: aload_3
      //   23: getfield 81	com/tencent/mm/pluginsdk/res/downloader/model/k:url	Ljava/lang/String;
      //   26: putfield 42	com/tencent/mm/plugin/appbrand/appcache/bd$c:qGJ	Ljava/lang/String;
      //   29: aload_0
      //   30: getfield 55	com/tencent/mm/plugin/appbrand/appcache/bd$c:qGK	Lcom/tencent/mm/plugin/appbrand/appcache/ag$a;
      //   33: astore_2
      //   34: aload_0
      //   35: getfield 42	com/tencent/mm/plugin/appbrand/appcache/bd$c:qGJ	Ljava/lang/String;
      //   38: ldc 83
      //   40: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   43: pop
      //   44: aload_2
      //   45: invokeinterface 93 1 0
      //   50: getstatic 31	com/tencent/mm/plugin/appbrand/appcache/bd$c:qGI	Ljava/lang/ThreadLocal;
      //   53: invokevirtual 99	java/lang/ThreadLocal:get	()Ljava/lang/Object;
      //   56: checkcast 101	com/tencent/mm/plugin/appbrand/appcache/bd$a
      //   59: astore_2
      //   60: new 103	com/tencent/mm/autogen/a/aek
      //   63: dup
      //   64: invokespecial 104	com/tencent/mm/autogen/a/aek:<init>	()V
      //   67: astore 4
      //   69: aload 4
      //   71: getfield 108	com/tencent/mm/autogen/a/aek:iiZ	Lcom/tencent/mm/autogen/a/aek$a;
      //   74: aload_0
      //   75: invokespecial 64	com/tencent/mm/pluginsdk/res/downloader/model/m$a:cgY	()Lcom/tencent/mm/pluginsdk/res/downloader/model/f$b;
      //   78: checkcast 66	com/tencent/mm/plugin/appbrand/appcache/a/a
      //   81: putfield 114	com/tencent/mm/autogen/a/aek$a:ija	Lcom/tencent/mm/plugin/appbrand/appcache/a/a;
      //   84: aload 4
      //   86: getfield 108	com/tencent/mm/autogen/a/aek:iiZ	Lcom/tencent/mm/autogen/a/aek$a;
      //   89: iconst_1
      //   90: putfield 118	com/tencent/mm/autogen/a/aek$a:event	I
      //   93: aload 4
      //   95: invokestatic 124	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   98: invokevirtual 128	com/tencent/mm/autogen/a/aek:asyncPublish	(Landroid/os/Looper;)V
      //   101: aload_2
      //   102: aload_0
      //   103: invokevirtual 131	com/tencent/mm/plugin/appbrand/appcache/bd$a:a	(Lcom/tencent/mm/plugin/appbrand/appcache/bd$c;)Lcom/tencent/mm/pluginsdk/res/downloader/model/l;
      //   106: astore_2
      //   107: new 103	com/tencent/mm/autogen/a/aek
      //   110: dup
      //   111: invokespecial 104	com/tencent/mm/autogen/a/aek:<init>	()V
      //   114: astore 4
      //   116: aload 4
      //   118: getfield 108	com/tencent/mm/autogen/a/aek:iiZ	Lcom/tencent/mm/autogen/a/aek$a;
      //   121: aload_0
      //   122: invokespecial 64	com/tencent/mm/pluginsdk/res/downloader/model/m$a:cgY	()Lcom/tencent/mm/pluginsdk/res/downloader/model/f$b;
      //   125: checkcast 66	com/tencent/mm/plugin/appbrand/appcache/a/a
      //   128: putfield 114	com/tencent/mm/autogen/a/aek$a:ija	Lcom/tencent/mm/plugin/appbrand/appcache/a/a;
      //   131: aload 4
      //   133: getfield 108	com/tencent/mm/autogen/a/aek:iiZ	Lcom/tencent/mm/autogen/a/aek$a;
      //   136: aload_2
      //   137: putfield 135	com/tencent/mm/autogen/a/aek$a:ijb	Lcom/tencent/mm/pluginsdk/res/downloader/model/l;
      //   140: aload 4
      //   142: getfield 108	com/tencent/mm/autogen/a/aek:iiZ	Lcom/tencent/mm/autogen/a/aek$a;
      //   145: iconst_2
      //   146: putfield 118	com/tencent/mm/autogen/a/aek$a:event	I
      //   149: aload 4
      //   151: invokestatic 124	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   154: invokevirtual 128	com/tencent/mm/autogen/a/aek:asyncPublish	(Landroid/os/Looper;)V
      //   157: aload_2
      //   158: ifnull +11 -> 169
      //   161: aload_2
      //   162: getfield 140	com/tencent/mm/pluginsdk/res/downloader/model/l:status	I
      //   165: iconst_3
      //   166: if_icmpne +124 -> 290
      //   169: ldc 142
      //   171: ldc 144
      //   173: iconst_1
      //   174: anewarray 146	java/lang/Object
      //   177: dup
      //   178: iconst_0
      //   179: aload_3
      //   180: getfield 149	com/tencent/mm/pluginsdk/res/downloader/model/k:XUX	Ljava/lang/String;
      //   183: aastore
      //   184: invokestatic 155	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   187: aload_0
      //   188: getfield 55	com/tencent/mm/plugin/appbrand/appcache/bd$c:qGK	Lcom/tencent/mm/plugin/appbrand/appcache/ag$a;
      //   191: invokeinterface 158 1 0
      //   196: aload_0
      //   197: aload_1
      //   198: invokespecial 160	com/tencent/mm/pluginsdk/res/downloader/model/m$a:a	(Lcom/tencent/mm/pluginsdk/res/downloader/model/j;)Lcom/tencent/mm/pluginsdk/res/downloader/model/l;
      //   201: astore_3
      //   202: aload_3
      //   203: astore_1
      //   204: aload_3
      //   205: ifnull +15 -> 220
      //   208: aload_3
      //   209: getfield 164	com/tencent/mm/pluginsdk/res/downloader/model/l:bundle	Landroid/os/Bundle;
      //   212: ldc 166
      //   214: iconst_1
      //   215: invokevirtual 172	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
      //   218: aload_3
      //   219: astore_1
      //   220: aload_0
      //   221: getfield 55	com/tencent/mm/plugin/appbrand/appcache/bd$c:qGK	Lcom/tencent/mm/plugin/appbrand/appcache/ag$a;
      //   224: aload_1
      //   225: invokeinterface 175 2 0
      //   230: aload_1
      //   231: ifnonnull +40 -> 271
      //   234: new 137	com/tencent/mm/pluginsdk/res/downloader/model/l
      //   237: dup
      //   238: aload_0
      //   239: aconst_null
      //   240: iconst_m1
      //   241: iconst_3
      //   242: invokespecial 178	com/tencent/mm/pluginsdk/res/downloader/model/l:<init>	(Lcom/tencent/mm/pluginsdk/res/downloader/model/e;Ljava/lang/Exception;II)V
      //   245: astore_1
      //   246: ldc 60
      //   248: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   251: aload_1
      //   252: areturn
      //   253: astore_2
      //   254: aconst_null
      //   255: astore_1
      //   256: ldc 142
      //   258: aload_2
      //   259: ldc 180
      //   261: iconst_0
      //   262: anewarray 146	java/lang/Object
      //   265: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   268: goto -38 -> 230
      //   271: ldc 60
      //   273: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   276: aload_1
      //   277: areturn
      //   278: astore_3
      //   279: aload_2
      //   280: astore_1
      //   281: aload_3
      //   282: astore_2
      //   283: goto -27 -> 256
      //   286: astore_2
      //   287: goto -31 -> 256
      //   290: aload_2
      //   291: astore_1
      //   292: goto -72 -> 220
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	295	0	this	c
      //   0	295	1	paramj	com.tencent.mm.pluginsdk.res.downloader.model.j
      //   33	129	2	localObject1	Object
      //   253	27	2	localException1	Exception
      //   282	1	2	localException2	Exception
      //   286	5	2	localException3	Exception
      //   12	207	3	localObject2	Object
      //   278	4	3	localException4	Exception
      //   67	83	4	localaek	com.tencent.mm.autogen.a.aek
      // Exception table:
      //   from	to	target	type
      //   5	157	253	java/lang/Exception
      //   161	169	278	java/lang/Exception
      //   169	202	278	java/lang/Exception
      //   208	218	278	java/lang/Exception
      //   220	230	286	java/lang/Exception
    }
    
    public final String aVp()
    {
      return "AppBrandWxaPkgDownloader";
    }
    
    protected final com.tencent.mm.plugin.appbrand.appcache.a.a cgQ()
    {
      AppMethodBeat.i(90603);
      com.tencent.mm.plugin.appbrand.appcache.a.a locala = (com.tencent.mm.plugin.appbrand.appcache.a.a)super.cgY();
      AppMethodBeat.o(90603);
      return locala;
    }
    
    public final String cgR()
    {
      return this.qGJ;
    }
    
    public final boolean cgS()
    {
      return true;
    }
    
    public final boolean cgT()
    {
      return false;
    }
    
    public final boolean cgU()
    {
      return true;
    }
    
    public final boolean cgV()
    {
      return false;
    }
    
    public final boolean cgW()
    {
      return true;
    }
    
    public final boolean cgX()
    {
      AppMethodBeat.i(90607);
      switch (com.tencent.mm.compatible.deviceinfo.ac.aPK())
      {
      default: 
        AppMethodBeat.o(90607);
        return false;
      case 0: 
        AppMethodBeat.o(90607);
        return false;
      }
      boolean bool = super.cgX();
      AppMethodBeat.o(90607);
      return bool;
    }
    
    public final boolean jz(long paramLong)
    {
      AppMethodBeat.i(90606);
      StatFs localStatFs = new StatFs(ah.v(new u(getFilePath()).jKP().jKT()));
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
  
  static final class d
    implements com.tencent.mm.pluginsdk.res.downloader.model.c
  {
    final MMHandler qGL;
    
    d()
    {
      AppMethodBeat.i(320310);
      this.qGL = new MMHandler("WxaPkgDownloadPerformerEventDispatchThread");
      AppMethodBeat.o(320310);
    }
    
    private static void a(bd.c paramc, com.tencent.mm.pluginsdk.res.downloader.model.l paraml)
    {
      AppMethodBeat.i(90617);
      y.deleteFile(paraml.filePath);
      if ((paramc.cgQ() instanceof m))
      {
        l.qEi.a((m)paramc.cgQ(), paraml);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.cgQ() instanceof ba))
      {
        v.a((ba)paramc.cgQ(), paraml, paramc.qGK);
        AppMethodBeat.o(90617);
        return;
      }
      if ((paramc.cgQ() instanceof bz))
      {
        ca.a((bz)paramc.cgQ(), paraml, paramc.qGK);
        AppMethodBeat.o(90617);
        return;
      }
      String str = paramc.cgQ().appId;
      if ((paraml.XWJ instanceof com.tencent.mm.pluginsdk.res.downloader.a.a)) {
        paramc = b.a.a.qIB;
      }
      for (;;)
      {
        bq.a(paraml.XUX, str, paramc);
        AppMethodBeat.o(90617);
        return;
        switch (paraml.httpStatusCode)
        {
        default: 
          paramc = b.a.a.qIx;
          break;
        case 403: 
        case 404: 
          paramc = b.a.a.qIA;
        }
      }
    }
    
    public static void b(com.tencent.mm.pluginsdk.res.downloader.model.e parame, com.tencent.mm.pluginsdk.res.downloader.model.l paraml)
    {
      AppMethodBeat.i(90613);
      a((bd.c)parame, paraml);
      AppMethodBeat.o(90613);
    }
    
    public static void c(com.tencent.mm.pluginsdk.res.downloader.model.e parame, com.tencent.mm.pluginsdk.res.downloader.model.l paraml)
    {
      AppMethodBeat.i(90614);
      Object localObject1 = ((bd.c)parame).cgQ();
      if ((localObject1 instanceof ba))
      {
        paraml = (ba)localObject1;
        localObject1 = ((bd.c)parame).qGK;
        parame = ((com.tencent.mm.plugin.appbrand.api.e)h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo();
        if (parame == null)
        {
          bq.a(paraml.XUX, paraml.appId, b.a.a.qIC, null);
          AppMethodBeat.o(90614);
          return;
        }
        Object localObject2 = paraml.appId;
        j = paraml.qGg;
        i = paraml.qGh;
        str = paraml.cgF();
        Object localObject3 = parame.b((String)localObject2, j, 0, new String[] { "pkgPath" });
        if (localObject3 == null)
        {
          Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, get NULL oldInfo with appId[%s] version[%d]", new Object[] { localObject2, Integer.valueOf(j) });
          bq.a(paraml.XUX, paraml.appId, b.a.a.qIC, null);
          AppMethodBeat.o(90614);
          return;
        }
        ((ag.a)localObject1).cfS();
        long l1 = SystemClock.elapsedRealtime();
        j = v.F(((bh)localObject3).field_pkgPath, str, paraml.getFilePath());
        long l2 = SystemClock.elapsedRealtime();
        Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", new Object[] { paraml.appId, ((bh)localObject3).field_pkgPath, str, paraml.getFilePath(), Long.valueOf(l2 - l1), Integer.valueOf(j) });
        ((ag.a)localObject1).zo(j);
        boolean bool2 = paraml.qGi instanceof b.b;
        if (j == 0)
        {
          Collection localCollection = bq.VA(paraml.XUX);
          localObject2 = new com.tencent.mm.plugin.appbrand.af.k();
          localObject3 = new com.tencent.mm.plugin.appbrand.af.k();
          com.tencent.mm.plugin.appbrand.af.k localk = new com.tencent.mm.plugin.appbrand.af.k();
          v.1 local1 = new v.1((com.tencent.mm.plugin.appbrand.af.k)localObject2, (com.tencent.mm.plugin.appbrand.af.k)localObject3, localk);
          bq.a(paraml.XUX, local1);
          bq.a(paraml.XUX, paraml.appId, str, i, 0, (ag.a)localObject1);
          if (b.a.a.qIw == ((com.tencent.mm.plugin.appbrand.af.k)localObject3).value) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, urlKey[%s] verifyOk[%s] canFallback[%b]", new Object[] { paraml.XUX, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            if ((!bool1) && (bool2)) {
              break label487;
            }
            if (localCollection == null) {
              break;
            }
            parame = localCollection.iterator();
            while (parame.hasNext()) {
              ((bq.a)parame.next()).a((String)((com.tencent.mm.plugin.appbrand.af.k)localObject2).value, (b.a.a)((com.tencent.mm.plugin.appbrand.af.k)localObject3).value, (bq.b)localk.value);
            }
          }
          AppMethodBeat.o(90614);
          return;
          label487:
          bq.a(paraml.XUX, localCollection);
        }
        y.deleteFile(str);
        y.deleteFile(paraml.getFilePath());
        localObject1 = new v.2(bq.VA(paraml.XUX), paraml);
        parame = parame.b(paraml.appId, paraml.qGh, 0, new String[] { "downloadURL" });
        if ((parame == null) || (TextUtils.isEmpty(parame.field_downloadURL)))
        {
          Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, fallback non-incremental get EMPTY url with key[%s]", new Object[] { paraml.XUX });
          ((bq.a)localObject1).a(paraml.appId, b.a.a.qIC, null);
          AppMethodBeat.o(90614);
          return;
        }
        if (!bq.a(paraml.appId, 0, paraml.qGh, parame.field_downloadURL, (bq.a)localObject1)) {
          ((bq.a)localObject1).a(paraml.appId, b.a.a.qIC, null);
        }
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof bz))
      {
        ca.a((bz)localObject1, ((bd.c)parame).qGK);
        AppMethodBeat.o(90614);
        return;
      }
      if ((localObject1 instanceof m))
      {
        l.qEi.a((m)localObject1, paraml);
        AppMethodBeat.o(90614);
        return;
      }
      String str = ((bd.c)parame).cgQ().appId;
      int i = ((bd.c)parame).cgQ().version;
      int j = ((bd.c)parame).cgQ().hJK;
      try
      {
        if ((localObject1 instanceof az)) {}
        for (localObject1 = ((az)localObject1).qGf;; localObject1 = null)
        {
          bq.a(paraml.XUX, str, paraml.filePath, i, j, (String)localObject1, ((bd.c)parame).qGK);
          AppMethodBeat.o(90614);
          return;
        }
        return;
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.WxaPkgDownloadPerformer", parame, "dispatchComplete", new Object[0]);
        bq.cQ(paraml.XUX, str);
        AppMethodBeat.o(90614);
      }
    }
    
    public static void d(com.tencent.mm.pluginsdk.res.downloader.model.e parame, com.tencent.mm.pluginsdk.res.downloader.model.l paraml)
    {
      AppMethodBeat.i(90615);
      a((bd.c)parame, paraml);
      AppMethodBeat.o(90615);
    }
    
    public final void G(String paramString, int paramInt1, int paramInt2) {}
    
    public final void T(String paramString, long paramLong) {}
    
    public final void a(final com.tencent.mm.pluginsdk.res.downloader.model.e parame, final com.tencent.mm.pluginsdk.res.downloader.model.l paraml)
    {
      AppMethodBeat.i(90612);
      this.qGL.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(90610);
          switch (paraml.status)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(90610);
            return;
            bd.d.d(parame, paraml);
            AppMethodBeat.o(90610);
            return;
            bd.d.c(parame, paraml);
            AppMethodBeat.o(90610);
            return;
            bd.d.b(parame, paraml);
          }
        }
      });
      AppMethodBeat.o(90612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bd
 * JD-Core Version:    0.7.0.1
 */