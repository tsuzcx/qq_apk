package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class a
  implements q
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(151260);
    ae.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.gte;
      if (bu.jB(paramString.urJ, 10002))
      {
        paramMap = z.a(paramString.FNI);
        if (bu.isNullOrNil(paramMap))
        {
          ae.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(151260);
          return;
        }
        String str = z.a(paramString.FNG);
        bv localbv = ((l)g.ab(l.class)).doJ().aJ(str, paramString.xrk);
        int i = 0;
        if (localbv.field_msgId > 0L) {
          i = 1;
        }
        localbv.qM(paramString.xrk);
        localbv.qN(bl.B(str, paramString.CreateTime));
        localbv.setType(10002);
        localbv.setContent(paramMap);
        localbv.kt(0);
        localbv.ui(str);
        localbv.tk(paramString.FNL);
        localbv.fwh();
        bl.a(localbv, parama);
        if (i == 0)
        {
          bl.v(localbv);
          AppMethodBeat.o(151260);
          return;
        }
        ((l)g.ab(l.class)).doJ().b(paramString.xrk, localbv);
        AppMethodBeat.o(151260);
        return;
      }
      ae.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.urJ) });
    }
    AppMethodBeat.o(151260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a
 * JD-Core Version:    0.7.0.1
 */