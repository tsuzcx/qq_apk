package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.coi;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private g callback;
  private b rr;
  
  public k(LinkedList<nb> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5584);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new coi();
    ((b.a)localObject).hvu = new coj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((b.a)localObject).funcId = 2645;
    ((b.a)localObject).reqCmdId = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).aAz();
    localObject = (coi)this.rr.hvr.hvw;
    ((coi)localObject).FBr = paramLinkedList;
    ((coi)localObject).FBs = paramInt1;
    ((coi)localObject).FBt = paramInt2;
    ((coi)localObject).DZA = paramInt3;
    ac.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", new Object[] { Integer.valueOf(((coi)localObject).FBr.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(5584);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(5586);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5586);
    return i;
  }
  
  public final int getType()
  {
    return 2645;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5585);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */