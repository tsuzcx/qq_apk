package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public final b fUF;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41607);
    ad.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ad.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bj();
    ((bj)localObject).sbA = paramString;
    ((bj)localObject).sch = paramLinkedList;
    paramLinkedList = e.fe(aj.getContext());
    paramString = paramLinkedList;
    if (bt.isNullOrNil(paramLinkedList)) {
      paramString = bt.iL(aj.getContext());
    }
    if (!bt.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bj)localObject).ijV = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bj)localObject).sci = new v();
        if (paramo1 != null)
        {
          ((bj)localObject).sci.sax = paramo1.rWe.rXc;
          ((bj)localObject).sci.hnC = paramo1.field_appId;
          ((bj)localObject).sci.rZt = paramo1.rWR;
          ((bj)localObject).sci.saz = paramo1.rWQ;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bj)localObject).sci;
          paramLinkedList.say |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bj)localObject).sci;
          paramLinkedList.say |= 0x2;
        }
        ((bj)localObject).scj = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDt();
        ((bj)localObject).sck = paramBoolean;
        if (i.eFb()) {}
        for (int i = 1;; i = 0)
        {
          ((bj)localObject).sbB = i;
          ad.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!bt.isNullOrNil(((bj)localObject).ijV)) && ("CN".equalsIgnoreCase(((bj)localObject).ijV))) {
            h.vKh.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new b.a();
          paramString.gUU = ((a)localObject);
          paramString.gUV = new bk();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.reqCmdId = 0;
          paramString.respCmdId = 0;
          this.fUF = paramString.atI();
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(41608);
    this.callback = paramg;
    int i = dispatch(parame, this.fUF, this);
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
    ad.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */