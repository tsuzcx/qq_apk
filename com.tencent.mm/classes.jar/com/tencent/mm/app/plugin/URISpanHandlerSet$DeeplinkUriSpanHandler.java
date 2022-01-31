package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

@URISpanHandlerSet.a(tB=URISpanHandlerSet.PRIORITY.LOW)
class URISpanHandlerSet$DeeplinkUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$DeeplinkUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final boolean a(m paramm, g paramg)
  {
    y.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[] { Integer.valueOf(paramm.type), paramm.url });
    if (paramg != null) {}
    for (paramg = (String)paramg.a(paramm);; paramg = null)
    {
      if (paramm.type == 30)
      {
        paramm = bk.pm(paramm.url);
        com.tencent.mm.ai.d locald;
        if ((paramm.startsWith("weixin://shieldBrandMsg/")) || (paramm.startsWith("weixin://receiveBrandMsg/")))
        {
          if (bk.bl(paramg))
          {
            y.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
            return true;
          }
          locald = f.kX(paramg);
          if (locald == null)
          {
            y.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
            return true;
          }
          if (paramm.startsWith("weixin://shieldBrandMsg/")) {
            h.a(URISpanHandlerSet.a(this.byk), R.l.temp_session_shield_biz_msg_tips, R.l.app_tip, R.l.temp_session_shield_biz_msg_confirm, R.l.cancel, new URISpanHandlerSet.DeeplinkUriSpanHandler.1(this, locald, paramm, paramg), null);
          }
        }
        for (;;)
        {
          return true;
          if (paramm.startsWith("weixin://receiveBrandMsg/"))
          {
            h.a(URISpanHandlerSet.a(this.byk), R.l.temp_session_receive_biz_msg_tips, R.l.app_tip, R.l.temp_session_receive_biz_msg_confirm, R.l.cancel, new URISpanHandlerSet.DeeplinkUriSpanHandler.2(this, locald, paramm, paramg), null);
            continue;
            if (com.tencent.mm.pluginsdk.d.j(Uri.parse(paramm)))
            {
              com.tencent.mm.pluginsdk.d.u(URISpanHandlerSet.a(this.byk), paramg, paramm);
            }
            else if (paramm.startsWith("weixin://receiveWeAppKFMsg"))
            {
              if (bk.bl(paramg))
              {
                y.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[] { paramm });
                return true;
              }
              h.a(URISpanHandlerSet.a(this.byk), R.l.app_brand_reveive_msg_title, R.l.app_tip, R.l.app_brand_reveive_msg_config, R.l.cancel, new URISpanHandlerSet.DeeplinkUriSpanHandler.3(this, paramg), null);
            }
            else
            {
              com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.a(this.byk), paramm, paramg, 1, paramm, null);
            }
          }
        }
      }
      return false;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, s params, Bundle paramBundle)
  {
    if ((bk.bl(paramString)) || (paramBundle == null)) {
      if (paramString == null)
      {
        paramBoolean = true;
        if (paramBundle != null) {
          break label59;
        }
        bool = true;
        y.e("MicroMsg.URISpanHandlerSet", "url is null ? %b, paramsBundle is null ? %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      }
    }
    label59:
    while (!com.tencent.mm.pluginsdk.d.j(Uri.parse(paramString))) {
      for (;;)
      {
        return false;
        paramBoolean = false;
        continue;
        boolean bool = false;
      }
    }
    int j = paramBundle.getInt("key_scene", -1);
    y.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[] { Integer.valueOf(j), paramString });
    int i = j;
    if (j == -1) {
      i = 5;
    }
    params = h.b(URISpanHandlerSet.a(this.byk), "", true, null);
    com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.a(this.byk), paramString, i, new URISpanHandlerSet.DeeplinkUriSpanHandler.4(this, params));
    return true;
  }
  
  final m cA(String paramString)
  {
    y.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[] { paramString });
    if (paramString.trim().toLowerCase().startsWith("weixin://")) {
      return new m(paramString, 30, null);
    }
    return null;
  }
  
  final int[] tA()
  {
    return new int[] { 30 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */