package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class ak
  extends n
  implements k
{
  private f callback;
  public final b gux;
  
  public ak(String paramString, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, int paramInt)
  {
    AppMethodBeat.i(41592);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new auy();
    ((b.a)localObject).hQG = new auz();
    ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearch";
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (auy)this.gux.hQD.hQJ;
    ((auy)localObject).usS = paramString;
    ((auy)localObject).GLW = paramLinkedList1;
    ((auy)localObject).GLQ = paramLinkedList2;
    ((auy)localObject).GLX = paramInt;
    AppMethodBeat.o(41592);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(41593);
    this.callback = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ak
 * JD-Core Version:    0.7.0.1
 */