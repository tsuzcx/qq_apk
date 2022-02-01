package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private g callback;
  cpr igk;
  private b rr;
  
  a(int paramInt, LinkedList<crm> paramLinkedList, crm paramcrm1, crm paramcrm2)
  {
    AppMethodBeat.i(148644);
    b.a locala = new b.a();
    locala.hvt = new cpr();
    locala.hvu = new cps();
    locala.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    locala.funcId = 228;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.igk = ((cpr)this.rr.hvr.hvw);
    this.igk.FCM = paramInt;
    this.igk.FCN = paramLinkedList;
    this.igk.FCO = paramcrm1;
    this.igk.FCP = paramcrm2;
    AppMethodBeat.o(148644);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(148645);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(148646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.a
 * JD-Core Version:    0.7.0.1
 */