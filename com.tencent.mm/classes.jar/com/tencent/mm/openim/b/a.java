package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class a
  implements t
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(151260);
    Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.mpN;
      if (Util.isEqual(paramString.IIs, 10002))
      {
        paramMap = w.a(paramString.YFG);
        if (Util.isNullOrNil(paramMap))
        {
          Log.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(151260);
          return;
        }
        String str = w.a(paramString.YFE);
        cc localcc = ((n)h.ax(n.class)).gaZ().aU(str, paramString.Njv);
        int i = 0;
        if (localcc.field_msgId > 0L) {
          i = 1;
        }
        localcc.gX(paramString.Njv);
        localcc.setCreateTime(br.D(str, paramString.CreateTime));
        localcc.setType(10002);
        localcc.setContent(paramMap);
        localcc.pI(0);
        localcc.BS(str);
        localcc.AU(paramString.YFJ);
        localcc.jcf();
        br.a(localcc, parama);
        if (i == 0)
        {
          br.B(localcc);
          AppMethodBeat.o(151260);
          return;
        }
        ((n)h.ax(n.class)).gaZ().b(paramString.Njv, localcc);
        AppMethodBeat.o(151260);
        return;
      }
      Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.IIs) });
    }
    AppMethodBeat.o(151260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */