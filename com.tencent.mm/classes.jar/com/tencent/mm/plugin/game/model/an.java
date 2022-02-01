package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class an
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public final b fUF;
  
  public an(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41601);
    ad.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ad.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new b.a();
    ((b.a)localObject).gUU = new bd();
    ((b.a)localObject).gUV = new be();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    localObject = (bd)this.fUF.gUS.gUX;
    ((bd)localObject).sbA = paramString;
    ((bd)localObject).sch = paramLinkedList;
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
      ((bd)localObject).ijV = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bd)localObject).sci = new v();
        if (paramo1 != null)
        {
          ((bd)localObject).sci.sax = paramo1.rWe.rXc;
          ((bd)localObject).sci.hnC = paramo1.field_appId;
          ((bd)localObject).sci.rZt = paramo1.rWR;
          ((bd)localObject).sci.saz = paramo1.rWQ;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bd)localObject).sci;
          paramLinkedList.say |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bd)localObject).sci;
          paramLinkedList.say |= 0x2;
        }
        ((bd)localObject).scj = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDt();
        ((bd)localObject).sck = paramBoolean;
        if (i.eFb()) {}
        for (int i = 1;; i = 0)
        {
          ((bd)localObject).sbB = i;
          ad.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!bt.isNullOrNil(((bd)localObject).ijV)) && (!"CN".equalsIgnoreCase(((bd)localObject).ijV))) {
            h.vKh.idkeyStat(860L, 7L, 1L, false);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(41602);
    this.callback = paramg;
    int i = dispatch(parame, this.fUF, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */