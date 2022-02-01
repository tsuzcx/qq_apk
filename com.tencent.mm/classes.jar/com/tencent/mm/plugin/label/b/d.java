package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class d
  extends n
  implements k
{
  private f callback;
  private final b rr;
  private LinkedList<dtz> uWe;
  
  public d(LinkedList<dtz> paramLinkedList)
  {
    AppMethodBeat.i(26152);
    this.uWe = new LinkedList();
    b.a locala = new b.a();
    locala.hNM = new car();
    locala.hNN = new cas();
    locala.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
    locala.funcId = 638;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uWe = paramLinkedList;
    AppMethodBeat.o(26152);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26154);
    ad.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
    this.callback = paramf;
    paramf = (car)this.rr.hNK.hNQ;
    paramf.GVu = this.uWe;
    paramf.GwN = this.uWe.size();
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