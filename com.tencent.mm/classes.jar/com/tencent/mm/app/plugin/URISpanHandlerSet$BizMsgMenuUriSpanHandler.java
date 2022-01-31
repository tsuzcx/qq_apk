package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  
  final boolean a(m paramm, g paramg)
  {
    if (43 == paramm.type)
    {
      if (bk.bl(paramm.username))
      {
        y.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
        return true;
      }
      y.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", new Object[] { paramm.url });
      Object localObject = Uri.parse(paramm.url.trim());
      paramg = ((Uri)localObject).getQueryParameter("msgmenuid");
      localObject = ((Uri)localObject).getQueryParameter("msgmenucontent");
      com.tencent.mm.plugin.report.service.h.nFQ.f(14522, new Object[] { bk.pm(paramg), paramm.username });
      if ((bk.bl(paramg)) || (bk.bl((String)localObject)))
      {
        y.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
        return true;
      }
      try
      {
        localObject = URLDecoder.decode((String)localObject, "UTF-8");
        HashMap localHashMap = new HashMap();
        localHashMap.put("bizmsgmenuid", paramg);
        paramm = new com.tencent.mm.modelmulti.h(paramm.username, (String)localObject, com.tencent.mm.model.s.hW(paramm.username), 291, localHashMap);
        au.Dk().a(paramm, 0);
        return true;
      }
      catch (UnsupportedEncodingException paramm)
      {
        for (;;)
        {
          y.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", new Object[] { paramm.getMessage() });
        }
      }
    }
    return false;
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.s params, Bundle paramBundle)
  {
    return false;
  }
  
  final m cA(String paramString)
  {
    if (paramString.trim().startsWith("weixin://bizmsgmenu")) {
      return new m(paramString, 43, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 43 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.BizMsgMenuUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */