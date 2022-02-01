package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import kotlin.a.e;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"})
public class bi
  implements be
{
  @Deprecated
  public static final a ntr;
  private final a<?> nto;
  
  static
  {
    AppMethodBeat.i(147977);
    ntr = new a((byte)0);
    AppMethodBeat.o(147977);
  }
  
  public bi(a<?> parama)
  {
    AppMethodBeat.i(147976);
    this.nto = parama;
    AppMethodBeat.o(147976);
  }
  
  public String adT(String paramString)
  {
    AppMethodBeat.i(147975);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(147975);
      return null;
    }
    localObject1 = com.tencent.luggage.sdk.b.a.d.czy;
    p.g(localObject1, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    label116:
    Object localObject3;
    if (e.contains((Object[])localObject1, paramString))
    {
      localObject1 = this.nto.S(ICommLibReader.class);
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((ICommLibReader)localObject1).UM(paramString);
      localObject2 = new StringBuilder("provideScript name[").append(paramString).append("] source.length[");
      if (localObject1 == null) {
        break label626;
      }
      i = ((String)localObject1).length();
      Log.i("Luggage.WXA.MPPageScriptProviderDefaultImpl", i + ']');
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label631;
      }
      i = 1;
      label158:
      if (i != 0) {
        break label763;
      }
      localObject2 = (bi)this;
      localObject3 = com.tencent.luggage.sdk.b.a.d.czy;
      p.g(localObject3, "SCRIPTS_LIB_FOR_WEBVIEW");
      if (!e.contains((Object[])localObject3, paramString))
      {
        localObject3 = ((bi)localObject2).nto.NP();
        if (localObject3 == null) {
          break label716;
        }
        localObject3 = ((com.tencent.luggage.sdk.d.d)localObject3).OM();
        if ((localObject3 == null) || (((AppBrandSysConfigLU)localObject3).cyC != true)) {
          break label716;
        }
      }
      localObject3 = new StringBuilder(com.tencent.luggage.sdk.b.a.d.czw);
      if (((bi)localObject2).nto.NP() != null) {
        break label636;
      }
      ((StringBuilder)localObject3).append("preload/");
      label256:
      paramString = paramString;
      p.g(paramString, "builder.append(resourceName).toString()");
      label272:
      p.g(paramString, "run makeSourceURL@{\n    …      }\n                }");
      if (((CharSequence)paramString).length() != 0) {
        break label723;
      }
    }
    label716:
    label723:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label728;
      }
      AppMethodBeat.o(147975);
      return localObject1;
      if (p.j(paramString, "app-wxss.js"))
      {
        localObject1 = this.nto.NP();
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = bg.d((AppBrandRuntime)localObject1, "app-wxss.js");
        break;
      }
      if (p.j(paramString, "page-frame.html"))
      {
        localObject1 = this.nto.NP();
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ad.adQ(bg.d((AppBrandRuntime)localObject1, "page-frame.html"));
        break;
      }
      if (p.j(paramString, this.nto.getURL()))
      {
        localObject1 = this.nto.NP();
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = bg.d((AppBrandRuntime)localObject1, paramString);
        localObject2 = ad.adP((String)localObject1);
        p.g(localObject2, "extractStyle(pageHtml)");
        localObject3 = kotlin.n.d.UTF_8;
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
        p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject2 = Base64.encodeToString((byte[])localObject2, 2);
        localObject3 = ad.adO((String)localObject1);
        p.g(localObject3, "extractPage(pageHtml)");
        localObject4 = kotlin.n.d.UTF_8;
        if (localObject3 == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
        p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
        localObject3 = Base64.encodeToString((byte[])localObject3, 2);
        localObject1 = ad.adQ((String)localObject1);
        localObject4 = ae.SYK;
        localObject4 = Locale.ENGLISH;
        p.g(localObject4, "Locale.ENGLISH");
        localObject1 = String.format((Locale)localObject4, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(new Object[] { localObject2, localObject3, localObject1 }, 3));
        p.g(localObject1, "java.lang.String.format(locale, format, *args)");
        break;
      }
      localObject1 = bg.d((AppBrandRuntime)this.nto.NP(), paramString);
      break;
      label626:
      i = -1;
      break label116;
      label631:
      i = 0;
      break label158;
      label636:
      Object localObject4 = ((bi)localObject2).nto.NP();
      if (localObject4 == null) {
        p.hyc();
      }
      localObject4 = ((StringBuilder)localObject3).append(((com.tencent.luggage.sdk.d.d)localObject4).getAppId()).append("/");
      localObject2 = ((bi)localObject2).nto.NP();
      if (localObject2 == null) {
        p.hyc();
      }
      ((StringBuilder)localObject4).append(((com.tencent.luggage.sdk.d.d)localObject2).OM().leE.pkgVersion()).append("/");
      break label256;
      paramString = "";
      break label272;
    }
    label728:
    paramString = (String)localObject1 + "\n//# sourceURL=" + r.afJ(paramString);
    AppMethodBeat.o(147975);
    return paramString;
    label763:
    AppMethodBeat.o(147975);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bi
 * JD-Core Version:    0.7.0.1
 */