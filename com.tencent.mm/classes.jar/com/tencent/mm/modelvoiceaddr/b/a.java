package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private f callback;
  cvq iCx;
  private b rr;
  
  a(int paramInt, LinkedList<cxn> paramLinkedList, cxn paramcxn1, cxn paramcxn2)
  {
    AppMethodBeat.i(148644);
    b.a locala = new b.a();
    locala.hQF = new cvq();
    locala.hQG = new cvr();
    locala.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    locala.funcId = 228;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.iCx = ((cvq)this.rr.hQD.hQJ);
    this.iCx.HGz = paramInt;
    this.iCx.HGA = paramLinkedList;
    this.iCx.HGB = paramcxn1;
    this.iCx.HGC = paramcxn2;
    AppMethodBeat.o(148644);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(148645);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(148645);
    return i;
  }
  
  public final int getType()
  {
    return 228;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148646);
    ae.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(148646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.a
 * JD-Core Version:    0.7.0.1
 */