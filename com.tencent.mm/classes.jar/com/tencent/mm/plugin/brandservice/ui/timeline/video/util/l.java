package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.v;
import com.tencent.mm.ai.x;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.e.b;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "bizVideoPlayTime", "maxVideoPlaySaveTime", "clearInvalidLastPlayTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "url", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "bundle", "Landroid/os/Bundle;", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class l
{
  private static final String TAG = "MicroMsg.BizVideoUtil";
  public static final l nlS;
  
  static
  {
    AppMethodBeat.i(7319);
    nlS = new l();
    TAG = "MicroMsg.BizVideoUtil";
    AppMethodBeat.o(7319);
  }
  
  public static final String J(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(7312);
    d.g.b.k.h(paramContext, "context");
    if (paramInt < 10000)
    {
      AppMethodBeat.o(7312);
      return String.valueOf(paramInt);
    }
    String str = ac.eFu();
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
  
  public static final int Qe(String paramString)
  {
    AppMethodBeat.i(7314);
    d.g.b.k.h(paramString, "key");
    ax localax = ax.aFC("bizVideoPlayTime");
    d.g.b.k.g(localax, "mmkv");
    String[] arrayOfString = localax.allKeys();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        d.g.b.k.g(str, "it");
        if (!d.n.n.mB(str, "PlayTime"))
        {
          l = localax.decodeLong(str, 0L);
          if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
          {
            localax.remove(str);
            localax.remove(str + ":PlayTime");
          }
        }
        i += 1;
      }
    }
    long l = localax.decodeLong(paramString, 0L);
    if (Math.abs(System.currentTimeMillis() - l) > 7200000L)
    {
      AppMethodBeat.o(7314);
      return 0;
    }
    int i = localax.decodeInt(paramString + ":PlayTime", 0);
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
    localIntent.putExtra("biz_video_session_id", com.tencent.mm.storage.u.getSessionId());
    localIntent.putExtras(paramBundle);
    d.g.b.k.h(localIntent, "intent");
    x localx = new x();
    localx.gKw = localIntent.getStringExtra("KPublisherId");
    localx.dgg = localIntent.getStringExtra("sns_local_id");
    localx.msgId = localIntent.getLongExtra("biz_video_msg_id", -1L);
    Object localObject1;
    bl localbl;
    Object localObject2;
    if (localx.msgId > -1L)
    {
      localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
      localbl = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).cOI().rm(localx.msgId);
      d.g.b.k.g(localbl, "msgInfo");
      if ((localbl.eJL()) || (localbl.cxB()))
      {
        d.g.b.k.h(localIntent, "intent");
        d.g.b.k.h(localx, "mpMsgInfo");
        d.g.b.k.h(localbl, "msgInfo");
        localx.drA = localIntent.getLongExtra("biz_video_msg_svr_id", 0L);
        localx.gKu = localIntent.getIntExtra("biz_video_msg_index", 0);
        localx.userName = localbl.SI();
        d.g.b.k.h(localbl, "msgInfo");
        d.g.b.k.h(localx, "mpMsgInfo");
        if ((localbl.eJL()) || (!localbl.cxB())) {
          break label630;
        }
        d.g.b.k.h(localbl, "msgInfo");
        d.g.b.k.h(localx, "mpMsgInfo");
        localObject2 = k.b.rx(localbl.getContent());
        if (localObject2 != null) {
          break label444;
        }
        ad.w(TAG, "parse content fail");
        localObject1 = null;
      }
    }
    int i;
    for (;;)
    {
      localx.gKx = ((v)localObject1);
      localx.type = localbl.getType();
      localx.t(localIntent);
      paramInt = paramBundle.getInt(e.b.FHP, 10000);
      i = paramBundle.getInt(e.b.FHQ, 10000);
      if (!bt.isNullOrNil(localx.gKx.url)) {
        break;
      }
      ad.e(TAG, "onVideoMsgClick url is null, %s", new Object[] { bt.eGN() });
      AppMethodBeat.o(175544);
      return;
      label444:
      localObject1 = new v();
      localx.dfT = ((k.b)localObject2).dxz;
      localx.gKv = ((k.b)localObject2).dxA;
      ((v)localObject1).url = ((k.b)localObject2).url;
      ((v)localObject1).title = ((k.b)localObject2).title;
      ((v)localObject1).gKF = ((k.b)localObject2).description;
      ((v)localObject1).gKD = ((k.b)localObject2).thumburl;
      localObject2 = (com.tencent.mm.ai.e)((k.b)localObject2).ao(com.tencent.mm.ai.e.class);
      if (localObject2 == null)
      {
        ad.w(TAG, "piece content fail");
        localObject1 = null;
      }
      else
      {
        ((v)localObject1).gGC = ((com.tencent.mm.ai.e)localObject2).gGC;
        ((v)localObject1).time = ((com.tencent.mm.ai.e)localObject2).gGy;
        ((v)localObject1).type = ((com.tencent.mm.ai.e)localObject2).gGx;
        ((v)localObject1).gGA = ((com.tencent.mm.ai.e)localObject2).gGA;
        ((v)localObject1).gKH = ((com.tencent.mm.ai.e)localObject2).duration;
        ((v)localObject1).videoWidth = ((com.tencent.mm.ai.e)localObject2).videoWidth;
        ((v)localObject1).videoHeight = ((com.tencent.mm.ai.e)localObject2).videoHeight;
        localx.gGB = ((com.tencent.mm.ai.e)localObject2).gGB;
        continue;
        label630:
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localbl.SF(), localbl.getContent());
        if ((localObject1 == null) || (bt.gL((List)((com.tencent.mm.ai.u)localObject1).gKs)))
        {
          ad.w(TAG, "getBizReaderItem reader is null");
          localObject1 = null;
        }
        else
        {
          localx.dfT = ((com.tencent.mm.ai.u)localObject1).dxz;
          localx.gKv = ((com.tencent.mm.ai.u)localObject1).dxA;
          if (localx.gKu >= ((com.tencent.mm.ai.u)localObject1).gKs.size()) {
            localObject1 = (v)((com.tencent.mm.ai.u)localObject1).gKs.get(0);
          } else {
            localObject1 = (v)((com.tencent.mm.ai.u)localObject1).gKs.get(localx.gKu);
          }
        }
      }
    }
    localIntent.putExtra("srcUsername", localx.SI());
    localIntent.putExtra("srcDisplayname", localx.gKv);
    int j = (int)(System.currentTimeMillis() / 1000L);
    paramBundle = ((b)g.ab(b.class)).d(localx.gKx.url, paramInt, i, j);
    if (!((b)g.ab(b.class)).a(paramContext, paramBundle, localx.gKx.type, paramInt, i, localIntent))
    {
      localIntent.putExtra("rawUrl", localx.gKx.url);
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
    localIntent.putExtra("KPublisherId", paramx.gKw);
    localIntent.putExtra("pre_username", paramx.SI());
    localIntent.putExtra("preUsername", paramx.SI());
    localIntent.putExtra("preChatName", paramx.SI());
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("geta8key_username", paramx.SI());
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(7313);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(7316);
    d.g.b.k.h(paramString, "coverUrl");
    d.g.b.k.h(paramx, "msgInfo");
    ad.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if ((bt.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(7316);
      return;
    }
    paramImageView.setContentDescription((CharSequence)paramImageView.getContext().getString(2131757186));
    com.tencent.mm.aw.a.a locala = com.tencent.mm.aw.a.a.ayO();
    c.a locala1 = new c.a().ayY().de(paramInt1, paramInt2).a((c)new com.tencent.mm.pluginsdk.ui.applet.n(4)).a((com.tencent.mm.aw.a.c.a)new com.tencent.mm.pluginsdk.ui.applet.e(4));
    d.g.b.k.h(paramx, "msgInfo");
    if (!bt.gL((List)paramx.gKy))
    {
      paramx = paramx.gKy.get(0);
      d.g.b.k.g(paramx, "msgInfo.coverPath[0]");
    }
    for (paramx = (String)paramx;; paramx = "")
    {
      locala.a(paramString, paramImageView, locala1.yv(paramx).azc(), null, (com.tencent.mm.aw.a.c.h)new m(4, paramInt1, paramInt2, null, null));
      AppMethodBeat.o(7316);
      return;
    }
  }
  
  public static final void ct(String paramString, int paramInt)
  {
    AppMethodBeat.i(7315);
    d.g.b.k.h(paramString, "key");
    ax localax = ax.aFC("bizVideoPlayTime");
    localax.encode(paramString, System.currentTimeMillis());
    localax.encode(paramString + ":PlayTime", paramInt);
    AppMethodBeat.o(7315);
  }
  
  public static boolean x(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(7318);
    if (paramBoolean)
    {
      AppMethodBeat.o(7318);
      return true;
    }
    ad.i(TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 1) || (paramInt == 0))
    {
      AppMethodBeat.o(7318);
      return true;
    }
    AppMethodBeat.o(7318);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l
 * JD-Core Version:    0.7.0.1
 */