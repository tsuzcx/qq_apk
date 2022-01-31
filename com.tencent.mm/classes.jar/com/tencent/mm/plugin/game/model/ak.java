package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class ak
  extends m
  implements k
{
  private f callback;
  public final b lFp;
  
  public ak(String paramString, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, int paramInt)
  {
    AppMethodBeat.i(111427);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aeq();
    ((b.a)localObject).fsY = new aer();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearch";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (aeq)this.lFp.fsV.fta;
    ((aeq)localObject).nsa = paramString;
    ((aeq)localObject).wXA = paramLinkedList1;
    ((aeq)localObject).wXu = paramLinkedList2;
    ((aeq)localObject).wXB = paramInt;
    AppMethodBeat.o(111427);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(111428);
    this.callback = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(111428);
    return i;
  }
  
  public final int getType()
  {
    return 1328;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111429);
    ab.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ak
 * JD-Core Version:    0.7.0.1
 */