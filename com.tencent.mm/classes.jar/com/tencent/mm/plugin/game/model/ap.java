package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public final b fYA;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41607);
    ac.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ac.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bj();
    ((bj)localObject).tju = paramString;
    ((bj)localObject).tkb = paramLinkedList;
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
      ((bj)localObject).iKc = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bj)localObject).tkc = new v();
        if (paramo1 != null)
        {
          ((bj)localObject).tkc.tir = paramo1.tdW.teU;
          ((bj)localObject).tkc.hOf = paramo1.field_appId;
          ((bj)localObject).tkc.thm = paramo1.teJ;
          ((bj)localObject).tkc.tit = paramo1.teI;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bj)localObject).tkc;
          paramLinkedList.tis |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bj)localObject).tkc;
          paramLinkedList.tis |= 0x2;
        }
        ((bj)localObject).tkd = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().cQD();
        ((bj)localObject).tke = paramBoolean;
        if (i.eUv()) {}
        for (int i = 1;; i = 0)
        {
          ((bj)localObject).tjv = i;
          ac.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!bs.isNullOrNil(((bj)localObject).iKc)) && ("CN".equalsIgnoreCase(((bj)localObject).iKc))) {
            h.wUl.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new b.a();
          paramString.hvt = ((a)localObject);
          paramString.hvu = new bk();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.reqCmdId = 0;
          paramString.respCmdId = 0;
          this.fYA = paramString.aAz();
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(41608);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */