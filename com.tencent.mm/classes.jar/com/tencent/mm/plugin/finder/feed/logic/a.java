package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderExposeLogic;", "", "()V", "exposeFeed", "", "context", "Landroid/content/Context;", "feedId", "", "commentId", "plugin-finder_release"})
public final class a
{
  public static final a rml;
  
  static
  {
    AppMethodBeat.i(166010);
    rml = new a();
    AppMethodBeat.o(166010);
  }
  
  public static void b(Context paramContext, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(166008);
    k.h(paramContext, "context");
    e.wTc.idkeyStat(1278L, 8L, 1L, false);
    Object localObject1 = z.KUT;
    localObject1 = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=58&wechat_real_lang=%s&content_ID=%s&comment_ID=%s", Arrays.copyOf(new Object[] { ab.eUO(), com.tencent.mm.ac.c.pb(paramLong1), com.tencent.mm.ac.c.pb(paramLong2) }, 3));
    k.g(localObject1, "java.lang.String.format(format, *args)");
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
    localObject1 = com.tencent.mm.plugin.finder.report.d.rxr;
    localObject1 = com.tencent.mm.plugin.finder.report.d.ur(paramLong1);
    if (localObject1 != null)
    {
      localObject2 = ((FinderItem)localObject1).getFeedObject();
      String str = ((com.tencent.mm.plugin.expt.a.c)g.ab(com.tencent.mm.plugin.expt.a.c.class)).cit();
      localObject1 = str + ',' + com.tencent.mm.plugin.finder.report.d.ut(((FinderObject)localObject2).id) + ',' + ((FinderObject)localObject2).username + ',' + ((FinderObject)localObject2).recommendType + ',' + ((FinderItem)localObject1).getMediaType();
      ac.i(com.tencent.mm.plugin.finder.report.d.TAG, "18974 ".concat(String.valueOf(localObject1)));
      e.wTc.kvStat(18974, (String)localObject1);
    }
    localObject1 = FinderReporterUIC.seQ;
    paramContext = FinderReporterUIC.a.eV(paramContext);
    if (paramContext != null)
    {
      paramContext = FinderReporterUIC.b(paramContext);
      if (paramContext != null)
      {
        paramContext.ctb().ue(paramLong1);
        AppMethodBeat.o(166008);
        return;
      }
    }
    AppMethodBeat.o(166008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.a
 * JD-Core Version:    0.7.0.1
 */