package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  
  final int[] Cf()
  {
    return new int[] { 43 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15640);
    if (43 == paramm.type)
    {
      if (bo.isNullOrNil(paramm.username))
      {
        ab.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
        AppMethodBeat.o(15640);
        return true;
      }
      ab.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[] { paramm.url });
      Object localObject = Uri.parse(paramm.url.trim());
      paramg = ((Uri)localObject).getQueryParameter("msgmenuid");
      localObject = ((Uri)localObject).getQueryParameter("msgmenucontent");
      com.tencent.mm.plugin.report.service.h.qsU.e(14522, new Object[] { bo.nullAsNil(paramg), paramm.username });
      if ((bo.isNullOrNil(paramg)) || (bo.isNullOrNil((String)localObject)))
      {
        ab.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
        AppMethodBeat.o(15640);
        return true;
      }
      try
      {
        localObject = URLDecoder.decode((String)localObject, "UTF-8");
        HashMap localHashMap = new HashMap();
        localHashMap.put("bizmsgmenuid", paramg);
        paramm = new com.tencent.mm.modelmulti.h(paramm.username, (String)localObject, t.oF(paramm.username), 291, localHashMap);
        aw.Rc().a(paramm, 0);
        AppMethodBeat.o(15640);
        return true;
      }
      catch (UnsupportedEncodingException paramm)
      {
        for (;;)
        {
          ab.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[] { paramm.getMessage() });
        }
      }
    }
    AppMethodBeat.o(15640);
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15639);
    if (paramString.trim().startsWith("weixin://bizmsgmenu"))
    {
      paramString = new m(paramString, 43, null);
      AppMethodBeat.o(15639);
      return paramString;
    }
    AppMethodBeat.o(15639);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.BizMsgMenuUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */