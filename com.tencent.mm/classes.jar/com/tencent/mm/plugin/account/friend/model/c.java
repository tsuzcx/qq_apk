package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;

public final class c
  extends com.tencent.mm.model.e
{
  public final cc a(g.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(304754);
    Object localObject1 = parama.mpN;
    Object localObject2 = w.a(((dl)localObject1).YFG);
    if ((localObject2 == null) || (((String)localObject2).length() <= 0))
    {
      Log.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
      AppMethodBeat.o(304754);
      return null;
    }
    localObject2 = cc.a.bys((String)localObject2);
    if (((dl)localObject1).IIs == 66) {
      ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).RG(((cc.a)localObject2).adkF);
    }
    if (Util.nullAsNil(((cc.a)localObject2).hgk).length() > 0)
    {
      localObject1 = new j();
      ((j)localObject1).username = ((cc.a)localObject2).hgk;
      ((j)localObject1).jZY = 3;
      ((j)localObject1).gX(true);
      ((j)localObject1).osN = ((cc.a)localObject2).adkB;
      ((j)localObject1).osM = ((cc.a)localObject2).adkC;
      ((j)localObject1).eQp = -1;
      Log.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", new Object[] { ((cc.a)localObject2).hgk, ((j)localObject1).bFw(), ((j)localObject1).bFx() });
      q.bFE().b((j)localObject1);
    }
    parama = super.a(parama, paramString1, paramString2, paramString3);
    AppMethodBeat.o(304754);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.c
 * JD-Core Version:    0.7.0.1
 */