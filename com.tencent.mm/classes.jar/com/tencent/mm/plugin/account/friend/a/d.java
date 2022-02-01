package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;

public final class d
  extends e
{
  public final bv a(e.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(218365);
    Object localObject1 = parama.gte;
    Object localObject2 = z.a(((cv)localObject1).FNI);
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      ae.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(218365);
      return null;
    }
    localObject2 = bv.a.aVC((String)localObject2);
    if (((cv)localObject1).urJ == 66) {
      ((a)g.ab(a.class)).Jb(((bv.a)localObject2).JgZ);
    }
    if (bu.nullAsNil(((bv.a)localObject2).cUA).length() > 0)
    {
      localObject1 = new i();
      ((i)localObject1).username = ((bv.a)localObject2).cUA;
      ((i)localObject1).eQU = 3;
      ((i)localObject1).eD(true);
      ((i)localObject1).hPQ = ((bv.a)localObject2).JgV;
      ((i)localObject1).hPP = ((bv.a)localObject2).JgW;
      ((i)localObject1).dEu = -1;
      ae.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((bv.a)localObject2).cUA, ((i)localObject1).aEG(), ((i)localObject1).aEH() });
      p.aEN().b((i)localObject1);
    }
    parama = super.a(parama, paramString1, paramString2, paramString3);
    AppMethodBeat.o(218365);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */