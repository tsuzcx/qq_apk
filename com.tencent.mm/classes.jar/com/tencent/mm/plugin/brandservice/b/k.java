package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private b rr;
  
  public k(LinkedList<nz> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5584);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cuf();
    ((b.a)localObject).hQG = new cug();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((b.a)localObject).funcId = 2645;
    ((b.a)localObject).hQH = 176;
    ((b.a)localObject).respCmdId = 1000000176;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cuf)this.rr.hQD.hQJ;
    ((cuf)localObject).HFe = paramLinkedList;
    ((cuf)localObject).HFf = paramInt1;
    ((cuf)localObject).HFg = paramInt2;
    ((cuf)localObject).FXt = paramInt3;
    ae.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", new Object[] { Integer.valueOf(((cuf)localObject).HFe.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(5584);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5586);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */