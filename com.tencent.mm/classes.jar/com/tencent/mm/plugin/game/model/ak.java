package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class ak
  extends n
  implements k
{
  private g callback;
  public final b fYA;
  
  public ak(String paramString, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, int paramInt)
  {
    AppMethodBeat.i(41592);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aqm();
    ((b.a)localObject).hvu = new aqn();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearch";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (aqm)this.fYA.hvr.hvw;
    ((aqm)localObject).tju = paramString;
    ((aqm)localObject).EJw = paramLinkedList1;
    ((aqm)localObject).EJq = paramLinkedList2;
    ((aqm)localObject).EJx = paramInt;
    AppMethodBeat.o(41592);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(41593);
    this.callback = paramg;
    int i = dispatch(parame, this.fYA, this);
    AppMethodBeat.o(41593);
    return i;
  }
  
  public final int getType()
  {
    return 1328;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41594);
    ac.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ak
 * JD-Core Version:    0.7.0.1
 */