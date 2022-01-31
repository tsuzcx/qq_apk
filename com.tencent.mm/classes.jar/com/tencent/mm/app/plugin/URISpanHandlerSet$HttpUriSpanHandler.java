package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@URISpanHandlerSet.a
class URISpanHandlerSet$HttpUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  URISpanHandlerSet$HttpUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
  }
  
  final int[] Cf()
  {
    return new int[] { 1 };
  }
  
  final boolean a(m paramm, g paramg)
  {
    AppMethodBeat.i(15674);
    int i;
    if (paramm.type == 1) {
      if ((URISpanHandlerSet.a(this.cam) != null) && ((URISpanHandlerSet.a(this.cam) instanceof WebViewUI)))
      {
        i = 1;
        paramm.ap(y.class);
        if ((i != 0) && (!ah.brt())) {
          break label456;
        }
      }
    }
    label428:
    label431:
    label456:
    for (Object localObject1 = z.ak("@" + paramm.url, URISpanHandlerSet.a(this.cam).getString(2131300541));; localObject1 = null)
    {
      if (paramg != null) {}
      for (String str1 = (String)paramg.a(paramm);; str1 = null)
      {
        Object localObject2;
        if ((localObject1 == null) || (!((y)localObject1).enable))
        {
          localObject2 = paramm.url;
          localObject1 = localObject2;
          if (!((String)localObject2).toLowerCase().startsWith("http")) {
            localObject1 = "http://".concat(String.valueOf(localObject2));
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
          if ((paramm.data != null) && ((paramm.data instanceof Integer))) {
            ((Intent)localObject2).putExtra("geta8key_scene", ((Integer)paramm.data).intValue());
          }
          localObject1 = paramm.mSessionId;
          if (!bo.isNullOrNil((String)localObject1))
          {
            Object localObject3 = com.tencent.mm.model.v.aae().oP((String)localObject1);
            if (localObject3 != null)
            {
              String str2 = ((v.b)localObject3).getString("prePublishId", null);
              String str3 = ((v.b)localObject3).getString("preUsername", null);
              localObject3 = ((v.b)localObject3).getString("preChatName", null);
              ((Intent)localObject2).putExtra("reportSessionId", (String)localObject1);
              ((Intent)localObject2).putExtra("KPublisherId", str2);
              ((Intent)localObject2).putExtra("geta8key_username", (String)localObject3);
              ((Intent)localObject2).putExtra("pre_username", str3);
              ((Intent)localObject2).putExtra("prePublishId", str2);
              ((Intent)localObject2).putExtra("preUsername", str3);
              ((Intent)localObject2).putExtra("preChatName", (String)localObject3);
              ((Intent)localObject2).putExtra("preChatTYPE", u.ah(str3, (String)localObject3));
            }
          }
          if (!bo.isNullOrNil(str1)) {
            break label428;
          }
          str1 = null;
          label365:
          ((Intent)localObject2).putExtra("geta8key_username", str1);
          if (i == 0) {
            break label431;
          }
          ((Intent)localObject2).addFlags(268435456);
        }
        for (;;)
        {
          d.b(URISpanHandlerSet.a(this.cam), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
          if (paramg != null) {
            paramg.b(paramm);
          }
          AppMethodBeat.o(15674);
          return true;
          i = 0;
          break;
          break label365;
          ((Intent)localObject2).addFlags(536870912);
        }
        AppMethodBeat.o(15674);
        return false;
      }
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.v paramv, Bundle paramBundle)
  {
    return false;
  }
  
  final m dN(String paramString)
  {
    AppMethodBeat.i(15673);
    if (paramString.trim().toLowerCase().startsWith("http")) {}
    for (paramString = new m(paramString, 1, null);; paramString = null)
    {
      AppMethodBeat.o(15673);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.HttpUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */