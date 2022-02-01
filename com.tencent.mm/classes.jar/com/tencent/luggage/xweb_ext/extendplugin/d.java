package com.tencent.luggage.xweb_ext.extendplugin;

import com.tencent.luggage.xweb_ext.extendplugin.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.ao;
import java.util.Locale;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkExtendTextAreaClient;

public final class d
{
  public static String G(String paramString, int paramInt)
  {
    AppMethodBeat.i(138808);
    paramString = String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(138808);
    return paramString;
  }
  
  public static com.tencent.luggage.xweb_ext.extendplugin.b.c a(WebView paramWebView, com.tencent.luggage.xweb_ext.extendplugin.b.d paramd, com.tencent.luggage.xweb_ext.extendplugin.a.c paramc, aw paramaw)
  {
    AppMethodBeat.i(220582);
    if (!ao.isCurrentVersionSupportExtendPluginForAppbrand())
    {
      Log.w("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
      AppMethodBeat.o(220582);
      return null;
    }
    if ((paramWebView != null) && (paramWebView.isXWalkKernel()))
    {
      paramWebView = paramWebView.getWebViewUI();
      if (((paramWebView instanceof XWebExtendInterface)) && (paramd != null))
      {
        paramWebView = (XWebExtendInterface)paramWebView;
        paramd = paramd.auW();
        Object localObject = new c(paramWebView);
        ((c)localObject).exB = paramd;
        paramd.a((c)localObject);
        paramWebView.setExtendPluginClient((XWalkExtendPluginClient)localObject);
        if (paramaw != null)
        {
          localObject = new a(paramWebView);
          ((a)localObject).eEr = paramaw;
          paramWebView.setExtendTextAreaClient((XWalkExtendTextAreaClient)localObject);
        }
        if (paramc != null) {
          paramd.a(paramc);
        }
        Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
        AppMethodBeat.o(220582);
        return paramd;
      }
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
    }
    for (;;)
    {
      AppMethodBeat.o(220582);
      return null;
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
    }
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(220588);
    if ((paramc != null) && (paramc.auU() != null))
    {
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramc.auU().takePluginScreenshot(paramString, paramInt);
    }
    AppMethodBeat.o(220588);
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(220584);
    if ((paramc != null) && (paramc.auU() != null))
    {
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      paramc.auU().setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(220584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.d
 * JD-Core Version:    0.7.0.1
 */