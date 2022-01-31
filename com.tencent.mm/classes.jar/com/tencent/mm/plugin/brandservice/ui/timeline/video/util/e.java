package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.l;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoUtil;", "", "()V", "REQUEST_CODE_APP_MSG", "", "REQUEST_SHARE_TO_TIME_LINE", "TAG", "", "maxVideoPlaySaveTime", "playTimeHashMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/VideoPlayTime;", "Lkotlin/collections/HashMap;", "convertMsgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "intent", "Landroid/content/Intent;", "mpMsgInfo", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "convertOtherMsgInfo", "msg", "getBizReaderItem", "Lcom/tencent/mm/message/BizReaderItem;", "getBizReaderItemFromAppMsg", "getLastPlayTime", "", "key", "getMPMsgInfo", "getNumStr", "context", "Landroid/content/Context;", "num", "getVideoFullCoverPath", "goToWebViewUI", "", "url", "isSIMFree", "", "isWifi", "simType", "onVideoMsgClick", "msgId", "", "msgSvrId", "msgIndex", "view", "Landroid/view/View;", "bundle", "Landroid/os/Bundle;", "left", "top", "width", "height", "setCoverByUrl", "cover", "Landroid/widget/ImageView;", "coverUrl", "setLastPlayTime", "time", "plugin-brandservice_release"})
public final class e
{
  private static final String TAG = "MicroMsg.BizVideoUtil";
  private static final HashMap<String, j> kie;
  public static final e kif;
  
  static
  {
    AppMethodBeat.i(15324);
    kif = new e();
    TAG = "MicroMsg.BizVideoUtil";
    kie = new HashMap();
    AppMethodBeat.o(15324);
  }
  
