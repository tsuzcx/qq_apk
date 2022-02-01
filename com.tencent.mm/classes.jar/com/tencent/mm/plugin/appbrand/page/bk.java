package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import kotlin.a.e;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"})
public class bk
  implements bg
{
  @Deprecated
  public static final bk.a qvk;
  private final a<?> qvh;
  
  static
  {
    AppMethodBeat.i(147977);
    qvk = new bk.a((byte)0);
    AppMethodBeat.o(147977);
  }
  
  public bk(a<?> parama)
  {
    AppMethodBeat.i(147976);
    this.qvh = parama;
    AppMethodBeat.o(147976);
  }
  
  public String alO(String paramString)
  {
    AppMethodBeat.i(147975);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(147975);
      return null;
    }
    localObject1 = com.tencent.luggage.sdk.b.a.d.cyu;
    p.j(localObject1, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    label116:
    Object localObject3;
    if (e.contains((Object[])localObject1, paramString))
    {
      localObject1 = this.qvh.R(ICommLibReader.class);
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = ((ICommLibReader)localObject1).acw(paramString);
      localObject2 = new StringBuilder("provideScript name[").append(paramString).append("] source.length[");
      if (localObject1 == null) {
        break label625;
      }
      i = ((String)localObject1).length();
      Log.i("Luggage.WXA.MPPageScriptProviderDefaultImpl", i + ']');
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label630;
      }
      i = 1;
      label158:
      if (i != 0) {
        break label762;
      }
      localObject2 = (bk)this;
      localObject3 = com.tencent.luggage.sdk.b.a.d.cyu;
      p.j(localObject3, "SCRIPTS_LIB_FOR_WEBVIEW");
      if (!e.contains((Object[])localObject3, paramString))
      {
        localObject3 = ((bk)localObject2).qvh.QM();
        if (localObject3 == null) {
          break label715;
        }
        localObject3 = ((com.tencent.luggage.sdk.e.d)localObject3).Sj();
        if ((localObject3 == null) || (((AppBrandSysConfigLU)localObject3).cxh != true)) {
          break label715;
        }
      }
      localObject3 = new StringBuilder(com.tencent.luggage.sdk.b.a.d.cys);
      if (((bk)localObject2).qvh.QM() != null) {
        break label635;
      }
      ((StringBuilder)localObject3).append("preload/");
      label256:
      paramString = paramString;
      p.j(paramString, "builder.append(resourceName).toString()");
      label272:
      p.j(paramString, "run makeSourceURL@{\n    …      }\n                }");
      if (((CharSequence)paramString).length() != 0) {
        break label722;
      }
    }
    label715:
    label722:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label727;
      }
      AppMethodBeat.o(147975);
      return localObject1;
      if (p.h(paramString, "app-wxss.js"))
      {
        localObject1 = this.qvh.QM();
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = bl.d((AppBrandRuntime)localObject1, "app-wxss.js");
        break;
      }
      if (p.h(paramString, "page-frame.html"))
      {
        localObject1 = this.qvh.QM();
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ae.alL(bl.d((AppBrandRuntime)localObject1, "page-frame.html"));
        break;
      }
      if (p.h(paramString, this.qvh.btD()))
      {
        localObject1 = this.qvh.QM();
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = bl.d((AppBrandRuntime)localObject1, paramString);
        localObject2 = ae.alK((String)localObject1);
        p.j(localObject2, "extractStyle(pageHtml)");
        localObject3 = kotlin.n.d.UTF_8;
        if (localObject2 == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
        p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject2 = Base64.encodeToString((byte[])localObject2, 2);
        localObject3 = ae.alJ((String)localObject1);
        p.j(localObject3, "extractPage(pageHtml)");
        localObject4 = kotlin.n.d.UTF_8;
        if (localObject3 == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(147975);
          throw paramString;
        }
        localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
        p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
        localObject3 = Base64.encodeToString((byte[])localObject3, 2);
        localObject1 = ae.alL((String)localObject1);
        localObject4 = af.aaBG;
        localObject4 = Locale.ENGLISH;
        p.j(localObject4, "Locale.ENGLISH");
        localObject1 = String.format((Locale)localObject4, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(new Object[] { localObject2, localObject3, localObject1 }, 3));
        p.j(localObject1, "java.lang.String.format(locale, format, *args)");
        break;
      }
      localObject1 = bl.d((AppBrandRuntime)this.qvh.QM(), paramString);
      break;
      label625:
      i = -1;
      break label116;
      label630:
      i = 0;
      break label158;
      label635:
      Object localObject4 = ((bk)localObject2).qvh.QM();
      if (localObject4 == null) {
        p.iCn();
      }
      localObject4 = ((StringBuilder)localObject3).append(((com.tencent.luggage.sdk.e.d)localObject4).getAppId()).append("/");
      localObject2 = ((bk)localObject2).qvh.QM();
      if (localObject2 == null) {
        p.iCn();
      }
      ((StringBuilder)localObject4).append(((com.tencent.luggage.sdk.e.d)localObject2).Sj().nYR.pkgVersion()).append("/");
      break label256;
      paramString = "";
      break label272;
    }
    label727:
    paramString = (String)localObject1 + "\n//# sourceURL=" + com.tencent.mm.plugin.appbrand.utils.t.anl(paramString);
    AppMethodBeat.o(147975);
    return paramString;
    label762:
    AppMethodBeat.o(147975);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */