package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class a
  implements t
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(151260);
    Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.jQG;
      if (Util.isEqual(paramString.COi, 10002))
      {
        paramMap = z.a(paramString.RIF);
        if (Util.isNullOrNil(paramMap))
        {
          Log.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(151260);
          return;
        }
        String str = z.a(paramString.RID);
        ca localca = ((n)h.ae(n.class)).eSe().aL(str, paramString.HlH);
        int i = 0;
        if (localca.field_msgId > 0L) {
          i = 1;
        }
        localca.EG(paramString.HlH);
        localca.setCreateTime(bq.z(str, paramString.CreateTime));
        localca.setType(10002);
        localca.setContent(paramMap);
        localca.pJ(0);
        localca.Jm(str);
        localca.Ip(paramString.RII);
        localca.hAb();
        bq.a(localca, parama);
        if (i == 0)
        {
          bq.z(localca);
          AppMethodBeat.o(151260);
          return;
        }
        ((n)h.ae(n.class)).eSe().b(paramString.HlH, localca);
        AppMethodBeat.o(151260);
        return;
      }
      Log.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.COi) });
    }
    AppMethodBeat.o(151260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.c.a
 * JD-Core Version:    0.7.0.1
 */