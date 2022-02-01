package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public final b fUF;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41604);
    ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bh();
    ((bh)localObject).sbA = paramString;
    ((bh)localObject).sch = paramLinkedList;
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
      ((bh)localObject).ijV = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bh)localObject).sci = new v();
        if (paramo1 != null)
        {
          ((bh)localObject).sci.sax = paramo1.rWe.rXc;
          ((bh)localObject).sci.hnC = paramo1.field_appId;
          ((bh)localObject).sci.rZt = paramo1.rWR;
          ((bh)localObject).sci.saz = paramo1.rWQ;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bh)localObject).sci;
          paramLinkedList.say |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bh)localObject).sci;
          paramLinkedList.say |= 0x2;
        }
        ((bh)localObject).scj = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBd().cDt();
        ((bh)localObject).sck = paramBoolean;
        if (i.eFb()) {}
        for (int i = 1;; i = 0)
        {
          ((bh)localObject).sbB = i;
          ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new b.a();
          paramString.gUU = ((a)localObject);
          paramString.gUV = new bi();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.reqCmdId = 0;
          paramString.respCmdId = 0;
          this.fUF = paramString.atI();
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(41605);
    this.callback = paramg;
    int i = dispatch(parame, this.fUF, this);
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
    ad.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */