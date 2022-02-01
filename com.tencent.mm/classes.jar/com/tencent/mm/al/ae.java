package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ae
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public ae(LinkedList<dna> paramLinkedList)
  {
    AppMethodBeat.i(124143);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dnb();
    ((d.a)localObject).iLO = new dnc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/reportcommand";
    ((d.a)localObject).funcId = 2592;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dnb)this.rr.iLK.iLR;
    ((dnb)localObject).LlQ = paramLinkedList;
    Log.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[] { Integer.valueOf(((dnb)localObject).LlQ.size()) });
    AppMethodBeat.o(124143);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124145);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124145);
    return i;
  }
  
  public final int getType()
  {
    return 2592;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124144);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(124144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.ae
 * JD-Core Version:    0.7.0.1
 */