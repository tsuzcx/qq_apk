package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class a
  extends n
  implements k
{
  private f callback;
  cuw izE;
  private b rr;
  
  a(int paramInt, LinkedList<cwt> paramLinkedList, cwt paramcwt1, cwt paramcwt2)
  {
    AppMethodBeat.i(148644);
    b.a locala = new b.a();
    locala.hNM = new cuw();
    locala.hNN = new cux();
    locala.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    locala.funcId = 228;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.izE = ((cuw)this.rr.hNK.hNQ);
    this.izE.HmZ = paramInt;
    this.izE.Hna = paramLinkedList;
    this.izE.Hnb = paramcwt1;
    this.izE.Hnc = paramcwt2;
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
    ad.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(148646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.a
 * JD-Core Version:    0.7.0.1
 */