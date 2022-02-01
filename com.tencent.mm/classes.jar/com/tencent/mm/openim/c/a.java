package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.Map;

public final class a
  implements p
{
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(151260);
    ad.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "onNewXmlReceived() ");
    if (paramMap != null)
    {
      paramString = parama.fTo;
      if (bt.iY(paramString.saz, 10002))
      {
        paramMap = z.a(paramString.Cxz);
        if (bt.isNullOrNil(paramMap))
        {
          ad.w("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "msg content is null");
          AppMethodBeat.o(151260);
          return;
        }
        String str = z.a(paramString.Cxx);
        bl localbl = ((k)g.ab(k.class)).cOI().aD(str, paramString.uKZ);
        int i = 0;
        if (localbl.field_msgId > 0L) {
          i = 1;
        }
        localbl.kX(paramString.uKZ);
        localbl.kY(bi.y(str, paramString.CreateTime));
        localbl.setType(10002);
        localbl.setContent(paramMap);
        localbl.jV(0);
        localbl.nY(str);
        localbl.mZ(paramString.CxC);
        localbl.eMy();
        bi.a(localbl, parama);
        if (i == 0)
        {
          bi.u(localbl);
          AppMethodBeat.o(151260);
          return;
        }
        ((k)g.ab(k.class)).cOI().b(paramString.uKZ, localbl);
        AppMethodBeat.o(151260);
        return;
      }
      ad.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberReceiver", "not new xml type:%d ", new Object[] { Integer.valueOf(paramString.saz) });
    }
    AppMethodBeat.o(151260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.c.a
 * JD-Core Version:    0.7.0.1
 */