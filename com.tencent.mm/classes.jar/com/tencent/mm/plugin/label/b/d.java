package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.protocal.protobuf.eov;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.ak.d rr;
  private LinkedList<eov> yBV;
  
  public d(LinkedList<eov> paramLinkedList)
  {
    AppMethodBeat.i(26152);
    this.yBV = new LinkedList();
    d.a locala = new d.a();
    locala.iLN = new cqn();
    locala.iLO = new cqo();
    locala.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
    locala.funcId = 638;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yBV = paramLinkedList;
    AppMethodBeat.o(26152);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26154);
    Log.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
    this.callback = parami;
    parami = (cqn)this.rr.iLK.iLR;
    parami.Mwq = this.yBV;
    parami.LUu = this.yBV.size();
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(26154);
    return i;
  }
  
  public final int getType()
  {
    return 638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26153);
    Log.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.d
 * JD-Core Version:    0.7.0.1
 */