package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.t;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.byp.c.c;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.storage.at;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateMsgConfig$FinderCreateSendMsgInterceptor;", "Lcom/tencent/mm/plugin/byp/config/BaseSendMsgInterceptors;", "()V", "checkIfYourFile", "", "params", "Lcom/tencent/mm/modelmulti/SendMsgCgiFactory$SendMsgParams;", "getBizType", "", "getSenderBySessionId", "", "sessionId", "getTalkerBySessionId", "support", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$a
  extends c
{
  public final String akk(String paramString)
  {
    AppMethodBeat.i(335981);
    s.u(paramString, "sessionId");
    paramString = ((bp)h.ax(bp.class)).aAw(paramString);
    s.s(paramString, "service(IFinderSessionIn…alkerFromLocal(sessionId)");
    AppMethodBeat.o(335981);
    return paramString;
  }
  
  public final String akl(String paramString)
  {
    AppMethodBeat.i(335985);
    s.u(paramString, "sessionId");
    paramString = ((bp)h.ax(bp.class)).aAx(paramString);
    s.s(paramString, "service(IFinderSessionIn…tSessionSender(sessionId)");
    AppMethodBeat.o(335985);
    return paramString;
  }
  
  public final boolean b(t.e parame)
  {
    AppMethodBeat.i(335996);
    s.u(parame, "params");
    if (((parame instanceof t)) && (at.bvN(((t)parame).fileName)))
    {
      AppMethodBeat.o(335996);
      return true;
    }
    AppMethodBeat.o(335996);
    return false;
  }
  
  public final int dis()
  {
    return 1;
  }
  
  public final boolean g(t.e parame)
  {
    AppMethodBeat.i(335976);
    bp localbp = (bp)h.ax(bp.class);
    s.checkNotNull(parame);
    if ((localbp.aAy(parame.toUser)) || (b(parame)))
    {
      AppMethodBeat.o(335976);
      return true;
    }
    AppMethodBeat.o(335976);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.m.a
 * JD-Core Version:    0.7.0.1
 */