package com.tencent.luggage.xweb_ext.extendplugin;

import com.tencent.luggage.xweb_ext.extendplugin.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class d
{
  public static com.tencent.luggage.xweb_ext.extendplugin.b.c a(WebView paramWebView, com.tencent.luggage.xweb_ext.extendplugin.b.d paramd, com.tencent.luggage.xweb_ext.extendplugin.a.c paramc, ar paramar)
  {
    AppMethodBeat.i(220398);
    if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand())
    {
      ae.w("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
      AppMethodBeat.o(220398);
      return null;
    }
    if ((paramWebView != null) && (paramWebView.isXWalkKernel()))
    {
      paramWebView = paramWebView.getWebViewUI();
      if (((paramWebView instanceof XWalkView)) && (paramd != null))
      {
        paramWebView = (XWalkView)paramWebView;
        paramd = paramd.GT();
        Object localObject = new c(paramWebView);
        ((c)localObject).crt = paramd;
        paramd.a((c)localObject);
        paramWebView.setExtendPluginClient((XWalkExtendPluginClient)localObject);
        if (paramar != null)
        {
          localObject = new a(paramWebView);
          ((a)localObject).cwe = paramar;
          paramWebView.setExtendTextAreaClient((XWalkExtendTextAreaClient)localObject);
        }
        if (paramc != null) {
          paramd.a(paramc);
        }
        ae.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
        AppMethodBeat.o(220398);
        return paramd;
      }
      ae.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
    }
    for (;;)
    {
      AppMethodBeat.o(220398);
      return null;
      ae.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
    }
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(220400);
    if ((paramc != null) && (paramc.GR() != null))
    {
      ae.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramc.GR().takePluginScreenshot(paramString, paramInt);
    }
    AppMethodBeat.o(220400);
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(220399);
    if ((paramc != null) && (paramc.GR() != null))
    {
      ae.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      paramc.GR().setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(220399);
  }
  
  public static String o(String paramString, int paramInt)
  {
    AppMethodBeat.i(138808);
    paramString = String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(138808);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.d
 * JD-Core Version:    0.7.0.1
 */