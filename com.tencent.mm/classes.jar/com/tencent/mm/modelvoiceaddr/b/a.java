package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private g callback;
  ckk hFI;
  private b rr;
  
  a(int paramInt, LinkedList<cmf> paramLinkedList, cmf paramcmf1, cmf paramcmf2)
  {
    AppMethodBeat.i(148644);
    b.a locala = new b.a();
    locala.gUU = new ckk();
    locala.gUV = new ckl();
    locala.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    locala.funcId = 228;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.hFI = ((ckk)this.rr.gUS.gUX);
    this.hFI.EfM = paramInt;
    this.hFI.EfN = paramLinkedList;
    this.hFI.EfO = paramcmf1;
    this.hFI.EfP = paramcmf2;
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
    ad.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(148646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.a
 * JD-Core Version:    0.7.0.1
 */