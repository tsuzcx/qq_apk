package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.bo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class an
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  public final b gux;
  
  public an(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41601);
    ae.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ae.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new b.a();
    ((b.a)localObject).hQF = new bn();
    ((b.a)localObject).hQG = new bo();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (bn)this.gux.hQD.hQJ;
    ((bn)localObject).usS = paramString;
    ((bn)localObject).utD = paramLinkedList;
    paramLinkedList = e.fz(ak.getContext());
    paramString = paramLinkedList;
    if (bu.isNullOrNil(paramLinkedList)) {
      paramString = bu.jm(ak.getContext());
    }
    if (!bu.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bn)localObject).jge = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bn)localObject).utE = new ab();
        if (paramo1 != null)
        {
          ((bn)localObject).utE.urH = paramo1.umO.unR;
          ((bn)localObject).utE.ikm = paramo1.field_appId;
          ((bn)localObject).utE.uqn = paramo1.unE;
          ((bn)localObject).utE.urJ = paramo1.unD;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bn)localObject).utE;
          paramLinkedList.urI |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bn)localObject).utE;
          paramLinkedList.urI |= 0x2;
        }
        ((bn)localObject).utF = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().dbS();
        ((bn)localObject).utG = paramBoolean;
        if (com.tencent.mm.sdk.platformtools.k.fnT()) {}
        for (int i = 1;; i = 0)
        {
          ((bn)localObject).usT = i;
          ae.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!bu.isNullOrNil(((bn)localObject).jge)) && (!"CN".equalsIgnoreCase(((bn)localObject).jge))) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(860L, 7L, 1L, false);
          }
          AppMethodBeat.o(41601);
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label468;
          }
          paramo1 = paramo3;
          break;
        }
        label468:
        paramo1 = null;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(41602);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
    AppMethodBeat.o(41602);
    return i;
  }
  
  public final int getType()
  {
    return 2994;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41603);
    ae.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */