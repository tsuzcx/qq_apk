package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.x.b;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;

@URISpanHandlerSet.a
class URISpanHandlerSet$WxaShortLinkUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$WxaShortLinkUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet) {}
  
  public final boolean a(View paramView, u paramu, m paramm)
  {
    AppMethodBeat.i(239365);
    Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] handleSpanClick ");
    paramm = paramu.cpt;
    if ((paramm instanceof Bundle))
    {
      paramView = ((Bundle)paramm).getString("key_wxa_short_link_launch_scene", "");
      int i = ((Bundle)paramm).getInt("key_wxa_short_link_launch_chat_type", -1);
      if (paramView.isEmpty())
      {
        Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] scene is null ");
        if (BuildInfo.IS_FLAVOR_RED)
        {
          paramView = new Error("[WxaShortLinkUriSpanHandler]  scene must not is null");
          AppMethodBeat.o(239365);
          throw paramView;
        }
      }
      else
      {
        paramm = x.b.valueOf(paramView);
        Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] sceneName=%s  scene=%d  preScene=%d", new Object[] { paramView, Integer.valueOf(paramm.CKA), Integer.valueOf(paramm.YpH) });
        AppBrandCheckWxaShortLinkUI.a(URISpanHandlerSet.a(this.hkL), paramu.url, paramm, i);
      }
    }
    do
    {
      AppMethodBeat.o(239365);
      return false;
      Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] HrefInfo has not data");
    } while (!BuildInfo.IS_FLAVOR_RED);
    paramView = new Error("[WxaShortLinkUriSpanHandler] HrefInfo has not data");
    AppMethodBeat.o(239365);
    throw paramView;
  }
  
  public final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  public final int[] aDQ()
  {
    return new int[] { 60 };
  }
  
  public final u iJ(String paramString)
  {
    AppMethodBeat.i(239362);
    if (paramString.trim().toLowerCase().startsWith("mp://"))
    {
      paramString = new u(paramString, 60, null);
      AppMethodBeat.o(239362);
      return paramString;
    }
    AppMethodBeat.o(239362);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.WxaShortLinkUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */