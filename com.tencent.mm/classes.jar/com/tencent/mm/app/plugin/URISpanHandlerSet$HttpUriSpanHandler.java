package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.l;
import com.tencent.mm.by.c;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.api.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

@URISpanHandlerSet.a
class URISpanHandlerSet$HttpUriSpanHandler
  extends URISpanHandlerSet.BaseUriSpanHandler
{
  private final String fgM;
  
  URISpanHandlerSet$HttpUriSpanHandler(URISpanHandlerSet paramURISpanHandlerSet)
  {
    super(paramURISpanHandlerSet);
    AppMethodBeat.i(286407);
    this.fgM = ("https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/newsubscribemsg?action=subscribepage");
    AppMethodBeat.o(286407);
  }
  
  final boolean a(View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(286409);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    if (paramu.type == 1)
    {
      if ((paramu != null) && (paramu.url.trim().startsWith(this.fgM)))
      {
        Log.i("MicroMsg.URISpanHandlerSet", "alvinluo processHttpLink subscribeMsgLink onClick url: %s", new Object[] { paramu.url });
        if (parami != null)
        {
          if (!Util.isNullOrNil(paramu.xyW)) {
            break label210;
          }
          localObject1 = paramu.username;
          if (!g.Ux((String)localObject1)) {
            break label210;
          }
          localObject2 = paramu.url;
          paramView = null;
          if ((paramu.xJA instanceof String)) {
            paramView = (String)paramu.xJA;
          }
          if ((localObject1 != null) && (localObject2 != null))
          {
            Log.i("MicroMsg.URISpanHandlerSet", "alvinluo clickSubscribeMsgSpan bizUsername: %s, url: %s, content: %s", new Object[] { localObject1, localObject2, paramView });
            localObject3 = b.moG;
            localObject3 = b.YR("name_biz");
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("key_extra_content", paramView);
            if (localObject3 != null) {
              ((ISubscribeMsgService)localObject3).a(URISpanHandlerSet.a(this.fgB), (String)localObject1, (String)localObject2, (Bundle)localObject4);
            }
          }
        }
      }
      label210:
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(286409);
        return true;
      }
      if ((URISpanHandlerSet.a(this.fgB) != null) && ((URISpanHandlerSet.a(this.fgB) instanceof WebViewUI)))
      {
        i = 1;
        paramu.bv(ah.class);
        if ((URISpanHandlerSet.a(this.fgB) == null) || ((i != 0) && (!MMApplicationContext.isMMProcess()))) {
          break label909;
        }
      }
    }
    label901:
    label909:
    for (Object localObject1 = ai.aR("@" + paramu.url, URISpanHandlerSet.a(this.fgB).getString(R.l.eGk));; localObject1 = null)
    {
      if (parami != null) {}
      for (paramView = (String)parami.a(paramu);; paramView = null)
      {
        if ((paramu.fromScene == 1) && (paramu.fNz != null)) {
          l.Y(paramu.fNz);
        }
        if ((localObject1 == null) || (!((ah)localObject1).enable))
        {
          localObject4 = paramu.url;
          if (((String)localObject4).toLowerCase().startsWith("http")) {
            break label901;
          }
          localObject4 = "http://".concat(String.valueOf(localObject4));
        }
        for (;;)
        {
          Intent localIntent = new Intent();
          localObject1 = "";
          localObject3 = "";
          Object localObject5 = localObject1;
          localObject2 = localObject3;
          Bundle localBundle;
          if (paramu.bnW != null)
          {
            localObject5 = localObject1;
            localObject2 = localObject3;
            if ((paramu.bnW instanceof Bundle))
            {
              localBundle = (Bundle)paramu.bnW;
              long l = localBundle.getLong("msgSvrId", 0L);
              if (l == 0L) {
                break label861;
              }
              localObject1 = String.valueOf(l);
              label471:
              if (!Util.isNullOrNil(paramu.xyW)) {
                break label873;
              }
              localObject3 = paramu.username;
              label487:
              localObject5 = localObject1;
              localObject2 = localObject3;
              if (Util.isNullOrNil((String)localObject3))
              {
                localObject2 = localBundle.getString("msgUsername");
                localObject5 = localObject1;
              }
            }
          }
          localIntent.putExtra("serverMsgID", localObject5);
          localIntent.putExtra("msgUsername", (String)localObject2);
          localIntent.putExtra("rawUrl", (String)localObject4);
          if ((paramu.bnW != null) && ((paramu.bnW instanceof Bundle))) {
            localIntent.putExtra("geta8key_scene", ((Bundle)paramu.bnW).getInt("geta8key_scene"));
          }
          localObject1 = paramu.mSessionId;
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject4 = ad.beh().Rn((String)localObject1);
            if (localObject4 != null)
            {
              localObject2 = ((ad.b)localObject4).getString("prePublishId", null);
              localObject3 = ((ad.b)localObject4).getString("preUsername", null);
              localObject4 = ((ad.b)localObject4).getString("preChatName", null);
              localIntent.putExtra("reportSessionId", (String)localObject1);
              localIntent.putExtra("KPublisherId", (String)localObject2);
              localIntent.putExtra("geta8key_username", (String)localObject4);
              localIntent.putExtra("pre_username", (String)localObject3);
              localIntent.putExtra("prePublishId", (String)localObject2);
              localIntent.putExtra("preUsername", (String)localObject3);
              localIntent.putExtra("preChatName", (String)localObject4);
              localIntent.putExtra("preChatTYPE", ac.aN((String)localObject3, (String)localObject4));
            }
          }
          localObject1 = paramView;
          if (Util.isNullOrNil(paramView)) {
            localObject1 = null;
          }
          localIntent.putExtra("geta8key_username", (String)localObject1);
          if ((paramu.fromScene == 1) || (paramu.fromScene == 2) || (paramu.fromScene == 3) || (paramu.fromScene == 4)) {
            localIntent.putExtra("key_enable_teen_mode_check", true);
          }
          if (i != 0) {
            localIntent.addFlags(268435456);
          }
          for (;;)
          {
            c.b(URISpanHandlerSet.a(this.fgB), "webview", ".ui.tools.WebViewUI", localIntent);
            if (parami != null) {
              parami.b(paramu);
            }
            AppMethodBeat.o(286409);
            return true;
            i = 0;
            break;
            label861:
            localObject1 = localBundle.getString("serverMsgID");
            break label471;
            label873:
            localObject3 = paramu.xyW;
            break label487;
            localIntent.addFlags(536870912);
          }
          AppMethodBeat.o(286409);
          return false;
        }
      }
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    return false;
  }
  
  final int[] abR()
  {
    return new int[] { 1 };
  }
  
  final com.tencent.mm.pluginsdk.ui.applet.u hi(String paramString)
  {
    AppMethodBeat.i(19719);
    if (paramString.trim().toLowerCase().startsWith("http")) {}
    for (paramString = new com.tencent.mm.pluginsdk.ui.applet.u(paramString, 1, null);; paramString = null)
    {
      AppMethodBeat.o(19719);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.HttpUriSpanHandler
 * JD-Core Version:    0.7.0.1
 */