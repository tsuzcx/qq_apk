package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.bt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  public final b gux;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41607);
    ae.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ae.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bt();
    ((bt)localObject).usS = paramString;
    ((bt)localObject).utD = paramLinkedList;
    paramLinkedList = e.fz(ak.getContext());
    paramString = paramLinkedList;
    if (com.tencent.mm.sdk.platformtools.bu.isNullOrNil(paramLinkedList)) {
      paramString = com.tencent.mm.sdk.platformtools.bu.jm(ak.getContext());
    }
    if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bt)localObject).jge = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bt)localObject).utE = new ab();
        if (paramo1 != null)
        {
          ((bt)localObject).utE.urH = paramo1.umO.unR;
          ((bt)localObject).utE.ikm = paramo1.field_appId;
          ((bt)localObject).utE.uqn = paramo1.unE;
          ((bt)localObject).utE.urJ = paramo1.unD;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bt)localObject).utE;
          paramLinkedList.urI |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bt)localObject).utE;
          paramLinkedList.urI |= 0x2;
        }
        ((bt)localObject).utF = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().dbS();
        ((bt)localObject).utG = paramBoolean;
        if (com.tencent.mm.sdk.platformtools.k.fnT()) {}
        for (int i = 1;; i = 0)
        {
          ((bt)localObject).usT = i;
          ae.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(((bt)localObject).jge)) && ("CN".equalsIgnoreCase(((bt)localObject).jge))) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new b.a();
          paramString.hQF = ((a)localObject);
          paramString.hQG = new com.tencent.mm.plugin.game.d.bu();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.hQH = 0;
          paramString.respCmdId = 0;
          this.gux = paramString.aDS();
          AppMethodBeat.o(41607);
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label449;
          }
          paramo1 = paramo3;
          break;
        }
        label449:
        paramo1 = null;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(41608);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
    AppMethodBeat.o(41608);
    return i;
  }
  
  public final int getType()
  {
    return 2855;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41609);
    ae.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */