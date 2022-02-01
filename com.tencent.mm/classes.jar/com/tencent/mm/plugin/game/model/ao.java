package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.br;
import com.tencent.mm.plugin.game.d.bs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  public final b gux;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41604);
    ae.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ae.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new br();
    ((br)localObject).usS = paramString;
    ((br)localObject).utD = paramLinkedList;
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
      ((br)localObject).jge = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((br)localObject).utE = new ab();
        if (paramo1 != null)
        {
          ((br)localObject).utE.urH = paramo1.umO.unR;
          ((br)localObject).utE.ikm = paramo1.field_appId;
          ((br)localObject).utE.uqn = paramo1.unE;
          ((br)localObject).utE.urJ = paramo1.unD;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((br)localObject).utE;
          paramLinkedList.urI |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((br)localObject).utE;
          paramLinkedList.urI |= 0x2;
        }
        ((br)localObject).utF = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().dbS();
        ((br)localObject).utG = paramBoolean;
        if (com.tencent.mm.sdk.platformtools.k.fnT()) {}
        for (int i = 1;; i = 0)
        {
          ((br)localObject).usT = i;
          ae.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new b.a();
          paramString.hQF = ((a)localObject);
          paramString.hQG = new bs();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.hQH = 0;
          paramString.respCmdId = 0;
          this.gux = paramString.aDS();
          AppMethodBeat.o(41604);
          return;
          if (paramo2 != null)
          {
            paramo1 = paramo2;
            break;
          }
          if (paramo3 == null) {
            break label411;
          }
          paramo1 = paramo3;
          break;
        }
        label411:
        paramo1 = null;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(41605);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
    AppMethodBeat.o(41605);
    return i;
  }
  
  public final int getType()
  {
    return 2586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41606);
    ae.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */