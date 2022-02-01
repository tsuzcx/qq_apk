package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;

public final class d
  extends e
{
  public final bu a(e.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(214664);
    Object localObject1 = parama.gqE;
    Object localObject2 = z.a(((cv)localObject1).Fvk);
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      ad.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(214664);
      return null;
    }
    localObject2 = bu.a.aUb((String)localObject2);
    if (((cv)localObject1).ugm == 66) {
      ((b)g.ab(b.class)).IC(((bu.a)localObject2).IMs);
    }
    if (bt.nullAsNil(((bu.a)localObject2).dHm).length() > 0)
    {
      localObject1 = new i();
      ((i)localObject1).username = ((bu.a)localObject2).dHm;
      ((i)localObject1).ePj = 3;
      ((i)localObject1).eB(true);
      ((i)localObject1).hMX = ((bu.a)localObject2).IMo;
      ((i)localObject1).hMW = ((bu.a)localObject2).IMp;
      ((i)localObject1).dDp = -1;
      ad.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((bu.a)localObject2).dHm, ((i)localObject1).aEq(), ((i)localObject1).aEr() });
      p.aEx().b((i)localObject1);
    }
    parama = super.a(parama, paramString1, paramString2, paramString3);
    AppMethodBeat.o(214664);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */