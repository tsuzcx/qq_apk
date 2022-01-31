package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public ao(String paramString, LinkedList<String> paramLinkedList, n paramn1, n paramn2, n paramn3, boolean paramBoolean)
  {
    AppMethodBeat.i(111439);
    ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bh();
    ((bh)localObject).nsa = paramString;
    ((bh)localObject).nsF = paramLinkedList;
    paramLinkedList = e.ej(ah.getContext());
    paramString = paramLinkedList;
    if (bo.isNullOrNil(paramLinkedList)) {
      paramString = bo.hi(ah.getContext());
    }
    if (!bo.isNullOrNil(i.countryCode)) {
      paramString = i.countryCode;
    }
    for (;;)
    {
      ((bh)localObject).gwY = paramString;
      if (paramn1 != null) {}
      for (;;)
      {
        ((bh)localObject).nsG = new t();
        if (paramn1 != null)
        {
          ((bh)localObject).nsG.nqU = paramn1.nnb.nnV;
          ((bh)localObject).nsG.fKw = paramn1.field_appId;
          ((bh)localObject).nsG.npW = paramn1.nnM;
          if (paramn1.field_msgType == 100) {
            ((bh)localObject).nsG.nqW = paramn1.nnL;
          }
        }
        else
        {
          label228:
          if (paramn2 != null)
          {
            paramLinkedList = ((bh)localObject).nsG;
            paramLinkedList.nqV |= 0x1;
          }
          if (paramn3 != null)
          {
            paramLinkedList = ((bh)localObject).nsG;
            paramLinkedList.nqV |= 0x2;
          }
          ((bh)localObject).nsH = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES().bGx();
          ((bh)localObject).nsI = paramBoolean;
          if (!com.tencent.mm.sdk.platformtools.g.dsn()) {
            break label429;
          }
        }
        label429:
        for (int i = 1;; i = 0)
        {
          ((bh)localObject).nsb = i;
          ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[] { paramString });
          paramString = new b.a();
          paramString.fsX = ((a)localObject);
          paramString.fsY = new bi();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
          paramString.funcId = getType();
          paramString.reqCmdId = 0;
          paramString.respCmdId = 0;
          this.lFp = paramString.ado();
          AppMethodBeat.o(111439);
          return;
          if (paramn2 != null)
          {
            paramn1 = paramn2;
            break;
          }
          if (paramn3 == null) {
            break label435;
          }
          paramn1 = paramn3;
          break;
          ((bh)localObject).nsG.nqW = paramn1.field_msgType;
          break label228;
        }
        label435:
        paramn1 = null;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(111440);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111440);
    return i;
  }
  
  public final int getType()
  {
    return 2586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111441);
    ab.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ao
 * JD-Core Version:    0.7.0.1
 */