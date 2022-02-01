package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ak
  extends q
  implements m
{
  private i callback;
  public final d hhm;
  
  public ak(String paramString, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, int paramInt)
  {
    AppMethodBeat.i(41592);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bgh();
    ((d.a)localObject).iLO = new bgi();
    ((d.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearch";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (bgh)this.hhm.iLK.iLR;
    ((bgh)localObject).xLl = paramString;
    ((bgh)localObject).LQa = paramLinkedList1;
    ((bgh)localObject).LPU = paramLinkedList2;
    ((bgh)localObject).LQb = paramInt;
    AppMethodBeat.o(41592);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(41593);
    this.callback = parami;
    int i = dispatch(paramg, this.hhm, this);
    AppMethodBeat.o(41593);
    return i;
  }
  
  public final int getType()
  {
    return 1328;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(41594);
    Log.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(41594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ak
 * JD-Core Version:    0.7.0.1
 */