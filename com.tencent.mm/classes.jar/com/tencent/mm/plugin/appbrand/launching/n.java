package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a.a;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bm.a;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appcache.bq.a;
import com.tencent.mm.plugin.appbrand.appcache.bs;
import com.tencent.mm.plugin.appbrand.appcache.bw;
import com.tencent.mm.plugin.appbrand.appcache.ca;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "", "onError", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "cgiExecutor", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "(Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;)V", "invalidCodeReportId", "", "queryKey", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "getStorage", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "storage$delegate", "Lkotlin/Lazy;", "start", "waitForDownload", "toERROR", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "Downloader", "Factory", "ResponseAssembler", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements y
{
  private static final b sYZ;
  @Deprecated
  private static final WxaPkgLoadProgress sZi;
  private final aeo sYL;
  private final kotlin.g.a.b<WxaPkgLoadProgress, ah> sYN;
  final y.d sZa;
  private final z sZb;
  private final y.c sZc;
  final kotlin.g.a.b<y.e, ah> sZd;
  final kotlin.g.a.m<y.a, String, ah> sZe;
  final af sZf;
  private final j sZg;
  int sZh;
  
  static
  {
    AppMethodBeat.i(180517);
    sYZ = new b((byte)0);
    sZi = new WxaPkgLoadProgress(0, 0L, 0L);
    AppMethodBeat.o(180517);
  }
  
  public n(y.d paramd, kotlin.g.a.b<? super y.e, ah> paramb, kotlin.g.a.m<? super y.a, ? super String, ah> paramm, kotlin.g.a.b<? super WxaPkgLoadProgress, ah> paramb1, z paramz, aeo paramaeo, y.c paramc)
  {
    AppMethodBeat.i(320841);
    this.sZa = paramd;
    this.sYN = paramb1;
    this.sZb = paramz;
    this.sYL = paramaeo;
    this.sZc = paramc;
    this.sZd = ((kotlin.g.a.b)new e(paramb, this));
    this.sZe = ((kotlin.g.a.m)new d(paramm, this));
    this.sZf = this.sZa.cAe();
    this.sZg = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.sZh = -1;
    AppMethodBeat.o(320841);
  }
  
  final com.tencent.mm.plugin.appbrand.appcache.u<? extends com.tencent.mm.plugin.appbrand.appcache.g> czW()
  {
    AppMethodBeat.i(320881);
    com.tencent.mm.plugin.appbrand.appcache.u localu = (com.tencent.mm.plugin.appbrand.appcache.u)this.sZg.getValue();
    AppMethodBeat.o(320881);
    return localu;
  }
  
  final void czX()
  {
    AppMethodBeat.i(180513);
    Object localObject = this.sZc;
    if (localObject != null) {
      ((y.c)localObject).b(this.sZa);
    }
    final z.a locala = new z.a();
    locala.setAppId(this.sZa.appId);
    int i = this.sZa.hDq;
    localObject = com.tencent.mm.cq.a.agWN;
    s.s(localObject, "WEAPP_CODE_PKG_INTEGRATED_PACKAGE_TYPES");
    if (kotlin.a.k.contains((int[])localObject, i)) {
      localObject = null;
    }
    for (;;)
    {
      locala.esT = ((String)localObject);
      locala.hDq = this.sZa.hDq;
      locala.euz = this.sZa.euz;
      label174:
      long l2;
      if (k.a.zn(this.sZa.euz))
      {
        localObject = com.tencent.mm.cq.a.agWM;
        s.s(localObject, "PLUGINCODE_PACKAGE_TYPES");
        if (!kotlin.a.k.contains((int[])localObject, this.sZa.hDq)) {
          break label699;
        }
        if (!locala.tak) {
          break label444;
        }
        localObject = m.cQ(this.sZf.toString(), 0);
        if (localObject != null) {
          l2 = 1000L * ((l)com.tencent.mm.plugin.appbrand.app.n.ag(l.class)).VO(this.sZa.appId);
        }
      }
      try
      {
        l1 = new com.tencent.mm.vfs.u(((WxaPkgWrappingInfo)localObject).pkgPath()).lastModified();
        if ((l2 > 0L) && (l2 > l1))
        {
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "waitForDownload(), request:" + this.sZa + ", fill localPkgVersion, find version(" + ((WxaPkgWrappingInfo)localObject).pkgVersion + ") but lastModified(" + l1 + ") is marked as invalid until " + l2);
          locala.tai = 0;
          locala.tah = 0;
          if (!this.sZa.sZV) {
            break label751;
          }
          i = 0;
          locala.tah = i;
          localObject = this.sZa.sZU;
          if (!(localObject instanceof y.g.c)) {
            break label756;
          }
          locala.appVersion = ((y.g.c)localObject).version;
          this.sZb.a(locala, (kotlin.g.a.b)new g(this, locala), (q)new h(this), 0, this.sYL);
          AppMethodBeat.o(180513);
          return;
          localObject = com.tencent.mm.cq.a.agWM;
          s.s(localObject, "PLUGINCODE_PACKAGE_TYPES");
          if (kotlin.a.k.contains((int[])localObject, i))
          {
            localObject = null;
            continue;
          }
          localObject = this.sZa.esT;
          continue;
          label444:
          if (!(this.sZa.sZU instanceof y.g.c)) {
            break label819;
          }
          j = ((y.g.c)this.sZa.sZU).version;
          String str = this.sZf.toString();
          int[] arrayOfInt = com.tencent.mm.plugin.appbrand.app.n.cfm().Vz(str);
          if ((arrayOfInt == null) || (arrayOfInt.length <= 0))
          {
            localObject = null;
            break label174;
          }
          i = Math.abs(j - arrayOfInt[0]);
          int k = Math.abs(j - arrayOfInt[(arrayOfInt.length - 1)]);
          if (i > k) {}
          for (;;)
          {
            Log.d("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg appId:%s,versionArray:%s", new Object[] { str, Arrays.toString(arrayOfInt) });
            localObject = null;
            int n = arrayOfInt.length;
            k = 0;
            while (k < n)
            {
              int i1 = arrayOfInt[k];
              int m = Math.abs(j - i1);
              Pair localPair = WxaPkgIntegrityChecker.H(str, 0, i1);
              if ((localPair.first != WxaPkgIntegrityChecker.a.qGY) || (localPair.second == null) || (m > i)) {
                break label816;
              }
              localObject = (WxaPkgWrappingInfo)localPair.second;
              i = m;
              k += 1;
            }
            i = k;
          }
          if (localObject != null) {
            Log.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg leastStep:%d,desireVersion:%d,localVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((WxaPkgWrappingInfo)localObject).pkgVersion) });
          }
          break label174;
          label699:
          localObject = m.cQ(this.sZf.toString(), 1);
        }
      }
      catch (Exception localException)
      {
        label816:
        label819:
        for (;;)
        {
          int j;
          long l1 = 9223372036854775807L;
          continue;
          locala.tai = ((WxaPkgWrappingInfo)localObject).pkgVersion;
          locala.tah = WxaPkg.Vo(((WxaPkgWrappingInfo)localObject).pkgPath());
          continue;
          label751:
          i = 1;
          continue;
          label756:
          if ((localObject instanceof y.g.b))
          {
            locala.appVersion = ((y.g.b)localObject).version;
            locala.tak = true;
          }
          else if ((localObject instanceof y.g.a))
          {
            locala.appVersion = 0;
            locala.qGf = ((y.g.a)localObject).desc;
            continue;
            continue;
            j = 0;
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader;", "", "(Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher;)V", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "start", "request", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "urls", "", "pkgChecksumMd5", "(Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;[Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;Ljava/lang/String;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
  {
    public a()
    {
      AppMethodBeat.i(321070);
      AppMethodBeat.o(321070);
    }
    
    private static final Object a(final ciq[] paramArrayOfciq, n paramn, z.a parama, int paramInt, a parama1, String paramString, ah paramah)
    {
      AppMethodBeat.i(321090);
      s.u(paramArrayOfciq, "$urls");
      s.u(paramn, "this$0");
      s.u(parama, "$request");
      s.u(parama1, "this$1");
      paramah = paramArrayOfciq[0];
      s.checkNotNull(paramah);
      paramah = (CharSequence)paramah.url;
      int i;
      if ((paramah == null) || (paramah.length() == 0)) {
        i = 1;
      }
      while (i != 0)
      {
        paramArrayOfciq = paramArrayOfciq[0];
        s.checkNotNull(paramArrayOfciq);
        paramInt = paramArrayOfciq.hGE;
        switch (paramInt)
        {
        default: 
          n.a(paramn).invoke(y.a.sZO, "invalid url");
          paramArrayOfciq = ah.aiuX;
          AppMethodBeat.o(321090);
          return paramArrayOfciq;
          i = 0;
          break;
        case -2000011: 
        case -2000004: 
          n.a(paramn).invoke(y.a.sZP, String.valueOf(paramInt));
          paramArrayOfciq = ah.aiuX;
          AppMethodBeat.o(321090);
          return paramArrayOfciq;
        }
      }
      Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("Downloader.fallbackLegacy with ", parama));
      parama1 = new c(parama1, paramArrayOfciq);
      if (k.a.vK(parama.euz))
      {
        paramn = n.e(paramn).toString();
        paramInt = parama.euz;
        parama = parama.qGf;
        paramArrayOfciq = paramArrayOfciq[0];
        s.checkNotNull(paramArrayOfciq);
      }
      for (boolean bool = bq.a(paramn, paramInt, parama, paramArrayOfciq.url, (bq.a)parama1, new n.a..ExternalSyntheticLambda0(paramString));; bool = bq.b(paramString, i, paramInt, paramArrayOfciq.url, n.g(paramn), (bq.a)parama1))
      {
        AppMethodBeat.o(321090);
        return Boolean.valueOf(bool);
        paramString = n.e(paramn).toString();
        i = parama.euz;
        paramArrayOfciq = paramArrayOfciq[0];
        s.checkNotNull(paramArrayOfciq);
      }
    }
    
    private static final ah a(final ciq[] paramArrayOfciq, z.a parama, n paramn, int paramInt, a parama1, final b.a.a[] paramArrayOfa, final Void paramVoid)
    {
      AppMethodBeat.i(321076);
      s.u(paramArrayOfciq, "$urls");
      s.u(parama, "$request");
      s.u(paramn, "this$0");
      s.u(parama1, "this$1");
      s.u(paramArrayOfa, "$INTERRUPT_ERROR_CODES");
      if (paramArrayOfciq[2] != null)
      {
        paramVoid = paramArrayOfciq[2];
        s.checkNotNull(paramVoid);
        paramVoid = (CharSequence)paramVoid.url;
        if ((paramVoid != null) && (paramVoid.length() != 0)) {
          break label170;
        }
      }
      label170:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramVoid = com.tencent.mm.vending.g.g.jJV();
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("Downloader.tryPatch with ", parama));
          String str = n.e(paramn).toString();
          i = parama.tai;
          parama = paramArrayOfciq[2];
          s.checkNotNull(parama);
          v.a(str, i, paramInt, parama.url, n.g(paramn), (bq.a)new a(parama1, paramArrayOfa, paramArrayOfciq, paramVoid));
        }
        paramArrayOfciq = ah.aiuX;
        AppMethodBeat.o(321076);
        return paramArrayOfciq;
      }
    }
    
    private static final ah a(final ciq[] paramArrayOfciq, z.a parama, n paramn, int paramInt, a parama1, final b.a.a[] paramArrayOfa, final ah paramah)
    {
      AppMethodBeat.i(321082);
      s.u(paramArrayOfciq, "$urls");
      s.u(parama, "$request");
      s.u(paramn, "this$0");
      s.u(parama1, "this$1");
      s.u(paramArrayOfa, "$INTERRUPT_ERROR_CODES");
      if (paramArrayOfciq[1] != null)
      {
        paramah = paramArrayOfciq[1];
        s.checkNotNull(paramah);
        paramah = (CharSequence)paramah.url;
        if ((paramah != null) && (paramah.length() != 0)) {
          break label165;
        }
      }
      label165:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramah = com.tencent.mm.vending.g.g.jJV();
          Log.i("MicroMsg.AppBrand.CommonPkgFetcher", s.X("Downloader.tryZstd with ", parama));
          ciq localciq = paramArrayOfciq[1];
          s.checkNotNull(localciq);
          ca.a(localciq.url, n.e(paramn).toString(), paramInt, parama.euz, n.g(paramn), (bq.a)new b(parama1, paramArrayOfa, paramArrayOfciq, paramah));
        }
        paramArrayOfciq = ah.aiuX;
        AppMethodBeat.o(321082);
        return paramArrayOfciq;
      }
    }
    
    private static final void a(z.a parama, ciq[] paramArrayOfciq, a parama1, n paramn, String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(321101);
      s.u(parama, "$request");
      s.u(paramArrayOfciq, "$urls");
      s.u(parama1, "this$0");
      s.u(paramn, "this$1");
      Object localObject1;
      if ((k.a.zn(parama.euz)) && (parama.tak))
      {
        int k = paramArrayOfciq.length;
        i = 0;
        int j;
        if (i < k)
        {
          localObject1 = paramArrayOfciq[i];
          if (localObject1 == null)
          {
            j = 0;
            label78:
            if (j <= 0) {
              break label150;
            }
            j = 1;
            label86:
            if (j == 0) {
              break label156;
            }
            label91:
            if (localObject1 != null) {
              break label171;
            }
          }
        }
        label150:
        label156:
        label171:
        for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((ciq)localObject1).YWM))
        {
          if (localObject1 != null) {
            break label184;
          }
          Log.e("MicroMsg.AppBrand.CommonPkgFetcher", s.X("Downloader.start, get invalid app_version using needLatestVersion, request=", parama));
          n.a(paramn).invoke(y.a.sZH, "invalid cgi response");
          AppMethodBeat.o(321101);
          return;
          j = ((ciq)localObject1).YWM;
          break label78;
          j = 0;
          break label86;
          i += 1;
          break;
          localObject1 = null;
          break label91;
        }
      }
      label184:
      for (int i = ((Integer)localObject1).intValue();; i = parama.appVersion)
      {
        localObject1 = new b.a.a[3];
        localObject1[0] = b.a.a.qIw;
        localObject1[1] = b.a.a.qIC;
        localObject1[2] = b.a.a.qIB;
        com.tencent.mm.vending.g.g.jJU().c(new n.a..ExternalSyntheticLambda2(paramArrayOfciq, parama, paramn, i, parama1, (b.a.a[])localObject1)).c(new n.a..ExternalSyntheticLambda3(paramArrayOfciq, parama, paramn, i, parama1, (b.a.a[])localObject1)).c(new n.a..ExternalSyntheticLambda1(paramArrayOfciq, paramn, parama, i, parama1, paramString)).a(n.a..ExternalSyntheticLambda4.INSTANCE);
        AppMethodBeat.o(321101);
        return;
      }
    }
    
    private static final String acZ(String paramString)
    {
      return paramString;
    }
    
    private static final void eg(Object paramObject) {}
    
    public final void a(z.a parama, ciq[] paramArrayOfciq, String paramString)
    {
      AppMethodBeat.i(321145);
      s.u(parama, "request");
      s.u(paramArrayOfciq, "urls");
      n.f(this.sZj).invoke(n.czZ());
      d.LOGIC.arrange(new n.a..ExternalSyntheticLambda5(parama, paramArrayOfciq, this, this.sZj, paramString));
      AppMethodBeat.o(321145);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader$start$1$1$1", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$IWxaPkgUpdateCallback;", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements bq.a
    {
      a(n.a parama, b.a.a[] paramArrayOfa, ciq[] paramArrayOfciq, com.tencent.mm.vending.g.b paramb) {}
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader$start$1$2$1", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$IWxaPkgUpdateCallback;", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements bq.a
    {
      b(n.a parama, b.a.a[] paramArrayOfa, ciq[] paramArrayOfciq, com.tencent.mm.vending.g.b paramb) {}
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Downloader$start$1$3$callback$1", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$IWxaPkgUpdateCallback;", "onPkgUpdateProgress", "", "progressInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onPkgUpdateResult", "appId", "", "errCode", "Lcom/tencent/mm/plugin/appbrand/appcache/base/IWxaPkgDownloader$IWxaPkgUpdateCallback$RetCode;", "response", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgUpdater$Response;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements bq.a
    {
      c(n.a parama, ciq[] paramArrayOfciq) {}
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$Factory;", "", "()V", "DOWNLOAD_START", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "TAG", "", "FOR", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "QUERY_FACTORY", "storage", "key", "Lcom/tencent/mm/plugin/appbrand/appcache/PkgQueryKey;", "versionType", "", "version", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$VERSION;", "RECORD_FACTORY", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    static com.tencent.mm.plugin.appbrand.appcache.g a(com.tencent.mm.plugin.appbrand.appcache.u<? extends com.tencent.mm.plugin.appbrand.appcache.g> paramu, af paramaf, int paramInt, y.g paramg)
    {
      AppMethodBeat.i(321073);
      if (((paramg instanceof y.g.c)) && (k.a.zn(paramInt)))
      {
        paramu = (com.tencent.mm.plugin.appbrand.appcache.g)paramu.a(paramaf.toString(), ((y.g.c)paramg).version, paramInt, new String[0]);
        AppMethodBeat.o(321073);
        return paramu;
      }
      if ((paramg instanceof y.g.a))
      {
        paramu = (com.tencent.mm.plugin.appbrand.appcache.g)paramu.a(paramaf.toString(), paramInt, ((y.g.a)paramg).desc, new String[0]);
        AppMethodBeat.o(321073);
        return paramu;
      }
      paramu = (com.tencent.mm.plugin.appbrand.appcache.g)paramu.a(paramaf.toString(), paramInt, new String[0]);
      AppMethodBeat.o(321073);
      return paramu;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/CommonPkgFetcher$ResponseAssembler;", "", "()V", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "request", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "wxaPkgFilePath", "", "wxaPkgFileMd5", "appVersion", "", "source", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$SOURCE;", "makeResponseByReusableLocalPkg", "storage", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
  {
    public static final c sZn;
    
    static
    {
      AppMethodBeat.i(321086);
      sZn = new c();
      AppMethodBeat.o(321086);
    }
    
    public static y.e a(com.tencent.mm.plugin.appbrand.appcache.u<?> paramu, y.d paramd, com.tencent.mm.plugin.appbrand.appcache.g paramg)
    {
      AppMethodBeat.i(321071);
      s.u(paramu, "storage");
      s.u(paramd, "request");
      s.u(paramg, "record");
      if (!(paramu instanceof bm))
      {
        AppMethodBeat.o(321071);
        return null;
      }
      af localaf = paramd.cAe();
      if (((paramd.sZU instanceof y.g.c)) && (k.a.zn(paramd.euz)))
      {
        Object localObject1 = (CharSequence)paramg.field_versionMd5;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label151;
          }
          localObject1 = (CharSequence)paramg.field_NewMd5;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label146;
          }
        }
        label146:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label151;
          }
          Log.e("MicroMsg.AppBrand.CommonPkgFetcher", s.X("makeResponseByReusableLocalPkg record.md5 is EMPTY, request=", paramd));
          AppMethodBeat.o(321071);
          return null;
          i = 0;
          break;
        }
        label151:
        i = paramd.euz;
        int j = ((y.g.c)paramd.sZU).version;
        Object localObject2 = paramg.field_versionMd5;
        Object localObject3 = paramg.field_NewMd5;
        localObject1 = com.tencent.mm.plugin.appbrand.app.n.cfm().a(localaf, i, bm.a.qHD);
        if (localObject1 != null)
        {
          Iterator localIterator = ((List)localObject1).iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject1 = (bh)localIterator.next();
              if (((bh)localObject1).field_version != j)
              {
                String str1 = WxaPkgIntegrityChecker.Vu(((bh)localObject1).field_pkgPath);
                i = 0;
                label252:
                if (i < 2)
                {
                  String str2 = new String[] { localObject2, localObject3 }[i];
                  if ((TextUtils.isEmpty(str2)) || (!str2.equals(str1))) {
                    break;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label365;
          }
          paramg = ((bh)localObject1).field_pkgPath;
          s.s(paramg, "reusable.field_pkgPath");
          paramu = a(paramd, a(localaf, paramd, paramu, paramg), null, ((y.g.c)paramd.sZU).version, (y.f)new y.f.a(1));
          AppMethodBeat.o(321071);
          return paramu;
          i += 1;
          break label252;
          break;
          localObject1 = null;
        }
        label365:
        localObject1 = Long.valueOf(((y.g.c)paramd.sZU).rcA);
        label399:
        long l;
        if (((Number)localObject1).longValue() >= 0L)
        {
          i = 1;
          if (i == 0) {
            break label666;
          }
          if (localObject1 == null) {
            break label682;
          }
          l = ((Number)localObject1).longValue();
          localObject1 = ((Iterable)((bw)com.tencent.mm.plugin.appbrand.app.n.ag(bw.class)).c(l, paramg.field_versionMd5, paramg.field_NewMd5)).iterator();
        }
        label666:
        label677:
        label680:
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label682;
          }
          localObject2 = (bh)((Iterator)localObject1).next();
          if (com.tencent.mm.vfs.y.ZC(((bh)localObject2).field_pkgPath))
          {
            paramg = WxaPkgWrappingInfo.n(new com.tencent.mm.vfs.u(((bh)localObject2).field_pkgPath));
            label494:
            localObject3 = (CharSequence)paramg;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label677;
            }
          }
          for (i = 1;; i = 0)
          {
            if ((i != 0) || ((!s.p(paramg, ((bh)localObject2).field_versionMd5)) && (!s.p(paramg, ((bh)localObject2).field_NewMd5)))) {
              break label680;
            }
            Log.i("MicroMsg.AppBrand.CommonPkgFetcher", "makeResponseByReusableLocalPkg matched pkg for templateId:" + l + ", appId:" + paramd.appId + ", appVersion:" + paramd.sZU + ", fileMd5:" + paramg);
            localObject1 = ((bh)localObject2).field_pkgPath;
            s.s(localObject1, "templateRecord.field_pkgPath");
            paramu = a(paramd, a(localaf, paramd, paramu, (String)localObject1), paramg, ((y.g.c)paramd.sZU).version, (y.f)new y.f.a(2));
            AppMethodBeat.o(321071);
            return paramu;
            i = 0;
            break;
            localObject1 = null;
            break label399;
            paramg = null;
            break label494;
          }
        }
      }
      label682:
      AppMethodBeat.o(321071);
      return null;
    }
    
    public static y.e a(y.d paramd, String paramString1, String paramString2, int paramInt, y.f paramf)
    {
      int i = 0;
      AppMethodBeat.i(321079);
      s.u(paramd, "request");
      s.u(paramString1, "wxaPkgFilePath");
      s.u(paramf, "source");
      Object localObject = com.tencent.mm.cq.a.agWM;
      s.s(localObject, "PLUGINCODE_PACKAGE_TYPES");
      if (kotlin.a.k.contains((int[])localObject, paramd.hDq))
      {
        localObject = new WxaPluginPkgInfo();
        ((WxaPluginPkgInfo)localObject).pkgPath = paramString1;
        ((WxaPluginPkgInfo)localObject).provider = paramd.appId;
        ((WxaPluginPkgInfo)localObject).version = paramInt;
        paramd = (CharSequence)paramString2;
        if (paramd != null)
        {
          paramInt = i;
          if (paramd.length() != 0) {}
        }
        else
        {
          paramInt = 1;
        }
        if (paramInt != 0) {
          paramString2 = WxaPkgIntegrityChecker.Vu(paramString1);
        }
        ((WxaPluginPkgInfo)localObject).md5 = paramString2;
        paramd = (bs)com.tencent.mm.plugin.appbrand.app.n.ag(bs.class);
        paramString1 = ((WxaPluginPkgInfo)localObject).provider;
        s.s(paramString1, "provider");
        ((WxaPluginPkgInfo)localObject).stringVersion = paramd.bJ(paramString1, ((WxaPluginPkgInfo)localObject).version);
        paramd = (IPkgInfo)localObject;
        paramd = new y.e(paramd, paramf);
        AppMethodBeat.o(321079);
        return paramd;
      }
      localObject = new ModulePkgInfo();
      ((ModulePkgInfo)localObject).pkgPath = paramString1;
      ((ModulePkgInfo)localObject).name = paramd.esT;
      paramd = (CharSequence)paramString2;
      if ((paramd == null) || (paramd.length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paramString2 = WxaPkgIntegrityChecker.Vu(paramString1);
        }
        ((ModulePkgInfo)localObject).md5 = paramString2;
        ((ModulePkgInfo)localObject).pkgVersion = paramInt;
        paramd = (IPkgInfo)localObject;
        break;
      }
    }
    
    private static final String a(af paramaf, y.d paramd, com.tencent.mm.plugin.appbrand.appcache.u<?> paramu, String paramString)
    {
      AppMethodBeat.i(321083);
      String str = be.bC(paramaf.toString(), ((y.g.c)paramd.sZU).version);
      com.tencent.mm.vfs.y.O(paramString, str, false);
      ((bm)paramu).f(paramaf.toString(), paramd.euz, ((y.g.c)paramd.sZU).version, str);
      s.s(str, "targetPkgPath");
      AppMethodBeat.o(321083);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "str", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.m<y.a, String, ah>
  {
    d(kotlin.g.a.m<? super y.a, ? super String, ah> paramm, n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<y.e, ah>
  {
    e(kotlin.g.a.b<? super y.e, ah> paramb, n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/BaseWxaPkgManifestRecord;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.u<? extends com.tencent.mm.plugin.appbrand.appcache.g>>
  {
    f(n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ciq[], ah>
  {
    g(n paramn, z.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements q<Integer, Integer, String, ah>
  {
    h(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.n
 * JD-Core Version:    0.7.0.1
 */