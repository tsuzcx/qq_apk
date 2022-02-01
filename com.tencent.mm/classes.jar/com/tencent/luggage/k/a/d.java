package com.tencent.luggage.k.a;

import com.tencent.luggage.k.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class d
{
  public static com.tencent.luggage.k.a.c.c a(WebView paramWebView, com.tencent.luggage.k.a.c.d paramd, com.tencent.luggage.k.a.b.c paramc, as paramas)
  {
    AppMethodBeat.i(206502);
    if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand())
    {
      ac.w("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
      AppMethodBeat.o(206502);
      return null;
    }
    if ((paramWebView != null) && (paramWebView.isXWalkKernel()))
    {
      paramWebView = paramWebView.getWebViewUI();
      if (((paramWebView instanceof XWalkView)) && (paramd != null))
      {
        paramWebView = (XWalkView)paramWebView;
        paramd = paramd.Ft();
        Object localObject = new c(paramWebView);
        ((c)localObject).cgy = paramd;
        paramd.a((c)localObject);
        paramWebView.setExtendPluginClient((XWalkExtendPluginClient)localObject);
        if (paramas != null)
        {
          localObject = new a(paramWebView);
          ((a)localObject).ckY = paramas;
          paramWebView.setExtendTextAreaClient((XWalkExtendTextAreaClient)localObject);
        }
        if (paramc != null) {
          paramd.a(paramc);
        }
        ac.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
        AppMethodBeat.o(206502);
        return paramd;
      }
      ac.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
    }
    for (;;)
    {
      AppMethodBeat.o(206502);
      return null;
      ac.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
    }
  }
  
  public static void a(com.tencent.luggage.k.a.c.c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(206504);
    if ((paramc != null) && (paramc.Fr() != null))
    {
      ac.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramc.Fr().takePluginScreenshot(paramString, paramInt);
    }
    AppMethodBeat.o(206504);
  }
  
  public static void a(com.tencent.luggage.k.a.c.c paramc, String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206503);
    if ((paramc != null) && (paramc.Fr() != null))
    {
      ac.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      paramc.Fr().setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(206503);
  }
  
  public static String l(String paramString, int paramInt)
  {
    AppMethodBeat.i(138808);
    paramString = String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(138808);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.d
 * JD-Core Version:    0.7.0.1
 */