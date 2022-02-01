package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderExposeLogic;", "", "()V", "LIVE_EXPOSE_URL", "", "getLIVE_EXPOSE_URL", "()Ljava/lang/String;", "TAG", "getTAG", "exposeActivity", "", "context", "Landroid/content/Context;", "topicId", "", "exposeBgm", "groupId", "exposeFeed", "feedId", "commentId", "exposeScene", "", "commentScene", "exposeMegaVideoBullet", "bulletId", "liveExpose", "liveId", "username", "commentSeq", "scene", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "liveRepalyExpose", "exposeUrl", "(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Long;I)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Bem;
  private static final String Ben;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(166010);
    Bem = new a();
    TAG = "FinderExposeLogic";
    Ben = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&msgId=%s";
    AppMethodBeat.o(166010);
  }
  
  public static void a(Context paramContext, long paramLong, String paramString, Long paramLong1, int paramInt)
  {
    AppMethodBeat.i(363741);
    s.u(paramContext, "context");
    s.u(paramString, "username");
    Log.i(TAG, "liveExpose liveId:" + paramLong + ",username:" + paramString + ",commentSeq:" + paramLong1);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    Object localObject = am.aixg;
    String str = Ben;
    if (paramLong1 == null) {
      paramLong1 = "";
    }
    for (;;)
    {
      paramString = String.format(str, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString, paramLong1 }, 4));
      s.s(paramString, "java.lang.String.format(format, *args)");
      localIntent.putExtra("rawUrl", paramString);
      c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(363741);
      return;
      localObject = paramLong1.toString();
      paramLong1 = (Long)localObject;
      if (localObject == null) {
        paramLong1 = "";
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(363754);
    s.u(paramContext, "context");
    s.u(paramString1, "exposeUrl");
    s.u(paramString2, "username");
    Log.i(TAG, "liveRepalyExpose liveId:" + paramLong + ",exposeUrl:" + paramString1 + ",username:" + paramString2 + ",commentSeq:" + null);
    Intent localIntent = new Intent();
    localIntent.putExtra("showShare", false);
    am localam = am.aixg;
    paramString1 = String.format(paramString1, Arrays.copyOf(new Object[] { Integer.valueOf(62), Long.valueOf(paramLong), paramString2, "" }, 4));
    s.s(paramString1, "java.lang.String.format(format, *args)");
    localIntent.putExtra("rawUrl", paramString1);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(363754);
  }
  
  public static void aB(Context paramContext, String paramString)
  {
    AppMethodBeat.i(363760);
    s.u(paramContext, "context");
    s.u(paramString, "groupId");
    Object localObject = am.aixg;
    paramString = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=64&wechat_real_lang=%s&topic_wording=%s", Arrays.copyOf(new Object[] { LocaleUtil.getApplicationLanguage(), paramString }, 2));
    s.s(paramString, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(363760);
  }
  
  public static void i(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(363764);
    s.u(paramContext, "context");
    Object localObject = am.aixg;
    localObject = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=68&topic_id=%s", Arrays.copyOf(new Object[] { d.hF(paramLong) }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(363764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.a
 * JD-Core Version:    0.7.0.1
 */