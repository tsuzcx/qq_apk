package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderExposeLogic;", "", "()V", "LIVE_EXPOSE_URL", "", "getLIVE_EXPOSE_URL", "()Ljava/lang/String;", "TAG", "getTAG", "exposeActivity", "", "context", "Landroid/content/Context;", "topicId", "", "exposeBgm", "groupId", "exposeFeed", "feedId", "commentId", "exposeScene", "", "exposeMegaVideoBullet", "bulletId", "liveExpose", "liveId", "username", "commentSeq", "scene", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "FinderExposeLogic";
  private static final String xFp = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&msgId=%s";
  public static final a xFq;
  
  static
  {
    AppMethodBeat.i(166010);
    xFq = new a();
    TAG = "FinderExposeLogic";
    xFp = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&msgId=%s";
    AppMethodBeat.o(166010);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(290271);
    p.k(paramContext, "context");
    f.Iyx.idkeyStat(1278L, 8L, 1L, false);
    Object localObject1 = af.aaBG;
    localObject1 = String.format("https://" + WeChatHosts.domainString(b.j.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%s&wechat_real_lang=%s&content_ID=%s&comment_ID=%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt), LocaleUtil.getApplicationLanguage(), d.Fw(paramLong1), d.Fw(paramLong2) }, 4));
    p.j(localObject1, "java.lang.String.format(format, *args)");
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
    localObject1 = n.zWF;
    localObject1 = n.Hc(paramLong1);
    if (localObject1 != null)
    {
      localObject2 = ((FinderItem)localObject1).getFeedObject();
      String str = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
      localObject1 = str + ',' + n.Mp(((FinderObject)localObject2).id) + ',' + ((FinderObject)localObject2).username + ',' + ((FinderObject)localObject2).recommendType + ',' + ((FinderItem)localObject1).getMediaType();
      Log.i(n.TAG, "18974 ".concat(String.valueOf(localObject1)));
      f.Iyx.kvStat(18974, (String)localObject1);
    }
    localObject1 = aj.Bnu;
    paramContext = aj.a.fZ(paramContext);
    if (paramContext != null)
    {
      paramContext = aj.b(paramContext);
      if (paramContext != null)
      {
        paramContext.dpO().KM(paramLong1);
        AppMethodBeat.o(290271);
        return;
      }
    }
    AppMethodBeat.o(290271);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, Long paramLong1, int paramInt)
  {
    AppMethodBeat.i(290273);
    p.k(paramContext, "context");
    p.k(paramString, "username");
    Log.i(TAG, "liveExpose liveId:" + paramLong + ",username:" + paramString + ",commentSeq:" + paramLong1);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    Object localObject = af.aaBG;
    String str = xFp;
    if (paramLong1 != null)
    {
      localObject = String.valueOf(paramLong1.longValue());
      paramLong1 = (Long)localObject;
      if (localObject != null) {}
    }
    else
    {
      paramLong1 = "";
    }
    paramString = String.format(str, Arrays.copyOf(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong), paramString, paramLong1 }, 4));
    p.j(paramString, "java.lang.String.format(format, *args)");
    localIntent.putExtra("rawUrl", paramString);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(290273);
  }
  
  public static void aB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(290276);
    p.k(paramContext, "context");
    p.k(paramString, "groupId");
    Object localObject = af.aaBG;
    paramString = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=64&wechat_real_lang=%s&topic_wording=%s", Arrays.copyOf(new Object[] { LocaleUtil.getApplicationLanguage(), paramString }, 2));
    p.j(paramString, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramString);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(290276);
  }
  
  public static void i(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(290277);
    p.k(paramContext, "context");
    Object localObject = af.aaBG;
    localObject = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=68&topic_id=%s", Arrays.copyOf(new Object[] { d.Fw(paramLong) }, 1));
    p.j(localObject, "java.lang.String.format(format, *args)");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(290277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.a
 * JD-Core Version:    0.7.0.1
 */