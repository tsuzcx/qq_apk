package com.tencent.mm.chatroom.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import d.g.a.a;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class a$k
  implements IPCRunCgi.a
{
  a$k(y.f paramf, Context paramContext) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final b paramb)
  {
    AppMethodBeat.i(213588);
    c.g((a)new q(paramb) {});
    AppMethodBeat.o(213588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a.k
 * JD-Core Version:    0.7.0.1
 */