package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public final b fYA;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, o paramo1, o paramo2, o paramo3, boolean paramBoolean)
  {
    AppMethodBeat.i(41604);
    ac.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ac.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bh();
    ((bh)localObject).tju = paramString;
    ((bh)localObject).tkb = paramLinkedList;
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
      ((bh)localObject).iKc = paramString;
      if (paramo1 != null) {}
      for (;;)
      {
        ((bh)localObject).tkc = new v();
        if (paramo1 != null)
        {
          ((bh)localObject).tkc.tir = paramo1.tdW.teU;
          ((bh)localObject).tkc.hOf = paramo1.field_appId;
          ((bh)localObject).tkc.thm = paramo1.teJ;
          ((bh)localObject).tkc.tit = paramo1.teI;
        }
        if (paramo2 != null)
        {
          paramLinkedList = ((bh)localObject).tkc;
          paramLinkedList.tis |= 0x1;
        }
        if (paramo3 != null)
        {
          paramLinkedList = ((bh)localObject).tkc;
          paramLinkedList.tis |= 0x2;
        }
        ((bh)localObject).tkd = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOm().cQD();
        ((bh)localObject).tke = paramBoolean;
        if (i.eUv()) {}
        for (int i = 1;; i = 0)
        {
          ((bh)localObject).tjv = i;
          ac.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new b.a();
          paramString.hvt = ((a)localObject);
          paramString.hvu = new bi();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.reqCmdId = 0;
          paramString.respCmdId = 0;
          this.fYA = paramString.aAz();
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(41605);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */