package com.tencent.mm.plugin.finder.uniComments.logic;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/logic/UniExposeLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "exposeFeed", "", "context", "Landroid/content/Context;", "feedId", "", "commentId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b GaN;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(341497);
    GaN = new b();
    TAG = "MicroMsg.UniExposeLogic";
    AppMethodBeat.o(341497);
  }
  
  public static void c(Context paramContext, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(341490);
    s.u(paramContext, "context");
    Object localObject = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=79&comment_ID=" + paramLong2 + "&Content_ID=" + paramLong1;
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    localObject = z.FrZ;
    z.pK(paramLong1);
    localObject = as.GSQ;
    paramContext = as.a.hu(paramContext);
    if (paramContext != null)
    {
      paramContext = ((bn)paramContext).foy();
      if (paramContext != null)
      {
        paramContext = paramContext.dYj();
        if (paramContext != null) {
          paramContext.nk(paramLong1);
        }
      }
    }
    AppMethodBeat.o(341490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.logic.b
 * JD-Core Version:    0.7.0.1
 */