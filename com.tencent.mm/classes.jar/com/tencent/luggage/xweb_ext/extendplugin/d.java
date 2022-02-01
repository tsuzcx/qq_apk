package com.tencent.luggage.xweb_ext.extendplugin;

import com.tencent.luggage.xweb_ext.extendplugin.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class d
{
  public static com.tencent.luggage.xweb_ext.extendplugin.b.c a(WebView paramWebView, com.tencent.luggage.xweb_ext.extendplugin.b.d paramd, com.tencent.luggage.xweb_ext.extendplugin.a.c paramc, au paramau)
  {
    AppMethodBeat.i(215535);
    if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand())
    {
      Log.w("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
      AppMethodBeat.o(215535);
      return null;
    }
    if ((paramWebView != null) && (paramWebView.isXWalkKernel()))
    {
      paramWebView = paramWebView.getWebViewUI();
      if (((paramWebView instanceof XWalkView)) && (paramd != null))
      {
        paramWebView = (XWalkView)paramWebView;
        paramd = paramd.QM();
        Object localObject = new c(paramWebView);
        ((c)localObject).cDJ = paramd;
        paramd.a((c)localObject);
        paramWebView.setExtendPluginClient((XWalkExtendPluginClient)localObject);
        if (paramau != null)
        {
          localObject = new a(paramWebView);
          ((a)localObject).cKd = paramau;
          paramWebView.setExtendTextAreaClient((XWalkExtendTextAreaClient)localObject);
        }
        if (paramc != null) {
          paramd.a(paramc);
        }
        Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
        AppMethodBeat.o(215535);
        return paramd;
      }
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
    }
    for (;;)
    {
      AppMethodBeat.o(215535);
      return null;
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
    }
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(215537);
    if ((paramc != null) && (paramc.QK() != null))
    {
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramc.QK().takePluginScreenshot(paramString, paramInt);
    }
    AppMethodBeat.o(215537);
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(215536);
    if ((paramc != null) && (paramc.QK() != null))
    {
      Log.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      paramc.QK().setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(215536);
  }
  
  public static String o(String paramString, int paramInt)
  {
    AppMethodBeat.i(138808);
    paramString = String.format(Locale.US, "%s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(138808);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.d
 * JD-Core Version:    0.7.0.1
 */