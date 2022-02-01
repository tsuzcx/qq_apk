package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class an
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public final b fYA;
  
  public an(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41601);
    ac.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ac.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new b.a();
    ((b.a)localObject).hvt = new bd();
    ((b.a)localObject).hvu = new be();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (bd)this.fYA.hvr.hvw;
    ((bd)localObject).tju = paramString;
    ((bd)localObject).tkb = paramLinkedList;
    paramLinkedList = e.fr(ai.getContext());
    paramString = paramLinkedList;
    if (bs.isNullOrNil(paramLinkedList)) {
      paramString = bs.iW(ai.getContext());
    }
    if (!bs.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bd)localObject).iKc = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bd)localObject).tkc = new v();
        if (paramo1 != null)
        {
          ((bd)localObject).tkc.tir = paramo1.tdW.teU;
          ((bd)localObject).tkc.hOf = paramo1.field_appId;
          ((bd)localObject).tkc.thm = paramo1.teJ;
          ((bd)localObject).tkc.tit = paramo1.teI;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bd)localObject).tkc;
          paramLinkedList.tis |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bd)localObject).tkc;
          paramLinkedList.tis |= 0x2;
        }
        ((bd)localObject).tkd = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().cQD();
        ((bd)localObject).tke = paramBoolean;
        if (i.eUv()) {}
        for (int i = 1;; i = 0)
        {
          ((bd)localObject).tjv = i;
          ac.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!bs.isNullOrNil(((bd)localObject).iKc)) && (!"CN".equalsIgnoreCase(((bd)localObject).iKc))) {
            h.wUl.idkeyStat(860L, 7L, 1L, false);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(41602);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */