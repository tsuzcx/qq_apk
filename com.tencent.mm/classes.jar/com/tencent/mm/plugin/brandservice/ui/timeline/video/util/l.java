package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.ah.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.e.b;
import d.g.b.p;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "bizVideoPlayTime", "maxVideoPlaySaveTime", "clearInvalidLastPlayTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "url", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "bundle", "Landroid/os/Bundle;", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class l
{
  private static final String TAG = "MicroMsg.BizVideoUtil";
  public static final l oxU;
  
  static
  {
    AppMethodBeat.i(7319);
    oxU = new l();
    TAG = "MicroMsg.BizVideoUtil";
    AppMethodBeat.o(7319);
  }
  
  public static final String O(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(7312);
    p.h(paramContext, "context");
    if (paramInt < 10000)
    {
      AppMethodBeat.o(7312);
      return String.valueOf(paramInt);
    }
    String str = ad.fom();
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
  
  public static final int YN(String paramString)
  {
    AppMethodBeat.i(7314);
    p.h(paramString, "key");
    ay localay = ay.aRW("bizVideoPlayTime");
    p.g(localay, "mmkv");
    String[] arrayOfString = localay.allKeys();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        p.g(str, "it");
        if (!d.n.n.nG(str, "PlayTime"))
        {
          l = localay.decodeLong(str, 0L);
          if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
          {
            localay.remove(str);
            localay.remove(str + ":PlayTime");
          }
        }
        i += 1;
      }
    }
    long l = localay.decodeLong(paramString, 0L);
    if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
    {
      AppMethodBeat.o(7314);
      return 0;
    }
    int i = localay.decodeInt(paramString + ":PlayTime", 0);
    AppMethodBeat.o(7314);
    return i;
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
    localIntent.putExtra("biz_video_session_id", y.getSessionId());
    localIntent.putExtras(paramBundle);
    p.h(localIntent, "intent");
    x localx = new x();
    localx.hFX = localIntent.getStringExtra("KPublisherId");
    localx.dqc = localIntent.getStringExtra("sns_local_id");
    localx.msgId = localIntent.getLongExtra("biz_video_msg_id", -1L);
    Object localObject1;
    bv localbv;
    Object localObject2;
    if (localx.msgId > -1L)
    {
      localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
      localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).doJ().ys(localx.msgId);
      p.g(localbv, "msgInfo");
      if ((localbv.fta()) || (localbv.cVH()))
      {
        p.h(localIntent, "intent");
        p.h(localx, "mpMsgInfo");
        p.h(localbv, "msgInfo");
        localx.dCd = localIntent.getLongExtra("biz_video_msg_svr_id", 0L);
        localx.hFV = localIntent.getIntExtra("biz_video_msg_index", 0);
        localx.userName = localbv.Wa();
        p.h(localbv, "msgInfo");
        p.h(localx, "mpMsgInfo");
        if ((localbv.fta()) || (!localbv.cVH())) {
          break label630;
        }
        p.h(localbv, "msgInfo");
        p.h(localx, "mpMsgInfo");
        localObject2 = k.b.zb(localbv.getContent());
        if (localObject2 != null) {
          break label444;
        }
        ae.w(TAG, "parse content fail");
        localObject1 = null;
      }
    }
    int i;
    for (;;)
    {
      localx.hFY = ((v)localObject1);
      localx.type = localbv.getType();
      localx.t(localIntent);
      paramInt = paramBundle.getInt(e.b.JoV, 10000);
      i = paramBundle.getInt(e.b.JoW, 10000);
      if (!bu.isNullOrNil(localx.hFY.url)) {
        break;
      }
      ae.e(TAG, "onVideoMsgClick url is null, %s", new Object[] { bu.fpN() });
      AppMethodBeat.o(175544);
      return;
      label444:
      localObject1 = new v();
      localx.dpP = ((k.b)localObject2).dIt;
      localx.hFW = ((k.b)localObject2).dIu;
      ((v)localObject1).url = ((k.b)localObject2).url;
      ((v)localObject1).title = ((k.b)localObject2).title;
      ((v)localObject1).hGg = ((k.b)localObject2).description;
      ((v)localObject1).hGe = ((k.b)localObject2).thumburl;
      localObject2 = (com.tencent.mm.ah.e)((k.b)localObject2).ao(com.tencent.mm.ah.e.class);
      if (localObject2 == null)
      {
        ae.w(TAG, "piece content fail");
        localObject1 = null;
      }
      else
      {
        ((v)localObject1).hCa = ((com.tencent.mm.ah.e)localObject2).hCa;
        ((v)localObject1).time = ((com.tencent.mm.ah.e)localObject2).hBW;
        ((v)localObject1).type = ((com.tencent.mm.ah.e)localObject2).hBV;
        ((v)localObject1).hBY = ((com.tencent.mm.ah.e)localObject2).hBY;
        ((v)localObject1).hGi = ((com.tencent.mm.ah.e)localObject2).duration;
        ((v)localObject1).videoWidth = ((com.tencent.mm.ah.e)localObject2).videoWidth;
        ((v)localObject1).videoHeight = ((com.tencent.mm.ah.e)localObject2).videoHeight;
        localx.hBZ = ((com.tencent.mm.ah.e)localObject2).hBZ;
        continue;
        label630:
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localbv.VX(), localbv.getContent());
        if ((localObject1 == null) || (bu.ht((List)((u)localObject1).hFT)))
        {
          ae.w(TAG, "getBizReaderItem reader is null");
          localObject1 = null;
        }
        else
        {
          localx.dpP = ((u)localObject1).dIt;
          localx.hFW = ((u)localObject1).dIu;
          if (localx.hFV >= ((u)localObject1).hFT.size()) {
            localObject1 = (v)((u)localObject1).hFT.get(0);
          } else {
            localObject1 = (v)((u)localObject1).hFT.get(localx.hFV);
          }
        }
      }
    }
    localIntent.putExtra("srcUsername", localx.Wa());
    localIntent.putExtra("srcDisplayname", localx.hFW);
    int j = (int)(System.currentTimeMillis() / 1000L);
    if (paramInt == 90)
    {
      paramBundle = com.tencent.mm.plugin.brandservice.b.c.och;
      com.tencent.mm.plugin.brandservice.b.c.s(4, localx.Wa(), localx.hFY.url);
    }
    paramBundle = ((b)g.ab(b.class)).d(localx.hFY.url, paramInt, i, j);
    if (!((b)g.ab(b.class)).a(paramContext, paramBundle, localx.hFY.type, paramInt, i, localIntent))
    {
      localIntent.putExtra("rawUrl", localx.hFY.url);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(175544);
  }
  
  public static final void a(Context paramContext, x paramx, String paramString)
  {
    AppMethodBeat.i(7313);
    p.h(paramContext, "context");
    p.h(paramx, "msgInfo");
    p.h(paramString, "url");
    Intent localIntent = new Intent();
    localIntent.putExtra("KPublisherId", paramx.hFX);
    localIntent.putExtra("pre_username", paramx.Wa());
    localIntent.putExtra("preUsername", paramx.Wa());
    localIntent.putExtra("preChatName", paramx.Wa());
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("geta8key_username", paramx.Wa());
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(7313);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7316);
    p.h(paramString, "coverUrl");
    p.h(paramx, "msgInfo");
    ae.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if ((bu.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(7316);
      return;
    }
    paramImageView.setContentDescription((CharSequence)paramImageView.getContext().getString(2131757186));
    com.tencent.mm.av.a.a locala = com.tencent.mm.av.a.a.aJh();
    c.a locala1 = new c.a().aJq().dh(paramInt1, paramInt2).a((com.tencent.mm.av.a.c.c)new com.tencent.mm.pluginsdk.ui.applet.n(4)).a((com.tencent.mm.av.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(4));
    p.h(paramx, "msgInfo");
    if (!bu.ht((List)paramx.hFZ))
    {
      paramx = paramx.hFZ.get(0);
      p.g(paramx, "msgInfo.coverPath[0]");
    }
    for (paramx = (String)paramx;; paramx = "")
    {
      locala.a(paramString, paramImageView, locala1.Gg(paramx).aJu(), null, (h)new m(4, paramInt1, paramInt2, null, null));
      AppMethodBeat.o(7316);
      return;
    }
  }
  
  public static final void cF(String paramString, int paramInt)
  {
    AppMethodBeat.i(7315);
    p.h(paramString, "key");
    ay localay = ay.aRW("bizVideoPlayTime");
    localay.encode(paramString, System.currentTimeMillis());
    localay.encode(paramString + ":PlayTime", paramInt);
    AppMethodBeat.o(7315);
  }
  
  public static boolean z(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7318);
    if (paramBoolean)
    {
      AppMethodBeat.o(7318);
      return true;
    }
    ae.i(TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt) });
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