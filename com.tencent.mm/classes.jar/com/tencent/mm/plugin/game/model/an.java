package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class an
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public an(String paramString, LinkedList<String> paramLinkedList, n paramn1, n paramn2, n paramn3, boolean paramBoolean)
  {
    AppMethodBeat.i(111436);
    ab.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ab.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new b.a();
    ((b.a)localObject).fsX = new bd();
    ((b.a)localObject).fsY = new be();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/getgameindex4";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (bd)this.lFp.fsV.fta;
    ((bd)localObject).nsa = paramString;
    ((bd)localObject).nsF = paramLinkedList;
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
      ((bd)localObject).gwY = paramString;
      if (paramn1 != null) {}
      for (;;)
      {
        ((bd)localObject).nsG = new t();
        if (paramn1 != null)
        {
          ((bd)localObject).nsG.nqU = paramn1.nnb.nnV;
          ((bd)localObject).nsG.fKw = paramn1.field_appId;
          ((bd)localObject).nsG.npW = paramn1.nnM;
          if (paramn1.field_msgType == 100) {
            ((bd)localObject).nsG.nqW = paramn1.nnL;
          }
        }
        else
        {
          label304:
          if (paramn2 != null)
          {
            paramLinkedList = ((bd)localObject).nsG;
            paramLinkedList.nqV |= 0x1;
          }
          if (paramn3 != null)
          {
            paramLinkedList = ((bd)localObject).nsG;
            paramLinkedList.nqV |= 0x2;
          }
          ((bd)localObject).nsH = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES().bGx();
          ((bd)localObject).nsI = paramBoolean;
          if (!com.tencent.mm.sdk.platformtools.g.dsn()) {
            break label486;
          }
        }
        label486:
        for (int i = 1;; i = 0)
        {
          ((bd)localObject).nsb = i;
          ab.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[] { paramString });
          if ((!bo.isNullOrNil(((bd)localObject).gwY)) && (!"CN".equalsIgnoreCase(((bd)localObject).gwY))) {
            h.qsU.idkeyStat(860L, 7L, 1L, false);
          }
          AppMethodBeat.o(111436);
          return;
          if (paramn2 != null)
          {
            paramn1 = paramn2;
            break;
          }
          if (paramn3 == null) {
            break label492;
          }
          paramn1 = paramn3;
          break;
          ((bd)localObject).nsG.nqW = paramn1.field_msgType;
          break label304;
        }
        label492:
        paramn1 = null;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(111437);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111437);
    return i;
  }
  
  public final int getType()
  {
    return 2994;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111438);
    ab.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.an
 * JD-Core Version:    0.7.0.1
 */