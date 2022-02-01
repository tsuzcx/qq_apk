package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderExposeLogic;", "", "()V", "LIVE_EXPOSE_URL", "", "getLIVE_EXPOSE_URL", "()Ljava/lang/String;", "TAG", "getTAG", "exposeActivity", "", "context", "Landroid/content/Context;", "topicId", "", "exposeBgm", "groupId", "exposeFeed", "feedId", "commentId", "exposeScene", "", "exposeMegaVideoBullet", "bulletId", "liveExpose", "liveId", "username", "commentSeq", "scene", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "FinderExposeLogic";
  private static final String tUu = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&msgId=%s";
  public static final a tUv;
  
  static
  {
    AppMethodBeat.i(166010);
    tUv = new a();
    TAG = "FinderExposeLogic";
    tUu = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&msgId=%s";
    AppMethodBeat.o(166010);
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(244531);
    p.h(paramContext, "context");
    e.Cxv.idkeyStat(1278L, 8L, 1L, false);
    Object localObject1 = ae.SYK;
    localObject1 = String.format("https://" + WeChatHosts.domainString(2131761748) + "/security/readtemplate?t=weixin_report/w_type&scene=%s&wechat_real_lang=%s&content_ID=%s&comment_ID=%s", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt), LocaleUtil.getApplicationLanguage(), d.zs(paramLong1), d.zs(paramLong2) }, 4));
    p.g(localObject1, "java.lang.String.format(format, *args)");
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
    localObject1 = k.vfA;
    localObject1 = k.Fc(paramLong1);
    if (localObject1 != null)
    {
      localObject2 = ((FinderItem)localObject1).getFeedObject();
      String str = ((com.tencent.mm.plugin.expt.b.c)g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
      localObject1 = str + ',' + k.Fg(((FinderObject)localObject2).id) + ',' + ((FinderObject)localObject2).username + ',' + ((FinderObject)localObject2).recommendType + ',' + ((FinderItem)localObject1).getMediaType();
      Log.i(k.TAG, "18974 ".concat(String.valueOf(localObject1)));
      e.Cxv.kvStat(18974, (String)localObject1);
    }
    localObject1 = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    if (paramContext != null)
    {
      paramContext = FinderReporterUIC.b(paramContext);
      if (paramContext != null)
      {
        paramContext.cZR().Ex(paramLong1);
        AppMethodBeat.o(244531);
        return;
      }
    }
    AppMethodBeat.o(244531);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, Long paramLong1, int paramInt)
  {
    AppMethodBeat.i(244533);
    p.h(paramContext, "context");
    p.h(paramString, "username");
    Log.i(TAG, "liveExpose liveId:" + paramLong + ",username:" + paramString + ",commentSeq:" + paramLong1);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    Object localObject = ae.SYK;
    String str = tUu;
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
    paramString = String.format(str, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString, paramLong1 }, 4));
    p.g(paramString, "java.lang.String.format(format, *args)");
    localIntent.putExtra("rawUrl", paramString);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(244533);
  }
  
  public static void aC(Context paramContext, String paramString)
  {
    AppMethodBeat.i(244535);
    p.h(paramContext, "context");
    p.h(paramString, "groupId");
    Object localObject = ae.SYK;
    paramString = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=64&wechat_real_lang=%s&topic_wording=%s", Arrays.copyOf(new Object[] { LocaleUtil.getApplicationLanguage(), paramString }, 2));
    p.g(paramString, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramString);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(244535);
  }
  
  public static void i(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(244536);
    p.h(paramContext, "context");
    Object localObject = ae.SYK;
    localObject = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=68&topic_id=%s", Arrays.copyOf(new Object[] { d.zs(paramLong) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(244536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.a
 * JD-Core Version:    0.7.0.1
 */