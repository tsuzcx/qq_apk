package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

@URISpanHandlerSet.a(Cg=URISpanHandlerSet.PRIORITY.LOW)
class URISpanHandlerSet$DeeplinkUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$DeeplinkUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 30 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15650);
    ab.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[] { Integer.valueOf(paramm.type), paramm.url });
    if (paramg != null) {}
    for (paramg = (String)paramg.a(paramm);; paramg = null)
    {
      if (paramm.type == 30)
      {
        paramm = bo.nullAsNil(paramm.url);
        d locald;
        if ((paramm.startsWith("weixin://shieldBrandMsg/")) || (paramm.startsWith("weixin://receiveBrandMsg/")))
        {
          if (bo.isNullOrNil(paramg))
          {
            ab.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
            AppMethodBeat.o(15650);
            return true;
          }
          locald = f.rS(paramg);
          if (locald == null)
          {
            ab.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
            AppMethodBeat.o(15650);
            return true;
          }
          if (paramm.startsWith("weixin://shieldBrandMsg/")) {
            h.a(URISpanHandlerSet.a(this.cam), 2131304268, 2131297087, 2131304267, 2131297837, new URISpanHandlerSet.DeeplinkUriSpanHandler.1(this, locald, paramm, paramg), null);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(15650);
          return true;
          if (paramm.startsWith("weixin://receiveBrandMsg/"))
          {
            h.a(URISpanHandlerSet.a(this.cam), 2131304266, 2131297087, 2131304265, 2131297837, new URISpanHandlerSet.DeeplinkUriSpanHandler.2(this, locald, paramm, paramg), null);
            continue;
            if (e.l(Uri.parse(paramm)))
            {
              e.A(URISpanHandlerSet.a(this.cam), paramg, paramm);
            }
            else if (paramm.startsWith("weixin://receiveWeAppKFMsg"))
            {
              if (bo.isNullOrNil(paramg))
              {
                ab.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[] { paramm });
                AppMethodBeat.o(15650);
                return true;
              }
              h.a(URISpanHandlerSet.a(this.cam), 2131296836, 2131297087, 2131296835, 2131297837, new URISpanHandlerSet.DeeplinkUriSpanHandler.3(this, paramg), null);
            }
            else
            {
              e.a(URISpanHandlerSet.a(this.cam), paramm, paramg, 1, paramm, null);
            }
          }
        }
      }
      AppMethodBeat.o(15650);
      return false;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15651);
    if ((bo.isNullOrNil(paramString)) || (paramBundle == null))
    {
      if (paramString == null)
      {
        paramBoolean = true;
        if (paramBundle != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.URISpanHandlerSet", "url is null ? %b, paramsBundle is null ? %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
        AppMethodBeat.o(15651);
        return false;
        paramBoolean = false;
        break;
      }
    }
    if (e.l(Uri.parse(paramString)))
    {
      int j = paramBundle.getInt("key_scene", -1);
      ab.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[] { Integer.valueOf(j), paramString });
      int i = j;
      if (j == -1) {
        i = 5;
      }
      paramv = h.b(URISpanHandlerSet.a(this.cam), "", true, null);
      e.a(URISpanHandlerSet.a(this.cam), paramString, i, new URISpanHandlerSet.DeeplinkUriSpanHandler.4(this, paramv));
      AppMethodBeat.o(15651);
      return true;
    }
    AppMethodBeat.o(15651);
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15649);
    ab.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[] { paramString });
    if (paramString.trim().toLowerCase().startsWith("weixin://"))
    {
      paramString = new m(paramString, 30, null);
      AppMethodBeat.o(15649);
      return paramString;
    }
    AppMethodBeat.o(15649);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */