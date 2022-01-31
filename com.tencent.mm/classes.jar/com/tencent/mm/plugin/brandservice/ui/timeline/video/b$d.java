package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class b$d
  implements b.a
{
  b$d(b paramb) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(152801);
    ab.i(this.kfC.TAG, "appmsg_comment_exposure errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(152801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b.d
 * JD-Core Version:    0.7.0.1
 */