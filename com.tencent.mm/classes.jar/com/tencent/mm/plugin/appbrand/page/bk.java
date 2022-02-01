package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.g.b.k;
import d.g.b.z;
import d.l;
import d.v;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"})
public class bk
  implements bg
{
  @Deprecated
  public static final a lfj;
  private final a<?> lfg;
  
  static
  {
    AppMethodBeat.i(147977);
    lfj = new a((byte)0);
    AppMethodBeat.o(147977);
  }
  
  public bk(a<?> parama)
  {
    AppMethodBeat.i(147976);
    this.lfg = parama;
    AppMethodBeat.o(147976);
  }
  
  public String Ky(String paramString)
  {
    AppMethodBeat.i(147975);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(147975);
      return null;
    }
    localObject1 = com.tencent.luggage.sdk.b.a.d.cgg;
    k.g(localObject1, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    if (e.contains((Object[])localObject1, paramString))
    {
      localObject1 = this.lfg.Q(ICommLibReader.class);
      if (localObject1 == null) {
        k.fvU();
      }
      localObject1 = ((ICommLibReader)localObject1).DH(paramString);
      localObject2 = new StringBuilder("provideScript name[").append(paramString).append("] source.length[");
      if (localObject1 == null) {
        break label552;
      }
      i = ((String)localObject1).length();
      label116:
      ad.i("Luggage.WXA.MPPageScriptProviderDefaultImpl", i + ']');
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
      if (this.lfg.Dl() != null) {
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
        localObject1 = this.lfg.Dl();
        if (localObject1 == null) {
          k.fvU();
        }
        localObject1 = be.d((AppBrandRuntime)localObject1, "app-wxss.js");
        break;
      }
      if (k.g(paramString, "page-frame.html"))
      {
        localObject1 = this.lfg.Dl();
        if (localObject1 == null) {
          k.fvU();
        }
        localObject1 = ab.LG(be.d((AppBrandRuntime)localObject1, "page-frame.html"));
        break;
      }
      if (k.g(paramString, this.lfg.getURL()))
      {
        localObject1 = this.lfg.Dl();
        if (localObject1 == null) {
          k.fvU();
        }
        localObject1 = be.d((AppBrandRuntime)localObject1, paramString);
        localObject2 = ab.LF((String)localObject1);
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
        localObject3 = ab.LE((String)localObject1);
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
        localObject1 = ab.LG((String)localObject1);
        localObject4 = z.Jhz;
        localObject4 = Locale.ENGLISH;
        k.g(localObject4, "Locale.ENGLISH");
        localObject1 = String.format((Locale)localObject4, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(new Object[] { localObject2, localObject3, localObject1 }, 3));
        k.g(localObject1, "java.lang.String.format(locale, format, *args)");
        break;
      }
      localObject1 = be.d((AppBrandRuntime)this.lfg.Dl(), paramString);
      break;
      label552:
      i = -1;
      break label116;
      label557:
      i = 0;
      break label158;
      label562:
      Object localObject3 = this.lfg.Dl();
      if (localObject3 == null) {
        k.fvU();
      }
      localObject3 = ((StringBuilder)localObject2).append(((c)localObject3).getAppId()).append("/");
      Object localObject4 = this.lfg.Dl();
      if (localObject4 == null) {
        k.fvU();
      }
      ((StringBuilder)localObject3).append(((c)localObject4).DY().jdS.pkgVersion()).append("/");
    }
    label638:
    AppMethodBeat.o(147975);
    return null;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */