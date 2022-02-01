package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class an
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public final b grW;
  
  public an(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41601);
    ad.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ad.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new b.a();
    ((b.a)localObject).hNM = new bg();
    ((b.a)localObject).hNN = new bh();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (bg)this.grW.hNK.hNQ;
    ((bg)localObject).uhu = paramString;
    ((bg)localObject).uie = paramLinkedList;
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
      ((bg)localObject).jdl = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bg)localObject).uif = new w();
        if (paramo1 != null)
        {
          ((bg)localObject).uif.ugk = paramo1.ubM.ucM;
          ((bg)localObject).uif.iht = paramo1.field_appId;
          ((bg)localObject).uif.ufd = paramo1.ucA;
          ((bg)localObject).uif.ugm = paramo1.ucz;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bg)localObject).uif;
          paramLinkedList.ugl |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bg)localObject).uif;
          paramLinkedList.ugl |= 0x2;
        }
        ((bg)localObject).uig = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().cZi();
        ((bg)localObject).uih = paramBoolean;
        if (com.tencent.mm.sdk.platformtools.j.fjZ()) {}
        for (int i = 1;; i = 0)
        {
          ((bg)localObject).uhv = i;
          ad.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!bt.isNullOrNil(((bg)localObject).jdl)) && (!"CN".equalsIgnoreCase(((bg)localObject).jdl))) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(860L, 7L, 1L, false);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(41602);
    this.callback = paramf;
    int i = dispatch(parame, this.grW, this);
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
    ad.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */