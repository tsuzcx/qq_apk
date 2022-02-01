package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class a
  implements q
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(151260);
    Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.heO;
      if (Util.isEqual(paramString.xKb, 10002))
      {
        paramMap = z.a(paramString.KHn);
        if (Util.isNullOrNil(paramMap))
        {
          Log.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(151260);
          return;
        }
        String str = z.a(paramString.KHl);
        ca localca = ((l)g.af(l.class)).eiy().aJ(str, paramString.Brn);
        int i = 0;
        if (localca.field_msgId > 0L) {
          i = 1;
        }
        localca.yF(paramString.Brn);
        localca.setCreateTime(bp.C(str, paramString.CreateTime));
        localca.setType(10002);
        localca.setContent(paramMap);
        localca.nv(0);
        localca.Cy(str);
        localca.BB(paramString.KHq);
        localca.gDN();
        bp.a(localca, parama);
        if (i == 0)
        {
          bp.x(localca);
          AppMethodBeat.o(151260);
          return;
        }
        ((l)g.af(l.class)).eiy().b(paramString.Brn, localca);
        AppMethodBeat.o(151260);
        return;
      }
      Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.xKb) });
    }
    AppMethodBeat.o(151260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.c.a
 * JD-Core Version:    0.7.0.1
 */