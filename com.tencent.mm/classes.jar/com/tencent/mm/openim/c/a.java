package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class a
  implements o
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(78916);
    ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.eyJ;
      if (bo.hl(paramString.nqW, 10002))
      {
        paramMap = aa.a(paramString.woR);
        if (bo.isNullOrNil(paramMap))
        {
          ab.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(78916);
          return;
        }
        String str = aa.a(paramString.woP);
        bi localbi = ((j)g.E(j.class)).bPQ().ag(str, paramString.pIG);
        int i = 0;
        if (localbi.field_msgId > 0L) {
          i = 1;
        }
        localbi.fP(paramString.pIG);
        localbi.fQ(bf.x(str, paramString.CreateTime));
        localbi.setType(10002);
        localbi.setContent(paramMap);
        localbi.hL(0);
        localbi.kj(str);
        localbi.jl(paramString.woU);
        localbi.dym();
        bf.a(localbi, parama);
        if (i == 0)
        {
          bf.l(localbi);
          AppMethodBeat.o(78916);
          return;
        }
        ((j)g.E(j.class)).bPQ().b(paramString.pIG, localbi);
        AppMethodBeat.o(78916);
        return;
      }
      ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.nqW) });
    }
    AppMethodBeat.o(78916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a
 * JD-Core Version:    0.7.0.1
 */