package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.e;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.message.x;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.brandservice.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.f.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "bizVideoPlayTime", "maxVideoPlaySaveTime", "addAutoPlayId", "url", "autoPlayId", "clearInvalidLastPlayTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "bundle", "Landroid/os/Bundle;", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "width", "height", "setLastPlayTime", "time", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b vYs;
  
  static
  {
    AppMethodBeat.i(7319);
    vYs = new b();
    TAG = "MicroMsg.BizVideoUtil";
    AppMethodBeat.o(7319);
  }
  
  public static final void a(Context paramContext, long paramLong1, long paramLong2, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(175544);
    s.u(paramContext, "context");
    s.u(paramBundle, "bundle");
    Intent localIntent = new Intent();
    localIntent.putExtra("biz_video_msg_id", paramLong1);
    localIntent.putExtra("biz_video_msg_svr_id", paramLong2);
    localIntent.putExtra("KPublisherId", s.X("msg_", Long.valueOf(paramLong2)));
    localIntent.putExtra("biz_video_msg_index", paramInt);
    localIntent.putExtra("biz_video_session_id", ad.getSessionId());
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("webpageTitle", paramBundle.getString("webpageTitle"));
    s.u(localIntent, "intent");
    x localx = new x();
    localx.mso = localIntent.getStringExtra("KPublisherId");
    localx.hES = localIntent.getStringExtra("sns_local_id");
    localx.msgId = localIntent.getLongExtra("biz_video_msg_id", -1L);
    Object localObject3;
    Object localObject1;
    if (localx.msgId > -1L)
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(localx.msgId);
      if ((((cc)localObject2).iYe()) || (((cc)localObject2).fxR()))
      {
        s.s(localObject2, "msgInfo");
        s.u(localIntent, "intent");
        s.u(localx, "mpMsgInfo");
        s.u(localObject2, "msgInfo");
        localx.hTh = localIntent.getLongExtra("biz_video_msg_svr_id", 0L);
        localx.nUE = localIntent.getIntExtra("biz_video_msg_index", 0);
        localx.userName = ((fi)localObject2).field_talker;
        s.u(localObject2, "msgInfo");
        s.u(localx, "mpMsgInfo");
        if ((((cc)localObject2).iYe()) || (!((cc)localObject2).fxR())) {
          break label636;
        }
        s.u(localObject2, "msgInfo");
        s.u(localx, "mpMsgInfo");
        localObject3 = k.b.Hf(((fi)localObject2).field_content);
        if (localObject3 != null) {
          break label450;
        }
        Log.w(TAG, "parse content fail");
        localObject1 = null;
      }
    }
    int i;
    int j;
    for (;;)
    {
      localx.nUG = ((v)localObject1);
      localx.type = ((cc)localObject2).getType();
      localx.w(localIntent);
      i = paramBundle.getInt("biz_video_scene", 10000);
      j = paramBundle.getInt(f.b.adwc, 10000);
      localObject3 = paramBundle.getString("biz_video_autoplay_id", "");
      if (!Util.isNullOrNil(localx.nUG.url)) {
        break;
      }
      Log.e(TAG, "onVideoMsgClick url is null, %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(175544);
      return;
      label450:
      localObject1 = new v();
      localx.hEE = ((k.b)localObject3).iaa;
      localx.nUF = ((k.b)localObject3).iab;
      ((v)localObject1).url = ((k.b)localObject3).url;
      ((v)localObject1).title = ((k.b)localObject3).title;
      ((v)localObject1).nUO = ((k.b)localObject3).description;
      ((v)localObject1).nUM = ((k.b)localObject3).thumburl;
      localObject3 = (e)((k.b)localObject3).aK(e.class);
      if (localObject3 == null)
      {
        Log.w(TAG, "piece content fail");
        localObject1 = null;
      }
      else
      {
        ((v)localObject1).vid = ((e)localObject3).vid;
        ((v)localObject1).time = ((e)localObject3).nQn;
        ((v)localObject1).type = ((e)localObject3).nQm;
        ((v)localObject1).nQp = ((e)localObject3).nQp;
        ((v)localObject1).nUQ = ((e)localObject3).duration;
        ((v)localObject1).videoWidth = ((e)localObject3).videoWidth;
        ((v)localObject1).videoHeight = ((e)localObject3).videoHeight;
        localx.nQq = ((e)localObject3).nQq;
        continue;
        label636:
        localObject1 = ((a)h.ax(a.class)).c(((fi)localObject2).field_msgId, ((fi)localObject2).field_content);
        if ((localObject1 == null) || (Util.isNullOrNil((List)((u)localObject1).nUC)))
        {
          Log.w(TAG, "getBizReaderItem reader is null");
          localObject1 = null;
        }
        else
        {
          localx.hEE = ((u)localObject1).iaa;
          localx.nUF = ((u)localObject1).iab;
          if (localx.nUE >= ((u)localObject1).nUC.size()) {
            localObject1 = (v)((u)localObject1).nUC.get(0);
          } else {
            localObject1 = (v)((u)localObject1).nUC.get(localx.nUE);
          }
        }
      }
    }
    localIntent.putExtra("srcUsername", localx.aJK());
    localIntent.putExtra("srcDisplayname", localx.nUF);
    paramInt = (int)(System.currentTimeMillis() / 1000L);
    if (i == 90)
    {
      paramBundle = d.vBI;
      d.w(4, localx.aJK(), localx.nUG.url);
    }
    Object localObject2 = ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e(localx.nUG.url, i, j, paramInt);
    s.s(localObject2, "redirectUrl");
    s.s(localObject3, "autoPlayId");
    paramInt = ad.getSessionId();
    if ((localObject2 == null) || (!kotlin.n.n.i((CharSequence)localObject2, (CharSequence)"mp.weixin.qq.com")) || ((paramInt <= 0) && (Util.isNullOrNil((String)localObject3))))
    {
      if ((((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(i)) && (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramContext, (String)localObject2, localx.nUG.type, i, j, localIntent)))
      {
        paramInt = 1;
        label979:
        if (paramInt == 0)
        {
          localIntent.putExtra("rawUrl", (String)localObject2);
          com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
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
        s.s(paramBundle, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((String)localObject2).substring(paramInt);
        s.s(localObject1, "(this as java.lang.String).substring(startIndex)");
        label1075:
        if (kotlin.n.n.i((CharSequence)localObject2, (CharSequence)"?")) {
          break label1190;
        }
        paramBundle = s.X(paramBundle, "?");
      }
    }
    label1190:
    for (paramInt = 1;; paramInt = 0)
    {
      if (!Util.isNullOrNil((String)localObject3)) {
        paramBundle = paramBundle + "&autoplayid=" + (String)localObject3;
      }
      for (;;)
      {
        if (paramInt != 0) {
          paramBundle = kotlin.n.n.bV(paramBundle, "?&", "?");
        }
        for (;;)
        {
          localObject2 = s.X(paramBundle, localObject1);
          break;
          paramBundle = (Bundle)localObject2;
          break label1075;
          paramInt = 0;
          break label979;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b
 * JD-Core Version:    0.7.0.1
 */