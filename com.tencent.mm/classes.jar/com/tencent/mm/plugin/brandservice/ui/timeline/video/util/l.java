package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.e.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "bizVideoPlayTime", "maxVideoPlaySaveTime", "addAutoPlayId", "url", "autoPlayId", "clearInvalidLastPlayTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "bundle", "Landroid/os/Bundle;", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class l
{
  private static final String TAG = "MicroMsg.BizVideoUtil";
  public static final l pLy;
  
  static
  {
    AppMethodBeat.i(7319);
    pLy = new l();
    TAG = "MicroMsg.BizVideoUtil";
    AppMethodBeat.o(7319);
  }
  
  public static boolean A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7318);
    if (paramBoolean)
    {
      AppMethodBeat.o(7318);
      return true;
    }
    Log.i(TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 1) || (paramInt == 0))
    {
      AppMethodBeat.o(7318);
      return true;
    }
    AppMethodBeat.o(7318);
    return false;
  }
  
  public static final String T(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(7312);
    p.h(paramContext, "context");
    if (paramInt < 10000)
    {
      AppMethodBeat.o(7312);
      return String.valueOf(paramInt);
    }
    String str = LocaleUtil.getApplicationLanguage();
    if (str == null) {}
    while (paramInt >= 100000)
    {
      AppMethodBeat.o(7312);
      return "100k+";
      switch (str.hashCode())
      {
      default: 
        break;
      case 115861276: 
        if (!str.equals("zh_CN")) {}
        break;
      case 115861812: 
      case 115861428: 
        for (;;)
        {
          paramContext = paramContext.getString(2131763165);
          p.g(paramContext, "context.getString(R.string.mp_100000)");
          if (paramInt < 100000) {
            break label177;
          }
          paramContext = "10" + paramContext + '+';
          AppMethodBeat.o(7312);
          return paramContext;
          if (!str.equals("zh_TW")) {
            break;
          }
          continue;
          if (!str.equals("zh_HK")) {
            break;
          }
        }
        label177:
        paramContext = paramInt / 10000 + '.' + paramInt % 10000 / 1000 + paramContext;
        AppMethodBeat.o(7312);
        return paramContext;
      }
    }
    paramContext = paramInt / 1000 + 'k';
    AppMethodBeat.o(7312);
    return paramContext;
  }
  
  public static final void a(Context paramContext, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(175544);
    p.h(paramContext, "context");
    p.h(paramBundle, "bundle");
    Intent localIntent = new Intent();
    localIntent.putExtra("biz_video_msg_id", paramLong1);
    localIntent.putExtra("biz_video_msg_svr_id", paramLong2);
    localIntent.putExtra("KPublisherId", "msg_".concat(String.valueOf(paramLong2)));
    localIntent.putExtra("biz_video_msg_index", paramInt);
    localIntent.putExtra("biz_video_session_id", ab.getSessionId());
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("webpageTitle", paramBundle.getString("webpageTitle"));
    p.h(localIntent, "intent");
    x localx = new x();
    localx.iAh = localIntent.getStringExtra("KPublisherId");
    localx.dHp = localIntent.getStringExtra("sns_local_id");
    localx.msgId = localIntent.getLongExtra("biz_video_msg_id", -1L);
    Object localObject3;
    if (localx.msgId > -1L)
    {
      localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).eiy().Hb(localx.msgId);
      p.g(localObject2, "msgInfo");
      if ((((ca)localObject2).gAt()) || (((ca)localObject2).dOQ()))
      {
        p.h(localIntent, "intent");
        p.h(localx, "mpMsgInfo");
        p.h(localObject2, "msgInfo");
        localx.dTS = localIntent.getLongExtra("biz_video_msg_svr_id", 0L);
        localx.iAf = localIntent.getIntExtra("biz_video_msg_index", 0);
        localx.userName = ((ca)localObject2).ajO();
        p.h(localObject2, "msgInfo");
        p.h(localx, "mpMsgInfo");
        if ((((ca)localObject2).gAt()) || (!((ca)localObject2).dOQ())) {
          break label656;
        }
        p.h(localObject2, "msgInfo");
        p.h(localx, "mpMsgInfo");
        localObject3 = k.b.HD(((ca)localObject2).getContent());
        if (localObject3 != null) {
          break label470;
        }
        Log.w(TAG, "parse content fail");
        localObject1 = null;
      }
    }
    int i;
    int j;
    for (;;)
    {
      localx.iAi = ((v)localObject1);
      localx.type = ((ca)localObject2).getType();
      localx.t(localIntent);
      i = paramBundle.getInt(e.b.OyQ, 10000);
      j = paramBundle.getInt(e.b.OyR, 10000);
      localObject3 = paramBundle.getString("biz_video_autoplay_id", "");
      if (!Util.isNullOrNil(localx.iAi.url)) {
        break;
      }
      Log.e(TAG, "onVideoMsgClick url is null, %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(175544);
      return;
      label470:
      localObject1 = new v();
      localx.dHc = ((k.b)localObject3).eag;
      localx.iAg = ((k.b)localObject3).eah;
      ((v)localObject1).url = ((k.b)localObject3).url;
      ((v)localObject1).title = ((k.b)localObject3).title;
      ((v)localObject1).iAq = ((k.b)localObject3).description;
      ((v)localObject1).iAo = ((k.b)localObject3).thumburl;
      localObject3 = (com.tencent.mm.ag.e)((k.b)localObject3).as(com.tencent.mm.ag.e.class);
      if (localObject3 == null)
      {
        Log.w(TAG, "piece content fail");
        localObject1 = null;
      }
      else
      {
        ((v)localObject1).vid = ((com.tencent.mm.ag.e)localObject3).vid;
        ((v)localObject1).time = ((com.tencent.mm.ag.e)localObject3).iwd;
        ((v)localObject1).type = ((com.tencent.mm.ag.e)localObject3).iwc;
        ((v)localObject1).iwf = ((com.tencent.mm.ag.e)localObject3).iwf;
        ((v)localObject1).iAs = ((com.tencent.mm.ag.e)localObject3).duration;
        ((v)localObject1).videoWidth = ((com.tencent.mm.ag.e)localObject3).videoWidth;
        ((v)localObject1).videoHeight = ((com.tencent.mm.ag.e)localObject3).videoHeight;
        localx.iwg = ((com.tencent.mm.ag.e)localObject3).iwg;
        continue;
        label656:
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(((ca)localObject2).ajL(), ((ca)localObject2).getContent());
        if ((localObject1 == null) || (Util.isNullOrNil((List)((u)localObject1).iAd)))
        {
          Log.w(TAG, "getBizReaderItem reader is null");
          localObject1 = null;
        }
        else
        {
          localx.dHc = ((u)localObject1).eag;
          localx.iAg = ((u)localObject1).eah;
          if (localx.iAf >= ((u)localObject1).iAd.size()) {
            localObject1 = (v)((u)localObject1).iAd.get(0);
          } else {
            localObject1 = (v)((u)localObject1).iAd.get(localx.iAf);
          }
        }
      }
    }
    localIntent.putExtra("srcUsername", localx.ajO());
    localIntent.putExtra("srcDisplayname", localx.iAg);
    paramInt = (int)(System.currentTimeMillis() / 1000L);
    if (i == 90)
    {
      paramBundle = com.tencent.mm.plugin.brandservice.b.c.pne;
      com.tencent.mm.plugin.brandservice.b.c.t(4, localx.ajO(), localx.iAi.url);
    }
    Object localObject2 = ((b)g.af(b.class)).d(localx.iAi.url, i, j, paramInt);
    p.g(localObject2, "redirectUrl");
    p.g(localObject3, "autoPlayId");
    paramInt = ab.getSessionId();
    if ((localObject2 == null) || (!kotlin.n.n.e((CharSequence)localObject2, (CharSequence)"mp.weixin.qq.com")) || ((paramInt <= 0) && (Util.isNullOrNil((String)localObject3))))
    {
      if (!((b)g.af(b.class)).a(paramContext, (String)localObject2, localx.iAi.type, i, j, localIntent))
      {
        localIntent.putExtra("rawUrl", localx.iAi.url);
        com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(175544);
      return;
    }
    Object localObject1 = "";
    paramInt = kotlin.n.n.a((CharSequence)localObject2, "#", 0, false, 6);
    if (paramInt > 0)
    {
      paramBundle = ((String)localObject2).substring(0, paramInt);
      p.g(paramBundle, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = ((String)localObject2).substring(paramInt);
      p.g(localObject1, "(this as java.lang.String).substring(startIndex)");
      label1074:
      if (kotlin.n.n.e((CharSequence)localObject2, (CharSequence)"?")) {
        break label1210;
      }
      paramBundle = paramBundle + "?";
    }
    label1210:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!Util.isNullOrNil((String)localObject3)) {
        paramBundle = paramBundle + "&autoplayid=" + (String)localObject3;
      }
      for (;;)
      {
        if (paramInt != 0) {
          paramBundle = kotlin.n.n.j(paramBundle, "?&", "?", false);
        }
        for (;;)
        {
          localObject2 = paramBundle + (String)localObject1;
          break;
          paramBundle = (Bundle)localObject2;
          break label1074;
        }
      }
    }
  }
  
  public static final void a(Context paramContext, x paramx, String paramString)
  {
    AppMethodBeat.i(7313);
    p.h(paramContext, "context");
    p.h(paramx, "msgInfo");
    p.h(paramString, "url");
    Intent localIntent = new Intent();
    localIntent.putExtra("KPublisherId", paramx.iAh);
    localIntent.putExtra("pre_username", paramx.ajO());
    localIntent.putExtra("preUsername", paramx.ajO());
    localIntent.putExtra("preChatName", paramx.ajO());
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("geta8key_username", paramx.ajO());
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(7313);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7316);
    p.h(paramString, "coverUrl");
    p.h(paramx, "msgInfo");
    Log.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if ((Util.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(7316);
      return;
    }
    paramImageView.setContentDescription((CharSequence)paramImageView.getContext().getString(2131757392));
    com.tencent.mm.av.a.a locala = com.tencent.mm.av.a.a.bdb();
    c.a locala1 = new c.a().bdp().dr(paramInt1, paramInt2).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(4)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(4));
    p.h(paramx, "msgInfo");
    if (!Util.isNullOrNil((List)paramx.iAj))
    {
      paramx = paramx.iAj.get(0);
      p.g(paramx, "msgInfo.coverPath[0]");
    }
    for (paramx = (String)paramx;; paramx = "")
    {
      locala.a(paramString, paramImageView, locala1.OS(paramx).bdv(), null, (h)new m(4, paramInt1, paramInt2, null, null));
      AppMethodBeat.o(7316);
      return;
    }
  }
  
  public static final int aiT(String paramString)
  {
    AppMethodBeat.i(7314);
    p.h(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("bizVideoPlayTime");
    p.g(localMultiProcessMMKV, "mmkv");
    String[] arrayOfString = localMultiProcessMMKV.allKeys();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        p.g(str, "it");
        if (!kotlin.n.n.K(str, "PlayTime", false))
        {
          l = localMultiProcessMMKV.decodeLong(str, 0L);
          if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
          {
            localMultiProcessMMKV.remove(str);
            localMultiProcessMMKV.remove(str + ":PlayTime");
          }
        }
        i += 1;
      }
    }
    long l = localMultiProcessMMKV.decodeLong(paramString, 0L);
    if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
    {
      AppMethodBeat.o(7314);
      return 0;
    }
    int i = localMultiProcessMMKV.decodeInt(paramString + ":PlayTime", 0);
    AppMethodBeat.o(7314);
    return i;
  }
  
  public static final void cL(String paramString, int paramInt)
  {
    AppMethodBeat.i(7315);
    p.h(paramString, "key");
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("bizVideoPlayTime");
    localMultiProcessMMKV.encode(paramString, System.currentTimeMillis());
    localMultiProcessMMKV.encode(paramString + ":PlayTime", paramInt);
    AppMethodBeat.o(7315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l
 * JD-Core Version:    0.7.0.1
 */