  public static final String H(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(15320);
    a.f.b.j.q(paramContext, "context");
    if (paramInt < 10000)
    {
      AppMethodBeat.o(15320);
      return String.valueOf(paramInt);
    }
    String str = aa.dsG();
    if (str == null) {}
    while (paramInt >= 100000)
    {
      AppMethodBeat.o(15320);
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
          paramContext = paramContext.getString(2131301629);
          if (paramInt < 100000) {
            break label171;
          }
          paramContext = "10" + paramContext + '+';
          AppMethodBeat.o(15320);
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
        AppMethodBeat.o(15320);
        return paramContext;
      }
    }
    paramContext = paramInt / 1000 + 'k';
    AppMethodBeat.o(15320);
    return paramContext;
  }
  
  public static final double Hu(String paramString)
  {
    AppMethodBeat.i(15322);
    a.f.b.j.q(paramString, "key");
    paramString = (j)kie.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(15322);
      return 0.0D;
    }
    if (System.currentTimeMillis() - paramString.kiO > 180000L)
    {
      AppMethodBeat.o(15322);
      return 0.0D;
    }
    double d = paramString.kiP;
    AppMethodBeat.o(15322);
    return d;
  }
  
  public static String a(com.tencent.mm.af.s params)
  {
    AppMethodBeat.i(152960);
    a.f.b.j.q(params, "msgInfo");
    if (!bo.es((List)params.fjE))
    {
      params = params.fjE.get(0);
      a.f.b.j.p(params, "msgInfo.coverPath[0]");
      params = (String)params;
      AppMethodBeat.o(152960);
      return params;
    }
    AppMethodBeat.o(152960);
    return "";
  }
  
  public static final void a(Context paramContext, long paramLong1, long paramLong2, int paramInt, View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(15318);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(paramView, "view");
    a.f.b.j.q(paramBundle, "bundle");
    Object localObject1 = new int[2];
    paramView.getLocationInWindow((int[])localObject1);
    int i = localObject1[0];
    int j = localObject1[1];
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("img_gallery_width", k);
    ((Intent)localObject1).putExtra("img_gallery_height", m);
    ((Intent)localObject1).putExtra("img_gallery_left", i);
    ((Intent)localObject1).putExtra("img_gallery_top", j);
    ab.d(TAG, "onVideoMsgClick left %d, top %d, w %d, h %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
    ((Intent)localObject1).putExtra("biz_video_msg_id", paramLong1);
    ((Intent)localObject1).putExtra("biz_video_msg_svr_index", paramLong2);
    ((Intent)localObject1).putExtra("KPublisherId", "msg_".concat(String.valueOf(paramLong2)));
    ((Intent)localObject1).putExtra("biz_video_msg_index", paramInt);
    ((Intent)localObject1).putExtra("biz_video_session_id", com.tencent.mm.storage.s.getSessionId());
    ((Intent)localObject1).putExtras(paramBundle);
    a.f.b.j.q(localObject1, "intent");
    com.tencent.mm.af.s locals = new com.tencent.mm.af.s();
    locals.fjC = ((Intent)localObject1).getStringExtra("KPublisherId");
    locals.crk = ((Intent)localObject1).getStringExtra("sns_local_id");
    locals.cpO = ((Intent)localObject1).getLongExtra("biz_video_msg_id", -1L);
    bi localbi;
    Object localObject2;
    if (locals.cpO > -1L)
    {
      paramView = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(paramView, "MMKernel.service<IMessen…engerStorage::class.java)");
      localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramView).bPQ().kB(locals.cpO);
      a.f.b.j.p(localbi, "msgInfo");
      if ((localbi.dvV()) || (localbi.bCn()))
      {
        a.f.b.j.q(localObject1, "intent");
        a.f.b.j.q(locals, "mpMsgInfo");
        a.f.b.j.q(localbi, "msgInfo");
        locals.cFn = ((Intent)localObject1).getLongExtra("biz_video_msg_svr_index", 0L);
        locals.fjA = ((Intent)localObject1).getIntExtra("biz_video_msg_index", 0);
        locals.userName = localbi.HD();
        a.f.b.j.q(localbi, "msgInfo");
        a.f.b.j.q(locals, "mpMsgInfo");
        if ((localbi.dvV()) || (!localbi.bCn())) {
          break label759;
        }
        a.f.b.j.q(localbi, "msgInfo");
        a.f.b.j.q(locals, "mpMsgInfo");
        localObject2 = j.b.mY(localbi.getContent());
        if (localObject2 != null) {
          break label583;
        }
        ab.w(TAG, "parse content fail");
        paramView = null;
      }
    }
    for (;;)
    {
      locals.fjD = paramView;
      locals.type = localbi.getType();
      locals.t((Intent)localObject1);
      paramInt = paramBundle.getInt("biz_video_scene", 10000);
      i = paramBundle.getInt("biz_video_subscene", 10000);
      if (!bo.isNullOrNil(locals.fjD.url)) {
        break;
      }
      ab.e(TAG, "onVideoMsgClick url is null, %s", new Object[] { bo.dtY() });
      AppMethodBeat.o(15318);
      return;
      label583:
      paramView = new q();
      locals.cqX = ((j.b)localObject2).cGN;
      locals.fjB = ((j.b)localObject2).cGO;
      paramView.url = ((j.b)localObject2).url;
      paramView.title = ((j.b)localObject2).title;
      paramView.fjL = ((j.b)localObject2).description;
      paramView.fjJ = ((j.b)localObject2).thumburl;
      localObject2 = (com.tencent.mm.af.e)((j.b)localObject2).R(com.tencent.mm.af.e.class);
      if (localObject2 == null)
      {
        ab.w(TAG, "piece content fail");
        paramView = null;
      }
      else
      {
        paramView.fgl = ((com.tencent.mm.af.e)localObject2).fgl;
        paramView.time = ((com.tencent.mm.af.e)localObject2).fgi;
        paramView.type = ((com.tencent.mm.af.e)localObject2).fgh;
        paramView.fjN = ((com.tencent.mm.af.e)localObject2).duration;
        paramView.videoWidth = ((com.tencent.mm.af.e)localObject2).videoWidth;
        paramView.videoHeight = ((com.tencent.mm.af.e)localObject2).videoHeight;
        locals.fgk = ((com.tencent.mm.af.e)localObject2).fgk;
        continue;
        label759:
        paramView = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(localbi.Hz(), localbi.getContent());
        if ((paramView == null) || (bo.es((List)paramView.fjy)))
        {
          ab.w(TAG, "getBizReaderItem reader is null");
          paramView = null;
        }
        else
        {
          locals.cqX = paramView.cGN;
          locals.fjB = paramView.cGO;
          if (locals.fjA >= paramView.fjy.size()) {
            paramView = (q)paramView.fjy.get(0);
          } else {
            paramView = (q)paramView.fjy.get(locals.fjA);
          }
        }
      }
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, locals.fjD.url, locals.fjD.type, true, paramInt, i, (Intent)localObject1))
    {
      ((Intent)localObject1).putExtra("rawUrl", locals.fjD.url);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
    AppMethodBeat.o(15318);
  }
  
  public static final void a(Context paramContext, com.tencent.mm.af.s params, String paramString)
  {
    AppMethodBeat.i(15321);
    a.f.b.j.q(paramContext, "context");
    a.f.b.j.q(params, "msgInfo");
    a.f.b.j.q(paramString, "url");
    Intent localIntent = new Intent();
    localIntent.putExtra("KPublisherId", params.fjC);
    localIntent.putExtra("pre_username", params.HD());
    localIntent.putExtra("preUsername", params.HD());
    localIntent.putExtra("preChatName", params.HD());
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("geta8key_username", params.HD());
    d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(15321);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, com.tencent.mm.af.s params)
  {
    AppMethodBeat.i(152959);
    a.f.b.j.q(paramString, "coverUrl");
    a.f.b.j.q(params, "msgInfo");
    ab.i(TAG, "setCover coverUrl=%s", new Object[] { paramString });
    if ((bo.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(152959);
      return;
    }
    paramImageView.setContentDescription((CharSequence)paramImageView.getContext().getString(2131298197));
    com.tencent.mm.at.a.a.ahM().a(paramString, paramImageView, new c.a().ahU().cx(paramInt1, paramInt2).a((com.tencent.mm.at.a.c.b)new f()).ty(a(params)).ahY(), null, (com.tencent.mm.at.a.c.g)new com.tencent.mm.pluginsdk.ui.applet.e(paramInt1, paramInt2, null, null));
    AppMethodBeat.o(152959);
  }
  
  public static final void e(String paramString, double paramDouble)
  {
    AppMethodBeat.i(15323);
    a.f.b.j.q(paramString, "key");
    ((Map)kie).put(paramString, new j(System.currentTimeMillis(), paramDouble));
    AppMethodBeat.o(15323);
  }
  
  public static boolean o(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(152961);
    if (paramBoolean)
    {
      AppMethodBeat.o(152961);
      return true;
    }
    ab.i(TAG, "simType: %s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 1) || (paramInt == 0))
    {
      AppMethodBeat.o(152961);
      return true;
    }
    AppMethodBeat.o(152961);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.e
 * JD-Core Version:    0.7.0.1
 */