package com.tencent.mm.plugin.finder.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "", "()V", "report21673", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "eventCode", "", "eventTime", "", "index", "jumpType", "wording", "", "friendLikeCount", "feedid", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJIILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "report21856", "context", "Landroid/content/Context;", "position", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final a Fsk;
  private static final ac Fsl;
  
  static
  {
    AppMethodBeat.i(331343);
    Fsk = new a((byte)0);
    Fsl = new ac();
    AppMethodBeat.o(331343);
  }
  
  public static void e(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(331326);
    s.u(paramContext, "context");
    s.u(paramString, "position");
    long l = cn.bDv();
    k localk = k.aeZF;
    paramContext = ((as)k.nq(paramContext).q(as.class)).fou();
    if (paramContext != null)
    {
      Log.i("Finder.FinderShareReporter", "FinderShareReporter.report21856, sessionId = " + paramContext.sessionId + ", clickTabContextId = " + paramContext.zIB + ", contextId = " + paramContext.zIO + ", commentScene = " + paramContext.AJo + ", eventCode = " + paramInt + ", eventTime = " + l + ", position = " + paramString);
      h.OAn.b(21856, new Object[] { paramContext.sessionId, paramContext.zIB, paramContext.zIO, Integer.valueOf(paramContext.AJo), Integer.valueOf(paramInt), Long.valueOf(l), paramString });
    }
    AppMethodBeat.o(331326);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter$Companion;", "", "()V", "EVENT_AUTO_GUIDE_NEXT", "", "EVENT_CLICK_GUIDE_NEXT", "EVENT_CLOSE_DUE_TO_OPEN_DRAWER", "EVENT_CLOSE_GUIDE_NEXT", "EVENT_CODE_CLICK", "EVENT_CODE_SHOW", "EVENT_EXPOSE_ANIMATION", "EVENT_EXPOSE_GUIDE_NEXT", "EVENT_EXPOSE_STATIC", "INSTANCE", "Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "JUMP_TYPE_CARD", "JUMP_TYPE_GUIDE", "JUMP_TYPE_POPUP", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ac
 * JD-Core Version:    0.7.0.1
 */