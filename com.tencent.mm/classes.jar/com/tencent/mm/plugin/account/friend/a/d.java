package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;

public final class d
  extends e
{
  public final bl a(cs paramcs, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(130990);
    Object localObject = z.a(paramcs.Cxz);
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      ad.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(130990);
      return null;
    }
    localObject = bl.a.aIO((String)localObject);
    if (paramcs.saz == 66) {
      ((b)g.ab(b.class)).Bh(((bl.a)localObject).FAb);
    }
    if (bt.nullAsNil(((bl.a)localObject).yGA).length() > 0)
    {
      i locali = new i();
      locali.username = ((bl.a)localObject).yGA;
      locali.evo = 3;
      locali.ee(true);
      locali.gUg = ((bl.a)localObject).FzX;
      locali.gUf = ((bl.a)localObject).FzY;
      locali.dtM = -1;
      ad.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((bl.a)localObject).yGA, locali.aux(), locali.auy() });
      p.auF().b(locali);
    }
    paramcs = super.a(paramcs, paramString1, paramString2, paramString3);
    AppMethodBeat.o(130990);
    return paramcs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */