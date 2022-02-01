package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ak
  extends p
  implements m
{
  private h callback;
  public final c mtC;
  
  public ak(String paramString, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, int paramInt)
  {
    AppMethodBeat.i(41592);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cbg();
    ((c.a)localObject).otF = new cbh();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamecentersearch";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (cbg)c.b.b(this.mtC.otB);
    ((cbg)localObject).IJD = paramString;
    ((cbg)localObject).aakw = paramLinkedList1;
    ((cbg)localObject).aakq = paramLinkedList2;
    ((cbg)localObject).aakx = paramInt;
    AppMethodBeat.o(41592);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(41593);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
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