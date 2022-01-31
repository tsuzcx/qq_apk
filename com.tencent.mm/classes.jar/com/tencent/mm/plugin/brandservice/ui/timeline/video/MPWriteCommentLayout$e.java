package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class MPWriteCommentLayout$e
  implements b.a
{
  MPWriteCommentLayout$e(MPWriteCommentLayout paramMPWriteCommentLayout) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(152914);
    MPWriteCommentLayout.f(this.khv);
    al.d((Runnable)new MPWriteCommentLayout.e.1(this, paramb));
    if (paramInt1 == 2)
    {
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(8);
      AppMethodBeat.o(152914);
      return;
    }
    if (paramInt1 != 0) {
      com.tencent.mm.plugin.webview.ui.tools.b.Ko(9);
    }
    AppMethodBeat.o(152914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.e
 * JD-Core Version:    0.7.0.1
 */