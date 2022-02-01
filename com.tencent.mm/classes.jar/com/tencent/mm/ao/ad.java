package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dwu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ad
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public ad(LinkedList<dws> paramLinkedList)
  {
    AppMethodBeat.i(124143);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dwt();
    ((d.a)localObject).lBV = new dwu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/reportcommand";
    ((d.a)localObject).funcId = 2592;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dwt)d.b.b(this.rr.lBR);
    ((dwt)localObject).Sna = paramLinkedList;
    Log.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[] { Integer.valueOf(((dwt)localObject).Sna.size()) });
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
 * Qualified Name:     com.tencent.mm.ao.ad
 * JD-Core Version:    0.7.0.1
 */