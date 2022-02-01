package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

@URISpanHandlerSet.a
class URISpanHandlerSet$BizMsgMenuUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$BizMsgMenuUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(278698);
    if (43 == paramu.type)
    {
      if (Util.isNullOrNil(paramu.username))
      {
        Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
        AppMethodBeat.o(278698);
        return true;
      }
      if ((paramu.fromScene == 1) && (paramu.fNz != null)) {
        l.Y(paramu.fNz);
      }
      Log.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[] { paramu.url });
      parami = Uri.parse(paramu.url.trim());
      paramView = parami.getQueryParameter("msgmenuid");
      parami = parami.getQueryParameter("msgmenucontent");
      h.IzE.a(14522, new Object[] { Util.nullAsNil(paramView), paramu.username });
      if ((Util.isNullOrNil(paramView)) || (Util.isNullOrNil(parami)))
      {
        Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
        AppMethodBeat.o(278698);
        return true;
      }
      try
      {
        String str = URLDecoder.decode(parami, "UTF-8");
        parami = new HashMap();
        parami.put("bizmsgmenuid", paramView);
        paramView = o.WI(paramu.username);
        paramView.toUser = paramu.username;
        paramView.content = str;
        paramView = paramView.wD(ab.QZ(paramu.username));
        paramView.cUP = 1;
        paramView.lUp = parami;
        paramView.lUq = 5;
        paramView.bnl().aEv();
        AppMethodBeat.o(278698);
        return true;
      }
      catch (UnsupportedEncodingException paramView)
      {
        for (;;)
        {
          Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[] { paramView.getMessage() });
        }
      }
    }
    AppMethodBeat.o(278698);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 43 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(19684);
    if (paramString.trim().startsWith("weixin://bizmsgmenu"))
    {
      paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 43, null);
      AppMethodBeat.o(19684);
      return paramString;
    }
    AppMethodBeat.o(19684);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.BizMsgMenuUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */