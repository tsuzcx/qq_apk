package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private g callback;
  private final b rr;
  private LinkedList<dit> sLX;
  
  public d(LinkedList<dit> paramLinkedList)
  {
    AppMethodBeat.i(26152);
    this.sLX = new LinkedList();
    b.a locala = new b.a();
    locala.gUU = new brk();
    locala.gUV = new brl();
    locala.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
    locala.funcId = 638;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.sLX = paramLinkedList;
    AppMethodBeat.o(26152);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26154);
    ad.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
    this.callback = paramg;
    paramg = (brk)this.rr.gUS.gUX;
    paramg.DPu = this.sLX;
    paramg.DsF = this.sLX.size();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(26154);
    return i;
  }
  
  public final int getType()
  {
    return 638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26153);
    ad.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.d
 * JD-Core Version:    0.7.0.1
 */