package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.launching.be;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.plugin.appbrand.launching.y.a;
import com.tencent.mm.plugin.appbrand.launching.y.b;
import com.tencent.mm.plugin.appbrand.launching.y.d;
import com.tencent.mm.plugin.appbrand.launching.y.e;
import com.tencent.mm.plugin.appbrand.launching.y.g;
import com.tencent.mm.plugin.appbrand.launching.y.g.b;
import com.tencent.mm.plugin.appbrand.service.w.a;
import com.tencent.mm.plugin.appbrand.service.w.b;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.gjx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService;", "()V", "registerPkgSpecs", "", "appUsername", "", "appId", "visitScene", "", "startDownloadPkg", "versionType", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "onError", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.appbrand.service.w
{
  public static final a qJQ;
  
  static
  {
    AppMethodBeat.i(320562);
    qJQ = new a((byte)0);
    AppMethodBeat.o(320562);
  }
  
  private static final int a(w.a parama, com.tencent.mm.vending.g.b paramb, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, c paramc, p paramp)
  {
    AppMethodBeat.i(320537);
    paramc = c.c.b(paramc.otC);
    int i;
    if ((paramc instanceof aal))
    {
      paramc = (aal)paramc;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        if (paramc == null) {
          break label200;
        }
        paramp = paramc.ZiP;
        if ((paramp == null) || (paramp.ytv != 0)) {
          break label200;
        }
        i = 1;
        label68:
        if (i != 0) {
          break label255;
        }
      }
      paramp = new StringBuilder("startDownloadPkg, waitFor demo info failed, errType:").append(paramInt2).append(", errCode:").append(paramInt3).append(", errMsg:").append(paramString2).append(", wxaapp_baseresponse:{ErrCode:");
      if (paramc != null) {
        break label206;
      }
      paramString1 = null;
      label121:
      paramp = paramp.append(paramString1).append(", ErrMsg:");
      if (paramc != null) {
        break label232;
      }
      paramString1 = null;
    }
    for (;;)
    {
      Log.e("MicroMsg.WxaPkgDownloaderExportServiceImpl", paramString1 + '}');
      if (parama != null) {
        parama.onError(paramInt3, paramString2);
      }
      paramb.gM(new Exception());
      AppMethodBeat.o(320537);
      return 0;
      paramc = null;
      break;
      label200:
      i = 0;
      break label68;
      label206:
      paramString1 = paramc.ZiP;
      if (paramString1 == null)
      {
        paramString1 = null;
        break label121;
      }
      paramString1 = Integer.valueOf(paramString1.ytv);
      break label121;
      label232:
      paramString1 = paramc.ZiP;
      if (paramString1 == null) {
        paramString1 = null;
      } else {
        paramString1 = paramString1.ytw;
      }
    }
    label255:
    if (paramc.ZiQ)
    {
      parama = (CharSequence)paramc.ZiS;
      if ((parama != null) && (parama.length() != 0)) {
        break label440;
      }
      paramInt2 = 1;
      if (paramInt2 == 0)
      {
        parama = ((d)n.ag(d.class)).bx(paramString1, paramInt1);
        if (!s.p(paramc.ZiS, parama))
        {
          parama = (CharSequence)paramc.ZiR;
          if ((parama != null) && (parama.length() != 0)) {
            break label446;
          }
        }
      }
    }
    label288:
    label440:
    label446:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt2 == 0) {
        n.cfm().a(paramString1, paramInt1, paramc.ZiR, paramc.ZiS, 0L, 0L);
      }
      ((t)n.ag(t.class)).d(paramString1, paramInt1, paramc.ZiW, true);
      parama = (d)n.ag(d.class);
      paramString2 = paramc.ZiS;
      s.s(paramString2, "resp.new_demo_md5");
      parama.q(paramString1, paramInt1, paramString2);
      paramb.K(new Object[] { Boolean.TRUE });
      break;
      paramInt2 = 0;
      break label288;
    }
  }
  
  private static final Boolean a(int paramInt, String paramString, w.a parama, Void paramVoid)
  {
    boolean bool = true;
    AppMethodBeat.i(320544);
    if (paramInt == 2)
    {
      paramVoid = com.tencent.mm.vending.g.g.jJV();
      z.a(be.N(paramString, null, null), new b..ExternalSyntheticLambda0(parama, paramVoid, paramString, paramInt), true);
      bool = false;
    }
    AppMethodBeat.o(320544);
    return Boolean.valueOf(bool);
  }
  
  private static final ah a(String paramString, final int paramInt, final w.b paramb, final w.a parama, final Boolean paramBoolean)
  {
    AppMethodBeat.i(320555);
    paramBoolean = new y.d(paramString, "", 0, paramInt, (y.g)new y.g.b(0, true, 1), false);
    Object localObject = y.sZF;
    paramString = (kotlin.g.a.b)new b(paramString, paramInt, paramBoolean, paramb);
    paramb = (m)new c(paramBoolean, parama);
    parama = new aeo();
    parama.ZmB = 1;
    localObject = ah.aiuX;
    y.b.a(paramBoolean, paramString, paramb, null, null, parama, null, 184);
    paramString = ah.aiuX;
    AppMethodBeat.o(320555);
    return paramString;
  }
  
  private static final void a(ah paramah) {}
  
  public final void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(320599);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString2;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label77;
        }
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label83;
      }
      AppMethodBeat.o(320599);
      return;
      i = 0;
      break;
    }
    label83:
    localObject = com.tencent.mm.plugin.appbrand.config.w.raK;
    com.tencent.mm.plugin.appbrand.config.w.G(paramString1, paramString2, paramInt);
    AppMethodBeat.o(320599);
  }
  
  public final void a(String paramString, int paramInt, w.b paramb, w.a parama)
  {
    AppMethodBeat.i(320595);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (parama != null) {
        parama.onError(-1, "invalid appId");
      }
      AppMethodBeat.o(320595);
      return;
    }
    com.tencent.mm.cp.g.jPX().h(new b..ExternalSyntheticLambda1(paramInt, paramString, parama)).h(new b..ExternalSyntheticLambda2(paramString, paramInt, paramb, parama)).a(b..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(320595);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl$Companion;", "", "()V", "TAG", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceImpl;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b chw()
    {
      AppMethodBeat.i(320572);
      Object localObject = (com.tencent.mm.plugin.appbrand.service.w)h.ax(com.tencent.mm.plugin.appbrand.service.w.class);
      if (localObject == null)
      {
        if (!h.baC().mBZ)
        {
          localObject = new com.tencent.mm.model.b();
          AppMethodBeat.o(320572);
          throw ((Throwable)localObject);
        }
        localObject = new NullPointerException();
        AppMethodBeat.o(320572);
        throw ((Throwable)localObject);
      }
      localObject = (b)localObject;
      AppMethodBeat.o(320572);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<y.e, ah>
  {
    b(String paramString, int paramInt, y.d paramd, w.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<y.a, String, ah>
  {
    c(y.d paramd, w.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.b
 * JD-Core Version:    0.7.0.1
 */