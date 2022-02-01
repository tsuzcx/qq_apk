package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.t.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

@URISpanHandlerSet.a
class URISpanHandlerSet$WxaShortLinkUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$WxaShortLinkUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(222771);
    Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] handleSpanClick ");
    parami = paramu.bnW;
    if ((parami instanceof Bundle))
    {
      paramView = ((Bundle)parami).getString("key_wxa_short_link_launch_scene", "");
      int i = ((Bundle)parami).getInt("key_wxa_short_link_launch_chat_type", -1);
      if (paramView.isEmpty())
      {
        Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] scene is null ");
        if (BuildInfo.IS_FLAVOR_RED)
        {
          paramView = new Error("[WxaShortLinkUriSpanHandler]  scene must not is null");
          AppMethodBeat.o(222771);
          throw paramView;
        }
      }
      else
      {
        parami = t.b.valueOf(paramView);
        Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] sceneName=%s  scene=%d  preScene=%d", new Object[] { paramView, Integer.valueOf(parami.Rtz), Integer.valueOf(parami.RtA) });
        AppBrandCheckWxaShortLinkUI.a(URISpanHandlerSet.a(this.fgB), paramu.url, parami, i);
      }
    }
    do
    {
      AppMethodBeat.o(222771);
      return false;
      Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] HrefInfo has not data");
    } while (!BuildInfo.IS_FLAVOR_RED);
    paramView = new Error("[WxaShortLinkUriSpanHandler] HrefInfo has not data");
    AppMethodBeat.o(222771);
    throw paramView;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 60 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(222765);
    if (paramString.trim().toLowerCase().startsWith("mp://"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 60, null);
      AppMethodBeat.o(222765);
      return paramString;
    }
    AppMethodBeat.o(222765);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.WxaShortLinkUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */