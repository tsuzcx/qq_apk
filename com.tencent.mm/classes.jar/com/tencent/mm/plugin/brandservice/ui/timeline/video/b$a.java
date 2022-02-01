package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.aq;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class b$a
  implements IPCRunCgi.a
{
  b$a(b paramb) {}
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(7064);
    aq.f((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(7063);
        IPCRunCgi.a locala = this.ooq.oop.kfc;
        if (locala != null)
        {
          locala.a(paramInt1, paramInt2, paramString, paramb);
          AppMethodBeat.o(7063);
          return;
        }
        AppMethodBeat.o(7063);
      }
    });
    AppMethodBeat.o(7064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b.a
 * JD-Core Version:    0.7.0.1
 */