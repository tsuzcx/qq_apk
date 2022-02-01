package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class b$d
  implements IPCRunCgi.a
{
  b$d(b paramb) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
  {
    AppMethodBeat.i(7068);
    ae.i(this.oug.TAG, "appmsg_comment_exposure errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(7068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b.d
 * JD-Core Version:    0.7.0.1
 */