package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.am;
import kotlin.g.b.s;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class bk
  implements bg
{
  @Deprecated
  public static boolean tAa;
  private static final bk.a tzZ;
  private final a<?> tzU;
  
  static
  {
    AppMethodBeat.i(147977);
    tzZ = new bk.a((byte)0);
    tAa = true;
    AppMethodBeat.o(147977);
  }
  
  public bk(a<?> parama)
  {
    AppMethodBeat.i(147976);
    this.tzU = parama;
    AppMethodBeat.o(147976);
  }
  
  public String aeU(String paramString)
  {
    AppMethodBeat.i(147975);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(147975);
      return null;
    }
    localObject1 = com.tencent.luggage.sdk.b.a.d.eqO;
    s.s(localObject1, "SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject2;
    label113:
    Object localObject3;
    if (k.contains((Object[])localObject1, paramString))
    {
      localObject1 = this.tzU.aa(ICommLibReader.class);
      s.checkNotNull(localObject1);
      localObject1 = ((ICommLibReader)localObject1).UW(paramString);
      localObject2 = new StringBuilder("provideScript name[").append(paramString).append("] source.length[");
      if (localObject1 != null) {
        break label859;
      }
      i = -1;
      Log.i("Luggage.WXA.MPPageScriptProviderDefaultImpl", i + ']');
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label867;
      }
      i = 1;
      label155:
      if (i != 0) {
        break label998;
      }
      localObject2 = (bk)this;
      localObject3 = com.tencent.luggage.sdk.b.a.d.eqO;
      s.s(localObject3, "SCRIPTS_LIB_FOR_WEBVIEW");
      if (!k.contains((Object[])localObject3, paramString))
      {
        localObject3 = ((bk)localObject2).tzU.aqZ();
        if (localObject3 == null) {
          break label872;
        }
        localObject3 = ((com.tencent.luggage.sdk.e.d)localObject3).asz();
        if ((localObject3 == null) || (((AppBrandSysConfigLU)localObject3).epz != true)) {
          break label872;
        }
        i = 1;
        label227:
        if (i == 0) {
          break label951;
        }
      }
      localObject3 = new StringBuilder(com.tencent.luggage.sdk.b.a.d.eqM);
      if (((bk)localObject2).tzU.aqZ() != null) {
        break label877;
      }
      ((StringBuilder)localObject3).append("preload/");
      label262:
      paramString = paramString;
      label272:
      s.s(paramString, "run makeSourceURL@{\n    …      }\n                }");
      if (((CharSequence)paramString).length() != 0) {
        break label958;
      }
    }
    label951:
    label958:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label963;
      }
      AppMethodBeat.o(147975);
      return localObject1;
      if (s.p(paramString, "app-wxss.js"))
      {
        localObject1 = this.tzU.aqZ();
        s.checkNotNull(localObject1);
        localObject1 = bl.d((AppBrandRuntime)localObject1, "app-wxss.js");
        break;
      }
      if (s.p(paramString, "page-frame.html"))
      {
        localObject1 = this.tzU.aqZ();
        s.checkNotNull(localObject1);
        localObject1 = ae.aeR(bl.d((AppBrandRuntime)localObject1, "page-frame.html"));
        break;
      }
      if (s.p(paramString, this.tzU.rAF))
      {
        localObject1 = this.tzU.aqZ();
        s.checkNotNull(localObject1);
        localObject2 = bl.d((AppBrandRuntime)localObject1, paramString);
        if (tAa)
        {
          localObject1 = new StringBuilder();
          localObject4 = i.bLh(ae.aeQ((String)localObject2));
          localObject3 = i.bLh(ae.aeP((String)localObject2));
          localObject2 = ae.aeR((String)localObject2);
          Object localObject5 = (CharSequence)localObject4;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            i = 1;
            label475:
            if (i == 0)
            {
              localObject5 = ((StringBuilder)localObject1).append("var style = document.createElement('style');");
              StringBuilder localStringBuilder = new StringBuilder("style.innerHTML = atob(\"");
              s.s(localObject4, "style");
              localObject4 = ((String)localObject4).getBytes(kotlin.n.d.UTF_8);
              s.s(localObject4, "(this as java.lang.String).getBytes(charset)");
              ((StringBuilder)localObject5).append(Base64.encodeToString((byte[])localObject4, 2) + "\");").append("document.head.appendChild(style);");
            }
            localObject4 = (CharSequence)localObject3;
            if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
              break label706;
            }
            i = 1;
            label576:
            if (i == 0)
            {
              localObject4 = ((StringBuilder)localObject1).append("var page = document.createElement('page');");
              localObject5 = new StringBuilder("page.innerHTML = atob(\"");
              s.s(localObject3, "page");
              localObject3 = ((String)localObject3).getBytes(kotlin.n.d.UTF_8);
              s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
              ((StringBuilder)localObject4).append(Base64.encodeToString((byte[])localObject3, 2) + "\");").append("document.body.appendChild(page);");
            }
            localObject3 = (CharSequence)localObject2;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label711;
            }
          }
          label706:
          label711:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              ((StringBuilder)localObject1).append((String)localObject2).append(';');
            }
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
            i = 0;
            break label475;
            i = 0;
            break label576;
          }
        }
        localObject1 = ae.aeQ((String)localObject2);
        s.s(localObject1, "extractStyle(pageHtml)");
        localObject1 = ((String)localObject1).getBytes(kotlin.n.d.UTF_8);
        s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
        localObject1 = Base64.encodeToString((byte[])localObject1, 2);
        localObject3 = ae.aeP((String)localObject2);
        s.s(localObject3, "extractPage(pageHtml)");
        localObject3 = ((String)localObject3).getBytes(kotlin.n.d.UTF_8);
        s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
        localObject3 = Base64.encodeToString((byte[])localObject3, 2);
        localObject2 = ae.aeR((String)localObject2);
        localObject4 = am.aixg;
        localObject1 = String.format(Locale.ENGLISH, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(new Object[] { localObject1, localObject3, localObject2 }, 3));
        s.s(localObject1, "java.lang.String.format(locale, format, *args)");
        break;
      }
      localObject1 = bl.d((AppBrandRuntime)this.tzU.aqZ(), paramString);
      break;
      label859:
      i = ((String)localObject1).length();
      break label113;
      label867:
      i = 0;
      break label155;
      label872:
      i = 0;
      break label227;
      label877:
      Object localObject4 = ((bk)localObject2).tzU.aqZ();
      s.checkNotNull(localObject4);
      localObject4 = ((StringBuilder)localObject3).append(((AppBrandRuntime)localObject4).mAppId).append("/");
      localObject2 = ((bk)localObject2).tzU.aqZ();
      s.checkNotNull(localObject2);
      ((StringBuilder)localObject4).append(((com.tencent.luggage.sdk.e.d)localObject2).asz().qYY.pkgVersion()).append("/");
      break label262;
      paramString = "";
      break label272;
    }
    label963:
    paramString = localObject1 + "\n//# sourceURL=" + y.agF(paramString);
    AppMethodBeat.o(147975);
    return paramString;
    label998:
    AppMethodBeat.o(147975);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */