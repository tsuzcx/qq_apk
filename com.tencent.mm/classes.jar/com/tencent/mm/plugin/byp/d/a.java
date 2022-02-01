package com.tencent.mm.plugin.byp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"print", "", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-byp_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final String e(cy paramcy)
  {
    AppMethodBeat.i(271962);
    s.u(paramcy, "<this>");
    StringBuilder localStringBuilder = new StringBuilder("isSender=").append(paramcy.YFj).append(", seq=").append(paramcy.seq).append(", sessionId=").append(paramcy.YFh).append(", addMsg=");
    paramcy = paramcy.YFg;
    if (paramcy == null) {}
    for (paramcy = null;; paramcy = "FromUserName=" + paramcy.YFE + " ToUserName=" + paramcy.YFF + " MsgType=" + paramcy.IIs + " NewMsgId=" + paramcy.Njv + " content=" + w.a(paramcy.YFG))
    {
      paramcy = paramcy;
      AppMethodBeat.o(271962);
      return paramcy;
      s.u(paramcy, "<this>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.d.a
 * JD-Core Version:    0.7.0.1
 */