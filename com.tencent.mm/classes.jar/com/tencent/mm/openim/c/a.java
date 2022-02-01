package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class a
  implements p
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(151260);
    ac.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.fXi;
      if (bs.jl(paramString.tit, 10002))
      {
        paramMap = z.a(paramString.DPV);
        if (bs.isNullOrNil(paramMap))
        {
          ac.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(151260);
          return;
        }
        String str = z.a(paramString.DPT);
        bo localbo = ((k)g.ab(k.class)).dcr().aF(str, paramString.vTQ);
        int i = 0;
        if (localbo.field_msgId > 0L) {
          i = 1;
        }
        localbo.oz(paramString.vTQ);
        localbo.oA(bi.z(str, paramString.CreateTime));
        localbo.setType(10002);
        localbo.setContent(paramMap);
        localbo.jT(0);
        localbo.re(str);
        localbo.qf(paramString.DPY);
        localbo.fcd();
        bi.a(localbo, parama);
        if (i == 0)
        {
          bi.u(localbo);
          AppMethodBeat.o(151260);
          return;
        }
        ((k)g.ab(k.class)).dcr().b(paramString.vTQ, localbo);
        AppMethodBeat.o(151260);
        return;
      }
      ac.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.tit) });
    }
    AppMethodBeat.o(151260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a
 * JD-Core Version:    0.7.0.1
 */