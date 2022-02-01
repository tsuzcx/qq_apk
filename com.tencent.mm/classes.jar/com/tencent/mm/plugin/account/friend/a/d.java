package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;

public final class d
  extends e
{
  public final bo a(cu paramcu, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(130990);
    Object localObject = z.a(paramcu.DPV);
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      ac.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(130990);
      return null;
    }
    localObject = bo.a.aOk((String)localObject);
    if (paramcu.tit == 66) {
      ((b)g.ab(b.class)).Fm(((bo.a)localObject).GZd);
    }
    if (bs.nullAsNil(((bo.a)localObject).zTO).length() > 0)
    {
      i locali = new i();
      locali.username = ((bo.a)localObject).zTO;
      locali.exK = 3;
      locali.ez(true);
      locali.huF = ((bo.a)localObject).GYZ;
      locali.huE = ((bo.a)localObject).GZa;
      locali.drx = -1;
      ac.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((bo.a)localObject).zTO, locali.aBo(), locali.aBp() });
      p.aBw().b(locali);
    }
    paramcu = super.a(paramcu, paramString1, paramString2, paramString3);
    AppMethodBeat.o(130990);
    return paramcu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */