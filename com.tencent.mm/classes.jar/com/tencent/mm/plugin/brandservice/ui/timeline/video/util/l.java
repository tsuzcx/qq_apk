package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.e.b;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "bizVideoPlayTime", "maxVideoPlaySaveTime", "clearInvalidLastPlayTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "url", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "bundle", "Landroid/os/Bundle;", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class l
{
  private static final String TAG = "MicroMsg.BizVideoUtil";
  public static final l nOS;
  
  static
  {
    AppMethodBeat.i(7319);
    nOS = new l();
    TAG = "MicroMsg.BizVideoUtil";
    AppMethodBeat.o(7319);
  }
  
  public static final String N(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(7312);
    d.g.b.k.h(paramContext, "context");
    if (paramInt < 10000)
    {
      AppMethodBeat.o(7312);
      return String.valueOf(paramInt);
    }
    String str = ab.eUO();
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
          paramContext = paramContext.getString(2131761338);
          if (paramInt < 100000) {
            break label171;
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
        label171:
        paramContext = paramInt / 10000 + '.' + paramInt % 10000 / 1000 + paramContext;
        AppMethodBeat.o(7312);
        return paramContext;
      }
    }
    paramContext = paramInt / 1000 + 'k';
    AppMethodBeat.o(7312);
    return paramContext;
  }
  
  public static final int Uq(String paramString)
  {
    AppMethodBeat.i(7314);
    d.g.b.k.h(paramString, "key");
    aw localaw = aw.aKT("bizVideoPlayTime");
    d.g.b.k.g(localaw, "mmkv");
    String[] arrayOfString = localaw.allKeys();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        d.g.b.k.g(str, "it");
        if (!d.n.n.nc(str, "PlayTime"))
        {
          l = localaw.decodeLong(str, 0L);
          if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
          {
            localaw.remove(str);
            localaw.remove(str + ":PlayTime");
          }
        }
        i += 1;
      }
    }
    long l = localaw.decodeLong(paramString, 0L);
    if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
    {
      AppMethodBeat.o(7314);
      return 0;
    }
    int i = localaw.decodeInt(paramString + ":PlayTime", 0);
    AppMethodBeat.o(7314);
    return i;
  }
  
  public static final void a(Context paramContext, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(175544);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramBundle, "bundle");
    Intent localIntent = new Intent();
    localIntent.putExtra("biz_video_msg_id", paramLong1);
    localIntent.putExtra("biz_video_msg_svr_id", paramLong2);
    localIntent.putExtra("KPublisherId", "msg_".concat(String.valueOf(paramLong2)));
    localIntent.putExtra("biz_video_msg_index", paramInt);
    localIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.v.getSessionId());
    localIntent.putExtras(paramBundle);
    d.g.b.k.h(localIntent, "intent");
    x localx = new x();
    localx.hkW = localIntent.getStringExtra("KPublisherId");
    localx.ddB = localIntent.getStringExtra("sns_local_id");
    localx.msgId = localIntent.getLongExtra("biz_video_msg_id", -1L);
    Object localObject1;
    bo localbo;
    Object localObject2;
    if (localx.msgId > -1L)
    {
      localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
      localbo = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).dcr().vP(localx.msgId);
      d.g.b.k.g(localbo, "msgInfo");
      if ((localbo.eZj()) || (localbo.cKN()))
      {
        d.g.b.k.h(localIntent, "intent");
        d.g.b.k.h(localx, "mpMsgInfo");
        d.g.b.k.h(localbo, "msgInfo");
        localx.dpl = localIntent.getLongExtra("biz_video_msg_svr_id", 0L);
        localx.hkU = localIntent.getIntExtra("biz_video_msg_index", 0);
        localx.userName = localbo.TC();
        d.g.b.k.h(localbo, "msgInfo");
        d.g.b.k.h(localx, "mpMsgInfo");
        if ((localbo.eZj()) || (!localbo.cKN())) {
          break label630;
        }
        d.g.b.k.h(localbo, "msgInfo");
        d.g.b.k.h(localx, "mpMsgInfo");
        localObject2 = k.b.vA(localbo.getContent());
        if (localObject2 != null) {
          break label444;
        }
        ac.w(TAG, "parse content fail");
        localObject1 = null;
      }
    }
    int i;
    for (;;)
    {
      localx.hkX = ((com.tencent.mm.ah.v)localObject1);
      localx.type = localbo.getType();
      localx.t(localIntent);
      paramInt = paramBundle.getInt(e.b.HgX, 10000);
      i = paramBundle.getInt(e.b.HgY, 10000);
      if (!bs.isNullOrNil(localx.hkX.url)) {
        break;
      }
      ac.e(TAG, "onVideoMsgClick url is null, %s", new Object[] { bs.eWi() });
      AppMethodBeat.o(175544);
      return;
      label444:
      localObject1 = new com.tencent.mm.ah.v();
      localx.ddo = ((k.b)localObject2).dvl;
      localx.hkV = ((k.b)localObject2).dvm;
      ((com.tencent.mm.ah.v)localObject1).url = ((k.b)localObject2).url;
      ((com.tencent.mm.ah.v)localObject1).title = ((k.b)localObject2).title;
      ((com.tencent.mm.ah.v)localObject1).hlf = ((k.b)localObject2).description;
      ((com.tencent.mm.ah.v)localObject1).hld = ((k.b)localObject2).thumburl;
      localObject2 = (com.tencent.mm.ah.e)((k.b)localObject2).ao(com.tencent.mm.ah.e.class);
      if (localObject2 == null)
      {
        ac.w(TAG, "piece content fail");
        localObject1 = null;
      }
      else
      {
        ((com.tencent.mm.ah.v)localObject1).hhd = ((com.tencent.mm.ah.e)localObject2).hhd;
        ((com.tencent.mm.ah.v)localObject1).time = ((com.tencent.mm.ah.e)localObject2).hgZ;
        ((com.tencent.mm.ah.v)localObject1).type = ((com.tencent.mm.ah.e)localObject2).hgY;
        ((com.tencent.mm.ah.v)localObject1).hhb = ((com.tencent.mm.ah.e)localObject2).hhb;
        ((com.tencent.mm.ah.v)localObject1).hlh = ((com.tencent.mm.ah.e)localObject2).duration;
        ((com.tencent.mm.ah.v)localObject1).videoWidth = ((com.tencent.mm.ah.e)localObject2).videoWidth;
        ((com.tencent.mm.ah.v)localObject1).videoHeight = ((com.tencent.mm.ah.e)localObject2).videoHeight;
        localx.hhc = ((com.tencent.mm.ah.e)localObject2).hhc;
        continue;
        label630:
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localbo.Tz(), localbo.getContent());
        if ((localObject1 == null) || (bs.gY((List)((u)localObject1).hkS)))
        {
          ac.w(TAG, "getBizReaderItem reader is null");
          localObject1 = null;
        }
        else
        {
          localx.ddo = ((u)localObject1).dvl;
          localx.hkV = ((u)localObject1).dvm;
          if (localx.hkU >= ((u)localObject1).hkS.size()) {
            localObject1 = (com.tencent.mm.ah.v)((u)localObject1).hkS.get(0);
          } else {
            localObject1 = (com.tencent.mm.ah.v)((u)localObject1).hkS.get(localx.hkU);
          }
        }
      }
    }
    localIntent.putExtra("srcUsername", localx.TC());
    localIntent.putExtra("srcDisplayname", localx.hkV);
    int j = (int)(System.currentTimeMillis() / 1000L);
    if (paramInt == 90)
    {
      paramBundle = com.tencent.mm.plugin.brandservice.b.c.nva;
      com.tencent.mm.plugin.brandservice.b.c.s(4, localx.TC(), localx.hkX.url);
    }
    paramBundle = ((b)g.ab(b.class)).d(localx.hkX.url, paramInt, i, j);
    if (!((b)g.ab(b.class)).a(paramContext, paramBundle, localx.hkX.type, paramInt, i, localIntent))
    {
      localIntent.putExtra("rawUrl", localx.hkX.url);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(175544);
  }
  
  public static final void a(Context paramContext, x paramx, String paramString)
  {
    AppMethodBeat.i(7313);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramx, "msgInfo");
    d.g.b.k.h(paramString, "url");
    Intent localIntent = new Intent();
    localIntent.putExtra("KPublisherId", paramx.hkW);
    localIntent.putExtra("pre_username", paramx.TC());
    localIntent.putExtra("preUsername", paramx.TC());
    localIntent.putExtra("preChatName", paramx.TC());
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("geta8key_username", paramx.TC());
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(7313);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7316);
    d.g.b.k.h(paramString, "coverUrl");
    d.g.b.k.h(paramx, "msgInfo");
    ac.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if ((bs.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(7316);
      return;
    }
    paramImageView.setContentDescription((CharSequence)paramImageView.getContext().getString(2131757186));
    com.tencent.mm.av.a.a locala = com.tencent.mm.av.a.a.aFG();
    c.a locala1 = new c.a().aFP().de(paramInt1, paramInt2).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(4)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(4));
    d.g.b.k.h(paramx, "msgInfo");
    if (!bs.gY((List)paramx.hkY))
    {
      paramx = paramx.hkY.get(0);
      d.g.b.k.g(paramx, "msgInfo.coverPath[0]");
    }
    for (paramx = (String)paramx;; paramx = "")
    {
      locala.a(paramString, paramImageView, locala1.CA(paramx).aFT(), null, (com.tencent.mm.av.a.c.h)new m(4, paramInt1, paramInt2, null, null));
      AppMethodBeat.o(7316);
      return;
    }
  }
  
  public static final void cy(String paramString, int paramInt)
  {
    AppMethodBeat.i(7315);
    d.g.b.k.h(paramString, "key");
    aw localaw = aw.aKT("bizVideoPlayTime");
    localaw.encode(paramString, System.currentTimeMillis());
    localaw.encode(paramString + ":PlayTime", paramInt);
    AppMethodBeat.o(7315);
  }
  
  public static boolean y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7318);
    if (paramBoolean)
    {
      AppMethodBeat.o(7318);
      return true;
    }
    ac.i(TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 1) || (paramInt == 0))
    {
      AppMethodBeat.o(7318);
      return true;
    }
    AppMethodBeat.o(7318);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l
 * JD-Core Version:    0.7.0.1
 */