package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public final b grW;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41607);
    ad.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ad.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bm();
    ((bm)localObject).uhu = paramString;
    ((bm)localObject).uie = paramLinkedList;
    paramLinkedList = e.fv(aj.getContext());
    paramString = paramLinkedList;
    if (bt.isNullOrNil(paramLinkedList)) {
      paramString = bt.jg(aj.getContext());
    }
    if (!bt.isNullOrNil(j.countryCode)) {
      paramString = j.countryCode;
    }
    for (;;)
    {
      ((bm)localObject).jdl = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bm)localObject).uif = new w();
        if (paramo1 != null)
        {
          ((bm)localObject).uif.ugk = paramo1.ubM.ucM;
          ((bm)localObject).uif.iht = paramo1.field_appId;
          ((bm)localObject).uif.ufd = paramo1.ucA;
          ((bm)localObject).uif.ugm = paramo1.ucz;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bm)localObject).uif;
          paramLinkedList.ugl |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bm)localObject).uif;
          paramLinkedList.ugl |= 0x2;
        }
        ((bm)localObject).uig = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZi();
        ((bm)localObject).uih = paramBoolean;
        if (com.tencent.mm.sdk.platformtools.j.fjZ()) {}
        for (int i = 1;; i = 0)
        {
          ((bm)localObject).uhv = i;
          ad.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!bt.isNullOrNil(((bm)localObject).jdl)) && ("CN".equalsIgnoreCase(((bm)localObject).jdl))) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new b.a();
          paramString.hNM = ((a)localObject);
          paramString.hNN = new bn();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.hNO = 0;
          paramString.respCmdId = 0;
          this.grW = paramString.aDC();
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(41608);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */