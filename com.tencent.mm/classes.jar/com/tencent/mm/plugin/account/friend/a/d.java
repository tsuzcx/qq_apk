package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;

public final class d
  extends e
{
  public final ca a(h.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(194238);
    Object localObject1 = parama.jQG;
    Object localObject2 = z.a(((db)localObject1).RIF);
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      Log.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(194238);
      return null;
    }
    localObject2 = ca.a.bwZ((String)localObject2);
    if (((db)localObject1).COi == 66) {
      ((a)h.ae(a.class)).ZA(((ca.a)localObject2).VGM);
    }
    if (Util.nullAsNil(((ca.a)localObject2).fcC).length() > 0)
    {
      localObject1 = new j();
      ((j)localObject1).username = ((ca.a)localObject2).fcC;
      ((j)localObject1).hDc = 3;
      ((j)localObject1).gg(true);
      ((j)localObject1).lBe = ((ca.a)localObject2).VGI;
      ((j)localObject1).lBd = ((ca.a)localObject2).VGJ;
      ((j)localObject1).cUP = -1;
      Log.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((ca.a)localObject2).fcC, ((j)localObject1).bhH(), ((j)localObject1).bhI() });
      q.bhP().b((j)localObject1);
    }
    parama = super.a(parama, paramString1, paramString2, paramString3);
    AppMethodBeat.o(194238);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */