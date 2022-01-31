package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.ccj;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private f callback;
  public String koi;
  public int koj;
  public String kok;
  private final b rr;
  
  public g(int paramInt1, LinkedList<cbu> paramLinkedList, String paramString1, String paramString2, ccj paramccj, int paramInt2, cgd paramcgd)
  {
    AppMethodBeat.i(88033);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cbs();
    ((b.a)localObject).fsY = new cbt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((b.a)localObject).funcId = 902;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cbs)this.rr.fsV.fta;
    ((cbs)localObject).xMu = paramInt1;
    ((cbs)localObject).fjy = paramLinkedList;
    ((cbs)localObject).xFL = paramString1;
    ((cbs)localObject).wZY = paramString2;
    ab.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((cbs)localObject).xMv = paramccj;
    ((cbs)localObject).cHp = paramInt2;
    ((cbs)localObject).wlJ = paramcgd;
    AppMethodBeat.o(88033);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(88035);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88035);
    return i;
  }
  
  public final int getType()
  {
    return 902;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88034);
    ab.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      paramq = (cbt)this.rr.fsW.fta;
      if (paramq != null)
      {
        this.koi = paramq.koi;
        this.koj = paramq.koj;
        this.kok = paramq.kok;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(88034);
      return;
      paramq = (cbt)this.rr.fsW.fta;
      if (paramq != null)
      {
        this.koi = paramq.koi;
        this.koj = paramq.koj;
        this.kok = paramq.kok;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */