package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import d.a.e;
import d.l;
import d.v;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"})
public class bf
  implements bb
{
  @Deprecated
  public static final a meD;
  private final a<?> meA;
  
  static
  {
    AppMethodBeat.i(147977);
    meD = new a((byte)0);
    AppMethodBeat.o(147977);
  }
  
  public bf(a<?> parama)
  {
    AppMethodBeat.i(147976);
    this.meA = parama;
    AppMethodBeat.o(147976);
  }
  
  public String Si(String paramString)
  {
    AppMethodBeat.i(147975);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(147975);
      return null;
    }
    localObject1 = com.tencent.luggage.sdk.b.a.d.cnu;
    d.g.b.p.g(localObject1, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    label116:
    Object localObject3;
    if (e.contains((Object[])localObject1, paramString))
    {
      localObject1 = this.meA.Q(ICommLibReader.class);
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      localObject1 = ((ICommLibReader)localObject1).Ld(paramString);
      localObject2 = new StringBuilder("provideScript name[").append(paramString).append("] source.length[");
      if (localObject1 == null) {
        break label624;
      }
      i = ((String)localObject1).length();
      com.tencent.mm.sdk.platformtools.ad.i("Luggage.WXA.MPPageScriptProviderDefaultImpl", i + ']');
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label629;
      }
      i = 1;
      label158:
      if (i != 0) {
        break label761;
      }
      localObject2 = (bf)this;
      localObject3 = com.tencent.luggage.sdk.b.a.d.cnu;
      d.g.b.p.g(localObject3, "SCRIPTS_LIB_FOR_WEBVIEW");
      if (!e.contains((Object[])localObject3, paramString))
      {
        localObject3 = ((bf)localObject2).meA.En();
        if (localObject3 == null) {
          break label714;
        }
        localObject3 = ((c)localObject3).Fa();
        if ((localObject3 == null) || (((AppBrandSysConfigLU)localObject3).cmE != true)) {
          break label714;
        }
      }
      localObject3 = new StringBuilder("https://servicewechat.com/");
      if (((bf)localObject2).meA.En() != null) {
        break label634;
      }
      ((StringBuilder)localObject3).append("preload/");
      label255:
      paramString = paramString;
      d.g.b.p.g(paramString, "builder.append(resourceName).toString()");
      label271:
      d.g.b.p.g(paramString, "run makeSourceURL@{\n    …      }\n                }");
      if (((CharSequence)paramString).length() != 0) {
        break label721;
      }
    }
    label714:
    label721:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label726;
      }
      AppMethodBeat.o(147975);
      return localObject1;
      if (d.g.b.p.i(paramString, "app-wxss.js"))
      {
        localObject1 = this.meA.En();
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        localObject1 = com.tencent.mm.plugin.appbrand.appcache.bf.d((AppBrandRuntime)localObject1, "app-wxss.js");
        break;
      }
      if (d.g.b.p.i(paramString, "page-frame.html"))
      {
        localObject1 = this.meA.En();
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        localObject1 = ab.Tr(com.tencent.mm.plugin.appbrand.appcache.bf.d((AppBrandRuntime)localObject1, "page-frame.html"));
        break;
      }
      if (d.g.b.p.i(paramString, this.meA.getURL()))
      {
        localObject1 = this.meA.En();
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        localObject1 = com.tencent.mm.plugin.appbrand.appcache.bf.d((AppBrandRuntime)localObject1, paramString);
        localObject2 = ab.Tq((String)localObject1);
        d.g.b.p.g(localObject2, "extractStyle(pageHtml)");
        localObject3 = d.n.d.UTF_8;
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
        d.g.b.p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject2 = Base64.encodeToString((byte[])localObject2, 2);
        localObject3 = ab.Tp((String)localObject1);
        d.g.b.p.g(localObject3, "extractPage(pageHtml)");
        localObject4 = d.n.d.UTF_8;
        if (localObject3 == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
        d.g.b.p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
        localObject3 = Base64.encodeToString((byte[])localObject3, 2);
        localObject1 = ab.Tr((String)localObject1);
        localObject4 = d.g.b.ad.MLZ;
        localObject4 = Locale.ENGLISH;
        d.g.b.p.g(localObject4, "Locale.ENGLISH");
        localObject1 = String.format((Locale)localObject4, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(new Object[] { localObject2, localObject3, localObject1 }, 3));
        d.g.b.p.g(localObject1, "java.lang.String.format(locale, format, *args)");
        break;
      }
      localObject1 = com.tencent.mm.plugin.appbrand.appcache.bf.d((AppBrandRuntime)this.meA.En(), paramString);
      break;
      label624:
      i = -1;
      break label116;
      label629:
      i = 0;
      break label158;
      label634:
      Object localObject4 = ((bf)localObject2).meA.En();
      if (localObject4 == null) {
        d.g.b.p.gfZ();
      }
      localObject4 = ((StringBuilder)localObject3).append(((c)localObject4).getAppId()).append("/");
      localObject2 = ((bf)localObject2).meA.En();
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      ((StringBuilder)localObject4).append(((c)localObject2).Fa().jYh.pkgVersion()).append("/");
      break label255;
      paramString = "";
      break label271;
    }
    label726:
    paramString = (String)localObject1 + "\n//# sourceURL=" + com.tencent.mm.plugin.appbrand.utils.p.Vc(paramString);
    AppMethodBeat.o(147975);
    return paramString;
    label761:
    AppMethodBeat.o(147975);
    return null;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bf
 * JD-Core Version:    0.7.0.1
 */