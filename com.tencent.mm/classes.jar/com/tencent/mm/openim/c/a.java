package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class a
  implements q
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(151260);
    ad.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.gqE;
      if (bt.jx(paramString.ugm, 10002))
      {
        paramMap = z.a(paramString.Fvk);
        if (bt.isNullOrNil(paramMap))
        {
          ad.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(151260);
          return;
        }
        String str = z.a(paramString.Fvi);
        bu localbu = ((l)g.ab(l.class)).dlK().aI(str, paramString.xbt);
        int i = 0;
        if (localbu.field_msgId > 0L) {
          i = 1;
        }
        localbu.qz(paramString.xbt);
        localbu.qA(bj.B(str, paramString.CreateTime));
        localbu.setType(10002);
        localbu.setContent(paramMap);
        localbu.kr(0);
        localbu.tN(str);
        localbu.sP(paramString.Fvn);
        localbu.fsg();
        bj.a(localbu, parama);
        if (i == 0)
        {
          bj.v(localbu);
          AppMethodBeat.o(151260);
          return;
        }
        ((l)g.ab(l.class)).dlK().b(paramString.xbt, localbu);
        AppMethodBeat.o(151260);
        return;
      }
      ad.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.ugm) });
    }
    AppMethodBeat.o(151260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a
 * JD-Core Version:    0.7.0.1
 */