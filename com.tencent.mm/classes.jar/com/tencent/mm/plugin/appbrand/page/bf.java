package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.e;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"})
public class bf
  implements bb
{
  @Deprecated
  public static final a lEZ;
  private final a<?> lEW;
  
  static
  {
    AppMethodBeat.i(147977);
    lEZ = new a((byte)0);
    AppMethodBeat.o(147977);
  }
  
  public bf(a<?> parama)
  {
    AppMethodBeat.i(147976);
    this.lEW = parama;
    AppMethodBeat.o(147976);
  }
  
  public String OF(String paramString)
  {
    AppMethodBeat.i(147975);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(147975);
      return null;
    }
    localObject1 = com.tencent.luggage.sdk.b.a.d.cdd;
    k.g(localObject1, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    if (e.contains((Object[])localObject1, paramString))
    {
      localObject1 = this.lEW.Q(ICommLibReader.class);
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = ((ICommLibReader)localObject1).HL(paramString);
      localObject2 = new StringBuilder("provideScript name[").append(paramString).append("] source.length[");
      if (localObject1 == null) {
        break label552;
      }
      i = ((String)localObject1).length();
      label116:
      ac.i("Luggage.WXA.MPPageScriptProviderDefaultImpl", i + ']');
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label557;
      }
      i = 1;
      label158:
      if (i != 0) {
        break label638;
      }
      localObject2 = new StringBuilder("https://servicewechat.com/");
      if (this.lEW.CO() != null) {
        break label562;
      }
      ((StringBuilder)localObject2).append("preload/");
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append(paramString);
      paramString = (String)localObject1 + "\n//# sourceURL=" + localObject2;
      AppMethodBeat.o(147975);
      return paramString;
      if (k.g(paramString, "app-wxss.js"))
      {
        localObject1 = this.lEW.CO();
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = be.d((AppBrandRuntime)localObject1, "app-wxss.js");
        break;
      }
      if (k.g(paramString, "page-frame.html"))
      {
        localObject1 = this.lEW.CO();
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = ab.PN(be.d((AppBrandRuntime)localObject1, "page-frame.html"));
        break;
      }
      if (k.g(paramString, this.lEW.getURL()))
      {
        localObject1 = this.lEW.CO();
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = be.d((AppBrandRuntime)localObject1, paramString);
        localObject2 = ab.PM((String)localObject1);
        k.g(localObject2, "extractStyle(pageHtml)");
        localObject3 = d.n.d.UTF_8;
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
        k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject2 = Base64.encodeToString((byte[])localObject2, 2);
        localObject3 = ab.PL((String)localObject1);
        k.g(localObject3, "extractPage(pageHtml)");
        localObject4 = d.n.d.UTF_8;
        if (localObject3 == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
        k.g(localObject3, "(this as java.lang.String).getBytes(charset)");
        localObject3 = Base64.encodeToString((byte[])localObject3, 2);
        localObject1 = ab.PN((String)localObject1);
        localObject4 = z.KUT;
        localObject4 = Locale.ENGLISH;
        k.g(localObject4, "Locale.ENGLISH");
        localObject1 = String.format((Locale)localObject4, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(new Object[] { localObject2, localObject3, localObject1 }, 3));
        k.g(localObject1, "java.lang.String.format(locale, format, *args)");
        break;
      }
      localObject1 = be.d((AppBrandRuntime)this.lEW.CO(), paramString);
      break;
      label552:
      i = -1;
      break label116;
      label557:
      i = 0;
      break label158;
      label562:
      Object localObject3 = this.lEW.CO();
      if (localObject3 == null) {
        k.fOy();
      }
      localObject3 = ((StringBuilder)localObject2).append(((c)localObject3).getAppId()).append("/");
      Object localObject4 = this.lEW.CO();
      if (localObject4 == null) {
        k.fOy();
      }
      ((StringBuilder)localObject3).append(((c)localObject4).DB().jEg.pkgVersion()).append("/");
    }
    label638:
    AppMethodBeat.o(147975);
    return null;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bf
 * JD-Core Version:    0.7.0.1
 */