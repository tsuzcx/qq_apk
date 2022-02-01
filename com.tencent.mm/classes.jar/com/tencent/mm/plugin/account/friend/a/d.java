package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;

public final class d
  extends e
{
  public final ca a(h.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(206400);
    Object localObject1 = parama.heO;
    Object localObject2 = z.a(((de)localObject1).KHn);
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      Log.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(206400);
      return null;
    }
    localObject2 = ca.a.bkA((String)localObject2);
    if (((de)localObject1).xKb == 66) {
      ((a)g.af(a.class)).RY(((ca.a)localObject2).OqQ);
    }
    if (Util.nullAsNil(((ca.a)localObject2).dkU).length() > 0)
    {
      localObject1 = new i();
      ((i)localObject1).username = ((ca.a)localObject2).dkU;
      ((i)localObject1).fuz = 3;
      ((i)localObject1).fv(true);
      ((i)localObject1).iKX = ((ca.a)localObject2).OqM;
      ((i)localObject1).iKW = ((ca.a)localObject2).OqN;
      ((i)localObject1).cSx = -1;
      Log.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((ca.a)localObject2).dkU, ((i)localObject1).aYt(), ((i)localObject1).aYu() });
      p.aYB().b((i)localObject1);
    }
    parama = super.a(parama, paramString1, paramString2, paramString3);
    AppMethodBeat.o(206400);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */