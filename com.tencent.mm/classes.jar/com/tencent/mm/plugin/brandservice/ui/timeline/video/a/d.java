package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.aj.x;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.f.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "bizVideoPlayTime", "maxVideoPlaySaveTime", "addAutoPlayId", "url", "autoPlayId", "clearInvalidLastPlayTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "bundle", "Landroid/os/Bundle;", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class d
{
  private static final String TAG = "MicroMsg.BizVideoUtil";
  public static final d sTd;
  
  static
  {
    AppMethodBeat.i(7319);
    sTd = new d();
    TAG = "MicroMsg.BizVideoUtil";
    AppMethodBeat.o(7319);
  }
  
  public static final void a(Context paramContext, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(175544);
    p.k(paramContext, "context");
    p.k(paramBundle, "bundle");
    Intent localIntent = new Intent();
    localIntent.putExtra("biz_video_msg_id", paramLong1);
    localIntent.putExtra("biz_video_msg_svr_id", paramLong2);
    localIntent.putExtra("KPublisherId", "msg_".concat(String.valueOf(paramLong2)));
    localIntent.putExtra("biz_video_msg_index", paramInt);
    localIntent.putExtra("biz_video_session_id", ab.getSessionId());
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("webpageTitle", paramBundle.getString("webpageTitle"));
    p.k(localIntent, "intent");
    x localx = new x();
    localx.lpD = localIntent.getStringExtra("KPublisherId");
    localx.fAg = localIntent.getStringExtra("sns_local_id");
    localx.msgId = localIntent.getLongExtra("biz_video_msg_id", -1L);
    Object localObject1;
    Object localObject3;
    if (localx.msgId > -1L)
    {
      localObject1 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      p.j(localObject1, "MMKernel.service<IMessen…engerStorage::class.java)");
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).eSe().Oq(localx.msgId);
      p.j(localObject2, "msgInfo");
      if ((((ca)localObject2).hwA()) || (((ca)localObject2).erk()))
      {
        p.k(localIntent, "intent");
        p.k(localx, "mpMsgInfo");
        p.k(localObject2, "msgInfo");
        localx.fNu = localIntent.getLongExtra("biz_video_msg_svr_id", 0L);
        localx.lpB = localIntent.getIntExtra("biz_video_msg_index", 0);
        localx.userName = ((ca)localObject2).apJ();
        p.k(localObject2, "msgInfo");
        p.k(localx, "mpMsgInfo");
        if ((((ca)localObject2).hwA()) || (!((ca)localObject2).erk())) {
          break label647;
        }
        p.k(localObject2, "msgInfo");
        p.k(localx, "mpMsgInfo");
        localObject3 = k.b.OQ(((ca)localObject2).getContent());
        if (localObject3 != null) {
          break label461;
        }
        Log.w(TAG, "parse content fail");
        localObject1 = null;
      }
    }
    int i;
    int j;
    for (;;)
    {
      localx.lpE = ((v)localObject1);
      localx.type = ((ca)localObject2).getType();
      localx.v(localIntent);
      i = paramBundle.getInt(f.b.VRT, 10000);
      j = paramBundle.getInt(f.b.VRU, 10000);
      localObject3 = paramBundle.getString("biz_video_autoplay_id", "");
      if (!Util.isNullOrNil(localx.lpE.url)) {
        break;
      }
      Log.e(TAG, "onVideoMsgClick url is null, %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(175544);
      return;
      label461:
      localObject1 = new v();
      localx.fzT = ((k.b)localObject3).fUd;
      localx.lpC = ((k.b)localObject3).fUe;
      ((v)localObject1).url = ((k.b)localObject3).url;
      ((v)localObject1).title = ((k.b)localObject3).title;
      ((v)localObject1).lpM = ((k.b)localObject3).description;
      ((v)localObject1).lpK = ((k.b)localObject3).thumburl;
      localObject3 = (e)((k.b)localObject3).ar(e.class);
      if (localObject3 == null)
      {
        Log.w(TAG, "piece content fail");
        localObject1 = null;
      }
      else
      {
        ((v)localObject1).vid = ((e)localObject3).vid;
        ((v)localObject1).time = ((e)localObject3).llq;
        ((v)localObject1).type = ((e)localObject3).llp;
        ((v)localObject1).lls = ((e)localObject3).lls;
        ((v)localObject1).lpO = ((e)localObject3).duration;
        ((v)localObject1).videoWidth = ((e)localObject3).videoWidth;
        ((v)localObject1).videoHeight = ((e)localObject3).videoHeight;
        localx.llt = ((e)localObject3).llt;
        continue;
        label647:
        localObject1 = ((a)h.ae(a.class)).b(((ca)localObject2).apG(), ((ca)localObject2).getContent());
        if ((localObject1 == null) || (Util.isNullOrNil((List)((u)localObject1).lpz)))
        {
          Log.w(TAG, "getBizReaderItem reader is null");
          localObject1 = null;
        }
        else
        {
          localx.fzT = ((u)localObject1).fUd;
          localx.lpC = ((u)localObject1).fUe;
          if (localx.lpB >= ((u)localObject1).lpz.size()) {
            localObject1 = (v)((u)localObject1).lpz.get(0);
          } else {
            localObject1 = (v)((u)localObject1).lpz.get(localx.lpB);
          }
        }
      }
    }
    localIntent.putExtra("srcUsername", localx.apJ());
    localIntent.putExtra("srcDisplayname", localx.lpC);
    paramInt = (int)(System.currentTimeMillis() / 1000L);
    if (i == 90)
    {
      paramBundle = com.tencent.mm.plugin.brandservice.b.d.swc;
      com.tencent.mm.plugin.brandservice.b.d.t(4, localx.apJ(), localx.lpE.url);
    }
    Object localObject2 = ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e(localx.lpE.url, i, j, paramInt);
    p.j(localObject2, "redirectUrl");
    p.j(localObject3, "autoPlayId");
    paramInt = ab.getSessionId();
    if ((localObject2 == null) || (!kotlin.n.n.g((CharSequence)localObject2, (CharSequence)"mp.weixin.qq.com")) || ((paramInt <= 0) && (Util.isNullOrNil((String)localObject3))))
    {
      if ((((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(i)) && (((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramContext, (String)localObject2, localx.lpE.type, i, j, localIntent)))
      {
        paramInt = 1;
        label990:
        if (paramInt == 0)
        {
          localIntent.putExtra("rawUrl", (String)localObject2);
          com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(175544);
      }
    }
    else
    {
      localObject1 = "";
      paramInt = kotlin.n.n.a((CharSequence)localObject2, "#", 0, false, 6);
      if (paramInt > 0)
      {
        paramBundle = ((String)localObject2).substring(0, paramInt);
        p.j(paramBundle, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((String)localObject2).substring(paramInt);
        p.j(localObject1, "(this as java.lang.String).substring(startIndex)");
        label1086:
        if (kotlin.n.n.g((CharSequence)localObject2, (CharSequence)"?")) {
          break label1228;
        }
        paramBundle = paramBundle + "?";
      }
    }
    label1228:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!Util.isNullOrNil((String)localObject3)) {
        paramBundle = paramBundle + "&autoplayid=" + (String)localObject3;
      }
      for (;;)
      {
        if (paramInt != 0) {
          paramBundle = kotlin.n.n.l(paramBundle, "?&", "?", false);
        }
        for (;;)
        {
          localObject2 = paramBundle + (String)localObject1;
          break;
          paramBundle = (Bundle)localObject2;
          break label1086;
          paramInt = 0;
          break label990;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d
 * JD-Core Version:    0.7.0.1
 */