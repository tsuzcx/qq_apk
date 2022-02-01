package com.tencent.luggage.xweb_ext.extendplugin;

import com.tencent.luggage.xweb_ext.extendplugin.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkExtendPluginClient;
import org.xwalk.core.XWalkExtendTextAreaClient;
import org.xwalk.core.XWalkView;

public final class d
{
  public static com.tencent.luggage.xweb_ext.extendplugin.b.c a(WebView paramWebView, com.tencent.luggage.xweb_ext.extendplugin.b.d paramd, com.tencent.luggage.xweb_ext.extendplugin.a.c paramc, as paramas)
  {
    AppMethodBeat.i(186715);
    if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand())
    {
      ad.w("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
      AppMethodBeat.o(186715);
      return null;
    }
    if ((paramWebView != null) && (paramWebView.isXWalkKernel()))
    {
      paramWebView = paramWebView.getWebViewUI();
      if (((paramWebView instanceof XWalkView)) && (paramd != null))
      {
        paramWebView = (XWalkView)paramWebView;
        paramd = paramd.GN();
        Object localObject = new c(paramWebView);
        ((c)localObject).cqP = paramd;
        paramd.a((c)localObject);
        paramWebView.setExtendPluginClient((XWalkExtendPluginClient)localObject);
        if (paramas != null)
        {
          localObject = new a(paramWebView);
          ((a)localObject).cvA = paramas;
          paramWebView.setExtendTextAreaClient((XWalkExtendTextAreaClient)localObject);
        }
        if (paramc != null) {
          paramd.a(paramc);
        }
        ad.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
        AppMethodBeat.o(186715);
        return paramd;
      }
      ad.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
    }
    for (;;)
    {
      AppMethodBeat.o(186715);
      return null;
      ad.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
    }
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(186717);
    if ((paramc != null) && (paramc.GL() != null))
    {
      ad.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginScreenshot, %s#%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      paramc.GL().takePluginScreenshot(paramString, paramInt);
    }
    AppMethodBeat.o(186717);
  }
  
  public static void a(com.tencent.luggage.xweb_ext.extendplugin.b.c paramc, String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(186716);
    if ((paramc != null) && (paramc.GL() != null))
    {
      ad.i("MicroMsg.SameLayer.WebViewExtendPluginUtil", "applyPluginTextureScale, %s#%d, scale:[%s,%s]", new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      paramc.GL().setPluginTextureScale(paramString, paramInt, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(186716);
  }
  
  public static String n(String paramString, int paramInt)
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