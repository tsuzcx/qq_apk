package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;

public final class d
  extends e
{
  public final bi a(cm paramcm, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108326);
    Object localObject = aa.a(paramcm.woR);
    if ((localObject == null) || (((String)localObject).length() <= 0))
    {
      ab.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(108326);
      return null;
    }
    localObject = bi.a.asj((String)localObject);
    if (paramcm.nqW == 66) {
      ((b)g.E(b.class)).wj(((bi.a)localObject).yOo);
    }
    if (bo.nullAsNil(((bi.a)localObject).tac).length() > 0)
    {
      h localh = new h();
      localh.username = ((bi.a)localObject).tac;
      localh.dqB = 3;
      localh.cM(true);
      localh.fsl = ((bi.a)localObject).yOk;
      localh.fsk = ((bi.a)localObject).yOl;
      localh.bsY = -1;
      ab.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((bi.a)localObject).tac, localh.acX(), localh.acY() });
      o.adg().b(localh);
    }
    paramcm = super.a(paramcm, paramString1, paramString2, paramString3);
    AppMethodBeat.o(108326);
    return paramcm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.d
 * JD-Core Version:    0.7.0.1
 */