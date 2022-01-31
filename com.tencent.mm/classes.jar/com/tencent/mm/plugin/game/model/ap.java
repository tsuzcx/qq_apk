package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class ap
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public ap(String paramString, LinkedList<String> paramLinkedList, n paramn1, n paramn2, n paramn3, boolean paramBoolean)
  {
    AppMethodBeat.i(111442);
    ab.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + paramString + ", installedApp list size: " + paramLinkedList.size());
    Object localObject = paramLinkedList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ab.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[] { (String)((Iterator)localObject).next() });
    }
    localObject = new bj();
    ((bj)localObject).nsa = paramString;
    ((bj)localObject).nsF = paramLinkedList;
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
      ((bj)localObject).gwY = paramString;
      if (paramn1 != null) {}
      for (;;)
      {
        ((bj)localObject).nsG = new t();
        if (paramn1 != null)
        {
          ((bj)localObject).nsG.nqU = paramn1.nnb.nnV;
          ((bj)localObject).nsG.fKw = paramn1.field_appId;
          ((bj)localObject).nsG.npW = paramn1.nnM;
          if (paramn1.field_msgType == 100) {
            ((bj)localObject).nsG.nqW = paramn1.nnL;
          }
        }
        else
        {
          label228:
          if (paramn2 != null)
          {
            paramLinkedList = ((bj)localObject).nsG;
            paramLinkedList.nqV |= 0x1;
          }
          if (paramn3 != null)
          {
            paramLinkedList = ((bj)localObject).nsG;
            paramLinkedList.nqV |= 0x2;
          }
          ((bj)localObject).nsH = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bES().bGx();
          ((bj)localObject).nsI = paramBoolean;
          if (!com.tencent.mm.sdk.platformtools.g.dsn()) {
            break label467;
          }
        }
        label467:
        for (int i = 1;; i = 0)
        {
          ((bj)localObject).nsb = i;
          ab.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[] { paramString });
          if ((!bo.isNullOrNil(((bj)localObject).gwY)) && ("CN".equalsIgnoreCase(((bj)localObject).gwY))) {
            h.qsU.idkeyStat(860L, 8L, 1L, false);
          }
          paramString = new b.a();
          paramString.fsX = ((a)localObject);
          paramString.fsY = new bk();
          paramString.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
          paramString.funcId = getType();
          paramString.reqCmdId = 0;
          paramString.respCmdId = 0;
          this.lFp = paramString.ado();
          AppMethodBeat.o(111442);
          return;
          if (paramn2 != null)
          {
            paramn1 = paramn2;
            break;
          }
          if (paramn3 == null) {
            break label473;
          }
          paramn1 = paramn3;
          break;
          ((bj)localObject).nsG.nqW = paramn1.field_msgType;
          break label228;
        }
        label473:
        paramn1 = null;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(111443);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111443);
    return i;
  }
  
  public final int getType()
  {
    return 2855;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111444);
    ab.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ap
 * JD-Core Version:    0.7.0.1
 */