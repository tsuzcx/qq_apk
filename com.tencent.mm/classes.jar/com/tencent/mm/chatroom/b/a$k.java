package com.tencent.mm.chatroom.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import kotlin.g.a.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class a$k
  implements IPCRunCgi.a
{
  a$k(aa.f paramf, Context paramContext) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.an.d paramd)
  {
    AppMethodBeat.i(187062);
    com.tencent.mm.ae.d.uiThread((a)new q(paramd) {});
    AppMethodBeat.o(187062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a.k
 * JD-Core Version:    0.7.0.1
 */