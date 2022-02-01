package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
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
  
  final int[] Xp()
  {
    return new int[] { 43 };
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231420);
    if (43 == paramu.type)
    {
      if (Util.isNullOrNil(paramu.username))
      {
        Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
        AppMethodBeat.o(231420);
        return true;
      }
      if ((paramu.fromScene == 1) && (paramu.dTX != null)) {
        l.S(paramu.dTX);
      }
      Log.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[] { paramu.url });
      parami = Uri.parse(paramu.url.trim());
      paramView = parami.getQueryParameter("msgmenuid");
      parami = parami.getQueryParameter("msgmenucontent");
      h.CyF.a(14522, new Object[] { Util.nullAsNil(paramView), paramu.username });
      if ((Util.isNullOrNil(paramView)) || (Util.isNullOrNil(parami)))
      {
        Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
        AppMethodBeat.o(231420);
        return true;
      }
      try
      {
        String str = URLDecoder.decode(parami, "UTF-8");
        parami = new HashMap();
        parami.put("bizmsgmenuid", paramView);
        paramView = o.Pl(paramu.username);
        paramView.toUser = paramu.username;
        paramView.content = str;
        paramView = paramView.tD(ab.JG(paramu.username));
        paramView.cSx = 1;
        paramView.jdQ = parami;
        paramView.jdR = 5;
        paramView.bdQ().execute();
        AppMethodBeat.o(231420);
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
    AppMethodBeat.o(231420);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u gx(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.BizMsgMenuUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */